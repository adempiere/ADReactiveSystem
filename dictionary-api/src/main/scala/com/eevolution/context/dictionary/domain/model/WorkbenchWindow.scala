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
  * Workbench Window Entity
  * @param workbenchWindowId Work Bench Window ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param workbenchId Work Bench ID
  * @param seqNo Seq No
  * @param isPrimary Is Primary
  * @param windowId Window ID
  * @param formId Form  ID
  * @param processId Process ID
  * @param taskId Task ID
  * @param entityType Entity Type
  * @param uuid UUID
  */

case class WorkbenchWindow(workbenchWindowId: Int,
                           isActive: Boolean = true,
                           created: DateTime = DateTime.now,
                           createdBy: Int,
                           updated: DateTime = DateTime.now,
                           updatedBy: Int,
                           workbenchId: Int,
                           seqNo: Int,
                           isPrimary: Boolean = false,
                           windowId: Option[Int],
                           formId: Option[Int],
                           processId: Option[Int],
                           taskId: Option[Int],
                           entityType: String = "D",
                           uuid: Option[String]
                           ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = workbenchWindowId

  override val entityName: String = "AD_WorkbenchWindow"
  override val identifier: String = "AD_WorkbenchWindow_ID"

}

object WorkbenchWindow {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[WorkbenchWindow]
  def create(workbenchWindowId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             workbenchId: Int,
             seqNo: Int,
             isPrimary: Boolean,
             windowId: Int,
             formId: Int,
             processId: Int,
             taskId: Int,
             entityType: String,
             uuid: String) = WorkbenchWindow(workbenchWindowId, isActive, created, createdBy, updated,
    updatedBy, workbenchId, seqNo, isPrimary, None, None, None, None, entityType, None)
}
