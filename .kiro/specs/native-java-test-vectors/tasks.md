# Implementation Plan: Native Java Test Vectors

## Overview

Rewrite the Dafny-transpiled Java test vector harness into idiomatic native Java, organized in 4 phases by dependency depth. Each phase builds on the previous, culminating in a fully functional test runner that exercises the same JSON test vectors without any Dafny runtime dependencies.

## Tasks

- [ ] 1. Phase 1: Foundation — Project setup and leaf utilities
  - [ ] 1.1 Update build.gradle.kts to remove Dafny dependencies and add Jackson/jqwik
    - Remove `org.dafny:DafnyRuntime` and `software.amazon.smithy.dafny:conversion` dependencies
    - Remove `src/main/dafny-generated`, `src/main/smithy-generated`, and `src/test/dafny-generated` source sets
    - Add `com.fasterxml.jackson.core:jackson-databind` implementation dependency
    - Add `net.jqwik:jqwik` test dependency
    - Update `runTests` task main class to `software.amazon.cryptography.dbencryptionsdk.dynamodb.testvectors.runner.TestVectorRunner`
    - Keep existing MPL, DBESDK, TestAwsCryptographicMaterialProviders, AWS SDK v2, and DynamoDB Local dependencies
    - _Requirements: 20.1, 20.2, 20.3, 20.4, 20.5, 1.5_

  - [ ] 1.2 Create TestVectorModels data classes
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/model/` package
    - Implement `Record`, `LargeRecord`, `TableConfig`, `SimpleQuery`, `ComplexQuery`, `ComplexTest`, `IoTest`, `RoundTripTest`, `WriteTest`, `DecryptTest`, `TestVectorConfig` as POJOs
    - Use standard Java types: `Map<String, AttributeValue>`, `List<>`, `Optional<>`
    - Use PascalCase class names, camelCase field names, UPPER_SNAKE_CASE constants
    - _Requirements: 1.2, 1.3, 2.1, 2.2, 2.3, 2.5, 2.7_

  - [ ] 1.3 Implement JsonItem — AttributeValue ↔ JSON conversion
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/JsonItem.java`
    - Implement `attributeMapToJson` and `attributeValueToJson` for AttributeValue → JsonNode
    - Implement `jsonToAttributeMap` and `jsonToAttributeValue` for JsonNode → AttributeValue
    - Handle type descriptors: S, N, B, SS, NS, BS, L, M, BOOL, NULL
    - Handle JSON string shorthand → S, JSON number shorthand → N
    - Implement Base64 encoding/decoding for B and BS types
    - Implement `normalizeItem` and `normalize` for number canonicalization and set sorting
    - Throw descriptive exceptions for invalid type descriptors or malformed JSON
    - _Requirements: 4.1, 4.2, 4.3, 4.4, 4.5, 4.6, 4.7, 10.3_

  - [ ]* 1.4 Write property test for JsonItem round-trip
    - **Property 1: AttributeValue JSON Round-Trip**
    - Create custom jqwik generators for all DynamoDB AttributeValue types (S, N, B, SS, NS, BS, L, M, BOOL, NULL)
    - Verify `jsonToAttributeMap(attributeMapToJson(item)) == normalizeItem(item)` for all generated inputs
    - Minimum 100 iterations
    - **Validates: Requirements 4.1, 4.2, 4.3, 4.4, 4.5, 4.7**

  - [ ]* 1.5 Write property test for normalization idempotence
    - **Property 2: Normalization Idempotence**
    - Verify `normalizeItem(normalizeItem(item)) == normalizeItem(item)` for all generated AttributeMaps
    - Reuse AttributeValue generators from 1.4
    - Minimum 100 iterations
    - **Validates: Requirements 10.3**

  - [ ] 1.6 Implement Permute — combinatorial permutation utility
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/Permute.java`
    - Implement `generatePermutations` using Heap's algorithm
    - Return `List<List<T>>` containing all permutations of the input list
    - _Requirements: 17.1, 17.2_

  - [ ]* 1.7 Write property test for Permute completeness
    - **Property 3: Permutation Completeness**
    - Verify output size equals n! for input lists of size 1–6
    - Verify each permutation contains exactly the same elements as the input
    - Verify all permutations are distinct
    - Minimum 100 iterations
    - **Validates: Requirements 17.1, 17.2**

  - [ ] 1.8 Implement DdbClientFactory — DynamoDB client creation
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/client/DdbClientFactory.java`
    - Implement `createEncryptedClient(String tableName, DynamoDbTableEncryptionConfig config)` that creates a `DynamoDbClient` with `DynamoDbEncryptionInterceptor`
    - Implement `createVanillaClient()` that creates a plain `DynamoDbClient` without interceptors
    - Configure endpoint override to `http://localhost:8000`
    - Configure region via `DefaultAwsRegionProviderChain`
    - Wrap SDK exceptions in `RuntimeException`
    - _Requirements: 3.1, 3.2, 3.3, 3.4, 3.5, 3.6_

  - [ ] 1.9 Implement ItemEncryptorFactory — DynamoDbItemEncryptor creation
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/client/ItemEncryptorFactory.java`
    - Implement `create(DynamoDbItemEncryptorConfig config)` that builds and returns a `DynamoDbItemEncryptor`
    - _Requirements: 7.1, 7.2, 7.3, 7.4, 7.5, 7.6, 7.7_

- [ ] 2. Checkpoint — Phase 1 complete
  - Ensure all tests pass, ask the user if questions arise.

- [ ] 3. Phase 2: Mid-level — Configuration parsing and manifest writing
  - [ ] 3.1 Implement WriteManifest — encrypt manifest generation
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/manifest/WriteManifest.java`
    - Implement `write(String filename)` that generates the encrypt.json manifest
    - Output JSON with `manifest` (type "aws-dbesdk-encrypt", version "1"), `keys` reference, and `tests` object
    - Each test entry contains type ("positive-encrypt", "negative-encrypt", or "negative-decrypt"), description, config, and record
    - Use Jackson for JSON serialization
    - _Requirements: 6.1_

  - [ ] 3.2 Implement WriteSetPermutations — PermTest.json generation
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/WriteSetPermutations.java`
    - Implement `writeSetPermutations()` that generates PermTest.json
    - Use `Permute.generatePermutations` for set element orderings
    - Generate permutations for SS, NS, BS at sizes 1–4
    - Write output using Jackson
    - _Requirements: 17.1, 17.2_

  - [ ] 3.3 Implement JsonConfigKeyring — keyring resolution from JSON
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/config/JsonConfigKeyring.java`
    - Implement `resolveKeyring(JsonNode keyDescription, KeyVectorsClient keyVectors)` that parses key descriptions and creates keyrings via MPL KeyVectors
    - Implement `parseAlgorithmSuiteId(String id)` for DBEAlgorithmSuiteId resolution
    - Handle algorithmSuiteId, plaintextOverride, legacyOverride configurations
    - _Requirements: 7.2, 7.5_

  - [ ] 3.4 Implement JsonConfigBeacon — beacon/search config parsing
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/config/JsonConfigBeacon.java`
    - Implement `parseSearchConfig`, `parseBeaconVersion`, `parseStandardBeacon`, `parseCompoundBeacon`, `parseVirtualField`
    - Parse BeaconKeySource from JSON
    - _Requirements: 5.2, 11.1_

  - [ ] 3.5 Implement JsonConfigParser — main configuration assembly
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/config/JsonConfigParser.java`
    - Implement `addJson(TestVectorConfig prev, String file, KeyVectorsClient keyVectors)` for incremental config loading
    - Implement `getTableConfigs` to parse configs.json into `Map<String, TableConfig>`
    - Implement `getOneTableConfig` to assemble a `DynamoDbTableEncryptionConfig` with attribute actions, keyrings, algorithm suite, allowed unsigned attributes, and search config
    - Implement `getRecords` to parse records.json into `List<Record>`
    - Implement `getItemEncryptor` to create `DynamoDbItemEncryptor` from JSON config using `ItemEncryptorFactory` and `JsonConfigKeyring`
    - Parse IoTest, WriteTest, DecryptTest, RoundTripTest, SimpleQuery, ComplexQuery, ComplexTest structures from data.json and iotest.json
    - Throw descriptive exceptions for missing config references or unparseable files
    - Print warning and continue with empty config if a file cannot be read
    - _Requirements: 5.1, 5.2, 5.3, 5.4, 5.5, 5.6, 5.7, 7.1, 7.2, 7.3, 7.4, 7.5, 7.6, 7.7_

