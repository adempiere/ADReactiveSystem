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
  * Pin Stance Entity
  * @param pinStanceId Pin Stance ID
  * @param processId Process ID
  * @param recordId Record ID
  * @param isProcessing Is Processing
  * @param created Created
  * @param userId User ID
  * @param updated Updated
  * @param result Result
  * @param errorMsg Error Msg
  * @param createdBy Created By
  * @param updatedBy Updated By
  * @param isActive Is Active
  * @param name Name
  * @param reportType Report Type
  * @param printFormatId Print Format ID
  * @param uuid UUID
  */

case class PinStance(pinStanceId: Int,
                     tenantId: Int,
                     organizationId: Int,
                     processId: Int,
                     recordId: Int,
                     isProcessing: Boolean = false,
                     created: DateTime = DateTime.now,
                     userId: Option[Int],
                     updated: DateTime = DateTime.now,
                     result: Option[String],
                     errorMsg: Option[String],
                     createdBy: Int,
                     updatedBy: Int,
                     isActive: Boolean = true,
                     name: String,
                     reportType: String = "P",
                     printFormatId: Option[Int],
                     uuid: Option[String]
                    ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = pinStanceId

  override val entityName: String = "AD_PinStance"
  override val identifier: String = "AD_PinStance_ID"
}

object PinStance  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PinStance]
  def create(pinStanceId: Int,
             tenantId: Int,
             organizationId: Int,
             processId: Int,
             recordId: Int,
             isProcessing: Boolean,
             created: DateTime,
             userId: Int,
             updated: DateTime,
             result: String,
             errorMsg: String,
             createdBy: Int,
             updatedBy: Int,
             isActive: Boolean,
             name: String,
             reportType: String,
             printFormatId: Int,
             uuid: String) = PinStance(pinStanceId, tenantId, organizationId, processId, recordId, isProcessing,
    created, None, updated, None, None, createdBy, updatedBy, isActive, name, reportType, None, None)
}

