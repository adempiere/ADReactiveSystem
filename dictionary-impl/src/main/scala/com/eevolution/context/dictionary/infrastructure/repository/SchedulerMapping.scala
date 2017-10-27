package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.Scheduler
import com.eevolution.context.dictionary.infrastructure.db.DbContext._

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
  * Scheduler Mapping
  */
trait SchedulerMapping  {
  val queryScheduler = quote {
    querySchema[Scheduler]("AD_Scheduler",
      _.schedulerId -> "AD_Scheduler_ID",
      _.tenantId -> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.isActive -> "IsActive",
      _.created -> "Created",
      _.createdBy -> "CreatedBy",
      _.updated -> "Updated",
      _.updatedBy -> "UpdatedBy",
      _.name -> "Name",
      _.description -> "Description",
      _.processId -> "AD_Process_ID",
      _.frequencyType -> "FrequencyType",
      _.frequency -> "Frequency",
      _.dateLastRun -> "DateLastRun",
      _.dateNextRun -> "DateNextRun",
      _.supervisorId -> "Supervisor_ID",
      _.keepLogDays -> "KeepLogDays",
      _.processing -> "Processing",
      _.weekDay -> "WeekDay",
      _.scheduleType -> "ScheduleType",
      _.monthDay -> "MonthDay",
      _.isIgnoreProcessingTime -> "IsIgnoreProcessingTime",
      _.cronPattern -> "CronPattern",
      _.entityId -> "AD_Table_ID",
      _.recordId -> "Record_ID",
      _.uuid -> "UUID")
  }
}
