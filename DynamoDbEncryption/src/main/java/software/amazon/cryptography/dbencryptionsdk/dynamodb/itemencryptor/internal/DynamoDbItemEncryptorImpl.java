// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internal.DynamoDbItemConverter;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.StructuredEncryptionImpl;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptPathStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;

/**
 * Native implementation of the DynamoDB Item Encryptor.
 *
 * //= specification/dynamodb-encryption-client/ddb-item-encryptor.md#overview
 * //# It is responsible for the encryption and decryption of DynamoDB Items
 * //# for a particular DynamoDB Table.
 */
public final class DynamoDbItemEncryptorImpl {

  private final DynamoDbItemEncryptorConfig config;
  private final ICryptographicMaterialsManager cmm;
  private final Map<String, CryptoAction> attributeActions;

  public DynamoDbItemEncryptorImpl(DynamoDbItemEncryptorConfig config, ICryptographicMaterialsManager cmm) {
    this.config = config;
    this.cmm = cmm;
    this.attributeActions = buildActionMap(config);
  }

  /**
   * //= specification/dynamodb-encryption-client/ddb-item-encryptor.md#encryptitem
   * //# The DynamoDB Item Encryptor MUST provide a function that adheres to EncryptItem.
   */
  public EncryptItemOutput encryptItem(EncryptItemInput input) {
    Map<String, AttributeValue> item = input.plaintextItem();

    // Validate partition key present
    if (!item.containsKey(config.partitionKeyName())) {
      throw new IllegalArgumentException("Item missing partition key: " + config.partitionKeyName());
    }
    // Validate sort key if configured
    if (config.sortKeyName() != null && !item.containsKey(config.sortKeyName())) {
      throw new IllegalArgumentException("Item missing sort key: " + config.sortKeyName());
    }

    // Validate attribute actions cover all attributes
    ItemEncryptorUtil.validateAttributeActions(item, attributeActions, config.allowedUnsignedAttributePrefix());

    // Determine config version and build base context
    int version = ItemEncryptorUtil.getConfigVersion(attributeActions);
    Map<String, String> baseContext;
    if (version == 2) {
      baseContext = ItemEncryptorUtil.buildBaseContextV2(
        config.logicalTableName(), config.partitionKeyName(), config.sortKeyName(), item);
    } else {
      baseContext = ItemEncryptorUtil.buildBaseContextV1(
        config.logicalTableName(), config.partitionKeyName(), config.sortKeyName(), item);
    }

    // Convert DDB item to CryptoList
    List<CryptoItem> cryptoList = DynamoDbItemConverter.itemToCryptoList(item, attributeActions);

    // Delegate to StructuredEncryption
    EncryptPathStructureOutput seOutput = StructuredEncryptionImpl.encryptPathStructure(
      config.logicalTableName(),
      cryptoList,
      cmm,
      config.algorithmSuiteId(),
      baseContext
    );

    // Convert back to DDB item
    Map<String, AttributeValue> encryptedItem = DynamoDbItemConverter.cryptoListToItem(seOutput.encryptedStructure());

    // Add header and footer as binary attributes
    for (CryptoItem ci : seOutput.encryptedStructure()) {
      String name = ci.key().get(0).member().key();
      if ("aws_dbe_head".equals(name) || "aws_dbe_foot".equals(name)) {
        byte[] value = toBytes(ci.data().value());
        encryptedItem.put(name, AttributeValue.fromB(software.amazon.awssdk.core.SdkBytes.fromByteArray(value)));
      }
    }

    return EncryptItemOutput.builder()
      .encryptedItem(encryptedItem)
      .parsedHeader(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.ParsedHeader.builder()
        .algorithmSuiteId(seOutput.parsedHeader().algorithmSuiteId())
        .encryptedDataKeys(seOutput.parsedHeader().encryptedDataKeys())
        .storedEncryptionContext(seOutput.parsedHeader().storedEncryptionContext())
        .encryptionContext(seOutput.parsedHeader().encryptionContext())
        .attributeActionsOnEncrypt(config.attributeActionsOnEncrypt())
        .selectorContext(new HashMap<>())
        .build())
      .build();
  }

