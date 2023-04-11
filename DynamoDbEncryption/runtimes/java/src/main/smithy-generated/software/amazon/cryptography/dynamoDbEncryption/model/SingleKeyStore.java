// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import software.amazon.cryptography.keyStore.KeyStore;

public class SingleKeyStore {
  private final KeyStore keyStore;

  private final String keyId;

  private final Integer cacheTTL;

  protected SingleKeyStore(BuilderImpl builder) {
    this.keyStore = builder.keyStore();
    this.keyId = builder.keyId();
    this.cacheTTL = builder.cacheTTL();
  }

  public KeyStore keyStore() {
    return this.keyStore;
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
    Builder keyStore(KeyStore keyStore);

    KeyStore keyStore();

    Builder keyId(String keyId);

    String keyId();

    Builder cacheTTL(Integer cacheTTL);

    Integer cacheTTL();

    SingleKeyStore build();
  }

  static class BuilderImpl implements Builder {
    protected KeyStore keyStore;

    protected String keyId;

    protected Integer cacheTTL;

    protected BuilderImpl() {
    }

    protected BuilderImpl(SingleKeyStore model) {
      this.keyStore = model.keyStore();
      this.keyId = model.keyId();
      this.cacheTTL = model.cacheTTL();
    }

    public Builder keyStore(KeyStore keyStore) {
      this.keyStore = new KeyStore(keyStore);
      return this;
    }

    public KeyStore keyStore() {
      return this.keyStore;
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
      return new SingleKeyStore(this);
    }
  }
}
