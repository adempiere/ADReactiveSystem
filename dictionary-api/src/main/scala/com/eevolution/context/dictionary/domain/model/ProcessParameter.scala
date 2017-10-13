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
  * Created by victor.perez@e-evolution.com , www.e-evolution.com on 18/02/17.
  * Modified by emeris.hernandez@e-evolution.com, www.e-evolution.com on 12/10/2017.
  */
/**
  * Process Parameter ID
  * @param processParameterId Process Parameter ID
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
  * @param accessLevel Access Level
  * @param processId Process ID
  * @param seqNo Seq No
  * @param referenceId Reference ID
  * @param referenceValueId Reference Value ID
  * @param validationRuleId Validation Rule ID
  * @param columnName Column Name
  * @param isCentrallyMaintained Is Centrally Maintained
  * @param fieldLength Field Length
  * @param isMandatory Is Mandatory
  * @param isRange Is Range
  * @param defaultValue Default Value
  * @param defaultValue2 Default Value 2
  * @param vFormat V Format
  * @param valueMin Value Min
  * @param valueMax Value Max
  * @param elementId Element ID
  * @param entityType Entity Type
  * @param readOnlyLogic Read Only Logic
  * @param displayLogic Display Logic
  * @param isInfoOnly Is Info Only
  * @param uuid UUID
  */

case class ProcessParameter (processParameterId: Int,
                             tenantId: Int,
                             organizationId: Int,
                             isActive : Boolean = true,
                             created : DateTime = DateTime.now,
                             createdBy : Int ,
                             updated : DateTime = DateTime.now,
                             updatedBy : Int,
                             name : String,
                             description: Option[String],
                             help: Option[String],
                             accessLevel : String = "3",
                             processId : Option[Int],
                             seqNo : Int = 0 ,
                             referenceId : Option[Int] ,
                             referenceValueId  : Option[Int] ,
                             validationRuleId : Option[Int] ,
                             columnName : String ,
                             isCentrallyMaintained : Boolean = false ,
                             fieldLength : Option[Int],
                             isMandatory : Boolean = false ,
                             isRange :  Boolean = false ,
                             defaultValue : Option[String],
                             defaultValue2 : Option[String] ,
                             vFormat : Option[String],
                             valueMin : Option[String],
                             valueMax : Option[String],
                             elementId : Option[Int],
                             entityType: String = EntityType.Dictionary,
                             readOnlyLogic : Option[String],
                             displayLogic : Option[String],
                             isInfoOnly : Boolean = false,
                             uuid: Option[String]
                            ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = processParameterId

  override val entityName: String = "AD_Process_Para"
  override val identifier: String = "AD_Process_Para_ID"
}

object ProcessParameter  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[ProcessParameter]
  def create(processParameterId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive : Boolean,
             created : DateTime,
             createdBy : Int ,
             updated : DateTime,
             updatedBy : Int,
             name : String,
             description: String,
             help: String,
             accessLevel : String,
             processId : Int,
             seqNo : Int,
             referenceId : Int,
             referenceValueId  : Int,
             validationRuleId : Int,
             columnName : String,
             isCentrallyMaintained : Boolean,
             fieldLength : Int,
             isMandatory : Boolean,
             isRange :  Boolean,
             defaultValue : String,
             defaultValue2 : String,
             vFormat : String,
             valueMin : String,
             valueMax : String,
             elementId : Int,
             entityType: String,
             readOnlyLogic : String,
             displayLogic : String,
             isInfoOnly : Boolean,
             uuid: String) = ProcessParameter(processParameterId, tenantId, organizationId, isActive, created,
    createdBy, updated, updatedBy, name, None, None, accessLevel, None, seqNo, None, None, None, columnName,
    isCentrallyMaintained, None, isMandatory, isRange, None, None, None, None, None, None, entityType, None,
    None, isInfoOnly, None)
}

