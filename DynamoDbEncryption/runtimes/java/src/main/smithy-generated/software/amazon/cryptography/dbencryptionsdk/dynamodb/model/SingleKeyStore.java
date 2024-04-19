// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

/**
 * The configuration for using a single Beacon Key.
 */
public class SingleKeyStore {

  /**
   * The Beacon Key ID.
   */
  private final String keyId;

  /**
   * How long (in seconds) the beacon key material is cached locally before it is re-retrieved from DynamoDB and re-authed with AWS KMS.
   */
  private final Integer cacheTTL;

  protected SingleKeyStore(BuilderImpl builder) {
    this.keyId = builder.keyId();
    this.cacheTTL = builder.cacheTTL();
  }

  /**
   * @return The Beacon Key ID.
   */
  public String keyId() {
    return this.keyId;
  }

  /**
   * @return How long (in seconds) the beacon key material is cached locally before it is re-retrieved from DynamoDB and re-authed with AWS KMS.
   */
  public Integer cacheTTL() {
    return this.cacheTTL;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param keyId The Beacon Key ID.
     */
    Builder keyId(String keyId);

    /**
     * @return The Beacon Key ID.
     */
    String keyId();

    /**
     * @param cacheTTL How long (in seconds) the beacon key material is cached locally before it is re-retrieved from DynamoDB and re-authed with AWS KMS.
     */
    Builder cacheTTL(Integer cacheTTL);

    /**
     * @return How long (in seconds) the beacon key material is cached locally before it is re-retrieved from DynamoDB and re-authed with AWS KMS.
     */
    Integer cacheTTL();

    SingleKeyStore build();
  }

  static class BuilderImpl implements Builder {

    protected String keyId;

    protected Integer cacheTTL;

    protected BuilderImpl() {}

    protected BuilderImpl(SingleKeyStore model) {
      this.keyId = model.keyId();
      this.cacheTTL = model.cacheTTL();
    }

    public Builder keyId(String keyId) {
      this.keyId = keyId;
      return this;
    }

    public String keyId() {
      return this.keyId;
    }

    public Builder cacheTTL(Integer cacheTTL) {
      this.cacheTTL = cacheTTL;
      return this;
    }

    public Integer cacheTTL() {
      return this.cacheTTL;
    }

    public SingleKeyStore build() {
      if (Objects.isNull(this.keyId())) {
        throw new IllegalArgumentException(
          "Missing value for required field `keyId`"
        );
      }
      if (Objects.isNull(this.cacheTTL())) {
        throw new IllegalArgumentException(
          "Missing value for required field `cacheTTL`"
        );
      }
      return new SingleKeyStore(this);
    }
  }
}
