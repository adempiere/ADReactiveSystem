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
  * Created by victor.perez@e-evolution.com , www.e-evolution.com on 18/02/17.
  * Modified by emeris.hernandez@e-evolution.com, www.e-evolution.com on 11/10/2017.
  */

/**
  * Process Entity
  * @param processId Process ID
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
  * @param help Help
  * @param accessLevel Access Level
  * @param entityType Entity Type
  * @param procedureName Procedure Name
  * @param isReport Is Report
  * @param isDirectPrint Is Direct Print
  * @param reportViewId Report View ID
  * @param className Class Name
  * @param statisticCount Statistic Count
  * @param statisticSeconds Statistic Seconds
  * @param printFormatId Print Format ID
  * @param workflowValue Workflow Value
  * @param workflowId Workflow ID
  * @param isBetaFunctionality Is Beta Functionality
  * @param isServerProcess Is Server Process
  * @param isShowHelp Is Show Help
  * @param jasperReport Jasper Report
  * @param formId Form ID
  * @param copyFromProcess Copy From Process
  * @param browseId Browse ID
  * @param generateClass Generate Class
  * @param uuid UUID
  */



case class Process(processId: Int,
                   tenantId: Int,
                   organizationId: Int,
                   isActive : Boolean = true,
                   created : DateTime = DateTime.now,
                   createdBy : Int ,
                   updated :Int ,
                   updatedBy : DateTime = DateTime.now,
                   value : String ,
                   name : String,
                   description: Option[String],
                   help: Option[String],
                   accessLevel : String = "3",
                   entityType: String = EntityType.Dictionary,
                   procedureName : String ,
                   isReport : Boolean = false ,
                   isDirectPrint : Boolean = false,
                   reportViewId : Option[Int],
                   className  : Option[String],
                   statisticCount : Option[BigDecimal],
                   statisticSeconds : Option[BigDecimal],
                   printFormatId : Option[Int],
                   workflowValue : Option[String],
                   workflowId : Option[Int],
                   isBetaFunctionality : Boolean = false ,
                   isServerProcess : Boolean = false ,
                   isShowHelp : Boolean =  false,
                   jasperReport : Option[String],
                   formId : Option[Int],
                   copyFromProcess : Option[String],
                   browseId : Option[Int] ,
                   generateClass : Option[String],
                   uuid: Option[String]
                  ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = processId

  override val entityName: String = "AD_Process"
  override val identifier: String = "AD_Process_ID"
}

object Process {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Process]
  def create(processId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive : Boolean,
             created : DateTime,
             createdBy : Int ,
             updated :Int ,
             updatedBy : DateTime,
             value : String ,
             name : String,
             description: String,
             help: String,
             accessLevel : String,
             entityType: String,
             procedureName : String ,
             isReport : Boolean,
             isDirectPrint : Boolean,
             reportViewId : Int,
             className  : String,
             statisticCount : BigDecimal,
             statisticSeconds : BigDecimal,
             printFormatId : Int,
             workflowValue : String,
             workflowId : Int,
             isBetaFunctionality : Boolean,
             isServerProcess : Boolean,
             isShowHelp : Boolean,
             jasperReport : String,
             formId : Int,
             copyFromProcess : String,
             browseId : Int ,
             generateClass : String,
             uuid: String) = Process(processId, tenantId, organizationId, isActive, created, createdBy,
    updated, updatedBy, value, name, None, None, accessLevel, entityType, procedureName, isReport, isDirectPrint,
    None, None, None, None, None, None, None, isBetaFunctionality, isServerProcess, isShowHelp, None, None, None,
    None, None, None)
}
