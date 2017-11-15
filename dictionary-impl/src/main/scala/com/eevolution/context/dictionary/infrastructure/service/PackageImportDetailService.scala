package com.eevolution.context.dictionary.infrastructure.service

import java.util.UUID

import akka.NotUsed
import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.PackageImportDetail
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
  * Email: emeris.hernandez@e-evolution.com, http://www.e-evolution.com , http://github.com/EmerisScala
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 15/11/17.
  */

/**
  * Package Import Detail Service
  */

trait PackageImportDetailService extends Service with api.service.PackageImportDetailService {

  override def getAll() :  ServiceCall[NotUsed, List[PackageImportDetail]]
  override def getById(id: Int): ServiceCall[NotUsed, PackageImportDetail]
  override def getByUUID(uuid :UUID): ServiceCall[NotUsed, PackageImportDetail]
  override def getAllByPage(pageNo: Option[Int], pageSize: Option[Int]): ServiceCall[NotUsed, PaginatedSequence[PackageImportDetail]]

  def descriptor = {
    import Service._
    named("packageImportDetail").withCalls(
      pathCall("/api/v1_0_0/packageImportDetail/all", getAll _) ,
      pathCall("/api/v1_0_0/packageImportDetail/:id", getById _),
      pathCall("/api/v1_0_0/packageImportDetail/:uuid", getByUUID _) ,
      pathCall("/api/v1_0_0/packageImportDetail?pageNo&pageSize", getAllByPage _)
    )
  }
}

