# Plan: Native Java Implementation of DB-ESDK for DynamoDB

## Overview

This plan describes how to rewrite the AWS Database Encryption SDK (DB-ESDK) for DynamoDB as a fully native Java implementation, eliminating the Dafny-compiled code and the Dafny runtime dependency. The goal is a pure Java library that is wire-compatible with the existing Dafny-based implementation (i.e., items encrypted by one can be decrypted by the other).

## Current Architecture

The existing Java artifact is composed of three layers:

1. **Dafny-compiled code** — The core logic (structured encryption, item encryptor, DDB transforms, searchable encryption) is written in Dafny and transpiled to Java. This produces large, unreadable Java classes that depend on the Dafny runtime library.

2. **Smithy-generated model classes** — Public API types (POJOs for configs, inputs, outputs, enums) are generated from Smithy models. These are idiomatic Java and form the public API surface.

3. **Hand-written Java code** — The `DynamoDbEncryptionInterceptor` (AWS SDK v2 interceptor), the Enhanced Client integration (`DynamoDbEnhancedClientEncryption`), and `internaldafny` shim classes that bridge smithy-generated types to Dafny runtime types via `ToDafny`/`ToNative` converters.

### What We Keep
- Smithy-generated model classes (POJOs, enums, exceptions) — these define the public API
- `DynamoDbEncryptionInterceptor` — the AWS SDK v2 interceptor (hand-written)
- Enhanced Client integration classes
- The sdkv2 legacy compatibility layer

### What We Replace
- All Dafny-compiled Java code (the `internaldafny` packages)
- The `ToDafny`/`ToNative` converter classes (no longer needed)
- The Dafny runtime dependency

---

## Module Decomposition

The native Java implementation maps to 4 logical modules, mirroring the Dafny structure:

### Module 1: Structured Encryption (`structured-encryption`)
The cryptographic core. Handles encrypt/decrypt of structured data with header/footer construction.

| Dafny Source | Native Java Class | Responsibility |
|---|---|---|
| `Header.dfy` | `HeaderSerializer` / `HeaderDeserializer` | Serialize/deserialize the binary header (version, flavor, messageID, legend, EC, EDKs, commitment) |
| `Footer.dfy` | `FooterSerializer` / `FooterVerifier` | Compute/verify HMAC recipient tags and optional ECDSA signature |
| `Crypt.dfy` | `FieldEncryptor` | Key derivation (HKDF → FieldRootKey → FieldKey) and AES-GCM encryption/decryption of terminal values |
| `Paths.dfy` | `CanonicalPath` | Compute canonical byte paths for fields (table name + depth + segments) |
| `Canonize.dfy` | `CryptoSchemaCanonizer` | Resolve auth actions from legend, sort fields by canonical path, build canonical crypto list |
| `SortCanon.dfy` | (merged into `CryptoSchemaCanonizer`) | Sorting logic for canonical paths |
| `Util.dfy` | `StructuredEncryptionUtil` | Shared constants, type IDs, helper functions |
| `OptimizedMergeSort.dfy` | (use `java.util.Arrays.sort`) | Not needed — Java stdlib sort suffices |
| `Operations.dfy` | `StructuredEncryptionImpl` | Top-level `encryptPathStructure`, `decryptPathStructure`, `resolveAuthActions` |

### Module 2: DynamoDB Item Encryptor (`dynamodb-item-encryptor`)
Bridges DynamoDB items to/from structured data and delegates to Module 1.

| Dafny Source | Native Java Class | Responsibility |
|---|---|---|
| `Operations.dfy` | `DynamoDbItemEncryptorImpl` | `encryptItem` / `decryptItem` — validates inputs, converts DDB item to structured data, calls structured encryption, converts back |
| `Index.dfy` | `DynamoDbItemEncryptorFactory` | Initialization/validation of config, construction of CMM, creation of encryptor instances |
| `Util.dfy` | `ItemEncryptorUtil` | Helpers for building encryption context, base context (v1/v2), attribute action validation |
| `InternalLegacyOverride.dfy` | `LegacyOverrideHandler` | Delegation to legacy DynamoDBEncryptor for migration |

