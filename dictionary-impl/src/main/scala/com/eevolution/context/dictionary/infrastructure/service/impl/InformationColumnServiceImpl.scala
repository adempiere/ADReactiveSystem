package com.eevolution.context.dictionary.infrastructure.service.impl

import java.util.UUID

import com.eevolution.context.dictionary.infrastructure.repository.InformationColumnRepository
import com.eevolution.context.dictionary.infrastructure.service.InformationColumnService
import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.lightbend.lagom.scaladsl.persistence.PersistentEntityRegistry

class InformationColumnServiceImpl (registry: PersistentEntityRegistry, informationColumnRepository: InformationColumnRepository) extends InformationColumnService {

  private val DefaultPageSize = 10

  override def getAll() = ServiceCall {_ => informationColumnRepository.getAll()}

  override def getAllByPage(page : Option[Int], pageSize : Option[Int]) =  ServiceCall{_ => informationColumnRepository.getAllByPage(page.getOrElse(0) , pageSize.getOrElse(DefaultPageSize))}

  override def getById(id: Int) = ServiceCall { _ => informationColumnRepository.getById(id)}

  override def getByUUID(uuid: UUID) = ServiceCall { _ => informationColumnRepository.getByUUID(uuid)}
}
