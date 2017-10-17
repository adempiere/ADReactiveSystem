package com.eevolution.context.dictionary.api

import java.util.{Date, UUID}

import com.eevolution.context.dictionary.domain.model.{Element, Entity, Organization, Tenant}
import com.eevolution.utils.PaginatedSequence
import org.joda.time.DateTime

import scala.concurrent.Future

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
  *
  * Created by e-Evolution on 25/02/14.
  */

/**
  * Define Domain Model type
  */
abstract trait DomainModel {
  type DomainModel
}

/**
  * Define Actave Enabled Type
  */
abstract trait ActiveEnabled {

  type ActiveEnabled

  val isActive: Boolean
}

/**
  * Defiend Tenant Enabled Type
  */
abstract trait TenantEnabled {

  type TenantEnabled

  val tenant: Tenant

  def getTenant() = tenant
}

/**
  * Define Identifiable Type
  */
abstract trait Identifiable {

  type Identifiable

  val entityName: String
  val identifier: String

  def Id: Int

  def EntityName: String = entityName

  def Identifier: String = identifier
}

/**
  * Define Organization Enabled type
  */
abstract trait OrganizationEnabled {

  type OrganizationEnabled

  val organization: Organization

  def getOrganization() = organization
}

/**
  * Define Traceable Type
  */
abstract trait Traceable {

  type Traceable

  val updatedBy: Int
  val createdBy: Int
  val created: DateTime
  val updated: DateTime

  def getCreatedBy: Int = createdBy

  def getCreated: DateTime = created

  def getUpdatedBy: Int = updatedBy

  def getUpdated: DateTime = updated

}

trait Repostory [DomainModel , idType] {

  def getById(id: idType): Future[DomainModel]

  def getByUUID(uuid: UUID): Future[DomainModel]

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[DomainModel]]

  def getAll() : Future[List[DomainModel]]
}

trait Service [DomainModel , idType] {

  def getById(id: idType): Object

  def getByUUID(uuid: UUID): Object

  def getAll() : Object

  def getAllByPage(page: Option[Int], pageSize: Option[Int]): Object

}