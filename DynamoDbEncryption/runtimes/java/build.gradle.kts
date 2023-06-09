import java.net.URI
import javax.annotation.Nullable
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    `java`
    `java-library`
    `maven-publish`
    `signing`
    id("io.github.gradle-nexus.publish-plugin") version "1.3.0"
}

group = "software.amazon.cryptography"
version = "3.0.0-preview-1"
description = "Aws Database Encryption Sdk for DynamoDb Java"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
    sourceSets["main"].java {
        srcDir("src/main/java")
        srcDir("src/main/dafny-generated")
        srcDir("src/main/smithy-generated")
        srcDir("src/main/sdkv1")
    }
    sourceSets["test"].java {
        srcDir("src/test")
    }
    withJavadocJar()
    withSourcesJar()
}

var caUrl: URI? = null
@Nullable
val caUrlStr: String? = System.getenv("CODEARTIFACT_URL_JAVA_CONVERSION")
if (!caUrlStr.isNullOrBlank()) {
    caUrl = URI.create(caUrlStr)
}

var caPassword: String? = null
@Nullable
val caPasswordString: String? = System.getenv("CODEARTIFACT_AUTH_TOKEN")
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
    implementation("software.amazon.cryptography:aws-cryptographic-material-providers:1.0.0-preview-1")

    implementation(platform("software.amazon.awssdk:bom:2.19.1"))
    implementation("software.amazon.awssdk:dynamodb")
    implementation("software.amazon.awssdk:dynamodb-enhanced")
    implementation("software.amazon.awssdk:core:2.19.1")
    implementation("software.amazon.awssdk:kms")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    
    //    For the DDB-EC v1
    implementation("com.amazonaws:aws-java-sdk-dynamodb:1.12.409")
    // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.5")
    // https://mvnrepository.com/artifact/com.amazonaws/DynamoDBLocal
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
    // https://mvnrepository.com/artifact/org.hamcrest/hamcrest-all
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    // https://mvnrepository.com/artifact/org.bouncycastle/bcprov-jdk15on
    testImplementation("org.bouncycastle:bcprov-jdk15on:1.70")
    // https://mvnrepository.com/artifact/org.quicktheories/quicktheories
    testImplementation("org.quicktheories:quicktheories:0.26")
    // https://mvnrepository.com/artifact/junit/junit
    testImplementation("junit:junit:4.13.2")
    // https://mvnrepository.com/artifact/edu.umd.cs.mtc/multithreadedtc
    testImplementation("edu.umd.cs.mtc:multithreadedtc:1.01")
}

publishing {
    publications.create<MavenPublication>("mavenLocal") {
        groupId = "software.amazon.cryptography"
        artifactId = "aws-database-encryption-sdk-dynamodb"
        artifact(tasks["jar"])
        artifact(tasks["javadocJar"])
        artifact(tasks["sourcesJar"])
    }
    publications.create<MavenPublication>("maven") {
        groupId = "software.amazon.cryptography"
        artifactId = "aws-database-encryption-sdk-dynamodb"
        artifact(tasks["jar"])
        artifact(tasks["javadocJar"])
        artifact(tasks["sourcesJar"])

        // Include extra information in the POMs.
        afterEvaluate {
            pom {
                name.set("AWS Database Encryption SDK for DynamoDB")
                description.set("AWS Database Encryption SDK for DynamoDB in Java")
                url.set("https://github.com/aws/aws-database-encryption-sdk-dynamodb-java")
                licenses {
                    license {
                        name.set("Apache License 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("repo")
                    }
                }
                developers {
                    developer {
                        id.set("amazonwebservices")
                        organization.set("Amazon Web Services")
                        organizationUrl.set("https://aws.amazon.com")
                        roles.add("developer")
                    }
                }
                scm {
                    url.set("https://github.com/aws/aws-database-encryption-sdk-dynamodb-java.git")
                }
            }
        }
    }
    repositories { mavenLocal() }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Jar>() {
    // to compile a sources jar we need a strategy on how to deal with duplicates;
    // we choose to include duplicate classes.
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

tasks.test {
    useTestNG()
    dependsOn("CopyDynamoDb")
    systemProperty("java.library.path", "build/libs")

    // This will show System.out.println statements
    testLogging.showStandardStreams = true

    testLogging {
        lifecycle {
            events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
            exceptionFormat = TestExceptionFormat.FULL
            showExceptions = true
            showCauses = true
            showStackTraces = true
            showStandardStreams = true
        }
        info.events = lifecycle.events
        info.exceptionFormat = lifecycle.exceptionFormat
    }

    // See https://github.com/gradle/kotlin-dsl/issues/836
    addTestListener(object : TestListener {
        override fun beforeSuite(suite: TestDescriptor) {}
        override fun beforeTest(testDescriptor: TestDescriptor) {}
        override fun afterTest(testDescriptor: TestDescriptor, result: TestResult) {}

        override fun afterSuite(suite: TestDescriptor, result: TestResult) {
            if (suite.parent == null) { // root suite
                logger.lifecycle("----")
                logger.lifecycle("Test result: ${result.resultType}")
                logger.lifecycle("Test summary: ${result.testCount} tests, " +
                        "${result.successfulTestCount} succeeded, " +
                        "${result.failedTestCount} failed, " +
                        "${result.skippedTestCount} skipped")
            }
        }
    })
}

tasks.register<JavaExec>("runTests") {
    mainClass.set("TestsFromDafny")
    classpath = sourceSets["test"].runtimeClasspath
}

tasks.register<Copy>("CopyDynamoDb")  {
    from (dynamodb) {
        include("*.dll")
        include("*.dylib")
        include("*.so")
    }
    into("build/libs")
}

tasks.javadoc {
    options {
        (this as CoreJavadocOptions).addStringOption("Xdoclint:none", "-quiet")
    }
    exclude("src/main/dafny-generated")
}
