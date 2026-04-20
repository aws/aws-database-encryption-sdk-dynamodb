// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.WriteRequest;
import software.amazon.awssdk.services.dynamodb.model.PutRequest;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.model.AlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.AlgorithmSuiteInfo;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.DecryptMaterialsInput;
import software.amazon.cryptography.materialproviders.model.DecryptMaterialsOutput;
import software.amazon.cryptography.materialproviders.model.EncryptedDataKey;
import software.amazon.cryptography.materialproviders.model.EncryptionMaterials;
import software.amazon.cryptography.materialproviders.model.GetEncryptionMaterialsInput;
import software.amazon.cryptography.materialproviders.model.GetEncryptionMaterialsOutput;

class DdbTransformsTest {

    private static DdbMiddlewareConfig config;

    @BeforeAll
    static void setup() {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.SIGN_ONLY);
        actions.put("data", CryptoAction.ENCRYPT_AND_SIGN);

        DynamoDbItemEncryptor encryptor = DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("TestTable")
                .partitionKeyName("pk")
                .attributeActionsOnEncrypt(actions)
                .cmm(new MockCMM())
                .build());

        Map<String, DynamoDbItemEncryptor> encryptors = new HashMap<>();
        encryptors.put("TestTable", encryptor);
        config = new DdbMiddlewareConfig(encryptors);
    }

    // ---- PutItem Input Transform ----

    @Test
    void testPutItemEncryptsItem() {
        Map<String, AttributeValue> item = new LinkedHashMap<>();
        item.put("pk", AttributeValue.fromS("id1"));
        item.put("data", AttributeValue.fromS("secret"));

        PutItemRequest request = PutItemRequest.builder()
            .tableName("TestTable").item(item).build();

        PutItemRequest transformed = DdbTransforms.putItemInput(config, request);

        // Item should be encrypted
        assertNotNull(transformed.item().get("aws_dbe_head"));
        assertNotNull(transformed.item().get("aws_dbe_foot"));
        // pk unchanged
        assertEquals("id1", transformed.item().get("pk").s());
        // data encrypted (now Binary)
        assertNotNull(transformed.item().get("data").b());
    }

    @Test
    void testPutItemPassesThroughUnconfiguredTable() {
        Map<String, AttributeValue> item = new LinkedHashMap<>();
        item.put("pk", AttributeValue.fromS("id1"));

        PutItemRequest request = PutItemRequest.builder()
            .tableName("OtherTable").item(item).build();

        PutItemRequest transformed = DdbTransforms.putItemInput(config, request);
        // Should be unchanged
        assertSame(request, transformed);
    }

    @Test
    void testPutItemRejectsReservedPrefix() {
        Map<String, AttributeValue> item = new LinkedHashMap<>();
        item.put("pk", AttributeValue.fromS("id1"));
        item.put("data", AttributeValue.fromS("val"));
        item.put("aws_dbe_bad", AttributeValue.fromS("x"));

        PutItemRequest request = PutItemRequest.builder()
            .tableName("TestTable").item(item).build();

        assertThrows(DbeException.class, () -> DdbTransforms.putItemInput(config, request));
    }

    @Test
    void testPutItemRejectsConditionOnEncryptedAttr() {
        Map<String, AttributeValue> item = new LinkedHashMap<>();
        item.put("pk", AttributeValue.fromS("id1"));
        item.put("data", AttributeValue.fromS("val"));

        Map<String, String> exprNames = new HashMap<>();
        exprNames.put("#d", "data"); // "data" is ENCRYPT_AND_SIGN

        PutItemRequest request = PutItemRequest.builder()
            .tableName("TestTable").item(item)
            .conditionExpression("attribute_not_exists(#d)")
            .expressionAttributeNames(exprNames)
            .build();

        assertThrows(DbeException.class, () -> DdbTransforms.putItemInput(config, request));
    }

    @Test
    void testPutItemAllowsConditionOnSignedAttr() {
        Map<String, AttributeValue> item = new LinkedHashMap<>();
        item.put("pk", AttributeValue.fromS("id1"));
        item.put("data", AttributeValue.fromS("val"));

        Map<String, String> exprNames = new HashMap<>();
        exprNames.put("#p", "pk"); // "pk" is SIGN_ONLY — allowed

        PutItemRequest request = PutItemRequest.builder()
            .tableName("TestTable").item(item)
            .conditionExpression("attribute_not_exists(#p)")
            .expressionAttributeNames(exprNames)
            .build();

        // Should not throw
        PutItemRequest transformed = DdbTransforms.putItemInput(config, request);
        assertNotNull(transformed);
    }

    // ---- IsPlainWrite ----

    @Test
    void testIsPlainWrite() {
        assertTrue(config.isPlainWrite("UnknownTable"));
        assertFalse(config.isPlainWrite("TestTable"));
    }

    // ---- ValidateWriteable ----

    @Test
    void testValidateWriteableRejectsReserved() {
        Map<String, String> item = new HashMap<>();
        item.put("aws_dbe_head", "bad");
        assertThrows(DbeException.class, () -> DdbMiddlewareConfig.validateWriteable(item));
    }

    @Test
    void testValidateWriteableAcceptsNormal() {
        Map<String, String> item = new HashMap<>();
        item.put("normal_attr", "ok");
        assertDoesNotThrow(() -> DdbMiddlewareConfig.validateWriteable(item));
    }

    // ---- Query ----

    @Test
    void testQueryRejectsFilterOnEncryptedAttr() {
        Map<String, String> exprNames = new HashMap<>();
        exprNames.put("#d", "data");
        QueryRequest request = QueryRequest.builder()
            .tableName("TestTable")
            .filterExpression("#d = :v")
            .expressionAttributeNames(exprNames)
            .build();
        assertThrows(DbeException.class, () -> DdbTransforms.queryInput(config, request));
    }

    @Test
    void testQueryAllowsFilterOnSignedAttr() {
        Map<String, String> exprNames = new HashMap<>();
        exprNames.put("#p", "pk");
        QueryRequest request = QueryRequest.builder()
            .tableName("TestTable")
            .keyConditionExpression("#p = :v")
            .expressionAttributeNames(exprNames)
            .build();
        assertDoesNotThrow(() -> DdbTransforms.queryInput(config, request));
    }

    // ---- Scan ----

    @Test
    void testScanRejectsFilterOnEncryptedAttr() {
        Map<String, String> exprNames = new HashMap<>();
        exprNames.put("#d", "data");
        ScanRequest request = ScanRequest.builder()
            .tableName("TestTable")
            .filterExpression("#d = :v")
            .expressionAttributeNames(exprNames)
            .build();
        assertThrows(DbeException.class, () -> DdbTransforms.scanInput(config, request));
    }

    // ---- UpdateItem ----

    @Test
    void testUpdateItemRejectsUpdateOnEncryptedAttr() {
        Map<String, String> exprNames = new HashMap<>();
        exprNames.put("#d", "data");
        UpdateItemRequest request = UpdateItemRequest.builder()
            .tableName("TestTable")
            .updateExpression("SET #d = :v")
            .expressionAttributeNames(exprNames)
            .build();
        assertThrows(DbeException.class, () -> DdbTransforms.updateItemInput(config, request));
    }

    @Test
    void testUpdateItemAllowsUpdateOnSignedAttr() {
        Map<String, String> exprNames = new HashMap<>();
        exprNames.put("#p", "pk");
        UpdateItemRequest request = UpdateItemRequest.builder()
            .tableName("TestTable")
            .updateExpression("SET #p = :v")
            .expressionAttributeNames(exprNames)
            .build();
        assertDoesNotThrow(() -> DdbTransforms.updateItemInput(config, request));
    }

    // ---- BatchWriteItem ----

    @Test
    void testBatchWriteEncryptsItems() {
        Map<String, AttributeValue> item = new LinkedHashMap<>();
        item.put("pk", AttributeValue.fromS("id1"));
        item.put("data", AttributeValue.fromS("secret"));

        Map<String, java.util.List<WriteRequest>> requestItems = new HashMap<>();
        requestItems.put("TestTable", Collections.singletonList(
            WriteRequest.builder().putRequest(PutRequest.builder().item(item).build()).build()));

        BatchWriteItemRequest request = BatchWriteItemRequest.builder()
            .requestItems(requestItems).build();

        BatchWriteItemRequest transformed = DdbTransforms.batchWriteInput(config, request);
        Map<String, AttributeValue> encItem = transformed.requestItems().get("TestTable").get(0).putRequest().item();
        assertNotNull(encItem.get("aws_dbe_head"));
        assertNotNull(encItem.get("data").b());
    }

    // ---- Mock CMM ----

    static class MockCMM implements ICryptographicMaterialsManager {
        @Override
        public GetEncryptionMaterialsOutput GetEncryptionMaterials(GetEncryptionMaterialsInput input) {
            byte[] dk = new byte[32]; new SecureRandom().nextBytes(dk);
            byte[] sk = new byte[32]; new SecureRandom().nextBytes(sk);
            return GetEncryptionMaterialsOutput.builder().encryptionMaterials(
                EncryptionMaterials.builder()
                    .algorithmSuite(AlgorithmSuiteInfo.builder()
                        .id(AlgorithmSuiteId.builder().DBE(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384).build())
                        .binaryId(ByteBuffer.wrap(new byte[]{0x67, 0x00})).messageVersion(2)
                        .encrypt(software.amazon.cryptography.materialproviders.model.Encrypt.builder()
                            .AES_GCM(software.amazon.cryptography.primitives.model.AES_GCM.builder().keyLength(32).tagLength(16).ivLength(12).build()).build())
                        .kdf(software.amazon.cryptography.materialproviders.model.DerivationAlgorithm.builder()
                            .HKDF(software.amazon.cryptography.materialproviders.model.HKDF.builder().hmac(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_512).saltLength(0).inputKeyLength(32).outputKeyLength(32).build()).build())
                        .commitment(software.amazon.cryptography.materialproviders.model.DerivationAlgorithm.builder()
                            .HKDF(software.amazon.cryptography.materialproviders.model.HKDF.builder().hmac(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_512).saltLength(0).inputKeyLength(32).outputKeyLength(32).build()).build())
                        .signature(software.amazon.cryptography.materialproviders.model.SignatureAlgorithm.builder()
                            .None(software.amazon.cryptography.materialproviders.model.None.builder().build()).build())
                        .symmetricSignature(software.amazon.cryptography.materialproviders.model.SymmetricSignatureAlgorithm.builder()
                            .HMAC(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_384).build())
                        .edkWrapping(software.amazon.cryptography.materialproviders.model.EdkWrappingAlgorithm.builder()
                            .DIRECT_KEY_WRAPPING(software.amazon.cryptography.materialproviders.model.DIRECT_KEY_WRAPPING.builder().build()).build())
                        .build())
                    .encryptionContext(input.encryptionContext() != null ? input.encryptionContext() : new HashMap<String, String>())
                    .encryptedDataKeys(Collections.singletonList(EncryptedDataKey.builder()
                        .keyProviderId("mock").keyProviderInfo(ByteBuffer.wrap("i".getBytes(StandardCharsets.UTF_8))).ciphertext(ByteBuffer.wrap(new byte[]{1})).build()))
                    .requiredEncryptionContextKeys(Collections.<String>emptyList())
                    .plaintextDataKey(ByteBuffer.wrap(dk))
                    .symmetricSigningKeys(Collections.singletonList(ByteBuffer.wrap(sk)))
                    .build()
            ).build();
        }

        @Override
        public DecryptMaterialsOutput DecryptMaterials(DecryptMaterialsInput input) {
            throw new UnsupportedOperationException();
        }
    }
}
