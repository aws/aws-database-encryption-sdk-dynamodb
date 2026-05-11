// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;

public class QueryOutputTransformInput {

  /**
   * <p>Represents the output of a <code>Query</code> operation.</p>
   */
  private final QueryResponse sdkOutput;

  /**
   * <p>Represents the input of a <code>Query</code> operation.</p>
   */
  private final QueryRequest originalInput;

  protected QueryOutputTransformInput(BuilderImpl builder) {
    this.sdkOutput = builder.sdkOutput();
    this.originalInput = builder.originalInput();
  }

  /**
   * @return <p>Represents the output of a <code>Query</code> operation.</p>
   */
  public QueryResponse sdkOutput() {
    return this.sdkOutput;
  }

  /**
   * @return <p>Represents the input of a <code>Query</code> operation.</p>
   */
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
    /**
     * @param sdkOutput <p>Represents the output of a <code>Query</code> operation.</p>
     */
    Builder sdkOutput(QueryResponse sdkOutput);

    /**
     * @return <p>Represents the output of a <code>Query</code> operation.</p>
     */
    QueryResponse sdkOutput();

    /**
     * @param originalInput <p>Represents the input of a <code>Query</code> operation.</p>
     */
    Builder originalInput(QueryRequest originalInput);

    /**
     * @return <p>Represents the input of a <code>Query</code> operation.</p>
     */
    QueryRequest originalInput();

    QueryOutputTransformInput build();
  }

  static class BuilderImpl implements Builder {

    protected QueryResponse sdkOutput;

    protected QueryRequest originalInput;

    protected BuilderImpl() {}

    protected BuilderImpl(QueryOutputTransformInput model) {
      this.sdkOutput = model.sdkOutput();
      this.originalInput = model.originalInput();
    }

    public Builder sdkOutput(QueryResponse sdkOutput) {
      this.sdkOutput = sdkOutput;
      return this;
    }

    public QueryResponse sdkOutput() {
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
      if (Objects.isNull(this.sdkOutput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `sdkOutput`"
        );
      }
      if (Objects.isNull(this.originalInput())) {
        throw new IllegalArgumentException(
          "Missing value for required field `originalInput`"
        );
      }
      return new QueryOutputTransformInput(this);
    }
  }
}
