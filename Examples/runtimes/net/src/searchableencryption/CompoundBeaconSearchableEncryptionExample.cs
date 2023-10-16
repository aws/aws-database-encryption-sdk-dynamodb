using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Net;
using System.Threading;
using System.Threading.Tasks;
using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.Model;
using Amazon.KeyManagementService;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
using AWS.Cryptography.KeyStore;
using AWS.Cryptography.MaterialProviders;


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

public class CompoundBeaconSearchableEncryptionExample
{
    static String GSI_NAME = "last4UnitCompound-index";

    public static async Task PutItemQueryItemWithCompoundBeacon(String branchKeyId)
    {
        String ddbTableName = TestUtils.UNIT_INSPECTION_TEST_DDB_TABLE_NAME;
        String branchKeyWrappingKmsKeyArn = TestUtils.TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN;
        String branchKeyDdbTableName = TestUtils.TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME;

        // 1. Create Beacons.
        //    These are the same beacons as in the "BasicSearchableEncryptionExample" in this directory.
        //    See that file to see details on beacon construction and parameters.
        //    While we will not directly query against these beacons,
        //      you must create standard beacons on encrypted fields
        //      that we wish to use in compound beacons.
        var standardBeaconList = new List<StandardBeacon>();
        StandardBeacon last4Beacon = new StandardBeacon
        {
            Name = "inspector_id_last4",
            Length = 10
        };
        standardBeaconList.Add(last4Beacon);
        StandardBeacon unitBeacon = new StandardBeacon
        {
            Name = "unit",
            Length = 30
        };
        standardBeaconList.Add(unitBeacon);

        // 2. Define encrypted parts.
        //    Encrypted parts define the beacons that can be used to construct a compound beacon,
        //        and how the compound beacon prefixes those beacon values.
        var encryptedPartList = new List<EncryptedPart>();
        // A encrypted part must receive:
        //  - name: Name of a standard beacon
        //  - prefix: Any string. This is plaintext that prefixes the beaconized value in the compound beacon.
        //            Prefixes must be unique across the configuration, and must not be a prefix of another prefix;
        //            i.e. for all configured prefixes, the first N characters of a prefix must not equal another prefix.
        // In practice, it is suggested to have a short value distinguishable from other parts served on the prefix.
        // For this example, we will choose "L-" as the prefix for "Last 4 digits of inspector ID".
        // With this prefix and the standard beacon's bit length definition (10), the beaconized
        //     version of the inspector ID's last 4 digits will appear as
        //     `L-000` to `L-3ff` inside a compound beacon.
        var last4EncryptedPart = new EncryptedPart
        {
            Name = "inspector_id_last4",
            Prefix = "L-"
        };
        encryptedPartList.Add(last4EncryptedPart);

        // For this example, we will choose "U-" as the prefix for "unit".
        // With this prefix and the standard beacon's bit length definition (30), a unit beacon will appear
        //     as `U-00000000` to `U-3fffffff` inside a compound beacon.
        var unitEncryptedPart = new EncryptedPart
        {
            Name = "unit",
            Prefix = "U-"
        };
        encryptedPartList.Add(unitEncryptedPart);

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
        var compoundBeaconList = new List<CompoundBeacon>();
        var last4UnitCompoundBeacon = new CompoundBeacon
        {
            Name = "last4UnitCompound",
            Split = ".",
            Encrypted = encryptedPartList
        };
        compoundBeaconList.Add(last4UnitCompoundBeacon);

        // 4. Configure the Keystore
        //    These are the same constructions as in the Basic example, which describes these in more detail.
        var keyStore = new KeyStore(new KeyStoreConfig
        {
            KmsClient = new AmazonKeyManagementServiceClient(),
            DdbClient = new AmazonDynamoDBClient(),
            DdbTableName = branchKeyDdbTableName,
            LogicalKeyStoreName = branchKeyDdbTableName,
            KmsConfiguration = new KMSConfiguration { KmsKeyArn = branchKeyWrappingKmsKeyArn }
        });

        // 5. Create BeaconVersion.
        //    This is similar to the Basic example, except we have also provided a compoundBeaconList.
        //    We must also continue to provide all of the standard beacons that compose a compound beacon list.
        var beaconVersions = new List<BeaconVersion>();
        beaconVersions.Add(new BeaconVersion
        {
            StandardBeacons = standardBeaconList,
            CompoundBeacons = compoundBeaconList,
            Version = 1, // MUST be 1
            KeyStore = keyStore,
            KeySource = new BeaconKeySource
            {
                Single = new SingleKeyStore
                {
                    KeyId = branchKeyId,
                    CacheTTL = 6000
                }
            }
        });

        // 6. Create a Hierarchical Keyring
        //    This is the same configuration as in the Basic example.
        var matProv = new MaterialProviders(new MaterialProvidersConfig());
        var keyringInput = new CreateAwsKmsHierarchicalKeyringInput
        {
            BranchKeyId = branchKeyId,
            KeyStore = keyStore,
            TtlSeconds = 6000L
        };
        var kmsKeyring = matProv.CreateAwsKmsHierarchicalKeyring(keyringInput);

        // 7. Configure which attributes are encrypted and/or signed when writing new items.
        var attributeActionsOnEncrypt = new Dictionary<String, CryptoAction>();
        attributeActionsOnEncrypt.Add("work_id",
            CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
        attributeActionsOnEncrypt.Add("inspection_date",
            CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
        attributeActionsOnEncrypt.Add("inspector_id_last4",
            CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
        attributeActionsOnEncrypt.Add("unit",
            CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted

        // We do not need to define a crypto action on last4UnitCompound.
        // We only need to define crypto actions on attributes that we pass to PutItem.

        // 8. Create the DynamoDb Encryption configuration for the table we will be writing to.
        //    The beaconVersions are added to the search configuration.
        var tableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>();
        var config = new DynamoDbTableEncryptionConfig
        {
            LogicalTableName = ddbTableName,
            PartitionKeyName = "work_id",
            SortKeyName = "inspection_date",
            AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
            Keyring = kmsKeyring,
            Search = new SearchConfig
            {
                WriteVersion = 1, // MUST be 1
                Versions = beaconVersions
            }
        };
        tableConfigs.Add(ddbTableName, config);

        // 9. Create config
        var encryptionConfig =
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs };

        // 10. Create an item with both attributes used in the compound beacon.
        var item = new Dictionary<String, AttributeValue>();
        item.Add("work_id", new AttributeValue("9ce39272-8068-4efd-a211-cd162ad65d4c"));
        item.Add("inspection_date", new AttributeValue("2023-06-13"));
        item.Add("inspector_id_last4", new AttributeValue("5678"));
        item.Add("unit", new AttributeValue("011899988199"));

        // 11. If developing or debugging, verify config by checking compound beacon values directly
        var trans = new DynamoDbEncryptionTransforms(encryptionConfig);
        var resolveInput = new ResolveAttributesInput
        {
            TableName = ddbTableName,
            Item = item,
            Version = 1
        };
        var resolveOutput = trans.ResolveAttributes(resolveInput);

        // VirtualFields is empty because we have no Virtual Fields configured
        Debug.Assert(resolveOutput.VirtualFields.Count == 0);

        // Verify that CompoundBeacons has the expected value
        Debug.Assert(resolveOutput.CompoundBeacons.Count == 1);
        Debug.Assert(resolveOutput.CompoundBeacons["last4UnitCompound"] == "L-5678.U-011899988199");
        // Note : the compound beacon actually stored in the table is not "L-5678.U-011899988199"
        // but rather something like "L-abc.U-123", as both parts are EncryptedParts
        // and therefore the text is replaced by the associated beacon

        // 12. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
        var ddb = new Client.DynamoDbClient(trans);

        // 13. Write the item to the table
        var putRequest = new PutItemRequest
        {
            TableName = ddbTableName,
            Item = item
        };

        var putResponse = await ddb.PutItemAsync(putRequest);
        // Validate object put successfully
        Debug.Assert(putResponse.HttpStatusCode == HttpStatusCode.OK);

        // 15. Query for the item we just put.
        var expressionAttributesNames = new Dictionary<String, String>();
        expressionAttributesNames.Add("#compound", "last4UnitCompound");

        var expressionAttributeValues = new Dictionary<String, AttributeValue>();
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
        expressionAttributeValues.Add(":value", new AttributeValue("L-5678.U-011899988199"));

        var queryRequest = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = GSI_NAME,
            KeyConditionExpression = "#compound = :value",
            ExpressionAttributeNames = expressionAttributesNames,
            ExpressionAttributeValues = expressionAttributeValues
        };

        // GSIs are sometimes a little bit delayed, so we retry if the query comes up empty.
        for (int i = 0; i < 10; ++i)
        {
            var queryResponse = await ddb.QueryAsync(queryRequest);
            // Validate query was returned successfully
            Debug.Assert(queryResponse.HttpStatusCode == HttpStatusCode.OK);
            var attributeValues = queryResponse.Items;

            // if no results, sleep and try again
            if (attributeValues.Count == 0)
            {
                Thread.Sleep(20);
                continue;
            }

            // Validate only 1 item was returned: the item we just put
            Debug.Assert(attributeValues.Count == 1);
            var returnedItem = attributeValues[0];
            // Validate the item has the expected attributes
            Debug.Assert(returnedItem["inspector_id_last4"].S.Equals("5678"));
            Debug.Assert(returnedItem["unit"].S.Equals("011899988199"));
            break;
        }
    }
}