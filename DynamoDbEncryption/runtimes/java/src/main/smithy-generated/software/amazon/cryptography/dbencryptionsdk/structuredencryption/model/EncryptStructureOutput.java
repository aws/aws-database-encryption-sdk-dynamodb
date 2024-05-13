// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.Map;
import java.util.Objects;

public class EncryptStructureOutput {

  private final Map<String, StructuredDataTerminal> encryptedStructure;

  private final Map<String, CryptoAction> cryptoSchema;

  private final ParsedHeader parsedHeader;

  protected EncryptStructureOutput(BuilderImpl builder) {
    this.encryptedStructure = builder.encryptedStructure();
    this.cryptoSchema = builder.cryptoSchema();
    this.parsedHeader = builder.parsedHeader();
  }

  public Map<String, StructuredDataTerminal> encryptedStructure() {
    return this.encryptedStructure;
  }

  public Map<String, CryptoAction> cryptoSchema() {
    return this.cryptoSchema;
  }

  public ParsedHeader parsedHeader() {
    return this.parsedHeader;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder encryptedStructure(
      Map<String, StructuredDataTerminal> encryptedStructure
    );

    Map<String, StructuredDataTerminal> encryptedStructure();

    Builder cryptoSchema(Map<String, CryptoAction> cryptoSchema);

    Map<String, CryptoAction> cryptoSchema();

    Builder parsedHeader(ParsedHeader parsedHeader);

    ParsedHeader parsedHeader();

    EncryptStructureOutput build();
  }

  static class BuilderImpl implements Builder {

    protected Map<String, StructuredDataTerminal> encryptedStructure;

    protected Map<String, CryptoAction> cryptoSchema;

    protected ParsedHeader parsedHeader;

    protected BuilderImpl() {}

    protected BuilderImpl(EncryptStructureOutput model) {
      this.encryptedStructure = model.encryptedStructure();
      this.cryptoSchema = model.cryptoSchema();
      this.parsedHeader = model.parsedHeader();
    }

    public Builder encryptedStructure(
      Map<String, StructuredDataTerminal> encryptedStructure
    ) {
      this.encryptedStructure = encryptedStructure;
      return this;
    }

    public Map<String, StructuredDataTerminal> encryptedStructure() {
      return this.encryptedStructure;
    }

    public Builder cryptoSchema(Map<String, CryptoAction> cryptoSchema) {
      this.cryptoSchema = cryptoSchema;
      return this;
    }

    public Map<String, CryptoAction> cryptoSchema() {
      return this.cryptoSchema;
    }

    public Builder parsedHeader(ParsedHeader parsedHeader) {
      this.parsedHeader = parsedHeader;
      return this;
    }

    public ParsedHeader parsedHeader() {
      return this.parsedHeader;
    }

    public EncryptStructureOutput build() {
      if (Objects.isNull(this.encryptedStructure())) {
        throw new IllegalArgumentException(
          "Missing value for required field `encryptedStructure`"
        );
      }
      if (Objects.isNull(this.cryptoSchema())) {
        throw new IllegalArgumentException(
          "Missing value for required field `cryptoSchema`"
        );
      }
      if (Objects.isNull(this.parsedHeader())) {
        throw new IllegalArgumentException(
          "Missing value for required field `parsedHeader`"
        );
      }
      return new EncryptStructureOutput(this);
    }
  }
}
