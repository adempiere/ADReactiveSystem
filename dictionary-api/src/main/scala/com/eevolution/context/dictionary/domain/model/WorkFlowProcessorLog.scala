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
  * Work Flow Processor Log Entity
  * @param workFlowProcessorLogId Work Flow Processor Log ID
  * @param workFlowProcessorId Work Flow Processor ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param isError Is Error
  * @param summary Summary
  * @param reference Reference
  * @param description Description
  * @param textMsg Text Msg
  * @param binaryDate Binary Date
  * @param uuId UU ID
  */

case class WorkFlowProcessorLog (workFlowProcessorLogId: Int,
                                 workFlowProcessorId: Int,
                                 isActive: Boolean = true,
                                 created: DateTime = DateTime.now,
                                 createdBy: Int,
                                 updated: DateTime = DateTime.now,
                                 updatedBy: Int,
                                 isError: Boolean = false,
                                 summary: Option[String],
                                 reference: Option[String],
                                 description: Option[String],
                                 textMsg: Option[String],
                                 binaryDate: Option[String],
                                 uuId: Option[String]
                                ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = workFlowProcessorLogId

  override val entityName: String = "AD_WorkFlowProcessorLog"
  override val identifier: String = "AD_WorkFlowProcessorLog_ID"

}

object WorkFlowProcessorLog {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[WorkFlowProcessorLog]
  def create(workFlowProcessorLogId: Int,
             workFlowProcessorId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             isError: Boolean,
             summary: String,
             reference: String,
             description: String,
             textMsg: String,
             binaryDate: String,
             uuId: String) = WorkFlowProcessorLog(workFlowProcessorLogId, workFlowProcessorId, isActive, created, createdBy, updated,
    updatedBy, isError, None, None, None, None, None, None)
}
