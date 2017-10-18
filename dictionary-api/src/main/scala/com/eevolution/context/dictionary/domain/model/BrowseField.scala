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
  * Browse Field Entity
  * @param browseFieldId Browse Field ID
  *
  * @param created Created
  * @param createdBy Created By
  * @param isActive Is Active
  * @param updated Updated
  * @param updatedBy Updated By
  * @param elementId Element ID
  * @param referenceId Reference ID
  * @param viewColumnId View Column ID
  * @param description Description
  * @param entityType Entity Type
  * @param help Help
  * @param isCentrallyMaintained Is Centrally Maintained
  * @param isDisplayed Is Displayed
  * @param isIdentifier Is Identifier
  * @param isKey Is Key
  * @param isQueryCriteria Is Query Criteria
  * @param isRange Is Range
  * @param name Name
  * @param seqNo Seq No
  * @param browseId Browse ID
  * @param referenceValueId Reference Value ID
  * @param isMandatory Is Mandatory
  * @param axisColumnId Axis Column ID
  * @param axisParentColumnId Axis Parent Column ID
  * @param isReadOnly Is Read Only
  * @param sortNo Sort No
  * @param isOrderBy Is Order By
  * @param valRuleId Val Rule ID
  * @param defaultValue Default Value
  * @param defaultValue2 Default Value 2
  * @param displayLogic Display Logic
  * @param fieldLength Field Length
  * @param readOnlyLogic Read Only Logic
  * @param vFormat V Format
  * @param valueMax Value Max
  * @param valueMin Value Min
  * @param callout Call Out
  * @param infoFactoryClass Info Factory Class
  * @param seqNoGrid Seq No Grid
  * @param isInfoOnly Is Info Only
  * @param uuid UUID
  */

case class BrowseField(browseFieldId: Int,
                       tenantId: Int,
                       organizationId: Int,
                       created: DateTime =  DateTime.now,
                       createdBy: Int,
                       isActive: Boolean = true,
                       updated: DateTime =  DateTime.now,
                       updatedBy: Int,
                       elementId: Int,
                       referenceId: Int,
                       viewColumnId: Int,
                       description: Option[String],
                       entityType: String,
                       help: Option[String],
                       isCentrallyMaintained: Boolean = true,
                       isDisplayed: Boolean = true,
                       isIdentifier: Option[Boolean],
                       isKey: Option[Boolean],
                       isQueryCriteria: Boolean = false,
                       isRange: Option[Boolean],
                       name: String,
                       seqNo: Option[Int],
                       browseId: Int,
                       referenceValueId: Option[Int],
                       isMandatory: Boolean = false,
                       axisColumnId: Option[Int],
                       axisParentColumnId: Option[Int],
                       isReadOnly: Boolean = true,
                       sortNo: Option[Int],
                       isOrderBy: Boolean = false,
                       valRuleId: Option[Int],
                       defaultValue: Option[String],
                       defaultValue2: Option[String],
                       displayLogic: Option[String],
                       fieldLength: Option[Int],
                       readOnlyLogic: Option[String],
                       vFormat: Option[String],
                       valueMax: Option[String],
                       valueMin: Option[String],
                       callout: Option[String],
                       infoFactoryClass: Option[String],
                       seqNoGrid: Int = 0,
                       isInfoOnly: Boolean = false,
                       uuid: Option[String]
                      ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = browseFieldId

  override val entityName: String = "AD_Browse_Field"
  override val identifier: String = "AD_Browse_Field_ID"
}

object BrowseField  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[BrowseField]
  def create(browseFieldId: Int,
             tenantId: Int,
             organizationId: Int,
             created: DateTime,
             createdBy: Int,
             isActive: Boolean,
             updated: DateTime,
             updatedBy: Int,
             elementId: Int,
             referenceId: Int,
             viewColumnId: Int,
             description: String,
             entityType: String,
             help: String,
             isCentrallyMaintained: Boolean,
             isDisplayed: Boolean,
             isIdentifier: Boolean,
             isKey: Boolean,
             isQueryCriteria: Boolean,
             isRange: Boolean,
             name: String,
             seqNo: Int,
             browseId: Int,
             referenceValueId: Int,
             isMandatory: Boolean,
             axisColumnId: Int,
             axisParentColumnId: Int,
             isReadOnly: Boolean,
             sortNo: Int,
             isOrderBy: Boolean,
             valRuleId: Int,
             defaultValue: String,
             defaultValue2: String,
             displayLogic: String,
             fieldLength: Int,
             readOnlyLogic: String,
             vFormat: String,
             valueMax: String,
             valueMin: String,
             callout: String,
             infoFactoryClass: String,
             seqNoGrid: Int,
             isInfoOnly: Boolean,
             uuid: String) = BrowseField(browseFieldId, tenantId, organizationId, created, createdBy, isActive,
    updated, updatedBy, elementId, referenceId, viewColumnId, None,entityType, None, isCentrallyMaintained,
    isDisplayed, None, None, isQueryCriteria, None, name, None, browseId, None, isMandatory, None, None,
    isReadOnly, None, isOrderBy, None, None, None, None, None, None, None, None, None, None, None,
    seqNoGrid, isInfoOnly, None)
}
