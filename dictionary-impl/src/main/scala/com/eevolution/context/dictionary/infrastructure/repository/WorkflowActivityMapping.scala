package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.WorkflowActivity
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
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 30/10/17.
  */

/**
  * Workflow Activity Mapping
  */

trait WorkflowActivityMapping {
  val queryWorkflowActivity = quote {
    querySchema[WorkflowActivity]("AD_WF_Activity",
      _.workflowActivityId-> "AD_WF_Activity_ID",
      _.tenantId-> "AD_Client_ID",
      _.organizationId -> "AD_Org_ID" ,
      _.isActive-> "IsActive",
      _.created-> "Created",
      _.createdBy-> "CreatedBy",
      _.updated-> "Updated",
      _.updatedBy-> "UpdatedBy",
      _.workflowProcessId-> "AD_WF_Process_ID",
      _.workflowNodeId-> "AD_WF_Node_ID",
      _.workflowResponsibleId-> "AD_WF_Responsible_ID",
      _.userId-> "AD_User_ID",
      _.workflowState-> "WFState",
      _.messageId-> "AD_Message_ID",
      _.processing-> "Processing",
      _.processed-> "Processed",
      _.textMsg-> "TextMsg",
      _.workFlowId-> "AD_Workflow_ID",
      _.entityId-> "AD_Table_ID",
      _.recordId-> "Record_ID",
      _.priority-> "Priority",
      _.endWaitTime-> "EndWaitTime",
      _.dateLastAlert-> "DateLastAlert",
      _.dynPriorityStart-> "DynPriorityStart",
      _.uuid-> "UUID")
  }
}
