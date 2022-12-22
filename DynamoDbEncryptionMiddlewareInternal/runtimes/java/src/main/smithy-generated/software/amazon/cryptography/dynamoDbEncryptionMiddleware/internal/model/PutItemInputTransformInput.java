// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import java.util.Objects;

public class PutItemInputTransformInput {
  private final PutItemRequest sdkInput;

  protected PutItemInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public PutItemRequest sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(PutItemRequest sdkInput);

    PutItemRequest sdkInput();

    PutItemInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected PutItemRequest sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(PutItemInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(PutItemRequest sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public PutItemRequest sdkInput() {
      return this.sdkInput;
    }

    public PutItemInputTransformInput build() {
      if (Objects.isNull(this.sdkInput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkInput`");
      }
      return new PutItemInputTransformInput(this);
    }
  }
}
