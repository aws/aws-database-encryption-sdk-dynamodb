// Smithy code-generation build for the TestServer (driven by the `generate` Make target).
//
// HOW GENERATION RUNS (design decision, Req 3.1/3.2): generation is driven by the Smithy
// *Gradle* plugin (`software.amazon.smithy.gradle.smithy-base`) rather than the standalone
// Smithy CLI. The smithy-java code generators require Smithy >= 1.68, and the Gradle plugin
// resolves its own pinned Smithy/smithy-java versions from Maven, so generation does not
// depend on whatever Smithy CLI version happens to be installed on the machine.
//
// This project applies ONLY the smithy-java codegen plugins and the rpcv2Cbor trait package
// on an isolated classpath. It does NOT depend on the DB-ESDK or the AWS SDK, so the source
// model build discovers exactly the one hand-written model under model/ plus the standard
// rpcv2Cbor protocol trait — nothing else leaks in from runtime dependencies.
//
// Output: build/smithyprojections/test-server-codegen/source/java-codegen/{java,resources}
// (consumed by runtimes/java/build.gradle.kts via -PgeneratedSrcDir).

plugins {
    // `java-library` provides the `implementation`/`runtimeClasspath` configurations the
    // smithy-base "source" build uses to discover the trait packages needed to load the model.
    `java-library`
    id("software.amazon.smithy.gradle.smithy-base") version "1.4.0"
}

// Pinned, non-floating versions (Req: pin a specific version).
val smithyJavaVersion = "1.4.0"   // smithy-java codegen + runtime (GA on Maven Central)
val smithyCoreVersion = "1.71.0"  // Smithy core that smithy-java 1.4.0 codegen targets

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    // The smithy-java code generation plugin ("java-codegen") plus the codegen-time support
    // libraries it generates against. These are build-only (not part of any output artifact).
    smithyBuild("software.amazon.smithy.java:codegen-plugin:$smithyJavaVersion")
    smithyBuild("software.amazon.smithy.java:client-core:$smithyJavaVersion")
    smithyBuild("software.amazon.smithy.java:server-api:$smithyJavaVersion")
    // rpcv2Cbor protocol code generation support (client + server).
    smithyBuild("software.amazon.smithy.java:client-rpcv2-cbor:$smithyJavaVersion")
    smithyBuild("software.amazon.smithy.java:server-rpcv2-cbor:$smithyJavaVersion")

    // Trait package that defines `smithy.protocols#rpcv2Cbor` (the @rpcv2Cbor trait used by
    // the model). Required on the model-discovery (runtime) classpath to resolve the trait.
    implementation("software.amazon.smithy:smithy-protocol-traits:$smithyCoreVersion")
}

smithy {
    // Never run the opinionated Smithy formatter against the committed model file; the
    // `generate` target must leave committed sources untouched (Req 3.4, 1.6).
    format.set(false)
}
