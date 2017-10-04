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
  * Print Label Line Entity
  * @param printLabelLineId Print Label Line ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param printLabelId Print Label ID
  * @param name Name
  * @param seqNo Seq No
  * @param labelFormatType Label Format Type
  * @param printName Print Name
  * @param columnId Column ID
  * @param labelPrinterFunctionId Label Printer Function ID
  * @param xPosition X Position
  * @param yPosition Y Position
  * @param uuId UU ID
  */

case class PrintLabelLine (printLabelLineId: Int,
                           isActive: Boolean = true,
                           created: DateTime = DateTime.now,
                           createdBy: Int,
                           updated: DateTime = DateTime.now,
                           updatedBy: Int,
                           printLabelId: Int,
                           name: String,
                           seqNo: Int,
                           labelFormatType: Boolean,
                           printName: Option[String],
                           columnId: Int,
                           labelPrinterFunctionId: Int,
                           xPosition: Int,
                           yPosition: Int,
                           uuId: Option[String]
                          ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = printLabelLineId

  override val entityName: String = "AD_PrintLabelLine"
  override val identifier: String = "AD_PrintGLabelLine_ID"

}

object PrintLabelLine {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PrintLabelLine]
  def create(printLabelLineId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             printLabelId: Int,
             name: String,
             seqNo: Int,
             labelFormatType: Boolean,
             printName: String,
             columnId: Int,
             labelPrinterFunctionId: Int,
             xPosition: Int,
             yPosition: Int,
             uuId: String) = PrintLabelLine(printLabelLineId, isActive, created, createdBy, updated, updatedBy,
    printLabelId, name, seqNo, labelFormatType, None, columnId, labelPrinterFunctionId, xPosition, yPosition, None)
}
