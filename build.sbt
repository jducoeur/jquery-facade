lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "jQuery Facade"

normalizedName := "jquery-facade"

version := "2.0"

organization := "org.querki"

scalaVersion := "2.13.1"

scalacOptions in ThisBuild ++= Seq("-feature", "-deprecation")

crossScalaVersions := Seq("2.12.10", "2.13.1")

libraryDependencies ++= Seq(
  "org.querki" %%% "querki-jsext" % "0.10",
  "org.scala-js" %%% "scalajs-dom" % "0.9.8"
)

jsEnv in Test := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv

publishTo := sonatypePublishToBundle.value
