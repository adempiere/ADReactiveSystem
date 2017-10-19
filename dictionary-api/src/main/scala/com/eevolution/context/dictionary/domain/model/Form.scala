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
  * Modified by emeris.hernandez@e-evolution.com, www.e-evolution.com on 10/10/17.
  */

/**
  * Form Entity
  * @param formId Form ID
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
  * @param className Class Name
  * @param entityType Entity Type
  * @param isBetaFunctionality Is Beta Functionality
  * @param jspUrl JSP URL
  * @param uuid UUID
  */

case class Form (formId: Int,
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
                 accessLevel : String,
                 className : Option[String] ,
                 entityType: String = EntityType.Dictionary,
                 isBetaFunctionality : Boolean = false ,
                 jspUrl : Option[String],
                 uuid: String
                 ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = formId

  override val entityName: String = "AD_Form"
  override val identifier: String = "AD_Form_ID"
}

object Form  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Form]
  def create(formId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive : Boolean ,
             created : DateTime ,
             createdBy : Int ,
             updated :DateTime ,
             updatedBy : Int ,
             name : String,
             description: String,
             help: String,
             accessLevel : String,
             className : String ,
             entityType: String,
             isBetaFunctionality : Boolean ,
             jspUrl : String,
             uuid: String) = Form(formId, tenantId, organizationId, isActive, created, createdBy, updated, updatedBy,
    name, None, None, accessLevel, None, entityType, isBetaFunctionality, None, uuid)
}






