package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.AttributeProcess
import com.eevolution.context.dictionary.infrastructure.db.DbContext._
import com.eevolution.utils.PaginatedSequence
import com.lightbend.lagom.scaladsl.persistence.jdbc.JdbcSession

import scala.concurrent.{ExecutionContext, Future}

class AttributeProcessRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.AttributeProcessRepository[AttributeProcess , Int]
    with AttributeProcessMapping {

  def getById(id: Int): Future[AttributeProcess] = {
    Future(run(queryAttributeProcess.filter(_.attributeProcessId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[AttributeProcess] = {
    Future(run(queryAttributeProcess.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByAttributeProcessId(id : Int) : Future[List[AttributeProcess]] = {
    Future(run(queryAttributeProcess))
  }

  def getAll() : Future[List[AttributeProcess]] = {
    Future(run(queryAttributeProcess))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[AttributeProcess]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countAttributeProcess()
      elements <- if (offset > count) Future.successful(Nil)
      else selectAttributeProcess(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countAttributeProcess() = {
    Future(run(queryAttributeProcess.size).toInt)
  }

  private def selectAttributeProcess(offset: Int, limit: Int): Future[Seq[AttributeProcess]] = {
    Future(run(queryAttributeProcess).drop(offset).take(limit).toSeq)
  }
}
