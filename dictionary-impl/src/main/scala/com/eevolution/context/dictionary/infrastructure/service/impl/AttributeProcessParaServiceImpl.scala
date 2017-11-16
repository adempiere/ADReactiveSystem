package com.eevolution.context.dictionary.infrastructure.service.impl

import java.util.UUID

import com.eevolution.context.dictionary.infrastructure.repository.AttributeProcessParaRepository
import com.eevolution.context.dictionary.infrastructure.service.AttributeProcessParaService
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
  * Email: emeris.hernandez@e-evolution.com, http://www.e-evolution.com , http://github.com/EmerisScala
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 16/11/17.
  */

/**
  * Attribute Process Para Service Implementation
  * @param registry
  * @param attributeProcessParaRepository
  */

class AttributeProcessParaServiceImpl (registry: PersistentEntityRegistry, attributeProcessParaRepository: AttributeProcessParaRepository) extends AttributeProcessParaService {

  private val DefaultPageSize = 10

  override def getAll() = ServiceCall {_ => attributeProcessParaRepository.getAll()}

  override def getAllByPage(page : Option[Int], pageSize : Option[Int]) =  ServiceCall{_ => attributeProcessParaRepository.getAllByPage(page.getOrElse(0) , pageSize.getOrElse(DefaultPageSize))}

  override def getById(id: Int) = ServiceCall { _ => attributeProcessParaRepository.getById(id)}

  override def getByUUID(uuid: UUID) = ServiceCall { _ => attributeProcessParaRepository.getByUUID(uuid)}
}
