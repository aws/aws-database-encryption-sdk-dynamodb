package software.aws.cryptography.examples.searchableencryption;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dynamoDbEncryption.model.BeaconKeySource;
import software.amazon.cryptography.dynamoDbEncryption.model.BeaconVersion;
import software.amazon.cryptography.dynamoDbEncryption.model.CompoundBeacon;
import software.amazon.cryptography.dynamoDbEncryption.model.Constructor;
import software.amazon.cryptography.dynamoDbEncryption.model.ConstructorPart;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.SearchConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.SensitivePart;
import software.amazon.cryptography.dynamoDbEncryption.model.SingleKeyStore;
import software.amazon.cryptography.dynamoDbEncryption.model.StandardBeacon;
import software.amazon.cryptography.keyStore.KeyStore;
import software.amazon.cryptography.keyStore.model.CreateKeyInput;
import software.amazon.cryptography.keyStore.model.CreateKeyOutput;
import software.amazon.cryptography.keyStore.model.KeyStoreConfig;
import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialProviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;
import software.aws.cryptography.dynamoDbEncryption.DynamoDbEncryptionInterceptor;

/*
  This example demonstrates how to set up a compound beacon on encrypted attributes,
      put an item with the beacon, and query against that beacon.
  This example follows a use case of a database that stores customer location data. This is an
      extension of the "BasicSearchableEncryptionExample" in this directory.

  Running this example requires access to a DDB table with the
  following primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
  This table must have a Global Secondary Index (GSI) configured named "Example-Compound-Beacon-Index":
    - Partition key is named "aws_dbe_b_compound_beacon_attr" with type (S)

  In this example for storing customer location data, this schema is utilized for the data:
   - "partition_key" stores a unique customer identifier
   - "sort_key" stores a Unix timestamp
   - "beacon_str_attr" attribute stores an encrypted 2-letter US state or territory abbreviation
         (https://www.faa.gov/air_traffic/publications/atpubs/cnt_html/appendix_a.html)
   - "beacon_num_attr" attribute stores an encrypted 5-digit US zipcode (00000 - 99999)
   - "aws_dbe_b_compound_beacon_attr" stores a beaconized concatenation of beacon_str_attr and beacon_num_attr

  The example requires the following ordered input command line parameters:
    1. DDB table name for table to put/query data from
    3. Branch key wrapping KMS key ARN for the KMS key used to create the branch key
    4. Branch key DDB table ARN for the DDB table representing the branch key store
 */

public class CompoundBeaconSearchableEncryptionExample {

  static String GSI_NAME = "Example-Compound-Beacon-Index";

