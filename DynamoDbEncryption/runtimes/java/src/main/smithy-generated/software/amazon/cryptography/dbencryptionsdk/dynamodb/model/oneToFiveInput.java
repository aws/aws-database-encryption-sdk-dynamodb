// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

public class oneToFiveInput {

  private final int inputOne;

  protected oneToFiveInput(BuilderImpl builder) {
    this.inputOne = builder.inputOne();
  }

  public int inputOne() {
    return this.inputOne;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder inputOne(int inputOne);

    int inputOne();

    oneToFiveInput build();
  }

  static class BuilderImpl implements Builder {

    protected int inputOne;

    private boolean _inputOneSet = false;

    protected BuilderImpl() {}

    protected BuilderImpl(oneToFiveInput model) {
      this.inputOne = model.inputOne();
      this._inputOneSet = true;
    }

    public Builder inputOne(int inputOne) {
      this.inputOne = inputOne;
      this._inputOneSet = true;
      return this;
    }

    public int inputOne() {
      return this.inputOne;
    }

    public oneToFiveInput build() {
      if (this._inputOneSet && this.inputOne() < 1) {
        throw new IllegalArgumentException(
          "`inputOne` must be greater than or equal to 1"
        );
      }
      if (this._inputOneSet && this.inputOne() > 5) {
        throw new IllegalArgumentException(
          "`inputOne` must be less than or equal to 5."
        );
      }
      return new oneToFiveInput(this);
    }
  }
}
