package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.ReplicationRoleAccess
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
  * Replication Role Access Repository
  * @param session
  * @param executionContext
  */

class ReplicationRoleAccessRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.ReplicationRoleAccessRepository[ReplicationRoleAccess , Int]
    with ReplicationRoleAccessMapping {

  def getById(id: Int): Future[ReplicationRoleAccess] = {
    Future(run(queryReplicationRoleAccess.filter(_.replicationRoleAccessId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[ReplicationRoleAccess] = {
    Future(run(queryReplicationRoleAccess.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByReplicationRoleAccessId(id : Int) : Future[List[ReplicationRoleAccess]] = {
    Future(run(queryReplicationRoleAccess))
  }

  def getAll() : Future[List[ReplicationRoleAccess]] = {
    Future(run(queryReplicationRoleAccess))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[ReplicationRoleAccess]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countReplicationRoleAccess()
      elements <- if (offset > count) Future.successful(Nil)
      else selectReplicationRoleAccess(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countReplicationRoleAccess() = {
    Future(run(queryReplicationRoleAccess.size).toInt)
  }


  private def selectReplicationRoleAccess(offset: Int, limit: Int): Future[Seq[ReplicationRoleAccess]] = {
    Future(run(queryReplicationRoleAccess).drop(offset).take(limit).toSeq)
  }
}
