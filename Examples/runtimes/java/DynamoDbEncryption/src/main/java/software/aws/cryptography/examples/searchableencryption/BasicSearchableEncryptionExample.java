package software.aws.cryptography.examples.searchableencryption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dynamoDbEncryption.DynamoDbEncryption;
import software.amazon.cryptography.dynamoDbEncryption.model.BeaconKey;
import software.amazon.cryptography.dynamoDbEncryption.model.BeaconVersion;
import software.amazon.cryptography.dynamoDbEncryption.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.SearchConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.StandardBeacon;
import software.amazon.cryptography.materialProviders.IBranchKeyIdSupplier;
import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialProviders.model.CreateAwsKmsMrkMultiKeyringInput;
import software.amazon.cryptography.materialProviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;
import software.aws.cryptography.dynamoDbEncryption.DynamoDbEncryptionInterceptor;

import java.util.HashMap;
import java.util.Map;

/*
  This example demonstrates how to set up a beacon on an encrypted attribute,
  put an item with the beacon, and query against that beacon.

  Running this example requires access to a DDB table  with the
  following primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
  and the following GSI:
    - Partition key is named "aws_dbe_b_beacon_str_attr" with type (S)
    - Sort key is named "aws_dbe_b_beacon_num_attr" with type (S)

  The example requires the following ordered input command line parameters:
    1. Index name for GSI configured on beacon attributes
    2. DDB table name for table to put/query data from
    3. Branch key ID containing the value of the "branch-key-id" attribute in the branch keystore
       for the key that should be used
    4. Branch key wrapping KMS key ARN for the KMS key used to create the branch key
    5. Branch key DDB table ARN for the DDB table representing the branch key store
 */

public class BasicSearchableEncryptionExample {

