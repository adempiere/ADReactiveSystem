package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.ReplicationLog
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
  * Email: eduardo.moreno@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by eduardo.moreno@e-evolution.com , www.e-evolution.com
  */

/**
  * Replication Log Repository
  * @param session
  * @param executionContext
  */

class ReplicationLogRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.ReplicationLogRepository[ReplicationLog , Int]
    with ReplicationLogMapping {

  def getById(id: Int): Future[ReplicationLog] = {
    Future(run(queryReplicationLog.filter(_.replicationLogId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[ReplicationLog] = {
    Future(run(queryReplicationLog.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByReplicationLogId(id : Int) : Future[List[ReplicationLog]] = {
    Future(run(queryReplicationLog))
  }

  def getAll() : Future[List[ReplicationLog]] = {
    Future(run(queryReplicationLog))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[ReplicationLog]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countReplicationLog()
      elements <- if (offset > count) Future.successful(Nil)
      else selectReplicationLog(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countReplicationLog() = {
    Future(run(queryReplicationLog.size).toInt)
  }


  private def selectReplicationLog(offset: Int, limit: Int): Future[Seq[ReplicationLog]] = {
    Future(run(queryReplicationLog).drop(offset).take(limit).toSeq)
  }
}
