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
  * Info Column Entity
  * @param infoColumnId Info Column ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param description Description
  * @param help Help
  * @param infoWindowId Info Window ID
  * @param entityType Entity Type
  * @param selectClause Select Clause
  * @param seqNo Seq No
  * @param isDisplayed Is Displayed
  * @param isQueryCriteria Is Query Criteria
  * @param elementId Element ID
  * @param referenceId Reference ID
  * @param uuid UUID
  */

case class InfoColumn(infoColumnId: Int,
                      isActive: Boolean = true,
                      created: DateTime = DateTime.now,
                      createdBy: Int,
                      updated: DateTime = DateTime.now,
                      updatedBy: Int,
                      name: String,
                      description: Option[String],
                      help: Option[String],
                      infoWindowId: Int,
                      entityType: String = "D",
                      selectClause: String,
                      seqNo: Int = 0,
                      isDisplayed : Boolean = true,
                      isQueryCriteria: Boolean = false,
                      elementId: Option[Int],
                      referenceId: Int,
                      uuid: Option[String]
                     ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = infoColumnId

  override val entityName: String = "AD_InfoColumn"
  override val identifier: String = "AD_InfoColumn_ID"
}

object InfoColumn  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[InfoColumn]
  def create(infoColumnId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             description: String,
             help: String,
             infoWindowId: Int,
             entityType: String,
             selectClause: String,
             seqNo: Int,
             isDisplayed : Boolean,
             isQueryCriteria: Boolean,
             elementId: Int,
             referenceId: Int,
             uuid: String) = InfoColumn(infoColumnId, isActive, created, createdBy, updated, updatedBy, name,
    None, None, infoWindowId, entityType, selectClause, seqNo,
    isDisplayed, isQueryCriteria, None, referenceId, None)
}


