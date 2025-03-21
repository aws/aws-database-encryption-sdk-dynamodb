// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;

public class ScanInputTransformOutput {

  /**
   * <p>Represents the input of a <code>Scan</code> operation.</p>
   */
  private final ScanRequest transformedInput;

  protected ScanInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  /**
   * @return <p>Represents the input of a <code>Scan</code> operation.</p>
   */
  public ScanRequest transformedInput() {
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
     * @param transformedInput <p>Represents the input of a <code>Scan</code> operation.</p>
     */
    Builder transformedInput(ScanRequest transformedInput);

    /**
     * @return <p>Represents the input of a <code>Scan</code> operation.</p>
     */
    ScanRequest transformedInput();

    ScanInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected ScanRequest transformedInput;

    protected BuilderImpl() {}

    protected BuilderImpl(ScanInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(ScanRequest transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public ScanRequest transformedInput() {
      return this.transformedInput;
    }

    public ScanInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedInput`"
        );
      }
      return new ScanInputTransformOutput(this);
    }
  }
}
