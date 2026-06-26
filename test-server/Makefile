# TestServer build orchestration (Project_Shell — Req 1.2).
#
# Discrete, individually-invocable targets. Tasks 1.3/1.4 provide `generate` and
# `build-java`; task 2.4 adds `start-java`; task 3.1 adds `test-java`.
#
# JDK REQUIREMENT (smithy-java 1.4.0): the generated client + server scaffolding and the
# smithy-java runtime REQUIRE JDK 21+. The Java_Server module pins a Java 21 toolchain
# (runtimes/java/build.gradle.kts). runtimes/java/settings.gradle.kts applies the Foojay
# toolchain-resolver convention so Gradle locates an already-installed JDK 21 or provisions
# one transparently on a fresh checkout. If toolchain auto-provisioning is disabled in your
# environment, install a JDK 21 (e.g. Amazon Corretto 21) so `build-java` can compile.
#
# HOW `generate` RUNS SMITHY (design decision):
#   Code generation is driven by the Smithy *Gradle* plugin via the dedicated
#   `test-server-codegen` Gradle build at this directory (test-server/build.gradle.kts +
#   settings.gradle.kts), NOT the standalone Smithy CLI. smithy-java's code generators
#   require Smithy >= 1.68, and the Gradle plugin resolves its own pinned Smithy /
#   smithy-java versions from Maven, so generation is independent of whatever Smithy CLI
#   version happens to be installed on the machine.
#
# Override the Gradle launcher (e.g. to point at a wrapper) with: make GRADLE=./gradlew generate

SHELL := /bin/bash

# Absolute path to this Makefile's directory (test-server/), independent of the caller's CWD.
TEST_SERVER_DIR := $(patsubst %/,%,$(dir $(abspath $(lastword $(MAKEFILE_LIST)))))

GRADLE ?= gradle

# Listen port for `start-java` (Req 6.2). Override with: make PORT=9001 start-java
# It is passed to the server as a program argument, which TestServerMain validates to be in
# 1..65535 (an out-of-range or in-use port fails startup without binding elsewhere — Req 6.3).
# `test-java` reuses PORT as the Language_Server port it connects the Test_Suite to.
PORT ?= 8080

# Test_Suite endpoint configuration (Reqs 8.3, 8.4) — read by the JUnit tests from runtime config.
# Override any of them on the command line, e.g. `make HOST=127.0.0.1 PORT=9001 test-java`.
#   HOST          host where the (already-running) Language_Server is listening.
#   PORT          its port (shared with start-java above).
#   DDB_ENDPOINT  the DynamoDB_Backend endpoint. EMPTY by default => the Test_Suite uses REAL AWS
#                 DynamoDB in DDB_REGION. Set DDB_ENDPOINT=http://localhost:8000 to target
#                 DynamoDB Local instead.
#   DDB_REGION    the DynamoDB_Backend region (used for real AWS; DynamoDB Local ignores it).
HOST ?= localhost
DDB_ENDPOINT ?=
DDB_REGION ?= us-west-2

# KMS key id for the CreateClient keyring config used by the round-trip tests. OPTIONAL: the tests
# default to the hard-coded demo key (DemoResources.KMS_KEY_ID) when this is empty. Override to use
# a different account's key:
#   make KMS_KEY_ID=arn:aws:kms:us-west-2:111122223333:key/<id> test-java
KMS_KEY_ID ?=

# Finalized smithy-build projection output ("source" projection, "java-codegen" plugin).
# This path is mirrored by runtimes/java/build.gradle.kts (generatedSrcDir / generatedResourcesDir).
GEN_PLUGIN_DIR := $(TEST_SERVER_DIR)/build/smithyprojections/test-server-codegen/source/java-codegen
GEN_JAVA_DIR   := $(GEN_PLUGIN_DIR)/java
GEN_RES_DIR    := $(GEN_PLUGIN_DIR)/resources

# The Java_Server module (generated scaffolding + hand-written handlers) lives here.
JAVA_DIR := $(TEST_SERVER_DIR)/runtimes/java

# A concrete generated file used as a Make file-dependency. Its presence proves the
# server scaffolding was generated; its absence (e.g. a fresh checkout) makes `build-java`
# transparently run `generate` first instead of failing on a missing input (Reqs 1.4, 1.5).
GEN_MARKER := $(GEN_JAVA_DIR)/software/amazon/cryptography/dbesdk/testserver/service/TestServer.java

.PHONY: help generate build-java start-java test-java

