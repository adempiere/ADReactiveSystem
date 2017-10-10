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
  * Package Exp Detail Entity
  * @param packageExportDetailId Package Exp Detail ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param formId Form ID
  * @param impFormatId Imp Format ID
  * @param menuId Menu ID
  * @param processId Process ID
  * @param roleId Role ID
  * @param windowId Window ID
  * @param workflowId Work Flow ID
  * @param fileDirectory File Directory
  * @param fileName File Name
  * @param destinationFileName Destination File Name
  * @param destinationDirectory Destination Directory
  * @param description Description
  * @param dbType DB Type
  * @param typePackage Type Package
  * @param targetDirectory Target Directory
  * @param sqlStatement SQL Statement
  * @param releaseNo Release No
  * @param processing Processing
  * @param processed Processed
  * @param name2 Name 2
  * @param line Line
  * @param workbenchId Work Bench ID
  * @param tableId Table ID
  * @param reportViewId Report View ID
  * @param packageExportId Package Exp ID
  * @param packageCodeNew Package Code New
  * @param packageCodeOld Package Code Old
  * @param dinamicValidationRuleId Val Rule ID
  * @param messageId Message ID
  * @param printFormatId Print Format ID
  * @param referenceId Reference ID
  * @param modelValidatorId Model Validator ID
  * @param entityTypeId Entity Type ID
  * @param viewId View ID
  * @param browseId Browse ID
  * @param uuid UUID
  */

case class PackageExportDetail(packageExportDetailId: Int,
                               tenantId: Int,
                               organizationId: Int,
                               isActive: Boolean = true,
                               created: DateTime = DateTime.now,
                               createdBy: Int,
                               updated: DateTime = DateTime.now,
                               updatedBy: Int,
                               formId: Option[Int],
                               impFormatId: Option[Int],
                               menuId: Option[Int],
                               processId: Option[Int],
                               roleId: Option[Int],
                               windowId: Option[Int],
                               workflowId: Option[Int],
                               fileDirectory: Option[String],
                               fileName: Option[String],
                               destinationFileName: Option[String],
                               destinationDirectory: Option[String],
                               description: String,
                               dbType: Option[String],
                               typePackage: String, // Cambiamos Type a TypePackage
                               targetDirectory: Option[String],
                               sqlStatement: Option[String],
                               releaseNo: Option[String],
                               processing: Boolean,
                               processed: Option[Boolean],
                               name2: Option[String],
                               line: Option[Int],
                               workbenchId: Option[Int],
                               tableId: Option[Int],
                               reportViewId: Option[Int],
                               packageExportId: Int,
                               packageCodeNew: Option[String],
                               packageCodeOld: Option[String],
                               dinamicValidationRuleId: Option[Int],
                               messageId: Option[Int],
                               printFormatId: Option[Int],
                               referenceId: Option[Int],
                               modelValidatorId: Option[Int],
                               entityTypeId: Option[Int],
                               viewId: Option[Int],
                               browseId: Option[Int],
                               uuid: Option[String]
                            ) extends DomainModel


  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = packageExportDetailId

  override val entityName: String = "AD_Package_Exp_Detail"
  override val identifier: String = "AD_Package_Exp_Detail_ID"

}

object PackageExportDetail {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PackageExportDetail]

  def create(packageExportDetailId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             formId: Int,
             importFormatId: Int,
             menuId: Int,
             processId: Int,
             roleId: Int,
             windowId: Int,
             workflowId: Int,
             fileDirectory: String,
             fileName: String,
             destinationFileName: String,
             destinationDirectory: String,
             description: String,
             dbType: String,
             typePackage: String, // Cambiamos Type a TypePackage
             targetDirectory: String,
             sqlStatement: String,
             releaseNo: String,
             processing: Boolean,
             processed: Boolean,
             name2: String,
             line: Int,
             workbenchId: Int,
             tableId: Int,
             reportViewId: Int,
             packageExpId: Int,
             packageCodeNew: String,
             packageCodeOld: String,
             dinamicValidationRuleId: Int,
             messageId: Int,
             printFormatId: Int,
             referenceId: Int,
             modelValidatorId: Int,
             entityTypeId: Int,
             viewId: Int,
             browseId: Int,
             uuid: String) = PackageExportDetail(packageExportDetailId, tenantId, organizationId, isActive, created,
    createdBy, updated, updatedBy, None, None, None, None, None, None, None, None, None, None, None, description, None,
    typePackage, None, None, None, processing, None, None, None, None, None, None, packageExpId, None, None, None, None,
    None, None, None, None, None, None, None)
}