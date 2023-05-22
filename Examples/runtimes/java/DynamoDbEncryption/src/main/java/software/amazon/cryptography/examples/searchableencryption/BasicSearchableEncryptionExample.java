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
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SearchConfig;
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
  This example demonstrates how to set up a beacon on an encrypted attribute,
  put an item with the beacon, and query against that beacon.
  This example follows a use case of a database that stores customer information.

  Running this example requires access to a DDB table  with the
  following primary key configuration:
    - Partition key is named "customer_id" with type (S)
    - Sort key is named "create_time" with type (S)
  This table must have a Global Secondary Index (GSI) configured named "email-birthday-index":
    - Partition key is named "aws_dbe_b_email" with type (S)
    - Sort key is named "aws_dbe_b_birthday" with type (S)

  In this example for storing customer information, this schema is utilized for the data:
   - "customer_id" stores a unique customer identifier
   - "create_time" stores a Unix timestamp
   - "email" stores a valid email address (i.e. prefix@domain)
   - "birthday" stores a birthday in DD/MM/YYYY format

  The example requires the following ordered input command line parameters:
    1. DDB table name for table to put/query data from
    2. Branch key ID for a branch key that was previously created in your key store. See the
       CreateKeyStoreKeyExample.
    3. Branch key wrapping KMS key ARN for the KMS key used to create the branch key with ID
       provided in arg 2
    4. Branch key DDB table name for the DDB table representing the branch key store
 */

public class BasicSearchableEncryptionExample {

  static String GSI_NAME = "email-birthday-index";

