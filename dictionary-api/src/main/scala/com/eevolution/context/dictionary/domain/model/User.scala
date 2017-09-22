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
  * User Entity
  * @param userId
  * @param tenantId
  * @param organizationId
  * @param isActive
  * @param created
  * @param createdBy
  * @param updated
  * @param updatedBy
  * @param name
  * @param description
  * @param password
  * @param email
  * @param supervisorId
  * @param partnerId
  * @param processing
  * @param emailUser
  * @param emailUserPW
  * @param partnerLocationId
  * @param greetingId
  * @param title
  * @param comments
  * @param phone
  * @param phone2
  * @param fax
  * @param lastContact
  * @param lastResult
  * @param birthDay
  * @param orgTrxid
  * @param emailVerify
  * @param emailVerifyDate
  * @param notificationType
  * @param isFullBPAccess
  * @param jobId
  * @param ldapUser
  * @param connectionProfile
  * @param value
  * @param userPin
  * @param isInPayroll
  * @param salt
  * @param isSalesLead
  * @param locationId
  * @param leadSource
  * @param leadStatus
  * @param leadSourceDescription
  * @param leadStatusDescription
  * @param campaignId
  * @param salesRepId
  * @param bpName
  * @param bpLocationId
  * @param emailConfigId
  */
case class User(userId : String ,
                tenantId: Int,
                organizationId : Int = 0 ,
                isActive : Boolean = true,
                created : DateTime = DateTime.now(),
                createdBy : Int ,
                updated :Int ,
                updatedBy : DateTime = DateTime.now(),
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
                birthDay : Option[DateTime],
                orgTrxid : Option[Int],
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
                emailConfigId : Option[Int]) {

  def Identity = "AD_User_ID"

}
