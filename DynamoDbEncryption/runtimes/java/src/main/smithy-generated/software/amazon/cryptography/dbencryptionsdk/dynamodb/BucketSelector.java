// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBucketNumberInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBucketNumberOutput;

public final class BucketSelector implements IBucketSelector {

  private final software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IBucketSelector _impl;

  private BucketSelector(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IBucketSelector iBucketSelector
  ) {
    Objects.requireNonNull(
      iBucketSelector,
      "Missing value for required argument `iBucketSelector`"
    );
    this._impl = iBucketSelector;
  }

  public static BucketSelector wrap(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IBucketSelector iBucketSelector
  ) {
    return new BucketSelector(iBucketSelector);
  }

  public static <I extends IBucketSelector> BucketSelector wrap(
    I iBucketSelector
  ) {
    Objects.requireNonNull(
      iBucketSelector,
      "Missing value for required argument `iBucketSelector`"
    );
    if (
      iBucketSelector instanceof
      software.amazon.cryptography.dbencryptionsdk.dynamodb.BucketSelector
    ) {
      return ((BucketSelector) iBucketSelector);
    }
    throw new IllegalArgumentException(
      "Custom implementations of software.amazon.cryptography.dbencryptionsdk.dynamodb.IBucketSelector are NOT supported at this time."
    );
  }

  public software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IBucketSelector impl() {
    return this._impl;
  }

  public GetBucketNumberOutput GetBucketNumber(GetBucketNumberInput input) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBucketNumberInput dafnyValue =
      ToDafny.GetBucketNumberInput(input);
    Result<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBucketNumberOutput,
      Error
    > result = this._impl.GetBucketNumber(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.GetBucketNumberOutput(result.dtor_value());
  }
}
