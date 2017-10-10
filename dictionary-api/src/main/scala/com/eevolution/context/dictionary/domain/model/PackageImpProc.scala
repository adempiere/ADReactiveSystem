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
  * Email: eduardo.moreno@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by eduardo.moreno@e-evolution.com , www.e-evolution.com
  */
/**
  * Package Imp Proc Entity
  * @param packageImpProcId Package Imp Proc ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param overrideDict Override Dict
  * @param packageDir Package Dir
  * @param packageSource Package Source
  * @param packageSourceType Package Source Type
  * @param processing Processing
  * @param uuid UUID
  */
case class PackageImpProc (packageImpProcId: Int,
                           tenantId: Int,
                           organizationId: Int,
                           isActive: Boolean = true,
                           created: DateTime = DateTime.now,
                           createdBy: Int,
                           updated: DateTime = DateTime.now,
                           updatedBy: Int,
                           overrideDict: Option[Boolean],
                           packageDir: Option[String],
                           packageSource: Option[String],
                           packageSourceType: String,
                           processing: Option[Boolean],
                           uuid: Option[String]
                          ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = packageImpProcId

  override val entityName: String = "AD_PackageImpProc"
  override val identifier: String = "AD_PackageImpProc_ID"

}

object PackageImpProc {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PackageImpProc]
  def create(packageImpProcId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             overrideDict: Boolean,
             packageDir: String,
             packageSource: String,
             packageSourceType: String,
             processing: Boolean,
             uuid: String) = PackageImpProc(packageImpProcId, tenantId, organizationId, isActive, created, createdBy,
    updated, updatedBy, None, None, None, packageSourceType, None, None)
}