package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.SequenceNo
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
  * Sequence No Repository
  * @param session
  * @param executionContext
  */

class SequenceNoRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.SequenceNoRepository[SequenceNo , Int]
    with SequenceNoMapping {

  //It dosen't have ID
  def getById(id: Int): Future[SequenceNo] = {
    Future(run(querySequenceNo.filter(null)).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[SequenceNo] = {
    Future(run(querySequenceNo.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getBySequenceNoId(id : Int) : Future[List[SequenceNo]] = {
    Future(run(querySequenceNo))
  }

  def getAll() : Future[List[SequenceNo]] = {
    Future(run(querySequenceNo))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[SequenceNo]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countSequenceNo()
      elements <- if (offset > count) Future.successful(Nil)
      else selectSequenceNo(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countSequenceNo() = {
    Future(run(querySequenceNo.size).toInt)
  }


  private def selectSequenceNo(offset: Int, limit: Int): Future[Seq[SequenceNo]] = {
    Future(run(querySequenceNo).drop(offset).take(limit).toSeq)
  }
}
