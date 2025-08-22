import java.net.URI
import javax.annotation.Nullable
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import java.awt.SystemColor.info
import java.nio.file.Files.delete

plugins {
    `java`
    `java-library`
    id("me.champeau.jmh") version "0.7.0"
}

group = "software.amazon.cryptography"
version = "1.0-SNAPSHOT"
description = "DynamoDbEncryptionPerformanceTest"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    sourceSets["main"].java {
        srcDir("src/main/java")
    }
    sourceSets["test"].java {
        srcDir("src/test/java")
    }
}

sourceSets {
    this.jmh {
        java.setSrcDirs(mutableListOf("src/main/java"))
    }
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
    mavenCentral()
    mavenLocal()
    
    // While commented out, this project will not pull from CodeArtifact, you must build and deploy dependencies locally
    //
    // maven {
    //    name = "CodeArtifact"
    //    url = URI.create("https://avp10745-648638458147.d.codeartifact.us-west-2.amazonaws.com/maven/AVP-10745/")
    //    credentials {
    //        username = "aws"
    //        password = System.getenv("CODEARTIFACT_AUTH_TOKEN")
    //    }
    //}
}

dependencies {
    implementation("software.amazon.cryptography:aws-database-encryption-sdk-dynamodb:1.0-SNAPSHOT")
    implementation("software.amazon.cryptography:AwsCryptographicMaterialProviders:1.0-SNAPSHOT")

    implementation(platform("software.amazon.awssdk:bom:2.19.1"))
    implementation("software.amazon.awssdk:dynamodb:2.20.64")
    implementation("software.amazon.awssdk:dynamodb-enhanced")
    implementation("com.amazonaws:aws-java-sdk-dynamodb:1.12.409")
    implementation("software.amazon.awssdk:kms")

    implementation("org.openjdk.jmh:jmh-core:1.36")
    implementation("org.openjdk.jmh:jmh-generator-annprocess:1.36")
    annotationProcessor ("org.openjdk.jmh:jmh-generator-annprocess:1.36")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")
    implementation("com.univocity:univocity-parsers:2.9.1")
    implementation("javax.xml.bind:jaxb-api:2.3.1")
    implementation("org.apache.commons:commons-lang3:3.8.1")

    // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.5")
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

gradle.taskGraph.whenReady {
    delete {
        file("build/results/").deleteRecursively()
    }
}

tasks.test {
    useTestNG()

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
