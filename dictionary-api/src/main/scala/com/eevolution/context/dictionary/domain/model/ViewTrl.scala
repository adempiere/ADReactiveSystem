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
  * View Trl Entity
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param created Created
  * @param createdBy Created By
  * @param isActive Is Active
  * @param updated Updated
  * @param updatedBy Updated By
  * @param viewId View ID
  * @param language Language
  * @param description Description
  * @param isTranslated Is Translated
  * @param name Name
  * @param help Help
  * @param uuid UUID
  */

case class ViewTrl(tenantId: Int,
                   organizationId:Int,
                   created: DateTime = DateTime.now,
                   createdBy: Int,
                   isActive: Boolean,
                   updated: DateTime = DateTime.now,
                   updatedBy: Int,
                   viewId: Int,
                   language: String,
                   description: Option[String],
                   isTranslated: Boolean,
                   name: String,
                   help : Option[String],
                   uuid: String
             ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = 0

  override val entityName: String = "AD_View_Trl"
  override val identifier: String = null
}

object ViewTrl  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[ViewTrl]
  def create(tenantId: Int,
             organizationId:Int,
             created: DateTime,
             createdBy: Int,
             isActive: Boolean,
             updated: DateTime,
             updatedBy: Int,
             viewId: Int,
             language: String,
             description: String,
             isTranslated: Boolean,
             name: String,
             help : String,
             uuid: String) = ViewTrl(tenantId, organizationId, created, createdBy, isActive, updated, updatedBy,
    viewId, language, None, isTranslated, name, None, uuid)
}


