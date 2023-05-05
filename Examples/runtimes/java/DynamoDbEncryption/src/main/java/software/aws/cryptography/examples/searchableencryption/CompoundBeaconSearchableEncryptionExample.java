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
import software.amazon.cryptography.keyStore.model.KMSConfiguration;
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
      extension of the "BasicSearchableEncryptionExample" in this directory. This example uses the same
      situation (storing customer location data) and the same table schema, but adds a compound beacon
      `location` that uses both the `state` and `zip` attributes.

  Running this example requires access to a DDB table with the
  following primary key configuration:
    - Partition key is named "customer_id" with type (S)
    - Sort key is named "create_time" with type (S)
  This table must have a Global Secondary Index (GSI) configured named "location-index:
    - Partition key is named "aws_dbe_b_location" with type (S)

  In this example for storing customer location data, this schema is utilized for the data:
   - "customer_id" stores a unique customer identifier
   - "create_time" stores a Unix timestamp
   - "state" attribute stores an encrypted 2-letter US state or territory abbreviation
         (https://www.faa.gov/air_traffic/publications/atpubs/cnt_html/appendix_a.html)
   - "zip" attribute stores an encrypted 5-digit US zipcode (00000 - 99999)
   - "aws_dbe_b_location" stores a beaconized concatenation of state and zip

  The example requires the following ordered input command line parameters:
    1. DDB table name for table to put/query data from
    2. Branch key wrapping KMS key ARN for the KMS key used to create the branch key
    3. Branch key DDB table ARN for the DDB table representing the branch key store
 */

public class CompoundBeaconSearchableEncryptionExample {

  static String GSI_NAME = "location-index";

  public static void PutItemQueryItemWithCompoundBeacon(String ddbTableName, String branchKeyWrappingKmsKeyArn, String branchKeyDdbTableName) {

    // 1. Create Beacons.
    //    These are the same beacons as in the "BasicSearchableEncryptionExample" in this directory.
    //    See that file to see details on beacon construction and parameters.
    //    While we will not query against these beacons, you must create standard beacons on fields
    //        that we wish to use in compound beacons.
    List<StandardBeacon> standardBeaconList = new ArrayList<>();
    StandardBeacon stringBeacon = StandardBeacon.builder()
        .name("state")
        .length(4)
        .build();
    standardBeaconList.add(stringBeacon);
    StandardBeacon numberBeacon = StandardBeacon.builder()
        .name("zip")
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
    SensitivePart sensitivePartStr = SensitivePart.builder()
        .name("state")
        .prefix("S-")
        .build();
    sensitivePartList.add(sensitivePartStr);
    // For this example, we will choose "Z-" as the prefix for "Zipcode".
    // With this prefix and the standard beacon's bit length definition (10), a zipcode beacon will appear
    //     as `Z-000` to `Z-3ff` inside a compound beacon.
    SensitivePart sensitivePartNum = SensitivePart.builder()
        .name("zip")
        .prefix("Z-")
        .build();
    sensitivePartList.add(sensitivePartNum);


    // 3. Define compound beacon.
    //    A compound beacon allows one to serve multiple beacons or attributes from a single index.
    //    A compound beacon must receive:
    //     - name: The name of the beacon. Compound beacon values will be written to `aws_ddb_e_[name]`.
    //     - split: A character separating parts in a compound beacon
    //    A compound beacon may also receive:
    //     - sensitive: A list of sensitive parts. This is effectively a list of beacons. We provide the list
    //                  that we created above.
    //     - constructors: A list of constructors. This is an ordered list of possible ways to create a beacon.
    //                     We have not defined any constructors here; see the complex example for how to do this.
    //                     The client will provide a default constructor, which will write a compound beacon as:
    //                     all non-sensitive parts in the order they are added to the nonSensitive list;
    //                     all sensitive parts in order they are added to the sensitive list; all parts required.
    //                     In this example, we expect compound beacons to be written as `S-X.Z-YYY`, since our
    //                     sensitive list looks like [sensitivePartStr, sensitivePartNum].
    //     - nonSensitive: A list of non-sensitive parts, i.e. plaintext attributes. This would be provided if we
    //                     wanted to use plaintext values as part of constructing our compound beacon. We do not
    //                     provide this here; see the Complex example for an example.
    List<CompoundBeacon> compoundBeaconList = new ArrayList<>();
    CompoundBeacon cpbeacon1 = CompoundBeacon.builder()
        .name("location")
        .split(".")
        .sensitive(sensitivePartList)
        .build();
    compoundBeaconList.add(cpbeacon1);

    // 4. Create Keystore and branch key.
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
    CreateKeyOutput output = keyStore.CreateKey();
    String branchKeyId = output.branchKeyIdentifier();

    // 5. Create BeaconVersion.
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
    attributeActions.put("state", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("zip", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted

    // We do not need to define a crypto action on location.
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

    // 11. Put an item with both a state abbreviation and a zipcode into the table.
    final HashMap<String, AttributeValue> item = new HashMap<>();
    item.put("customer_id", AttributeValue.builder().s("Both-State-And-Zip").build());
    item.put("create_time", AttributeValue.builder().n("1681495205").build());
    item.put("state", AttributeValue.builder().s("WA").build());
    item.put("zip", AttributeValue.builder().n("98109").build());

    final PutItemRequest putRequestBoth = PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(item)
        .build();

    final PutItemResponse putResponse = ddb.putItem(putRequestBoth);
    // Validate object put successfully
    assert 200 == putResponse.sdkHttpResponse().statusCode();

    // 12. Query for the item with both state abbreviation and zipcode.
    Map<String ,String> expressionAttributesNames = new HashMap<>();
    expressionAttributesNames.put("#c", "location");

    Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
    // This query expression takes a few factors into consideration:
    //  - The configured state abbreviation prefix is "S-"; zipcode abbreviation prefix is "Z-"
    //  - The configured split character, separating component parts, is "."
    //  - The default constructor adds sensitive parts in the order they are in the sensitive list, which
    //    configures the state abbreviation to come before the zipcode
    // NOTE: We did not need to create a compound beacon for this query. This query could have also been
    //       done by querying on the partition and sort key, as was done in the Basic example.
    //       This is intended to be a simple example to demonstrate how one might set up a compound beacon.
    //       For examples where compound beacons are required, see the Complex example.
    //       The most basic extension to this example that would require a compound beacon would add a third
    //       part to the compound beacon, then query against three parts.
    expressionAttributeValues.put(":v", AttributeValue.builder().s("S-WA.Z-98109").build());

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
    assert returnedItem.get("state").s().equals("WA");
    assert returnedItem.get("zip").n().equals("98109");
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
