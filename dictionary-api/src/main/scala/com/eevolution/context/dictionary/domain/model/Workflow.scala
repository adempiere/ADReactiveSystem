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
  */
/**
  * Workflow Entity
  * @param workflowId Workflow ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param description Description
  * @param help Help
  * @param accessLevel Access Level
  * @param WfNodeId Wf Node ID
  * @param entityType Entity Type
  * @param durationUnit Duration Unit
  * @param author Author
  * @param version Version
  * @param validFrom Valid From
  * @param validTo Valid To
  * @param priority Priority
  * @param limit Limit
  * @param duration Duration
  * @param cost Cost
  * @param workingTime Working Time
  * @param waitingTime Waiting Time
  * @param wfResponsibleId Wf Responsible ID
  * @param publishStatus Publish Status
  * @param workflowProcessorId Work Flow Processor ID
  * @param value Value
  * @param isDefault Is Default
  * @param tableId Table ID
  * @param validateWorkflow Validate Workflow
  * @param workflowType Work Flow Type
  * @param docValueLogic Doc Value Logic
  * @param isValid Is Valid
  * @param sResourceId S Resource ID
  * @param setupTime Setup Time
  * @param movingTime Moving Time
  * @param processType Process Type
  * @param documentNo Document No
  * @param qTyBatchSize G Ty Batch Size
  * @param queUIngTime Que U Ing Time
  * @param isBetaFunctionality Is Beta Functionality
  * @param yieldData Yield Data
  * @param unitsCycles Units Cycles
  * @param overLapUnits Over Lap Units
  * @param uuid UUID
  */


case class Workflow(workflowId: Int,
                    tenantId: Int,
                    organizationId: Int,
                    isActive: Boolean = true,
                    created: DateTime = DateTime.now,
                    createdBy: Int,
                    updated: DateTime = DateTime.now,
                    updatedBy: Int,
                    name: String,
                    description: Option[String],
                    help: Option[String],
                    accessLevel: Boolean,
                    WfNodeId: Option[String],
                    entityType: String = "D",
                    durationUnit: Option[Boolean],
                    author: String,
                    version: Int,
                    validFrom: Option[DateTime],
                    validTo: Option[DateTime],
                    priority: Option[Int],
                    limit: Option[Int],
                    duration: Int,
                    cost: Int,
                    workingTime: Int,
                    waitingTime: Int,
                    wfResponsibleId: Option[Int],
                    publishStatus: Boolean,
                    workflowProcessorId: Option[Int],
                    value: String,
                    isDefault: Boolean = false,
                    tableId: Option[Int],
                    validateWorkflow: Option[Int],
                    workflowType: String = "G",
                    docValueLogic: Option[String],
                    isValid: Boolean = false,
                    sResourceId: Option[Int],
                    setupTime: Option[Int],
                    movingTime: Option[Int],
                    processType: Option[String],
                    documentNo: Option[String],
                    qTyBatchSize: Option[Int],
                    queUIngTime: Option[Int],
                    isBetaFunctionality: Boolean = false,
                    yieldData: Option[Int],
                    unitsCycles: Option[Int],
                    overLapUnits: Option[Int],
                    uuid: Option[String]
                    ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = workflowId

  override val entityName: String = "AD_Workflow"
  override val identifier: String = "AD_Workflow_ID"

}

object Workflow {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Workflow]
  def create(workflowId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             description: String,
             help: String,
             accessLevel: Boolean,
             WfNodeId: String,
             entityType: String,
             durationUnit: Boolean,
             author: String,
             version: Int,
             validFrom: DateTime,
             validTo: DateTime,
             priority: Int,
             limit: Int,
             duration: Int,
             cost: Int,
             workingTime: Int,
             waitingTime: Int,
             wfResponsibleId: Int,
             publishStatus: Boolean,
             workflowProcessorId: Int,
             value: String,
             isDefault: Boolean,
             tableId: Int,
             validateWorkflow: Int,
             workflowType: String,
             docValueLogic: String,
             isValid: Boolean,
             sResourceId: Int,
             setupTime: Int,
             movingTime: Int,
             processType: String,
             documentNo: String,
             qTyBatchSize: Int,
             queUIngTime: Int,
             isBetaFunctionality: Boolean,
             yieldData: Int,
             unitsCycles: Int,
             overLapUnits: Int,
             uuid: String) = Workflow(workflowId, tenantId, organizationId, isActive, created, createdBy, updated,
    updatedBy, name, None, None, accessLevel, None, entityType, None, author, version, None, None, None, None, duration,
    cost, workingTime, waitingTime, None, publishStatus, None, value, isDefault, None, None, workflowType, None,
    isValid, None, None, None, None, None, None, None, isBetaFunctionality, None, None, None, None)
}
