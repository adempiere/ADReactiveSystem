package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.TreeNodeCMC
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
  * Tree Node CMC Repository
  * @param session
  * @param executionContext
  */

class TreeNodeCMCRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.TreeNodeCMCRepository[TreeNodeCMC , Int]
    with TreeNodeCMCMapping {

  //It doesn't have ID
  def getById(id: Int): Future[TreeNodeCMC] = {
    Future(run(queryTreeNodeCMC.filter(null)).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[TreeNodeCMC] = {
    Future(run(queryTreeNodeCMC.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByTreeNodeCMCId(id : Int) : Future[List[TreeNodeCMC]] = {
    Future(run(queryTreeNodeCMC))
  }

  def getAll() : Future[List[TreeNodeCMC]] = {
    Future(run(queryTreeNodeCMC))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[TreeNodeCMC]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countTreeNodeCMC()
      elements <- if (offset > count) Future.successful(Nil)
      else selectTreeNodeCMC(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countTreeNodeCMC() = {
    Future(run(queryTreeNodeCMC.size).toInt)
  }


  private def selectTreeNodeCMC(offset: Int, limit: Int): Future[Seq[TreeNodeCMC]] = {
    Future(run(queryTreeNodeCMC).drop(offset).take(limit).toSeq)
  }
}
