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
  * Package Exp Common Entity
  * @param packageExportCommonId Package Exp Common Id
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param formId Form ID
  * @param importFormatId Imp Format ID
  * @param reportViewId Report View ID
  * @param entityId Entity ID
  * @param workbenchId Workbench ID
  * @param dbType DB Type
  * @param processed Processed
  * @param name Name
  * @param name2 Name 2
  * @param line Line
  * @param fileDirectory File Directory
  * @param fileName File Name
  * @param destinationDirectory Destination Directory
  * @param description Description
  * @param typePackage Type Package
  * @param targetDirectory Target Directory
  * @param sqlStatement SQL Statement
  * @param processing Processing
  * @param workflowId Work Flow ID
  * @param windowId Window ID
  * @param roleId Role ID
  * @param processId Process ID
  * @param menuId Menu ID
  * @param uuid UUID
  */

case class PackageExportCommon(packageExportCommonId: Int,
                               tenantId: Int,
                               organizationId: Int,
                               isActive: Boolean = true,
                               created: DateTime = DateTime.now,
                               createdBy: Int,
                               updated: DateTime = DateTime.now,
                               updatedBy: Int,
                               formId: Int,
                               importFormatId: Option[Int],
                               reportViewId: Option[Int],
                               entityId: Option[Int],
                               workbenchId: Option[Int],
                               dbType: Option[String],
                               processed: Option[Boolean],
                               name: Option[String],
                               name2: Option[String],
                               line: Option[Int],
                               fileDirectory: Option[String],
                               fileName: Option[String],
                               destinationDirectory: Option[String],
                               description: Option[String],
                               typePackage: Option[String], //  Type = TypePackage
                               targetDirectory: Option[String],
                               sqlStatement: Option[String],
                               processing: Option[Boolean],
                               workflowId: Option[Int],
                               windowId: Option[Int],
                               roleId: Option[Int],
                               processId: Option[Int],
                               menuId: Option[Int],
                               uuid: Option[String]
                            ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = packageExportCommonId

  override val entityName: String = "AD_Package_Exp_Common"
  override val identifier: String = "AD_Package_Exp_Common_ID"

}

object PackageExportCommon {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PackageExportCommon]
  def create(packageExportCommonId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             formId: Int,
             impFormatId: Int,
             reportViewId: Int,
             entityId: Int,
             workbenchId: Int,
             dbType: String,
             processed: Boolean,
             name: String,
             name2: String,
             line: Int,
             fileDirectory: String,
             fileName: String,
             destinationDirectory: String,
             description: String,
             typePackage: String, // Cambiamos Type a TypePackage
             targetDirectory: String,
             sqlStatement: String,
             processing: Boolean,
             workflowId: Int,
             windowId: Int,
             roleId: Int,
             processId: Int,
             menuId: Int,
             uuid: String) = PackageExportCommon(packageExportCommonId, tenantId, organizationId, isActive, created,
    createdBy,updated, updatedBy, formId, None, None, None, None, None, None, None, None, None, None, None, None,
    None, None, None, None, None, None, None, None, None, None, None)
}