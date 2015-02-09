import sbt._
import sbt.Keys._

object Dependencies {
  val scalatest="org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"
  val all = Seq(scalatest)
}

object GitHub {
  val util = uri("https://github.com/nabezokodaikon/scala-repo-example.git")
  val util2 = uri("https://github.com/nabezokodaikon/scala-repo-example.git#feature")
  val all = Seq(util, util2)
}

object Resolvers {
  val snapshots = "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots"
  val releases = "releases"  at "http://oss.sonatype.org/content/repositories/releases"
  val all = Seq(snapshots, releases)
}

object Format {
  import com.typesafe.sbt.SbtScalariform._

  lazy val all = scalariformSettings ++ Seq(
    ScalariformKeys.preferences in Compile := formattingPreferences,
    ScalariformKeys.preferences in Test := formattingPreferences
  )

  def formattingPreferences = {
    import scalariform.formatter.preferences._
    FormattingPreferences()
      .setPreference(AlignParameters, true)
      .setPreference(AlignSingleLineCaseStatements, false)
  }
}

object Build extends Build {

  lazy val scalareporefexample = Project(
    id = "scala-repo-ref-example",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "scala-repo-ref-example",
      organization := "org.example",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.11.4",
      libraryDependencies ++= Dependencies.all,
      resolvers ++= Resolvers.all
      // add other settings here
    ) ++ Format.all
  ).dependsOn(GitHub.util2).dependsOn(GitHub.util)
}
