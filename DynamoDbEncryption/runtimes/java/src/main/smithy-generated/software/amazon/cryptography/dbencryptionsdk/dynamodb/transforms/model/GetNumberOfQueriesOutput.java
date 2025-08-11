// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

public class GetNumberOfQueriesOutput {

  private final int numberOfQueries;

  protected GetNumberOfQueriesOutput(BuilderImpl builder) {
    this.numberOfQueries = builder.numberOfQueries();
  }

  public int numberOfQueries() {
    return this.numberOfQueries;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder numberOfQueries(int numberOfQueries);

    int numberOfQueries();

    GetNumberOfQueriesOutput build();
  }

  static class BuilderImpl implements Builder {

    protected int numberOfQueries;

    private boolean _numberOfQueriesSet = false;

    protected BuilderImpl() {}

    protected BuilderImpl(GetNumberOfQueriesOutput model) {
      this.numberOfQueries = model.numberOfQueries();
      this._numberOfQueriesSet = true;
    }

    public Builder numberOfQueries(int numberOfQueries) {
      this.numberOfQueries = numberOfQueries;
      this._numberOfQueriesSet = true;
      return this;
    }

    public int numberOfQueries() {
      return this.numberOfQueries;
    }

    public GetNumberOfQueriesOutput build() {
      if (!this._numberOfQueriesSet) {
        throw new IllegalArgumentException(
          "Missing value for required field `numberOfQueries`"
        );
      }
      if (this._numberOfQueriesSet && this.numberOfQueries() < 1) {
        throw new IllegalArgumentException(
          "`numberOfQueries` must be greater than or equal to 1"
        );
      }
      if (this._numberOfQueriesSet && this.numberOfQueries() > 255) {
        throw new IllegalArgumentException(
          "`numberOfQueries` must be less than or equal to 255."
        );
      }
      return new GetNumberOfQueriesOutput(this);
    }
  }
}