  public static void PutItemQueryItemWithBeacon(String ddbTableName, String branchKeyId,
      String branchKeyWrappingKmsKeyArn, String branchKeyDdbTableName) {

    // 1. Configure Beacons.
    //    The beacon name must be the name of a table attribute that will be encrypted.
    //    The `length` parameter dictates how many bits are in the beacon attribute value.
    //    The following link provides guidance on choosing a beacon length:
    //    TODO: add link
    List<StandardBeacon> standardBeaconList = new ArrayList<>();

    // The configured DDB table has a GSI on the `aws_dbe_b_email` AttributeName.
    // This field is assumed to hold a valid email address (prefix@domain).
    // We will also assume that each customer ID corresponds to a single email address.
    // (This is not enforced by our schema, but we assume our writer code enforces this.)
    //
    // To select a beacon length, we must consider how many email addresses we expect
    // to have in our system; from our assumptions above, there will be as many email addresses
    // as there are customer IDs, i.e. one per customer. So the email beacon length
    // should correlate with the number of customers in our database.
    //
    // Let's assume we have 100,000 customers in our database right now, but are growing quickly
    // and expect to double our customer base every year. We would like to select a beacon length
    // that would be safe now and still be safe in ~5 years, when we expect to have 3.2M customers.
    //
    // This link provides guidance for choosing a beacon length:
    //    TODO: add link
    // We follow the guidance in the link above to determine reasonable bounds for beacon length:
    // 100,000 customers:
    //  - min: log(sqrt(100,000))/log(2) ~= 8.3, round down to 8
    //  - max: log((100,000/2))/log(2) ~= 15.6, round up to 16
    // 3,200,000 customers:
    //  - min: log(sqrt(3,200,000))/log(2) ~= 10.8, round up to 11
    //  - max: log((3,200,000/2))/log(2) ~= 20.6, round up to 21
    // You will somehow need to round results to the nearest integer.
    // We choose to round to the nearest number; you might consider a different rounding approach.
    // Rounding up will return fewer expected "false positives" in queries, leading to fewer decrypt calls and
    //    better performance, but it is easier to distinguish unique plaintext values in encrypted data.
    // Rounding down will return more expected "false positives" in queries, leading to more decrypt calls and
    //    worse performance, but it is harder to distinguish unique plaintext values in encrypted data.
    // This suggests we can select a beacon length between 11 and 16 and
    // have desirable security properties at both 100,000 and 3,200,000 customers:
    //  - Closer to 11, we expect more "false positives" to be returned,
    //    making it harder to distinguish plaintext values
    //    but leading to more decrypt calls and worse performance
    //  - Closer to 16, we expect fewer "false positives" returned in queries,
    //    leading to fewer decrypt calls and better performance,
    //    but it is easier to distinguish unique plaintext values
    // As an example, we will choose 15.
    //
    // Values stored in aws_dbe_b_email will be 15 bits long (0x0000 - 0x8fff)
    // There will be 2^15 = 32,768 possible HMAC values.
    // When we have ~100,000 customers, for a particular beacon we expect
    // (100,000/32,768) ~= 3.1 emails
    // sharing that beacon value.
    // When we have ~3,200,000 customers, for a particular beacon we expect
    // (3,200,000/32,768) ~= 97.7 emails
    // sharing that beacon value.
    StandardBeacon emailBeacon = StandardBeacon.builder()
        .name("email")
        .length(15)
        .build();
    standardBeaconList.add(emailBeacon);

    // The configured DDB table has a GSI on the `aws_dbe_b_birthday` AttributeName.
    // This field is assumed to hold birthday represented as a string in DD/MM/YYYY format.
    // We will make some assumptions about the distribution of these strings:
    // - Birthdays will only be between January 1, 1913 (01/01/1913) and January 1, 2023 (01/01/2023).
    //   This implies that there are 40,177 unique possible values for this field.
    // - Birthdays are uniformly distributed across this range.
    //   In practice, this will not be true (we expect very few early birthdays and very few recent
    //   birthdays). A more complex analysis would show that a stricter
    //   upper bound is necessary to hide information from the underlying distribution.
    // With these assumptions, we have a uniformly-distributed dataset of birthdays
    // with 40,177 unique values.
    //
    // This link provides guidance for choosing a beacon length:
    //    TODO: add link
    // We follow the guidance in the link above to determine reasonable bounds for beacon length:
    //  - min: log(sqrt(40,177))/log(2) ~= 7.6, round up to 8
    //  - max: log((40,177/2))/log(2) ~= 14.3, round down to 14
    // We can choose a beacon length between 8 and 14:
    //  - Closer to 8, we expect more "false positives" to be returned,
    //    making it harder to distinguish plaintext values
    //    but leading to more decrypt calls and worse performance
    //  - Closer to 14, we expect fewer "false positives" returned in queries,
    //    leading to fewer decrypt calls and better performance,
    //    but it is easier to distinguish unique plaintext values
    // As an example, we will choose 10.
    //
    // Values stored in aws_dbe_b_birthday will be 10 bits long (0x000 - 0x3ff).
    // There will be 2^10 = 1024 possible HMAC values.
    // With well-distributed birthdays (40,177 values), for a particular beacon we expect
    //   (40,177/1024) ~= 39 birthdays
    //   sharing that beacon value.
    StandardBeacon birthdayBeacon = StandardBeacon.builder()
        .name("birthday")
        .length(10)
        .build();
    standardBeaconList.add(birthdayBeacon);

    // 2. Configure Keystore.
    //    The keystore is a separate DDB table where the client stores encryption and decryption materials.
    //    In order to configure beacons on the DDB client, you must configure a keystore.
    //
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
    //        a different beacon key per tenant), look into configuring a Multi Beacon Key.
    //        Source: TODO example
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

    // 4. Create a Hierarchical Keyring
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

    // 5. Configure which attributes are encrypted and/or signed when writing new items.
    //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    //    we must explicitly configure how they should be treated during item encryption:
    //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    //    Any attributes that will be used in beacons must be configured as ENCRYPT_AND_SIGN.
    final Map<String, CryptoAction> attributeActions = new HashMap<>();
    attributeActions.put("customer_id", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActions.put("create_time", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
    attributeActions.put("email", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("birthday", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted

    // 6. Create the DynamoDb Encryption configuration for the table we will be writing to.
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
    //    Since our configuration includes beacons for `email` and `birthday`,
    //        the client will add two additional attributes to the item. These attributes will have names
    //        `aws_dbe_b_email` and `aws_dbe_b_birthday`. Their values will be HMACs
    //        truncated to as many bits as the beacon's `length` parameter; e.g.
    //    aws_dbe_b_email = truncate(HMAC("able@amazon.com"), 15)
    //    aws_dbe_b_birthday = truncate(HMAC("07/05/1994"), 10)
    final HashMap<String, AttributeValue> item = new HashMap<>();
    item.put("customer_id", AttributeValue.builder().s("ABCD-1234").build());
    item.put("create_time", AttributeValue.builder().n("1681495205").build());
    item.put("email", AttributeValue.builder().s("able@amazon.com").build());
    item.put("birthday", AttributeValue.builder().s("07/05/1994").build());

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
    //     Internally, the client will query for and receive all items with a matching HMAC value in the beacon field.
    //     This may include a number of "false positives" with different ciphertext, but the same truncated HMAC.
    //     e.g. if truncate(HMAC("able@amazon.com"), 15) == truncate(HMAC("bob@amazon.com"), 15),
    //     the query will return both items.
    //     The client will decrypt all returned items to determine which ones have the expected attribute values,
    //         and only surface items with the correct plaintext to the user.
    //     This procedure is internal to the client and is abstracted away from the user;
    //     e.g. the user will only see "able@amazon.com" and never "bob@amazon.com",
    //         though the actual query returned both.
    Map<String,String> expressionAttributesNames = new HashMap<>();
    expressionAttributesNames.put("#email", "email");
    expressionAttributesNames.put("#birthday", "birthday");

    Map<String,AttributeValue> expressionAttributeValues = new HashMap<>();
    expressionAttributeValues.put(":email", AttributeValue.builder().s("able@amazon.com").build());
    expressionAttributeValues.put(":birthday", AttributeValue.builder().s("07/05/1994").build());

    QueryRequest queryRequest = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName(GSI_NAME)
        .keyConditionExpression("#email = :email and #birthday = :birthday")
        .expressionAttributeNames(expressionAttributesNames)
        .expressionAttributeValues(expressionAttributeValues)
        .build();

    final QueryResponse queryResponse = ddb.query(queryRequest);
    List<Map<String, AttributeValue>> attributeValues = queryResponse.items();
    // Validate query was returned successfully
    assert 200 == queryResponse.sdkHttpResponse().statusCode();
    // Validate only 1 item was returned: the item we just put
    assert attributeValues.size() == 1;
    final Map<String, AttributeValue> returnedItem = attributeValues.get(0);
    // Validate the item has the expected attributes
    assert returnedItem.get("email").s().equals("able@amazon.com");
    assert returnedItem.get("birthday").s().equals("07/05/1994");
  }

  public static void main(final String[] args) {
    if (args.length <= 1) {
      throw new IllegalArgumentException("To run this example, include ddbTableName as args[0], "
              + "branchKeyId as args[1], branchKeyWrappingKmsKeyId as args[2], and branchKeyDdbTableName as args[3]");
    }
    final String ddbTableName = args[0];
    final String branchKeyId = args[1];
    final String branchKeyWrappingKmsKeyArn = args[2];
    final String branchKeyDdbTableName = args[3];
    PutItemQueryItemWithBeacon(ddbTableName, branchKeyId, branchKeyWrappingKmsKeyArn, branchKeyDdbTableName);
  }
}
