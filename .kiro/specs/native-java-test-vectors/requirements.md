# Requirements Document

## Introduction

This feature rewrites the Dafny-generated Java test vector code for the AWS Database Encryption SDK for DynamoDB into idiomatic native Java. The current implementation uses auto-generated code from Dafny that relies on Dafny runtime types (`Wrappers_Compile.Result`, `DafnySequence`, etc.) with non-idiomatic naming conventions (packages like `CreateInterceptedDDBClient_Compile`, classes named `__default`). The rewrite eliminates all Dafny runtime dependencies, uses standard Java types and patterns, maintains the same test vector functionality, and follows proper Java naming conventions.

## Glossary

- **Test_Vector_Runner**: The main Java application that orchestrates loading JSON configuration files and executing all test categories against DynamoDB Local
- **JSON_Config_Parser**: The component responsible for parsing JSON test vector configuration files (records.json, configs.json, data.json, iotest.json, PermTest.json, large_records.json) into Java data structures
- **JSON_Item_Converter**: The component responsible for bidirectional conversion between DynamoDB `AttributeValue` objects and their JSON representations
- **DDB_Client_Factory**: The component responsible for creating DynamoDB clients with or without encryption interceptors, configured to connect to DynamoDB Local
- **Manifest_Processor**: The component responsible for writing, encrypting, and decrypting test manifests for cross-language compatibility testing
- **Item_Encryptor_Factory**: The component responsible for creating `DynamoDbItemEncryptor` instances from JSON configuration
- **Test_Executor**: The component responsible for running all test categories (IO tests, query tests, round-trip tests, decrypt tests, large/perf tests, complex tests, write tests)
- **TableConfig**: A data structure holding a configuration name, a `DynamoDbTableEncryptionConfig`, and a vanilla flag indicating whether encryption is disabled
- **Record**: A data structure holding a record number (natural number) and a DynamoDB `AttributeMap`
- **TestVectorConfig**: The aggregate data structure holding all parsed test vector data including records, configs, queries, tests, and string ordering data
- **KeyVectors_Client**: The `TestAwsCryptographicMaterialProviders` KeyVectors client used to resolve cryptographic key references in test manifests

## Requirements

### Requirement 1: Eliminate Dafny Runtime Dependencies

**User Story:** As a developer, I want the test vector code to use only standard Java types and AWS SDK types, so that the codebase is maintainable without Dafny toolchain knowledge.

#### Acceptance Criteria

1. THE Test_Vector_Runner SHALL compile and execute the full test suite without any classes from the `dafny` runtime library on the classpath
2. THE Test_Vector_Runner SHALL not reference any types from packages matching `dafny.*`, `Wrappers_Compile`, `*_Compile`, or classes originating from the `org.dafny:DafnyRuntime` or `software.amazon.smithy.dafny:conversion` artifacts, including but not limited to `DafnySequence`, `DafnyMap`, `DafnySet`, `Wrappers_Compile.Option`, and `Wrappers_Compile.Result`
3. THE Test_Vector_Runner SHALL use standard Java types: `java.util.Optional` instead of `Wrappers_Compile.Option`, runtime exceptions instead of `Wrappers_Compile.Result` for error signaling, `java.util.List` instead of `DafnySequence`, and `java.util.Map` instead of `DafnyMap`
4. THE Test_Vector_Runner SHALL use the native AWS SDK v2 `software.amazon.awssdk.services.dynamodb.DynamoDbClient` directly instead of the Dafny `Shim` wrapper
5. THE Test_Vector_Runner SHALL not declare any compile or runtime dependency on `org.dafny:DafnyRuntime` or `software.amazon.smithy.dafny:conversion` in its Gradle build configuration, including transitive dependencies

### Requirement 2: Idiomatic Java Package and Class Structure

**User Story:** As a developer, I want the code organized with proper Java naming conventions, so that it follows standard Java project conventions and is easy to navigate.

#### Acceptance Criteria

