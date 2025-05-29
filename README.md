# AWS Database Encryption SDK for DynamoDB

📣 Note: This repository contains the source code and related files for all
language implementations of the AWS Database Encryption SDK for DynamoDB.
See our [supported languages](#supported-languages) section for more information.

The AWS Database Encryption SDK (DB-ESDK) for DynamoDB is a client-side encryption
library that allows you to perform attribute-level encryption, enabling you to encrypt specific
attribute values within items before storing them in your DynamoDB table. All encryption and
decryption are performed within your application. This lets you protect sensitive data in-transit
and at-rest, as data cannot be exposed unless decrypted by your application.

For more details about the design and architecture of the DB-ESDK for DynamoDB,
see the [AWS Database Encryption SDK Developer Guide](https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/).

# Security

If you discover a potential security issue in this project
we ask that you notify AWS/Amazon Security via our
[vulnerability reporting page](http://aws.amazon.com/security/vulnerability-reporting/).
Please **do not** create a public GitHub issue.

# Support Policy

See [Support Policy](./SUPPORT_POLICY.rst) for details
on the current support status of all major versions of this library.

## Giving Feedback

We need your help in making this SDK great.
Please participate in the community and contribute to this effort by
submitting issues,
participating in discussion forums and
submitting pull requests through the following channels:

- Submit [issues](https://github.com/aws/aws-database-encryption-sdk-dynamodb-java/issues)
  \- this is the **preferred** channel to interact with our team
- Articulate your
  [feature request](https://github.com/aws/aws-database-encryption-sdk-dynamodb-java/issues?q=is%3Aopen+is%3Aissue+label%3A%22feature-request%22)
  or upvote existing ones
- Ask [questions](https://repost.aws/tags/TAc3VKZnkNQyimpHnCHetNOQ/aws-crypto-tools) on AWS re:Post under AWS Crypto Tools tag

# Getting Started

### Repository structure

This repository is a top level repository which houses all source code in order to compile this library into
different runtimes.

This library is written in Dafny, a formally verifiable programming language that can be compiled into
different runtimes. This library is currently **ONLY** supported in Java and .NET

### AWS Integration

You need an Amazon Web Services (AWS) account to use the DB-ESDK for DynamoDB as it's specifically designed to work with Amazon DynamoDB. Optionally, you can use AWS Key Management Service (AWS KMS) as your main keyring provider.

- **To create an AWS account**, go to
  [Sign In or Create an AWS Account](https://portal.aws.amazon.com/gp/aws/developer/registration/index.html)
  and then choose **I am a new user.**  
  Follow the instructions to create an AWS account.

- **(Optional) To create a key in AWS KMS**, see
  [Creating Keys](https://docs.aws.amazon.com/kms/latest/developerguide/create-keys.html).

## Supported Languages

- Java
- .NET
- Dafny
- Rust
- Python

# Contributing

See [CONTRIBUTING](CONTRIBUTING.md) for more information.

# License

This project is licensed under the Apache-2.0 License.

[ddbenhanced]: https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/dynamodb-enhanced-client.html
