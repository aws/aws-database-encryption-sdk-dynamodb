// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internal;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internal.DynamoDbItemConverter;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.StructuredEncryptionUtil;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;

/**
 * Utilities for the DynamoDB Item Encryptor: base context construction and validation.
 */
public final class ItemEncryptorUtil {

  private ItemEncryptorUtil() {}

  // Encryption context keys
  public static final String EC_TABLE_NAME = "aws-crypto-table-name";
  public static final String EC_PARTITION_NAME = "aws-crypto-partition-name";
  public static final String EC_SORT_NAME = "aws-crypto-sort-name";
  public static final String EC_ATTR_PREFIX = "aws-crypto-attr.";

  /**
   * Build the DynamoDB Item Base Context Version 1.
   *
   * //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item-base-context-version-1
   * //# The DynamoDB Item Base Context MUST contain:
   * //# - the key "aws-crypto-table-name" with a value equal to the configured logical table name.
   * //# - the key "aws-crypto-partition-name" with a value equal to the name of the Partition Key.
   * //# - the value of the Partition Key.
   */
  public static Map<String, String> buildBaseContextV1(
    String logicalTableName,
    String partitionKeyName,
    String sortKeyName,
    Map<String, AttributeValue> item
  ) {
    Map<String, String> context = new LinkedHashMap<>();
    context.put(EC_TABLE_NAME, logicalTableName);
    context.put(EC_PARTITION_NAME, partitionKeyName);

    // Partition key value
    AttributeValue pkValue = item.get(partitionKeyName);
    if (pkValue == null) {
      throw new IllegalArgumentException("Item missing partition key: " + partitionKeyName);
    }
    context.put(EC_ATTR_PREFIX + partitionKeyName, encodeTerminalV1(pkValue));

    // Sort key (if configured)
    if (sortKeyName != null && !sortKeyName.isEmpty()) {
      context.put(EC_SORT_NAME, sortKeyName);
      AttributeValue skValue = item.get(sortKeyName);
      if (skValue == null) {
        throw new IllegalArgumentException("Item missing sort key: " + sortKeyName);
      }
      context.put(EC_ATTR_PREFIX + sortKeyName, encodeTerminalV1(skValue));
    }

    return context;
  }

  /**
   * Build the DynamoDB Item Base Context Version 2.
   *
   * //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item-base-context-version-2
   * //# The DynamoDB Item Base Context MUST contain:
   * //# - the key "aws-crypto-table-name" with a value equal to the DynamoDB Table Name.
   * //# - the key "aws-crypto-partition-name" with a value equal to the name of the Partition Key.
   * //# - For every Crypto Action that is SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
   * //#   the key "aws-crypto-attr.<attr_name>" with a value equal to the base context value.
   */
  public static Map<String, String> buildBaseContextV2(
    String logicalTableName,
    String partitionKeyName,
    String sortKeyName,
    Map<String, AttributeValue> item
  ) {
    Map<String, String> context = new LinkedHashMap<>();
    context.put(EC_TABLE_NAME, logicalTableName);
    context.put(EC_PARTITION_NAME, partitionKeyName);

    if (sortKeyName != null && !sortKeyName.isEmpty()) {
      context.put(EC_SORT_NAME, sortKeyName);
    }

    // V2: include key attribute values in encryption context
    AttributeValue pkValue = item.get(partitionKeyName);
    if (pkValue != null) {
      context.put(EC_ATTR_PREFIX + partitionKeyName, encodeTerminalV1(pkValue));
    }
    if (sortKeyName != null && !sortKeyName.isEmpty()) {
      AttributeValue skValue = item.get(sortKeyName);
      if (skValue != null) {
        context.put(EC_ATTR_PREFIX + sortKeyName, encodeTerminalV1(skValue));
      }
    }

    return context;
  }

  /**
   * Validate that attribute actions cover all attributes in the item.
   *
   * //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
   * //# The Attributes Actions configured on this Item Encryptor MUST specify a Crypto Action
   * //# for every attribute in the input DynamoDB Item.
   */
  public static void validateAttributeActions(
    Map<String, AttributeValue> item,
    Map<String, CryptoAction> actions,
    String allowedUnsignedPrefix
  ) {
    for (String attrName : item.keySet()) {
      if (actions.containsKey(attrName)) continue;
      // Check if it's covered by the unsigned prefix
      if (allowedUnsignedPrefix != null && attrName.startsWith(allowedUnsignedPrefix)) continue;
      // Beacon attributes added by the SDK are implicitly SIGN_ONLY
      if (attrName.startsWith("aws_dbe_b_")) continue;
      throw new IllegalArgumentException(
        "No Crypto Action configured for attribute: " + attrName);
    }
  }

  /**
   * Determine the configuration version based on attribute actions.
   *
   * //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#configuration-version
   * //# If any of the Attribute Actions are configured as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT
   * //# then the configuration version MUST be 2; otherwise, the configuration version MUST be 1.
   */
  public static int getConfigVersion(Map<String, CryptoAction> actions) {
    for (CryptoAction action : actions.values()) {
      if (CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.equals(action)) {
        return 2;
      }
    }
    return 1;
  }

  /**
   * Encode a terminal value for Version 1 encryption context.
   *
   * //= specification/dynamodb-encryption-client/encrypt-item.md#base-context-value-version-1
   * //# The value MUST be the UTF8 Encoding of the Base 64 encoded,
   * //# of the concatenation of the bytes typeID + serializedValue.
   */
  private static String encodeTerminalV1(AttributeValue av) {
    StructuredDataTerminal terminal = DynamoDbItemConverter.serializeAttr(av);
    byte[] typeId = toBytes(terminal.typeId());
    byte[] value = toBytes(terminal.value());
    byte[] combined = new byte[typeId.length + value.length];
    System.arraycopy(typeId, 0, combined, 0, typeId.length);
    System.arraycopy(value, 0, combined, typeId.length, value.length);
    return Base64.getEncoder().encodeToString(combined);
  }

  private static byte[] toBytes(ByteBuffer buf) {
    if (buf == null) return new byte[0];
    buf = buf.asReadOnlyBuffer();
    byte[] arr = new byte[buf.remaining()];
    buf.get(arr);
    return arr;
  }
}
