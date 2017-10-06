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
  * Workflow Next Condition Entity
  * @param workflowNextConditionId Wf Next Condition ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param workflowNodeNextId Wf Node Next ID
  * @param seqNo Seq No
  * @param entityType Entity Type
  * @param andOr And Or
  * @param columnId Column ID
  * @param operation Operation
  * @param value Value
  * @param value2 Value 2
  * @param uuId UU ID
  */

case class WorkflowNextCondition(workflowNextConditionId: Int,
                                 isActive: Boolean = true,
                                 created: DateTime = DateTime.now,
                                 createdBy: Int,
                                 updated: DateTime = DateTime.now,
                                 updatedBy: Int,
                                 workflowNodeNextId: Int,
                                 seqNo: Int,
                                 entityType: String = "D",
                                 andOr: Boolean,
                                 columnId: Int,
                                 operation: String,
                                 value: String,
                                 value2: Option[String],
                                 uuId: Option[String]
                          ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = workflowNextConditionId

  override val entityName: String = "AD_WfNextCondition"
  override val identifier: String = "AD_WfNextCondition_ID"
}

object WorkflowNextCondition  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[WorkflowNextCondition]
  def create(workflowNextConditionId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             workflowNodeNextId: Int,
             seqNo: Int,
             entityType: String,
             andOr: Boolean,
             columnId: Int,
             operation: String,
             value: String,
             value2: String,
             uuId: String) = WorkflowNextCondition(workflowNextConditionId, isActive, created, createdBy, updated, updatedBy,
    workflowNodeNextId, seqNo, entityType, andOr, columnId, operation, value, None, None)
}



