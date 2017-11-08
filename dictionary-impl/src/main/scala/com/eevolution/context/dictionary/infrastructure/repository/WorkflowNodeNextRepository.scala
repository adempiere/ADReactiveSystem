package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.WorkflowNodeNext
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
  * Workflow Node Next Repository
  * @param session
  * @param executionContext
  */

class WorkflowNodeNextRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.WorkflowNodeNextRepository[WorkflowNodeNext , Int]
    with WorkflowNodeNextMapping {

  def getById(id: Int): Future[WorkflowNodeNext] = {
    Future(run(queryWorkflowNodeNext.filter(_.workflowNodeNextId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[WorkflowNodeNext] = {
    Future(run(queryWorkflowNodeNext.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByWorkflowNodeNextId(id : Int) : Future[List[WorkflowNodeNext]] = {
    Future(run(queryWorkflowNodeNext))
  }

  def getAll() : Future[List[WorkflowNodeNext]] = {
    Future(run(queryWorkflowNodeNext))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[WorkflowNodeNext]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countWorkflowNodeNext()
      elements <- if (offset > count) Future.successful(Nil)
      else selectWorkflowNodeNext(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countWorkflowNodeNext() = {
    Future(run(queryWorkflowNodeNext.size).toInt)
  }


  private def selectWorkflowNodeNext(offset: Int, limit: Int): Future[Seq[WorkflowNodeNext]] = {
    Future(run(queryWorkflowNodeNext).drop(offset).take(limit).toSeq)
  }
}
