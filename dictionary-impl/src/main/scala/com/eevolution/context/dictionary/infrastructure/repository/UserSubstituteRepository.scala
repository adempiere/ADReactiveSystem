package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.UserSubstitute
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
  * User Substitute Repository
  * @param session
  * @param executionContext
  */

class UserSubstituteRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.UserSubstituteRepository[UserSubstitute , Int]
    with UserSubstituteMapping {

  def getById(id: Int): Future[UserSubstitute] = {
    Future(run(queryUserSubstitute.filter(_.userSubstituteId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[UserSubstitute] = {
    Future(run(queryUserSubstitute.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByUserSubstituteId(id : Int) : Future[List[UserSubstitute]] = {
    Future(run(queryUserSubstitute))
  }

  def getAll() : Future[List[UserSubstitute]] = {
    Future(run(queryUserSubstitute))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[UserSubstitute]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countUserSubstitute()
      elements <- if (offset > count) Future.successful(Nil)
      else selectUserSubstitute(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countUserSubstitute() = {
    Future(run(queryUserSubstitute.size).toInt)
  }


  private def selectUserSubstitute(offset: Int, limit: Int): Future[Seq[UserSubstitute]] = {
    Future(run(queryUserSubstitute).drop(offset).take(limit).toSeq)
  }
}
