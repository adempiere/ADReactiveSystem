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
  * Print Form Entity
  * @param printFormId Print Form ID
  * @param tenantId Tenant ID
  * @param organizationId Organization ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param name Name
  * @param description Description
  * @param invoicePrintFormatId Invoice Print Format ID
  * @param orderPrintFormatId Order Print Format ID
  * @param remittancePrintFormatId Remittance Print Format ID
  * @param shipmentPrintFormatId Shipment Print Format ID
  * @param invoiceMailTextId Invoice Mail Text ID
  * @param orderMailTextId Order Mail Text ID
  * @param shipmentMailTextId Shipment Mail Text ID
  * @param projectMailTextId Project Mail Text ID
  * @param projectPrintFormatId Project Print Format ID
  * @param manufOrderMailTextId Manuf Order Mail Text ID
  * @param manufOrderPrintFormatId Manuf Order Print Format ID
  * @param distribOrderMailTextId Distrib Order Mail Text ID
  * @param distribOrderPrintFormatId Distrib Order Print Format ID
  * @param uuid UUID
  */
case class PrintForm (printFormId: Int,
                      tenantId: Int,
                      organizationId: Int,
                      isActive: Boolean = true,
                      created: DateTime = DateTime.now,
                      createdBy: Int,
                      updated: DateTime = DateTime.now,
                      updatedBy: Int,
                      name: String,
                      description: Option[String],
                      invoicePrintFormatId: Option[Int],
                      orderPrintFormatId: Option[Int],
                      remittancePrintFormatId: Option[Int],
                      shipmentPrintFormatId: Option[Int],
                      invoiceMailTextId: Option[Int],
                      orderMailTextId: Option[Int],
                      shipmentMailTextId: Option[Int],
                      projectMailTextId: Option[Int],
                      projectPrintFormatId: Option[Int],
                      manufOrderMailTextId: Option[Int],
                      manufOrderPrintFormatId: Option[Int],
                      distribOrderMailTextId: Option[Int],
                      distribOrderPrintFormatId: Option[Int],
                      uuid: Option[String]
                     ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type
  override def Id: Int = printFormId

  override val entityName: String = "AD_PrintForm"
  override val identifier: String = "AD_PrintForm_ID"

}

object PrintForm {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PrintForm]
  def create(printFormId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             name: String,
             description: String,
             invoicePrintFormatId: Int,
             orderPrintFormatId: Int,
             remittancePrintFormatId: Int,
             shipmentPrintFormatId: Int,
             invoiceMailTextId: Int,
             orderMailTextId: Int,
             shipmentMailTextId: Int,
             projectMailTextId: Int,
             projectPrintFormatId: Int,
             manufOrderMailTextId: Int,
             manufOrderPrintFormatId: Int,
             distribOrderMailTextId: Int,
             distribOrderPrintFormatId: Int,
             uuid: String) = PrintForm(printFormId, tenantId, organizationId, isActive, created, createdBy, updated,
    updatedBy, name, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None)
}