1. THE Test_Vector_Runner SHALL place all source files under a package hierarchy rooted at `software.amazon.cryptography.dbencryptionsdk.dynamodb.testvectors`
2. THE Test_Vector_Runner SHALL use PascalCase for class names (e.g., `CreateInterceptedDdbClient` instead of `__default`)
3. THE Test_Vector_Runner SHALL use camelCase for method names (e.g., `createInterceptedDdbClient` instead of `CreateInterceptedDDBClient`)
4. THE Test_Vector_Runner SHALL not use packages ending in `_Compile` or classes named `__default`
5. THE Test_Vector_Runner SHALL organize classes into sub-packages of the root package: `model` for data types and POJOs, `config` for configuration parsing, `client` for DDB client creation, `manifest` for manifest processing, and `runner` for test execution
6. IF a class does not belong to any of the defined sub-packages (`model`, `config`, `client`, `manifest`, `runner`), THEN THE Test_Vector_Runner SHALL place it directly in the root package `software.amazon.cryptography.dbencryptionsdk.dynamodb.testvectors`
7. THE Test_Vector_Runner SHALL use UPPER_SNAKE_CASE for static final constant names

### Requirement 3: DynamoDB Client Creation

**User Story:** As a test runner, I want to create DynamoDB clients with and without encryption interceptors, so that I can test encrypted and plaintext operations against DynamoDB Local.

#### Acceptance Criteria

1. WHEN a `DynamoDbTableEncryptionConfig` and its associated table name are provided, THE DDB_Client_Factory SHALL create a `DynamoDbEncryptionInterceptor` by wrapping the config into a `DynamoDbTablesEncryptionConfig` keyed by that table name, and return a `DynamoDbClient` configured with that interceptor
2. WHEN a vanilla (unencrypted) client is requested, THE DDB_Client_Factory SHALL create a `DynamoDbClient` without any encryption interceptor and without any `ClientOverrideConfiguration`
3. THE DDB_Client_Factory SHALL configure all created clients with the endpoint override `http://localhost:8000` for DynamoDB Local
4. THE DDB_Client_Factory SHALL configure all created clients using the `DefaultAwsRegionProviderChain` to resolve the AWS region
5. IF client creation fails due to an underlying SDK or configuration exception, THEN THE DDB_Client_Factory SHALL throw a `RuntimeException` that wraps the underlying cause
6. THE DDB_Client_Factory SHALL return a native AWS SDK v2 `DynamoDbClient` instance directly, without any Dafny Shim or wrapper layer

### Requirement 4: JSON to DynamoDB AttributeValue Conversion

**User Story:** As a test configuration loader, I want to convert between JSON representations and DynamoDB AttributeValue objects, so that test data can be stored in JSON files and used in DynamoDB operations.

#### Acceptance Criteria

1. WHEN a JSON object with DynamoDB type descriptors is provided (keys: "S", "N", "B", "SS", "NS", "BS", "L", "M", "BOOL", "NULL"), THE JSON_Item_Converter SHALL convert it to the corresponding DynamoDB `AttributeValue`
2. WHEN a DynamoDB `AttributeValue` is provided, THE JSON_Item_Converter SHALL convert it to a JSON object with the appropriate type descriptor key
3. WHEN a JSON string value appears where an AttributeValue is expected, THE JSON_Item_Converter SHALL interpret it as a DynamoDB String type ("S")
4. WHEN a JSON number value appears where an AttributeValue is expected, THE JSON_Item_Converter SHALL interpret it as a DynamoDB Number type ("N")
5. WHEN a "B" or "BS" type is encountered, THE JSON_Item_Converter SHALL decode the string value from Base64 encoding
6. IF an invalid type descriptor or malformed JSON structure is encountered, THEN THE JSON_Item_Converter SHALL throw a descriptive exception identifying the invalid element
7. FOR ALL valid DynamoDB AttributeMap objects, converting to JSON then back to AttributeMap SHALL produce an equivalent object (round-trip property)

### Requirement 5: JSON Configuration File Parsing

**User Story:** As a test runner, I want to parse JSON configuration files into structured Java objects, so that test vectors can be defined declaratively in JSON.

#### Acceptance Criteria

