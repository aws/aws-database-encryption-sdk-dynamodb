// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;
import software.amazon.cryptography.materialproviders.BranchKeyIdSupplier;
import software.amazon.cryptography.materialproviders.IBranchKeyIdSupplier;

/**
 * Outputs for creating a Branch Key Supplier from a DynamoDB Key Branch Key Id Supplier
 */
public class CreateDynamoDbEncryptionBranchKeyIdSupplierOutput {

  /**
   * The Branch Key Supplier for use with the Hierarchical Keyring.
   */
  private final IBranchKeyIdSupplier branchKeyIdSupplier;

  protected CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
    BuilderImpl builder
  ) {
    this.branchKeyIdSupplier = builder.branchKeyIdSupplier();
  }

  /**
   * @return The Branch Key Supplier for use with the Hierarchical Keyring.
   */
  public IBranchKeyIdSupplier branchKeyIdSupplier() {
    return this.branchKeyIdSupplier;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param branchKeyIdSupplier The Branch Key Supplier for use with the Hierarchical Keyring.
     */
    Builder branchKeyIdSupplier(IBranchKeyIdSupplier branchKeyIdSupplier);

    /**
     * @return The Branch Key Supplier for use with the Hierarchical Keyring.
     */
    IBranchKeyIdSupplier branchKeyIdSupplier();

    CreateDynamoDbEncryptionBranchKeyIdSupplierOutput build();
  }

  static class BuilderImpl implements Builder {

    protected IBranchKeyIdSupplier branchKeyIdSupplier;

    protected BuilderImpl() {}

    protected BuilderImpl(
      CreateDynamoDbEncryptionBranchKeyIdSupplierOutput model
    ) {
      this.branchKeyIdSupplier = model.branchKeyIdSupplier();
    }

    public Builder branchKeyIdSupplier(
      IBranchKeyIdSupplier branchKeyIdSupplier
    ) {
      this.branchKeyIdSupplier = BranchKeyIdSupplier.wrap(branchKeyIdSupplier);
      return this;
    }

    public IBranchKeyIdSupplier branchKeyIdSupplier() {
      return this.branchKeyIdSupplier;
    }

    public CreateDynamoDbEncryptionBranchKeyIdSupplierOutput build() {
      if (Objects.isNull(this.branchKeyIdSupplier())) {
        throw new IllegalArgumentException(
          "Missing value for required field `branchKeyIdSupplier`"
        );
      }
      return new CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(this);
    }
  }
}
