// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.Objects;

public class EncryptStructureOutput {

  private final StructuredData encryptedStructure;

  private final ParsedHeader parsedHeader;

  protected EncryptStructureOutput(BuilderImpl builder) {
    this.encryptedStructure = builder.encryptedStructure();
    this.parsedHeader = builder.parsedHeader();
  }

  public StructuredData encryptedStructure() {
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
    Builder encryptedStructure(StructuredData encryptedStructure);

    StructuredData encryptedStructure();

    Builder parsedHeader(ParsedHeader parsedHeader);

    ParsedHeader parsedHeader();

    EncryptStructureOutput build();
  }

  static class BuilderImpl implements Builder {

    protected StructuredData encryptedStructure;

    protected ParsedHeader parsedHeader;

    protected BuilderImpl() {}

    protected BuilderImpl(EncryptStructureOutput model) {
      this.encryptedStructure = model.encryptedStructure();
      this.parsedHeader = model.parsedHeader();
    }

    public Builder encryptedStructure(StructuredData encryptedStructure) {
      this.encryptedStructure = encryptedStructure;
      return this;
    }

    public StructuredData encryptedStructure() {
      return this.encryptedStructure;
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
      if (Objects.isNull(this.parsedHeader())) {
        throw new IllegalArgumentException(
          "Missing value for required field `parsedHeader`"
        );
      }
      return new EncryptStructureOutput(this);
    }
  }
}
