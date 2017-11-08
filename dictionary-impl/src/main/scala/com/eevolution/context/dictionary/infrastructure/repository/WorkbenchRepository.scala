package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.Workbench
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
  * Workbench Repository
  * @param session
  * @param executionContext
  */

class WorkbenchRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.WorkbenchRepository[Workbench , Int]
    with WorkbenchMapping {

  def getById(id: Int): Future[Workbench] = {
    Future(run(queryWorkbench.filter(_.workbenchId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[Workbench] = {
    Future(run(queryWorkbench.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByWorkbenchId(id : Int) : Future[List[Workbench]] = {
    Future(run(queryWorkbench))
  }

  def getAll() : Future[List[Workbench]] = {
    Future(run(queryWorkbench))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[Workbench]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countWorkbench()
      elements <- if (offset > count) Future.successful(Nil)
      else selectWorkbench(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countWorkbench() = {
    Future(run(queryWorkbench.size).toInt)
  }


  private def selectWorkbench(offset: Int, limit: Int): Future[Seq[Workbench]] = {
    Future(run(queryWorkbench).drop(offset).take(limit).toSeq)
  }
}
