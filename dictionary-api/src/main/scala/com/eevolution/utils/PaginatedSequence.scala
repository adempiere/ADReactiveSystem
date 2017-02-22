package com.eevolution.utils

import play.api.libs.json._
import play.api.libs.functional.syntax._

/**
  * Copyright (C) 2003-2017, e-Evolution Consultants S.A. , http://www.e-evolution.com
  * This program is free software: you can redistribute it and/or modify
  * it under the terms of the GNU Affero General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU Affero General Public License for more details.
  * You should have received a copy of the GNU Affero General Public License
  * along with this program.  If not, see <http://www.gnu.org/licenses/>.
  * Email: victor.perez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by victor.perez@e-evolution.com , www.e-evolution.com
  */

/**
  * Paginated Sequence
  * @param items
  * @param page
  * @param pageSize
  * @param count
  * @tparam T
  */
case class PaginatedSequence[T](
  items: Seq[T],
  page: Int,
  pageSize: Int,
  count: Int
) {

  def isEmpty: Boolean = items.isEmpty
  def isFirst: Boolean = page == 0
  def isLast: Boolean = count <= (page + 1) * pageSize
  def isPaged: Boolean = count > pageSize
  def pageCount: Int = ((count - 1) / pageSize) + 1
}

/**
  * Paginated Sequence
  */
object PaginatedSequence {
  implicit def format[T: Format]: Format[PaginatedSequence[T]] = {
    (
      (__ \ "items").format[Seq[T]] and
      (__ \ "page").format[Int] and
      (__ \ "pageSize").format[Int] and
      (__ \ "count").format[Int]
    ).apply(PaginatedSequence.apply, unlift(PaginatedSequence.unapply))
  }
}
