// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

public class EncryptedDataKeyDescription {

  /**
   * Key provider id of the encrypted data key.
   */
  private final String keyProviderId;

  /**
   * Key provider information of the encrypted data key.
   */
  private final String keyProviderInfo;

  /**
   * Branch key id of the encrypted data key.
   */
  private final String branchKeyId;

  /**
   * Branch key version of the encrypted data key.
   */
  private final String branchKeyVersion;

  protected EncryptedDataKeyDescription(BuilderImpl builder) {
    this.keyProviderId = builder.keyProviderId();
    this.keyProviderInfo = builder.keyProviderInfo();
    this.branchKeyId = builder.branchKeyId();
    this.branchKeyVersion = builder.branchKeyVersion();
  }

  /**
   * @return Key provider id of the encrypted data key.
   */
  public String keyProviderId() {
    return this.keyProviderId;
  }

  /**
   * @return Key provider information of the encrypted data key.
   */
  public String keyProviderInfo() {
    return this.keyProviderInfo;
  }

  /**
   * @return Branch key id of the encrypted data key.
   */
  public String branchKeyId() {
    return this.branchKeyId;
  }

  /**
   * @return Branch key version of the encrypted data key.
   */
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
    /**
     * @param keyProviderId Key provider id of the encrypted data key.
     */
    Builder keyProviderId(String keyProviderId);

    /**
     * @return Key provider id of the encrypted data key.
     */
    String keyProviderId();

    /**
     * @param keyProviderInfo Key provider information of the encrypted data key.
     */
    Builder keyProviderInfo(String keyProviderInfo);

    /**
     * @return Key provider information of the encrypted data key.
     */
    String keyProviderInfo();

    /**
     * @param branchKeyId Branch key id of the encrypted data key.
     */
    Builder branchKeyId(String branchKeyId);

    /**
     * @return Branch key id of the encrypted data key.
     */
    String branchKeyId();

    /**
     * @param branchKeyVersion Branch key version of the encrypted data key.
     */
    Builder branchKeyVersion(String branchKeyVersion);

    /**
     * @return Branch key version of the encrypted data key.
     */
    String branchKeyVersion();

    EncryptedDataKeyDescription build();
  }

  static class BuilderImpl implements Builder {

    protected String keyProviderId;

    protected String keyProviderInfo;

    protected String branchKeyId;

    protected String branchKeyVersion;

    protected BuilderImpl() {}

    protected BuilderImpl(EncryptedDataKeyDescription model) {
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

    public EncryptedDataKeyDescription build() {
      if (Objects.isNull(this.keyProviderId())) {
        throw new IllegalArgumentException(
          "Missing value for required field `keyProviderId`"
        );
      }
      return new EncryptedDataKeyDescription(this);
    }
  }
}
