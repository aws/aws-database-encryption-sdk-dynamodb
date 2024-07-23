// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;

public class PutItemOutputTransformOutput {

  /**
   * <p>Represents the output of a <code>PutItem</code> operation.</p>
   */
  private final PutItemResponse transformedOutput;

  protected PutItemOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  /**
   * @return <p>Represents the output of a <code>PutItem</code> operation.</p>
   */
  public PutItemResponse transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param transformedOutput <p>Represents the output of a <code>PutItem</code> operation.</p>
     */
    Builder transformedOutput(PutItemResponse transformedOutput);

    /**
     * @return <p>Represents the output of a <code>PutItem</code> operation.</p>
     */
    PutItemResponse transformedOutput();

    PutItemOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected PutItemResponse transformedOutput;

    protected BuilderImpl() {}

    protected BuilderImpl(PutItemOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(PutItemResponse transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public PutItemResponse transformedOutput() {
      return this.transformedOutput;
    }

    public PutItemOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedOutput`"
        );
      }
      return new PutItemOutputTransformOutput(this);
    }
  }
}
