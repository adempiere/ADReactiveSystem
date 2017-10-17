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
  * Workflow Event Audit Entity
  * @param workflowEventAuditId Wf Event Audit ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param eventType Event Type
  * @param workflowState Wf State
  * @param workflowProcessId Wf Process ID
  * @param nodeId Node ID
  * @param tableId Table ID
  * @param recordId Record ID
  * @param workflowResponsibleId Wf Responsive ID
  * @param userId User ID
  * @param elapsedTimeMs Elapsed Time MS
  * @param attributeName Attribute Name
  * @param oldValue Old Value
  * @param newValue New Value
  * @param description Description
  * @param textMsg Text Msg
  * @param uuid UUID
  */

case class WorkflowEventAudit(workflowEventAuditId: Int,
                              tenantId: Int,
                              organizationId : Int ,
                              isActive: Boolean = true,
                              created: DateTime = DateTime.now,
                              createdBy: Int,
                              updated: DateTime = DateTime.now,
                              updatedBy: Int,
                              eventType: String,
                              workflowState: String,
                              workflowProcessId: Int,
                              nodeId: Int,
                              tableId: Int,
                              recordId: Int,
                              workflowResponsibleId: Int,
                              userId: Option[Int],
                              elapsedTimeMs: Int,
                              attributeName: Option[String],
                              oldValue: Option[String],
                              newValue: Option[String],
                              description: Option[String],
                              textMsg: Option[String],
                              uuid: Option[String]
                       ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = workflowEventAuditId

  override val entityName: String = "AD_Wf_EventAudit"
  override val identifier: String = "AD_Wf_EventAudit_ID"
}

object WorkflowEventAudit  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[WorkflowEventAudit]
  def create(workflowEventAuditId: Int,
             tenantId: Int,
             organizationId : Int ,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             eventType: String,
             workflowState: String,
             workflowProcessId: Int,
             nodeId: Int,
             tableId: Int,
             recordId: Int,
             workflowResponsibleId: Int,
             userId: Int,
             elapsedTimeMs: Int,
             attributeName: String,
             oldValue: String,
             newValue: String,
             description: String,
             textMsg: String,
             uuid: String) = WorkflowEventAudit(workflowEventAuditId, tenantId, organizationId, isActive, created,
    createdBy, updated, updatedBy, eventType, workflowState, workflowProcessId, nodeId, tableId, recordId,
    workflowResponsibleId, None, elapsedTimeMs, None, None, None, None, None, None)
}



