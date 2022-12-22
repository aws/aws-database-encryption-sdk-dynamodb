// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import java.util.Objects;

public class UpdateItemOutputTransformInput {
  private final UpdateItemResult sdkOutput;

  private final UpdateItemRequest originalInput;

  protected UpdateItemOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public UpdateItemResult sdkOutput() {
    return this.sdkOutput;
  }

  public UpdateItemRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(UpdateItemResult sdkOutput);

    UpdateItemResult sdkOutput();

    Builder originalInput(UpdateItemRequest originalInput);

    UpdateItemRequest originalInput();

    UpdateItemOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected UpdateItemResult sdkOutput;

    protected UpdateItemRequest originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(UpdateItemOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(UpdateItemResult sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public UpdateItemResult sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(UpdateItemRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public UpdateItemRequest originalInput() {
      return this.originalInput;
    }

    public UpdateItemOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new UpdateItemOutputTransformInput(this);
    }
  }
}
