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
  * Email: eduardo.moreno@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by eduardo.moreno@e-evolution.com , www.e-evolution.com
  */
/**
  * Scheduler Entity
  * @param schedulerId Scheduler ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param description Description
  * @param processId Process ID
  * @param frequencyType Frequency Type
  * @param frequency Frequency
  * @param dateLastRun Date Last Run
  * @param dateNextRun Date Next Run
  * @param superVisorId Super Visor ID
  * @param keepLogDays Keep Log Days
  * @param processing Processing
  * @param weekDay Week Day
  * @param scheduleType Schedule Type
  * @param monthDay Month Day
  * @param isIgnoreProcessingTime Is Ignore Processing Time
  * @param cronPattern Cron Pattern
  * @param entityId Entity ID
  * @param recordId Record ID
  * @param uuId UU ID
  */

case class Scheduler (schedulerId: Int,
                      tenantId: Int,
                      organizationId: Int,
                      isActive: Boolean = true,
                      created: DateTime = DateTime.now,
                      createdBy: Int,
                      updated: DateTime = DateTime.now,
                      updatedBy: Int,
                      name: String,
                      description: Option[String],
                      processId: Int,
                      frequencyType: Boolean,
                      frequency: Int,
                      dateLastRun: Option[DateTime],
                      dateNextRun: Option[DateTime],
                      superVisorId: Int,
                      keepLogDays: Int,
                      processing: Option[Boolean],
                      weekDay: Option[Boolean],
                      scheduleType: String = "F",
                      monthDay: Option[Int],
                      isIgnoreProcessingTime: Boolean = false,
                      cronPattern: Option[String],
                      entityId: Option[Int],
                      recordId: Option[Int],
                      uuId: Option[String]
                     ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = schedulerId

  override val entityName: String = "AD_Scheduler"
  override val identifier: String = "AD_Scheduler_ID"

}

object Scheduler {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Scheduler]
  def create(schedulerId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive:Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             description: String,
             processId: Int,
             frequencyType: Boolean,
             frequency: Int,
             dateLastRun: DateTime,
             dateNextRun: DateTime,
             superVisorId: Int,
             keepLogDays: Int,
             processing: Boolean,
             weekDay: Boolean,
             scheduleType: String,
             monthDay: Int,
             isIgnoreProcessingTime: Boolean,
             cronPattern: String,
             entityId: Int,
             recordId: Int,
             uuId: String) = Scheduler(schedulerId, tenantId, organizationId, isActive, created, createdBy, updated, updatedBy, name,
    None, processId, frequencyType, frequency, None, None, superVisorId, keepLogDays, None, None, scheduleType,
    None, isIgnoreProcessingTime, None, None, None, None)
}
