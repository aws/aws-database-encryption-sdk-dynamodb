// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.materialproviders.CryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;

public class EncryptStructureInput {

  private final String tableName;

  private final Map<String, StructuredDataTerminal> plaintextStructure;

  private final Map<String, CryptoAction> cryptoSchema;

  private final ICryptographicMaterialsManager cmm;

  private final DBEAlgorithmSuiteId algorithmSuiteId;

  private final Map<String, String> encryptionContext;

  protected EncryptStructureInput(BuilderImpl builder) {
    this.tableName = builder.tableName();
    this.plaintextStructure = builder.plaintextStructure();
    this.cryptoSchema = builder.cryptoSchema();
    this.cmm = builder.cmm();
    this.algorithmSuiteId = builder.algorithmSuiteId();
    this.encryptionContext = builder.encryptionContext();
  }

  public String tableName() {
    return this.tableName;
  }

  public Map<String, StructuredDataTerminal> plaintextStructure() {
    return this.plaintextStructure;
  }

  public Map<String, CryptoAction> cryptoSchema() {
    return this.cryptoSchema;
  }

  public ICryptographicMaterialsManager cmm() {
    return this.cmm;
  }

  public DBEAlgorithmSuiteId algorithmSuiteId() {
    return this.algorithmSuiteId;
  }

  public Map<String, String> encryptionContext() {
    return this.encryptionContext;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder tableName(String tableName);

    String tableName();

    Builder plaintextStructure(
      Map<String, StructuredDataTerminal> plaintextStructure
    );

    Map<String, StructuredDataTerminal> plaintextStructure();

    Builder cryptoSchema(Map<String, CryptoAction> cryptoSchema);

    Map<String, CryptoAction> cryptoSchema();

    Builder cmm(ICryptographicMaterialsManager cmm);

    ICryptographicMaterialsManager cmm();

    Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId);

    DBEAlgorithmSuiteId algorithmSuiteId();

    Builder encryptionContext(Map<String, String> encryptionContext);

    Map<String, String> encryptionContext();

    EncryptStructureInput build();
  }

  static class BuilderImpl implements Builder {

    protected String tableName;

    protected Map<String, StructuredDataTerminal> plaintextStructure;

    protected Map<String, CryptoAction> cryptoSchema;

    protected ICryptographicMaterialsManager cmm;

    protected DBEAlgorithmSuiteId algorithmSuiteId;

    protected Map<String, String> encryptionContext;

    protected BuilderImpl() {}

    protected BuilderImpl(EncryptStructureInput model) {
      this.tableName = model.tableName();
      this.plaintextStructure = model.plaintextStructure();
      this.cryptoSchema = model.cryptoSchema();
      this.cmm = model.cmm();
      this.algorithmSuiteId = model.algorithmSuiteId();
      this.encryptionContext = model.encryptionContext();
    }

    public Builder tableName(String tableName) {
      this.tableName = tableName;
      return this;
    }

    public String tableName() {
      return this.tableName;
    }

    public Builder plaintextStructure(
      Map<String, StructuredDataTerminal> plaintextStructure
    ) {
      this.plaintextStructure = plaintextStructure;
      return this;
    }

    public Map<String, StructuredDataTerminal> plaintextStructure() {
      return this.plaintextStructure;
    }

    public Builder cryptoSchema(Map<String, CryptoAction> cryptoSchema) {
      this.cryptoSchema = cryptoSchema;
      return this;
    }

    public Map<String, CryptoAction> cryptoSchema() {
      return this.cryptoSchema;
    }

    public Builder cmm(ICryptographicMaterialsManager cmm) {
      this.cmm = CryptographicMaterialsManager.wrap(cmm);
      return this;
    }

    public ICryptographicMaterialsManager cmm() {
      return this.cmm;
    }

    public Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId) {
      this.algorithmSuiteId = algorithmSuiteId;
      return this;
    }

    public DBEAlgorithmSuiteId algorithmSuiteId() {
      return this.algorithmSuiteId;
    }

    public Builder encryptionContext(Map<String, String> encryptionContext) {
      this.encryptionContext = encryptionContext;
      return this;
    }

    public Map<String, String> encryptionContext() {
      return this.encryptionContext;
    }

    public EncryptStructureInput build() {
      if (Objects.isNull(this.tableName())) {
        throw new IllegalArgumentException(
          "Missing value for required field `tableName`"
        );
      }
      if (Objects.isNull(this.plaintextStructure())) {
        throw new IllegalArgumentException(
          "Missing value for required field `plaintextStructure`"
        );
      }
      if (Objects.isNull(this.cryptoSchema())) {
        throw new IllegalArgumentException(
          "Missing value for required field `cryptoSchema`"
        );
      }
      if (Objects.isNull(this.cmm())) {
        throw new IllegalArgumentException(
          "Missing value for required field `cmm`"
        );
      }
      return new EncryptStructureInput(this);
    }
  }
}
