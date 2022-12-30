package software.aws.cryptography.dynamoDbEncryption.enhancedclient;

import org.junit.jupiter.api.Test;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.aws.cryptography.dynamoDbEncryption.DynamoDbEncryptionInterceptor;

import static software.aws.cryptography.dynamoDbEncryption.TestUtils.*;

public class DynamoDbEncryptionEnhancedClientIntegrationTests {
    @Test
    public void SmokeTest() {
        TableSchema<Customer> customerTableSchema = TableSchema.fromBean(Customer.class);
        DynamoDbEncryptionInterceptor interceptor = createInterceptor(createStaticKeyring());
        DynamoDbClient ddb = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(ddb)
                .build();

        DynamoDbTable<Customer> custTable = enhancedClient.table("DynamoDbEncryptionEnhancedClientTestTable", customerTableSchema);

        // Populate the Table.
        Customer custRecord = new Customer();
        custRecord.setId("id101");
        custRecord.setEmail("tred@noserver.com");

        // Put the customer data into an Amazon DynamoDB table.
        custTable.putItem(custRecord);
    }
}
