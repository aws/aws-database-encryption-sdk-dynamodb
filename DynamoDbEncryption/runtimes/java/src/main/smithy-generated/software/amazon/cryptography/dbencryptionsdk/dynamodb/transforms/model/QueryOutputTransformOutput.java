// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;

public class QueryOutputTransformOutput {

  private final QueryResponse transformedOutput;

  protected QueryOutputTransformOutput(BuilderImpl builder) {
    this.transformedOutput = builder.transformedOutput();
  }

  public QueryResponse transformedOutput() {
    return this.transformedOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transformedOutput(QueryResponse transformedOutput);

    QueryResponse transformedOutput();

    QueryOutputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected QueryResponse transformedOutput;

    protected BuilderImpl() {}

    protected BuilderImpl(QueryOutputTransformOutput model) {
      this.transformedOutput = model.transformedOutput();
    }

    public Builder transformedOutput(QueryResponse transformedOutput) {
      this.transformedOutput = transformedOutput;
      return this;
    }

    public QueryResponse transformedOutput() {
      return this.transformedOutput;
    }

    public QueryOutputTransformOutput build() {
      if (Objects.isNull(this.transformedOutput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedOutput`"
        );
      }
      return new QueryOutputTransformOutput(this);
    }
  }
}
