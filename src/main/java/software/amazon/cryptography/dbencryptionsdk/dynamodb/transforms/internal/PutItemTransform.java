// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internal;

import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.*;

/**
 * //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-putitem
 * //# Before the PutItem call is made to DynamoDB:
 * //# If the TableName in the request does not refer to an encrypted-table,
 * //# the PutItem request MUST be unchanged.
 */
public final class PutItemTransform {

  private PutItemTransform() {}

  public static PutItemInputTransformOutput inputTransform(
    PutItemInputTransformInput input, TransformConfig config
  ) {
    PutItemRequest request = input.sdkInput();
    DynamoDbItemEncryptor encryptor = config.getEncryptor(request.tableName());
    if (encryptor == null) {
      return PutItemInputTransformOutput.builder().transformedInput(request).build();
    }

    EncryptItemOutput encrypted = encryptor.EncryptItem(
      EncryptItemInput.builder().plaintextItem(request.item()).build());

    PutItemRequest transformed = request.toBuilder().item(encrypted.encryptedItem()).build();
    return PutItemInputTransformOutput.builder().transformedInput(transformed).build();
  }

  public static PutItemOutputTransformOutput outputTransform(
    PutItemOutputTransformInput input, TransformConfig config
  ) {
    PutItemResponse response = input.sdkOutput();
    PutItemRequest originalRequest = input.originalInput();
    DynamoDbItemEncryptor encryptor = config.getEncryptor(originalRequest.tableName());

    if (encryptor == null || !response.hasAttributes() || response.attributes().isEmpty()) {
      return PutItemOutputTransformOutput.builder().transformedOutput(response).build();
    }

    // Decrypt returned attributes (ALL_OLD case)
    DecryptItemOutput decrypted = encryptor.DecryptItem(
      DecryptItemInput.builder().encryptedItem(response.attributes()).build());
    PutItemResponse transformed = response.toBuilder().attributes(decrypted.plaintextItem()).build();
    return PutItemOutputTransformOutput.builder().transformedOutput(transformed).build();
  }
}
