// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;

public class GetNumberOfQueriesInput {

  /**
   * <p>Represents the input of a <code>Query</code> operation.</p>
   */
  private final QueryRequest input;

  protected GetNumberOfQueriesInput(BuilderImpl builder) {
    this.input = builder.input();
  }

  /**
   * @return <p>Represents the input of a <code>Query</code> operation.</p>
   */
  public QueryRequest input() {
    return this.input;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param input <p>Represents the input of a <code>Query</code> operation.</p>
     */
    Builder input(QueryRequest input);

    /**
     * @return <p>Represents the input of a <code>Query</code> operation.</p>
     */
    QueryRequest input();

    GetNumberOfQueriesInput build();
  }

  static class BuilderImpl implements Builder {

    protected QueryRequest input;

    protected BuilderImpl() {}

    protected BuilderImpl(GetNumberOfQueriesInput model) {
      this.input = model.input();
    }

    public Builder input(QueryRequest input) {
      this.input = input;
      return this;
    }

    public QueryRequest input() {
      return this.input;
    }

    public GetNumberOfQueriesInput build() {
      if (Objects.isNull(this.input())) {
        throw new IllegalArgumentException(
          "Missing value for required field `input`"
        );
      }
      return new GetNumberOfQueriesInput(this);
    }
  }
}
