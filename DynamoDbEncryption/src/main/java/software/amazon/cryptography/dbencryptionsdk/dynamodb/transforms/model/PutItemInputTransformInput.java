// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

public class PutItemInputTransformInput {

  /**
   * <p>Represents the input of a <code>PutItem</code> operation.</p>
   */
  private final PutItemRequest sdkInput;

  protected PutItemInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  /**
   * @return <p>Represents the input of a <code>PutItem</code> operation.</p>
   */
  public PutItemRequest sdkInput() {
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
     * @param sdkInput <p>Represents the input of a <code>PutItem</code> operation.</p>
     */
    Builder sdkInput(PutItemRequest sdkInput);

    /**
     * @return <p>Represents the input of a <code>PutItem</code> operation.</p>
     */
    PutItemRequest sdkInput();

    PutItemInputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected PutItemRequest sdkInput;

    protected BuilderImpl() {}

    protected BuilderImpl(PutItemInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(PutItemRequest sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public PutItemRequest sdkInput() {
      return this.sdkInput;
    }

    public PutItemInputTransformInput build() {
      if (Objects.isNull(this.sdkInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `sdkInput`"
        );
      }
      return new PutItemInputTransformInput(this);
    }
  }
}
