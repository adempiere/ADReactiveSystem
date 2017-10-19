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
  * Pin Stance Log Entity
  * @param pinStanceLogId Pin Stance Log ID
  * @param pinStanceId Pin Stance ID
  * @param date Date
  * @param id ID
  * @param number Number
  * @param msg Msg
  * @param createdBy Created By
  * @param created Created
  * @param updatedBy Updated By
  * @param updated Updated
  * @param isActive Is Active
  * @param uuid UUID
  */

case class PinStanceLog(pinStanceLogId: Int,
                        pinStanceId: Int,
                        date: DateTime = DateTime.now,
                        id: Option[Int],
                        number: Option[Int],
                        msg: Option[String],
                        createdBy: Int,
                        created: DateTime = DateTime.now,
                        updatedBy: Int,
                        updated: DateTime = DateTime.now,
                        isActive: Boolean = true,
                        uuid: String
                       ) extends DomainModel


  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = pinStanceLogId

  override val entityName: String = "AD_PinStance_Log"
  override val identifier: String = "AD_PinStance_Log_ID"
}

object PinStanceLog  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PinStanceLog]
  def create(pinStanceLogId: Int,
             pinStanceId: Int,
             date: DateTime,
             id: Int,
             number: Int,
             msg: String,
             createdBy: Int,
             created: DateTime,
             updatedBy: Int,
             updated: DateTime,
             isActive: Boolean,
             uuid: String) = PinStanceLog(pinStanceLogId, pinStanceId, date, None, None, None, createdBy,
    created, updatedBy, updated, isActive, uuid)
}