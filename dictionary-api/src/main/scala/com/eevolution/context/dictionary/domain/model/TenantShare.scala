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
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com
  */

/**
  * Tenant Share Entity
  * @param tenantShareId Tenant Share ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created by
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param description Description
  * @param tableId Table ID
  * @param shareType Share Type
  * @param uuid UUID
  */

case class TenantShare(tenantShareId: Int,
                       tenantId: Int,
                       organizationId: Int,
                       isActive: Boolean,
                       created: DateTime,
                       createdBy: Int,
                       updated: DateTime,
                       updatedBy: Int,
                       name: String,
                       description: Option[String],
                       tableId: Int,
                       shareType: Boolean,
                       uuid: Option[String]
                      ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = tenantShareId

  override val entityName: String = "AD_ClientShare"
  override val identifier: String = "AD_ClientShare_ID"
}

object TenantShare  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[TenantShare]
  def create(tenantShareId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             description: String,
             tableId: Int,
             shareType: Boolean,
             uuid: String) = TenantShare(tenantShareId, tenantId, organizationId, isActive, created, createdBy, updated, updatedBy,
    name, None, tableId, shareType, None)
}


