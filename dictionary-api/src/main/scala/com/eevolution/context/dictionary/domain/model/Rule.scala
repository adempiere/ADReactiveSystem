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
  * Modified by emeris.hernandez@e-evolution.com , www.e-evolution.com on 13/10/2017.
  */

/**
  * Rule Entity
  * @param ruleId Rule ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param accessLevel Access Level
  * @param created Created
  * @param createdBy Created By
  * @param description Description
  * @param entityType Entity Type
  * @param eventType Event Type
  * @param help  Help
  * @param isActive Is Active
  * @param name Name
  * @param ruleType Rule Type
  * @param updated Updated
  * @param updatedBy Updated By
  * @param value  Value
  * @param script Script
  * @param uuid UUID
  */

case class Rule (ruleId: Int,
                 tenantId : Int,
                 organizationId : Int,
                 accessLevel : Option[String] ,
                 created : DateTime = DateTime.now(),
                 createdBy : Int ,
                 description: Option[String],
                 entityType: String =  EntityType.Dictionary ,
                 eventType : String ,
                 help: Option[String],
                 isActive : Boolean = true,
                 name: String,
                 ruleType : String ,
                 updated : DateTime = DateTime.now,
                 updatedBy :Int,
                 value: String,
                 script : Option[String],
                 uuid: String
                ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = ruleId

  override val entityName: String = "AD_Rule"
  override val identifier: String = "AD_Rule_ID"
}

object Rule  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Rule]
  def create(ruleId: Int,
             tenantId : Int,
             organizationId : Int,
             accessLevel : String,
             created : DateTime,
             createdBy : Int ,
             description: String,
             entityType: String,
             eventType : String ,
             help: String,
             isActive : Boolean,
             name: String,
             ruleType : String,
             updated : DateTime = DateTime.now,
             updatedBy :Int,
             value: String,
             script : String,
             uuid: String) = Rule(ruleId, tenantId, organizationId, None, created, createdBy, None,
    entityType, eventType, None, isActive, name,ruleType, updated, updatedBy, value, None, uuid)
}

