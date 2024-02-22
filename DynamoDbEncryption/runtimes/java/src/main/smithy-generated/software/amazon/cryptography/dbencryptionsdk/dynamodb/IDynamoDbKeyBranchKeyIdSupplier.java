// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBranchKeyIdFromDdbKeyInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBranchKeyIdFromDdbKeyOutput;

public interface IDynamoDbKeyBranchKeyIdSupplier {
  /**
   * Get the Branch Key that should be used for wrapping and unwrapping data keys based on the primary key of the item being read or written.
   *
   * @param input Inputs for getting the Branch Key that should be used for wrapping and unwrapping data keys.
   * @return Outputs for getting the Branch Key that should be used for wrapping and unwrapping data keys.
   */
  GetBranchKeyIdFromDdbKeyOutput GetBranchKeyIdFromDdbKey(
    GetBranchKeyIdFromDdbKeyInput input
  );
}
