package software.amazon.cryptography.examples.migration.awsdbe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.GetItemEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.kms.KmsClient;
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
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.DynamoDBEncryptor;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.DirectKmsMaterialsProvider;

/*
  Migration Step 2: This is an example demonstrating how to update your configuration
  to start writing items using the latest encryption format, but still continue
  to read any items written using the old encryption format.

  Once you deploy this change to your system, you will have a dataset
  containing items in both the old and new format.
  Because the changes in Step 1 have been deployed to all our readers,
  we can be sure that our entire system is ready to read this new data.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (N)
 */
public class MigrationExampleStep2 {

  public static void MigrationStep2(
    final String kmsKeyId,
    final String ddbTableName,
    final int sortReadValue
  ) {
    // 1. Continue to configure your Keyring, Table Schema, legacy attribute actions,
    //    and allowedUnsignedAttributes, and old DynamoDBEncryptor as you did in Step 1.
    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    final CreateAwsKmsMrkMultiKeyringInput keyringInput =
      CreateAwsKmsMrkMultiKeyringInput.builder().generator(kmsKeyId).build();
    final IKeyring kmsKeyring = matProv.CreateAwsKmsMrkMultiKeyring(keyringInput);

    final TableSchema<SimpleClass> schemaOnEncrypt = TableSchema.fromBean(SimpleClass.class);

    final List<String> allowedUnsignedAttributes = Arrays.asList("attribute3");

    final Map<String, CryptoAction> legacyActions = new HashMap<>();
    legacyActions.put("partition_key", CryptoAction.SIGN_ONLY);
    legacyActions.put("sort_key", CryptoAction.SIGN_ONLY);
    legacyActions.put("attribute1", CryptoAction.ENCRYPT_AND_SIGN);
    legacyActions.put("attribute2", CryptoAction.SIGN_ONLY);
    legacyActions.put("attribute3", CryptoAction.DO_NOTHING);

    // Configure the DynamoDBEncryptor using DDBEC SDK V2.
    final KmsClient kmsClient = KmsClient.create();
    final DirectKmsMaterialsProvider cmp = new DirectKmsMaterialsProvider(kmsClient, kmsKeyId);
    final DynamoDBEncryptor oldEncryptor = DynamoDBEncryptor.getInstance(cmp);

    // 2. When configuring our legacy behavior, use `FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT`.
    //    With this policy, you will continue to read items in both formats,
    //    but will only write new items using the new format.
    final LegacyOverride legacyOverride = LegacyOverride
      .builder()
      .encryptor(oldEncryptor)
      .policy(LegacyPolicy.FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT)
      .attributeActionsOnEncrypt(legacyActions)
      .build();

    // 3. Create the DynamoDb Encryption Interceptor with the above configuration.
    final Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
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

    // 4. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(interceptor)
          .build()
      )
      .build();

    // 5. Create the DynamoDbEnhancedClient using the AWS SDK Client created above,
    //    and create a Table with your modelled class
    final DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient
      .builder()
      .dynamoDbClient(ddb)
      .build();
    final DynamoDbTable<SimpleClass> table = enhancedClient.table(ddbTableName, schemaOnEncrypt);

    // 6. Put an item into your table using the DynamoDb Enhanced Client.
    //    This item will be encrypted in the latest format, using the
    //    configuration from your modelled class to decide
    //    which attribute to encrypt and/or sign.
    final SimpleClass item = new SimpleClass();
    item.setPartitionKey("MigrationExample");
    item.setSortKey(2);
    item.setAttribute1("encrypt and sign me!");
    item.setAttribute2("sign me!");
    item.setAttribute3("ignore me!");

    table.putItem(item);

    // 7. Get an item back from the table using the DynamoDb Enhanced Client.
    //    If this is an item written in the old format (e.g. any item written
    //    during Step 0 or 1), then we will attempt to decrypt the item
    //    using the legacy behavior.
    //    If this is an item written in the new format (e.g. any item written
    //    during Step 2 or after), then we will attempt to decrypt the item using
    //    the non-legacy behavior.
    final Key key = Key
      .builder()
      .partitionValue("MigrationExample")
      .sortValue(sortReadValue)
      .build();

    final SimpleClass decryptedItem = table.getItem(
      (GetItemEnhancedRequest.Builder requestBuilder) -> requestBuilder.key(key)
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
    MigrationStep2(kmsKeyId, ddbTableName, sortReadValue);
  }
}
