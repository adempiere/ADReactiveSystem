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
  * Migration Script Entity
  * @param tenantId Tenant ID
  * @param migrationScriptId Migration Script ID
  * @param organizationId Organization ID
  * @param created Created
  * @param createdBy Created By
  * @param description Description
  * @param developerName Developer Name
  * @param isActive Is Active
  * @param name Name
  * @param projectName Project Name
  * @param reference Reference
  * @param releaseNo Release No
  * @param scriptRoll Script Roll
  * @param status Status
  * @param url URL
  * @param updated Updated
  * @param updatedBy Updated By
  * @param isApply Is Apply
  * @param filename Filename
  * @param script Script
  * @param uuid UUID
  */

case class MigrationScript(tenantId: Int,
                           migrationScriptId: Int,
                           organizationId: Int,
                           created: DateTime =  DateTime.now,
                           createdBy: Int,
                           description: Option[String],
                           developerName: Option[String],
                           isActive: Boolean = true,
                           name: String,
                           projectName: String,
                           reference: Option[String],
                           releaseNo: String,
                           scriptRoll: Option[Boolean],
                           status: String,
                           url: Option[String],
                           updated: DateTime =  DateTime.now,
                           updatedBy: Int,
                           isApply: Boolean,
                           filename: String,
                           script: String,
                           uuid: Option [String]
                          ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = migrationScriptId

  override val entityName: String = "AD_MigrationScript"
  override val identifier: String = "AD_MigrationScript_ID"
}

object MigrationScript {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[MigrationScript]
  def create(tenantId: Int,
             migrationScriptId: Int,
             organizationId: Int,
             created: DateTime,
             createdBy: Int,
             description: String,
             developerName: String,
             isActive: Boolean,
             name: String,
             projectName: String,
             reference: String,
             releaseNo: String,
             scriptRoll: Boolean,
             status: String,
             url: String,
             updated: DateTime,
             updatedBy: Int,
             isApply: Boolean,
             filename: String,
             script: String,
             uuid: String) = MigrationScript(tenantId, migrationScriptId, organizationId, created, createdBy, None,
    None, isActive, name, projectName, None, releaseNo, None, status, None, updated, updatedBy, isApply, filename,
    script, None)
}



