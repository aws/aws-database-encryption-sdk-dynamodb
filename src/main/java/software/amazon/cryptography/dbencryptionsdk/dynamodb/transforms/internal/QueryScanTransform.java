// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internal.BeaconConfigResolver;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internal.DdbSupport;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internal.FilterExpressionRewriter;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internal.StandardBeaconImpl;
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
    QueryRequest request = input.sdkInput();
    BeaconConfigResolver.SearchInfo searchInfo = config.getSearchInfo(request.tableName());
    if (searchInfo == null) {
      return QueryInputTransformOutput.builder().transformedInput(request).build();
    }

    // Rewrite filter and key condition expressions for beacons
    QueryRequest.Builder builder = request.toBuilder();
    Map<String, StandardBeaconImpl> beaconMap = buildBeaconMap(searchInfo);
    Map<String, software.amazon.cryptography.dbencryptionsdk.dynamodb.internal.CompoundBeaconImpl> compoundBeaconMap = buildCompoundBeaconMap(searchInfo);
    byte[] hmacKey = getHmacKey(searchInfo);

    if (request.filterExpression() != null) {
      FilterExpressionRewriter.RewriteResult result = FilterExpressionRewriter.rewrite(
        request.filterExpression(), request.expressionAttributeNames(),
        request.expressionAttributeValues(), beaconMap, compoundBeaconMap, hmacKey);
      builder.filterExpression(result.expression);
      builder.expressionAttributeNames(result.expressionAttributeNames);
      builder.expressionAttributeValues(result.expressionAttributeValues);
    }

    if (request.keyConditionExpression() != null && hmacKey != null) {
      FilterExpressionRewriter.RewriteResult result = FilterExpressionRewriter.rewrite(
        request.keyConditionExpression(),
        builder.build().expressionAttributeNames(),
        builder.build().expressionAttributeValues(), beaconMap, compoundBeaconMap, hmacKey);
      builder.keyConditionExpression(result.expression);
      builder.expressionAttributeNames(result.expressionAttributeNames);
      builder.expressionAttributeValues(result.expressionAttributeValues);
    }

    return QueryInputTransformOutput.builder().transformedInput(builder.build()).build();
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

    List<Map<String, AttributeValue>> decrypted = decryptAndRemoveBeacons(encryptor, response.items());
    QueryResponse transformed = response.toBuilder().items(decrypted).count(decrypted.size()).build();
    return QueryOutputTransformOutput.builder().transformedOutput(transformed).build();
  }

  // --- Scan ---

  public static ScanInputTransformOutput scanInputTransform(
    ScanInputTransformInput input, TransformConfig config
  ) {
    ScanRequest request = input.sdkInput();
    BeaconConfigResolver.SearchInfo searchInfo = config.getSearchInfo(request.tableName());
    if (searchInfo == null) {
      return ScanInputTransformOutput.builder().transformedInput(request).build();
    }

    ScanRequest.Builder builder = request.toBuilder();
    Map<String, StandardBeaconImpl> beaconMap = buildBeaconMap(searchInfo);
    Map<String, software.amazon.cryptography.dbencryptionsdk.dynamodb.internal.CompoundBeaconImpl> compoundBeaconMap = buildCompoundBeaconMap(searchInfo);
    byte[] hmacKey = getHmacKey(searchInfo);

    if (request.filterExpression() != null) {
      FilterExpressionRewriter.RewriteResult result = FilterExpressionRewriter.rewrite(
        request.filterExpression(), request.expressionAttributeNames(),
        request.expressionAttributeValues(), beaconMap, compoundBeaconMap, hmacKey);
      builder.filterExpression(result.expression);
      if (result.expressionAttributeNames != null && !result.expressionAttributeNames.isEmpty()) {
        builder.expressionAttributeNames(result.expressionAttributeNames);
      }
      if (result.expressionAttributeValues != null && !result.expressionAttributeValues.isEmpty()) {
        builder.expressionAttributeValues(result.expressionAttributeValues);
      }
    }

    return ScanInputTransformOutput.builder().transformedInput(builder.build()).build();
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

    List<Map<String, AttributeValue>> decrypted = decryptAndRemoveBeacons(encryptor, response.items());
    ScanResponse transformed = response.toBuilder().items(decrypted).count(decrypted.size()).build();
    return ScanOutputTransformOutput.builder().transformedOutput(transformed).build();
  }

  // --- Helpers ---

  private static List<Map<String, AttributeValue>> decryptAndRemoveBeacons(
    DynamoDbItemEncryptor encryptor, List<Map<String, AttributeValue>> items
  ) {
    List<Map<String, AttributeValue>> result = new ArrayList<>(items.size());
    for (Map<String, AttributeValue> item : items) {
      DecryptItemOutput decrypted = encryptor.DecryptItem(
        DecryptItemInput.builder().encryptedItem(item).build());
      result.add(DdbSupport.removeBeacons(decrypted.plaintextItem()));
    }
    return result;
  }

  private static Map<String, StandardBeaconImpl> buildBeaconMap(BeaconConfigResolver.SearchInfo searchInfo) {
    Map<String, StandardBeaconImpl> map = new HashMap<>();
    if (searchInfo.standardBeacons != null) {
      for (StandardBeaconImpl sb : searchInfo.standardBeacons) {
        map.put(sb.getName(), sb);
      }
    }
    return map;
  }

  static Map<String, software.amazon.cryptography.dbencryptionsdk.dynamodb.internal.CompoundBeaconImpl> buildCompoundBeaconMap(
    BeaconConfigResolver.SearchInfo searchInfo
  ) {
    Map<String, software.amazon.cryptography.dbencryptionsdk.dynamodb.internal.CompoundBeaconImpl> map = new HashMap<>();
    if (searchInfo.compoundBeacons != null) {
      for (software.amazon.cryptography.dbencryptionsdk.dynamodb.internal.CompoundBeaconImpl cb : searchInfo.compoundBeacons) {
        map.put(cb.getName(), cb);
      }
    }
    return map;
  }

  /** Get HMAC key from search info. */
  private static byte[] getHmacKey(BeaconConfigResolver.SearchInfo searchInfo) {
    return searchInfo.getHmacKey();
  }
}
