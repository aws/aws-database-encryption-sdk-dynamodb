// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption;

import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.__default;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredEncryptionConfig;

public class StructuredEncryption {
  private final IStructuredEncryptionClient _impl;

  protected StructuredEncryption(BuilderImpl builder) {
    StructuredEncryptionConfig input = builder.StructuredEncryptionConfig();
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredEncryptionConfig dafnyValue = ToDafny.StructuredEncryptionConfig(input);
    Result<IStructuredEncryptionClient, Error> result = __default.StructuredEncryption(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    this._impl = result.dtor_value();
  }

  StructuredEncryption(IStructuredEncryptionClient impl) {
    this._impl = impl;
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public DecryptStructureOutput DecryptStructure(DecryptStructureInput input) {
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureInput dafnyValue = ToDafny.DecryptStructureInput(input);
    Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureOutput, Error> result = this._impl.DecryptStructure(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DecryptStructureOutput(result.dtor_value());
  }

  public EncryptStructureOutput EncryptStructure(EncryptStructureInput input) {
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureInput dafnyValue = ToDafny.EncryptStructureInput(input);
    Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureOutput, Error> result = this._impl.EncryptStructure(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.EncryptStructureOutput(result.dtor_value());
  }

  protected IStructuredEncryptionClient impl() {
    return this._impl;
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
