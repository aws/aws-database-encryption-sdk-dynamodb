<!-- Copyright Amazon.com Inc. or its affiliates. All Rights Reserved. -->
<!-- SPDX-License-Identifier: Apache-2.0 -->

# TestServer

A cross-language conformance testing framework for the AWS Database Encryption SDK for
DynamoDB (DB-ESDK). One shared test suite exercises any language implementation of the
DB-ESDK by having each language expose a small HTTP server whose contract is defined by a
single, hand-written Smithy model.

Each test calls `CreateClient` on a server to construct a configured DB-ESDK client, gets
back a `ClientId`, and then performs encrypted DynamoDB operations against that client by
supplying the `ClientId` on every subsequent request.

The MVP is **Java only** and uses the DynamoDB Enhanced Client (high-level) API.

## Layout

```
test-server/
├── Makefile                # generate, build-java, start-java, test-java
├── smithy-build.json       # the code generation target (one plugin: java-codegen)
├── build.gradle.kts        # isolated Smithy codegen build (drives `generate`)
├── model/
│   └── test-server.smithy  # THE single source of truth for the wire contract
├── runtimes/
│   └── java/               # the Java_Server + the shared Test_Suite (generated client)
└── build/                  # generated client + server scaffolding (git-ignored)
```

## Make targets

| Target       | What it does |
|--------------|--------------|
| `generate`   | Generate the Java client + server scaffolding from `model/` into `build/`. |
| `build-java` | Generate (if needed) then compile the Java_Server. |
| `start-java` | Build (if needed) then start the Java_Server (`PORT`, default 8080). |
| `test-java`  | Build (if needed) then run the round-trip Test_Suite against the configured endpoint. |

The Test_Suite does not start the server or DynamoDB. Start DynamoDB Local and the
Java_Server first, then point the suite at them via configuration:

```
make HOST=localhost PORT=8080 \
     DDB_ENDPOINT=http://localhost:8000 DDB_REGION=us-west-2 \
     KMS_KEY_ID=arn:aws:kms:us-west-2:<acct>:key/<id> \
     test-java
```

## The extensibility contract

The framework is structured so additional languages can be added without touching the
model or the existing Java_Server (Requirement 8). The seams:

1. **The wire contract lives solely in `model/test-server.smithy`** (Req 8.1).
   It is plain Smithy 2.0 — only standard constructs and the standard
   `smithy.protocols#rpcv2Cbor` protocol trait, no `aws.polymorph` traits and nothing
   Java-specific. Every request/response shape, operation, and error
   (`GenericServerError`, `DBESDKClientError`) is defined here and nowhere else. Each
   Language_Server and the Test_Suite use only the **generated** types; no server or test
   defines its own wire shapes. (The Java server's internal `adapter` value types —
   `CreateClientConfig`, `TableEncryptionConfigValue`, `KeyringConfigValue`,
   `BackendConfig`, `EnhancedClientHandle` — are server-side representations decoupled
   from the generated types; they are never used as the transport contract.)

2. **Code generation is the shared, language-agnostic target** (Req 8.2).
   `smithy-build.json` declares one plugin (`java-codegen`, modes `client` + `server`)
   against the model. The model is the same for every language, so adding a new
   Language_Server is a matter of **adding another code generation target/plugin** (e.g. a
   Rust codegen plugin/projection) that consumes the same `model/`, plus a new
   `runtimes/<language>/` implementation — **without editing `model/test-server.smithy`
   and without editing the Java_Server**.

3. **The Test_Suite endpoint is fully configuration-driven** (Reqs 8.3, 8.4).
   `TestServerEndpointConfig.fromRuntime()` reads the target Language_Server endpoint
   (host + port, or a full URL) and the DynamoDB_Backend endpoint from system properties
   (with environment-variable fallbacks) — never hard-coded. The same test source targets
   any Language_Server by changing only configuration. A missing/garbled endpoint, or an
   unreachable server, is reported as a failure, never a pass (Reqs 7.5, 8.5).

### Adding a new Language_Server (e.g. Rust)

No change to `model/test-server.smithy` or to `runtimes/java/`:

1. Add a code generation target for the new language that reads the same `model/`
   (a new Smithy build plugin/projection, or the language's own generator pointed at the
   model). It produces that language's client + server scaffolding from the shared
   contract.
2. Implement `runtimes/<language>/` — wire the generated server scaffolding to handlers
   that delegate to that language's DB-ESDK, mirroring the Java_Server's
   registry/`CreateClient`/write/read structure.
3. Add `Makefile` targets for the new language (`build-<lang>`, `start-<lang>`).
4. Run the **existing** Java Test_Suite against the new server by pointing
   `HOST`/`PORT` at it: `make HOST=<host> PORT=<port> ... test-java`. The test source is
   unchanged.
