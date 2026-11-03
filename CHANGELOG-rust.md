# Changelog

## 1.3.1 (2026-11-03)

### Fixes

- **rust:** stop enabling the deprecated `rustls` default feature of `aws-sdk-dynamodb` and `aws-sdk-kms`, so default builds no longer pull in the legacy hyper 0.14 stack and `rustls-webpki` 0.101.7. Callers that pin a `BehaviorVersion` older than `v2025_01_17` can opt back in with the new `legacy-https-client` feature ([#2379](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2379)) ([3e4d38c](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/3e4d38cd4c9a180bdfca1042b8785e9729cddbfb))

### Maintenance

- **rust:** bump aws-lc-rs from 1.17.0 to 1.18.0, aws-lc-sys from 0.42 to 0.47, and aws-lc-fips-sys from 0.13.1 to 0.14.1 ([#2355](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2355), [#2366](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2366), [#2370](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2370), [#2388](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2388))
- **rust:** bump pem from 3.0.6 to 4.0.0, and relax the `time` cap from `<0.3.37` to `<0.3.56` ([#2370](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2370)) ([e0e61fd](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/e0e61fd012cd306ba9821d60f23c0504f482ec49))

## 1.3.0 (2026-07-01)

### Features -- All Languages

- **dafny:** Add bucket beacon support ([#1943](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1943)) ([5c53d59](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/5c53d5983a90f93cf5d85d1399704eda0d16d63a))

### Fixes -- All Languages

- validate attribute name length by UTF-8 byte count ([#2329](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2329)) ([1520838](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/1520838e319868cdce363f30beca8a221cddc128))

### Maintenance -- All Languages

- **dafny:** add length check validation for beacon key condition expressions ([#2348](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2348)) ([0b21d4b](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/0b21d4b0115a09ce5159129b4f0b84faa1354764))
