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
  * View Definition Entity
  * @param viewDefinitionId View Definition ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param created Created
  * @param createdBy Created By
  * @param isActive Is Active
  * @param updated Updated
  * @param updatedBy Updated By
  * @param viewId View ID
  * @param seqNo Seq No
  * @param tableId Table ID
  * @param tableAlias Table Alias
  * @param joinClause Join Clause
  * @param processing Processing
  * @param uuid UUID
  */

case class ViewDefinition(viewDefinitionId: Int,
                          tenantId: Int,
                          organizationId : Int ,
                          created: DateTime = DateTime.now,
                          createdBy: Int,
                          isActive: Boolean,
                          updated: DateTime = DateTime.now,
                          updatedBy: Int,
                          viewId: Option[Int],
                          seqNo: Option[Int],
                          tableId: Option[Int],
                          tableAlias: String,
                          joinClause: Option[String],
                          processing: Option[Boolean],
                          uuid: String
                         ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = viewDefinitionId

  override val entityName: String = "AD_View_Definition"
  override val identifier: String = "AD_View_Definition_ID"
}

object ViewDefinition  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[ViewDefinition]
  def create(viewDefinitionId: Int,
             tenantId: Int,
             organizationId : Int ,
             created: DateTime,
             createdBy: Int,
             isActive: Boolean,
             updated: DateTime,
             updatedBy: Int,
             viewId: Int,
             seqNo: Int,
             tableId: Int,
             tableAlias: String,
             joinClause: String,
             processing: Boolean,
             uuid: String) = ViewDefinition(viewDefinitionId, tenantId, organizationId, created, createdBy,
    isActive, updated, updatedBy, None, None, None, tableAlias, None, None, uuid)
}
