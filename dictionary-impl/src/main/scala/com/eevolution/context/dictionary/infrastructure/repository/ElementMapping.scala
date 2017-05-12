package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.Element
import com.eevolution.context.dictionary.infrastructure.db.DbContext._

/**
  * Copyright (C) 2003-2017, e-Evolution Consultants S.A. , http://www.e-evolution.com
  * This program is free software: you can redistribute it and/or modify
  * it under the terms of the GNU Affero General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU Affero General Public License for more details.
  * You should have received a copy of the GNU Affero General Public License
  * along with this program.  If not, see <http://www.gnu.org/licenses/>.
  * Email: victor.perez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by victor.perez@e-evolution.com , www.e-evolution.com
  */

/**
  * Element Mapping
  */
trait ElementMapping {
  val queryElement = quote {
    querySchema[Element]("AD_Element",
      _.elementId -> "AD_Element_ID",
      _.columnName -> "ColumnName",
      _.name -> "Name",
      _.description -> "Description",
      _.help -> "Help",
      _.printName -> "PrintName",
      _.namePO -> "PO_Name",
      _.descriptionPO -> "PO_Description",
      _.helpPO -> "PO_Help",
      _.printNamePO -> "PO_PrintName",
      _.referenceId -> "AD_Reference_ID",
      _.referenceValueId -> "AD_Reference_Value_ID",
      _.fieldLength -> "FieldLength",
      _.entityType ->  "EntityType")
  }
}
