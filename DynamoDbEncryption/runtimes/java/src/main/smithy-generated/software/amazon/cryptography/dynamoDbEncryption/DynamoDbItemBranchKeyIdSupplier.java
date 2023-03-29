// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption;

import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error;
import Wrappers_Compile.Result;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.util.Objects;
import software.amazon.cryptography.dynamoDbEncryption.model.GetBranchKeyIdFromItemInput;
import software.amazon.cryptography.dynamoDbEncryption.model.GetBranchKeyIdFromItemOutput;
import software.amazon.cryptography.dynamoDbEncryption.model.NativeError;
import software.amazon.cryptography.dynamoDbEncryption.model.OpaqueError;

public final class DynamoDbItemBranchKeyIdSupplier implements IDynamoDbItemBranchKeyIdSupplier {
  private final Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbItemBranchKeyIdSupplier _impl;

  private DynamoDbItemBranchKeyIdSupplier(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbItemBranchKeyIdSupplier iDynamoDbItemBranchKeyIdSupplier) {
    Objects.requireNonNull(iDynamoDbItemBranchKeyIdSupplier, "Missing value for required argument `iDynamoDbItemBranchKeyIdSupplier`");
    this._impl = iDynamoDbItemBranchKeyIdSupplier;
  }

  public static DynamoDbItemBranchKeyIdSupplier wrap(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbItemBranchKeyIdSupplier iDynamoDbItemBranchKeyIdSupplier) {
    return new DynamoDbItemBranchKeyIdSupplier(iDynamoDbItemBranchKeyIdSupplier);
  }

  public static <I extends IDynamoDbItemBranchKeyIdSupplier> DynamoDbItemBranchKeyIdSupplier wrap(
      I iDynamoDbItemBranchKeyIdSupplier) {
    Objects.requireNonNull(iDynamoDbItemBranchKeyIdSupplier, "Missing value for required argument `iDynamoDbItemBranchKeyIdSupplier`");
    if (iDynamoDbItemBranchKeyIdSupplier instanceof software.amazon.cryptography.dynamoDbEncryption.DynamoDbItemBranchKeyIdSupplier) {
      return ((DynamoDbItemBranchKeyIdSupplier) iDynamoDbItemBranchKeyIdSupplier);
    }
    return DynamoDbItemBranchKeyIdSupplier.wrap(new NativeWrapper(iDynamoDbItemBranchKeyIdSupplier));
  }

  public Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbItemBranchKeyIdSupplier impl() {
    return this._impl;
  }

  public GetBranchKeyIdFromItemOutput GetBranchKeyIdFromItem(
      GetBranchKeyIdFromItemInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromItemInput dafnyValue = ToDafny.GetBranchKeyIdFromItemInput(nativeValue);
    Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromItemOutput, Error> result = this._impl.GetBranchKeyIdFromItem(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.GetBranchKeyIdFromItemOutput(result.dtor_value());
  }

  private static final class NativeWrapper implements Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbItemBranchKeyIdSupplier {
    private final IDynamoDbItemBranchKeyIdSupplier _impl;

    NativeWrapper(IDynamoDbItemBranchKeyIdSupplier nativeImpl) {
      if (nativeImpl instanceof DynamoDbItemBranchKeyIdSupplier) {
        throw new IllegalArgumentException("Recursive wrapping is strictly forbidden.");
      }
      this._impl = nativeImpl;
    }

    public Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromItemOutput, Error> GetBranchKeyIdFromItem(
        Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromItemInput dafnyInput) {
      GetBranchKeyIdFromItemInput nativeInput = ToNative.GetBranchKeyIdFromItemInput(dafnyInput);
      try {
        GetBranchKeyIdFromItemOutput nativeOutput = this._impl.GetBranchKeyIdFromItem(nativeInput);
        Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromItemOutput dafnyOutput = ToDafny.GetBranchKeyIdFromItemOutput(nativeOutput);
        return Result.create_Success(dafnyOutput);
      } catch (NativeError ex) {
        return Result.create_Failure(ToDafny.Error(ex));
      } catch (Exception ex) {
        OpaqueError error = OpaqueError.builder().obj(ex).cause(ex).build();
        return Result.create_Failure(ToDafny.Error(error));
      }
    }

    public Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromItemOutput, Error> GetBranchKeyIdFromItem_k(
        Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromItemInput dafnyInput) {
      throw NativeError.builder().message("Not supported at this time.").build();
    }
  }
}
