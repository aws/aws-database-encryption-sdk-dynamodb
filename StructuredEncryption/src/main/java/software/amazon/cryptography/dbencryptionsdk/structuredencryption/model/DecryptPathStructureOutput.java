// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.List;
import java.util.Objects;

public class DecryptPathStructureOutput {

  private final List<CryptoItem> plaintextStructure;

  private final ParsedHeader parsedHeader;

  protected DecryptPathStructureOutput(BuilderImpl builder) {
    this.plaintextStructure = builder.plaintextStructure();
    this.parsedHeader = builder.parsedHeader();
  }

  public List<CryptoItem> plaintextStructure() {
    return this.plaintextStructure;
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
    Builder plaintextStructure(List<CryptoItem> plaintextStructure);

    List<CryptoItem> plaintextStructure();

    Builder parsedHeader(ParsedHeader parsedHeader);

    ParsedHeader parsedHeader();

    DecryptPathStructureOutput build();
  }

  static class BuilderImpl implements Builder {

    protected List<CryptoItem> plaintextStructure;

    protected ParsedHeader parsedHeader;

    protected BuilderImpl() {}

    protected BuilderImpl(DecryptPathStructureOutput model) {
      this.plaintextStructure = model.plaintextStructure();
      this.parsedHeader = model.parsedHeader();
    }

    public Builder plaintextStructure(List<CryptoItem> plaintextStructure) {
      this.plaintextStructure = plaintextStructure;
      return this;
    }

    public List<CryptoItem> plaintextStructure() {
      return this.plaintextStructure;
    }

    public Builder parsedHeader(ParsedHeader parsedHeader) {
      this.parsedHeader = parsedHeader;
      return this;
    }

    public ParsedHeader parsedHeader() {
      return this.parsedHeader;
    }

    public DecryptPathStructureOutput build() {
      if (Objects.isNull(this.plaintextStructure())) {
        throw new IllegalArgumentException(
          "Missing value for required field `plaintextStructure`"
        );
      }
      if (Objects.isNull(this.parsedHeader())) {
        throw new IllegalArgumentException(
          "Missing value for required field `parsedHeader`"
        );
      }
      return new DecryptPathStructureOutput(this);
    }
  }
}
