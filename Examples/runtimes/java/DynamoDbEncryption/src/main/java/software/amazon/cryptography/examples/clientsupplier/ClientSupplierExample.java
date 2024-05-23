package software.amazon.cryptography.examples.clientsupplier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkDiscoveryMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.DiscoveryFilter;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

/*
  This example sets up an MRK multi-keyring and an MRK discovery
  multi-keyring using a custom client supplier.
  A custom client supplier grants users access to more granular
  configuration aspects of their authentication details and KMS
  client. In this example, we create a simple custom client supplier
  that authenticates with a different IAM role based on the
  region of the KMS key.

  This example creates a MRK multi-keyring configured with a custom
  client supplier using a single MRK and puts an encrypted item to the
  table. Then, it creates a MRK discovery multi-keyring to decrypt the item
  and retrieves the item from the table.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
 */
public class ClientSupplierExample {

  public static void ClientSupplierPutItemGetItem(
    String ddbTableName,
    String keyArn,
    List<String> accountIds,
    List<String> regions
  ) {
    // 1. Create a single MRK multi-keyring.
    //    This can be either a single-region KMS key or an MRK.
    //    For this example to succeed, the key's region must either
    //    1) be in the regions list, or
    //    2) the key must be an MRK with a replica defined
    //    in a region in the regions list, and the client
    //    must have the correct permissions to access the replica.
    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    // Create the multi-keyring using our custom client supplier
    // defined in the RegionalRoleClientSupplier class in this directory.
    final CreateAwsKmsMrkMultiKeyringInput createAwsKmsMrkMultiKeyringInput =
      CreateAwsKmsMrkMultiKeyringInput
        .builder()
        // Note: RegionalRoleClientSupplier will internally use the keyArn's region
        // to retrieve the correct IAM role.
        .clientSupplier(new RegionalRoleClientSupplier())
        .generator(keyArn)
        .build();
    IKeyring mrkKeyringWithClientSupplier = matProv.CreateAwsKmsMrkMultiKeyring(
      createAwsKmsMrkMultiKeyringInput
    );

    // 2. Configure which attributes are encrypted and/or signed when writing new items.
    //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    //    we must explicitly configure how they should be treated during item encryption:
    //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    //      - SIGN_ONLY: The attribute is not encrypted, but is still included in the signature
    //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    final Map<String, CryptoAction> attributeActionsOnEncrypt = new HashMap<>();
    attributeActionsOnEncrypt.put("partition_key", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put("sort_key", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put(
      "sensitive_data",
      CryptoAction.ENCRYPT_AND_SIGN
    );

    // 3. Configure which attributes we expect to be included in the signature
    //    when reading items. There are two options for configuring this:
    //
    //    - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
    //      When defining your DynamoDb schema and deciding on attribute names,
    //      choose a distinguishing prefix (such as ":") for all attributes that
    //      you do not want to include in the signature.
    //      This has two main benefits:
    //      - It is easier to reason about the security and authenticity of data within your item
    //        when all unauthenticated data is easily distinguishable by their attribute name.
    //      - If you need to add new unauthenticated attributes in the future,
    //        you can easily make the corresponding update to your `attributeActionsOnEncrypt`
    //        and immediately start writing to that new attribute, without
    //        any other configuration update needed.
    //      Once you configure this field, it is not safe to update it.
    //
    //    - Configure `allowedUnsignedAttributes`: You may also explicitly list
    //      a set of attributes that should be considered unauthenticated when encountered
    //      on read. Be careful if you use this configuration. Do not remove an attribute
    //      name from this configuration, even if you are no longer writing with that attribute,
    //      as old items may still include this attribute, and our configuration needs to know
    //      to continue to exclude this attribute from the signature scope.
    //      If you add new attribute names to this field, you must first deploy the update to this
    //      field to all readers in your host fleet before deploying the update to start writing
    //      with that new attribute.
    //
    //   For this example, we currently authenticate all attributes. To make it easier to
    //   add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
    final String unsignAttrPrefix = ":";

    // 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig
      .builder()
      .logicalTableName(ddbTableName)
      .partitionKeyName("partition_key")
      .sortKeyName("sort_key")
      .attributeActionsOnEncrypt(attributeActionsOnEncrypt)
      .keyring(mrkKeyringWithClientSupplier)
      .allowedUnsignedAttributePrefix(unsignAttrPrefix)
      .build();
    tableConfigs.put(ddbTableName, config);

    // 5. Create the DynamoDb Encryption Interceptor
    DynamoDbEncryptionInterceptor encryptionInterceptor =
      DynamoDbEncryptionInterceptor
        .builder()
        .config(
          DynamoDbTablesEncryptionConfig
            .builder()
            .tableEncryptionConfigs(tableConfigs)
            .build()
        )
        .build();

    // 6. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddbClient = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(encryptionInterceptor)
          .build()
      )
      .build();

    // 7. Put an item into our table using the above client.
    //    Before the item gets sent to DynamoDb, it will be encrypted
    //    client-side using the MRK multi-keyring.
    //    The data key protecting this item will be encrypted
    //    with all the KMS Keys in this keyring, so that it can be
    //    decrypted with any one of those KMS Keys.
    final HashMap<String, AttributeValue> item = new HashMap<>();
    item.put(
      "partition_key",
      AttributeValue.builder().s("clientSupplierItem").build()
    );
    item.put("sort_key", AttributeValue.builder().n("0").build());
    item.put(
      "sensitive_data",
      AttributeValue.builder().s("encrypt and sign me!").build()
    );

    final PutItemRequest putRequest = PutItemRequest
      .builder()
      .tableName(ddbTableName)
      .item(item)
      .build();

    final PutItemResponse putResponse = ddbClient.putItem(putRequest);

    // Demonstrate that PutItem succeeded
    assert 200 == putResponse.sdkHttpResponse().statusCode();

    // 8. Get the item back from our table using the same keyring.
    //    The client will decrypt the item client-side using the MRK
    //    and return the original item.
    final HashMap<String, AttributeValue> keyToGet = new HashMap<>();
    keyToGet.put(
      "partition_key",
      AttributeValue.builder().s("clientSupplierItem").build()
    );
    keyToGet.put("sort_key", AttributeValue.builder().n("0").build());

    final GetItemRequest getRequest = GetItemRequest
      .builder()
      .key(keyToGet)
      .tableName(ddbTableName)
      .build();

    final GetItemResponse getResponse = ddbClient.getItem(getRequest);

    // Demonstrate that GetItem succeeded and returned the decrypted item
    assert 200 == getResponse.sdkHttpResponse().statusCode();
    final Map<String, AttributeValue> returnedItem = getResponse.item();
    assert returnedItem
      .get("sensitive_data")
      .s()
      .equals("encrypt and sign me!");

    // 9. Create a MRK discovery multi-keyring with a custom client supplier.
    //    A discovery MRK multi-keyring will be composed of
    //    multiple discovery MRK keyrings, one for each region.
    //    Each component keyring has its own KMS client in a particular region.
    //    When we provide a client supplier to the multi-keyring, all component
    //    keyrings will use that client supplier configuration.
    //    In our tests, we make `keyArn` an MRK with a replica, and
    //    provide only the replica region in our discovery filter.
    DiscoveryFilter discoveryFilter = DiscoveryFilter
      .builder()
      .partition("aws")
      .accountIds(accountIds)
      .build();

    final CreateAwsKmsMrkDiscoveryMultiKeyringInput mrkDiscoveryClientSupplierInput =
      CreateAwsKmsMrkDiscoveryMultiKeyringInput
        .builder()
        .clientSupplier(new RegionalRoleClientSupplier())
        .discoveryFilter(discoveryFilter)
        .regions(regions)
        .build();
    IKeyring mrkDiscoveryClientSupplierKeyring =
      matProv.CreateAwsKmsMrkDiscoveryMultiKeyring(
        mrkDiscoveryClientSupplierInput
      );

    // 10. Create a new config and client using the discovery keyring.
    //     This is the same setup as above, except we provide the discovery keyring to the config.
    final Map<
      String,
      DynamoDbTableEncryptionConfig
    > onlyReplicaKeyTableConfigs = new HashMap<>();
    final DynamoDbTableEncryptionConfig onlyReplicaKeyConfig =
      DynamoDbTableEncryptionConfig
        .builder()
        .logicalTableName(ddbTableName)
        .partitionKeyName("partition_key")
        .sortKeyName("sort_key")
        .attributeActionsOnEncrypt(attributeActionsOnEncrypt)
        // Provide discovery keyring here
        .keyring(mrkDiscoveryClientSupplierKeyring)
        .allowedUnsignedAttributePrefix(unsignAttrPrefix)
        .build();
    onlyReplicaKeyTableConfigs.put(ddbTableName, onlyReplicaKeyConfig);

    DynamoDbEncryptionInterceptor onlyReplicaKeyEncryptionInterceptor =
      DynamoDbEncryptionInterceptor
        .builder()
        .config(
          DynamoDbTablesEncryptionConfig
            .builder()
            .tableEncryptionConfigs(onlyReplicaKeyTableConfigs)
            .build()
        )
        .build();

    final DynamoDbClient onlyReplicaKeyDdbClient = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(onlyReplicaKeyEncryptionInterceptor)
          .build()
      )
      .build();

    // 11. Get the item back from our table using the discovery keyring client.
    //     The client will decrypt the item client-side using the keyring,
    //     and return the original item.
    //     The discovery keyring will only use KMS keys in the provided regions and
    //     AWS accounts. Since we have provided it with a custom client supplier
    //     which uses different IAM roles based on the key region,
    //     the discovery keyring will use a particular IAM role to decrypt
    //     based on the region of the KMS key it uses to decrypt.
    final HashMap<String, AttributeValue> onlyReplicaKeyKeyToGet =
      new HashMap<>();
    onlyReplicaKeyKeyToGet.put(
      "partition_key",
      AttributeValue.builder().s("awsKmsMrkMultiKeyringItem").build()
    );
    onlyReplicaKeyKeyToGet.put(
      "sort_key",
      AttributeValue.builder().n("0").build()
    );

    final GetItemRequest onlyReplicaKeyGetRequest = GetItemRequest
      .builder()
      .key(onlyReplicaKeyKeyToGet)
      .tableName(ddbTableName)
      .build();

    final GetItemResponse onlyReplicaKeyGetResponse =
      onlyReplicaKeyDdbClient.getItem(onlyReplicaKeyGetRequest);

    // Demonstrate that GetItem succeeded and returned the decrypted item
    assert 200 == onlyReplicaKeyGetResponse.sdkHttpResponse().statusCode();
    final Map<String, AttributeValue> onlyReplicaKeyReturnedItem =
      onlyReplicaKeyGetResponse.item();
    assert onlyReplicaKeyReturnedItem
      .get("sensitive_data")
      .s()
      .equals("encrypt and sign me!");
  }

  public static void main(final String[] args) {
    if (args.length <= 1) {
      throw new IllegalArgumentException(
        "To run this example, include the ddbTable, keyArn, AWS accounts, and regions in args"
      );
    }
    final String ddbTableName = args[0];
    final String keyArn = args[1];

    // We will assume only 1 AWS account and 1 region will be passed into args.
    // To add more of either, change this number, then pass them into args.
    int numberOfAwsAccounts = 1;
    int numberOfRegions = 1;

    List<String> accounts = new ArrayList<>();
    int firstAccountIndex = 2; // 2 because args[0] is ddbTableName and args[1] is mrkArn
    for (
      int i = firstAccountIndex;
      i < firstAccountIndex + numberOfAwsAccounts;
      i++
    ) {
      accounts.add(args[i]);
    }
    List<String> regions = new ArrayList<>();
    int firstRegionIndex = firstAccountIndex + numberOfAwsAccounts;
    for (
      int i = firstRegionIndex;
      i < firstRegionIndex + numberOfRegions;
      i++
    ) {
      regions.add(args[i]);
    }
    ClientSupplierPutItemGetItem(ddbTableName, keyArn, accounts, regions);
  }
}
