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
  * Session Entity
  * @param sessionId Session ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param webSession Web Session
  * @param remoteAddr  remote Addr
  * @param remoteHost Remote Host
  * @param processed Processed
  * @param description Description
  * @param roleId Role ID
  * @param loginDate Login Date
  * @param uuid UU ID
  */

case class Session (sessionId: Int,
                    tenantId: Int,
                    organizationId: Int,
                    isActive: Boolean,
                    created: DateTime,
                    createdBy: Int,
                    updated: DateTime,
                    updatedBy: Int,
                    webSession: Option[String],
                    remoteAddr: Option[String],
                    remoteHost: Option[String],
                    processed: Boolean = false,
                    description: Option[String],
                    roleId: Option[Int],
                    loginDate: Option[DateTime],
                    uuid: String
                   ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = sessionId

  override val entityName: String = "AD_Session"
  override val identifier: String = "AD_Session_ID"

}

object Session {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Session]
  def create(sessionId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             webSession: String,
             remoteAddr: String,
             remoteHost: String,
             processed: Boolean,
             description: String,
             roleId: Int,
             loginDate: DateTime,
             uuid: String) = Session(sessionId, tenantId, organizationId, isActive, created, createdBy, updated,
    updatedBy, None, None, None, processed, None, None, None, uuid)
}
