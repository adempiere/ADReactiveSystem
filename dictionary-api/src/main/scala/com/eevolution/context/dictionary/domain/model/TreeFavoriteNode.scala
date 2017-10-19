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
  * Tree Favorite Node Entity
  * @param treeFavoriteNodeId Tree Favorite Node ID
  * @param menuId Menu ID
  * @param treeFavoriteId Tree Favorite ID
  * @param created Created
  * @param createdBy Created By
  * @param isActive Is Active
  * @param isSummary Is Summary
  * @param nodeName Node Name
  * @param parentId Parent ID
  * @param seqNo Seq No
  * @param updated Updated
  * @param updatedBy Updated By
  * @param isCollapsible Is Collapsible
  * @param uuid UUID
  */

case class TreeFavoriteNode(treeFavoriteNodeId: Int,
                            tenantId: Int,
                            organizationId: Int,
                            menuId: Int,
                            treeFavoriteId: Int,
                            created: DateTime = DateTime.now,
                            createdBy: Int,
                            isActive: Boolean = true,
                            isSummary: Boolean,
                            nodeName: Option[String],
                            parentId: Option[Int],
                            seqNo: Int,
                            updated: DateTime = DateTime.now,
                            updatedBy: Int,
                            isCollapsible: Boolean = false,
                            uuid: String
                           ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = treeFavoriteNodeId

  override val entityName: String = "AD_Tree_Favorite_Node"
  override val identifier: String = "AD_Tree_Favorite_Node_ID"
}

object TreeFavoriteNode  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[TreeFavoriteNode]
  def create(treeFavoriteNodeId: Int,
             tenantId: Int,
             organizationId: Int,
             menuId: Int,
             treeFavoriteId: Int,
             created: DateTime,
             createdBy: Int,
             isActive: Boolean,
             isSummary: Boolean,
             nodeName: String,
             parentId: Int,
             seqNo: Int,
             updated: DateTime,
             updatedBy: Int,
             isCollapsible: Boolean,
             uuid: String) = TreeFavoriteNode(treeFavoriteId, tenantId, organizationId, menuId, treeFavoriteId,
    created, createdBy, isActive, isSummary, None, None, seqNo, updated, updatedBy, isCollapsible, uuid)
}

