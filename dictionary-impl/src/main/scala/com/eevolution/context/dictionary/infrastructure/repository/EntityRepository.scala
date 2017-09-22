package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.api._
import com.eevolution.context.dictionary.domain.model.{Attribute, Entity}
import com.eevolution.context.dictionary.infrastructure.db.DbContext._
import com.eevolution.utils.PaginatedSequence
import com.lightbend.lagom.scaladsl.persistence.jdbc.JdbcSession

import scala.concurrent.{ExecutionContext, Future}

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
  * Entity Repository
  * @param session
  * @param executionContext
  */
class EntityRepository(session: JdbcSession)(implicit executionContext: ExecutionContext) extends Repostory[Entity , Int]
  with EntityMapping
  with AttributeMapping {

  def getById(id: Int): Future[Entity] = {
    Future(run(queryEntity.filter(_.entityId == lift(id))).headOption.get)
  }

  def getAttributes(id: Int): Future[List[Attribute]] = {
    Future(run(queryAttribute.filter(_.entityId == lift(id))))
  }

  def getByUUID(uuid: UUID): Future[Entity] = {
    Future(run(queryEntity.filter(_.name == lift(uuid.toString))).headOption.get)
  }

  def getAll() : Future[List[Entity]] = {
    Future(run(queryEntity))
  }

  def getAll(page: Int, pageSize: Int): Future[PaginatedSequence[Entity]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countEntity()
      elements <- if (offset > count) Future.successful(Nil)
      else selectEntity(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countEntity() = {
    Future(run(queryEntity.size).toInt)
  }

  private def selectEntity(offset: Int, limit: Int): Future[Seq[Entity]] = {
    Future(run(queryEntity).drop(offset).take(limit).toSeq)
  }
}