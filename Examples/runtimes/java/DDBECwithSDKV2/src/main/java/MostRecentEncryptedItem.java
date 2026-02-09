// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

import java.security.GeneralSecurityException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.DynamoDBEncryptor;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionContext;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionFlags;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.CachingMostRecentProvider;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.DirectKmsMaterialsProvider;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.store.MetaStore;

/**
 * This demonstrates how to use the CachingMostRecentProvider backed by a MetaStore
 * and the DirectKmsMaterialsProvider to encrypt your data.
 */
public class MostRecentEncryptedItem {

  private static final String STRING_FIELD_NAME = "example";
  private static final String BINARY_FIELD_NAME = "and some binary";
  private static final String NUMBER_FIELD_NAME = "some numbers";
  private static final String IGNORED_FIELD_NAME = "leave me";

  public static void encryptRecord(
    final DynamoDbClient ddbClient,
    final KmsClient kmsClient,
    final String tableName,
    final String keyTableName,
    final String cmkArn,
    final String materialName,
    final String partitionKeyName,
    final String sortKeyName,
    final String partitionKeyValue,
    final String sortKeyValue
  ) throws GeneralSecurityException {
    // Sample record to be encrypted
    final Map<String, AttributeValue> record = new HashMap<>();
    record.put(
      partitionKeyName,
      AttributeValue.builder().s(partitionKeyValue).build()
    );
    record.put(sortKeyName, AttributeValue.builder().n(sortKeyValue).build());
    record.put(STRING_FIELD_NAME, AttributeValue.builder().s("data").build());
    record.put(NUMBER_FIELD_NAME, AttributeValue.builder().n("99").build());
    record.put(
      BINARY_FIELD_NAME,
      AttributeValue
        .builder()
        .b(SdkBytes.fromByteArray(new byte[] { 0x00, 0x01, 0x02 }))
        .build()
    );
    record.put(IGNORED_FIELD_NAME, AttributeValue.builder().s("alone").build());

    // Provider Configuration to protect the data keys
    final DirectKmsMaterialsProvider kmsProv = new DirectKmsMaterialsProvider(
      kmsClient,
      cmkArn
    );
    final DynamoDBEncryptor keyEncryptor = DynamoDBEncryptor.getInstance(
      kmsProv
    );

    final MetaStore metaStore = new MetaStore(
      ddbClient,
      keyTableName,
      keyEncryptor
    );

    // Provider configuration to protect the data
    final CachingMostRecentProvider cmp = new CachingMostRecentProvider(
      metaStore,
      materialName,
      60_000
    );

    // Encryptor creation
    final DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(cmp);

    // Information about the context of our data (normally just Table information)
    final EncryptionContext encryptionContext = EncryptionContext
      .builder()
      .tableName(tableName)
      .hashKeyName(partitionKeyName)
      .rangeKeyName(sortKeyName)
      .build();

    // Describe what actions need to be taken for each attribute
    final EnumSet<EncryptionFlags> signOnly = EnumSet.of(EncryptionFlags.SIGN);
    final EnumSet<EncryptionFlags> encryptAndSign = EnumSet.of(
      EncryptionFlags.ENCRYPT,
      EncryptionFlags.SIGN
    );
    final Map<String, Set<EncryptionFlags>> actions = new HashMap<>();

    for (final String attributeName : record.keySet()) {
      switch (attributeName) {
        case "partition_key":
        case "sort_key":
          actions.put(attributeName, signOnly);
          break;
        default:
          if (!attributeName.equals(IGNORED_FIELD_NAME)) {
            actions.put(attributeName, encryptAndSign);
          }
          break;
      }
    }

    // Encrypt the plaintext record directly
    final Map<String, AttributeValue> encrypted_record =
      encryptor.encryptRecord(record, actions, encryptionContext);

    // For demo, encrypted record fields change as expected
    assert encrypted_record.get(STRING_FIELD_NAME).b() != null;
    assert encrypted_record.get(NUMBER_FIELD_NAME).b() != null;
    assert !record
      .get(BINARY_FIELD_NAME)
      .b()
      .equals(encrypted_record.get(BINARY_FIELD_NAME).b());
    assert record
      .get(IGNORED_FIELD_NAME)
      .s()
      .equals(encrypted_record.get(IGNORED_FIELD_NAME).s());

    // For demo, the encrypted item is put to DynamoDB. You can skip this as needed.
    ddbClient.putItem(
      PutItemRequest
        .builder()
        .tableName(tableName)
        .item(encrypted_record)
        .build()
    );

    // Get the item back from DynamoDB
    final Map<String, AttributeValue> keyToGet = new HashMap<>();
    keyToGet.put(
      partitionKeyName,
      AttributeValue.builder().s(partitionKeyValue).build()
    );
    keyToGet.put(sortKeyName, AttributeValue.builder().n(sortKeyValue).build());

    final GetItemResponse getResponse = ddbClient.getItem(
      GetItemRequest.builder().tableName(tableName).key(keyToGet).build()
    );

    // Decryption is identical
    final Map<String, AttributeValue> decrypted_record =
      encryptor.decryptRecord(getResponse.item(), actions, encryptionContext);

    // For demo, the decrypted fields match the original fields before encryption
    assert record
      .get(STRING_FIELD_NAME)
      .s()
      .equals(decrypted_record.get(STRING_FIELD_NAME).s());
    assert record
      .get(NUMBER_FIELD_NAME)
      .n()
      .equals(decrypted_record.get(NUMBER_FIELD_NAME).n());
    assert record
      .get(BINARY_FIELD_NAME)
      .b()
      .equals(decrypted_record.get(BINARY_FIELD_NAME).b());
  }

  public static void main(final String[] args) throws GeneralSecurityException {
    if (args.length < 8) {
      throw new IllegalArgumentException(
        "To run this example, include tableName, keyTableName, cmkArn, materialName, " +
        "partitionKeyName, sortKeyName, partitionKeyValue, sortKeyValue as args"
      );
    }
    final String tableName = args[0];
    final String keyTableName = args[1];
    final String cmkArn = args[2];
    final String materialName = args[3];
    final String partitionKeyName = args[4];
    final String sortKeyName = args[5];
    final String partitionKeyValue = args[6];
    final String sortKeyValue = args[7];
    try (final DynamoDbClient ddbClient = DynamoDbClient.create()) {
      encryptRecord(
        ddbClient,
        KmsClient.create(),
        tableName,
        keyTableName,
        cmkArn,
        materialName,
        partitionKeyName,
        sortKeyName,
        partitionKeyValue,
        sortKeyValue
      );
    }
  }
}
