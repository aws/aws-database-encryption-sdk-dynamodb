package software.amazon.cryptography.examples.searchableencryption;

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
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconKeySource;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconVersion;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CompoundBeacon;
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
  This example demonstrates how to set up a compound beacon on encrypted attributes,
      put an item with the beacon, and query against that beacon.
  This example follows a use case of a database that associates a customer
      with a particular building ID and floor number. (Maybe this is a database for
      a storage business, and this is where a customer's belongings are stored.)
  We will set up a compound beacon on these attributes so we can query against them.

  Running this example requires access to a DDB table with the
  following primary key configuration:
    - Partition key is named "customer_id" with type (S)
    - Sort key is named "create_time" with type (S)
  This table must have a Global Secondary Index (GSI) configured named "buildingAndFloor-index:
    - Partition key is named "aws_dbe_b_buildingAndFloor" with type (S)

  In this example for storing customer location data, this schema is utilized for the data:
   - "customer_id" stores a unique customer identifier
   - "create_time" stores a Unix timestamp
   - "building" attribute stores a building ID; see below
   - "floor" attribute stores a floor number; see below
   - "aws_dbe_b_buildingAndFloor" stores a beaconized concatenation of building and floor

  The example requires the following ordered input command line parameters:
    1. DDB table name for table to put/query data from
    2. Branch key ID for a branch key that was previously created in your key store. See the
       CreateKeyStoreKeyExample.
    3. Branch key wrapping KMS key ARN for the KMS key used to create the branch key with ID
       provided in arg 2
    4. Branch key DDB table ARN for the DDB table representing the branch key store
 */

public class CompoundBeaconSearchableEncryptionExample {

  static String GSI_NAME = "buildingAndFloor-index";

  public static void PutItemQueryItemWithCompoundBeacon(String ddbTableName, String branchKeyId, String branchKeyWrappingKmsKeyArn, String branchKeyDdbTableName) {

    // 1. Create Standard Beacons.
    //    Any encrypted components of a Compound Beacon are associated
    //    to a Standard Beacon definition.
    List<StandardBeacon> standardBeaconList = new ArrayList<>();

    // The `buildingAndFloor` compound beacon will use the `building` field.
    // This field is assumed to hold a two-digit building ID prefixed with SEA; i.e. SEA00-SEA99.
    // We will assume that `building`s are uniformly distributed across customer IDs.
    // (In practice, this will not be true. If a building is larger, we would expect
    //  it to have more customer IDs associated with it.)
    // With these assumptions, we have a uniformly-distributed dataset of building IDs
    // with 100 unique values.
    //
    // This link provides guidance for choosing a beacon length:
    //    TODO: add link
    // We follow the guidance in the link above to determine reasonable bounds for beacon length:
    //  - min: log(sqrt(100))/log(2) ~= 3.3, round down to 3
    //  - max: log((100/2))/log(2) ~= 5.6, round up to 6
    // You will somehow need to round results to a nearby integer.
    // We choose to round to the nearest integer; you might consider a different rounding approach.
    // Rounding up will return fewer expected "false positives" in queries, leading to fewer decrypt calls and
    //    better performance, but it is easier to distinguish unique plaintext values in encrypted data.
    // Rounding down will return more expected "false positives" in queries, leading to more decrypt calls and
    //    worse performance, but it is harder to distinguish unique plaintext values in encrypted data.
    // We can choose a beacon length between 3 and 6:
    //  - Closer to 8, we expect more "false positives" to be returned,
    //    making it harder to distinguish plaintext values
    //    but leading to more decrypt calls and worse performance
    //  - Closer to 14, we expect fewer "false positives" returned in queries,
    //    leading to fewer decrypt calls and better performance,
    //    but it is easier to distinguish unique plaintext values
    // As an example, we will choose 4.
    //
    // Values stored in aws_dbe_b_building will be 4 bits long (0x0 - 0xf).
    // There will be 2^4 = 16 possible HMAC values.
    // With well-distributed building IDs (100 values), for a particular beacon we expect
    //   (100/16) = 6.25 building IDs
    //   sharing that beacon value.
    StandardBeacon buildingBeacon = StandardBeacon.builder()
        .name("building")
        .length(4)
        .build();
    standardBeaconList.add(buildingBeacon);

    // The `buildingAndFloor` compound beacon will also use the `floor` field.
    // This field is assumed to hold an integer from 1 to 50.
    // We will make some assumptions about the distribution of floors:
    //  - All buildings have exactly 50 floors.
    //    In practice, this will not be true. If the tallest building is 50 floors,
    //    but some buildings are shorter than the tallest building,
    //    we expect a left-skewed floor frequency distribution.
    //    Such a dataset would require a stricter upper bound on beacon length
    //    to better hide information from the underlying distribution.
    //  - Floors are uniformly distributed across customer IDs.
    //  - Floors, building IDs, and customer IDs have no correlation.
    // With these assumptions, we have a dataset of floors with 50 possible values
    // uniformly distributed across customer IDs.
    //
    // This link provides guidance for choosing a beacon length:
    //    TODO: add link
    // We follow the guidance in the link above to determine reasonable bounds for beacon length:
    //  - min: log(sqrt(50))/log(2) ~= 2.8, round up to 3
    //  - max: log((50/2))/log(2) ~= 4.6, round up to 5
    // We can choose a beacon length between 3 and 5:
    //  - Closer to 3, we expect more "false positives" to be returned,
    //    making it harder to distinguish plaintext values
    //    but leading to more decrypt calls and worse performance
    //  - Closer to 5, we expect fewer "false positives" returned in queries,
    //    leading to fewer decrypt calls and better performance,
    //    but it is easier to distinguish unique plaintext values
    // As an example, we will choose 4.
    //
    // Values stored in aws_dbe_b_floor will be 4 bits long (0x0 - 0xf).
    // There will be 2^4 = 16 possible HMAC values.
    // With well-distributed floors (50 values), for a particular beacon we expect
    //   (50/16) = 3.125 building IDs
    //   sharing that beacon value.
    StandardBeacon floorBeacon = StandardBeacon.builder()
        .name("floor")
        .length(4)
        .build();
    standardBeaconList.add(floorBeacon);

    // 2. Define encrypted parts.
    //    Encrypted parts define the beacons that can be used to construct a compound beacon,
    //        and how the compound beacon prefixes those beacon values.
    List<EncryptedPart> encryptedPartList = new ArrayList<>();
    // A encrypted part must receive:
    //  - name: Name of a standard beacon
    //  - prefix: Any string. This is plaintext that prefixes the beaconized value in the compound beacon.
    //            Prefixes must be unique across the configuration, and must not be a prefix of another prefix;
    //            i.e. for all configured prefixes, the first N characters of a prefix must not equal another prefix.
    // In practice, it is suggested to have a short value distinguishable from other parts served on the prefix.
    // For this example, we will choose "B-" as the prefix for "Building".
    // With this prefix and the standard beacon's bit length definition (4), a building ID beacon will appear
    //     as `B-0` to `B-f` inside a compound beacon.
    EncryptedPart buildingEncryptedPart = EncryptedPart.builder()
        .name("building")
        .prefix("B-")
        .build();
    encryptedPartList.add(buildingEncryptedPart);
    // For this example, we will choose "F-" as the prefix for "Floor".
    // With this prefix and the standard beacon's bit length definition (4), a floor beacon will appear
    //     as `F-0` to `F-f` inside a compound beacon.
    EncryptedPart floorEncryptedPart = EncryptedPart.builder()
        .name("floor")
        .prefix("F-")
        .build();
    encryptedPartList.add(floorEncryptedPart);

    // 3. Define compound beacon.
    //    A compound beacon allows one to serve multiple beacons or attributes from a single index.
    //    A compound beacon must receive:
    //     - name: The name of the beacon. Compound beacon values will be written to `aws_ddb_b_[name]`.
    //     - split: A character separating parts in a compound beacon
    //    A compound beacon may also receive:
    //     - encrypted: A list of encrypted parts. This is effectively a list of beacons. We provide the list
    //                  that we created above.
    //     - constructors: A list of constructors. This is an ordered list of possible ways to create a beacon.
    //                     We have not defined any constructors here; see the complex example for how to do this.
    //                     The client will provide a default constructor, which will write a compound beacon as:
    //                     all signed parts in the order they are added to the signed list;
    //                     all encrypted parts in order they are added to the encrypted list; all parts required.
    //                     In this example, we expect compound beacons to be written as `B-X.F-Y`, since our
    //                     encrypted list looks like [buildingEncryptedPart, floorEncryptedPart].
    //     - signed: A list of signed parts, i.e. plaintext attributes. This would be provided if we
    //                     wanted to use plaintext values as part of constructing our compound beacon. We do not
    //                     provide this here; see the Complex example for an example.
    List<CompoundBeacon> compoundBeaconList = new ArrayList<>();
    CompoundBeacon buildingAndFloorCompoundBeacon = CompoundBeacon.builder()
        .name("buildingAndFloor")
        .split(".")
        .encrypted(encryptedPartList)
        .build();
    compoundBeaconList.add(buildingAndFloorCompoundBeacon);

    // 4. Configure the Keystore
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

    // 5. Create BeaconVersion.
    //    This is similar to the Basic example, except we have also provided a compoundBeaconList.
    //    We must also continue to provide all the standard beacons that compose a compound beacon list.
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

    // 6. Create a Hierarchical Keyring
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

    // 7. Configure which attributes are encrypted and/or signed when writing new items.
    final Map<String, CryptoAction> attributeActions = new HashMap<>();
    attributeActions.put("customer_id", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActions.put("create_time", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActions.put("building", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("floor", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted

    // We do not need to define a crypto action on buildingAndFloor.
    // We only need to define crypto actions on attributes that we pass to PutItem.

    // 8. Create the DynamoDb Encryption configuration for the table we will be writing to.
    //    The beaconVersions are added to the search configuration.
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig.builder()
        .logicalTableName(ddbTableName)
        .partitionKeyName("customer_id")
        .attributeActions(attributeActions)
        .keyring(kmsKeyring)
        .search(SearchConfig.builder()
            .writeVersion(1) // MUST be 1
            .versions(beaconVersions)
            .build())
        .build();
    tableConfigs.put(ddbTableName, config);

    // 9. Create the DynamoDb Encryption Interceptor
    DynamoDbEncryptionInterceptor encryptionInterceptor = DynamoDbEncryptionInterceptor.builder()
        .config(DynamoDbTablesEncryptionConfig.builder()
            .tableEncryptionConfigs(tableConfigs)
            .build())
        .build();

    // 10. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient.builder()
        .overrideConfiguration(
            ClientOverrideConfiguration.builder()
                .addExecutionInterceptor(encryptionInterceptor)
                .build())
        .build();

    // 11. Put an item with both a building ID and a floor into the table.
    final HashMap<String, AttributeValue> item = new HashMap<>();
    item.put("customer_id", AttributeValue.builder().s("EFGH-5678").build());
    item.put("create_time", AttributeValue.builder().n("1681495205").build());
    item.put("building", AttributeValue.builder().s("SEA95").build());
    item.put("floor", AttributeValue.builder().n("42").build());

    final PutItemRequest putRequest = PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(item)
        .build();

    final PutItemResponse putResponse = ddb.putItem(putRequest);
    // Validate object put successfully
    assert 200 == putResponse.sdkHttpResponse().statusCode();

    // 12. Query for the item with both building ID and floor
    Map<String ,String> expressionAttributesNames = new HashMap<>();
    expressionAttributesNames.put("#bAndF", "buildingAndFloor");

    Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
    // This query expression takes a few factors into consideration:
    //  - The configured building ID abbreviation prefix is "B-"; floor abbreviation prefix is "F-"
    //  - The configured split character, separating component parts, is "."
    //  - The default constructor adds encrypted parts in the order they are in the encrypted list, which
    //    configures the building ID to come before the floor
    // NOTE: We did not need to create a compound beacon for this query. This query could have also been
    //       done by querying on the partition and sort key, as was done in the Basic example.
    //       This is intended to be a simple example to demonstrate how one might set up a compound beacon.
    //       For examples where compound beacons are required, see the Complex example.
    //       The most basic extension to this example that would require a compound beacon would add a third
    //       part to the compound beacon, then query against three parts.
    expressionAttributeValues.put(":bAndF", AttributeValue.builder().s("B-SEA95.F-42").build());

    QueryRequest queryRequest = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName(GSI_NAME)
        .keyConditionExpression("#bAndF = :bAndF")
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
    assert returnedItem.get("building").s().equals("SEA95");
    assert returnedItem.get("floor").n().equals("42");
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
    PutItemQueryItemWithCompoundBeacon(ddbTableName, branchKeyId, branchKeyWrappingKmsKeyId, branchKeyDdbTableName);
  }
}