- [ ] 4. Checkpoint — Phase 2 complete
  - Ensure all tests pass, ask the user if questions arise.

- [ ] 5. Phase 3: Test Runners — Manifest encrypt and decrypt
  - [ ] 5.1 Implement DecryptManifest — decrypt manifest processing
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/manifest/DecryptManifest.java`
    - Implement `decrypt(String inFile, KeyVectorsClient keyVectors)` that reads and parses the decrypt manifest
    - Validate required top-level members: "keys", "client", "manifest" (type "aws-dbesdk-decrypt", version "1"), "tests"
    - For each test: create item encryptor from config, decrypt the encrypted record, verify plaintext matches expected after normalization
    - Handle negative-decrypt tests by verifying decryption fails
    - Process manifests from multiple languages/versions: dotnet (3.2, 3.3, 3.3a), java (3.2, 3.3, 3.3a, 3.9), rust (3.8), go (3.8)
    - Return failure result for missing/invalid manifest structure
    - _Requirements: 6.3, 6.7, 6.8, 6.9_

  - [ ] 5.2 Implement EncryptManifest — encrypt manifest processing
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/manifest/EncryptManifest.java`
    - Implement `encrypt(String inFile, String outFile, String lang, String version, KeyVectorsClient keyVectors)`
    - Read and validate input manifest (keys, manifest type "aws-dbesdk-encrypt" version "1", tests)
    - For positive-encrypt tests: encrypt record, produce output with type "positive-decrypt", description, config/decryptConfig, plaintext, and encrypted record
    - For negative-encrypt tests: verify encryption fails, exclude from output
    - For negative-decrypt tests: encrypt record, produce output with type "negative-decrypt"
    - Write decrypt manifest with manifest (type "aws-dbesdk-decrypt", version "1"), client (name, version), keys, and processed tests
    - _Requirements: 6.2, 6.4, 6.5, 6.6, 6.8_

