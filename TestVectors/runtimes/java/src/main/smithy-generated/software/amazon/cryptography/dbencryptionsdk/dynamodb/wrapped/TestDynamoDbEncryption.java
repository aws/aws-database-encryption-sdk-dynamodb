// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.wrapped;

import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.lang.RuntimeException;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryption;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient;

public class TestDynamoDbEncryption implements IDynamoDbEncryptionClient {

  private final DynamoDbEncryption _impl;

  protected TestDynamoDbEncryption(BuilderImpl builder) {
    this._impl = builder.impl();
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public Result<
    CreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
    Error
  > CreateDynamoDbEncryptionBranchKeyIdSupplier(
    CreateDynamoDbEncryptionBranchKeyIdSupplierInput dafnyInput
  ) {
    try {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput nativeInput =
        ToNative.CreateDynamoDbEncryptionBranchKeyIdSupplierInput(dafnyInput);
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput nativeOutput =
        this._impl.CreateDynamoDbEncryptionBranchKeyIdSupplier(nativeInput);
      CreateDynamoDbEncryptionBranchKeyIdSupplierOutput dafnyOutput =
        ToDafny.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(nativeOutput);
      return Result.create_Success(dafnyOutput);
    } catch (RuntimeException ex) {
      return Result.create_Failure(ToDafny.Error(ex));
    }
  }

  public interface Builder {
    Builder impl(DynamoDbEncryption impl);

    DynamoDbEncryption impl();

    TestDynamoDbEncryption build();
  }

  static class BuilderImpl implements Builder {

    protected DynamoDbEncryption impl;

    protected BuilderImpl() {}

    public Builder impl(DynamoDbEncryption impl) {
      this.impl = impl;
      return this;
    }

    public DynamoDbEncryption impl() {
      return this.impl;
    }

    public TestDynamoDbEncryption build() {
      if (Objects.isNull(this.impl())) {
        throw new IllegalArgumentException(
          "Missing value for required field `impl`"
        );
      }
      return new TestDynamoDbEncryption(this);
    }
  }
}
