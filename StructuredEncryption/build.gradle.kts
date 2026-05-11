import java.io.FileInputStream
import java.util.Properties

val props = Properties().apply {
    load(FileInputStream(File(rootProject.rootDir, "project.properties")))
}

dependencies {
    implementation("software.amazon.awssdk:dynamodb")
    implementation("org.bouncycastle:bcprov-jdk18on:${props.getProperty("bouncyCastleVersion")}")

    testImplementation("org.junit.jupiter:junit-jupiter:5.11.4")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.4")
}
