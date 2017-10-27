package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.System
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
  * System Mapping
  */
trait SystemMapping  {
  val querySystem = quote {
    querySchema[System]("AD_System",
      _.systemId -> "AD_System_ID",
      _.tenantId -> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.isActive -> "IsActive",
      _.created -> "Created",
      _.createdBy -> "CreatedBy",
      _.updated -> "Updated",
      _.updatedBy -> "UpdatedBy",
      _.name -> "Name",
      _.userName -> "UserName",
      _.info -> "Info",
      _.version -> "Version",
      _.releaseNo -> "ReleaseNo",
      _.supportsUnits -> "SupportsUnits",
      _.password -> "Password",
      _.replicationType -> "ReplicationType",
      _.idRangeStart -> "IDRangeStart",
      _.idRangeEnd -> "IDRangeEnd",
      _.ldapHost -> "LDAPHost",
      _.customPrefix -> "CustomPrefix",
      _.isJustMigrate -> "IsJustMigrate",
      _.dbInstance -> "DBInstance",
      _.dbAddress -> "DBAddress",
      _.noProcessors -> "NoProcessors",
      _.summary -> "Summary",
      _.encryptionKey -> "EncryptionKey",
      _.ldapDomain -> "LDAPDomain",
      _.isAutoErrorReport -> "IsAutoErrorReport",
      _.recordId -> "Record_ID",
      _.supportExpDate -> "SupportExpDate",
      _.processing -> "Processing",
      _.supportEmail -> "SupportEmail",
      _.isAllowStatistics -> "IsAllowStatistics",
      _.statisticsInfo -> "StatisticsInfo",
      _.profileInfo -> "ProfileInfo",
      _.oldName -> "OldName",
      _.description -> "Description",
      _.systemStatus -> "SystemStatus",
      _.isFailOnMissingModelValidator -> "IsFailOnMissingModelValidator",
      _.lastBuiltInfo -> "LastBuiltInfo",
      _.isFailOnBuildDiffer -> "IsFailOnBuildDiffer",
      _.uuid -> "UUID")
  }
}
