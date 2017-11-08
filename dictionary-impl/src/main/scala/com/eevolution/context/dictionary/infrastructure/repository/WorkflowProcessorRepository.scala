package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.WorkflowProcessor
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
  * Workflow Processor Repository
  * @param session
  * @param executionContext
  */

class WorkflowProcessorRepository(session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.WorkflowProcessorRepository[WorkflowProcessor , Int]
    with WorkflowProcessorMapping {

  def getById(id: Int): Future[WorkflowProcessor] = {
    Future(run(queryWorkflowProcessor.filter(_.workflowProcessorId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[WorkflowProcessor] = {
    Future(run(queryWorkflowProcessor.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByWorkflowProcessorId(id : Int) : Future[List[WorkflowProcessor]] = {
    Future(run(queryWorkflowProcessor))
  }

  def getAll() : Future[List[WorkflowProcessor]] = {
    Future(run(queryWorkflowProcessor))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[WorkflowProcessor]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countWorkflowProcessor()
      elements <- if (offset > count) Future.successful(Nil)
      else selectWorkflowProcessor(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countWorkflowProcessor() = {
    Future(run(queryWorkflowProcessor.size).toInt)
  }


  private def selectWorkflowProcessor(offset: Int, limit: Int): Future[Seq[WorkflowProcessor]] = {
    Future(run(queryWorkflowProcessor).drop(offset).take(limit).toSeq)
  }
}
