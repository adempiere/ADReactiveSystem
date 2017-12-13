package com.eevolution.context.dictionary.infrastructure.service.impl

import java.util.UUID

import com.eevolution.context.dictionary.infrastructure.repository.AttachmentNoteRepository
import com.eevolution.context.dictionary.infrastructure.service.AttachmentNoteService
import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.lightbend.lagom.scaladsl.persistence.PersistentEntityRegistry

class AttachmentNoteServiceImpl(registry: PersistentEntityRegistry, attachmentNoteRepository: AttachmentNoteRepository) extends AttachmentNoteService {

  private val DefaultPageSize = 10

  override def getAll() = ServiceCall {_ => attachmentNoteRepository.getAll()}

  override def getAllByPage(page : Option[Int], pageSize : Option[Int]) =  ServiceCall{_ => attachmentNoteRepository.getAllByPage(page.getOrElse(0) , pageSize.getOrElse(DefaultPageSize))}

  override def getById(id: Int) = ServiceCall { _ => attachmentNoteRepository.getById(id)}

  override def getByUUID(uuid: UUID) = ServiceCall { _ => attachmentNoteRepository.getByUUID(uuid)}
}
