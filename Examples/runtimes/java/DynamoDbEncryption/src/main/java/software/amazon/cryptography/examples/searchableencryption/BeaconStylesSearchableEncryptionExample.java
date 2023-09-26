package software.amazon.cryptography.examples.searchableencryption;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
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
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconKeySource;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconVersion;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CompoundBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconStyle;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.TwinnedSet;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Twinned;

import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Constructor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.ConstructorPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SearchConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.EncryptedPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SingleKeyStore;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.StandardBeacon;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.keystore.model.CreateKeyOutput;
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;

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

  The example requires the following ordered input command line parameters:
    1. DDB table name for table to put/query data from
    2. Branch key ID for a branch key that was previously created in your key store. See the
       CreateKeyStoreKeyExample.
    3. Branch key wrapping KMS key ARN for the KMS key used to create the branch key with ID
       provided in arg 2
    4. Branch key DDB table ARN for the DDB table representing the branch key store
 */

public class BeaconStylesSearchableEncryptionExample {

  public static void PutItemQueryItemWithBeaconStyles(String ddbTableName, String branchKeyId, String branchKeyWrappingKmsKeyArn, String branchKeyDdbTableName) {

    // 1. Create Beacons.
    List<StandardBeacon> standardBeaconList = new ArrayList<>();

    // The fruit beacon allows searching on the encrypted fruit attribute
    StandardBeacon fruitBeacon = StandardBeacon.builder()
        .name("fruit")
        .length(30)
        .build();
    standardBeaconList.add(fruitBeacon);

    // The basket beacon allows searching on the encrypted basket attribute
    // basket is used as a Set, and therefore needs a beacon style to reflect that
    // further, we need to be able to compare the items in basket to the fruit attribute
    // so we `twin` this beacon to `fruit`.
    // Since we need both of these things, we use the TwinnedSet style.
    StandardBeacon basketBeacon = StandardBeacon.builder()
        .name("basket")
        .length(30)
        .style(
            BeaconStyle.builder()
                .twinnedSet(TwinnedSet.builder().other("fruit").build())
            .build()
        )
        .build();
    standardBeaconList.add(basketBeacon);

    // The dessert beacon allows searching on the encrypted dessert attribute
    // Wwe need to be able to compare the dessert attribute to the fruit attribute
    // so we `twin` this beacon to `fruit`.
    StandardBeacon dessertBeacon = StandardBeacon.builder()
        .name("dessert")
        .length(30)
        .style(
            BeaconStyle.builder()
                .twinned(Twinned.builder().other("fruit").build())
            .build()
        )
        .build();
    standardBeaconList.add(dessertBeacon);

    // 3. Configure the Keystore
    //    These are the same constructions as in the Basic example, which describes these in more detail.
    KeyStore keyStore = KeyStore.builder()
        .KeyStoreConfig(KeyStoreConfig.builder()
            .kmsClient(KmsClient.create())
            .ddbClient(DynamoDbClient.create())
            .ddbTableName(branchKeyDdbTableName)
            .logicalKeyStoreName(branchKeyDdbTableName)
            .kmsConfiguration(KMSConfiguration.builder().kmsKeyArn(branchKeyWrappingKmsKeyArn).build())
            .build())
        .build();

    // 4. Create BeaconVersion.
    //    This is similar to the Basic example
    List<BeaconVersion> beaconVersions = new ArrayList<>();
    beaconVersions.add(
        BeaconVersion.builder()
            .standardBeacons(standardBeaconList)
            .version(1) // MUST be 1
            .keyStore(keyStore)
            .keySource(BeaconKeySource.builder()
                .single(SingleKeyStore.builder()
                    .keyId(branchKeyId)
                    .cacheTTL(6000)
                    .build())
                .build())
            .build()
    );

    // 5. Create a Hierarchical Keyring
    //    This is the same configuration as in the Basic example.
    final MaterialProviders matProv = MaterialProviders.builder()
        .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
        .build();
    CreateAwsKmsHierarchicalKeyringInput keyringInput = CreateAwsKmsHierarchicalKeyringInput.builder()
        .branchKeyId(branchKeyId)
        .keyStore(keyStore)
        .ttlSeconds(6000l)
        .build();
    final IKeyring kmsKeyring = matProv.CreateAwsKmsHierarchicalKeyring(keyringInput);

    // 6. Configure which attributes are encrypted and/or signed when writing new items.
    final Map<String, CryptoAction> attributeActionsOnEncrypt = new HashMap<>();
    attributeActionsOnEncrypt.put("work_id", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put("inspection_date", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put("dessert", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActionsOnEncrypt.put("fruit", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActionsOnEncrypt.put("basket", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted

    // 7. Create the DynamoDb Encryption configuration for the table we will be writing to.
    //    The beaconVersions are added to the search configuration.
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig.builder()
        .logicalTableName(ddbTableName)
        .partitionKeyName("work_id")
        .sortKeyName("inspection_date")
        .attributeActionsOnEncrypt(attributeActionsOnEncrypt)
        .keyring(kmsKeyring)
        .search(SearchConfig.builder()
            .writeVersion(1) // MUST be 1
            .versions(beaconVersions)
            .build())
        .build();
    tableConfigs.put(ddbTableName, config);

    // 8. Create config
    final DynamoDbTablesEncryptionConfig encryptionConfig =
        DynamoDbTablesEncryptionConfig.builder()
            .tableEncryptionConfigs(tableConfigs)
            .build();

    // 9. Create item one, specifically with "dessert != fruit", and "fruit in basket".
    final HashMap<String, AttributeValue> item1 = new HashMap<>();
    item1.put("work_id", AttributeValue.builder().s("1").build());
    item1.put("inspection_date", AttributeValue.builder().s("2023-06-13").build());
    item1.put("dessert", AttributeValue.builder().s("cake").build());
    item1.put("fruit", AttributeValue.builder().s("banana").build());
    ArrayList<String> basket = new ArrayList<String>();
    basket.add("banana");
    basket.add("apple");
    basket.add("pear");
    item1.put("basket", AttributeValue.builder().ss(basket).build());

    // 10. Create item two, specifically with "dessert == fruit", and "fruit not in basket".
    final HashMap<String, AttributeValue> item2 = new HashMap<>();
    item2.put("work_id", AttributeValue.builder().s("2").build());
    item2.put("inspection_date", AttributeValue.builder().s("2023-06-13").build());
    item2.put("fruit", AttributeValue.builder().s("orange").build());
    item2.put("dessert", AttributeValue.builder().s("orange").build());
    basket = new ArrayList<String>();
    basket.add("strawberry");
    basket.add("blueberry");
    basket.add("blackberry");
    item2.put("basket", AttributeValue.builder().ss(basket).build());

    // 11. Create the DynamoDb Encryption Interceptor
    DynamoDbEncryptionInterceptor encryptionInterceptor = DynamoDbEncryptionInterceptor.builder()
        .config(encryptionConfig)
        .build();

    // 12. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient.builder()
        .overrideConfiguration(
            ClientOverrideConfiguration.builder()
                .addExecutionInterceptor(encryptionInterceptor)
                .build())
        .build();

    // 13. Add the two items
    PutItemRequest putRequest = PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(item1)
        .build();

    PutItemResponse putResponse = ddb.putItem(putRequest);
    // Validate object put successfully
    assert 200 == putResponse.sdkHttpResponse().statusCode();

    putRequest = PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(item2)
        .build();

    putResponse = ddb.putItem(putRequest);
    // Validate object put successfully
    assert 200 == putResponse.sdkHttpResponse().statusCode();


    // 14. Test the first type of Set operation :
    // Select records where the basket attribute holds a particular value
    Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
    expressionAttributeValues.put(":value", AttributeValue.builder().s("banana").build());

    ScanRequest scanRequest = ScanRequest.builder()
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

    // 15. Test the second type of Set operation :
    // Select records where the basket attribute holds the fruit attribute
    scanRequest = ScanRequest.builder()
        .tableName(ddbTableName)
        .filterExpression("contains(basket, fruit)")
        .build();

	scanResponse = ddb.scan(scanRequest);
	// Validate query was returned successfully
	assert 200 == scanResponse.sdkHttpResponse().statusCode();

	// Validate only 1 item was returned: item1
	assert scanResponse.items().size() == 1;
    assert scanResponse.items().get(0).equals(item1);

    // 16. Test the third type of Set operation :
    // Select records where the fruit attribute exists in a particular set
    ArrayList<String> basket3 = new ArrayList<String>();
    basket3.add("boysenberry");
    basket3.add("orange");
    basket3.add("grape");
    expressionAttributeValues.put(":value", AttributeValue.builder().ss(basket3).build());

    scanRequest = ScanRequest.builder()
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

    // Test a Twinned search. Select records where the dessert attribute matches the fruit attribute
    scanRequest = ScanRequest.builder()
        .tableName(ddbTableName)
        .filterExpression("dessert = fruit")
        .build();
    
    scanResponse = ddb.scan(scanRequest);

    // Validate query was returned successfully
	assert 200 == scanResponse.sdkHttpResponse().statusCode();

	// Validate only 1 item was returned: item2
	assert scanResponse.items().size() == 1;
    assert scanResponse.items().get(0).equals(item2);
}

  public static void main(final String[] args) {
    if (args.length <= 1) {
      throw new IllegalArgumentException("To run this example, include ddbTableName as args[0], branchKeyId as args[1], "
              + "branchKeyWrappingKmsKeyId as args[2], and branchKeyDdbTableName as args[3]");
    }
    final String ddbTableName = args[0];
    final String branchKeyId = args[1];
    final String branchKeyWrappingKmsKeyId = args[2];
    final String branchKeyDdbTableName = args[3];
    PutItemQueryItemWithBeaconStyles(ddbTableName, branchKeyId, branchKeyWrappingKmsKeyId, branchKeyDdbTableName);
  }
}
