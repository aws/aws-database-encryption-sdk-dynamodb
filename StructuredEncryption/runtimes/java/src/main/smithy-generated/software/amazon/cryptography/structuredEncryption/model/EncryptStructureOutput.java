// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.structuredEncryption.model;

import java.util.Objects;

public class EncryptStructureOutput {
  private final StructuredData encryptedStructure;

  protected EncryptStructureOutput(BuilderImpl builder) {
    this.encryptedStructure = builder.encryptedStructure();
  }

  public StructuredData encryptedStructure() {
    return this.encryptedStructure;
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

    EncryptStructureOutput build();
  }

  static class BuilderImpl implements Builder {
    protected StructuredData encryptedStructure;

    protected BuilderImpl() {
    }

    protected BuilderImpl(EncryptStructureOutput model) {
      this.encryptedStructure = model.encryptedStructure();
    }

    public Builder encryptedStructure(StructuredData encryptedStructure) {
      this.encryptedStructure = encryptedStructure;
      return this;
    }

    public StructuredData encryptedStructure() {
      return this.encryptedStructure;
    }

    public EncryptStructureOutput build() {
      if (Objects.isNull(this.encryptedStructure()))  {
        throw new IllegalArgumentException("Missing value for required field `encryptedStructure`");
      }
      return new EncryptStructureOutput(this);
    }
  }
}
