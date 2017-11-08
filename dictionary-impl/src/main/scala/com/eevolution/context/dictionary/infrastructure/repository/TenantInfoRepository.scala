package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.TenantInfo
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
  * Tenant Info Repository
  * @param session
  * @param executionContext
  */

class TenantInfoRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.TenantInfoRepository[TenantInfo , Int]
    with TenantInfoMapping {

  //It doesn't have ID
  def getById(id: Int): Future[TenantInfo] = {
    Future(run(queryTenantInfo.filter(null)).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[TenantInfo] = {
    Future(run(queryTenantInfo.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByTenantInfoId(id : Int) : Future[List[TenantInfo]] = {
    Future(run(queryTenantInfo))
  }

  def getAll() : Future[List[TenantInfo]] = {
    Future(run(queryTenantInfo))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[TenantInfo]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countTenantInfo()
      elements <- if (offset > count) Future.successful(Nil)
      else selectTenantInfo(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countTenantInfo() = {
    Future(run(queryTenantInfo.size).toInt)
  }


  private def selectTenantInfo(offset: Int, limit: Int): Future[Seq[TenantInfo]] = {
    Future(run(queryTenantInfo).drop(offset).take(limit).toSeq)
  }
}
