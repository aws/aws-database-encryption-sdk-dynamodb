package software.amazon.cryptography.examples.awsdbe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.CreateDynamoDbEncryptionInterceptorInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedClientEncryption;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PlaintextOverride;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

/*
  Migration Step 1: This is an example demonstrating how to start using the
  AWS Database Encryption SDK with a pre-existing table with plaintext items.
  In this example, we configure a DynamoDb Encryption Interceptor to do the following:
    - Write items only in plaintext
    - Read items in plaintext or, if the item is encrypted, decrypt with our encryption configuration

  While this step configures your client to be ready to start reading encrypted items,
  we do not yet expect to be reading any encrypted items,
  as our client still writes plaintext items.
  Before you move on to step 2, ensure that these changes have successfully been deployed
  to all of your readers.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
 */
public class MigrationExampleStep1 {

  public static void MigrationStep1(
    String kmsKeyId,
    String ddbTableName,
    int sortReadValue,
    String partitionKey
  ) {
    // 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
    //    We will use the `CreateMrkMultiKeyring` method to create this keyring,
    //    as it will correctly handle both single region and Multi-Region KMS Keys.
    //
    //    Note that while we still are not writing encrypted items,
    //    and our key will not be used to encrypt items in this example,
    //    our configuration specifies that we may read encrypted items,
    //    and we should expect to be able to decrypt and process any encrypted items.
    //    To that end, we must fully define our encryption configuration in
    //    this step.
    MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    final CreateAwsKmsMrkMultiKeyringInput keyringInput =
      CreateAwsKmsMrkMultiKeyringInput.builder().generator(kmsKeyId).build();
    final IKeyring kmsKeyring = matProv.CreateAwsKmsMrkMultiKeyring(
      keyringInput
    );

    // 2. Create a Table Schema over your annotated class.
    //    See SimpleClass.java in this directory for the update to use the new DynamoDb Enhanced Client annotations.
    //    All primary key attributes will be signed but not encrypted (SIGN_ONLY)
    //    and by default all non-primary key attributes will be encrypted and signed (ENCRYPT_AND_SIGN).
    //    If you want a particular non-primary key attribute to be signed but not encrypted,
    //    use the `DynamoDbEncryptionSignOnly` annotation.
    //    If you want a particular attribute to be neither signed nor encrypted (DO_NOTHING),
    //    use the `DynamoDbEncryptionDoNothing` annotation.
    final TableSchema<SimpleClass> tableSchema = TableSchema.fromBean(
      SimpleClass.class
    );

    // 3. Configure which attributes we expect to be excluded in the signature
    //    when reading items. This value represents all unsigned attributes
    //    across our entire dataset. If you ever want to add new unsigned attributes
    //    in the future, you must make an update to this field to all your readers
    //    before deploying any change to start writing that new data. It is not safe
    //    to remove attributes from this field.
    final List<String> unsignedAttributes = Arrays.asList("attribute3");

    // 4. Create encryption configuration for table.
    //    Again, while we are not writing encrypted items,
    //    we should expect to be able to read encrypted items.
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      ddbTableName,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(ddbTableName)
        .keyring(kmsKeyring)
        .schemaOnEncrypt(tableSchema)
        .allowedUnsignedAttributes(unsignedAttributes)
        // This plaintext override means:
        //  - Write: Items are forced to be written as plaintext.
        //           Items may not be written as encrypted items.
        //  - Read: Items are allowed to be read as plaintext.
        //          Items are allowed to be read as encrypted items.
        .plaintextOverride(
          PlaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ
        )
        .build()
    );

    // 5. Create DynamoDbEncryptionInterceptor using the table config
    DynamoDbEncryptionInterceptor interceptor =
      DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
        CreateDynamoDbEncryptionInterceptorInput
          .builder()
          .tableEncryptionConfigs(tableConfigs)
          .build()
      );

    // 6. Create the EnhancedClient using the interceptor, and create a table from the schema
    DynamoDbClient ddb = DynamoDbClient
      .builder()
      .region(Region.US_WEST_2)
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(interceptor)
          .build()
      )
      .build();
    DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient
      .builder()
      .dynamoDbClient(ddb)
      .build();
    final DynamoDbTable<SimpleClass> table = enhancedClient.table(
      ddbTableName,
      tableSchema
    );

    // 7. Put an item into your table using the DynamoDb Enhanced Client.
    //    This item will be stored in plaintext.
    final SimpleClass item = new SimpleClass();
    item.setPartitionKey(partitionKey);
    item.setSortKey(1);
    item.setAttribute1("this will be encrypted and signed");
    item.setAttribute3("this will never be encrypted nor signed");
    item.setAttribute2("this will never be encrypted, but it will be signed");

    table.putItem(item);

    // 8. Get an item back from the table using the DynamoDb Enhanced Client.
    //    If this is an item written in plaintext (i.e. any item written
    //    during Step 0 or 1), then the item will still be in plaintext.
    //    If this is an item that was encrypted client-side (i.e. any item written
    //    during Step 2 or after), then the item will be decrypted client-side
    //    and surfaced as a plaintext item.
    SimpleClass itemToGet = new SimpleClass();
    itemToGet.setPartitionKey(partitionKey);
    itemToGet.setSortKey(sortReadValue);

    SimpleClass returnedItem = table.getItem(itemToGet);

    // Demonstrate we get the expected item back
    assert returnedItem.getPartitionKey().equals(partitionKey);
    assert returnedItem
      .getAttribute1()
      .equals("this will be encrypted and signed");
  }

  public static void main(final String[] args) {
    if (args.length < 3) {
      throw new IllegalArgumentException(
        "To run this example, include the kmsKeyId, ddbTableName, and sortReadValue as args."
      );
    }
    final String kmsKeyId = args[0];
    final String ddbTableName = args[1];
    // You can manipulate this value to demonstrate reading records written in other steps
    final int sortReadValue = Integer.parseInt(args[2]);
    final String partitionKey = args[3];
    MigrationStep1(kmsKeyId, ddbTableName, sortReadValue, partitionKey);
  }
}
