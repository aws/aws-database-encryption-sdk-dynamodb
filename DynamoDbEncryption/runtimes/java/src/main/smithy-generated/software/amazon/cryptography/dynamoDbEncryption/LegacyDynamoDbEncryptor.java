// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption;

import java.lang.IllegalArgumentException;
import java.util.Objects;

public final class LegacyDynamoDbEncryptor implements ILegacyDynamoDbEncryptor {
  private final Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ILegacyDynamoDbEncryptor _impl;

  private LegacyDynamoDbEncryptor(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ILegacyDynamoDbEncryptor iLegacyDynamoDbEncryptor) {
    Objects.requireNonNull(iLegacyDynamoDbEncryptor, "Missing value for required argument `iLegacyDynamoDbEncryptor`");
    this._impl = iLegacyDynamoDbEncryptor;
  }

  public static LegacyDynamoDbEncryptor wrap(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ILegacyDynamoDbEncryptor iLegacyDynamoDbEncryptor) {
    return new LegacyDynamoDbEncryptor(iLegacyDynamoDbEncryptor);
  }

  public static <I extends ILegacyDynamoDbEncryptor> LegacyDynamoDbEncryptor wrap(
      I iLegacyDynamoDbEncryptor) {
    Objects.requireNonNull(iLegacyDynamoDbEncryptor, "Missing value for required argument `iLegacyDynamoDbEncryptor`");
    if (iLegacyDynamoDbEncryptor instanceof software.amazon.cryptography.dynamoDbEncryption.LegacyDynamoDbEncryptor) {
      return ((LegacyDynamoDbEncryptor) iLegacyDynamoDbEncryptor);
    }
    return LegacyDynamoDbEncryptor.wrap(new NativeWrapper(iLegacyDynamoDbEncryptor));
  }

  public Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ILegacyDynamoDbEncryptor impl() {
    return this._impl;
  }

  protected static final class NativeWrapper implements Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ILegacyDynamoDbEncryptor {
    protected final ILegacyDynamoDbEncryptor _impl;

    NativeWrapper(ILegacyDynamoDbEncryptor nativeImpl) {
      if (nativeImpl instanceof LegacyDynamoDbEncryptor) {
        throw new IllegalArgumentException("Recursive wrapping is strictly forbidden.");
      }
      this._impl = nativeImpl;
    }
  }
}
