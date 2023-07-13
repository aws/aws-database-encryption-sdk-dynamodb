package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.DirectKmsMaterialProvider;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyOverride;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyPolicy;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;
import static software.amazon.cryptography.dbencryptionsdk.dynamodb.TestUtils.*;

import org.testng.annotations.Test;

public class DynamoDbEnhancedClientEncryptionTest {
    @Test
    public void TestMultipleTables() {
        TableSchema<SimpleClass> simpleSchema = TableSchema.fromBean(SimpleClass.class);
        TableSchema<SignOnlyClass> signOnlySchema = TableSchema.fromBean(SignOnlyClass.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put("SimpleClassTestTable",
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .logicalTableName("SimpleClassTestTable")
                        .keyring(createKmsKeyring())
                        .allowedUnsignedAttributes(Arrays.asList("doNothing"))
                        .schemaOnEncrypt(simpleSchema)
                        .build());
        tableConfigs.put("SignOnlyClassTestTable",
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .logicalTableName("SignOnlyClassTestTable")
                        .keyring(createKmsKeyring())
                        .schemaOnEncrypt(signOnlySchema)
                        .build());
        DynamoDbEncryptionInterceptor interceptor =
                DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                        CreateDynamoDbEncryptionInterceptorInput.builder()
                                .tableEncryptionConfigs(tableConfigs)
                                .build()
                );
        assertEquals(2, interceptor.config().tableEncryptionConfigs().size());

        DynamoDbTableEncryptionConfig simpleConfig = interceptor.config().tableEncryptionConfigs().get("SimpleClassTestTable");
        assertEquals(CryptoAction.DO_NOTHING, simpleConfig.attributeActionsOnEncrypt().get("doNothing"));
        assertEquals(CryptoAction.SIGN_ONLY, simpleConfig.attributeActionsOnEncrypt().get("signOnly"));
        assertEquals(CryptoAction.SIGN_ONLY, simpleConfig.attributeActionsOnEncrypt().get("partition_key"));
        assertEquals(CryptoAction.SIGN_ONLY, simpleConfig.attributeActionsOnEncrypt().get("sort_key"));
        assertEquals(CryptoAction.ENCRYPT_AND_SIGN, simpleConfig.attributeActionsOnEncrypt().get("encryptAndSign"));

        DynamoDbTableEncryptionConfig signOnlyConfig = interceptor.config().tableEncryptionConfigs().get("SignOnlyClassTestTable");
        assertEquals(CryptoAction.SIGN_ONLY, signOnlyConfig.attributeActionsOnEncrypt().get("partition_key"));
        assertEquals(CryptoAction.SIGN_ONLY, signOnlyConfig.attributeActionsOnEncrypt().get("sort_key"));
        assertEquals(CryptoAction.SIGN_ONLY, signOnlyConfig.attributeActionsOnEncrypt().get("attr1"));
        assertEquals(CryptoAction.SIGN_ONLY, signOnlyConfig.attributeActionsOnEncrypt().get("attr2"));
    }

