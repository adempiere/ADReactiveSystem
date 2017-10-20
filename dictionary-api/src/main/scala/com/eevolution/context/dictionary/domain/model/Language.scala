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
  * Language Entity
  * @param languageId Language ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param languageISO Language ISO
  * @param countryCode Country Code
  * @param isBaseLanguage is Base Language
  * @param isSystemLanguage Is System Language
  * @param processing Processing
  * @param language Language
  * @param isDecimalPoint Is Decimal Point
  * @param datePattern Date Pattern
  * @param timePattern Time Pattern
  * @param uuid UUID
  */

case class Language(languageId: Int,
                    tenantId : Int ,
                    organizationId : Int,
                    isActive: Boolean = true,
                    created: DateTime =  DateTime.now,
                    createdBy: Int,
                    updated: DateTime =  DateTime.now,
                    updatedBy: Int,
                    name: String,
                    languageISO: Option[String],
                    countryCode: Option[String],
                    isBaseLanguage: Boolean = false,
                    isSystemLanguage: Boolean = false,
                    processing: Option[Boolean],
                    language: String,
                    isDecimalPoint: Boolean = true,
                    datePattern: Option[String],
                    timePattern: Option[String],
                    uuid: String
                   ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
    override type ActiveEnabled = this.type
    override type Identifiable = this.type
    override type Traceable = this.type

    override def Id: Int = languageId

    override val entityName: String = "AD_Language"
    override val identifier: String = "AD_Language_ID"
}

object Language {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Language]
  def create(languageId: Int,
             tenantId : Int ,
             organizationId : Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             languageISO: String,
             countryCode: String,
             isBaseLanguage: Boolean,
             isSystemLanguage: Boolean,
             processing: Boolean,
             language: String,
             isDecimalPoint: Boolean,
             datePattern: String,
             timePattern: String,
             uuid: String) = Language(languageId, tenantId, organizationId, isActive, created, createdBy, updated,
    updatedBy, name, None, None, isBaseLanguage, isSystemLanguage, None, language, isDecimalPoint, None, None, uuid)
}


