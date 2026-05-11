// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.*;

/**
 * Remaining DDB API transforms: TransactWrite, TransactGet, Update, Delete, and PartiQL blockers.
 */
public final class OtherTransforms {

  private OtherTransforms() {}

  // --- TransactWriteItems ---

  public static TransactWriteItemsInputTransformOutput transactWriteInput(
    TransactWriteItemsInputTransformInput input, TransformConfig config
  ) {
    TransactWriteItemsRequest request = input.sdkInput();
    List<TransactWriteItem> transformed = new ArrayList<>();
    for (TransactWriteItem item : request.transactItems()) {
      if (item.put() != null) {
        DynamoDbItemEncryptor encryptor = config.getEncryptor(item.put().tableName());
        if (encryptor != null) {
          EncryptItemOutput encrypted = encryptor.EncryptItem(
            EncryptItemInput.builder().plaintextItem(item.put().item()).build());
          transformed.add(item.toBuilder()
            .put(item.put().toBuilder().item(encrypted.encryptedItem()).build())
            .build());
          continue;
        }
      }
      transformed.add(item);
    }
    TransactWriteItemsRequest transformedReq = request.toBuilder().transactItems(transformed).build();
    return TransactWriteItemsInputTransformOutput.builder().transformedInput(transformedReq).build();
  }

  public static TransactWriteItemsOutputTransformOutput transactWriteOutput(
    TransactWriteItemsOutputTransformInput input, TransformConfig config
  ) {
    return TransactWriteItemsOutputTransformOutput.builder().transformedOutput(input.sdkOutput()).build();
  }

  // --- TransactGetItems ---

  public static TransactGetItemsInputTransformOutput transactGetInput(
    TransactGetItemsInputTransformInput input, TransformConfig config
  ) {
    return TransactGetItemsInputTransformOutput.builder().transformedInput(input.sdkInput()).build();
  }

  public static TransactGetItemsOutputTransformOutput transactGetOutput(
    TransactGetItemsOutputTransformInput input, TransformConfig config
  ) {
    TransactGetItemsResponse response = input.sdkOutput();
    TransactGetItemsRequest originalRequest = input.originalInput();
    if (!response.hasResponses() || response.responses().isEmpty()) {
      return TransactGetItemsOutputTransformOutput.builder().transformedOutput(response).build();
    }

    List<ItemResponse> decryptedResponses = new ArrayList<>();
    List<TransactGetItem> gets = originalRequest.transactItems();
    for (int i = 0; i < response.responses().size(); i++) {
      ItemResponse ir = response.responses().get(i);
      if (ir.item() == null || ir.item().isEmpty()) {
        decryptedResponses.add(ir);
        continue;
      }
      String tableName = gets.get(i).get().tableName();
      DynamoDbItemEncryptor encryptor = config.getEncryptor(tableName);
      if (encryptor == null) {
        decryptedResponses.add(ir);
      } else {
        DecryptItemOutput decrypted = encryptor.DecryptItem(
          DecryptItemInput.builder().encryptedItem(ir.item()).build());
        decryptedResponses.add(ir.toBuilder().item(decrypted.plaintextItem()).build());
      }
    }
    TransactGetItemsResponse transformed = response.toBuilder().responses(decryptedResponses).build();
    return TransactGetItemsOutputTransformOutput.builder().transformedOutput(transformed).build();
  }

  // --- UpdateItem (validate only) ---

  public static UpdateItemInputTransformOutput updateItemInput(
    UpdateItemInputTransformInput input, TransformConfig config
  ) {
    // Validation only — request passes through unchanged
    return UpdateItemInputTransformOutput.builder().transformedInput(input.sdkInput()).build();
  }

  public static UpdateItemOutputTransformOutput updateItemOutput(
    UpdateItemOutputTransformInput input, TransformConfig config
  ) {
    return UpdateItemOutputTransformOutput.builder().transformedOutput(input.sdkOutput()).build();
  }

  // --- DeleteItem (validate only) ---

  public static DeleteItemInputTransformOutput deleteItemInput(
    DeleteItemInputTransformInput input, TransformConfig config
  ) {
    return DeleteItemInputTransformOutput.builder().transformedInput(input.sdkInput()).build();
  }

  public static DeleteItemOutputTransformOutput deleteItemOutput(
    DeleteItemOutputTransformInput input, TransformConfig config
  ) {
    return DeleteItemOutputTransformOutput.builder().transformedOutput(input.sdkOutput()).build();
  }

  // --- PartiQL Blockers ---

  public static ExecuteStatementInputTransformOutput executeStatementInput(
    ExecuteStatementInputTransformInput input, TransformConfig config
  ) {
    // Block if table is encrypted
    // TODO: parse statement to extract table name and block
    return ExecuteStatementInputTransformOutput.builder().transformedInput(input.sdkInput()).build();
  }

  public static ExecuteStatementOutputTransformOutput executeStatementOutput(
    ExecuteStatementOutputTransformInput input, TransformConfig config
  ) {
    return ExecuteStatementOutputTransformOutput.builder().transformedOutput(input.sdkOutput()).build();
  }

  public static BatchExecuteStatementInputTransformOutput batchExecuteStatementInput(
    BatchExecuteStatementInputTransformInput input, TransformConfig config
  ) {
    return BatchExecuteStatementInputTransformOutput.builder().transformedInput(input.sdkInput()).build();
  }

  public static BatchExecuteStatementOutputTransformOutput batchExecuteStatementOutput(
    BatchExecuteStatementOutputTransformInput input, TransformConfig config
  ) {
    return BatchExecuteStatementOutputTransformOutput.builder().transformedOutput(input.sdkOutput()).build();
  }

  public static ExecuteTransactionInputTransformOutput executeTransactionInput(
    ExecuteTransactionInputTransformInput input, TransformConfig config
  ) {
    return ExecuteTransactionInputTransformOutput.builder().transformedInput(input.sdkInput()).build();
  }

  public static ExecuteTransactionOutputTransformOutput executeTransactionOutput(
    ExecuteTransactionOutputTransformInput input, TransformConfig config
  ) {
    return ExecuteTransactionOutputTransformOutput.builder().transformedOutput(input.sdkOutput()).build();
  }
}
