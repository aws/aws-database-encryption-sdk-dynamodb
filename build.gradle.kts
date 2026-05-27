import java.io.FileInputStream
import java.util.Properties

plugins {
    `java-library`
    `maven-publish`
}

val props = Properties().apply {
    load(FileInputStream(File(rootProject.rootDir, "project.properties")))
}

group = "software.amazon.cryptography"
version = props.getProperty("projectJavaVersion")

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(platform("software.amazon.awssdk:bom:${props.getProperty("awsSdkVersion")}"))
    implementation("software.amazon.cryptography:aws-cryptographic-material-providers:${props.getProperty("mplDependencyJavaVersion")}")
    implementation("software.amazon.awssdk:dynamodb")
    implementation("software.amazon.awssdk:dynamodb-enhanced")
    implementation("software.amazon.awssdk:kms")
    implementation("org.bouncycastle:bcprov-jdk18on:${props.getProperty("bouncyCastleVersion")}")

    testImplementation("org.junit.jupiter:junit-jupiter:5.11.4")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.4")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifactId = "aws-database-encryption-sdk-dynamodb"
        }
    }
}
