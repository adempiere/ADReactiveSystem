package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.api._
import com.eevolution.context.dictionary.domain.model.Element
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
  * Email: victor.perez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by victor.perez@e-evolution.com , www.e-evolution.com
  */

/**
  * Element Repository
  * @param session
  * @param executionContext
  */
class ElementRepository(session: JdbcSession)(implicit executionContext: ExecutionContext) extends Repostory[Element , Int] with ElementMapping {

  def getById(id: Int): Future[Element] = {
    Future(run(queryElement.filter(_.elementId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[Element] = {
    Future(run(queryElement.filter(_.name == lift(uuid.toString))).headOption.get)
  }

  def getAll() : Future[List[Element]] = {
    Future(run(queryElement))
  }

  def getAll(page: Int, pageSize: Int): Future[PaginatedSequence[Element]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countElement()
      elements <- if (offset > count) Future.successful(Nil)
      else selectElement(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countElement() = {
    Future(run(queryElement.size).toInt)
  }


  private def selectElement(offset: Int, limit: Int): Future[Seq[Element]] = {
    Future(run(queryElement).drop(offset).take(limit).toSeq)
  }
}