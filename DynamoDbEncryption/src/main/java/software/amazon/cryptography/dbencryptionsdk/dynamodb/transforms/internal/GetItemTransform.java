// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internal;

import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.*;

/**
 * //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-getitem
 * //# The Item Encryptor MUST perform Decrypt Item where the input DynamoDB Item
 * //# is the Item field in the original response.
 */
public final class GetItemTransform {

  private GetItemTransform() {}

  public static GetItemInputTransformOutput inputTransform(
    GetItemInputTransformInput input, TransformConfig config
  ) {
    // GetItem input is not modified
    return GetItemInputTransformOutput.builder().transformedInput(input.sdkInput()).build();
  }

  public static GetItemOutputTransformOutput outputTransform(
    GetItemOutputTransformInput input, TransformConfig config
  ) {
    GetItemResponse response = input.sdkOutput();
    GetItemRequest originalRequest = input.originalInput();
    DynamoDbItemEncryptor encryptor = config.getEncryptor(originalRequest.tableName());

    if (encryptor == null || !response.hasItem() || response.item().isEmpty()) {
      return GetItemOutputTransformOutput.builder().transformedOutput(response).build();
    }

    DecryptItemOutput decrypted = encryptor.DecryptItem(
      DecryptItemInput.builder().encryptedItem(response.item()).build());
    GetItemResponse transformed = response.toBuilder().item(decrypted.plaintextItem()).build();
    return GetItemOutputTransformOutput.builder().transformedOutput(transformed).build();
  }
}
