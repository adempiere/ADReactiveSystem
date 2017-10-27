package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.Process
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
  * Email: eduardo.moreno@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by eduardo.moreno@e-evolution.com , www.e-evolution.com
  */

/**
  * Print Process Mapping
  */
trait ProcessMapping  {
  val queryProcess = quote {
    querySchema[Process]("AD_Process",
      _.processId -> "AD_Process_ID",
      _.tenantId -> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.isActive -> "IsActive",
      _.created -> "Created",
      _.createdBy -> "CreatedBy",
      _.updated -> "Updated",
      _.updatedBy -> "UpdatedBy",
      _.value -> "Value",
      _.name -> "Name",
      _.description -> "Description",
      _.help -> "Help",
      _.accessLevel -> "AccessLevel",
      _.entityType -> "EntityType",
      _.procedureName -> "ProcedureName",
      _.isReport -> "IsReport",
      _.isDirectPrint -> "IsDirectPrint",
      _.reportViewId -> "AD_ReportView_ID",
      _.className -> "ClassName",
      _.statisticCount -> "Statistic_Count",
      _.statisticSeconds -> "Statistic_Second",
      _.printFormatId -> "AD_PrintFormat_ID",
      _.workflowValue -> "WorkflowValue",
      _.workflowId -> "AD_Workflow_ID",
      _.isBetaFunctionality -> "IsBetaFunctionality",
      _.isServerProcess -> "IsServerProcess",
      _.isShowHelp -> "IsShowHelp",
      _.jasperReport -> "JasperReport",
      _.formId -> "AD_Form_ID",
      _.copyFromProcess -> "CopyFromProcess",
      _.browseId -> "AD_Browse_ID",
      _.generateClass -> "GenerateClass",
      _.uuid -> "UUID")
  }
}
