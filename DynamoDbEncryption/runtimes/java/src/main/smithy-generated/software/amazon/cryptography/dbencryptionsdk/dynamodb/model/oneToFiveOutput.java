// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

public class oneToFiveOutput {

  private final int outputOne;

  protected oneToFiveOutput(BuilderImpl builder) {
    this.outputOne = builder.outputOne();
  }

  public int outputOne() {
    return this.outputOne;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder outputOne(int outputOne);

    int outputOne();

    oneToFiveOutput build();
  }

  static class BuilderImpl implements Builder {

    protected int outputOne;

    private boolean _outputOneSet = false;

    protected BuilderImpl() {}

    protected BuilderImpl(oneToFiveOutput model) {
      this.outputOne = model.outputOne();
      this._outputOneSet = true;
    }

    public Builder outputOne(int outputOne) {
      this.outputOne = outputOne;
      this._outputOneSet = true;
      return this;
    }

    public int outputOne() {
      return this.outputOne;
    }

    public oneToFiveOutput build() {
      if (this._outputOneSet && this.outputOne() < 1) {
        throw new IllegalArgumentException(
          "`outputOne` must be greater than or equal to 1"
        );
      }
      if (this._outputOneSet && this.outputOne() > 5) {
        throw new IllegalArgumentException(
          "`outputOne` must be less than or equal to 5."
        );
      }
      return new oneToFiveOutput(this);
    }
  }
}
