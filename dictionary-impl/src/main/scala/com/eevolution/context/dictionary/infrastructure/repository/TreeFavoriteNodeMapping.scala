package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.TreeFavoriteNode
import com.eevolution.context.dictionary.infrastructure.db.DbContext._

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
  * Email: emeris.hernandez@e-evolution.com, http://www.e-evolution.com , http://github.com/EmerisScala
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 27/10/17.
  */

/**
  * Tree Favorite Node Mapping
  */

trait TreeFavoriteNodeMapping {
  val queryTreeFavoriteNode = quote {
    querySchema[TreeFavoriteNode]("AD_Tree_Favorite_Node",
      _.treeFavoriteNodeId-> "AD_Tree_Favorite_Node_ID",
      _.tenantId-> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.menuId-> "AD_Menu_ID",
      _.treeFavoriteId-> "AD_Tree_Favorite_ID",
      _.created-> "Created",
      _.createdBy-> "CreatedBy",
      _.isActive-> "IsActive",
      _.isSummary-> "IsSummary",
      _.nodeName-> "NodeName",
      _.parentId-> "Parent_ID",
      _.seqNo-> "SeqNo",
      _.updated-> "Updated",
      _.updatedBy-> "UpdatedBy",
      _.isCollapsible-> "IsCollapsible",
      _.uuid-> "UUID")
  }
}
