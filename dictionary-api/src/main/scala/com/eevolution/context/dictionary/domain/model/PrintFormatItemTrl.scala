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
  * Print Format Item Trl Entity
  * @param printFormatItemTrlId Print Format Item Trl ID
  * @param language Language
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param printName Print Name
  * @param isTranslated Is Translated
  * @param printNameSuffix Print Name Suffix
  * @param uuid UUID
  */
case class PrintFormatItemTrl (printFormatItemTrlId: Int,
                               language: String,
                               tenantId: Int,
                               organizationId: Int,
                               isActive: Boolean = true,
                               created: DateTime = DateTime.now,
                               createdBy: Int,
                               updated: DateTime = DateTime.now,
                               updatedBy: Int,
                               printName: Option[String],
                               isTranslated : Boolean = false,
                               printNameSuffix: Option[String],
                               uuid: Option[String]
                              ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = printFormatItemTrlId

  override val entityName: String = "AD_PrintFormatItemTrlId"
  override val identifier: String = "AD_PrintFormatItemTrlId_ID"

}

object PrintFormatItemTrl {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PrintFormatItemTrl]
  def create(printFormatItemTrlId: Int,
             language: String,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             printName: String,
             isTranslated : Boolean,
             printNameSuffix: String,
             uuid: String) = PrintFormatItemTrl(printFormatItemTrlId, language, tenantId, organizationId, isActive,
    created, createdBy, updated, updatedBy, None, isTranslated, None, None)
}