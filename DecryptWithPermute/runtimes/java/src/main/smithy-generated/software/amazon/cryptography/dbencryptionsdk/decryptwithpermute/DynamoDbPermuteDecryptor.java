// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.decryptwithpermute;

import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.DynamoDbPermuteDecryptorClient;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.__default;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.IDynamoDbPermuteDecryptorClient;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model.DynamoDbPermuteDecryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model.PermuteDecryptInput;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model.PermuteDecryptOutput;

public class DynamoDbPermuteDecryptor {
  private final IDynamoDbPermuteDecryptorClient _impl;

  protected DynamoDbPermuteDecryptor(BuilderImpl builder) {
    DynamoDbPermuteDecryptorConfig input = builder.DynamoDbPermuteDecryptorConfig();
    software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.DynamoDbPermuteDecryptorConfig dafnyValue = ToDafny.DynamoDbPermuteDecryptorConfig(input);
    Result<DynamoDbPermuteDecryptorClient, Error> result = __default.DynamoDbPermuteDecryptor(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    this._impl = result.dtor_value();
  }

  DynamoDbPermuteDecryptor(IDynamoDbPermuteDecryptorClient impl) {
    this._impl = impl;
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  /**
   * Decrypt a DynamoDB Item, permute sets as necessary to match signature.
   * @return Outputs for decrypting a DynamoDB Item.
   */
  public PermuteDecryptOutput PermuteDecrypt(PermuteDecryptInput input) {
    software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.PermuteDecryptInput dafnyValue = ToDafny.PermuteDecryptInput(input);
    Result<software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.PermuteDecryptOutput, Error> result = this._impl.PermuteDecrypt(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.PermuteDecryptOutput(result.dtor_value());
  }

  protected IDynamoDbPermuteDecryptorClient impl() {
    return this._impl;
  }

  public interface Builder {
    /**
     * @param DynamoDbPermuteDecryptorConfig The configuration for the client-side encryption of DynamoDB items.
     */
    Builder DynamoDbPermuteDecryptorConfig(
        DynamoDbPermuteDecryptorConfig DynamoDbPermuteDecryptorConfig);

    /**
     * @return The configuration for the client-side encryption of DynamoDB items.
     */
    DynamoDbPermuteDecryptorConfig DynamoDbPermuteDecryptorConfig();

    DynamoDbPermuteDecryptor build();
  }

  static class BuilderImpl implements Builder {
    protected DynamoDbPermuteDecryptorConfig DynamoDbPermuteDecryptorConfig;

    protected BuilderImpl() {
    }

    public Builder DynamoDbPermuteDecryptorConfig(
        DynamoDbPermuteDecryptorConfig DynamoDbPermuteDecryptorConfig) {
      this.DynamoDbPermuteDecryptorConfig = DynamoDbPermuteDecryptorConfig;
      return this;
    }

    public DynamoDbPermuteDecryptorConfig DynamoDbPermuteDecryptorConfig() {
      return this.DynamoDbPermuteDecryptorConfig;
    }

    public DynamoDbPermuteDecryptor build() {
      if (Objects.isNull(this.DynamoDbPermuteDecryptorConfig()))  {
        throw new IllegalArgumentException("Missing value for required field `DynamoDbPermuteDecryptorConfig`");
      }
      return new DynamoDbPermuteDecryptor(this);
    }
  }
}
