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
  * Email: emeris.hernandez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com
  * Modify by victor.perez@e-evolution.com , www.e-evolution.com
  */

/**
  * User Def Win Entity
  * @param userDefiendWindowId User Def Win ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated by
  * @param roleId Role ID
  * @param userId User Id
  * @param windowId Window ID
  * @param name Name
  * @param description Description
  * @param help Help
  * @param language Language
  * @param isDefault Is Default
  * @param isReadOnly Is Read Only
  * @param isUserUpdateable is User Updated Able
  * @param uuid UUID
  */

case class UserDefiendWindow(userDefiendWindowId : Int,
                             tenantId: Int,
                             organizationId : Int = 0,
                             isActive : Boolean = true,
                             created : DateTime = DateTime.now,
                             createdBy : Int,
                             updated : DateTime = DateTime.now,
                             updatedBy : Int,
                             roleId: Option[Int],
                             userId: Option[Int],
                             windowId: Int,
                             name: String,
                             description: Option[String],
                             help: Option[String],
                             language: Option[String],
                             isDefault: Boolean = false,
                             isReadOnly: Boolean = false,
                             isUserUpdateable: Boolean = true,
                             uuid: Option[String]
                     ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = userDefiendWindowId

  override val entityName: String = "AD_UserDef_Win"
  override val identifier: String = "AD_UserDef_Win_ID"
}

object UserDefiendWindow  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[UserDefiendWindow]
  def create(userDefinedWindowId : Int,
             tenantId: Int,
             organizationId : Int,
             isActive : Boolean,
             created : DateTime,
             createdBy : Int,
             updated : DateTime,
             updatedBy : Int,
             roleId: Int,
             userId: Int,
             windowId: Int,
             name: String,
             description: String,
             help: String,
             language: String,
             isDefault: Boolean,
             isReadOnly: Boolean,
             isUserUpdateable: Boolean,
             uuid: String) = UserDefiendWindow(userDefinedWindowId, tenantId, organizationId, isActive, created, createdBy,
    updated, updatedBy, None, None, windowId, name, None, None, None, isDefault,
    isReadOnly, isUserUpdateable, None)
}





