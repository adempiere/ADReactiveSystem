lazy val root = (project in file("."))
  .settings(name := "adempiereMS")
  .aggregate(dictionaryApi, dictionaryImpl)
  .settings(commonSettings: _*)

organization in ThisBuild := "com.evolution"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.11.8"

val playJsonDerivedCodecs = "org.julienrf" %% "play-json-derived-codecs" % "3.3"
val playJsonExtensions = "ai.x" %% "play-json-extensions" % "0.8.0"
val macwire = "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided"
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1" % "test"

lazy val dictionaryApi = (project in file("dictionary-api"))
  .settings(commonSettings: _*)
  .settings(
    version := "1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      lagomScaladslApi,
      playJsonExtensions,
      playJsonDerivedCodecs,
      "io.getquill" % "quill-jdbc_2.11" % "1.1.1"
      //"io.getquill" %% "quill-async-postgres" % "1.0.1"
    )
  )

lazy val dictionaryImpl = (project in file("dictionary-impl"))
  .settings(commonSettings: _*)
  .enablePlugins(LagomScala)
  .settings(
    version := "1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      lagomScaladslPersistenceJdbc,
      "org.postgresql" % "postgresql" % "9.4.1212",
      lagomScaladslTestKit,
      lagomScaladslKafkaBroker,
      macwire,
      scalaTest
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(dictionaryApi)

def commonSettings: Seq[Setting[_]] = Seq(
)

lagomCassandraCleanOnStart in ThisBuild := false

// ------------------------------------------------------------------------------------------------

// register 'elastic-search' as an unmanaged service on the service locator so that at 'runAll' our code
// will resolve 'elastic-search' and use it. See also com.example.com.ElasticSearch
lagomUnmanagedServices in ThisBuild += ("elastic-search" -> "http://127.0.0.1:9200")

