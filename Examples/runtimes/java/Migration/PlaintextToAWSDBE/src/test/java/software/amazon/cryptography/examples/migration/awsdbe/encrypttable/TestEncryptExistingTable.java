package software.amazon.cryptography.examples.migration.awsdbe.encrypttable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
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
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.CreateDynamoDbEncryptionInterceptorInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedClientEncryption;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PlaintextOverride;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep1;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep2;
import software.amazon.cryptography.examples.awsdbe.SimpleClass;
import software.amazon.cryptography.examples.migration.TestUtils;
import software.amazon.cryptography.examples.plaintext.MigrationExampleStep0;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

/*
  DO NOT USE THE CODE IN THIS FILE FOR ANY PRODUCTION PURPOSE.
  THIS CODE IS NOT AN EXAMPLE OF ENCRYPTING AN EXISTING PLAINTEXT TABLE,
  AND IS NOT A SUPPORTED OR SUGGESTED APPROACH TO ENCRYPT A TABLE.

  This test contains a naive approach to encrypting all plaintext
  items in a table.

  This test configures a DynamoDbEnhancedClient to read plaintext
  items and write encrypted items. Then, it scans a table for all
  plaintext items. For each item in the scan, it Puts the item back
  to the table. The client will transparently encrypt the item when
  it is Put.

  Encrypting an existing table using a scan will not be feasible
  for any production applications with a reasonable scale (>1 MB).
  This file is included to test the library; it is not included
  as an example to encrypt an existing table and should not be used
  by any users. Users should analyze their own tables to find
  an approach to encrypt a table that works for them.
 */
public class TestEncryptExistingTable {

  public static void EncryptExistingTable(
    String kmsKeyId,
    String ddbTableName,
    String partitionKey
  ) {
    // 1. Continue to configure your Keyring, Table Schema,
    //    and allowedUnsignedAttributes as you did in Step 1.
    MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    final CreateAwsKmsMrkMultiKeyringInput keyringInput =
      CreateAwsKmsMrkMultiKeyringInput.builder().generator(kmsKeyId).build();
    final IKeyring kmsKeyring = matProv.CreateAwsKmsMrkMultiKeyring(
      keyringInput
    );

    final TableSchema<SimpleClass> tableSchema = TableSchema.fromBean(
      SimpleClass.class
    );

    final List<String> unsignedAttributes = Arrays.asList("attribute3");

    // 2. Create encryption configuration for table,
    //    using the same plaintext override as Step 2
    //    (`FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ`).
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      ddbTableName,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(ddbTableName)
        .keyring(kmsKeyring)
        .schemaOnEncrypt(tableSchema)
        .allowedUnsignedAttributes(unsignedAttributes)
        .plaintextOverride(
          PlaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ
        )
        .build()
    );

    // 3. Create DynamoDbEncryptionInterceptor using the above config
    DynamoDbEncryptionInterceptor interceptor =
      DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
        CreateDynamoDbEncryptionInterceptorInput
          .builder()
          .tableEncryptionConfigs(tableConfigs)
          .build()
      );

    // 4. Create the EnhancedClient using the interceptor, and create a table from the schema
    DynamoDbClient ddb = DynamoDbClient
      .builder()
      .region(Region.US_WEST_2)
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(interceptor)
          .build()
      )
      .build();
    DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient
      .builder()
      .dynamoDbClient(ddb)
      .build();
    final DynamoDbTable<SimpleClass> table = enhancedClient.table(
      ddbTableName,
      tableSchema
    );

    // 5. Scan the table for items with no `aws_dbe_head` attribute.
    //    Any record with the `aws_dbe_head` attribute is an encrypted record.
    //    Any record without the attribute is a plaintext record.
    //    To limit the number of affected records, we also
    //    add a condition to our filter expression that the `partition_key`
    //    partition key attribute is specific to our test, i.e.
    //    equals "PlaintextMigrationTest". We do this because our
    //    table contains multiple types of records, and we are only encrypting
    //    some in this test.
    Map<String, String> expressionAttributesNames = new HashMap<>();
    expressionAttributesNames.put("#header", "aws_dbe_head");
    expressionAttributesNames.put("#pk", "partition_key");

    Map<String, AttributeValue> expressionAttributesValues = new HashMap<>();
    expressionAttributesValues.put(
      ":plaintexttest",
      AttributeValue.builder().s(partitionKey).build()
    );

    ScanEnhancedRequest scanEnhancedRequest = ScanEnhancedRequest
      .builder()
      // We use consistent reads because we run this test in our CI,
      // where we put items then scan for them very quickly.
      // This ensures our scan has data from all write requests.
      .consistentRead(true)
      .filterExpression(
        Expression
          .builder()
          .expression("attribute_not_exists(#header) and #pk = :plaintexttest")
          .expressionNames(expressionAttributesNames)
          .expressionValues(expressionAttributesValues)
          .build()
      )
      .build();
    PageIterable<SimpleClass> scanIterable = table.scan(scanEnhancedRequest);

    // Verify we are about to modify an acceptable number of items.
    // In our test migration, this should be exactly 2.
    // Steps 0, 1, and 2 were run previously.
    // Steps 0 and 1 added plaintext items that did not have the header attribute,
    // while Step 2 added an encrypted item that did have the header attribute.
    // The scan should return the items from Steps 0 and 1.
    assert scanIterable.items().stream().count() == 2;

    // 6. Encrypt each item.
    //    Since we have configured our table to write encrypted records,
    //    we can simply put each item back to the table,
    //    and the client will overwrite the plaintext record with the encrypted record.
    scanIterable.stream().forEach(p -> p.items().forEach(table::putItem));

    // Demonstrate that the same scan now returns no results
    scanIterable = table.scan(scanEnhancedRequest);
    System.out.println(scanIterable.items().stream().count());
    assert scanIterable.items().stream().count() == 0;
  }

  @Test
  public void TestEncryptExistingTable() {
    // Given: All the previous migration steps have been run.
    MigrationExampleStep0.MigrationStep0(
      TestUtils.TEST_DDB_TABLE_NAME,
      0,
      TestUtils.PARTITION_KEY
    );
    MigrationExampleStep1.MigrationStep1(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      1,
      TestUtils.PARTITION_KEY
    );
    MigrationExampleStep2.MigrationStep2(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      2,
      TestUtils.PARTITION_KEY
    );
    // When: Execute migration, Then: Success (i.e. encrypts 2 plaintext values)
    EncryptExistingTable(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      TestUtils.PARTITION_KEY
    );
  }
}
