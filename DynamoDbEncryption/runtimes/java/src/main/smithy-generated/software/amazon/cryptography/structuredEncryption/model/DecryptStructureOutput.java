// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.structuredEncryption.model;

import java.util.Objects;

public class DecryptStructureOutput {
  private final StructuredData plaintextStructure;

  protected DecryptStructureOutput(BuilderImpl builder) {
    this.plaintextStructure = builder.plaintextStructure();
  }

  public StructuredData plaintextStructure() {
    return this.plaintextStructure;
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

    DecryptStructureOutput build();
  }

  static class BuilderImpl implements Builder {
    protected StructuredData plaintextStructure;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DecryptStructureOutput model) {
      this.plaintextStructure = model.plaintextStructure();
    }

    public Builder plaintextStructure(StructuredData plaintextStructure) {
      this.plaintextStructure = plaintextStructure;
      return this;
    }

    public StructuredData plaintextStructure() {
      return this.plaintextStructure;
    }

    public DecryptStructureOutput build() {
      if (Objects.isNull(this.plaintextStructure()))  {
        throw new IllegalArgumentException("Missing value for required field `plaintextStructure`");
      }
      return new DecryptStructureOutput(this);
    }
  }
}
