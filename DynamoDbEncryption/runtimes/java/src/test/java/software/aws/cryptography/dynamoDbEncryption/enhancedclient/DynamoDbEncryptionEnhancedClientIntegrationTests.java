package software.aws.cryptography.dynamoDbEncryption.enhancedclient;

import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.GetItemEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.aws.cryptography.dynamoDbEncryption.DynamoDbEncryptionInterceptor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.*;

import org.testng.annotations.Test;

// TODO test various schema updates
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
}