    @Test
    public void TestEnhancedCreateWithLegacyPolicy() {
        // Encryptor creation
        AWSKMS kmsClient = AWSKMSClientBuilder.standard().build();
        final DirectKmsMaterialProvider cmp = new DirectKmsMaterialProvider(kmsClient, "kmsKeyARN");
        final DynamoDBEncryptor oldEncryptor = DynamoDBEncryptor.getInstance(cmp);
        final Map<String, CryptoAction> oldActions = new HashMap<>();

        TableSchema<SimpleClass> simpleSchema = TableSchema.fromBean(SimpleClass.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .logicalTableName(TEST_TABLE_NAME)
                        .keyring(createKmsKeyring())
                        .allowedUnsignedAttributes(Arrays.asList("doNothing"))
                        .schemaOnEncrypt(simpleSchema)
                        .legacyOverride(
                                LegacyOverride.builder()
                                        .encryptor(oldEncryptor)
                                        .policy(LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT)
                                        .attributeActionsOnEncrypt(oldActions)
                                        .build())
                        .build());
        DynamoDbEncryptionInterceptor interceptor =
                DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                        CreateDynamoDbEncryptionInterceptorInput.builder()
                                .tableEncryptionConfigs(tableConfigs)
                                .build()
                );
        assertNotNull(interceptor);
    }

    @Test
    public void TestEnhancedCreateWithAlgorithmSuite() {
        // Encryptor creation
        AWSKMS kmsClient = AWSKMSClientBuilder.standard().build();
        final DirectKmsMaterialProvider cmp = new DirectKmsMaterialProvider(kmsClient, "kmsKeyARN");

        TableSchema<SimpleClass> simpleSchema = TableSchema.fromBean(SimpleClass.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .logicalTableName(TEST_TABLE_NAME)
                        .keyring(createKmsKeyring())
                        .allowedUnsignedAttributes(Arrays.asList("doNothing"))
                        .schemaOnEncrypt(simpleSchema)
                        .algorithmSuiteId(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384)
                        .build());
        DynamoDbEncryptionInterceptor interceptor =
                DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                        CreateDynamoDbEncryptionInterceptorInput.builder()
                                .tableEncryptionConfigs(tableConfigs)
                                .build()
                );
        assertNotNull(interceptor);
    }

    @Test(
            expectedExceptions = DynamoDbEncryptionException.class,
            expectedExceptionsMessageRegExp = "Cannot use @DynamoDbEncryptionDoNothing on primary key attributes."
    )
    public void TestDoNothingOnPartitionAttribute() {
        TableSchema<InvalidAnnotatedPartitionClass> schemaOnEncrypt = TableSchema.fromBean(InvalidAnnotatedPartitionClass.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .logicalTableName(TEST_TABLE_NAME)
                        .keyring(createKmsKeyring())
                        .schemaOnEncrypt(schemaOnEncrypt)
                        .build());
        DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                CreateDynamoDbEncryptionInterceptorInput.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build());
    }

    @Test(
            expectedExceptions = DynamoDbItemEncryptorException.class,
            expectedExceptionsMessageRegExp = "Attribute doNothing is configured as DO_NOTHING but it must also be in unauthenticatedAttributes or begin with the unauthenticatedPrefix."
    )
    public void TestInconsistentSignatureScopeMissing() {
        TableSchema<SimpleClass> schemaOnEncrypt = TableSchema.fromBean(SimpleClass.class);

        // Do not specify Unauthenticated attributes when you should
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .logicalTableName(TEST_TABLE_NAME)
                        .keyring(createKmsKeyring())
                        .schemaOnEncrypt(schemaOnEncrypt)
                        .build());
        DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                CreateDynamoDbEncryptionInterceptorInput.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build());
    }

    @Test(
            expectedExceptions = DynamoDbItemEncryptorException.class,
            expectedExceptionsMessageRegExp = "Attribute partition_key is configured as SIGN_ONLY but it is also in unauthenticatedAttributes."
    )
    public void TestInconsistentSignatureScopeIncorrect() {
        TableSchema<SimpleClass> schemaOnEncrypt = TableSchema.fromBean(SimpleClass.class);

        // Specify Unauthenticated attributes when you should not
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .logicalTableName(TEST_TABLE_NAME)
                        .keyring(createKmsKeyring())
                        .allowedUnsignedAttributes(Arrays.asList("doNothing", "partition_key"))
                        .schemaOnEncrypt(schemaOnEncrypt)
                        .build());
        DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                CreateDynamoDbEncryptionInterceptorInput.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build());
    }

    @Test(
            expectedExceptions = DynamoDbEncryptionException.class,
            expectedExceptionsMessageRegExp = "Cannot use @DynamoDbEncryptionDoNothing on primary key attributes."
    )
    public void TestDoNothingOnSortAttribute() {
        TableSchema<InvalidAnnotatedSortClass> schemaOnEncrypt = TableSchema.fromBean(InvalidAnnotatedSortClass.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .logicalTableName(TEST_TABLE_NAME)
                        .keyring(createKmsKeyring())
                        .schemaOnEncrypt(schemaOnEncrypt)
                        .build());
        DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                CreateDynamoDbEncryptionInterceptorInput.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build());
    }

    @Test(
            expectedExceptions = DynamoDbEncryptionException.class,
            expectedExceptionsMessageRegExp = "Cannot use @DynamoDbEncryptionDoNothing and @DynamoDbEncryptionSignOnly on same attribute."
    )
    public void TestDoubleAnnotationOnAttribute() {
        TableSchema<InvalidDoubleAnnotationClass> schemaOnEncrypt = TableSchema.fromBean(InvalidDoubleAnnotationClass.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .logicalTableName(TEST_TABLE_NAME)
                        .keyring(createKmsKeyring())
                        .schemaOnEncrypt(schemaOnEncrypt)
                        .build());
        DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                CreateDynamoDbEncryptionInterceptorInput.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build());
    }

    @Test(
        expectedExceptions = DynamoDbItemEncryptorException.class,
        expectedExceptionsMessageRegExp = "Attribute lastName is configured as DO_NOTHING but it must also be in unauthenticatedAttributes or begin with the unauthenticatedPrefix."
    )
    public void TestFlattenedNestedBeanAnnotationMissingUnauthenticatedAttributes() {
        TableSchema<AnnotatedFlattenedBean> schemaOnEncrypt =
            TableSchema.fromBean(AnnotatedFlattenedBean.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
            DynamoDbEnhancedTableEncryptionConfig.builder()
                .logicalTableName(TEST_TABLE_NAME)
                .keyring(createKmsKeyring())
                .schemaOnEncrypt(schemaOnEncrypt)
                .build());
        DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
            CreateDynamoDbEncryptionInterceptorInput.builder()
                .tableEncryptionConfigs(tableConfigs)
                .build());
    }

    @Test
    public void TestFlattenedNestedBeanAnnotation() {
        TableSchema<AnnotatedFlattenedBean> schemaOnEncrypt =
            TableSchema.fromBean(AnnotatedFlattenedBean.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
            DynamoDbEnhancedTableEncryptionConfig.builder()
                .logicalTableName(TEST_TABLE_NAME)
                .keyring(createKmsKeyring())
                .schemaOnEncrypt(schemaOnEncrypt)
                .allowedUnsignedAttributes(Collections.singletonList("lastName"))
                .build());
        DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
            CreateDynamoDbEncryptionInterceptorInput.builder()
                .tableEncryptionConfigs(tableConfigs)
                .build());
    }

    @Test(
        expectedExceptions = DynamoDbEncryptionException.class
    )
    public void TestInvalidAnnotatedConvertedByAnnotationsOnNonAttributes() {
        TableSchema<InvalidAnnotatedConvertedBy> schemaOnEncrypt =
            TableSchema.fromBean(InvalidAnnotatedConvertedBy.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
            DynamoDbEnhancedTableEncryptionConfig.builder()
                .logicalTableName(TEST_TABLE_NAME)
                .keyring(createKmsKeyring())
                .schemaOnEncrypt(schemaOnEncrypt)
                .build());
        DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
            CreateDynamoDbEncryptionInterceptorInput.builder()
                .tableEncryptionConfigs(tableConfigs)
                .build());
    }

    @Test
    public void TestAnnotatedConvertedBy() {
        TableSchema<AnnotatedConvertedBy> schemaOnEncrypt =
            TableSchema.fromBean(AnnotatedConvertedBy.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
            DynamoDbEnhancedTableEncryptionConfig.builder()
                .logicalTableName(TEST_TABLE_NAME)
                .keyring(createKmsKeyring())
                .schemaOnEncrypt(schemaOnEncrypt)
                .allowedUnsignedAttributes(Collections.singletonList("nestedIgnored"))
                .build());
        DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
            CreateDynamoDbEncryptionInterceptorInput.builder()
                .tableEncryptionConfigs(tableConfigs)
                .build());
    }

    @Test(
        expectedExceptions = DynamoDbEncryptionException.class
    )
    public void TestAnnotatedConverterProvider() {
        TableSchema<InvalidAnnotatedConverterProvider> schemaOnEncrypt =
            TableSchema.fromBean(InvalidAnnotatedConverterProvider.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
            DynamoDbEnhancedTableEncryptionConfig.builder()
                .logicalTableName(TEST_TABLE_NAME)
                .keyring(createKmsKeyring())
                .schemaOnEncrypt(schemaOnEncrypt)
                .build());
        DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
            CreateDynamoDbEncryptionInterceptorInput.builder()
                .tableEncryptionConfigs(tableConfigs)
                .build());
    }

    @Test(
        expectedExceptions = DynamoDbEncryptionException.class
    )
    public void TestNestedBeanAnnotation() {
        TableSchema<InvalidAnnotatedNestedBean> schemaOnEncrypt =
            TableSchema.fromBean(InvalidAnnotatedNestedBean.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
            DynamoDbEnhancedTableEncryptionConfig.builder()
                .logicalTableName(TEST_TABLE_NAME)
                .keyring(createKmsKeyring())
                .schemaOnEncrypt(schemaOnEncrypt)
                .build());
        DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
            CreateDynamoDbEncryptionInterceptorInput.builder()
                .tableEncryptionConfigs(tableConfigs)
                .build());
    }
}
