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
  * System Entity
  * @param systemId System ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param username Username
  * @param info Info
  * @param version Version
  * @param releaseNo Release No
  * @param supportsUnits Supports Units
  * @param password Password
  * @param replicationType Replication Type
  * @param idRangeStart ID Range Start
  * @param idRangeEnd ID Range End
  * @param ldapHost LDAP Host
  * @param customPrefix Custom Prefix
  * @param isJustMigrate Is Just Migrate
  * @param dbInstance DB Instance
  * @param dbAddress DB Address
  * @param noProcessors No Processors
  * @param summary Summary
  * @param encryptionKey Encryption Key
  * @param ldapDomain LDAP Domain
  * @param isAutoErrorReport Is Auto Error Report
  * @param recordId Record ID
  * @param supportExpDate Support Exp Date
  * @param processing Processing
  * @param supportEmail Support Email
  * @param isAllowStatistics Is Allow Statistics
  * @param statisticsInfo Statistics Info
  * @param profileInfo Profile Info
  * @param oldName Old Name
  * @param description Description
  * @param systemStatus System Status
  * @param isFailOnMissingModelValidator Is Fail On Missing Model Validator
  * @param lastBuiltInfo Last Built Info
  * @param isFailOnBuildDiffer Is Fail On Build Differ
  * @param uuid UUID
  */

case class System (systemId: Int,
                   tenantId: Int,
                   organizationId: Int,
                   isActive: Boolean = true,
                   created: DateTime = DateTime.now,
                   createdBy: Int,
                   updated: DateTime = DateTime.now,
                   updatedBy: Int,
                   name: String,
                   username: String,
                   info: Option[String],
                   version: Option[String],
                   releaseNo: Option[String],
                   supportsUnits: Option[Int],
                   password: Option[String],
                   replicationType: String = "L",
                   idRangeStart: Option[Int],
                   idRangeEnd: Option[Int],
                   ldapHost: Option[String],
                   customPrefix: Option[String],
                   isJustMigrate: Boolean = false,
                   dbInstance: Option[String],
                   dbAddress: Option[String],
                   noProcessors: Option[Int],
                   summary: Option[String],
                   encryptionKey: Option[String],
                   ldapDomain: Option[String],
                   isAutoErrorReport: Boolean = true,
                   recordId: Option[Int],
                   supportExpDate: Option[DateTime],
                   processing: Option[Boolean],
                   supportEmail: Option[String],
                   isAllowStatistics: Boolean = true,
                   statisticsInfo: Option[String],
                   profileInfo: Option[String],
                   oldName: Option[String],
                   description: Option[String],
                   systemStatus: String = "E",
                   isFailOnMissingModelValidator: Boolean = true,
                   lastBuiltInfo: Option[String],
                   isFailOnBuildDiffer: Boolean = false,
                   uuid: String
                  ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = systemId

  override val entityName: String = "AD_System"
  override val identifier: String = "AD_System_ID"

}

object System {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[System]
  def create(systemId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             username: String,
             info: String,
             version: String,
             releaseNo: String,
             supportsUnits: Int,
             password: String,
             replicationType: String,
             idRangeStart: Int,
             idRangeEnd: Int,
             ldapHost: String,
             customPrefix: String,
             isJustMigrate: Boolean,
             dbInstance: String,
             dbAddress: String,
             noProcessors: Int,
             summary: String,
             encryptionKey: String,
             ldapDomain: String,
             isAutoErrorReport: Boolean,
             recordId: Int,
             supportExpDate: DateTime,
             processing: Boolean,
             supportEmail: String,
             isAllowStatistics: Boolean,
             statisticsInfo: String,
             profileInfo: String,
             oldName: String,
             description: String,
             systemStatus: String,
             isFailOnMissingModelValidator: Boolean,
             lastBuiltInfo: String,
             isFailOnBuildDiffer: Boolean,
             uuid: String) = System(systemId, tenantId, organizationId, isActive, created, createdBy, updated,
    updatedBy, name, username, None, None, None, None, None, replicationType, None, None, None, None, isJustMigrate,
    None, None, None, None, None, None, isAutoErrorReport, None, None, None, None, isAllowStatistics, None, None, None,
    None, systemStatus, isFailOnMissingModelValidator, None, isFailOnBuildDiffer, uuid)
}
