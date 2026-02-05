package software.amazon.cryptography.examples.migration.ddbec;

import java.security.GeneralSecurityException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.DynamoDBEncryptor;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionContext;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionFlags;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.DirectKmsMaterialsProvider;

/*
  Migration Step 0: This is an example demonstrating use with the DynamoDb Encryption Client
  with AWS SDK for Java V2, and is the starting state for our migration to the
  AWS Database Encryption SDK for DynamoDb.

  In this example we configure a DynamoDBEncryptor to encrypt and decrypt items.
  The encryption and decryption of data is configured to use a KMS Key as the root of trust.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (N)
*/
public class MigrationExampleStep0 {

  public static void MigrationStep0(
    final String kmsKeyId,
    final String ddbTableName,
    final int sortReadValue
  ) throws GeneralSecurityException {
    // 1. Create the DirectKmsMaterialsProvider that protects your data keys.
    //    This uses the AWS SDK for Java V2 KmsClient.
    final KmsClient kmsClient = KmsClient.create();
    final DirectKmsMaterialsProvider cmp = new DirectKmsMaterialsProvider(
      kmsClient,
      kmsKeyId
    );

    // 2. Create the DynamoDBEncryptor using the Material Provider created above
    final DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(cmp);

    // 3. Configure attribute flags for encryption.
    //    For each attribute, specify whether to ENCRYPT and/or SIGN.
    final Map<String, Set<EncryptionFlags>> attributeFlags = new HashMap<>();
    // Keys are signed but never encrypted
    attributeFlags.put("partition_key", EnumSet.of(EncryptionFlags.SIGN));
    attributeFlags.put("sort_key", EnumSet.of(EncryptionFlags.SIGN));
    // attribute1 - encrypt and sign
    attributeFlags.put(
      "attribute1",
      EnumSet.of(EncryptionFlags.ENCRYPT, EncryptionFlags.SIGN)
    );
    // attribute2 - sign only
    attributeFlags.put("attribute2", EnumSet.of(EncryptionFlags.SIGN));
    // attribute3 - no flags (do nothing)

    // 4. Create a DynamoDB client
    final DynamoDbClient ddbClient = DynamoDbClient.create();

    // 5. Create the item to encrypt
    final Map<String, AttributeValue> item = new HashMap<>();
    item.put(
      "partition_key",
      AttributeValue.builder().s("MigrationExample").build()
    );
    item.put("sort_key", AttributeValue.builder().n("0").build());
    item.put(
      "attribute1",
      AttributeValue.builder().s("encrypt and sign me!").build()
    );
    item.put("attribute2", AttributeValue.builder().s("sign me!").build());
    item.put("attribute3", AttributeValue.builder().s("ignore me!").build());

    // 6. Create the EncryptionContext for this operation
    final EncryptionContext encryptionContext = EncryptionContext
      .builder()
      .tableName(ddbTableName)
      .hashKeyName("partition_key")
      .rangeKeyName("sort_key")
      .build();

    // 7. Encrypt the item using encryptRecord
    final Map<String, AttributeValue> encryptedItem = encryptor.encryptRecord(
      item,
      attributeFlags,
      encryptionContext
    );

    // Verify attribute1 is encrypted (original attribute name no longer exists)
    assert encryptedItem.get("attribute1").b() != null;
    // Verify attribute2 and attribute3 are not encrypted (sign-only and do-nothing)
    assert encryptedItem.get("attribute2").s().equals("sign me!");
    assert encryptedItem.get("attribute3").s().equals("ignore me!");

    // 8. Put the encrypted item into DynamoDB
    ddbClient.putItem(
      PutItemRequest
        .builder()
        .tableName(ddbTableName)
        .item(encryptedItem)
        .build()
    );

    // 9. Get the encrypted item back from DynamoDB
    final Map<String, AttributeValue> key = new HashMap<>();
    key.put(
      "partition_key",
      AttributeValue.builder().s("MigrationExample").build()
    );
    key.put(
      "sort_key",
      AttributeValue.builder().n(String.valueOf(sortReadValue)).build()
    );

    final GetItemResponse response = ddbClient.getItem(
      GetItemRequest.builder().tableName(ddbTableName).key(key).build()
    );

    // 10. Decrypt the item using decryptRecord
    final Map<String, AttributeValue> decryptedItem = encryptor.decryptRecord(
      response.item(),
      attributeFlags,
      encryptionContext
    );

    // Demonstrate we get the expected item back
    assert decryptedItem.get("partition_key").s().equals("MigrationExample");
    assert decryptedItem.get("attribute1").s().equals("encrypt and sign me!");
    assert decryptedItem.get("attribute2").s().equals("sign me!");
    assert decryptedItem.get("attribute3").s().equals("ignore me!");
  }

  public static void main(final String[] args) throws GeneralSecurityException {
    if (args.length < 3) {
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
