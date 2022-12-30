package software.aws.cryptography.dynamoDbEncryption.enhancedclient;

import org.junit.jupiter.api.Test;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.awssdk.enhanced.dynamodb.model.GetItemEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.aws.cryptography.dynamoDbEncryption.DynamoDbEncryptionInterceptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.*;

public class DynamoDbEncryptionEnhancedClientIntegrationTests {
    @Test
    public void TestPutAndGet() {
        TableSchema<SimpleClass> customerTableSchema = TableSchema.fromBean(SimpleClass.class);
        DynamoDbEncryptionInterceptor interceptor =
                DynamoDbEnhancedClientEncryptionHelpers.CreateDynamoDbEncryptionInterceptorWithTableSchema(
                        CreateDynamoDbEncryptionInterceptorWithTableSchemaInput.builder()
                                .tableName("DynamoDbEncryptionEnhancedClientTestTable")
                                .keyring(createStaticKeyring())
                                .tableSchema(customerTableSchema)
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

        DynamoDbTable<SimpleClass> table = enhancedClient.table("DynamoDbEncryptionEnhancedClientTestTable", customerTableSchema);

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
