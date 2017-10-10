package com.eevolution.context.dictionary.infrastructure.db

import java.util.Date

import io.getquill.MappedEncoding
import org.joda.time.{DateTime, Duration}

trait Encoders {
  implicit val jodaDateTimeEncoder = MappedEncoding[DateTime, Date](_.toDate)

  implicit val jodaDurationEncoder = MappedEncoding[Duration, Long](_.getMillis)
}
