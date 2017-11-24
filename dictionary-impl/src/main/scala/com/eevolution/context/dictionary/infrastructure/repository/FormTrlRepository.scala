package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.FormTrl
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
  */

/**
  * Form Trl Repository
  * @param session
  * @param executionContext
  */

class FormTrlRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.FormTrlRepository[FormTrl , Int]
    with FormTrlMapping {

  def getById(id: Int): Future[FormTrl] = {
    getByLanguage(id , "en_US")
  }

  def getByLanguage(id: Int , lang : String): Future[FormTrl] = {
    Future(run(queryFormTrl.filter(form => form.formId == lift(id)
      && form.language == lift(lang))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[FormTrl] = {
    Future(run(queryFormTrl.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByFormTrlId(id : Int) : Future[List[FormTrl]] = {
    Future(run(queryFormTrl))
  }

  def getAll() : Future[List[FormTrl]] = {
    Future(run(queryFormTrl))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[FormTrl]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countFormTrl()
      elements <- if (offset > count) Future.successful(Nil)
      else selectFormTrl(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countFormTrl() = {
    Future(run(queryFormTrl.size).toInt)
  }

  private def selectFormTrl(offset: Int, limit: Int): Future[Seq[FormTrl]] = {
    Future(run(queryFormTrl).drop(offset).take(limit).toSeq)
  }
}
