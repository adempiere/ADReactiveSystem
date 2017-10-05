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
  * Tree Node U1 Entity
  * @param treeNodeU1Id Tree Node U1 ID
  * @param nodeId Node ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updatedBy Updated By
  * @param updated Updated
  * @param parentId Parent ID
  * @param seqNo Seq No
  * @param uuId UU ID
  */

case class TreeNodeU1(treeNodeU1Id: Int,
                      nodeId: Int,
                      isActive: Boolean = true,
                      created: DateTime = DateTime.now,
                      createdBy: Int,
                      updatedBy: Int,
                      updated: DateTime = DateTime.now,
                      parentId: Option[Int],
                      seqNo: Option[Int],
                      uuId: Option[String]
                     ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = treeNodeU1Id

  override val entityName: String = "AD_TreeNodeU1"
  override val identifier: String = "AD_TreeNodeU1_ID"
}

object TreeNodeU1  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[TreeNodeU1]
  def create(treeNodeU1Id: Int,
             nodeId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updatedBy: Int,
             updated: DateTime,
             parentId: Int,
             seqNo: Int,
             uuId: String) = TreeNodeU1(treeNodeU1Id, nodeId, isActive, created, createdBy, updatedBy, updated,
    None, None, None)
}



