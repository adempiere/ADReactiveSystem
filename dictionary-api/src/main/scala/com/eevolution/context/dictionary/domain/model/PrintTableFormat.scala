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
  * Print Table Format Entity
  * @param printTableFormatId Print Table Format ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param hdrPrintFontId Hdr Print Font ID
  * @param hdrTextFgPrintColorId Hdr Text Fg Print Color ID
  * @param hdrTextBgPrintColorId Hdr Text Bg Print Color ID
  * @param hdrLinePrintColorId Hdr Line Print Color ID
  * @param functPrintFontId Funct Print Font ID
  * @param functBgPrintColorId Funct Bg Print Color ID
  * @param functFgPrintColorId Funct Fg Print Color ID
  * @param linePrintColorId Line Print Color ID
  * @param description Description
  * @param isPaintBoundaryLines Is Paint Boundary Lines
  * @param isPaintHLines Is Paint H Line
  * @param isPaintVLines Is Paint V Line
  * @param isPrintFunctionSymbols Is Print Function Symbols
  * @param name Name
  * @param isDefault Is Default
  * @param imageUrl Image URL
  * @param headerLeft Header Left
  * @param headerCenter Header Center
  * @param headerRight Header Right
  * @param footerLeft Footer Left
  * @param footerCenter Footer Center
  * @param footerRight Footer Right
  * @param imageIsAttached Image Is Attached
  * @param hdrStroke Hdr Stroke
  * @param lineStroke Line Stroke
  * @param hdrStrokeType Hdr Stroke Type
  * @param lineStrokeType Line Stroke
  * @param isPaintHeaderLines Is Paint Header Lines
  * @param imageId Image ID
  * @param isMultiLineHeader Is Multi Line Header
  * @param uuid UUID
  */

case class PrintTableFormat (printTableFormatId: Int,
                             tenantId: Int,
                             organizationId: Int,
                             isActive: Boolean = true,
                             created: DateTime = DateTime.now,
                             createdBy: Int,
                             updated: DateTime = DateTime.now,
                             updatedBy: Int,
                             hdrPrintFontId: Option[Int],
                             hdrTextFgPrintColorId: Option[Int],
                             hdrTextBgPrintColorId: Option[Int],
                             hdrLinePrintColorId: Option[Int],
                             functPrintFontId: Option[Int],
                             functBgPrintColorId: Option[Int],
                             functFgPrintColorId: Option[Int],
                             linePrintColorId: Option[Int],
                             description: Option[String],
                             isPaintBoundaryLines: Boolean = false,
                             isPaintHLines: Boolean = false,
                             isPaintVLines: Boolean = false,
                             isPrintFunctionSymbols: Boolean = true,
                             name: String,
                             isDefault: Boolean = false,
                             imageUrl: Option[String],
                             headerLeft: Option[String],
                             headerCenter: Option[String],
                             headerRight: Option[String],
                             footerLeft: Option[String],
                             footerCenter: Option[String],
                             footerRight: Option[String],
                             imageIsAttached: Boolean = false,
                             hdrStroke: Option[Int],
                             lineStroke: Option[Int],
                             hdrStrokeType: Option[Boolean],
                             lineStrokeType: Option[Boolean],
                             isPaintHeaderLines: Boolean = true,
                             imageId: Option[Int],
                             isMultiLineHeader: Boolean = false,
                             uuid: Option[String]
                            ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = printTableFormatId

  override val entityName: String = "AD_PrintTableFormat"
  override val identifier: String = "AD_PrintTableFormat_ID"

}

object PrintTableFormat {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PrintTableFormat]
  def create(printTableFormatId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             hdrPrintFontId: Int,
             hdrTextFgPrintColorId: Int,
             hdrTextBgPrintColorId: Int,
             hdrLinePrintColorId: Int,
             functPrintFontId: Int,
             functBgPrintColorId: Int,
             functFgPrintColorId: Int,
             linePrintColorId: Int,
             description: String,
             isPaintBoundaryLines: Boolean,
             isPaintHLines: Boolean,
             isPaintVLines: Boolean,
             isPrintFunctionSymbols: Boolean,
             name: String,
             isDefault: Boolean,
             imageUrl: String,
             headerLeft: String,
             headerCenter: String,
             headerRight: String,
             footerLeft: String,
             footerCenter: String,
             footerRight: String,
             imageIsAttached: Boolean,
             hdrStroke: Int,
             lineStroke: Int,
             hdrStrokeType: Boolean,
             lineStrokeType: Boolean,
             isPaintHeaderLines: Boolean,
             imageId: Int,
             isMultiLineHeader: Boolean,
             uuid: String) = PrintTableFormat(printTableFormatId, tenantId, organizationId, isActive, created,
    createdBy, updated, updatedBy, None, None, None, None, None, None, None, None, None, isPaintBoundaryLines,
    isPaintHLines, isPaintVLines, isPrintFunctionSymbols, name, isDefault, None, None, None, None, None, None, None,
    imageIsAttached, None, None, None, None, isPaintHeaderLines, None,isMultiLineHeader, None)
}

