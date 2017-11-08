package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.ViewDefinition
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
  * View Definition Repository
  * @param session
  * @param executionContext
  */

class ViewDefinitionRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.ViewDefinitionRepository[ViewDefinition , Int]
    with ViewDefinitionMapping {

  def getById(id: Int): Future[ViewDefinition] = {
    Future(run(queryViewDefinition.filter(_.viewDefinitionId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[ViewDefinition] = {
    Future(run(queryViewDefinition.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByViewDefinitionId(id : Int) : Future[List[ViewDefinition]] = {
    Future(run(queryViewDefinition))
  }

  def getAll() : Future[List[ViewDefinition]] = {
    Future(run(queryViewDefinition))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[ViewDefinition]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countViewDefinition()
      elements <- if (offset > count) Future.successful(Nil)
      else selectViewDefinition(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countViewDefinition() = {
    Future(run(queryViewDefinition.size).toInt)
  }


  private def selectViewDefinition(offset: Int, limit: Int): Future[Seq[ViewDefinition]] = {
    Future(run(queryViewDefinition).drop(offset).take(limit).toSeq)
  }
}
