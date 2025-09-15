# AWS Database Encryption SDK for DynamoDB in Go

This is the official AWS Database Encryption SDK (DB-ESDK) for DynamoDB in Go.

## [CHANGELOG](https://github.com/aws/aws-database-encryption-sdk-dynamodb/tree/main/releases/go/dynamodb-esdk/CHANGELOG.md)

## Overview

The AWS Database Encryption SDK (DB-ESDK) for DynamoDB is a client-side encryption
library that allows you to perform attribute-level encryption, enabling you to encrypt specific
attribute values within items before storing them in your DynamoDB table. All encryption and
decryption are performed within your application. This lets you protect sensitive data in-transit
and at-rest, as data cannot be exposed unless decrypted by your application.

For more details about the design and architecture of the DB-ESDK for DynamoDB,
see the [AWS Database Encryption SDK Developer Guide](https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/).

## Installation

`go get github.com/aws/aws-encryption-sdk/releases/go/dynamodb-esdk@latest`

## Examples for AWS Database Encryption SDK for DynamoDB in Go

Please look at the Examples on how to use the Encryption SDK in Go [here]https://github.com/aws/aws-database-encryption-sdk-dynamodb/tree/main/Examples/runtimes/go).

Please note that some examples MAY require internet access and valid AWS credentials.

## License

This library is licensed under the Apache 2.0 License.