# AWS Database Encryption SDK for DynamoDB in Java

The AWS Database Encryption SDK for DynamoDB in Java
provides client-side encryption and signing of Amazon DynamoDB items
to help you protect your table's data before you send it to DynamoDB.

For more details about the design and architecture of the
AWS Database Encryption SDK (DB-ESDK) for DynamoDB, 
see the [AWS Database Encryption SDK Developer Guide](https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/).

# Security
If you discover a potential security issue in this project
we ask that you notify AWS/Amazon Security via our
[vulnerability reporting page](http://aws.amazon.com/security/vulnerability-reporting/).
Please do **not** create a public GitHub issue.

# Support Policy
See [Support Policy](./SUPPORT_POLICY.rst) for details 
on the current support status of all major versions of this library.

## Giving Feedback
We need your help in making this SDK great.
Please participate in the community and contribute to this effort by
submitting issues,
participating in discussion forums and
submitting pull requests through the following channels:

* Submit [issues](https://github.com/aws/aws-database-encryption-sdk-dynamodb-java/issues)
  \- this is the **preferred** channel to interact with our team
* Articulate your
  [feature request](https://github.com/aws/aws-database-encryption-sdk-dynamodb-java/issues?q=is%3Aopen+is%3Aissue+label%3A%22feature-request%22)
  or upvote existing ones

# Getting Started

## Required Prerequisites
To use the DB-ESDK for DynamoDB in Java, you must have:

* **A Java 8 or newer development environment**

  If you do not have one, 
  go to [Java SE Downloads](https://www.oracle.com/technetwork/java/javase/downloads/index.html) on the Oracle website, 
  then download and install the Java SE Development Kit (JDK). 
  Java 8 or higher is required.

  **Note:** If you use the Oracle JDK, 
  you must also download and install 
  the [Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files](http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html).

* **Declare a Dependency on the DB-ESDK for DynamoDB in Java and it's dependencies**  
  The DB-ESDK for DynamoDB in Java requires the Dynamodb-Enhanced client
  from the AWS SDK for Java V2.
  It also requires the AWS Cryptographic Material Providers library.

  The KMS and DynamoDB Clients are **optional** dependencies.

  * **Via Gradle Kotlin**  
   In a Gradle Java Project, add the following to the _dependencies_ section:
   ```kotlin
   implementation("software.amazon.cryptography:aws-database-encryption-sdk-dynamodb:3.0.0")
   implementation("software.amazon.cryptography:aws-cryptographic-material-providers:1.0.0")
   implementation(platform("software.amazon.awssdk:bom:2.19.1"))
   implementation("software.amazon.awssdk:dynamodb-enhanced")
   // The following are optional:
   implementation("software.amazon.awssdk:dynamodb")
   implementation("software.amazon.awssdk:kms")
   ```

  * **Via Apache Maven**  
  Add the following to your project's `pom.xml`.
  ```xml
  <project>
  ...
  <dependencyManagement>
   <dependencies>
      <dependency>
        <groupId>software.amazon.awssdk</groupId>
        <artifactId>bom</artifactId>
        <version>2.19.1</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
   </dependencies>
  </dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>software.amazon.awssdk</groupId>
      <artifactId>dynamodb-enhanced</artifactId>
    </dependency>
    <dependency>
      <groupId>software.amazon.cryptography</groupId>
      <artifactId>aws-database-encryption-sdk-dynamodb</artifactId>
      <version>3.0.0</version>
    </dependency>
    <dependency>
      <groupId>software.amazon.cryptography</groupId>
      <artifactId>aws-cryptographic-material-providers</artifactId>
      <version>1.0.0</version>
    </dependency>
    <!-- The following are optional -->
    <dependency>
      <groupId>software.amazon.awssdk</groupId>
      <artifactId>dynamodb</artifactId>
    </dependency>
    <dependency>
      <groupId>software.amazon.awssdk</groupId>
      <artifactId>kms</artifactId>
    </dependency>
  </dependencies>
  ...
  </project>
  ```

### AWS Integration
You need an Amazon Web Services (AWS) account to use
the AWS Database Encryption SDK for DynamoDB
(a KMS Key is optional).

* **To create an AWS account**, go to 
  [Sign In or Create an AWS Account](https://portal.aws.amazon.com/gp/aws/developer/registration/index.html)
  and then choose **I am a new user.**  
  Follow the instructions to create an AWS account.

* **To create a key in AWS KMS**, see
  [Creating Keys](https://docs.aws.amazon.com/kms/latest/developerguide/create-keys.html).

### Amazon Corretto Crypto Provider
Many users find that the Amazon Corretto Crypto Provider (ACCP)
significantly improves the performance of
the AWS Database Encryption SDK for DynamoDB in Java.
For help installing and using ACCP, see the 
[amazon-corretto-crypto-provider repository](https://github.com/corretto/amazon-corretto-crypto-provider).

## Using the DB-ESDK for DynamoDB in Java
There are several ways to use the
AWS Database Encryption SDK (DB-ESDK) for DynamoDB in Java.  
Please read the
[AWS Database Encryption SDK Developer Guide](https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/)
for guidance.  
Also see the
[DynamoDbEncryption Examples](Examples/runtimes/java/DynamoDbEncryption)
and the 
[Migration Examples](Examples/runtimes/java/Migration).

# Contributing

See [CONTRIBUTING](CONTRIBUTING.md) for more information.

# License

This project is licensed under the Apache-2.0 License.

[ddbenhanced]: https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/dynamodb-enhanced-client.html
