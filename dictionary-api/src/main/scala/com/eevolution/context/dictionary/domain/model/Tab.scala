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
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 13/10/2017.
  */


/**
  * Tab Entity
  * @param tabId Tab ID
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
  * @param entityId Entity ID
  * @param windowId Window ID
  * @param seqNo Seq No
  * @param tabLevel Tab Level
  * @param isSingleRow Is Single Row
  * @param isInfoTab Is Info Tab
  * @param isTranslationTab Is Translation
  * @param isReadOnly Is Read Only
  * @param attributeId Attribute ID
  * @param hasTree Has Tree
  * @param whereClause Where Clause
  * @param orderByClause Order By Clause
  * @param commitWarning Commit Warning
  * @param processId Process ID
  * @param processing Processing
  * @param imageId Image ID
  * @param importFields Import Fields
  * @param columnORTOrderId Column ORT Order ID
  * @param columnORTYesNoId Column ORT Yes No ID
  * @param isORTTab Is ORT Tab
  * @param entityType Entity Type
  * @param includedTabId Included Tab ID
  * @param readOnlyLogic Read Only Logic
  * @param displayLogic Display Logic
  * @param isInsertRecord Is Insert Record
  * @param isAdvancedTab Is Advanced Tab
  * @param parentColumnId Parent Column ID
  * @param uuid UUID
  */

case class Tab(tabId: Int,
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
               entityId: Int,
               windowId: Int,
               seqNo: Int,
               tabLevel: Int,
               isSingleRow: Boolean = true,
               isInfoTab: Boolean = false,
               isTranslationTab: Boolean = false,
               isReadOnly: Boolean = false,
               attributeId: Option[Int],
               hasTree: Boolean = false,
               whereClause: Option[String],
               orderByClause: Option[String],
               commitWarning: Option[String],
               processId: Option[Int],
               processing: Option[String],
               imageId: Option[Int],
               importFields: Option[Boolean],
               columnORTOrderId: Option[Int],
               columnORTYesNoId: Option[Int],
               isORTTab: Boolean = false,
               entityType: String = "D",
               includedTabId: Option[Int],
               readOnlyLogic: Option[String],
               displayLogic: Option[String],
               isInsertRecord: Boolean = true,
               isAdvancedTab: Boolean = false,
               parentColumnId: Option[Int],
               uuid: Option[String]
              ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = tabId

  override val entityName: String = "AD_Tab"
  override val identifier: String = "AD_Tab_ID"
}

object Tab  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Tab]
  def create(tabId: Int,
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
             entityId: Int,
             windowId: Int,
             seqNo: Int,
             tabLevel: Int,
             isSingleRow: Boolean,
             isInfoTab: Boolean ,
             isTranslationTab: Boolean,
             isReadOnly: Boolean ,
             attributeId: Int,
             hasTree: Boolean,
             whereClause: String,
             orderByClause: String,
             commitWarning: String,
             processId: Int,
             processing: String,
             imageId: Int,
             importFields: Boolean,
             columnORTOrderId: Int,
             columnORTYesNoId: Int,
             isORTTab: Boolean,
             entityType: String ,
             includedTabId: Int,
             readOnlyLogic: String,
             displayLogic: String,
             isInsertRecord: Boolean ,
             isAdvancedTab: Boolean,
             parentColumnId: Int,
             uuid: String ) = Tab(tabId, tenantId, organizationId, isActive, created, createdBy, updated,
    updatedBy, name, None, None, entityId, windowId, seqNo, tabLevel, isSingleRow, isInfoTab, isTranslationTab,
    isReadOnly, None, hasTree, None, None, None, None, None, None, None, None, None, isORTTab, entityType,
    None, None, None, isInsertRecord, isAdvancedTab, None, None)
}

