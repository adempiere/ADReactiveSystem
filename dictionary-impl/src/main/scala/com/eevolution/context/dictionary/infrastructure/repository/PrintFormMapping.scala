package com.eevolution.context.dictionary.infrastructure.repository

import com.eevolution.context.dictionary.domain.model.PrintForm
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
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com on 26/10/17.
  */

/**
  * Print Form Mapping
  */

trait PrintFormMapping {
  val queryPrintForm = quote {
    querySchema[PrintForm]("AD_PrintForm",
      _.printFormId-> "AD_PrintForm_ID",
      _.tenantId-> "AD_Client_ID",
      _.organizationId-> "AD_Org_ID",
      _.isActive-> "IsActive",
      _.created-> "Created",
      _.createdBy-> "CreatedBy",
      _.updated-> "Updated",
      _.updatedBy-> "UpdatedBy",
      _.name-> "Name",
      _.description-> "Description",
      _.invoicePrintFormatId-> "Invoice_PrintFormat_ID",
      _.orderPrintFormatId-> "Order_PrintFormat_ID",
      _.remittancePrintFormatId-> "Remittance_PrintFormat_ID",
      _.shipmentPrintFormatId-> "Shipment_PrintFormat_ID",
      _.invoiceMailTextId-> "Invoice_MailText_ID",
      _.orderMailTextId-> "Order_MailText_ID",
      _.shipmentMailTextId-> "Shipment_MailText_ID",
      _.projectMailTextId-> "Project_MailText_ID",
      _.projectPrintFormatId-> "Project_PrintFormat_ID",
      _.manufOrderMailTextId-> "Manuf_Order_MailText_ID",
      _.manufOrderPrintFormatId-> "Manuf_Order_PrintFormat_ID",
      _.distribOrderMailTextId-> "Distrib_Order_MailText_ID",
      _.distribOrderPrintFormatId-> "Distrib_Order_PrintFormat_ID",
      _.uuid-> "UUID")
  }
}
