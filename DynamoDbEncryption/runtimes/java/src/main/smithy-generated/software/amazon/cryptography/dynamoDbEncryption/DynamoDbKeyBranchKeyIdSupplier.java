// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption;

import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error;
import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.lang.RuntimeException;
import java.util.Objects;
import software.amazon.cryptography.dynamoDbEncryption.model.GetBranchKeyIdFromDdbKeyInput;
import software.amazon.cryptography.dynamoDbEncryption.model.GetBranchKeyIdFromDdbKeyOutput;

public final class DynamoDbKeyBranchKeyIdSupplier implements IDynamoDbKeyBranchKeyIdSupplier {
  private final Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbKeyBranchKeyIdSupplier _impl;

  private DynamoDbKeyBranchKeyIdSupplier(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbKeyBranchKeyIdSupplier iDynamoDbKeyBranchKeyIdSupplier) {
    Objects.requireNonNull(iDynamoDbKeyBranchKeyIdSupplier, "Missing value for required argument `iDynamoDbKeyBranchKeyIdSupplier`");
    this._impl = iDynamoDbKeyBranchKeyIdSupplier;
  }

  public static DynamoDbKeyBranchKeyIdSupplier wrap(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbKeyBranchKeyIdSupplier iDynamoDbKeyBranchKeyIdSupplier) {
    return new DynamoDbKeyBranchKeyIdSupplier(iDynamoDbKeyBranchKeyIdSupplier);
  }

  public static <I extends IDynamoDbKeyBranchKeyIdSupplier> DynamoDbKeyBranchKeyIdSupplier wrap(
      I iDynamoDbKeyBranchKeyIdSupplier) {
    Objects.requireNonNull(iDynamoDbKeyBranchKeyIdSupplier, "Missing value for required argument `iDynamoDbKeyBranchKeyIdSupplier`");
    if (iDynamoDbKeyBranchKeyIdSupplier instanceof software.amazon.cryptography.dynamoDbEncryption.DynamoDbKeyBranchKeyIdSupplier) {
      return ((DynamoDbKeyBranchKeyIdSupplier) iDynamoDbKeyBranchKeyIdSupplier);
    }
    return DynamoDbKeyBranchKeyIdSupplier.wrap(new NativeWrapper(iDynamoDbKeyBranchKeyIdSupplier));
  }

  public Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbKeyBranchKeyIdSupplier impl() {
    return this._impl;
  }

  public GetBranchKeyIdFromDdbKeyOutput GetBranchKeyIdFromDdbKey(
      GetBranchKeyIdFromDdbKeyInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyInput dafnyValue = ToDafny.GetBranchKeyIdFromDdbKeyInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput, Error> result = this._impl.GetBranchKeyIdFromDdbKey(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.GetBranchKeyIdFromDdbKeyOutput(result.dtor_value());
  }

  protected static final class NativeWrapper implements Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbKeyBranchKeyIdSupplier {
    protected final IDynamoDbKeyBranchKeyIdSupplier _impl;

    NativeWrapper(IDynamoDbKeyBranchKeyIdSupplier nativeImpl) {
      if (nativeImpl instanceof DynamoDbKeyBranchKeyIdSupplier) {
        throw new IllegalArgumentException("Recursive wrapping is strictly forbidden.");
      }
      this._impl = nativeImpl;
    }

    public Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput, Error> GetBranchKeyIdFromDdbKey(
        Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyInput dafnyInput) {
      GetBranchKeyIdFromDdbKeyInput nativeInput = ToNative.GetBranchKeyIdFromDdbKeyInput(dafnyInput);
      try {
        GetBranchKeyIdFromDdbKeyOutput nativeOutput = this._impl.GetBranchKeyIdFromDdbKey(nativeInput);
        Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput dafnyOutput = ToDafny.GetBranchKeyIdFromDdbKeyOutput(nativeOutput);
        return Result.create_Success(dafnyOutput);
      } catch (RuntimeException ex) {
        return Result.create_Failure(ToDafny.Error(ex));
      }
    }

    public Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput, Error> GetBranchKeyIdFromDdbKey_k(
        Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyInput dafnyInput) {
      throw new RuntimeException("Not supported at this time.");
    }
  }
}
