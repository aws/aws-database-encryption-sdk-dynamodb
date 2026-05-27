// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internal;

import java.util.HashMap;
import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internal.BeaconConfigResolver;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;

/**
 * Holds per-table item encryptors and search info, constructed from the tables encryption config.
 */
public final class TransformConfig {

  private final Map<String, DynamoDbItemEncryptor> tableEncryptors;
  private final Map<String, BeaconConfigResolver.SearchInfo> tableSearchInfo;
  private final Map<String, DynamoDbTableEncryptionConfig> tableConfigs;

  public TransformConfig(DynamoDbTablesEncryptionConfig config) {
    this.tableEncryptors = new HashMap<>();
    this.tableSearchInfo = new HashMap<>();
    this.tableConfigs = new HashMap<>();
    if (config.tableEncryptionConfigs() != null) {
      for (Map.Entry<String, DynamoDbTableEncryptionConfig> entry : config.tableEncryptionConfigs().entrySet()) {
        String tableName = entry.getKey();
        DynamoDbTableEncryptionConfig tableConfig = entry.getValue();
        tableConfigs.put(tableName, tableConfig);
        DynamoDbItemEncryptorConfig.Builder configBuilder = DynamoDbItemEncryptorConfig.builder()
            .logicalTableName(tableConfig.logicalTableName() != null ? tableConfig.logicalTableName() : tableName)
            .partitionKeyName(tableConfig.partitionKeyName())
            .sortKeyName(tableConfig.sortKeyName())
            .attributeActionsOnEncrypt(tableConfig.attributeActionsOnEncrypt())
            .allowedUnsignedAttributes(tableConfig.allowedUnsignedAttributes())
            .allowedUnsignedAttributePrefix(tableConfig.allowedUnsignedAttributePrefix())
            .algorithmSuiteId(tableConfig.algorithmSuiteId());
        if (tableConfig.cmm() != null) {
          configBuilder.cmm(tableConfig.cmm());
        }
        if (tableConfig.keyring() != null) {
          configBuilder.keyring(tableConfig.keyring());
        }
        DynamoDbItemEncryptor encryptor = DynamoDbItemEncryptor.builder()
          .DynamoDbItemEncryptorConfig(configBuilder.build())
          .build();
        tableEncryptors.put(tableName, encryptor);

        // Resolve search config if present
        if (tableConfig.search() != null) {
          BeaconConfigResolver.SearchInfo searchInfo = BeaconConfigResolver.resolve(tableConfig.search());
          if (searchInfo != null) {
            tableSearchInfo.put(tableName, searchInfo);
          }
        }
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

  /** Get search info for a table, or null if no beacons configured. */
  public BeaconConfigResolver.SearchInfo getSearchInfo(String tableName) {
    return tableSearchInfo.get(tableName);
  }

  /** Get the raw table config. */
  public DynamoDbTableEncryptionConfig getTableConfig(String tableName) {
    return tableConfigs.get(tableName);
  }
}
