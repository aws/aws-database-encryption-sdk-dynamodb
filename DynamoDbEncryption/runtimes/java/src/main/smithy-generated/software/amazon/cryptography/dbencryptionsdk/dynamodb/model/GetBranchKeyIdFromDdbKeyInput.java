// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Map;
import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * Inputs for getting the Branch Key that should be used for wrapping and unwrapping data keys.
 */
public class GetBranchKeyIdFromDdbKeyInput {

  /**
   * The partition and sort (if it exists) attributes on the item being read or written, along with the values of any attributes configured as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.
   */
  private final Map<String, AttributeValue> ddbKey;

  protected GetBranchKeyIdFromDdbKeyInput(BuilderImpl builder) {
    this.ddbKey = builder.ddbKey();
  }

  /**
   * @return The partition and sort (if it exists) attributes on the item being read or written, along with the values of any attributes configured as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.
   */
  public Map<String, AttributeValue> ddbKey() {
    return this.ddbKey;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param ddbKey The partition and sort (if it exists) attributes on the item being read or written, along with the values of any attributes configured as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.
     */
    Builder ddbKey(Map<String, AttributeValue> ddbKey);

    /**
     * @return The partition and sort (if it exists) attributes on the item being read or written, along with the values of any attributes configured as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.
     */
    Map<String, AttributeValue> ddbKey();

    GetBranchKeyIdFromDdbKeyInput build();
  }

  static class BuilderImpl implements Builder {

    protected Map<String, AttributeValue> ddbKey;

    protected BuilderImpl() {}

    protected BuilderImpl(GetBranchKeyIdFromDdbKeyInput model) {
      this.ddbKey = model.ddbKey();
    }

    public Builder ddbKey(Map<String, AttributeValue> ddbKey) {
      this.ddbKey = ddbKey;
      return this;
    }

    public Map<String, AttributeValue> ddbKey() {
      return this.ddbKey;
    }

    public GetBranchKeyIdFromDdbKeyInput build() {
      if (Objects.isNull(this.ddbKey())) {
        throw new IllegalArgumentException(
          "Missing value for required field `ddbKey`"
        );
      }
      return new GetBranchKeyIdFromDdbKeyInput(this);
    }
  }
}