# Default target: list the available targets.
help:
	@echo "TestServer Make targets:"
	@echo "  generate     Generate the Java client + server scaffolding from model/ into build/ (Req 3.1, 3.2, 3.6)"
	@echo "  build-java   Generate (if needed) then compile the Java_Server under runtimes/java (Req 1.2, 1.4, 1.5, 3.3)"
	@echo "  start-java   Build (if needed) then start the Java_Server on PORT (default $(PORT)) (Req 6.1, 6.2)"
	@echo "  test-java    Build (if needed) then run the round-trip Test_Suite against the configured endpoint (Req 7.4)"

# generate (Req 3.1, 3.2, 3.4, 3.5, 3.6, 8.2):
#   Runs smithy-java code generation, producing BOTH the Java client and the Java server
#   scaffolding under build/. Re-invocation overwrites prior output so the result always
#   reflects the current model (Req 3.6). On failure (including model-validation failure,
#   whose message names the offending shape id) the target exits non-zero naming the failed
#   step and removes any partial generated output, leaving committed sources untouched
#   (Req 3.4, 3.5, 1.6).
generate:
	@echo "[generate] Generating TestServer Java client + server scaffolding from model/ ..."
	@# Clear prior plugin output so stale/removed shapes never linger (Req 3.6).
	@rm -rf "$(GEN_JAVA_DIR)" "$(GEN_RES_DIR)"
	@if ! "$(GRADLE)" --project-dir "$(TEST_SERVER_DIR)" --console=plain --rerun-tasks smithyBuild; then \
		echo "[generate] FAILED: smithy code generation did not complete." >&2; \
		echo "[generate]   If this was a model-validation error, the message above names the offending shape id." >&2; \
		rm -rf "$(GEN_JAVA_DIR)" "$(GEN_RES_DIR)"; \
		exit 1; \
	fi
	@if [ ! -d "$(GEN_JAVA_DIR)" ]; then \
		echo "[generate] FAILED: code generation produced no Java sources at $(GEN_JAVA_DIR)." >&2; \
		rm -rf "$(GEN_JAVA_DIR)" "$(GEN_RES_DIR)"; \
		exit 1; \
	fi
	@echo "[generate] OK: generated client + server scaffolding under:"
	@echo "[generate]   $(GEN_PLUGIN_DIR)"

# Generated-output file rule (Reqs 1.4, 1.5):
#   Expresses the `generate` output as a real Make file-dependency. When the generated
#   sources are absent (a fresh checkout, or after `git clean`), requesting this file makes
#   Make run `generate` to produce it, so downstream targets transparently regenerate their
#   prerequisites rather than terminating with a missing-input failure. When the file already
#   exists, Make skips regeneration and the downstream target compiles the existing output.
$(GEN_MARKER):
	@echo "[build-java] Generated sources absent; running 'generate' first ..."
	@$(MAKE) -f "$(abspath $(lastword $(MAKEFILE_LIST)))" generate

# build-java (Reqs 1.2, 1.4, 1.5, 1.6, 3.3):
#   Compiles the Java_Server (the generated client + server scaffolding plus any hand-written
#   handlers) under runtimes/java. It depends on the generated output ($(GEN_MARKER)) as a Make
#   file-dependency, so invoking `build-java` on a fresh checkout regenerates the scaffolding
#   transparently before compiling (Reqs 1.4, 1.5). Compilation writes only under the git-ignored
#   build/ directories, leaving committed sources unmodified. On failure the target exits non-zero
#   naming the failed target (Req 1.6); a successful compile demonstrates the generated client and
#   server scaffolding compile without errors (Req 3.3).
#
#   smithy-java 1.4.0 requires JDK 21+. The module pins a Java 21 toolchain and
#   runtimes/java/settings.gradle.kts applies the Foojay resolver so Gradle locates/provisions a
#   compatible JDK (see the JDK REQUIREMENT note at the top of this file).
build-java: $(GEN_MARKER)
	@echo "[build-java] Compiling the Java_Server (generated scaffolding + handlers) under runtimes/java ..."
	@if ! "$(GRADLE)" --project-dir "$(JAVA_DIR)" --console=plain compileJava; then \
		echo "[build-java] FAILED: Java_Server compilation did not complete." >&2; \
		echo "[build-java]   Committed sources are unchanged; only build/ output is affected." >&2; \
		exit 1; \
	fi
	@echo "[build-java] OK: Java_Server compiled (generated client + server scaffolding compile cleanly)."

