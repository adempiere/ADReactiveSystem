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
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 12/10/2017.
  */

/**
  * Registration Entity
  * @param registrationId Registration ID
  * @param tenantId Tenant ID
  * @param systemId System ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param isRegistered Is Registered
  * @param recordId Record ID
  * @param description Description
  * @param locationId Location ID
  * @param isInProduction Is In Production
  * @param startProductionDate Start Production Date
  * @param isAllowPublish Is Allow Publish
  * @param isAllowStatistics Is Allow Statistics
  * @param platformInfo Platform Info
  * @param industryInfo Industry Info
  * @param salesVolume Sales Volume
  * @param currencyId Currency ID
  * @param numberEmployees Number Employees
  * @param processing Processing
  * @param remoteHost Remote Host
  * @param remoteAddress Remote Address
  * @param uuid UUID
  */

case class Registration(registrationId: Int,
                        tenantId: Int,
                        systemId: Int,
                        organizationId: Int,
                        isActive : Boolean = true,
                        created : DateTime = DateTime.now,
                        createdBy : Int ,
                        updated : DateTime = DateTime.now,
                        updatedBy :Int,
                        isRegistered: Boolean = false,
                        recordId: Option[Int],
                        description: Option[String],
                        locationId: Option[Int],
                        isInProduction: Boolean = false,
                        startProductionDate: DateTime = new DateTime,
                        isAllowPublish: Boolean = true,
                        isAllowStatistics: Boolean = true,
                        platformInfo: Option[String],
                        industryInfo: Option[String],
                        salesVolume: Int = 0,
                        currencyId: Option[Int],
                        numberEmployees: Int = 0,
                        processing: Option[Boolean],
                        remoteHost: Option[String],
                        remoteAddress: Option[String],
                        uuid: Option[String]
                       ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = registrationId

  override val entityName: String = "AD_Registration"
  override val identifier: String = "AD_Registration_ID"
}

object Registration  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Registration]
  def create(registrationId: Int,
             tenantId: Int,
             systemId: Int,
             organizationId: Int,
             isActive : Boolean,
             created : DateTime ,
             createdBy : Int ,
             updated : DateTime = DateTime.now,
             updatedBy :Int,
             isRegistered: Boolean,
             recordId: Int,
             description: String,
             locationId: Int,
             isInProduction: Boolean,
             startProductionDate: DateTime ,
             isAllowPublish: Boolean ,
             isAllowStatistics: Boolean,
             platformInfo: String,
             industryInfo: String,
             salesVolume: Int,
             currencyId: Int,
             numberEmployees: Int ,
             processing: Boolean,
             remoteHost: String,
             remoteAddress: String,
             uuid: String) = Registration(registrationId, tenantId, systemId, organizationId, isActive,
    created, createdBy, updated, updatedBy, isRegistered, None, None, None, isInProduction, startProductionDate,
    isAllowPublish, isAllowStatistics, None, None, salesVolume, None, numberEmployees, None, None, None, None)
}



