// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import java.util.Objects;
import software.amazon.cryptography.materialProviders.BranchKeyIdSupplier;
import software.amazon.cryptography.materialProviders.IBranchKeyIdSupplier;

public class CreateDynamoDbEncryptionBranchKeyIdSupplierOutput {
  private final BranchKeyIdSupplier branchKeyIdSupplier;

  protected CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(BuilderImpl builder) {
    this.branchKeyIdSupplier = builder.branchKeyIdSupplier();
  }

  public BranchKeyIdSupplier branchKeyIdSupplier() {
    return this.branchKeyIdSupplier;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder branchKeyIdSupplier(IBranchKeyIdSupplier branchKeyIdSupplier);

    BranchKeyIdSupplier branchKeyIdSupplier();

    CreateDynamoDbEncryptionBranchKeyIdSupplierOutput build();
  }

  static class BuilderImpl implements Builder {
    protected BranchKeyIdSupplier branchKeyIdSupplier;

    protected BuilderImpl() {
    }

    protected BuilderImpl(CreateDynamoDbEncryptionBranchKeyIdSupplierOutput model) {
      this.branchKeyIdSupplier = model.branchKeyIdSupplier();
    }

    public Builder branchKeyIdSupplier(IBranchKeyIdSupplier branchKeyIdSupplier) {
      this.branchKeyIdSupplier = BranchKeyIdSupplier.wrap(branchKeyIdSupplier);
      return this;
    }

    public BranchKeyIdSupplier branchKeyIdSupplier() {
      return this.branchKeyIdSupplier;
    }

    public CreateDynamoDbEncryptionBranchKeyIdSupplierOutput build() {
      if (Objects.isNull(this.branchKeyIdSupplier()))  {
        throw new IllegalArgumentException("Missing value for required field `branchKeyIdSupplier`");
      }
      return new CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(this);
    }
  }
}
