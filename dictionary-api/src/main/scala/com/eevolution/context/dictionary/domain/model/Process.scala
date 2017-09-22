package com.eevolution.context.dictionary.domain.model

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
  */

/**
  * Process Entity
  * @param processId
  * @param isActive
  * @param created
  * @param createdBy
  * @param updated
  * @param updatedBy
  * @param value
  * @param name
  * @param description
  * @param help
  * @param accessLevel
  * @param entityType
  * @param procedureName
  * @param isReport
  * @param isDirectPrint
  * @param reportViewId
  * @param className
  * @param statisticCount
  * @param statisticSeconds
  * @param printFormatId
  * @param workflowValue
  * @param workflowId
  * @param isBetaFunctionality
  * @param isServerProcess
  * @param isShowHelp
  * @param jasperReport
  * @param formId
  * @param copyFromProcess
  * @param browseId
  * @param generateClass
  */
case class Process(processId: Int,
                   isActive : Boolean = true,
                   created : DateTime = DateTime.now(),
                   createdBy : Int ,
                   updated :Int ,
                   updatedBy : DateTime = DateTime.now(),
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
                   generateClass : Option[String]) {

  def Identity = "AD_Process_ID"

}
