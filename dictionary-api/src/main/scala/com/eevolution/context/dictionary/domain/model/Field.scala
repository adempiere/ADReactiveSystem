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
  * Field Entity
  * @param fieldId Field Id
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
  * @param isCentrallyMaintained Is Centrally Maintained
  * @param tabId Tab ID
  * @param columnId Column ID
  * @param fieldGroup Field Group
  * @param isDisplayed Is Displayed
  * @param displayLogic Displayed Logic
  * @param displayLength Displayed Length
  * @param isReadOnly Is Read Only
  * @param seqNo Seq No
  * @param sortNo Sort No
  * @param isSameLine Is Same Line
  * @param isHeading Is Heading
  * @param isFieldOnly Is Field Only
  * @param isEncrypted Is Encrypted
  * @param entityType Entity Type
  * @param obscureType Obscure Type
  * @param referenceId Reference ID
  * @param isMandatory Is Mandatory
  * @param includedTabId Include Tab ID
  * @param defaultValue Default Value
  * @param referenceValueId Reference Value ID
  * @param valRuleId Val Rule ID
  * @param infoFactoryClass Info Factory Class
  * @param isEmbedded Is Embedded
  * @param preferredWidth Preferred Width
  * @param isDisplayedGrid Is Displayed Grid
  * @param seqNoGrid Seq No Grid
  * @param isAllowCopy Is Allow Copy
  * @param uuId UU ID
  */
case class Field (fieldId: Int,
                  tenantId: Int,
                  organizationId: Int,
                  isActive: Boolean = true,
                  created: DateTime = DateTime.now(),
                  createdBy: Int,
                  updated: DateTime = DateTime.now(),
                  updatedBy: Int,
                  name: String,
                  description: Option[String],
                  help: Option[String],
                  isCentrallyMaintained: Boolean = true,
                  tabId: Int,
                  columnId: Option[Int],
                  fieldGroup: Option[Int],
                  isDisplayed: Boolean = true,
                  displayLogic: Option[String],
                  displayLength: Option[Int],
                  isReadOnly: Boolean = false,
                  seqNo: Option[Int],
                  sortNo: Option[Int],
                  isSameLine: Boolean = false,
                  isHeading: Boolean = false,
                  isFieldOnly: Boolean = false,
                  isEncrypted: Boolean = false,
                  entityType: String = "D",
                  obscureType: Option[String],
                  referenceId: Option[Int],
                  isMandatory: Option[Boolean],
                  includedTabId: Option[Int],
                  defaultValue: Option[String],
                  referenceValueId: Option[Int],
                  valRuleId: Option[Int],
                  infoFactoryClass: Option[String],
                  isEmbedded: Boolean = false,
                  preferredWidth: Option[Int],
                  isDisplayedGrid: Boolean = true,
                  seqNoGrid: Option[Int],
                  isAllowCopy: Boolean = true,
                  uuId: Option[String]
                 ) extends DomainModel
  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = fieldId

  override val entityName: String = "AD_Field"
  override val identifier: String = "AD_Field_ID"

}

object Field {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Field]
  def create(fieldId: Int,
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
             isCentrallyMaintained: Boolean,
             tabId: Int,
             columnId: Int,
             fieldGroup: Int,
             isDisplayed: Boolean,
             displayLogic: String,
             displayLength: Int,
             isReadOnly: Boolean,
             seqNo: Int,
             sortNo: Int,
             isSameLine: Boolean,
             isHeading: Boolean,
             isFieldOnly: Boolean,
             isEncrypted: Boolean,
             entityType: String,
             obscureType: String,
             referenceId: Int,
             isMandatory: Boolean,
             includedTabId: Int,
             defaultValue: String,
             referenceValueId: Int,
             valRuleId: Int,
             infoFactoryClass: String,
             isEmbedded: Boolean,
             preferredWidth: Int,
             isDisplayedGrid: Boolean,
             seqNoGrid: Int,
             isAllowCopy: Boolean,
             uuId: String) = Field(fieldId, tenantId, organizationId, isActive, created, createdBy, updated, updatedBy,
    name, None, None, isCentrallyMaintained, tabId, None, None, isDisplayed, None, None, isReadOnly, None, None,
    isSameLine, isHeading, isFieldOnly, isEncrypted, entityType, None, None, None, None, None, None, None, None,
    isEmbedded, None, isDisplayedGrid, None, isAllowCopy, None)
}