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
  * Browse Entity
  * @param browseId Browse ID
  * @param created Created
  * @param createdBy Created By
  * @param isActive Is Active
  * @param updated Updated
  * @param updatedBy Updated By
  * @param description Description
  * @param entityType Entity Type
  * @param help Help
  * @param name Name
  * @param value Value
  * @param viewId View ID
  * @param whereClause Where Clause
  * @param processing Processing
  * @param processId Process ID
  * @param isBetaFunctionality Is Beta Functionality
  * @param accessLevel Access Level
  * @param copyFrom Copy From
  * @param isDeleteAble Is Delete Able
  * @param isCollapsibleByDefault Is Collapsible By Default
  * @param isSelectedByDefault Is Selected By Default
  * @param isExecutedQueryByDefault Is Executed Query By Default
  * @param windowId Window ID
  * @param isShowTotal Is Show Total
  * @param uuid UUID
  */

case class Browse(browseId: Int,
                  created: DateTime =  DateTime.now,
                  createdBy: Int,
                  isActive: Boolean = true,
                  updated: DateTime =  DateTime.now,
                  updatedBy: Int,
                  description: Option[String],
                  entityType: String,
                  help: Option[String],
                  name: String,
                  value: Option[String],
                  viewId: Int,
                  whereClause:Option[String],
                  processing: Option[Boolean],
                  processId:Option[Int],
                  isBetaFunctionality: Boolean=false,
                  accessLevel: Int=4,
                  copyFrom: Option[Boolean],
                  isDeleteAble: Boolean=false,
                  isCollapsibleByDefault: Boolean = false,
                  isSelectedByDefault: Boolean = false,
                  isExecutedQueryByDefault: Boolean = false,
                  windowId: Option[Int],
                  isShowTotal: Boolean = false,
                  uuid: Option[String]
                 ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = browseId

  override val entityName: String = "AD_Browse"
  override val identifier: String = "AD_Browse_ID"
}

  object Browse  {
    implicit lazy val jsonFormat = Jsonx.formatCaseClass[Browse]
    def create(browseId: Int,
               created: DateTime,
               createdBy: Int,
               isActive: Boolean,
               updated: DateTime,
               updatedBy: Int,
               description: String,
               entityType: String,
               help: String,
               name: String,
               value: String,
               viewId: Int,
               whereClause:String,
               processing: Boolean,
               processId: Int,
               isBetaFunctionality: Boolean,
               accessLevel: Int,
               copyFrom: Boolean,
               isDeleteAble: Boolean,
               isCollapsibleByDefault: Boolean,
               isSelectedByDefault: Boolean,
               isExecutedQueryByDefault: Boolean,
               windowId: Int,
               isShowTotal: Boolean,
               uuid: String) = Browse(browseId,created, createdBy, isActive, updated,
      updatedBy, None, entityType, None , name, None, viewId, None, None,
      None, isBetaFunctionality, accessLevel, None, isDeleteAble, isCollapsibleByDefault,
      isSelectedByDefault, isExecutedQueryByDefault, None, isShowTotal, None)
  }

