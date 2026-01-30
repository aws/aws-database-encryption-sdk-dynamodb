/*
 * Copyright 2014-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption;

import static java.util.stream.Collectors.toMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.collections.Sets.newHashSet;
import static software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.utils.EncryptionContextOperators.overrideEncryptionContextTableName;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.mockito.internal.util.collections.Sets;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.materials.DecryptionMaterials;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.materials.EncryptionMaterials;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.EncryptionMaterialsProvider;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.SymmetricStaticProvider;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.internal.Utils;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.testing.AttrMatcher;

public class DynamoDbEncryptorTest {
    private static SecretKey encryptionKey;
    private static SecretKey macKey;
    
    private InstrumentedEncryptionMaterialsProvider prov;
    private DynamoDbEncryptor encryptor;
    private Map<String, AttributeValue> attribs;
    private EncryptionContext context;
    private static final String OVERRIDDEN_TABLE_NAME = "TheBestTableName";

    @BeforeClass
    public static void setUpClass() throws Exception {
        KeyGenerator aesGen = KeyGenerator.getInstance("AES");
        aesGen.init(128, Utils.getRng());
        encryptionKey = aesGen.generateKey();

        KeyGenerator macGen = KeyGenerator.getInstance("HmacSHA256");
        macGen.init(256, Utils.getRng());
        macKey = macGen.generateKey();
    }

    @BeforeMethod
    public void setUp() {
        prov = new InstrumentedEncryptionMaterialsProvider(
                    new SymmetricStaticProvider(encryptionKey, macKey,
                        Collections.emptyMap()));
        encryptor = DynamoDbEncryptor.getInstance(prov, "enryptor-");

        attribs = new HashMap<>();
        attribs.put("intValue", AttributeValue.builder().n("123").build());
        attribs.put("stringValue", AttributeValue.builder().s("Hello world!").build());
        attribs.put("byteArrayValue",
                    AttributeValue.builder().b(SdkBytes.fromByteArray(new byte[] {0, 1, 2, 3, 4, 5})).build());
        attribs.put("stringSet", AttributeValue.builder().ss("Goodbye", "Cruel", "World", "?").build());
        attribs.put("intSet", AttributeValue.builder().ns("1", "200", "10", "15", "0").build());
        attribs.put("hashKey", AttributeValue.builder().n("5").build());
        attribs.put("rangeKey", AttributeValue.builder().n("7").build());
        attribs.put("version", AttributeValue.builder().n("0").build());

        // New(er) data types
        attribs.put("booleanTrue", AttributeValue.builder().bool(true).build());
        attribs.put("booleanFalse", AttributeValue.builder().bool(false).build());
        attribs.put("nullValue", AttributeValue.builder().nul(true).build());
        Map<String, AttributeValue> tmpMap = new HashMap<>(attribs);
        attribs.put("listValue", AttributeValue.builder().l(
                AttributeValue.builder().s("I'm a string").build(),
                AttributeValue.builder().n("42").build(),
                AttributeValue.builder().s("Another string").build(),
                AttributeValue.builder().ns("1", "4", "7").build(),
                AttributeValue.builder().m(tmpMap).build(),
                AttributeValue.builder().l(
                        AttributeValue.builder().n("123").build(),
                        AttributeValue.builder().ns("1", "200", "10", "15", "0").build(),
                        AttributeValue.builder().ss("Goodbye", "Cruel", "World", "!").build()
                ).build()).build());
        tmpMap = new HashMap<>();
        tmpMap.put("another string", AttributeValue.builder().s("All around the cobbler's bench").build());
        tmpMap.put("next line", AttributeValue.builder().ss("the monkey", "chased", "the weasel").build());
        tmpMap.put("more lyrics", AttributeValue.builder().l(
                AttributeValue.builder().s("the monkey").build(),
                AttributeValue.builder().s("thought twas").build(),
                AttributeValue.builder().s("all in fun").build()
        ).build());
        tmpMap.put("weasel", AttributeValue.builder().m(Collections.singletonMap("pop", AttributeValue.builder().bool(true).build())).build());
        attribs.put("song", AttributeValue.builder().m(tmpMap).build());

        context = EncryptionContext.builder()
            .tableName("TableName")
            .hashKeyName("hashKey")
            .rangeKeyName("rangeKey")
            .build();
    }

    @Test
    public void testSetSignatureFieldName() {
        assertNotNull(encryptor.getSignatureFieldName());
        encryptor.setSignatureFieldName("A different value");
        assertEquals("A different value", encryptor.getSignatureFieldName());
    }

    @Test
    public void testSetMaterialDescriptionFieldName() {
        assertNotNull(encryptor.getMaterialDescriptionFieldName());
        encryptor.setMaterialDescriptionFieldName("A different value");
        assertEquals("A different value", encryptor.getMaterialDescriptionFieldName());
    }

    @Test
    public void fullEncryption() throws GeneralSecurityException {
        Map<String, AttributeValue> encryptedAttributes =
                encryptor.encryptAllFieldsExcept(
                        Collections.unmodifiableMap(attribs), context, "hashKey", "rangeKey", "version");
        assertThat(encryptedAttributes, AttrMatcher.invert(attribs));

        Map<String, AttributeValue> decryptedAttributes =
                encryptor.decryptAllFieldsExcept(
                        Collections.unmodifiableMap(encryptedAttributes),
                        context,
                        "hashKey",
                        "rangeKey",
                        "version");
        assertThat(decryptedAttributes, AttrMatcher.match(attribs));

        // Make sure keys and version are not encrypted
        assertAttrEquals(attribs.get("hashKey"), encryptedAttributes.get("hashKey"));
        assertAttrEquals(attribs.get("rangeKey"), encryptedAttributes.get("rangeKey"));
        assertAttrEquals(attribs.get("version"), encryptedAttributes.get("version"));

        // Make sure String has been encrypted (we'll assume the others are correct as well)
        assertTrue(encryptedAttributes.containsKey("stringValue"));
        assertNull(encryptedAttributes.get("stringValue").s());
        assertNotNull(encryptedAttributes.get("stringValue").b());

        // Make sure we're calling the proper getEncryptionMaterials method
        assertEquals(
                "Wrong getEncryptionMaterials() called",
                1,
                prov.getCallCount("getEncryptionMaterials(EncryptionContext context)"));
    }

    @Test
    public void ensureEncryptedAttributesUnmodified() throws GeneralSecurityException {
        Map<String, AttributeValue> encryptedAttributes =
                encryptor.encryptAllFieldsExcept(
                        Collections.unmodifiableMap(attribs), context, "hashKey", "rangeKey", "version");
        String encryptedString = encryptedAttributes.toString();
        encryptor.decryptAllFieldsExcept(
                Collections.unmodifiableMap(encryptedAttributes),
                context,
                "hashKey",
                "rangeKey",
                "version");

        assertEquals(encryptedString, encryptedAttributes.toString());
    }

    @Test(expectedExceptions = SignatureException.class)
    public void fullEncryptionBadSignature() throws GeneralSecurityException {
        Map<String, AttributeValue> encryptedAttributes =
                encryptor.encryptAllFieldsExcept(
                        Collections.unmodifiableMap(attribs), context, "hashKey", "rangeKey", "version");
        assertThat(encryptedAttributes, AttrMatcher.invert(attribs));
        encryptedAttributes.put("hashKey", AttributeValue.builder().n("666").build());
        encryptor.decryptAllFieldsExcept(
                Collections.unmodifiableMap(encryptedAttributes),
                context,
                "hashKey",
                "rangeKey",
                "version");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void badVersionNumber() throws GeneralSecurityException {
        Map<String, AttributeValue> encryptedAttributes =
                encryptor.encryptAllFieldsExcept(
                        Collections.unmodifiableMap(attribs), context, "hashKey", "rangeKey", "version");
        SdkBytes materialDescription =
                encryptedAttributes.get(encryptor.getMaterialDescriptionFieldName()).b();
        byte[] rawArray = materialDescription.asByteArray();
        assertEquals(0, rawArray[0]); // This will need to be kept in sync with the current version.
        rawArray[0] = 100;
        encryptedAttributes.put(
                encryptor.getMaterialDescriptionFieldName(),
                AttributeValue.builder().b(SdkBytes.fromByteBuffer(ByteBuffer.wrap(rawArray))).build());
        encryptor.decryptAllFieldsExcept(
                Collections.unmodifiableMap(encryptedAttributes),
                context,
                "hashKey",
                "rangeKey",
                "version");
    }

    @Test
    public void signedOnly() throws GeneralSecurityException {
        Map<String, AttributeValue> encryptedAttributes =
                encryptor.encryptAllFieldsExcept(attribs, context, attribs.keySet().toArray(new String[0]));
        assertThat(encryptedAttributes, AttrMatcher.invert(attribs));
        Map<String, AttributeValue> decryptedAttributes =
                encryptor.decryptAllFieldsExcept(
                        encryptedAttributes, context, attribs.keySet().toArray(new String[0]));
        assertThat(decryptedAttributes, AttrMatcher.match(attribs));

        // Make sure keys and version are not encrypted
        assertAttrEquals(attribs.get("hashKey"), encryptedAttributes.get("hashKey"));
        assertAttrEquals(attribs.get("rangeKey"), encryptedAttributes.get("rangeKey"));
        assertAttrEquals(attribs.get("version"), encryptedAttributes.get("version"));

        // Make sure String has not been encrypted (we'll assume the others are correct as well)
        assertAttrEquals(attribs.get("stringValue"), encryptedAttributes.get("stringValue"));
    }

    @Test
    public void signedOnlyNullCryptoKey() throws GeneralSecurityException {
        prov =
                new InstrumentedEncryptionMaterialsProvider(
                        new SymmetricStaticProvider(null, macKey, Collections.emptyMap()));
        encryptor = DynamoDbEncryptor.getInstance(prov, "encryptor-");
        Map<String, AttributeValue> encryptedAttributes =
                encryptor.encryptAllFieldsExcept(attribs, context, attribs.keySet().toArray(new String[0]));
        assertThat(encryptedAttributes, AttrMatcher.invert(attribs));
        Map<String, AttributeValue> decryptedAttributes =
                encryptor.decryptAllFieldsExcept(
                        encryptedAttributes, context, attribs.keySet().toArray(new String[0]));
        assertThat(decryptedAttributes, AttrMatcher.match(attribs));

        // Make sure keys and version are not encrypted
        assertAttrEquals(attribs.get("hashKey"), encryptedAttributes.get("hashKey"));
        assertAttrEquals(attribs.get("rangeKey"), encryptedAttributes.get("rangeKey"));
        assertAttrEquals(attribs.get("version"), encryptedAttributes.get("version"));

        // Make sure String has not been encrypted (we'll assume the others are correct as well)
        assertAttrEquals(attribs.get("stringValue"), encryptedAttributes.get("stringValue"));
    }

    @Test(expectedExceptions = SignatureException.class)
    public void signedOnlyBadSignature() throws GeneralSecurityException {
        Map<String, AttributeValue> encryptedAttributes =
                encryptor.encryptAllFieldsExcept(attribs, context, attribs.keySet().toArray(new String[0]));
        assertThat(encryptedAttributes, AttrMatcher.invert(attribs));
        encryptedAttributes.put("hashKey", AttributeValue.builder().n("666").build());
        encryptor.decryptAllFieldsExcept(
                encryptedAttributes, context, attribs.keySet().toArray(new String[0]));
    }

    @Test(expectedExceptions = SignatureException.class)
    public void signedOnlyNoSignature() throws GeneralSecurityException {
        Map<String, AttributeValue> encryptedAttributes =
                encryptor.encryptAllFieldsExcept(attribs, context, attribs.keySet().toArray(new String[0]));
        assertThat(encryptedAttributes, AttrMatcher.invert(attribs));
        encryptedAttributes.remove(encryptor.getSignatureFieldName());
        encryptor.decryptAllFieldsExcept(
                encryptedAttributes, context, attribs.keySet().toArray(new String[0]));
    }

    @Test
    public void RsaSignedOnly() throws GeneralSecurityException {
        KeyPairGenerator rsaGen = KeyPairGenerator.getInstance("RSA");
        rsaGen.initialize(2048, Utils.getRng());
        KeyPair sigPair = rsaGen.generateKeyPair();
        encryptor =
                DynamoDbEncryptor.getInstance(
                        new SymmetricStaticProvider(
                                encryptionKey, sigPair, Collections.<String, String>emptyMap()),
                        "encryptor-");

        Map<String, AttributeValue> encryptedAttributes =
                encryptor.encryptAllFieldsExcept(attribs, context, attribs.keySet().toArray(new String[0]));
        assertThat(encryptedAttributes, AttrMatcher.invert(attribs));
        Map<String, AttributeValue> decryptedAttributes =
                encryptor.decryptAllFieldsExcept(
                        encryptedAttributes, context, attribs.keySet().toArray(new String[0]));
        assertThat(decryptedAttributes, AttrMatcher.match(attribs));

        // Make sure keys and version are not encrypted
        assertAttrEquals(attribs.get("hashKey"), encryptedAttributes.get("hashKey"));
        assertAttrEquals(attribs.get("rangeKey"), encryptedAttributes.get("rangeKey"));
        assertAttrEquals(attribs.get("version"), encryptedAttributes.get("version"));

        // Make sure String has not been encrypted (we'll assume the others are correct as well)
        assertAttrEquals(attribs.get("stringValue"), encryptedAttributes.get("stringValue"));
    }

    @Test(expectedExceptions = SignatureException.class)
    public void RsaSignedOnlyBadSignature() throws GeneralSecurityException {
        KeyPairGenerator rsaGen = KeyPairGenerator.getInstance("RSA");
        rsaGen.initialize(2048, Utils.getRng());
        KeyPair sigPair = rsaGen.generateKeyPair();
        encryptor =
                DynamoDbEncryptor.getInstance(
                        new SymmetricStaticProvider(
                                encryptionKey, sigPair, Collections.<String, String>emptyMap()),
                        "encryptor-");

        Map<String, AttributeValue> encryptedAttributes =
                encryptor.encryptAllFieldsExcept(attribs, context, attribs.keySet().toArray(new String[0]));
        assertThat(encryptedAttributes, AttrMatcher.invert(attribs));
        encryptedAttributes.put("hashKey", AttributeValue.builder().n("666").build());
        encryptor.decryptAllFieldsExcept(
                encryptedAttributes, context, attribs.keySet().toArray(new String[0]));
    }

    /**
     * Tests that no exception is thrown when the encryption context override operator is null
     *
     * @throws GeneralSecurityException
     */
    @Test
    public void testNullEncryptionContextOperator() throws GeneralSecurityException {
        DynamoDbEncryptor encryptor = DynamoDbEncryptor.getInstance(prov);
        encryptor.setEncryptionContextOverrideOperator(null);
        encryptor.encryptAllFieldsExcept(attribs, context, Collections.emptyList());
    }

    /**
     * Tests decrypt and encrypt with an encryption context override operator
     */
    @Test
    public void testTableNameOverriddenEncryptionContextOperator() throws GeneralSecurityException {
        // Ensure that the table name is different from what we override the table to.
        assertThat(context.getTableName(), not(equalTo(OVERRIDDEN_TABLE_NAME)));
        DynamoDbEncryptor encryptor = DynamoDbEncryptor.getInstance(prov);
        encryptor.setEncryptionContextOverrideOperator(
                overrideEncryptionContextTableName(context.getTableName(), OVERRIDDEN_TABLE_NAME));
        Map<String, AttributeValue> encryptedItems =
                encryptor.encryptAllFieldsExcept(attribs, context, Collections.emptyList());
        Map<String, AttributeValue> decryptedItems =
                encryptor.decryptAllFieldsExcept(encryptedItems, context, Collections.emptyList());
        assertThat(decryptedItems, AttrMatcher.match(attribs));
    }


    /**
     * Tests encrypt with an encryption context override operator, and a second encryptor without an override
     */
    @Test
    public void testTableNameOverriddenEncryptionContextOperatorWithSecondEncryptor()
            throws GeneralSecurityException {
        // Ensure that the table name is different from what we override the table to.
        assertThat(context.getTableName(), not(equalTo(OVERRIDDEN_TABLE_NAME)));
        DynamoDbEncryptor encryptor = DynamoDbEncryptor.getInstance(prov);
        DynamoDbEncryptor encryptorWithoutOverride = DynamoDbEncryptor.getInstance(prov);
        encryptor.setEncryptionContextOverrideOperator(
                overrideEncryptionContextTableName(context.getTableName(), OVERRIDDEN_TABLE_NAME));
        Map<String, AttributeValue> encryptedItems =
                encryptor.encryptAllFieldsExcept(attribs, context, Collections.emptyList());

        EncryptionContext expectedOverriddenContext =
                new EncryptionContext.Builder(context).tableName("TheBestTableName").build();
        Map<String, AttributeValue> decryptedItems =
                encryptorWithoutOverride.decryptAllFieldsExcept(
                        encryptedItems, expectedOverriddenContext, Collections.emptyList());
        assertThat(decryptedItems, AttrMatcher.match(attribs));
    }

    /**
     * Tests encrypt with an encryption context override operator, and a second encryptor without an override
     */
    @Test(expectedExceptions = SignatureException.class)
    public void
    testTableNameOverriddenEncryptionContextOperatorWithSecondEncryptorButTheOriginalEncryptionContext()
            throws GeneralSecurityException {
        // Ensure that the table name is different from what we override the table to.
        assertThat(context.getTableName(), not(equalTo(OVERRIDDEN_TABLE_NAME)));
        DynamoDbEncryptor encryptor = DynamoDbEncryptor.getInstance(prov);
        DynamoDbEncryptor encryptorWithoutOverride = DynamoDbEncryptor.getInstance(prov);
        encryptor.setEncryptionContextOverrideOperator(
                overrideEncryptionContextTableName(context.getTableName(), OVERRIDDEN_TABLE_NAME));
        Map<String, AttributeValue> encryptedItems =
                encryptor.encryptAllFieldsExcept(attribs, context, Collections.emptyList());

        // Use the original encryption context, and expect a signature failure
        Map<String, AttributeValue> decryptedItems =
                encryptorWithoutOverride.decryptAllFieldsExcept(
                        encryptedItems, context, Collections.emptyList());
    }

    @Test
    public void EcdsaSignedOnly() throws GeneralSecurityException {

        encryptor = DynamoDbEncryptor.getInstance(getMaterialProviderwithECDSA());

        Map<String, AttributeValue> encryptedAttributes =
                encryptor.encryptAllFieldsExcept(attribs, context, attribs.keySet().toArray(new String[0]));
        assertThat(encryptedAttributes, AttrMatcher.invert(attribs));
        Map<String, AttributeValue> decryptedAttributes =
                encryptor.decryptAllFieldsExcept(
                        encryptedAttributes, context, attribs.keySet().toArray(new String[0]));
        assertThat(decryptedAttributes, AttrMatcher.match(attribs));

        // Make sure keys and version are not encrypted
        assertAttrEquals(attribs.get("hashKey"), encryptedAttributes.get("hashKey"));
        assertAttrEquals(attribs.get("rangeKey"), encryptedAttributes.get("rangeKey"));
        assertAttrEquals(attribs.get("version"), encryptedAttributes.get("version"));

        // Make sure String has not been encrypted (we'll assume the others are correct as well)
        assertAttrEquals(attribs.get("stringValue"), encryptedAttributes.get("stringValue"));
    }

    @Test(expectedExceptions = SignatureException.class)
    public void EcdsaSignedOnlyBadSignature() throws GeneralSecurityException {

        encryptor = DynamoDbEncryptor.getInstance(getMaterialProviderwithECDSA());

        Map<String, AttributeValue> encryptedAttributes =
                encryptor.encryptAllFieldsExcept(attribs, context, attribs.keySet().toArray(new String[0]));
        assertThat(encryptedAttributes, AttrMatcher.invert(attribs));
        encryptedAttributes.put("hashKey", AttributeValue.builder().n("666").build());
        encryptor.decryptAllFieldsExcept(
                encryptedAttributes, context, attribs.keySet().toArray(new String[0]));
    }

    @Test
    public void toByteArray() throws ReflectiveOperationException {
        final byte[] expected = new byte[] {0, 1, 2, 3, 4, 5};
        assertToByteArray("Wrap", expected, ByteBuffer.wrap(expected));
        assertToByteArray("Wrap-RO", expected, ByteBuffer.wrap(expected).asReadOnlyBuffer());

        assertToByteArray("Wrap-Truncated-Sliced", expected, ByteBuffer.wrap(new byte[] {0, 1, 2, 3, 4, 5, 6}, 0, 6).slice());
        assertToByteArray("Wrap-Offset-Sliced", expected, ByteBuffer.wrap(new byte[] {6, 0, 1, 2, 3, 4, 5, 6}, 1, 6).slice());
        assertToByteArray("Wrap-Truncated", expected, ByteBuffer.wrap(new byte[] {0, 1, 2, 3, 4, 5, 6}, 0, 6));
        assertToByteArray("Wrap-Offset", expected, ByteBuffer.wrap(new byte[] {6, 0, 1, 2, 3, 4, 5, 6}, 1, 6));

        ByteBuffer buff = ByteBuffer.allocate(expected.length + 10);
        buff.put(expected);
        buff.flip();
        assertToByteArray("Normal", expected, buff);

        buff = ByteBuffer.allocateDirect(expected.length + 10);
        buff.put(expected);
        buff.flip();
        assertToByteArray("Direct", expected, buff);
    }

    @Test
    public void testDecryptWithPlaintextItem() throws GeneralSecurityException {
        Map<String, Set<EncryptionFlags>> attributeWithEmptyEncryptionFlags =
                attribs.keySet().stream().collect(toMap(k -> k, k -> newHashSet()));

        Map<String, AttributeValue> decryptedAttributes =
                encryptor.decryptRecord(attribs, attributeWithEmptyEncryptionFlags, context);
        assertThat(decryptedAttributes, AttrMatcher.match(attribs));
    }

    /*
    Test decrypt with a map that contains a new key (not included in attribs) with an encryption flag set that contains ENCRYPT and SIGN.
     */
    @Test
    public void testDecryptWithPlainTextItemAndAdditionNewAttributeHavingEncryptionFlag()
            throws GeneralSecurityException {
        Map<String, Set<EncryptionFlags>> attributeWithEmptyEncryptionFlags =
                attribs.keySet().stream().collect(toMap(k -> k, k -> newHashSet()));
        attributeWithEmptyEncryptionFlags.put(
                "newAttribute", Sets.newSet(EncryptionFlags.ENCRYPT, EncryptionFlags.SIGN));

        Map<String, AttributeValue> decryptedAttributes =
                encryptor.decryptRecord(attribs, attributeWithEmptyEncryptionFlags, context);
        assertThat(decryptedAttributes, AttrMatcher.match(attribs));
    }
    private void assertToByteArray(
            final String msg, final byte[] expected, final ByteBuffer testValue)
            throws ReflectiveOperationException {
        Method m = DynamoDbEncryptor.class.getDeclaredMethod("toByteArray", ByteBuffer.class);
        m.setAccessible(true);

        int oldPosition = testValue.position();
        int oldLimit = testValue.limit();

        assertThat(m.invoke(null, testValue), is(expected));
        assertEquals(msg + ":Position", oldPosition, testValue.position());
        assertEquals(msg + ":Limit", oldLimit, testValue.limit());
    }

    private void assertAttrEquals(AttributeValue o1, AttributeValue o2) {
        assertEquals(o1.b(), o2.b());
        assertSetsEqual(o1.bs(), o2.bs());
        assertEquals(o1.n(), o2.n());
        assertSetsEqual(o1.ns(), o2.ns());
        assertEquals(o1.s(), o2.s());
        assertSetsEqual(o1.ss(), o2.ss());
    }
    
    private <T> void assertSetsEqual(Collection<T> c1, Collection<T> c2) {
        assertFalse(c1 == null ^ c2 == null);
        if (c1 != null) {
            Set<T> s1 = new HashSet<>(c1);
            Set<T> s2 = new HashSet<>(c2);
            assertEquals(s1, s2);
        }
    }

    private EncryptionMaterialsProvider getMaterialProviderwithECDSA() 
           throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchProviderException {
            Security.addProvider(new BouncyCastleProvider());
            ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec("secp384r1");
            KeyPairGenerator g = KeyPairGenerator.getInstance("ECDSA", "BC");
            g.initialize(ecSpec, Utils.getRng());
            KeyPair keypair = g.generateKeyPair();
            Map<String, String> description = new HashMap<>();
            description.put(DynamoDbEncryptor.DEFAULT_SIGNING_ALGORITHM_HEADER, "SHA384withECDSA");
            return new SymmetricStaticProvider(null, keypair, description);
    }

    private static final class InstrumentedEncryptionMaterialsProvider implements EncryptionMaterialsProvider {
        private final EncryptionMaterialsProvider delegate;
        private final ConcurrentHashMap<String, AtomicInteger> calls = new ConcurrentHashMap<>();
        
        InstrumentedEncryptionMaterialsProvider(EncryptionMaterialsProvider delegate) {
            this.delegate = delegate;
        }
        
        @Override
        public DecryptionMaterials getDecryptionMaterials(EncryptionContext context) {
            incrementMethodCount("getDecryptionMaterials()");
            return delegate.getDecryptionMaterials(context);
        }

        @Override
        public EncryptionMaterials getEncryptionMaterials(EncryptionContext context) {
            incrementMethodCount("getEncryptionMaterials(EncryptionContext context)");
            return delegate.getEncryptionMaterials(context);
        }

        @Override
        public void refresh() {
            incrementMethodCount("refresh()");
            delegate.refresh();
        }
        
        int getCallCount(String method) {
            AtomicInteger count = calls.get(method);
            if (count != null) {
                return count.intValue();
            } else {
                return 0;
            }
        }
        
        @SuppressWarnings("unused")
        public void resetCallCounts() {
            calls.clear();
        }
        
        private void incrementMethodCount(String method) {
            AtomicInteger oldValue = calls.putIfAbsent(method, new AtomicInteger(1));
            if (oldValue != null) {
                oldValue.incrementAndGet();
            }
        }
    }
}
