// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.itemEncryptor;

import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorClient;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.IDynamoDbItemEncryptorClient;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.__default;
import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.util.Objects;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.DecryptItemInput;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.DecryptItemOutput;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.EncryptItemInput;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.EncryptItemOutput;

public class DynamoDbItemEncryptor {
  private final IDynamoDbItemEncryptorClient _impl;

  protected DynamoDbItemEncryptor(BuilderImpl builder) {
    DynamoDbItemEncryptorConfig nativeValue = builder.DynamoDbItemEncryptorConfig();
    Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DynamoDbItemEncryptorConfig dafnyValue = ToDafny.DynamoDbItemEncryptorConfig(nativeValue);
    Result<DynamoDbItemEncryptorClient, Error> result = __default.DynamoDbItemEncryptor(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    this._impl = result.dtor_value();
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public EncryptItemOutput EncryptItem(EncryptItemInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemInput dafnyValue = ToDafny.EncryptItemInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Error> result = this._impl.EncryptItem(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.EncryptItemOutput(result.dtor_value());
  }

  public DecryptItemOutput DecryptItem(DecryptItemInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput dafnyValue = ToDafny.DecryptItemInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Error> result = this._impl.DecryptItem(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DecryptItemOutput(result.dtor_value());
  }

  protected IDynamoDbItemEncryptorClient impl() {
    return this._impl;
  }

  public interface Builder {
    Builder DynamoDbItemEncryptorConfig(DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig);

    DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig();

    DynamoDbItemEncryptor build();
  }

  static class BuilderImpl implements Builder {
    protected DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig;

    protected BuilderImpl() {
    }

    public Builder DynamoDbItemEncryptorConfig(
        DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig) {
      this.DynamoDbItemEncryptorConfig = DynamoDbItemEncryptorConfig;
      return this;
    }

    public DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig() {
      return this.DynamoDbItemEncryptorConfig;
    }

    public DynamoDbItemEncryptor build() {
      if (Objects.isNull(this.DynamoDbItemEncryptorConfig()))  {
        throw new IllegalArgumentException("Missing value for required field `DynamoDbItemEncryptorConfig`");
      }
      return new DynamoDbItemEncryptor(this);
    }
  }
}
