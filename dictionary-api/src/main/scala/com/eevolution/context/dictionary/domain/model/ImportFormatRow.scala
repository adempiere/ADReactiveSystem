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
  * Imp Format Row Entity
  * @param importFormatRowId Imp Format Row ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Creted
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param importFormatId Imp Format Id
  * @param seqNo Seq No
  * @param name Name
  * @param columnId Column ID
  * @param startNo Start No
  * @param endNo End No
  * @param dataType Data Type
  * @param dataFormat Data Format
  * @param decimalPoint Decimal Point
  * @param divideBy100 Divide By 100
  * @param constantValue Constant Value
  * @param callout Call Out
  * @param script Script
  * @param defaultValue Default Value
  * @param uuid UUID
  */

case class ImportFormatRow(importFormatRowId: Int,
                           tenantId: Int,
                           organizationId: Int,
                           isActive: Boolean = true,
                           created: DateTime = DateTime.now,
                           createdBy: Int,
                           updated: DateTime = DateTime.now,
                           updatedBy: Int,
                           importFormatId: Int,
                           seqNo: Int,
                           name: String,
                           columnId: String,
                           startNo: Option[Int],
                           endNo: Option[Int],
                           dataType: Boolean,
                           dataFormat: Option[String],
                           decimalPoint: Boolean,
                           divideBy100: Boolean = false,
                           constantValue: Option[String],
                           callout: Option[String],
                           script: Option[String],
                           defaultValue: Option[String],
                           uuid: Option[String]
                        ) extends DomainModel


  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = importFormatRowId

  override val entityName: String = "AD_ImpFormat_Row"
  override val identifier: String = "AD_ImpFormat_Row_ID"

}

object ImportFormatRow {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[ImportFormatRow]

  def create(impportFormatRowId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             importFormatId: Int,
             seqNo: Int,
             name: String,
             columnId: String,
             startNo: Int,
             endNo: Int,
             dataType: Boolean,
             dataFormat: String,
             decimalPoint: Boolean,
             divideBy100: Boolean,
             constantValue: String,
             callout: String,
             script: String,
             defaultValue: String,
             uuid: String) = ImportFormatRow(impportFormatRowId, tenantId, organizationId, isActive, created, createdBy,
    updated, updatedBy, importFormatId, seqNo, name, columnId, None, None, dataType, None, decimalPoint, divideBy100,
    None, None, None, None, None)
}