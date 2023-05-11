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
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetPrefix;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SearchConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SingleKeyStore;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.StandardBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualField;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualTransform;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.aws.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;

/*
  This example demonstrates how to set up a virtual field from two DDB
  attributes, create a standard beacon with that field, put an item with
  that beacon, and query against that beacon.

  A virtual field is a field consisting of a transformation of one or more attributes in a DDB item.
  Virtual fields are not stored in the DDB table. However, they are used to construct
  a beacon, the value of which is stored. For our example, we will construct a virtual field
  from two DDB attributes `state` and `hasSensitiveData` as `state`+prefix(`hasSensitiveData`, 1).
  We will then create beacon out of this virtual field and use it to search.

  In general, if you wish to use a field with only a handful possible values, it is suggested
  to construct a virtual field to enable effective querying while obfuscating underlying data.

  This example follows a use case of a database that stores customer location data. This is an
  extension of the "BasicSearchableEncryptionExample" in this directory. This example uses the same
  situation (storing customer location data) and the same table schema, but adds a virtual field
  `stateAndHasSensitiveData`.

  The motivation behind this example is to demonstrate how and why one would use a virtual beacon.
  In this example, our table stores records with an encrypted boolean `hasSensitiveData` attribute.
  We would like to be able to query for customers in a given state with a `true` hasSensitiveData
  attribute. In practice, this setup might be used to identify customers with particular types
  of data in a particular state to comply with different state's data processing laws
  (e.g. CA's CCPA, IL's BIPA). If a customer provides particularly sensitive (e.g. biometric)
  data, we want a flag indicating that. Please note that this is a streamlined example to facilitate
  understanding, and we do not suggest using this setup for production purpose.

  To be able to execute this query securely and efficiently, we want the following
  properties on our table:
   1. Obfuscate whether a record's `hasSensitiveData` attribute is `true` or `false`
   2. Query against a combination of whether `hasSensitiveData` is true/false and the `state` field
  We could not achieve these properties with a standard beacon on an true/false attribute.Following
  the guidance to choose a beacon length:
    TODO: link
  For a boolean value (in our case, whether `hasSensitiveData` is true or false), the acceptable
  bounds for beacon length are either 0 or 1. This corresponds to either not storing a beacon
  (length 0), or effectively directly storing an true/false attribute (length 1). With
  length 0, this beacon is useless for searching (violating property 2); with length 1, this
  beacon does not obfuscate the attribute (violating property 1).

  (A compound beacon also does not help. To (over)simplify, a compound beacon is a
   concatenation of standard beacons, i.e. beacon(`state`)+beacon(`hasSensitiveData`).
   The `state` beacon is still visible, so we would still have the problems above.)

  To achieve these properties, we instead construct a virtual field and use that in our beacon,
  i.e. beacon(`state`+`hasSensitiveData`). This gives us both desired properties; we can query
  against both attributes while obfuscating the underlying data. This is demonstrated in more
  detail below.

  Running this example requires access to a DDB table  with the
  following primary key configuration:
    - Partition key is named "customer_id" with type (S)
    - Sort key is named "create_time" with type (S)
  This table must have a Global Secondary Index (GSI) configured named "stateAndHasSensitiveData-index":
    - Partition key is named "aws_dbe_b_stateAndHasSensitiveData" with type (S)

  In this example for storing customer location data, this schema is utilized for the data:
   - "customer_id" stores a unique customer identifier
   - "create_time" stores a Unix timestamp
   - "state" stores an encrypted 2-letter US state or territory abbreviation
         (https://www.faa.gov/air_traffic/publications/atpubs/cnt_html/appendix_a.html)
   - "zip" stores an encrypted 5-digit US zipcode (00000 - 99999)
   - "hasSensitiveData" is not part of the schema, but is an attribute utilized in this example.
      It stores a boolean attribute (false/true) indicating whether this customer has sensitive
      data stored.

  The example requires the following ordered input command line parameters:
    1. DDB table name for table to put/query data from
    2. Branch key ID for a branch key that was previously created in your key store. See the
       CreateKeyStoreKeyExample.
    2. Branch key wrapping KMS key ARN for the KMS key used to create the branch key
    3. Branch key DDB table name for the DDB table representing the branch key store
 */

public class VirtualBeaconSearchableEncryptionExample {

  static String GSI_NAME = "stateAndHasSensitiveData-index";

