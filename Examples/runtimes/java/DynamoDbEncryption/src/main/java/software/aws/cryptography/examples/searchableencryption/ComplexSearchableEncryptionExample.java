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
import software.amazon.cryptography.dynamoDbEncryption.DynamoDbEncryption;
import software.amazon.cryptography.dynamoDbEncryption.model.BeaconKey;
import software.amazon.cryptography.dynamoDbEncryption.model.BeaconVersion;
import software.amazon.cryptography.dynamoDbEncryption.model.CompoundBeacon;
import software.amazon.cryptography.dynamoDbEncryption.model.Constructor;
import software.amazon.cryptography.dynamoDbEncryption.model.ConstructorPart;
import software.amazon.cryptography.dynamoDbEncryption.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.SearchConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.SensitivePart;
import software.amazon.cryptography.dynamoDbEncryption.model.StandardBeacon;
import software.amazon.cryptography.materialProviders.IBranchKeyIdSupplier;
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
    - Partition key is named "aws_dbe_b_beacon_str_attr" with type (S)
    - Sort key is named "aws_dbe_b_beacon_num_attr" with type (S)

  In this example for storing customer location data, this schema is utilized for the data:
   - "partition_key" stores a unique customer identifier
   - "sort_key" stores a Unix timestamp
   - "beacon_str_attr" stores an encrypted 2-letter US state or territory abbreviation
         (https://www.faa.gov/air_traffic/publications/atpubs/cnt_html/appendix_a.html)
   - "beacon_num_attr" stores an encrypted 5-digit US zipcode (00000 - 99999)

  The example requires the following ordered input command line parameters:
    1. Index name for GSI configured on beacon attributes
    2. DDB table name for table to put/query data from
    3. Branch key ID containing the value of the "branch-key-id" attribute in the branch keystore
       for the key that should be used
    4. Branch key wrapping KMS key ARN for the KMS key used to create the branch key
    5. Branch key DDB table ARN for the DDB table representing the branch key store
 */

public class ComplexSearchableEncryptionExample {

  static String GSI_NAME = "aws_dbe_b_Ownership-index";

  public static void PutItemQueryItemWithBeacon(String ddbTableName, String branchKeyId, String branchKeyWrappingKmsKeyId, String branchKeyDdbTableName) {

    // 1. Create standard beacons.
    //    A compound beacon must be constructed from standard beacons.
    //    The standard beacon name must be the name of a table attribute that will be encrypted.
    //    The `length` parameter dictates how many bits are in the beacon attribute value.
    //    The following link provides guidance on choosing a beacon length:
    //    TODO: add link
    List<StandardBeacon> standardBeaconList = new ArrayList<>();
    // We will create a standard beacon on the requester ID attribute.
    // As an example, let's assume there are 10^9 possible requester IDs.
    // Follow the guidance in the link above to determine acceptable bounds for beacon length:
    //    - min: log(sqrt(10^9))/log(2) ~= 14.95, round up to 15
    //    - max: log((10^9/2))/log(2) ~= 28.90, round up to 29
    // We can safely choose a beacon length between 15 and 29:
    //  - Closer to 15, the underlying data is better obfuscated,
    //    but more "false positives" are returned in queries
    //  - Closer to 29, fewer "false positives" are returned in queries,
    //    but it is easier to distinguish unique plaintext values
    // As an example, we will choose 20.
    // Values stored in aws_dbe_b_RequesterID will be 20 bits long (0x00000 - 0xfffff).
    // There will be 2^20 possible HMAC values.
    // With well-distributed plaintext data (10^9 values), we expect (10^9/2^20)
    //  ~= 953.7 IDs sharing the same beacon value.
    StandardBeacon employeeIdBeacon = StandardBeacon.builder()
        .name("AssigneeID")
        .length(20)
        .build();
    standardBeaconList.add(employeeIdBeacon);

    StandardBeacon roomIdBeacon = StandardBeacon.builder()
        .name("RequesterID")
        .length(12)
        .build();
    standardBeaconList.add(roomIdBeacon);

    // 1. Create compound beacon.
    //    A compound beacon must be constructed from standard beacons.
    //    The compound beacon uses the length of the
    List<CompoundBeacon> compoundBeaconList = new ArrayList<>();


    List<ConstructorPart> constructorPartList = new ArrayList<>();
    // A constructor part must receive:
    //  - name: Name of a standard beacon
    //  - required: Whether this attribute must be present in the item
    // For EmployeeID constructor: Since we are serving two types of records from this table,
    //     EmployeeID will not be present in every item. So it is not required.
    ConstructorPart constructorPartEmployee = ConstructorPart.builder()
        .name("AssigneeID")
        .required(false)
        .build();
    constructorPartList.add(constructorPartEmployee);
    // RoomID is also not required for the same reason.
    ConstructorPart constructorPartRoom = ConstructorPart.builder()
        .name("RequesterID")
        .required(true)
        .build();
    constructorPartList.add(constructorPartRoom);

    List<Constructor> constructorList = new ArrayList<>();
    Constructor constructor = Constructor.builder()
        .parts(constructorPartList)
        .build();
    constructorList.add(constructor);

    // 3. Define sensitive parts.
    List<SensitivePart> sensitivePartList = new ArrayList<>();
    // A sensitive part must receive:
    //  - name: Name of a standard beacon
    //  - prefix: Any string. This is plaintext that prefixes the beaconized value in the compound beacon.
    //            Prefixes must not be a prefix of another prefix;
    //            i.e. for all configured prefixes, the first N characters of a prefix must not equal another prefix.
    // In practice, it is suggested to have a short value distinguishable from other parts served on the prefix.
    // For this example, we will choose "E-" as the prefix for "EmployeeID".
    SensitivePart sensitivePartEmployee = SensitivePart.builder()
        .name("AssigneeID")
        .prefix("A-")
        .build();
    sensitivePartList.add(sensitivePartEmployee);
    // For this example, we will choose "E-" as the prefix for "RoomID".
    SensitivePart sensitivePartRoom = SensitivePart.builder()
        .name("RequesterID")
        .prefix("R-")
        .build();
    sensitivePartList.add(sensitivePartRoom);

    // 4. Define compound beacon.
    // A compound beacon must receive:
    //  - name: The name of the beacon. Compound beacon values will be written to `aws_ddb_e_[name]`.
    //  - split: A character separating parts in a compound beacon
    //  - sensitive: A list of sensitive parts. This is effectively a list of beacons.
    // A compound beacon may also receive:
    //  - constructors: A list of constructors. This is an ordered list of possible ways to create a beacon.
    //    We have defined our constructor above. If we had not done this, a default construtor would be provided,
    //        whose details are defined in TODO: Add link
    //  - nonSensitive: A list of non-sensitive parts, i.e. plaintext values. This would be provided if we
    //        wanted to use plaintext values as part of constructing our compound beacon.
    CompoundBeacon cpbeacon1 = CompoundBeacon.builder()
        .name("Ownership")
        .split(".")
        .sensitive(sensitivePartList)
        .constructors(constructorList)
        .build();

    compoundBeaconList.add(cpbeacon1);

    // 2. Create BeaconVersion.
    //    The BeaconVersion inside the list holds the list of beacons on the table.
    //    The BeaconVersion also stores information about the branch keystore.
    //    The branch keystore is a separate DDB table that stores encryption and decryption information. See:
    //    TODO: Add link
    //    In order to configure beacons on the DDB client, you must configure a branch keystore.
    //    BeaconVersion must be provided:
    //      - branchKeyId: The value contained in the `branch-key-id` attribute in the branch keystore
    //      - keyArn: The ARN of the KMS key used to create the branch key
    //      - tableArn: The ARN of the branch keystore DDB table
    List<BeaconVersion> beaconVersions = new ArrayList<>();
    beaconVersions.add(
        BeaconVersion.builder()
            .standardBeacons(standardBeaconList)
            .compoundBeacons(compoundBeaconList)
            .version(1) // MUST be 1
            .key(BeaconKey.builder()
                .branchKeyID(branchKeyId)
                .keyArn(branchKeyWrappingKmsKeyId)
                .tableArn(branchKeyDdbTableName)
                .build())
            .build()
    );

    // 3. Create a Hierarchical Keyring
    //    This is a KMS keyring that utilizes the branch keystore table.
    //    This config defines how items are encrypted and decrypted.
    //    NOTE: You should configure this to use the same keystore as your search config.
    final MaterialProviders matProv = MaterialProviders.builder()
        .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
        .build();
    DynamoDbEncryption ddbEnc = DynamoDbEncryption.builder()
        .DynamoDbEncryptionConfig(DynamoDbEncryptionConfig.builder().build())
        .build();
    CreateAwsKmsHierarchicalKeyringInput keyringInput = CreateAwsKmsHierarchicalKeyringInput.builder()
        .kmsKeyId(branchKeyWrappingKmsKeyId)
        .kmsClient(KmsClient.create())
        .branchKeyId(branchKeyId)
        .branchKeyStoreArn(branchKeyDdbTableName)
        .ddbClient(DynamoDbClient.create())
        .ttlSeconds(6000l)
        .maxCacheSize(100)
        .build();
    final IKeyring kmsKeyring = matProv.CreateAwsKmsHierarchicalKeyring(keyringInput);

    // 4. Configure which attributes are encrypted and/or signed when writing new items.
    //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    //    we must explicitly configure how they should be treated during item encryption:
    //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    //    Any attributes that will be used in beacons must be configured as ENCRYPT_AND_SIGN.
    final Map<String, CryptoAction> attributeActions = new HashMap<>();
    attributeActions.put("CaseID", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActions.put("AssigneeID", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("RequesterID", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("Ownership", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted

    // 5. Create the DynamoDb Encryption configuration for the table we will be writing to.
    //    The beaconVersions are added to the search configuration.
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig.builder()
        .partitionKeyName("CaseID")
        .attributeActions(attributeActions)
        .keyring(kmsKeyring)
        .search(SearchConfig.builder()
            .writeVersion(1) // MUST be 1
            .versions(beaconVersions)
            .build())
        .build();
    tableConfigs.put(ddbTableName, config);

    // 6. Create the DynamoDb Encryption Interceptor
    DynamoDbEncryptionInterceptor encryptionInterceptor = DynamoDbEncryptionInterceptor.builder()
        .config(DynamoDbTablesEncryptionConfig.builder()
            .tableEncryptionConfigs(tableConfigs)
            .build())
        .build();

    // 7. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient.builder()
        .overrideConfiguration(
            ClientOverrideConfiguration.builder()
                .addExecutionInterceptor(encryptionInterceptor)
                .build())
        .build();

    // 8. Put an item into our table using the above client.
    //    Before the item gets sent to DynamoDb, it will be encrypted
    //        client-side, according to our configuration.
    //    Since our configuration includes beacons for `beacon_str_attr` and `beacon_num_attr`,
    //        the client will add two additional attributes to the item. These attributes will have names
    //        `aws_dbe_b_beacon_str_attr` and `aws_dbe_b_beacon_num_attr`. Their values will be HMACs
    //        truncated to the beacon's `length` parameter; e.g.
    //    aws_dbe_b_beacon_str_attr = truncate(HMAC("WA"), 4)
    //    aws_dbe_b_beacon_num_attr = truncate(HMAC("98101"), 10)
    final HashMap<String, AttributeValue> item1 = new HashMap<>();
    item1.put("CaseID", AttributeValue.builder().s("Case-1").build());
    item1.put("AssigneeID", AttributeValue.builder().s("assignee-abcde-1234").build());
    item1.put("RequesterID", AttributeValue.builder().s("requester-xyz-789").build());

    final PutItemRequest putRequest = PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(item1)
        .build();

    final PutItemResponse putResponse = ddb.putItem(putRequest);
    assert 200 == putResponse.sdkHttpResponse().statusCode();

    final HashMap<String, AttributeValue> item2 = new HashMap<>();
    item2.put("CaseID", AttributeValue.builder().s("Case-2").build());
    item2.put("AssigneeID", AttributeValue.builder().s("assignee-abcde-1234").build());

    final PutItemRequest putRequest2 = PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(item2)
        .build();

    final PutItemResponse putResponse2 = ddb.putItem(putRequest2);
    assert 200 == putResponse2.sdkHttpResponse().statusCode();

    final HashMap<String, AttributeValue> item3 = new HashMap<>();
    item3.put("CaseID", AttributeValue.builder().s("Case-3").build());
    item3.put("RequesterID", AttributeValue.builder().s("requester-abc-123").build());

    final PutItemRequest putRequest3 = PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(item3)
        .build();

    final PutItemResponse putResponse3 = ddb.putItem(putRequest3);
    assert 200 == putResponse3.sdkHttpResponse().statusCode();

    //  9. Query for the item we just put.
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
//    Map<String,String> expressionAttributesNames = new HashMap<>();
//    expressionAttributesNames.put("#a", "EmployeeID");
//    expressionAttributesNames.put("#b", "RoomID");
//    expressionAttributesNames.put("#e", "Hash");
//
//    Map<String,AttributeValue> expressionAttributeValues = new HashMap<>();
//    expressionAttributeValues.put(":c", AttributeValue.builder().s("WA").build());
//    expressionAttributeValues.put(":d", AttributeValue.builder().s("98101").build());
//
//    QueryRequest queryRequest = QueryRequest.builder()
//        .tableName(ddbTableName)
//        .indexName(GSI_NAME)
//        .keyConditionExpression("#e = :v or ")
//        .expressionAttributeNames(expressionAttributesNames)
//        .expressionAttributeValues(expressionAttributeValues)
//        .build();
//
//    final QueryResponse queryResponse = ddb.query(queryRequest);
//    List<Map<String, AttributeValue>> attributeValues = queryResponse.items();
//    // Validate query was returned successfully
//    assert 200 == queryResponse.sdkHttpResponse().statusCode();
//    // Validate only 1 item was returned: the item we just put
//    assert attributeValues.size() == 1;
//    System.out.println(attributeValues);
//    final Map<String, AttributeValue> returnedItem = attributeValues.get(0);
//    // Validate the item has the expected attributes
//    assert returnedItem.get("beacon_str_attr").s().equals("WA");
//    assert returnedItem.get("beacon_num_attr").n().equals("98101");
  }

  public static void main(final String[] args) {
    if (args.length != 4) {
      throw new IllegalArgumentException("To run this example, include ddbTableName as args[0], branchKeyId as args[1], branchKeyWrappingKmsKeyId as args[2], and branchKeyDdbTableName as args[3]");
    }
    final String ddbTableName = args[0];
    final String branchKeyId = args[1];
    final String branchKeyWrappingKmsKeyId = args[2];
    final String branchKeyDdbTableName = args[3];
    PutItemQueryItemWithBeacon(ddbTableName, branchKeyId, branchKeyWrappingKmsKeyId, branchKeyDdbTableName);
  }
}
