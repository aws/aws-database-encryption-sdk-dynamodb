// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.DescribeTableInput;
import java.util.Objects;

public class DescribeTableInputTransformOutput {
  private final DescribeTableInput transformedInput;

  protected DescribeTableInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public DescribeTableInput transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(DescribeTableInput transformedInput);

    DescribeTableInput transformedInput();

    DescribeTableInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected DescribeTableInput transformedInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DescribeTableInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(DescribeTableInput transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public DescribeTableInput transformedInput() {
      return this.transformedInput;
    }

    public DescribeTableInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedInput`");
      }
      return new DescribeTableInputTransformOutput(this);
    }
  }
}
