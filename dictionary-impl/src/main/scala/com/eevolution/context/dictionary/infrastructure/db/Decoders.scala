package com.eevolution.context.dictionary.infrastructure.db
import java.util.Date

import io.getquill.MappedEncoding
import org.joda.time.{DateTime, Duration}

trait Decoders {
  implicit val jodaLocalDateTimeDecoder = MappedEncoding[Date, DateTime](new DateTime(_))

  implicit val jodaDurationDecoder = MappedEncoding(Duration.millis)
}