1. WHEN `records.json` is parsed, THE JSON_Config_Parser SHALL produce a list of `Record` objects each containing a record number and an `AttributeMap`
2. WHEN `configs.json` is parsed, THE JSON_Config_Parser SHALL produce a map of configuration names to `TableConfig` objects, each containing a `DynamoDbTableEncryptionConfig` and a vanilla flag
3. WHEN `data.json` is parsed, THE JSON_Config_Parser SHALL produce query definitions (`SimpleQuery`, `ComplexQuery`, `ComplexTest`), expression attribute names, expression attribute values, round-trip tests, write tests, and decrypt tests
4. WHEN `iotest.json` is parsed, THE JSON_Config_Parser SHALL produce a list of `IoTest` objects each containing write/read configs, records, expression maps, and queries
5. WHEN `large_records.json` is parsed, THE JSON_Config_Parser SHALL produce a list of `LargeRecord` objects each containing a name and an `AttributeMap`
6. IF a referenced configuration name does not exist in the parsed configs map, THEN THE JSON_Config_Parser SHALL throw a descriptive exception identifying the missing config
7. IF a JSON file cannot be read or parsed, THEN THE JSON_Config_Parser SHALL print a warning and continue with an empty configuration for that file

### Requirement 6: Test Manifest Processing

**User Story:** As a test runner, I want to write, encrypt, and decrypt test manifests, so that cross-language compatibility can be verified.

#### Acceptance Criteria

1. WHEN `WriteManifest.write` is called with a filename, THE Manifest_Processor SHALL generate a JSON manifest file containing a "manifest" object (with type "aws-dbesdk-encrypt" and version "1"), a "keys" reference, and a "tests" object containing named test cases each with a type ("positive-encrypt", "negative-encrypt", or "negative-decrypt"), description, config, and record
2. WHEN `EncryptManifest.encrypt` is called with an input manifest, output filename, language identifier, and version, THE Manifest_Processor SHALL read and parse the input manifest, validate that it contains "keys", "manifest" (with type "aws-dbesdk-encrypt" and version "1"), and "tests" members, then process each test record according to its type and write a decrypt manifest containing a "manifest" object (with type "aws-dbesdk-decrypt" and version "1"), a "client" object (with name and version), a "keys" reference, and the processed test results
3. WHEN `DecryptManifest.decrypt` is called with a manifest filename, THE Manifest_Processor SHALL read and parse the manifest, validate that it contains "keys", "client", "manifest" (with type "aws-dbesdk-decrypt" and version "1"), and "tests" members, then decrypt each encrypted record and verify the decrypted plaintext matches the expected plaintext after attribute value normalization
4. WHEN a positive-encrypt test is processed during encryption, THE Manifest_Processor SHALL encrypt the record using the specified config and produce an output test entry containing the type "positive-decrypt", the description, the config (or decryptConfig if specified), the original plaintext record, and the encrypted record
5. WHEN a negative-encrypt test is processed, THE Manifest_Processor SHALL attempt encryption and verify that the encryption operation returns a failure result, excluding the test from the decrypt manifest output
6. WHEN a negative-decrypt test is processed during encryption, THE Manifest_Processor SHALL encrypt the record and produce an output test entry with type "negative-decrypt" so that decryption with the specified config is expected to fail
7. THE Manifest_Processor SHALL process decrypt manifests from multiple languages and versions: dotnet (3.2, 3.3, 3.3a), java (3.2, 3.3, 3.3a, 3.9), rust (3.8), and go (3.8)
8. IF the input manifest file cannot be read, parsed as valid JSON, or is missing required top-level members ("keys", "manifest", "tests"), THEN THE Manifest_Processor SHALL return a failure result indicating the specific validation error
9. WHEN a negative-decrypt test is processed during decryption, THE Manifest_Processor SHALL attempt decryption and verify that the decryption operation returns a failure result

### Requirement 7: Item Encryptor Creation from JSON Config

**User Story:** As a manifest processor, I want to create DynamoDbItemEncryptor instances from JSON configuration objects, so that manifests can specify encryption settings declaratively.

#### Acceptance Criteria

