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
  * Memo Entity
  * @param memoId Memo ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param tableId Table ID
  * @param created Created
  * @param createdBy Created By
  * @param isActive Is Active
  * @param recordId Record ID
  * @param updated Updated
  * @param updatedBy Updated By
  * @param comments Comments
  * @param userId User ID
  * @param activityId Activity ID
  * @param bPartnerId Business Partner ID
  * @param campaignId Campaign ID
  * @param projectId Project ID
  * @param productId Product ID
  * @param isAlert Is Alert
  * @param uuid UUID
  */

case class Memo(memoId: Int,
                tenantId : Int ,
                organizationId : Int,
                tableId: Int,
                created: DateTime = DateTime.now,
                createdBy: Int,
                isActive: Boolean = true,
                recordId: Int,
                updated: DateTime = DateTime.now,
                updatedBy: Int,
                comments: Option[String],
                userId: Option[Int],
                activityId: Option[Int],
                bPartnerId: Option[Int],
                campaignId: Option[Int],
                projectId: Option[Int],
                productId: Option[Int],
                isAlert: Option[Boolean],
                uuid: Option[String]
               ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = memoId

  override val entityName: String = "AD_Memo"
  override val identifier: String = "AD_Memo_ID"
}

object Memo {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Memo]
  def create(memoId: Int,
             tenantId : Int ,
             organizationId : Int,
             tableId: Int,
             created: DateTime,
             createdBy: Int,
             isActive: Boolean,
             recordId: Int,
             updated: DateTime,
             updatedBy: Int,
             comments: String,
             userId: Int,
             activityId: Int,
             bPartnerId: Int,
             campaignId: Int,
             projectId: Int,
             productId: Int,
             isAlert: Boolean,
             uuid: String) = Memo(memoId, tenantId, organizationId, tableId, created, createdBy, isActive, recordId,
    updated, updatedBy,None, None, None, None, None, None, None, None, None)
}
