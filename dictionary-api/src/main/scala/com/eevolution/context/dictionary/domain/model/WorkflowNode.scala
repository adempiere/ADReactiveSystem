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
  * Workflow Node Entity
  * @param workflowNodeId Wf Node ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param description Description
  * @param help Help
  * @param workFlowId Work Flow ID
  * @param isCentrallyMaintained Is Centrally Maintained
  * @param action Action
  * @param windowId Window ID
  * @param workFlowId2 Work Flow ID 2
  * @param taskId Task ID
  * @param processId Process ID
  * @param formId Form ID
  * @param entityType Entity Type
  * @param xPosition X Position
  * @param yPosition Y Position
  * @param workflowBlockId Wf Block ID
  * @param subFlowExecution Sub Flow Execution
  * @param startMode Start Mode
  * @param finishMode Finish Mode
  * @param limit Limit
  * @param cost Cost
  * @param workingTime Working Time
  * @param waitingTime Waiting Time
  * @param workflowResponsibleId Wf Responsible ID
  * @param imageId Image ID
  * @param joinElement Join Element
  * @param splitElement Split Element
  * @param waitTime Wait Time
  * @param columnId Column ID
  * @param attributeName Attribute Name
  * @param attributeValue Attribute Value
  * @param docAction Doc Action
  * @param value Value
  * @param dynPriorityUnit Dyn Priority Unit
  * @param dynPriorityChange Dyn Priority Change
  * @param emailRecipient Email Recipient
  * @param email Email
  * @param mailTextId Mail Text ID
  * @param validTo Valid To
  * @param isMilestone Is Milestone
  * @param isSubContracting Is Sub Contracting
  * @param unitsCycles Units Cycles
  * @param movingTime Moving Time
  * @param overlapUnits Overlap Units
  * @param bPartnerId business Partner ID
  * @param queuingTime Queuing Time
  * @param resourceId Resource ID
  * @param setupTime Setup Time
  * @param validFrom Valid From
  * @param yieldData Yield Data
  * @param viewId View ID
  * @param browseId Browse ID
  * @param uuid UUID
  */

case class WorkflowNode(workflowNodeId: Int,
                        isActive: Boolean = true,
                        created: DateTime = DateTime.now,
                        createdBy: Int,
                        updated: DateTime = DateTime.now,
                        updatedBy: Int,
                        name: String,
                        description: Option[String],
                        help: Option[String],
                        workFlowId: Int,
                        isCentrallyMaintained: Boolean = true,
                        action: Boolean,
                        windowId: Option[Int],
                        workFlowId2: Option[Int],
                        taskId: Option[Int],
                        processId: Option[Int],
                        formId: Option[Int],
                        entityType: String = "U",
                        xPosition: Int = 0,
                        yPosition: Int = 0,
                        workflowBlockId: Option[Int],
                        subFlowExecution: Option[Boolean],
                        startMode: Option[Boolean],
                        finishMode: Option[Boolean],
                        limit: Int = 0,
                        cost: Int = 0,
                        workingTime: Option[Int],
                        waitingTime: Int = 0,
                        workflowResponsibleId: Option[Int],
                        imageId: Option[Int],
                        joinElement: Boolean,
                        splitElement: Boolean,
                        waitTime: Option[Int],
                        columnId: Option[Int],
                        attributeName: Option[String],
                        attributeValue: Option[String],
                        docAction: Option[String],
                        value: String,
                        dynPriorityUnit: Option[Boolean],
                        dynPriorityChange: Option[Int],
                        emailRecipient: Option[Boolean],
                        email: Option[String],
                        mailTextId: Option[Int],
                        validTo: Option[DateTime],
                        isMilestone: Boolean = false,
                        isSubContracting: Boolean = false,
                        unitsCycles: Int = 0,
                        movingTime: Option[Int],
                        overlapUnits: Option[Int],
                        bPartnerId: Option[Int],
                        queuingTime: Option[Int],
                        resourceId: Option[Int],
                        setupTime: Option[Int],
                        validFrom: Option[DateTime],
                        yieldData: Int = 100,
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

  override def Id: Int = workflowNodeId

  override val entityName: String = "AD_WfNode"
  override val identifier: String = "AD_WfNode_ID"
}

object WorkflowNode  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[WorkflowNode]
  def create(workflowNodeId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             description: String,
             help: String,
             workFlowId: Int,
             isCentrallyMaintained: Boolean,
             action: Boolean,
             windowId: Int,
             workFlowId2: Int,
             taskId: Int,
             processId: Int,
             formId: Int,
             entityType: String,
             xPosition: Int,
             yPosition: Int,
             workflowBlockId: Int,
             subFlowExecution: Boolean,
             startMode: Boolean,
             finishMode: Boolean,
             limit: Int,
             cost: Int,
             workingTime: Int,
             waitingTime: Int,
             workflowResponsibleId: Int,
             imageId: Int,
             joinElement: Boolean,
             splitElement: Boolean,
             waitTime: Int,
             columnId: Int,
             attributeName: String,
             attributeValue: String,
             docAction: String,
             value: String,
             dynPriorityUnit: Boolean,
             dynPriorityChange: Int,
             emailRecipient: Boolean,
             email: String,
             mailTextId: Int,
             validTo: DateTime,
             isMilestone: Boolean,
             isSubContracting: Boolean,
             unitsCycles: Int,
             movingTime: Int,
             overlapUnits: Int,
             bPartnerId: Int,
             queuingTime: Int,
             resourceId: Int,
             setupTime: Int,
             validFrom: DateTime,
             yieldData: Int,
             viewId: Int,
             browseId: Int,
             uuid: String) = WorkflowNode(workflowNodeId, isActive, created, createdBy, updated, updatedBy,
    name, None, None, workFlowId, isCentrallyMaintained, action, None, None, None, None, None,
    entityType, xPosition, yPosition, None, None, None, None, limit, cost, None, waitingTime,
    None, None, joinElement, splitElement, None, None, None, None, None, value, None, None,
    None, None, None, None, isMilestone, isSubContracting, unitsCycles, None, None, None,
    None, None, None, None, yieldData, None, None, None)
}

