package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.ElementTrl
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
  * Email: emeris.hernandez@e-evolution.com, http://www.e-evolution.com , http://github.com/EmerisScala
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 07/11/17.
  * Email: victor.perez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Author by victor.perez@e-evolution.com , www.e-evolution.com
  */

/**
  * Element Trl Repository
  * @param session
  * @param executionContext
  */

class ElementTrlRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.ElementTrlRepository[ElementTrl , Int]
    with ElementTrlMapping {

  def getById(id: Int): Future[ElementTrl] = {
    getByLanguage(id , "en_US")
  }

  def getByLanguage(id: Int , lang : String): Future[ElementTrl] = {
    Future(run(queryElementTrl.filter(element => element.elementId == lift(lang)  && element.language == lift(lang))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[ElementTrl] = {
    Future(run(queryElementTrl.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByElementTrlId(id : Int) : Future[List[ElementTrl]] = {
    Future(run(queryElementTrl))
  }

  def getAll() : Future[List[ElementTrl]] = {
    Future(run(queryElementTrl))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[ElementTrl]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countElementTrl()
      elements <- if (offset > count) Future.successful(Nil)
      else selectElementTrl(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countElementTrl() = {
    Future(run(queryElementTrl.size).toInt)
  }

  private def selectElementTrl(offset: Int, limit: Int): Future[Seq[ElementTrl]] = {
    Future(run(queryElementTrl).drop(offset).take(limit).toSeq)
  }
}
