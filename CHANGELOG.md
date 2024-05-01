# Changelog

## [3.4.0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/compare/v3.3.0...v3.4.0) (2024-04-30)

### Notes
#### .NET
- [#797](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/797) ([785481c](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/785481c73b385918c5b60301b336ac90f451d307)) Enforces User input Constraints at Type Conversion.

Prior to this fix, unset Integers defaulted to `0`, and unset Booleans defaulted to `false`.

This particularly effects Searchable Encryption's 
`ConstructorPart`, who's required field previously
would have defaulted to false.
Any configuration ever created for Searchable Encryption can be re-created with the fix, but they may look different.

### Features

* Adopt SmithyDafnyMakefile.mk, progress towards fixing nightly build ([#797](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/797)) ([785481c](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/785481c73b385918c5b60301b336ac90f451d307)), closes [/github.com/aws/aws-database-encryption-sdk-dynamodb/pull/797/files#diff-692e2b06d124c9775e2fcd9cd9dbd10e0c8ea470e08174ed0b258b0301622581R182](https://github.com/aws//github.com/aws/aws-database-encryption-sdk-dynamodb/pull/797/files/issues/diff-692e2b06d124c9775e2fcd9cd9dbd10e0c8ea470e08174ed0b258b0301622581R182)


### Maintenance

* enforce Dafny formatting ([#865](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/865)) ([dfc0dbd](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/dfc0dbd84f3ab23bd12be6abf8600f472576173e))
* more test vectors ([#959](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/959)) ([3ca15af](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/3ca15afac59bee530dfffe832af64f5922c73e9a))
* add verify test for test vectors ([#897](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/897)) ([6c980e7](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/6c980e7f867952442fc686dfa7ef4c82f04362f3))
* **CI/CD:** add semantic release automation ([#949](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/949)) ([3f22abc](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/3f22abcc4c325a7a8df22e5e72cd859905fbd1e9))
* **deps:** bump actions/setup-dotnet from 3 to 4 in /.github/workflows ([#943](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/943)) ([f5d9748](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/f5d974833bf22fe2fcef0ce97da12a92ae9a7ec9))
* **deps:** bump aws-actions/configure-aws-credentials ([#954](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/954)) ([90d7d78](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/90d7d786e17b31ed337334a1e311babc3b63b3de))
* **deps:** bump io.github.gradle-nexus.publish-plugin ([#903](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/903)) ([04c6cc4](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/04c6cc4c3db59f38ab49046abbf6c161cac5ade9))
* **deps:** bump org.projectlombok:lombok ([#838](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/838)) ([56f1cd1](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/56f1cd14d84dd660a62eff7b3e346a621b731de4))
* **deps:** bump rrainn/dynamodb-action in /.github/workflows ([#932](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/932)) ([16e4d7b](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/16e4d7b8c95d0e778c2b552d63be04c1b2b066cb))
* **docs:** mention sign_and_include in javadoc for keyid supplier ([#966](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/966)) ([2796693](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/27966933f280f48ef4d4c96d0e1db065473ae34f))
* point to the correct readme ([#845](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/845)) ([b950b4a](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/b950b4a8d1b47d7016b90525849bee77426ffa60))
* repair json file names ([#846](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/846)) ([3ca955a](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/3ca955a088db58d336dd779927e7d622e0a4610d))
* test "dotnet pack" in CI ([#851](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/851)) ([75e44d0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/75e44d00bf73c1dfdd25f942eed57eddfeba8d65))
* **test:** add tests for attribute names that seem structured ([#964](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/964)) ([c4c0886](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/c4c088661adef70e4e87246a8592f5f49211e0bc))
* Update MPL to 1.3.0 ([#972](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/972)) ([3d8acae](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/3d8acae26c4d6af333b6e654f99baa2de47be9c7))

## 3.2.0 2024-03-20

### Features

- A fourth Crypto Action will be made available : `SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT`, to join the existing `DO_NOTHING`, `SIGN_ONLY` and `ENCRYPT_AND_SIGN`. `SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT` behaves like `SIGN_ONLY`, but also includes the value in the encryption context, making it available to the branch key selector.
- The Parsed Header, returned from EncryptItem and DecryptItem, now returns two more fields
  - encryptionContext : the full encryption context used for encryption
  - selectorContext : the encryption context as presented to the branch key selector
- The Java Enhanced Client now supports Single Table Design. When using the DynamoDbEnhancedTableEncryptionConfig builder, one can now specify `schemaOnEncrypt` multiple times, once for each class being modeled in the table.
- There was a hard limit of 100 on the size of maps and lists in Items to be encrypted. This limit has been removed.

## 3.2.0 2024-01-16

### Features
- support for .NET
- Beacon Styles :
  - PartOnly : save a little bit of space for a beacon that used as part of a Compound Beacon, but never alone
  - AsSet : turn a set of values into a set of beacons, rather than into a single beacon
  - Twinned : calculate beacons for one attribute to be compatible with those from a different attribute
  - TwinnedSet : both AsSet and Twinned
- Global Parts List : all compound beacons can now share a single list of Parts
- Test vectors to ensure cross language compatibility
- explicit error message when searching on a Compound Beacon that could never exist.
- New APIs : ResolveAttributes and GetVirtualFields to assist in development and debugging.

### Fix
 - String compare for client side filtering of Scan and Query results could sometimes produce the wrong result for certain characters.


## 3.1.2 2023-11-13

### Fix

Fixed an issue where, when using the DynamoDbEncryptionInterceptor,
an encrypted item in the Attributes field of a DeleteItem, PutItem, or UpdateItem
response was passed through unmodified instead of being decrypted.

## 3.1.1 2023-11-07

### Fix

Issue when a DynamoDB Set attribute is marked as SIGN_ONLY in the AWS Database Encryption SDK (DB-ESDK) for DynamoDB.

DB-ESDK for DynamoDB supports SIGN_ONLY and ENCRYPT_AND_SIGN attribute actions. In version 3.1.0 and below, when a Set type is assigned a SIGN_ONLY attribute action, there is a chance that signature validation of the record containing a Set will fail on read, even if the Set attributes contain the same values. The probability of a failure depends on the order of the elements in the Set combined with how DynamoDB returns this data, which is undefined.

This update addresses the issue by ensuring that any Set values are canonicalized in the same order while written to DynamoDB as when read back from DynamoDB.

See: https://github.com/aws/aws-database-encryption-sdk-dynamodb-java/tree/v3.1.1/DecryptWithPermute for additional details for additional details


## 3.1.0 2023-09-07

### Features
- Support underscores in DynamoDB expression attribute names

### Maintenance
- Upgrade various library dependencies
- A variety of fixes to the library's CI and testing

## 3.0.0 2023-07-24

### Features
- Updates to the AWS Cryptographic Material Providers Library for Java,
  a pivotal dependency of the this library,
  introduce Thread Safe Cryptographic Materials Caches (CMCs):
  - Storm Tracking Cache  
    Safe for use in a multi threaded environment,  
    tries to prevent redundant or overly parallel backend calls.  
    See [Spec changes](https://github.com/awslabs/aws-encryption-sdk-specification/blob/ce9a4062124edc5085c66a4f10742e15aa039b34/changes/2023-06-19_thread_safe_cache/change.md) for details.  
  - Multi Threaded Cache  
    Safe for use in a multi threaded environment,  
    but no extra functionality
- Examples for using the Enhanced Client via Lombok Annotation and TableSchemaBuilder
- Detection of ignored DynamoDB Encryption Configuration Tags due to Nested Data Models
- Multi Threading Example

### BREAKING CHANGES
- Updates to the AWS Cryptographic Material Providers Library for Java,
  a pivotal dependency of the this library,
  introduce the following breaking changes:
  - CMCs:  
    - Original Cryptographic Materials Cache has been renamed to Single Threaded Cache  
    - `CreateCryptographicMaterialsCacheInput` now ONLY accepts `CacheType`,  
    which determines which, if any, of the three implemented CMCs will be returned.  
    - The `DefaultCache` is `StormTrackingCache`  
  - `CreateAwsKmsHierarchicalKeyringInput`:  
    - no longer has a `maxCacheSize` field   
    - now has an optional `cache` field for a `CacheType`  
  - Hierarchical Keyring's Key Store:  
    - The Hierarchical Keyring's Key Store's Data Structure has changed.  
      As such, entries persisted in the Key Store with prior versions of this library are NOT compatible.  
      Instead, we recommend Creating a new DynamoDB Table for this version of the Key Store.  
    - The Key Store's `CreateKeyInput` now takes:  
      - An Optional `String branchKeyIdentifier`  
      - An Optional `EncryptionContext encryptionContext`  
        - This `encryptionContext` will be added to the Encryption Context sent to KMS prefixed with `aws-crypto-ec:`  
    - Creating a Key now also calls KMS:ReEncrypt  
    - `CreateKeyStore` no longer creates a GSI  
    - The Encryption Context used with KMS' `GenerateDataKeyWithoutPlaintext` no longer includes the discarded GSI's `status`.  
    - More details about the Key Store's changes are available in our Specification:  
      - [2023-07-12 Update Key Store](https://github.com/awslabs/aws-encryption-sdk-specification/tree/master/changes/2023_7_12_update-keystore-structure)
      - [KeyStore Specification](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/branch-key-store.md)
        
### Fix
- With the Enhanced Client, Identify Only Index attributes for Sign Only,
  NOT all Key Attributes, such as Auto Generated Last Modified Time Stamp.

### Maintenance
- A variety of fixes to the libraries CI and testing

## 3.0.0-preview-2 2023-06-09

### Fix
- The AWS SDK Core MUST NOT be depended on directly.

## 3.0.0-preview-1 2023-06-09

### Features
- Initial release of the AWS Database Encryption SDK.
  This release is considered a [developer preview](https://docs.aws.amazon.com/sdkref/latest/guide/maint-policy.html#version-life-cycle)
  and is not intended for production use cases.
