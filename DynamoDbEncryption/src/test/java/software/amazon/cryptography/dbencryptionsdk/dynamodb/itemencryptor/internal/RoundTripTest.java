// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internal;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.AesWrappingAlg;
import software.amazon.cryptography.materialproviders.model.CreateRawAesKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Round-trip test: encrypt an item then decrypt it and verify we get the original back.
 */
class RoundTripTest {

  @Test
  void encryptThenDecryptRoundTrip() {
    // Create a raw AES keyring for testing (no KMS needed)
    byte[] rawKey = new byte[32];
    Arrays.fill(rawKey, (byte) 0xAA);

    MaterialProviders mpl = MaterialProviders.builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();

    IKeyring keyring = mpl.CreateRawAesKeyring(
      CreateRawAesKeyringInput.builder()
        .keyNamespace("test")
        .keyName("test-key")
        .wrappingKey(ByteBuffer.wrap(rawKey))
        .wrappingAlg(AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16)
        .build());

    // Configure attribute actions
    Map<String, CryptoAction> actions = new HashMap<>();
    actions.put("pk", CryptoAction.SIGN_ONLY);
    actions.put("sk", CryptoAction.SIGN_ONLY);
    actions.put("secret", CryptoAction.ENCRYPT_AND_SIGN);
    actions.put("data", CryptoAction.ENCRYPT_AND_SIGN);

    // Build the item encryptor
    DynamoDbItemEncryptor encryptor = DynamoDbItemEncryptor.builder()
      .DynamoDbItemEncryptorConfig(DynamoDbItemEncryptorConfig.builder()
        .logicalTableName("TestTable")
        .partitionKeyName("pk")
        .sortKeyName("sk")
        .attributeActionsOnEncrypt(actions)
        .keyring(keyring)
        .build())
      .build();

    // Create a plaintext item
    Map<String, AttributeValue> plaintextItem = new HashMap<>();
    plaintextItem.put("pk", AttributeValue.fromS("user-123"));
    plaintextItem.put("sk", AttributeValue.fromN("42"));
    plaintextItem.put("secret", AttributeValue.fromS("my-secret-value"));
    plaintextItem.put("data", AttributeValue.fromB(SdkBytes.fromByteArray(new byte[] { 1, 2, 3, 4, 5 })));

    // Encrypt
    EncryptItemOutput encryptOutput = encryptor.EncryptItem(
      EncryptItemInput.builder().plaintextItem(plaintextItem).build());

    Map<String, AttributeValue> encryptedItem = encryptOutput.encryptedItem();

    // Verify encrypted item has header and footer
    assertTrue(encryptedItem.containsKey("aws_dbe_head"), "Missing aws_dbe_head");
    assertTrue(encryptedItem.containsKey("aws_dbe_foot"), "Missing aws_dbe_foot");

    // Verify partition and sort keys are unchanged (SIGN_ONLY)
    assertEquals("user-123", encryptedItem.get("pk").s());
    assertEquals("42", encryptedItem.get("sk").n());

    // Verify encrypted fields are different from plaintext
    assertNotEquals(plaintextItem.get("secret"), encryptedItem.get("secret"));

    // Decrypt
    DecryptItemOutput decryptOutput = encryptor.DecryptItem(
      DecryptItemInput.builder().encryptedItem(encryptedItem).build());

    Map<String, AttributeValue> decryptedItem = decryptOutput.plaintextItem();

    // Verify round-trip: decrypted item matches original plaintext
    assertEquals("user-123", decryptedItem.get("pk").s());
    assertEquals("42", decryptedItem.get("sk").n());
    assertEquals("my-secret-value", decryptedItem.get("secret").s());
    assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, decryptedItem.get("data").b().asByteArray());

    // Verify header/footer are NOT in decrypted output
    assertFalse(decryptedItem.containsKey("aws_dbe_head"));
    assertFalse(decryptedItem.containsKey("aws_dbe_foot"));
  }
}
