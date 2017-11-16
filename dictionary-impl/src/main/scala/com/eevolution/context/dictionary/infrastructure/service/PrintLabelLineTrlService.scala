package com.eevolution.context.dictionary.infrastructure.service

import java.util.UUID

import akka.NotUsed
import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.PrintLabelLineTrl
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
  * Print Label Line Trl Service
  */

trait PrintLabelLineTrlService extends Service with api.service.PrintLabelLineTrlService {

  override def getAll() :  ServiceCall[NotUsed, List[PrintLabelLineTrl]]
  override def getById(id: Int): ServiceCall[NotUsed, PrintLabelLineTrl]
  override def getByUUID(uuid :UUID): ServiceCall[NotUsed, PrintLabelLineTrl]
  override def getAllByPage(pageNo: Option[Int], pageSize: Option[Int]): ServiceCall[NotUsed, PaginatedSequence[PrintLabelLineTrl]]

  def descriptor = {
    import Service._
    named("printLabelLineTrl").withCalls(
      pathCall("/api/v1_0_0/printLabelLineTrl/all", getAll _) ,
      pathCall("/api/v1_0_0/printLabelLineTrl/:id", getById _),
      pathCall("/api/v1_0_0/printLabelLineTrl/:uuid", getByUUID _) ,
      pathCall("/api/v1_0_0/printLabelLineTrl?pageNo&pageSize", getAllByPage _)
    )
  }
}

