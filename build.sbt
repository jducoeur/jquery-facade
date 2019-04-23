lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "jQuery Facade"

normalizedName := "jquery-facade"

version := "1.2"

organization := "org.querki"

scalaVersion := "2.12.8"

scalacOptions in ThisBuild ++= Seq("-feature", "-deprecation")

crossScalaVersions := Seq("2.10.7", "2.11.12", "2.12.8")

libraryDependencies ++= Seq(
  "org.querki" %%% "querki-jsext" % "0.8",
  "org.scala-js" %%% "scalajs-dom" % "0.9.3"
)

jsEnv in Test := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv

homepage := Some(url("http://www.querki.net/"))

licenses += ("MIT License", url("http://www.opensource.org/licenses/mit-license.php"))

scmInfo := Some(ScmInfo(
    url("https://github.com/jducoeur/jquery-facade"),
    "scm:git:git@github.com:jducoeur/jquery-facade.git",
    Some("scm:git:git@github.com:jducoeur/jquery-facade.git")))

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := (
  <developers>
    <developer>
      <id>jducoeur</id>
      <name>Mark Waks</name>
      <url>https://github.com/jducoeur/</url>
    </developer>
  </developers>
)

pomIncludeRepository := { _ => false }
