package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.MigrationStep
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
  * Migration Step Repository
  * @param session
  * @param executionContext
  */

class MigrationStepRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.MigrationStepRepository[MigrationStep , Int]
    with MigrationStepMapping {

  def getById(id: Int): Future[MigrationStep] = {
    Future(run(queryMigrationStep.filter(_.migrationStepId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[MigrationStep] = {
    Future(run(queryMigrationStep.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByMigrationStepId(id : Int) : Future[List[MigrationStep]] = {
    Future(run(queryMigrationStep))
  }

  def getAll() : Future[List[MigrationStep]] = {
    Future(run(queryMigrationStep))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[MigrationStep]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countMigrationStep()
      elements <- if (offset > count) Future.successful(Nil)
      else selectMigrationStep(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countMigrationStep() = {
    Future(run(queryMigrationStep.size).toInt)
  }

  private def selectMigrationStep(offset: Int, limit: Int): Future[Seq[MigrationStep]] = {
    Future(run(queryMigrationStep).drop(offset).take(limit).toSeq)
  }
}
