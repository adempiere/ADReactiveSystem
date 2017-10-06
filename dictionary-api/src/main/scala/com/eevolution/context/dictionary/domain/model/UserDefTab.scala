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
  */

/**
  * User Def Tab Entity
  * @param userDefTabId user Def Tab ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param userDefWinId user Def Win ID
  * @param tabId Tab ID
  * @param isMultiRowOnly Is Multi Row Only
  * @param name Name
  * @param description Description
  * @param help Help
  * @param isReadOnly Is Read Only
  * @param isSingleRow Is Single Row
  * @param uuid UUID
  */

case class UserDefTab(userDefTabId : Int ,
                      tenantId: Int,
                      organizationId : Int,
                      isActive : Boolean = true,
                      created : DateTime = DateTime.now,
                      createdBy : Int ,
                      updated :Int ,
                      updatedBy : DateTime = DateTime.now,
                      userDefWinId: Int,
                      tabId: Int,
                      isMultiRowOnly: Boolean = false,
                      name: String,
                      description : Option[String],
                      help: Option[String],
                      isReadOnly: Boolean = false,
                      isSingleRow: Boolean = false,
                      uuid: Option[String]
                     ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = userDefTabId

  override val entityName: String = "AD_UserDef_Tab"
  override val identifier: String = "AD_UserDef_Tab_ID"
}

object UserDefTab  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[UserDefTab]
  def create(userDefTabId : Int ,
             tenantId: Int,
             organizationId : Int,
             isActive : Boolean ,
             created : DateTime ,
             createdBy : Int ,
             updated :Int ,
             updatedBy : DateTime,
             userDefWinId: Int,
             tabId: Int,
             isMultiRowOnly: Boolean,
             name: String,
             description : String,
             help: String,
             isReadOnly: Boolean ,
             isSingleRow: Boolean ,
             uuid: String) = UserDefTab(userDefTabId, tenantId, organizationId, isActive, created, createdBy, updated,
    updatedBy, userDefWinId, tabId, isMultiRowOnly, name, None, None, isReadOnly, isSingleRow, None)
}





