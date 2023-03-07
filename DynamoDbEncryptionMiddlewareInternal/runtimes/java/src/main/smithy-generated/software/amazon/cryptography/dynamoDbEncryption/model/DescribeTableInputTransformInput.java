// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.DescribeTableInput;
import java.util.Objects;

public class DescribeTableInputTransformInput {
  private final DescribeTableInput sdkInput;

  protected DescribeTableInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public DescribeTableInput sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(DescribeTableInput sdkInput);

    DescribeTableInput sdkInput();

    DescribeTableInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected DescribeTableInput sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DescribeTableInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(DescribeTableInput sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public DescribeTableInput sdkInput() {
      return this.sdkInput;
    }

    public DescribeTableInputTransformInput build() {
      if (Objects.isNull(this.sdkInput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkInput`");
      }
      return new DescribeTableInputTransformInput(this);
    }
  }
}
