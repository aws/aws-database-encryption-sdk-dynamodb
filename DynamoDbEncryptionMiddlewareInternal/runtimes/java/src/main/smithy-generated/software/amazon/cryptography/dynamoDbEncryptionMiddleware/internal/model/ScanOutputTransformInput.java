// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import java.util.Objects;

public class ScanOutputTransformInput {
  private final ScanResult sdkOutput;

  private final ScanRequest originalInput;

  protected ScanOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public ScanResult sdkOutput() {
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
    Builder sdkOutput(ScanResult sdkOutput);

    ScanResult sdkOutput();

    Builder originalInput(ScanRequest originalInput);

    ScanRequest originalInput();

    ScanOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected ScanResult sdkOutput;

    protected ScanRequest originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(ScanOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(ScanResult sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public ScanResult sdkOutput() {
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
