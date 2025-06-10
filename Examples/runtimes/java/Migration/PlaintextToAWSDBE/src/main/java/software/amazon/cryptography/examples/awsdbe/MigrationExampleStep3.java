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
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

/*
  Migration Step 3: This is an example demonstrating how to update your configuration
  to stop accepting reading plaintext items.

  Once you complete Step 3, all items being read by your system are encrypted.

  Before you move onto this step, you will need to encrypt all plaintext items in your dataset.
  How you will want to do this depends on your system.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
 */
public class MigrationExampleStep3 {

  public static void MigrationStep3(
    String kmsKeyId,
    String ddbTableName,
    int sortReadValue,
    String partitionKey
  ) {
    // 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
    //    We will use the `CreateMrkMultiKeyring` method to create this keyring,
    //    as it will correctly handle both single region and Multi-Region KMS Keys.
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
    //    This uses the same annotated class as Step 2, which MUST be deployed to all hosts
    //    before deploying Step 2.
    final TableSchema<SimpleClass> tableSchema = TableSchema.fromBean(
      SimpleClass.class
    );

    // 3. Configure which attributes we expect to be excluded in the signature
    //    when reading items. This value MUST be the same as in Steps 1 and 2.
    final List<String> unsignedAttributes = Arrays.asList("attribute3");

    // 4. Create encryption configuration for table.
    //    Do not specify a plaintext override. Unspecified plaintext override defaults to
    //    `FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ`, which is the desired behavior
    //    for a client interacting with a fully encrypted database.
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
        .build()
    );

    // 5. Create DynamoDbEncryptionInterceptor using the above config
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
    //    This item will be encrypted.
    final SimpleClass item = new SimpleClass();
    item.setPartitionKey(partitionKey);
    item.setSortKey(3);
    item.setAttribute1("this will be encrypted and signed");
    item.setAttribute3("this will never be encrypted nor signed");
    item.setAttribute2("this will never be encrypted, but it will be signed");

    table.putItem(item);

    // 8. Get an item back from the table using the DynamoDb Enhanced Client.
    //    If this is an item written in plaintext (i.e. any item written
    //    during Step 0 or 1), then the read will fail, as we have
    //    configured our client to forbid reading plaintext items.
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
    MigrationStep3(kmsKeyId, ddbTableName, sortReadValue, partitionKey);
  }
}
