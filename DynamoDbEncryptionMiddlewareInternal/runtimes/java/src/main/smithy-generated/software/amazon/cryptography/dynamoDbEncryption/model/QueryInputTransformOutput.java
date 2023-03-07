// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.QueryInput;
import java.util.Objects;

public class QueryInputTransformOutput {
  private final QueryInput transformedInput;

  protected QueryInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  public QueryInput transformedInput() {
    return this.transformedInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedInput(QueryInput transformedInput);

    QueryInput transformedInput();

    QueryInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected QueryInput transformedInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(QueryInputTransformOutput model) {
      this.transformedInput = model.transformedInput();
    }

    public Builder transformedInput(QueryInput transformedInput) {
      this.transformedInput = transformedInput;
      return this;
    }

    public QueryInput transformedInput() {
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
