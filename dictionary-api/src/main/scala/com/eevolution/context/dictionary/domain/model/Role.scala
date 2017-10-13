package com.eevolution.context.dictionary.domain.model

import ai.x.play.json.Jsonx
import com.eevolution.context.dictionary.api.{ActiveEnabled, DomainModel, Identifiable, Traceable}
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
  * Created by victor.perez@e-evolution.com , www.e-evolution.com on 18/02/17.
  * Modified by emeris.hernandez@e-evolution.com , www.e-evolution.com on 13/10/2017.
  */

/**
  * Role Entity
  * @param roleId Role ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param description Description
  * @param userLevel User Level
  * @param currencyId Currency ID
  * @param amtApproval AMT Approval
  * @param treeMenuId Tree Menu ID
  * @param isManual Is Manual
  * @param isShowAcct Is Show ACCT
  * @param isPersonalLock Is Personal Lock
  * @param isPersonalAccess Is Personal Access
  * @param isCanExport Is Can Export
  * @param isCanReport Is Can Report
  * @param supervisorId Supervisor ID
  * @param isCanApproveOwnDoc Is Can Approve Own Doc
  * @param isAccessAllOrgs Is Access All Organizations
  * @param isChangeLog Is Change Log
  * @param preferenceType Preference Type
  * @param isOverwritePriceLimit Is Over Write price Limit
  * @param isUseUserOrgAccess Is User User Organization Access
  * @param treeOrgId Tree Organization ID
  * @param confirmQueryRecords Confirm Query Records
  * @param maxQueryRecords Max Query Records
  * @param connectionProfile Connection Profile
  * @param allowInfoAccount Allow Info Account
  * @param allowInfoAsset Allow Info Asset
  * @param allowInfoBPartner Allow Info Business Partner
  * @param allowInfoCashJournal Allow Info Cash Journal
  * @param allowInfoInOut Allow Info In Out
  * @param allowInfoInvoice Allow Info In Voice
  * @param allowInfoOrder Allow Info Order
  * @param allowInfoPayment Allow Info Payment
  * @param allowInfoProduct Allow Info Product
  * @param allowInfoResource Allow Info Resource
  * @param allowInfoSchedule Allow Info Schedule
  * @param UserDiscount User Discount
  * @param allowInfoMRP Allow Info MRP
  * @param allowInfoCRP Allow Info CRP
  * @param isDiscountUpToLimitPrice Is Discount Up To Limit Price
  * @param isDiscountAllowedOnTotal Id Discount Allowed On Total
  * @param allowHTMLView Allow HTML View
  * @param allowXLSView Allow XLS View
  * @param isCanLoad Is Can Load
  * @param uuid UUID
  */

case class Role(roleId: Int,
                tenantId : Int ,
                organizationId : Int ,
                isActive : Boolean = true,
                created : DateTime = DateTime.now,
                createdBy : Int ,
                updated : DateTime = DateTime.now ,
                updatedBy : Int,
                name : String,
                description: Option[String],
                userLevel : String = "O",
                currencyId : Option[Int],
                amtApproval : Option[BigDecimal] = Some(0),
                treeMenuId : Option[Int],
                isManual : Boolean = false,
                isShowAcct : Boolean = true ,
                isPersonalLock : Boolean = false ,
                isPersonalAccess : Boolean =  false,
                isCanExport : Boolean = true,
                isCanReport : Boolean = true ,
                supervisorId : Option[Int],
                isCanApproveOwnDoc : Boolean = true ,
                isAccessAllOrgs : Boolean = false ,
                isChangeLog : Boolean = false ,
                preferenceType : String = "C",
                isOverwritePriceLimit : Boolean = false ,
                isUseUserOrgAccess : Boolean =  false ,
                treeOrgId : Option [Int],
                confirmQueryRecords : Int = 0 ,
                maxQueryRecords : Int = 0 ,
                connectionProfile : Option[String],
                allowInfoAccount : Boolean = true ,
                allowInfoAsset : Boolean = true ,
                allowInfoBPartner : Boolean =  true ,
                allowInfoCashJournal : Boolean =  true ,
                allowInfoInOut : Boolean =  true ,
                allowInfoInvoice : Boolean = true ,
                allowInfoOrder : Boolean = true ,
                allowInfoPayment : Boolean = true ,
                allowInfoProduct : Boolean = true ,
                allowInfoResource : Boolean =  true ,
                allowInfoSchedule : Boolean = true ,
                UserDiscount : Option[BigDecimal] ,
                allowInfoMRP : Boolean = true,
                allowInfoCRP : Boolean =  true ,
                isDiscountUpToLimitPrice : Boolean = false ,
                isDiscountAllowedOnTotal : Boolean =  false,
                allowHTMLView: Boolean = true,
                allowXLSView: Boolean = true,
                isCanLoad: Boolean = true,
                uuid: Option[String]
               ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = roleId

  override val entityName: String = "AD_Role"
  override val identifier: String = "AD_Role_ID"
}

