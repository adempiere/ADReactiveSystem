package com.eevolution.context.dictionary.domain.model


import java.util.Date

import ai.x.play.json.Jsonx
import com.eevolution.context.dictionary.api._
import com.eevolution.context.dictionary.domain.model.EntityType.Dictionary

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
  * Created by victor.perez@e-evolution.com , www.e-evolution.com
  */

/**
  * Entity for Application Dictionary
  * @param entityId
  * @param isActive
  * @param created
  * @param createdBy
  * @param updated
  * @param updatedBy
  * @param name
  * @param description
  * @param help
  * @param tableName
  * @param isView
  * @param accessLevel
  * @param entityType
  * @param windowId
  * @param windowPOId
  * @param valueRuleId
  * @param loadSeq
  * @param isSecurityEnabled
  * @param isDeleteable
  * @param isHighVolume
  * @param isImporttable
  * @param isChangeLog
  * @param replicationType
  * @param copyColumnsFromTable
  * @param isCentrallyMaintained
  * @param acTriggerLength
  * @param isDocument
  * @param isIgnoreMigration
  * @param attributes
  */
case class Entity(entityId: Int,
                  isActive: Boolean = true,
                  created: Date = new Date(),
                  createdBy: Int,
                  updated: Date = new Date(),
                  updatedBy: Int,
                  name: String,
                  description: Option[String],
                  help: Option[String],
                  tableName: String,
                  isView: Boolean = false,
                  accessLevel: String,
                  entityType: String = Dictionary,
                  windowId: Option[Int],
                  windowPOId: Option[Int],
                  valueRuleId: Option[Int],
                  loadSeq: Option[Int],
                  isSecurityEnabled: Boolean = false,
                  isDeleteable: Boolean = false,
                  isHighVolume: Boolean = false,
                  isImporttable: Boolean = false,
                  isChangeLog: Boolean = false,
                  replicationType: String = "L",
                  copyColumnsFromTable: Option[String],
                  isCentrallyMaintained: Boolean = true,
                  acTriggerLength: Int,
                  isDocument: Boolean = false,
                  isIgnoreMigration: Boolean = false
) extends DomainModel
  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = entityId

  override val entityName: String = "AD_Table"
  override val identifier: String = "AD_Table_ID"
}

/**
  * Entity Singleton
  */
object Entity  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Entity]
  def create(entityId: Int,
             isActive: Boolean,
             created: Date,
             createdBy: Int,
             updated: Date,
             updatedBy: Int,
             name: String,
             description: String,
             help: String,
             tableName: String,
             isView: Boolean,
             accessLevel: String,
             entityType: String,
             windowId: Int,
             windowPOId: Int,
             valueRuleId: Int,
             loadSeq: Int,
             isSecurityEnabled: Boolean,
             isDeleteable: Boolean,
             isHighVolume: Boolean,
             isImporttable: Boolean,
             isChangeLog: Boolean ,
             replicationType: String,
             copyColumnsFromTable: String ,
             isCentrallyMaintained: Boolean,
             acTriggerLength: Int,
             isDocument: Boolean ,
             isIgnoreMigration: Boolean) = Entity(entityId, isActive, created, createdBy, updated, updatedBy, name,
    None, None, tableName, isView, accessLevel, entityType, None, None, None,
    None, isSecurityEnabled, isDeleteable, isHighVolume, isImporttable, isChangeLog ,
    replicationType , None ,  isCentrallyMaintained, acTriggerLength, isDocument, isIgnoreMigration)

}
