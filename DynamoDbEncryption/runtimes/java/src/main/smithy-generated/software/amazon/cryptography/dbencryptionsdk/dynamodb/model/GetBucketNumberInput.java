// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Map;
import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class GetBucketNumberInput {

  private final Map<String, AttributeValue> item;

  private final int numberOfBuckets;

  protected GetBucketNumberInput(BuilderImpl builder) {
    this.item = builder.item();
    this.numberOfBuckets = builder.numberOfBuckets();
  }

  public Map<String, AttributeValue> item() {
    return this.item;
  }

  public int numberOfBuckets() {
    return this.numberOfBuckets;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder item(Map<String, AttributeValue> item);

    Map<String, AttributeValue> item();

    Builder numberOfBuckets(int numberOfBuckets);

    int numberOfBuckets();

    GetBucketNumberInput build();
  }

  static class BuilderImpl implements Builder {

    protected Map<String, AttributeValue> item;

    protected int numberOfBuckets;

    private boolean _numberOfBucketsSet = false;

    protected BuilderImpl() {}

    protected BuilderImpl(GetBucketNumberInput model) {
      this.item = model.item();
      this.numberOfBuckets = model.numberOfBuckets();
      this._numberOfBucketsSet = true;
    }

    public Builder item(Map<String, AttributeValue> item) {
      this.item = item;
      return this;
    }

    public Map<String, AttributeValue> item() {
      return this.item;
    }

    public Builder numberOfBuckets(int numberOfBuckets) {
      this.numberOfBuckets = numberOfBuckets;
      this._numberOfBucketsSet = true;
      return this;
    }

    public int numberOfBuckets() {
      return this.numberOfBuckets;
    }

    public GetBucketNumberInput build() {
      if (Objects.isNull(this.item())) {
        throw new IllegalArgumentException(
          "Missing value for required field `item`"
        );
      }
      if (!this._numberOfBucketsSet) {
        throw new IllegalArgumentException(
          "Missing value for required field `numberOfBuckets`"
        );
      }
      if (this._numberOfBucketsSet && this.numberOfBuckets() < 1) {
        throw new IllegalArgumentException(
          "`numberOfBuckets` must be greater than or equal to 1"
        );
      }
      if (this._numberOfBucketsSet && this.numberOfBuckets() > 255) {
        throw new IllegalArgumentException(
          "`numberOfBuckets` must be less than or equal to 255."
        );
      }
      return new GetBucketNumberInput(this);
    }
  }
}