### Module 3: DynamoDB Encryption Transforms (`dynamodb-transforms`)
Intercepts DDB API calls and applies encrypt/decrypt logic.

| Dafny Source | Native Java Class | Responsibility |
|---|---|---|
| `PutItemTransform.dfy` | `PutItemTransform` | Encrypt before PutItem |
| `GetItemTransform.dfy` | `GetItemTransform` | Decrypt after GetItem |
| `QueryTransform.dfy` | `QueryTransform` | Modify before Query, decrypt after Query |
| `ScanTransform.dfy` | `ScanTransform` | Modify before Scan, decrypt after Scan |
| `BatchWriteItemTransform.dfy` | `BatchWriteItemTransform` | Encrypt items in batch writes |
| `BatchGetItemTransform.dfy` | `BatchGetItemTransform` | Decrypt items in batch gets |
| `TransactWriteItemsTransform.dfy` | `TransactWriteItemsTransform` | Encrypt items in transact writes |
| `TransactGetItemsTransform.dfy` | `TransactGetItemsTransform` | Decrypt items in transact gets |
| `UpdateItemTransform.dfy` | `UpdateItemTransform` | Validate update expressions |
| `DeleteItemTransform.dfy` | `DeleteItemTransform` | Validate delete conditions |
| `ExecuteStatementTransform.dfy` | `ExecuteStatementTransform` | Block PartiQL on encrypted tables |
| `BatchExecuteStatementTransform.dfy` | `BatchExecuteStatementTransform` | Block batch PartiQL on encrypted tables |
| `ExecuteTransactionTransform.dfy` | `ExecuteTransactionTransform` | Block transact PartiQL on encrypted tables |
| `DynamoDbMiddlewareSupport.dfy` | `DdbMiddlewareSupport` | Shared validation (writable check, condition/update expression validation) |
| `DdbStatement.dfy` | `DdbStatementParser` | Parse PartiQL statements to extract table names |
| `DdbMiddlewareConfig.dfy` | `TransformConfig` | Configuration holder for transforms |
| `Index.dfy` | `DynamoDbEncryptionTransformsImpl` | Factory/initialization |
| `AttributeResolver.dfy` | `AttributeResolver` | Resolve attributes for beacon operations |

### Module 4: DynamoDB Encryption / Searchable Encryption (`dynamodb-encryption`)
Beacon configuration, filter expression rewriting, and searchable encryption support.

| Dafny Source | Native Java Class | Responsibility |
|---|---|---|
| `DynamoToStruct.dfy` | `DynamoDbItemConverter` | Convert DDB `AttributeValue` ↔ `StructuredDataTerminal` (serialization per spec) |
| `SearchInfo.dfy` | `SearchInfo` | Beacon key management, search config resolution |
| `Beacon.dfy` | `StandardBeaconImpl` | Standard beacon computation (HMAC-based) |
| `CompoundBeacon.dfy` | `CompoundBeaconImpl` | Compound beacon construction |
| `ConfigToInfo.dfy` | `BeaconConfigResolver` | Convert user beacon config to internal search info |
| `FilterExpr.dfy` | `FilterExpressionRewriter` | Rewrite filter/condition expressions to use beacons |
| `Virtual.dfy` | `VirtualFieldComputer` | Compute virtual fields from source attributes |
| `DDBSupport.dfy` | `DdbSupport` | Add/remove beacons, writable checks, expression validation |
| `NormalizeNumber.dfy` | `NumberNormalizer` | Normalize DDB number strings |
| `TermLoc.dfy` | `TerminalLocator` | Parse and resolve terminal locations in structured data |
| `UpdateExpr.dfy` | `UpdateExpressionValidator` | Validate update expressions against crypto schema |
| `DynamoDbEncryptionBranchKeyIdSupplier.dfy` | `BranchKeyIdSupplierImpl` | Branch key ID supplier for multi-tenant |
| `Util.dfy` | `DynamoDbEncryptionUtil` | Shared utilities |

---

## Implementation Phases

