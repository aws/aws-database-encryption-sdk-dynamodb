// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

public class GetPartitionNumberOutput {

  private final int partitionNumber;

  protected GetPartitionNumberOutput(BuilderImpl builder) {
    this.partitionNumber = builder.partitionNumber();
  }

  public int partitionNumber() {
    return this.partitionNumber;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder partitionNumber(int partitionNumber);

    int partitionNumber();

    GetPartitionNumberOutput build();
  }

  static class BuilderImpl implements Builder {

    protected int partitionNumber;

    private boolean _partitionNumberSet = false;

    protected BuilderImpl() {}

    protected BuilderImpl(GetPartitionNumberOutput model) {
      this.partitionNumber = model.partitionNumber();
      this._partitionNumberSet = true;
    }

    public Builder partitionNumber(int partitionNumber) {
      this.partitionNumber = partitionNumber;
      this._partitionNumberSet = true;
      return this;
    }

    public int partitionNumber() {
      return this.partitionNumber;
    }

    public GetPartitionNumberOutput build() {
      if (!this._partitionNumberSet) {
        throw new IllegalArgumentException(
          "Missing value for required field `partitionNumber`"
        );
      }
      if (this._partitionNumberSet && this.partitionNumber() < 0) {
        throw new IllegalArgumentException(
          "`partitionNumber` must be greater than or equal to 0"
        );
      }
      if (this._partitionNumberSet && this.partitionNumber() > 254) {
        throw new IllegalArgumentException(
          "`partitionNumber` must be less than or equal to 254."
        );
      }
      return new GetPartitionNumberOutput(this);
    }
  }
}
