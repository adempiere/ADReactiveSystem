package com.eevolution.context.dictionary.domain.model


import ai.x.play.json.Jsonx
import com.eevolution.context.dictionary.api.{ActiveEnabled, DomainModel, Identifiable, Traceable}
import org.joda.time.DateTime

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
  * Email: emeris.hernandez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com
  */

/**
  * Migration Entity
  * @param migrationId Migration ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param apply Apply
  * @param comments Comments
  * @param created Created
  * @param createdBy Created By
  * @param entityType Entity Type
  * @param exportXML Export XML
  * @param isActive is Active
  * @param name Name
  * @param releaseNo Release No
  * @param seqNo Seq No
  * @param statusCode Status Code
  * @param updated Updated
  * @param updatedBy Updated By
  * @param processing Processing
  * @param processed Processed
  * @param uuid UUID
  */

case class Migration(migrationId: Int,
                     tenantId : Int ,
                     organizationId : Int,
                     apply: Option[Boolean],
                     comments: Option[String],
                     created: DateTime =  DateTime.now,
                     createdBy: Int,
                     entityType: String,
                     exportXML: Option[Boolean],
                     isActive: Boolean = true,
                     name: String,
                     releaseNo: Option[String],
                     seqNo: Int,
                     statusCode: Option[Boolean],
                     updated: DateTime =  DateTime.now,
                     updatedBy: Int,
                     processing: Option[Boolean],
                     processed: Boolean = false,
                     uuid: String
                    ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = migrationId

  override val entityName: String = "AD_Migration"
  override val identifier: String = "AD_Migration_ID"
}

object Migration  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Migration]
  def create(migrationId: Int,
             tenantId : Int ,
             organizationId : Int,
             apply: Boolean,
             comments: String,
             created: DateTime,
             createdBy: Int,
             entityType: String,
             exportXML: Boolean,
             isActive: Boolean,
             name: String,
             releaseNo: String,
             seqNo: Int,
             statusCode: Boolean,
             updated: DateTime,
             updatedBy: Int,
             processing: Boolean,
             processed: Boolean,
             uuid: String) = Migration(migrationId, tenantId, organizationId, None, None, created, createdBy,
    entityType, None, isActive, name, None, seqNo, None, updated, updatedBy, None, processed, uuid)
}
