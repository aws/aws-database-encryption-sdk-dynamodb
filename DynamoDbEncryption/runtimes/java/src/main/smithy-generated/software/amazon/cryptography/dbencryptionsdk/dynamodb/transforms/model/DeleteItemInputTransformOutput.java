// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;

public class DeleteItemInputTransformOutput {

  /**
   * <p>Represents the input of a <code>DeleteItem</code> operation.</p>
   */
  private final DeleteItemRequest transformedInput;

  protected DeleteItemInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  /**
   * @return <p>Represents the input of a <code>DeleteItem</code> operation.</p>
   */
  public DeleteItemRequest transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param transformedInput <p>Represents the input of a <code>DeleteItem</code> operation.</p>
     */
    Builder transformedInput(DeleteItemRequest transformedInput);

    /**
     * @return <p>Represents the input of a <code>DeleteItem</code> operation.</p>
     */
    DeleteItemRequest transformedInput();

    DeleteItemInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected DeleteItemRequest transformedInput;

    protected BuilderImpl() {}

    protected BuilderImpl(DeleteItemInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(DeleteItemRequest transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public DeleteItemRequest transformedInput() {
      return this.transformedInput;
    }

    public DeleteItemInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedInput`"
        );
      }
      return new DeleteItemInputTransformOutput(this);
    }
  }
}
