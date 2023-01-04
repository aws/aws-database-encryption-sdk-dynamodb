package software.aws.cryptography.dynamoDbEncryption.enhancedclient;

import org.junit.jupiter.api.Test;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.*;

// TODO test various schema updates
public class DynamoDbEncryptionEnhancedClientIntegrationTests {
    @Test
    public void TestPutAndGet() {
        TableSchema<SimpleClass> tableSchema = TableSchema.fromBean(SimpleClass.class);
        Map<String, DynamoDbEncryptionWithTableSchemaConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(ENHANCED_CLIENT_TEST_TABLE_NAME,
                DynamoDbEncryptionWithTableSchemaConfig.builder()
                        .keyring(createStaticKeyring())
                        .allowedUnauthenticatedAttributes(Arrays.asList("doNothing"))
                        .tableSchema(tableSchema)
                        .build());
        DynamoDbEncryptionInterceptor interceptor =
                DynamoDbEnhancedClientEncryptionHelpers.CreateDynamoDbEncryptionInterceptorWithTableSchema(
                        CreateDynamoDbEncryptionInterceptorWithTableSchemasInput.builder()
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

        DynamoDbTable<SimpleClass> table = enhancedClient.table(ENHANCED_CLIENT_TEST_TABLE_NAME, tableSchema);

        SimpleClass record = new SimpleClass();
        record.setId("foo");
        record.setSortKey("bar");
        record.setEncryptAndSign("lorem");
        record.setSignOnly("ipsum");
        record.setDoNothing("fizzbuzz");

        // Put an item into an Amazon DynamoDB table.
        table.putItem(record);

        // Get the item back from the table
        Key key = Key.builder()
                .partitionValue("foo").sortValue("bar")
                .build();

        // Get the item by using the key.
        SimpleClass result = table.getItem(
                (GetItemEnhancedRequest.Builder requestBuilder) -> requestBuilder.key(key));
        assertEquals("foo", result.getId());
        assertEquals("bar", result.getSortKey());
        assertEquals("lorem", result.getEncryptAndSign());
        assertEquals("ipsum", result.getSignOnly());
        assertEquals("fizzbuzz", result.getDoNothing());
    }
}
