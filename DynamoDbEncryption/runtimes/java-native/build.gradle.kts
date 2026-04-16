import java.io.File
import java.io.FileInputStream
import java.util.Properties

plugins {
    `java-library`
}

var props = Properties().apply {
    load(FileInputStream(File(rootProject.rootDir, "../../../project.properties")))
}

group = "software.amazon.cryptography"
version = props.getProperty("projectJavaVersion")
description = "AWS Database Encryption SDK for DynamoDB - Native Java"

// Use a released MPL version available in local maven / maven central
// The SNAPSHOT version from project.properties requires a CodeArtifact repo
var mplVersion = "1.7.0"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
    sourceSets["main"].java {
        srcDir("src/main/java")
    }
    sourceSets["test"].java {
        srcDir("src/test/java")
    }
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    // MPL - kept as-is (Dafny-transpiled), used via its public API
    implementation("software.amazon.cryptography:aws-cryptographic-material-providers:${mplVersion}")

    // AWS SDK v2
    implementation(platform("software.amazon.awssdk:bom:2.30.18"))
    implementation("software.amazon.awssdk:dynamodb")
    implementation("software.amazon.awssdk:dynamodb-enhanced")
    implementation("software.amazon.awssdk:kms")

    // Test
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.4")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.11.4")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.4")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
    }
}
