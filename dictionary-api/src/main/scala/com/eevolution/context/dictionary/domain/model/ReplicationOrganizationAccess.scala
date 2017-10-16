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
  * Entity for Replication Organization Access
  * @param replicationOrganizationAccessId Replication Organization Access ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param replicationStrategyId Replication Strategy ID
  * @param created Created
  * @param createdBy Created By
  * @param isActive Is Active
  * @param isReadOnly Is Read Only
  * @param updated Updated
  * @param updatedBy Updated By
  * @param uuid UUID
  */

case class ReplicationOrganizationAccess(replicationOrganizationAccessId: Int,
                                         tenantId: Int,
                                         organizationId: Int,
                                         replicationStrategyId: Option[Int],
                                         created : DateTime = DateTime.now,
                                         createdBy : Int ,
                                         isActive : Boolean = true,
                                         isReadOnly: Option[Boolean],
                                         updated : DateTime = DateTime.now,
                                         updatedBy : Int,
                                         uuid: Option[String]
                                        ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = replicationOrganizationAccessId

  override val entityName: String = "AD_ReplicationOrgAccess"
  override val identifier: String = "AD_ReplicationOrgAccess_ID"
}

object ReplicationOrganizationAccess  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[ReplicationOrganizationAccess]
  def create(replicationOrganizationAccessId: Int,
             tenantId: Int,
             organizationId: Int,
             replicationStrategyId: Int,
             created : DateTime = DateTime.now,
             createdBy : Int ,
             isActive : Boolean,
             isReadOnly: Boolean,
             updated : DateTime,
             updatedBy : Int,
             uuid: String) = ReplicationOrganizationAccess(replicationOrganizationAccessId, tenantId,
    organizationId, None, created, createdBy, isActive, None, updated, updatedBy, None)
}


