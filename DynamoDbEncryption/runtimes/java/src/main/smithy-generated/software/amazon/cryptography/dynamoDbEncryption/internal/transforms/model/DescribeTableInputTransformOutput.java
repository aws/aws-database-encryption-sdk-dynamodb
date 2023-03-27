// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.internal.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableRequest;

public class DescribeTableInputTransformOutput {
  private final DescribeTableRequest transformedInput;

  protected DescribeTableInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public DescribeTableRequest transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(DescribeTableRequest transformedInput);

    DescribeTableRequest transformedInput();

    DescribeTableInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected DescribeTableRequest transformedInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DescribeTableInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(DescribeTableRequest transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public DescribeTableRequest transformedInput() {
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
