package com.eevolution.context.dictionary.infrastructure.repository
import java.util.UUID

import com.eevolution.context.dictionary.domain.api
import com.eevolution.context.dictionary.domain.model.Attribute
import com.eevolution.context.dictionary.infrastructure.db.DbContext._
import com.eevolution.utils.PaginatedSequence
import com.lightbend.lagom.scaladsl.persistence.jdbc.JdbcSession

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by e-Evolution on 11/03/17.
  */
class AttributeRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.AttributeRepository[Attribute , Int]
    with AttributeMapping {

  def getById(id: Int): Future[Attribute] = {
    Future(run(queryAttribute.filter(_.attributeId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[Attribute] = {
    Future(run(queryAttribute.filter(_.uuid == lift(uuid.toString))).headOption.get)
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
      count <- countAttribute()
      elements <- if (offset > count) Future.successful(Nil)
      else selectAttribute(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countAttribute() = {
    Future(run(queryAttribute.size).toInt)
  }


  private def selectAttribute(offset: Int, limit: Int): Future[Seq[Attribute]] = {
    Future(run(queryAttribute).drop(offset).take(limit).toSeq)
  }

}
