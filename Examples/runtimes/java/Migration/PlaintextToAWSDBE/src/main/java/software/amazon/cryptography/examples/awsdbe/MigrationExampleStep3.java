package software.amazon.cryptography.examples.awsdbe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Expression;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PlaintextPolicy;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.CreateDynamoDbEncryptionInterceptorInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedClientEncryption;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedTableEncryptionConfig;

/*
  Migration Step 3: This is an example demonstrating a possible approach
  to encrypting all plaintext items from a table.

  In this example, we configure a DynamoDbEnhancedClient to
  read plaintext items and write encrypted items. Then, we perform
  a scan on the table. For each item in the scan, we Put the
  item back to the table. The client will transparently encrypt
  the item when it is Put.

  This approach would only work for tables of a certain size.
  You would need to scale this approach based on the size
  of your table, possibly by batching the scan and PutItem requests.

  Once you complete Step 3, you can be sure that all table items
  have been encrypted using our configuration.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
 */
public class MigrationExampleStep3 {

    public static void MigrationStep3(String kmsKeyId, String ddbTableName) {
        // 1. Continue to configure your Keyring, Table Schema,
        //    and allowedUnauthenticatedAttributes as you did in Step 1.
        MaterialProviders matProv = MaterialProviders.builder()
            .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
            .build();
        final CreateAwsKmsMrkMultiKeyringInput keyringInput = CreateAwsKmsMrkMultiKeyringInput.builder()
            .generator(kmsKeyId)
            .build();
        final IKeyring kmsKeyring = matProv.CreateAwsKmsMrkMultiKeyring(keyringInput);

        final TableSchema<SimpleClass> tableSchema = TableSchema.fromBean(SimpleClass.class);

        final List<String> unauthAttributes = Arrays.asList("do_nothing");

        // 2. Create encryption configuration for table,
        //    using the same plaintext policy as Step 2 (`FORBID_WRITE_ALLOW_READ`).
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(ddbTableName,
            DynamoDbEnhancedTableEncryptionConfig.builder()
                .logicalTableName(ddbTableName)
                .keyring(kmsKeyring)
                .tableSchema(tableSchema)
                .allowedUnauthenticatedAttributes(unauthAttributes)
                .plaintextPolicy(PlaintextPolicy.FORBID_WRITE_ALLOW_READ)
                .build());

        // 3. Create DynamoDbEncryptionInterceptor using the above config
        DynamoDbEncryptionInterceptor interceptor =
            DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                CreateDynamoDbEncryptionInterceptorInput.builder()
                    .tableEncryptionConfigs(tableConfigs)
                    .build());

        // 4. Create the EnhancedClient using the interceptor, and create a table from the schema
        DynamoDbClient ddb = DynamoDbClient.builder()
            .region(Region.US_WEST_2)
            .overrideConfiguration(
                ClientOverrideConfiguration.builder()
                    .addExecutionInterceptor(interceptor)
                    .build())
            .build();
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
            .dynamoDbClient(ddb)
            .build();
        final DynamoDbTable<SimpleClass> table = enhancedClient.table(ddbTableName, tableSchema);

        // 5. Scan the table for items with no `aws_dbe_head` attribute.
        //    Any record with the `aws_dbe_head` attribute is an encrypted record.
        //    Any record without the attribute is a plaintext record.
        //    To limit the number of affected records, we also
        //    add a condition to our filter expression that the `partition_key`
        //    partition key attribute is specific to our example, i.e.
        //    equals "PlaintextMigrationExample". We do this because our
        //    table contains multiple types of records, and we are only encrypting
        //    some in this example. You should modify this approach if you need
        //    to selectively encrypt items according to your specific use case.
        Map<String,String> expressionAttributesNames = new HashMap<>();
        expressionAttributesNames.put("#header", "aws_dbe_head");
        expressionAttributesNames.put("#pk", "partition_key");

        Map<String,AttributeValue> expressionAttributesValues = new HashMap<>();
        expressionAttributesValues.put(":plaintextexample", AttributeValue.builder().s("PlaintextMigrationExample").build());

        ScanEnhancedRequest scanEnhancedRequest = ScanEnhancedRequest.builder()
            // We use consistent reads because we run these examples in our CI,
            // where we put items then scan for them very quickly.
            // This ensures our scan has data from all write requests.
            // You do not need to use consistent reads in your approach.
            .consistentRead(true)
            .filterExpression(Expression.builder()
                .expression("attribute_not_exists(#header) and #pk = :plaintextexample")
                .expressionNames(expressionAttributesNames)
                .expressionValues(expressionAttributesValues)
                .build())
            .build();
        PageIterable<SimpleClass> scanIterable = table.scan(scanEnhancedRequest);

        // Verify we are about to modify an acceptable number of items.
        // In our example migration, this should be exactly 2.
        // Steps 0, 1, and 2 were run previously.
        // Steps 0 and 1 added plaintext items that did not have the header attribute,
        // while Step 2 added an encrypted item that did have the header attribute.
        // The scan should return the items from Steps 0 and 1.
        assert scanIterable.items().stream().count() == 2;

        // 6. Encrypt each item.
        //    Since we have configured our table to write encrypted records,
        //    we can simply put each item back to the table,
        //    and the client will overwrite the plaintext record with the encrypted record.
        scanIterable.stream().forEach(
            p -> p.items().forEach(
                table::putItem
            )
        );

        // Demonstrate that the same scan now returns no results
        scanIterable = table.scan(scanEnhancedRequest);
        assert scanIterable.items().stream().count() == 0;
    }

    public static void main(final String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("To run this example, include the kmsKeyId and ddbTableName as args.");
        }
        final String kmsKeyId = args[0];
        final String ddbTableName = args[1];
        MigrationStep3(kmsKeyId, ddbTableName);
    }
}
