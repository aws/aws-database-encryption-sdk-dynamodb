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
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconKeySource;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconVersion;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CompoundBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Constructor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.ConstructorPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetPrefix;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.NonSensitivePart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SearchConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SensitivePart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SingleKeyStore;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.StandardBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualField;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualTransform;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.keystore.model.CreateKeyOutput;
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.aws.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;

/*
  This example demonstrates how to set up a virtual beacon on one or
  more attributes, put an item with that beacon, and query against that beacon.

  This example follows a use case of a database that stores customer location data. This is an
  extension of the "BasicSearchableEncryptionExample" in this directory. This example uses the same
  situation (storing customer location data) and the same table schema, but adds a virtual field
  `stateAndCustomerData`.

  The motivation behind this example is to demonstrate how and why one would use a virtual beacon.
  In this example, our table stores records with an encrypted `customerData` attribute. We would like
  to be able to query for customers in a given state with a non-empty customerData attribute. In
  practice, this setup might be used to query for customers with data in a particular state to
  comply with different state's data processing laws (e.g. CA's CCPA, IL's BIPA).

  To achieve this, we want the following properties:
   1. Obfuscate whether a record's `customerData` attribute is empty or non-empty
   2. Query against a combination of whether `customerData` is empty/non-empty and the `state` field
  We could not achieve these properties with a standard beacon on an empty/non-empty attribute.

  Following the guidance to choose a beacon length in the BasicSearchableEncryptionExample for
  a boolean value (in our case, whether `customerData` is empty or non-empty), the acceptable
  bounds for beacon length are either 0 or 1. This corresponds to either not storing a beacon
  (length 0), or effectively directly storing an empty/non-empty attribute (length 1). With
  length 0, this beacon is useless for searching (violating property 2); with length 1, this
  beacon does not obfuscate the attribute (violating property 1).

  (A compound beacon also does not help. To (over)simplify, a compound beacon is a
   concatenation of standard beacons, i.e. beacon(`customerData`)+beacon(`state`).
   The `state` beacon is still visible, so we would still have the problems above.)

  To achieve these properties, we instead construct a virtual field and use that in our beacon.
  A virtual field is a transformation of one or more fields that is not stored, but is used to
  construct a beacon that is stored. For our example, we will construct a virtual field as
  `customerData`+`state`. We will create beacon out of this, i.e. beacon(`customerData`+`state`).
  This gives us both desired properties. The reasoning behind this and this construction
  is described in the example below.

  In general, if you wish to use a field with only a handful possible values, it is suggested
  to construct a virtual field to enable effective querying while obfuscating underlying data.

  Running this example requires access to a DDB table  with the
  following primary key configuration:
    - Partition key is named "customer_id" with type (S)
    - Sort key is named "create_time" with type (S)
  This table must have a Global Secondary Index (GSI) configured named "state-zip-index":
    - Partition key is named "aws_dbe_b_state" with type (S)
    - Sort key is named "aws_dbe_b_zip" with type (S)

  In this example for storing customer location data, this schema is utilized for the data:
   - "customer_id" stores a unique customer identifier
   - "create_time" stores a Unix timestamp
   - "state" stores an encrypted 2-letter US state or territory abbreviation
         (https://www.faa.gov/air_traffic/publications/atpubs/cnt_html/appendix_a.html)
   - "zip" stores an encrypted 5-digit US zipcode (00000 - 99999)
   - "customerData" is not part of the schema, but is an attribute utilized in this example.
      It stores a boolean attribute (false/true) indicating whether this customer has data stored.

  The example requires the following ordered input command line parameters:
    1. DDB table name for table to put/query data from
    2. Branch key wrapping KMS key ARN for the KMS key used to create the branch key
    3. Branch key DDB table name for the DDB table representing the branch key store
 */

public class VirtualBeaconSearchableEncryptionExample {

  // In this example, we re-use the index from the BasicSearchableEncryptionExample.
  // We will use a filter expression to implement our query against our beaconized virtual field.
  // This demonstrates that you do not need to create a new GSI for every query,
  // and might be able to re-use existing GSIs if the primary key is similar enough.
  // This is done as an example only; we could have also created a new GSI for this query.
  static String GSI_NAME = "state-zip-index";

