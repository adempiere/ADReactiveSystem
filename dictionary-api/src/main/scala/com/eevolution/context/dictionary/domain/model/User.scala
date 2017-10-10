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
  */

/**
  * User Entity
  * @param userId User ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param description Description
  * @param password Password
  * @param email Email
  * @param supervisorId Supervisor ID
  * @param partnerId Partner ID
  * @param processing Processing
  * @param emailUser Email User
  * @param emailUserPW Email User PW
  * @param partnerLocationId Partner Location ID
  * @param greetingId Greeting ID
  * @param title Title
  * @param comments Comments
  * @param phone Phone
  * @param phone2 Phone 2
  * @param fax Fax
  * @param lastContact Last Contact
  * @param lastResult Last Result
  * @param birthday Birthday
  * @param orgTrxId Org TRX ID
  * @param emailVerify Email Verify
  * @param emailVerifyDate Email Verify Date
  * @param notificationType Notification Type
  * @param isFullBPAccess Is Full BP Access
  * @param jobId Job ID
  * @param ldapUser LDAP User
  * @param connectionProfile Connection Profile
  * @param value Value
  * @param userPin User Pin
  * @param isInPayroll Is In Payroll
  * @param salt Salt
  * @param isSalesLead Is Sales Lead
  * @param locationId Location ID
  * @param leadSource Lead Source
  * @param leadStatus Lead Status
  * @param leadSourceDescription Lead Source Description
  * @param leadStatusDescription Lead Status Description
  * @param campaignId Campaign ID
  * @param salesRepId Sales Rep ID
  * @param bpName BP Name
  * @param bpLocationId BP Location ID
  * @param emailConfigId Email Config
  * @param isLogInUser Is Log In User
  * @param isInternalUser Is Internal User
  * @param isWebStoreUser Is Web Store User
  * @param recentItemsMaxSaved Recent Items Max Saved
  * @param recentItemsMaxShown Recent Items Max Shown
  * @param uuId UUID
  */

case class User(userId : Int ,
                tenantId: Int,
                organizationId : Int = 0 ,
                isActive : Boolean = true,
                created : DateTime = DateTime.now,
                createdBy : Int ,
                updated : DateTime = DateTime.now ,
                updatedBy : Int,
                name: String,
                description: Option[String],
                password : Option[String] ,
                email : Option[String],
                supervisorId : Option[Int],
                partnerId : Option[Int] ,
                processing : Boolean = false ,
                emailUser : Option[String] ,
                emailUserPW : Option[String] ,
                partnerLocationId : Option[Int] ,
                greetingId : Option [Int] ,
                title : Option[String],
                comments : Option[String] ,
                phone : Option[String],
                phone2 : Option[String] ,
                fax : Option[String],
                lastContact : Option[DateTime] ,
                lastResult : Option[String],
                birthday : Option[DateTime],
                orgTrxId : Option[Int],
                emailVerify : Option[String],
                emailVerifyDate : Option[DateTime],
                notificationType : String = "E",
                isFullBPAccess : Boolean = true ,
                jobId : Option[Int],
                ldapUser : Option[String],
                connectionProfile : Option[String],
                value : Option[String],
                userPin : Option[String],
                isInPayroll : Boolean = true,
                salt : Option[String],
                isSalesLead : Boolean = false ,
                locationId : Option[Int],
                leadSource : Option[String] ,
                leadStatus : Option[String] ,
                leadSourceDescription : Option[String],
                leadStatusDescription : Option[String],
                campaignId : Option[Int],
                salesRepId : Option[Int],
                bpName : Option[String],
                bpLocationId : Option[Int],
                emailConfigId : Option[Int],
                isLogInUser: Boolean = false,
                isInternalUser: Boolean = false,
                isWebStoreUser: Boolean = false,
                recentItemsMaxSaved: Int = 50,
                recentItemsMaxShown: Int = 20,
                uuId: Option[String]
               ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = userId

  override val entityName: String = "AD_User"
  override val identifier: String = "AD_User_ID"
}

object User  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[User]
  def create(userId : Int ,
             tenantId: Int,
             organizationId : Int,
             isActive : Boolean,
             created : DateTime,
             createdBy : Int ,
             updated :DateTime ,
             updatedBy : Int,
             name: String,
             description: String,
             password : String ,
             email : String,
             supervisorId : Int,
             partnerId : Int ,
             processing : Boolean ,
             emailUser : String ,
             emailUserPW : String ,
             partnerLocationId : Int ,
             greetingId : Int ,
             title : String,
             comments : String ,
             phone : String,
             phone2 : String ,
             fax : String,
             lastContact : DateTime,
             lastResult : String,
             birthday : DateTime,
             orgTrxId : Int,
             emailVerify : String,
             emailVerifyDate : DateTime,
             notificationType : String,
             isFullBPAccess : Boolean ,
             jobId : Int,
             ldapUser : String,
             connectionProfile : String,
             value : String,
             userPin : String,
             isInPayroll : Boolean,
             salt : String,
             isSalesLead : Boolean ,
             locationId : Int,
             leadSource : String ,
             leadStatus : String ,
             leadSourceDescription : String,
             leadStatusDescription : String,
             campaignId : Int,
             salesRepId : Int,
             bpName : String,
             bpLocationId : Int,
             emailConfigId : Int,
             isLogInUser: Boolean,
             isInternalUser: Boolean,
             isWebStoreUser: Boolean,
             recentItemsMaxSaved: Int,
             recentItemsMaxShown: Int,
             uuId: String) = User(userId, tenantId, organizationId, isActive, created, createdBy, updated,
    updatedBy,name, None, None, None, None, None, processing, None, None, None, None, None, None, None,
    None, None, None, None, None, None, None, None, notificationType, isFullBPAccess, None, None, None,
    None, None, isInPayroll, None, isSalesLead, None, None, None, None, None, None, None, None, None,
    None, isLogInUser, isInternalUser, isWebStoreUser, recentItemsMaxSaved, recentItemsMaxShown, None)
}