import java.io.File
import java.io.FileInputStream
import java.net.URI
import java.util.Properties

// Build configuration for the Java TestServer (Language_Server).
//
// This module is a small executable that wires the smithy-java generated transport
// (client + server scaffolding) to hand-written operation handlers that delegate to
// the DB-ESDK DynamoDB Enhanced Client. It depends on:
//   1. The DB-ESDK Java artifact (published to mavenLocal by the existing
//      DynamoDbEncryption/runtimes/java build), and
//   2. The generated code output produced by the `generate` Make target (task 1.3),
//      which smithy-java writes under the git-ignored `test-server/build/` directory.
//
// NOTE: The Smithy model, smithy-build.json, and Make targets are authored in later
// tasks (1.2, 1.3+). The generated-source wiring below is expressed as overridable
// locations so those tasks can finalize the exact smithy projection paths without
// reworking this file.

plugins {
    `java`
    `application`
}

// Shared repo versions (projectJavaVersion, mplDependencyJavaVersion, ...).
// test-server/runtimes/java -> ../../../ resolves to the repository root, matching
// the path convention used by DynamoDbEncryption/runtimes/java/build.gradle.kts.
val props = Properties().apply {
    load(FileInputStream(File(rootProject.rootDir, "../../../project.properties")))
}

group = "software.amazon.cryptography.dbesdk.testserver"
version = props.getProperty("projectJavaVersion")
description = "TestServer Java Language_Server for the AWS Database Encryption SDK for DynamoDB"

val dbEsdkVersion = props.getProperty("projectJavaVersion")
val mplVersion = props.getProperty("mplDependencyJavaVersion")

// Location of the smithy-java generated sources, written under test-server/build/ by the
// `generate` target (the test-server-codegen Gradle build). Overridable via -PgeneratedSrcDir.
// This is the finalized smithy-build projection output path for the "source" projection and
// the "java-codegen" plugin (modes: client + server):
//   test-server/build/smithyprojections/test-server-codegen/source/java-codegen/{java,resources}
val generatedProjectionDir =
    "${rootDir}/../../build/smithyprojections/test-server-codegen/source/java-codegen"
val generatedSrcDir = (findProperty("generatedSrcDir") as String?)
    ?: "${generatedProjectionDir}/java"
val generatedResourcesDir = (findProperty("generatedResourcesDir") as String?)
    ?: "${generatedProjectionDir}/resources"

// smithy-java 1.4.0 runtime artifacts (consumed by the generated client + server scaffolding)
// are compiled for and REQUIRE Java 21+, so the TestServer module builds on Java 21.
// (The DB-ESDK artifact it depends on is compiled for Java 8 and remains consumable.)
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    sourceSets["main"].java {
        srcDir("src/main/java")
        // Generated client + server scaffolding (produced by the `generate` target).
        srcDir(generatedSrcDir)
    }
    sourceSets["main"].resources {
        // Generated resources (e.g. the SchemaIndex service provider) produced alongside
        // the generated Java sources by the `generate` target.
        srcDir(generatedResourcesDir)
    }
    sourceSets["test"].java {
        srcDir("src/test/java")
    }
}

// The server main() class is implemented in task 2.4; placeholder coordinates kept here
// so the `application` plugin and the future `start-java` target have a single source of truth.
application {
    mainClass.set("software.amazon.cryptography.dbesdk.testserver.server.TestServerMain")
}

var caUrl: URI? = null
val caUrlStr: String? = System.getenv("CODEARTIFACT_URL_JAVA_CONVERSION")
if (!caUrlStr.isNullOrBlank()) {
    caUrl = URI.create(caUrlStr)
}
val caPassword: String? = System.getenv("CODEARTIFACT_AUTH_TOKEN")

repositories {
    // DB-ESDK and MPL SNAPSHOT artifacts are published locally by the existing builds.
    mavenLocal()
    maven {
        name = "DynamoDB Local Release Repository - US West (Oregon) Region"
        url = URI.create("https://s3-us-west-2.amazonaws.com/dynamodb-local/release")
    }
    mavenCentral()
    if (caUrl != null && !caPassword.isNullOrBlank()) {
        maven {
            name = "CodeArtifact"
            url = caUrl!!
            credentials {
                username = "aws"
                password = caPassword
            }
        }
    }
}

