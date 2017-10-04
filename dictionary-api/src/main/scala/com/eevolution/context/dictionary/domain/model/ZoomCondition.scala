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
  * Zoom Condition Entity
  * @param zoomConditionId Zoom Confition ID
  * @param tableId Table ID
  * @param windowId Window ID
  * @param created Created
  * @param createdBy Created By
  * @param description Description
  * @param isActive Is Active
  * @param name Name
  * @param seqNo Seq No
  * @param updated Update
  * @param updatedBy Update By
  * @param whereClause Where Clause
  * @param zoomLogic Zoom Logic
  * @param uuId UU ID
  */

case class ZoomCondition (zoomConditionId: Int,
                          tableId: Option[Int],
                          windowId: Option[Int],
                          created: DateTime = DateTime.now,
                          createdBy: Int,
                          description: Option[String],
                          isActive: Boolean = true,
                          name: Option[String],
                          seqNo: Option[Int],
                          updated: DateTime = DateTime.now,
                          updatedBy: Int,
                          whereClause: Option[String],
                          zoomLogic: Option[String],
                          uuId: Option[String]
                         ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = zoomConditionId

  override val entityName: String = "AD_ZoomCondition"
  override val identifier: String = "AD_ZoomCondition_ID"

}

object ZoomCondition {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[ZoomCondition]
  def create(zoomConditionId: Int,
             tableId: Int,
             windowId: Int,
             created: DateTime,
             createdBy: Int,
             description: String,
             isActive: Boolean,
             name: String,
             seqNo: Int,
             updated: DateTime,
             updatedBy: Int,
             whereClause: String,
             zoomLogic: String,
             uuId: String) = ZoomCondition(zoomConditionId, None, None, created, createdBy, None, isActive,
    None, None, updated, updatedBy, None, None, None)
}
