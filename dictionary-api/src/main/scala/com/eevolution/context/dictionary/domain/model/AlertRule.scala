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
  * Alert Rule Entity
  * @param alertRuleId Alert Rule ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param alertId Alert ID
  * @param selectClause Select Clause
  * @param fromClause From Clause
  * @param whereClause Where Clause
  * @param entityId Table ID
  * @param preProcessing Pre Processing
  * @param postProcessing Post Processing
  * @param isValid Is Valid
  * @param errorMsg Error Msg
  * @param otherClause Other Clause
  * @param uuid UUID
  */

case class AlertRule(alertRuleId: Int,
                     tenantId: Int,
                     organizationId: Int,
                     isActive: Boolean = true,
                     created: DateTime = DateTime.now,
                     createdBy: Int,
                     updated: DateTime = DateTime.now,
                     updatedBy: Int,
                     name: String,
                     alertId: Int,
                     selectClause: String,
                     fromClause: String,
                     whereClause: Option[String],
                     entityId: Option[Int],
                     preProcessing: Option[String],
                     postProcessing: Option[String],
                     isValid: Boolean = true,
                     errorMsg: Option[String],
                     otherClause: Option[String],
                     uuid: String
                    ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = alertRuleId

  override val entityName: String = "AD_AlertRule"
  override val identifier: String = "AD_AlertRule_ID"
}

object AlertRule  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[AlertRule]
  def create(alertRuleId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             alertId: Int,
             selectClause: String,
             fromClause: String,
             whereClause: String,
             entityId: Int,
             preProcessing: String,
             postProcessing: String,
             isValid: Boolean,
             errorMsg:String,
             otherClause: String,
             uuid: String) = AlertRule(alertId, tenantId, organizationId, isActive, created, createdBy, updated,
    updatedBy, name, alertId, selectClause, fromClause, None, None, None, None, isValid, None, None, uuid)
}



