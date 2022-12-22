// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import java.util.Objects;

public class GetItemOutputTransformInput {
  private final GetItemResult sdkOutput;

  private final GetItemRequest originalInput;

  protected GetItemOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public GetItemResult sdkOutput() {
    return this.sdkOutput;
  }

  public GetItemRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(GetItemResult sdkOutput);

    GetItemResult sdkOutput();

    Builder originalInput(GetItemRequest originalInput);

    GetItemRequest originalInput();

    GetItemOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected GetItemResult sdkOutput;

    protected GetItemRequest originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(GetItemOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(GetItemResult sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public GetItemResult sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(GetItemRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public GetItemRequest originalInput() {
      return this.originalInput;
    }

    public GetItemOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new GetItemOutputTransformInput(this);
    }
  }
}
