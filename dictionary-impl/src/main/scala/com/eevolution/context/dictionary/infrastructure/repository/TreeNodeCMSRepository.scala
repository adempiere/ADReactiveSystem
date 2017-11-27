package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.TreeNodeCMS
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
  * Tree Node CMS Repository
  * @param session
  * @param executionContext
  */

class TreeNodeCMSRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.TreeNodeCMSRepository[TreeNodeCMS , Int]
    with TreeNodeCMSMapping {

  def getById(id: Int): Future[TreeNodeCMS] = {
    getByNode(id , 0)
  }

  def getByNode(id: Int , node : Int): Future[TreeNodeCMS] = {
    Future(run(queryTreeNodeCMS.filter(treeNodeCMS => treeNodeCMS.treeId == lift(id)
      && treeNodeCMS.nodeId == lift(node))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[TreeNodeCMS] = {
    Future(run(queryTreeNodeCMS.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByTreeNodeCMSId(id : Int) : Future[List[TreeNodeCMS]] = {
    Future(run(queryTreeNodeCMS))
  }

  def getAll() : Future[List[TreeNodeCMS]] = {
    Future(run(queryTreeNodeCMS))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[TreeNodeCMS]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countTreeNodeCMS()
      elements <- if (offset > count) Future.successful(Nil)
      else selectTreeNodeCMS(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countTreeNodeCMS() = {
    Future(run(queryTreeNodeCMS.size).toInt)
  }


  private def selectTreeNodeCMS(offset: Int, limit: Int): Future[Seq[TreeNodeCMS]] = {
    Future(run(queryTreeNodeCMS).drop(offset).take(limit).toSeq)
  }
}
