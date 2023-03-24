// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.resources.model;

import java.util.Objects;
import software.amazon.cryptography.dynamoDbEncryption.resources.DynamoDbItemBranchKeyIdSupplier;
import software.amazon.cryptography.dynamoDbEncryption.resources.IDynamoDbItemBranchKeyIdSupplier;

public class CreateDynamoDbEncryptionBranchKeyIdSupplierInput {
  private final DynamoDbItemBranchKeyIdSupplier ddbItemBranchKeyIdSupplier;

  protected CreateDynamoDbEncryptionBranchKeyIdSupplierInput(BuilderImpl builder) {
    this.ddbItemBranchKeyIdSupplier = builder.ddbItemBranchKeyIdSupplier();
  }

  public DynamoDbItemBranchKeyIdSupplier ddbItemBranchKeyIdSupplier() {
    return this.ddbItemBranchKeyIdSupplier;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder ddbItemBranchKeyIdSupplier(IDynamoDbItemBranchKeyIdSupplier ddbItemBranchKeyIdSupplier);

    DynamoDbItemBranchKeyIdSupplier ddbItemBranchKeyIdSupplier();

    CreateDynamoDbEncryptionBranchKeyIdSupplierInput build();
  }

  static class BuilderImpl implements Builder {
    protected DynamoDbItemBranchKeyIdSupplier ddbItemBranchKeyIdSupplier;

    protected BuilderImpl() {
    }

    protected BuilderImpl(CreateDynamoDbEncryptionBranchKeyIdSupplierInput model) {
      this.ddbItemBranchKeyIdSupplier = model.ddbItemBranchKeyIdSupplier();
    }

    public Builder ddbItemBranchKeyIdSupplier(
        IDynamoDbItemBranchKeyIdSupplier ddbItemBranchKeyIdSupplier) {
      this.ddbItemBranchKeyIdSupplier = DynamoDbItemBranchKeyIdSupplier.wrap(ddbItemBranchKeyIdSupplier);
      return this;
    }

    public DynamoDbItemBranchKeyIdSupplier ddbItemBranchKeyIdSupplier() {
      return this.ddbItemBranchKeyIdSupplier;
    }

    public CreateDynamoDbEncryptionBranchKeyIdSupplierInput build() {
      if (Objects.isNull(this.ddbItemBranchKeyIdSupplier()))  {
        throw new IllegalArgumentException("Missing value for required field `ddbItemBranchKeyIdSupplier`");
      }
      return new CreateDynamoDbEncryptionBranchKeyIdSupplierInput(this);
    }
  }
}
