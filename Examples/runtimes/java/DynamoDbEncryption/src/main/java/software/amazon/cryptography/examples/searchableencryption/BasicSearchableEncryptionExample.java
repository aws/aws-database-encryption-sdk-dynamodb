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
import software.amazon.cryptography.keystore.model.CreateKeyOutput;
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

/*
  This example demonstrates how to set up a beacon on an encrypted attribute,
  put an item with the beacon, and query against that beacon.
  This example follows a use case of a database that stores unit inspection information.

  Running this example requires access to a DDB table with the
  following key configuration:
    - Partition key is named "work_id" with type (S)
    - Sort key is named "inspection_date" with type (S)
  This table must have a Global Secondary Index (GSI) configured named "last4-unit-index":
    - Partition key is named "aws_dbe_b_inspector_id_last4" with type (S)
    - Sort key is named "aws_dbe_b_unit" with type (S)

  In this example for storing unit inspection information, this schema is utilized for the data:
   - "work_id" stores a unique identifier for a unit inspection work order (v4 UUID)
   - "inspection_date" stores an ISO 8601 date for the inspection (YYYY-MM-DD)
   - "inspector_id_last4" stores the last 4 digits of the ID of the inspector performing the work
   - "unit" stores a 12-digit serial number for the unit being inspected

  The example requires the following ordered input command line parameters:
    1. DDB table name for table to put/query data from
    2. Branch key ID for a branch key that was previously created in your key store. See the
       CreateKeyStoreKeyExample.
    3. Branch key wrapping KMS key ARN for the KMS key used to create the branch key with ID
       provided in arg 2
    4. Branch key DDB table name for the DDB table representing the branch key store
 */

public class BasicSearchableEncryptionExample {

  static String GSI_NAME = "last4-unit-index";

