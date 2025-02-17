// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;

public class QueryInputTransformOutput {

  /**
   * <p>Represents the input of a <code>Query</code> operation.</p>
   */
  private final QueryRequest transformedInput;

  protected QueryInputTransformOutput(BuilderImpl builder) {
    this.transformedInput = builder.transformedInput();
  }

  /**
   * @return <p>Represents the input of a <code>Query</code> operation.</p>
   */
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
    /**
     * @param transformedInput <p>Represents the input of a <code>Query</code> operation.</p>
     */
    Builder transformedInput(QueryRequest transformedInput);

    /**
     * @return <p>Represents the input of a <code>Query</code> operation.</p>
     */
    QueryRequest transformedInput();

    QueryInputTransformOutput build();
  }

  static class BuilderImpl implements Builder {

    protected QueryRequest transformedInput;

    protected BuilderImpl() {}

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
      if (Objects.isNull(this.transformedInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `transformedInput`"
        );
      }
      return new QueryInputTransformOutput(this);
    }
  }
}
