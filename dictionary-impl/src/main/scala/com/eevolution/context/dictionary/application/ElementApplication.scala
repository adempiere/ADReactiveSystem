package com.eevolution.context.dictionary.application

import com.eevolution.context.dictionary.infrastructure.repository.ElementRepository
import com.eevolution.context.dictionary.infrastructure.service.ElementService
import com.eevolution.context.dictionary.infrastructure.service.impl.ElementServiceImpl
import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.persistence.jdbc.JdbcPersistenceComponents
import com.lightbend.lagom.scaladsl.server.{LagomServer, LagomServerComponents, _}
import com.softwaremill.macwire._
import play.api.Environment
import play.api.db.HikariCPComponents
import play.api.libs.ws.ahc.AhcWSComponents

import scala.concurrent.ExecutionContext

/**
  * Copyright (C) 2003-2017, e-Evolution Consultants S.A. , http://www.e-evolution.com
  * This program is free software: you can redistribute it and/or modify
  * it under the terms of the GNU Affero General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU Affero General Public License for more details.
  * You should have received a copy of the GNU Affero General Public License
  * along with this program.  If not, see <http://www.gnu.org/licenses/>.
  * Email: victor.perez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by victor.perez@e-evolution.com , www.e-evolution.com
  */

/**
  * Element Componet
  */
trait ElementComponents extends LagomServerComponents
  with JdbcPersistenceComponents
  with HikariCPComponents {

  implicit def executionContext: ExecutionContext
  def environment: Environment

  override lazy val lagomServer = LagomServer.forServices(
    bindService[ElementService].to(wire[ElementServiceImpl])
  )
  lazy val elementRepository = wire[ElementRepository]
  lazy val jsonSerializerRegistry = ElementSerializerRegistry
}

/**
  * Element Application
  * @param context
  */
abstract class ElementApplication (context: LagomApplicationContext) extends LagomApplication(context)
  with ElementComponents
  with AhcWSComponents {

  override lazy val lagomServer = LagomServer.forServices(
    bindService[ElementService].to(wire[ElementServiceImpl])
  )
  override lazy val elementRepository = wire[ElementRepository]
}

/**
  * Element Application Loader
  */
class ElementApplicationLoader extends LagomApplicationLoader {
  override def load(context: LagomApplicationContext) = new ElementApplication(context) {
    override def serviceLocator = NoServiceLocator
  }

  override def loadDevMode(context: LagomApplicationContext) =
    new ElementApplication(context) with LagomDevModeComponents
}
