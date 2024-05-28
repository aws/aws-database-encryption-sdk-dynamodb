package software.amazon.cryptography.examples.migration.ddbec;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.AttributeEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.SaveBehavior;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.TableNameOverride;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.DirectKmsMaterialProvider;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;

/*
  Migration Step 0: This is an example demonstrating use with the DynamoDb Encryption Client,
  and is the starting state for our migration to the AWS Database Encryption SDK for DynamoDb.
  In this example we configure a DynamoDBMapper configured to encrypt and decrypt
  items. The encryption and decryption of data is configured to use a KMS Key as the root of trust.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
*/
public class MigrationExampleStep0 {

  public static void MigrationStep0(
    String kmsKeyId,
    String ddbTableName,
    int sortReadValue
  ) {
    // 1. Create the MaterialProvider that protects your data keys. For this example,
    //    we create a DirectKmsMaterialProvider which protects data keys using a single kmsKey.
    final AWSKMS kmsClient = AWSKMSClientBuilder.defaultClient();
    final DirectKmsMaterialProvider cmp = new DirectKmsMaterialProvider(
      kmsClient,
      kmsKeyId
    );

    // 2. Create the DynamoDBEncryptor using the Material Provider created above
    final DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(cmp);

    // 3. Create a DynamoDbMapper with a AttributeEncryptor configured with the above encryptor.
    //    You MUST configure this mapper with a save behavior of PUT or CLOBBER;
    //    omitting this can result in data-corruption.
    AmazonDynamoDB ddbClient = AmazonDynamoDBClientBuilder.defaultClient();
    DynamoDBMapperConfig mapperConfig = DynamoDBMapperConfig
      .builder()
      .withSaveBehavior(SaveBehavior.PUT)
      .withTableNameOverride(
        TableNameOverride.withTableNameReplacement(ddbTableName)
      )
      .build();
    DynamoDBMapper mapper = new DynamoDBMapper(
      ddbClient,
      mapperConfig,
      new AttributeEncryptor(encryptor)
    );

    // 4. Put an example item into our DynamoDb table.
    //    This item will be encrypted client-side before it is sent to DynamoDb.
    SimpleClass item = new SimpleClass();
    item.setPartitionKey("MigrationExample");
    item.setSortKey(0);
    item.setAttribute1("encrypt and sign me!");
    item.setAttribute2("sign me!");
    item.setAttribute3("ignore me!");

    mapper.save(item);

    // 5. Get this item back from DynamoDb.
    //    The item will be decrypted client-side, and the original item returned.
    SimpleClass decryptedItem = mapper.load(
      SimpleClass.class,
      "MigrationExample",
      sortReadValue
    );

    // Demonstrate we get the expected item back
    assert decryptedItem.getPartitionKey().equals("MigrationExample");
    assert decryptedItem.getAttribute1().equals("encrypt and sign me!");
  }

  public static void main(final String[] args) {
    if (args.length < 2) {
      throw new IllegalArgumentException(
        "To run this example, include the kmsKeyId, ddbTableName, and sortReadValue as args."
      );
    }
    final String kmsKeyId = args[0];
    final String ddbTableName = args[1];
    // You can manipulate this value to demonstrate reading records written in other steps
    final int sortReadValue = Integer.parseInt(args[2]);
    MigrationStep0(kmsKeyId, ddbTableName, sortReadValue);
  }
}
