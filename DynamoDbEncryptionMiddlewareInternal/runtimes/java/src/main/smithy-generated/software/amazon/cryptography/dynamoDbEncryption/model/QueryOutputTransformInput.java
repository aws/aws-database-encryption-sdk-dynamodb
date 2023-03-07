// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.dynamodb.model.QueryInput;
import com.amazonaws.dynamodb.model.QueryOutput;
import java.util.Objects;

public class QueryOutputTransformInput {
  private final QueryOutput sdkOutput;

  private final QueryInput originalInput;

  protected QueryOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public QueryOutput sdkOutput() {
    return this.sdkOutput;
  }

  public QueryInput originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(QueryOutput sdkOutput);

    QueryOutput sdkOutput();

    Builder originalInput(QueryInput originalInput);

    QueryInput originalInput();

    QueryOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected QueryOutput sdkOutput;

    protected QueryInput originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(QueryOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(QueryOutput sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public QueryOutput sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(QueryInput originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public QueryInput originalInput() {
      return this.originalInput;
    }

    public QueryOutputTransformInput build() {
      if (Objects.isNull(this.sdkOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `sdkOutput`");
      }
      if (Objects.isNull(this.originalInput()))  {
        throw new IllegalArgumentException("Missing value for required field `originalInput`");
      }
      return new QueryOutputTransformInput(this);
    }
  }
}
