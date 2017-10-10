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
  * Tree Entity
  * @param treeId Tree ID
  * @param created Created
  * @param createdBy Created By
  * @param updated  Updated
  * @param updatedBy Updated By
  * @param isActive Is Active
  * @param name Name
  * @param description Description
  * @param treeType Tree Types
  * @param isAllNodes Is All Notes
  * @param processing Processing
  * @param isDefault Is Default
  * @param uuid UUID
  */

case class Tree(treeId: Int,
                created: DateTime = DateTime.now,
                createdBy: Int,
                updated: DateTime = DateTime.now,
                updatedBy: Int,
                isActive: Boolean = true,
                name: String,
                description: Option[String],
                treeType: String,
                isAllNodes: Boolean = true,
                processing: Option[Boolean],
                isDefault: Boolean = false,
                uuid: Option[String]
               ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = treeId

  override val entityName: String = "AD_Tree"
  override val identifier: String = "AD_Tree_ID"
}

object Tree  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[Tree]
  def create(treeId: Int,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             isActive: Boolean,
             name: String,
             description: String,
             treeType: String,
             isAllNodes: Boolean,
             processing: Boolean,
             isDefault: Boolean,
             uuid: String) = Tree(treeId, created, createdBy, updated, updatedBy, isActive, name, None,
    treeType, isAllNodes, None, isDefault, None)
}

