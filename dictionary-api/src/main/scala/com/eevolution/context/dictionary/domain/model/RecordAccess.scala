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
  * Record Access Entity
  * @param recordAccessId Record Access ID
  * @param roleId Role ID
  * @param tableId Table ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param isReadOnly Is Read Only
  * @param isExclude Is Exclude
  * @param isDependentEntities Is Dependent Entities
  * @param uuid UUID
  */

case class RecordAccess(recordAccessId: Int,
                        roleId: Int,
                        tableId: Int,
                        isActive: Boolean = true,
                        created: DateTime = DateTime.now,
                        createdBy: Int,
                        updated: DateTime = DateTime.now,
                        updatedBy: Int,
                        isReadOnly: Boolean = false,
                        isExclude: Boolean = true,
                        isDependentEntities: Boolean = false,
                        uuid: Option[String]
                       ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = recordAccessId

  override val entityName: String = "AD_Record_Access"
  override val identifier: String = "AD_Record_Access_ID"
}

object RecordAccess  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[RecordAccess]
  def create(recordAccessId: Int,
             roleId: Int,
             tableId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             isReadOnly: Boolean,
             isExclude: Boolean,
             isDependentEntities: Boolean,
             uuid: String) = RecordAccess(recordAccessId, roleId, tableId, isActive, created, createdBy,
    updated, updatedBy, isReadOnly, isExclude, isDependentEntities, None)
}





