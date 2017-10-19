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
  * Sequence Audit Entity
  * @param sequenceId Sequence Audit ID
  * @param documentNo Document No
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param entityId Entity ID
  * @param recordId Record ID
  * @param uuid UU ID
  */

case class SequenceAudit (sequenceId: Int,
                          documentNo: String,
                          tenantId: Int,
                          organizationId: Int,
                          isActive: Boolean = true,
                          created: DateTime = DateTime.now,
                          createdBy: Int,
                          updated: DateTime = DateTime.now,
                          updatedBy: Int,
                          entityId: Int,
                          recordId: Int,
                          uuid: String
                         ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = 0

  override val entityName: String = "AD_Sequence_Audit"
  override val identifier: String = null

}

object SequenceAudit {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[SequenceAudit]
  def create(sequenceId: Int,
             documentNo: String,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             entityId: Int,
             recordId: Int,
             uuid: String) = SequenceAudit(sequenceId, documentNo, tenantId, organizationId, isActive, created,
    createdBy, updated, updatedBy, entityId, recordId, uuid)
}