# start-java (Reqs 6.1, 6.2, 6.3; design Build Targets table):
#   Builds the Java_Server (if needed) then starts it so it serves the model's operations over
#   HTTP on the configurable PORT. This is the process used for manual `curl` verification and the
#   one the Test_Suite (test-java, added later) targets. It depends on `build-java`, so on a fresh
#   checkout it transparently generates + compiles before starting (Reqs 1.4, 1.5).
#
#   The server is launched via the Gradle `application` plugin's `run` task (mainClass =
#   software.amazon.cryptography.dbesdk.testserver.server.TestServerMain). The port is passed as a
#   program argument (--args), which TestServerMain resolves and validates (1..65535); an
#   out-of-range or already-in-use port makes the server fail startup without binding another port
#   (Req 6.3). The DynamoDB_Backend endpoint/region are read by the server from the environment
#   ($TEST_SERVER_DDB_ENDPOINT / $TEST_SERVER_DDB_REGION), which Gradle's run task inherits.
#
#   This is a long-running, foreground process (it serves until interrupted), suitable for manual
#   verification. On failure the target exits non-zero naming itself (Req 1.6); it writes only under
#   the git-ignored build/ directories, leaving committed sources unmodified.
start-java: build-java
	@echo "[start-java] Starting the Java_Server on http://localhost:$(PORT) (Ctrl-C to stop) ..."
	@if ! "$(GRADLE)" --project-dir "$(JAVA_DIR)" --console=plain run --args="$(PORT)"; then \
		echo "[start-java] FAILED: the Java_Server did not start (e.g. port $(PORT) out of range or in use)." >&2; \
		exit 1; \
	fi

# test-java (Reqs 7.4, 7.5, 8.3, 8.4, 8.5; design Build Targets table + Testing Strategy):
#   Runs the round-trip Test_Suite (Requirement 7) under runtimes/java against a Language_Server
#   reachable at the configured endpoint. It depends on `build-java`, so on a fresh checkout it
#   transparently generates + compiles the module (which also compiles the generated client the
#   suite uses) before testing (Reqs 1.4, 1.5).
#
#   SERVER / DYNAMODB STARTUP RESPONSIBILITY (design decision):
#     `test-java` does NOT start the Java_Server or DynamoDB Local. Per the design's Test
#     environment, the DynamoDB_Backend is started before the suite runs and both the
#     Language_Server and the backend are reachable at endpoints supplied via runtime configuration.
#     Accordingly this target only *connects* the suite to an already-running server/backend:
#       1. start DynamoDB Local (listening at DDB_ENDPOINT), then
#       2. start the Java_Server (e.g. `make start-java`, listening on HOST:PORT) in another shell,
#       3. then run `make test-java`.
#     Keeping startup out of this target keeps the suite endpoint fully configuration-driven, so the
#     same target can point at any Language_Server (e.g. a future Rust server) without changes
#     (Reqs 8.3, 8.4).
#
#   ENDPOINT CONFIG (never hard-coded in the test source — Reqs 8.3, 8.4):
#     The endpoints are passed to the JUnit JVM as -D system properties; runtimes/java/build.gradle.kts
#     forwards them into the forked test JVM. The test source reads them via TestServerEndpointConfig.
#     --no-daemon ensures the -D values reach a fresh Gradle JVM rather than a stale daemon.
#
#   UNREACHABLE = FAILURE, NEVER A PASS (Reqs 7.5, 8.5):
#     If the Language_Server or DynamoDB_Backend is unreachable, the suite reports a failure (the
#     harness probes connectivity and the round-trip tests throw on connection errors — neither is
#     swallowed or skipped), `gradle test` exits non-zero, and this target exits non-zero naming
#     itself (Req 1.6). It writes only under the git-ignored build/ directories.
test-java: build-java
	@echo "[test-java] Running the round-trip Test_Suite against http://$(HOST):$(PORT) (DynamoDB_Backend $(DDB_ENDPOINT)) ..."
	@echo "[test-java]   NOTE: this target expects the Java_Server and DynamoDB Local to already be running at those endpoints."
	@if ! "$(GRADLE)" --project-dir "$(JAVA_DIR)" --console=plain --no-daemon test \
		-Dtestserver.endpoint.host="$(HOST)" \
		-Dtestserver.port="$(PORT)" \
		-Dtestserver.ddb.endpoint="$(DDB_ENDPOINT)" \
		-Dtestserver.ddb.region="$(DDB_REGION)" \
		-Dtestserver.kms.key.id="$(KMS_KEY_ID)"; then \
		echo "[test-java] FAILED: the round-trip Test_Suite did not pass (e.g. the Language_Server or DynamoDB_Backend was unreachable)." >&2; \
		echo "[test-java]   Ensure DynamoDB Local and the Java_Server are running at the configured endpoints, then re-run." >&2; \
		exit 1; \
	fi
	@echo "[test-java] OK: the round-trip Test_Suite passed."
