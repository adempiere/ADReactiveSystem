package com.eevolution.context.dictionary.infrastructure.service.impl

import java.util.UUID

import com.eevolution.context.dictionary.infrastructure.repository.{AttributeRepository}
import com.eevolution.context.dictionary.infrastructure.service.{AttributeService}
import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.lightbend.lagom.scaladsl.persistence.PersistentEntityRegistry

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
  * Attribute Access Service Implementation
  * @param registry
  * @param attributeRepository
  */

class AttributeServiceImpl(registry: PersistentEntityRegistry, attributeRepository: AttributeRepository) extends AttributeService {

  private val DefaultPageSize = 10

  override def getAll() = ServiceCall {_ => attributeRepository.getAll()}

  override def getAllByPage(page : Option[Int], pageSize : Option[Int]) =  ServiceCall{_ => attributeRepository.getAllByPage(page.getOrElse(0) , pageSize.getOrElse(DefaultPageSize))}

  override def getById(id: Int) = ServiceCall { _ => attributeRepository.getById(id)}

  override def getByUUID(uuid: UUID) = ServiceCall { _ => attributeRepository.getByUUID(uuid)}
}
