package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.PrintGraph
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
  * Print Graph Mapping
  */
trait PrintGraphMapping  {
  val queryPrintGraph = quote {
    querySchema[PrintGraph]("AD_PrintGraph",
      _.printGraphId -> "AD_PrintGraph_ID",
      _.tenantId -> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.isActive -> "IsActive",
      _.created -> "Created",
      _.createdBy -> "CreatedBy",
      _.updated -> "Updated",
      _.updatedBy -> "UpdatedBy",
      _.name -> "Name",
      _.description -> "Description",
      _.graphType -> "GraphType",
      _.descriptionPrintFormatItemId -> "Description_PrintFormatItem_ID",
      _.dataPrintFormatItemID -> "Data_PrintFormatItem_ID",
      _.data1PrintFormatItemID -> "Data1_PrintFormatItem_ID",
      _.data2PrintFormatItemID -> "Data2_PrintFormatItem_ID",
      _.data3PrintFormatItemID -> "Data3_PrintFormatItem_ID",
      _.data4PrintFormatItemID -> "Data4_PrintFormatItem_ID",
      _.printFormatId -> "AD_PrintFormat_ID",
      _.uuid -> "UUID")
  }
}
