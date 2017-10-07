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
  * Package Exp Entity
  * @param packageExportId Package Exp ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created by
  * @param updated Updated
  * @param updatedBy Updated By
  * @param packageType Package Type
  * @param email Email
  * @param instructions Instructions
  * @param name Name
  * @param processed Precessed
  * @param releaseNo Release No
  * @param version Version
  * @param userName User Name
  * @param processing Processing
  * @param pkVersion PK Version
  * @param fileDirectory File Directory
  * @param description Description
  * @param uuid UUID
  */

case class PackageExport(packageExportId: Int,
                         tenantId: Int,
                         organizationId: Int,
                         isActive: Boolean = true,
                         created: DateTime = DateTime.now,
                         createdBy: Int,
                         updated: DateTime = DateTime.now,
                         updatedBy: Int,
                         packageType: Option[Boolean],
                         email: String,
                         instructions: String,
                         name: String,
                         processed: Option[Boolean],
                         releaseNo: String,
                         version: String,
                         userName: String,
                         processing: Boolean,
                         pkVersion: String,
                         fileDirectory: String,
                         description: String,
                         uuid: Option[String]
                     ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = packageExportId

  override val entityName: String = "AD_Package_Exp"
  override val identifier: String = "AD_Package_Exp_ID"

}

object PackageExport {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PackageExport]
  def create(packageExportId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             packageType: Boolean,
             email: String,
             instructions: String,
             name: String,
             processed: Boolean,
             releaseNo: String,
             version: String,
             userName: String,
             processing: Boolean,
             pkVersion: String,
             fileDirectory: String,
             description: String,
             uuid: String) = PackageExport(packageExportId, tenantId, organizationId, isActive, created, createdBy, updated,
    updatedBy, None, email, instructions, name, None, releaseNo, version, userName, processing, pkVersion,
    fileDirectory, description, None)
}