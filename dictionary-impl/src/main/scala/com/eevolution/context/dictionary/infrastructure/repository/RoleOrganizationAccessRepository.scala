package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.RoleOrganizationAccess
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
  * Role Organization Access Repository
  * @param session
  * @param executionContext
  */

class RoleOrganizationAccessRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.RoleOrganizationAccessRepository[RoleOrganizationAccess , Int]
    with RoleOrganizationAccessMapping {

  def getById(id: Int): Future[RoleOrganizationAccess] = {
    getByRole(id , 0)
  }

  def getByRole(id: Int , role : Int): Future[RoleOrganizationAccess] = {
    Future(run(queryRoleOrganizationAccess.filter(roleOrganizationAccess => roleOrganizationAccess.organizationId == lift(id)
      && roleOrganizationAccess.roleId == lift(role))).headOption.get)
  }
  def getByUUID(uuid: UUID): Future[RoleOrganizationAccess] = {
    Future(run(queryRoleOrganizationAccess.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByRoleOrganizationAccessId(id : Int) : Future[List[RoleOrganizationAccess]] = {
    Future(run(queryRoleOrganizationAccess))
  }

  def getAll() : Future[List[RoleOrganizationAccess]] = {
    Future(run(queryRoleOrganizationAccess))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[RoleOrganizationAccess]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countRoleOrganizationAccess()
      elements <- if (offset > count) Future.successful(Nil)
      else selectRoleOrganizationAccess(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countRoleOrganizationAccess() = {
    Future(run(queryRoleOrganizationAccess.size).toInt)
  }


  private def selectRoleOrganizationAccess(offset: Int, limit: Int): Future[Seq[RoleOrganizationAccess]] = {
    Future(run(queryRoleOrganizationAccess).drop(offset).take(limit).toSeq)
  }
}
