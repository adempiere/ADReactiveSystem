package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.Tenant
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
  * Tenant Mapping
  */

trait TenantMapping {
  val queryTenant = quote {
    querySchema[Tenant]("AD_Client",
      _.tenantId-> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.isActive-> "IsActive",
      _.created-> "Created",
      _.createdBy-> "CreatedBy",
      _.updated-> "Updated",
      _.updatedBy-> "UpdatedBy",
      _.value-> "Value",
      _.name-> "Name",
      _.description->"Description",
      _.smtpHost-> "SMTPHost",
      _.requestEmail-> "RequestEmail",
      _.requestUser-> "RequestUser",
      _.requestUserPW-> "RequestUserPW",
      _.requestFolder-> "RequestFolder",
      _.language-> "AD_Language",
      _.isMultilingualDocument-> "IsMultiLingualDocument",
      _.isSMTPAuthorization-> "IsSMTPAuthorization",
      _.isUseBetaFunctions-> "IsUseBetaFunctions",
      _.ldapQuery-> "LDAPQuery",
      _.modelValidationClasses-> "ModelValidationClasses",
      _.isAutoArchive-> "AutoArchive",
      _.mmPolicy-> "MMPolicy",
      _.emailTest-> "Email",
      _.isServerEmail-> "IsServerEmail",
      _.documentDir-> "DocumentDir",
      _.isPostImmediate-> "IsPostImmediate",
      _.isCostImmediate-> "IsCostImmediate",
      _.isStoreAttachmentsOnFileSystem -> "StoreAttachmentsOnFileSystem",
      _.windowsAttachmentPath-> "WindowsAttachmentPath",
      _.unixAttachmentPath-> "UnixAttachmentPath",
      _.isStoreArchiveOnFileSystem-> "StoreArchiveOnFileSystem",
      _.windowsArchivePath-> "WindowsArchivePath",
      _.unixArchivePath-> "UnixArchivePath",
      _.isUseASP-> "IsUseASP",
      _.replicationStrategyId-> "AD_ReplicationStrategy_ID",
      _.emailConfigId-> "AD_EmailConfig_ID",
      _.uuid-> "UUID")
  }
}
