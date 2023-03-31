// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

public class BeaconKey {
  private final String keyArn;

  private final String tableArn;

  private final String branchKeyID;

  protected BeaconKey(BuilderImpl builder) {
    this.keyArn = builder.keyArn();
    this.tableArn = builder.tableArn();
    this.branchKeyID = builder.branchKeyID();
  }

  public String keyArn() {
    return this.keyArn;
  }

  public String tableArn() {
    return this.tableArn;
  }

  public String branchKeyID() {
    return this.branchKeyID;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder keyArn(String keyArn);

    String keyArn();

    Builder tableArn(String tableArn);

    String tableArn();

    Builder branchKeyID(String branchKeyID);

    String branchKeyID();

    BeaconKey build();
  }

  static class BuilderImpl implements Builder {
    protected String keyArn;

    protected String tableArn;

    protected String branchKeyID;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BeaconKey model) {
      this.keyArn = model.keyArn();
      this.tableArn = model.tableArn();
      this.branchKeyID = model.branchKeyID();
    }

    public Builder keyArn(String keyArn) {
      this.keyArn = keyArn;
      return this;
    }

    public String keyArn() {
      return this.keyArn;
    }

    public Builder tableArn(String tableArn) {
      this.tableArn = tableArn;
      return this;
    }

    public String tableArn() {
      return this.tableArn;
    }

    public Builder branchKeyID(String branchKeyID) {
      this.branchKeyID = branchKeyID;
      return this;
    }

    public String branchKeyID() {
      return this.branchKeyID;
    }

    public BeaconKey build() {
      return new BeaconKey(this);
    }
  }
}
