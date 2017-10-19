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
  * Print Format Item Entity
  * @param printFormatItemId Print Format Item ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param printFormatId Print Format ID
  * @param name Name
  * @param printName Print Name
  * @param isPrinted Is Printed
  * @param printAreaType Print Area Type
  * @param seqNo Seq No
  * @param printFormatType Print Format Type
  * @param attributeId Attribute ID
  * @param printFormatChildIs Print Format Child Is
  * @param isRelativePosition Is Relative Position
  * @param isNextLine Is Next Line
  * @param xSpace X Space
  * @param ySpace Y Space
  * @param xPosition X Position
  * @param yPosition Y Position
  * @param maxWidth Max Width
  * @param isHeightOneLine Is Height One Line
  * @param maxHeight Max Height
  * @param fieldAlignmentType Field Alignment Type
  * @param lineAlignmentType Line Alignment Type
  * @param printColorId Print Color ID
  * @param printFontId Print Font ID
  * @param isOrderBy Is Order By
  * @param sortNo Sort No
  * @param isGroupBy Is Group By
  * @param isPageBrake Is Page Brake
  * @param isSummarized Is Summarized
  * @param imageIsAttached Image Is Attached
  * @param imageUrl Image URL
  * @param isAveraged Is Averaged
  * @param isCounted Is Counted
  * @param isSetNlPosition Is Set N L Position
  * @param isSuppressNull Is Suppress Null
  * @param belowAttribute Below Attribute
  * @param printGraphId Print Graph ID
  * @param isFixedWidth Is Fixed Width
  * @param isNextPage Is Next Page
  * @param printNameSuffix Print Name Suffix
  * @param isMinCalc Is Min Calc
  * @param isMaxCalc Is Max Calc
  * @param isRunningTotal Is Running Total
  * @param runningTotalLines Running Total Lines
  * @param isVarianceCalc Is Variance Calc
  * @param isDeviationCalc Is Deviation Calc
  * @param isFilledRectangle Is Filled Rectangle
  * @param lineWidth Line Width
  * @param arcDiameter Arc Diameter
  * @param shapeType Shape Type
  * @param isCentrallyMaintained Is Centrally Maintained
  * @param isImageField Is Image Field
  * @param barcodeType Barcode Type
  * @param formatPattern Format Pattern
  * @param isSuppressRepeats Is Suppress Repeats
  * @param isDesc Is Desc
  * @param isPrintBarcodeText Is Print Barcode Text
  * @param displayLogic Display Logic
  * @param uuid UUID
  */
case class PrintFormatItem (printFormatItemId: Int,
                            tenantId: Int,
                            organizationId: Int,
                            isActive: Boolean = true,
                            created: DateTime = DateTime.now,
                            createdBy: Int,
                            updated: DateTime = DateTime.now,
                            updatedBy: Int,
                            printFormatId: Int,
                            name: String,
                            printName: Option[String],
                            isPrinted: Boolean = true,
                            printAreaType: Boolean,
                            seqNo: Int,
                            printFormatType: Boolean,
                            attributeId: Option[Int],
                            printFormatChildIs: Option[Int],
                            isRelativePosition: Boolean = true,
                            isNextLine: Boolean = true,
                            xSpace: Int,
                            ySpace: Int,
                            xPosition: Int,
                            yPosition: Int,
                            maxWidth: Int,
                            isHeightOneLine: Boolean = true,
                            maxHeight: Int,
                            fieldAlignmentType: Boolean,
                            lineAlignmentType: Boolean,
                            printColorId: Option[Int],
                            printFontId: Option[Int],
                            isOrderBy: Boolean = false,
                            sortNo: Int,
                            isGroupBy: Boolean = false,
                            isPageBrake: Boolean = false,
                            isSummarized: Boolean = false,
                            imageIsAttached: Boolean = false,
                            imageUrl: Option[String],
                            isAveraged: Boolean = false,
                            isCounted: Boolean = false,
                            isSetNlPosition: Boolean = false,
                            isSuppressNull: Boolean = false,
                            belowAttribute: Option[Int],
                            printGraphId: Option[Int],
                            isFixedWidth: Boolean = false,
                            isNextPage: Boolean = false,
                            printNameSuffix: Option[String],
                            isMinCalc: Boolean = false,
                            isMaxCalc: Boolean = false,
                            isRunningTotal: Boolean = false,
                            runningTotalLines: Option[Int],
                            isVarianceCalc: Boolean = false,
                            isDeviationCalc: Boolean = false,
                            isFilledRectangle: Boolean = false,
                            lineWidth: Option[Int],
                            arcDiameter: Option[Int],
                            shapeType: Option[Boolean],
                            isCentrallyMaintained: Boolean = true,
                            isImageField: Boolean = false,
                            barcodeType: Option[String],
                            formatPattern: Option[String],
                            isSuppressRepeats: Boolean = false,
                            isDesc: Boolean = false,
                            isPrintBarcodeText: Boolean = true,
                            displayLogic: Option[String],
                            uuid: String
                           ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = printFormatItemId

  override val entityName: String = "AD_PrintFormatItem"
  override val identifier: String = "AD_PrintFormatItem_ID"

}

