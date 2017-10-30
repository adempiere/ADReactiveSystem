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
  * Email: emeris.hernandez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com
  */

/**
  * Workflow Activity Entity
  * @param workflowActivityId Wf Activity ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param workflowProcessId Wf Process ID
  * @param workflowNodeId Wf Node ID
  * @param workflowResponsibleId Wf Responsible ID
  * @param userId User ID
  * @param workflowState Wf State
  * @param messageId Message ID
  * @param processing Processing
  * @param processed Processed
  * @param textMsg Text Msg
  * @param workFlowId Work Flow ID
  * @param entityId Entity ID
  * @param recordId Record ID
  * @param priority Priority
  * @param endWaitTime End Wait Time
  * @param dateLastAlert Date Last Alert
  * @param dynPriorityStart Dyn Priority Start
  * @param uuid UUID
  */

case class WorkflowActivity(workflowActivityId: Int,
                            tenantId: Int,
                            organizationId : Int ,
                            isActive: Boolean = true,
                            created: DateTime = DateTime.now,
                            createdBy: Int,
                            updated: DateTime = DateTime.now,
                            updatedBy: Int,
                            workflowProcessId: Int,
                            workflowNodeId: Int,
                            workflowResponsibleId: Option[Int],
                            userId: Option[Int],
                            workflowState: String,
                            messageId: Option[Int],
                            processing: Option[Boolean],
                            processed: Boolean = false,
                            textMsg: Option[String],
                            workFlowId: Int,
                            entityId: Int,
                            recordId: Int,
                            priority: Option[Int],
                            endWaitTime: Option[DateTime],
                            dateLastAlert: Option[DateTime],
                            dynPriorityStart: Option[Int],
                            uuid: String
                     ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = workflowActivityId

  override val entityName: String = "AD_Wf_Activity"
  override val identifier: String = "AD_Wf_Activity_ID"
}

object WorkflowActivity {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[WorkflowActivity]
  def create(workflowActivityId: Int,
             tenantId: Int,
             organizationId : Int ,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             workflowProcessId: Int,
             workflowNodeId: Int,
             workflowResponsibleId: Int,
             userId: Int,
             workflowState: String,
             messageId: Int,
             processing: Boolean,
             processed: Boolean,
             textMsg: String,
             workFlowId: Int,
             entityId: Int,
             recordId: Int,
             priority: Int,
             endWaitTime: DateTime,
             dateLastAlert: DateTime,
             dynPriorityStart: Int,
             uuid: String) = WorkflowActivity(workflowActivityId, tenantId, organizationId,  isActive, created,
    createdBy, updated, updatedBy, workflowProcessId, workflowNodeId, None, None, workflowState, None, None,
    processed, None, workFlowId, entityId, recordId, None, None, None, None, uuid)

}

