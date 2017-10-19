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
  * Sys Config Entity
  * @param sysConfigId Sis Config ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated By
  * @param updatedBy Updated By
  * @param isActive Is Active
  * @param name Name
  * @param value Value
  * @param description Decription
  * @param entityType Entity Type
  * @param configurationLevel Configuration Level
  * @param uuid UUID
  */

case class SysConfig (sysConfigId: Int,
                      tenantId: Int,
                      organizationId: Int,
                      created: DateTime = DateTime.now,
                      createdBy: Int,
                      updated: DateTime = DateTime.now,
                      updatedBy: Int,
                      isActive: Boolean = true,
                      name: String,
                      value: String,
                      description: Option[String],
                      entityType: String = "U",
                      configurationLevel: String = "S",
                      uuid: String
                     ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = sysConfigId

  override val entityName: String = "AD_SysConfig"
  override val identifier: String = "AD_SysConfig_ID"

}

object SysConfig {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[SysConfig]
  def create(sysConfigId: Int,
             tenantId: Int,
             organizationId: Int,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             isActive: Boolean,
             name: String,
             value: String,
             description: String,
             entityType: String,
             configurationLevel: String,
             uuid: String) = SysConfig(sysConfigId, tenantId, organizationId, created, createdBy, updated,
    updatedBy, isActive, name, value, None, entityType, configurationLevel, uuid)
}