### Phase 0: Project Setup ✅ COMPLETE
- [x] Set up Gradle multi-module project structure
- [x] Define module boundaries: `StructuredEncryption`, `DynamoDbEncryption`
- [x] Add dependencies: AWS SDK v2, AWS Cryptographic Materials Providers (MPL) for Java 1.11.1-SNAPSHOT
- [x] Copy over smithy-generated model classes unchanged
- [x] Copy over hand-written interceptor and enhanced client code
- [x] Set up test infrastructure (JUnit 5)

### Phase 1: Structured Encryption (Core Crypto) — ✅ COMPLETE
This is the foundation everything else depends on. Implement bottom-up:

1. **`StructuredEncryptionUtil`** — Constants (BYTES_TYPE_ID=0xFFFF, header/footer path names), helper methods
2. **`CanonicalPath`** — Compute canonical byte representation of field paths (table name + depth + segments with `$`/`#` prefixes)
3. **`HeaderSerializer` / `HeaderDeserializer`** — Binary serialization per spec:
   - Format Version (1 byte: 0x01 or 0x02)
   - Format Flavor (1 byte: algorithm suite)
   - Message ID (32 bytes random)
   - Encrypt Legend (2-byte length + legend bytes: `e`/`s`/`c`)
   - Encryption Context (2-byte count + sorted key-value pairs)
   - Encrypted Data Keys (1-byte count + entries)
   - Header Commitment (32 bytes HMAC-SHA384 truncated)
4. **`FieldEncryptor`** — Key derivation and encryption:
   - HKDF-SHA512 with info="AWS_DBE_DERIVE_KEY" + messageID → FieldRootKey (32 bytes)
   - FieldKeyNonce = "AwsDbeField" + 0x2c + offset(4 bytes)
   - AES-256-CTR stream of FieldRootKey with FieldKeyNonce → FieldKey (44 bytes = 32 cipherkey + 12 nonce)
   - AES-256-GCM encrypt/decrypt with cipherkey, nonce, AAD=canonical path
5. **`FooterSerializer` / `FooterVerifier`** — Canonical hash (SHA-384 of header + AAD + sorted signed fields) → HMAC tags per EDK + optional ECDSA-P384 signature
6. **`CryptoSchemaCanonizer`** — Sort fields by canonical path, build legend, resolve auth actions from legend
7. **`StructuredEncryptionImpl`** — Orchestrate: get materials from CMM → derive keys → encrypt fields → build header → compute footer

### Phase 2: DynamoDB Item Conversion ✅ COMPLETE
1. **`DynamoDbItemConverter`** — Bidirectional conversion between `Map<String, AttributeValue>` and `List<CryptoItem>`:
   - Serialize each attribute value to bytes per type ID table (NULL=0x0000, S=0x0001, N=0x0002, B=0xFFFF, BOOL=0x0004, SS=0x0101, NS=0x0102, BS=0x01FF, M=0x0200, L=0x0300)
   - Handle sets (sorted, deduplicated), maps (sorted by key), lists (ordered)
   - Number normalization
2. **`NumberNormalizer`** — Normalize DDB number strings (strip leading zeros, normalize scientific notation)

### Phase 3: DynamoDB Item Encryptor ✅ COMPLETE
1. **`ItemEncryptorUtil`** — Build DynamoDB Item Base Context (v1: table name + partition key name + key values; v2: table name + partition key name + sort key name)
2. **`DynamoDbItemEncryptorImpl`** — Implement `encryptItem` and `decryptItem`:
   - Validate input (partition key present, sort key if configured, attribute actions cover all attributes)
   - Handle legacy/plaintext policies
   - Convert DDB item → CryptoList
   - Build encryption context
   - Create Required Encryption Context CMM
   - Delegate to `StructuredEncryptionImpl`
   - Convert result back to DDB item
3. **`DynamoDbItemEncryptorFactory`** — Validate config, construct default CMM from keyring if needed

### Phase 4: DynamoDB Encryption Transforms ✅ COMPLETE
1. **`DdbMiddlewareSupport`** — Shared logic: writable validation, condition/update expression validation
2. **`DdbStatementParser`** — Extract table names from PartiQL statements
3. **Individual transform classes** — Each is relatively thin:
   - Input transforms: validate, add beacons, encrypt
   - Output transforms: decrypt, remove beacons
   - Validation transforms: check expressions, block PartiQL

