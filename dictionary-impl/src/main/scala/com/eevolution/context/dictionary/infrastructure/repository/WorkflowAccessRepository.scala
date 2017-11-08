package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.WorkflowAccess
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
  * Workflow Access Repository
  * @param session
  * @param executionContext
  */

class WorkflowAccessRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.WorkflowAccessRepository[WorkflowAccess , Int]
    with WorkflowAccessMapping {

  //It doesn't have ID
  def getById(id: Int): Future[WorkflowAccess] = {
    Future(run(queryWorkflowAccess.filter(null)).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[WorkflowAccess] = {
    Future(run(queryWorkflowAccess.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByWorkflowAccessId(id : Int) : Future[List[WorkflowAccess]] = {
    Future(run(queryWorkflowAccess))
  }

  def getAll() : Future[List[WorkflowAccess]] = {
    Future(run(queryWorkflowAccess))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[WorkflowAccess]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countWorkflowAccess()
      elements <- if (offset > count) Future.successful(Nil)
      else selectWorkflowAccess(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countWorkflowAccess() = {
    Future(run(queryWorkflowAccess.size).toInt)
  }


  private def selectWorkflowAccess(offset: Int, limit: Int): Future[Seq[WorkflowAccess]] = {
    Future(run(queryWorkflowAccess).drop(offset).take(limit).toSeq)
  }
}
