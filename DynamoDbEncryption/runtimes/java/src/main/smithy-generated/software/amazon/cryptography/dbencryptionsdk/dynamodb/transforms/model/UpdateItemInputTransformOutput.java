// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;

public class UpdateItemInputTransformOutput {

  /**
   * <p>Represents the input of an <code>UpdateItem</code> operation.</p>
   */
  private final UpdateItemRequest transformedInput;

  protected UpdateItemInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  /**
   * @return <p>Represents the input of an <code>UpdateItem</code> operation.</p>
   */
  public UpdateItemRequest transformedInput() {
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
     * @param transformedInput <p>Represents the input of an <code>UpdateItem</code> operation.</p>
     */
    Builder transformedInput(UpdateItemRequest transformedInput);

    /**
     * @return <p>Represents the input of an <code>UpdateItem</code> operation.</p>
     */
    UpdateItemRequest transformedInput();

    UpdateItemInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected UpdateItemRequest transformedInput;

    protected BuilderImpl() {}

    protected BuilderImpl(UpdateItemInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(UpdateItemRequest transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public UpdateItemRequest transformedInput() {
      return this.transformedInput;
    }

    public UpdateItemInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedInput`"
        );
      }
      return new UpdateItemInputTransformOutput(this);
    }
  }
}
