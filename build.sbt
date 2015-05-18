//enablePlugins(JavaAppPackaging)
name := "password.generator"

version := "0.1"

//scalaVersion := "2.11.6"

resolvers ++= Seq(
  "snapshots"           at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases"            at "http://oss.sonatype.org/content/repositories/releases",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "spray repo"          at "http://repo.spray.io"
)

scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation", "-encoding", "utf8")

// the deps are loaded as latest available for 14.05.2015
//val sprayVersion = "1.3.1"

libraryDependencies ++= {

  val akkaV = "2.3.11"
  val akkaStreamV = "1.0-RC2"
  val scalaTestV = "2.2.4"
  val sprayV = "1.3.3"

  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-stream-experimental" % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-core-experimental" % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-scala-experimental" % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaStreamV,
    //"com.typesafe.akka" %% "akka-http-spray-routing-experimental" % akkaStreamV,
    //"com.typesafe.akka" %% "akka-http-spray-client-experimental" % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-testkit-scala-experimental" % akkaStreamV,
    //"io.spray" %% "spray-can" % "1.3.x",
    "io.spray"            %%  "spray-can"     % sprayV,
    "io.spray"            %%  "spray-routing" % sprayV,
    "io.spray"            %%  "spray-testkit" % sprayV  % "test",
    //"org.scalatest" %% "scalatest" % scalaTestV % "test",
    "org.json4s" %% "json4s-native" % "3.2.11",
    "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2",
   // "ch.qos.logback" % "logback-classic" % "1.1.3",
    "org.specs2"          %%  "specs2-core"   % "2.3.11" % "test",
  //not needed
    "org.scalatest" %% "scalatest" % "2.2.4" % "test",
    "org.mockito" % "mockito-all" % "1.9.5" % "test"
  )
}

//Revolver.settings