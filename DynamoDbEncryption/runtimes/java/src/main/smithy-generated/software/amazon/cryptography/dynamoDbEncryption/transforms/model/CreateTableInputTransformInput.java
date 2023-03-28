// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;

public class CreateTableInputTransformInput {
  private final CreateTableRequest sdkInput;

  protected CreateTableInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public CreateTableRequest sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(CreateTableRequest sdkInput);

    CreateTableRequest sdkInput();

    CreateTableInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected CreateTableRequest sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(CreateTableInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(CreateTableRequest sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public CreateTableRequest sdkInput() {
      return this.sdkInput;
    }

    public CreateTableInputTransformInput build() {
      if (Objects.isNull(this.sdkInput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkInput`");
      }
      return new CreateTableInputTransformInput(this);
    }
  }
}
