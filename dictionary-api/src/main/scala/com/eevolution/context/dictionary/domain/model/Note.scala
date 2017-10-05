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
  * Note Entity
  * @param noteId Note ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param userId User ID
  * @param messageId Message ID
  * @param reference Reference
  * @param tableId Table ID
  * @param recordId Record ID
  * @param processed Processed
  * @param processing Processing
  * @param description Description
  * @param wfActivityId Wf Activity ID
  * @param textMsg Text Msg
  * @param uuId UU ID
  */

case class Note(noteId: Int,
                isActive: Boolean = true,
                created: DateTime = DateTime.now,
                createdBy: Int,
                updated: DateTime = DateTime.now,
                updatedBy: Int,
                userId: Option[Int],
                messageId: Int,
                reference: Option[String],
                tableId: Option[Int],
                recordId: Option[Int],
                processed: Boolean = false,
                processing: Option[Boolean],
                description: Option[String],
                wfActivityId: Option[Int],
                textMsg: Option[String],
                uuId: Option[String]
               ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = noteId

  override val entityName: String = "AD_Note"
  override val identifier: String = "AD_Note_ID"
}


object Note {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Note]
  def create(noteId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             userId: Int,
             messageId: Int,
             reference: String,
             tableId: Int,
             recordId: Int,
             processed: Boolean,
             processing: Boolean,
             description: String,
             wfActivityId: Int,
             textMsg: String,
             uuId: String) = Note(noteId, isActive, created, createdBy, updated, updatedBy, None, messageId,
    None, None, None, processed, None, None, None, None, None)
}


