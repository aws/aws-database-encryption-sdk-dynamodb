// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

import java.io.File
import java.io.FileInputStream
import java.util.Properties
import java.net.URI

plugins {
    `java-library`
}

var props = Properties().apply {
    load(FileInputStream(File(rootProject.rootDir, "project.properties")))
}

group = "software.amazon.cryptography"
version = props.getProperty("projectJavaVersion")
description = "TestVectorsDynamoDbEncryption"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
    sourceSets["main"].java {
        srcDir("src/main/java")
        srcDir("src/main/dafny-generated")
        srcDir("src/main/smithy-generated")
    }
    sourceSets["test"].java {
        srcDir("src/test/dafny-generated")
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

repositories {
    mavenLocal()
    maven {
        name = "DynamoDB Local Release Repository - US West (Oregon) Region"
        url = URI.create("https://s3-us-west-2.amazonaws.com/dynamodb-local/release")
    }
    mavenCentral()
}

// Configuration to hold SQLLite information.
val dynamodb by configurations.creating

dependencies {
    implementation("org.dafny:DafnyRuntime:4.9.0")
    implementation("software.amazon.smithy.dafny:conversion:0.1.1")
    implementation("software.amazon.cryptography:aws-cryptographic-material-providers:${props.getProperty("mplDependencyJavaVersion")}")
    implementation("software.amazon.cryptography:TestAwsCryptographicMaterialProviders:${props.getProperty("mplDependencyJavaVersion")}-SNAPSHOT")
    implementation(project(":")) // Native DB-ESDK business logic
    implementation(files("libs/dafny-bridge-DELETE-ME.jar")) // Dafny bridge: ToDafny/ToNative/internaldafny (stripped of business logic)

    implementation(platform("software.amazon.awssdk:bom:${props.getProperty("awsSdkVersion")}"))
    implementation("software.amazon.awssdk:dynamodb")
    implementation("software.amazon.awssdk:dynamodb-enhanced")
    implementation("software.amazon.awssdk:kms")
    testImplementation("com.amazonaws:DynamoDBLocal:2.+")
    dynamodb("com.amazonaws:DynamoDBLocal:2.+")
    if (org.apache.tools.ant.taskdefs.condition.Os.isArch("aarch64")) {
        testImplementation("io.github.ganadist.sqlite4java:libsqlite4java-osx-aarch64:1.0.392")
        dynamodb("io.github.ganadist.sqlite4java:libsqlite4java-osx-aarch64:1.0.392")
    }
}

tasks.register<Copy>("copyKeysJSON") {
    from(layout.projectDirectory.file("../submodules/aws-cryptographic-material-providers-library/TestVectorsAwsCryptographicMaterialProviders/dafny/TestVectorsAwsCryptographicMaterialProviders/test/keys.json"))
    into(layout.projectDirectory)
}

tasks.register<Copy>("CopyDynamoDb") {
    from(dynamodb) {
        include("*.dll")
        include("*.dylib")
        include("*.so")
    }
    into("build/libs")
}

tasks.register<JavaExec>("runTests") {
    dependsOn("CopyDynamoDb")
    systemProperty("java.library.path", "build/libs")
    workingDir = projectDir
    mainClass.set("TestsFromDafny")
    classpath = sourceSets["test"].runtimeClasspath
}
