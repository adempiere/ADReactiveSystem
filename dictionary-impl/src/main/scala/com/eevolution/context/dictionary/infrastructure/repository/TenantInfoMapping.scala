package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.TenantInfo
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
  * Tenant Info Mapping
  */

trait TenantInfoMapping {
  val queryTenantInfo = quote {
    querySchema[TenantInfo]("AD_ClientInfo",
      _.tenantId-> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.isActive-> "IsActive",
      _.created-> "Created",
      _.createdBy-> "CreatedBy",
      _.updated-> "Updated",
      _.updatedBy-> "UpdatedBy",
      _.isDiscountLineAmt-> "IsDiscountLineAmt",
      _.calendarId-> "C_Calendar_ID",
      _.acctSchema1Id-> "C_Acct_Schema1_ID",
      _.uomVolumeId-> "C_UOM_Volume_ID",
      _.uomWeightId-> "C_UOM_Weight_ID",
      _.uomLengthId-> "C_UOM_Length_ID",
      _.uomTimeId-> "C_UOM_Time_ID",
      _.treeMenuId-> "AD_Tree_Menu_ID",
      _.treeOrgId-> "AD_Tree_Org_ID",
      _.treeBPartnerId-> "AD_Tree_BPartner_ID",
      _.treeProjectId-> "AD_Tree_Project_ID",
      _.treeSalesRegionId-> "AD_Tree_SalesRegion_ID",
      _.treeProductId-> "AD_Tree_Product_ID",
      _.productFreightId-> "M_ProductFreight_ID",
      _.bPartnerCashTrxId-> "C_BPartnerCashTrx_ID",
      _.keepLogDays-> "KeepLogDays",
      _.treeActivityId-> "AD_Tree_Activity_ID",
      _.treeCampaignId-> "AD_Tree_Campaign_ID",
      _.logoId-> "Logo_ID",
      _.logoReportId-> "LogoReport_ID",
      _.logoWebId-> "LogoWeb_ID",
      _.uuid-> "UUID")
  }
}
