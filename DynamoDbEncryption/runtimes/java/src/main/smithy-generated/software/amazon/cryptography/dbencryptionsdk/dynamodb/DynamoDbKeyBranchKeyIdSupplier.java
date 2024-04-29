// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.lang.RuntimeException;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBranchKeyIdFromDdbKeyInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBranchKeyIdFromDdbKeyOutput;

public final class DynamoDbKeyBranchKeyIdSupplier
  implements IDynamoDbKeyBranchKeyIdSupplier {

  private final software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier _impl;

  private DynamoDbKeyBranchKeyIdSupplier(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier iDynamoDbKeyBranchKeyIdSupplier
  ) {
    Objects.requireNonNull(
      iDynamoDbKeyBranchKeyIdSupplier,
      "Missing value for required argument `iDynamoDbKeyBranchKeyIdSupplier`"
    );
    this._impl = iDynamoDbKeyBranchKeyIdSupplier;
  }

  public static DynamoDbKeyBranchKeyIdSupplier wrap(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier iDynamoDbKeyBranchKeyIdSupplier
  ) {
    return new DynamoDbKeyBranchKeyIdSupplier(iDynamoDbKeyBranchKeyIdSupplier);
  }

  public static <
    I extends IDynamoDbKeyBranchKeyIdSupplier
  > DynamoDbKeyBranchKeyIdSupplier wrap(I iDynamoDbKeyBranchKeyIdSupplier) {
    Objects.requireNonNull(
      iDynamoDbKeyBranchKeyIdSupplier,
      "Missing value for required argument `iDynamoDbKeyBranchKeyIdSupplier`"
    );
    if (
      iDynamoDbKeyBranchKeyIdSupplier instanceof
      software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbKeyBranchKeyIdSupplier
    ) {
      return ((DynamoDbKeyBranchKeyIdSupplier) iDynamoDbKeyBranchKeyIdSupplier);
    }
    return DynamoDbKeyBranchKeyIdSupplier.wrap(
      new NativeWrapper(iDynamoDbKeyBranchKeyIdSupplier)
    );
  }

  public software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier impl() {
    return this._impl;
  }

  /**
   * Get the Branch Key that should be used for wrapping and unwrapping data keys based on the primary key of the item being read or written, along with the values of any attributes configured as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.
   *
   * @param input Inputs for getting the Branch Key that should be used for wrapping and unwrapping data keys.
   * @return Outputs for getting the Branch Key that should be used for wrapping and unwrapping data keys.
   */
  public GetBranchKeyIdFromDdbKeyOutput GetBranchKeyIdFromDdbKey(
    GetBranchKeyIdFromDdbKeyInput input
  ) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyInput dafnyValue =
      ToDafny.GetBranchKeyIdFromDdbKeyInput(input);
    Result<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput,
      Error
    > result = this._impl.GetBranchKeyIdFromDdbKey(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.GetBranchKeyIdFromDdbKeyOutput(result.dtor_value());
  }

  protected static final class NativeWrapper
    implements
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier {

    protected final IDynamoDbKeyBranchKeyIdSupplier _impl;

    NativeWrapper(IDynamoDbKeyBranchKeyIdSupplier nativeImpl) {
      if (nativeImpl instanceof DynamoDbKeyBranchKeyIdSupplier) {
        throw new IllegalArgumentException(
          "Recursive wrapping is strictly forbidden."
        );
      }
      this._impl = nativeImpl;
    }

    public Result<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput,
      Error
    > GetBranchKeyIdFromDdbKey(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyInput dafnyInput
    ) {
      try {
        GetBranchKeyIdFromDdbKeyInput nativeInput =
          ToNative.GetBranchKeyIdFromDdbKeyInput(dafnyInput);
        GetBranchKeyIdFromDdbKeyOutput nativeOutput =
          this._impl.GetBranchKeyIdFromDdbKey(nativeInput);
        software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput dafnyOutput =
          ToDafny.GetBranchKeyIdFromDdbKeyOutput(nativeOutput);
        return Result.create_Success(dafnyOutput);
      } catch (RuntimeException ex) {
        return Result.create_Failure(ToDafny.Error(ex));
      }
    }

    public Result<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput,
      Error
    > GetBranchKeyIdFromDdbKey_k(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyInput dafnyInput
    ) {
      throw new RuntimeException("Not supported at this time.");
    }
  }
}
