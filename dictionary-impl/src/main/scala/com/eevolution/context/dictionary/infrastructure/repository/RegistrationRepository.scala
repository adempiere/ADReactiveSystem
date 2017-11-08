package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.Registration
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
  * Registration Repository
  * @param session
  * @param executionContext
  */


class RegistrationRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.RegistrationRepository[Registration , Int]
    with RegistrationMapping {

  def getById(id: Int): Future[Registration] = {
    Future(run(queryRegistration.filter(_.registrationId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[Registration] = {
    Future(run(queryRegistration.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByRegistrationId(id : Int) : Future[List[Registration]] = {
    Future(run(queryRegistration))
  }

  def getAll() : Future[List[Registration]] = {
    Future(run(queryRegistration))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[Registration]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countRegistration()
      elements <- if (offset > count) Future.successful(Nil)
      else selectRegistration(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countRegistration() = {
    Future(run(queryRegistration.size).toInt)
  }


  private def selectRegistration(offset: Int, limit: Int): Future[Seq[Registration]] = {
    Future(run(queryRegistration).drop(offset).take(limit).toSeq)
  }
}