### Phase 5: Searchable Encryption (Beacons) ✅ COMPLETE
1. **`StandardBeaconImpl`** — HMAC-SHA384 truncated to configured bit length
2. **`CompoundBeaconImpl`** — Concatenate parts with separators
3. **`VirtualFieldComputer`** — Apply transforms (upper, lower, prefix, suffix, substring, segment, insert)
4. **`FilterExpressionRewriter`** — Parse and rewrite DDB filter/condition expressions to reference beacon attributes
5. **`DdbSupport`** — Add signed beacons, add encrypted beacons, remove beacons, handle beacon key field name
6. **`BeaconConfigResolver`** — Convert user-facing `BeaconVersion` config to internal `SearchInfo`
7. **`SearchInfo`** — Manage beacon key cache, resolve branch key IDs

### Phase 6: Integration & Wiring ✅ COMPLETE
1. **Replace `internaldafny` shims** — ✅ DONE. All service classes rewired to native implementations.
2. **Remove `ToDafny`/`ToNative` converters** — ✅ DONE. No Dafny types anywhere.
3. **Update `DynamoDbEncryptionInterceptor`** — ✅ DONE. Works via DynamoDbEncryptionTransforms.
4. **Update Enhanced Client integration** — ✅ DONE. DynamoDbEnhancedClientEncryption works as-is.
5. **Implement `GetEncryptedDataKeyDescription`** — ✅ DONE. Parses header, extracts EDK info.
6. **Implement `CreateDynamoDbEncryptionBranchKeyIdSupplier`** — ✅ DONE. Adapter pattern.
7. **Implement `ResolveAttributes`** — ✅ DONE. Returns empty maps (no beacon config active).
8. **Implement PartiQL blockers** — ✅ DONE. Parses table name, blocks encrypted tables.
9. **Implement ECDSA signature support** — ✅ DONE. Sign/verify with NONEwithECDSA, MPL key formats.
10. **Full FilterExpressionRewriter** — ❌ Passthrough stub (deferred — 60KB Dafny equivalent)

---

## Testing Strategy

### Unit Tests
- Each module gets comprehensive unit tests
- Port Dafny test cases (from `test/` directories) to JUnit
- Focus on edge cases: empty items, all attribute types, max-size attributes

### Integration Tests
- End-to-end tests with local dynamodb and fake KMS
- Test all DDB API paths: PutItem, GetItem, Query, Scan, BatchWrite, BatchGet, TransactWrite, TransactGet
- Test Enhanced Client path
- Test legacy migration path
- Test searchable encryption with beacons

### Specification Compliance Tests
- For each `//= specification/...` comment in the Dafny code, create a corresponding test that validates the MUST/MUST NOT requirement

---

## Dependencies

| Dependency | Purpose |
|---|---|
| AWS SDK for Java v2 (`dynamodb`, `core`) | DynamoDB client, interceptor API |
| AWS Cryptographic Material Providers (MPL) for Java (Dafny-based) | CMM, Keyring, algorithm suites, encryption materials |
| BouncyCastle or JCA | AES-GCM, HKDF-SHA512, HMAC-SHA384, ECDSA-P384, SHA-384 |
| AWS KMS SDK | KMS keyring support (via MPL) |

### ⚠️ HARD CONSTRAINT: Zero Dafny Types in DB-ESDK Code

**No Dafny types (`dafny.*`, `software.amazon.cryptography.*.internaldafny.*`, `Dafny.DafnySequence`, `Dafny.DafnyMap`, etc.) may appear anywhere in the native DB-ESDK Java source code — not in imports, fields, method signatures, or local variables.**

The MPL's public API (`software.amazon.cryptography.materialproviders.model.*` and `software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager`) uses only standard Java types (`Map<String, String>`, `List<String>`, `byte[]`, `Long`, etc.) and its own smithy-generated POJOs. No Dafny types leak through this boundary.

**If at any point during implementation a Dafny type is required to call MPL, STOP and alert the user immediately.** This would indicate a gap in MPL's public Java API that needs to be resolved upstream before proceeding.

