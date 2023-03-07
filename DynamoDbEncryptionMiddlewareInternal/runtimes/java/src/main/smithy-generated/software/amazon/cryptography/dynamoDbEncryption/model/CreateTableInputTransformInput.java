// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.CreateTableInput;
import java.util.Objects;

public class CreateTableInputTransformInput {
  private final CreateTableInput sdkInput;

  protected CreateTableInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public CreateTableInput sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(CreateTableInput sdkInput);

    CreateTableInput sdkInput();

    CreateTableInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected CreateTableInput sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(CreateTableInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(CreateTableInput sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public CreateTableInput sdkInput() {
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
