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
  * Modify by victor.perez@e-evolution.com , www.e-evolution.com
  */

/**
  * User Defined Field Entity
  * @param userDefinedFieldId User Defined Field ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param userDefinedTabId User Defined Tab ID
  * @param fieldId Field ID
  * @param name Name
  * @param description Description
  * @param help Help
  * @param isDisplayed Is Displayed
  * @param isReadOnly Is Read Only
  * @param isSameLine Is Same Line
  * @param isUpdateAble Is Update Able
  * @param displayLength Display Length
  * @param displayLogic Display Logic
  * @param defaultValue Default Value
  * @param sortNo Sort No
  * @param seqNo Seq No
  * @param uuid UUID
  */

case class UserDefinedField(userDefinedFieldId: Int,
                            tenantId: Int,
                            organizationId: Int,
                            isActive: Boolean = true,
                            created: DateTime = DateTime.now,
                            createdBy: Int,
                            updated: DateTime = DateTime.now,
                            updatedBy: Int,
                            userDefinedTabId: Int,
                            fieldId: Int,
                            name: String,
                            description: Option[String],
                            help: Option[String],
                            isDisplayed: Boolean = true,
                            isReadOnly: Boolean = false,
                            isSameLine: Boolean = false,
                            isUpdateAble: Boolean = true,
                            displayLength: Int = 0,
                            displayLogic: String,
                            defaultValue: String,
                            sortNo: Int = 0,
                            seqNo: Int = 0,
                            uuid: Option[String]
                       )extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = userDefinedFieldId

  override val entityName: String = "AD_UserDef_Field"
  override val identifier: String = "AD_UserDef_Field_ID"
}

object UserDefinedField  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[UserDefinedField]
  def create(userDefinedFieldId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             userDefinedTabId: Int,
             fieldId: Int,
             name: String,
             description: String,
             help: String,
             isDisplayed: Boolean,
             isReadOnly: Boolean,
             isSameLine: Boolean,
             isUpdateAble: Boolean,
             displayLength: Int,
             displayLogic: String,
             defaultValue: String,
             sortNo: Int,
             seqNo: Int,
             uuid: String) = UserDefinedField(userDefinedFieldId, tenantId, organizationId, isActive, created, createdBy,
    updated, updatedBy, userDefinedTabId, fieldId, name, None, None, isDisplayed, isReadOnly, isSameLine, isUpdateAble,
    displayLength, displayLogic, defaultValue, sortNo, seqNo, None)
}
