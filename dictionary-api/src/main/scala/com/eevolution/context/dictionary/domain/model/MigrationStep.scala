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
  * Migration Step Entity
  * @param migrationStepId Migration Step ID
  * @param migrationId Migration ID
  * @param entityId Table ID
  * @param action Action
  * @param apply Apply
  * @param comments Comments
  * @param created Created
  * @param createdBy Created By
  * @param dbType DB Type
  * @param errorMsg Error Msg
  * @param isActive is Active
  * @param recordId Record ID
  * @param seqNo Seq No
  * @param statusCode Status Code
  * @param stepType Step Type
  * @param updated Updated
  * @param updatedBy Updated By
  * @param parse Parse
  * @param sqlStatement SQL Statement
  * @param rollBackStatement Roll Back Statement
  * @param uuid UUID
  */

case class MigrationStep(migrationStepId: Int,
                         tenantId: Int,
                         organizationId: Int,
                         migrationId: Int,
                         entityId: Option[Int],
                         action: Option[Boolean],
                         apply: Option[Boolean],
                         comments: Option[String],
                         created: DateTime =  DateTime.now,
                         createdBy: Int,
                         dbType: String = "ALL",
                         errorMsg: Option[String],
                         isActive: Boolean = true,
                         recordId: Option[Int],
                         seqNo: Int,
                         statusCode: Option[Boolean],
                         stepType: String,
                         updated: DateTime =  DateTime.now,
                         updatedBy: Int,
                         parse: Boolean = true,
                         sqlStatement: Option[String],
                         rollBackStatement: Option[String],
                         uuid: String
                        ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = migrationStepId

  override val entityName: String = "AD_MigrationStep"
  override val identifier: String = "AD_MigrationStep_ID"
}

object MigrationStep  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[MigrationStep]
  def create(migrationStepId: Int,
             tenantId: Int,
             organizationId: Int,
             migrationId: Int,
             entityId: Int,
             action: Boolean,
             apply: Boolean,
             comments: String,
             created: DateTime,
             createdBy: Int,
             dbType: String,
             errorMsg: String,
             isActive: Boolean,
             recordId: Int,
             seqNo: Int,
             statusCode: Boolean,
             stepType: String,
             updated: DateTime,
             updatedBy: Int,
             parse: Boolean,
             sqlStatement: String,
             rollBackStatement: String,
             uuid: String) = MigrationStep(migrationStepId, tenantId, organizationId, migrationId, None,
    None, None, None, created, createdBy, dbType, None, isActive, None, seqNo, None, stepType, updated,
    updatedBy, parse, None, None, uuid)
}

