// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.List;
import java.util.Objects;

public class EncryptPathStructureOutput {

  private final List<CryptoItem> encryptedStructure;

  private final ParsedHeader parsedHeader;

  protected EncryptPathStructureOutput(BuilderImpl builder) {
    this.encryptedStructure = builder.encryptedStructure();
    this.parsedHeader = builder.parsedHeader();
  }

  public List<CryptoItem> encryptedStructure() {
    return this.encryptedStructure;
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
    Builder encryptedStructure(List<CryptoItem> encryptedStructure);

    List<CryptoItem> encryptedStructure();

    Builder parsedHeader(ParsedHeader parsedHeader);

    ParsedHeader parsedHeader();

    EncryptPathStructureOutput build();
  }

  static class BuilderImpl implements Builder {

    protected List<CryptoItem> encryptedStructure;

    protected ParsedHeader parsedHeader;

    protected BuilderImpl() {}

    protected BuilderImpl(EncryptPathStructureOutput model) {
      this.encryptedStructure = model.encryptedStructure();
      this.parsedHeader = model.parsedHeader();
    }

    public Builder encryptedStructure(List<CryptoItem> encryptedStructure) {
      this.encryptedStructure = encryptedStructure;
      return this;
    }

    public List<CryptoItem> encryptedStructure() {
      return this.encryptedStructure;
    }

    public Builder parsedHeader(ParsedHeader parsedHeader) {
      this.parsedHeader = parsedHeader;
      return this;
    }

    public ParsedHeader parsedHeader() {
      return this.parsedHeader;
    }

    public EncryptPathStructureOutput build() {
      if (Objects.isNull(this.encryptedStructure())) {
        throw new IllegalArgumentException(
          "Missing value for required field `encryptedStructure`"
        );
      }
      if (Objects.isNull(this.parsedHeader())) {
        throw new IllegalArgumentException(
          "Missing value for required field `parsedHeader`"
        );
      }
      return new EncryptPathStructureOutput(this);
    }
  }
}
