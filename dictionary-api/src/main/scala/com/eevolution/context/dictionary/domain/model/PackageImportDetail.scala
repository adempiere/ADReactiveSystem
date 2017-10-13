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
  * Package Import Detail Entity
  * @param packageImpDetailId Package Import Detail ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param packageImportId Package Import ID
  * @param originalId Original ID
  * @param backupId Backup ID
  * @param action Action
  * @param success Success
  * @param typePackage Type Package
  * @param tableName Table Name
  * @param entityId Entity ID
  * @param uninstall Uninstall
  * @param uuid UUID
  */

case class PackageImportDetail(packageImpDetailId: Int,
                               tenantId: Int,
                               organizationId: Int,
                               isActive: Boolean = true,
                               created: DateTime = DateTime.now,
                               createdBy: Int,
                               updated: DateTime = DateTime.now,
                               updatedBy: Int,
                               name: Option[String],
                               packageImportId: Int,
                               originalId: Int,
                               backupId: Option[Int],
                               action: Option[String],
                               success: Option[String],
                               typePackage: Option[String], //Cambiamos type por typePackage
                               tableName: Option[String],
                               entityId: Option[Int],
                               uninstall: Option[Boolean],
                               uuid: Option[String]
                            ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = packageImpDetailId

  override val entityName: String = "AD_Package_ImpDetail"
  override val identifier: String = "AD_Package_Imp_Detail_ID"

}

object PackageImportDetail {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PackageImportDetail]
  def create(packageImpDetailId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             packageImportId: Int,
             originalId: Int,
             backupId: Int,
             action: String,
             success: String,
             typePackage: String, //Cambiamos type por typePackage
             tableName: String,
             entityId: Int,
             uninstall: Boolean,
             uuid: String) = PackageImportDetail(packageImpDetailId, tenantId, organizationId, isActive, created,
    createdBy, updated, updatedBy, None, packageImportId, originalId, None, None, None, None, None, None, None, None)
}
