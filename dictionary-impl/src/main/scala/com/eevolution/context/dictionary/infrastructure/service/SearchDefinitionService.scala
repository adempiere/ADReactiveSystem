package com.eevolution.context.dictionary.infrastructure.service

import java.util.UUID

import akka.NotUsed
import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.SearchDefinition
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
  * Search Definition Service
  */

trait SearchDefinitionService extends Service with api.service.SearchDefinitionService {

  override def getAll() :  ServiceCall[NotUsed, List[SearchDefinition]]
  override def getById(id: Int): ServiceCall[NotUsed, SearchDefinition]
  override def getByUUID(uuid :UUID): ServiceCall[NotUsed, SearchDefinition]
  override def getAllByPage(pageNo: Option[Int], pageSize: Option[Int]): ServiceCall[NotUsed, PaginatedSequence[SearchDefinition]]

  def descriptor = {
    import Service._
    named("searchDefinition").withCalls(
      pathCall("/api/v1_0_0/searchDefinition/all", getAll _) ,
      pathCall("/api/v1_0_0/searchDefinition/:id", getById _),
      pathCall("/api/v1_0_0/searchDefinition/:uuid", getByUUID _) ,
      pathCall("/api/v1_0_0/searchDefinition?pageNo&pageSize", getAllByPage _)
    )
  }
}