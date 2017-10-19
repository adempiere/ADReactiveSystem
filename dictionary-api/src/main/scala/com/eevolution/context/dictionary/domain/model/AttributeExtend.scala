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
  * Email: victor.perez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by victor.perez@e-evolution.com , www.e-evolution.com.
  * Modified by emeris.hernandez@e-evolution.com , www.e-evolution.com.
  */

/**
  * Attribute Extend Entity
  * @param attributeExtendId Attribute Extend ID
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
  * @param referenceId Reference ID
  * @param referenceValueId Reference Value ID
  * @param validationRuleId Validation Rule ID
  * @param callout Call Out
  * @param valueMin Value Min
  * @param valueMax Value Max
  * @param defaultValue Default Value
  * @param isReadOnly Is Read Only
  * @param isUpdateable Is Update Able
  * @param isMandatory Is Mandatory
  * @param isEncrypted Is Encrypted
  * @param fieldLength Field Length
  * @param displayLength Display Length
  * @param displayLogic Display Logic
  * @param vFormat V Format
  * @param isSameLine Is Same Line
  * @param isHeading Is Heading
  * @param isFieldOnly Is Field Only
  * @param seqNo Seq No
  * @param uuid UUID
  */


case class AttributeExtend(attributeExtendId: Int,
                           tenantId: Int,
                           organizationId: Int,
                           isActive : Boolean = true,
                           created : DateTime= DateTime.now,
                           createdBy : Int,
                           updated : DateTime = DateTime.now,
                           updatedBy : Int,
                           name : String,
                           description: Option[String],
                           help: Option[String],
                           entityId: Int,
                           referenceId: Int,
                           referenceValueId: Option[Int],
                           validationRuleId: Option[Int],
                           callout: Option[String],
                           valueMin: Option[String],
                           valueMax: Option[String],
                           defaultValue: Option[String],
                           isReadOnly: Boolean = false,
                           isUpdateable: Boolean =true,
                           isMandatory: Boolean = false,
                           isEncrypted: Boolean = false,
                           fieldLength: Option[Int],
                           displayLength: Option[Int],
                           displayLogic: Option[String],
                           vFormat: Option[String],
                           isSameLine: Boolean = false,
                           isHeading: Boolean = false,
                           isFieldOnly: Boolean = false,
                           seqNo: Option[Int],
                           uuid: String
                 ) extends DomainModel
  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = attributeExtendId

  override val entityName: String = "AD_Attribute"
  override val identifier: String = "AD_Attribute_ID"
}

object AttributeExtend {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[AttributeExtend]
  def create(attributeExtendId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive : Boolean,
             created : DateTime,
             createdBy : Int,
             updated : DateTime,
             updatedBy : Int,
             name : String,
             description: String,
             help: String,
             entityId: Int,
             referenceId: Int,
             referenceValueId: Int,
             validationRuleId: Int,
             callout: String,
             valueMin: String,
             valueMax: String,
             defaultValue: String,
             isReadOnly: Boolean,
             isUpdateable: Boolean,
             isMandatory: Boolean,
             isEncrypted: Boolean,
             fieldLength: Int,
             displayLength: Int,
             displayLogic: String,
             vFormat: String,
             isSameLine: Boolean,
             isHeading: Boolean,
             isFieldOnly: Boolean,
             seqNo: Int,
             uuid: String) = AttributeExtend(attributeExtendId, tenantId, organizationId, isActive, created,
    createdBy, updated, updatedBy, name, None, None, entityId, referenceId, None, None, None, None, None,
    None, isReadOnly, isUpdateable, isMandatory, isEncrypted, None, None, None, None, isSameLine, isHeading,
    isFieldOnly, None, uuid)
}

