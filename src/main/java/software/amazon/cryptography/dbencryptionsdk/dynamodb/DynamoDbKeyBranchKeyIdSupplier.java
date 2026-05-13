// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBranchKeyIdFromDdbKeyInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBranchKeyIdFromDdbKeyOutput;

public final class DynamoDbKeyBranchKeyIdSupplier
  implements IDynamoDbKeyBranchKeyIdSupplier {

  private final IDynamoDbKeyBranchKeyIdSupplier _impl;

  private DynamoDbKeyBranchKeyIdSupplier(IDynamoDbKeyBranchKeyIdSupplier impl) {
    Objects.requireNonNull(impl, "Missing value for required argument `impl`");
    this._impl = impl;
  }

  public static DynamoDbKeyBranchKeyIdSupplier wrap(IDynamoDbKeyBranchKeyIdSupplier impl) {
    if (impl instanceof DynamoDbKeyBranchKeyIdSupplier) {
      return (DynamoDbKeyBranchKeyIdSupplier) impl;
    }
    return new DynamoDbKeyBranchKeyIdSupplier(impl);
  }

  public GetBranchKeyIdFromDdbKeyOutput GetBranchKeyIdFromDdbKey(
    GetBranchKeyIdFromDdbKeyInput input
  ) {
    return this._impl.GetBranchKeyIdFromDdbKey(input);
  }
}
