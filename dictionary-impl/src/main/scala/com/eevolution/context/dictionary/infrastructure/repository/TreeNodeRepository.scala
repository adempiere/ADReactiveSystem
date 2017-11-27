package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.TreeNode
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
  * Tree Node Repository
  * @param session
  * @param executionContext
  */

class TreeNodeRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.TreeNodeRepository[TreeNode , Int]
    with TreeNodeMapping {

  def getById(id: Int): Future[TreeNode] = {
    getByNode(id , 0)
  }

  def getByNode(id: Int , node : Int): Future[TreeNode] = {
    Future(run(queryTreeNode.filter(treeNode => treeNode.treeId == lift(id)
      && treeNode.nodeId == lift(node))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[TreeNode] = {
    Future(run(queryTreeNode.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByTreeNodeId(id : Int) : Future[List[TreeNode]] = {
    Future(run(queryTreeNode))
  }

  def getAll() : Future[List[TreeNode]] = {
    Future(run(queryTreeNode))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[TreeNode]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countTreeNode()
      elements <- if (offset > count) Future.successful(Nil)
      else selectTreeNode(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countTreeNode() = {
    Future(run(queryTreeNode.size).toInt)
  }


  private def selectTreeNode(offset: Int, limit: Int): Future[Seq[TreeNode]] = {
    Future(run(queryTreeNode).drop(offset).take(limit).toSeq)
  }
}
