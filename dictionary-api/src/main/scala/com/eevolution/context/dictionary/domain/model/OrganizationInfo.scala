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
  * Organization Info Entity
  * @param organizationId Organization ID
  * @param tenantId Tenant ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param locationId Location ID
  * @param duns Duns
  * @param taxId Tax Id
  * @param goalId Goal ID
  * @param supervisorId Supervisor ID
  * @param parentOrgId Parent ORG ID
  * @param orgTypeId ORG Type ID
  * @param warehouseId Warehouse ID
  * @param transferBankId Transfer Bank ID
  * @param transferCashBookId Transfer Cash ID
  * @param receiptFooterMsg Receipt Footer MSG
  * @param dropShipWarehouseId Drop Ship Warehouse ID
  * @param calendarId Calendar ID
  * @param logoId Logo ID
  * @param phone Phone
  * @param phone2 Phone 2
  * @param fax Fax
  * @param email Email
  * @param uuid UUID
  */

case class OrganizationInfo(organizationId: Int,
                            tenantId : Int ,
                            isActive : Boolean = true,
                            created : DateTime =  DateTime.now,
                            createdBy : Int ,
                            updated : DateTime =  DateTime.now,
                            updatedBy : Int ,
                            locationId: Option[Int],
                            duns: String,
                            taxId: String,
                            goalId: Option[Int],
                            supervisorId: Option[Int],
                            parentOrgId: Option[Int],
                            orgTypeId: Option[Int],
                            warehouseId: Option[Int],
                            transferBankId: Option[Int],
                            transferCashBookId: Option[Int],
                            receiptFooterMsg: Option[String],
                            dropShipWarehouseId: Option[Int],
                            calendarId: Option[Int],
                            logoId: Option[Int],
                            phone: Option[String],
                            phone2: Option[String],
                            fax: Option[String],
                            email: Option[String],
                            uuid: String
                           ) extends DomainModel
  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = 0

  override val entityName: String = "AD_OrgInfo"
  override val identifier: String = null
}

object OrganizationInfo{
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[OrganizationInfo]
  def create(organizationId: Int,
             tenantId : Int ,
             isActive : Boolean ,
             created : DateTime ,
             createdBy : Int ,
             updated : DateTime ,
             updatedBy : Int ,
             locationId: Int,
             duns: String,
             taxId: String,
             goalId: Int,
             supervisorId: Int,
             parentOrgId: Int,
             orgTypeId: Int,
             warehouseId: Int,
             transferBankId:Int,
             transferCashBookId: Int,
             receiptFooterMsg: String,
             dropShipWarehouseId: Int,
             calendarId: Int,
             logoId: Int,
             phone: String,
             phone2: String,
             fax: String,
             email: String,
             uuid: String) = OrganizationInfo(organizationId, tenantId, isActive, created, createdBy,
    updated, updatedBy, None, duns, taxId, None, None, None, None, None, None, None, None, None, None,
    None, None, None, None, None, uuid)
}