  public static void PutItemQueryItemWithBeacon(
    String ddbTableName,
    String branchKeyId,
    String branchKeyWrappingKmsKeyArn,
    String branchKeyDdbTableName
  ) {
    // 1. Configure Beacons.
    //    The beacon name must be the name of a table attribute that will be encrypted.
    //    The `length` parameter dictates how many bits are in the beacon attribute value.
    //    The following link provides guidance on choosing a beacon length:
    //        https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
    List<StandardBeacon> standardBeaconList = new ArrayList<>();

    // The configured DDB table has a GSI on the `aws_dbe_b_inspector_id_last4` AttributeName.
    // This field holds the last 4 digits of an inspector ID.
    // For our example, this field may range from 0 to 9,999 (10,000 possible values).
    // For our example, we assume a full inspector ID is an integer
    //     ranging from 0 to 99,999,999. We do not assume that the full inspector ID's
    //     values are uniformly distributed across its range of possible values.
    //     In many use cases, the prefix of an identifier encodes some information
    //     about that identifier (e.g. zipcode and SSN prefixes encode geographic
    //     information), while the suffix does not and is more uniformly distributed.
    //     We will assume that the inspector ID field matches a similar use case.
    //     So for this example, we only store and use the last
    //     4 digits of the inspector ID, which we assume is uniformly distributed.
    // Since the full ID's range is divisible by the range of the last 4 digits,
    //     then the last 4 digits of the inspector ID are uniformly distributed
    //     over the range from 0 to 9,999.
    // See our documentation for why you should avoid creating beacons over non-uniform distributions
    //  https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/searchable-encryption.html#are-beacons-right-for-me
    // A single inspector ID suffix may be assigned to multiple `work_id`s.
    //
    // This link provides guidance for choosing a beacon length:
    //    https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
    // We follow the guidance in the link above to determine reasonable bounds
    // for the length of a beacon on the last 4 digits of an inspector ID:
    //  - min: log(sqrt(10,000))/log(2) ~= 6.6, round up to 7
    //  - max: log((10,000/2))/log(2) ~= 12.3, round down to 12
    // You will somehow need to round results to a nearby integer.
    // We choose to round to the nearest integer; you might consider a different rounding approach.
    // Rounding up will return fewer expected "false positives" in queries,
    //    leading to fewer decrypt calls and better performance,
    //    but it is easier to identify which beacon values encode distinct plaintexts.
    // Rounding down will return more expected "false positives" in queries,
    //    leading to more decrypt calls and worse performance,
    //    but it is harder to identify which beacon values encode distinct plaintexts.
    // We can choose a beacon length between 7 and 12:
    //  - Closer to 7, we expect more "false positives" to be returned,
    //    making it harder to identify which beacon values encode distinct plaintexts,
    //    but leading to more decrypt calls and worse performance
    //  - Closer to 12, we expect fewer "false positives" returned in queries,
    //    leading to fewer decrypt calls and better performance,
    //    but it is easier to identify which beacon values encode distinct plaintexts.
    // As an example, we will choose 10.
    //
    // Values stored in aws_dbe_b_inspector_id_last4 will be 10 bits long (0x000 - 0x3ff)
    // There will be 2^10 = 1,024 possible HMAC values.
    // With a sufficiently large number of well-distributed inspector IDs,
    //    for a particular beacon we expect (10,000/1,024) ~= 9.8 4-digit inspector ID suffixes
    //    sharing that beacon value.
    StandardBeacon last4Beacon = StandardBeacon
      .builder()
      .name("inspector_id_last4")
      .length(10)
      .build();
    standardBeaconList.add(last4Beacon);

    // The configured DDB table has a GSI on the `aws_dbe_b_unit` AttributeName.
    // This field holds a unit serial number.
    // For this example, this is a 12-digit integer from 0 to 999,999,999,999 (10^12 possible values).
    // We will assume values for this attribute are uniformly distributed across this range.
    // A single unit serial number may be assigned to multiple `work_id`s.
    //
    // This link provides guidance for choosing a beacon length:
    //    https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
    // We follow the guidance in the link above to determine reasonable bounds
    // for the length of a beacon on a unit serial number:
    //  - min: log(sqrt(999,999,999,999))/log(2) ~= 19.9, round up to 20
    //  - max: log((999,999,999,999/2))/log(2) ~= 38.9, round up to 39
    // We can choose a beacon length between 20 and 39:
    //  - Closer to 20, we expect more "false positives" to be returned,
    //    making it harder to identify which beacon values encode distinct plaintexts,
    //    but leading to more decrypt calls and worse performance
    //  - Closer to 39, we expect fewer "false positives" returned in queries,
    //    leading to fewer decrypt calls and better performance,
    //    but it is easier to identify which beacon values encode distinct plaintexts.
    // As an example, we will choose 30.
    //
    // Values stored in aws_dbe_b_unit will be 30 bits long (0x00000000 - 0x3fffffff)
    // There will be 2^30 = 1,073,741,824 ~= 1.1B possible HMAC values.
    // With a sufficiently large number of well-distributed inspector IDs,
    //    for a particular beacon we expect (10^12/2^30) ~= 931.3 unit serial numbers
    //    sharing that beacon value.
    StandardBeacon unitBeacon = StandardBeacon
      .builder()
      .name("unit")
      .length(30)
      .build();
    standardBeaconList.add(unitBeacon);

    // 2. Configure Keystore.
    //    The keystore is a separate DDB table where the client stores encryption and decryption materials.
    //    In order to configure beacons on the DDB client, you must configure a keystore.
    //
    //    This example expects that you have already set up a KeyStore with a single branch key.
    //    See the "Create KeyStore Table Example" and "Create KeyStore Key Example" for how to do this.
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

    // 3. Create BeaconVersion.
    //    The BeaconVersion inside the list holds the list of beacons on the table.
    //    The BeaconVersion also stores information about the keystore.
    //    BeaconVersion must be provided:
    //      - keyStore: The keystore configured in step 2.
    //      - keySource: A configuration for the key source.
    //        For simple use cases, we can configure a 'singleKeySource' which
    //        statically configures a single beaconKey. That is the approach this example takes.
    //        For use cases where you want to use different beacon keys depending on the data
    //        (for example if your table holds data for multiple tenants, and you want to use
    //        a different beacon key per tenant), look into configuring a MultiKeyStore:
    //          https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/searchable-encryption-multitenant.html
    List<BeaconVersion> beaconVersions = new ArrayList<>();
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

    // 4. Create a Hierarchical Keyring
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

    // 5. Configure which attributes are encrypted and/or signed when writing new items.
    //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    //    we must explicitly configure how they should be treated during item encryption:
    //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    //    Any attributes that will be used in beacons must be configured as ENCRYPT_AND_SIGN.
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

    // 7. Create the DynamoDb Encryption Interceptor
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

    // 8. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(encryptionInterceptor)
          .build()
      )
      .build();

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

    final PutItemResponse putResponse = ddb.putItem(putRequest);
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

      // Validate only 1 item was returned: the item we just put
      assert attributeValues.size() == 1;
      final Map<String, AttributeValue> returnedItem = attributeValues.get(0);
      // Validate the item has the expected attributes
      assert returnedItem.get("inspector_id_last4").s().equals("4321");
      assert returnedItem.get("unit").s().equals("123456789012");
      break;
    }
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
    PutItemQueryItemWithBeacon(
      ddbTableName,
      branchKeyId,
      branchKeyWrappingKmsKeyArn,
      branchKeyDdbTableName
    );
  }
}
