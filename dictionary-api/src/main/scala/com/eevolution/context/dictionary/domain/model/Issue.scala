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
  * Issue Entity
  * @param issueId Issue ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param releaseNo release No
  * @param version Version
  * @param name Name
  * @param username Username
  * @param supportEmail Support Email
  * @param dbAddress DB Address
  * @param localHost Local Host
  * @param operatingSystemInfo Operating System Info
  * @param releaseTag Release Tag
  * @param databaseInfo Database Info
  * @param javaInfo Java Info
  * @param remoteAddress Remote Address
  * @param remoteHost Remote Host
  * @param issueSummary Issue Summary
  * @param comments Comments
  * @param sourceLassName Source Lass Name
  * @param sourceMetHodName Source Met Hod Name
  * @param loggerName Logger Name
  * @param lineNo Line No
  * @param stackTrace Stack Trace
  * @param errorTrace Error Trace
  * @param recordId Record ID
  * @param requestDocumentNo Request Document No
  * @param assetId Asset ID
  * @param requestId Request ID
  * @param responseText Response Text
  * @param processing Processing
  * @param processed Processed
  * @param isVanillaSystem Is Vanilla System
  * @param isReproducible Is Reproducible
  * @param issueKnownId Issue Known ID
  * @param statisticsInfo Statistics Info
  * @param profileInfo Profile Info
  * @param systemStatus System Status
  * @param issueProjectId Issue Project ID
  * @param issueUserId Issue User ID
  * @param issueSystemId Issue System ID
  * @param issueSource Issue Source
  * @param windowId Window ID
  * @param processId Process ID
  * @param formId Form ID
  * @param uuId UU ID
  */

case class Issue(issueId: Int,
                 isActive: Boolean,
                 created: DateTime = DateTime.now,
                 createdBy: Int,
                 updated: DateTime = DateTime.now,
                 updatedBy: Int,
                 releaseNo: String,
                 version: String,
                 name: String,
                 username: String,
                 supportEmail: Option[String],
                 dbAddress: Option[String],
                 localHost: Option[String],
                 operatingSystemInfo: Option[String],
                 releaseTag: Option[String],
                 databaseInfo: Option[String],
                 javaInfo: Option[String],
                 remoteAddress: Option[String],
                 remoteHost: Option[String],
                 issueSummary: String,
                 comments: Option[String],
                 sourceLassName: Option[String],
                 sourceMetHodName: Option[String],
                 loggerName: Option[String],
                 lineNo: Int = 0,
                 stackTrace: Option[String],
                 errorTrace: Option[String],
                 recordId: Option[Int],
                 requestDocumentNo: Option[String],
                 assetId: Option[Int],
                 requestId: Option[Int],
                 responseText: Option[String],
                 processing: Option[Boolean],
                 processed: Boolean = false,
                 isVanillaSystem: Boolean = false,
                 isReproducible : Boolean = false,
                 issueKnownId: Option[Int],
                 statisticsInfo: Option[String],
                 profileInfo: Option[String],
                 systemStatus: Boolean,
                 issueProjectId: Option[Int],
                 issueUserId: Option[Int],
                 issueSystemId: Option[Int],
                 issueSource: Option[Boolean],
                 windowId: Option[Int],
                 processId: Option[Int],
                 formId: Option[Int],
                 uuId: Option[String]
                ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = issueId

  override val entityName: String = "AD_Issue"
  override val identifier: String = "AD_Issue_ID"
}

object Issue  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Issue]
  def create(issueId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             releaseNo: String,
             version: String,
             name: String,
             username: String,
             supportEmail: String,
             dbAddress: String,
             localHost: String,
             operatingSystemInfo: String,
             releaseTag: String,
             databaseInfo: String,
             javaInfo: String,
             remoteAddress: String,
             remoteHost: String,
             issueSummary: String,
             comments: String,
             sourceLassName: String,
             sourceMetHodName: String,
             loggerName: String,
             lineNo: Int,
             stackTrace: String,
             errorTrace: String,
             recordId: Int,
             requestDocumentNo: String,
             assetId: Int,
             requestId: Int,
             responseText: String,
             processing: Boolean,
             processed: Boolean,
             isVanillaSystem: Boolean,
             isReproducible : Boolean,
             issueKnownId: Int,
             statisticsInfo: String,
             profileInfo: String,
             systemStatus: Boolean,
             issueProjectId: Int,
             issueUserId: Int,
             issueSystemId: Int,
             issueSource: Boolean,
             windowId: Int,
             processId: Int,
             formId: Int,
             uuId: String) = Issue(issueId, isActive, created, createdBy, updated, updatedBy, releaseNo,
    version, name, username, None, None, None, None, None, None, None, None, None, issueSummary, None, None, None,
    None, lineNo, None, None, None, None, None, None, None, None, processed, isVanillaSystem, isReproducible,
    None, None, None, systemStatus, None, None, None, None, None, None, None, None)
}


