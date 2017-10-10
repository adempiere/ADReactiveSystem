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
  * Chart Date Source Entity
  * @param chartDataSourceId Chart Data Source ID
  * @param chartId Chart ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param tableId Table ID
  * @param categoryColumn Category Column
  * @param created Created
  * @param createdBy Created By
  * @param dateColumn Date Column
  * @param description Description
  * @param entityType Entity Type
  * @param fromClause From Clause
  * @param isActive Is Active
  * @param keyColumn Key Column
  * @param Name Name
  * @param updated Updated
  * @param updatedBy Updated By
  * @param valueColumn Value Column
  * @param whereClause Where Clause
  * @param timeOffSet Time Off Set
  * @param seriesColumn Series Column
  * @param uuid UUID
  */

case class ChartDataSource (chartDataSourceId: Int,
                            chartId: Int,
                            tenantId: Int,
                            organizationId: Int,
                            tableId: Option[Int],
                            categoryColumn: Option[String],
                            created: DateTime = DateTime.now,
                            createdBy: Int,
                            dateColumn: Option[String],
                            description: Option[String],
                            entityType: String = "D",
                            fromClause: String,
                            isActive: Boolean = true,
                            keyColumn: Option[String],
                            Name: String,
                            updated: DateTime = DateTime.now,
                            updatedBy: Int,
                            valueColumn: String,
                            whereClause: String,
                            timeOffSet: Option[Int],
                            seriesColumn: Option[String],
                            uuid: Option[String]
                           ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = chartDataSourceId

  override val entityName: String = "AD_ChartDataSource"
  override val identifier: String = "AD_ChartDataSource_ID"

}

object ChartDataSource {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[ChartDataSource]
  def create(chartDataSourceId: Int,
             chartId: Int,
             tenantId: Int,
             organizationId: Int,
             tableId: Int,
             categoryColumn: String,
             created:  DateTime,
             createdBy: Int,
             dateColumn: String,
             description: String,
             entityType: String,
             fromClause: String,
             isActive: Boolean,
             keyColumn: String,
             Name: String,
             updated:  DateTime,
             updatedBy: Int,
             valueColumn: String,
             whereClause: String,
             timeOffSet:Int,
             seriesColumn: String,
             uuid: String) = ChartDataSource(chartDataSourceId, chartId, tenantId, organizationId, None, None, created, createdBy, None,
    None, entityType, fromClause, isActive, None, Name, updated, updatedBy, valueColumn, whereClause, None, None, None)
}
