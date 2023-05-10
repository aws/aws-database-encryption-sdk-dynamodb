// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.Objects;

public class DecryptStructureOutput {
  private final StructuredData plaintextStructure;

  private final ParsedHeader parsedHeader;

  protected DecryptStructureOutput(BuilderImpl builder) {
    this.plaintextStructure = builder.plaintextStructure();
    this.parsedHeader = builder.parsedHeader();
  }

  public StructuredData plaintextStructure() {
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
    Builder plaintextStructure(StructuredData plaintextStructure);

    StructuredData plaintextStructure();

    Builder parsedHeader(ParsedHeader parsedHeader);

    ParsedHeader parsedHeader();

    DecryptStructureOutput build();
  }

  static class BuilderImpl implements Builder {
    protected StructuredData plaintextStructure;

    protected ParsedHeader parsedHeader;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DecryptStructureOutput model) {
      this.plaintextStructure = model.plaintextStructure();
      this.parsedHeader = model.parsedHeader();
    }

    public Builder plaintextStructure(StructuredData plaintextStructure) {
      this.plaintextStructure = plaintextStructure;
      return this;
    }

    public StructuredData plaintextStructure() {
      return this.plaintextStructure;
    }

    public Builder parsedHeader(ParsedHeader parsedHeader) {
      this.parsedHeader = parsedHeader;
      return this;
    }

    public ParsedHeader parsedHeader() {
      return this.parsedHeader;
    }

    public DecryptStructureOutput build() {
      if (Objects.isNull(this.plaintextStructure()))  {
        throw new IllegalArgumentException("Missing value for required field `plaintextStructure`");
      }
      if (Objects.isNull(this.parsedHeader()))  {
        throw new IllegalArgumentException("Missing value for required field `parsedHeader`");
      }
      return new DecryptStructureOutput(this);
    }
  }
}
