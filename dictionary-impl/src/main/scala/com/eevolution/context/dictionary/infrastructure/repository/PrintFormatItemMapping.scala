package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.PrintFormatItem
import com.eevolution.context.dictionary.infrastructure.db.DbContext._

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
  * Print Format Item Mapping
  */
trait PrintFormatItemMapping  {
  val queryPrintFormatItem = quote {
    querySchema[PrintFormatItem]("AD_PrintFormatItem",
      _.printFormatItemId -> "AD_PrintFormatItem_ID",
      _.tenantId -> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.isActive -> "IsActive",
      _.created -> "Created",
      _.createdBy -> "CreatedBy",
      _.updated -> "Updated",
      _.updatedBy -> "UpdatedBy",
      _.printFormatId -> "AD_PrintFormat_ID",
      _.name -> "Name",
      _.printName -> "PrintName",
      _.isPrinted -> "IsPrinted",
      _.printAreaType -> "PrintAreaType",
      _.seqNo -> "SeqNo",
      _.printFormatType -> "PrintFormatType",
      _.attributeId -> "AD_Column_ID",
      _.printFormatChildId -> "AD_PrintFormatChild_ID",
      _.isRelativePosition -> "IsRelativePosition",
      _.isNextLine -> "IsNextLine",
      _.xSpace -> "XSpace",
      _.ySpace -> "YSpace",
      _.xPosition -> "XPosition",
      _.yPosition -> "YPosition",
      _.maxWidth -> "MaxWidth",
      _.isHeightOneLine -> "IsHeightOneLine",
      _.maxHeight -> "MaxHeight",
      _.fieldAlignmentType -> "FieldAlignmentType",
      _.lineAlignmentType -> "LineAlignmentType",
      _.printColorId -> "AD_PrintColor_ID",
      _.printFontId -> "AD_PrintFont_ID",
      _.isOrderBy -> "IsOrderBy",
      _.sortNo -> "SortNo",
      _.isGroupBy -> "IsGroupBy",
      _.isPageBrake -> "IsPageBrake",
      _.isSummarized -> "IsSummarized",
      _.imageIsAttached -> "ImageIsAttachment",
      _.imageUrl -> "ImageUrl",
      _.isAveraged -> "IsAveraged",
      _.isCounted -> "IsCounted",
      _.isSetNlPosition -> "IsSetNlPosition",
      _.isSuppressNull -> "IsSuppressNull",
      _.belowAttribute -> "BelowAttribute",
      _.printGraphId -> "AD_PrintGraph_ID",
      _.isFixedWidth -> "IsFixedWidth",
      _.isNextPage -> "IsNextPage",
      _.printNameSuffix -> "PrintNameSuffix",
      _.isMinCalc -> "IsMinCalc",
      _.isMaxCalc -> "IsMaxCalc",
      _.isRunningTotal -> "IsRunningTotal",
      _.runningTotalLines -> "RunningTotalLines",
      _.isVarianceCalc -> "IsVarianceCalc",
      _.isDeviationCalc -> "IsDeviationCalc",
      _.isFilledRectangle -> "IsFilledRectangle",
      _.lineWidth -> "LineWidth",
      _.arcDiameter -> "ArcDiameter",
      _.shapeType -> "ShapeType",
      _.isCentrallyMaintained -> "IsCentrallyMaintained",
      _.isImageField -> "IsImageField",
      _.barcodeType -> "BarcodeType",
      _.formatPattern -> "FormatPattern",
      _.isSuppressRepeats -> "IsSuppressRepeats",
      _.isDesc -> "IsDesc",
      _.isPrintBarcodeText -> "IsPrintBarcodeText",
      _.displayLogic -> "DisplayLogic",
      _.uuid -> "UUID")
  }
}
