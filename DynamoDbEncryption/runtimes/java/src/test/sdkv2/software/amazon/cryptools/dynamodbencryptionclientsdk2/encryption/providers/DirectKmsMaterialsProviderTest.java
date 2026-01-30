/*
 * Copyright 2014-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except
 * in compliance with the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertTrue;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.crypto.SecretKey;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.awssdk.services.kms.model.DecryptRequest;
import software.amazon.awssdk.services.kms.model.DecryptResponse;
import software.amazon.awssdk.services.kms.model.GenerateDataKeyRequest;
import software.amazon.awssdk.services.kms.model.GenerateDataKeyResponse;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionContext;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.internal.Base64;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.materials.DecryptionMaterials;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.materials.EncryptionMaterials;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.materials.WrappedRawMaterials;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.testing.FakeKMS;

public class DirectKmsMaterialsProviderTest {
    private FakeKMS kms;
    private String keyId;
    private Map<String, String> description;
    private EncryptionContext ctx;

    @BeforeMethod
    public void setUp() {
        description = new HashMap<>();
        description.put("TestKey", "test value");
        description = Collections.unmodifiableMap(description);
        ctx = new EncryptionContext.Builder().build();
        kms = new FakeKMS();
        keyId = kms.createKey().keyMetadata().keyId();
    }

    @Test
    public void simple() {
        DirectKmsMaterialsProvider prov = new DirectKmsMaterialsProvider(kms, keyId);

        EncryptionMaterials eMat = prov.getEncryptionMaterials(ctx);
        SecretKey encryptionKey = eMat.getEncryptionKey();
        assertNotNull(encryptionKey);
        Key signingKey = eMat.getSigningKey();
        assertNotNull(signingKey);

        DecryptionMaterials dMat = prov.getDecryptionMaterials(ctx(eMat));
        assertEquals(encryptionKey, dMat.getDecryptionKey());
        assertEquals(signingKey, dMat.getVerificationKey());

        String expectedEncAlg =
                encryptionKey.getAlgorithm() + "/" + (encryptionKey.getEncoded().length * 8);
        String expectedSigAlg = signingKey.getAlgorithm() + "/" + (signingKey.getEncoded().length * 8);

        Map<String, String> kmsCtx = kms.getSingleEc();
        assertEquals(expectedEncAlg, kmsCtx.get("*" + WrappedRawMaterials.CONTENT_KEY_ALGORITHM + "*"));
        assertEquals(expectedSigAlg, kmsCtx.get("*amzn-ddb-sig-alg*"));
    }

    @Test
    public void simpleWithKmsEc() {
        DirectKmsMaterialsProvider prov = new DirectKmsMaterialsProvider(kms, keyId);

        Map<String, AttributeValue> attrVals = new HashMap<>();
        attrVals.put("hk", AttributeValue.builder().s("HashKeyValue").build());
        attrVals.put("rk", AttributeValue.builder().s("RangeKeyValue").build());

        ctx =
                new EncryptionContext.Builder()
                        .hashKeyName("hk")
                        .rangeKeyName("rk")
                        .tableName("KmsTableName")
                        .attributeValues(attrVals)
                        .build();
        EncryptionMaterials eMat = prov.getEncryptionMaterials(ctx);
        SecretKey encryptionKey = eMat.getEncryptionKey();
        assertNotNull(encryptionKey);
        Key signingKey = eMat.getSigningKey();
        assertNotNull(signingKey);
        Map<String, String> kmsCtx = kms.getSingleEc();
        assertEquals("HashKeyValue", kmsCtx.get("hk"));
        assertEquals("RangeKeyValue", kmsCtx.get("rk"));
        assertEquals("KmsTableName", kmsCtx.get("*aws-kms-table*"));

        EncryptionContext dCtx =
                new EncryptionContext.Builder(ctx(eMat))
                        .hashKeyName("hk")
                        .rangeKeyName("rk")
                        .tableName("KmsTableName")
                        .attributeValues(attrVals)
                        .build();

        DecryptionMaterials dMat = prov.getDecryptionMaterials(dCtx);
        assertEquals(encryptionKey, dMat.getDecryptionKey());
        assertEquals(signingKey, dMat.getVerificationKey());
    }

    @Test
    public void simpleWithKmsEc2() throws GeneralSecurityException {
        DirectKmsMaterialsProvider prov = new DirectKmsMaterialsProvider(kms, keyId);

        Map<String, AttributeValue> attrVals = new HashMap<>();
        attrVals.put("hk", AttributeValue.builder().n("10").build());
        attrVals.put("rk", AttributeValue.builder().n("20").build());

        ctx =
                new EncryptionContext.Builder()
                        .hashKeyName("hk")
                        .rangeKeyName("rk")
                        .tableName("KmsTableName")
                        .attributeValues(attrVals)
                        .build();
        EncryptionMaterials eMat = prov.getEncryptionMaterials(ctx);
        SecretKey encryptionKey = eMat.getEncryptionKey();
        assertNotNull(encryptionKey);
        Key signingKey = eMat.getSigningKey();
        assertNotNull(signingKey);
        Map<String, String> kmsCtx = kms.getSingleEc();
        assertEquals("10", kmsCtx.get("hk"));
        assertEquals("20", kmsCtx.get("rk"));
        assertEquals("KmsTableName", kmsCtx.get("*aws-kms-table*"));

        EncryptionContext dCtx =
                new EncryptionContext.Builder(ctx(eMat))
                        .hashKeyName("hk")
                        .rangeKeyName("rk")
                        .tableName("KmsTableName")
                        .attributeValues(attrVals)
                        .build();

        DecryptionMaterials dMat = prov.getDecryptionMaterials(dCtx);
        assertEquals(encryptionKey, dMat.getDecryptionKey());
        assertEquals(signingKey, dMat.getVerificationKey());
    }

    @Test
    public void simpleWithKmsEc3() throws GeneralSecurityException {
        DirectKmsMaterialsProvider prov = new DirectKmsMaterialsProvider(kms, keyId);

        Map<String, AttributeValue> attrVals = new HashMap<>();
        attrVals.put(
                "hk", AttributeValue.builder()
                        .b(SdkBytes.fromByteBuffer(ByteBuffer.wrap("Foo".getBytes(StandardCharsets.UTF_8))))
                        .build());
        attrVals.put(
                "rk", AttributeValue.builder()
                        .b(SdkBytes.fromByteBuffer(ByteBuffer.wrap("Bar".getBytes(StandardCharsets.UTF_8))))
                        .build());

        ctx =
                new EncryptionContext.Builder()
                        .hashKeyName("hk")
                        .rangeKeyName("rk")
                        .tableName("KmsTableName")
                        .attributeValues(attrVals)
                        .build();
        EncryptionMaterials eMat = prov.getEncryptionMaterials(ctx);
        SecretKey encryptionKey = eMat.getEncryptionKey();
        assertNotNull(encryptionKey);
        Key signingKey = eMat.getSigningKey();
        assertNotNull(signingKey);
        assertNotNull(signingKey);
        Map<String, String> kmsCtx = kms.getSingleEc();
        assertEquals(Base64.encodeToString("Foo".getBytes(StandardCharsets.UTF_8)), kmsCtx.get("hk"));
        assertEquals(Base64.encodeToString("Bar".getBytes(StandardCharsets.UTF_8)), kmsCtx.get("rk"));
        assertEquals("KmsTableName", kmsCtx.get("*aws-kms-table*"));

        EncryptionContext dCtx =
                new EncryptionContext.Builder(ctx(eMat))
                        .hashKeyName("hk")
                        .rangeKeyName("rk")
                        .tableName("KmsTableName")
                        .attributeValues(attrVals)
                        .build();

        DecryptionMaterials dMat = prov.getDecryptionMaterials(dCtx);
        assertEquals(encryptionKey, dMat.getDecryptionKey());
        assertEquals(signingKey, dMat.getVerificationKey());
    }

    @Test
    public void randomEnvelopeKeys() throws GeneralSecurityException {
        DirectKmsMaterialsProvider prov = new DirectKmsMaterialsProvider(kms, keyId);

        EncryptionMaterials eMat = prov.getEncryptionMaterials(ctx);
        SecretKey encryptionKey = eMat.getEncryptionKey();
        assertNotNull(encryptionKey);

        EncryptionMaterials eMat2 = prov.getEncryptionMaterials(ctx);
        SecretKey encryptionKey2 = eMat2.getEncryptionKey();

        assertFalse("Envelope keys must be different", encryptionKey.equals(encryptionKey2));
    }

    @Test
    public void testRefresh() {
        // This does nothing, make sure we don't throw and exception.
        DirectKmsMaterialsProvider prov = new DirectKmsMaterialsProvider(kms, keyId);
        prov.refresh();
    }

    @Test
    public void explicitContentKeyAlgorithm() throws GeneralSecurityException {
        Map<String, String> desc = new HashMap<>();
        desc.put(WrappedRawMaterials.CONTENT_KEY_ALGORITHM, "AES");

        DirectKmsMaterialsProvider prov = new DirectKmsMaterialsProvider(kms, keyId, desc);

        EncryptionMaterials eMat = prov.getEncryptionMaterials(ctx);
        SecretKey encryptionKey = eMat.getEncryptionKey();
        assertNotNull(encryptionKey);

        DecryptionMaterials dMat = prov.getDecryptionMaterials(ctx(eMat));
        assertEquals(
                "AES", eMat.getMaterialDescription().get(WrappedRawMaterials.CONTENT_KEY_ALGORITHM));
        assertEquals(encryptionKey, dMat.getDecryptionKey());
    }

    @Test
    public void explicitContentKeyLength128() throws GeneralSecurityException {
        Map<String, String> desc = new HashMap<>();
        desc.put(WrappedRawMaterials.CONTENT_KEY_ALGORITHM, "AES/128");

        DirectKmsMaterialsProvider prov = new DirectKmsMaterialsProvider(kms, keyId, desc);

        EncryptionMaterials eMat = prov.getEncryptionMaterials(ctx);
        SecretKey encryptionKey = eMat.getEncryptionKey();
        assertNotNull(encryptionKey);
        assertEquals(16, encryptionKey.getEncoded().length); // 128 Bits

        DecryptionMaterials dMat = prov.getDecryptionMaterials(ctx(eMat));
        assertEquals(
                "AES/128", eMat.getMaterialDescription().get(WrappedRawMaterials.CONTENT_KEY_ALGORITHM));
        assertEquals("AES", eMat.getEncryptionKey().getAlgorithm());
        assertEquals(encryptionKey, dMat.getDecryptionKey());
    }

    @Test
    public void explicitContentKeyLength256() throws GeneralSecurityException {
        Map<String, String> desc = new HashMap<>();
        desc.put(WrappedRawMaterials.CONTENT_KEY_ALGORITHM, "AES/256");

        DirectKmsMaterialsProvider prov = new DirectKmsMaterialsProvider(kms, keyId, desc);

        EncryptionMaterials eMat = prov.getEncryptionMaterials(ctx);
        SecretKey encryptionKey = eMat.getEncryptionKey();
        assertNotNull(encryptionKey);
        assertEquals(32, encryptionKey.getEncoded().length); // 256 Bits

        DecryptionMaterials dMat = prov.getDecryptionMaterials(ctx(eMat));
        assertEquals(
                "AES/256", eMat.getMaterialDescription().get(WrappedRawMaterials.CONTENT_KEY_ALGORITHM));
        assertEquals("AES", eMat.getEncryptionKey().getAlgorithm());
        assertEquals(encryptionKey, dMat.getDecryptionKey());
    }

    @Test
    public void extendedWithDerivedEncryptionKeyId() {
        ExtendedKmsMaterialsProvider prov =
                new ExtendedKmsMaterialsProvider(kms, keyId, "encryptionKeyId");
        String customKeyId = kms.createKey().keyMetadata().keyId();

        Map<String, AttributeValue> attrVals = new HashMap<>();
        attrVals.put("hk", AttributeValue.builder().n("10").build());
        attrVals.put("rk", AttributeValue.builder().n("20").build());
        attrVals.put("encryptionKeyId", AttributeValue.builder().s(customKeyId).build());

        ctx =
                new EncryptionContext.Builder()
                        .hashKeyName("hk")
                        .rangeKeyName("rk")
                        .tableName("KmsTableName")
                        .attributeValues(attrVals)
                        .build();
        EncryptionMaterials eMat = prov.getEncryptionMaterials(ctx);
        SecretKey encryptionKey = eMat.getEncryptionKey();
        assertNotNull(encryptionKey);
        Key signingKey = eMat.getSigningKey();
        assertNotNull(signingKey);
        Map<String, String> kmsCtx = kms.getSingleEc();
        assertEquals("10", kmsCtx.get("hk"));
        assertEquals("20", kmsCtx.get("rk"));
        assertEquals("KmsTableName", kmsCtx.get("*aws-kms-table*"));

        EncryptionContext dCtx =
                new EncryptionContext.Builder(ctx(eMat))
                        .hashKeyName("hk")
                        .rangeKeyName("rk")
                        .tableName("KmsTableName")
                        .attributeValues(attrVals)
                        .build();

        DecryptionMaterials dMat = prov.getDecryptionMaterials(dCtx);
        assertEquals(encryptionKey, dMat.getDecryptionKey());
        assertEquals(signingKey, dMat.getVerificationKey());
    }

    @Test(expectedExceptions = SdkException.class)
    public void encryptionKeyIdMismatch() throws SdkException {
        DirectKmsMaterialsProvider directProvider = new DirectKmsMaterialsProvider(kms, keyId);
        String customKeyId = kms.createKey().keyMetadata().keyId();

        Map<String, AttributeValue> attrVals = new HashMap<>();
        attrVals.put("hk", AttributeValue.builder().n("10").build());
        attrVals.put("rk", AttributeValue.builder().n("20").build());
        attrVals.put("encryptionKeyId", AttributeValue.builder().s(customKeyId).build());

        ctx =
                new EncryptionContext.Builder()
                        .hashKeyName("hk")
                        .rangeKeyName("rk")
                        .tableName("KmsTableName")
                        .attributeValues(attrVals)
                        .build();
        EncryptionMaterials eMat = directProvider.getEncryptionMaterials(ctx);

        EncryptionContext dCtx =
                new EncryptionContext.Builder(ctx(eMat))
                        .hashKeyName("hk")
                        .rangeKeyName("rk")
                        .tableName("KmsTableName")
                        .attributeValues(attrVals)
                        .build();

        ExtendedKmsMaterialsProvider extendedProvider =
                new ExtendedKmsMaterialsProvider(kms, keyId, "encryptionKeyId");

        extendedProvider.getDecryptionMaterials(dCtx);
    }

    @Test(expectedExceptions = SdkException.class)
    public void missingEncryptionKeyId() throws SdkException {
        ExtendedKmsMaterialsProvider prov =
                new ExtendedKmsMaterialsProvider(kms, keyId, "encryptionKeyId");

        Map<String, AttributeValue> attrVals = new HashMap<>();
        attrVals.put("hk", AttributeValue.builder().n("10").build());
        attrVals.put("rk", AttributeValue.builder().n("20").build());

        ctx =
                new EncryptionContext.Builder()
                        .hashKeyName("hk")
                        .rangeKeyName("rk")
                        .tableName("KmsTableName")
                        .attributeValues(attrVals)
                        .build();
        prov.getEncryptionMaterials(ctx);
    }

    @Test
    public void generateDataKeyIsCalledWith256NumberOfBits() {
        final AtomicBoolean gdkCalled = new AtomicBoolean(false);
        KmsClient kmsSpy =
                new FakeKMS() {
                    @Override
                    public GenerateDataKeyResponse generateDataKey(GenerateDataKeyRequest r) {
                        gdkCalled.set(true);
                        assertEquals((Integer) 32, r.numberOfBytes());
                        assertNull(r.keySpec());
                        return super.generateDataKey(r);
                    }
                };
        assertFalse(gdkCalled.get());
        new DirectKmsMaterialsProvider(kmsSpy, keyId).getEncryptionMaterials(ctx);
        assertTrue(gdkCalled.get());
    }

    private static class ExtendedKmsMaterialsProvider extends DirectKmsMaterialsProvider {
        private final String encryptionKeyIdAttributeName;

        public ExtendedKmsMaterialsProvider(
                KmsClient kms, String encryptionKeyId, String encryptionKeyIdAttributeName) {
            super(kms, encryptionKeyId);

            this.encryptionKeyIdAttributeName = encryptionKeyIdAttributeName;
        }

        @Override
        protected String selectEncryptionKeyId(EncryptionContext context)
                throws DynamoDbException {
            if (!context.getAttributeValues().containsKey(encryptionKeyIdAttributeName)) {
                throw DynamoDbException.create("encryption key attribute is not provided", new Exception());
            }

            return context.getAttributeValues().get(encryptionKeyIdAttributeName).s();
        }

        @Override
        protected void validateEncryptionKeyId(String encryptionKeyId, EncryptionContext context)
                throws DynamoDbException {
            if (!context.getAttributeValues().containsKey(encryptionKeyIdAttributeName)) {
                throw DynamoDbException.create("encryption key attribute is not provided", new Exception());
            }

            String customEncryptionKeyId =
                    context.getAttributeValues().get(encryptionKeyIdAttributeName).s();
            if (!customEncryptionKeyId.equals(encryptionKeyId)) {
                throw DynamoDbException.create("encryption key ids do not match.", new Exception());
            }
        }

        @Override
        protected DecryptResponse decrypt(DecryptRequest request, EncryptionContext context) {
            return super.decrypt(request, context);
        }

        @Override
        protected GenerateDataKeyResponse generateDataKey(
                GenerateDataKeyRequest request, EncryptionContext context) {
            return super.generateDataKey(request, context);
        }
    }

    private static EncryptionContext ctx(EncryptionMaterials mat) {
        return new EncryptionContext.Builder()
                .materialDescription(mat.getMaterialDescription())
                .build();
    }
}
