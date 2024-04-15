name := """scala-library-microservices"""
organization := "com.cimbaAI"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.13"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.0" % Test

// Slick dependencies for database access
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.3.3"
libraryDependencies += "org.postgresql" % "postgresql" % "42.2.24"

// For using HikariCP as the connection pool
libraryDependencies += "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.cimbaAI.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.cimbaAI.binders._"
