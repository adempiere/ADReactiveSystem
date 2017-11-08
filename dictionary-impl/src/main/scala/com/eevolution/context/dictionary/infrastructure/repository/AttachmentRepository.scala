package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.Attachment
import com.eevolution.context.dictionary.infrastructure.db.DbContext._
import com.eevolution.utils.PaginatedSequence
import com.lightbend.lagom.scaladsl.persistence.jdbc.JdbcSession

import scala.concurrent.{ExecutionContext, Future}

/**
  * Copyright (C) 2003-2017, e-Evolution Consultants S.A. , http://www.e-evolution.com
  * This program is free software: you can redistribute it and/or modify
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  * You should have received a copy of the GNU General Public License
  * along with this program.  If not, see <http://www.gnu.org/licenses/>.
  * Email: emeris.hernandez@e-evolution.com, http://www.e-evolution.com , http://github.com/EmerisScala
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 07/11/17.
  */

/**
  * Attachment Repository
  * @param session
  * @param executionContext
  */

class AttachmentRepository(session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.AttachmentRepository[Attachment , Int]
    with AttachmentMapping {

  def getById(id: Int): Future[Attachment] = {
    Future(run(queryAttachment.filter(_.attachmentId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[Attachment] = {
    Future(run(queryAttachment.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByAttachmentId(id : Int) : Future[List[Attachment]] = {
    Future(run(queryAttachment))
  }

  def getAll() : Future[List[Attachment]] = {
    Future(run(queryAttachment))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[Attachment]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countAttachment()
      elements <- if (offset > count) Future.successful(Nil)
      else selectAttachment(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countAttachment() = {
    Future(run(queryAttachment.size).toInt)
  }

  private def selectAttachment(offset: Int, limit: Int): Future[Seq[Attachment]] = {
    Future(run(queryAttachment).drop(offset).take(limit).toSeq)
  }
}
