//
// Copyright (C) 2016 Lightbend Inc. <https://www.lightbend.com>
// The Lagom plugin
addSbtPlugin("com.lightbend.lagom" % "lagom-sbt-plugin" % "1.5.4")

// Needed for importing the project into Eclipse
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")
// Platform Tooling plugin
addSbtPlugin("com.lightbend.rp" % "sbt-reactive-app" % "1.7.3")
// Akka GRPC
addSbtPlugin("com.lightbend.akka.grpc" %% "sbt-akka-grpc" % "0.6.0")


