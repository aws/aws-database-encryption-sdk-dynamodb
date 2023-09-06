import java.net.URI
import javax.annotation.Nullable
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

tasks.wrapper {
    gradleVersion = "7.6"
}

plugins {
    `java-library`
    `maven-publish`
}

group = "software.amazon.cryptography"
version = "1.0-SNAPSHOT"
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

var caUrl: URI? = null
@Nullable
val caUrlStr: String? = System.getenv("CODEARTIFACT_REPO_URL")
if (!caUrlStr.isNullOrBlank()) {
    caUrl = URI.create(caUrlStr)
}

var caPassword: String? = null
@Nullable
val caPasswordString: String? = System.getenv("CODEARTIFACT_TOKEN")
if (!caPasswordString.isNullOrBlank()) {
    caPassword = caPasswordString
}

repositories {
    maven {
        name = "DynamoDB Local Release Repository - US West (Oregon) Region"
        url  = URI.create("https://s3-us-west-2.amazonaws.com/dynamodb-local/release")
    }
    mavenCentral()
    mavenLocal()
    if (caUrl != null && caPassword != null) {
        maven {
            name = "CodeArtifact"
            url = caUrl!!
            credentials {
                username = "aws"
                password = caPassword!!
            }
        }
    }
}

// Configuration to hold SQLLite information.
// DynamoDB-Local needs to have access to native sqllite4java.
val dynamodb by configurations.creating

dependencies {
    implementation("org.dafny:DafnyRuntime:4.1.0")
    implementation("software.amazon.smithy.dafny:conversion:0.1")
    implementation("software.amazon.cryptography:aws-cryptographic-material-providers:1.0.0")
    implementation("software.amazon.cryptography:aws-database-encryption-sdk-dynamodb:3.1.0")
    implementation("software.amazon.cryptography:TestAwsCryptographicMaterialProviders:1.0-SNAPSHOT")

    implementation(platform("software.amazon.awssdk:bom:2.20.142"))
    implementation("software.amazon.awssdk:dynamodb")
    implementation("software.amazon.awssdk:dynamodb-enhanced")
    implementation("software.amazon.awssdk:core:2.19.1")
    implementation("software.amazon.awssdk:kms")
    testImplementation("com.amazonaws:DynamoDBLocal:1.+")
    // This is where we gather the SQLLite files to copy over
    dynamodb("com.amazonaws:DynamoDBLocal:1.+")
    // As of 1.21.0 DynamoDBLocal does not support Apple Silicon
    // This checks the dependencies and adds a native library
    // to support this architecture.
    if (org.apache.tools.ant.taskdefs.condition.Os.isArch("aarch64")) {
        testImplementation("io.github.ganadist.sqlite4java:libsqlite4java-osx-aarch64:1.0.392")
        dynamodb("io.github.ganadist.sqlite4java:libsqlite4java-osx-aarch64:1.0.392")
    }
}

publishing {
    publications.create<MavenPublication>("maven") {
        groupId = group as String?
        artifactId = description
        from(components["java"])
    }
    repositories { mavenLocal() }
}


tasks.register<Copy>("copyKeysJSON") {
    from(layout.projectDirectory.file("../../../submodules/MaterialProviders/TestVectorsAwsCryptographicMaterialProviders/dafny/TestVectorsAwsCryptographicMaterialProviders/test/keys.json"))
    into(layout.projectDirectory.dir("dafny/DDBEncryption/test"))
}

tasks.register<Copy>("CopyDynamoDb")  {
    from (dynamodb) {
        include("*.dll")
        include("*.dylib")
        include("*.so")
    }
    into("build/libs")
}

tasks.register<JavaExec>("runTests") {
    dependsOn("CopyDynamoDb")
    dependsOn("copyKeysJSON")
    systemProperty("java.library.path", "build/libs")
    mainClass.set("TestsFromDafny")
    classpath = sourceSets["test"].runtimeClasspath
}
