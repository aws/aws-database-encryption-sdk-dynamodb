// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;
import software.amazon.cryptography.materialproviders.model.CacheType;

/**
 * The configuration for using multiple Beacon Keys.
 */
public class MultiKeyStore {

  /**
   * The name of the field that stores the Beacon Key. This may be a Virtual Field.
   */
  private final String keyFieldName;

  /**
   * How long (in seconds) the beacon key material is cached locally before it is re-retrieved from DynamoDB and re-authed with AWS KMS.
   */
  private final Integer cacheTTL;

  /**
   * Which type of local cache to use.
   */
  private final CacheType cache;

  /**
   * Partition ID to distinguish Beacon Key Sources writing to a Shared cache. If the Partition ID is the same for two Beacon Key Sources, they can share the same cache entries in the Shared cache.
   */
  private final String partitionId;

  protected MultiKeyStore(BuilderImpl builder) {
    this.keyFieldName = builder.keyFieldName();
    this.cacheTTL = builder.cacheTTL();
    this.cache = builder.cache();
    this.partitionId = builder.partitionId();
  }

  /**
   * @return The name of the field that stores the Beacon Key. This may be a Virtual Field.
   */
  public String keyFieldName() {
    return this.keyFieldName;
  }

  /**
   * @return How long (in seconds) the beacon key material is cached locally before it is re-retrieved from DynamoDB and re-authed with AWS KMS.
   */
  public Integer cacheTTL() {
    return this.cacheTTL;
  }

  /**
   * @return Which type of local cache to use.
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
     * @param keyFieldName The name of the field that stores the Beacon Key. This may be a Virtual Field.
     */
    Builder keyFieldName(String keyFieldName);

    /**
     * @return The name of the field that stores the Beacon Key. This may be a Virtual Field.
     */
    String keyFieldName();

    /**
     * @param cacheTTL How long (in seconds) the beacon key material is cached locally before it is re-retrieved from DynamoDB and re-authed with AWS KMS.
     */
    Builder cacheTTL(Integer cacheTTL);

    /**
     * @return How long (in seconds) the beacon key material is cached locally before it is re-retrieved from DynamoDB and re-authed with AWS KMS.
     */
    Integer cacheTTL();

    /**
     * @param cache Which type of local cache to use.
     */
    Builder cache(CacheType cache);

    /**
     * @return Which type of local cache to use.
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

    MultiKeyStore build();
  }

  static class BuilderImpl implements Builder {

    protected String keyFieldName;

    protected Integer cacheTTL;

    protected CacheType cache;

    protected String partitionId;

    protected BuilderImpl() {}

    protected BuilderImpl(MultiKeyStore model) {
      this.keyFieldName = model.keyFieldName();
      this.cacheTTL = model.cacheTTL();
      this.cache = model.cache();
      this.partitionId = model.partitionId();
    }

    public Builder keyFieldName(String keyFieldName) {
      this.keyFieldName = keyFieldName;
      return this;
    }

    public String keyFieldName() {
      return this.keyFieldName;
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

    public MultiKeyStore build() {
      if (Objects.isNull(this.keyFieldName())) {
        throw new IllegalArgumentException(
          "Missing value for required field `keyFieldName`"
        );
      }
      if (Objects.isNull(this.cacheTTL())) {
        throw new IllegalArgumentException(
          "Missing value for required field `cacheTTL`"
        );
      }
      return new MultiKeyStore(this);
    }
  }
}
