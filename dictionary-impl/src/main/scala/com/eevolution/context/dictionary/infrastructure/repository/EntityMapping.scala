package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.Entity
import com.eevolution.context.dictionary.infrastructure.db.DbContext._
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
  * Email: victor.perez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by victor.perez@e-evolution.com , www.e-evolution.com
  */

/**
  * Entity Mapping
  */
trait EntityMapping {
  val queryEntity = quote {
    querySchema[Entity]("AD_Table",
      _.entityId -> "AD_Table_ID",
      _.tenantId -> "AD_Client_ID",
      _.organizationId -> "AD_Org_ID",
      _.isActive -> "IsActive",
      _.created -> "Created",
      _.createdBy -> "CreatedBy" ,
      _.updated -> "Updated",
      _.updatedBy -> "UpdatedBy",
      _.name -> "Name",
      _.description -> "Description",
      _.help -> "Help",
      _.tableName -> "TableName",
      _.isView -> "IsView",
      _.accessLevel -> "AccessLevel",
      _.entityType -> "EntityType",
      _.windowId -> "AD_Window_ID",
      _.windowPOId -> "PO_Window_ID",
      _.valueRuleId -> "AD_Val_Rule_ID",
      _.loadSeq -> "LoadSeq",
      _.isSecurityEnabled -> "IsSecurityEnabled",
      _.isDeleteable -> "IsDeleteable",
      _.isHighVolume -> "IsHighVolume",
      _.isImportTable -> "ImportTable",
      _.isChangeLog -> "IsChangeLog" ,
      _.replicationType -> "ReplicationType",
      _.copyColumnsFromTable -> "CopyColumnsFromTable",
      _.isCentrallyMaintained -> "IsCentrallyMaintained",
      _.acTriggerLength -> "AcTriggerLength" ,
      _.isDocument -> "IsDocument",
      _.isIgnoreMigration -> "IsIgnoreMigration")
  }
}