dependencies {
    // The DB-ESDK Java artifact the Java_Server delegates to (Enhanced Client API).
    implementation("software.amazon.cryptography:aws-database-encryption-sdk-dynamodb:${dbEsdkVersion}")
    implementation("software.amazon.cryptography:aws-cryptographic-material-providers:${mplVersion}")

    // AWS SDK v2: DynamoDB + Enhanced Client + KMS keyring support.
    implementation(platform("software.amazon.awssdk:bom:2.30.18"))
    implementation("software.amazon.awssdk:dynamodb")
    implementation("software.amazon.awssdk:dynamodb-enhanced")
    implementation("software.amazon.awssdk:kms")

    // smithy-java runtime dependencies. The generated client + server scaffolding (written by
    // the `generate` target) compile and run against these. Versions are pinned (not floating)
    // and managed by the smithy-java BOM. Must stay in lockstep with the codegen version pinned
    // in test-server/build.gradle.kts (smithy-java 1.4.0).
    implementation(platform("software.amazon.smithy.java:bom:1.4.0"))
    // Generated client transport (RPC v2 CBOR).
    implementation("software.amazon.smithy.java:client-core")
    implementation("software.amazon.smithy.java:client-rpcv2-cbor")
    // Generated server scaffolding + Netty HTTP transport (the main() server is wired in 2.4).
    implementation("software.amazon.smithy.java:server-api")
    implementation("software.amazon.smithy.java:server-core")
    implementation("software.amazon.smithy.java:server-netty")
    implementation("software.amazon.smithy.java:server-rpcv2-cbor")
    // Shared schema/serde + modeled framework errors referenced by the generated shapes.
    implementation("software.amazon.smithy.java:core")
    implementation("software.amazon.smithy.java:framework-errors")

    // Round-trip Test_Suite (Requirement 7). The suite drives the Language_Server with the
    // smithy-java GENERATED client (compiled into the main source set) over RPC v2 CBOR.
    // The generated client builder defaults the RPC v2 CBOR protocol but requires an HTTP
    // transport; `client-http` provides smithy-java's java.net.http-based JavaHttpClientTransport
    // (the default ClientTransportFactory), which the harness wires explicitly. Version is managed
    // by the smithy-java BOM declared above (1.4.0).
    testImplementation("software.amazon.smithy.java:client-http")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.4")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.4")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.test {
    useJUnitPlatform()
    testLogging.showStandardStreams = true

    // The round-trip Test_Suite reads the Language_Server and DynamoDB_Backend endpoints from
    // runtime configuration and never hard-codes them (Reqs 8.3, 8.4). Gradle runs tests in a
    // forked JVM, so we explicitly forward the configuration into that fork. Sourcing the values
    // here (rather than relying on environment inheritance) keeps it reliable across the Gradle
    // daemon boundary. The `test-java` Make target passes these as -D system properties; a user
    // may instead export the matching environment variables.
    val systemPropertyKeys = listOf(
        "testserver.endpoint",
        "testserver.endpoint.host",
        "testserver.port",
        "testserver.ddb.endpoint",
        "testserver.ddb.region",
        // KMS key id for the CreateClient keyring config (task 3.2 / Req 7.1); never hard-coded.
        "testserver.kms.key.id",
    )
    systemPropertyKeys.forEach { key ->
        System.getProperty(key)?.let { systemProperty(key, it) }
    }
    val environmentKeys = listOf(
        "TEST_SERVER_ENDPOINT",
        "TEST_SERVER_HOST",
        "TEST_SERVER_PORT",
        "TEST_SERVER_DDB_ENDPOINT",
        "TEST_SERVER_DDB_REGION",
        "TEST_SERVER_KMS_KEY_ID",
    )
    environmentKeys.forEach { key ->
        System.getenv(key)?.let { environment(key, it) }
    }
}