1. WHEN a JSON config object with `attributeActionsOnEncrypt`, `logicalTableName`, and `partitionKeyName` is provided, THE Item_Encryptor_Factory SHALL create a `DynamoDbItemEncryptor` with the specified attribute actions mapped to `CryptoAction` values (ENCRYPT_AND_SIGN, SIGN_ONLY, DO_NOTHING, SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT)
2. WHEN the JSON config contains an `algorithmSuiteId`, THE Item_Encryptor_Factory SHALL configure the encryptor with the corresponding `DBEAlgorithmSuiteId` enum value
3. WHEN the JSON config contains `allowedUnsignedAttributes`, THE Item_Encryptor_Factory SHALL configure the encryptor to allow those attributes to be unsigned during decryption
4. WHEN the JSON config contains `allowedUnsignedAttributePrefix`, THE Item_Encryptor_Factory SHALL configure the encryptor to treat any attribute with that prefix as unsigned during decryption
5. THE Item_Encryptor_Factory SHALL resolve key description references in the JSON config to a keyring by calling the KeyVectors_Client, and configure the encryptor with the resolved keyring
6. WHEN the JSON config contains a `sortKeyName`, THE Item_Encryptor_Factory SHALL configure the encryptor with the specified sort key name
7. IF the JSON config is missing required fields (`logicalTableName`, `partitionKeyName`, or `attributeActionsOnEncrypt`), or references an unrecognized attribute action value, THEN THE Item_Encryptor_Factory SHALL throw an exception indicating which field is missing or invalid

### Requirement 8: Basic IO Test Execution

**User Story:** As a test runner, I want to execute basic IO tests covering all DynamoDB write and read operations, so that encryption works correctly for all operation types.

#### Acceptance Criteria

1. WHEN a PutItem test is executed for a config pair, THE Test_Executor SHALL write each record using the write config client and then read all records back using the read config client via GetItem, BatchGetItems, Scan, and TransactGetItems, verifying that each decrypted record matches the original after normalization
2. WHEN a BatchWriteItem test is executed for a config pair, THE Test_Executor SHALL write records in batches of up to 10 items using the write config client and then read all records back using the read config client via GetItem, BatchGetItems, Scan, and TransactGetItems, verifying that each decrypted record matches the original after normalization
3. WHEN a TransactWriteItems test is executed for a config pair, THE Test_Executor SHALL write records in transactions of up to 10 items using the write config client and then read all records back using the read config client via GetItem, BatchGetItems, Scan, and TransactGetItems, verifying that each decrypted record matches the original after normalization
4. WHEN an UpdateItem test is executed for a config pair, IF the attribute being updated has action ENCRYPT_AND_SIGN or SIGN_ONLY, THEN THE Test_Executor SHALL verify that the update operation fails with an error indicating update expressions are forbidden on signed attributes; IF the attribute has action DO_NOTHING, THEN THE Test_Executor SHALL verify that the update operation succeeds
5. WHEN a DeleteItem test with a condition expression is executed for a config pair, IF the condition references an ENCRYPT_AND_SIGN attribute, THEN THE Test_Executor SHALL verify that the delete operation fails with an error indicating condition expressions are forbidden on encrypted attributes; IF the condition references a non-encrypted attribute that matches, THEN THE Test_Executor SHALL verify the delete succeeds and returns the deleted item
6. WHEN a DeleteItem test without a condition expression is executed for a config pair, THE Test_Executor SHALL verify that the delete operation succeeds and returns the deleted item attributes
7. WHEN an ExecuteStatement test is executed against an encrypted table, THE Test_Executor SHALL verify that both INSERT and SELECT PartiQL statements fail with an error indicating ExecuteStatement is not supported on encrypted tables
8. WHEN an ExecuteTransaction test is executed against an encrypted table, THE Test_Executor SHALL verify that PartiQL transaction statements fail with an error indicating ExecuteTransaction is not supported on encrypted tables
9. WHEN a BatchExecuteStatement test is executed against an encrypted table, THE Test_Executor SHALL verify that PartiQL batch statements fail with an error indicating BatchExecuteStatement is not supported on encrypted tables
10. THE Test_Executor SHALL execute all basic IO test operations for each config pair defined in the `configsForIoTest` list, using the first config as the write config and the second config as the read config

### Requirement 9: Query and Scan Test Execution

**User Story:** As a test runner, I want to execute query and scan tests with various filter and key expressions, so that encrypted data can be correctly queried.

#### Acceptance Criteria

