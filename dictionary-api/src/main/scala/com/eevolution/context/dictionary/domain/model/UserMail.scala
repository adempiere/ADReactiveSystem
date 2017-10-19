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
  * User Mail Entity
  * @param userMailId User Mail ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param userId user ID
  * @param mailTextId Mail Text ID
  * @param mailMsgId Mail Msg ID
  * @param messageId Message ID
  * @param deliveryConfirmation Delivery Confirmation
  * @param isDelivered Is Delivered
  * @param subject Subject
  * @param mailText Mail Text
  * @param uuid UUID
  */

case class UserMail (userMailId: Int,
                     tenantId: Int,
                     organizationId: Int,
                     isActive: Boolean = true,
                     created: DateTime = DateTime.now,
                     createdBy: Int,
                     updated: DateTime = DateTime.now,
                     updatedBy: Int,
                     userId: Int,
                     mailTextId: Option[Int],
                     mailMsgId: Option[Int],
                     messageId: Option[String],
                     deliveryConfirmation: Option[String],
                     isDelivered: Option[Boolean],
                     subject: Option[String],
                     mailText: Option[String],
                     uuid: String
                    ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = userMailId

  override val entityName: String = "AD_UserMail"
  override val identifier: String = "AD_UserMail_ID"
}

object UserMail  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[UserMail]
  def create(userMailId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             userId: Int,
             mailTextId: Int,
             mailMsgId: Int,
             messageId: String,
             deliveryConfirmation: String,
             isDelivered: Boolean,
             subject: String,
             mailText: String,
             uuid: String) = UserMail(userMailId, tenantId, organizationId, isActive, created, createdBy,
    updated, updatedBy, userId, None, None, None, None, None, None, None, uuid)
}