object Role  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Role]
  def create(roleId: Int,
             tenantId : Int ,
             organizationId : Int ,
             isActive : Boolean,
             created : DateTime,
             createdBy : Int ,
             updated : DateTime,
             updatedBy : Int,
             name : String,
             description: String,
             userLevel : String,
             currencyId : Int,
             amtApproval : BigDecimal,
             treeMenuId : Int,
             isManual : Boolean,
             isShowAcct : Boolean,
             isPersonalLock : Boolean,
             isPersonalAccess : Boolean,
             isCanExport : Boolean,
             isCanReport : Boolean,
             supervisorId : Int,
             isCanApproveOwnDoc : Boolean,
             isAccessAllOrgs : Boolean,
             isChangeLog : Boolean,
             preferenceType : String,
             isOverwritePriceLimit : Boolean,
             isUseUserOrgAccess : Boolean,
             treeOrgId : Int,
             confirmQueryRecords : Int,
             maxQueryRecords : Int,
             connectionProfile : String,
             allowInfoAccount : Boolean,
             allowInfoAsset : Boolean,
             allowInfoBPartner : Boolean,
             allowInfoCashJournal : Boolean,
             allowInfoInOut : Boolean,
             allowInfoInvoice : Boolean,
             allowInfoOrder : Boolean,
             allowInfoPayment : Boolean,
             allowInfoProduct : Boolean,
             allowInfoResource : Boolean,
             allowInfoSchedule : Boolean,
             UserDiscount : BigDecimal,
             allowInfoMRP : Boolean,
             allowInfoCRP : Boolean,
             isDiscountUpToLimitPrice : Boolean,
             isDiscountAllowedOnTotal : Boolean,
             allowHTMLView: Boolean,
             allowXLSView: Boolean,
             isCanLoad: Boolean,
             uuid: String) = Role(roleId, tenantId, organizationId, isActive, created, createdBy, updated,
    updatedBy, name, None, userLevel, None, None, None, isManual, isShowAcct, isPersonalLock, isPersonalAccess,
    isCanExport, isCanReport, None, isCanApproveOwnDoc, isAccessAllOrgs, isChangeLog, preferenceType,
    isOverwritePriceLimit, isUseUserOrgAccess, None, confirmQueryRecords, maxQueryRecords, None,
    allowInfoAccount, allowInfoAsset, allowInfoBPartner, allowInfoCashJournal, allowInfoInOut, allowInfoInvoice,
    allowInfoOrder, allowInfoPayment, allowInfoProduct, allowInfoResource, allowInfoSchedule,
    None, allowInfoMRP, allowInfoCRP, isDiscountUpToLimitPrice, isDiscountAllowedOnTotal, allowHTMLView,
    allowXLSView, isCanLoad, None)
}


