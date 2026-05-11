// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import java.util.Objects;

public final class LegacyDynamoDbEncryptor implements ILegacyDynamoDbEncryptor {

  private final ILegacyDynamoDbEncryptor _impl;

  private LegacyDynamoDbEncryptor(ILegacyDynamoDbEncryptor impl) {
    Objects.requireNonNull(impl, "Missing value for required argument `impl`");
    this._impl = impl;
  }

  public static LegacyDynamoDbEncryptor wrap(ILegacyDynamoDbEncryptor impl) {
    if (impl instanceof LegacyDynamoDbEncryptor) {
      return (LegacyDynamoDbEncryptor) impl;
    }
    return new LegacyDynamoDbEncryptor(impl);
  }
}
