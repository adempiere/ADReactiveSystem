package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.PackageImportInstall
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
  * Package Import Install Repository
  * @param session
  * @param executionContext
  */

class PackageImportInstallRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.PackageImportInstallRepository[PackageImportInstall , Int]
    with PackageImportInstallMapping {

  def getById(id: Int): Future[PackageImportInstall] = {
    Future(run(queryPackageImportInstall.filter(_.packageImportInstallId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[PackageImportInstall] = {
    Future(run(queryPackageImportInstall.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByPackageImportInstallId(id : Int) : Future[List[PackageImportInstall]] = {
    Future(run(queryPackageImportInstall))
  }

  def getAll() : Future[List[PackageImportInstall]] = {
    Future(run(queryPackageImportInstall))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[PackageImportInstall]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countPackageImportInstall()
      elements <- if (offset > count) Future.successful(Nil)
      else selectPackageImportInstall(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countPackageImportInstall() = {
    Future(run(queryPackageImportInstall.size).toInt)
  }

  private def selectPackageImportInstall(offset: Int, limit: Int): Future[Seq[PackageImportInstall]] = {
    Future(run(queryPackageImportInstall).drop(offset).take(limit).toSeq)
  }
}
