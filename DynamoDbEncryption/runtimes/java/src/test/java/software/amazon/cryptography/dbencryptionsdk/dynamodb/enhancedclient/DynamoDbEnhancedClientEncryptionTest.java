package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionFlags;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.DirectKmsMaterialProvider;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyPolicy;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
                        .allowedUnauthenticatedAttributes(Arrays.asList("doNothing"))
                        .tableSchema(simpleSchema)
                        .build());
        tableConfigs.put("SignOnlyClassTestTable",
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .logicalTableName("SignOnlyClassTestTable")
                        .keyring(createKmsKeyring())
                        .tableSchema(signOnlySchema)
                        .build());
        DynamoDbEncryptionInterceptor interceptor =
                DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                        CreateDynamoDbEncryptionInterceptorInput.builder()
                                .tableEncryptionConfigs(tableConfigs)
                                .build()
                );
        assertEquals(2, interceptor.config().tableEncryptionConfigs().size());

        DynamoDbTableEncryptionConfig simpleConfig = interceptor.config().tableEncryptionConfigs().get("SimpleClassTestTable");
        assertEquals(CryptoAction.DO_NOTHING, simpleConfig.attributeActions().get("doNothing"));
        assertEquals(CryptoAction.SIGN_ONLY, simpleConfig.attributeActions().get("signOnly"));
        assertEquals(CryptoAction.SIGN_ONLY, simpleConfig.attributeActions().get("partition_key"));
        assertEquals(CryptoAction.SIGN_ONLY, simpleConfig.attributeActions().get("sort_key"));
        assertEquals(CryptoAction.ENCRYPT_AND_SIGN, simpleConfig.attributeActions().get("encryptAndSign"));

        DynamoDbTableEncryptionConfig signOnlyConfig = interceptor.config().tableEncryptionConfigs().get("SignOnlyClassTestTable");
        assertEquals(CryptoAction.SIGN_ONLY, signOnlyConfig.attributeActions().get("partition_key"));
        assertEquals(CryptoAction.SIGN_ONLY, signOnlyConfig.attributeActions().get("sort_key"));
        assertEquals(CryptoAction.SIGN_ONLY, signOnlyConfig.attributeActions().get("attr1"));
        assertEquals(CryptoAction.SIGN_ONLY, signOnlyConfig.attributeActions().get("attr2"));
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
                        .allowedUnauthenticatedAttributes(Arrays.asList("doNothing"))
                        .tableSchema(simpleSchema)
                        .legacyConfig(
                                LegacyConfig.builder()
                                        .encryptor(oldEncryptor)
                                        .policy(LegacyPolicy.REQUIRE_ENCRYPT_ALLOW_DECRYPT)
                                        .attributeFlags(oldActions)
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
                        .allowedUnauthenticatedAttributes(Arrays.asList("doNothing"))
                        .tableSchema(simpleSchema)
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
        TableSchema<InvalidAnnotatedPartitionClass> tableSchema = TableSchema.fromBean(InvalidAnnotatedPartitionClass.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .logicalTableName(TEST_TABLE_NAME)
                        .keyring(createKmsKeyring())
                        .tableSchema(tableSchema)
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
        TableSchema<SimpleClass> tableSchema = TableSchema.fromBean(SimpleClass.class);

        // Do not specify Unauthenticated attributes when you should
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .logicalTableName(TEST_TABLE_NAME)
                        .keyring(createKmsKeyring())
                        .tableSchema(tableSchema)
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
        TableSchema<SimpleClass> tableSchema = TableSchema.fromBean(SimpleClass.class);

        // Specify Unauthenticated attributes when you should not
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .logicalTableName(TEST_TABLE_NAME)
                        .keyring(createKmsKeyring())
                        .allowedUnauthenticatedAttributes(Arrays.asList("doNothing", "partition_key"))
                        .tableSchema(tableSchema)
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
        TableSchema<InvalidAnnotatedSortClass> tableSchema = TableSchema.fromBean(InvalidAnnotatedSortClass.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .logicalTableName(TEST_TABLE_NAME)
                        .keyring(createKmsKeyring())
                        .tableSchema(tableSchema)
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
        TableSchema<InvalidDoubleAnnotationClass> tableSchema = TableSchema.fromBean(InvalidDoubleAnnotationClass.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .logicalTableName(TEST_TABLE_NAME)
                        .keyring(createKmsKeyring())
                        .tableSchema(tableSchema)
                        .build());
        DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                CreateDynamoDbEncryptionInterceptorInput.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build());
    }
}
