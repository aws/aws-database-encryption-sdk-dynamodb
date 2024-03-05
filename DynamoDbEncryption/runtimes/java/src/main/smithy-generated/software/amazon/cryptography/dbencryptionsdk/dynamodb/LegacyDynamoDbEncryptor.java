// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import java.lang.IllegalArgumentException;
import java.util.Objects;

public final class LegacyDynamoDbEncryptor implements ILegacyDynamoDbEncryptor {

  private final software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor _impl;

  private LegacyDynamoDbEncryptor(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor iLegacyDynamoDbEncryptor
  ) {
    Objects.requireNonNull(
      iLegacyDynamoDbEncryptor,
      "Missing value for required argument `iLegacyDynamoDbEncryptor`"
    );
    this._impl = iLegacyDynamoDbEncryptor;
  }

  public static LegacyDynamoDbEncryptor wrap(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor iLegacyDynamoDbEncryptor
  ) {
    return new LegacyDynamoDbEncryptor(iLegacyDynamoDbEncryptor);
  }

  public static <
    I extends ILegacyDynamoDbEncryptor
  > LegacyDynamoDbEncryptor wrap(I iLegacyDynamoDbEncryptor) {
    Objects.requireNonNull(
      iLegacyDynamoDbEncryptor,
      "Missing value for required argument `iLegacyDynamoDbEncryptor`"
    );
    if (
      iLegacyDynamoDbEncryptor instanceof
      software.amazon.cryptography.dbencryptionsdk.dynamodb.LegacyDynamoDbEncryptor
    ) {
      return ((LegacyDynamoDbEncryptor) iLegacyDynamoDbEncryptor);
    }
    return LegacyDynamoDbEncryptor.wrap(
      new NativeWrapper(iLegacyDynamoDbEncryptor)
    );
  }

  public software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor impl() {
    return this._impl;
  }

  protected static final class NativeWrapper
    implements
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor {

    protected final ILegacyDynamoDbEncryptor _impl;

    NativeWrapper(ILegacyDynamoDbEncryptor nativeImpl) {
      if (nativeImpl instanceof LegacyDynamoDbEncryptor) {
        throw new IllegalArgumentException(
          "Recursive wrapping is strictly forbidden."
        );
      }
      this._impl = nativeImpl;
    }
  }
}
