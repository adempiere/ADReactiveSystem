package com.eevolution.context.dictionary.domain.model

import java.util.Date

import ai.x.play.json.Jsonx
import com.eevolution.context.dictionary.api.{ActiveEnabled, DomainModel, Identifiable, Traceable}
import org.joda.time.DateTime

/**
  * Copyright (C) 2003-2017, e-Evolution Consultants S.A. , http://www.e-evolution.com
  * This program is free software: you can redistribute it and/or modify
  * it under the terms of the GNU Affero General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU Affero General Public License for more details.
  * You should have received a copy of the GNU Affero General Public License
  * along with this program.  If not, see <http://www.gnu.org/licenses/>.
  * Email: victor.perez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by victor.perez@e-evolution.com , www.e-evolution.com
  */
case class Attribute(attributeId: Int,
                     isActive : Boolean = true,
                     created : Date = new Date,
                     createdBy : Int ,
                     updated : Date = new Date ,
                     updatedBy : Int,
                     name : String,
                     description: Option[String],
                     help: Option[String],
                     version : BigDecimal = 0,
                     entityType: String = EntityType.Dictionary,
                     columnName: String ,
                     entityId : Int,
                     referenceId : Int,
                     referenceValueiId : Option[Int],
                     valueRuleId : Option[Int],
                     fieldLength : Int = 0 ,
                     defaultValue : Option[String],
                     isKey : Boolean = false,
                     isParent : Boolean = false,
                     isMandatory : Boolean = false,
                     isUpdateable : Boolean = true,
                     readOnlyLogic : Option[String],
                     isIdentifier : Boolean = false ,
                     seqNo : Option[Int],
                     isTranslated : Boolean = false ,
                     isEncrypted : Boolean = false ,
                     callout : Option[String],
                     vformat : Option[String] ,
                     valueMin : Option[String] ,
                     valueMax : Option[String] ,
                     isSelectionColumn : Boolean = false,
                     elementId : Int,
                     processId : Int,
                     isSyncDatabase : Boolean =  false,
                     isAlwaysUpdateable : Boolean = false ,
                     columnSQL : Option[String],
                     mandatoryLogic : Option[String],
                     infoFactoryClass : Option[String],
                     isAutoComplete : Boolean = false ,
                     isAllowLogging : Boolean = true,
                     formatPattern : Option[String] ,
                     chartId : Option[Int],
                     isRange : Boolean = false
                 ) extends DomainModel
  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = attributeId

  override val entityName: String = "AD_Column"
  override val identifier: String = "AD_Column_ID"
}

object Attribute {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Attribute]
  def create(attributeId: Int,
             isActive : Boolean ,
             created : Date ,
             createdBy : Int ,
             updated : Date ,
             updatedBy : Int,
             name : String,
             description : String,
             help: String,
             version : BigDecimal ,
             entityType: String ,
             columnName: String ,
             entityId : Int,
             referenceId : Int,
             referenceValueiId : Int ,
             valueRuleId : Int,
             fieldLength : Int ,
             defaultValue : String,
             isKey : Boolean ,
             isParent : Boolean ,
             isMandatory : Boolean ,
             isUpdateable : Boolean ,
             readOnlyLogic : String ,
             isIdentifier : Boolean ,
             seqNo : Int,
             isTranslated : Boolean = false ,
             isEncrypted : Boolean = false ,
             callout : String,
             vformat : String ,
             valueMin : String ,
             valueMax : String ,
             isSelectionColumn : Boolean,
             elementId : Int,
             processId : Int,
             isSyncDatabase : Boolean ,
             isAlwaysUpdateable : Boolean  ,
             columnSQL : String,
             mandatoryLogic : String,
             infoFactoryClass : String,
             isAutoComplete : Boolean = false ,
             isAllowLogging : Boolean = true,
             formatPattern : String ,
             chartId : Int,
             isRange : Boolean) = Attribute(attributeId,isActive,created,createdBy,updated, updatedBy , name , None , None ,
    version, entityType , columnName , elementId , referenceId, None , None , fieldLength , None , isKey ,
    isParent , isMandatory , isUpdateable , None , isIdentifier , None , isTranslated , isEncrypted , None , None ,
    None , None , isSelectionColumn , elementId , processId , isSyncDatabase , isAlwaysUpdateable , None , None ,
    None, isAutoComplete , isAllowLogging , None , None , isRange)
}

