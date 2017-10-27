package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.ProcessParameter
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
  * Process Parameter Mapping
  */
trait ProcessParameterMapping  {
  val queryProcessParameter = quote {
    querySchema[ProcessParameter]("AD_Process_Para",
      _.processParameterId -> "AD_Process_Para_ID",
      _.tenantId -> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.isActive -> "IsActive",
      _.created -> "Created",
      _.createdBy -> "CreatedBy",
      _.updated -> "Updated",
      _.updatedBy -> "UpdatedBy",
      _.name -> "Name",
      _.description -> "Description",
      _.help -> "Help",
      _.accessLevel ->  "",
      _.processId -> "AD_Process_ID",
      _.seqNo -> "SeqNo",
      _.referenceId -> "AD_Reference_ID",
      _.referenceValueId -> "AD_Reference_Value_ID",
      _.validationRuleId -> "AD_Val_Rule_ID",
      _.columnName -> "ColumnName",
      _.isCentrallyMaintained -> "IsCentrallyMaintained",
      _.fieldLength -> "FieldLength",
      _.isMandatory -> "IsMandatory",
      _.isRange -> "IsRange",
      _.defaultValue -> "DefaultValue",
      _.defaultValue2 -> "DefaultValue2",
      _.vFormat -> "VFormat",
      _.valueMin -> "ValueMin",
      _.valueMax -> "ValueMax",
      _.elementId -> "AD_Element_ID",
      _.entityType -> "EntityType",
      _.readOnlyLogic -> "ReadOnlyLogic",
      _.displayLogic -> "DisplayLogic",
      _.isInfoOnly -> "IsInfoOnly",
      _.uuid -> "UUID")
  }
}
