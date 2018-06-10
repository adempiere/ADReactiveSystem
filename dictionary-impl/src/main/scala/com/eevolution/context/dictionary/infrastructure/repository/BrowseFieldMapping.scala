package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.BrowseField
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
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 19/10/17.
  */

/**
  * Browse Field Mapping
  */

trait BrowseFieldMapping {
  val queryBrowseField = quote {
    querySchema[BrowseField]("AD_Browse_Field",
      _.browseFieldId-> "AD_Browse_Field_ID",
      _.tenantId-> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.created-> "Created",
      _.createdBy-> "CreatedBy",
      _.isActive-> "IsActive",
      _.updated-> "Updated",
      _.updatedBy-> "UpdatedBy",
      _.elementId-> "AD_Element_ID",
      _.referenceId-> "AD_Reference_ID",
      _.viewColumnId-> "AD_View_Column_ID",
      _.description-> "Description",
      _.entityType-> "EntityType",
      _.help-> "Help",
      _.isCentrallyMaintained-> "IsCentrallyMaintained",
      _.isDisplayed-> "IsDisplayed",
      _.isIdentifier-> "IsIdentifier",
      _.isKey-> "IsKey",
      _.isQueryCriteria-> "IsQueryCriteria",
      _.isRange-> "IsRange",
      _.name-> "Name",
      _.seqNo-> "SeqNo",
      _.browseId-> "AD_Browse_ID",
      _.referenceValueId-> "AD_Reference_Value_ID",
      _.isMandatory-> "IsMandatory",
      _.axisColumnId-> "Axis_Column_ID",
      _.axisParentColumnId-> "Axis_Parent_Column_ID",
      _.isReadOnly-> "IsReadOnly",
      _.sortNo-> "SortNo",
      _.isOrderBy-> "IsOrderBy",
      _.valRuleId-> "AD_Val_Rule_ID",
      _.defaultValue-> "DefaultValue",
      _.defaultValue2-> "DefaultValue2",
      _.displayLogic-> "DisplayLogic",
      _.fieldLength-> "FieldLength",
      _.readOnlyLogic-> "ReadOnlyLogic",
      _.vFormat-> "VFormat",
      _.valueMax-> "ValueMax",
      _.valueMin-> "ValueMin",
      _.callout-> "Callout",
      _.infoFactoryClass-> "InfoFactoryClass",
      _.seqNoGrid-> "SeqNoGrid",
      _.isInfoOnly-> "IsInfoOnly",
      _.uuid-> "UUID")
  }
}
