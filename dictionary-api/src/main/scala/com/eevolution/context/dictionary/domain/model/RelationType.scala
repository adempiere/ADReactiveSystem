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
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 12/10/2017.
  */

/**
  * Relation Type Entity
  * @param relationTypeId Relation Type ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param referenceSourceId Reference Source ID
  * @param referenceTargetId Reference Target ID
  * @param created Created
  * @param createdBy Created By
  * @param description Description
  * @param isActive Is Active
  * @param isDirected Is Directed
  * @param name Name
  * @param roleSource Role Source
  * @param roleTarget Role Target
  * @param typePackage Type Package
  * @param updated Updated
  * @param updatedBy Updated By
  * @param uuid UUID
  */
case class RelationType(relationTypeId: Int,
                        tenantId: Int,
                        organizationId: Int,
                        referenceSourceId: Option[Int],
                        referenceTargetId: Option[Int],
                        created: DateTime = DateTime.now,
                        createdBy: Int,
                        description: Option[String],
                        isActive: Boolean = true,
                        isDirected: Boolean = false,
                        name: String,
                        roleSource: Option[String],
                        roleTarget: Option[String],
                        typePackage: String = "I",
                        updated: DateTime = DateTime.now,
                        updatedBy: Int,
                        uuid: Option[String]
                       ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = relationTypeId

  override val entityName: String = "AD_RelationType"
  override val identifier: String = "AD_RelationType_ID"
}

object RelationType  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[RelationType]
  def create(relationTypeId: Int,
             tenantId: Int,
             organizationId: Int,
             referenceSourceId: Int,
             referenceTargetId: Int,
             created: DateTime,
             createdBy: Int,
             description: String,
             isActive: Boolean,
             isDirected: Boolean,
             name: String,
             roleSource: String,
             roleTarget: String,
             typePackage: String,
             updated: DateTime,
             updatedBy: Int,
             uuid: String) = RelationType(relationTypeId, tenantId, organizationId, None, None, created,
    createdBy, None, isActive, isDirected, name, None, None, typePackage, updated, updatedBy, None)
}

