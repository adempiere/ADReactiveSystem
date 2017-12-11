package com.eevolution.context.dictionary.application

import com.eevolution.context.dictionary.infrastructure.repository.{AttributeRepository, ElementRepository, EntityRepository, WindowRepository}
import com.eevolution.context.dictionary.infrastructure.service.{AttributeService, ElementService, EntityService, WindowService}
import com.eevolution.context.dictionary.infrastructure.service.impl._
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
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  * You should have received a copy of the GNU General Public License
  * along with this program.  If not, see <http://www.gnu.org/licenses/>.
  * Email: victor.perez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by victor.perez@e-evolution.com , www.e-evolution.com
  */

/**
  * Entity Component
  */
/*
trait DictionaryComponents extends LagomServerComponents
  with JdbcPersistenceComponents
  with HikariCPComponents {

  implicit def executionContext: ExecutionContext
  def environment: Environment

  override lazy val lagomServer = LagomServer.forServices(
    bindService[ElementService].to(wire[ElementServiceImpl]),
    bindService[EntityService].to(wire[EntityServiceImpl]),
    bindService[AttributeService].to(wire[AttributeServiceImpl])
  )

  lazy val elementRepository = wire[ElementRepository]
  lazy val entityRepository = wire[EntityRepository]
  lazy val attributeRepository = wire[AttributeRepository]
  lazy val windowRepository = wire[WindowRepository]

  lazy val jsonSerializerRegistry = DictionarySerializerRegistry

}
*/

/**
  * Entity Application
  * @param context
  */

 abstract class ApplicationDictionary(context: LagomApplicationContext) extends LagomApplication(context)
  with DictionaryComponents
  with AhcWSComponents {

  override lazy val lagomServer = LagomServer.forServices(
    bindService[ElementService].to(wire[ElementServiceImpl]),
    bindService[EntityService].to(wire[EntityServiceImpl]),
    bindService[AttributeService].to(wire[AttributeServiceImpl]),
    bindService[WindowService].to(wire[WindowServiceImpl])
  )
  override lazy val elementRepository = wire[ElementRepository]
  override lazy val entityRepository = wire[EntityRepository]
  override lazy val attributeRepository = wire[AttributeRepository]
  override lazy val windowRepository = wire[WindowRepository]
}

/**
  * Entity Application Loader
  */
class ApplicationDictionaryLoader extends LagomApplicationLoader {
  override def load(context: LagomApplicationContext) = new ApplicationDictionary(context) {
    override def serviceLocator = NoServiceLocator
  }

  override def loadDevMode(context: LagomApplicationContext) =
    new ApplicationDictionary(context) with LagomDevModeComponents
}
