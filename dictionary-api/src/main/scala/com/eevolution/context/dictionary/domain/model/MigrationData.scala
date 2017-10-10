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
  * Migration Data Entity
  * @param migrationDataId Migration Data ID
  * @param columnId Column ID
  * @param migrationStep Migration Step
  * @param backupValue Backup Value
  * @param created Created
  * @param createdBy Created By
  * @param isActive Is Active
  * @param isBackupNull Is Backup Null
  * @param isOldNull Is Old Null
  * @param isNewNull Is New Null
  * @param newValue New Value
  * @param oldValue Old Value
  * @param updated Updated
  * @param updatedBy Updated By
  * @param uuid UUID
  */

case class MigrationData (migrationDataId: Int,
                          columnId: Int,
                          migrationStep: Int,
                          backupValue: Option[String],
                          created: DateTime =  DateTime.now,
                          createdBy: Int,
                          isActive: Boolean = true,
                          isBackupNull: Option[Boolean],
                          isOldNull: Option[Boolean],
                          isNewNull: Option[Boolean],
                          newValue: Option[String],
                          oldValue: Option[String],
                          updated: DateTime =  DateTime.now,
                          updatedBy: Int,
                          uuid: Option [String]
                         ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = migrationDataId

  override val entityName: String = "AD_MigrationData"
  override val identifier: String = "AD_MigrationData_ID"
}

object MigrationData  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[MigrationData]
  def create(migrationDataId: Int,
             columnId: Int,
             migrationStep: Int,
             backupValue: String,
             created: DateTime,
             createdBy: Int,
             isActive: Boolean,
             isBackupNull: Boolean,
             isOldNull: Boolean,
             isNewNull: Boolean,
             newValue: String,
             oldValue: String,
             updated: DateTime,
             updatedBy: Int,
             uuid: String) = MigrationData(migrationDataId, columnId, migrationStep, None, created,
    createdBy, isActive, None, None, None, None, None, updated, updatedBy, None)
}

