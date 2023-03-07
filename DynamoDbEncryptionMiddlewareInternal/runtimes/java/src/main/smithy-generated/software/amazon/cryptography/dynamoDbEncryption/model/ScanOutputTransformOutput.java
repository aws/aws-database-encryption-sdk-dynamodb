// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.ScanOutput;
import java.util.Objects;

public class ScanOutputTransformOutput {
  private final ScanOutput transformedOutput;

  protected ScanOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public ScanOutput transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(ScanOutput transformedOutput);

    ScanOutput transformedOutput();

    ScanOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected ScanOutput transformedOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(ScanOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(ScanOutput transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public ScanOutput transformedOutput() {
      return this.transformedOutput;
    }

    public ScanOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedOutput`");
      }
      return new ScanOutputTransformOutput(this);
    }
  }
}
