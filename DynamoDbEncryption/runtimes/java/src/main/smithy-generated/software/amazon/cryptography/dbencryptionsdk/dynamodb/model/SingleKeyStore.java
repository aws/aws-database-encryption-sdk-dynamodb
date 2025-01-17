// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;
import software.amazon.cryptography.materialproviders.model.CacheType;

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

  /**
   * Which type of local cache to use. Please see the [spec](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/specification/searchable-encryption/search-config.md#key-store-cache) on how to provide a cache for a SingleKeyStore.
   */
  private final CacheType cache;

  /**
   * Partition ID to distinguish Beacon Key Sources writing to a Shared cache. If the Partition ID is the same for two Beacon Key Sources, they can share the same cache entries in the Shared cache.
   */
  private final String partitionId;

  protected SingleKeyStore(BuilderImpl builder) {
    this.keyId = builder.keyId();
    this.cacheTTL = builder.cacheTTL();
    this.cache = builder.cache();
    this.partitionId = builder.partitionId();
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

  /**
   * @return Which type of local cache to use. Please see the [spec](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/specification/searchable-encryption/search-config.md#key-store-cache) on how to provide a cache for a SingleKeyStore.
   */
  public CacheType cache() {
    return this.cache;
  }

  /**
   * @return Partition ID to distinguish Beacon Key Sources writing to a Shared cache. If the Partition ID is the same for two Beacon Key Sources, they can share the same cache entries in the Shared cache.
   */
  public String partitionId() {
    return this.partitionId;
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

    /**
     * @param cache Which type of local cache to use. Please see the [spec](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/specification/searchable-encryption/search-config.md#key-store-cache) on how to provide a cache for a SingleKeyStore.
     */
    Builder cache(CacheType cache);

    /**
     * @return Which type of local cache to use. Please see the [spec](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/specification/searchable-encryption/search-config.md#key-store-cache) on how to provide a cache for a SingleKeyStore.
     */
    CacheType cache();

    /**
     * @param partitionId Partition ID to distinguish Beacon Key Sources writing to a Shared cache. If the Partition ID is the same for two Beacon Key Sources, they can share the same cache entries in the Shared cache.
     */
    Builder partitionId(String partitionId);

    /**
     * @return Partition ID to distinguish Beacon Key Sources writing to a Shared cache. If the Partition ID is the same for two Beacon Key Sources, they can share the same cache entries in the Shared cache.
     */
    String partitionId();

    SingleKeyStore build();
  }

  static class BuilderImpl implements Builder {

    protected String keyId;

    protected Integer cacheTTL;

    protected CacheType cache;

    protected String partitionId;

    protected BuilderImpl() {}

    protected BuilderImpl(SingleKeyStore model) {
      this.keyId = model.keyId();
      this.cacheTTL = model.cacheTTL();
      this.cache = model.cache();
      this.partitionId = model.partitionId();
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

    public Builder cache(CacheType cache) {
      this.cache = cache;
      return this;
    }

    public CacheType cache() {
      return this.cache;
    }

    public Builder partitionId(String partitionId) {
      this.partitionId = partitionId;
      return this;
    }

    public String partitionId() {
      return this.partitionId;
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
