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
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetPrefix;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SearchConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SingleKeyStore;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.StandardBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualField;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualTransform;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.DynamoDbEncryptionTransforms;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ResolveAttributesInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ResolveAttributesOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

/*
  This example demonstrates how to set up a virtual field from two DDB
  attributes, create a standard beacon with that field, put an item with
  that beacon, and query against that beacon.

  A virtual field is a field consisting of a transformation of one or more attributes in a DDB item.
  Virtual fields are useful in querying against encrypted fields that only have a handful of
  possible values. They allow you to take fields with few possible values, concatenate
  them to other fields, then query against the combined field. This enables using these types of
  fields in queries while making it infeasible to identify which beacon values encode
  the few possible distinct plaintexts. This is explained in more detail below.
  Virtual fields are not stored in the DDB table. However, they are used to construct
  a beacon, the value of which is stored.

  For more information on virtual fields, see
    https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/beacons.html#virtual-field

  For our example, we will construct a virtual field
  from two DDB attributes `state` and `hasTestResult` as `state`+prefix(`hasTestResult`, 1).
  We will then create a beacon out of this virtual field and use it to search.

  This example follows a use case of a database that stores customer test result metadata.
  Records are indexed by `customer_id` and store a `state` attribute, representing the
  US state or territory where the customer lives, and a `hasTestResult` boolean attribute,
  representing whether the customer has a "test result" available. (Maybe this represents
  some medical test result, and this table stores "result available" metadata.) We assume
  that values in these fields are uniformly distributed across all possible values for
  these fields (56 for `state`, 2 for `hasTestResult`), and are uniformly distributed across
  customer IDs.

  The motivation behind this example is to demonstrate how and why one would use a virtual beacon.
  In this example, our table stores records with an encrypted boolean `hasTestResult` attribute.
  We would like to be able to query for customers in a given state with a `true` hasTestResult
  attribute.

  To be able to execute this query securely and efficiently, we want the following
  properties on our table:
   1. Hide the distribution of `hasTestResult` attribute values (i.e. it should be infeasible
      to determine the percentage of `true`s to `false`s across the dataset from beaconized
      values)
   2. Query against a combination of whether `hasTestResult` is true/false and the `state` field
  We cannot achieve these properties with a standard beacon on a true/false attribute. Following
  the guidance to choose a beacon length:
    https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
  For a boolean value (in our case, whether `hasTestResult` is true or false), the acceptable
  bounds for beacon length are either 0 or 1. This corresponds to either not storing a beacon
  (length 0), or effectively storing another boolean attribute (length 1). With
  length 0, this beacon is useless for searching (violating property 2); with length 1, this
  beacon may not hide the attribute (violating property 1).
  In addition, choosing a longer beacon length does not help us.
  Each attribute value is mapped to a distinct beacon.
  Since booleans only have 2 possible attribute values, we will still only have 2 possible
  beacon values, though those values may be longer. A longer beacon provides no advantages over
  beacon of length 1 in this situation.

  A compound beacon also does not help.
  To (over)simplify, a compound beacon is a concatenation of standard beacons,
  i.e. beacon(`state`)+beacon(`hasTestResult`).
  The `hasTestResult` beacon is still visible, so we would still have the problems above.

  To achieve these properties, we instead construct a virtual field and use that in our beacon,
  i.e. beacon(`state`+`hasTestResult`). Assuming these fields are well-distributed across
  customer IDs and possible values, this gives us both desired properties; we can query against
  both attributes while hiding information from the underlying data. This is demonstrated in more
  detail below.

  Running this example requires access to a DDB table  with the
  following primary key configuration:
    - Partition key is named "customer_id" with type (S)
    - Sort key is named "create_time" with type (S)
  This table must have a Global Secondary Index (GSI) configured named "stateAndHasTestResult-index":
    - Partition key is named "aws_dbe_b_stateAndHasTestResult" with type (S)

  In this example for storing customer location data, this schema is utilized for the data:
   - "customer_id" stores a unique customer identifier
   - "create_time" stores a Unix timestamp
   - "state" stores an encrypted 2-letter US state or territory abbreviation
         (https://www.faa.gov/air_traffic/publications/atpubs/cnt_html/appendix_a.html)
   - "hasTestResult" is not part of the schema, but is an attribute utilized in this example.
      It stores a boolean attribute (false/true) indicating whether this customer has a test result
      available.

  The example requires the following ordered input command line parameters:
    1. DDB table name for table to put/query data from
    2. Branch key ID for a branch key that was previously created in your key store. See the
       CreateKeyStoreKeyExample.
    2. Branch key wrapping KMS key ARN for the KMS key used to create the branch key
    3. Branch key DDB table name for the DDB table representing the branch key store
 */

public class VirtualBeaconSearchableEncryptionExample {

