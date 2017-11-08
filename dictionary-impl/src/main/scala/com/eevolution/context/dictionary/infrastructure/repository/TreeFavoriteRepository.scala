package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.TreeFavorite
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
  * Tree Favorite Repository
  * @param session
  * @param executionContext
  */

class TreeFavoriteRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.TreeFavoriteRepository[TreeFavorite , Int]
    with TreeFavoriteMapping {

  def getById(id: Int): Future[TreeFavorite] = {
    Future(run(queryTreeFavorite.filter(_.treeFavoriteId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[TreeFavorite] = {
    Future(run(queryTreeFavorite.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByTreeFavoriteId(id : Int) : Future[List[TreeFavorite]] = {
    Future(run(queryTreeFavorite))
  }

  def getAll() : Future[List[TreeFavorite]] = {
    Future(run(queryTreeFavorite))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[TreeFavorite]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countTreeFavorite()
      elements <- if (offset > count) Future.successful(Nil)
      else selectTreeFavorite(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countTreeFavorite() = {
    Future(run(queryTreeFavorite.size).toInt)
  }


  private def selectTreeFavorite(offset: Int, limit: Int): Future[Seq[TreeFavorite]] = {
    Future(run(queryTreeFavorite).drop(offset).take(limit).toSeq)
  }
}
