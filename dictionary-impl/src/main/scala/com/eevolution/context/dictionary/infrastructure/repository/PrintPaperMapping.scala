package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.PrintPaper
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
  * Print Paper Mapping
  */
trait PrintPaperMapping  {
  val queryPrintPaper = quote {
    querySchema[PrintPaper]("AD_PrintPaper",
      _.printPaperId -> "AD_PrintPaper_ID",
      _.tenantId -> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.isActive -> "IsActive",
      _.created -> "Created",
      _.createdBy -> "CreatedBy",
      _.updated -> "Updated",
      _.updatedBy -> "UpdatedBy",
      _.name -> "Name",
      _.description -> "Descripcion",
      _.isDefault -> "IsDefault",
      _.isLandscape -> "IsLandScape",
      _.code -> "Code",
      _.marginTop -> "MarginTop",
      _.marginLeft -> "MarginLeft",
      _.marginRight -> "MarginRight",
      _.marginBottom -> "MarginBottom",
      _.processing -> "Processing",
      _.sizeX -> "SizeX",
      _.sizeY -> "SizeY",
      _.dimensionUnits -> "DimensionUnits",
      _.uuid -> "UUID")
  }
}
