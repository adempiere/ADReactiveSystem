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
  * House Keeping Entity
  * @param houseKeepingId House Keeping Id
  * @param tableId Table ID
  * @param backupFolder Backup Folder
  * @param created Created
  * @param createdBy Created By
  * @param description Description
  * @param help Help
  * @param isActive Is Active
  * @param isExportXmlBackup Is Export XML Backup
  * @param isSaveInHistoric Is Save In Historic
  * @param lastDeleted Last Deleted
  * @param lastRun Last Run
  * @param name Name
  * @param processing Processing
  * @param updated Updated
  * @param updatedBy Updated By
  * @param value  Value
  * @param whereClause Where Clause
  * @param uuid UUID
  */

case class HouseKeeping (houseKeepingId: Int,
                         tableId: Int,
                         backupFolder: Option[String],
                         created: DateTime = DateTime.now,
                         createdBy: Int,
                         description: Option[String],
                         help: Option[String],
                         isActive: Boolean = true,
                         isExportXmlBackup: Option[Boolean],
                         isSaveInHistoric: Option[Boolean],
                         lastDeleted: Option[Int],
                         lastRun: DateTime = new DateTime,
                         name: String,
                         processing: Option[Boolean],
                         updated: DateTime = DateTime.now,
                         updatedBy: Int,
                         value: String,
                         whereClause: Option[String],
                         uuid: Option[String]
                        ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = houseKeepingId

  override val entityName: String = "AD_HouseKeeping"
  override val identifier: String = "AD_HouseKeeping_ID"
}

object HouseKeeping  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[HouseKeeping]
  def create(houseKeepingId: Int,
             tableId: Int,
             backupFolder: String,
             created: DateTime,
             createdBy: Int,
             description: String,
             help: Option[String],
             isActive: Boolean,
             isExportXmlBackup: Boolean,
             isSaveInHistoric: Boolean,
             lastDeleted: Int,
             lastRun: DateTime,
             name: String,
             processing: Boolean,
             updated: DateTime,
             updatedBy: Int,
             value: String,
             whereClause: String,
             uuid: String) = HouseKeeping(houseKeepingId, tableId, None, created, createdBy, None, None,
    isActive, None, None, None, lastRun, name, None, updated, updatedBy, value, None, None)
}

