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
  * Recent Item Entity
  * @param recentItemId Recent Item ID
  * @param roleId Role ID
  * @param tabId Tab ID
  * @param entityId Table ID
  * @param userId User ID
  * @param windowId Window ID
  * @param created Created
  * @param createdBy Created By
  * @param isActive Is Active
  * @param recordId Record ID
  * @param updated Updated
  * @param updatedBy Updated By
  * @param menuId Menu ID
  * @param uuid UUID
  */

case class RecentItem(recentItemId: Int,
                      tenantId: Int,
                      organizationId: Int,
                      roleId: Int,
                      tabId: Option[Int],
                      entityId: Option[Int],
                      userId: Option[Int],
                      windowId: Option[Int],
                      created: DateTime = DateTime.now,
                      createdBy: Int,
                      isActive: Boolean = true,
                      recordId: Option[Int],
                      updated: DateTime = DateTime.now,
                      updatedBy: Int,
                      menuId: Option[Int],
                      uuid: Option[String]
                     ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = recentItemId

  override val entityName: String = "AD_RecentItem"
  override val identifier: String = "AD_RecentItem_ID"
}

object RecentItem {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[RecentItem]
  def create(recentItemId: Int,
             tenantId: Int,
             organizationId: Int,
             roleId: Int,
             tabId: Int,
             entityId: Int,
             userId: Int,
             windowId: Int,
             created: DateTime,
             createdBy: Int,
             isActive: Boolean,
             recordId: Int,
             updated: DateTime,
             updatedBy: Int,
             menuId: Int,
             uuid: String) = RecentItem(recentItemId, tenantId, organizationId, roleId, None, None, None,
    None, created, createdBy, isActive, None, updated, updatedBy, None, None)
}