  public static void PutItemQueryItemWithBeacon(String ddbTableName, String branchKeyId,
      String branchKeyWrappingKmsKeyArn, String branchKeyDdbTableName) {
    // 1. Construct a length-1 prefix virtual transform.
    //    `customerData` is a binary attribute, containing either `true` or `false`.
    //    As an example to demonstrate virtual transforms, we will truncate the value
    //    of `customerData` in the virtual field to the length-1 prefix of the binary value, i.e.:
    //     - "true" -> "t"
    //     - "false -> "f"
    //    This is not necessary and is done as a demonstration of virtual transforms.
    //    Virtual transform operations treat all attributes as strings,
    //      i.e. the binary `true` is interpreted as a string "true",
    //    so its length-1 prefix is just "t".
    List<VirtualTransform> length1PrefixVirtualTransformList = new ArrayList<>();
    VirtualTransform length1PrefixVirtualTransform = VirtualTransform.builder()
        .prefix(GetPrefix.builder()
            .length(1)
            .build())
        .build();
    length1PrefixVirtualTransformList.add(length1PrefixVirtualTransform);

    // 2. Construct the VirtualParts required for the VirtualField
    VirtualPart customerDataPart = VirtualPart.builder()
        .loc("customerData")
        // Here, we apply the length-1 prefix virtual transform
        .trans(length1PrefixVirtualTransformList)
        .build();
    VirtualPart statePart = VirtualPart.builder()
        .loc("state")
        // Note that we do not apply any transform to the `state` attribute,
        // and the virtual field will read in the attribute as-is.
        .build();

    // 3. Construct the VirtualField from the VirtualParts
    //    Note that the order that virtual parts are added to the virtualPartList
    //    dictates the order in which they are concatenated to build the virtual field.
    //    You must add virtual parts in the same order on write as you do on read.
    List<VirtualPart> virtualPartList = new ArrayList<>();
    virtualPartList.add(customerDataPart);
    virtualPartList.add(statePart);

    VirtualField stateAndCustomerDataField = VirtualField.builder()
        .name("stateAndCustomerData")
        .parts(virtualPartList)
        .build();

    List<VirtualField> virtualFieldList = new ArrayList<>();
    virtualFieldList.add(stateAndCustomerDataField);

    // 4. Configure Beacons.
    //    We will configure standard beacons for `state` and `zip` as done in the Basic example
    //    since we are re-using that GSI. However, we will also create a new standard beacon
    //    for `stateAndCustomerData`.
    List<StandardBeacon> standardBeaconList = new ArrayList<>();

    // Re-use beacon length calculations for `state` and `zip` from Basic example;
    // See the BasicSearchableEncryptionExample for length parameter details
    StandardBeacon stateBeacon = StandardBeacon.builder()
        .name("state")
        .length(4)
        .build();
    standardBeaconList.add(stateBeacon);
    StandardBeacon zipBeacon = StandardBeacon.builder()
        .name("zip")
        .length(10)
        .build();
    standardBeaconList.add(zipBeacon);

    // Since `stateAndCustomerData` is a new beacon, we will go through the exercise of
    //   determining beacon length.
    // This field is assumed to hold a well-distributed US 2-letter state abbreviation
    //   (56 possible values = 50 states + 6 territories) concatenated with a binary attribute
    //   (2 possible values: empty/non-empty customerData field), we expect a population size of
    //   roughly (56 * 2 = 112).
    // The following link provides guidance on choosing a beacon length:
    //    TODO: add link
    // We follow the guidance in the link above to determine acceptable bounds for beacon length:
    //  - min: log(sqrt(112))/log(2) ~= 3.4, round up to 4
    //  - max: log((112/2))/log(2) ~= 5.8, round up to 6
    // We can safely choose a beacon length between 4 and 6:
    //  - Closer to 4, the underlying data is better obfuscated, but more "false positives" are returned in
    //    queries, leading to more decrypt calls and worse performance
    //  - Closer to 6, fewer "false positives" are returned in queries, leading to fewer decrypt calls and
    //    better performance, but it is easier to distinguish unique plaintext values
    // As an example, we will choose 5.
    // Values stored in aws_dbe_b_stateAndCustomerData will be 5 bits long (0x00 - 0x1f)
    // There will be 2^5 = 32 possible HMAC values.
    // With well-distributed plaintext data (112 values), we expect (112/32) = 3.5 combinations of
    //    abbreviation + empty/non-empty attribute sharing the same beacon value.
    // NOTE: This example assumes that the field values are well-distributed. In practice, this will not be true.
    //       Some flaws in this assumption:
    //        - More populous states would be expected to have more records; those beacons will be overused
    //        - States where a business is not operating would expect no customer records for that state; those
    //          beacons will be underused
    //       This is a streamlined example and should not be used as a basis for determining beacon length
    //       in production. Users should analyze their specific dataset to determine acceptable beacon length bounds.
    StandardBeacon stateAndCustomerDataBeacon = StandardBeacon.builder()
        .name("stateAndCustomerData")
        .length(5)
        .build();
    standardBeaconList.add(stateAndCustomerDataBeacon);

    // 5. Configure Keystore.
    //    This example expects that you have already set up a KeyStore with a single branch key.
    //    See the "Create KeyStore Table Example" and "Create KeyStore Key Example" for how to do this.
    //    After you create a branch key, you should persist its ID for use in this example.
    KeyStore keyStore = KeyStore.builder()
        .KeyStoreConfig(KeyStoreConfig.builder()
            .kmsClient(KmsClient.create())
            .ddbClient(DynamoDbClient.create())
            .ddbTableName(branchKeyDdbTableName)
            .logicalKeyStoreName(branchKeyDdbTableName)
            .kmsConfiguration(KMSConfiguration.builder().kmsKeyArn(branchKeyWrappingKmsKeyArn).build())
            .build())
        .build();

    // 6. Create BeaconVersion.
    //    The BeaconVersion inside the list holds the list of beacons on the table.
    //    The BeaconVersion also stores information about the keystore.
    //    BeaconVersion must be provided:
    //      - keyStore: The keystore configured in step 2
    //      - keySource: A configuration for the key source
    List<BeaconVersion> beaconVersions = new ArrayList<>();
    beaconVersions.add(
        BeaconVersion.builder()
            .virtualFields(virtualFieldList)
            .standardBeacons(standardBeaconList)
            .version(1) // MUST be 1
            .keyStore(keyStore)
            .keySource(BeaconKeySource.builder()
                .single(SingleKeyStore.builder()
                    // `keyId` references a beacon key.
                    // For every branch key we create in the keystore,
                    // we also create a beacon key.
                    // This beacon key is not the same as the branch key,
                    // but is created with the same ID as the branch key.
                    .keyId(branchKeyId)
                    .cacheTTL(6000)
                    .build())
                .build())
            .build()
    );

    // 5. Create a Hierarchical Keyring
    //    This is a KMS keyring that utilizes the keystore table.
    //    This config defines how items are encrypted and decrypted.
    //    NOTE: You should configure this to use the same keystore as your search config.
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

    // 6. Configure which attributes are encrypted and/or signed when writing new items.
    //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    //    we must explicitly configure how they should be treated during item encryption:
    //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    //    Any attributes that will be used in beacons must be configured as ENCRYPT_AND_SIGN.
    final Map<String, CryptoAction> attributeActions = new HashMap<>();
    attributeActions.put("customer_id", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActions.put("create_time", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
    attributeActions.put("state", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("zip", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("customerData", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted

    // 7. Create the DynamoDb Encryption configuration for the table we will be writing to.
    //    The beaconVersions are added to the search configuration.
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig.builder()
        .logicalTableName(ddbTableName)
        .partitionKeyName("customer_id")
        .sortKeyName("create_time")
        .attributeActions(attributeActions)
        .keyring(kmsKeyring)
        .search(SearchConfig.builder()
            .writeVersion(1) // MUST be 1
            .versions(beaconVersions)
            .build())
        .build();
    tableConfigs.put(ddbTableName, config);

    // 8. Create the DynamoDb Encryption Interceptor
    DynamoDbEncryptionInterceptor encryptionInterceptor = DynamoDbEncryptionInterceptor.builder()
        .config(DynamoDbTablesEncryptionConfig.builder()
            .tableEncryptionConfigs(tableConfigs)
            .build())
        .build();

    // 9. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient.builder()
        .overrideConfiguration(
            ClientOverrideConfiguration.builder()
                .addExecutionInterceptor(encryptionInterceptor)
                .build())
        .build();

    // 10. Put three items into our table using the above client.
    //     All 3 items will have different zipcodes:
    //      1. 98101: Example zipcode above
    //      2. 98155: Zipcode with same length-3 prefix as example zipcode
    //      3. 95555: Zipcode with same length-1 prefix as example zipcode
    //     We will use this to demonstrate querying against the length-1,
    //     length-3, and length-5 prefixes.
    //     Before the item gets sent to DynamoDb, it will be encrypted
    //         client-side, according to our configuration.
    //     Since our configuration includes a virtual field on `zip`,
    //         the client will add two additional attributes to the item. These attributes will have names
    //         `aws_dbe_b_state` and `aws_dbe_b_zip`. Their values will be HMACs
    //         truncated to as many bits as the beacon's `length` parameter; e.g.
    //     aws_dbe_b_state = truncate(HMAC("WA"), 4)
    //     aws_dbe_b_zip = truncate(HMAC("98101"), 10)

    // Add a record in CA with customer data
    final HashMap<String, AttributeValue> exampleZipcodeItem = new HashMap<>();
    exampleZipcodeItem.put("customer_id", AttributeValue.builder().s("ABC-123").build());
    exampleZipcodeItem.put("create_time", AttributeValue.builder().n("1681495205").build());
    exampleZipcodeItem.put("state", AttributeValue.builder().s("CA").build());
    exampleZipcodeItem.put("zip", AttributeValue.builder().s("98101").build());
    exampleZipcodeItem.put("customerData", AttributeValue.builder().bool(true).build());

    final PutItemRequest putRequest = PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(exampleZipcodeItem)
        .build();

    final PutItemResponse putResponse = ddb.putItem(putRequest);
    // Assert PutItem was successful
    assert 200 == putResponse.sdkHttpResponse().statusCode();

    // Add record in CA with no customer data
    final HashMap<String, AttributeValue> length3PrefixZipcodeItem = new HashMap<>();
    length3PrefixZipcodeItem.put("customer_id", AttributeValue.builder().s("DEF-456").build());
    length3PrefixZipcodeItem.put("create_time", AttributeValue.builder().n("1681495205").build());
    length3PrefixZipcodeItem.put("state", AttributeValue.builder().s("CA").build());
    length3PrefixZipcodeItem.put("zip", AttributeValue.builder().s("98155").build());
    length3PrefixZipcodeItem.put("customerData", AttributeValue.builder().bool(false).build());


    final PutItemRequest length3PrefixPutRequest = PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(length3PrefixZipcodeItem)
        .build();

    final PutItemResponse length3PrefixPutResponse = ddb.putItem(length3PrefixPutRequest);
    // Assert PutItem was successful
    assert 200 == length3PrefixPutResponse.sdkHttpResponse().statusCode();

    // 11. Query for the item we just put.
    //     Note that we are constructing the query as if we were querying on plaintext values.
    //     However, the DDB encryption client will detect that this attribute name has a beacon configured.
    //     The client will add the beaconized attribute name and attribute value to the query,
    //         and transform the query to use the beaconized name and value.
    //     Internally, the client will query for and receive all items with a matching HMAC value in the beacon field.
    //     This may include a number of "false positives" with different ciphertext, but the same truncated HMAC.
    //     e.g. if truncate(HMAC("WA"), 4) == truncate(HMAC("DC"), 4), the query will return both items.
    //     The client will decrypt all returned items to determine which ones have the expected attribute values,
    //         and only surface items with the correct plaintext to the user.
    //     This procedure is internal to the client and is abstracted away from the user;
    //     e.g. the user will only see "WA" and never "DC", though the actual query returned both.
    Map<String,String> expressionAttributesNames = new HashMap<>();
    expressionAttributesNames.put("#s", "state");
//    expressionAttributesNames.put("#z", "zip");
    expressionAttributesNames.put("#zp", "stateAndCustomerData");

    Map<String,AttributeValue> expressionAttributeValues = new HashMap<>();
    expressionAttributeValues.put(":s", AttributeValue.builder().s("CA").build());
//    expressionAttributeValues.put(":z", AttributeValue.builder().s("98101").build());
    // Since we added virtual parts as `customerData` then `state`,
    // we must write our query expression in the same order
    expressionAttributeValues.put(":zp", AttributeValue.builder().s("tCA").build());

    QueryRequest queryRequest = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName(GSI_NAME)
        .keyConditionExpression("#s = :s")
        .filterExpression("#zp = :zp")
        .expressionAttributeNames(expressionAttributesNames)
        .expressionAttributeValues(expressionAttributeValues)
        .build();

    final QueryResponse queryResponse = ddb.query(queryRequest);
    List<Map<String, AttributeValue>> attributeValues = queryResponse.items();
    // Validate query was returned successfully
    assert 200 == queryResponse.sdkHttpResponse().statusCode();
    System.out.println("Got items " + attributeValues.size());
    // Validate only 1 item was returned: the item we just put
    assert attributeValues.size() == 1;
    final Map<String, AttributeValue> returnedItem = attributeValues.get(0);
    // Validate the item has the expected attributes
    assert returnedItem.get("state").s().equals("CA");
    assert returnedItem.get("customerData").bool().equals(true);
  }

  public static void main(final String[] args) {
    if (args.length != 3) {
      throw new IllegalArgumentException("To run this example, include ddbTableName as args[0], branchKeyWrappingKmsKeyId as args[1], and branchKeyDdbTableName as args[2]");
    }
    final String ddbTableName = args[0];
    final String branchKeyWrappingKmsKeyArn = args[1];
    final String branchKeyDdbTableName = args[2];
    PutItemQueryItemWithBeacon(ddbTableName, branchKeyWrappingKmsKeyArn, branchKeyDdbTableName);
  }
}
