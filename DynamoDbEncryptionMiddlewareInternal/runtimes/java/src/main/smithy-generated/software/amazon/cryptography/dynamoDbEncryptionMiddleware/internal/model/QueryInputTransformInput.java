// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import java.util.Objects;

public class QueryInputTransformInput {
  private final QueryRequest sdkInput;

  protected QueryInputTransformInput(BuilderImpl builder) {
    this.sdkInput = builder.sdkInput();
  }

  public QueryRequest sdkInput() {
    return this.sdkInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkInput(QueryRequest sdkInput);

    QueryRequest sdkInput();

    QueryInputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected QueryRequest sdkInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(QueryInputTransformInput model) {
      this.sdkInput = model.sdkInput();
    }

    public Builder sdkInput(QueryRequest sdkInput) {
      this.sdkInput = sdkInput;
      return this;
    }

    public QueryRequest sdkInput() {
      return this.sdkInput;
    }

    public QueryInputTransformInput build() {
      if (Objects.isNull(this.sdkInput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkInput`");
      }
      return new QueryInputTransformInput(this);
    }
  }
}
