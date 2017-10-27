package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.User
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
  * User Mapping
  */

trait UserMapping {
  val queryUser = quote {
    querySchema[User]("AD_User",
      _.userId -> "AD_User_ID" ,
      _.tenantId-> "AD_Client_ID",
      _.organizationId -> "AD_Org_ID",
      _.isActive -> "IsActive",
      _.created -> "Created",
      _.createdBy -> "CreatedBy" ,
      _.updated ->"Updated" ,
      _.updatedBy -> "UpdatedBy",
      _.name-> "Name",
      _.description-> "Description",
      _.password -> "Password" ,
      _.email -> "Email",
      _.supervisorId -> "Supervisor_ID",
      _.partnerId -> "C_BPartner_ID" ,
      _.processing -> "Processing" ,
      _.emailUser -> "EmailUser" ,
      _.emailUserPW -> "EmailUserPW" ,
      _.partnerLocationId -> "C_BPartner_Location_ID" ,
      _.greetingId -> "C_Greeting_ID" ,
      _.title -> "Title",
      _.comments -> "Comments" ,
      _.phone -> "Phone",
      _.phone2 -> "Phone2" ,
      _.fax -> "Fax",
      _.lastContact -> "LastContact",
      _.lastResult -> "LastResult",
      _.birthday -> "Birthday",
      _.orgTrxId -> "AD_OrgTrx_ID",
      _.emailVerify -> "EmailVerify",
      _.emailVerifyDate -> "EmailVerifyDate",
      _.notificationType -> "NotificationType",
      _.isFullBPAccess -> "IsFullBPAccess" ,
      _.jobId -> "C_Job_ID",
      _.ldapUser -> "LDAPUser",
      _.connectionProfile -> "ConnectionProfile",
      _.value -> "Value",
      _.userPin -> "UserPin",
      _.isInPayroll -> "IsInPayRoll",
      _.salt -> "Salt",
      _.isSalesLead -> "IsSalesLead" ,
      _.locationId -> "C_Location_ID",
      _.leadSource -> "LeadSource" ,
      _.leadStatus -> "LeadStatus" ,
      _.leadSourceDescription -> "LeadSourceDescription",
      _.leadStatusDescription -> "LeadStatusDescription",
      _.campaignId -> "C_Campaign_ID",
      _.salesRepId -> "SalesRep_ID",
      _.bpName -> "BPName",
      _.bpLocationId -> "BP_Location_ID",
      _.emailConfigId -> "AD_EmailConfig_ID",
      _.isLogInUser-> "IsLogInUser",
      _.isInternalUser-> "IsInternalUser",
      _.isWebStoreUser-> "IsWebStoreUser",
      _.recentItemsMaxSaved-> "RecentItemsMaxSaved",
      _.recentItemsMaxShown-> "RecentItemsMaxShown",
      _.uuid-> "UUID")
  }
}
