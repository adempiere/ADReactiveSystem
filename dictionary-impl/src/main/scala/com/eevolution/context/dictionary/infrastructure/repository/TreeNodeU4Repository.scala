package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.TreeNodeU4
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
  * Tree Node U4 Repository
  * @param session
  * @param executionContext
  */

class TreeNodeU4Repository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.TreeNodeU4Repository[TreeNodeU4 , Int]
    with TreeNodeU4Mapping {

  def getById(id: Int): Future[TreeNodeU4] = {
    getByNode(id , 0)
  }

  def getByNode(id: Int , node : Int): Future[TreeNodeU4] = {
    Future(run(queryTreeNodeU4.filter(treeNodeU4 => treeNodeU4.treeId == lift(id)
      && treeNodeU4.nodeId == lift(node))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[TreeNodeU4] = {
    Future(run(queryTreeNodeU4.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByTreeNodeU4Id(id : Int) : Future[List[TreeNodeU4]] = {
    Future(run(queryTreeNodeU4))
  }

  def getAll() : Future[List[TreeNodeU4]] = {
    Future(run(queryTreeNodeU4))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[TreeNodeU4]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countTreeNodeU4()
      elements <- if (offset > count) Future.successful(Nil)
      else selectTreeNodeU4(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countTreeNodeU4() = {
    Future(run(queryTreeNodeU4.size).toInt)
  }


  private def selectTreeNodeU4(offset: Int, limit: Int): Future[Seq[TreeNodeU4]] = {
    Future(run(queryTreeNodeU4).drop(offset).take(limit).toSeq)
  }
}
