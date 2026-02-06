// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.DynamoDBEncryptor;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionContext;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionFlags;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.WrappedMaterialsProvider;

/**
 * Example showing use of an AES key for encryption and an HmacSHA256 key for signing. For ease of
 * the example, we create new random ones every time.
 */
public class SymmetricEncryptedItem {

  private static final String STRING_FIELD_NAME = "example";
  private static final String BINARY_FIELD_NAME = "and some binary";
  private static final String NUMBER_FIELD_NAME = "some numbers";
  private static final String IGNORED_FIELD_NAME = "leave me";

  public static void main(String[] args) throws GeneralSecurityException {
    if (args.length < 5) {
      throw new IllegalArgumentException(
        "To run this example, include tableName, partitionKeyName, sortKeyName, " +
        "partitionKeyValue, sortKeyValue as args"
      );
    }
    final String tableName = args[0];
    final String partitionKeyName = args[1];
    final String sortKeyName = args[2];
    final String partitionKeyValue = args[3];
    final String sortKeyValue = args[4];

    // Both AES and HMAC keys are just random bytes.
    // You should never use the same keys for encryption and signing/integrity.
    final SecureRandom secureRandom = new SecureRandom();
    byte[] rawAes = new byte[32];
    byte[] rawHmac = new byte[32];
    secureRandom.nextBytes(rawAes);
    secureRandom.nextBytes(rawHmac);
    final SecretKey wrappingKey = new SecretKeySpec(rawAes, "AES");
    final SecretKey signingKey = new SecretKeySpec(rawHmac, "HmacSHA256");

    try (final DynamoDbClient ddbClient = DynamoDbClient.create()) {
      encryptRecord(
        ddbClient,
        tableName,
        partitionKeyName,
        sortKeyName,
        partitionKeyValue,
        sortKeyValue,
        wrappingKey,
        signingKey
      );
    }
  }

  public static void encryptRecord(
    final DynamoDbClient ddbClient,
    final String tableName,
    final String partitionKeyName,
    final String sortKeyName,
    final String partitionKeyValue,
    final String sortKeyValue,
    final SecretKey wrappingKey,
    final SecretKey signingKey
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
    record.put(IGNORED_FIELD_NAME, AttributeValue.builder().s("alone").build()); // We want to ignore this attribute

    // Set up our configuration and clients. All of this is thread-safe and can be reused across
    // calls.
    // Provider Configuration
    final WrappedMaterialsProvider cmp = new WrappedMaterialsProvider(
      wrappingKey,
      wrappingKey,
      signingKey
    );
    //  While the wrappedMaterialsProvider is better as it uses a unique encryption key per record,
    // many existing systems use the SymmetricStaticProvider which always uses the same encryption
    // key.
    //    final SymmetricStaticProvider cmp = new SymmetricStaticProvider(encryptionKey,
    // signingKey);
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
          // Partition and sort keys must not be encrypted but should be signed
          actions.put(attributeName, signOnly);
          break;
        case IGNORED_FIELD_NAME:
          // For this example, we are neither signing nor encrypting this field
          break;
        default:
          // We want to encrypt and sign everything else
          actions.put(attributeName, encryptAndSign);
          break;
      }
    }
    // End set-up

    // Encrypt the plaintext record directly
    final Map<String, AttributeValue> encrypted_record =
      encryptor.encryptRecord(record, actions, encryptionContext);

    // Encrypted record fields change as expected
    assert encrypted_record.get(STRING_FIELD_NAME).b() != null; // the encrypted string is stored as bytes
    assert encrypted_record.get(NUMBER_FIELD_NAME).b() != null; // the encrypted number is stored as bytes
    assert !record
      .get(BINARY_FIELD_NAME)
      .b()
      .equals(encrypted_record.get(BINARY_FIELD_NAME).b()); // the encrypted bytes have updated
    assert record
      .get(IGNORED_FIELD_NAME)
      .s()
      .equals(encrypted_record.get(IGNORED_FIELD_NAME).s()); // ignored field is left as is

    // For demo, the encrypted item is put to DynamoDB. You can skip this as needed for your use case.
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

    // Decrypt the record retrieved from DynamoDB
    final Map<String, AttributeValue> decrypted_record =
      encryptor.decryptRecord(getResponse.item(), actions, encryptionContext);

    // The decrypted fields match the original fields before encryption
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
}
