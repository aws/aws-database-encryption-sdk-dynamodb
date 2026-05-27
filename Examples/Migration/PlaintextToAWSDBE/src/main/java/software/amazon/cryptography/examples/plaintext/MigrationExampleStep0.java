package software.amazon.cryptography.examples.plaintext;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

/*
  Migration Step 0: This is the pre-migration step for the
  plaintext-to-encrypted database migration, and is the starting
  state for our migration from a plaintext database to a
  client-side encrypted database encrypted using the
  AWS Database Encryption SDK for DynamoDb.

  In this example, we configure a DynamoDbEnhancedClient to
  write a plaintext record to a table and read that record.
  This emulates the starting state of a plaintext-to-encrypted
  database migration; i.e. a plaintext database you can
  read and write to with the DynamoDbEnhancedClient.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
*/
public class MigrationExampleStep0 {

  public static void MigrationStep0(
    String ddbTableName,
    int sortReadValue,
    String partitionKey
  ) {
    // 1. Create a Table Schema over your annotated class.
    //    See SimpleClass.java in this directory for a sample annotated class
    //    for a plaintext item.
    final TableSchema<SimpleClass> tableSchema = TableSchema.fromBean(
      SimpleClass.class
    );

    // 2. Create a DynamoDB EnhancedClient and a Table with the annotated class.
    //    Note that the EnhancedClient is only available in AWS SDK for Java V2.
    //    If you are using AWS SDK for Java v2's DDBMapper, you should first
    //    migrate your config to the AWS SDK for Java v2's EnhancedClient.
    DynamoDbClient ddb = DynamoDbClient
      .builder()
      .region(Region.US_WEST_2)
      .build();
    DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient
      .builder()
      .dynamoDbClient(ddb)
      .build();
    final DynamoDbTable<SimpleClass> table = enhancedClient.table(
      ddbTableName,
      tableSchema
    );

    // 3. Put an example item into our DynamoDb table.
    //    This item will be stored in plaintext.
    SimpleClass itemToPut = new SimpleClass();
    itemToPut.setPartitionKey(partitionKey);
    itemToPut.setSortKey(0);
    itemToPut.setAttribute1("this will be encrypted and signed");
    itemToPut.setAttribute3("this will never be encrypted nor signed");
    itemToPut.setAttribute2(
      "this will never be encrypted, but it will be signed"
    );

    table.putItem(itemToPut);

    // 4. Get an item back from the table as it was written.
    //    If this is an item written in plaintext (i.e. any item written
    //    during Step 0 or 1), then the item will still be in plaintext
    //    and will be able to be processed.
    //    If this is an item that was encrypted client-side (i.e. any item written
    //    during Step 2 or after), then the item will still be encrypted client-side
    //    and will be unable to be processed in your code. To decrypt and process
    //    client-side encrypted items, you will need to configure encrypted reads on
    //    your enhanced client (this is configured from Step 1 onwards).
    SimpleClass itemToGet = new SimpleClass();
    itemToGet.setPartitionKey(partitionKey);
    itemToGet.setSortKey(sortReadValue);

    SimpleClass returnedItem = table.getItem(itemToGet);

    // Demonstrate we get the expected item back
    assert returnedItem.getPartitionKey().equals(partitionKey);
    assert returnedItem
      .getAttribute1()
      .equals("this will be encrypted and signed");
  }

  public static void main(final String[] args) {
    if (args.length <= 1) {
      throw new IllegalArgumentException(
        "To run this example, include the ddbTableName and sortReadValue as args."
      );
    }
    final String ddbTableName = args[0];
    // You can manipulate this value to demonstrate reading records written in other steps
    final int sortReadValue = Integer.parseInt(args[1]);
    final String partitionKey = args[2];
    MigrationStep0(ddbTableName, sortReadValue, partitionKey);
  }
}
