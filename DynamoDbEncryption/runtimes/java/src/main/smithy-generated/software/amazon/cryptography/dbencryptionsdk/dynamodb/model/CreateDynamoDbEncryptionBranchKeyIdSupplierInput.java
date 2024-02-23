// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbKeyBranchKeyIdSupplier;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.IDynamoDbKeyBranchKeyIdSupplier;

/**
 * Inputs for creating a Branch Key Supplier from a DynamoDB Key Branch Key Id Supplier
 */
public class CreateDynamoDbEncryptionBranchKeyIdSupplierInput {

  /**
   * An implementation of the DynamoDbKeyBranchKeyIdSupplier interface, which determines what Branch Key to use for data key wrapping/unwrapping based on the DynamoDB item being written/read.
   */
  private final IDynamoDbKeyBranchKeyIdSupplier ddbKeyBranchKeyIdSupplier;

  protected CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
    BuilderImpl builder
  ) {
    this.ddbKeyBranchKeyIdSupplier = builder.ddbKeyBranchKeyIdSupplier();
  }

  /**
   * @return An implementation of the DynamoDbKeyBranchKeyIdSupplier interface, which determines what Branch Key to use for data key wrapping/unwrapping based on the DynamoDB item being written/read.
   */
  public IDynamoDbKeyBranchKeyIdSupplier ddbKeyBranchKeyIdSupplier() {
    return this.ddbKeyBranchKeyIdSupplier;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param ddbKeyBranchKeyIdSupplier An implementation of the DynamoDbKeyBranchKeyIdSupplier interface, which determines what Branch Key to use for data key wrapping/unwrapping based on the DynamoDB item being written/read.
     */
    Builder ddbKeyBranchKeyIdSupplier(
      IDynamoDbKeyBranchKeyIdSupplier ddbKeyBranchKeyIdSupplier
    );

    /**
     * @return An implementation of the DynamoDbKeyBranchKeyIdSupplier interface, which determines what Branch Key to use for data key wrapping/unwrapping based on the DynamoDB item being written/read.
     */
    IDynamoDbKeyBranchKeyIdSupplier ddbKeyBranchKeyIdSupplier();

    CreateDynamoDbEncryptionBranchKeyIdSupplierInput build();
  }

  static class BuilderImpl implements Builder {

    protected IDynamoDbKeyBranchKeyIdSupplier ddbKeyBranchKeyIdSupplier;

    protected BuilderImpl() {}

    protected BuilderImpl(
      CreateDynamoDbEncryptionBranchKeyIdSupplierInput model
    ) {
      this.ddbKeyBranchKeyIdSupplier = model.ddbKeyBranchKeyIdSupplier();
    }

    public Builder ddbKeyBranchKeyIdSupplier(
      IDynamoDbKeyBranchKeyIdSupplier ddbKeyBranchKeyIdSupplier
    ) {
      this.ddbKeyBranchKeyIdSupplier =
        DynamoDbKeyBranchKeyIdSupplier.wrap(ddbKeyBranchKeyIdSupplier);
      return this;
    }

    public IDynamoDbKeyBranchKeyIdSupplier ddbKeyBranchKeyIdSupplier() {
      return this.ddbKeyBranchKeyIdSupplier;
    }

    public CreateDynamoDbEncryptionBranchKeyIdSupplierInput build() {
      if (Objects.isNull(this.ddbKeyBranchKeyIdSupplier())) {
        throw new IllegalArgumentException(
          "Missing value for required field `ddbKeyBranchKeyIdSupplier`"
        );
      }
      return new CreateDynamoDbEncryptionBranchKeyIdSupplierInput(this);
    }
  }
}
