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
  * Report View Trl Entity
  * @param tenantId Tenant ID
  * @param language Language
  * @param organizationId Organization ID
  * @param reportViewId Report View ID
  * @param created Created
  * @param createdBy Created By
  * @param description DEscription
  * @param isActive Is Active
  * @param isTranslated Is Translated
  * @param name Name
  * @param printName Print Name
  * @param updated Updated
  * @param updatedBy Updated By
  * @param uuId UUID
  */

case class ReportViewTrl (tenantId: Int,
                          language: String,
                          organizationId: Int,
                          reportViewId: Int,
                          created : DateTime = DateTime.now,
                          createdBy : Int ,
                          description: Option[String],
                          isActive : Boolean = true,
                          isTranslated: Boolean = false,
                          name: Int,
                          printName: Option[String],
                          updated : DateTime = DateTime.now,
                          updatedBy : Int,
                          uuId: Option[String]
                         ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = 0

  override val entityName: String = "AD_ReportView_Trl"
  override val identifier: String = null
}

object ReportViewTrl  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[ReportViewTrl]
  def create(tenantId: Int,
             language: String,
             organizationId: Int,
             reportViewId: Int,
             created : DateTime,
             createdBy : Int ,
             description: String,
             isActive : Boolean,
             isTranslated: Boolean,
             name: Int,
             printName: String,
             updated : DateTime,
             updatedBy : Int,
             uuId: String) = ReportViewTrl(tenantId, language, organizationId, reportViewId, created, createdBy,
    None, isActive, isTranslated, name, None, updated, updatedBy, None)
}