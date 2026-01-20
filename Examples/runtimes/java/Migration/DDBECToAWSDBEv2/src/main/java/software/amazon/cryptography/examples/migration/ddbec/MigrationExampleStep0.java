package software.amazon.cryptography.examples.migration.ddbec;

import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionFlags;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.DirectKmsMaterialsProvider;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.interceptor.DDBECInterceptor;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

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

    // 4. Put an example item into our DynamoDb table.
    //    This item will be encrypted client-side before it is sent to DynamoDb.
    final Map<String, AttributeValue> item = new HashMap<>();
    item.put("partition_key", AttributeValue.builder().s("MigrationExample").build());
    item.put("sort_key", AttributeValue.builder().n("0").build());
    item.put("attribute1", AttributeValue.builder().s("encrypt and sign me!").build());
    item.put("attribute2", AttributeValue.builder().s("sign me!").build());
    item.put("attribute3", AttributeValue.builder().s("ignore me!").build());

    // Encrypt manually using encryptRecord with attribute flags
    final Map<String, Set<EncryptionFlags>> attributeFlags = new HashMap<>();
    // Keys are never encrypted, only signed
    attributeFlags.put("partition_key", java.util.EnumSet.of(EncryptionFlags.SIGN));
    attributeFlags.put("sort_key", java.util.EnumSet.of(EncryptionFlags.SIGN));
    // attribute1 - encrypt and sign
    attributeFlags.put("attribute1", java.util.EnumSet.of(EncryptionFlags.ENCRYPT, EncryptionFlags.SIGN));
    // attribute2 - sign only
    attributeFlags.put("attribute2", java.util.EnumSet.of(EncryptionFlags.SIGN));
    // attribute3 - ignore (no flags)

    // Create interceptor
    DDBECInterceptor interceptor = DDBECInterceptor.builder()
            .tableName(ddbTableName)
            .partitionKeyName("partition_key")
            .sortKeyName("sort_key")
            .materialProvider(materialProvider)
            .attributeFlags(attributeFlags)
            .build();

    final DynamoDbClient ddbClient = DynamoDbClient.builder()
            .overrideConfiguration(ClientOverrideConfiguration.builder()
            .addExecutionInterceptor(interceptor)
            .build())
            .build();

    // Send to DynamoDB
    ddbClient.putItem(PutItemRequest.builder()
      .tableName(ddbTableName)
      .item(item)
      .build());

    // 5. Get this item back from DynamoDb.
    //    The item will be decrypted client-side, and the original item returned.
    final Map<String, AttributeValue> key = new HashMap<>();
    key.put("partition_key", AttributeValue.builder().s("MigrationExample").build());
    key.put("sort_key", AttributeValue.builder().n(String.valueOf(sortReadValue)).build());

    final GetItemResponse response = ddbClient.getItem(GetItemRequest.builder()
      .tableName(ddbTableName)
      .key(key)
      .build());


    // Demonstrate we get the expected item back
    assert response.item().get("partition_key").s().equals("MigrationExample");
    assert response.item().get("attribute1").s().equals("encrypt and sign me!");
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
