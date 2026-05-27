package software.amazon.cryptography.examples.searchableencryption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
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
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconStyle;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconVersion;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CompoundBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Constructor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.ConstructorPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.EncryptedPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PartOnly;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SearchConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SingleKeyStore;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.StandardBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.DynamoDbEncryptionTransforms;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ResolveAttributesInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ResolveAttributesOutput;
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
  This example demonstrates how to set up a compound beacon on encrypted attributes,
      put an item with the beacon, and query against that beacon.
  This example follows a use case of a database that stores unit inspection information.
      This is an extension of the "BasicSearchableEncryptionExample" in this directory.
      This example uses the same situation (storing unit inspection information)
      and the same table schema.
  However, this example uses a different Global Secondary Index (GSI)
      that is based on a compound beacon configuration composed of
      the `last4` and `unit` attributes.

  Running this example requires access to a DDB table with the
  following key configuration:
    - Partition key is named "work_id" with type (S)
    - Sort key is named "inspection_time" with type (S)
  This table must have a Global Secondary Index (GSI) configured named "last4UnitCompound-index":
    - Partition key is named "aws_dbe_b_last4UnitCompound" with type (S)

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
    4. Branch key DDB table ARN for the DDB table representing the branch key store
 */

public class CompoundBeaconSearchableEncryptionExample {

  static String GSI_NAME = "last4UnitCompound-index";
  static int MAX_CONCURRENT_QUERY_THREADS = 10;

