// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

public class ScanOutputTransformInput {

  private final ScanResponse sdkOutput;

  private final ScanRequest originalInput;

  protected ScanOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public ScanResponse sdkOutput() {
    return this.sdkOutput;
  }

  public ScanRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(ScanResponse sdkOutput);

    ScanResponse sdkOutput();

    Builder originalInput(ScanRequest originalInput);

    ScanRequest originalInput();

    ScanOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected ScanResponse sdkOutput;

    protected ScanRequest originalInput;

    protected BuilderImpl() {}

    protected BuilderImpl(ScanOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(ScanResponse sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public ScanResponse sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(ScanRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public ScanRequest originalInput() {
      return this.originalInput;
    }

    public ScanOutputTransformInput build() {
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
      return new ScanOutputTransformInput(this);
    }
  }
}
