package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.Tab
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
  * Email: emeris.hernandez@e-evolution.com, http://www.e-evolution.com , http://github.com/EmerisScala
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 27/10/17.
  */

/**
  * Tab Mapping
  */

trait TabMapping {
  val queryTab = quote {
    querySchema[Tab]("AD_Tab",
      _.tabId-> "AD_Tab_ID",
      _.tenantId-> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.isActive-> "IsActive",
      _.created-> "Created",
      _.createdBy-> "CreatedBy",
      _.updated-> "Updated",
      _.updatedBy-> "UpdatedBy",
      _.name-> "Name",
      _.description-> "Description",
      _.help-> "Help",
      _.entityId-> "AD_Table_ID",
      _.windowId-> "AD_Window_ID",
      _.seqNo-> "SeqNo",
      _.tabLevel-> "TabLevel",
      _.isSingleRow-> "IsSingleRow",
      _.isInfoTab-> "IsInfoTab" ,
      _.isTranslationTab-> "IsTranslationTab",
      _.isReadOnly-> "IsReadOnly" ,
      _.attributeId-> "AD_Column_ID",
      _.hasTree-> "HasTree",
      _.whereClause-> "WhereClause",
      _.orderByClause-> "OrderByClause",
      _.commitWarning-> "CommitWarning",
      _.processId-> "AD_Process_ID",
      _.processing-> "Processing",
      _.imageId-> "AD_Image_ID",
      _.importFields-> "ImportFields",
      _.attributeSortOrderId-> "AD_ColumnSortOrder_ID",
      _.attributeSortYesNoId-> "AD_ColumnSortYesNo_ID",
      _.isSortTab-> "IsSortTab",
      _.entityType-> "EntityType" ,
      _.includedTabId-> "Included_Tab_ID",
      _.readOnlyLogic-> "ReadOnlyLogic",
      _.displayLogic-> "DisplayLogic",
      _.isInsertRecord-> "IsInsertRecord" ,
      _.isAdvancedTab-> "IsAdvancedTab",
      _.parentAttributeId-> "Parent_Column_ID",
      _.uuid-> "UUID")
  }
}
