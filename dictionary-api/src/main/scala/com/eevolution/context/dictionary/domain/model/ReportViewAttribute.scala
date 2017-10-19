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
  * Created by eduardo.moreno@e-evolution.com , www.e-evolution.com
  */
/**
  * Report View Attribute Entity
  * @param reportViewAttributeId Report View Attribute ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param reportViewId Report View ID
  * @param attributeId Attribute ID
  * @param functionAttributeId Function Attribute ID
  * @param isGroupFunction Is Group Function
  * @param uuid UUID
  */

case class ReportViewAttribute (reportViewAttributeId: Int,
                                tenantId: Int,
                                organizationId: Int,
                                isActive : Boolean = true,
                                created : DateTime = DateTime.now,
                                createdBy : Int ,
                                updated : DateTime = DateTime.now,
                                updatedBy : Int,
                                reportViewId: Int,
                                attributeId: Option[Int],
                                functionAttributeId: Option[String],
                                isGroupFunction: Boolean = false,
                                uuid: String
                               ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = reportViewAttributeId

  override val entityName: String = "AD_ReportView_Col"
  override val identifier: String = "AD_ReportView_Col_ID"
}

object ReportViewAttribute  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[ReportViewAttribute]
  def create(reportViewAttributeId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive : Boolean = true,
             created : DateTime = DateTime.now,
             createdBy : Int ,
             updated : DateTime = DateTime.now,
             updatedBy : Int,
             reportViewId: Int,
             attributeId: Option[Int],
             functionAttributeId: Option[String],
             isGroupFunction: Boolean = false,
             uuid: String) = ReportViewAttribute(reportViewAttributeId, tenantId, organizationId, isActive,
    created, createdBy, updated, updatedBy, reportViewId, None, None,isGroupFunction, uuid)
}