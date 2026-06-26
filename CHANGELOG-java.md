# Changelog

## [4.1.0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/compare/v4.0.0-java...v4.1.0-java) (2026-06-26)

### Features -- All Languages

- **dafny:** Add bucket beacon support ([#1943](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1943)) ([5c53d59](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/5c53d5983a90f93cf5d85d1399704eda0d16d63a))

### Fixes -- All Languages

- validate attribute name length by UTF-8 byte count ([#2329](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2329)) ([1520838](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/1520838e319868cdce363f30beca8a221cddc128))

### Maintenance -- All Languages

- **dafny:** add length check validation for beacon key condition expressions ([#2348](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2348)) ([0b21d4b](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/0b21d4b0115a09ce5159129b4f0b84faa1354764))
- update README to reflect new changes DBESDK 4.x ([#2333](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2333)) ([cc6c4b9](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/cc6c4b9902f5b3d459ca494f476fd76dbbc2d7b0))

### Miscellaneous

- add retries to examples ([#2262](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2262)) ([ab622af](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/ab622afed8425c8c54544d09031a2dd2f8411653))
- add special-characters-workaround to avoid sigv4 failure ([#2270](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2270)) ([7223d98](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/7223d98795755337fb31c5d0592b15f006358bf4))
- **ci:** add concurrency control ([#2265](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2265)) ([85d6be8](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/85d6be85756eac0b7c07aff114fe4662e229a685))
- **ci:** add more error code in infra related failure ([#2254](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2254)) ([7d3b0b5](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/7d3b0b5562d82bd55889c7ef7ef80977efb14dc9))
- **ci:** Add retries to DDB local setup steps ([#2267](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2267)) ([7987566](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/7987566c847735f4d547f181aab3e47cf40a9a32))
- **ci:** add separate changelog links ([#2306](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2306)) ([be7843b](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/be7843b437c9ac1a90af1605d2857af40a6f6267))
- **ci:** Update daily_ci to get triggered at 7AM ([#2283](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2283)) ([3ed89b5](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/3ed89b54702756f298dc970b3aa62b2e44ad95ae))
- group dependabot updates for each runtimes ([#2337](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2337)) ([6683d0a](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/6683d0a71d3e1e8b980bf573b13bcca529331911))
- pin time crate to fix CI ([#2324](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2324)) ([105e862](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/105e8621d92e117a4d11fa35ee3d1ca66bf2179e))
- **release:** 4.0.0 ([#2299](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2299)) ([d7f4739](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/d7f4739a5e465ed9c20b79fe6a7eca0f7e8c9f7f)), closes [#2048](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2048) [#2145](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2145)
- **release:** allow local testing ([#2251](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2251)) ([546b68c](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/546b68cb585dfab003395f3feab164c85459a661))
- Update README to mention DDBECwithSDKV2 examples ([#2276](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2276)) ([bdcf6d0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/bdcf6d0a218e1adc7a5a37e4952c11af12257b38))
- use install smithy dafny deps from MPL ([#2266](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2266)) ([4f3b542](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/4f3b54292790b1ca17c66a6a7646e9278146e77c))

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
