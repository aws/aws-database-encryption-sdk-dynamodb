package software.amazon.cryptography.examples.searchableencryption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconKeySource;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconVersion;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SearchConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SingleKeyStore;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.StandardBeacon;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.keystore.model.AwsKms;
import software.amazon.cryptography.keystore.model.DynamoDBTable;
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyManagement;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;
import software.amazon.cryptography.keystore.model.Storage;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsCache;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CacheType;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateCryptographicMaterialsCacheInput;
import software.amazon.cryptography.materialproviders.model.DefaultCache;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

public class SearchableEncryptionDefaultStorage {

  static String GSI_NAME = "last4-unit-index";
  static DynamoDbClient _ddbClient = DynamoDbClient.create();
  static KmsClient _kmsClient = KmsClient.create();

  public static void PutItemQueryItemWithBeaconDefaultStorage(
    String ddbTableName,
    String branchKeyId,
    String branchKeyWrappingKmsKeyArn,
    String branchKeyDdbTableName
  ) {
    List<StandardBeacon> standardBeaconList = new ArrayList<>();
    List<BeaconVersion> beaconVersions = new ArrayList<>();
    createStandardBeacons(standardBeaconList);

    DynamoDBTable table = DynamoDBTable
      .builder()
      .ddbClient(_ddbClient)
      .ddbTableName(branchKeyDdbTableName)
      .build();
    KMSConfiguration kmsConfiguration = KMSConfiguration
      .builder()
      .kmsKeyArn(branchKeyWrappingKmsKeyArn)
      .build();
    KeyStore keyStore = createKeyStore(
      table,
      kmsConfiguration,
      branchKeyDdbTableName
    );

    final MaterialProviders mpl = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();

    CreateAwsKmsHierarchicalKeyringInput input1 = createKeyringInputSharedCache(
      branchKeyId,
      keyStore,
      mpl
    );
    CreateAwsKmsHierarchicalKeyringInput input2 = createKeyringInputSharedCache(
      branchKeyId,
      keyStore,
      mpl
    );

    final IKeyring hkeyring1 = mpl.CreateAwsKmsHierarchicalKeyring(input1);
    final IKeyring hkeyring2 = mpl.CreateAwsKmsHierarchicalKeyring(input2);

    beaconVersions.add(
      BeaconVersion
        .builder()
        .standardBeacons(standardBeaconList)
        .version(1) // MUST be 1
        .keyStore(keyStore)
        .keySource(
          BeaconKeySource
            .builder()
            .single(
              SingleKeyStore.builder().keyId(branchKeyId).cacheTTL(6000).build()
            )
            .build()
        )
        .build()
    );

    final Map<String, CryptoAction> attributeActionsOnEncrypt = new HashMap<>();
    attributeActionsOnEncrypt.put("work_id", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put("inspection_date", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put(
      "inspector_id_last4",
      CryptoAction.ENCRYPT_AND_SIGN
    ); // Beaconized attributes must be encrypted
    attributeActionsOnEncrypt.put("unit", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted

    // 6. Create the DynamoDb Encryption configuration for the table we will be writing to.
    //    The beaconVersions are added to the search configuration.
    final DynamoDbTableEncryptionConfig config1 = getConfig(
      ddbTableName,
      attributeActionsOnEncrypt,
      hkeyring1,
      beaconVersions
    );
    final DynamoDbTableEncryptionConfig config2 = getConfig(
      ddbTableName,
      attributeActionsOnEncrypt,
      hkeyring2,
      beaconVersions
    );

    // 7. Create the DynamoDb Encryption Interceptor
    DynamoDbEncryptionInterceptor encryptionInterceptor1 = createInterceptor(
      ddbTableName,
      config1
    );
    DynamoDbEncryptionInterceptor encryptionInterceptor2 = createInterceptor(
      ddbTableName,
      config2
    );

    // 8. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb1 = getDdbClient(encryptionInterceptor1);
    final DynamoDbClient ddb2 = getDdbClient(encryptionInterceptor2);

    // 9. Put an item into our table using the above client.
    //    Before the item gets sent to DynamoDb, it will be encrypted
    //        client-side, according to our configuration.
    //    Since our configuration includes beacons for `inspector_id_last4` and `unit`,
    //        the client will add two additional attributes to the item. These attributes will have names
    //        `aws_dbe_b_inspector_id_last4` and `aws_dbe_b_unit`. Their values will be HMACs
    //        truncated to as many bits as the beacon's `length` parameter; e.g.
    //    aws_dbe_b_inspector_id_last4 = truncate(HMAC("4321"), 10)
    //    aws_dbe_b_unit = truncate(HMAC("123456789012"), 30)
    final HashMap<String, AttributeValue> item = new HashMap<>();
    item.put(
      "work_id",
      AttributeValue.builder().s("1313ba89-5661-41eb-ba6c-cb1b4cb67b2d").build()
    );
    item.put(
      "inspection_date",
      AttributeValue.builder().s("2023-06-13").build()
    );
    item.put("inspector_id_last4", AttributeValue.builder().s("4321").build());
    item.put("unit", AttributeValue.builder().s("123456789012").build());

    final PutItemRequest putRequest = PutItemRequest
      .builder()
      .tableName(ddbTableName)
      .item(item)
      .build();

    final PutItemResponse putResponse = ddb1.putItem(putRequest);
    assert 200 == putResponse.sdkHttpResponse().statusCode();

    // 10. Query for the item we just put.
    //     Note that we are constructing the query as if we were querying on plaintext values.
    //     However, the DDB encryption client will detect that this attribute name has a beacon configured.
    //     The client will add the beaconized attribute name and attribute value to the query,
    //         and transform the query to use the beaconized name and value.
    //     Internally, the client will query for and receive all items with a matching HMAC value in the beacon field.
    //     This may include a number of "false positives" with different ciphertext, but the same truncated HMAC.
    //     e.g. if truncate(HMAC("123456789012"), 30)
    //          == truncate(HMAC("098765432109"), 30),
    //     the query will return both items.
    //     The client will decrypt all returned items to determine which ones have the expected attribute values,
    //         and only surface items with the correct plaintext to the user.
    //     This procedure is internal to the client and is abstracted away from the user;
    //     e.g. the user will only see "123456789012" and never
    //        "098765432109", though the actual query returned both.
    Map<String, String> expressionAttributesNames = new HashMap<>();
    expressionAttributesNames.put("#last4", "inspector_id_last4");
    expressionAttributesNames.put("#unit", "unit");

    Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
    expressionAttributeValues.put(
      ":last4",
      AttributeValue.builder().s("4321").build()
    );
    expressionAttributeValues.put(
      ":unit",
      AttributeValue.builder().s("123456789012").build()
    );

    QueryRequest queryRequest = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName(GSI_NAME)
      .keyConditionExpression("#last4 = :last4 and #unit = :unit")
      .expressionAttributeNames(expressionAttributesNames)
      .expressionAttributeValues(expressionAttributeValues)
      .build();

    // GSIs do not update instantly
    // so if the results come back empty
    // we retry after a short sleep
    for (int i = 0; i < 10; ++i) {
      final QueryResponse queryResponse = ddb1.query(queryRequest);
      List<Map<String, AttributeValue>> attributeValues = queryResponse.items();
      // Validate query was returned successfully
      assert 200 == queryResponse.sdkHttpResponse().statusCode();

      // if no results, sleep and try again
      if (attributeValues.size() == 0) {
        try {
          Thread.sleep(20);
        } catch (Exception e) {}
        continue;
      }

      // Validate only 1 item was returned: the item we just put
      assert attributeValues.size() == 1;
      final Map<String, AttributeValue> returnedItem = attributeValues.get(0);
      // Validate the item has the expected attributes
      assert returnedItem.get("inspector_id_last4").s().equals("4321");
      assert returnedItem.get("unit").s().equals("123456789012");
      break;
    }

    for (int i = 0; i < 10; ++i) {
      final QueryResponse queryResponse = ddb2.query(queryRequest);
      List<Map<String, AttributeValue>> attributeValues = queryResponse.items();
      // Validate query was returned successfully
      assert 200 == queryResponse.sdkHttpResponse().statusCode();

      // if no results, sleep and try again
      if (attributeValues.size() == 0) {
        try {
          Thread.sleep(20);
        } catch (Exception e) {}
        continue;
      }

      // Validate only 1 item was returned: the item we just put
      assert attributeValues.size() == 1;
      final Map<String, AttributeValue> returnedItem = attributeValues.get(0);
      // Validate the item has the expected attributes
      assert returnedItem.get("inspector_id_last4").s().equals("4321");
      assert returnedItem.get("unit").s().equals("123456789012");
      break;
    }
  }

  public static DynamoDbClient getDdbClient(
    DynamoDbEncryptionInterceptor encryptionInterceptor1
  ) {
    return DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(encryptionInterceptor1)
          .build()
      )
      .build();
  }

  public static DynamoDbEncryptionInterceptor createInterceptor(
    String ddbTableName,
    DynamoDbTableEncryptionConfig encryptionConfig
  ) {
    final Map<String, DynamoDbTableEncryptionConfig> encryptionConfigs =
      new HashMap<>();
    encryptionConfigs.put(ddbTableName, encryptionConfig);
    return DynamoDbEncryptionInterceptor
      .builder()
      .config(
        DynamoDbTablesEncryptionConfig
          .builder()
          .tableEncryptionConfigs(encryptionConfigs)
          .build()
      )
      .build();
  }

  public static DynamoDbTableEncryptionConfig getConfig(
    String ddbTableName,
    Map<String, CryptoAction> attributeActionsOnEncrypt,
    IKeyring hkeyring1,
    List<BeaconVersion> beaconVersions
  ) {
    return DynamoDbTableEncryptionConfig
      .builder()
      .logicalTableName(ddbTableName)
      .partitionKeyName("work_id")
      .sortKeyName("inspection_date")
      .attributeActionsOnEncrypt(attributeActionsOnEncrypt)
      .keyring(hkeyring1)
      .search(
        SearchConfig
          .builder()
          .writeVersion(1) // MUST be 1
          .versions(beaconVersions)
          .build()
      )
      .build();
  }

  private static KeyStore createKeyStore(
    DynamoDBTable table,
    KMSConfiguration kmsConfiguration,
    String ddbTableName
  ) {
    AwsKms awsKms = AwsKms.builder().kmsClient(_kmsClient).build();
    Storage defualtStorage = Storage.builder().ddb(table).build();
    return KeyStore
      .builder()
      .KeyStoreConfig(
        KeyStoreConfig
          .builder()
          .storage(defualtStorage)
          .logicalKeyStoreName(ddbTableName)
          .kmsConfiguration(kmsConfiguration)
          .keyManagement(KeyManagement.builder().kms(awsKms).build())
          .build()
      )
      .build();
  }

  public static CreateAwsKmsHierarchicalKeyringInput createKeyringInputSharedCache(
    String branchKeyId,
    KeyStore keyStore,
    MaterialProviders mpl
  ) {
    final CacheType cache = CacheType
      .builder()
      .Default(DefaultCache.builder().entryCapacity(100).build())
      .build();

    final CreateCryptographicMaterialsCacheInput cryptographicMaterialsCacheInput =
      CreateCryptographicMaterialsCacheInput.builder().cache(cache).build();

    final ICryptographicMaterialsCache sharedCryptographicMaterialsCache =
      mpl.CreateCryptographicMaterialsCache(cryptographicMaterialsCacheInput);

    // 2. Create a CacheType object for the sharedCryptographicMaterialsCache
    //    Note that the `cache` parameter in the Hierarchical Keyring Input takes a `CacheType` as input
    final CacheType sharedCache = CacheType
      .builder()
      // This is the `Shared` CacheType that passes an already initialized shared cache
      .Shared(sharedCryptographicMaterialsCache)
      .build();

    return CreateAwsKmsHierarchicalKeyringInput
      .builder()
      .branchKeyId(branchKeyId)
      .keyStore(keyStore)
      .cache(sharedCache)
      .ttlSeconds(6000l)
      .build();
  }

  public static void createStandardBeacons(
    List<StandardBeacon> standardBeaconList
  ) {
    StandardBeacon last4Beacon = StandardBeacon
      .builder()
      .name("inspector_id_last4")
      .length(10)
      .build();
    standardBeaconList.add(last4Beacon);

    StandardBeacon unitBeacon = StandardBeacon
      .builder()
      .name("unit")
      .length(30)
      .build();
    standardBeaconList.add(unitBeacon);
  }

  public static void main(final String[] args) {
    if (args.length <= 1) {
      throw new IllegalArgumentException(
        "To run this example, include ddbTableName as args[0], " +
        "branchKeyId as args[1], branchKeyWrappingKmsKeyId as args[2], and branchKeyDdbTableName as args[3]"
      );
    }
    final String ddbTableName = args[0];
    final String branchKeyId = args[1];
    final String branchKeyWrappingKmsKeyArn = args[2];
    final String branchKeyDdbTableName = args[3];
    PutItemQueryItemWithBeaconDefaultStorage(
      ddbTableName,
      branchKeyId,
      branchKeyWrappingKmsKeyArn,
      branchKeyDdbTableName
    );
  }
}
