package com.eevolution.context.dictionary.infrastructure.service

import java.util.UUID

import akka.NotUsed
import com.eevolution.context.dictionary.domain.model.Element
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
  * Element Service
  */
trait ElementService extends Service with api.ElementService {

  override def getElementById(id: Int): ServiceCall[NotUsed, Element]
  override def getElementByUUID(uuid :UUID): ServiceCall[NotUsed, Element]
  override def getElements(pageNo: Option[Int], pageSize: Option[Int]): ServiceCall[NotUsed, PaginatedSequence[Element]]

 def descriptor = {
    import Service._
    named("element").withCalls(
      pathCall("/api/v1_0_0/element/:id", getElementById _),
      pathCall("/api/v1_0_0/element/:uuid", getElementByUUID _) ,
      pathCall("/api/v1_0_0/element?pageNo&pageSize", getElements _)
    )
  }
}