  public static void PutItemQueryItemWithVirtualBeacon(String ddbTableName, String branchKeyId,
      String branchKeyWrappingKmsKeyArn, String branchKeyDdbTableName) {
    // 1. Construct a length-1 prefix virtual transform.
    //    `hasSensitiveData` is a binary attribute, containing either `true` or `false`.
    //    As an example to demonstrate virtual transforms, we will truncate the value
    //    of `hasSensitiveData` in the virtual field to the length-1 prefix of the binary value, i.e.:
    //     - "true" -> "t"
    //     - "false -> "f"
    //    This is not necessary. This is done as a demonstration of virtual transforms.
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
    VirtualPart hasSensitiveDataPart = VirtualPart.builder()
        .loc("hasSensitiveData")
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
    virtualPartList.add(statePart);
    virtualPartList.add(hasSensitiveDataPart);

    VirtualField stateAndHasSensitiveDataField = VirtualField.builder()
        .name("stateAndHasSensitiveData")
        .parts(virtualPartList)
        .build();

    List<VirtualField> virtualFieldList = new ArrayList<>();
    virtualFieldList.add(stateAndHasSensitiveDataField);

    // 4. Configure our beacon.
    //    The virtual field is assumed to hold a well-distributed US 2-letter state abbreviation
    //      (56 possible values = 50 states + 6 territories) concatenated with a binary attribute
    //      (2 possible values: true/false hasSensitiveData field), we expect a population size of
    //      (56 * 2 = 112) possible values.
    //    The following link provides guidance on choosing a beacon length:
    //       TODO: add link
    //    We follow the guidance in the link above to determine acceptable bounds for beacon length:
    //     - min: log(sqrt(112))/log(2) ~= 3.4, round up to 4
    //     - max: log((112/2))/log(2) ~= 5.8, round up to 6
    //    We can safely choose a beacon length between 4 and 6:
    //     - Closer to 4, the underlying data is better obfuscated, but more "false positives" are returned in
    //       queries, leading to more decrypt calls and worse performance
    //     - Closer to 6, fewer "false positives" are returned in queries, leading to fewer decrypt calls and
    //       better performance, but it is easier to distinguish unique plaintext values
    //    As an example, we will choose 5.
    //    Values stored in aws_dbe_b_stateAndHasSensitiveData will be 5 bits long (0x00 - 0x1f)
    //    There will be 2^5 = 32 possible HMAC values.
    //    With well-distributed plaintext data (112 values), we expect (112/32) = 3.5 combinations of
    //       abbreviation + true/false attribute sharing the same beacon value.
    //    NOTE: This example assumes that the field values are well-distributed. In practice, this will not be true.
    //          Some flaws in this assumption:
    //           - More populous states would be expected to have more records; those beacons will be overused
    //           - States where a business is not operating would expect no customer records for that state; those
    //             beacons will be underused
    //          This is a streamlined example and should not be used as a basis for determining beacon length
    //          in production. Users should analyze their specific dataset to determine acceptable beacon length bounds.
    List<StandardBeacon> standardBeaconList = new ArrayList<>();
    StandardBeacon stateAndHasSensitiveDataBeacon = StandardBeacon.builder()
        // This name is the same as our virtual field's name above;
        .name("stateAndHasSensitiveData")
        .length(5)
        .build();
    standardBeaconList.add(stateAndHasSensitiveDataBeacon);

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
    //      - keyStore: The keystore configured in the previous step.
    //      - keySource: A configuration for the key source.
    //        For simple use cases, we can configure a 'singleKeySource' which
    //        statically configures a single beaconKey. That is the approach this example takes.
    //        For use cases where you want to use different beacon keys depending on the data
    //        (for example if your table holds data for multiple tenants, and you want to use
    //        a different beacon key per tenant), look into configuring a Multi Beacon Key.
    //        Source: TODO example
    //    We also provide our standard beacon list and virtual fields here.
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

    // 7. Create a Hierarchical Keyring
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

    // 8. Configure which attributes are encrypted and/or signed when writing new items.
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
    attributeActions.put("hasSensitiveData", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted

    // 9. Create the DynamoDb Encryption configuration for the table we will be writing to.
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

    // 10. Create the DynamoDb Encryption Interceptor
    DynamoDbEncryptionInterceptor encryptionInterceptor = DynamoDbEncryptionInterceptor.builder()
        .config(DynamoDbTablesEncryptionConfig.builder()
            .tableEncryptionConfigs(tableConfigs)
            .build())
        .build();

    // 11. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient.builder()
        .overrideConfiguration(
            ClientOverrideConfiguration.builder()
                .addExecutionInterceptor(encryptionInterceptor)
                .build())
        .build();

    // 12. Put two items into our table using the above client.
    //     The two items will differ only in their `customer_id` attribute (primary key)
    //         and their `hasSensitiveData` attribute.
    //     We will query against these items to demonstrate how to use our setup above
    //         to query against our `stateAndHasSensitiveData` beacon.
    //     Before the item gets sent to DynamoDb, it will be encrypted
    //         client-side, according to our configuration.
    //     Since our configuration includes a beacon on a virtual field named
    //         `stateAndHasSensitiveData`, the client will add an attribute
    //         to the item with name `aws_dbe_b_stateAndHasSensitiveData`.
    //         Its value will be an HMAC truncated to as many bits as the
    //         beacon's `length` parameter; i.e. 5.

    // Add record with hasSensitiveData=true
    final HashMap<String, AttributeValue> itemWithHasSensitiveData = new HashMap<>();
    itemWithHasSensitiveData.put("customer_id", AttributeValue.builder().s("ABC-123").build());
    itemWithHasSensitiveData.put("create_time", AttributeValue.builder().n("1681495205").build());
    itemWithHasSensitiveData.put("state", AttributeValue.builder().s("CA").build());
    itemWithHasSensitiveData.put("zip", AttributeValue.builder().s("94111").build());
    itemWithHasSensitiveData.put("hasSensitiveData", AttributeValue.builder().bool(true).build());

    final PutItemRequest itemWithHasSensitiveDataPutRequest = PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(itemWithHasSensitiveData)
        .build();

    final PutItemResponse itemWithHasSensitiveDataPutResponse = ddb.putItem(itemWithHasSensitiveDataPutRequest);
    // Assert PutItem was successful
    assert 200 == itemWithHasSensitiveDataPutResponse.sdkHttpResponse().statusCode();

    // Add record with hasSensitiveData=false
    final HashMap<String, AttributeValue> itemWithNoHasSensitiveData = new HashMap<>();
    itemWithNoHasSensitiveData.put("customer_id", AttributeValue.builder().s("DEF-456").build());
    itemWithNoHasSensitiveData.put("create_time", AttributeValue.builder().n("1681495205").build());
    itemWithNoHasSensitiveData.put("state", AttributeValue.builder().s("CA").build());
    itemWithNoHasSensitiveData.put("zip", AttributeValue.builder().s("94111").build());
    itemWithNoHasSensitiveData.put("hasSensitiveData", AttributeValue.builder().bool(false).build());

    final PutItemRequest itemWithNoHasSensitiveDataPutRequest = PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(itemWithNoHasSensitiveData)
        .build();

    final PutItemResponse itemWithNoHasSensitiveDataPutResponse = ddb.putItem(itemWithNoHasSensitiveDataPutRequest);
    // Assert PutItem was successful
    assert 200 == itemWithNoHasSensitiveDataPutResponse.sdkHttpResponse().statusCode();

    // 11. Query by stateAndHasSensitiveData attribute.
    //     Note that we are constructing the query as if we were querying on plaintext values.
    //     However, the DDB encryption client will detect that this attribute name has a beacon configured.
    //     The client will add the beaconized attribute name and attribute value to the query,
    //         and transform the query to use the beaconized name and value.
    //     Internally, the client will query for and receive all items with a matching HMAC value in the beacon field.
    //     This may include a number of "false positives" with different ciphertext, but the same truncated HMAC.
    //     e.g. if truncate(HMAC("CAt"), t) == truncate(HMAC("DCf"), 5), the query will return both items.
    //     The client will decrypt all returned items to determine which ones have the expected attribute values,
    //         and only surface items with the correct plaintext to the user.
    //     This procedure is internal to the client and is abstracted away from the user;
    //     e.g. the user will only see "CAt" and never "DCf", though the actual query returned both.
    Map<String,String> expressionAttributesNames = new HashMap<>();
    expressionAttributesNames.put("#scd", "stateAndHasSensitiveData");

    Map<String,AttributeValue> expressionAttributeValues = new HashMap<>();
    // We are querying for the item with `state`="CA" and `hasSensitiveData`=`true`.
    // Since we added virtual parts as `state` then `hasSensitiveData`,
    //     we must write our query expression in the same order.
    // We constructed our virtual field as `state`+`hasSensitiveData`,
    //     so we add the two parts in that order.
    // Since we also created a virtual transform that truncated `hasSensitiveData`
    //     to its length-1 prefix, i.e. "true" -> "t",
    //     we write that field as its length-1 prefix in the query.
    expressionAttributeValues.put(":scd", AttributeValue.builder().s("CAt").build());

    QueryRequest queryRequest = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName(GSI_NAME)
        .keyConditionExpression("#scd = :scd")
        .expressionAttributeNames(expressionAttributesNames)
        .expressionAttributeValues(expressionAttributeValues)
        .build();

    final QueryResponse queryResponse = ddb.query(queryRequest);
    List<Map<String, AttributeValue>> attributeValues = queryResponse.items();
    // Validate query was returned successfully
    assert 200 == queryResponse.sdkHttpResponse().statusCode();
    // Validate only 1 item was returned: the item with the expected attributes
    assert attributeValues.size() == 1;
    final Map<String, AttributeValue> returnedItem = attributeValues.get(0);
    // Validate the item has the expected attributes
    assert returnedItem.get("state").s().equals("CA");
    assert returnedItem.get("hasSensitiveData").bool().equals(true);
  }

  public static void main(final String[] args) {
    if (args.length <= 1) {
      throw new IllegalArgumentException("To run this example, include ddbTableName as args[0], branchKeyId as args[1], branchKeyWrappingKmsKeyId as args[2], and branchKeyDdbTableName as args[3]");
    }
    final String ddbTableName = args[0];
    final String branchKeyId = args[1];
    final String branchKeyWrappingKmsKeyArn = args[2];
    final String branchKeyDdbTableName = args[3];
    PutItemQueryItemWithVirtualBeacon(ddbTableName, branchKeyId, branchKeyWrappingKmsKeyArn, branchKeyDdbTableName);
  }
}
