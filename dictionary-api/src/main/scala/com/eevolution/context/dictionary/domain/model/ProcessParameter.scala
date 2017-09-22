package com.eevolution.context.dictionary.domain.model

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
  */

/**
  * Process Parameter Entity
  * @param processParameterId
  * @param isActive
  * @param created
  * @param createdBy
  * @param updated
  * @param updatedBy
  * @param name
  * @param description
  * @param help
  * @param accessLevel
  * @param entityType
  * @param processId
  * @param seqNo
  * @param referenceId
  * @param referenceValueId
  * @param validationRuleId
  * @param columnName
  * @param isCentrallyMaintained
  * @param fieldLength
  * @param isMandatory
  * @param isRange
  * @param defaultValue
  * @param defaultValue2
  * @param vFormat
  * @param valueMin
  * @param valueMax
  * @param elementId
  * @param readOnlyLogic
  * @param displayLogic
  * @param isInfoOnly
  */
case class ProcessParameter (processParameterId: Int,
                             isActive : Boolean = true,
                             created : DateTime = DateTime.now(),
                             createdBy : Int ,
                             updated :Int ,
                             updatedBy : DateTime = DateTime.now(),
                             name : String,
                             description: Option[String],
                             help: Option[String],
                             accessLevel : String = "3",
                             entityType: String = EntityType.Dictionary,
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
                             readOnlyLogic : Option[String],
                             displayLogic : Option[String],
                             isInfoOnly : Boolean = false) {

  def Identity = "AD_Process_Para_ID"

}