  static String GSI_NAME = "stateAndHasTestResult-index";

  public static void PutItemQueryItemWithVirtualBeacon(
    String ddbTableName,
    String branchKeyId,
    String branchKeyWrappingKmsKeyArn,
    String branchKeyDdbTableName
  ) {
    // 1. Construct a length-1 prefix virtual transform.
    //    `hasTestResult` is a binary attribute, containing either `true` or `false`.
    //    As an example to demonstrate virtual transforms, we will truncate the value
    //    of `hasTestResult` in the virtual field to the length-1 prefix of the binary value, i.e.:
    //     - "true" -> "t"
    //     - "false -> "f"
    //    This is not necessary. This is done as a demonstration of virtual transforms.
    //    Virtual transform operations treat all attributes as strings
    //    (i.e. the boolean value `true` is interpreted as a string "true"),
    //    so its length-1 prefix is just "t".
    List<VirtualTransform> length1PrefixVirtualTransformList =
      new ArrayList<>();
    VirtualTransform length1PrefixVirtualTransform = VirtualTransform
      .builder()
      .prefix(GetPrefix.builder().length(1).build())
      .build();
    length1PrefixVirtualTransformList.add(length1PrefixVirtualTransform);

    // 2. Construct the VirtualParts required for the VirtualField
    VirtualPart hasTestResultPart = VirtualPart
      .builder()
      .loc("hasTestResult")
      // Here, we apply the length-1 prefix virtual transform
      .trans(length1PrefixVirtualTransformList)
      .build();
    VirtualPart statePart = VirtualPart
      .builder()
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
    virtualPartList.add(hasTestResultPart);

    VirtualField stateAndHasTestResultField = VirtualField
      .builder()
      .name("stateAndHasTestResult")
      .parts(virtualPartList)
      .build();

    List<VirtualField> virtualFieldList = new ArrayList<>();
    virtualFieldList.add(stateAndHasTestResultField);

    // 4. Configure our beacon.
    //    The virtual field is assumed to hold a US 2-letter state abbreviation
    //    (56 possible values = 50 states + 6 territories) concatenated with a binary attribute
    //    (2 possible values: true/false hasTestResult field), we expect a population size of
    //    56 * 2 = 112 possible values.
    //    We will also assume that these values are reasonably well-distributed across
    //    customer IDs. In practice, this will not be true. We would expect
    //    more populous states to appear more frequently in the database.
    //    A more complex analysis would show that a stricter upper bound
    //    is necessary to account for this by hiding information from the
    //    underlying distribution.
    //
    //    This link provides guidance for choosing a beacon length:
    //       https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
    //    We follow the guidance in the link above to determine reasonable bounds for beacon length:
    //     - min: log(sqrt(112))/log(2) ~= 3.4, round down to 3
    //     - max: log((112/2))/log(2) ~= 5.8, round up to 6
    //    You will somehow need to round results to a nearby integer.
    //    We choose to round to the nearest integer; you might consider a different rounding approach.
    //    Rounding up will return fewer expected "false positives" in queries,
    //       leading to fewer decrypt calls and better performance,
    //       but it is easier to identify which beacon values encode distinct plaintexts.
    //    Rounding down will return more expected "false positives" in queries,
    //       leading to more decrypt calls and worse performance,
    //       but it is harder to identify which beacon values encode distinct plaintexts.
    //    We can choose a beacon length between 3 and 6:
    //     - Closer to 3, we expect more "false positives" to be returned,
    //       making it harder to identify which beacon values encode distinct plaintexts,
    //       but leading to more decrypt calls and worse performance
    //     - Closer to 6, we expect fewer "false positives" returned in queries,
    //       leading to fewer decrypt calls and better performance,
    //       but it is easier to identify which beacon values encode distinct plaintexts.
    //    As an example, we will choose 5.
    //    Values stored in aws_dbe_b_stateAndHasTestResult will be 5 bits long (0x00 - 0x1f)
    //    There will be 2^5 = 32 possible HMAC values.
    //    With a well-distributed dataset (112 values), for a particular beacon we expect
    //    (112/32) = 3.5 combinations of abbreviation + true/false attribute
    //    sharing that beacon value.
    List<StandardBeacon> standardBeaconList = new ArrayList<>();
    StandardBeacon stateAndHasTestResultBeacon = StandardBeacon
      .builder()
      // This name is the same as our virtual field's name above
      .name("stateAndHasTestResult")
      .length(5)
      .build();
    standardBeaconList.add(stateAndHasTestResultBeacon);

    // 5. Configure Keystore.
    //    This example expects that you have already set up a KeyStore with a single branch key.
    //    See the "CreateKeyStoreTableExample" and "CreateKeyStoreKeyExample" files for how to do this.
    //    After you create a branch key, you should persist its ID for use in this example.
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
    //        a different beacon key per tenant), look into configuring a MultiKeyStore:
    //          https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/searchable-encryption-multitenant.html
    //    We also provide our standard beacon list and virtual fields here.
    List<BeaconVersion> beaconVersions = new ArrayList<>();
    beaconVersions.add(
      BeaconVersion
        .builder()
        .virtualFields(virtualFieldList)
        .standardBeacons(standardBeaconList)
        .version(1) // MUST be 1
        .keyStore(keyStore)
        .keySource(
          BeaconKeySource
            .builder()
            .single(
              SingleKeyStore
                .builder()
                // `keyId` references a beacon key.
                // For every branch key we create in the keystore,
                // we also create a beacon key.
                // This beacon key is not the same as the branch key,
                // but is created with the same ID as the branch key.
                .keyId(branchKeyId)
                .cacheTTL(6000)
                .build()
            )
            .build()
        )
        .build()
    );

    // 7. Create a Hierarchical Keyring
    //    This is a KMS keyring that utilizes the keystore table.
    //    This config defines how items are encrypted and decrypted.
    //    NOTE: You should configure this to use the same keystore as your search config.
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

    // 8. Configure which attributes are encrypted and/or signed when writing new items.
    //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    //    we must explicitly configure how they should be treated during item encryption:
    //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    //    Any attributes that will be used in beacons must be configured as ENCRYPT_AND_SIGN.
    final Map<String, CryptoAction> attributeActionsOnEncrypt = new HashMap<>();
    attributeActionsOnEncrypt.put("customer_id", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put("create_time", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put("state", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActionsOnEncrypt.put(
      "hasTestResult",
      CryptoAction.ENCRYPT_AND_SIGN
    ); // Beaconized attributes must be encrypted

    // 9. Create the DynamoDb Encryption configuration for the table we will be writing to.
    //    The beaconVersions are added to the search configuration.
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig
      .builder()
      .logicalTableName(ddbTableName)
      .partitionKeyName("customer_id")
      .sortKeyName("create_time")
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

    // 10. Create config
    final DynamoDbTablesEncryptionConfig encryptionConfig =
      DynamoDbTablesEncryptionConfig
        .builder()
        .tableEncryptionConfigs(tableConfigs)
        .build();

    // 11. Create test items

    // Create item with hasTestResult=true
    final HashMap<String, AttributeValue> itemWithHasTestResult =
      new HashMap<>();
    itemWithHasTestResult.put(
      "customer_id",
      AttributeValue.builder().s("ABC-123").build()
    );
    itemWithHasTestResult.put(
      "create_time",
      AttributeValue.builder().n("1681495205").build()
    );
    itemWithHasTestResult.put(
      "state",
      AttributeValue.builder().s("CA").build()
    );
    itemWithHasTestResult.put(
      "hasTestResult",
      AttributeValue.builder().bool(true).build()
    );

    // Create item with hasTestResult=false
    final HashMap<String, AttributeValue> itemWithNoHasTestResult =
      new HashMap<>();
    itemWithNoHasTestResult.put(
      "customer_id",
      AttributeValue.builder().s("DEF-456").build()
    );
    itemWithNoHasTestResult.put(
      "create_time",
      AttributeValue.builder().n("1681495205").build()
    );
    itemWithNoHasTestResult.put(
      "state",
      AttributeValue.builder().s("CA").build()
    );
    itemWithNoHasTestResult.put(
      "hasTestResult",
      AttributeValue.builder().bool(false).build()
    );

    // 12. If developing or debugging, verify config by checking virtual field values directly
    final DynamoDbEncryptionTransforms trans = DynamoDbEncryptionTransforms
      .builder()
      .DynamoDbTablesEncryptionConfig(encryptionConfig)
      .build();

    final ResolveAttributesInput resolveInput = ResolveAttributesInput
      .builder()
      .TableName(ddbTableName)
      .Item(itemWithHasTestResult)
      .Version(1)
      .build();
    final ResolveAttributesOutput resolveOutput = trans.ResolveAttributes(
      resolveInput
    );

    // CompoundBeacons is empty because we have no Compound Beacons configured
    assert resolveOutput.CompoundBeacons().isEmpty();

    // Verify that VirtualFields has the expected value
    Map<String, String> vf = new HashMap<>();
    vf.put("stateAndHasTestResult", "CAt");
    assert resolveOutput.VirtualFields().equals(vf);

    // 13. Create the DynamoDb Encryption Interceptor
    DynamoDbEncryptionInterceptor encryptionInterceptor =
      DynamoDbEncryptionInterceptor.builder().config(encryptionConfig).build();

    // 14. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(encryptionInterceptor)
          .build()
      )
      .build();

    // 15. Put two items into our table using the above client.
    //     The two items will differ only in their `customer_id` attribute (primary key)
    //         and their `hasTestResult` attribute.
    //     We will query against these items to demonstrate how to use our setup above
    //         to query against our `stateAndHasTestResult` beacon.
    //     Before the item gets sent to DynamoDb, it will be encrypted
    //         client-side, according to our configuration.
    //     Since our configuration includes a beacon on a virtual field named
    //         `stateAndHasTestResult`, the client will add an attribute
    //         to the item with name `aws_dbe_b_stateAndHasTestResult`.
    //         Its value will be an HMAC truncated to as many bits as the
    //         beacon's `length` parameter; i.e. 5.

    final PutItemRequest itemWithHasTestResultPutRequest = PutItemRequest
      .builder()
      .tableName(ddbTableName)
      .item(itemWithHasTestResult)
      .build();

    final PutItemResponse itemWithHasTestResultPutResponse = ddb.putItem(
      itemWithHasTestResultPutRequest
    );
    // Assert PutItem was successful
    assert 200 ==
    itemWithHasTestResultPutResponse.sdkHttpResponse().statusCode();

    final PutItemRequest itemWithNoHasTestResultPutRequest = PutItemRequest
      .builder()
      .tableName(ddbTableName)
      .item(itemWithNoHasTestResult)
      .build();

    final PutItemResponse itemWithNoHasTestResultPutResponse = ddb.putItem(
      itemWithNoHasTestResultPutRequest
    );
    // Assert PutItem was successful
    assert 200 ==
    itemWithNoHasTestResultPutResponse.sdkHttpResponse().statusCode();

    // 16. Query by stateAndHasTestResult attribute.
    //     Note that we are constructing the query as if we were querying on plaintext values.
    //     However, the DDB encryption client will detect that this attribute name has a beacon configured.
    //     The client will add the beaconized attribute name and attribute value to the query,
    //         and transform the query to use the beaconized name and value.
    //     Internally, the client will query for and receive all items with a matching HMAC value in the beacon field.
    //     This may include a number of "false positives" with different ciphertext, but the same truncated HMAC.
    //     e.g. if truncate(HMAC("CAt"), 5) == truncate(HMAC("DCf"), 5), the query will return both items.
    //     The client will decrypt all returned items to determine which ones have the expected attribute values,
    //         and only surface items with the correct plaintext to the user.
    //     This procedure is internal to the client and is abstracted away from the user;
    //     e.g. the user will only see "CAt" and never "DCf", though the actual query returned both.
    Map<String, String> expressionAttributesNames = new HashMap<>();
    expressionAttributesNames.put(
      "#stateAndHasTestResult",
      "stateAndHasTestResult"
    );

    Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
    // We are querying for the item with `state`="CA" and `hasTestResult`=`true`.
    // Since we added virtual parts as `state` then `hasTestResult`,
    //     we must write our query expression in the same order.
    // We constructed our virtual field as `state`+`hasTestResult`,
    //     so we add the two parts in that order.
    // Since we also created a virtual transform that truncated `hasTestResult`
    //     to its length-1 prefix, i.e. "true" -> "t",
    //     we write that field as its length-1 prefix in the query.
    expressionAttributeValues.put(
      ":stateAndHasTestResult",
      AttributeValue.builder().s("CAt").build()
    );

    QueryRequest queryRequest = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName(GSI_NAME)
      .keyConditionExpression("#stateAndHasTestResult = :stateAndHasTestResult")
      .expressionAttributeNames(expressionAttributesNames)
      .expressionAttributeValues(expressionAttributeValues)
      .build();

    // GSIs do not update instantly
    // so if the results come back empty
    // we retry after a short sleep
    for (int i = 0; i < 10; ++i) {
      final QueryResponse queryResponse = ddb.query(queryRequest);
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

      // Validate only 1 item was returned: the item with the expected attributes
      assert attributeValues.size() == 1;
      final Map<String, AttributeValue> returnedItem = attributeValues.get(0);
      // Validate the item has the expected attributes
      assert returnedItem.get("state").s().equals("CA");
      assert returnedItem.get("hasTestResult").bool().equals(true);
      break;
    }
  }

  public static void main(final String[] args) {
    if (args.length <= 1) {
      throw new IllegalArgumentException(
        "To run this example, include ddbTableName as args[0], branchKeyId as args[1], branchKeyWrappingKmsKeyId as args[2], and branchKeyDdbTableName as args[3]"
      );
    }
    final String ddbTableName = args[0];
    final String branchKeyId = args[1];
    final String branchKeyWrappingKmsKeyArn = args[2];
    final String branchKeyDdbTableName = args[3];
    PutItemQueryItemWithVirtualBeacon(
      ddbTableName,
      branchKeyId,
      branchKeyWrappingKmsKeyArn,
      branchKeyDdbTableName
    );
  }
}
