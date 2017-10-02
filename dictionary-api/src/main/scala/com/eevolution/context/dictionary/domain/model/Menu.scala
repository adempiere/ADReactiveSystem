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

case class Menu(menuId: Int,
           isActive: Boolean = true,
           created: DateTime =  DateTime.now,
           createdBy: Int,
           updated: DateTime =  DateTime.now,
           name: String,
           updatedBy: Int,
           description: Option[String],
           isSummary: Boolean = false,
           isSotrx: Boolean = true,
           isReadOnly: Boolean = false,
           action: Option[Boolean],
           windowId: Option[Int],
           workFlowId: Option[Int],
           taskId: Option[Int],
           processId: Option[Int],
           formId: Option[Int],
           workbenchId: Option[Int],
           entityType: String = "D",
           isCentrallyMaintained: Boolean = true,
           browseId: Option[Int],
           uuId: Option[String]
          ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
    override type ActiveEnabled = this.type
    override type Identifiable = this.type
    override type Traceable = this.type

    override def Id: Int = menuId

    override val entityName: String = "AD_Menu"
    override val identifier: String = "AD_Menu_ID"
}

object Menu {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Menu]
  def create(menuId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             name: String,
             updatedBy: Int,
             description: String,
             isSummary: Boolean,
             isSotrx: Boolean,
             isReadOnly: Boolean,
             action: Boolean,
             windowId: Int,
             workFlowId: Int,
             taskId: Int,
             processId:Int,
             formId: Int,
             workbenchId: Int,
             entityType: String,
             isCentrallyMaintained: Boolean,
             browseId: Int,
             uuId: String) = Menu (menuId,isActive, created, createdBy, updated,
    name, updatedBy,None, isSummary, isSotrx, isReadOnly,
    None, None, None, None, None, None, None, entityType, isCentrallyMaintained, None, None)
}