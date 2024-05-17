package software.amazon.cryptography.examples.searchableencryption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.text.html.Option;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.AsSet;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconKeySource;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconStyle;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconVersion;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CompoundBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Constructor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.ConstructorPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.EncryptedPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PartOnly;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SearchConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Shared;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SharedSet;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SignedPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SingleKeyStore;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.StandardBeacon;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.keystore.model.CreateKeyOutput;
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

/*
  This example demonstrates how to use Beacons Styles on Standard Beacons on encrypted attributes,
      put an item with the beacon, and query against that beacon.
  This example follows a use case of a database that stores food information.
      This is an extension of the "BasicSearchableEncryptionExample" in this directory
      and uses the same table schema.

  Running this example requires access to a DDB table with the
  following key configuration:
    - Partition key is named "work_id" with type (S)
    - Sort key is named "inspection_time" with type (S)

  In this example for storing food information, this schema is utilized for the data:
   - "work_id" stores a unique identifier for a unit inspection work order (v4 UUID)
   - "inspection_date" stores an ISO 8601 date for the inspection (YYYY-MM-DD)
   - "fruit" stores one type of fruit
   - "basket" stores a set of types of fruit
   - "dessert" stores one type of dessert
   - "veggies" stores a set of types of vegetable
   - "work_type" stores a unit inspection category

  The example requires the following ordered input command line parameters:
    1. DDB table name for table to put/query data from
    2. Branch key ID for a branch key that was previously created in your key store. See the
       CreateKeyStoreKeyExample.
    3. Branch key wrapping KMS key ARN for the KMS key used to create the branch key with ID
       provided in arg 2
    4. Branch key DDB table ARN for the DDB table representing the branch key store
 */

public class BeaconStylesSearchableEncryptionExample {

