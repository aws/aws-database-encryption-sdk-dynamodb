# Changelog

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
 - String compare for client side filtering of Scan and Query results could somtimes produce the wrong result for certain characters.


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
