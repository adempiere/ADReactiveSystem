package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.ViewAttributeTrl
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
  * View Attribute Trl Repository
  * @param session
  * @param executionContext
  */

class ViewAttributeTrlRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.ViewAttributeTrlRepository[ViewAttributeTrl , Int]
    with ViewAttributeTrlMapping {

  //It doesn't have ID
  def getById(id: Int): Future[ViewAttributeTrl] = {
    Future(run(queryViewAttributeTrl.filter(null)).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[ViewAttributeTrl] = {
    Future(run(queryViewAttributeTrl.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByViewAttributeTrlId(id : Int) : Future[List[ViewAttributeTrl]] = {
    Future(run(queryViewAttributeTrl))
  }

  def getAll() : Future[List[ViewAttributeTrl]] = {
    Future(run(queryViewAttributeTrl))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[ViewAttributeTrl]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countViewAttributeTrl()
      elements <- if (offset > count) Future.successful(Nil)
      else selectViewAttributeTrl(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countViewAttributeTrl() = {
    Future(run(queryViewAttributeTrl.size).toInt)
  }


  private def selectViewAttributeTrl(offset: Int, limit: Int): Future[Seq[ViewAttributeTrl]] = {
    Future(run(queryViewAttributeTrl).drop(offset).take(limit).toSeq)
  }
}
