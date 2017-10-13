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
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 13/10/2017.
  */

/**
  * Role Included Entity
  * @param includedRoleId Include Role ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param roleId Role ID
  * @param created Created
  * @param createdBy Created By
  * @param isActive Is Active
  * @param seqNo Seq No
  * @param updated Updated
  * @param updatedBy Updated By
  * @param uuid UUID
  */

case class RoleIncluded(includedRoleId: Int,
                        tenantId : Int ,
                        organizationId : Int ,
                        roleId: Int,
                        created : DateTime = DateTime.now,
                        createdBy : Int ,
                        isActive : Boolean = true,
                        seqNo: Int,
                        updated : DateTime = DateTime.now ,
                        updatedBy : Int,
                        uuid: Option[String]
                       ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = includedRoleId

  override val entityName: String = "AD_Role_Included"
  override val identifier: String = "Included_Role_ID"
}

object RoleIncluded  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[RoleIncluded]
  def create(includedRoleId: Int,
             tenantId : Int ,
             organizationId : Int ,
             roleId: Int,
             created : DateTime,
             createdBy : Int ,
             isActive : Boolean,
             seqNo: Int,
             updated : DateTime,
             updatedBy : Int,
             uuid: String) = RoleIncluded(includedRoleId, tenantId, organizationId, roleId, created, createdBy, isActive,
    seqNo, updated, updatedBy, None)
}
