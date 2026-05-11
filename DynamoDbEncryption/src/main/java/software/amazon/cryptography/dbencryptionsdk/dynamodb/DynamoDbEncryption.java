// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionOutput;

public class DynamoDbEncryption {

  protected DynamoDbEncryption(BuilderImpl builder) {
    // TODO: Phase 5 — initialize native implementation
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public CreateDynamoDbEncryptionBranchKeyIdSupplierOutput CreateDynamoDbEncryptionBranchKeyIdSupplier(
    CreateDynamoDbEncryptionBranchKeyIdSupplierInput input
  ) {
    throw new UnsupportedOperationException("Not yet implemented — Phase 5");
  }

  public GetEncryptedDataKeyDescriptionOutput GetEncryptedDataKeyDescription(
    GetEncryptedDataKeyDescriptionInput input
  ) {
    throw new UnsupportedOperationException("Not yet implemented — Phase 5");
  }

  public interface Builder {
    Builder DynamoDbEncryptionConfig(DynamoDbEncryptionConfig DynamoDbEncryptionConfig);
    DynamoDbEncryptionConfig DynamoDbEncryptionConfig();
    DynamoDbEncryption build();
  }

  static class BuilderImpl implements Builder {

    protected DynamoDbEncryptionConfig DynamoDbEncryptionConfig;

    protected BuilderImpl() {}

    public Builder DynamoDbEncryptionConfig(DynamoDbEncryptionConfig DynamoDbEncryptionConfig) {
      this.DynamoDbEncryptionConfig = DynamoDbEncryptionConfig;
      return this;
    }

    public DynamoDbEncryptionConfig DynamoDbEncryptionConfig() {
      return this.DynamoDbEncryptionConfig;
    }

    public DynamoDbEncryption build() {
      if (Objects.isNull(this.DynamoDbEncryptionConfig())) {
        throw new IllegalArgumentException(
          "Missing value for required field `DynamoDbEncryptionConfig`"
        );
      }
      return new DynamoDbEncryption(this);
    }
  }
}
