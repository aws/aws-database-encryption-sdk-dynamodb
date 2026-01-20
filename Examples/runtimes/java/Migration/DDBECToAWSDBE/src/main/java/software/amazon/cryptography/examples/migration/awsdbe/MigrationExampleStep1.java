package software.amazon.cryptography.examples.migration.awsdbe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// // v1
//import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.DirectKmsMaterialProvider;
//import com.amazonaws.services.kms.AWSKMS;
//import com.amazonaws.services.kms.AWSKMSClientBuilder;
//import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.GetItemEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.CreateDynamoDbEncryptionInterceptorInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedClientEncryption;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyOverride;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyPolicy;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;
// v2
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.DynamoDBEncryptor;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.DirectKmsMaterialsProvider;
/*
  Migration Step 1: This is an example demonstrating how to start using the
  AWS Database Encryption SDK with a pre-existing table used with DynamoDB Encryption Client.
  In this example, you configure a DynamoDb Encryption Interceptor to do the following:
    - Read items encrypted in the old format
    - Continue to encrypt items in the old format on write
    - Read items encrypted in the new format
  While this step configures your client to be ready to start reading items encrypted,
  we do not yet expect to be reading any items in the new format.
  Before you move on to step 2, ensure that these changes have successfully been deployed
  to all of your readers.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
 */
public class MigrationExampleStep1 {

