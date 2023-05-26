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

* **A Java 8 or newer development environment**

  If you do not have one, go to [Java SE Downloads](https://www.oracle.com/technetwork/java/javase/downloads/index.html) on the Oracle website, then download and install the Java SE Development Kit (JDK). Java 8 or higher is required.

  **Note:** If you use the Oracle JDK, you must also download and install the [Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files](http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html).

### Get Started

Suppose you have created ([sample code][createtable]) and a DynamoDB table, and want to store some objects.
The security requirement involves classifying particular attributes as sensitive information. 
This is how the annotated class may look like:

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

As a typical use case of the [DynamoDBEnhancedClient][ddbenhanced], you can easily save and retrieve a SimpleClass object to and from Amazon DynamoDB _without encryption (nor signing)_.  For example,

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

To enable transparent encryption and signing, create a keyring and a DynamoDbEncryptionInterceptor, then add it to the client.  For example:

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

See a related [example][TODOplaintextexample] for more context and description.

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
- `DynamoDbEncryption`: Contains the implementation of the Database Encryption SDK for DynamoDB in Java.
A specification of this project exists at `specification`.
- `Examples`: Contains example projects that demonstrate use of the features of the Database Encryption SDK for DynamoDB
- `TestVectors`: Contains project that encrypts and decrypts a suite of DynamoDB items to validate the Database Encryption SDK's cross-version compatibility

## Security

See [CONTRIBUTING](CONTRIBUTING.md#security-issue-notifications) for more information.

## License

This project is licensed under the Apache-2.0 License.

[createtable]: todofix
[ddbenhanced]: https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/dynamodb-enhanced-client.html
