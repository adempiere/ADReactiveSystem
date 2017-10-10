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
  * View Column Entity
  * @param viewColumnId View Column ID
  * @param created Created
  * @param createdBy Created By
  * @param isActive Is Active
  * @param updated Updated
  * @param updatedBy Updated By
  * @param viewDefinitionId View Definition ID
  * @param description Description
  * @param entityType Entity Type
  * @param help Help
  * @param name Name
  * @param columnSql Column SQL
  * @param columnName Column Name
  * @param viewId View ID
  * @param columnId Column ID
  * @param uuid UUID
  */

case class ViewColumn(viewColumnId: Int,
                      created: DateTime = DateTime.now,
                      createdBy: Int,
                      isActive: Boolean,
                      updated: DateTime = DateTime.now,
                      updatedBy: Int,
                      viewDefinitionId: Option[Int],
                      description: Option[String],
                      entityType: String =  "D",
                      help: Option[String],
                      name: String,
                      columnSql: Option[String],
                      columnName: Option[String],
                      viewId: Option[Int],
                      columnId: Option[Int],
                      uuid: Option[String]
                     ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = viewColumnId

  override val entityName: String = "AD_ViewColumn"
  override val identifier: String = "AD_ViewColumn_ID"
}

object ViewColumn  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[ViewColumn]
  def create(viewColumnId: Int,
             created: DateTime,
             createdBy: Int,
             isActive: Boolean,
             updated: DateTime,
             updatedBy: Int,
             viewDefinitionId: Int,
             description: String,
             entityType: String,
             help: String,
             name: String,
             columnSql: String,
             columnName: String,
             viewId: Int,
             columnId: Int,
             uuid: String) = ViewColumn(viewColumnId, created, createdBy, isActive, updated, updatedBy,
    None, None, entityType, None, name, None, None, None, None, None)
}

