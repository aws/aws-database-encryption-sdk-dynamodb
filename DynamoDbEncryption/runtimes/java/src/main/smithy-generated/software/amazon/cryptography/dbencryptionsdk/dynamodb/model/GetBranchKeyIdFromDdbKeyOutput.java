// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

/**
 * Outputs for getting the Branch Key that should be used for wrapping and unwrapping data keys.
 */
public class GetBranchKeyIdFromDdbKeyOutput {

  /**
   * The ID of the Branch Key that should be used to wrap and unwrap data keys for this item.
   */
  private final String branchKeyId;

  protected GetBranchKeyIdFromDdbKeyOutput(BuilderImpl builder) {
    this.branchKeyId = builder.branchKeyId();
  }

  /**
   * @return The ID of the Branch Key that should be used to wrap and unwrap data keys for this item.
   */
  public String branchKeyId() {
    return this.branchKeyId;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param branchKeyId The ID of the Branch Key that should be used to wrap and unwrap data keys for this item.
     */
    Builder branchKeyId(String branchKeyId);

    /**
     * @return The ID of the Branch Key that should be used to wrap and unwrap data keys for this item.
     */
    String branchKeyId();

    GetBranchKeyIdFromDdbKeyOutput build();
  }

  static class BuilderImpl implements Builder {

    protected String branchKeyId;

    protected BuilderImpl() {}

    protected BuilderImpl(GetBranchKeyIdFromDdbKeyOutput model) {
      this.branchKeyId = model.branchKeyId();
    }

    public Builder branchKeyId(String branchKeyId) {
      this.branchKeyId = branchKeyId;
      return this;
    }

    public String branchKeyId() {
      return this.branchKeyId;
    }

    public GetBranchKeyIdFromDdbKeyOutput build() {
      if (Objects.isNull(this.branchKeyId())) {
        throw new IllegalArgumentException(
          "Missing value for required field `branchKeyId`"
        );
      }
      return new GetBranchKeyIdFromDdbKeyOutput(this);
    }
  }
}