  public static void MigrationStep1(
    String kmsKeyId,
    String ddbTableName,
    int sortReadValue
  ) {
    // 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
    //    For this migration, we will continue to encrypt and decrypt data using the kmsKeyId
    //    used in Step 0 by configuring an AWS KMS Keyring with that same kmsKeyId.
    //    We will use the `CreateMrkMultiKeyring` method to create this keyring,
    //    as it will correctly handle both single region and Multi-Region KMS Keys.
    //    Note that we are now using the AWS SDK for Java v2 KMS client.
    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    final CreateAwsKmsMrkMultiKeyringInput keyringInput =
      CreateAwsKmsMrkMultiKeyringInput.builder().generator(kmsKeyId).build();
    final IKeyring kmsKeyring = matProv.CreateAwsKmsMrkMultiKeyring(
      keyringInput
    );

    // 2. Create a Table Schema over your annotated class.
    //    See SimpleClass.java in this directory for the update to use the new DynamoDb Enhanced Client annotations.
    //    All primary key attributes will be signed but not encrypted (SIGN_ONLY)
    //    and by default all non-primary key attributes will be encrypted and signed (ENCRYPT_AND_SIGN).
    //    If you want a particular non-primary key attribute to be signed but not encrypted,
    //    use the `DynamoDbEncryptionSignOnly` annotation.
    //    If you want a particular attribute to be neither signed nor encrypted (DO_NOTHING),
    //    use the `DynamoDbEncryptionDoNothing` annotation.
    final TableSchema<SimpleClass> schemaOnEncrypt = TableSchema.fromBean(
      SimpleClass.class
    );

    // 3. Configure which attributes we expect to be excluded in the signature
    //    when reading items. This value represents all unsigned attributes
    //    across our entire dataset. If you ever want to add new unsigned attributes
    //    in the future, you must make an update to this field to all your readers
    //    before deploying any change to start writing that new data. It is not safe
    //    to remove attributes from this field.
    final List<String> allowedUnsignedAttributes = Arrays.asList("attribute3");

    // 4. Configure the attributeActionsOnEncrypt that are configured on our modelled class in Step 0
    //    in an explicit map.
    final Map<String, CryptoAction> legacyActions = new HashMap<>();
    legacyActions.put("partition_key", CryptoAction.SIGN_ONLY);
    legacyActions.put("sort_key", CryptoAction.SIGN_ONLY);
    legacyActions.put("attribute1", CryptoAction.ENCRYPT_AND_SIGN);
    legacyActions.put("attribute2", CryptoAction.SIGN_ONLY);
    legacyActions.put("attribute3", CryptoAction.DO_NOTHING);

    // 5. Configure the same DynamoDBEncryptor that we did in Step 0.
// V2
    final KmsClient kmsClient = KmsClient.create();
    final DirectKmsMaterialsProvider cmp = new DirectKmsMaterialsProvider(
            kmsClient,
            kmsKeyId
    );
//    final AWSKMS kmsClient = AWSKMSClientBuilder.defaultClient();
//    final DirectKmsMaterialProvider cmp = new DirectKmsMaterialProvider(ps aux | grep kiro-cli
//      kmsClient,
//      kmsKeyId
//    );
    final DynamoDBEncryptor oldEncryptor = DynamoDBEncryptor.getInstance(cmp);

    // 6. Configure our legacy behavior, inputting the DynamoDBEncryptor and attribute actions
    //    created above. For Legacy Policy, use `FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT`.
    //    With this policy, you will continue to read and write items using the old format,
    //    but will be able to start reading new items in the new format as soon as they appear.
    final LegacyOverride legacyOverride = LegacyOverride
      .builder()
      .encryptor(oldEncryptor)
      .policy(LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT)
      .attributeActionsOnEncrypt(legacyActions)
      .build();

    // 7. Create the DynamoDb Encryption Interceptor with the above configuration.
    final Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      ddbTableName,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(ddbTableName)
        .keyring(kmsKeyring)
        .allowedUnsignedAttributes(allowedUnsignedAttributes)
        .schemaOnEncrypt(schemaOnEncrypt)
        .legacyOverride(legacyOverride)
        .build()
    );
    final DynamoDbEncryptionInterceptor interceptor =
      DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
        CreateDynamoDbEncryptionInterceptorInput
          .builder()
          .tableEncryptionConfigs(tableConfigs)
          .build()
      );

    // 8. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(interceptor)
          .build()
      )
      .build();

    // 9. Create the DynamoDbEnhancedClient using the AWS SDK Client created above,
    //    and create a Table with your modelled class
    final DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient
      .builder()
      .dynamoDbClient(ddb)
      .build();
    final DynamoDbTable<SimpleClass> table = enhancedClient.table(
      ddbTableName,
      schemaOnEncrypt
    );

    // 10. Put an item into your table using the DynamoDb Enhanced Client.
    //     This item will be encrypted in the legacy format, using the
    //     old DynamoDBEncryptor and the legacy attribute actions.
    //     In this step, we do not expect items to be encrypted any differently
    //     from before.
    final SimpleClass item = new SimpleClass();
    item.setPartitionKey("MigrationExample");
    item.setSortKey(1);
    item.setAttribute1("encrypt and sign me!");
    item.setAttribute2("sign me!");
    item.setAttribute3("ignore me!");

    table.putItem(item);

    // 11. Get an item back from the table using the DynamoDb Enhanced Client.
    //     If this is an item written in the old format (e.g. any item written
    //     during Step 0 or 1), then we will attempt to decrypt the item
    //     using the legacy behavior.
    //     If this is an item written in the new format (e.g. any item written
    //     during Step 2 or after), then we will attempt to decrypt the item using
    //     the non-legacy behavior.
    final Key key = Key
      .builder()
      .partitionValue("MigrationExample")
      .sortValue(sortReadValue)
      .build();

    final SimpleClass decryptedItem =
      table.getItem((GetItemEnhancedRequest.Builder requestBuilder) ->
        requestBuilder.key(key)
      );

    // Demonstrate we get the expected item back
    assert decryptedItem.getPartitionKey().equals("MigrationExample");
    assert decryptedItem.getAttribute1().equals("encrypt and sign me!");
  }

  public static void main(final String[] args) {
    if (args.length < 3) {
      throw new IllegalArgumentException(
        "To run this example, include the kmsKeyId, ddbTableName, and sortReadValue as args."
      );
    }
    final String kmsKeyId = args[0];
    final String ddbTableName = args[1];
    // You can manipulate this value to demonstrate reading records written in other steps
    final int sortReadValue = Integer.parseInt(args[2]);
    MigrationStep1(kmsKeyId, ddbTableName, sortReadValue);
  }
}
