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
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.SearchConfig;
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
  This example demonstrates how to set up a beacon on an encrypted attribute,
  put an item with the beacon, and query against that beacon.
  This example follows a use case of a database that stores customer location data.

  Running this example requires access to a DDB table  with the
  following primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
  This table must have a Global Secondary Index (GSI) configured named "Example-Beacon-Index":
    - Partition key is named "aws_dbe_b_state" with type (S)
    - Sort key is named "aws_dbe_b_zip" with type (S)

  In this example for storing customer location data, this schema is utilized for the data:
   - "partition_key" stores a unique customer identifier
   - "sort_key" stores a Unix timestamp
   - "state" stores an encrypted 2-letter US state or territory abbreviation
         (https://www.faa.gov/air_traffic/publications/atpubs/cnt_html/appendix_a.html)
   - "zip" stores an encrypted 5-digit US zipcode (00000 - 99999)

  The example requires the following ordered input command line parameters:
    1. DDB table ARN for table to put/query data from
    2. Branch key wrapping KMS key ARN for the KMS key used to create the branch key
    3. Branch key DDB table ARN for the DDB table representing the branch key store
 */

public class BasicSearchableEncryptionExample {

  static String GSI_NAME = "state-zip-index";

  public static void PutItemQueryItemWithBeacon(String ddbTableName, String branchKeyWrappingKmsKeyArn, String branchKeyDdbTableName) {

    // 1. Configure Beacons.
    //    The beacon name must be the name of a table attribute that will be encrypted.
    //    The `length` parameter dictates how many bits are in the beacon attribute value.
    //    The following link provides guidance on choosing a beacon length:
    //    TODO: add link
    List<StandardBeacon> standardBeaconList = new ArrayList<>();

    // The configured DDB table has a GSI on the `aws_dbe_b_state` AttributeName
    // Since this field is assumed to hold a well-distributed US 2-letter state abbreviation
    //   (56 = 50 states + 6 territories),
    //   we follow the guidance in the link above to determine acceptable bounds for beacon length:
    //    - min: log(sqrt(56))/log(2) ~= 2.9, round up to 3
    //    - max: log((56/2))/log(2) ~= 4.8, round up to 5
    // We can safely choose a beacon length between 3 and 5:
    //  - Closer to 3, the underlying data is better obfuscated, but more "false positives" are returned in
    //    queries, leading to more decrypt calls and worse performance
    //  - Closer to 5, fewer "false positives" are returned in queries, leading to fewer decrypt calls and
    //    better performance, but it is easier to distinguish unique plaintext values
    // As an example, we will choose 4.
    // Values stored in aws_dbe_b_state will be 4 bits long (0x0 - 0xf)
    // There will be 2^4 = 16 possible HMAC values.
    // With well-distributed plaintext data (56 values), we expect (56/16) = 3.5 abbrevations sharing the same beacon
    //   value.
    // NOTE: This example assumes that the field values are well-distributed. In practice, this will not be true.
    //       Some flaws in this assumption:
    //        - More populous states would be expected to have more records; those beacons will be overused
    //        - States where a business is not operating would expect no customer records for that state; those
    //          beacons will be underused
    //       This is a streamlined example and should not be used as a basis for determining beacon length
    //       in production. Users should analyze their specific dataset to determine acceptable beacon length bounds.
    StandardBeacon stringBeacon = StandardBeacon.builder()
        .name("state")
        .length(4)
        .build();
    standardBeaconList.add(stringBeacon);

    // The configured DDB table has a GSI on the `aws_dbe_b_zip` AttributeName
    // Since this field holds a well-distributed zipcode (100,000 possible values, of which ~42,000 are valid;
    //   see: https://facts.usps.com/42000-zip-codes/),
    //  we follow the guidance in the link above to determine acceptable bounds for beacon length:
    //    - min: log(sqrt(42,000))/log(2) ~= 7.7, round up to 8
    //    - max: log((42,000/2))/log(2) ~= 14.3, round up to 15
    // We can safely choose a beacon length between 8 and 15:
    //  - Closer to 8, the underlying data is better obfuscated, but more "false positives" are returned in
    //    queries, leading to more decrypt calls and worse performance
    //  - Closer to 15, fewer "false positives" are returned in queries, leading to fewer decrypt calls and
    //    better performance, but it is easier to distinguish unique plaintext values
    // As an example, we will choose 10.
    // Values stored in aws_dbe_b_zip will be 10 bits long (0x000 - 0x3ff).
    // There will be 2^10 = 1024 possible HMAC values.
    // With well-distributed plaintext data (100,000 values), we expect (42,000/1024) ~= 41 zipcodes sharing the same
    //   beacon value.
    StandardBeacon numberBeacon = StandardBeacon.builder()
        .name("zip")
        .length(10)
        .build();
    standardBeaconList.add(numberBeacon);

    // 2. Create Keystore.
    //    The keystore is a separate DDB table where the client stores encryption and decryption materials.
    //    In order to configure beacons on the DDB client, you must configure a keystore.
    //    For more information, see:
    //    TODO: Add link
    KeyStore keyStore = KeyStore.builder()
        .KeyStoreConfig(KeyStoreConfig.builder()
            .kmsClient(KmsClient.create())
            .ddbClient(DynamoDbClient.create())
            .ddbTableName(branchKeyDdbTableName)
            .kmsKeyArn(branchKeyWrappingKmsKeyArn)
            .build())
        .build();

    // 3. Create a branch key.
    //    The branch key stores information required to encrypt and decrypt items on the main table.
    //    This key lives as an item inside the keystore DDB table.
    //    After you create a branch key, you should persist its ID to decrypt items in the table.
    //    For simple use cases, we can configure a 'singleKeySource' which
    //    statically configures a single beaconKey. That is the approach this example takes.
    //    For use cases where you want to use different beacon keys depending on the data
    //    (for example if your table holds data for multiple tenants, and you want to use
    //    a different beacon key per tenant), look into configuring a Multi Beacon Key.
    //    Source: TODO example
    CreateKeyOutput output = keyStore.CreateKey(CreateKeyInput.builder().build());
    String branchKeyId = output.branchKeyIdentifier();

    // 4. Create BeaconVersion.
    //    The BeaconVersion inside the list holds the list of beacons on the table.
    //    The BeaconVersion also stores information about the keystore.
    //    BeaconVersion must be provided:
    //      - keyStore: The keystore configured in step 2
    //      - keySource: A configuration for the key source
    List<BeaconVersion> beaconVersions = new ArrayList<>();
    beaconVersions.add(
        BeaconVersion.builder()
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
    attributeActions.put("partition_key", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActions.put("sort_key", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
    attributeActions.put("state", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("zip", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted

    // 7. Create the DynamoDb Encryption configuration for the table we will be writing to.
    //    The beaconVersions are added to the search configuration.
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig.builder()
        .partitionKeyName("partition_key")
        .sortKeyName("sort_key")
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

    // 10. Put an item into our table using the above client.
    //     Before the item gets sent to DynamoDb, it will be encrypted
    //         client-side, according to our configuration.
    //     Since our configuration includes beacons for `state` and `zip`,
    //         the client will add two additional attributes to the item. These attributes will have names
    //         `aws_dbe_b_state` and `aws_dbe_b_zip`. Their values will be HMACs
    //         truncated to as many bits as the beacon's `length` parameter; e.g.
    //     aws_dbe_b_state = truncate(HMAC("WA"), 4)
    //     aws_dbe_b_zip = truncate(HMAC("98101"), 10)
    final HashMap<String, AttributeValue> item = new HashMap<>();
    item.put("customer_id", AttributeValue.builder().s("ABCD-1234").build());
    item.put("create_time", AttributeValue.builder().n("1681495205").build());
    item.put("state", AttributeValue.builder().s("WA").build());
    item.put("zip", AttributeValue.builder().s("98101").build());

    final PutItemRequest putRequest = PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(item)
        .build();

    final PutItemResponse putResponse = ddb.putItem(putRequest);
    assert 200 == putResponse.sdkHttpResponse().statusCode();

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
    expressionAttributesNames.put("#z", "zip");

    Map<String,AttributeValue> expressionAttributeValues = new HashMap<>();
    expressionAttributeValues.put(":s", AttributeValue.builder().s("WA").build());
    expressionAttributeValues.put(":z", AttributeValue.builder().s("98101").build());

    QueryRequest queryRequest = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName(GSI_NAME)
        .keyConditionExpression("#s = :s and #z = :z")
        .expressionAttributeNames(expressionAttributesNames)
        .expressionAttributeValues(expressionAttributeValues)
        .build();

    final QueryResponse queryResponse = ddb.query(queryRequest);
    List<Map<String, AttributeValue>> attributeValues = queryResponse.items();
    // Validate query was returned successfully
    assert 200 == queryResponse.sdkHttpResponse().statusCode();
    // Validate only 1 item was returned: the item we just put
    assert attributeValues.size() == 1;
    System.out.println(attributeValues);
    final Map<String, AttributeValue> returnedItem = attributeValues.get(0);
    // Validate the item has the expected attributes
    assert returnedItem.get("state").s().equals("WA");
    assert returnedItem.get("zip").s().equals("98101");
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
