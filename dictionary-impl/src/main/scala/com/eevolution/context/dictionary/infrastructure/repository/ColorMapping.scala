package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.infrastructure.db.DbContext._
import com.eevolution.context.dictionary.domain.model.Color

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
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 19/10/17.
  */

/**
  * Color Mapping
  */

trait ColorMapping {
  val queryColor = quote {
    querySchema[Color]("AD_Color",
      _.colorId-> "AD_Color_ID",
      _.tenantId-> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.isActive-> "IsActive",
      _.created-> "Created",
      _.createdBy-> "CreatedBy",
      _.updated-> "Updated",
      _.updatedBy-> "UpdatedBy",
      _.name-> "Name",
      _.isDefault-> "IsDefault",
      _.colorType-> "ColorType",
      _.red-> "Red",
      _.green-> "Green",
      _.blue-> "Blue",
      _.alpha-> "Alpha",
      _.imageId-> "AD_Image_ID",
      _.imageAlpha-> "ImageAlpha",
      _.red1-> "Red_1",
      _.green1-> "Green_1",
      _.blue1-> "Blue_1",
      _.alpha1-> "Alpha_1",
      _.lineWidth-> "LineWidth",
      _.lineDistance-> "LineDistance",
      _.startPoint-> "StartPoint",
      _.repeatDistance-> "RepeatDistance",
      _.uuid-> "UUID")
  }
}
