// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemResponse;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.*;

public final class BatchGetItemTransform {

  private BatchGetItemTransform() {}

  public static BatchGetItemInputTransformOutput inputTransform(
    BatchGetItemInputTransformInput input, TransformConfig config
  ) {
    return BatchGetItemInputTransformOutput.builder().transformedInput(input.sdkInput()).build();
  }

  public static BatchGetItemOutputTransformOutput outputTransform(
    BatchGetItemOutputTransformInput input, TransformConfig config
  ) {
    BatchGetItemResponse response = input.sdkOutput();
    if (!response.hasResponses() || response.responses().isEmpty()) {
      return BatchGetItemOutputTransformOutput.builder().transformedOutput(response).build();
    }

    Map<String, List<Map<String, AttributeValue>>> transformedResponses = new HashMap<>();
    for (Map.Entry<String, List<Map<String, AttributeValue>>> entry : response.responses().entrySet()) {
      String tableName = entry.getKey();
      DynamoDbItemEncryptor encryptor = config.getEncryptor(tableName);

      if (encryptor == null) {
        transformedResponses.put(tableName, entry.getValue());
        continue;
      }

      List<Map<String, AttributeValue>> decryptedItems = new ArrayList<>();
      for (Map<String, AttributeValue> item : entry.getValue()) {
        DecryptItemOutput decrypted = encryptor.DecryptItem(
          DecryptItemInput.builder().encryptedItem(item).build());
        decryptedItems.add(decrypted.plaintextItem());
      }
      transformedResponses.put(tableName, decryptedItems);
    }

    BatchGetItemResponse transformed = response.toBuilder().responses(transformedResponses).build();
    return BatchGetItemOutputTransformOutput.builder().transformedOutput(transformed).build();
  }
}
