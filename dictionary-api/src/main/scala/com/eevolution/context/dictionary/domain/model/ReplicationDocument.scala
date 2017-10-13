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
  * Email: emeris.hernandez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 12/10/2017.
  */

/**
  * Replication Document ID
  * @param replicationDocumentId Replication Document ID
  * @param replicationStrategyId Replication Strategy ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param description Description
  * @param docTypeId Doc Type ID
  * @param replicationType Replication Type
  * @param entityId Entity ID
  * @param uuid UUID
  */

case class ReplicationDocument(replicationDocumentId: Int,
                               replicationStrategyId: Int,
                               tenantId: Int,
                               organizationId: Int,
                               isActive : Boolean = true,
                               created : DateTime = DateTime.now,
                               createdBy : Int ,
                               updated : DateTime = DateTime.now,
                               updatedBy : Int,
                               description: Option[String],
                               docTypeId: Int,
                               replicationType: Boolean,
                               entityId: Int,
                               uuid: Option[String]
                              ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = replicationDocumentId

  override val entityName: String = "AD_ReplicationDocument"
  override val identifier: String = "AD_ReplicationDocument_ID"
}

object ReplicationDocument  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[ReplicationDocument]
  def create(replicationDocumentId: Int,
             replicationStrategyId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive : Boolean = true,
             created : DateTime = DateTime.now,
             createdBy : Int ,
             updated : DateTime = DateTime.now,
             updatedBy : Int,
             description: Option[String],
             docTypeId: Int,
             replicationType: Boolean,
             entityId: Int,
             uuid: Option[String]) = ReplicationDocument(replicationDocumentId, replicationStrategyId, tenantId,
    organizationId, isActive, created, createdBy, updated, updatedBy, None, docTypeId, replicationType,
    entityId, None)
}
