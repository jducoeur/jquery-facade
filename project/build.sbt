// Gives support for Scala.js compilation
val scalaJSVersion = Option(System.getenv("SCALAJS_VERSION")).getOrElse("1.0.1")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % scalaJSVersion)

addSbtPlugin("com.jsuereth" % "sbt-pgp" % "2.0.1")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "3.8.1")

libraryDependencies ++= {
  if(scalaJSVersion.startsWith("1.")) {
    Seq("org.scala-js" %% "scalajs-env-jsdom-nodejs" % "1.0.0" )
  } else {
    Nil
  }
}
