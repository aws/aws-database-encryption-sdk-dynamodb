// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import java.util.Map;
import java.util.Objects;

public class DynamoDbEncryptionConfig {
  private final Map<String, DynamoDbTableEncryptionConfig> tableEncryptionConfigs;

  protected DynamoDbEncryptionConfig(BuilderImpl builder) {
    this.tableEncryptionConfigs = builder.tableEncryptionConfigs();
  }

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
    Builder tableEncryptionConfigs(
        Map<String, DynamoDbTableEncryptionConfig> tableEncryptionConfigs);

    Map<String, DynamoDbTableEncryptionConfig> tableEncryptionConfigs();

    DynamoDbEncryptionConfig build();
  }

  static class BuilderImpl implements Builder {
    protected Map<String, DynamoDbTableEncryptionConfig> tableEncryptionConfigs;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DynamoDbEncryptionConfig model) {
      this.tableEncryptionConfigs = model.tableEncryptionConfigs();
    }

    public Builder tableEncryptionConfigs(
        Map<String, DynamoDbTableEncryptionConfig> tableEncryptionConfigs) {
      this.tableEncryptionConfigs = tableEncryptionConfigs;
      return this;
    }

    public Map<String, DynamoDbTableEncryptionConfig> tableEncryptionConfigs() {
      return this.tableEncryptionConfigs;
    }

    public DynamoDbEncryptionConfig build() {
      if (Objects.isNull(this.tableEncryptionConfigs()))  {
        throw new IllegalArgumentException("Missing value for required field `tableEncryptionConfigs`");
      }
      return new DynamoDbEncryptionConfig(this);
    }
  }
}
