// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;

public class PutItemOutputTransformInput {

  /**
   * <p>Represents the output of a <code>PutItem</code> operation.</p>
   */
  private final PutItemResponse sdkOutput;

  /**
   * <p>Represents the input of a <code>PutItem</code> operation.</p>
   */
  private final PutItemRequest originalInput;

  protected PutItemOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  /**
   * @return <p>Represents the output of a <code>PutItem</code> operation.</p>
   */
  public PutItemResponse sdkOutput() {
    return this.sdkOutput;
  }

  /**
   * @return <p>Represents the input of a <code>PutItem</code> operation.</p>
   */
  public PutItemRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param sdkOutput <p>Represents the output of a <code>PutItem</code> operation.</p>
     */
    Builder sdkOutput(PutItemResponse sdkOutput);

    /**
     * @return <p>Represents the output of a <code>PutItem</code> operation.</p>
     */
    PutItemResponse sdkOutput();

    /**
     * @param originalInput <p>Represents the input of a <code>PutItem</code> operation.</p>
     */
    Builder originalInput(PutItemRequest originalInput);

    /**
     * @return <p>Represents the input of a <code>PutItem</code> operation.</p>
     */
    PutItemRequest originalInput();

    PutItemOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected PutItemResponse sdkOutput;

    protected PutItemRequest originalInput;

    protected BuilderImpl() {}

    protected BuilderImpl(PutItemOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(PutItemResponse sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public PutItemResponse sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(PutItemRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public PutItemRequest originalInput() {
      return this.originalInput;
    }

    public PutItemOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `sdkOutput`"
        );
      }
      if (Objects.isNull(this.originalInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `originalInput`"
        );
      }
      return new PutItemOutputTransformInput(this);
    }
  }
}
