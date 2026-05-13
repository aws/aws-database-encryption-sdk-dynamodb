// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;

public class GetItemOutputTransformOutput {

  /**
   * <p>Represents the output of a <code>GetItem</code> operation.</p>
   */
  private final GetItemResponse transformedOutput;

  protected GetItemOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  /**
   * @return <p>Represents the output of a <code>GetItem</code> operation.</p>
   */
  public GetItemResponse transformedOutput() {
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
     * @param transformedOutput <p>Represents the output of a <code>GetItem</code> operation.</p>
     */
    Builder transformedOutput(GetItemResponse transformedOutput);

    /**
     * @return <p>Represents the output of a <code>GetItem</code> operation.</p>
     */
    GetItemResponse transformedOutput();

    GetItemOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected GetItemResponse transformedOutput;

    protected BuilderImpl() {}

    protected BuilderImpl(GetItemOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(GetItemResponse transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public GetItemResponse transformedOutput() {
      return this.transformedOutput;
    }

    public GetItemOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedOutput`"
        );
      }
      return new GetItemOutputTransformOutput(this);
    }
  }
}
