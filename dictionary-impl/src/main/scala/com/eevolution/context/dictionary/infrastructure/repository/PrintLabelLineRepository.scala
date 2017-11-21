package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.PrintLabelLine
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
  * Print Label Line Repository
  * @param session
  * @param executionContext
  */

class PrintLabelLineRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.PrintLabelLineRepository[PrintLabelLine , Int]
    with PrintLabelLineMapping {

  def getById(id: Int): Future[PrintLabelLine] = {
    Future(run(queryPrintLabelLine.filter(_.printLabelLineId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[PrintLabelLine] = {
    Future(run(queryPrintLabelLine.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByPrintLabelLineId(id : Int) : Future[List[PrintLabelLine]] = {
    Future(run(queryPrintLabelLine))
  }

  def getAll() : Future[List[PrintLabelLine]] = {
    Future(run(queryPrintLabelLine))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[PrintLabelLine]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countPrintLabelLine()
      elements <- if (offset > count) Future.successful(Nil)
      else selectPrintLabelLine(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countPrintLabelLine() = {
    Future(run(queryPrintLabelLine.size).toInt)
  }

  private def selectPrintLabelLine(offset: Int, limit: Int): Future[Seq[PrintLabelLine]] = {
    Future(run(queryPrintLabelLine).drop(offset).take(limit).toSeq)
  }
}
