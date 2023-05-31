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

* **Declared a Dependency on the DB-ESDK for DynamoDB in Java and it's dependencies**  
  The DB-ESDK for DynamoDB in Java requires the DynamoDB,
  Dynamodb-Enhanced, and KMS clients from the AWS SDK for Java V2.
  It also requires the AwsCryptographicMaterialProviders library.

  * **Via Gradle Kotlin**  
   In a Gradle Java Project, add the following to the _dependencies_ section:
   ```kotlin
   implementation("software.amazon.cryptography:aws-database-encryption-sdk-dynamodb:3.0.0")
   implementation("software.amazon.cryptography:AwsCryptographicMaterialProviders:1.0.0")
   implementation(platform("software.amazon.awssdk:bom:2.19.1"))
   implementation("software.amazon.awssdk:dynamodb")
   implementation("software.amazon.awssdk:dynamodb-enhanced")
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
      <groupId>software.amazon.awssdk</groupId>
      <artifactId>dynamodb</artifactId>
    </dependency>
    <dependency>
      <groupId>software.amazon.awssdk</groupId>
      <artifactId>kms</artifactId>
    </dependency>
    <dependency>
      <groupId>software.amazon.cryptography</groupId>
      <artifactId>aws-database-encryption-sdk-dynamodb</artifactId>
      <version>3.0.0</version>
    </dependency>
    <dependency>
      <groupId>software.amazon.cryptography</groupId>
      <artifactId>AwsCryptographicMaterialProviders</artifactId>
      <version>1.0.0</version>
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

## Configuring the DB-ESDK for DynamoDB in Java
There are several ways to use the
AWS Database Encryption SDK (DB-ESDK) for DynamoDB in Java.  
More details are provided in the
[AWS Database Encryption SDK Developer Guide](https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/).  
Also see the [Examples](Examples/runtimes/java/DynamoDbEncryption).

### Using Annotations

Suppose you have created a DynamoDB table via the request in 
[Examples/CreateSimpleTable](Examples/runtimes/java/DynamoDbEncryption/src/main/java/software/amazon/cryptography/examples/enhanced/CreateSimpleTable.java), 
and want to store some objects.  
The security requirements for these objects involves classifying particular
attributes as sensitive information.  
You can use annotations from the Enhanced DynamoDB Client and the DB-ESDK to define
the objects types and which fields are encrypted:

```java
@DynamoDbBean
public class SimpleClass {

  private String partitionKey;
  private int sortKey;
  // The next three fields represent DynamoDB item attributes that we will perform cryptographic operations on.
  
  // attribute1: Encrypt the data and sign it for authenticity
  private String attribute1;
  // attribute2: Do not encrypt but sign for authenticity 
  private String attribute2;
  // attribute3: Do not encrypt and do not sign
  private String attribute3;

  @DynamoDbPartitionKey
  @DynamoDbAttribute(value = "partition_key")
  public String getPartitionKey() { return this.partitionKey; }
  public void setPartitionKey(String partitionKey) { this.partitionKey = partitionKey; }

  @DynamoDbSortKey
  @DynamoDbAttribute(value = "sort_key")
  public int getSortKey() { return this.sortKey; }
  public void setSortKey(int sortKey) { this.sortKey = sortKey; }

  @DynamoDbAttribute(value = "attribute1")
  public String getAttribute1() { return this.attribute1; }
  public void setAttribute1(String attribute1) { this.attribute1 = attribute1; }

  @DynamoDbEncryptionSignOnly
  @DynamoDbAttribute(value = "attribute2")
  public String getAttribute2() { return this.attribute2; }
  public void setAttribute2(String attribute2) { this.attribute2 = attribute2; }

