package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.PrintGraph
import com.eevolution.context.dictionary.infrastructure.db.DbContext._
import com.eevolution.utils.PaginatedSequence
import com.lightbend.lagom.scaladsl.persistence.jdbc.JdbcSession

import scala.concurrent.{ExecutionContext, Future}

class PrintGraphRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.PinStanceRepository[PrintGraph , Int]
    with PrintGraphMapping {

  def getById(id: Int): Future[PrintGraph] = {
    Future(run(queryPrintGraph.filter(null)).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[PrintGraph] = {
    Future(run(queryPrintGraph.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByPrintGraphId(id : Int) : Future[List[PrintGraph]] = {
    Future(run(queryPrintGraph))
  }

  def getAll() : Future[List[PrintGraph]] = {
    Future(run(queryPrintGraph))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[PrintGraph]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countPrintGraph()
      elements <- if (offset > count) Future.successful(Nil)
      else selectPrintGraph(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countPrintGraph() = {
    Future(run(queryPrintGraph.size).toInt)
  }

  private def selectPrintGraph(offset: Int, limit: Int): Future[Seq[PrintGraph]] = {
    Future(run(queryPrintGraph).drop(offset).take(limit).toSeq)
  }
}
