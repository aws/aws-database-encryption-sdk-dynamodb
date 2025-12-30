package software.amazon.cryptography.examples.migration.ddbec;

import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.DirectKmsMaterialsProvider;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.DynamoDbEncryptor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.kms.KmsClient;

/*
  Migration Step 0: This is an example demonstrating use with the DynamoDb Encryption Client,
  and is the starting state for our migration to the AWS Database Encryption SDK for DynamoDb.
  In this example we configure a DynamoDBMapper configured to encrypt and decrypt
  items. The encryption and decryption of data is configured to use a KMS Key as the root of trust.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (N)
*/
public class MigrationExampleStep0 {

  public static void MigrationStep0(
    String kmsKeyId,
    String ddbTableName,
    int sortReadValue
  ) {
    // 1. Create the DirectKmsMaterialsProvider that protects your data keys.
    final KmsClient kmsClient = KmsClient.create();
    final DirectKmsMaterialsProvider materialProvider = new DirectKmsMaterialsProvider(
      kmsClient,
      kmsKeyId
    );

    // 2. Create the DynamoDBEncryptor using the Material Provider created above
    final DynamoDbEncryptor encryptor = DynamoDbEncryptor.getInstance(materialProvider);

    // 3. Create a DynamoDbEnhancedClient with the encryptor configured as an extension
    final DynamoDbClient ddbClient = DynamoDbClient.create();
    final DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
      .dynamoDbClient(ddbClient)
      .extensions(encryptor)
      .build();

    // 4. Create a DynamoDbTable with the table schema
    final DynamoDbTable<SimpleClass> table = enhancedClient.table(
      ddbTableName,
      TableSchema.fromBean(SimpleClass.class)
    );

    // 5. Put an example item into our DynamoDb table.
    //    This item will be encrypted client-side before it is sent to DynamoDb.
    SimpleClass item = new SimpleClass();
    item.setPartitionKey("MigrationExample");
    item.setSortKey(0);
    item.setAttribute1("encrypt and sign me!");
    item.setAttribute2("sign me!");
    item.setAttribute3("ignore me!");

    table.putItem(item);

    // 6. Get this item back from DynamoDb.
    //    The item will be decrypted client-side, and the original item returned.
    Key key = Key.builder()
      .partitionValue("MigrationExample")
      .sortValue(sortReadValue)
      .build();
    
    SimpleClass decryptedItem = table.getItem(key);

    // Demonstrate we get the expected item back
    assert decryptedItem.getPartitionKey().equals("MigrationExample");
    assert decryptedItem.getAttribute1().equals("encrypt and sign me!");
  }

  public static void main(final String[] args) {
    if (args.length < 2) {
      throw new IllegalArgumentException(
        "To run this example, include the kmsKeyId, ddbTableName, and sortReadValue as args."
      );
    }
    final String kmsKeyId = args[0];
    final String ddbTableName = args[1];
    // You can manipulate this value to demonstrate reading records written in other steps
    final int sortReadValue = Integer.parseInt(args[2]);
    MigrationStep0(kmsKeyId, ddbTableName, sortReadValue);
  }
}
