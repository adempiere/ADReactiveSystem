package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.Issue
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
  * Issue Repository
  * @param session
  * @param executionContext
  */

class IssueRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.IssueRepository[Issue , Int]
    with IssueMapping {

  def getById(id: Int): Future[Issue] = {
    Future(run(queryIssue.filter(_.issueId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[Issue] = {
    Future(run(queryIssue.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByIssueId(id : Int) : Future[List[Issue]] = {
    Future(run(queryIssue))
  }

  def getAll() : Future[List[Issue]] = {
    Future(run(queryIssue))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[Issue]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countIssue()
      elements <- if (offset > count) Future.successful(Nil)
      else selectIssue(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countIssue() = {
    Future(run(queryIssue.size).toInt)
  }

  private def selectIssue(offset: Int, limit: Int): Future[Seq[Issue]] = {
    Future(run(queryIssue).drop(offset).take(limit).toSeq)
  }
}
