// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

// TODO manually updated the below DDB import to point to the right place
// TODO manually updated native type name, i.e. Input->Request Output->Result
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import java.util.Objects;

public class QueryOutputTransformOutput {
  private final QueryResult transformedOutput;

  protected QueryOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public QueryResult transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(QueryResult transformedOutput);

    QueryResult transformedOutput();

    QueryOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {
    protected QueryResult transformedOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(QueryOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(QueryResult transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public QueryResult transformedOutput() {
      return this.transformedOutput;
    }

    public QueryOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `transformedOutput`");
      }
      return new QueryOutputTransformOutput(this);
    }
  }
}
