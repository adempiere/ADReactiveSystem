package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.PrintLabelLineTrl
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
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 21/11/17.
  */

/**
  * Print Label Line Trl Repository
  * @param session
  * @param executionContext
  */

class PrintLabelLineTrlRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.PrintLabelLineTrlRepository[PrintLabelLineTrl , Int]
    with PrintLabelLineTrlMapping {

  def getById(id: Int): Future[PrintLabelLineTrl] = {
    getByLanguage(id , "en_US")
  }

  def getByLanguage(id: Int , lang : String): Future[PrintLabelLineTrl] = {
    Future(run(queryPrintLabelLineTrl.filter(printLabelLine => printLabelLine.printLabelLineId == lift(id)
      && printLabelLine.language == lift(lang))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[PrintLabelLineTrl] = {
    Future(run(queryPrintLabelLineTrl.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByPrintLabelLineTrlId(id : Int) : Future[List[PrintLabelLineTrl]] = {
    Future(run(queryPrintLabelLineTrl))
  }

  def getAll() : Future[List[PrintLabelLineTrl]] = {
    Future(run(queryPrintLabelLineTrl))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[PrintLabelLineTrl]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countPrintLabelLineTrl()
      elements <- if (offset > count) Future.successful(Nil)
      else selectPrintLabelLineTrl(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countPrintLabelLineTrl() = {
    Future(run(queryPrintLabelLineTrl.size).toInt)
  }

  private def selectPrintLabelLineTrl(offset: Int, limit: Int): Future[Seq[PrintLabelLineTrl]] = {
    Future(run(queryPrintLabelLineTrl).drop(offset).take(limit).toSeq)
  }
}
