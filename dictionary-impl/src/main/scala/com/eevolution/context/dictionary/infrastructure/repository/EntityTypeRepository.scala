package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.EntityType
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
  * Email: emeris.hernandez@e-evolution.com, http://www.e-evolution.com , http://github.com/EmerisScala
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 07/11/17.
  */

/**
  * Entity Type Repository
  * @param session
  * @param executionContext
  */

class EntityTypeRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.EntityTypeRepository[EntityType , Int]
    with EntityTypeMapping {

  def getById(id: Int): Future[EntityType] = {
    Future(run(queryEntityType.filter(_.entityTypeId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[EntityType] = {
    Future(run(queryEntityType.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByEntityTypeId(id : Int) : Future[List[EntityType]] = {
    Future(run(queryEntityType))
  }

  def getAll() : Future[List[EntityType]] = {
    Future(run(queryEntityType))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[EntityType]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countEntityType()
      elements <- if (offset > count) Future.successful(Nil)
      else selectEntityType(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countEntityType() = {
    Future(run(queryEntityType.size).toInt)
  }

  private def selectEntityType(offset: Int, limit: Int): Future[Seq[EntityType]] = {
    Future(run(queryEntityType).drop(offset).take(limit).toSeq)
  }
}
