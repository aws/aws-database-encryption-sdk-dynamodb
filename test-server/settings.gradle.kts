// Dedicated Smithy code-generation project for the TestServer.
//
// This Gradle build exists ONLY to run smithy-java code generation from the shared
// model/ directory via the `generate` Make target. It is intentionally separate from
// runtimes/java so that code generation runs against an ISOLATED classpath (just the
// smithy-java codegen plugins + the rpcv2Cbor trait package) and never discovers the
// DB-ESDK / AWS SDK runtime models that the Java_Server module depends on.
//
// The generated client + server scaffolding is written under test-server/build/ and is
// consumed by test-server/runtimes/java as a generated source directory.
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
}

rootProject.name = "test-server-codegen"
