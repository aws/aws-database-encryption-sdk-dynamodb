// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.Map;
import java.util.Objects;

public class DecryptStructureOutput {
  private final Map<String, StructuredDataTerminal> plaintextStructure;

  private final ParsedHeader parsedHeader;

  protected DecryptStructureOutput(BuilderImpl builder) {
    this.plaintextStructure = builder.plaintextStructure();
    this.parsedHeader = builder.parsedHeader();
  }

  public Map<String, StructuredDataTerminal> plaintextStructure() {
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
    Builder plaintextStructure(Map<String, StructuredDataTerminal> plaintextStructure);

    Map<String, StructuredDataTerminal> plaintextStructure();

    Builder parsedHeader(ParsedHeader parsedHeader);

    ParsedHeader parsedHeader();

    DecryptStructureOutput build();
  }

  static class BuilderImpl implements Builder {
    protected Map<String, StructuredDataTerminal> plaintextStructure;

    protected ParsedHeader parsedHeader;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DecryptStructureOutput model) {
      this.plaintextStructure = model.plaintextStructure();
      this.parsedHeader = model.parsedHeader();
    }

    public Builder plaintextStructure(Map<String, StructuredDataTerminal> plaintextStructure) {
      this.plaintextStructure = plaintextStructure;
      return this;
    }

    public Map<String, StructuredDataTerminal> plaintextStructure() {
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
