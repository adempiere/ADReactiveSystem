package com.eevolution.context.dictionary.infrastructure.service

import java.util.UUID

import akka.NotUsed
import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.UserRoles
import com.eevolution.utils.PaginatedSequence
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}

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
  * User Roles Service
  */

trait UserRolesService extends Service with api.service.UserRolesService {

  override def getAll() :  ServiceCall[NotUsed, List[UserRoles]]
  override def getById(id: Int): ServiceCall[NotUsed, UserRoles]
  override def getByUUID(uuid :UUID): ServiceCall[NotUsed, UserRoles]
  override def getAllByPage(pageNo: Option[Int], pageSize: Option[Int]): ServiceCall[NotUsed, PaginatedSequence[UserRoles]]

  def descriptor = {
    import Service._
    named("userRoles").withCalls(
      pathCall("/api/v1_0_0/userRoles/all", getAll _) ,
      pathCall("/api/v1_0_0/userRoles/:id", getById _),
      pathCall("/api/v1_0_0/userRoles/:uuid", getByUUID _) ,
      pathCall("/api/v1_0_0/userRoles?pageNo&pageSize", getAllByPage _)
    )
  }
}
