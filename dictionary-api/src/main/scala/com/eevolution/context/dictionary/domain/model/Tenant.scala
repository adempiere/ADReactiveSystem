package com.eevolution.context.dictionary.domain.model

import java.util.Date
import com.eevolution.context.dictionary.api.{ActiveEnabled, DomainModel, Identifiable, Traceable}


/**
  * Copyright (C) 2003-2017, e-Evolution Consultants S.A. , http://www.e-evolution.com
  * This program is free software: you can redistribute it and/or modify
  * it under the terms of the GNU Affero General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU Affero General Public License for more details.
  * You should have received a copy of the GNU Affero General Public License
  * along with this program.  If not, see <http://www.gnu.org/licenses/>.
  * Email: victor.perez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by victor.perez@e-evolution.com , www.e-evolution.com
  */

/**
  * Tenant Entity
  * @param tenantId
  * @param organizationId
  * @param isActive
  * @param created
  * @param createdBy
  * @param updated
  * @param updatedBy
  * @param value
  * @param name
  * @param description
  * @param smtpHost
  * @param requestEmail
  * @param requestUser
  * @param requestUserPW
  * @param requestFolder
  * @param language
  * @param isMultiLingualDocument
  * @param isSMTPAuthorization
  * @param isUseBetaFunctions
  * @param LDAPQuery
  * @param modelValidationClasses
  * @param isAutoArchive
  * @param MMPolicy
  * @param emailTest
  * @param isServerEmail
  * @param documentDir
  * @param isPostImmediate
  * @param isCostImmediate
  * @param IsStoreAttachmentsOnFileSystem
  * @param windowsAttachmentPath
  * @param unixAttachmentPath
  * @param isStoreArchiveOnFileSystem
  * @param windowsArchivePath
  * @param unixArchivePath
  * @param isUseASP
  * @param replicationStrategyId
  * @param emailConfigId
  */
case class Tenant(tenantId: Int,
                  organizationId : Int = 0 ,
                  isActive : Boolean = true,
                  created : Date = new Date(),
                  createdBy : Int ,
                  updated : Date = new Date(),
                  updatedBy : Int,
                  value : String ,
                  name: String,
                  description: Option[String],
                  smtpHost : Option[String] ,
                  requestEmail : Option[String] ,
                  requestUser : Option[String] ,
                  requestUserPW : Option[String] ,
                  requestFolder : Option[String] ,
                  language : Option[String] ,
                  isMultiLingualDocument : Boolean = false ,
                  isSMTPAuthorization : Boolean = false ,
                  isUseBetaFunctions : Boolean =  false ,
                  LDAPQuery : Option[String] ,
                  modelValidationClasses : Option[String] ,
                  isAutoArchive : Boolean = false ,
                  MMPolicy : String = "F" ,
                  emailTest : Option[String] ,
                  isServerEmail : Boolean = false ,
                  documentDir : Option[String] ,
                  isPostImmediate : Boolean =  false ,
                  isCostImmediate : Boolean =  false ,
                  IsStoreAttachmentsOnFileSystem : Boolean = false ,
                  windowsAttachmentPath : Option[String] ,
                  unixAttachmentPath : Option[String] ,
                  isStoreArchiveOnFileSystem : Boolean = false ,
                  windowsArchivePath : Option[String] ,
                  unixArchivePath : Option[String],
                  isUseASP : Boolean =  false ,
                  replicationStrategyId : Option[Int],
                  emailConfigId : Option[Int]) extends DomainModel
  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = tenantId

  override val entityName: String = "AD_Client"
  override val identifier: String = "AD_Client_ID"
}
