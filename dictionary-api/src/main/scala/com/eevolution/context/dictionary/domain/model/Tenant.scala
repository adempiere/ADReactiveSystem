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
  * Email: victor.perez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by victor.perez@e-evolution.com , www.e-evolution.com.
  * Modified by emeris.hernandez@e-evolution.com, www.e-evolution.com.
  */

/**
  * Tenant Entity
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param value Value
  * @param name Name
  * @param description Description
  * @param smTpHost Sm Tp Host
  * @param requestEmail Request Email
  * @param requestUser Request User
  * @param requestUserPW Request User Pw
  * @param requestFolder Request Folder
  * @param language Language
  * @param isMultilingualDocument Is Multilingual Document
  * @param isSmTpAuthorization Is Sm Tp Authorization
  * @param isUseBetaFunctions Is Use Beta Functions
  * @param LDAPQuery LDAP Query
  * @param modelValidationClasses modelValidationClasses
  * @param isAutoArchive Is Auto Archive
  * @param MMPolicy MM Policy
  * @param emailTest Email Test
  * @param isServerEmail Is Server Email
  * @param documentDir Document Dir
  * @param isPostImmediate Is Post Immediate
  * @param isCostImmediate Is Cost Immediate
  * @param IsStoreAttachmentsOnFileSystem Is Store Attachment On File System
  * @param windowsAttachmentPath Window Attachment Path
  * @param unixAttachmentPath Unix Attachment Path
  * @param isStoreArchiveOnFileSystem Is Store Archive On File System
  * @param windowsArchivePath Windows Archive Path
  * @param unixArchivePath Unix Archive Path
  * @param isUseASP Is Use ASP
  * @param replicationStrategyId Replication Strategy ID
  * @param emailConfigId Email Config ID
  */
case class Tenant(tenantId: Int,
                  organizationId : Int = 0 ,
                  isActive : Boolean = true,
                  created : DateTime =  DateTime.now,
                  createdBy : Int ,
                  updated : DateTime =  DateTime.now,
                  updatedBy : Int,
                  value : String ,
                  name: String,
                  description: Option[String],
                  smTpHost : Option[String] ,
                  requestEmail : Option[String] ,
                  requestUser : Option[String] ,
                  requestUserPW : Option[String] ,
                  requestFolder : Option[String] ,
                  language : Option[String] ,
                  isMultilingualDocument : Boolean = false ,
                  isSmTpAuthorization : Boolean = false ,
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
                  emailConfigId : Option[Int],
                  uuid: Option[String]
                 ) extends DomainModel

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

object Tenant  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Tenant]
  def create(clientId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             value: String,
             name: String,
             description:String,
             smTpHost: String,
             requestEmail: String,
             requestUser: String,
             requestUserPw: String,
             requestFolder: String,
             language: String,
             isMultilingualDocument: Boolean,
             isSmTpAuthorization: Boolean,
             isUseBetaFunctions: Boolean,
             ldapQuery: String,
             modelValidationClasses: String,
             autoArchive: Boolean,
             mmPolicy: String,
             emailTest: Boolean,
             isServerEmail: Boolean,
             documentDir: String,
             isPostImmediate: Boolean,
             isCostImmediate: Boolean,
             storeAttachmentSonFileSystem: Boolean,
             windowsAttachmentPath: String,
             unixAttachmentPath: String,
             storeArchiveOnFileSystem: Boolean,
             windowsArchivePath: String,
             unixArchivePath: String,
             isUseAsp: Boolean,
             replicationStrategyId: Int,
             emailConfigId: Int,
             uuid: String) = Tenant(clientId, organizationId, isActive, created, createdBy, updated, updatedBy, value,
    name, None, None, None, None, None, None, None, isMultilingualDocument, isSmTpAuthorization,
    isUseBetaFunctions, None, None, autoArchive, mmPolicy, None, isServerEmail, None,
    isPostImmediate, isCostImmediate, storeAttachmentSonFileSystem, None, None,
    storeArchiveOnFileSystem, None, None, isUseAsp, None, None, None)
}
