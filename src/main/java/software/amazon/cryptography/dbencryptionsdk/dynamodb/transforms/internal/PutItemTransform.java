// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internal;

import java.util.HashMap;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internal.BeaconConfigResolver;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internal.CompoundBeaconImpl;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internal.StandardBeaconImpl;
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

    // Compute beacon attributes from plaintext item BEFORE encryption
    Map<String, AttributeValue> beaconAttrs = new HashMap<>();
    BeaconConfigResolver.SearchInfo searchInfo = config.getSearchInfo(request.tableName());
    if (searchInfo != null) {
      byte[] hmacKey = searchInfo.getHmacKey();
      if (hmacKey != null) {
        // Compute virtual field values for beaconization
        Map<String, String> virtualFieldValues = new HashMap<>();
        if (searchInfo.beaconVersion.virtualFields() != null) {
          for (software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualField vf : searchInfo.beaconVersion.virtualFields()) {
            String value = computeVirtualFieldValue(vf, request.item());
            if (value != null) {
              virtualFieldValues.put(vf.name(), value);
            }
          }
        }

        // Standard beacons
        for (StandardBeaconImpl sb : searchInfo.standardBeacons) {
          AttributeValue av = request.item().get(sb.getName());
          if (av != null) {
            if (sb.isSet()) {
              java.util.List<String> hashedSet = new java.util.ArrayList<>();
              if (av.ss() != null) {
                for (String s : av.ss()) {
                  hashedSet.add(sb.hashStr(s, hmacKey));
                }
              } else if (av.s() != null) {
                hashedSet.add(sb.hashStr(av.s(), hmacKey));
              }
              if (!hashedSet.isEmpty()) {
                beaconAttrs.put(sb.getBeaconAttributeName(), AttributeValue.fromSs(hashedSet));
              }
            } else {
              String beaconValue;
              if (av.s() != null) {
                beaconValue = sb.hashStr(av.s(), hmacKey);
              } else if (av.b() != null) {
                beaconValue = sb.hash(av.b().asByteArray(), hmacKey);
              } else if (av.n() != null) {
                beaconValue = sb.hashStr(av.n(), hmacKey);
              } else {
                continue;
              }
              beaconAttrs.put(sb.getBeaconAttributeName(), AttributeValue.fromS(beaconValue));
            }
          } else if (virtualFieldValues.containsKey(sb.getName())) {
            String beaconValue = sb.hashStr(virtualFieldValues.get(sb.getName()), hmacKey);
            beaconAttrs.put(sb.getBeaconAttributeName(), AttributeValue.fromS(beaconValue));
          }
        }
        // Compound beacons
        for (CompoundBeaconImpl cb : searchInfo.compoundBeacons) {
          String value = cb.construct(request.item(), hmacKey);
          if (value != null) {
            beaconAttrs.put(cb.getBeaconAttributeName(), AttributeValue.fromS(value));
          }
        }
      }
    }

    // Encrypt the item WITHOUT beacon attributes
    EncryptItemOutput encrypted = encryptor.EncryptItem(
      EncryptItemInput.builder().plaintextItem(request.item()).build());

    // Add beacon attributes to the encrypted item AFTER encryption
    Map<String, AttributeValue> finalItem = new HashMap<>(encrypted.encryptedItem());
    finalItem.putAll(beaconAttrs);

    PutItemRequest transformed = request.toBuilder().item(finalItem).build();
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

  private static String computeVirtualFieldValue(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualField vf,
    Map<String, AttributeValue> item
  ) {
    if (vf.parts() == null) return null;
    StringBuilder sb = new StringBuilder();
    for (software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualPart part : vf.parts()) {
      AttributeValue av = item.get(part.loc());
      if (av == null) return null;
      String value;
      if (av.s() != null) value = av.s();
      else if (av.n() != null) value = av.n();
      else if (av.bool() != null) value = av.bool().toString();
      else return null;
      if (part.trans() != null) {
        for (software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualTransform t : part.trans()) {
          if (t.upper() != null) value = value.toUpperCase();
          else if (t.lower() != null) value = value.toLowerCase();
          else if (t.prefix() != null) {
            int len = t.prefix().length();
            value = len >= 0 ? value.substring(0, Math.min(len, value.length()))
                             : value.substring(0, Math.max(0, value.length() + len));
          } else if (t.suffix() != null) {
            int len = t.suffix().length();
            value = len >= 0 ? value.substring(Math.max(0, value.length() - len))
                             : value.substring(Math.min(-len, value.length()));
          }
        }
      }
      sb.append(value);
    }
    return sb.toString();
  }
}
