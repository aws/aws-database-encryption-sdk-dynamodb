// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.*;

public final class QueryScanTransform {

  private QueryScanTransform() {}

  // --- Query ---

  public static QueryInputTransformOutput queryInputTransform(
    QueryInputTransformInput input, TransformConfig config
  ) {
    return QueryInputTransformOutput.builder().transformedInput(input.sdkInput()).build();
  }

  public static QueryOutputTransformOutput queryOutputTransform(
    QueryOutputTransformInput input, TransformConfig config
  ) {
    QueryResponse response = input.sdkOutput();
    QueryRequest originalRequest = input.originalInput();
    DynamoDbItemEncryptor encryptor = config.getEncryptor(originalRequest.tableName());

    if (encryptor == null || !response.hasItems() || response.items().isEmpty()) {
      return QueryOutputTransformOutput.builder().transformedOutput(response).build();
    }

    List<Map<String, AttributeValue>> decrypted = decryptItems(encryptor, response.items());
    QueryResponse transformed = response.toBuilder().items(decrypted).count(decrypted.size()).build();
    return QueryOutputTransformOutput.builder().transformedOutput(transformed).build();
  }

  // --- Scan ---

  public static ScanInputTransformOutput scanInputTransform(
    ScanInputTransformInput input, TransformConfig config
  ) {
    return ScanInputTransformOutput.builder().transformedInput(input.sdkInput()).build();
  }

  public static ScanOutputTransformOutput scanOutputTransform(
    ScanOutputTransformInput input, TransformConfig config
  ) {
    ScanResponse response = input.sdkOutput();
    ScanRequest originalRequest = input.originalInput();
    DynamoDbItemEncryptor encryptor = config.getEncryptor(originalRequest.tableName());

    if (encryptor == null || !response.hasItems() || response.items().isEmpty()) {
      return ScanOutputTransformOutput.builder().transformedOutput(response).build();
    }

    List<Map<String, AttributeValue>> decrypted = decryptItems(encryptor, response.items());
    ScanResponse transformed = response.toBuilder().items(decrypted).count(decrypted.size()).build();
    return ScanOutputTransformOutput.builder().transformedOutput(transformed).build();
  }

  private static List<Map<String, AttributeValue>> decryptItems(
    DynamoDbItemEncryptor encryptor, List<Map<String, AttributeValue>> items
  ) {
    List<Map<String, AttributeValue>> result = new ArrayList<>(items.size());
    for (Map<String, AttributeValue> item : items) {
      DecryptItemOutput decrypted = encryptor.DecryptItem(
        DecryptItemInput.builder().encryptedItem(item).build());
      result.add(decrypted.plaintextItem());
    }
    return result;
  }
}
