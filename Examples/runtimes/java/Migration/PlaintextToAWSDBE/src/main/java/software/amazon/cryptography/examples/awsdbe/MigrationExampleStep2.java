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
  Migration Step 2: This is an example demonstrating how to update your configuration
  to start writing encrypted items, but still continue to read any plaintext or
  encrypted items.

  Once you deploy this change to your system, you will have a dataset
  containing both encrypted and plaintext items.
  Because the changes in Step 1 have been deployed to all our readers,
  we can be sure that our entire system is ready to read this new data.

  Before you move onto the next step, you will need to encrypt all plaintext items in your dataset.
  How you will want to do this depends on your system.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
 */
public class MigrationExampleStep2 {

  public static void MigrationStep2(
    String kmsKeyId,
    String ddbTableName,
    int sortReadValue,
    String partitionKey
  ) {
    // 1. Continue to configure your Keyring, Table Schema, legacy attribute actions,
    //    and allowedUnsignedAttributes, and old DynamoDBEncryptor as you did in Step 1.
    MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    final CreateAwsKmsMrkMultiKeyringInput keyringInput =
      CreateAwsKmsMrkMultiKeyringInput.builder().generator(kmsKeyId).build();
    final IKeyring kmsKeyring = matProv.CreateAwsKmsMrkMultiKeyring(
      keyringInput
    );

    final TableSchema<SimpleClass> tableSchema = TableSchema.fromBean(
      SimpleClass.class
    );

    final List<String> unsignedAttributes = Arrays.asList("attribute3");

    // 2. When creating encryption configuration for your table,
    //    you must use the plaintext override `FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ`.
    //    This plaintext override means:
    //     - Write: Items are forbidden to be written as plaintext.
    //              Items will be written as encrypted items.
    //     - Read: Items are allowed to be read as plaintext.
    //             Items are allowed to be read as encrypted items.
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
        // Update plaintext override here
        .plaintextOverride(
          PlaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ
        )
        .build()
    );

    // 3. Create DynamoDbEncryptionInterceptor using the above config
    DynamoDbEncryptionInterceptor interceptor =
      DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
        CreateDynamoDbEncryptionInterceptorInput
          .builder()
          .tableEncryptionConfigs(tableConfigs)
          .build()
      );

    // 4. Create the EnhancedClient using the interceptor, and create a table from the schema
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

    // 5. Put an item into your table using the DynamoDb Enhanced Client.
    //    This item will be encrypted.
    final SimpleClass item = new SimpleClass();
    item.setPartitionKey(partitionKey);
    item.setSortKey(2);
    item.setAttribute1("this will be encrypted and signed");
    item.setAttribute3("this will never be encrypted nor signed");
    item.setAttribute2("this will never be encrypted, but it will be signed");

    table.putItem(item);

    // 8. Get an item back from the table using the DynamoDb Enhanced Client.
    //    If this is an item written in plaintext (i.e. any item written
    //    during Step 0 or 1), then the item will still be in plaintext.
    //    If this is an item that was encrypted client-side (i.e. any item written
    //    during Step 2 or after), then the DDB enhanced client will decrypt the
    //    item client-side and surface it in our code as a plaintext item.
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
    MigrationStep2(kmsKeyId, ddbTableName, sortReadValue, partitionKey);
  }
}
