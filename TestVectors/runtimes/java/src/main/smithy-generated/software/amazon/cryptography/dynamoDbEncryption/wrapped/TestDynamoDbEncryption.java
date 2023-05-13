// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.wrapped;

import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbEncryptionClient;
import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.lang.RuntimeException;
import java.util.Objects;
import software.amazon.cryptography.dynamoDbEncryption.DynamoDbEncryption;
import software.amazon.cryptography.dynamoDbEncryption.ToDafny;
import software.amazon.cryptography.dynamoDbEncryption.ToNative;

public class TestDynamoDbEncryption implements IDynamoDbEncryptionClient {
  private final DynamoDbEncryption _impl;

  protected TestDynamoDbEncryption(BuilderImpl builder) {
    this._impl = builder.impl();
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public Result<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error> CreateDynamoDbEncryptionBranchKeyIdSupplier(
      CreateDynamoDbEncryptionBranchKeyIdSupplierInput dafnyInput) {
    software.amazon.cryptography.dynamoDbEncryption.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput nativeInput = ToNative.CreateDynamoDbEncryptionBranchKeyIdSupplierInput(dafnyInput);
    try {
      software.amazon.cryptography.dynamoDbEncryption.model.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput nativeOutput = this._impl.CreateDynamoDbEncryptionBranchKeyIdSupplier(nativeInput);
      CreateDynamoDbEncryptionBranchKeyIdSupplierOutput dafnyOutput = ToDafny.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(nativeOutput);
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

    protected BuilderImpl() {
    }

    public Builder impl(DynamoDbEncryption impl) {
      this.impl = impl;
      return this;
    }

    public DynamoDbEncryption impl() {
      return this.impl;
    }

    public TestDynamoDbEncryption build() {
      if (Objects.isNull(this.impl()))  {
        throw new IllegalArgumentException("Missing value for required field `impl`");
      }
      return new TestDynamoDbEncryption(this);
    }
  }
}
