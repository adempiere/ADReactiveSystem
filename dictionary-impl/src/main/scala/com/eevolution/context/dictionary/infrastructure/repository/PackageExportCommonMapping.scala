package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.PackageExportCommon
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
  * Package Export Common Mapping
  */

trait PackageExportCommonMapping {
  val queryPackageExportCommon = quote {
    querySchema[PackageExportCommon]("AD_Package_Exp_Common",
      _.packageExportCommonId-> "AD_Package_Exp_Common_ID",
      _.tenantId-> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.isActive-> "IsActive",
      _.created-> "Created",
      _.createdBy-> "CreatedBy",
      _.updated-> "Updated",
      _.updatedBy-> "UpdatedBy",
      _.formId-> "AD_Form_ID",
      _.importFormatId-> "AD_ImpFormat_ID",
      _.reportViewId-> "AD_ReportView_ID",
      _.entityId-> "AD_Table_ID",
      _.workbenchId-> "AD_Workbench_ID",
      _.dbType-> "DBType",
      _.processed-> "Processed",
      _.name-> "Name",
      _.name2-> "Name2",
      _.line-> "Line",
      _.fileDirectory-> "File_Directory",
      _.fileName-> "FileName",
      _.destinationDirectory-> "Destination_Directory",
      _.description-> "Description",
      _.typePackage-> "Type",
      _.targetDirectory-> "Target_Directory",
      _.sqlStatement-> "SQLStatement",
      _.processing-> "Processing",
      _.workflowId-> "AD_Workflow_ID",
      _.windowId-> "AD_Window_ID",
      _.roleId-> "AD_Role_ID",
      _.processId-> "AD_Process_ID",
      _.menuId-> "AD_Menu_ID",
      _.uuid-> "UUID")
  }
}
