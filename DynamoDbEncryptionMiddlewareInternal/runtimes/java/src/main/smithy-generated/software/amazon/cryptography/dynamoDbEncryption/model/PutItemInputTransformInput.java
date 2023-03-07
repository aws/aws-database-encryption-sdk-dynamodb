// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.PutItemInput;
import java.util.Objects;

public class PutItemInputTransformInput {
  private final PutItemInput sdkInput;

  protected PutItemInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public PutItemInput sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(PutItemInput sdkInput);

    PutItemInput sdkInput();

    PutItemInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected PutItemInput sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(PutItemInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(PutItemInput sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public PutItemInput sdkInput() {
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