  public static void PutItemQueryItemWithBeaconStyles(
    String ddbTableName,
    String branchKeyId,
    String branchKeyWrappingKmsKeyArn,
    String branchKeyDdbTableName
  ) {
    // 1. Create Beacons.
    List<StandardBeacon> standardBeaconList = new ArrayList<>();

    // The fruit beacon allows searching on the encrypted fruit attribute
    // We have selected 30 as an example beacon length, but you should go to
    // https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
    // when creating your beacons.
    StandardBeacon fruitBeacon = StandardBeacon
      .builder()
      .name("fruit")
      .length(30)
      .build();
    standardBeaconList.add(fruitBeacon);

    // The basket beacon allows searching on the encrypted basket attribute
    // basket is used as a Set, and therefore needs a beacon style to reflect that.
    // Further, we need to be able to compare the items in basket to the fruit attribute
    // so we `share` this beacon with `fruit`.
    // Since we need both of these things, we use the SharedSet style.
    StandardBeacon basketBeacon = StandardBeacon
      .builder()
      .name("basket")
      .length(30)
      .style(
        BeaconStyle
          .builder()
          .sharedSet(SharedSet.builder().other("fruit").build())
          .build()
      )
      .build();
    standardBeaconList.add(basketBeacon);

    // The dessert beacon allows searching on the encrypted dessert attribute
    // We need to be able to compare the dessert attribute to the fruit attribute
    // so we `share` this beacon with `fruit`.
    StandardBeacon dessertBeacon = StandardBeacon
      .builder()
      .name("dessert")
      .length(30)
      .style(
        BeaconStyle
          .builder()
          .shared(Shared.builder().other("fruit").build())
          .build()
      )
      .build();
    standardBeaconList.add(dessertBeacon);

    // The veggieBeacon allows searching on the encrypted veggies attribute
    // veggies is used as a Set, and therefore needs a beacon style to reflect that.
    StandardBeacon veggieBeacon = StandardBeacon
      .builder()
      .name("veggies")
      .length(30)
      .style(BeaconStyle.builder().asSet(AsSet.builder().build()).build())
      .build();
    standardBeaconList.add(veggieBeacon);

    // The work_typeBeacon allows searching on the encrypted work_type attribute
    // We only use it as part of the compound work_unit beacon,
    // so we disable its use as a standalone beacon
    StandardBeacon work_typeBeacon = StandardBeacon
      .builder()
      .name("work_type")
      .length(30)
      .style(BeaconStyle.builder().partOnly(PartOnly.builder().build()).build())
      .build();
    standardBeaconList.add(work_typeBeacon);

    // Here we build a compound beacon from work_id and work_type
    // If we had tried to make a StandardBeacon from work_type, we would have seen an error
    // because work_type is "PartOnly"
    List<EncryptedPart> encryptedPartList = new ArrayList<>();
    EncryptedPart work_typePart = EncryptedPart
      .builder()
      .name("work_type")
      .prefix("T-")
      .build();
    encryptedPartList.add(work_typePart);

    List<SignedPart> signedPartList = new ArrayList<>();
    SignedPart work_idPart = SignedPart
      .builder()
      .name("work_id")
      .prefix("I-")
      .build();
    signedPartList.add(work_idPart);

    List<CompoundBeacon> compoundBeaconList = new ArrayList<>();
    CompoundBeacon work_unitBeacon = CompoundBeacon
      .builder()
      .name("work_unit")
      .split(".")
      .encrypted(encryptedPartList)
      .signed(signedPartList)
      .build();
    compoundBeaconList.add(work_unitBeacon);

    // 2. Configure the Keystore
    //    These are the same constructions as in the Basic example, which describes these in more detail.
    KeyStore keyStore = KeyStore
      .builder()
      .KeyStoreConfig(
        KeyStoreConfig
          .builder()
          .kmsClient(KmsClient.create())
          .ddbClient(DynamoDbClient.create())
          .ddbTableName(branchKeyDdbTableName)
          .logicalKeyStoreName(branchKeyDdbTableName)
          .kmsConfiguration(
            KMSConfiguration
              .builder()
              .kmsKeyArn(branchKeyWrappingKmsKeyArn)
              .build()
          )
          .build()
      )
      .build();

    // 3. Create BeaconVersion.
    //    This is similar to the Basic example
    List<BeaconVersion> beaconVersions = new ArrayList<>();
    beaconVersions.add(
      BeaconVersion
        .builder()
        .standardBeacons(standardBeaconList)
        .compoundBeacons(compoundBeaconList)
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

    // 4. Create a Hierarchical Keyring
    //    This is the same configuration as in the Basic example.
    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    CreateAwsKmsHierarchicalKeyringInput keyringInput =
      CreateAwsKmsHierarchicalKeyringInput
        .builder()
        .branchKeyId(branchKeyId)
        .keyStore(keyStore)
        .ttlSeconds(6000l)
        .build();
    final IKeyring kmsKeyring = matProv.CreateAwsKmsHierarchicalKeyring(
      keyringInput
    );

    // 5. Configure which attributes are encrypted and/or signed when writing new items.
    final Map<String, CryptoAction> attributeActionsOnEncrypt = new HashMap<>();
    attributeActionsOnEncrypt.put("work_id", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put("inspection_date", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put("dessert", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActionsOnEncrypt.put("fruit", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActionsOnEncrypt.put("basket", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActionsOnEncrypt.put("veggies", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActionsOnEncrypt.put("work_type", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted

    // 6. Create the DynamoDb Encryption configuration for the table we will be writing to.
    //    The beaconVersions are added to the search configuration.
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig
      .builder()
      .logicalTableName(ddbTableName)
      .partitionKeyName("work_id")
      .sortKeyName("inspection_date")
      .attributeActionsOnEncrypt(attributeActionsOnEncrypt)
      .keyring(kmsKeyring)
      .search(
        SearchConfig
          .builder()
          .writeVersion(1) // MUST be 1
          .versions(beaconVersions)
          .build()
      )
      .build();
    tableConfigs.put(ddbTableName, config);

    // 7. Create config
    final DynamoDbTablesEncryptionConfig encryptionConfig =
      DynamoDbTablesEncryptionConfig
        .builder()
        .tableEncryptionConfigs(tableConfigs)
        .build();

    // 8. Create item one, specifically with "dessert != fruit", and "fruit in basket".
    final HashMap<String, AttributeValue> item1 = new HashMap<>();
    item1.put("work_id", AttributeValue.builder().s("1").build());
    item1.put(
      "inspection_date",
      AttributeValue.builder().s("2023-06-13").build()
    );
    item1.put("dessert", AttributeValue.builder().s("cake").build());
    item1.put("fruit", AttributeValue.builder().s("banana").build());
    ArrayList<String> basket = new ArrayList<String>();
    basket.add("apple");
    basket.add("banana");
    basket.add("pear");
    item1.put("basket", AttributeValue.builder().ss(basket).build());
    ArrayList<String> veggies = new ArrayList<String>();
    veggies.add("beans");
    veggies.add("carrots");
    veggies.add("celery");
    item1.put("veggies", AttributeValue.builder().ss(veggies).build());
    item1.put("work_type", AttributeValue.builder().s("small").build());

    // 9. Create item two, specifically with "dessert == fruit", and "fruit not in basket".
    final HashMap<String, AttributeValue> item2 = new HashMap<>();
    item2.put("work_id", AttributeValue.builder().s("2").build());
    item2.put(
      "inspection_date",
      AttributeValue.builder().s("2023-06-13").build()
    );
    item2.put("fruit", AttributeValue.builder().s("orange").build());
    item2.put("dessert", AttributeValue.builder().s("orange").build());
    basket = new ArrayList<String>();
    basket.add("blackberry");
    basket.add("blueberry");
    basket.add("strawberry");
    item2.put("basket", AttributeValue.builder().ss(basket).build());
    veggies = new ArrayList<String>();
    veggies.add("beans");
    veggies.add("carrots");
    veggies.add("peas");
    item2.put("veggies", AttributeValue.builder().ss(veggies).build());
    item2.put("work_type", AttributeValue.builder().s("large").build());

    // 10. Create the DynamoDb Encryption Interceptor
    DynamoDbEncryptionInterceptor encryptionInterceptor =
      DynamoDbEncryptionInterceptor.builder().config(encryptionConfig).build();

    // 11. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(encryptionInterceptor)
          .build()
      )
      .build();

    // 12. Add the two items
    PutItemRequest putRequest = PutItemRequest
      .builder()
      .tableName(ddbTableName)
      .item(item1)
      .build();

    PutItemResponse putResponse = ddb.putItem(putRequest);
    // Validate object put successfully
    assert 200 == putResponse.sdkHttpResponse().statusCode();

    putRequest =
      PutItemRequest.builder().tableName(ddbTableName).item(item2).build();

    putResponse = ddb.putItem(putRequest);
    // Validate object put successfully
    assert 200 == putResponse.sdkHttpResponse().statusCode();

    // 13. Test the first type of Set operation :
    // Select records where the basket attribute holds a particular value
    Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
    expressionAttributeValues.put(
      ":value",
      AttributeValue.builder().s("banana").build()
    );

    ScanRequest scanRequest = ScanRequest
      .builder()
      .tableName(ddbTableName)
      .filterExpression("contains(basket, :value)")
      .expressionAttributeValues(expressionAttributeValues)
      .build();

    ScanResponse scanResponse = ddb.scan(scanRequest);
    // Validate query was returned successfully
    assert 200 == scanResponse.sdkHttpResponse().statusCode();

    // Validate only 1 item was returned: item1
    assert scanResponse.items().size() == 1;
    assert scanResponse.items().get(0).equals(item1);

    // 14. Test the second type of Set operation :
    // Select records where the basket attribute holds the fruit attribute
    scanRequest =
      ScanRequest
        .builder()
        .tableName(ddbTableName)
        .filterExpression("contains(basket, fruit)")
        .build();

    scanResponse = ddb.scan(scanRequest);
    // Validate query was returned successfully
    assert 200 == scanResponse.sdkHttpResponse().statusCode();

    // Validate only 1 item was returned: item1
    assert scanResponse.items().size() == 1;
    assert scanResponse.items().get(0).equals(item1);

    // 15. Test the third type of Set operation :
    // Select records where the fruit attribute exists in a particular set
    ArrayList<String> basket3 = new ArrayList<String>();
    basket3.add("boysenberry");
    basket3.add("grape");
    basket3.add("orange");
    expressionAttributeValues.put(
      ":value",
      AttributeValue.builder().ss(basket3).build()
    );

    scanRequest =
      ScanRequest
        .builder()
        .tableName(ddbTableName)
        .filterExpression("contains(:value, fruit)")
        .expressionAttributeValues(expressionAttributeValues)
        .build();

    scanResponse = ddb.scan(scanRequest);

    // Validate query was returned successfully
    assert 200 == scanResponse.sdkHttpResponse().statusCode();

    // Validate only 1 item was returned: item2
    assert scanResponse.items().size() == 1;
    assert scanResponse.items().get(0).equals(item2);

    // Test a Shared search. Select records where the dessert attribute matches the fruit attribute
    scanRequest =
      ScanRequest
        .builder()
        .tableName(ddbTableName)
        .filterExpression("dessert = fruit")
        .build();

    scanResponse = ddb.scan(scanRequest);

    // Validate query was returned successfully
    assert 200 == scanResponse.sdkHttpResponse().statusCode();

    // Validate only 1 item was returned: item2
    assert scanResponse.items().size() == 1;
    assert scanResponse.items().get(0).equals(item2);

    // 16. Test the AsSet attribute 'veggies' :
    // Select records where the veggies attribute holds a particular value
    expressionAttributeValues.put(
      ":value",
      AttributeValue.builder().s("peas").build()
    );

    scanRequest =
      ScanRequest
        .builder()
        .tableName(ddbTableName)
        .filterExpression("contains(veggies, :value)")
        .expressionAttributeValues(expressionAttributeValues)
        .build();

    scanResponse = ddb.scan(scanRequest);
    // Validate query was returned successfully
    assert 200 == scanResponse.sdkHttpResponse().statusCode();

    // Validate only 1 item was returned: item1
    assert scanResponse.items().size() == 1;
    assert scanResponse.items().get(0).equals(item2);

    // 17. Test the compound beacon 'work_unit' :
    expressionAttributeValues.put(
      ":value",
      AttributeValue.builder().s("I-1.T-small").build()
    );

    scanRequest =
      ScanRequest
        .builder()
        .tableName(ddbTableName)
        .filterExpression("work_unit = :value")
        .expressionAttributeValues(expressionAttributeValues)
        .build();

    scanResponse = ddb.scan(scanRequest);
    // Validate query was returned successfully
    assert 200 == scanResponse.sdkHttpResponse().statusCode();

    // Validate only 1 item was returned: item1
    assert scanResponse.items().size() == 1;
    assert scanResponse.items().get(0).equals(item1);
  }

  public static void main(final String[] args) {
    if (args.length <= 1) {
      throw new IllegalArgumentException(
        "To run this example, include ddbTableName as args[0], branchKeyId as args[1], " +
        "branchKeyWrappingKmsKeyId as args[2], and branchKeyDdbTableName as args[3]"
      );
    }
    final String ddbTableName = args[0];
    final String branchKeyId = args[1];
    final String branchKeyWrappingKmsKeyId = args[2];
    final String branchKeyDdbTableName = args[3];
    PutItemQueryItemWithBeaconStyles(
      ddbTableName,
      branchKeyId,
      branchKeyWrappingKmsKeyId,
      branchKeyDdbTableName
    );
  }
}
