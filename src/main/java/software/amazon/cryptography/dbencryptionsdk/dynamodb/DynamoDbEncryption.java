// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.EncryptedDataKeyDescription;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionUnion;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.HeaderDeserializer;
import software.amazon.cryptography.materialproviders.IBranchKeyIdSupplier;
import software.amazon.cryptography.materialproviders.model.EncryptedDataKey;
import software.amazon.cryptography.materialproviders.model.GetBranchKeyIdInput;
import software.amazon.cryptography.materialproviders.model.GetBranchKeyIdOutput;

public class DynamoDbEncryption {

  private static final String HIERARCHY_PROVIDER_ID = "aws-kms-hierarchy";

  protected DynamoDbEncryption(BuilderImpl builder) {}

  public static Builder builder() {
    return new BuilderImpl();
  }

  public CreateDynamoDbEncryptionBranchKeyIdSupplierOutput CreateDynamoDbEncryptionBranchKeyIdSupplier(
    CreateDynamoDbEncryptionBranchKeyIdSupplierInput input
  ) {
    IDynamoDbKeyBranchKeyIdSupplier ddbSupplier = input.ddbKeyBranchKeyIdSupplier();
    // Wrap the DDB-specific supplier into an MPL IBranchKeyIdSupplier
    IBranchKeyIdSupplier mplSupplier = new DdbBranchKeyIdSupplierAdapter(ddbSupplier);
    return CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.builder()
      .branchKeyIdSupplier(mplSupplier)
      .build();
  }

  public GetEncryptedDataKeyDescriptionOutput GetEncryptedDataKeyDescription(
    GetEncryptedDataKeyDescriptionInput input
  ) {
    GetEncryptedDataKeyDescriptionUnion union = input.input();
    byte[] headerBytes;
    if (union.header() != null) {
      headerBytes = toByteArray(union.header());
    } else if (union.item() != null) {
      Map<String, AttributeValue> item = union.item();
      AttributeValue headAttr = item.get("aws_dbe_head");
      if (headAttr == null || headAttr.b() == null) {
        throw new IllegalArgumentException("Item does not contain aws_dbe_head binary attribute");
      }
      headerBytes = headAttr.b().asByteArray();
    } else {
      throw new IllegalArgumentException("Either header or item must be provided");
    }

    HeaderDeserializer.ParsedHeader parsed = HeaderDeserializer.deserialize(headerBytes);
    List<EncryptedDataKeyDescription> descriptions = new ArrayList<>();
    for (EncryptedDataKey edk : parsed.encryptedDataKeys) {
      EncryptedDataKeyDescription.Builder desc = EncryptedDataKeyDescription.builder()
        .keyProviderId(edk.keyProviderId());

      if (edk.keyProviderInfo() != null) {
        byte[] info = toByteArray(edk.keyProviderInfo());
        if (info.length > 0) {
          desc.keyProviderInfo(new String(info, StandardCharsets.UTF_8));
        }
      }

      // For hierarchy keyrings, extract branch key id and version from provider info
      if (HIERARCHY_PROVIDER_ID.equals(edk.keyProviderId()) && edk.keyProviderInfo() != null) {
        byte[] info = toByteArray(edk.keyProviderInfo());
        String infoStr = new String(info, StandardCharsets.UTF_8);
        desc.branchKeyId(infoStr);
        // Branch key version is in the ciphertext blob (first 16 bytes as UUID)
        if (edk.ciphertext() != null) {
          byte[] ct = toByteArray(edk.ciphertext());
          if (ct.length >= 16) {
            desc.branchKeyVersion(bytesToUuid(ct, 0));
          }
        }
      }

      descriptions.add(desc.build());
    }

    return GetEncryptedDataKeyDescriptionOutput.builder()
      .EncryptedDataKeyDescriptionOutput(descriptions)
      .build();
  }

  private static byte[] toByteArray(ByteBuffer buf) {
    if (buf == null) return new byte[0];
    buf = buf.asReadOnlyBuffer();
    byte[] arr = new byte[buf.remaining()];
    buf.get(arr);
    return arr;
  }

  private static String bytesToUuid(byte[] bytes, int offset) {
    long msb = 0, lsb = 0;
    for (int i = 0; i < 8; i++) msb = (msb << 8) | (bytes[offset + i] & 0xFFL);
    for (int i = 8; i < 16; i++) lsb = (lsb << 8) | (bytes[offset + i] & 0xFFL);
    return new java.util.UUID(msb, lsb).toString();
  }

  /**
   * Adapter that wraps a DDB-specific branch key ID supplier into an MPL IBranchKeyIdSupplier.
   */
  private static final class DdbBranchKeyIdSupplierAdapter implements IBranchKeyIdSupplier {
    private final IDynamoDbKeyBranchKeyIdSupplier ddbSupplier;

    DdbBranchKeyIdSupplierAdapter(IDynamoDbKeyBranchKeyIdSupplier ddbSupplier) {
      this.ddbSupplier = ddbSupplier;
    }

    @Override
    public GetBranchKeyIdOutput GetBranchKeyId(GetBranchKeyIdInput input) {
      // The encryption context contains the DDB key attributes
      Map<String, String> ec = input.encryptionContext();
      // Convert EC string values to DDB AttributeValues for the DDB supplier
      Map<String, AttributeValue> ddbKey = new java.util.HashMap<>();
      for (Map.Entry<String, String> entry : ec.entrySet()) {
        ddbKey.put(entry.getKey(), AttributeValue.fromS(entry.getValue()));
      }
      software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBranchKeyIdFromDdbKeyOutput result =
        ddbSupplier.GetBranchKeyIdFromDdbKey(
          software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBranchKeyIdFromDdbKeyInput.builder()
            .ddbKey(ddbKey)
            .build());
      return GetBranchKeyIdOutput.builder()
        .branchKeyId(result.branchKeyId())
        .build();
    }
  }

  public interface Builder {
    Builder DynamoDbEncryptionConfig(DynamoDbEncryptionConfig DynamoDbEncryptionConfig);
    DynamoDbEncryptionConfig DynamoDbEncryptionConfig();
    DynamoDbEncryption build();
  }

  static class BuilderImpl implements Builder {

    protected DynamoDbEncryptionConfig DynamoDbEncryptionConfig;

    protected BuilderImpl() {}

    public Builder DynamoDbEncryptionConfig(DynamoDbEncryptionConfig DynamoDbEncryptionConfig) {
      this.DynamoDbEncryptionConfig = DynamoDbEncryptionConfig;
      return this;
    }

    public DynamoDbEncryptionConfig DynamoDbEncryptionConfig() {
      return this.DynamoDbEncryptionConfig;
    }

    public DynamoDbEncryption build() {
      if (Objects.isNull(this.DynamoDbEncryptionConfig())) {
        throw new IllegalArgumentException(
          "Missing value for required field `DynamoDbEncryptionConfig`"
        );
      }
      return new DynamoDbEncryption(this);
    }
  }
}
