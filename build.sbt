import akka.grpc.gen.scaladsl.play.{PlayScalaClientCodeGenerator, PlayScalaServerCodeGenerator}

lazy val root = (project in file("."))
  .settings(name := "adempiereMS")
  .aggregate(dictionaryApi, dictionaryImpl)
  .settings(commonSettings: _*)


organization in ThisBuild := "com.evolution"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.12.10"

lagomServiceEnableSsl in ThisBuild := true
val `dictionary-impl-HTTPS-port` = 11000
// ALL SETTINGS HERE ARE TEMPORARY WORKAROUNDS FOR KNOWN ISSUES OR WIP
def workaroundSettings: Seq[sbt.Setting[_]] = Seq(
  // Lagom still can't register a service under the gRPC name so we hard-code
  // the port and use the value to add the entry on the Service Registry
  lagomServiceHttpsPort := `dictionary-impl-HTTPS-port`
)

val playJsonJoda = "com.typesafe.play" %% "play-json-joda" % "2.6.14"
val playJsonDerivedCodecs = "org.julienrf" %% "play-json-derived-codecs" % "6.0.0"
val playJsonExtensions = "ai.x" %% "play-json-extensions" % "0.40.2"
val macwire = "com.softwaremill.macwire" %% "macros" % "2.3.3" % "provided"
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.8" % "test"
val quill = "io.getquill" %% "quill-jdbc" % "3.4.10"
val postgresql = "org.postgresql" % "postgresql" % "42.2.8"

val lagomGrpcTestkit = "com.lightbend.play" %% "lagom-scaladsl-grpc-testkit" % "0.7.0"
//val gRPCGenerators = "com.lightbend.play" %% "play-grpc-generators" % "0.7.0"
//val gRPCRuntime = "com.lightbend.play" % "play-grpc-runtime" % "0.7.0"

lazy val `dictionaryApi` = (project in file("dictionary-api"))
  .settings(commonSettings: _*)
  .settings(
    version := "1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      lagomScaladslApi,
      playJsonJoda,
      playJsonExtensions,
      playJsonDerivedCodecs,
      lagomGrpcTestkit,
      postgresql,
      quill
      //"io.getquill" %% "quill-async-postgres" % "1.0.1"
    )
  )

lazy val dictionaryImpl = (project in file("dictionary-impl"))
  .enablePlugins(LagomScala)
  .enablePlugins(AkkaGrpcPlugin) // enables source generation for gRPC
  .enablePlugins(PlayAkkaHttp2Support) // enables serving HTTP/2 and gRPC
  .settings(akkaGrpcGeneratedLanguages := Seq(AkkaGrpc.Scala),
    akkaGrpcGeneratedSources :=
      Seq(AkkaGrpc.Server,
        AkkaGrpc.Client // the client is only used in tests. See https://github.com/akka/akka-grpc/issues/410
      ),
    akkaGrpcExtraGenerators in Compile += PlayScalaServerCodeGenerator,
  ).settings(
  workaroundSettings: _*
).settings(
  version := "1.0-SNAPSHOT",
  libraryDependencies ++= Seq(
    lagomScaladslTestKit,
    lagomScaladslPersistenceJdbc,
    lagomScaladslKafkaBroker,
    macwire,
    scalaTest,
    postgresql,
    lagomGrpcTestkit
  )
)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`dictionaryApi`)


def commonSettings: Seq[Setting[_]] = Seq(
)

lagomCassandraEnabled in ThisBuild := false
lagomKafkaEnabled in ThisBuild := false
lagomCassandraCleanOnStart in ThisBuild := true


// ------------------------------------------------------------------------------------------------

// register 'elastic-search' as an unmanaged service on the service locator so that at 'runAll' our code
// will resolve 'elastic-search' and use it. See also com.example.com.ElasticSearch
lagomUnmanagedServices in ThisBuild += ("elastic-search" -> "http://127.0.0.1:9200")

