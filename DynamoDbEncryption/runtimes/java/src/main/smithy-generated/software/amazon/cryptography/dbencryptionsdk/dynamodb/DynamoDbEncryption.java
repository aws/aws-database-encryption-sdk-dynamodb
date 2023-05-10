// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionConfig;

public class DynamoDbEncryption {
  private final IDynamoDbEncryptionClient _impl;

  protected DynamoDbEncryption(BuilderImpl builder) {
    DynamoDbEncryptionConfig nativeValue = builder.DynamoDbEncryptionConfig();
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbEncryptionConfig dafnyValue = ToDafny.DynamoDbEncryptionConfig(nativeValue);
    Result<DynamoDbEncryptionClient, Error> result = __default.DynamoDbEncryption(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    this._impl = result.dtor_value();
  }

  DynamoDbEncryption(IDynamoDbEncryptionClient impl) {
    this._impl = impl;
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public CreateDynamoDbEncryptionBranchKeyIdSupplierOutput CreateDynamoDbEncryptionBranchKeyIdSupplier(
      CreateDynamoDbEncryptionBranchKeyIdSupplierInput nativeValue) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput dafnyValue = ToDafny.CreateDynamoDbEncryptionBranchKeyIdSupplierInput(nativeValue);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error> result = this._impl.CreateDynamoDbEncryptionBranchKeyIdSupplier(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(result.dtor_value());
  }

  protected IDynamoDbEncryptionClient impl() {
    return this._impl;
  }

  public interface Builder {
    Builder DynamoDbEncryptionConfig(DynamoDbEncryptionConfig DynamoDbEncryptionConfig);

    DynamoDbEncryptionConfig DynamoDbEncryptionConfig();

    DynamoDbEncryption build();
  }

  static class BuilderImpl implements Builder {
    protected DynamoDbEncryptionConfig DynamoDbEncryptionConfig;

    protected BuilderImpl() {
    }

    public Builder DynamoDbEncryptionConfig(DynamoDbEncryptionConfig DynamoDbEncryptionConfig) {
      this.DynamoDbEncryptionConfig = DynamoDbEncryptionConfig;
      return this;
    }

    public DynamoDbEncryptionConfig DynamoDbEncryptionConfig() {
      return this.DynamoDbEncryptionConfig;
    }

    public DynamoDbEncryption build() {
      if (Objects.isNull(this.DynamoDbEncryptionConfig()))  {
        throw new IllegalArgumentException("Missing value for required field `DynamoDbEncryptionConfig`");
      }
      return new DynamoDbEncryption(this);
    }
  }
}
