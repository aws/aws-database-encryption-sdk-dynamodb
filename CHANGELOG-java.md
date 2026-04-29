# Changelog

## [4.0.0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/compare/v3.9.0-java...v4.0.0-java) (2026-04-29)

### ⚠ BREAKING CHANGES

- **java:** add DDBEC with SDK v2 and remove DDBEC with SDK V1 (#2048)
  - The AWS Database Encryption SDK for DynamoDB will NOT support AWS SDK for Java 1.x in the embedded 2.x version (which was known as DynamoDB Encryption Client(DDBEC)). The embedded DDBEC will now use AWS SDK for Java 2.x. These changes are limited to embedded DDBEC and rest of DB-ESDK has no code changes.
  - If consumer of DB-ESDK is using APIs from namespace `com.amazonaws.services.dynamodbv2` through DB-ESDK then they have to migrate to use corresponding API from namespace `com.amazonaws.services.dynamodbv2.datamodeling.sdkv2`. If consumer of DB-ESDK are NOT using namespace `com.amazonaws.services.dynamodbv2` through DB-ESDK then there will not be any breaking change when moving to next major version.

### Features -- Java

- **java:** add DDBEC with SDK v2 and remove DDBEC with SDK V1 ([#2048](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2048)) ([035dbe3](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/035dbe3b30135d34c94d597fb758440e6f1b5409))

### Fixes -- All Languages

- use UUIDs and cleanup in beacon styles example to avoid stale item collisions ([#2125](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2125)) ([773c1ff](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/773c1fff6004a2551a8bea28fd50a93515ccaaf6))

### Fixes -- Java

- **java:** drop hkdf offset method ([#2011](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2011)) ([b8f29f9](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/b8f29f914d2c593de83304a186869aec12f020e3))

### Maintenance -- All Languages

- **dafny:** bump MPL and update mutable map ([#1974](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1974)) ([e9ea870](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/e9ea870eb2d7d885f063cb53fd17c83526ba69ca))
- **dafny:** bump smithy dafny ([#1971](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1971)) ([85309a0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/85309a023d4aeeeeae5106fd904a3dd23fd728cb))

### Maintenance -- Java

- **java:** Allow local testing ([#1947](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1947)) ([bf5a106](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/bf5a106ccaa816de9c1e4f0eacaf84c9f915b752))
- **java:** Attempt to reduce flaky CI ([#2220](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2220)) ([987aec6](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/987aec6183b4b8d6e83fd886a6db63d3f43a9e9b))
- **java:** attempt to reduce flaky CI failures ([#2203](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2203)) ([b4d88f1](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/b4d88f1f9e2f3adb86589cdaaa68c2b117fd7d78))
- **java:** bring back test against released MPL version ([#2226](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2226)) ([a340b34](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/a340b346b2f694193f5351e61f501da69f5b827d))
- **java:** fix GetEncryptedDataKeyDescription java Example ([#1973](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1973)) ([ba8fcb7](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/ba8fcb7f9aca01ce20cfcd3bc4f2fc0087b5fc9d))
- **java:** retry failed workflow ([#2229](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2229)) ([2668d68](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/2668d687fbb3bfbdc7243cf5f7f7c0d085e70ebb))
- **java:** shut down local DDB in test ([#2176](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2176)) ([fa1e151](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/fa1e151fed1ca3dcd1fff14fe13af1c95d3fe61d))
