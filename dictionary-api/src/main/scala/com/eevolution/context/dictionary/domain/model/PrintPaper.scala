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
  * Print Paper Entity
  * @param printPaperId Print Paper ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param description Description
  * @param isDefault Is Default
  * @param isLandscape Is Landscape
  * @param code Code
  * @param marginTop Margin Top
  * @param marginLeft Margin Left
  * @param marginRight Margin Right
  * @param marginBottom Margin Bottom
  * @param processing Processing
  * @param sizeX Size X
  * @param sizeY Size Y
  * @param dimensionUnits Dimension Units
  * @param uuid UUID
  */

case class PrintPaper (printPaperId: Int,
                       tenantId: Int,
                       organizationId: Int,
                       isActive: Boolean = true,
                       created: DateTime = DateTime.now,
                       createdBy: Int,
                       updated: DateTime = DateTime.now,
                       updatedBy: Int,
                       name: String,
                       description: Option[String],
                       isDefault: Boolean = false,
                       isLandscape: Boolean = true,
                       code: String,
                       marginTop: Int,
                       marginLeft: Int,
                       marginRight: Int,
                       marginBottom: Int,
                       processing: Option[Boolean],
                       sizeX: Option[Int],
                       sizeY: Option[Int],
                       dimensionUnits: Option[Boolean],
                       uuid: Option[String]
                      ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = printPaperId

  override val entityName: String = "AD_PrintPaper"
  override val identifier: String = "AD_PrintPaper_ID"

}

object PrintPaper {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PrintPaper]
  def create(printPaperId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             description: String,
             isDefault: Boolean,
             isLandscape: Boolean,
             code: String,
             marginTop: Int,
             marginLeft: Int,
             marginRight: Int,
             marginBottom: Int,
             processing: Boolean,
             sizeX: Int,
             sizeY: Int,
             dimensionUnits: Boolean,
             uuid: String) = PrintPaper(printPaperId, tenantId, organizationId, isActive, created, createdBy, updated,
    updatedBy, name, None, isDefault, isLandscape, code, marginTop, marginLeft, marginRight, marginBottom, None, None,
    None, None, None)
}
