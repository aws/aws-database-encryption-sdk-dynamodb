// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import java.util.Objects;

public class QueryOutputTransformInput {
  private final QueryResult sdkOutput;

  private final QueryRequest originalInput;

  protected QueryOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  public QueryResult sdkOutput() {
    return this.sdkOutput;
  }

  public QueryRequest originalInput() {
    return this.originalInput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder sdkOutput(QueryResult sdkOutput);

    QueryResult sdkOutput();

    Builder originalInput(QueryRequest originalInput);

    QueryRequest originalInput();

    QueryOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {
    protected QueryResult sdkOutput;

    protected QueryRequest originalInput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(QueryOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(QueryResult sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public QueryResult sdkOutput() {
      return this.sdkOutput;
    }

    public Builder originalInput(QueryRequest originalInput) {
      this.originalInput = originalInput;
      return this;
    }

    public QueryRequest originalInput() {
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