- [ ] 6. Checkpoint — Phase 3 complete
  - Ensure all tests pass, ask the user if questions arise.

- [ ] 7. Phase 4: Orchestrator — Test execution and wiring
  - [ ] 7.1 Implement DdbTestHelper — DDB Local table lifecycle and utilities
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/runner/DdbTestHelper.java`
    - Implement `setupTestTable` to create the test table with partition key "RecNum" (N)
    - Implement `deleteTable` to delete the test table
    - Implement `writeAllRecords` to write records via PutItem
    - Implement `fullQuery` with pagination (max 100 iterations) using ExclusiveStartKey
    - Implement `fullScan` with pagination (max 100 iterations) using ExclusiveStartKey
    - Implement `compareRecords` that normalizes and compares AttributeMaps
    - Implement `trimMaps` to filter expression attribute names/values to only those referenced in expressions
    - _Requirements: 9.3, 9.6, 18.4_

  - [ ] 7.2 Implement IoTestsCrud — single-item DDB operations
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/runner/IoTestsCrud.java`
    - Implement PutItem test: write each record with write config, read back via GetItem/BatchGetItems/Scan/TransactGetItems with read config, verify match
    - Implement UpdateItem test: verify failure for ENCRYPT_AND_SIGN/SIGN_ONLY attributes, success for DO_NOTHING
    - Implement DeleteItem test: verify condition expression failures for encrypted attributes, success for non-encrypted
    - Implement DeleteItem without condition: verify success and returned attributes
    - _Requirements: 8.1, 8.4, 8.5, 8.6, 8.10_

  - [ ] 7.3 Implement IoTestsBatch — batch/transact DDB operations
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/runner/IoTestsBatch.java`
    - Implement BatchWriteItem test: write in batches of 10, read back and verify
    - Implement TransactWriteItems test: write in transactions of 10, read back and verify
    - Implement ExecuteStatement test: verify INSERT/SELECT PartiQL fails on encrypted tables
    - Implement ExecuteTransaction test: verify PartiQL transactions fail on encrypted tables
    - Implement BatchExecuteStatement test: verify PartiQL batch fails on encrypted tables
    - _Requirements: 8.2, 8.3, 8.7, 8.8, 8.9, 8.10_

  - [ ] 7.4 Implement QueryTests — query/scan and complex beacon tests
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/runner/QueryTests.java`
    - Implement basic query test: Query when keyExpr present, Scan when absent
    - Implement failConfigs skipping and failingQueries verification
    - Implement expression attribute trimming (parse tokens, retain only referenced placeholders)
    - Implement result comparison against vanilla baseline
    - Implement string ordering tests with all comparison operators (<, <=, >, >=, =, <>)
    - Implement complex query tests: write records, verify pass/fail lists, verify failure queries
    - Implement config modification tests: write with first config, query with second, compare results
    - Implement perf query tests
    - _Requirements: 9.1, 9.2, 9.3, 9.4, 9.5, 9.6, 9.7, 11.1, 11.2, 11.3, 11.4, 15.1, 15.2, 15.3, 16.1, 16.2_

  - [ ] 7.5 Implement WriteAndRoundTripTests — write, round-trip, decrypt, and large tests
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/runner/WriteAndRoundTripTests.java`
    - Implement round-trip tests: PutItem then GetItem, verify normalized equality for each config
    - Implement write tests: encrypt records, read back with vanilla client, serialize to JSON output file
    - Implement decrypt tests: write encrypted records with vanilla client, read with encrypted client, verify match
    - Implement large record tests: 1000 iterations of encrypt/decrypt for each config, measure and report timing
    - _Requirements: 10.1, 10.2, 10.3, 10.4, 10.5, 12.1, 12.2, 12.3, 13.1, 13.2, 13.3, 14.1, 14.2, 14.3_

  - [ ] 7.6 Implement TestVectorRunner — main entry point and orchestration
    - Create `src/main/java/software/amazon/cryptography/dbencryptionsdk/dynamodb/testvectors/runner/TestVectorRunner.java`
    - Implement `main(String[] args)` entry point
    - Initialize KeyVectors client using keys manifest at default path
    - Call `WriteSetPermutations.writeSetPermutations()` before loading configs
    - Load JSON configs in order: records.json, configs.json, data.json, iotest.json, PermTest.json, large_records.json
    - Execute all test categories via RunAllTests in order: decrypt manifests, write manifest, encrypt manifest, validate, string ordering, large tests, perf query tests, basic IO, run IO tests, basic query, config mod, complex tests, write tests, round-trip tests, decrypt tests
    - Delete test table after all tests complete
    - _Requirements: 18.1, 18.2, 18.3, 18.4, 18.5_

  - [ ] 7.7 Implement validation logic
    - Implement sequential record number validation (starting from zero)
    - Implement config name existence checks for complex tests, query fail lists, IO test pairs, and config mod pairs
    - Print descriptive error messages and terminate on validation failure
    - _Requirements: 19.1, 19.2, 19.3, 19.4, 19.5_

  - [ ]* 7.8 Write property test for validation detection
    - **Property 4: Validation Detects Invalid Config References**
    - Generate TestVectorConfig instances with invalid config name references in complexTests, queries.failConfigs, configsForIoTest, configsForModTest
    - Verify validation step detects and reports each invalid reference
    - Minimum 100 iterations
    - **Validates: Requirements 19.2, 19.3, 19.4**

- [ ] 8. Final checkpoint — Ensure all tests pass
  - Ensure all tests pass, ask the user if questions arise.

## Notes

- Tasks marked with `*` are optional and can be skipped for faster MVP
- Each task references specific requirements for traceability
- Checkpoints ensure incremental validation between phases
- Property tests validate universal correctness properties from the design document
- The 4-phase ordering ensures no forward dependencies: each phase only depends on earlier phases
- All code uses Java 8 source compatibility per the Gradle toolchain configuration
- Jackson is used for all JSON parsing/serialization (replaces Dafny JSON library)
- jqwik is used for property-based testing

## Task Dependency Graph

```json
{
  "waves": [
    { "id": 0, "tasks": ["1.1"] },
    { "id": 1, "tasks": ["1.2", "1.6", "1.8", "1.9"] },
    { "id": 2, "tasks": ["1.3", "1.7"] },
    { "id": 3, "tasks": ["1.4", "1.5"] },
    { "id": 4, "tasks": ["3.1", "3.2", "3.3", "3.4"] },
    { "id": 5, "tasks": ["3.5"] },
    { "id": 6, "tasks": ["5.1", "5.2"] },
    { "id": 7, "tasks": ["7.1"] },
    { "id": 8, "tasks": ["7.2", "7.3", "7.4", "7.5", "7.7"] },
    { "id": 9, "tasks": ["7.6", "7.8"] }
  ]
}
```
