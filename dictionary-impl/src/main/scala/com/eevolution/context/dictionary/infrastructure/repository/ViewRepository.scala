package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.View
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
  * View Repository
  * @param session
  * @param executionContext
  */

class ViewRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.ViewRepository[View , Int]
    with ViewMapping {

  def getById(id: Int): Future[View] = {
    Future(run(queryView.filter(_.viewId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[View] = {
    Future(run(queryView.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByViewId(id : Int) : Future[List[View]] = {
    Future(run(queryView))
  }

  def getAll() : Future[List[View]] = {
    Future(run(queryView))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[View]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countView()
      elements <- if (offset > count) Future.successful(Nil)
      else selectView(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countView() = {
    Future(run(queryView.size).toInt)
  }


  private def selectView(offset: Int, limit: Int): Future[Seq[View]] = {
    Future(run(queryView).drop(offset).take(limit).toSeq)
  }
}
