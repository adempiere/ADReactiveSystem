package com.eevolution.context.dictionary.infrastructure.service

import java.util.UUID

import akka.NotUsed
import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.PackageExport
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
  * Package Export Service
  */

trait PackageExportService extends Service with api.service.PackageExportService {

  override def getAll() :  ServiceCall[NotUsed, List[PackageExport]]
  override def getById(id: Int): ServiceCall[NotUsed, PackageExport]
  override def getByUUID(uuid :UUID): ServiceCall[NotUsed, PackageExport]
  override def getAllByPage(pageNo: Option[Int], pageSize: Option[Int]): ServiceCall[NotUsed, PaginatedSequence[PackageExport]]

  def descriptor = {
    import Service._
    named("packageExport").withCalls(
      pathCall("/api/v1_0_0/packageExport/all", getAll _) ,
      pathCall("/api/v1_0_0/packageExport/:id", getById _),
      pathCall("/api/v1_0_0/packageExport/:uuid", getByUUID _) ,
      pathCall("/api/v1_0_0/packageExport?pageNo&pageSize", getAllByPage _)
    )
  }
}

