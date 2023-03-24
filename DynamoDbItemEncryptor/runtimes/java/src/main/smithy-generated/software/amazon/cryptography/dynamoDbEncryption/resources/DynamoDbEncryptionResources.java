// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.resources;

import Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.DynamoDbEncryptionResourcesClient;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.IDynamoDbEncryptionResourcesClient;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.__default;
import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.util.Objects;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.DynamoDbEncryptionResourcesConfig;

public class DynamoDbEncryptionResources {
  private final IDynamoDbEncryptionResourcesClient _impl;

  protected DynamoDbEncryptionResources(BuilderImpl builder) {
    DynamoDbEncryptionResourcesConfig nativeValue = builder.DynamoDbEncryptionResourcesConfig();
    Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.DynamoDbEncryptionResourcesConfig dafnyValue = ToDafny.DynamoDbEncryptionResourcesConfig(nativeValue);
    Result<DynamoDbEncryptionResourcesClient, Error> result = __default.DynamoDbEncryptionResources(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    this._impl = result.dtor_value();
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public CreateDynamoDbEncryptionBranchKeyIdSupplierOutput CreateDynamoDbEncryptionBranchKeyIdSupplier(
      CreateDynamoDbEncryptionBranchKeyIdSupplierInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput dafnyValue = ToDafny.CreateDynamoDbEncryptionBranchKeyIdSupplierInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error> result = this._impl.CreateDynamoDbEncryptionBranchKeyIdSupplier(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(result.dtor_value());
  }

  protected IDynamoDbEncryptionResourcesClient impl() {
    return this._impl;
  }

  public interface Builder {
    Builder DynamoDbEncryptionResourcesConfig(
        DynamoDbEncryptionResourcesConfig DynamoDbEncryptionResourcesConfig);

    DynamoDbEncryptionResourcesConfig DynamoDbEncryptionResourcesConfig();

    DynamoDbEncryptionResources build();
  }

  static class BuilderImpl implements Builder {
    protected DynamoDbEncryptionResourcesConfig DynamoDbEncryptionResourcesConfig;

    protected BuilderImpl() {
    }

    public Builder DynamoDbEncryptionResourcesConfig(
        DynamoDbEncryptionResourcesConfig DynamoDbEncryptionResourcesConfig) {
      this.DynamoDbEncryptionResourcesConfig = DynamoDbEncryptionResourcesConfig;
      return this;
    }

    public DynamoDbEncryptionResourcesConfig DynamoDbEncryptionResourcesConfig() {
      return this.DynamoDbEncryptionResourcesConfig;
    }

    public DynamoDbEncryptionResources build() {
      if (Objects.isNull(this.DynamoDbEncryptionResourcesConfig()))  {
        throw new IllegalArgumentException("Missing value for required field `DynamoDbEncryptionResourcesConfig`");
      }
      return new DynamoDbEncryptionResources(this);
    }
  }
}
