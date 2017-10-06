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
  * Email: emeris.hernandez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com
  */

/**
  * Tenant Info Entity
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param isDiscountLineAmt Is Discount Line Amt
  * @param calendarId Calendar ID
  * @param acctSchema1Id Acc Schema1 ID
  * @param uomVolumeId Uom Volume ID
  * @param uomWeightId Uom Weight ID
  * @param uomLengthId Uom Length ID
  * @param uomTimeId Uom Time ID
  * @param treeMenuId Tree Menu ID
  * @param treeOrgId Tree Org ID
  * @param treeBPartnerId Tree Business Partner ID
  * @param treeProjectId Tree Project ID
  * @param treeSalesRegionId Tree Sales Region ID
  * @param treeProductId Tree Product ID
  * @param productFreightId Product Freight ID
  * @param bPartnerCashTrxId Business Partner Cash Trx ID
  * @param keepLogDays Keep Logs Days
  * @param treeActivityId Tree Activity
  * @param treeCampaignId Tree Campaign ID
  * @param logoId Logo ID
  * @param logoReportId Logo Report ID
  * @param logoWebId Logo Web ID
  * @param uuId UU ID
  */

case class TenantInfo(tenantId: Int,
                      organizationId: Int,
                      isActive: Boolean,
                      created: DateTime,
                      createdBy: Int,
                      updated: DateTime,
                      updatedBy: Int,
                      isDiscountLineAmt: Boolean = true,
                      calendarId: Option[Int],
                      acctSchema1Id: Option[Int],
                      uomVolumeId: Option[Int],
                      uomWeightId: Option[Int],
                      uomLengthId: Option[Int],
                      uomTimeId: Option[Int],
                      treeMenuId: Option[Int],
                      treeOrgId: Option[Int],
                      treeBPartnerId: Option[Int],
                      treeProjectId: Option[Int],
                      treeSalesRegionId: Option[Int],
                      treeProductId: Option[Int],
                      productFreightId: Option[Int],
                      bPartnerCashTrxId: Option[Int],
                      keepLogDays: Option[Int],
                      treeActivityId: Option[Int],
                      treeCampaignId: Option[Int],
                      logoId: Option[Int],
                      logoReportId: Option[Int],
                      logoWebId: Option[Int],
                      uuId: Option[String]
                     ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = tenantId

  override val entityName: String = "AD_ClientInfo"
  override val identifier: String = "AD_ClientInfo_ID"
}

object TenantInfo  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[TenantInfo]
  def create(tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             isDiscountLineAmt: Boolean,
             calendarId: Int,
             acctSchema1Id: Int,
             uomVolumeId: Int,
             uomWeightId: Int,
             uomLengthId: Int,
             uomTimeId: Int,
             treeMenuId: Int,
             treeOrgId: Int,
             treeBPartnerId: Int,
             treeProjectId: Int,
             treeSalesRegionId: Int,
             treeProductId: Int,
             productFreightId: Int,
             bPartnerCashTrxId: Int,
             keepLogDays: Int,
             treeActivityId: Int,
             treeCampaignId: Int,
             logoId: Int,
             logoReportId: Int,
             logoWebId: Int,
             uuId: String) = TenantInfo(tenantId, organizationId, isActive, created, createdBy, updated, updatedBy,
    isDiscountLineAmt, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None,
    None, None, None, None, None, None)
}

