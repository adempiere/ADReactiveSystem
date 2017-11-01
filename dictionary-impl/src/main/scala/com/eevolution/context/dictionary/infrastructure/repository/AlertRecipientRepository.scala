package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.AlertRecipient
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
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 01/11/17.
  */

/**
  * Alert Recipient Repository
  * @param session
  * @param executionContext
  */

class AlertRecipientRepository(session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.AlertRecipientRepository[AlertRecipient , Int]
    with AlertRecipientMapping {

  def getById(id: Int): Future[AlertRecipient] = {
    Future(run(queryAlertRecipient.filter(_.alertRecipientId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[AlertRecipient] = {
    Future(run(queryAlertRecipient.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByAlertRecipientId(id : Int) : Future[List[AlertRecipient]] = {
    Future(run(queryAlertRecipient))
  }

  def getAll() : Future[List[AlertRecipient]] = {
    Future(run(queryAlertRecipient))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[AlertRecipient]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countAlertRecipient()
      elements <- if (offset > count) Future.successful(Nil)
      else selectAlertRecipient(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countAlertRecipient() = {
    Future(run(queryAlertRecipient.size).toInt)
  }

  private def selectAlertRecipient(offset: Int, limit: Int): Future[Seq[AlertRecipient]] = {
    Future(run(queryAlertRecipient).drop(offset).take(limit).toSeq)
  }
}