### MPL Interaction

The native DB-ESDK calls MPL through its smithy-generated public Java API:

```java
// Example — no Dafny types anywhere
GetEncryptionMaterialsOutput output = cmm.GetEncryptionMaterials(
    GetEncryptionMaterialsInput.builder()
        .encryptionContext(Map.of("aws-crypto-table-name", "MyTable"))
        .commitmentPolicy(commitmentPolicy)
        .algorithmSuiteId(algorithmSuiteId)
        .maxPlaintextLength(plaintextLength)
        .requiredEncryptionContextKeys(requiredKeys)
        .build()
);
EncryptionMaterials materials = output.encryptionMaterials();
ByteBuffer plaintextDataKey = materials.plaintextDataKey();
```

- MPL handles Dafny conversion internally (inside its own `ToDafny`/`ToNative` shims)
- DB-ESDK never sees or touches those internals
- Crypto primitives (AES-GCM, HKDF, HMAC, ECDSA) are performed directly by DB-ESDK using JCA/BouncyCastle — MPL only provides key material

---

## Risk Areas & Considerations

### Cryptographic Correctness
- The most critical risk. Any deviation in key derivation, serialization order, or padding will produce incompatible ciphertext.
- Mitigation: Extensive cross-compatibility testing, byte-level comparison of headers/footers.

### Number Normalization
- DynamoDB number normalization is subtle (scientific notation, trailing zeros, precision).
- The Dafny `NormalizeNumber.dfy` is 8KB of logic. Must be ported precisely.

### Set Ordering
- Sets must be serialized in specific sort orders (UTF-16 binary order for strings/numbers, lexicographic for binary).
- Java's `String.compareTo` uses UTF-16 code unit order, which aligns with the spec.

### Filter Expression Rewriting
- `FilterExpr.dfy` is 60KB — the largest single file. It parses DDB expressions and rewrites them for beacons.
- Consider using a proper parser (ANTLR or hand-written recursive descent) rather than a direct port.

### Backward Compatibility
- Must support both header version 1 (no SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT) and version 2.
- Must handle legacy items (old DynamoDBEncryptor format) and plaintext items.

### Performance
- Native Java should be significantly faster than Dafny-compiled code (no Dafny runtime overhead, no sequence copying).
- Opportunity to use `ByteBuffer` for zero-copy serialization.

---

## Estimated Effort by Phase

| Phase | Estimated Effort | Complexity |
|---|---|---|
| Phase 0: Project Setup | 1 week | Low |
| Phase 1: Structured Encryption | 4-5 weeks | Very High (crypto, serialization) |
| Phase 2: Item Conversion | 1-2 weeks | Medium (many attribute types) |
| Phase 3: Item Encryptor | 2 weeks | Medium |
| Phase 4: Transforms | 2-3 weeks | Medium (many operations, but each is thin) |
| Phase 5: Searchable Encryption | 3-4 weeks | High (expression parsing, beacon logic) |
| Phase 6: Integration | 1-2 weeks | Medium |
| Testing & Validation | 3-4 weeks (parallel) | High |
| **Total** | **~16-20 weeks** | |

---

## File/Package Structure

