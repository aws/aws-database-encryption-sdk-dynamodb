// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;

public class UpdateItemInputTransformInput {

  /**
   * <p>Represents the input of an <code>UpdateItem</code> operation.</p>
   */
  private final UpdateItemRequest sdkInput;

  protected UpdateItemInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  /**
   * @return <p>Represents the input of an <code>UpdateItem</code> operation.</p>
   */
  public UpdateItemRequest sdkInput() {
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
     * @param sdkInput <p>Represents the input of an <code>UpdateItem</code> operation.</p>
     */
    Builder sdkInput(UpdateItemRequest sdkInput);

    /**
     * @return <p>Represents the input of an <code>UpdateItem</code> operation.</p>
     */
    UpdateItemRequest sdkInput();

    UpdateItemInputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected UpdateItemRequest sdkInput;

    protected BuilderImpl() {}

    protected BuilderImpl(UpdateItemInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(UpdateItemRequest sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public UpdateItemRequest sdkInput() {
      return this.sdkInput;
    }

    public UpdateItemInputTransformInput build() {
      if (Objects.isNull(this.sdkInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `sdkInput`"
        );
      }
      return new UpdateItemInputTransformInput(this);
    }
  }
}
