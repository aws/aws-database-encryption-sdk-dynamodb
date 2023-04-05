// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.structuredEncryption.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.materialProviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialProviders.model.EncryptedDataKey;

public class ParsedHeader {
  private final CryptoSchema cryptoSchema;

  private final DBEAlgorithmSuiteId algorithmSuiteId;

  private final List<EncryptedDataKey> encryptedDataKeys;

  private final Map<String, String> storedEncryptionContext;

  protected ParsedHeader(BuilderImpl builder) {
    this.cryptoSchema = builder.cryptoSchema();
    this.algorithmSuiteId = builder.algorithmSuiteId();
    this.encryptedDataKeys = builder.encryptedDataKeys();
    this.storedEncryptionContext = builder.storedEncryptionContext();
  }

  public CryptoSchema cryptoSchema() {
    return this.cryptoSchema;
  }

  public DBEAlgorithmSuiteId algorithmSuiteId() {
    return this.algorithmSuiteId;
  }

  public List<EncryptedDataKey> encryptedDataKeys() {
    return this.encryptedDataKeys;
  }

  public Map<String, String> storedEncryptionContext() {
    return this.storedEncryptionContext;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder cryptoSchema(CryptoSchema cryptoSchema);

    CryptoSchema cryptoSchema();

    Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId);

    DBEAlgorithmSuiteId algorithmSuiteId();

    Builder encryptedDataKeys(List<EncryptedDataKey> encryptedDataKeys);

    List<EncryptedDataKey> encryptedDataKeys();

    Builder storedEncryptionContext(Map<String, String> storedEncryptionContext);

    Map<String, String> storedEncryptionContext();

    ParsedHeader build();
  }

  static class BuilderImpl implements Builder {
    protected CryptoSchema cryptoSchema;

    protected DBEAlgorithmSuiteId algorithmSuiteId;

    protected List<EncryptedDataKey> encryptedDataKeys;

    protected Map<String, String> storedEncryptionContext;

    protected BuilderImpl() {
    }

    protected BuilderImpl(ParsedHeader model) {
      this.cryptoSchema = model.cryptoSchema();
      this.algorithmSuiteId = model.algorithmSuiteId();
      this.encryptedDataKeys = model.encryptedDataKeys();
      this.storedEncryptionContext = model.storedEncryptionContext();
    }

    public Builder cryptoSchema(CryptoSchema cryptoSchema) {
      this.cryptoSchema = cryptoSchema;
      return this;
    }

    public CryptoSchema cryptoSchema() {
      return this.cryptoSchema;
    }

    public Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId) {
      this.algorithmSuiteId = algorithmSuiteId;
      return this;
    }

    public DBEAlgorithmSuiteId algorithmSuiteId() {
      return this.algorithmSuiteId;
    }

    public Builder encryptedDataKeys(List<EncryptedDataKey> encryptedDataKeys) {
      this.encryptedDataKeys = encryptedDataKeys;
      return this;
    }

    public List<EncryptedDataKey> encryptedDataKeys() {
      return this.encryptedDataKeys;
    }

    public Builder storedEncryptionContext(Map<String, String> storedEncryptionContext) {
      this.storedEncryptionContext = storedEncryptionContext;
      return this;
    }

    public Map<String, String> storedEncryptionContext() {
      return this.storedEncryptionContext;
    }

    public ParsedHeader build() {
      if (Objects.isNull(this.cryptoSchema()))  {
        throw new IllegalArgumentException("Missing value for required field `cryptoSchema`");
      }
      if (Objects.isNull(this.algorithmSuiteId()))  {
        throw new IllegalArgumentException("Missing value for required field `algorithmSuiteId`");
      }
      if (Objects.isNull(this.encryptedDataKeys()))  {
        throw new IllegalArgumentException("Missing value for required field `encryptedDataKeys`");
      }
      if (Objects.isNull(this.storedEncryptionContext()))  {
        throw new IllegalArgumentException("Missing value for required field `storedEncryptionContext`");
      }
      return new ParsedHeader(this);
    }
  }
}
