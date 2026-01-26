import java.io.File
import java.io.FileInputStream
import java.util.Properties
import java.net.URI
import javax.annotation.Nullable
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

tasks.wrapper {
    gradleVersion = "7.6"
}

plugins {
    `java`
    `java-library`
    `maven-publish`
    application
}

var props = Properties().apply {
    load(FileInputStream(File(rootProject.rootDir, "../../../project.properties")))
}

var mplVersion = props.getProperty("mplDependencyJavaVersion")
var ddbecVersion = props.getProperty("projectJavaVersion")
var dafnyRuntimeJavaVersion = props.getProperty("dafnyRuntimeJavaVersion")
var smithyDafnyJavaConversionVersion = props.getProperty("smithyDafnyJavaConversionVersion")


java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
}

application {
    mainClass.set("com.amazon.dbesdk.benchmark.Program")
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
    mavenLocal()
    maven {
        name = "DynamoDB Local Release Repository - US West (Oregon) Region"
        url  = URI.create("https://s3-us-west-2.amazonaws.com/dynamodb-local/release")
    }
    mavenLocal()
    mavenCentral()
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
    implementation("org.dafny:DafnyRuntime:${dafnyRuntimeJavaVersion}")
    implementation("software.amazon.smithy.dafny:conversion:${smithyDafnyJavaConversionVersion}")
    implementation("software.amazon.cryptography:aws-cryptographic-material-providers:${mplVersion}")
    implementation("software.amazon.cryptography:aws-database-encryption-sdk-dynamodb:${ddbecVersion}")

    implementation(platform("software.amazon.awssdk:bom:2.30.18"))
    implementation("software.amazon.awssdk:dynamodb")
    implementation("software.amazon.awssdk:dynamodb-enhanced")
    implementation("software.amazon.awssdk:core:2.30.18")
    implementation("software.amazon.awssdk:kms")
    
    // Apache Commons CLI for command line parsing
    implementation("commons-cli:commons-cli:1.5.0")
    
    // SnakeYAML for YAML configuration parsing
    implementation("org.yaml:snakeyaml:2.0")
    
    // Jackson for JSON output
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    
    testImplementation("com.amazonaws:DynamoDBLocal:2.+")
    // This is where we gather the SQLLite files to copy over
    dynamodb("com.amazonaws:DynamoDBLocal:2.+")
    // As of 1.21.0 DynamoDBLocal does not support Apple Silicon
    // This checks the dependencies and adds a native library
    // to support this architecture.
    if (org.apache.tools.ant.taskdefs.condition.Os.isArch("aarch64")) {
        testImplementation("io.github.ganadist.sqlite4java:libsqlite4java-osx-aarch64:1.0.392")
        dynamodb("io.github.ganadist.sqlite4java:libsqlite4java-osx-aarch64:1.0.392")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

// Create a fat JAR for easy execution
tasks.register<Jar>("fatJar") {
    archiveClassifier.set("all")
    from(sourceSets.main.get().output)
    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    }) {
        exclude("META-INF/*.RSA", "META-INF/*.SF", "META-INF/*.DSA")
    }
    manifest {
        attributes["Main-Class"] = "com.amazon.dbesdk.benchmark.Program"
    }
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