object PrintFormatItem {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PrintFormatItem]
  def create(printFormatItemId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             printFormatId: Int,
             name: String,
             printName: String,
             isPrinted: Boolean,
             printAreaType: Boolean,
             seqNo: Int,
             printFormatType: Boolean,
             attributeId: Int,
             printFormatChildIs: Int,
             isRelativePosition: Boolean,
             isNextLine: Boolean,
             xSpace: Int,
             ySpace: Int,
             xPosition: Int,
             yPosition: Int,
             maxWidth: Int,
             isHeightOneLine: Boolean,
             maxHeight: Int,
             fieldAlignmentType: Boolean,
             lineAlignmentType: Boolean,
             printColorId: Int,
             printFontId: Int,
             isOrderBy: Boolean,
             sortNo: Int,
             isGroupBy: Boolean,
             isPageBrake: Boolean,
             isSummarized: Boolean,
             imageIsAttached: Boolean,
             imageUrl: String,
             isAveraged: Boolean,
             isCounted: Boolean,
             isSetNlPosition: Boolean,
             isSuppressNull: Boolean,
             belowAttribute: Int,
             printGraphId: Int,
             isFixedWidth: Boolean,
             isNextPage: Boolean,
             printNameSuffix: String,
             isMinCalc: Boolean,
             isMaxCalc: Boolean,
             isRunningTotal: Boolean,
             runningTotalLines: Int,
             isVarianceCalc: Boolean,
             isDeviationCalc: Boolean,
             isFilledRectangle: Boolean,
             lineWidth: Int,
             arcDiameter: Int,
             shapeType: Boolean,
             isCentrallyMaintained: Boolean,
             isImageField: Boolean,
             barcodeType: String,
             formatPattern: String,
             isSuppressRepeats: Boolean,
             isDesc: Boolean,
             isPrintBarcodeText: Boolean,
             displayLogic: String,
             uuid: String) = PrintFormatItem(printFormatItemId, tenantId, organizationId, isActive, created, createdBy,
    updated, updatedBy, printFormatId, name, None,isPrinted, printAreaType, seqNo, printFormatType, None, None,
    isRelativePosition, isNextLine, xSpace, ySpace, xPosition, yPosition, maxWidth, isHeightOneLine, maxHeight,
    fieldAlignmentType, lineAlignmentType, None, None, isOrderBy, sortNo,isGroupBy, isPageBrake, isSummarized,
    imageIsAttached, None, isAveraged, isCounted, isSetNlPosition, isSuppressNull, None, None, isFixedWidth, isNextPage,
    None, isMinCalc, isMaxCalc, isRunningTotal, None, isVarianceCalc, isDeviationCalc, isFilledRectangle, None, None,
    None, isCentrallyMaintained, isImageField, None, None, isSuppressRepeats, isDesc, isPrintBarcodeText, None, uuid)
}