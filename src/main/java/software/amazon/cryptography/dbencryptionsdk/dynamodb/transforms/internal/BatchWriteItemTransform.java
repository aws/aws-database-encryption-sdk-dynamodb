// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutRequest;
import software.amazon.awssdk.services.dynamodb.model.WriteRequest;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.*;

public final class BatchWriteItemTransform {

  private BatchWriteItemTransform() {}

  public static BatchWriteItemInputTransformOutput inputTransform(
    BatchWriteItemInputTransformInput input, TransformConfig config
  ) {
    BatchWriteItemRequest request = input.sdkInput();
    Map<String, List<WriteRequest>> transformedItems = new HashMap<>();

    for (Map.Entry<String, List<WriteRequest>> entry : request.requestItems().entrySet()) {
      String tableName = entry.getKey();
      DynamoDbItemEncryptor encryptor = config.getEncryptor(tableName);

      if (encryptor == null) {
        transformedItems.put(tableName, entry.getValue());
        continue;
      }

      List<WriteRequest> transformed = new ArrayList<>();
      for (WriteRequest wr : entry.getValue()) {
        if (wr.putRequest() != null) {
          EncryptItemOutput encrypted = encryptor.EncryptItem(
            EncryptItemInput.builder().plaintextItem(wr.putRequest().item()).build());
          transformed.add(wr.toBuilder()
            .putRequest(PutRequest.builder().item(encrypted.encryptedItem()).build())
            .build());
        } else {
          transformed.add(wr);
        }
      }
      transformedItems.put(tableName, transformed);
    }

    BatchWriteItemRequest transformedRequest = request.toBuilder().requestItems(transformedItems).build();
    return BatchWriteItemInputTransformOutput.builder().transformedInput(transformedRequest).build();
  }

  public static BatchWriteItemOutputTransformOutput outputTransform(
    BatchWriteItemOutputTransformInput input, TransformConfig config
  ) {
    // Output is not modified (unprocessed items remain encrypted)
    return BatchWriteItemOutputTransformOutput.builder().transformedOutput(input.sdkOutput()).build();
  }
}
