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
  * Modified by emeris.hernandez@e-evolution.com, www.e-evolution.com on 12/10/17.
  */

/**
  * Entity for Model Validator
  * @param modelValidatorId
  * @param isActive
  * @param created
  * @param createdBy
  * @param updated
  * @param updatedBy
  * @param name
  * @param description
  * @param help
  * @param entityType
  * @param modelValidationClass
  * @param seqNo
  */

case class ModelValidator (modelValidatorId: Int,
                           tenantId: Int,
                           organizationId: Int,
                           created : DateTime = DateTime.now,
                           createdBy : Int ,
                           updated : DateTime = DateTime.now,
                           updatedBy : Int,
                           isActive : Boolean = true,
                           name : String,
                           description: Option[String],
                           help: Option[String],
                           entityType: String = EntityType.Dictionary,
                           modelValidationClass : Option[String],
                           seqNo : Int,
                           uuid: Option[String]
                          ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = modelValidatorId

  override val entityName: String = "AD_ModelValidator"
  override val identifier: String = "AD_ModelValidator_ID"
}

object ModelValidator  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[ModelValidator]
  def create(modelValidatorId: Int,
             tenantId: Int,
             organizationId: Int,
             created : DateTime,
             createdBy : Int ,
             updated : DateTime,
             updatedBy : Int,
             isActive : Boolean,
             name : String,
             description: String,
             help: String,
             entityType: String,
             modelValidationClass : String,
             seqNo : Int,
             uuid: String) = ModelValidator(modelValidatorId, tenantId, organizationId, created, createdBy, updated,
    updatedBy, isActive, name, None, None, entityType, None, seqNo, None)
}

