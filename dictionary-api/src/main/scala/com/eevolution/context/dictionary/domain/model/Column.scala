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
  * Column Entity
  * @param columnId Column ID
  * @param isActive Is Active
  * @param created Created
  * @param updated Updated
  * @param createdBy Created By
  * @param updatedBy Updated By
  * @param name Name
  * @param description Description
  * @param help Help
  * @param version Version
  * @param entityType Entity Type
  * @param columnName Column Name
  * @param tableId Table ID
  * @param referenceId Reference ID
  * @param referenceValueId Reference Value ID
  * @param valRuleId Val Rule ID
  * @param fieldLength Field Length
  * @param defaultValue Default Value
  * @param isKey Is Key
  * @param isParent Is Parent
  * @param isMandatory Is Mandatory
  * @param isUpdateAble Is Update Able
  * @param readOnlyLogic Read Only Logic
  * @param isIdentifier Is Identifier
  * @param seqNo Seq No
  * @param isTranslated Is Translated
  * @param isEncrypted Is Encrypted
  * @param callOut Call Out
  * @param vFormat V Format
  * @param valueMin Value Min
  * @param valueMax Value Max
  * @param isSelectionColumn is Selection Column
  * @param elementId Element ID
  * @param processId Process ID
  * @param isSyncDatabase Is Sync Database
  * @param isAlwaysUpdateAble Is Always Update Able
  * @param columnSql Column SQL
  * @param mandatoryLogic Mandatory Logic
  * @param infoFactoryClass Info Factory Class
  * @param isAutoComplete Is Auto Complete
  * @param forMatPattern For Hat Pattern
  * @param chartId Chart ID
  * @param isRange Is Range
  * @param isAllowCopy Is Allow Copy
  * @param uuId UU ID
  */

case class Column(columnId: Int,
                  isActive:Boolean=true,
                  created:DateTime = DateTime.now,
                  updated: DateTime = DateTime.now,
                  createdBy: Int,
                  updatedBy: Int,
                  name: String,
                  description: Option[String],
                  help: Option[String],
                  version: Int,
                  entityType: String = "D",
                  columnName: String,
                  tableId: Int,
                  referenceId: Int,
                  referenceValueId:Option[Int],
                  valRuleId: Option[Int],
                  fieldLength: Option[Int],
                  defaultValue: Option[String],
                  isKey: Boolean=false,
                  isParent: Boolean = false,
                  isMandatory: Boolean= false,
                  isUpdateAble: Boolean = true,
                  readOnlyLogic: Option[String],
                  isIdentifier: Boolean = false,
                  seqNo: Option[Int],
                  isTranslated: Boolean = false,
                  isEncrypted: Boolean = false,
                  callOut: Option[String],
                  vFormat: Option[String],
                  valueMin: Option[String],
                  valueMax: Option[String],
                  isSelectionColumn: Boolean = false,
                  elementId: Option[Int],
                  processId: Option[Int],
                  isSyncDatabase: Boolean = false,
                  isAlwaysUpdateAble: Boolean = false,
                  columnSql: Option[String],
                  mandatoryLogic: Option[String],
                  infoFactoryClass: Option[String],
                  isAutoComplete: Boolean = false,
                  forMatPattern: Option[String],
                  chartId: Option[Int],
                  isRange: Boolean = false,
                  isAllowCopy: Boolean = true,
                  uuId: Option[String]
                 ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = columnId

  override val entityName: String = "AD_Column"
  override val identifier: String = "AD_Column_ID"
}


object Column {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Column]
  def create(columnId: Int,
             isActive:Boolean,
             created:DateTime,
             updated: DateTime,
             createdBy: Int,
             updatedBy: Int,
             name: String,
             description: String,
             help: String,
             version: Int,
             entityType: String,
             columnName: String,
             tableId: Int,
             referenceId: Int,
             referenceValueId:Int,
             valRuleId:Int,
             fieldLength: Int,
             defaultValue: String,
             isKey: Boolean,
             isParent: Boolean,
             isMandatory: Boolean,
             isUpdateAble: Boolean,
             readOnlyLogic: String,
             isIdentifier: Boolean,
             seqNo: Int,
             isTranslated: Boolean,
             isEncrypted: Boolean,
             callOut: String,
             vFormat: String,
             valueMin: String,
             valueMax: String,
             isSelectionColumn: Boolean,
             elementId: Int,
             processId: Int,
             isSyncDatabase: Boolean,
             isAlwaysUpdateAble: Boolean,
             columnSql: String,
             mandatoryLogic: String,
             infoFactoryClass: String,
             isAutoComplete: Boolean,
             forMatPattern: String,
             chartId: Int,
             isRange: Boolean,
             isAllowCopy: Boolean,
             uuId: String) = Column(columnId, isActive,created, updated, createdBy,
    updatedBy, name, None, None, version, entityType, columnName, tableId, referenceId, None, None, None,
    None, isKey, isParent, isMandatory, isUpdateAble, None, isIdentifier, None, isTranslated,isEncrypted, None,
    None, None, None, isSelectionColumn, None, None, isSyncDatabase, isAlwaysUpdateAble, None, None, None, isAutoComplete,
    None, None, isRange, isAllowCopy, None)
}
