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

case class MigrationStep(migrationStepId: Int,
                         migrationId: Int,
                         tableId: Option[Int],
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
                         uuId: Option[String]
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
             migrationId: Int,
             tableId: Option[Int],
             action: Option[Boolean],
             apply: Option[Boolean],
             comments: Option[String],
             created: DateTime =  DateTime.now(),
             createdBy: Int,
             dbType: String = "ALL",
             errorMsg: Option[String],
             isActive: Boolean = true,
             recordId: Option[Int],
             seqNo: Int,
             statusCode: Option[Boolean],
             stepType: String,
             updated: DateTime =  DateTime.now(),
             updatedBy: Int,
             parse: Boolean = true,
             sqlStatement: Option[String],
             rollBackStatement: Option[String],
             uuId: Option[String]) = MigrationStep(migrationStepId, migrationId, None, None, None, None, created,
    createdBy, dbType, None, isActive, None, seqNo, None, stepType, updated, updatedBy, parse, None, None, None)
}

