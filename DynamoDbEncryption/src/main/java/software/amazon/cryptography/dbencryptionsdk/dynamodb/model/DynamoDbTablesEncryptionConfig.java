// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Map;
import java.util.Objects;

/**
 * The configuration for client-side encryption with multiple DynamoDB table.
 */
public class DynamoDbTablesEncryptionConfig {

  /**
   * A map of DynamoDB table name to its configuration for client-side encryption.
   */
  private final Map<
    String,
    DynamoDbTableEncryptionConfig
  > tableEncryptionConfigs;

  protected DynamoDbTablesEncryptionConfig(BuilderImpl builder) {
    this.tableEncryptionConfigs = builder.tableEncryptionConfigs();
  }

  /**
   * @return A map of DynamoDB table name to its configuration for client-side encryption.
   */
  public Map<String, DynamoDbTableEncryptionConfig> tableEncryptionConfigs() {
    return this.tableEncryptionConfigs;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param tableEncryptionConfigs A map of DynamoDB table name to its configuration for client-side encryption.
     */
    Builder tableEncryptionConfigs(
      Map<String, DynamoDbTableEncryptionConfig> tableEncryptionConfigs
    );

    /**
     * @return A map of DynamoDB table name to its configuration for client-side encryption.
     */
    Map<String, DynamoDbTableEncryptionConfig> tableEncryptionConfigs();

    DynamoDbTablesEncryptionConfig build();
  }

  static class BuilderImpl implements Builder {

    protected Map<String, DynamoDbTableEncryptionConfig> tableEncryptionConfigs;

    protected BuilderImpl() {}

    protected BuilderImpl(DynamoDbTablesEncryptionConfig model) {
      this.tableEncryptionConfigs = model.tableEncryptionConfigs();
    }

    public Builder tableEncryptionConfigs(
      Map<String, DynamoDbTableEncryptionConfig> tableEncryptionConfigs
    ) {
      this.tableEncryptionConfigs = tableEncryptionConfigs;
      return this;
    }

    public Map<String, DynamoDbTableEncryptionConfig> tableEncryptionConfigs() {
      return this.tableEncryptionConfigs;
    }

    public DynamoDbTablesEncryptionConfig build() {
      if (Objects.isNull(this.tableEncryptionConfigs())) {
        throw new IllegalArgumentException(
          "Missing value for required field `tableEncryptionConfigs`"
        );
      }
      return new DynamoDbTablesEncryptionConfig(this);
    }
  }
}
