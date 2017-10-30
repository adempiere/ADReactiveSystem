package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.Workflow
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
  * Workflow Mapping
  */

trait WorkflowMapping {
  val queryWorkflow = quote {
    querySchema[Workflow]("AD_Workflow",
      _.workflowId-> "AD_Workflow_ID",
      _.tenantId-> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.isActive-> "IsActive",
      _.created-> "Created",
      _.createdBy-> "CreatedBy",
      _.updated-> "Updated",
      _.updatedBy-> "UpdatedBy",
      _.name-> "Name",
      _.description-> "Description",
      _.help-> "Help",
      _.accessLevel-> "AccessLevel",
      _.workflowNodeId-> "AD_WF_Node_ID",
      _.entityType-> "EntityType",
      _.durationUnit-> "DurationUnit",
      _.author-> "Author",
      _.version-> "Version",
      _.validFrom-> "ValidFrom",
      _.validTo-> "ValidTo",
      _.priority-> "Priority",
      _.limit-> "Limit",
      _.duration-> "Duration",
      _.cost-> "Cost",
      _.workingTime-> "WorkingTime",
      _.waitingTime-> "WaitingTime",
      _.workflowResponsibleId-> "AD_WF_Responsible_ID",
      _.publishStatus-> "PublishStatus",
      _.workflowProcessorId-> "AD_WorkflowProcessor_ID",
      _.value-> "Value",
      _.isDefault-> "IsDefault",
      _.entityId-> "AD_Table_ID",
      _.validateWorkflow-> "ValidateWorkflow",
      _.workflowType-> "WorkflowType",
      _.docValueLogic-> "DocValueLogic",
      _.isValid-> "IsValid",
      _.sResourceId-> "S_Resource_ID",
      _.setupTime-> "SetupTime",
      _.movingTime-> "MovingTime",
      _.processType-> "ProcessType",
      _.documentNo-> "DocumentNo",
      _.quantityBatchSize-> "QTYBatchSize",
      _.queuingTime-> "QueuingTime",
      _.isBetaFunctionality-> "IsBetaFunctionality",
      _.yieldData-> "Yield",
      _.unitsCycles-> "UnitsCycles",
      _.overlapUnits-> "OverlapUnits",
      _.uuid-> "UUID")
  }
}
