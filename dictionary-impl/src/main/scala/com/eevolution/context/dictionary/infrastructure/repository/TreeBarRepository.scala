package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.TreeBar
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
  * Email: eduardo.moreno@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by eduardo.moreno@e-evolution.com , www.e-evolution.com
  */

/**
  * Tree Bar Repository
  * @param session
  * @param executionContext
  */

class TreeBarRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.TreeBarRepository[TreeBar , Int]
    with TreeBarMapping {

  def getById(id: Int): Future[TreeBar] = {
    getByUser(id , 0)
  }

  def getByUser(id: Int, user: Int): Future[TreeBar] = {
    getByNode(id, user, 0)
  }

  def getByNode(id: Int , user: Int, node: Int): Future[TreeBar] = {
    Future(run(queryTreeBar.filter(treeBar => treeBar.treeId == lift(id)
      && treeBar.userId == lift(user) && treeBar.nodeId == lift(node))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[TreeBar] = {
    Future(run(queryTreeBar.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByTreeBarId(id : Int) : Future[List[TreeBar]] = {
    Future(run(queryTreeBar))
  }

  def getAll() : Future[List[TreeBar]] = {
    Future(run(queryTreeBar))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[TreeBar]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countTreeBar()
      elements <- if (offset > count) Future.successful(Nil)
      else selectTreeBar(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countTreeBar() = {
    Future(run(queryTreeBar.size).toInt)
  }


  private def selectTreeBar(offset: Int, limit: Int): Future[Seq[TreeBar]] = {
    Future(run(queryTreeBar).drop(offset).take(limit).toSeq)
  }
}