  /**
   * //= specification/dynamodb-encryption-client/ddb-item-encryptor.md#decryptitem
   * //# The DynamoDB Item Encryptor MUST provide a function that adheres to DecryptItem.
   */
  public DecryptItemOutput decryptItem(DecryptItemInput input) {
    Map<String, AttributeValue> item = input.encryptedItem();

    // Validate partition key present
    if (!item.containsKey(config.partitionKeyName())) {
      throw new IllegalArgumentException("Item missing partition key: " + config.partitionKeyName());
    }
    if (config.sortKeyName() != null && !item.containsKey(config.sortKeyName())) {
      throw new IllegalArgumentException("Item missing sort key: " + config.sortKeyName());
    }

    // Determine plaintext items (no aws_dbe_head/foot)
    if (!item.containsKey("aws_dbe_head") || !item.containsKey("aws_dbe_foot")) {
      // Plaintext item — passthrough
      return DecryptItemOutput.builder().plaintextItem(item).build();
    }

    // Determine version from header first byte
    byte[] headerBytes = item.get("aws_dbe_head").b().asByteArray();
    byte version = headerBytes[0];

    // Build base context
    int configVersion = (version == 0x02) ? 2 : 1;
    Map<String, String> baseContext;
    if (configVersion == 2) {
      baseContext = ItemEncryptorUtil.buildBaseContextV2(
        config.logicalTableName(), config.partitionKeyName(), config.sortKeyName(), item);
    } else {
      baseContext = ItemEncryptorUtil.buildBaseContextV1(
        config.logicalTableName(), config.partitionKeyName(), config.sortKeyName(), item);
    }

    // Convert DDB item to AuthList
    List<software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthItem> authList = new java.util.ArrayList<>();
    for (Map.Entry<String, AttributeValue> entry : item.entrySet()) {
      String name = entry.getKey();
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateAction action =
        isInSignatureScope(name)
          ? software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateAction.SIGN
          : software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateAction.DO_NOT_SIGN;

      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal terminal =
        DynamoDbItemConverter.serializeAttr(entry.getValue());

      List<software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.PathSegment> path =
        java.util.Collections.singletonList(
          software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.PathSegment.builder()
            .member(software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructureSegment.builder().key(name).build())
            .build());

      authList.add(software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthItem.builder()
        .key(path).data(terminal).action(action).build());
    }

    // Delegate to StructuredEncryption decrypt
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptPathStructureOutput seOutput =
      StructuredEncryptionImpl.decryptPathStructure(
        config.logicalTableName(),
        authList,
        cmm,
        baseContext
      );

    // Convert back to DDB item
    Map<String, AttributeValue> decryptedItem = DynamoDbItemConverter.cryptoListToItem(seOutput.plaintextStructure());

    return DecryptItemOutput.builder()
      .plaintextItem(decryptedItem)
      .parsedHeader(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.ParsedHeader.builder()
        .algorithmSuiteId(seOutput.parsedHeader().algorithmSuiteId())
        .encryptedDataKeys(seOutput.parsedHeader().encryptedDataKeys())
        .storedEncryptionContext(seOutput.parsedHeader().storedEncryptionContext())
        .encryptionContext(seOutput.parsedHeader().encryptionContext())
        .attributeActionsOnEncrypt(config.attributeActionsOnEncrypt())
        .selectorContext(new HashMap<>())
        .build())
      .build();
  }

  private boolean isInSignatureScope(String attrName) {
    // Unauthenticated attributes
    if (config.allowedUnsignedAttributes() != null && config.allowedUnsignedAttributes().contains(attrName)) {
      return false;
    }
    if (config.allowedUnsignedAttributePrefix() != null && attrName.startsWith(config.allowedUnsignedAttributePrefix())) {
      return false;
    }
    return true;
  }

  private Map<String, CryptoAction> buildActionMap(DynamoDbItemEncryptorConfig config) {
    Map<String, CryptoAction> actions = new HashMap<>();
    if (config.attributeActionsOnEncrypt() != null) {
      actions.putAll(config.attributeActionsOnEncrypt());
    }
    // Key attributes get the key action
    CryptoAction keyAction = (ItemEncryptorUtil.getConfigVersion(actions) == 2)
      ? CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT
      : CryptoAction.SIGN_ONLY;
    actions.put(config.partitionKeyName(), keyAction);
    if (config.sortKeyName() != null) {
      actions.put(config.sortKeyName(), keyAction);
    }
    return actions;
  }

  private static byte[] toBytes(java.nio.ByteBuffer buf) {
    if (buf == null) return new byte[0];
    buf = buf.asReadOnlyBuffer();
    byte[] arr = new byte[buf.remaining()];
    buf.get(arr);
    return arr;
  }
}
