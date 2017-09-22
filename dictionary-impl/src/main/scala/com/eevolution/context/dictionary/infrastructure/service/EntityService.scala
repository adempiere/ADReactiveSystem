package com.eevolution.context.dictionary.infrastructure.service

import java.util.UUID

import akka.NotUsed
import com.eevolution.context.dictionary.domain.model.{Attribute, Entity}
import com.eevolution.service.api
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}
import com.eevolution.utils.PaginatedSequence

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
  * Email: victor.perez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by victor.perez@e-evolution.com , www.e-evolution.com
  */

/**
  * Entity Service
  */
trait EntityService extends Service with api.EntityService {

  override def getAll() :  ServiceCall[NotUsed, List[Entity]]
  override def getEntityById(id: Int): ServiceCall[NotUsed, Entity]
  override def getAttributes(id: Int): ServiceCall[NotUsed, List[Attribute]]
  override def getEntityByUUID(uuid :UUID): ServiceCall[NotUsed, Entity]
  override def getEntities(pageNo: Option[Int], pageSize: Option[Int]): ServiceCall[NotUsed, PaginatedSequence[Entity]]

  def descriptor = {
    import Service._
    named("entity").withCalls(
      pathCall("/api/v1_0_0/entity/all", getAll _) ,
      pathCall("/api/v1_0_0/entity/:id", getEntityById _),
      pathCall("/api/v1_0_0/entity/:id/attributes", getAttributes _),
      pathCall("/api/v1_0_0/entity/:uuid", getEntityByUUID _) ,
      pathCall("/api/v1_0_0/entity?pageNo&pageSize", getEntities _)
    )
  }
}
