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
  * Wf Activity Entity
  * @param wfActivityId Wf Activity ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param wfProcessId Wf Process ID
  * @param wfNodeId Wf Node ID
  * @param wfResponsibleId Wf Responsible ID
  * @param userId User ID
  * @param wfState Wf State
  * @param messageId Message ID
  * @param processing Processing
  * @param processed Processed
  * @param textMsg Text Msg
  * @param workFlowId Work Flow ID
  * @param tableId Table ID
  * @param recordId Record ID
  * @param priority Priority
  * @param endWaitTime End Wait Time
  * @param dateLastAlert Date Last Alert
  * @param dynPriorityStart Dyn Priority Start
  * @param uuId UU ID
  */

case class WfActivity(wfActivityId: Int,
                      isActive: Boolean = true,
                      created: DateTime = DateTime.now,
                      createdBy: Int,
                      updated: DateTime = DateTime.now,
                      updatedBy: Int,
                      wfProcessId: Int,
                      wfNodeId: Int,
                      wfResponsibleId: Option[Int],
                      userId: Option[Int],
                      wfState: String,
                      messageId: Option[Int],
                      processing: Option[Boolean],
                      processed: Boolean = false,
                      textMsg: Option[String],
                      workFlowId: Int,
                      tableId: Int,
                      recordId: Int,
                      priority: Option[Int],
                      endWaitTime: Option[DateTime],
                      dateLastAlert: Option[DateTime],
                      dynPriorityStart: Option[Int],
                      uuId: Option[String]
                     ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = wfActivityId

  override val entityName: String = "AD_WfActivity"
  override val identifier: String = "AD_WfActivity_ID"
}

object WfActivity {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[WfActivity]
  def create(wfActivityId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             wfProcessId: Int,
             wfNodeId: Int,
             wfResponsibleId: Int,
             userId: Int,
             wfState: String,
             messageId: Int,
             processing: Boolean,
             processed: Boolean,
             textMsg: String,
             workFlowId: Int,
             tableId: Int,
             recordId: Int,
             priority: Int,
             endWaitTime: DateTime,
             dateLastAlert: DateTime,
             dynPriorityStart: Int,
             uuId: String) = WfActivity(wfActivityId, isActive, created, createdBy, updated, updatedBy,
    wfProcessId, wfNodeId, None, None, wfState, None, None, processed, None, workFlowId, tableId, recordId,
    None, None, None, None, None)

}

