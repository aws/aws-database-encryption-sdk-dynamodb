// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

public class GetBucketNumberOutput {

  private final int bucketNumber;

  protected GetBucketNumberOutput(BuilderImpl builder) {
    this.bucketNumber = builder.bucketNumber();
  }

  public int bucketNumber() {
    return this.bucketNumber;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder bucketNumber(int bucketNumber);

    int bucketNumber();

    GetBucketNumberOutput build();
  }

  static class BuilderImpl implements Builder {

    protected int bucketNumber;

    private boolean _bucketNumberSet = false;

    protected BuilderImpl() {}

    protected BuilderImpl(GetBucketNumberOutput model) {
      this.bucketNumber = model.bucketNumber();
      this._bucketNumberSet = true;
    }

    public Builder bucketNumber(int bucketNumber) {
      this.bucketNumber = bucketNumber;
      this._bucketNumberSet = true;
      return this;
    }

    public int bucketNumber() {
      return this.bucketNumber;
    }

    public GetBucketNumberOutput build() {
      if (!this._bucketNumberSet) {
        throw new IllegalArgumentException(
          "Missing value for required field `bucketNumber`"
        );
      }
      if (this._bucketNumberSet && this.bucketNumber() < 0) {
        throw new IllegalArgumentException(
          "`bucketNumber` must be greater than or equal to 0"
        );
      }
      if (this._bucketNumberSet && this.bucketNumber() > 254) {
        throw new IllegalArgumentException(
          "`bucketNumber` must be less than or equal to 254."
        );
      }
      return new GetBucketNumberOutput(this);
    }
  }
}
