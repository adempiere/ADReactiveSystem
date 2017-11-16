package com.eevolution.context.dictionary.infrastructure.service

import java.util.UUID

import akka.NotUsed
import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.WorkflowNodeTrl
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
  * Workflow Node Trl Service
  */

trait WorkflowNodeTrlService extends Service with api.service.WorkflowNodeTrlService {

  override def getAll() :  ServiceCall[NotUsed, List[WorkflowNodeTrl]]
  override def getById(id: Int): ServiceCall[NotUsed, WorkflowNodeTrl]
  override def getByUUID(uuid :UUID): ServiceCall[NotUsed, WorkflowNodeTrl]
  override def getAllByPage(pageNo: Option[Int], pageSize: Option[Int]): ServiceCall[NotUsed, PaginatedSequence[WorkflowNodeTrl]]

  def descriptor = {
    import Service._
    named("workflowNodeTrl").withCalls(
      pathCall("/api/v1_0_0/workflowNodeTrl/all", getAll _) ,
      pathCall("/api/v1_0_0/workflowNodeTrl/:id", getById _),
      pathCall("/api/v1_0_0/workflowNodeTrl/:uuid", getByUUID _) ,
      pathCall("/api/v1_0_0/workflowNodeTrl?pageNo&pageSize", getAllByPage _)
    )
  }
}
