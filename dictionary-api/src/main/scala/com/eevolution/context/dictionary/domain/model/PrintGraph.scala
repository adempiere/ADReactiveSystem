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
  * Print Graph Entity
  * @param printGraphId Print Graph ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param description Descrption
  * @param graphType Graph Type
  * @param descriptionPrintFormatItemId Description Print Format Item ID
  * @param dataPrintFormatItemID Data Print Format Item ID
  * @param data1PrintFormatItemID Data 1 Print Format Item ID
  * @param data2PrintFormatItemID Data 2 Print Format Item ID
  * @param data3PrintFormatItemID Data 3 Print Format Item ID
  * @param data4PrintFormatItemID Data 4 Print Format Item ID
  * @param printFormatId Print Format ID
  * @param uuId UU ID
  */

case class PrintGraph (printGraphId: Int,
                       tenantId: Int,
                       organizationId: Int,
                       isActive: Boolean = true,
                       created: DateTime = DateTime.now,
                       createdBy: Int,
                       updated: DateTime = DateTime.now,
                       updatedBy: Int,
                       name: String,
                       description: Option[String],
                       graphType: Boolean,
                       descriptionPrintFormatItemId: Int,
                       dataPrintFormatItemID: Int,
                       data1PrintFormatItemID: Option[Int],
                       data2PrintFormatItemID: Option[Int],
                       data3PrintFormatItemID: Option[Int],
                       data4PrintFormatItemID: Option[Int],
                       printFormatId: Int,
                       uuId: Option[String]
                      ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = printGraphId

  override val entityName: String = "AD_PrintGraph"
  override val identifier: String = "AD_PrintGraph_ID"

}

object PrintGraph {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PrintGraph]
  def create(printGraphId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             description: String,
             graphType: Boolean,
             descriptionPrintFormatItemId: Int,
             dataPrintFormatItemID: Int,
             data1PrintFormatItemID: Int,
             data2PrintFormatItemID: Int,
             data3PrintFormatItemID: Int,
             data4PrintFormatItemID: Int,
             printFormatId: Int,
             uuId: String) = PrintGraph(printFormatId, tenantId, organizationId, isActive, created, createdBy, updated,
    updatedBy, name, None, graphType, descriptionPrintFormatItemId, dataPrintFormatItemID, None, None, None, None,
    printFormatId, None)
}
