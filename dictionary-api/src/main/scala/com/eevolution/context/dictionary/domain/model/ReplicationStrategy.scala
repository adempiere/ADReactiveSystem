package com.eevolution.context.dictionary.domain.model

import ai.x.play.json.Jsonx
import com.eevolution.context.dictionary.api.{ActiveEnabled, DomainModel, Identifiable, Traceable}
import org.joda.time.DateTime
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
  * Replication strategy Entity
  * @param replicationStrategyId Replication Strategy ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param description Description
  * @param help Help
  * @param entityType Entity Type
  * @param expProcessorId Exp Processor ID
  * @param value  Value
  * @param uuId UUID
  */

case class ReplicationStrategy (replicationStrategyId: Int,
                                tenantId: Int,
                                organizationId: Int,
                                isActive : Boolean = true,
                                created : DateTime = DateTime.now,
                                createdBy : Int ,
                                updated : DateTime = DateTime.now,
                                updatedBy : Int,
                                name: Int,
                                description: Option[String],
                                help: Option[String],
                                entityType: String = "D",
                                expProcessorId: Option[Int],
                                value: Option[Int],
                                uuId: Option[String]
                               ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = replicationStrategyId

  override val entityName: String = "AD_ReplicationStrategy"
  override val identifier: String = "AD_ReplicationStrategy_ID"
}

object ReplicationStrategy  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[ReplicationStrategy]
  def create(replicationStrategyId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive : Boolean = true,
             created : DateTime = DateTime.now,
             createdBy : Int ,
             updated : DateTime = DateTime.now,
             updatedBy : Int,
             name: Int,
             description: Option[String],
             help: Option[String],
             entityType: String = "D",
             expProcessorId: Option[Int],
             value: Option[Int],
             uuId: Option[String]) = ReplicationStrategy(replicationStrategyId,tenantId, organizationId, isActive,
    created, createdBy, updated, updatedBy, name, None, None, entityType, None, None, None)
}