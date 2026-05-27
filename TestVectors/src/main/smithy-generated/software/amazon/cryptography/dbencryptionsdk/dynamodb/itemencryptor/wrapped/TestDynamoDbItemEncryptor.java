// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.wrapped;

import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.lang.RuntimeException;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.ToDafny;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.ToNative;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient;

public class TestDynamoDbItemEncryptor implements IDynamoDbItemEncryptorClient {

  private final DynamoDbItemEncryptor _impl;

  protected TestDynamoDbItemEncryptor(BuilderImpl builder) {
    this._impl = builder.impl();
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public Result<DecryptItemOutput, Error> DecryptItem(
    DecryptItemInput dafnyInput
  ) {
    try {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput nativeInput =
        ToNative.DecryptItemInput(dafnyInput);
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput nativeOutput =
        this._impl.DecryptItem(nativeInput);
      DecryptItemOutput dafnyOutput = ToDafny.DecryptItemOutput(nativeOutput);
      return Result.create_Success(
        DecryptItemOutput._typeDescriptor(),
        Error._typeDescriptor(),
        dafnyOutput
      );
    } catch (RuntimeException ex) {
      return Result.create_Failure(
        DecryptItemOutput._typeDescriptor(),
        Error._typeDescriptor(),
        ToDafny.Error(ex)
      );
    }
  }

  public Result<EncryptItemOutput, Error> EncryptItem(
    EncryptItemInput dafnyInput
  ) {
    try {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemInput nativeInput =
        ToNative.EncryptItemInput(dafnyInput);
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemOutput nativeOutput =
        this._impl.EncryptItem(nativeInput);
      EncryptItemOutput dafnyOutput = ToDafny.EncryptItemOutput(nativeOutput);
      return Result.create_Success(
        EncryptItemOutput._typeDescriptor(),
        Error._typeDescriptor(),
        dafnyOutput
      );
    } catch (RuntimeException ex) {
      return Result.create_Failure(
        EncryptItemOutput._typeDescriptor(),
        Error._typeDescriptor(),
        ToDafny.Error(ex)
      );
    }
  }

  public interface Builder {
    Builder impl(DynamoDbItemEncryptor impl);

    DynamoDbItemEncryptor impl();

    TestDynamoDbItemEncryptor build();
  }

  static class BuilderImpl implements Builder {

    protected DynamoDbItemEncryptor impl;

    protected BuilderImpl() {}

    public Builder impl(DynamoDbItemEncryptor impl) {
      this.impl = impl;
      return this;
    }

    public DynamoDbItemEncryptor impl() {
      return this.impl;
    }

    public TestDynamoDbItemEncryptor build() {
      if (Objects.isNull(this.impl())) {
        throw new IllegalArgumentException(
          "Missing value for required field `impl`"
        );
      }
      return new TestDynamoDbItemEncryptor(this);
    }
  }
}
