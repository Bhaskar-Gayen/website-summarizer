import sbt.Keys.organization

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """scala-library-microservices""",
    organization := "com.cimbaAI",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.13",
    libraryDependencies ++= Seq(
      guice,
      "org.playframework" %% "play-slick" % "6.1.0",
      "org.playframework" %% "play-slick-evolutions" % "6.1.0",
      "com.h2database" % "h2" % "1.4.192",
      "org.postgresql" % "postgresql" % "42.2.24",
      ws,
      ehcache,
      specs2 % Test,
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )

