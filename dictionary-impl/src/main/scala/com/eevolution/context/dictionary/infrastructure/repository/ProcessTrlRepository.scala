package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.ProcessTrl
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
  * Zoom Condition Repository
  * @param session
  * @param executionContext
  */


class ProcessTrlRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.ProcessTrlRepository[ProcessTrl , Int]
    with ProcessTrlMapping {

  def getById(id: Int): Future[ProcessTrl] = {
    Future(run(queryProcessTrl.filter(null)).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[ProcessTrl] = {
    Future(run(queryProcessTrl.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByProcessTrlId(id : Int) : Future[List[ProcessTrl]] = {
    Future(run(queryProcessTrl))
  }

  def getAll() : Future[List[ProcessTrl]] = {
    Future(run(queryProcessTrl))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[ProcessTrl]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countProcessTrl()
      elements <- if (offset > count) Future.successful(Nil)
      else selectProcessTrl(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countProcessTrl() = {
    Future(run(queryProcessTrl.size).toInt)
  }


  private def selectProcessTrl(offset: Int, limit: Int): Future[Seq[ProcessTrl]] = {
    Future(run(queryProcessTrl).drop(offset).take(limit).toSeq)
  }
}