1. WHEN a SimpleQuery has a `keyExpr`, THE Test_Executor SHALL execute a DynamoDB Query operation with that key condition expression, the `filterExpr` (if present), and the `index` (if present)
2. WHEN a SimpleQuery has no `keyExpr`, THE Test_Executor SHALL execute a DynamoDB Scan operation with the `filterExpr` (if present) and the `index` (if present)
3. WHEN a Query or Scan response contains a non-empty `LastEvaluatedKey`, THE Test_Executor SHALL issue subsequent requests with that key as `ExclusiveStartKey`, accumulating results, for a maximum of 100 pagination iterations
4. WHEN a query is executed for a config whose name appears in that query's `failConfigs` list, THE Test_Executor SHALL skip that query for that config and not compare results
5. WHEN a query appears in the `failingQueries` list, THE Test_Executor SHALL execute it as a Query operation and verify that the DynamoDB client returns a failure response
6. THE Test_Executor SHALL trim the global expression attribute names and values maps by parsing the key and filter expressions into tokens and retaining only entries whose keys appear as attribute-name or value placeholders in those tokens
7. WHEN a query is executed for a config whose name does not appear in that query's `failConfigs` list, THE Test_Executor SHALL verify that the query results match the expected baseline results obtained from a vanilla client

### Requirement 10: Round-Trip Test Execution

**User Story:** As a test runner, I want to execute round-trip tests that encrypt then decrypt records, so that data integrity through the encryption pipeline is verified.

#### Acceptance Criteria

1. WHEN a round-trip test is executed, THE Test_Executor SHALL write each record using PutItem and then read it back using GetItem with the record's partition key attribute as the retrieval key
2. WHEN the GetItem response is returned, THE Test_Executor SHALL verify that the normalized retrieved item is structurally equal to the normalized original record item
3. THE Test_Executor SHALL normalize attributes before comparison by: applying DynamoDB canonical number normalization to N attributes, normalizing each number string in NS attributes before sorting, sorting SS and NS attributes in lexicographic order, sorting BS attributes in byte-wise order, and recursively normalizing nested Map values and List elements
4. WHEN a round-trip test is executed, THE Test_Executor SHALL create an encrypted DynamoDB client for each config in the test's config map and execute the write-then-read cycle for every record against each client
5. IF a PutItem or GetItem operation fails during a round-trip test, THEN THE Test_Executor SHALL fail the test with an error indicating which record and config caused the failure

### Requirement 11: Complex Query Test Execution

**User Story:** As a test runner, I want to execute complex query tests with beacon-based search, so that searchable encryption features are verified.

#### Acceptance Criteria

1. WHEN a ComplexTest is executed, THE Test_Executor SHALL write all global records using the test's specified config
2. WHEN a query result is returned, THE Test_Executor SHALL verify that all expected record numbers (pass list) are present in the results
3. WHEN a query result is returned, THE Test_Executor SHALL verify that all excluded record numbers (fail list) are absent from the results
4. WHEN a failure query is specified, THE Test_Executor SHALL verify that the query produces an error

### Requirement 12: Decrypt Test Execution

**User Story:** As a test runner, I want to execute decrypt tests that read pre-encrypted records, so that backward compatibility with previously encrypted data is verified.

#### Acceptance Criteria

1. WHEN a decrypt test is executed, THE Test_Executor SHALL write the encrypted records using a vanilla (unencrypted) client
2. THE Test_Executor SHALL then read the records using an encrypted client configured with the test's config
3. THE Test_Executor SHALL verify that the decrypted records match the expected plaintext records regardless of ordering

### Requirement 13: Write Test Execution

**User Story:** As a test runner, I want to execute write tests that encrypt records and save the ciphertext, so that encrypted output can be used for cross-language decrypt testing.

#### Acceptance Criteria

1. WHEN a write test is executed, THE Test_Executor SHALL write all records using the test's encryption config
2. THE Test_Executor SHALL then read the encrypted records back using a vanilla client
3. THE Test_Executor SHALL serialize the encrypted records to JSON and write them to the specified output file

### Requirement 14: Large Record and Performance Tests

**User Story:** As a test runner, I want to execute performance tests with large records, so that encryption performance characteristics are measured.

#### Acceptance Criteria

1. THE Test_Executor SHALL execute large record tests for configurations: do_nothing, do_nothing_nosign, full_encrypt, full_encrypt_nosign, full_sign, full_sign_nosign
2. THE Test_Executor SHALL perform 1000 iterations of encrypt and decrypt for each large record and configuration combination
3. THE Test_Executor SHALL measure and report elapsed time for encrypt and decrypt operations

