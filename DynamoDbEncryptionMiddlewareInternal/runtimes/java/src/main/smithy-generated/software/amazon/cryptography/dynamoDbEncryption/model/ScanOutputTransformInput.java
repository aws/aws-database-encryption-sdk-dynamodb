// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.ScanInput;
import com.amazonaws.dynamodb.model.ScanOutput;
import java.util.Objects;

public class ScanOutputTransformInput {
  private final ScanOutput sdkOutput;

  private final ScanInput originalInput;

  protected ScanOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public ScanOutput sdkOutput() {
    return this.sdkOutput;
  }

  public ScanInput originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(ScanOutput sdkOutput);

    ScanOutput sdkOutput();

    Builder originalInput(ScanInput originalInput);

    ScanInput originalInput();

    ScanOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected ScanOutput sdkOutput;

    protected ScanInput originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(ScanOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(ScanOutput sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public ScanOutput sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(ScanInput originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public ScanInput originalInput() {
      return this.originalInput;
    }

    public ScanOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new ScanOutputTransformInput(this);
    }
  }
}