  public static void PutItemQueryItemWithCompoundBeacon(
    String ddbTableName,
    String branchKeyId,
    String branchKeyWrappingKmsKeyArn,
    String branchKeyDdbTableName
  ) {
    // 1. Create Beacons.
    //    These are the same beacons as in the "BasicSearchableEncryptionExample" in this directory.
    //    See that file to see details on beacon construction and parameters.
    //    While we will not directly query against these beacons,
    //      you must create standard beacons on encrypted fields
    //      that we wish to use in compound beacons.
    //    We mark them both as PartOnly to enforce the fact that
    //      we will not directly query against these beacons.
    List<StandardBeacon> standardBeaconList = Arrays.asList(
      StandardBeacon
        .builder()
        .name("inspector_id_last4")
        .length(10)
        .style(
          BeaconStyle.builder().partOnly(PartOnly.builder().build()).build()
        )
        .build(),
      StandardBeacon
        .builder()
        .name("unit")
        .length(30)
        .style(
          BeaconStyle.builder().partOnly(PartOnly.builder().build()).build()
        )
        .build()
    );

    // 2. Define encrypted parts.
    //    Encrypted parts define the beacons that can be used to construct a compound beacon,
    //        and how the compound beacon prefixes those beacon values.
    // A encrypted part must receive:
    //  - name: Name of a standard beacon
    //  - prefix: Any string. This is plaintext that prefixes the beaconized value in the compound beacon.
    //            Prefixes must be unique across the configuration, and must not be a prefix of another prefix;
    //            i.e. for all configured prefixes, the first N characters of a prefix must not equal another prefix.
    // In practice, it is suggested to have a short value distinguishable from other parts served on the prefix.

    List<EncryptedPart> encryptedPartList = Arrays.asList(
      // For this example, we will choose "L-" as the prefix for "Last 4 digits of inspector ID".
      // With this prefix and the standard beacon's bit length definition (10), the beaconized
      //     version of the inspector ID's last 4 digits will appear as
      //     `L-000` to `L-3ff` inside a compound beacon.
      EncryptedPart.builder().name("inspector_id_last4").prefix("L-").build(),
      // For this example, we will choose "U-" as the prefix for "unit".
      // With this prefix and the standard beacon's bit length definition (30), a unit beacon will appear
      //     as `U-00000000` to `U-3fffffff` inside a compound beacon.
      EncryptedPart.builder().name("unit").prefix("U-").build()
    );

    List<ConstructorPart> constructorParts = Arrays.asList(
      ConstructorPart
        .builder()
        .name("inspector_id_last4")
        .required(true)
        .build(),
      ConstructorPart
        .builder()
        // This name comes from the "EmployeeID" standard beacon.
        .name("unit")
        .required(true)
        .build()
    );
    List<Constructor> constructors = Arrays.asList(
      Constructor.builder().parts(constructorParts).build()
    );

    // 3. Define compound beacon.
    //    A compound beacon allows one to serve multiple beacons or attributes from a single index.
    //    A compound beacon must receive:
    //     - name: The name of the beacon. Compound beacon values will be written to `aws_ddb_e_[name]`.
    //     - split: A character separating parts in a compound beacon
    //    A compound beacon may also receive:
    //     - encrypted: A list of encrypted parts. This is effectively a list of beacons. We provide the list
    //                  that we created above.
    //     - constructors: A list of constructors. This is an ordered list of possible ways to create a beacon.
    //                     We have not defined any constructors here; see the complex example for how to do this.
    //                     The client will provide a default constructor, which will write a compound beacon as:
    //                     all signed parts in the order they are added to the signed list;
    //                     all encrypted parts in order they are added to the encrypted list; all parts required.
    //                     In this example, we expect compound beacons to be written as
    //                     `L-XXX.U-YYYYYYYY`, since our encrypted list looks like
    //                     [last4EncryptedPart, unitEncryptedPart].
    //     - signed: A list of signed parts, i.e. plaintext attributes. This would be provided if we
    //                     wanted to use plaintext values as part of constructing our compound beacon. We do not
    //                     provide this here; see the Complex example for an example.
    List<CompoundBeacon> compoundBeaconList = Arrays.asList(
      CompoundBeacon
        .builder()
        .name("last4UnitCompound")
        .constructors(constructors)
        .split(".")
        .build()
    );

    // 4. Configure the Keystore
    //    These are the same constructions as in the Basic example, which describes these in more detail.
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

    // 5. Create BeaconVersion.
    //    This is similar to the Basic example, except we have also provided a compoundBeaconList.
    //    We must also continue to provide all of the standard beacons that compose a compound beacon list.
    List<BeaconVersion> beaconVersions = Arrays.asList(
      BeaconVersion
        .builder()
        .encryptedParts(encryptedPartList)
        .standardBeacons(standardBeaconList)
        .compoundBeacons(compoundBeaconList)
        .version(1) // MUST be 1
        .keyStore(keyStore)
        .keySource(
          BeaconKeySource
            .builder()
            .single(
              SingleKeyStore.builder().keyId(branchKeyId).cacheTTL(6000).build()
            )
            .build()
        )
        .build()
    );

    // 6. Create a Hierarchical Keyring
    //    This is the same configuration as in the Basic example.
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

    // 7. Configure which attributes are encrypted and/or signed when writing new items.
    final Map<String, CryptoAction> attributeActionsOnEncrypt = new HashMap<>();
    attributeActionsOnEncrypt.put("work_id", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put("inspection_date", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put(
      "inspector_id_last4",
      CryptoAction.ENCRYPT_AND_SIGN
    ); // Beaconized attributes must be encrypted
    attributeActionsOnEncrypt.put("unit", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted

    // We do not need to define a crypto action on last4UnitCompound.
    // We only need to define crypto actions on attributes that we pass to PutItem.

    // 8. Create the DynamoDb Encryption configuration for the table we will be writing to.
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

    // 9. Create config
    final DynamoDbTablesEncryptionConfig encryptionConfig =
      DynamoDbTablesEncryptionConfig
        .builder()
        .tableEncryptionConfigs(tableConfigs)
        .build();

    // 10. Create an item with both attributes used in the compound beacon.
    final HashMap<String, AttributeValue> item = new HashMap<>();
    item.put(
      "work_id",
      AttributeValue.builder().s("9ce39272-8068-4efd-a211-cd162ad65d4c").build()
    );
    item.put(
      "inspection_date",
      AttributeValue.builder().s("2023-06-13").build()
    );
    item.put("inspector_id_last4", AttributeValue.builder().s("5678").build());
    item.put("unit", AttributeValue.builder().s("011899988199").build());

    // 11. If developing or debugging, verify config by checking compound beacon values directly
    final DynamoDbEncryptionTransforms trans = DynamoDbEncryptionTransforms
      .builder()
      .DynamoDbTablesEncryptionConfig(encryptionConfig)
      .build();

    final ResolveAttributesInput resolveInput = ResolveAttributesInput
      .builder()
      .TableName(ddbTableName)
      .Item(item)
      .Version(1)
      .build();

    final ResolveAttributesOutput resolveOutput = trans.ResolveAttributes(
      resolveInput
    );

    // VirtualFields is empty because we have no Virtual Fields configured
    assert resolveOutput.VirtualFields().isEmpty();

    // Verify that CompoundBeacons has the expected value
    Map<String, String> cbs = new HashMap<>();
    cbs.put("last4UnitCompound", "L-5678.U-011899988199");
    assert resolveOutput.CompoundBeacons().equals(cbs);
    // Note : the compound beacon actually stored in the table is not "L-5678.U-011899988199"
    // but rather something like "L-abc.U-123", as both parts are EncryptedParts
    // and therefore the text is replaced by the associated beacon

    // 12. Create the DynamoDb Encryption Interceptor
    DynamoDbEncryptionInterceptor encryptionInterceptor =
      DynamoDbEncryptionInterceptor.builder().config(encryptionConfig).build();

    // 13. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(encryptionInterceptor)
          .build()
      )
      .build();

    PutAndQueryItemWithCompoundBeacon(ddb, ddbTableName, item);

    // If instead you were working in a multi-threaded context
    // it might look like this
    Runnable myThread = () -> {
      for (int i = 0; i < 20; ++i) {
        PutAndQueryItemWithCompoundBeacon(ddb, ddbTableName, item);
      }
    };
    ExecutorService pool = Executors.newFixedThreadPool(
      MAX_CONCURRENT_QUERY_THREADS
    );
    for (int i = 0; i < (2 * MAX_CONCURRENT_QUERY_THREADS); i++) {
      pool.execute(myThread);
    }
    pool.shutdown();
    try {
      pool.awaitTermination(30, TimeUnit.SECONDS);
    } catch (Exception e) {}
  }

  public static void PutAndQueryItemWithCompoundBeacon(
    DynamoDbClient ddb,
    String ddbTableName,
    HashMap<String, AttributeValue> item
  ) {
    // 14. Write the item to the table
    final PutItemRequest putRequest = PutItemRequest
      .builder()
      .tableName(ddbTableName)
      .item(item)
      .build();

    final PutItemResponse putResponse = ddb.putItem(putRequest);
    // Validate object put successfully
    assert 200 == putResponse.sdkHttpResponse().statusCode();

    // 15. Query for the item we just put.
    Map<String, String> expressionAttributesNames = new HashMap<>();
    expressionAttributesNames.put("#compound", "last4UnitCompound");

    Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
    // This query expression takes a few factors into consideration:
    //  - The configured prefix for the last 4 digits of an inspector ID is "L-";
    //    the prefix for the unit is "U-"
    //  - The configured split character, separating component parts, is "."
    //  - The default constructor adds encrypted parts in the order they are in the encrypted list, which
    //    configures `last4` to come before `unit``
    // NOTE: We did not need to create a compound beacon for this query. This query could have also been
    //       done by querying on the partition and sort key, as was done in the Basic example.
    //       This is intended to be a simple example to demonstrate how one might set up a compound beacon.
    //       For examples where compound beacons are required, see the Complex example.
    //       The most basic extension to this example that would require a compound beacon would add a third
    //       part to the compound beacon, then query against three parts.
    expressionAttributeValues.put(
      ":value",
      AttributeValue.builder().s("L-5678.U-011899988199").build()
    );

    QueryRequest queryRequest = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName(GSI_NAME)
      .keyConditionExpression("#compound = :value")
      .expressionAttributeNames(expressionAttributesNames)
      .expressionAttributeValues(expressionAttributeValues)
      .build();

    // GSIs do not update instantly
    // so if the results come back empty
    // we retry after a short sleep
    for (int i = 0; i < 10; ++i) {
      QueryResponse queryResponse = ddb.query(queryRequest);
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
      Map<String, AttributeValue> returnedItem = attributeValues.get(0);
      // Validate the item has the expected attributes
      assert returnedItem.get("inspector_id_last4").s().equals("5678");
      assert returnedItem.get("unit").s().equals("011899988199");
      break;
    }
  }

  public static void main(final String[] args) {
    if (args.length <= 1) {
      throw new IllegalArgumentException(
        "To run this example, include ddbTableName as args[0], branchKeyId as args[1], " +
        "branchKeyWrappingKmsKeyId as args[2], and branchKeyDdbTableName as args[3]"
      );
    }
    final String ddbTableName = args[0];
    final String branchKeyId = args[1];
    final String branchKeyWrappingKmsKeyId = args[2];
    final String branchKeyDdbTableName = args[3];
    PutItemQueryItemWithCompoundBeacon(
      ddbTableName,
      branchKeyId,
      branchKeyWrappingKmsKeyId,
      branchKeyDdbTableName
    );
  }
}
