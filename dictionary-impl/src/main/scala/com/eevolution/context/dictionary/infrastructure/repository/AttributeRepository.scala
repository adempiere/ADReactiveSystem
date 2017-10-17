package com.eevolution.context.dictionary.infrastructure.repository
import com.eevolution.context.dictionary.infrastructure.db.DbContext._

import java.util.UUID

import com.eevolution.context.dictionary.api.Repostory
import com.eevolution.context.dictionary.domain.model.{Attribute}
import com.eevolution.utils.PaginatedSequence
import com.lightbend.lagom.scaladsl.persistence.jdbc.JdbcSession

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by e-Evolution on 11/03/17.
  */
class AttributeRepository (session: JdbcSession)(implicit executionContext: ExecutionContext) extends Repostory[Attribute , Int] with AttributeMapping {
  def getById(id: Int): Future[Attribute] = {
    Future(run(queryAttribute.filter(_.attributeId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[Attribute] = {
    Future(run(queryAttribute.filter(_.name == lift(uuid.toString))).headOption.get)
  }

  def getByEntityId(id : Int) : Future[List[Attribute]] = {
    Future(run(queryAttribute))
  }

  def getAll() : Future[List[Attribute]] = {
    Future(run(queryAttribute))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[Attribute]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countElement()
      elements <- if (offset > count) Future.successful(Nil)
      else selectElement(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countElement() = {
    Future(run(queryAttribute.size).toInt)
  }


  private def selectElement(offset: Int, limit: Int): Future[Seq[Attribute]] = {
    Future(run(queryAttribute).drop(offset).take(limit).toSeq)
  }

}
