// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

public class EncryptedDataKeyDescriptionOutput {

  private final String keyProviderId;

  private final String keyProviderInfo;

  private final String branchKeyId;

  private final String branchKeyVersion;

  protected EncryptedDataKeyDescriptionOutput(BuilderImpl builder) {
    this.keyProviderId = builder.keyProviderId();
    this.keyProviderInfo = builder.keyProviderInfo();
    this.branchKeyId = builder.branchKeyId();
    this.branchKeyVersion = builder.branchKeyVersion();
  }

  public String keyProviderId() {
    return this.keyProviderId;
  }

  public String keyProviderInfo() {
    return this.keyProviderInfo;
  }

  public String branchKeyId() {
    return this.branchKeyId;
  }

  public String branchKeyVersion() {
    return this.branchKeyVersion;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder keyProviderId(String keyProviderId);

    String keyProviderId();

    Builder keyProviderInfo(String keyProviderInfo);

    String keyProviderInfo();

    Builder branchKeyId(String branchKeyId);

    String branchKeyId();

    Builder branchKeyVersion(String branchKeyVersion);

    String branchKeyVersion();

    EncryptedDataKeyDescriptionOutput build();
  }

  static class BuilderImpl implements Builder {

    protected String keyProviderId;

    protected String keyProviderInfo;

    protected String branchKeyId;

    protected String branchKeyVersion;

    protected BuilderImpl() {}

    protected BuilderImpl(EncryptedDataKeyDescriptionOutput model) {
      this.keyProviderId = model.keyProviderId();
      this.keyProviderInfo = model.keyProviderInfo();
      this.branchKeyId = model.branchKeyId();
      this.branchKeyVersion = model.branchKeyVersion();
    }

    public Builder keyProviderId(String keyProviderId) {
      this.keyProviderId = keyProviderId;
      return this;
    }

    public String keyProviderId() {
      return this.keyProviderId;
    }

    public Builder keyProviderInfo(String keyProviderInfo) {
      this.keyProviderInfo = keyProviderInfo;
      return this;
    }

    public String keyProviderInfo() {
      return this.keyProviderInfo;
    }

    public Builder branchKeyId(String branchKeyId) {
      this.branchKeyId = branchKeyId;
      return this;
    }

    public String branchKeyId() {
      return this.branchKeyId;
    }

    public Builder branchKeyVersion(String branchKeyVersion) {
      this.branchKeyVersion = branchKeyVersion;
      return this;
    }

    public String branchKeyVersion() {
      return this.branchKeyVersion;
    }

    public EncryptedDataKeyDescriptionOutput build() {
      if (Objects.isNull(this.keyProviderId())) {
        throw new IllegalArgumentException(
          "Missing value for required field `keyProviderId`"
        );
      }
      return new EncryptedDataKeyDescriptionOutput(this);
    }
  }
}
