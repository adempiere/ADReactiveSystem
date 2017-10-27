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
  * Email: eduardo.moreno@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by eduardo.moreno@e-evolution.com , www.e-evolution.com.
  * Modified by emeris.hernandez@e-evolution.com, www.e-evolution.com on 12/10/17.
  */
/**
  * Search Definition Entity
  * @param searchDefinitionId Search Definition ID
  * @param tenantId Tenant ID
  * @param attributeId Attribute ID
  * @param organizationId Organization ID
  * @param entityId Entity ID
  * @param windowId Window ID
  * @param created Created
  * @param createdBy Created By
  * @param dataType CData Type
  * @param description Description
  * @param isActive Is Active
  * @param name Name
  * @param query Query
  * @param searchType Search Type
  * @param transactionCode Transaction Code
  * @param updated Updated
  * @param updatedBy Updated By
  * @param poWindowId Po Window ID
  * @param isDefault Is Default
  * @param uuid UU ID
  */

case class SearchDefinition (searchDefinitionId: Int,
                             tenantId: Int,
                             attributeId: Option[Int],
                             organizationId: Int,
                             entityId: Int,
                             windowId: Int,
                             created: DateTime = DateTime.now,
                             createdBy: Int,
                             dataType: Boolean,
                             description: Option[String],
                             isActive: Boolean = true,
                             name: Option[String],
                             query: Option[String],
                             searchType: Boolean,
                             transactionCode: Option[String],
                             updated : DateTime = DateTime.now ,
                             updatedBy : Int,
                             poWindowId:Option[Int],
                             isDefault: Boolean = false,
                             uuid: String
                            ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = searchDefinitionId

  override val entityName: String = "AD_SearchDefinition"
  override val identifier: String = "AD_SearchDefinition_ID"

}

object SearchDefinition {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[SearchDefinition]
  def create(searchDefinitionId: Int,
             tenantId: Int,
             attributeId: Int,
             organizationId: Int,
             entityId: Int,
             windowId: Int,
             created: DateTime,
             createdBy: Int,
             dataType: Boolean,
             description: Option[String],
             isActive: Boolean,
             name: String,
             query: String,
             searchType: Boolean,
             transactionCode: String,
             updated :DateTime,
             updatedBy : Int,
             poWindowId:Int,
             isDefault: Boolean,
             uuid: String) = SearchDefinition(searchDefinitionId, tenantId, None, organizationId, entityId, windowId,
    updated, updatedBy, dataType, None, isActive, None, None, searchType, None, updated, updatedBy, None, isDefault, uuid)
}
