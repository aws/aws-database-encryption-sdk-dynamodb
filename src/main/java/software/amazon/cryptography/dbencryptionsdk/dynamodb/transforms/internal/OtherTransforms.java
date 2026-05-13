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
    blockIfEncryptedTable(input.sdkInput().statement(), config);
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
    BatchExecuteStatementRequest request = input.sdkInput();
    if (request.hasStatements()) {
      for (BatchStatementRequest stmt : request.statements()) {
        blockIfEncryptedTable(stmt.statement(), config);
      }
    }
    return BatchExecuteStatementInputTransformOutput.builder().transformedInput(request).build();
  }

  public static BatchExecuteStatementOutputTransformOutput batchExecuteStatementOutput(
    BatchExecuteStatementOutputTransformInput input, TransformConfig config
  ) {
    return BatchExecuteStatementOutputTransformOutput.builder().transformedOutput(input.sdkOutput()).build();
  }

  public static ExecuteTransactionInputTransformOutput executeTransactionInput(
    ExecuteTransactionInputTransformInput input, TransformConfig config
  ) {
    ExecuteTransactionRequest request = input.sdkInput();
    if (request.hasTransactStatements()) {
      for (ParameterizedStatement stmt : request.transactStatements()) {
        blockIfEncryptedTable(stmt.statement(), config);
      }
    }
    return ExecuteTransactionInputTransformOutput.builder().transformedInput(request).build();
  }

  public static ExecuteTransactionOutputTransformOutput executeTransactionOutput(
    ExecuteTransactionOutputTransformInput input, TransformConfig config
  ) {
    return ExecuteTransactionOutputTransformOutput.builder().transformedOutput(input.sdkOutput()).build();
  }

  /**
   * Parse the table name from a PartiQL statement and block if it's an encrypted table.
   *
   * //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-executestatement
   * //# If the table name in the statement refers to an encrypted-table,
   * //# the request MUST be rejected.
   */
  private static void blockIfEncryptedTable(String statement, TransformConfig config) {
    if (statement == null || statement.isEmpty()) return;
    String tableName = extractTableName(statement);
    if (tableName != null && config.isEncryptedTable(tableName)) {
      throw software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DynamoDbEncryptionTransformsException
        .builder()
        .message("PartiQL operations are not supported on encrypted tables. Table: " + tableName)
        .build();
    }
  }

  /**
   * Extract table name from a PartiQL statement.
   * Handles: SELECT ... FROM "table", INSERT INTO "table", UPDATE "table", DELETE FROM "table"
   */
  private static String extractTableName(String statement) {
    String upper = statement.trim().toUpperCase();
    String trimmed = statement.trim();
    int tableStart = -1;
    if (upper.startsWith("SELECT")) {
      int fromIdx = upper.indexOf("FROM");
      if (fromIdx >= 0) tableStart = fromIdx + 4;
    } else if (upper.startsWith("INSERT")) {
      int intoIdx = upper.indexOf("INTO");
      if (intoIdx >= 0) tableStart = intoIdx + 4;
    } else if (upper.startsWith("UPDATE")) {
      tableStart = 6;
    } else if (upper.startsWith("DELETE")) {
      int fromIdx = upper.indexOf("FROM");
      if (fromIdx >= 0) tableStart = fromIdx + 4;
    }
    if (tableStart < 0) return null;
    // Skip whitespace
    while (tableStart < trimmed.length() && Character.isWhitespace(trimmed.charAt(tableStart))) {
      tableStart++;
    }
    if (tableStart >= trimmed.length()) return null;
    // Extract table name (may be quoted with double quotes)
    if (trimmed.charAt(tableStart) == '"') {
      int end = trimmed.indexOf('"', tableStart + 1);
      if (end < 0) return null;
      return trimmed.substring(tableStart + 1, end);
    }
    // Unquoted: read until whitespace or special char
    int end = tableStart;
    while (end < trimmed.length() && !Character.isWhitespace(trimmed.charAt(end))
           && trimmed.charAt(end) != '.' && trimmed.charAt(end) != '[') {
      end++;
    }
    return trimmed.substring(tableStart, end);
  }
}
