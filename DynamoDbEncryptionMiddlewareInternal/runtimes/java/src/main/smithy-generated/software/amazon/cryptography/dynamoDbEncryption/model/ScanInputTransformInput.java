// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.ScanInput;
import java.util.Objects;

public class ScanInputTransformInput {
  private final ScanInput sdkInput;

  protected ScanInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public ScanInput sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(ScanInput sdkInput);

    ScanInput sdkInput();

    ScanInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected ScanInput sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(ScanInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(ScanInput sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public ScanInput sdkInput() {
      return this.sdkInput;
    }

    public ScanInputTransformInput build() {
      if (Objects.isNull(this.sdkInput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkInput`");
      }
      return new ScanInputTransformInput(this);
    }
  }
}
