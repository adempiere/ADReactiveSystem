package com.eevolution.context.dictionary.domain.model

import org.joda.time.DateTime

import ai.x.play.json.Jsonx
import com.eevolution.context.dictionary.api.{ActiveEnabled, DomainModel, Identifiable, Traceable}

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
  * Email: emeris.hernandez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com
  */

/**
  * Desktop Entity
  * @param desktopId Desktop ID
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
  * @param imageId Image ID
  * @param colorId Color ID
  * @param uuid UUID
  */

case class Desktop(desktopId: Int,
                   tenantId: Int,
                   organizationId: Int,
                   isActive:Boolean=true,
                   created:DateTime = DateTime.now,
                   createdBy: Int,
                   updated: DateTime = DateTime.now,
                   updatedBy: Int,
                   name: String,
                   description: Option[String],
                   help: Option[String],
                   imageId: Option[Int],
                   colorId:Option[Int],
                   uuid: Option[String]
                  ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int =desktopId

  override val entityName: String = "AD_Desktop"
  override val identifier: String = "AD_Desktop_ID"
}

  object Desktop {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Desktop]
  def create(desktopId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive:Boolean,
             created:DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             description:String,
             help: String,
             imageId: Int,
             colorId:Int,
             uuid:String) = Desktop(desktopId, tenantId, organizationId, isActive,created, createdBy, updated,
    updatedBy, name, None, None, None, None, None)
}