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
  * Workbench Entity
  * @param workbenchId Workbench ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param description Description
  * @param help Help
  * @param columnId Column ID
  * @param imageId Image ID
  * @param colorId Color ID
  * @param entityType Entity Type
  * @param uuId UU ID
  */

case class Workbench(workbenchId: Int,
                     isActive: Boolean = true,
                     created: DateTime = DateTime.now,
                     createdBy: Int,
                     updated: DateTime = DateTime.now,
                     updatedBy: Int,
                     name: String,
                     description: Option[String],
                     help: Option[String],
                     columnId: Int,
                     imageId: Option[Int],
                     colorId: Option[Int],
                     entityType: String = "D",
                     uuId: Option[String]
                    ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = workbenchId

  override val entityName: String = "AD_Workbench"
  override val identifier: String = "AD_Workbench_ID"
}


object Workbench {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Workbench]
  def create(workbenchId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             description: String,
             help: String,
             columnId: Int,
             imageId: Int,
             colorId: Int,
             entityType: String,
             uuId: String) = Workbench(workbenchId, isActive, created, createdBy, updated, updatedBy,
    name, None, None, columnId, None, None, entityType, None)
}
