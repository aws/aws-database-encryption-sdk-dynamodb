package software.aws.cryptography.dynamoDbEncryption.enhancedclient;

import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionFlags;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.DirectKmsMaterialProvider;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.cryptography.dynamoDbEncryption.model.*;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.DynamoDbItemEncryptorException;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;
import software.aws.cryptography.dynamoDbEncryption.DynamoDbEncryptionInterceptor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.ENHANCED_CLIENT_TEST_TABLE_NAME;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.createStaticKeyring;

public class DynamoDbEnhancedClientEncryptionHelpersTest {
    @Test
    public void TestMultipleTables() {
        TableSchema<SimpleClass> simpleSchema = TableSchema.fromBean(SimpleClass.class);
        TableSchema<SignOnlyClass> signOnlySchema = TableSchema.fromBean(SignOnlyClass.class);
        Map<String, DynamoDbEncryptionWithTableSchemaConfig> tableConfigs = new HashMap<>();
        tableConfigs.put("SimpleClassTestTable",
                DynamoDbEncryptionWithTableSchemaConfig.builder()
                        .keyring(createStaticKeyring())
                        .allowedUnauthenticatedAttributes(Arrays.asList("doNothing"))
                        .tableSchema(simpleSchema)
                        .build());
        tableConfigs.put("SignOnlyClassTestTable",
                DynamoDbEncryptionWithTableSchemaConfig.builder()
                        .keyring(createStaticKeyring())
                        .tableSchema(signOnlySchema)
                        .build());
        DynamoDbEncryptionInterceptor interceptor =
                DynamoDbEnhancedClientEncryptionHelpers.CreateDynamoDbEncryptionInterceptorWithTableSchema(
                        CreateDynamoDbEncryptionInterceptorWithTableSchemasInput.builder()
                                .tableEncryptionConfigs(tableConfigs)
                                .build()
                );
        assertEquals(2, interceptor.config().tableEncryptionConfigs().size());

        DynamoDbTableEncryptionConfig simpleConfig = interceptor.config().tableEncryptionConfigs().get("SimpleClassTestTable");
        assertEquals(CryptoAction.DO_NOTHING, simpleConfig.attributeActions().get("doNothing"));
        assertEquals(CryptoAction.SIGN_ONLY, simpleConfig.attributeActions().get("signOnly"));
        assertEquals(CryptoAction.SIGN_ONLY, simpleConfig.attributeActions().get("id"));
        assertEquals(CryptoAction.SIGN_ONLY, simpleConfig.attributeActions().get("sortKey"));
        assertEquals(CryptoAction.ENCRYPT_AND_SIGN, simpleConfig.attributeActions().get("encryptAndSign"));

        DynamoDbTableEncryptionConfig signOnlyConfig = interceptor.config().tableEncryptionConfigs().get("SignOnlyClassTestTable");
        assertEquals(CryptoAction.SIGN_ONLY, signOnlyConfig.attributeActions().get("id"));
        assertEquals(CryptoAction.SIGN_ONLY, signOnlyConfig.attributeActions().get("attr1"));
        assertEquals(CryptoAction.SIGN_ONLY, signOnlyConfig.attributeActions().get("attr2"));
    }

    @Test
    public void TestCreateAcceptsLegacyConfig() {
        // Encryptor creation
        AWSKMS kmsClient = AWSKMSClientBuilder.standard().build();
        final DirectKmsMaterialProvider cmp = new DirectKmsMaterialProvider(kmsClient, "kmsKeyARN");
        final DynamoDBEncryptor oldEncryptor = DynamoDBEncryptor.getInstance(cmp);
        final Map<String, Set<EncryptionFlags>> oldActions = new HashMap<>();

        TableSchema<SimpleClass> simpleSchema = TableSchema.fromBean(SimpleClass.class);
        Map<String, DynamoDbEncryptionWithTableSchemaConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(ENHANCED_CLIENT_TEST_TABLE_NAME,
                DynamoDbEncryptionWithTableSchemaConfig.builder()
                        .keyring(createStaticKeyring())
                        .allowedUnauthenticatedAttributes(Arrays.asList("doNothing"))
                        .tableSchema(simpleSchema)
                        .legacyConfig(
                                LegacyConfig.builder()
                                        .legacyEncryptor(LegacyDynamoDbItemEncryptor.builder()
                                                .encryptor(oldEncryptor)
                                                .attributeFlags(oldActions)
                                                .build())
                                        .legacyPolicy(LegacyPolicy.REQUIRE_ENCRYPT_ALLOW_DECRYPT)
                                        .build())
                        .build());
        DynamoDbEncryptionInterceptor interceptor =
                DynamoDbEnhancedClientEncryptionHelpers.CreateDynamoDbEncryptionInterceptorWithTableSchema(
                        CreateDynamoDbEncryptionInterceptorWithTableSchemasInput.builder()
                                .tableEncryptionConfigs(tableConfigs)
                                .build()
                );
        assertNotNull(interceptor);
    }

