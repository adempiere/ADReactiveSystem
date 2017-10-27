package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.PackageExportDetail
import com.eevolution.context.dictionary.infrastructure.db.DbContext._

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
  * Email: emeris.hernandez@e-evolution.com, http://www.e-evolution.com , http://github.com/EmerisScala
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 26/10/17.
  */

/**
  * Package Export Detail Mapping
  */

trait PackageExportDetailMapping {
  val queryPackageExportDetail = quote {
    querySchema[PackageExportDetail]("AD_Package_Exp_Detail",
      _.packageExportDetailId-> "AD_Package_Exp_Detail_ID",
      _.tenantId-> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.isActive-> "IsActive",
      _.created-> "Created",
      _.createdBy-> "CreatedBy",
      _.updated-> "Updated",
      _.updatedBy-> "UpdatedBy",
      _.formId-> "AD_Form_ID",
      _.importFormatId-> "AD_ImpFormat_ID",
      _.menuId-> "AD_Menu_ID",
      _.processId-> "AD_Process_ID",
      _.roleId-> "AD_Role_ID",
      _.windowId-> "AD_Window_ID",
      _.workflowId-> "AD_Workflow_ID",
      _.fileDirectory-> "File_Directory",
      _.fileName-> "FileName",
      _.destinationFileName-> "Destination_FileName",
      _.destinationDirectory-> "Destination_Directory",
      _.description-> "Description",
      _.dbType-> "DBType",
      _.typePackage-> "Type",
      _.targetDirectory-> "Target_Directory",
      _.sqlStatement-> "SQLStatement",
      _.releaseNo-> "ReleaseNo",
      _.processing-> "Processing",
      _.processed-> "Processed",
      _.name2-> "Name2",
      _.line-> "Line",
      _.workbenchId-> "AD_Workbench_ID",
      _.entityId-> "AD_Table_ID",
      _.reportViewId-> "AD_ReportView_ID",
      _.packageExportId-> "AD_Package_Exp_ID",
      _.packageCodeNew-> "AD_Package_Code_New",
      _.packageCodeOld-> "AD_Package_Code_Old",
      _.dynamicValidationRuleId-> "AD_Val_Rule_ID",
      _.messageId-> "AD_Message_ID",
      _.printFormatId-> "AD_PrintFormat_ID",
      _.referenceId-> "AD_Reference_ID",
      _.modelValidatorId-> "AD_ModelValidator_ID",
      _.entityTypeId-> "AD_EntityType_ID",
      _.viewId-> "AD_View_ID",
      _.browseId-> "AD_Browse_ID",
      _.uuid-> "UUID")
  }
}