### Requirement 15: String Ordering Tests

**User Story:** As a test runner, I want to verify that string comparison operators work correctly with encrypted data, so that filter expressions produce correct results.

#### Acceptance Criteria

1. THE Test_Executor SHALL test all comparison operators (<, <=, >, >=, =, <>) against string values
2. THE Test_Executor SHALL verify that scan results with filter expressions match the expected results from in-memory filtering
3. THE Test_Executor SHALL use the string values defined in the test vector configuration

### Requirement 16: Configuration Modification Tests

**User Story:** As a test runner, I want to verify that data encrypted with one config can be read with a compatible modified config, so that config evolution is supported.

#### Acceptance Criteria

1. WHEN a config modification test pair is specified, THE Test_Executor SHALL write records with the first config and query them with the second config
2. THE Test_Executor SHALL verify that query results are identical between the two configs for queries that are not in either config's fail list

### Requirement 17: Write Set Permutations

**User Story:** As a test data generator, I want to generate set permutation test data, so that set ordering invariants are tested.

#### Acceptance Criteria

1. THE Test_Vector_Runner SHALL execute `WriteSetPermutations` before loading test configuration files
2. THE Test_Vector_Runner SHALL generate the `PermTest.json` file containing set permutation test data

### Requirement 18: Entry Point and Test Orchestration

**User Story:** As a CI system, I want a single entry point that loads all configuration and runs all tests, so that the full test suite executes in the correct order.

#### Acceptance Criteria

1. THE Test_Vector_Runner SHALL initialize a KeyVectors_Client using the keys manifest at the default path (`../../../submodules/MaterialProviders/TestVectorsAwsCryptographicMaterialProviders/dafny/TestVectorsAwsCryptographicMaterialProviders/test/keys.json`)
2. THE Test_Vector_Runner SHALL load configuration files in order: records.json, configs.json, data.json, iotest.json, PermTest.json, large_records.json
3. THE Test_Vector_Runner SHALL execute all test categories via `RunAllTests` in the defined order: decrypt manifests, write manifest, encrypt manifest, validate, string ordering, large tests, perf query tests, basic IO, run IO tests, basic query, config mod, complex tests, write tests, round-trip tests, decrypt tests
4. THE Test_Vector_Runner SHALL delete the test table after all tests complete
5. THE Test_Vector_Runner SHALL be executable via the Gradle `runTests` task with DynamoDB Local on the classpath

### Requirement 19: Validation of Test Configuration

**User Story:** As a test runner, I want to validate that all configuration references are consistent before running tests, so that test failures are caught early with clear error messages.

#### Acceptance Criteria

1. THE Test_Executor SHALL verify that record numbers are sequential starting from zero
2. THE Test_Executor SHALL verify that all config names referenced in complex tests exist in the table encryption configs map
3. THE Test_Executor SHALL verify that all config names referenced in query fail lists exist in the table encryption configs map
4. THE Test_Executor SHALL verify that all config names referenced in IO test pairs and config mod test pairs exist in the table encryption configs map
5. IF any validation check fails, THEN THE Test_Executor SHALL print a descriptive error message and terminate execution

### Requirement 20: Build System Integration

**User Story:** As a developer, I want the rewritten code to integrate with the existing Gradle build system, so that it can be built and tested using existing CI infrastructure.

#### Acceptance Criteria

1. THE Test_Vector_Runner SHALL compile with Java 8 source compatibility as specified in the Gradle toolchain configuration
2. THE Test_Vector_Runner SHALL depend on `aws-cryptographic-material-providers`, `aws-database-encryption-sdk-dynamodb`, and `TestAwsCryptographicMaterialProviders` libraries at their current versions
3. THE Test_Vector_Runner SHALL depend on AWS SDK v2 for DynamoDB and KMS
4. THE Test_Vector_Runner SHALL not depend on `org.dafny:DafnyRuntime` or `software.amazon.smithy.dafny:conversion` libraries
5. THE Test_Vector_Runner SHALL work with DynamoDB Local using the native SQLite libraries copied to `build/libs`
