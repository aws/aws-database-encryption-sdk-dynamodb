// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.ScanInput;
import java.util.Objects;

public class ScanInputTransformOutput {
  private final ScanInput transformedInput;

  protected ScanInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public ScanInput transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(ScanInput transformedInput);

    ScanInput transformedInput();

    ScanInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected ScanInput transformedInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(ScanInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(ScanInput transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public ScanInput transformedInput() {
      return this.transformedInput;
    }

    public ScanInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedInput`");
      }
      return new ScanInputTransformOutput(this);
    }
  }
}
