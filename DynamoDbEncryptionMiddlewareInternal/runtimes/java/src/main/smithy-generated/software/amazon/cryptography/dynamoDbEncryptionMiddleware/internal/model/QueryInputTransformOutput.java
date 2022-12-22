// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import java.util.Objects;

public class QueryInputTransformOutput {
  private final QueryRequest transformedInput;

  protected QueryInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public QueryRequest transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(QueryRequest transformedInput);

    QueryRequest transformedInput();

    QueryInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected QueryRequest transformedInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(QueryInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(QueryRequest transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public QueryRequest transformedInput() {
      return this.transformedInput;
    }

    public QueryInputTransformOutput build() {
      if (Objects.isNull(this.transformedInput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedInput`");
      }
      return new QueryInputTransformOutput(this);
    }
  }
}
