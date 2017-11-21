package com.eevolution.context.dictionary.infrastructure.service

import java.util.UUID

import akka.NotUsed
import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.PrintForm
import com.eevolution.utils.PaginatedSequence
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}

trait PrintFormService extends Service with api.service.PrintFormService {

  override def getAll() :  ServiceCall[NotUsed, List[PrintForm]]
  override def getById(id: Int): ServiceCall[NotUsed, PrintForm]
  override def getByUUID(uuid :UUID): ServiceCall[NotUsed, PrintForm]
  override def getAllByPage(pageNo: Option[Int], pageSize: Option[Int]): ServiceCall[NotUsed, PaginatedSequence[PrintForm]]

  def descriptor = {
    import Service._
    named("printForm").withCalls(
      pathCall("/api/v1_0_0/printForm/all", getAll _) ,
      pathCall("/api/v1_0_0/printForm/:id", getById _),
      pathCall("/api/v1_0_0/printForm/:uuid", getByUUID _) ,
      pathCall("/api/v1_0_0/printForm?pageNo&pageSize", getAllByPage _)
    )
  }
}
