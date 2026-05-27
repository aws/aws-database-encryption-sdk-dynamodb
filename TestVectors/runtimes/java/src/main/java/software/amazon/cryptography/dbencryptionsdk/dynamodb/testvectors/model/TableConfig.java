// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.amazon.cryptography.dbencryptionsdk.dynamodb.testvectors.model;

import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;

/**
 * A table encryption configuration with a name and a vanilla flag indicating
 * whether encryption is disabled.
 */
public class TableConfig {

  private final String name;
  private final DynamoDbTableEncryptionConfig config;
  private final boolean vanilla;

  public TableConfig(
    String name,
    DynamoDbTableEncryptionConfig config,
    boolean vanilla
  ) {
    this.name = name;
    this.config = config;
    this.vanilla = vanilla;
  }

  public String getName() {
    return name;
  }

  public DynamoDbTableEncryptionConfig getConfig() {
    return config;
  }

  public boolean isVanilla() {
    return vanilla;
  }

  @Override
  public String toString() {
    return "TableConfig{name='" + name + "', vanilla=" + vanilla + "}";
  }
}
