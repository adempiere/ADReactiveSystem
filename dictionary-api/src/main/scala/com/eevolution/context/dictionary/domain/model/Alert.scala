package com.eevolution.context.dictionary.domain.model

import org.joda.time.DateTime
import ai.x.play.json.Jsonx
import com.eevolution.context.dictionary.api.{ActiveEnabled, DomainModel, Identifiable, Traceable}

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
  * Alert Entity
  * @param alertId Alert ID
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
  * @param alertSubject Alert Subject
  * @param alertMessage Alert Message
  * @param enforceClientSecurity Enforce Client Security
  * @param enforceRoleSecurity Enforce Role Security
  * @param alertProcessorId Alert Processor ID
  * @param isValid Is Valid
  * @param uuid UUID
  */

case class Alert(alertId: Int,
                 tenantId: Int,
                 organizationId: Int,
                 isActive: Boolean = true,
                 created: DateTime = DateTime.now,
                 createdBy: Int,
                 updated: DateTime = DateTime.now,
                 updatedBy: Int,
                 name: String,
                 description: Option[String],
                 help: Option[String],
                 alertSubject:String,
                 alertMessage:String,
                 enforceClientSecurity: Boolean = true,
                 enforceRoleSecurity: Boolean = true,
                 alertProcessorId: Int,
                 isValid: Boolean = true,
                 uuid: String
                ) extends DomainModel

with ActiveEnabled
with Identifiable
with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = alertId

  override val entityName: String = "AD_Alert"
  override val identifier: String = "AD_Alert_ID"
}

  object Alert  {
    implicit lazy val jsonFormat = Jsonx.formatCaseClass[Alert]
    def create(alertId: Int,
               tenantId: Int,
               organizationId: Int,
               isActive: Boolean,
               created: DateTime,
               createdBy: Int,
               updated: DateTime,
               updatedBy: Int,
               name: String,
               description: String,
               help: String,
               alertSubject:String,
               alertMessage:String,
               enforceClientSecurity: Boolean,
               enforceRoleSecurity: Boolean,
               alertProcessorId: Int,
               isValid: Boolean,
               uuid: String) = Alert(alertId, tenantId, organizationId, isActive, created, createdBy, updated,
      updatedBy, name, None, None, alertSubject, alertMessage, enforceClientSecurity, enforceRoleSecurity,
      alertProcessorId, isValid, uuid)
  }

