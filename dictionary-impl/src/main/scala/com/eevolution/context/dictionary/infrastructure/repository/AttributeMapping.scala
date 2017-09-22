package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.Attribute
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
  * Email: victor.perez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by victor.perez@e-evolution.com , www.e-evolution.com
  */

/**
  * Attribute Mapping
  */
trait AttributeMapping  {
  val queryAttribute = quote {
    querySchema[Attribute]("AD_Column",
      _.attributeId -> "AD_Column_ID",
      _.isActive -> "IsActive",
      _.created -> "Created",
      _.createdBy -> "CreatedBy",
      _.updated -> "Updated",
      _.updatedBy -> "UpdatedBy",
      _.name -> "Name",
      _.description -> "Description",
      _.help -> "Help",
      _.version -> "Version",
      _.entityType -> "EntityType",
      _.columnName -> "ColumnName",
      _.entityId -> "AD_Table_ID",
      _.referenceId -> "AD_Reference_ID",
      _.referenceValueiId -> "AD_Reference_Value_ID",
      _.valueRuleId -> "AD_Val_Rule_ID",
      _.fieldLength -> "FieldLength",
      _.defaultValue -> "DefaultValue",
      _.isKey -> "IsKey",
      _.isParent -> "IsParent",
      _.isMandatory -> "IsMandatory",
      _.isUpdateable -> "IsUpdateable",
      _.readOnlyLogic -> "ReadOnlyLogic",
      _.isIdentifier -> "IsIdentifier",
      _.seqNo -> "SeqNo",
      _.isTranslated -> "IsTranslated",
      _.isEncrypted -> "IsEncrypted",
      _.callout -> "Callout",
      _.vformat -> "VFormat",
      _.valueMin -> "ValueMin",
      _.valueMax -> "ValueMax",
      _.isSelectionColumn -> "IsSelectionColumn",
      _.elementId -> "AD_Element_ID",
      _.processId -> "AD_Process_ID",
      _.isSyncDatabase -> "IsSyncDatabase",
      _.isAlwaysUpdateable -> "IsAlwaysUpdateable",
      _.columnSQL -> "ColumnSQL",
      _.mandatoryLogic -> "MandatoryLogic",
      _.infoFactoryClass -> "InfoFactoryClass",
      _.isAutoComplete -> "IsAutoComplete",
      _.isAllowLogging -> "IsAllowLogging",
      _.formatPattern -> "FormatPattern",
      _.chartId -> "AD_Chart_ID",
      _.isRange -> "IsRange")
  }
}
