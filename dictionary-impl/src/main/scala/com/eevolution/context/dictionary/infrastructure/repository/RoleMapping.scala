package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.Role
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
  * Role Mapping
  */

trait RoleMapping {
  val queryRole = quote {
    querySchema[Role]("AD_Role",
      _.roleId-> "AD_Role_ID",
      _.tenantId -> "AD_Client_ID" ,
      _.organizationId -> "AD_Org_ID" ,
      _.isActive -> "IsActive",
      _.created -> "Created",
      _.createdBy -> "CreatedBy" ,
      _.updated -> "Updated",
      _.updatedBy -> "UpdatedBy",
      _.name -> "Name",
      _.description-> "Description",
      _.userLevel -> "UserLevel",
      _.currencyId -> "C_Currency_ID",
      _.amtApproval -> "AmtApproval",
      _.treeMenuId -> "AD_Tree_Menu_ID",
      _.isManual -> "IsManual",
      _.isShowAcct -> "IsShowAcct",
      _.isPersonalLock -> "IsPersonalLock",
      _.isPersonalAccess -> "IsPersonalAccess",
      _.isCanExport -> "IsCanExport",
      _.isCanReport -> "IsCanReport",
      _.supervisorId -> "Supervisor_ID",
      _.isCanApproveOwnDoc -> "IsCanApproveOwnDoc",
      _.isAccessAllOrgs -> "IsAccessAllOrgs",
      _.isChangeLog -> "IsChangeLog",
      _.preferenceType -> "PreferenceType",
      _.overwritePriceLimit -> "OverwritePriceLimit",
      _.isUseUserOrgAccess -> "IsUseUserOrgAccess",
      _.treeOrgId -> "AD_Tree_Org_ID",
      _.confirmQueryRecords -> "ConfirmQueryRecords",
      _.maxQueryRecords -> "MaxQueryRecords",
      _.connectionProfile -> "ConnectionProfile",
      _.allowInfoAccount -> "Allow_Info_Account",
      _.allowInfoAsset -> "Allow_Info_Asset",
      _.allowInfoBPartner -> "Allow_Info_BPartner",
      _.allowInfoCashJournal -> "Allow_Info_CashJournal",
      _.allowInfoInOut -> "Allow_Info_InOut",
      _.allowInfoInvoice -> "Allow_Info_Invoice",
      _.allowInfoOrder -> "Allow_Info_Order",
      _.allowInfoPayment -> "Allow_Info_Payment",
      _.allowInfoProduct -> "Allow_Info_Product",
      _.allowInfoResource -> "Allow_Info_Resource",
      _.allowInfoSchedule -> "Allow_Info_Schedule",
      _.UserDiscount -> "UserDiscount",
      _.allowInfoMRP -> "Allow_Info_MRP",
      _.allowInfoCRP -> "Allow_Info_CRP",
      _.isDiscountUpToLimitPrice -> "IsDiscountUpToLimitPrice",
      _.isDiscountAllowedOnTotal -> "IsDiscountAllowedOnTotal",
      _.allowHTMLView-> "Allow_HTML_View",
      _.allowXLSView-> "Allow_XLS_View",
      _.isCanLoad-> "IsCanLoad",
      _.uuid-> "UUID")
  }
}
