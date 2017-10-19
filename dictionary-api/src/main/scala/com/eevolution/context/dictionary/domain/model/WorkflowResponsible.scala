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
  * Workflow Responsive Entity
  * @param workflowResponsibleId Wf Responsible ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param description Description
  * @param responsibleType Responsible Type
  * @param userId User ID
  * @param roleId Role ID
  * @param entityType Entity Type
  * @param uuid UUID
  */

case class WorkflowResponsible(workflowResponsibleId: Int,
                               tenantId: Int,
                               organizationId: Int,
                               isActive: Boolean = true,
                               created: DateTime = DateTime.now,
                               createdBy: Int,
                               updated: DateTime = DateTime.now,
                               updatedBy: Int,
                               name: String,
                               description: Option[String],
                               responsibleType: Boolean,
                               userId: Option[Int],
                               roleId: Option[Int],
                               entityType: String = "D",
                               uuid: String
                              ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = workflowResponsibleId

  override val entityName: String = "AD_Wf_Responsible"
  override val identifier: String = "AD_Wf_Responsible_ID"
}

object WorkflowResponsible {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[WorkflowResponsible]
  def create(workflowResponsibleId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             description: String,
             responsibleType: Boolean,
             userId: Int,
             roleId: Int,
             entityType: String,
             uuid: String) = WorkflowResponsible(workflowResponsibleId, tenantId, organizationId, isActive, created,
    createdBy, updated, updatedBy, name, None, responsibleType, None, None, entityType, uuid)
}

