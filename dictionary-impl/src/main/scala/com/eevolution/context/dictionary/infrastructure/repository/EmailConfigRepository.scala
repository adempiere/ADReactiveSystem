package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.EmailConfig
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
  * Email Config Repository
  * @param session
  * @param executionContext
  */

class EmailConfigRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.EmailConfigRepository[EmailConfig , Int]
    with EmailConfigMapping {

  def getById(id: Int): Future[EmailConfig] = {
    Future(run(queryEmailConfig.filter(_.emailConfigId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[EmailConfig] = {
    Future(run(queryEmailConfig.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByEmailConfigId(id : Int) : Future[List[EmailConfig]] = {
    Future(run(queryEmailConfig))
  }

  def getAll() : Future[List[EmailConfig]] = {
    Future(run(queryEmailConfig))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[EmailConfig]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countEmailConfig()
      elements <- if (offset > count) Future.successful(Nil)
      else selectEmailConfig(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countEmailConfig() = {
    Future(run(queryEmailConfig.size).toInt)
  }

  private def selectEmailConfig(offset: Int, limit: Int): Future[Seq[EmailConfig]] = {
    Future(run(queryEmailConfig).drop(offset).take(limit).toSeq)
  }
}
