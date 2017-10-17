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
  * Email Config Entity
  * @param emailConfigId Email Config ID
  * @param authMechanism Auth Mechanism
  * @param connectionTimeOut Connection Time Out
  * @param created Created
  * @param createdBy Created By
  * @param description Description
  * @param encryptionType Encryption Type
  * @param isActive Is Active
  * @param isSmTpAuthorization Is Sm Tp Authorization
  * @param ldapDomain Ldap Domain
  * @param name Name
  * @param port Port
  * @param protocol Protocol
  * @param smTpHost Sm Tp Host
  * @param timeOut Time Out
  * @param updated Updated
  * @param updatedBy Updated By
  * @param uuid UUID
  */

case class EmailConfig(emailConfigId: Int,
                       tenantId: Int,
                       organizationId: Int,
                       authMechanism: String = "L",
                       connectionTimeOut: Int = 0,
                       created: DateTime = DateTime.now,
                       createdBy: Int,
                       description: Option[String],
                       encryptionType: Boolean = false,
                       isActive: Boolean = true,
                       isSmTpAuthorization: Boolean = false,
                       ldapDomain: Option[String],
                       name: String,
                       port: Int,
                       protocol: Boolean,
                       smTpHost: String,
                       timeOut: Int = 0,
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

  override def Id: Int = emailConfigId

  override val entityName: String = "AD_EmailConfig"
  override val identifier: String = "AD_EmailConfig_ID"
}

object EmailConfig {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[EmailConfig]
  def create(emailConfigId: Int,
             tenantId: Int,
             organizationId: Int,
             authMechanism: String,
             connectionTimeOut: Int,
             created: DateTime,
             createdBy: Int,
             description: String,
             encryptionType: Boolean,
             isActive: Boolean,
             isSmTpAuthorization: Boolean,
             ldapDomain: String,
             name: String,
             port: Int,
             protocol: Boolean,
             smTpHost: String,
             timeOut: Int,
             updated: DateTime,
             updatedBy: Int,
             uuid: String) = EmailConfig(emailConfigId, tenantId, organizationId, authMechanism, connectionTimeOut,
    created, createdBy, None, encryptionType, isActive, isSmTpAuthorization, None, name, port, protocol, smTpHost,
    timeOut, updated, updatedBy, None)
}

