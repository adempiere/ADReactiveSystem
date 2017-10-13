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
  * Package Import Backup Entity
  * @param packageImportBackupId Package Import Backup ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param packageImportId Package Import ID
  * @param packageImportDetailId Package Import Detail ID
  * @param entityId Entity ID
  * @param attributeId Attribute ID
  * @param referenceId Reference ID
  * @param packageImportBckDir Package Import Bck Dir
  * @param packageImportOrgDir Package Import Org Dir
  * @param colValue Col Value
  * @param uninstall Uninstall
  * @param uuid UUID
  */

case class PackageImportBackup(packageImportBackupId: Int,
                               tenantId: Int,
                               organizationId: Int,
                               isActive: Boolean = true,
                               created: DateTime = DateTime.now,
                               createdBy: Int,
                               updated: DateTime = DateTime.now,
                               updatedBy: Int,
                               packageImportId: Int,
                               packageImportDetailId: Int,
                               entityId: Option[Int],
                               attributeId: Option[Int],
                               referenceId: Option[Int],
                               packageImportBckDir: Option[String],
                               packageImportOrgDir: Option[String],
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
  override def Id: Int = packageImportBackupId

  override val entityName: String = "AD_Package_Imp_Backup"
  override val identifier: String = "AD_Package_Imp_Backup_ID"

}

object PackageImportBackup {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PackageImportBackup]
  def create(packageImpBackupId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             packageImportId: Int,
             packageImportDetailId: Int,
             entityId: Int,
             attributeId: Int,
             referenceId: Int,
             packageImportBckDir: String,
             packageImportOrgDir: String,
             colValue: String,
             uninstall: Boolean,
             uuid: String) = PackageImportBackup(packageImpBackupId, tenantId, organizationId, isActive, created,
    createdBy, updated, updatedBy, packageImportId, packageImportDetailId, None, None, None, None, None, None, None,
    None)
}