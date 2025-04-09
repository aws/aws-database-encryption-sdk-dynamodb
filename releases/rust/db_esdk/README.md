# AWS Database Encryption SDK for DynamoDB

[![build status](https://github.com/aws/aws-database-encryption-sdk-dynamodb/actions/workflows/daily_ci.yml/badge.svg?branch=main)](https://github.com/aws/aws-database-encryption-sdk-dynamodb/actions/workflows/daily_ci.yml)
[![crates.io](https://img.shields.io/crates/v/aws-db-esdk.svg)](https://crates.io/crates/aws-db-esdk)
[![docs](https://docs.rs/aws-db-esdk/badge.svg)](https://docs.rs/aws-db-esdk)
[![rustc](https://img.shields.io/badge/rust-1.81%2B-orange.svg)](https://img.shields.io/badge/rust-1.81%2B-orange.svg)

This is the official [AWS Database Encryption SDK (DB-ESDK) for DynamoDB in Rust](https://crates.io/crates/aws-db-esdk).

## [CHANGELOG](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/CHANGELOG.md)

## Overview

The AWS Database Encryption SDK (DB-ESDK) for DynamoDB is a client-side encryption
library that allows you to perform attribute-level encryption, enabling you to encrypt specific
attribute values within items before storing them in your DynamoDB table. All encryption and
decryption are performed within your application. This lets you protect sensitive data in-transit
and at-rest, as data cannot be exposed unless decrypted by your application.

For more details about the design and architecture of the DB-ESDK for DynamoDB,
see the [AWS Database Encryption SDK Developer Guide](https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/).

## Examples for AWS Database Encryption SDK in Rust

Please look at the Examples on how to use the AWS Database Encryption SDK in Rust [here](https://github.com/aws/aws-database-encryption-sdk-dynamodb/tree/main/releases/rust/db_esdk/examples).

Please note that some examples MAY require internet access and valid AWS credentials, since calls to KMS are made.

## License

This library is licensed under the Apache 2.0 License.
