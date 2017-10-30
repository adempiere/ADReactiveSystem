package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.WorkflowNode
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
  * Workflow Node Mapping
  */

trait WorkflowNodeMapping {
  val queryWorkflowNode = quote {
    querySchema[WorkflowNode]("AD_WF_Node",
      _.workflowNodeId-> "AD_WF_Node_ID",
      _.tenantId-> "AD_Client_ID",
      _.organizationId -> "AD_Org_ID" ,
      _.isActive-> "IsActive",
      _.created-> "Created",
      _.createdBy-> "CreatedBy",
      _.updated-> "Updated",
      _.updatedBy-> "UpdatedBy",
      _.name-> "Name",
      _.description-> "Description",
      _.help-> "Help",
      _.workFlowId-> "AD_Workflow_ID",
      _.isCentrallyMaintained-> "IsCentrallyMaintained",
      _.action-> "Action",
      _.windowId-> "AD_Window_ID",
      _.workFlowId2-> "Workflow_ID",
      _.taskId-> "AD_Task_ID",
      _.processId-> "AD_Process_ID",
      _.formId-> "AD_Form_ID",
      _.entityType-> "EntityType",
      _.xPosition-> "XPosition",
      _.yPosition-> "YPosition",
      _.workflowBlockId-> "AD_WF_Block_ID",
      _.subFlowExecution-> "SubFlowExecution",
      _.startMode-> "StartMode",
      _.finishMode-> "FinishMode",
      _.limit-> "Limit",
      _.priority -> "Priority",
      _.duration -> "Duration",
      _.cost-> "Cost",
      _.workingTime-> "WorkingTime",
      _.waitingTime-> "WaitingTime",
      _.workflowResponsibleId-> "AD_WF_Responsible_ID",
      _.imageId-> "AD_Image_ID",
      _.joinElement-> "JoinElement",
      _.splitElement-> "SplitElement",
      _.waitTime-> "WaitTime",
      _.attributeId-> "AD_Column_ID",
      _.attributeName-> "AttributeName",
      _.attributeValue-> "AttributeValue",
      _.docAction-> "DocAction",
      _.value-> "Value",
      _.dynPriorityUnit-> "DynPriorityUit",
      _.dynPriorityChange-> "DynPriorityChange",
      _.emailRecipient-> "EmailRecipient",
      _.email-> "Email",
      _.mailTextId-> "R_MailText_ID",
      _.validTo-> "ValidTo",
      _.isMilestone-> "IsMilestone",
      _.isSubContracting-> "IsSubcontracting",
      _.unitsCycles-> "UnitsCycles",
      _.movingTime-> "MovingTime",
      _.overlapUnits-> "OverlapUnits",
      _.bPartnerId-> "C_BPartner_ID",
      _.queuingTime-> "QueuingTime",
      _.resourceId-> "S_Resource_ID",
      _.setupTime-> "SetupTime",
      _.validFrom-> "ValidFrom",
      _.yieldData-> "Yield",
      _.viewId-> "AD_View_ID",
      _.browseId-> "AD_Browse_ID",
      _.uuid-> "UUID")
  }
}
