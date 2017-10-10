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
  * Sequence Entity
  * @param sequenceId Sequence ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param description Description
  * @param vFormat V Format
  * @param isAutoSequence Is Auto Sequence
  * @param incrementNo Increment No
  * @param startNo Start No
  * @param currentNext Current Next
  * @param currentNextSys Current Next
  * @param isAudited Is Audited
  * @param isEntityId Is Entity ID
  * @param prefix Prefix
  * @param suffix Suffix
  * @param startNewYear Start New Year
  * @param dateAttribute Date Attribute
  * @param decimalPattern Decimal Pattern
  * @param uuId UU ID
  */

case class Sequence (sequenceId: Int,
                     tenantId: Int,
                     organizationId: Int,
                     isActive: Boolean = true,
                     created: DateTime = DateTime.now,
                     createdBy: Int,
                     updated: DateTime = DateTime.now,
                     updatedBy: Int,
                     name: String,
                     description: Option[String],
                     vFormat: Option[String],
                     isAutoSequence: Boolean = true,
                     incrementNo: Int,
                     startNo: Int,
                     currentNext: Int,
                     currentNextSys: Int,
                     isAudited: Boolean = false,
                     isEntityId: Boolean = false,
                     prefix: Option[String],
                     suffix: Option[String],
                     startNewYear: Boolean = false,
                     dateAttribute: Option[String],
                     decimalPattern: Option[String],
                     uuId: Option[String]
                    ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = sequenceId

  override val entityName: String = "AD_Sequence"
  override val identifier: String = "AD_Sequence_ID"

}

object Sequence {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Sequence]
  def create(sequenceId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             description: String,
             vFormat: String,
             isAutoSequence: Boolean,
             incrementNo: Int,
             startNo: Int,
             currentNext: Int,
             currentNextSys: Int,
             isAudited: Boolean,
             isEntityId: Boolean,
             prefix: String,
             suffix: String,
             startNewYear: Boolean,
             dateAttribute: String,
             decimalPattern: String,
             uuId: String) = Sequence(sequenceId, tenantId, organizationId, isActive, created, createdBy,
    updated, updatedBy, name, None, None, isAutoSequence, incrementNo, startNo, currentNext, currentNextSys, isAudited,
    isEntityId, None, None, startNewYear, None, None, None)
}
