package com.eevolution.context.dictionary.domain.model

import java.util.Date

import com.eevolution.context.dictionary.api.{ActiveEnabled, DomainModel, Identifiable, Traceable}
import play.api.libs.json.{Format, Json}

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
  * Created by victor.perez@e-evolution.com , www.e-evolution.com
  */

/**
  * Entity for Element
  * @param elementId
  * @param isActive
  * @param created
  * @param createdBy
  * @param updated
  * @param updatedBy
  * @param columnName
  * @param name
  * @param description
  * @param help
  * @param printName
  * @param namePO
  * @param descriptionPO
  * @param helpPO
  * @param printNamePO
  * @param referenceId
  * @param referenceValueId
  * @param fieldLength
  * @param entityType
  */
case class Element(elementId: Int,
                   isActive: Boolean = true,
                   created: Date = new Date(),
                   createdBy: Int,
                   updated: Date = new Date(),
                   updatedBy: Int,
                   columnName: String,
                   name: String,
                   description: Option[String],
                   help: Option[String],
                   printName: Option[String],
                   namePO: Option[String],
                   descriptionPO : Option[String],
                   helpPO: Option[String],
                   printNamePO: Option[String],
                   referenceId: Option[Int],
                   referenceValueId: Option[Int],
                   fieldLength: Option[Int],
                   entityType: String) extends DomainModel
with ActiveEnabled
with Identifiable
with Traceable{
  override type DomainModel = this.type
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = elementId
  override val entityName: String = "AD_Element"
  override val identifier: String = "AD_Element_ID"
}

object Element {
  implicit val format: Format[Element] = Json.format
  def create(
             elementId: Int,
             isActive: Boolean,
             created: Date,
             createdBy: Int,
             updated: Date,
             updatedBy: Int,
             columnName: String,
             name: String,
             description: String,
             help: String,
             printName: String,
             namePO: String,
             descriptionPO: String,
             helpPO: String,
             printNamePO: String,
             referenceId: Int,
             fieldLength: Int,
             referenceValueId: Int,
             entityType: String) = Element(elementId, isActive , created , createdBy , updated , updatedBy , columnName, name, None, None, None, None, None, None, None, None, None, None, entityType)
}