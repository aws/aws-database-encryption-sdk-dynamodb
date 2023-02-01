// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.structuredEncryption;

import Dafny.Aws.Cryptography.StructuredEncryption.StructuredEncryptionClient;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.Error;
import Dafny.Aws.Cryptography.StructuredEncryption.Types.IStructuredEncryptionClient;
import Dafny.Aws.Cryptography.StructuredEncryption.__default;
import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.util.Objects;
import software.amazon.cryptography.structuredEncryption.model.DecryptStructureInput;
import software.amazon.cryptography.structuredEncryption.model.DecryptStructureOutput;
import software.amazon.cryptography.structuredEncryption.model.EncryptStructureInput;
import software.amazon.cryptography.structuredEncryption.model.EncryptStructureOutput;
import software.amazon.cryptography.structuredEncryption.model.StructuredEncryptionConfig;

public class StructuredEncryption {
  private final IStructuredEncryptionClient _impl;

  protected StructuredEncryption(BuilderImpl builder) {
    StructuredEncryptionConfig nativeValue = builder.StructuredEncryptionConfig();
    Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredEncryptionConfig dafnyValue = ToDafny.StructuredEncryptionConfig(nativeValue);
    Result<StructuredEncryptionClient, Error> result = __default.StructuredEncryption(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    this._impl = result.dtor_value();
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  protected IStructuredEncryptionClient impl() {
    return this._impl;
  }

  public EncryptStructureOutput EncryptStructure(EncryptStructureInput nativeValue) {
    Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput dafnyValue = ToDafny.EncryptStructureInput(nativeValue);
    Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput, Error> result = this._impl.EncryptStructure(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.EncryptStructureOutput(result.dtor_value());
  }

  public DecryptStructureOutput DecryptStructure(DecryptStructureInput nativeValue) {
    Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput dafnyValue = ToDafny.DecryptStructureInput(nativeValue);
    Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput, Error> result = this._impl.DecryptStructure(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DecryptStructureOutput(result.dtor_value());
  }

  public interface Builder {
    Builder StructuredEncryptionConfig(StructuredEncryptionConfig StructuredEncryptionConfig);

    StructuredEncryptionConfig StructuredEncryptionConfig();

    StructuredEncryption build();
  }

  static class BuilderImpl implements Builder {
    protected StructuredEncryptionConfig StructuredEncryptionConfig;

    protected BuilderImpl() {
    }

    public Builder StructuredEncryptionConfig(
        StructuredEncryptionConfig StructuredEncryptionConfig) {
      this.StructuredEncryptionConfig = StructuredEncryptionConfig;
      return this;
    }

    public StructuredEncryptionConfig StructuredEncryptionConfig() {
      return this.StructuredEncryptionConfig;
    }

    public StructuredEncryption build() {
      if (Objects.isNull(this.StructuredEncryptionConfig()))  {
        throw new IllegalArgumentException("Missing value for required field `StructuredEncryptionConfig`");
      }
      return new StructuredEncryption(this);
    }
  }
}
