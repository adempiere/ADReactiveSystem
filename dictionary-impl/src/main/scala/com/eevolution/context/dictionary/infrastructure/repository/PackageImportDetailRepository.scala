package com.eevolution.context.dictionary.infrastructure.repository

import java.util.UUID

import com.eevolution.context.dictionary.domain._
import com.eevolution.context.dictionary.domain.model.PackageImportDetail
import com.eevolution.context.dictionary.infrastructure.db.DbContext._
import com.eevolution.utils.PaginatedSequence
import com.lightbend.lagom.scaladsl.persistence.jdbc.JdbcSession

import scala.concurrent.{ExecutionContext, Future}

class PackageImportDetailRepository (session: JdbcSession)(implicit executionContext: ExecutionContext)
  extends api.repository.PackageImportDetailRepository[PackageImportDetail , Int]
    with PackageImportDetailMapping {

  def getById(id: Int): Future[PackageImportDetail] = {
    Future(run(queryPackageImportDetail.filter(_.packageImportDetailId == lift(id))).headOption.get)
  }

  def getByUUID(uuid: UUID): Future[PackageImportDetail] = {
    Future(run(queryPackageImportDetail.filter(_.uuid == lift(uuid.toString))).headOption.get)
  }

  def getByPackageImportDetailId(id : Int) : Future[List[PackageImportDetail]] = {
    Future(run(queryPackageImportDetail))
  }

  def getAll() : Future[List[PackageImportDetail]] = {
    Future(run(queryPackageImportDetail))
  }

  def getAllByPage(page: Int, pageSize: Int): Future[PaginatedSequence[PackageImportDetail]] = {
    val offset = page * pageSize
    val limit = (page + 1) * pageSize
    for {
      count <- countPackageImportDetail()
      elements <- if (offset > count) Future.successful(Nil)
      else selectPackageImportDetail(offset, limit)
    } yield {
      PaginatedSequence(elements, page, pageSize, count)
    }
  }

  private def countPackageImportDetail() = {
    Future(run(queryPackageImportDetail.size).toInt)
  }

  private def selectPackageImportDetail(offset: Int, limit: Int): Future[Seq[PackageImportDetail]] = {
    Future(run(queryPackageImportDetail).drop(offset).take(limit).toSeq)
  }
}
