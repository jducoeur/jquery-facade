lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "jQuery Facade"

normalizedName := "jquery-facade"

version := "2.1"

organization := "org.querki"

scalaVersion := "3.1.0"

ThisBuild / scalacOptions ++= Seq("-feature", "-deprecation")

crossScalaVersions := Seq("2.12.10", "2.13.1", "3.1.0")

libraryDependencies ++= Seq(
  "org.querki" %%% "querki-jsext" % "0.12",
  "org.scala-js" %%% "scalajs-dom" % "2.0.0"
)

Test / jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv

publishTo := sonatypePublishToBundle.value
