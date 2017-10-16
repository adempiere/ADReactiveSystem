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
  * Modify by victor.perez@e-evolution.com , www.e-evolution.com
  */
/**
  * Package Imp Entity
  * @param packageImportId Package Imp ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param pkStatus PK Status
  * @param releaseNo Release No
  * @param pkVersion PK Version
  * @param version Version
  * @param description Description
  * @param email Email
  * @param processed Processed
  * @param processing Processing
  * @param creator Creator
  * @param creatorContact Creator Contact
  * @param createdDate Created Date
  * @param updatedDate Updated Date
  * @param uninstall Uninstall
  * @param uuid UUID
  */

case class PackageImport(packageImportId: Int,
                         tenantId: Int,
                         organizationId: Int,
                         isActive: Boolean = true,
                         created: DateTime = DateTime.now,
                         createdBy: Int,
                         updated: DateTime = DateTime.now,
                         updatedBy: Int,
                         name: String,
                         pkStatus: Option[String],
                         releaseNo: Option[String],
                         pkVersion: Option[String],
                         version: Option[String],
                         description: String,
                         email: Option[String],
                         processed: Boolean = false,
                         processing: Boolean = false,
                         creator: Option[String],
                         creatorContact: Option[String],
                         createdDate: Option[String],
                         updatedDate: Option[String],
                         uninstall: Option[Boolean],
                         uuid: Option[String]
                      ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = packageImportId

  override val entityName: String = "AD_Package_Imp"
  override val identifier: String = "AD_Package_Imp_ID"

}

object PackageImport {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PackageImport]
  def create(packageImportId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             pkStatus: String,
             releaseNo: String,
             pkVersion: String,
             version: String,
             description: String,
             email: String,
             processed: Boolean,
             processing: Boolean,
             creator: String,
             creatorContact: String,
             createdDate: String,
             updatedDate: String,
             uninstall: Boolean,
             uuid: String) = PackageImport(packageImportId, tenantId, organizationId, isActive, created, createdBy, updated,
    updatedBy, name, None, None, None, None, description, None, processed, processing, None, None, None, None, None,
    None)
}