    @Test
    public void TestDoNothingOnPartitionAttribute() {
        TableSchema<InvalidAnnotatedPartitionClass> tableSchema = TableSchema.fromBean(InvalidAnnotatedPartitionClass.class);
        Map<String, DynamoDbEncryptionWithTableSchemaConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(ENHANCED_CLIENT_TEST_TABLE_NAME,
                DynamoDbEncryptionWithTableSchemaConfig.builder()
                        .keyring(createStaticKeyring())
                        .tableSchema(tableSchema)
                        .build());
        Exception exception = assertThrows(DynamoDbEncryptionException.class, () -> {
            DynamoDbEnhancedClientEncryptionHelpers.CreateDynamoDbEncryptionInterceptorWithTableSchema(
                    CreateDynamoDbEncryptionInterceptorWithTableSchemasInput.builder()
                            .tableEncryptionConfigs(tableConfigs)
                            .build());
        });
        assertTrue(exception.getMessage().contains("Cannot use @DynamoDbEncryptionDoNothing on primary key attributes."));
    }

    @Test
    public void TestInconsistentSignatureScope() {
        TableSchema<SimpleClass> tableSchema = TableSchema.fromBean(SimpleClass.class);

        // Do not specify Unauthenticated attributes when you should
        Map<String, DynamoDbEncryptionWithTableSchemaConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(ENHANCED_CLIENT_TEST_TABLE_NAME,
                DynamoDbEncryptionWithTableSchemaConfig.builder()
                        .keyring(createStaticKeyring())
                        .tableSchema(tableSchema)
                        .build());
        Exception exception = assertThrows(DynamoDbItemEncryptorException.class, () -> {
            DynamoDbEnhancedClientEncryptionHelpers.CreateDynamoDbEncryptionInterceptorWithTableSchema(
                    CreateDynamoDbEncryptionInterceptorWithTableSchemasInput.builder()
                            .tableEncryptionConfigs(tableConfigs)
                            .build());
        });
        assertTrue(exception.getMessage().contains("Attribute: doNothing configuration not compatible with unauthenticated configuration."));

        // Specify Unauthenticated attributes when you should not
        Map<String, DynamoDbEncryptionWithTableSchemaConfig> tableConfigs2 = new HashMap<>();
        tableConfigs.put(ENHANCED_CLIENT_TEST_TABLE_NAME,
                DynamoDbEncryptionWithTableSchemaConfig.builder()
                        .keyring(createStaticKeyring())
                        .allowedUnauthenticatedAttributes(Arrays.asList("doNothing", "id"))
                        .tableSchema(tableSchema)
                        .build());
        Exception exception2 = assertThrows(DynamoDbItemEncryptorException.class, () -> {
            DynamoDbEnhancedClientEncryptionHelpers.CreateDynamoDbEncryptionInterceptorWithTableSchema(
                    CreateDynamoDbEncryptionInterceptorWithTableSchemasInput.builder()
                            .tableEncryptionConfigs(tableConfigs)
                            .build());
        });
        assertTrue(exception2.getMessage().contains("Attribute: id configuration not compatible with unauthenticated configuration."));
    }

    @Test
    public void TestDoNothingOnSortAttribute() {
        TableSchema<InvalidAnnotatedSortClass> tableSchema = TableSchema.fromBean(InvalidAnnotatedSortClass.class);
        Map<String, DynamoDbEncryptionWithTableSchemaConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(ENHANCED_CLIENT_TEST_TABLE_NAME,
                DynamoDbEncryptionWithTableSchemaConfig.builder()
                        .keyring(createStaticKeyring())
                        .tableSchema(tableSchema)
                        .build());
        Exception exception = assertThrows(DynamoDbEncryptionException.class, () -> {
            DynamoDbEnhancedClientEncryptionHelpers.CreateDynamoDbEncryptionInterceptorWithTableSchema(
                    CreateDynamoDbEncryptionInterceptorWithTableSchemasInput.builder()
                            .tableEncryptionConfigs(tableConfigs)
                            .build());
        });
        assertTrue(exception.getMessage().contains("Cannot use @DynamoDbEncryptionDoNothing on primary key attributes."));
    }

    @Test
    public void TestDoubleAnnotationOnAttribute() {
        TableSchema<InvalidDoubleAnnotationClass> tableSchema = TableSchema.fromBean(InvalidDoubleAnnotationClass.class);
        Map<String, DynamoDbEncryptionWithTableSchemaConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(ENHANCED_CLIENT_TEST_TABLE_NAME,
                DynamoDbEncryptionWithTableSchemaConfig.builder()
                        .keyring(createStaticKeyring())
                        .tableSchema(tableSchema)
                        .build());
        Exception exception = assertThrows(DynamoDbEncryptionException.class, () -> {
            DynamoDbEnhancedClientEncryptionHelpers.CreateDynamoDbEncryptionInterceptorWithTableSchema(
                    CreateDynamoDbEncryptionInterceptorWithTableSchemasInput.builder()
                            .tableEncryptionConfigs(tableConfigs)
                            .build());
        });
        assertTrue(exception.getMessage().contains("Cannot use @DynamoDbEncryptionDoNothing and @DynamoDbEncryptionSignOnly on same attribute."));
    }
}
