// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internal;

import java.util.HashMap;
import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;

/**
 * Holds per-table item encryptors, constructed from the tables encryption config.
 */
public final class TransformConfig {

  private final Map<String, DynamoDbItemEncryptor> tableEncryptors;

  public TransformConfig(DynamoDbTablesEncryptionConfig config) {
    this.tableEncryptors = new HashMap<>();
    if (config.tableEncryptionConfigs() != null) {
      for (Map.Entry<String, DynamoDbTableEncryptionConfig> entry : config.tableEncryptionConfigs().entrySet()) {
        String tableName = entry.getKey();
        DynamoDbTableEncryptionConfig tableConfig = entry.getValue();
        DynamoDbItemEncryptor encryptor = DynamoDbItemEncryptor.builder()
          .DynamoDbItemEncryptorConfig(DynamoDbItemEncryptorConfig.builder()
            .logicalTableName(tableConfig.logicalTableName() != null ? tableConfig.logicalTableName() : tableName)
            .partitionKeyName(tableConfig.partitionKeyName())
            .sortKeyName(tableConfig.sortKeyName())
            .attributeActionsOnEncrypt(tableConfig.attributeActionsOnEncrypt())
            .allowedUnsignedAttributes(tableConfig.allowedUnsignedAttributes())
            .allowedUnsignedAttributePrefix(tableConfig.allowedUnsignedAttributePrefix())
            .algorithmSuiteId(tableConfig.algorithmSuiteId())
            .keyring(tableConfig.keyring())
            .cmm(tableConfig.cmm())
            .build())
          .build();
        tableEncryptors.put(tableName, encryptor);
      }
    }
  }

  /** Get the encryptor for a table, or null if the table is not encrypted. */
  public DynamoDbItemEncryptor getEncryptor(String tableName) {
    return tableEncryptors.get(tableName);
  }

  /** Check if a table is configured for encryption. */
  public boolean isEncryptedTable(String tableName) {
    return tableEncryptors.containsKey(tableName);
  }
}
