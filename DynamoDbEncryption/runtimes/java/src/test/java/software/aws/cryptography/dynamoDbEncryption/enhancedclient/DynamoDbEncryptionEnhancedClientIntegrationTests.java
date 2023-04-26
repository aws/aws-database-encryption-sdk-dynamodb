package software.aws.cryptography.dynamoDbEncryption.enhancedclient;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.AttributeEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.DirectKmsMaterialProvider;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.GetItemEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.kms.model.KmsException;
import software.amazon.cryptography.dynamoDbEncryption.model.LegacyConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.LegacyPolicy;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;
import software.aws.cryptography.dynamoDbEncryption.DynamoDbEncryptionInterceptor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.*;

import org.testng.annotations.Test;

public class DynamoDbEncryptionEnhancedClientIntegrationTests {
    @Test
    public void TestPutAndGet() {
        TableSchema<SimpleClass> tableSchema = TableSchema.fromBean(SimpleClass.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .keyring(createKmsKeyring())
                        .allowedUnauthenticatedAttributes(Arrays.asList("doNothing"))
                        .tableSchema(tableSchema)
                        .build());
        DynamoDbEncryptionInterceptor interceptor =
                DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                        CreateDynamoDbEncryptionInterceptorInput.builder()
                                .tableEncryptionConfigs(tableConfigs)
                                .build()
                );
        DynamoDbClient ddb = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(ddb)
                .build();

        DynamoDbTable<SimpleClass> table = enhancedClient.table(TEST_TABLE_NAME, tableSchema);

        SimpleClass record = new SimpleClass();
        record.setPartitionKey("foo");
        record.setSortKey(777);
        record.setEncryptAndSign("lorem");
        record.setSignOnly("ipsum");
        record.setDoNothing("fizzbuzz");

        // Put an item into an Amazon DynamoDB table.
        table.putItem(record);

        // Get the item back from the table
        Key key = Key.builder()
                .partitionValue("foo").sortValue(777)
                .build();

