name := """service-gateway"""

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.4"

crossScalaVersions := Seq("2.11.12", "2.12.4")

mainClass in assembly := Some("play.core.server.ProdServerStart")
fullClasspath in assembly += Attributed.blank(PlayKeys.playPackageAssets.value)

assemblyMergeStrategy in assembly := {
    case manifest if manifest.contains("MANIFEST.MF") =>
    // We don't need manifest files since sbt-assembly will create
    // one with the given settings
    MergeStrategy.discard
    case referenceOverrides if referenceOverrides.contains("reference-overrides.conf") =>
    // Keep the content for all reference-overrides.conf files
    MergeStrategy.concat
    case x =>
    // For all the other files, use the default sbt-assembly merge strategy
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

libraryDependencies ++= Seq(
    javaCore,
    javaWs,
    "com.encentral.test_project" % "entities" % "1.0",
    "com.encentral.test_project" % "service-endpoint" % "1.0",
    "com.encentral.test_project" % "user-management-impl" % "1.0",
    "com.encentral.test_project" % "commons" % "1.0",
    "com.encentral.test_project" % "binder" % "1.0",

    "com.h2database" % "h2" % "1.4.197",
    "org.eclipse.persistence" % "eclipselink" % "2.6.2",
    "io.vavr" % "vavr" % "0.9.2",
    
    "io.swagger" %% "swagger-play2" % "1.6.0",
    "io.swagger"         % "swagger-parser"             % "1.0.20",
    "io.swagger" % "swagger-annotations" % "1.5.9",
    "org.flywaydb" %% "flyway-play" % "5.0.0",
    
    filters,
    javaJpa,
    guice
)

resolvers += Resolver.mavenLocal
resolvers += Resolver.jcenterRepo