  public static void PutItemQueryItemWithBeacon(String gsiName, String ddbTableName, String branchKeyId, String branchKeyWrappingKmsKeyId, String branchKeyDdbTableName) {

    // 1. Create Beacons.
    //    The beacon name must be the name of a table attribute that will be encrypted.
    //    To use the beacon in DDB queries or scans, the table must have an index configured
    //        on the beaconized attribute name: i.e. aws_dbe_b_[beacon_name]
    //    Since the attribute is encrypted, the attribute must have DDB attribute type `binary`.
    //    The beaconized attribute must have DDB attribute type `string`.
    //    The `length` parameter dictates how many bits are in the beacon attribute value.
    List<StandardBeacon> standardBeaconList = new ArrayList<>();
    // The configured DDB table has a GSI on the `aws_dbe_b_beacon_str_attr` AttributeName
    // Values stored in aws_dbe_b_beacon_str_attr will be 4 bits long (0x0 - 0xf)
    StandardBeacon stringBeacon = StandardBeacon.builder()
        .name("beacon_str_attr")
        .length(4)
        .build();
    standardBeaconList.add(stringBeacon);
    // The configured DDB table has a GSI on the `aws_dbe_b_beacon_num_attr` AttributeName
    // Values stored in aws_dbe_b_beacon_num_attr will be 8 bits long (0x00 - 0xff)
    StandardBeacon numberBeacon = StandardBeacon.builder()
        .name("beacon_num_attr")
        .length(8)
        .build();
    standardBeaconList.add(numberBeacon);

    // 2. Create BeaconVersion.
    //    The BeaconVersions list MUST be of length 1; i.e. a list containing a single BeaconVersion.
    //    The BeaconVersion inside the list holds the list of beacons on the table.
    //    The BeaconVersion also stores information about the branch keystore.
    //    The branch keystore is a separate DDB table outlined in:
    //        https://github.com/awslabs/private-aws-encryption-sdk-specification-staging/blob/master/framework/branch-key-store.md
    //    In order to configure beacons on the DDB client, you must configure a branch keystore.
    //    BeaconVersion must be provided:
    //      - branchKeyId: The value contained in the `branch-key-id` attribute in the branch keystore
    //      - keyArn: The ARN of the KMS key used to create the branch key
    //      - tableArn: The ARN of the branch keystore DDB table
    List<BeaconVersion> beaconVersions = new ArrayList<>();
    beaconVersions.add(
        BeaconVersion.builder()
            .standardBeacons(standardBeaconList)
            .version(1) // MUST be 1
            .key(BeaconKey.builder()
                .branchKeyID(branchKeyId)
                .keyArn(branchKeyWrappingKmsKeyId)
                .tableArn(branchKeyDdbTableName)
                .build())
            .build()
    );

    // 3. Create a Hierarchical Keyring
    //    This is a KMS keyring that utilizes the branch keystore.
    final MaterialProviders matProv = MaterialProviders.builder()
        .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
        .build();
    DynamoDbEncryption ddbEnc = DynamoDbEncryption.builder()
        .DynamoDbEncryptionConfig(DynamoDbEncryptionConfig.builder().build())
        .build();
    IBranchKeyIdSupplier branchKeyIdSupplier = ddbEnc.CreateDynamoDbEncryptionBranchKeyIdSupplier(
            CreateDynamoDbEncryptionBranchKeyIdSupplierInput.builder()
                .ddbKeyBranchKeyIdSupplier(new BasicBranchKeyIdSupplier(branchKeyId))
                .build())
        .branchKeyIdSupplier();
    CreateAwsKmsHierarchicalKeyringInput keyringInput = CreateAwsKmsHierarchicalKeyringInput.builder()
        .kmsKeyId(branchKeyWrappingKmsKeyId)
        .kmsClient(KmsClient.create())
        .branchKeyIdSupplier(branchKeyIdSupplier)
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
    attributeActions.put("partition_key", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActions.put("sort_key", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
    attributeActions.put("beacon_str_attr", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("beacon_num_attr", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted

    // 5. Configure which attributes we expect to be included in the signature
    //    when reading items. There are two options for configuring this:
    //
    //    - (Recommended) Configure `allowedUnauthenticatedAttributesPrefix`:
    //      When defining your DynamoDb schema and deciding on attribute names,
    //      choose a distinguishing prefix (such as ":") for all attributes that
    //      you do not want to include in the signature.
    //      This has two main benefits:
    //      - It is easier to reason about the security and authenticity of data within your item
    //        when all unauthenticated data is easily distinguishable by their attribute name.
    //      - If you need to add new unauthenticated attributes in the future,
    //        you can easily make the corresponding update to your `attributeActions`
    //        and immediately start writing to that new attribute, without
    //        any other configuration update needed.
    //      Once you configure this field, it is not safe to update it.
    //
    //    - Configure `allowedUnauthenticatedAttributes`: You may also explicitly list
    //      a set of attributes that should be considered unauthenticated when encountered
    //      on read. Be careful if you use this configuration. Do not remove an attribute
    //      name from this configuration, even if you are no longer writing with that attribute,
    //      as old items may still include this attribute, and our configuration needs to know
    //      to continue to exclude this attribute from the signature scope.
    //      If you add new attribute names to this field, you must first deploy the update to this
    //      field to all readers in your host fleet before deploying the update to start writing
    //      with that new attribute.
    //
    //   For this example, we have designed our DynamoDb table such that any attribute name with
    //   the ":" prefix should be considered unauthenticated.
    final String unauthAttrPrefix = ":";

    // 6. Create the DynamoDb Encryption configuration for the table we will be writing to.
    //    The beaconVersions are added to the search configuration.
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig.builder()
        .partitionKeyName("partition_key")
        .sortKeyName("sort_key")
        .attributeActions(attributeActions)
        .keyring(kmsKeyring)
        .allowedUnauthenticatedAttributePrefix(unauthAttrPrefix)
        .search(SearchConfig.builder()
            .writeVersion(1) // MUST be 1
            .versions(beaconVersions)
            .build())
        .build();
    tableConfigs.put(ddbTableName, config);

    // 7. Create the DynamoDb Encryption Interceptor
    DynamoDbEncryptionInterceptor encryptionInterceptor = DynamoDbEncryptionInterceptor.builder()
        .config(DynamoDbTablesEncryptionConfig.builder()
            .tableEncryptionConfigs(tableConfigs)
            .build())
        .build();

    // 8. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient.builder()
        .overrideConfiguration(
            ClientOverrideConfiguration.builder()
                .addExecutionInterceptor(encryptionInterceptor)
                .build())
        .build();

    // 9. Put an item into our table using the above client.
    //    Before the item gets sent to DynamoDb, it will be encrypted
    //        client-side, according to our configuration.
    //    Since our configuration includes beacons for `beacon_str_attr` and `beacon_num_attr`,
    //        the client will add two additional attributes to the item. These attributes will have names
    //        `aws_dbe_b_beacon_str_attr` and `aws_dbe_b_beacon_num_attr`. Their values will be HMACs
    //        truncated to the beacon's `length` parameter.
    final HashMap<String, AttributeValue> item = new HashMap<>();
    item.put("partition_key", AttributeValue.builder().s("PutItemWithBeaconExample").build());
    item.put("sort_key", AttributeValue.builder().n("34").build());
    item.put("beacon_str_attr", AttributeValue.builder().s("encrypt, sign, and beaconize me!").build());
    item.put("beacon_num_attr", AttributeValue.builder().n("42").build());

    final PutItemRequest putRequest = PutItemRequest.builder()
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
    //     The client will receive the item with a matching HMAC value, then decrypt the encrypted field
    //         to validate the encrypted value matches the plaintext value.
    Map<String,String> expressionAttributesNames = new HashMap<>();
    expressionAttributesNames.put("#s", "beacon_str_attr");

    Map<String,AttributeValue> expressionAttributeValues = new HashMap<>();
    expressionAttributeValues.put(":v", AttributeValue.builder().s("encrypt, sign, and beaconize me!").build());

    QueryRequest queryRequest = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName(gsiName)
        .keyConditionExpression("#s = :v")
        .expressionAttributeNames(expressionAttributesNames)
        .expressionAttributeValues(expressionAttributeValues)
        .build();

    final QueryResponse queryResponse = ddb.query(queryRequest);
    List<Map<String, AttributeValue>> attributeValues = queryResponse.items();
    assert 200 == queryResponse.sdkHttpResponse().statusCode();

    assert attributeValues.size() == 1;
    final Map<String, AttributeValue> returnedItem = attributeValues.get(0);
    assert returnedItem.get("beacon_str_attr").s().equals("encrypt, sign, and beaconize me!");
  }

  public static void main(final String[] args) {
    if (args.length != 5) {
      throw new IllegalArgumentException("To run this example, kmsKeyId as args[0], ddbTableName as args[1], branchKeyId as args[2], branchKeyWrappingKmsKeyId as args[3], and branchKeyDdbTableName as args[4]");
    }
    final String gsiName = args[0];
    final String ddbTableName = args[1];
    final String branchKeyId = args[2];
    final String branchKeyWrappingKmsKeyId = args[3];
    final String branchKeyDdbTableName = args[4];
    PutItemQueryItemWithBeacon(gsiName, ddbTableName, branchKeyId, branchKeyWrappingKmsKeyId, branchKeyDdbTableName);
  }
}
