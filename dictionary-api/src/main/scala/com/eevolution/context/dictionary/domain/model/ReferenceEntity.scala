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
  * Modified by emeris.hernandez@e-evolution.com, www.e-evolution.com on 11/10/2017.
  */

/**
  * Entity for Reference Entity
  * @param referenceId Reference ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param entityId Entity ID
  * @param key Key
  * @param display Display
  * @param isValueDisplayed Is Value Displayed
  * @param whereClause Where Clause
  * @param orderByClause Order By Clause
  * @param entityType Entity Type
  * @param windowId Window ID
  * @param isAlert Is Alert
  * @param displaySQL Display SQL
  * @param isDisplayIdentifier Is Display Identifier
  * @param uuid UUID
  */

case class ReferenceEntity(referenceId: Int,
                           tenantId: Int,
                           organizationId: Int,
                           isActive : Boolean = true,
                           created : DateTime = DateTime.now,
                           createdBy : Int,
                           updated : DateTime = DateTime.now,
                           updatedBy : Int,
                           entityId : Int,
                           key :Int,
                           display : Int,
                           isValueDisplayed : Boolean = false,
                           whereClause : Option[String],
                           orderByClause : Option[String],
                           entityType : String = EntityType.Dictionary,
                           windowId :  Option[Int],
                           isAlert : Boolean =  false,
                           displaySQL : Option[String],
                           isDisplayIdentifier : Boolean =  false,
                           uuid: String
                          ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = referenceId

  override val entityName: String = "AD_Ref_Table"
  override val identifier: String = "AD_Reference_ID"
}

object ReferenceEntity  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[ReferenceEntity]
  def create(referenceId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive : Boolean,
             created : DateTime,
             createdBy : Int ,
             updated : DateTime,
             updatedBy : Int,
             entityId : Int ,
             key :Int ,
             display : Int ,
             isValueDisplayed : Boolean,
             whereClause : String,
             orderByClause : String ,
             entityType : String,
             windowId :  Int ,
             isAlert : Boolean,
             displaySQL : String,
             isDisplayIdentifier : Boolean,
             uuid: String) = ReferenceEntity(referenceId, tenantId, organizationId, isActive, created,
    createdBy, updated, updatedBy, entityId, key, display, isValueDisplayed, None, None, entityType,
    None, isAlert, None, isDisplayIdentifier, uuid)
}

