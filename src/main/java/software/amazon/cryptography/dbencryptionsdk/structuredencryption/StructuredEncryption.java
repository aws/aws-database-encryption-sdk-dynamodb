// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption;

import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.StructuredEncryptionImpl;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptPathStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptPathStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptPathStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptPathStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.ResolveAuthActionsInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.ResolveAuthActionsOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredEncryptionConfig;

public class StructuredEncryption {

  protected StructuredEncryption(BuilderImpl builder) {
    // TODO: Phase 1 — initialize native StructuredEncryptionImpl
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public DecryptPathStructureOutput DecryptPathStructure(DecryptPathStructureInput input) {
    return StructuredEncryptionImpl.decryptPathStructure(
      input.tableName(),
      input.encryptedStructure(),
      input.cmm(),
      input.encryptionContext()
    );
  }

  public DecryptStructureOutput DecryptStructure(DecryptStructureInput input) {
    throw new UnsupportedOperationException("Not yet implemented — Phase 1");
  }

  public EncryptPathStructureOutput EncryptPathStructure(EncryptPathStructureInput input) {
    return StructuredEncryptionImpl.encryptPathStructure(
      input.tableName(),
      input.plaintextStructure(),
      input.cmm(),
      input.algorithmSuiteId(),
      input.encryptionContext()
    );
  }

  public EncryptStructureOutput EncryptStructure(EncryptStructureInput input) {
    throw new UnsupportedOperationException("Not yet implemented — Phase 1");
  }

  public ResolveAuthActionsOutput ResolveAuthActions(ResolveAuthActionsInput input) {
    throw new UnsupportedOperationException("Not yet implemented — Phase 1");
  }

  public interface Builder {
    Builder StructuredEncryptionConfig(StructuredEncryptionConfig StructuredEncryptionConfig);
    StructuredEncryptionConfig StructuredEncryptionConfig();
    StructuredEncryption build();
  }

  static class BuilderImpl implements Builder {

    protected StructuredEncryptionConfig StructuredEncryptionConfig;

    protected BuilderImpl() {}

    public Builder StructuredEncryptionConfig(StructuredEncryptionConfig StructuredEncryptionConfig) {
      this.StructuredEncryptionConfig = StructuredEncryptionConfig;
      return this;
    }

    public StructuredEncryptionConfig StructuredEncryptionConfig() {
      return this.StructuredEncryptionConfig;
    }

    public StructuredEncryption build() {
      if (Objects.isNull(this.StructuredEncryptionConfig())) {
        throw new IllegalArgumentException(
          "Missing value for required field `StructuredEncryptionConfig`"
        );
      }
      return new StructuredEncryption(this);
    }
  }
}
