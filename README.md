## AWS Database Encryption SDK for DynamoDB in Java

The AWS Database Encryption SDK for DynamoDB in Java
provides client-side encryption and signing of Amazon DynamoDB items
to help you protect your table's data before you send it to DynamoDB.

For more details about the design and architecture of the AWS Database Encryption SDK for DynamoDB, see the [AWS Database Encryption SDK Developer Guide](https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/).

[Security issue notifications](./CONTRIBUTING.md#security-issue-notifications)

See [Support Policy](./SUPPORT_POLICY.rst) for details on the current support status of all major versions of this library.

## Getting Started

### Required Prerequisites
To use the DB ESDK for DynamoDB in Java, you must have:

* **A Java 8 development environment**

  If you do not have one, go to [Java SE Downloads](https://www.oracle.com/technetwork/java/javase/downloads/index.html) on the Oracle website, then download and install the Java SE Development Kit (JDK). Java 8 or higher is required.

  **Note:** If you use the Oracle JDK, you must also download and install the [Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files](http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html).

### Optional Prerequisites

#### AWS Integration
You don't need an Amazon Web Services (AWS) account to use the AWS Encryption SDK, but some [example code][examples] require an AWS account, an AWS KMS key, and the AWS SDK for Java (either 1.x or 2.x). Note that the `KmsAsyncClient` is not supported, only the synchronous client.

* **To create an AWS account**, go to [Sign In or Create an AWS Account](https://portal.aws.amazon.com/gp/aws/developer/registration/index.html) and then choose **I am a new user.** Follow the instructions to create an AWS account.

* **To create a symmetric encryption KMS key in AWS KMS**, see [Creating Keys](https://docs.aws.amazon.com/kms/latest/developerguide/create-keys.html).

* **To download and install the AWS SDK for Java 2.x**, see [Installing the AWS SDK for Java 2.x](https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/getting-started.html).

* **To download and install the AWS SDK for Java 1.x**, see [Installing the AWS SDK for Java 1.x](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/getting-started.html).

### Get Started

### Downloads

You can get the latest release from Maven:

```xml
  <dependency>
    <groupId>software.amazon.cryptography</groupId>
    <artifactId>aws-database-encryption-sdk-dynamodb</artifactId>
    <version>3.0.0</version>
  </dependency>
```

### Development

This repo contains several projects:
- DynamoDbEncryption: Contains the implementation of the DynamoDb Encryption Client in all target languages
- TODO test vectors
- TODO examples

A specification of all these projects exists at `specification`.

## Security

See [CONTRIBUTING](CONTRIBUTING.md#security-issue-notifications) for more information.

## License

This project is licensed under the Apache-2.0 License.
