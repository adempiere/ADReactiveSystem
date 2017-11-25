package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.UserRoles
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
  * User Roles Repository
  * @param session
  * @param executionContext
  */

class UserRolesRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.UserRolesRepository[UserRoles , Int]
    with UserRolesMapping {

  def getById(id: Int): Future[UserRoles] = {
    getByRole(id , 0)
  }

  def getByRole(id: Int , role : Int): Future[UserRoles] = {
    Future(run(queryUserRoles.filter(userRoles => userRoles.userId == lift(id)
      && userRoles.roleId == lift(role))).headOption.get)
  }


  def getByUUID(uuid: UUID): Future[UserRoles] = {
    Future(run(queryUserRoles.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByUserRolesId(id : Int) : Future[List[UserRoles]] = {
    Future(run(queryUserRoles))
  }

  def getAll() : Future[List[UserRoles]] = {
    Future(run(queryUserRoles))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[UserRoles]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countUserRoles()
      elements <- if (offset > count) Future.successful(Nil)
      else selectUserRoles(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countUserRoles() = {
    Future(run(queryUserRoles.size).toInt)
  }


  private def selectUserRoles(offset: Int, limit: Int): Future[Seq[UserRoles]] = {
    Future(run(queryUserRoles).drop(offset).take(limit).toSeq)
  }
}
