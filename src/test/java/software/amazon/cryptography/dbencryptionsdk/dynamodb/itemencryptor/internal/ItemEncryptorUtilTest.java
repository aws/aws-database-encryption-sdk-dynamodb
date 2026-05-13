// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internal;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

import static org.junit.jupiter.api.Assertions.*;

class ItemEncryptorUtilTest {

  @Test
  void baseContextV1WithPartitionKeyOnly() {
    Map<String, AttributeValue> item = new HashMap<>();
    item.put("pk", AttributeValue.fromS("myKey"));
    item.put("data", AttributeValue.fromS("value"));

    Map<String, String> ctx = ItemEncryptorUtil.buildBaseContextV1("MyTable", "pk", null, item);

    assertEquals("MyTable", ctx.get("aws-crypto-table-name"));
    assertEquals("pk", ctx.get("aws-crypto-partition-name"));
    assertNotNull(ctx.get("aws-crypto-attr.pk"));
    assertFalse(ctx.containsKey("aws-crypto-sort-name"));
  }

  @Test
  void baseContextV1WithSortKey() {
    Map<String, AttributeValue> item = new HashMap<>();
    item.put("pk", AttributeValue.fromS("myKey"));
    item.put("sk", AttributeValue.fromN("42"));

    Map<String, String> ctx = ItemEncryptorUtil.buildBaseContextV1("MyTable", "pk", "sk", item);

    assertEquals("MyTable", ctx.get("aws-crypto-table-name"));
    assertEquals("pk", ctx.get("aws-crypto-partition-name"));
    assertEquals("sk", ctx.get("aws-crypto-sort-name"));
    assertNotNull(ctx.get("aws-crypto-attr.pk"));
    assertNotNull(ctx.get("aws-crypto-attr.sk"));
  }

  @Test
  void baseContextV2DoesNotIncludeKeyValues() {
    Map<String, AttributeValue> item = new HashMap<>();
    item.put("pk", AttributeValue.fromS("myKey"));
    item.put("sk", AttributeValue.fromS("mySort"));

    Map<String, String> ctx = ItemEncryptorUtil.buildBaseContextV2("MyTable", "pk", "sk", item);

    assertEquals("MyTable", ctx.get("aws-crypto-table-name"));
    assertEquals("pk", ctx.get("aws-crypto-partition-name"));
    assertEquals("sk", ctx.get("aws-crypto-sort-name"));
    // V2 does NOT include key values in base context
    assertFalse(ctx.containsKey("aws-crypto-attr.pk"));
    assertFalse(ctx.containsKey("aws-crypto-attr.sk"));
  }

  @Test
  void configVersionDetection() {
    Map<String, CryptoAction> actions1 = new HashMap<>();
    actions1.put("pk", CryptoAction.SIGN_ONLY);
    actions1.put("data", CryptoAction.ENCRYPT_AND_SIGN);
    assertEquals(1, ItemEncryptorUtil.getConfigVersion(actions1));

    Map<String, CryptoAction> actions2 = new HashMap<>();
    actions2.put("pk", CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT);
    actions2.put("data", CryptoAction.ENCRYPT_AND_SIGN);
    assertEquals(2, ItemEncryptorUtil.getConfigVersion(actions2));
  }

  @Test
  void validateAttributeActionsFailsOnMissing() {
    Map<String, AttributeValue> item = new HashMap<>();
    item.put("pk", AttributeValue.fromS("key"));
    item.put("unknown", AttributeValue.fromS("val"));

    Map<String, CryptoAction> actions = new HashMap<>();
    actions.put("pk", CryptoAction.SIGN_ONLY);

    assertThrows(IllegalArgumentException.class, () ->
      ItemEncryptorUtil.validateAttributeActions(item, actions, null));
  }

  @Test
  void validateAttributeActionsPassesWithPrefix() {
    Map<String, AttributeValue> item = new HashMap<>();
    item.put("pk", AttributeValue.fromS("key"));
    item.put(":prefix_attr", AttributeValue.fromS("val"));

    Map<String, CryptoAction> actions = new HashMap<>();
    actions.put("pk", CryptoAction.SIGN_ONLY);

    // Should not throw because :prefix_attr starts with the allowed prefix
    assertDoesNotThrow(() ->
      ItemEncryptorUtil.validateAttributeActions(item, actions, ":prefix_"));
  }

  @Test
  void missingPartitionKeyThrows() {
    Map<String, AttributeValue> item = new HashMap<>();
    item.put("data", AttributeValue.fromS("value"));

    assertThrows(IllegalArgumentException.class, () ->
      ItemEncryptorUtil.buildBaseContextV1("Table", "pk", null, item));
  }
}
