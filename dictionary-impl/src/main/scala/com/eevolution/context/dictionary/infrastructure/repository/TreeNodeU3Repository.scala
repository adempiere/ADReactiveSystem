package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.TreeNodeU3
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
  * Tree Node U3 Repository
  * @param session
  * @param executionContext
  */

class TreeNodeU3Repository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.TreeNodeU3Repository[TreeNodeU3 , Int]
    with TreeNodeU3Mapping {

  def getById(id: Int): Future[TreeNodeU3] = {
    getByNode(id , 0)
  }

  def getByNode(id: Int , node : Int): Future[TreeNodeU3] = {
    Future(run(queryTreeNodeU3.filter(treeNodeU3 => treeNodeU3.treeId == lift(id)
      && treeNodeU3.nodeId == lift(node))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[TreeNodeU3] = {
    Future(run(queryTreeNodeU3.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByTreeNodeU3Id(id : Int) : Future[List[TreeNodeU3]] = {
    Future(run(queryTreeNodeU3))
  }

  def getAll() : Future[List[TreeNodeU3]] = {
    Future(run(queryTreeNodeU3))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[TreeNodeU3]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countTreeNodeU3()
      elements <- if (offset > count) Future.successful(Nil)
      else selectTreeNodeU3(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countTreeNodeU3() = {
    Future(run(queryTreeNodeU3.size).toInt)
  }


  private def selectTreeNodeU3(offset: Int, limit: Int): Future[Seq[TreeNodeU3]] = {
    Future(run(queryTreeNodeU3).drop(offset).take(limit).toSeq)
  }
}
