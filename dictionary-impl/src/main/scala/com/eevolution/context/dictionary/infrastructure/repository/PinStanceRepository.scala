package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.PinStance
import com.eevolution.context.dictionary.infrastructure.db.DbContext._
import com.eevolution.utils.PaginatedSequence
import com.lightbend.lagom.scaladsl.persistence.jdbc.JdbcSession

import scala.concurrent.{ExecutionContext, Future}

class PinStanceRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.PinStanceRepository[PinStance , Int]
    with PinStanceMapping {

  def getById(id: Int): Future[PinStance] = {
    Future(run(queryPinStance.filter(_.pinStanceId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[PinStance] = {
    Future(run(queryPinStance.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByPinStanceId(id : Int) : Future[List[PinStance]] = {
    Future(run(queryPinStance))
  }

  def getAll() : Future[List[PinStance]] = {
    Future(run(queryPinStance))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[PinStance]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countPinStance()
      elements <- if (offset > count) Future.successful(Nil)
      else selectPinStance(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countPinStance() = {
    Future(run(queryPinStance.size).toInt)
  }

  private def selectPinStance(offset: Int, limit: Int): Future[Seq[PinStance]] = {
    Future(run(queryPinStance).drop(offset).take(limit).toSeq)
  }
}
