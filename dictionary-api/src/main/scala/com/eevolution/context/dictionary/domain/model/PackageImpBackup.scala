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
  * Package Imp Backup Entity
  * @param packageImpBackupId Package Imp Backup ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param packageImpId Package Imp ID
  * @param packageImpDetailId Package Imp Detail ID
  * @param tableId Table ID
  * @param column Column
  * @param referenceId Reference ID
  * @param packageImpBckDir Package Imp Bck Dir
  * @param packageImpOrgDir Package Imp Org Dir
  * @param colValue Col Value
  * @param uninstall Uninstall
  * @param uuid UUID
  */

case class PackageImpBackup (packageImpBackupId: Int,
                             tenantId: Int,
                             organizationId: Int,
                             isActive: Boolean = true,
                             created: DateTime = DateTime.now,
                             createdBy: Int,
                             updated: DateTime = DateTime.now,
                             updatedBy: Int,
                             packageImpId: Int,
                             packageImpDetailId: Int,
                             tableId: Option[Int],
                             column: Option[Int],
                             referenceId: Option[Int],
                             packageImpBckDir: Option[String],
                             packageImpOrgDir: Option[String],
                             colValue: Option[String],
                             uninstall: Option[Boolean],
                             uuid: Option[String]
                            ) extends DomainModel


  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = packageImpBackupId

  override val entityName: String = "AD_PackageImpBackupId"
  override val identifier: String = "AD_PackageImpBackupId_ID"

}

object PackageImpBackup {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PackageImpBackup]
  def create(packageImpBackupId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             packageImpId: Int,
             packageImpDetailId: Int,
             tableId: Int,
             column: Int,
             referenceId: Int,
             packageImpBckDir: String,
             packageImpOrgDir: String,
             colValue: String,
             uninstall: Boolean,
             uuid: String) = PackageImpBackup(packageImpBackupId, tenantId, organizationId, isActive, created,
    createdBy, updated, updatedBy, packageImpId, packageImpDetailId, None, None, None, None, None, None, None, None)
}