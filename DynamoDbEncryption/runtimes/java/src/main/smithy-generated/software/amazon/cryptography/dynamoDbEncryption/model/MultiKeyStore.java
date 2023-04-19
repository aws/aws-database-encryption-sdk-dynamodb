// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import java.util.Objects;

public class MultiKeyStore {
  private final String keyFieldName;

  private final Integer cacheTTL;

  private final Integer maxCacheSize;

  protected MultiKeyStore(BuilderImpl builder) {
    this.keyFieldName = builder.keyFieldName();
    this.cacheTTL = builder.cacheTTL();
    this.maxCacheSize = builder.maxCacheSize();
  }

  public String keyFieldName() {
    return this.keyFieldName;
  }

  public Integer cacheTTL() {
    return this.cacheTTL;
  }

  public Integer maxCacheSize() {
    return this.maxCacheSize;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder keyFieldName(String keyFieldName);

    String keyFieldName();

    Builder cacheTTL(Integer cacheTTL);

    Integer cacheTTL();

    Builder maxCacheSize(Integer maxCacheSize);

    Integer maxCacheSize();

    MultiKeyStore build();
  }

  static class BuilderImpl implements Builder {
    protected String keyFieldName;

    protected Integer cacheTTL;

    protected Integer maxCacheSize;

    protected BuilderImpl() {
    }

    protected BuilderImpl(MultiKeyStore model) {
      this.keyFieldName = model.keyFieldName();
      this.cacheTTL = model.cacheTTL();
      this.maxCacheSize = model.maxCacheSize();
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

    public Builder maxCacheSize(Integer maxCacheSize) {
      this.maxCacheSize = maxCacheSize;
      return this;
    }

    public Integer maxCacheSize() {
      return this.maxCacheSize;
    }

    public MultiKeyStore build() {
      if (Objects.isNull(this.keyFieldName()))  {
        throw new IllegalArgumentException("Missing value for required field `keyFieldName`");
      }
      if (Objects.isNull(this.cacheTTL()))  {
        throw new IllegalArgumentException("Missing value for required field `cacheTTL`");
      }
      if (Objects.isNull(this.maxCacheSize()))  {
        throw new IllegalArgumentException("Missing value for required field `maxCacheSize`");
      }
      return new MultiKeyStore(this);
    }
  }
}
