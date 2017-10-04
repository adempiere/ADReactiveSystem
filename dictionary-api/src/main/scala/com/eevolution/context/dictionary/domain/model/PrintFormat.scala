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
  * Print Format Entity
  * @param printFormatId Print Format ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param description Description
  * @param isTableBased Is Table Based
  * @param isForm Is Form
  * @param tableId Table ID
  * @param printPaperId Print Paper ID
  * @param printColorId Print Color ID
  * @param printFontId Print Font ID
  * @param isStandardHeaderFooter Is Standard Header Footer
  * @param headerMargin Header Margin
  * @param footerMargin Footer Margin
  * @param createCopy Create Copy
  * @param reportViewId Report View ID
  * @param printTableFormatId Print Table Format ID
  * @param printerName Print Name
  * @param isDefault Is Default
  * @param jasperProcessId Jasper Process ID
  * @param className Class Name
  * @param args Args
  * @param isSummary Is Summary
  * @param isPrintParameters Is Print Parameters
  * @param uuId UU ID
  */
case class PrintFormat (printFormatId: Int,
                        isActive: Boolean = true,
                        created: DateTime = DateTime.now,
                        createdBy: Int,
                        updated: DateTime = DateTime.now,
                        updatedBy: Int,
                        name: String,
                        description: Option[String],
                        isTableBased: Boolean = true,
                        isForm: Boolean = false,
                        tableId: Int,
                        printPaperId: Int,
                        printColorId: Int,
                        printFontId: Int,
                        isStandardHeaderFooter: Boolean = true,
                        headerMargin: Int,
                        footerMargin: Int,
                        createCopy: Option[Boolean],
                        reportViewId: Option[Int],
                        printTableFormatId: Option[Int],
                        printerName: Option[String],
                        isDefault: Boolean = false,
                        jasperProcessId: Option[Int],
                        className: Option[String],
                        args: Option[String],
                        isSummary: Boolean = false,
                        isPrintParameters: Boolean = true,
                        uuId: Option[String]
                       ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = printFormatId

  override val entityName: String = "AD_PrintFormat"
  override val identifier: String = "AD_PrintFormat_ID"

}

object PrintFormat {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PrintFormat]
  def create(printFormatId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             description: String,
             isTableBased: Boolean,
             isForm: Boolean,
             tableId: Int,
             printPaperId: Int,
             printColorId: Int,
             printFontId: Int,
             isStandardHeaderFooter: Boolean,
             headerMargin: Int,
             footerMargin: Int,
             createCopy: Boolean,
             reportViewId: Int,
             printTableFormatId: Int,
             printerName: String,
             isDefault: Boolean,
             jasperProcessId: Int,
             className: String,
             args: String,
             isSummary: Boolean,
             isPrintParameters: Boolean,
             uuId: String) = PrintFormat(printFormatId, isActive, created, createdBy, updated, updatedBy, name,
    None, isTableBased, isForm, tableId, printPaperId, printColorId, printFontId, isStandardHeaderFooter, headerMargin,
    footerMargin, None, None, None, None, isDefault, None, None, None, isSummary, isPrintParameters, None)
}