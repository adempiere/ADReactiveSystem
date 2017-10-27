package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.Rule
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
  * Email: emeris.hernandez@e-evolution.com, http://www.e-evolution.com , http://github.com/EmerisScala
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 27/10/17.
  */

/**
  * Rule Mapping
  */

trait RuleMapping {
  val queryRule = quote {
    querySchema[Rule]("AD_Rule",
      _.ruleId-> "AD_Rule_ID",
      _.tenantId -> "AD_Client_ID",
      _.organizationId -> "AD_Org_ID",
      _.accessLevel -> "AccessLevel",
      _.created -> "Created",
      _.createdBy -> "CreatedBy" ,
      _.description-> "Description",
      _.entityType-> "EntityType",
      _.eventType -> "EventType" ,
      _.help-> "Help",
      _.isActive -> "IsActive",
      _.name-> "Name",
      _.ruleType -> "RuleType",
      _.updated -> "Updated",
      _.updatedBy ->"UpdatedBy",
      _.value-> "Value",
      _.script -> "Script",
      _.uuid-> "UUID")
  }
}
