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
  * Chart Entity
  * @param chartId Chart ID
  * @param chartType Chart Type
  * @param created Created
  * @param createdBy Created By
  * @param description Description
  * @param isActive Is Active
  * @param name Name
  * @param updated Updated
  * @param updatedBy Updated By
  * @param winHeight Win Height
  * @param isDisplayLegend Is Display Legend
  * @param chartOrientation Chart Orientation
  * @param isTimeSeries Is Time Series
  * @param timeUnit Time Unit
  * @param timeScope Time Scope
  * @param domainLabel Domain Label
  * @param rageLabel Range Label
  * @param uuId UU ID
  */


case class Chart (chartId: Int,
                  chartType: String,
                  created: DateTime = DateTime.now,
                  createdBy: Int,
                  description: String,
                  isActive: Boolean,
                  name: String,
                  updated: DateTime = DateTime.now,
                  updatedBy: Int,
                  winHeight: Option[Int],
                  isDisplayLegend: Boolean = true,
                  chartOrientation: String = "V",
                  isTimeSeries: Boolean = false,
                  timeUnit: Option[Boolean],
                  timeScope: Option[Int],
                  domainLabel: Option[String],
                  rageLabel: Option[String],
                  uuId: Option[String]
                 ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = chartId

  override val entityName: String = "AD_Chart"
  override val identifier: String = "AD_Chart_ID"

}

object Chart {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Chart]
  def create(chartId: Int,
             chartType: String,
             created: DateTime,
             createdBy: Int,
             description: String,
             isActive: Boolean,
             name: String,
             updated: DateTime,
             updatedBy: Int,
             winHeight: Int,
             isDisplayLegend: Boolean,
             chartOrientation: String,
             isTimeSeries: Boolean,
             timeUnit: Boolean,
             timeScope: Int,
             domainLabel: String,
             rageLabel: String,
             uuId: String) = Chart(chartId, chartType, created, createdBy, description, isActive, name, updated,
    updatedBy, None, isDisplayLegend, chartOrientation, isTimeSeries, None, None, None, None, None)
}
