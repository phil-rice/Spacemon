name := "robert"

version := "0.1"

scalaVersion := "2.13.7"
lazy val versions = new {
  val scalatest = "3.2.2"
  val mockito = "1.10.19"
}


libraryDependencies += "org.mockito" % "mockito-all" % versions.mockito % "test"

libraryDependencies += "org.scalatest" %% "scalatest" % versions.scalatest % "test"

