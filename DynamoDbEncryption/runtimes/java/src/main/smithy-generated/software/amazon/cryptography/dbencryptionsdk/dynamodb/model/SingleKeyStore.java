// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

public class SingleKeyStore {
  private final String keyId;

  private final Integer cacheTTL;

  protected SingleKeyStore(BuilderImpl builder) {
    this.keyId = builder.keyId();
    this.cacheTTL = builder.cacheTTL();
  }

  public String keyId() {
    return this.keyId;
  }

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
    Builder keyId(String keyId);

    String keyId();

    Builder cacheTTL(Integer cacheTTL);

    Integer cacheTTL();

    SingleKeyStore build();
  }

  static class BuilderImpl implements Builder {
    protected String keyId;

    protected Integer cacheTTL;

    protected BuilderImpl() {
    }

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
      if (Objects.isNull(this.keyId()))  {
        throw new IllegalArgumentException("Missing value for required field `keyId`");
      }
      if (Objects.isNull(this.cacheTTL()))  {
        throw new IllegalArgumentException("Missing value for required field `cacheTTL`");
      }
      return new SingleKeyStore(this);
    }
  }
}
