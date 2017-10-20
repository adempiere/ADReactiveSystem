package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.Issue
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
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 20/10/17.
  */

/**
  * Issue Mapping
  */

trait IssueMapping {
  val queryIssue = quote {
    querySchema[Issue]("AD_Issue",
      _.issueId-> "AD_Issue_ID",
      _.tenantId -> "AD_Client_ID" ,
      _.organizationId -> "AD_Org_ID",
      _.isActive-> "IsActive",
      _.created-> "Created",
      _.createdBy-> "CreatedBy",
      _.updated-> "Updated",
      _.updatedBy-> "UpdatedBy",
      _.releaseNo-> "ReleaseNo",
      _.version-> "Version",
      _.name-> "Name",
      _.username-> "UserName",
      _.supportEmail-> "SupportEmail",
      _.dbAddress-> "DBAddress",
      _.localHost-> "Local_Host",
      _.operatingSystemInfo-> "OperatingSystemInfo",
      _.releaseTag-> "ReleaseTag",
      _.databaseInfo-> "DatabaseInfo",
      _.javaInfo-> "JavaInfo",
      _.remoteAddress-> "Remote_Addr",
      _.remoteHost-> "Remote_Host",
      _.issueSummary-> "IssueSummary",
      _.comments-> "Comments",
      _.sourceLassName-> "SourceClassName",
      _.sourceMetHodName-> "SourceMetHodName",
      _.loggerName-> "LoggerName",
      _.lineNo-> "LineNo",
      _.stackTrace-> "StackTrace",
      _.errorTrace-> "ErrorTrace",
      _.recordId-> "Record_ID",
      _.requestDocumentNo-> "RequestDocumentNo",
      _.assetId-> "A_Asset_ID",
      _.requestId-> "R_Request_ID",
      _.responseText-> "ResponseText",
      _.processing-> "Processing",
      _.processed-> "Processed",
      _.isVanillaSystem-> "IsVanillaSystem",
      _.isReproducible -> "IsReproducible",
      _.issueKnownId-> "R_IssueKnown_ID",
      _.statisticsInfo-> "StatisticsInfo",
      _.profileInfo-> "ProfileInfo",
      _.systemStatus-> "SystemStatus",
      _.issueProjectId-> "R_IssueProject_ID",
      _.issueUserId-> "R_IssueUser_ID",
      _.issueSystemId-> "R_IssueSystem_ID",
      _.issueSource-> "IssueSource",
      _.windowId-> "AD_Window_ID",
      _.processId-> "AD_Process_ID",
      _.formId-> "AD_Form_ID",
      _.uuid-> "UUID")
  }
}
