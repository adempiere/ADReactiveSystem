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
  * Column Process Para Entity
  * @param columnProcessParaId Column Process Para ID
  * @param columnProcessId Column Process ID
  * @param processParaId Process Para ID
  * @param created Created
  * @param createdBy Created By
  * @param defaultValue Default Value
  * @param isActive Is Active
  * @param updated Updated
  * @param updatedBy Updated By
  * @param uuId UU ID
  */

case class ColumnProcessPara(columnProcessParaId: Int,
                             columnProcessId: Option[Int],
                             processParaId: Option[Int],
                             created: DateTime = DateTime.now,
                             createdBy: Int,
                             defaultValue: Option[String],
                             isActive: Boolean,
                             updated: DateTime = DateTime.now,
                             updatedBy: Int,
                             uuId: Option [String]
                            ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = columnProcessParaId

  override val entityName: String = "AD_ColumnProcessPara"
  override val identifier: String = "AD_ColumnProcessPara_ID"
}

object ColumnProcessPara {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[ColumnProcessPara]
  def create(columnProcessParaId: Int,
             columnProcessId: Int,
             processParaId: Int,
             created: DateTime,
             createdBy: Int,
             defaultValue: String,
             isActive: Boolean,
             updated: DateTime,
             updatedBy: Int,
             uuId: String) = ColumnProcessPara(columnProcessParaId, None, None, created, createdBy, None,
    isActive, updated, updatedBy, None)
}

