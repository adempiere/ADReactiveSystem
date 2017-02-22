package com.eevolution.context.dictionary.infrastructure.service.impl

import java.util.UUID

import com.eevolution.context.dictionary.infrastructure.repository.ElementRepository
import com.eevolution.context.dictionary.infrastructure.service.ElementService
import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.lightbend.lagom.scaladsl.persistence.PersistentEntityRegistry

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
  * Element Service Implementation
  * @param registry
  * @param elementRepository
  */
class ElementServiceImpl (registry: PersistentEntityRegistry, elementRepository: ElementRepository) extends ElementService {

  private val DefaultPageSize = 10

  override def getElements(page : Option[Int], pageSize : Option[Int]) =  ServiceCall{_ => elementRepository.getElements(page.getOrElse(0) , pageSize.getOrElse(DefaultPageSize))}

  override def getElementById(id: Int) = ServiceCall { _ => elementRepository.getElementById(id)}

  override def getElementByUUID(uuid: UUID) = ServiceCall { _ => elementRepository.getElementByUUID(uuid)}
}
