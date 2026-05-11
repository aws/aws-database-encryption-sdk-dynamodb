// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

public class PutItemInputTransformOutput {

  /**
   * <p>Represents the input of a <code>PutItem</code> operation.</p>
   */
  private final PutItemRequest transformedInput;

  protected PutItemInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  /**
   * @return <p>Represents the input of a <code>PutItem</code> operation.</p>
   */
  public PutItemRequest transformedInput() {
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
     * @param transformedInput <p>Represents the input of a <code>PutItem</code> operation.</p>
     */
    Builder transformedInput(PutItemRequest transformedInput);

    /**
     * @return <p>Represents the input of a <code>PutItem</code> operation.</p>
     */
    PutItemRequest transformedInput();

    PutItemInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected PutItemRequest transformedInput;

    protected BuilderImpl() {}

    protected BuilderImpl(PutItemInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(PutItemRequest transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public PutItemRequest transformedInput() {
      return this.transformedInput;
    }

    public PutItemInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedInput`"
        );
      }
      return new PutItemInputTransformOutput(this);
    }
  }
}
