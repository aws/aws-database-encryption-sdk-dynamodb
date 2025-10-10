// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Map;
import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class GetPartitionNumberInput {

  private final Map<String, AttributeValue> item;

  private final int numberOfPartitions;

  private final String logicalTableName;

  protected GetPartitionNumberInput(BuilderImpl builder) {
    this.item = builder.item();
    this.numberOfPartitions = builder.numberOfPartitions();
    this.logicalTableName = builder.logicalTableName();
  }

  public Map<String, AttributeValue> item() {
    return this.item;
  }

  public int numberOfPartitions() {
    return this.numberOfPartitions;
  }

  public String logicalTableName() {
    return this.logicalTableName;
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

    Builder numberOfPartitions(int numberOfPartitions);

    int numberOfPartitions();

    Builder logicalTableName(String logicalTableName);

    String logicalTableName();

    GetPartitionNumberInput build();
  }

  static class BuilderImpl implements Builder {

    protected Map<String, AttributeValue> item;

    protected int numberOfPartitions;

    private boolean _numberOfPartitionsSet = false;

    protected String logicalTableName;

    protected BuilderImpl() {}

    protected BuilderImpl(GetPartitionNumberInput model) {
      this.item = model.item();
      this.numberOfPartitions = model.numberOfPartitions();
      this._numberOfPartitionsSet = true;
      this.logicalTableName = model.logicalTableName();
    }

    public Builder item(Map<String, AttributeValue> item) {
      this.item = item;
      return this;
    }

    public Map<String, AttributeValue> item() {
      return this.item;
    }

    public Builder numberOfPartitions(int numberOfPartitions) {
      this.numberOfPartitions = numberOfPartitions;
      this._numberOfPartitionsSet = true;
      return this;
    }

    public int numberOfPartitions() {
      return this.numberOfPartitions;
    }

    public Builder logicalTableName(String logicalTableName) {
      this.logicalTableName = logicalTableName;
      return this;
    }

    public String logicalTableName() {
      return this.logicalTableName;
    }

    public GetPartitionNumberInput build() {
      if (Objects.isNull(this.item())) {
        throw new IllegalArgumentException(
          "Missing value for required field `item`"
        );
      }
      if (!this._numberOfPartitionsSet) {
        throw new IllegalArgumentException(
          "Missing value for required field `numberOfPartitions`"
        );
      }
      if (this._numberOfPartitionsSet && this.numberOfPartitions() < 1) {
        throw new IllegalArgumentException(
          "`numberOfPartitions` must be greater than or equal to 1"
        );
      }
      if (this._numberOfPartitionsSet && this.numberOfPartitions() > 255) {
        throw new IllegalArgumentException(
          "`numberOfPartitions` must be less than or equal to 255."
        );
      }
      if (Objects.isNull(this.logicalTableName())) {
        throw new IllegalArgumentException(
          "Missing value for required field `logicalTableName`"
        );
      }
      return new GetPartitionNumberInput(this);
    }
  }
}
