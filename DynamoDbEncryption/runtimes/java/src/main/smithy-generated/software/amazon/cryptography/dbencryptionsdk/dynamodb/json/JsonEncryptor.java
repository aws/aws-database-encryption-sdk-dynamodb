// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json;

import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.__default;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.IJsonEncryptorClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.DecryptObjectInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.DecryptObjectOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.EncryptObjectInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.EncryptObjectOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.JsonEncryptorConfig;

public class JsonEncryptor {
  private final IJsonEncryptorClient _impl;

  protected JsonEncryptor(BuilderImpl builder) {
    JsonEncryptorConfig input = builder.JsonEncryptorConfig();
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.JsonEncryptorConfig dafnyValue = ToDafny.JsonEncryptorConfig(input);
    Result<IJsonEncryptorClient, Error> result = __default.JsonEncryptor(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    this._impl = result.dtor_value();
  }

  JsonEncryptor(IJsonEncryptorClient impl) {
    this._impl = impl;
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  /**
   * Decrypt a Json object.
   *
   * @param input Inputs for decrypting a JSON object.
   * @return Outputs for decrypting a JSON object.
   */
  public DecryptObjectOutput DecryptObject(DecryptObjectInput input) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DecryptObjectInput dafnyValue = ToDafny.DecryptObjectInput(input);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DecryptObjectOutput, Error> result = this._impl.DecryptObject(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.DecryptObjectOutput(result.dtor_value());
  }

  /**
   * Encrypt a Json object.
   *
   * @param input Inputs for encrypting a JSON object.
   * @return Outputs for encrypting a JSON object.
   */
  public EncryptObjectOutput EncryptObject(EncryptObjectInput input) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EncryptObjectInput dafnyValue = ToDafny.EncryptObjectInput(input);
    Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EncryptObjectOutput, Error> result = this._impl.EncryptObject(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.EncryptObjectOutput(result.dtor_value());
  }

  protected IJsonEncryptorClient impl() {
    return this._impl;
  }

  public interface Builder {
    /**
     * @param JsonEncryptorConfig The configuration for the client-side encryption of JSON objects.
     */
    Builder JsonEncryptorConfig(JsonEncryptorConfig JsonEncryptorConfig);

    /**
     * @return The configuration for the client-side encryption of JSON objects.
     */
    JsonEncryptorConfig JsonEncryptorConfig();

    JsonEncryptor build();
  }

  static class BuilderImpl implements Builder {
    protected JsonEncryptorConfig JsonEncryptorConfig;

    protected BuilderImpl() {
    }

    public Builder JsonEncryptorConfig(JsonEncryptorConfig JsonEncryptorConfig) {
      this.JsonEncryptorConfig = JsonEncryptorConfig;
      return this;
    }

    public JsonEncryptorConfig JsonEncryptorConfig() {
      return this.JsonEncryptorConfig;
    }

    public JsonEncryptor build() {
      if (Objects.isNull(this.JsonEncryptorConfig()))  {
        throw new IllegalArgumentException("Missing value for required field `JsonEncryptorConfig`");
      }
      return new JsonEncryptor(this);
    }
  }
}
