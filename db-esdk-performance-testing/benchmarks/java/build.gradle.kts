import java.io.File
import java.io.FileInputStream
import java.util.Properties

plugins {
    java
    application
}

// Load properties from the main project
var props = Properties().apply {
    load(FileInputStream(File(rootProject.rootDir, "../../../project.properties")))
}

group = "com.amazon.dbesdk.benchmark"
version = "1.0.0"
description = "DB-ESDK Performance Benchmark for Java"

var mplVersion = props.getProperty("mplDependencyJavaVersion")
var dafnyRuntimeJavaVersion = props.getProperty("dafnyRuntimeJavaVersion") 
var smithyDafnyJavaConversionVersion = props.getProperty("smithyDafnyJavaConversionVersion")

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}

application {
    mainClass.set("com.amazon.dbesdk.benchmark.Program")
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    // Core DB-ESDK and cryptography dependencies
    implementation("software.amazon.cryptography:aws-cryptographic-material-providers:${mplVersion}")
    implementation("software.amazon.cryptography:aws-database-encryption-sdk-dynamodb:${props.getProperty("projectJavaVersion")}")
    
    // AWS SDK v2 dependencies
    implementation(platform("software.amazon.awssdk:bom:2.30.18"))
    implementation("software.amazon.awssdk:dynamodb")
    
    // Configuration and JSON processing
    implementation("org.yaml:snakeyaml:2.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.1")
    
    // Command line parsing
    implementation("commons-cli:commons-cli:1.9.0")
    
    // Progress bar for visual feedback (optional)
    implementation("me.tongfei:progressbar:0.10.1")
    
    // Testing dependencies
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.4")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.4")
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

// Run task configuration for easier command line usage
tasks.named<JavaExec>("run") {
    standardInput = System.`in`
    if (project.hasProperty("args")) {
        args = (project.property("args") as String).split(" ")
    }
}
