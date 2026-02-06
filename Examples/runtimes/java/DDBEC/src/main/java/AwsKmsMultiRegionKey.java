// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

import java.security.GeneralSecurityException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.DynamoDBEncryptor;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionContext;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionFlags;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.DirectKmsMaterialsProvider;

/**
 * Example showing use of AWS KMS CMP with an AWS KMS Multi-Region Key. We encrypt a record with a
 * key in one region, then decrypt the ciphertext with the same key replicated to another region.
 *
 * <p>This example demonstrates that data encrypted with one MRK can be decrypted with its replica
 * key from a different region, without requiring a Global Table.
 */
public class AwsKmsMultiRegionKey {

  public static void main(String[] args) throws GeneralSecurityException {
    final String tableName = args[0];
    final String cmkArn1 = args[1];
    final String cmkArn2 = args[2];

    try (final DynamoDbClient ddbClient = DynamoDbClient.create()) {
      encryptRecord(ddbClient, tableName, cmkArn1, cmkArn2);
    }
  }

  public static void encryptRecord(
    final DynamoDbClient ddbClient,
    final String tableName,
    final String cmkArnEncrypt,
    final String cmkArnDecrypt
  ) throws GeneralSecurityException {
    // Extract regions from ARNs
    final String encryptRegion = cmkArnEncrypt.split(":")[3];
    final String decryptRegion = cmkArnDecrypt.split(":")[3];

    final KmsClient kmsEncrypt = KmsClient
      .builder()
      .region(Region.of(encryptRegion))
      .build();
    final KmsClient kmsDecrypt = KmsClient
      .builder()
      .region(Region.of(decryptRegion))
      .build();

    // Sample record to be encrypted
    final String partitionKeyName = "partition_key";
    final String sortKeyName = "sort_key";
    final Map<String, AttributeValue> record = new HashMap<>();
    record.put(partitionKeyName, AttributeValue.builder().s("is this").build());
    record.put(sortKeyName, AttributeValue.builder().n("42").build());
    record.put("example", AttributeValue.builder().s("data").build());
    record.put("some numbers", AttributeValue.builder().n("99").build());
    record.put(
      "and some binary",
      AttributeValue
        .builder()
        .b(SdkBytes.fromByteArray(new byte[] { 0x00, 0x01, 0x02 }))
        .build()
    );
    record.put("leave me", AttributeValue.builder().s("alone").build());

    // Set up encryptor with first region's KMS key
    final DirectKmsMaterialsProvider cmpEncrypt =
      new DirectKmsMaterialsProvider(kmsEncrypt, cmkArnEncrypt);
    final DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(
      cmpEncrypt
    );

    final EncryptionContext encryptionContext = EncryptionContext
      .builder()
      .tableName(tableName)
      .hashKeyName(partitionKeyName)
      .rangeKeyName(sortKeyName)
      .build();

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
        case "leave me":
          break;
        default:
          actions.put(attributeName, encryptAndSign);
          break;
      }
    }

    // Encrypt and save to table
    final Map<String, AttributeValue> encrypted_record =
      encryptor.encryptRecord(record, actions, encryptionContext);
    ddbClient.putItem(
      PutItemRequest
        .builder()
        .tableName(tableName)
        .item(encrypted_record)
        .build()
    );

    // Set up decryptor using the replica key from second region
    final DirectKmsMaterialsProvider cmpDecrypt =
      new DirectKmsMaterialsProvider(kmsDecrypt, cmkArnDecrypt);
    final DynamoDBEncryptor decryptor = DynamoDBEncryptor.getInstance(
      cmpDecrypt
    );

    // Retrieve from same table
    final Map<String, AttributeValue> keyToGet = new HashMap<>();
    keyToGet.put(
      partitionKeyName,
      AttributeValue.builder().s("is this").build()
    );
    keyToGet.put(sortKeyName, AttributeValue.builder().n("42").build());

    final Map<String, AttributeValue> encryptedItem = ddbClient
      .getItem(
        GetItemRequest.builder().tableName(tableName).key(keyToGet).build()
      )
      .item();

    // Decrypt using replica key - demonstrates multi-region key capability
    final Map<String, AttributeValue> decrypted_record =
      decryptor.decryptRecord(encryptedItem, actions, encryptionContext);

    // Verify decryption
    assert record
      .get("example")
      .s()
      .equals(decrypted_record.get("example").s());
    assert record
      .get("some numbers")
      .n()
      .equals(decrypted_record.get("some numbers").n());
    assert record
      .get("and some binary")
      .b()
      .equals(decrypted_record.get("and some binary").b());

    ddbClient.close();
    kmsEncrypt.close();
    kmsDecrypt.close();
  }
}
