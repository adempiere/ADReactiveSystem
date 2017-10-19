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
  * User Def Tab Entity
  * @param userDefinedTabId user Defined Tab ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param userDefinedWindowId user Defined Win ID
  * @param tabId Tab ID
  * @param isMultiRowOnly Is Multi Row Only
  * @param name Name
  * @param description Description
  * @param help Help
  * @param isReadOnly Is Read Only
  * @param isSingleRow Is Single Row
  * @param uuid UUID
  */

case class UserDefinedTab(userDefinedTabId : Int,
                          tenantId: Int,
                          organizationId : Int,
                          isActive : Boolean = true,
                          created : DateTime = DateTime.now,
                          createdBy : Int,
                          updated : DateTime = DateTime.now,
                          updatedBy : Int,
                          userDefinedWindowId: Int,
                          tabId: Int,
                          isMultiRowOnly: Boolean = false,
                          name: String,
                          description : Option[String],
                          help: Option[String],
                          isReadOnly: Boolean = false,
                          isSingleRow: Boolean = false,
                          uuid: String
                     ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = userDefinedTabId

  override val entityName: String = "AD_UserDef_Tab"
  override val identifier: String = "AD_UserDef_Tab_ID"
}

object UserDefinedTab  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[UserDefinedTab]
  def create(userDefinedTabId : Int,
             tenantId: Int,
             organizationId : Int,
             isActive : Boolean,
             created : DateTime,
             createdBy : Int,
             updated : DateTime,
             updatedBy : Int,
             userDefiendWindowId: Int,
             tabId: Int,
             isMultiRowOnly: Boolean,
             name: String,
             description : String,
             help: String,
             isReadOnly: Boolean,
             isSingleRow: Boolean,
             uuid: String) = UserDefinedTab(userDefinedTabId, tenantId, organizationId, isActive, created,
    createdBy, updated, updatedBy, userDefiendWindowId, tabId, isMultiRowOnly, name, None, None, isReadOnly,
    isSingleRow, uuid)
}





