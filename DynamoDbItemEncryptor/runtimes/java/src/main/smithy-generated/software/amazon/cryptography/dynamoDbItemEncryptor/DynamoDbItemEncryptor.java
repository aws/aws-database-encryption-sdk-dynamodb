// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbItemEncryptor;

import Dafny.Aws.Cryptography.DynamoDbItemEncryptor.DynamoDbItemEncryptorClient;
import Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.IDynamoDbItemEncryptorClient;
import Dafny.Aws.Cryptography.DynamoDbItemEncryptor.__default;
import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.util.Objects;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.DecryptItemInput;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.DecryptItemOutput;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.EncryptItemInput;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.EncryptItemOutput;

public class DynamoDbItemEncryptor {
  private final IDynamoDbItemEncryptorClient _impl;

  protected DynamoDbItemEncryptor(BuilderImpl builder) {
    DynamoDbItemEncryptorConfig nativeValue = builder.DynamoDbItemEncryptorConfig();
    Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.DynamoDbItemEncryptorConfig dafnyValue = ToDafny.DynamoDbItemEncryptorConfig(nativeValue);
    Result<DynamoDbItemEncryptorClient, Error> result = __default.DynamoDbItemEncryptor(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    this._impl = result.dtor_value();
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  protected IDynamoDbItemEncryptorClient impl() {
    return this._impl;
  }

  public EncryptItemOutput EncryptItem(EncryptItemInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.EncryptItemInput dafnyValue = ToDafny.EncryptItemInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.EncryptItemOutput, Error> result = this._impl.EncryptItem(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.EncryptItemOutput(result.dtor_value());
  }

  public DecryptItemOutput DecryptItem(DecryptItemInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.DecryptItemInput dafnyValue = ToDafny.DecryptItemInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types.DecryptItemOutput, Error> result = this._impl.DecryptItem(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DecryptItemOutput(result.dtor_value());
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
