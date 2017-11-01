package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.Archive
import com.eevolution.context.dictionary.infrastructure.db.DbContext._
import com.eevolution.utils.PaginatedSequence
import com.lightbend.lagom.scaladsl.persistence.jdbc.JdbcSession

import scala.concurrent.{ExecutionContext, Future}

class ArchiveRepository(session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.ArchiveRepository[Archive , Int]
    with ArchiveMapping {

  def getById(id: Int): Future[Archive] = {
    Future(run(queryArchive.filter(_.archiveId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[Archive] = {
    Future(run(queryArchive.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByArchiveId(id : Int) : Future[List[Archive]] = {
    Future(run(queryArchive))
  }

  def getAll() : Future[List[Archive]] = {
    Future(run(queryArchive))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[Archive]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countArchive()
      elements <- if (offset > count) Future.successful(Nil)
      else selectArchive(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countArchive() = {
    Future(run(queryArchive.size).toInt)
  }

  private def selectArchive(offset: Int, limit: Int): Future[Seq[Archive]] = {
    Future(run(queryArchive).drop(offset).take(limit).toSeq)
  }
}
