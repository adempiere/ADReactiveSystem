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
  * Print Label Entity
  * @param printLabelId Print Label ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param description Description
  * @param tableId Table ID
  * @param printerName Printer Name
  * @param isLandscape Is LandsCape
  * @param labelHeight Label Height
  * @param labelWidth Label Width
  * @param labelPrinterId Label Printer ID
  * @param uuid UUID
  */

case class PrintLabel (printLabelId: Int,
                       tenantId: Int,
                       organizationId: Int,
                       isActive: Boolean = true,
                       created: DateTime = DateTime.now,
                       createdBy: Int,
                       updated: DateTime = DateTime.now,
                       updatedBy: Int,
                       name: String,
                       description: Option[String],
                       tableId: Int,
                       printerName: Option[String],
                       isLandscape: Boolean = true,
                       labelHeight: Int,
                       labelWidth: Int,
                       labelPrinterId: Int,
                       uuid: Option[String]
                      ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = printLabelId

  override val entityName: String = "AD_PrintLabel"
  override val identifier: String = "AD_PrintLabel_ID"

}

object PrintLabel {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PrintLabel]
  def create(printLabelId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             description: String,
             tableId: Int,
             printerName: String,
             isLandscape: Boolean,
             labelHeight: Int,
             labelWidth: Int,
             labelPrinterId: Int,
             uuid: String) = PrintLabel(printLabelId, tenantId, organizationId, isActive, created, createdBy, updated,
    updatedBy, name, None, tableId, None, isLandscape, labelHeight, labelWidth, labelPrinterId, None)
}
