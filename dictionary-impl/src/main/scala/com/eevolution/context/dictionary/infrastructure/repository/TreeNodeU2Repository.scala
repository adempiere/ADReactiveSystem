package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.TreeNodeU2
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
  * Tree Node U2 Repository
  * @param session
  * @param executionContext
  */

class TreeNodeU2Repository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.TreeNodeU2Repository[TreeNodeU2 , Int]
    with TreeNodeU2Mapping {

  def getById(id: Int): Future[TreeNodeU2] = {
    getByNode(id , 0)
  }

  def getByNode(id: Int , node : Int): Future[TreeNodeU2] = {
    Future(run(queryTreeNodeU2.filter(treeNodeU2 => treeNodeU2.treeId == lift(id)
      && treeNodeU2.nodeId == lift(node))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[TreeNodeU2] = {
    Future(run(queryTreeNodeU2.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByTreeNodeU2Id(id : Int) : Future[List[TreeNodeU2]] = {
    Future(run(queryTreeNodeU2))
  }

  def getAll() : Future[List[TreeNodeU2]] = {
    Future(run(queryTreeNodeU2))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[TreeNodeU2]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countTreeNodeU2()
      elements <- if (offset > count) Future.successful(Nil)
      else selectTreeNodeU2(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countTreeNodeU2() = {
    Future(run(queryTreeNodeU2.size).toInt)
  }


  private def selectTreeNodeU2(offset: Int, limit: Int): Future[Seq[TreeNodeU2]] = {
    Future(run(queryTreeNodeU2).drop(offset).take(limit).toSeq)
  }
}
