package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.PrintTableFormat
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
  * Print Table Format Mapping
  */
trait PrintTableFormatMapping  {
  val queryPrintTableFormat = quote {
    querySchema[PrintTableFormat]("AD_PrintTableFormat",
      _.printTableFormatId -> "AD_PrintTableFormat_ID",
      _.tenantId -> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.isActive -> "IsActive",
      _.created -> "Created",
      _.createdBy -> "CreatedBy",
      _.updated -> "Updated",
      _.updatedBy -> "UpdatedBy",
      _.hdrPrintFontId -> "Hdr_PrintFont_ID",
      _.hdrTextFgPrintColorId -> "HdrTextFg_PrintColor_ID",
      _.hdrTextBgPrintColorId -> "HdrTextBg_PrintColor_ID",
      _.hdrLinePrintColorId -> "HdrLine_PrintColor_ID",
      _.functPrintFontId -> "Funct_PrintFont_ID",
      _.functBgPrintColorId -> "FunctBg_PrintColor_ID",
      _.functFgPrintColorId -> "FunctFg_PrintColor_ID",
      _.linePrintColorId -> "Line_PrintColor_ID",
      _.description -> "DEscription",
      _.isPaintBoundaryLines -> "IsPaintBoundaryLines",
      _.isPaintHLines -> "IsPaintHLines",
      _.isPaintVLines -> "IsPaintVLines",
      _.isPrintFunctionSymbols -> "IsPrintFunctionSymbols",
      _.name -> "Name",
      _.isDefault -> "IsDefault",
      _.imageUrl -> "ImageURL",
      _.headerLeft -> "HeaderLeft",
      _.headerCenter -> "HeaderCenter",
      _.headerRight -> "HeaderRight",
      _.footerLeft -> "FooterLeft",
      _.footerCenter -> "FooterCenter",
      _.footerRight -> "FooterRight",
      _.imageIsAttached -> "ImageIsAttached",
      _.hdrStroke -> "HdrStroke",
      _.lineStroke -> "LineStroke",
      _.hdrStrokeType -> "HdrStrokeType",
      _.lineStrokeType -> "LineStrokeType",
      _.isPaintHeaderLines -> "IsPaintHeaderLines",
      _.imageId -> "AD_Image_ID",
      _.isMultiLineHeader -> "IsMultiLineHeader",
      _.uuid -> "UUID")
  }
}