        // Get the item by using the key.
        SimpleClass result = table.getItem(
                (GetItemEnhancedRequest.Builder requestBuilder) -> requestBuilder.key(key));
        assertEquals("foo", result.getPartitionKey());
        assertEquals(777, result.getSortKey());
        assertEquals("lorem", result.getEncryptAndSign());
        assertEquals("ipsum", result.getSignOnly());
        assertEquals("fizzbuzz", result.getDoNothing());
    }

    @Test
    public void TestGetLegacyItem() {
        // Put item using legacy DDBMapper
        AWSKMS kmsClient = AWSKMSClientBuilder.standard().build();
        final DirectKmsMaterialProvider cmp = new DirectKmsMaterialProvider(kmsClient, KMS_TEST_KEY_ID);
        final DynamoDBEncryptor oldEncryptor = DynamoDBEncryptor.getInstance(cmp);
        final AmazonDynamoDB ddbv1 = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapperConfig mapperConfig = DynamoDBMapperConfig.builder().withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.PUT).build();
        DynamoDBMapper mapper = new DynamoDBMapper(ddbv1, mapperConfig, new AttributeEncryptor(oldEncryptor));

        LegacyClass record = new LegacyClass();
        record.setPartitionKey("ddbMapperItem");
        record.setSortKey(777);
        record.setEncryptAndSign("lorem");
        record.setSignOnly("ipsum");
        record.setDoNothing("fizzbuzz");

        mapper.save(record);

        // Configure EnhancedClient with Legacy behavior
        Map<String, CryptoAction> legacyActions = new HashMap<>();
        legacyActions.put("partition_key", CryptoAction.SIGN_ONLY);
        legacyActions.put("sort_key", CryptoAction.SIGN_ONLY);
        legacyActions.put("encryptAndSign", CryptoAction.ENCRYPT_AND_SIGN);
        legacyActions.put("signOnly", CryptoAction.SIGN_ONLY);
        legacyActions.put("doNothing", CryptoAction.DO_NOTHING);
        LegacyConfig legacyConfig = LegacyConfig
                .builder()
                .encryptor(oldEncryptor)
                .policy(LegacyPolicy.REQUIRE_ENCRYPT_ALLOW_DECRYPT)
                .attributeFlags(legacyActions)
                .build();

        TableSchema<LegacyClass> tableSchema = TableSchema.fromBean(LegacyClass.class);
        DynamoDbEnhancedClient enhancedClient = createEnhancedClientForLegacyClass(oldEncryptor, tableSchema);

        DynamoDbTable<LegacyClass> table = enhancedClient.table(TEST_TABLE_NAME, tableSchema);

        // Get the item back from the table
        Key key = Key.builder()
                .partitionValue("ddbMapperItem").sortValue(777)
                .build();
        LegacyClass result = table.getItem(
                (GetItemEnhancedRequest.Builder requestBuilder) -> requestBuilder.key(key));
        assertEquals("ddbMapperItem", result.getPartitionKey());
        assertEquals(777, result.getSortKey());
        assertEquals("lorem", result.getEncryptAndSign());
        assertEquals("ipsum", result.getSignOnly());
        assertEquals("fizzbuzz", result.getDoNothing());
    }

    @Test
    public void TestWriteLegacyItem() {
        // Configure EnhancedClient with Legacy behavior
        AWSKMS kmsClient = AWSKMSClientBuilder.standard().build();
        final DirectKmsMaterialProvider cmp = new DirectKmsMaterialProvider(kmsClient, KMS_TEST_KEY_ID);
        final DynamoDBEncryptor oldEncryptor = DynamoDBEncryptor.getInstance(cmp);
        TableSchema<LegacyClass> tableSchema = TableSchema.fromBean(LegacyClass.class);
        DynamoDbEnhancedClient enhancedClient = createEnhancedClientForLegacyClass(oldEncryptor, tableSchema);

        LegacyClass record = new LegacyClass();
        record.setPartitionKey("legacyItem");
        record.setSortKey(777);
        record.setEncryptAndSign("lorem");
        record.setSignOnly("ipsum");
        record.setDoNothing("fizzbuzz");

        DynamoDbTable<LegacyClass> table = enhancedClient.table(TEST_TABLE_NAME, tableSchema);
        table.putItem(record);

        // Get item using legacy DDBMapper
        final AmazonDynamoDB ddbv1 = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapperConfig mapperConfig = DynamoDBMapperConfig.builder().withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.PUT).build();
        DynamoDBMapper mapper = new DynamoDBMapper(ddbv1, mapperConfig, new AttributeEncryptor(oldEncryptor));

        LegacyClass result = mapper.load(LegacyClass.class, "legacyItem", 777);
        assertEquals("legacyItem", result.getPartitionKey());
        assertEquals(777, result.getSortKey());
        assertEquals("lorem", result.getEncryptAndSign());
        assertEquals("ipsum", result.getSignOnly());
        assertEquals("fizzbuzz", result.getDoNothing());
    }

    private static DynamoDbEnhancedClient createEnhancedClientForLegacyClass(DynamoDBEncryptor oldEncryptor, TableSchema tableSchema) {
        Map<String, CryptoAction> legacyActions = new HashMap<>();
        legacyActions.put("partition_key", CryptoAction.SIGN_ONLY);
        legacyActions.put("sort_key", CryptoAction.SIGN_ONLY);
        legacyActions.put("encryptAndSign", CryptoAction.ENCRYPT_AND_SIGN);
        legacyActions.put("signOnly", CryptoAction.SIGN_ONLY);
        legacyActions.put("doNothing", CryptoAction.DO_NOTHING);
        LegacyConfig legacyConfig = LegacyConfig
                .builder()
                .encryptor(oldEncryptor)
                .policy(LegacyPolicy.REQUIRE_ENCRYPT_ALLOW_DECRYPT)
                .attributeFlags(legacyActions)
                .build();

        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .keyring(createKmsKeyring())
                        .allowedUnauthenticatedAttributes(Arrays.asList("doNothing"))
                        .tableSchema(tableSchema)
                        .legacyConfig(legacyConfig)
                        .build());
        DynamoDbEncryptionInterceptor interceptor =
                DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                        CreateDynamoDbEncryptionInterceptorInput.builder()
                                .tableEncryptionConfigs(tableConfigs)
                                .build()
                );
        DynamoDbClient ddb = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();
       return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(ddb)
                .build();
    }

    @Test(
            expectedExceptions = KmsException.class,
            expectedExceptionsMessageRegExp = "Service returned error code AccessDeniedException.*"
    )
    public void TestKmsError() {
        // Use an KMS Key that does not exist
        String invalidKey = "arn:aws:kms:us-west-2:658956600833:key/ffffffff-ffff-ffff-ffff-ffffffffffff";
        TableSchema<SimpleClass> tableSchema = TableSchema.fromBean(SimpleClass.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(TEST_TABLE_NAME,
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .keyring(createKmsKeyring(invalidKey))
                        .allowedUnauthenticatedAttributes(Arrays.asList("doNothing"))
                        .tableSchema(tableSchema)
                        .build());
        DynamoDbEncryptionInterceptor interceptor =
                DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                        CreateDynamoDbEncryptionInterceptorInput.builder()
                                .tableEncryptionConfigs(tableConfigs)
                                .build()
                );
        DynamoDbClient ddb = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(ddb)
                .build();

        DynamoDbTable<SimpleClass> table = enhancedClient.table(TEST_TABLE_NAME, tableSchema);

        SimpleClass record = new SimpleClass();
        record.setPartitionKey("foo");
        record.setSortKey(777);
        record.setEncryptAndSign("lorem");
        record.setSignOnly("ipsum");
        record.setDoNothing("fizzbuzz");

        // Put an item into an Amazon DynamoDB table.
        table.putItem(record);
    }

    @Test(
            expectedExceptions = DynamoDbException.class,
            expectedExceptionsMessageRegExp = ".*Status Code: 400.*"
    )
    public void TestDdbError() {
        // Use an KMS Key that does not exist
        String badTableName = "tableDoesNotExist";
        TableSchema<SimpleClass> tableSchema = TableSchema.fromBean(SimpleClass.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put("badTableName",
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .keyring(createKmsKeyring())
                        .allowedUnauthenticatedAttributes(Arrays.asList("doNothing"))
                        .tableSchema(tableSchema)
                        .build());
        DynamoDbEncryptionInterceptor interceptor =
                DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                        CreateDynamoDbEncryptionInterceptorInput.builder()
                                .tableEncryptionConfigs(tableConfigs)
                                .build()
                );
        DynamoDbClient ddb = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(ddb)
                .build();

        DynamoDbTable<SimpleClass> table = enhancedClient.table(badTableName, tableSchema);

        SimpleClass record = new SimpleClass();
        record.setPartitionKey("foo");
        record.setSortKey(777);
        record.setEncryptAndSign("lorem");
        record.setSignOnly("ipsum");
        record.setDoNothing("fizzbuzz");

        // Put an item into an Amazon DynamoDB table.
        table.putItem(record);
    }
}