  @DynamoDbEncryptionDoNothing
  @DynamoDbAttribute(value = "attribute3")
  public String getAttribute3() { return this.attribute3; }
  public void setAttribute3(String attribute3) { this.attribute3 = attribute3; }
}
```

As a typical use case of the [DynamoDBEnhancedClient][ddbenhanced],
you can easily save and retrieve a SimpleClass object
to and from Amazon DynamoDB _without encryption (nor signing)_.
For example,

```java
  // Create the DynamoDBEnhancedClient and our table
  DynamoDbClient ddb = DynamoDbClient.builder()...build();
  DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
    .dynamoDbClient(ddb)
    .build();
  final TableSchema<SimpleClass> tableSchema = TableSchema.fromBean(SimpleClass.class);
  final DynamoDbTable<SimpleClass> table = enhancedClient.table(ddbTableName, tableSchema);

  // Save the unencrypted item to DynamoDB
  SimpleClass itemToPut = new SimpleClass();
  itemToPut.setPartitionKey("anyKey");
  itemToPut.setSortKey(0);
  itemToPut.setAttribute1("this is not encrypted");
  table.putItem(itemToPut);

  // Load the item back from DynamoDB
  SimpleClass itemToGet = new SimpleClass();
  itemToGet.setPartitionKey("anyKey");
  itemToGet.setSortKey(0);
  SimpleClass returnedItem = table.getItem(itemToGet);
```

See 
[EnhancedPlaintextPutGetExample](Examples/runtimes/java/DynamoDbEncryption/src/main/java/software/amazon/cryptography/examples/enhanced/EnhancedPlaintextPutGetExample.java).

To enable transparent encryption and signing, 
create a keyring and a DynamoDbEncryptionInterceptor,
then add it to the client.  
For example:

```java
    // Use an example KMS key for encrypting your data
    String encryptingKmsKeyArn = ...;

    // Create encryption materials provider using your example KMS key
    MaterialProviders matProv = MaterialProviders.builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    CreateAwsKmsMrkMultiKeyringInput keyringInput = CreateAwsKmsMrkMultiKeyringInput.builder()
      .generator(encryptingKmsKeyArn)
      .build();
    IKeyring kmsKeyring = matProv.CreateAwsKmsMrkMultiKeyring(keyringInput);
    

    // Create your encrypted table config
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
      tableConfigs.put(ddbTableName,
        DynamoDbEnhancedTableEncryptionConfig.builder()
          .logicalTableName(ddbTableName)
          .keyring(kmsKeyring)
          .schemaOnEncrypt(tableSchema)
          .allowedUnsignedAttributes(Arrays.asList("do_nothing"))
          .build());

    // Create an interceptor to pass into the DDB client
    DynamoDbEncryptionInterceptor interceptor =
      DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
        CreateDynamoDbEncryptionInterceptorInput.builder()
        .tableEncryptionConfigs(tableConfigs)
        .build());

    // Create the DDB client with our encryption interceptor
    DynamoDbClient ddb = DynamoDbClient.builder()
      .region(Region.US_WEST_2)
      .overrideConfiguration(
        ClientOverrideConfiguration.builder()
        .addExecutionInterceptor(interceptor)
        .build())
      .build();
    DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
      .dynamoDbClient(ddb)
      .build();
    final DynamoDbTable<SimpleClass> table = enhancedClient.table(ddbTableName, tableSchema);

    // Save the encrypted item to DynamoDB
    SimpleClass itemToPut = new SimpleClass();
    itemToPut.setPartitionKey("anyKey");
    itemToPut.setSortKey(0);
    itemToPut.setAttribute1("this is encrypted client-side");
    table.putItem(itemToPut);

    // Load the item back from DynamoDB and decrypt client-side
    SimpleClass itemToGet = new SimpleClass();
    itemToGet.setPartitionKey("anyKey");
    itemToGet.setSortKey(0);
    SimpleClass returnedItem = table.getItem(itemToGet);
```

See
[EnhancedPutGetExample](Examples/runtimes/java/DynamoDbEncryption/src/main/java/software/amazon/cryptography/examples/enhanced/EnhancedPutGetExample.java)
for more context and description.

# Development

[//]: # (TODO: Post-GA? Development Instructions)
This repo contains several projects:
- `DynamoDbEncryption`: Contains the implementation of the Database Encryption 
  SDK for DynamoDB in Java.
- A specification of this project exists at `specification`.
- `Examples`: Contains example projects that demonstrate use of 
  the features of the Database Encryption SDK for DynamoDB
- `TestVectors`: Contains project that encrypts and decrypts
  a suite of DynamoDB items to validate the Database Encryption 
  SDK's cross-version compatibility

# Contributing

See [CONTRIBUTING](CONTRIBUTING.md) for more information.

# License

This project is licensed under the Apache-2.0 License.

[ddbenhanced]: https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/dynamodb-enhanced-client.html