  public static void PutItemQueryItemWithCompoundBeacon(String ddbTableName, String branchKeyWrappingKmsKeyArn, String branchKeyDdbTableName) {

    // 1. Create Beacons.
    //    These are the same beacons as in the "BasicSearchableEncryptionExample" in this directory.
    //    See that file to see details on beacon construction and parameters.
    //    While we will not query against these beacons, you must create standard beacons on fields
    //        that you wish to use in compound beacons.
    List<StandardBeacon> standardBeaconList = new ArrayList<>();
    StandardBeacon stringBeacon = StandardBeacon.builder()
        .name("beacon_str_attr")
        .length(4)
        .build();
    standardBeaconList.add(stringBeacon);
    StandardBeacon numberBeacon = StandardBeacon.builder()
        .name("beacon_num_attr")
        .length(10)
        .build();
    standardBeaconList.add(numberBeacon);

    // 2. Define sensitive parts.
    //    Sensitive parts define the beacons that can be used to construct a compound beacon,
    //        and how the compound beacon prefixes those beacon values.
    List<SensitivePart> sensitivePartList = new ArrayList<>();
    // A sensitive part must receive:
    //  - name: Name of a standard beacon
    //  - prefix: Any string. This is plaintext that prefixes the beaconized value in the compound beacon.
    //            Prefixes must be unique across the configuration, and must not be a prefix of another prefix;
    //            i.e. for all configured prefixes, the first N characters of a prefix must not equal another prefix.
    // In practice, it is suggested to have a short value distinguishable from other parts served on the prefix.
    // For this example, we will choose "S-" as the prefix for "State abbreviation".
    // With this prefix and the standard beacon's bit length definition (4), a state abbreviation beacon will appear
    //     as `S-0` to `S-f` inside a compound beacon.
    SensitivePart sensitivePartEmployee = SensitivePart.builder()
        .name("beacon_str_attr")
        .prefix("S-")
        .build();
    sensitivePartList.add(sensitivePartEmployee);
    // For this example, we will choose "Z-" as the prefix for "Zipcode".
    // With this prefix and the standard beacon's bit length definition (10), a zipcode beacon will appear
    //     as `Z-000` to `Z-3ff` inside a compound beacon.
    SensitivePart sensitivePartRoom = SensitivePart.builder()
        .name("beacon_num_attr")
        .prefix("Z-")
        .build();
    sensitivePartList.add(sensitivePartRoom);

    // 3. Create constructor parts.
    //    Constructor parts are used to assemble constructors.
    //    A constructor part must receive:
    //     - name: Name of a standard beacon
    //     - required: Whether this attribute must be present in the item to match a constructor
    //    In this example, we will use each constructor part in more than one constructor, and re-use
    //        the constructor parts across multiple constructors.

    // We will name this constructor `beacon_str_attr` after our standard beacon.
    // As an example, this will be required.
    ConstructorPart constructorPartStr = ConstructorPart.builder()
        .name("beacon_str_attr")
        .required(true)
        .build();
    // We will name this constructor `beacon_num_attr` after our standard beacon.
    // As an example, this will be required.
    ConstructorPart constructorPartNum = ConstructorPart.builder()
        .name("beacon_num_attr")
        .required(true)
        .build();

    // 4. Create constructors.
    //    Constructors define how sensitive and non-sensitive parts are assembled into compound beacons.
    //    We will define 3 constructors:
    //     1. Only zipcode
    //     2. Only state abbreviation
    //     3. Both state and zipcode abbreviation
    List<ConstructorPart> onlyZipcodeConstructorPartList = new ArrayList<>();
    onlyZipcodeConstructorPartList.add(constructorPartNum);
    Constructor onlyZipcodeConstructor = Constructor.builder()
        .parts(onlyZipcodeConstructorPartList)
        .build();

    List<ConstructorPart> onlyStateConstructorPartList = new ArrayList<>();
    onlyStateConstructorPartList.add(constructorPartStr);
    Constructor onlyStateConstructor = Constructor.builder()
        .parts(onlyStateConstructorPartList)
        .build();

    // In a constructor with multiple constructor parts, the order the constructor parts are added to
    //     the constructor part list matters.
    // By adding beacon_str_attr first and beacon_num_attr second, this compound beacon will be
    //     constructed as [beacon_str_attr][split character][beacon_num_attr].
    // We can reverse the placements by swapping the order the constructors were added to the list.
    List<ConstructorPart> bothZipcodeAndStateConstructorPartList = new ArrayList<>();
    bothZipcodeAndStateConstructorPartList.add(constructorPartStr);
    bothZipcodeAndStateConstructorPartList.add(constructorPartNum);
    Constructor bothZipcodeAndStateConstructor = Constructor.builder()
        .parts(bothZipcodeAndStateConstructorPartList)
        .build();

    // 5. Add constructors to the compound beacon constructor list in desired construction order.
    //    In a compound beacon with multiple constructors, the order the constructors are added to
    //        the constructor list matters.
    //    The client will use the first matching constructor in the list to create a beacon.
    //    In our case, this forces us to add the "bothZipcodeAndStateConstructor" first. Since it requires
    //        both zipcode and state, and the other two constructors only require one or the other,
    //        it would never be constructed if it were placed behind one of the other constructors,
    //        as an item with both a zipcode and a state abbreviation attribute would always match the
    //        first matching constructor.
    //    A general strategy is to add constructors with unique conditions at the beginning of the list,
    //       and add constructors with general conditions at the end of the list. This would allow a given
    //       item would trigger the constructor most specific to its attributes.
    List<Constructor> constructorList = new ArrayList<>();
    constructorList.add(bothZipcodeAndStateConstructor);
    constructorList.add(onlyStateConstructor);
    constructorList.add(onlyZipcodeConstructor);

    // 6. Define compound beacon.
    //    A compound beacon allows one to serve multiple beacons or attributes from a single index.
    //    A compound beacon must receive:
    //     - name: The name of the beacon. Compound beacon values will be written to `aws_ddb_e_[name]`.
    //     - split: A character separating parts in a compound beacon
    //     - sensitive: A list of sensitive parts. This is effectively a list of beacons.
    //    A compound beacon may also receive:
    //     - constructors: A list of constructors. This is an ordered list of possible ways to create a beacon.
    //       We have defined our constructor above. If we had not provided this, a default constructor would be
    //           provided: all non-sensitive parts in order, followed by sensitive parts in order, all parts required.
    //     - nonSensitive: A list of non-sensitive parts, i.e. plaintext attributes. This would be provided if we
    //           wanted to use plaintext values as part of constructing our compound beacon.
    List<CompoundBeacon> compoundBeaconList = new ArrayList<>();
    CompoundBeacon cpbeacon1 = CompoundBeacon.builder()
        .name("compound_beacon_attr")
        .split(".")
        .sensitive(sensitivePartList)
        .constructors(constructorList)
        .build();
    compoundBeaconList.add(cpbeacon1);

    // 7. Create Keystore and branch key.
    //    These are the same constructions as in the Basic example, which describes these in more detail.
    KeyStore keyStore = KeyStore.builder()
        .KeyStoreConfig(KeyStoreConfig.builder()
            .kmsClient(KmsClient.create())
            .ddbClient(DynamoDbClient.create())
            .ddbTableName(branchKeyDdbTableName)
            .kmsKeyArn(branchKeyWrappingKmsKeyArn)
            .build())
        .build();
    CreateKeyOutput output = keyStore.CreateKey(CreateKeyInput.builder().build());
    String branchKeyId = output.branchKeyIdentifier();

    // 8. Create BeaconVersion.
    //    This is similar to the Basic example, except we have also provided a compoundBeaconList.
    //    We must also continue to provide all of the standard beacons that compose a compound beacon list.
    List<BeaconVersion> beaconVersions = new ArrayList<>();
    beaconVersions.add(
        BeaconVersion.builder()
            .standardBeacons(standardBeaconList)
            .compoundBeacons(compoundBeaconList)
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

    // 9. Create a Hierarchical Keyring
    //    This is the same configuration as in the Basic example.
    final MaterialProviders matProv = MaterialProviders.builder()
        .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
        .build();
    CreateAwsKmsHierarchicalKeyringInput keyringInput = CreateAwsKmsHierarchicalKeyringInput.builder()
        .branchKeyId(branchKeyId)
        .keyStore(keyStore)
        .ttlSeconds(6000l)
        .maxCacheSize(100)
        .build();
    final IKeyring kmsKeyring = matProv.CreateAwsKmsHierarchicalKeyring(keyringInput);

    // 10. Configure which attributes are encrypted and/or signed when writing new items.
    //     This is similar to the Basic example, except we have added the "compound_beacon_attr".
    final Map<String, CryptoAction> attributeActions = new HashMap<>();
    attributeActions.put("partition_key", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActions.put("sort_key", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActions.put("beacon_str_attr", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("beacon_num_attr", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("compound_beacon_attr", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted

    // 11. Create the DynamoDb Encryption configuration for the table we will be writing to.
    //     The beaconVersions are added to the search configuration.
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig.builder()
        .partitionKeyName("partition_key")
        .attributeActions(attributeActions)
        .keyring(kmsKeyring)
        .search(SearchConfig.builder()
            .writeVersion(1) // MUST be 1
            .versions(beaconVersions)
            .build())
        .build();
    tableConfigs.put(ddbTableName, config);

    // 12. Create the DynamoDb Encryption Interceptor
    DynamoDbEncryptionInterceptor encryptionInterceptor = DynamoDbEncryptionInterceptor.builder()
        .config(DynamoDbTablesEncryptionConfig.builder()
            .tableEncryptionConfigs(tableConfigs)
            .build())
        .build();

    // 13. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient.builder()
        .overrideConfiguration(
            ClientOverrideConfiguration.builder()
                .addExecutionInterceptor(encryptionInterceptor)
                .build())
        .build();

    // 14. Put an item with only a zipcode into the table.
    //     The client's standard beacon behavior is described in the Basic example.
    //     Adding a compound beacon extends this behavior.
    //     In addition to writing the standard beacon fields, the client will also write to the compound beacon field.
    //     The standard beacon field will not be prefixed, but the compound beacon field will have the prefix
    //         it was configured with.
    //     Putting an item with a configured standard beacon, as well as a compound beacon that uses a standard beacon,
    //         will result in different beaconized values used in the standard and the compound beacon.
    //     e.g. `aws_dbe_b_beacon_num_attr` may have `123`, but `aws_dbe_b_compound_beacon_attr` may have `Z-abc`.
    final HashMap<String, AttributeValue> itemOnlyZip = new HashMap<>();
    itemOnlyZip.put("partition_key", AttributeValue.builder().s("Only-Zip").build());
    itemOnlyZip.put("sort_key", AttributeValue.builder().n("1681495205").build());
    itemOnlyZip.put("beacon_num_attr", AttributeValue.builder().n("98109").build());

    final PutItemRequest putRequestOnlyZip = PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(itemOnlyZip)
        .build();

    final PutItemResponse putResponseOnlyZip = ddb.putItem(putRequestOnlyZip);
    // Validate item put successfully
    assert 200 == putResponseOnlyZip.sdkHttpResponse().statusCode();

    // 15. Query for the item we just put.
    Map<String,String> expressionAttributesNames = new HashMap<>();
    expressionAttributesNames.put("#c", "compound_beacon_attr");

    // To query against a compound beacon, you must write the prefix, then the unencrypted value.
    // The expression below queries against zipcodes of 98109.
    // This is similar to the behavior in the Basic example, which also queries as if the beacon was plaintext,
    //     except we must add the prefix.
    Map<String,AttributeValue> expressionAttributeValues = new HashMap<>();
    expressionAttributeValues.put(":v", AttributeValue.builder().s("Z-98109").build());

    QueryRequest queryRequest = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName(GSI_NAME)
        .keyConditionExpression("#c = :v")
        .expressionAttributeNames(expressionAttributesNames)
        .expressionAttributeValues(expressionAttributeValues)
        .build();

    QueryResponse queryResponse = ddb.query(queryRequest);
    List<Map<String, AttributeValue>> attributeValues = queryResponse.items();
    // Validate query was returned successfully
    assert 200 == queryResponse.sdkHttpResponse().statusCode();
    // Validate only 1 item was returned: the item we just put
    assert attributeValues.size() == 1;
    Map<String, AttributeValue> returnedItem = attributeValues.get(0);
    // Validate the item has the expected attributes
    assert returnedItem.get("beacon_num_attr").n().equals("98109");

    // 16. Put an item with both a state abbreviation and a zipcode into the table.
    final HashMap<String, AttributeValue> itemBoth = new HashMap<>();
    itemBoth.put("partition_key", AttributeValue.builder().s("Both-State-And-Zip").build());
    itemBoth.put("sort_key", AttributeValue.builder().n("1681495205").build());
    itemBoth.put("beacon_str_attr", AttributeValue.builder().s("WA").build());
    itemBoth.put("beacon_num_attr", AttributeValue.builder().n("98109").build());

    final PutItemRequest putRequestBoth = PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(itemBoth)
        .build();

    final PutItemResponse putResponseBoth = ddb.putItem(putRequestBoth);
    // Validate object put successfully
    assert 200 == putResponseBoth.sdkHttpResponse().statusCode();

    // 17. Query for the item with both state abbreviation and zipcode.
    expressionAttributesNames = new HashMap<>();
    expressionAttributesNames.put("#c", "compound_beacon_attr");

    expressionAttributeValues = new HashMap<>();
    // This query expression takes a few factors into consideration:
    //  - The configured state abbreviation prefix is "S-"; zipcode abbreviation prefix is "Z-"
    //  - The configured split character, separating component parts, is "."
    //  - The configured constructor configures the state abbreviation to come before the zipcode
    expressionAttributeValues.put(":v", AttributeValue.builder().s("S-WA.Z-98109").build());

    queryRequest = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName(GSI_NAME)
        .keyConditionExpression("#c = :v")
        .expressionAttributeNames(expressionAttributesNames)
        .expressionAttributeValues(expressionAttributeValues)
        .build();

    queryResponse = ddb.query(queryRequest);
    attributeValues = queryResponse.items();
    // Validate query was returned successfully
    assert 200 == queryResponse.sdkHttpResponse().statusCode();
    // Validate only 1 item was returned: the item we just put
    assert attributeValues.size() == 1;
    returnedItem = attributeValues.get(0);
    // Validate the item has the expected attributes
    assert returnedItem.get("beacon_str_attr").s().equals("WA");
    assert returnedItem.get("beacon_num_attr").n().equals("98109");
  }

  public static void main(final String[] args) {
    if (args.length != 4) {
      throw new IllegalArgumentException("To run this example, include ddbTableName as args[0], branchKeyWrappingKmsKeyId as args[2], and branchKeyDdbTableName as args[3]");
    }
    final String ddbTableName = args[0];
    final String branchKeyWrappingKmsKeyId = args[1];
    final String branchKeyDdbTableName = args[2];
    PutItemQueryItemWithCompoundBeacon(ddbTableName, branchKeyWrappingKmsKeyId, branchKeyDdbTableName);
  }
}
