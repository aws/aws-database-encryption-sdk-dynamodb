// The Java_Server (Language_Server) Gradle build.
//
// smithy-java 1.4.0 (the generated client + server scaffolding and its runtime) REQUIRES
// JDK 21+, so build.gradle.kts pins a Java 21 toolchain. The Foojay toolchain-resolver
// convention lets Gradle locate an already-installed JDK 21 or download a compatible one
// transparently, so `make build-java` works on a fresh checkout without the maintainer
// manually configuring a JDK (Reqs 1.4, 1.5).
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "TestServerDynamoDbJava"
