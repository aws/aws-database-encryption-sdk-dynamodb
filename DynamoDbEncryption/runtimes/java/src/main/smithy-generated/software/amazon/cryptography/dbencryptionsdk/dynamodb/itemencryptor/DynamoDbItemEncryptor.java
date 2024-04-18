// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor;

import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.__default;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemOutput;

public class DynamoDbItemEncryptor {

  private final IDynamoDbItemEncryptorClient _impl;

  protected DynamoDbItemEncryptor(BuilderImpl builder) {
    DynamoDbItemEncryptorConfig input = builder.DynamoDbItemEncryptorConfig();
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig dafnyValue =
      ToDafny.DynamoDbItemEncryptorConfig(input);
    Result<DynamoDbItemEncryptorClient, Error> result =
      __default.DynamoDbItemEncryptor(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    this._impl = result.dtor_value();
  }

  DynamoDbItemEncryptor(IDynamoDbItemEncryptorClient impl) {
    this._impl = impl;
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  /**
   * Decrypt a DynamoDB Item.
   *
   * @param input Inputs for decrypting a DynamoDB Item.
   * @return Outputs for decrypting a DynamoDB Item.
   */
  public DecryptItemOutput DecryptItem(DecryptItemInput input) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput dafnyValue =
      ToDafny.DecryptItemInput(input);
    Result<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput,
      Error
    > result = this._impl.DecryptItem(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DecryptItemOutput(result.dtor_value());
  }

  /**
   * Encrypt a DynamoDB Item.
   *
   * @param input Inputs for encrypting a DynamoDB Item.
   * @return Outputs for encrypting a DynamoDB Item.
   */
  public EncryptItemOutput EncryptItem(EncryptItemInput input) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput dafnyValue =
      ToDafny.EncryptItemInput(input);
    Result<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput,
      Error
    > result = this._impl.EncryptItem(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.EncryptItemOutput(result.dtor_value());
  }

  protected IDynamoDbItemEncryptorClient impl() {
    return this._impl;
  }

  public interface Builder {
    /**
     * @param DynamoDbItemEncryptorConfig The configuration for the client-side encryption of DynamoDB items.
     */
    Builder DynamoDbItemEncryptorConfig(
      DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig
    );

    /**
     * @return The configuration for the client-side encryption of DynamoDB items.
     */
    DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig();

    DynamoDbItemEncryptor build();
  }

  static class BuilderImpl implements Builder {

    protected DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig;

    protected BuilderImpl() {}

    public Builder DynamoDbItemEncryptorConfig(
      DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig
    ) {
      this.DynamoDbItemEncryptorConfig = DynamoDbItemEncryptorConfig;
      return this;
    }

    public DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig() {
      return this.DynamoDbItemEncryptorConfig;
    }

    public DynamoDbItemEncryptor build() {
      if (Objects.isNull(this.DynamoDbItemEncryptorConfig())) {
        throw new IllegalArgumentException(
          "Missing value for required field `DynamoDbItemEncryptorConfig`"
        );
      }
      return new DynamoDbItemEncryptor(this);
    }
  }
}
