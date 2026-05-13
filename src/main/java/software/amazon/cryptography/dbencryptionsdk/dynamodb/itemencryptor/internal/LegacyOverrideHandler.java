// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internal;

import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.ILegacyDynamoDbEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyOverride;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyPolicy;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemOutput;

/**
 * Handles legacy encryption/decryption delegation for migration from v2 to v3.
 *
 * //= specification/dynamodb-encryption-client/ddb-item-encryptor.md#legacy-behavior
 * //# If a Legacy Policy of FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT is configured,
 * //# the encrypt MUST delegate to the legacy encryptor.
 */
public final class LegacyOverrideHandler {

  private final LegacyOverride config;

  public LegacyOverrideHandler(LegacyOverride config) {
    this.config = config;
  }

  /** Returns true if legacy encrypt should be used instead of native encrypt. */
  public boolean shouldLegacyEncrypt() {
    return config.policy() == LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT;
  }

  /** Returns true if legacy decrypt should be attempted for items without aws_dbe_head. */
  public boolean shouldLegacyDecrypt() {
    return config.policy() == LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT
        || config.policy() == LegacyPolicy.FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT;
  }

  /**
   * Encrypt using the legacy encryptor.
   * The ILegacyDynamoDbEncryptor is a user-provided implementation that wraps
   * the old DynamoDBEncryptor. The actual encrypt/decrypt calls are made via
   * reflection or direct casting since the interface is a marker.
   */
  public EncryptItemOutput legacyEncrypt(EncryptItemInput input) {
    // The legacy encryptor is opaque — the user's implementation handles the actual
    // encryption using the old DynamoDBEncryptor. We invoke it via the known method pattern.
    ILegacyDynamoDbEncryptor encryptor = config.encryptor();
    Map<String, AttributeValue> encrypted = invokeLegacyEncrypt(encryptor, input.plaintextItem());
    return EncryptItemOutput.builder().encryptedItem(encrypted).build();
  }

  /**
   * Decrypt using the legacy encryptor.
   */
  public DecryptItemOutput legacyDecrypt(DecryptItemInput input) {
    ILegacyDynamoDbEncryptor encryptor = config.encryptor();
    Map<String, AttributeValue> decrypted = invokeLegacyDecrypt(encryptor, input.encryptedItem());
    return DecryptItemOutput.builder().plaintextItem(decrypted).build();
  }

  /**
   * Invoke legacy encrypt via reflection on the user-provided encryptor.
   * The legacy encryptor is expected to have an encryptRecord method.
   */
  @SuppressWarnings("unchecked")
  private static Map<String, AttributeValue> invokeLegacyEncrypt(
    ILegacyDynamoDbEncryptor encryptor, Map<String, AttributeValue> item
  ) {
    try {
      java.lang.reflect.Method method = encryptor.getClass().getMethod(
        "encryptRecord", Map.class);
      return (Map<String, AttributeValue>) method.invoke(encryptor, item);
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(
        "Legacy encryptor must implement encryptRecord(Map<String, AttributeValue>)", e);
    } catch (Exception e) {
      throw new RuntimeException("Legacy encryption failed", e);
    }
  }

  @SuppressWarnings("unchecked")
  private static Map<String, AttributeValue> invokeLegacyDecrypt(
    ILegacyDynamoDbEncryptor encryptor, Map<String, AttributeValue> item
  ) {
    try {
      java.lang.reflect.Method method = encryptor.getClass().getMethod(
        "decryptRecord", Map.class);
      return (Map<String, AttributeValue>) method.invoke(encryptor, item);
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(
        "Legacy encryptor must implement decryptRecord(Map<String, AttributeValue>)", e);
    } catch (Exception e) {
      throw new RuntimeException("Legacy decryption failed", e);
    }
  }
}
