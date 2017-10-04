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
  * Print Label Line Trl Entity
  * @param printLabelLineTrlId Print Label Linel Trl ID
  * @param language Language
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param printName Printed Name
  * @param isTranslated In Translated
  * @param uuId UU ID
  */

case class PrintLabelLineTrl (printLabelLineTrlId: Int,
                              language: String,
                              isActive: Boolean = true,
                              created: DateTime = DateTime.now,
                              createdBy: Int,
                              updated: DateTime = DateTime.now,
                              updatedBy: Int,
                              printName: Option[String],
                              isTranslated: Boolean = false,
                              uuId: Option[String]
                             ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = printLabelLineTrlId

  override val entityName: String = "AD_PrintLabelLineTrl"
  override val identifier: String = "AD_PrintLabelLineTrl_ID"

}

object PrintLabelLineTrl {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PrintLabelLineTrl]
  def create(printLabelLineTrlId: Int,
             language: String,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             printName: String,
             isTranslated: Boolean,
             uuId: String) = PrintLabelLineTrl(printLabelLineTrlId, language, isActive, created, createdBy, updated,
    updatedBy, None, isTranslated, None)
}