```
src/main/java/software/amazon/cryptography/dbencryptionsdk/
├── structuredencryption/
│   ├── internal/
│   │   ├── StructuredEncryptionImpl.java
│   │   ├── HeaderSerializer.java
│   │   ├── HeaderDeserializer.java
│   │   ├── FooterSerializer.java
│   │   ├── FooterVerifier.java
│   │   ├── FieldEncryptor.java
│   │   ├── CanonicalPath.java
│   │   ├── CryptoSchemaCanonizer.java
│   │   └── StructuredEncryptionUtil.java
│   ├── model/          ← (keep smithy-generated)
│   └── StructuredEncryption.java  ← (rewire to internal impl)
├── dynamodb/
│   ├── internal/
│   │   ├── DynamoDbItemConverter.java
│   │   ├── NumberNormalizer.java
│   │   ├── DdbSupport.java
│   │   ├── FilterExpressionRewriter.java
│   │   ├── VirtualFieldComputer.java
│   │   ├── StandardBeaconImpl.java
│   │   ├── CompoundBeaconImpl.java
│   │   ├── BeaconConfigResolver.java
│   │   ├── SearchInfo.java
│   │   ├── BranchKeyIdSupplierImpl.java
│   │   ├── UpdateExpressionValidator.java
│   │   ├── TerminalLocator.java
│   │   └── DynamoDbEncryptionUtil.java
│   ├── model/          ← (keep smithy-generated)
│   ├── transforms/
│   │   ├── internal/
│   │   │   ├── DynamoDbEncryptionTransformsImpl.java
│   │   │   ├── PutItemTransform.java
│   │   │   ├── GetItemTransform.java
│   │   │   ├── QueryTransform.java
│   │   │   ├── ScanTransform.java
│   │   │   ├── BatchWriteItemTransform.java
│   │   │   ├── BatchGetItemTransform.java
│   │   │   ├── TransactWriteItemsTransform.java
│   │   │   ├── TransactGetItemsTransform.java
│   │   │   ├── UpdateItemTransform.java
│   │   │   ├── DeleteItemTransform.java
│   │   │   ├── ExecuteStatementTransform.java
│   │   │   ├── BatchExecuteStatementTransform.java
│   │   │   ├── ExecuteTransactionTransform.java
│   │   │   ├── DdbMiddlewareSupport.java
│   │   │   ├── DdbStatementParser.java
│   │   │   └── TransformConfig.java
│   │   └── model/      ← (keep smithy-generated)
│   ├── itemencryptor/
│   │   ├── internal/
│   │   │   ├── DynamoDbItemEncryptorImpl.java
│   │   │   ├── DynamoDbItemEncryptorFactory.java
│   │   │   ├── ItemEncryptorUtil.java
│   │   │   └── LegacyOverrideHandler.java
│   │   └── model/      ← (keep smithy-generated)
│   ├── DynamoDbEncryptionInterceptor.java  ← (keep hand-written)
│   └── enhancedclient/  ← (keep hand-written)
└── sdkv2/              ← (keep legacy compat layer)
```

---

## Key Specification References

Each implementation class should include spec-linking comments matching the existing pattern:

```java
//= specification/structured-encryption/header.md#message-id
//# Implementations MUST generate a fresh 256-bit random MessageID,
//# from a cryptographically secure source, for each record encrypted.
byte[] messageId = new byte[32];
SecureRandom.getInstanceStrong().nextBytes(messageId);
```

---

## Success Criteria

1. **Wire compatibility**: Items encrypted by native Java can be decrypted by Dafny-based implementation and vice versa
2. **API compatibility**: Public API (smithy-generated model classes) is unchanged — drop-in replacement
3. **No Dafny runtime dependency**: The final artifact has zero dependency on `dafny.jar` or Dafny-generated code
4. **All existing tests pass**: Integration tests, cross-language test vectors
5. **Performance improvement**: Measurable reduction in latency and memory usage vs Dafny-compiled version

---

### Phase 7: Test Vector Adaptation ⚠️ IN PROGRESS

The TestVectors project at `aws-database-encryption-sdk-dynamodb/TestVectors/runtimes/java` has 5 bridge files that convert between Dafny test driver types and the native API. These files use `ToDafny`/`ToNative` converters that no longer exist in the native artifact.

**Strategy**: Rewrite the 5 bridge files to perform the Dafny↔Native conversion inline (the conversions are simple type mappings). The Dafny test driver and runtime remain — only the bridge layer changes.

**Files to modify:**
1. `CreateInterceptedDDBClient_Compile/__default.java` — Takes Dafny config, creates intercepted DDB client
2. `CreateWrappedItemEncryptor_Compile/__default.java` — Takes Dafny config, creates item encryptor
3. `internaldafny/wrapped/__default.java` — Wraps DynamoDbEncryption service
4. `wrapped/TestDynamoDbEncryption.java` — Wraps DynamoDbEncryption for test harness
5. `wrapped/TestDynamoDbItemEncryptor.java` — Wraps item encryptor for test harness

