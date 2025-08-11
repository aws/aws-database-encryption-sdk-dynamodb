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
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionOutput;

public class DynamoDbEncryption {

  private final IDynamoDbEncryptionClient _impl;

  protected DynamoDbEncryption(BuilderImpl builder) {
    DynamoDbEncryptionConfig input = builder.DynamoDbEncryptionConfig();
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbEncryptionConfig dafnyValue =
      ToDafny.DynamoDbEncryptionConfig(input);
    Result<DynamoDbEncryptionClient, Error> result =
      __default.DynamoDbEncryption(dafnyValue);
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

  /**
   * Create a Branch Key Supplier for use with the Hierarchical Keyring that decides what Branch Key to use based on the primary key of the DynamoDB item being read or written.
   *
   * @param input Inputs for creating a Branch Key Supplier from a DynamoDB Key Branch Key Id Supplier
   * @return Outputs for creating a Branch Key Supplier from a DynamoDB Key Branch Key Id Supplier
   */
  public CreateDynamoDbEncryptionBranchKeyIdSupplierOutput CreateDynamoDbEncryptionBranchKeyIdSupplier(
    CreateDynamoDbEncryptionBranchKeyIdSupplierInput input
  ) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput dafnyValue =
      ToDafny.CreateDynamoDbEncryptionBranchKeyIdSupplierInput(input);
    Result<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
      Error
    > result =
      this._impl.CreateDynamoDbEncryptionBranchKeyIdSupplier(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
      result.dtor_value()
    );
  }

  /**
   * Returns encrypted data key description.
   *
   * @param input Input for getting encrypted data key description.
   * @return Output for getting encrypted data key description.
   */
  public GetEncryptedDataKeyDescriptionOutput GetEncryptedDataKeyDescription(
    GetEncryptedDataKeyDescriptionInput input
  ) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput dafnyValue =
      ToDafny.GetEncryptedDataKeyDescriptionInput(input);
    Result<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput,
      Error
    > result = this._impl.GetEncryptedDataKeyDescription(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.GetEncryptedDataKeyDescriptionOutput(result.dtor_value());
  }

  protected IDynamoDbEncryptionClient impl() {
    return this._impl;
  }

  public interface Builder {
    Builder DynamoDbEncryptionConfig(
      DynamoDbEncryptionConfig DynamoDbEncryptionConfig
    );

    DynamoDbEncryptionConfig DynamoDbEncryptionConfig();

    DynamoDbEncryption build();
  }

  static class BuilderImpl implements Builder {

    protected DynamoDbEncryptionConfig DynamoDbEncryptionConfig;

    protected BuilderImpl() {}

    public Builder DynamoDbEncryptionConfig(
      DynamoDbEncryptionConfig DynamoDbEncryptionConfig
    ) {
      this.DynamoDbEncryptionConfig = DynamoDbEncryptionConfig;
      return this;
    }

    public DynamoDbEncryptionConfig DynamoDbEncryptionConfig() {
      return this.DynamoDbEncryptionConfig;
    }

    public DynamoDbEncryption build() {
      if (Objects.isNull(this.DynamoDbEncryptionConfig())) {
        throw new IllegalArgumentException(
          "Missing value for required field `DynamoDbEncryptionConfig`"
        );
      }
      return new DynamoDbEncryption(this);
    }
  }
}
