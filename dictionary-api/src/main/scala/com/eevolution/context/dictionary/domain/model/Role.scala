package com.eevolution.context.dictionary.domain.model

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
  */

/**
  * Role Entity
  * @param roleId
  * @param tenantId
  * @param organizationId
  * @param isActive
  * @param created
  * @param createdBy
  * @param updated
  * @param updatedBy
  * @param name
  * @param description
  * @param help
  * @param userLevel
  * @param currencyId
  * @param amtApproval
  * @param treeMenuId
  * @param isManual
  * @param isShowAcct
  * @param isPersonalLock
  * @param isPersonalAccess
  * @param isCanExport
  * @param isCanReport
  * @param supervisorId
  * @param isCanApproveOwnDoc
  * @param isAccessallOrgs
  * @param isChangeLog
  * @param preferenceType
  * @param isOverwritePriceLimit
  * @param isUseUserOrgAccess
  * @param treeOrgId
  * @param confirmQueryRecords
  * @param maxQueryRecords
  * @param connectionProfile
  * @param allowInfoAccount
  * @param allowInfoAsset
  * @param allowInfoBPartner
  * @param allowInfoCashJournal
  * @param allowInfoInOut
  * @param allowInfoInvoice
  * @param allowInfoOrder
  * @param allowInfoPayment
  * @param allowInfoProduct
  * @param allowInfoResource
  * @param allowInfoSchedule
  * @param UserDiscount
  * @param allowInfoMRP
  * @param allowInfoCRP
  * @param isDiscountUpToLimitPrice
  * @param isDiscountAllowedOnTotal
  */
case class Role(roleId: Int,
                tenantId : Int ,
                organizationId : Int ,
                isActive : Boolean = true,
                created : DateTime = DateTime.now(),
                createdBy : Int ,
                updated :Int ,
                updatedBy : DateTime = DateTime.now(),
                name : String,
                description: Option[String],
                help : Option[String],
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
                isAccessallOrgs : Boolean = false ,
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
                isDiscountAllowedOnTotal : Boolean =  false) {

  def Identity = "AD_Role_ID"
}
