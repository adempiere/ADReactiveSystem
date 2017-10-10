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
  * Attribute Entity
  * @param attributeId Attribute ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param description Description
  * @param help Help
  * @param version Version
  * @param entityType Entity Type
  * @param columnName Column Name
  * @param entityId Entity ID
  * @param referenceId Reference ID
  * @param referenceValueId Reference Value ID
  * @param valueRuleId Value Rule ID
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
  * @param isSelectionColumn Is Selection Column
  * @param elementId Element ID
  * @param processId Process ID
  * @param isSyncDatabase Is Sync Database
  * @param isAlwaysUpdateAble Is Always Update Able
  * @param columnSQL Column SQL
  * @param mandatoryLogic Mandatory Logic
  * @param infoFactoryClass Info Factory Class
  * @param isAutoComplete Is Auto Complete
  * @param isAllowLogging Is Allow Logging
  * @param formatPattern Format Pattern
  * @param chartId Char ID
  * @param isRange Is Range
  */

case class Attribute(attributeId: Int,
                     tenantId: Int,
                     organizationId: Int,
                     isActive : Boolean = true,
                     created : DateTime= DateTime.now,
                     createdBy : Int ,
                     updated : DateTime = DateTime.now,
                     updatedBy : Int,
                     name : String,
                     description: Option[String],
                     help: Option[String],
                     version : BigDecimal = 0,
                     entityType: String = EntityType.Dictionary,
                     columnName: String ,
                     entityId : Int,
                     referenceId : Int,
                     referenceValueId : Option[Int],
                     valueRuleId : Option[Int],
                     fieldLength : Int = 0 ,
                     defaultValue : Option[String],
                     isKey : Boolean = false,
                     isParent : Boolean = false,
                     isMandatory : Boolean = false,
                     isUpdateAble : Boolean = true,
                     readOnlyLogic : Option[String],
                     isIdentifier : Boolean = false ,
                     seqNo : Option[Int],
                     isTranslated : Boolean = false ,
                     isEncrypted : Boolean = false ,
                     callOut : Option[String],
                     vFormat : Option[String] ,
                     valueMin : Option[String] ,
                     valueMax : Option[String] ,
                     isSelectionColumn : Boolean = false,
                     elementId : Int,
                     processId : Int,
                     isSyncDatabase : Boolean =  false,
                     isAlwaysUpdateAble : Boolean = false ,
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
             tenantId: Int,
             organizationId: Int,
             isActive : Boolean ,
             created : DateTime ,
             createdBy : Int ,
             updated : DateTime ,
             updatedBy : Int,
             name : String,
             description : String,
             help: String,
             version : BigDecimal ,
             entityType: String ,
             columnName: String ,
             entityId : Int,
             referenceId : Int,
             referenceValueId : Int ,
             valueRuleId : Int,
             fieldLength : Int ,
             defaultValue : String,
             isKey : Boolean ,
             isParent : Boolean ,
             isMandatory : Boolean ,
             isUpdateAble : Boolean ,
             readOnlyLogic : String ,
             isIdentifier : Boolean ,
             seqNo : Int,
             isTranslated : Boolean = false ,
             isEncrypted : Boolean = false ,
             callOut : String,
             vFormat : String ,
             valueMin : String ,
             valueMax : String ,
             isSelectionColumn : Boolean,
             elementId : Int,
             processId : Int,
             isSyncDatabase : Boolean ,
             isAlwaysUpdateAble : Boolean  ,
             columnSQL : String,
             mandatoryLogic : String,
             infoFactoryClass : String,
             isAutoComplete : Boolean = false ,
             isAllowLogging : Boolean = true,
             formatPattern : String ,
             chartId : Int,
             isRange : Boolean) = Attribute(attributeId, tenantId, organizationId, isActive,created,createdBy,updated,
    updatedBy , name , None , None , version, entityType , columnName , elementId , referenceId, None , None ,
    fieldLength , None , isKey , isParent , isMandatory , isUpdateAble , None , isIdentifier , None ,
    isTranslated , isEncrypted , None , None , None , None , isSelectionColumn , elementId ,
    processId , isSyncDatabase , isAlwaysUpdateAble , None , None , None, isAutoComplete ,
    isAllowLogging , None , None , isRange)
}

