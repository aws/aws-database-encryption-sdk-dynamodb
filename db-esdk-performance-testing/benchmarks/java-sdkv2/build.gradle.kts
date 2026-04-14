import java.io.File
import java.io.FileInputStream
import java.util.Properties
import java.net.URI
import javax.annotation.Nullable

tasks.wrapper {
    gradleVersion = "7.6"
}

plugins {
    `java`
    `java-library`
    application
}

var props = Properties().apply {
    load(FileInputStream(File(rootProject.rootDir, "../../../project.properties")))
}

var mplVersion = props.getProperty("mplDependencyJavaVersion")
var ddbecVersion = props.getProperty("projectJavaVersion")
var dafnyRuntimeJavaVersion = props.getProperty("dafnyRuntimeJavaVersion")
var smithyDafnyJavaConversionVersion = props.getProperty("smithyDafnyJavaConversionVersion")

// Fall back to available local SNAPSHOT if exact version not found
val ddbecFallbackVersion = "3.9.0-SNAPSHOT"
val resolvedDdbecVersion = if (File(System.getProperty("user.home") +
    "/.m2/repository/software/amazon/cryptography/aws-database-encryption-sdk-dynamodb/${ddbecVersion}").exists())
    ddbecVersion else ddbecFallbackVersion

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

dependencies {
    // DB-ESDK and MPL (needed for DB-ESDK mode and legacy override mode)
    implementation("org.dafny:DafnyRuntime:${dafnyRuntimeJavaVersion}")
    implementation("software.amazon.smithy.dafny:conversion:${smithyDafnyJavaConversionVersion}")
    implementation("software.amazon.cryptography:aws-cryptographic-material-providers:${mplVersion}")
    implementation("software.amazon.cryptography:aws-database-encryption-sdk-dynamodb:${resolvedDdbecVersion}")

    // AWS SDK v2
    implementation(platform("software.amazon.awssdk:bom:2.30.18"))
    implementation("software.amazon.awssdk:dynamodb")
    implementation("software.amazon.awssdk:dynamodb-enhanced")
    implementation("software.amazon.awssdk:core:2.30.18")
    implementation("software.amazon.awssdk:kms")

    // Netty (required by SDKv2 DynamoDBEncryptor)
    implementation("io.netty:netty-common:4.2.9.Final")

    // Apache Commons CLI for command line parsing
    implementation("commons-cli:commons-cli:1.5.0")

    // SnakeYAML for YAML configuration parsing
    implementation("org.yaml:snakeyaml:2.0")

    // Jackson for JSON output
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
}

// Include the SDKv2 source from the main project
sourceSets {
    main {
        java {
            srcDir("../../../DynamoDbEncryption/runtimes/java/src/main/sdkv2")
        }
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

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
    jvmArgs = listOf("-Xmx8g")
}
