import java.io.FileInputStream
import java.util.Properties

plugins {
    `java-library`
}

val props = Properties().apply {
    load(FileInputStream(File(rootProject.rootDir, "project.properties")))
}

subprojects {
    apply(plugin = "java-library")

    group = "software.amazon.cryptography"
    version = props.getProperty("projectVersion")

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(8))
    }

    repositories {
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        implementation(platform("software.amazon.awssdk:bom:${props.getProperty("awsSdkVersion")}"))
        implementation("software.amazon.cryptography:aws-cryptographic-material-providers:${props.getProperty("mplVersion")}")
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    tasks.test {
        useJUnitPlatform()
    }
}
