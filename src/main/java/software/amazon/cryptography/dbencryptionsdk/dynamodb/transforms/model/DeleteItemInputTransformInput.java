// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;

public class DeleteItemInputTransformInput {

  /**
   * <p>Represents the input of a <code>DeleteItem</code> operation.</p>
   */
  private final DeleteItemRequest sdkInput;

  protected DeleteItemInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  /**
   * @return <p>Represents the input of a <code>DeleteItem</code> operation.</p>
   */
  public DeleteItemRequest sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param sdkInput <p>Represents the input of a <code>DeleteItem</code> operation.</p>
     */
    Builder sdkInput(DeleteItemRequest sdkInput);

    /**
     * @return <p>Represents the input of a <code>DeleteItem</code> operation.</p>
     */
    DeleteItemRequest sdkInput();

    DeleteItemInputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected DeleteItemRequest sdkInput;

    protected BuilderImpl() {}

    protected BuilderImpl(DeleteItemInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(DeleteItemRequest sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public DeleteItemRequest sdkInput() {
      return this.sdkInput;
    }

    public DeleteItemInputTransformInput build() {
      if (Objects.isNull(this.sdkInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `sdkInput`"
        );
      }
      return new DeleteItemInputTransformInput(this);
    }
  }
}
