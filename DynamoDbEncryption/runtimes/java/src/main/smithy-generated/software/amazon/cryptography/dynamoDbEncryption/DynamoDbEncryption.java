// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption;

import Dafny.Aws.Cryptography.DynamoDbEncryption.DynamoDbEncryptionClient;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbEncryptionClient;
import Dafny.Aws.Cryptography.DynamoDbEncryption.__default;
import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.util.Objects;
import software.amazon.cryptography.dynamoDbEncryption.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dynamoDbEncryption.model.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig;

public class DynamoDbEncryption {
  private final IDynamoDbEncryptionClient _impl;

  protected DynamoDbEncryption(BuilderImpl builder) {
    DynamoDbEncryptionConfig nativeValue = builder.DynamoDbEncryptionConfig();
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbEncryptionConfig dafnyValue = ToDafny.DynamoDbEncryptionConfig(nativeValue);
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
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput dafnyValue = ToDafny.CreateDynamoDbEncryptionBranchKeyIdSupplierInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error> result = this._impl.CreateDynamoDbEncryptionBranchKeyIdSupplier(dafnyValue);
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
