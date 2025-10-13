// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import Wrappers_Compile.Result;
import java.lang.IllegalArgumentException;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetPartitionNumberInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetPartitionNumberOutput;

public final class PartitionSelector implements IPartitionSelector {

  private final software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IPartitionSelector _impl;

  private PartitionSelector(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IPartitionSelector iPartitionSelector
  ) {
    Objects.requireNonNull(
      iPartitionSelector,
      "Missing value for required argument `iPartitionSelector`"
    );
    this._impl = iPartitionSelector;
  }

  public static PartitionSelector wrap(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IPartitionSelector iPartitionSelector
  ) {
    return new PartitionSelector(iPartitionSelector);
  }

  public static <I extends IPartitionSelector> PartitionSelector wrap(
    I iPartitionSelector
  ) {
    Objects.requireNonNull(
      iPartitionSelector,
      "Missing value for required argument `iPartitionSelector`"
    );
    if (
      iPartitionSelector instanceof
      software.amazon.cryptography.dbencryptionsdk.dynamodb.PartitionSelector
    ) {
      return ((PartitionSelector) iPartitionSelector);
    }
    throw new IllegalArgumentException(
      "Custom implementations of software.amazon.cryptography.dbencryptionsdk.dynamodb.IPartitionSelector are NOT supported at this time."
    );
  }

  public software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IPartitionSelector impl() {
    return this._impl;
  }

  public GetPartitionNumberOutput GetPartitionNumber(
    GetPartitionNumberInput input
  ) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetPartitionNumberInput dafnyValue =
      ToDafny.GetPartitionNumberInput(input);
    Result<
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetPartitionNumberOutput,
      Error
    > result = this._impl.GetPartitionNumber(dafnyValue);
    if (result.is_Failure()) {
      throw ToNative.Error(result.dtor_error());
    }
    return ToNative.GetPartitionNumberOutput(result.dtor_value());
  }
}
