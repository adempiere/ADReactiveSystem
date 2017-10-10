package com.eevolution.context.dictionary.infrastructure

import io.getquill.{Literal, PostgresJdbcContext}

/**
  * Created by e-Evolution on 01/04/17.
  */
package object db {

  lazy val DbContext = new PostgresJdbcContext[Literal]("ctx") with Encoders with Decoders
}
