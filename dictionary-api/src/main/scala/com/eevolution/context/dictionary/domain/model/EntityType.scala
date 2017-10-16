package com.eevolution.context.dictionary.domain.model


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
  * Modified by emeris.hernandez@e-evolution.com , www.e-evolution.com on 13/10/17.
  */
case class EntityType(entityTypeId: Int,
                      tenantId: Int,
                      organizationId: Int,
                      entityType: String = EntityType.Dictionary,
                      isActive: Boolean = true,
                      created: DateTime =  DateTime.now,
                      createdBy: Int,
                      updated: DateTime =  DateTime.now,
                      updatedBy: Int ,
                      name: String,
                      description: Option[String],
                      help: Option[String],
                      version: Option[String],
                      modelPackage: Option[String],
                      classPath: Option[String],
                      processing: Boolean = false
                     ) extends DomainModel
  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = entityTypeId

  override val entityName: String = "AD_EntityType"
  override val identifier: String = "AD_EntityType_ID"
}

object EntityType {
  def Dictionary: String = "D"
}