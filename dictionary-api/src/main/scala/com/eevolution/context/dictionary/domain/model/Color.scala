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
  * Color Entity
  * @param colorId Color ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param isDefault is Default
  * @param colorType Color Type
  * @param red Red
  * @param green Green
  * @param blue Blue
  * @param alpha Alpha
  * @param imageId Image ID
  * @param imageAlpha Image Alpha
  * @param red1 Red 1
  * @param green1 Green 1
  * @param blue1 Blue 1
  * @param alpha1 Alpha 1
  * @param lineWidth Line Width
  * @param lineDistance Line Distance
  * @param startPoint Start Point
  * @param repeatDistance Repeat Distance
  * @param uuid UUID
  */

case class Color(colorId: Int,
                 isActive: Boolean = true,
                 created: DateTime =  DateTime.now(),
                 createdBy: Int,
                 updated: DateTime =  DateTime.now(),
                 updatedBy: Int,
                 name: String,
                 isDefault: Boolean=false,
                 colorType: Boolean,
                 red: Int,
                 green: Int,
                 blue: Int,
                 alpha: Int,
                 imageId: Option[Int],
                 imageAlpha:Int,
                 red1: Option[Int],
                 green1: Option[Int],
                 blue1: Option[Int],
                 alpha1: Option[Int],
                 lineWidth: Option[Int],
                 lineDistance: Option[Int],
                 startPoint: Option[Int],
                 repeatDistance: Option[Int],
                 uuid: Option[String]
                ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable{
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int =colorId

  override val entityName: String = "AD_Color"
  override val identifier: String = "AD_Color_ID"

}

object Color {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Color]
  def create(colorId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             isDefault: Boolean,
             colorType: Boolean,
             red: Int,
             green: Int,
             blue: Int,
             alpha: Int,
             imageId: Int,
             imageAlpha:Int,
             red1: Int,
             green1: Int,
             blue1: Int,
             alpha1: Int,
             lineWidth: Int,
             lineDistance: Int,
             startPoint: Int,
             repeatDistance: Int,
             uuid: String) = Color(colorId, isActive, created, createdBy, updated,
    updatedBy, name, isDefault, colorType, red, green, blue, alpha, None, imageAlpha, None,
    None, None, None, None, None, None, None, None)
}
