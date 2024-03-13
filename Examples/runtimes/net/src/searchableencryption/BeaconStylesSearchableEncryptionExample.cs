using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Net;
using System.Threading.Tasks;
using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.Model;
using Amazon.KeyManagementService;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
using AWS.Cryptography.KeyStore;
using AWS.Cryptography.MaterialProviders;

/*
  This example demonstrates how to use Beacons Styles on Standard Beacons on encrypted attributes,
      put an item with the beacon, and query against that beacon.
  This example follows a use case of a database that stores food information.
      This is an extension of the "BasicSearchableEncryptionExample" in this directory
      and uses the same table schema.

  Running this example requires access to a DDB table with the
  following key configuration:
    - Partition key is named "work_id" with type (S)
    - Sort key is named "inspection_time" with type (S)

  In this example for storing food information, this schema is utilized for the data:
   - "work_id" stores a unique identifier for a unit inspection work order (v4 UUID)
   - "inspection_date" stores an ISO 8601 date for the inspection (YYYY-MM-DD)
   - "fruit" stores one type of fruit
   - "basket" stores a set of types of fruit
   - "dessert" stores one type of dessert
   - "veggies" stores a set of types of vegetable
   - "work_type" stores a unit inspection category

  The example requires the following ordered input command line parameters:
    1. DDB table name for table to put/query data from
    2. Branch key ID for a branch key that was previously created in your key store. See the
       CreateKeyStoreKeyExample.
    3. Branch key wrapping KMS key ARN for the KMS key used to create the branch key with ID
       provided in arg 2
    4. Branch key DDB table ARN for the DDB table representing the branch key store
 */

public class BeaconStylesSearchableEncryptionExample
{
    public static async Task PutItemQueryItemWithBeaconStyles(String branchKeyId)
    {
        String ddbTableName = TestUtils.UNIT_INSPECTION_TEST_DDB_TABLE_NAME;
        String branchKeyWrappingKmsKeyArn = TestUtils.TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN;
        String branchKeyDdbTableName = TestUtils.TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME;

        // 1. Create Beacons.
        var standardBeaconList = new List<StandardBeacon>
        {
            // The fruit beacon allows searching on the encrypted fruit attribute
            // We have selected 30 as an example beacon length, but you should go to
            // https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
            // when creating your beacons.
            new StandardBeacon
            {
                Name = "fruit",
                Length = 30
            },

            // The basket beacon allows searching on the encrypted basket attribute
            // Basket is used as a Set, and therefore needs a beacon style to reflect that.
            // Further, we need to be able to compare the items in basket to the fruit attribute
            // so we `share` this beacon with `fruit`.
            // Since we need both of these things, we use the SharedSet style.
            new StandardBeacon
            {
                Name = "basket",
                Length = 30,
                Style = new BeaconStyle
                {
                    SharedSet = new SharedSet { Other = "fruit" }
                }
            },

            // The dessert beacon allows searching on the encrypted dessert attribute
            // We need to be able to compare the dessert attribute to the fruit attribute
            // so we `share` this beacon with `fruit`.
            new StandardBeacon
            {
                Name = "dessert",
                Length = 30,
                Style = new BeaconStyle
                {
                    Shared = new Shared { Other = "fruit" }
                }
            },

            // The veggieBeacon allows searching on the encrypted veggies attribute
            // veggies is used as a Set, and therefore needs a beacon style to reflect that.
            new StandardBeacon
            {
                Name = "veggies",
                Length = 30,
                Style = new BeaconStyle
                {
                    AsSet = new AsSet()
                }
            },

            // The work_typeBeacon allows searching on the encrypted work_type attribute
            // We only use it as part of the compound work_unit beacon, 
            // so we disable its use as a standalone beacon
            new StandardBeacon
            {
                Name = "work_type",
                Length = 30,
                Style = new BeaconStyle
                {
                    PartOnly = new PartOnly()
                }
            }
        };

        // Here we build a compound beacon from work_id and work_type
        // If we had tried to make a StandardBeacon from work_type, we would have seen an error
        // because work_type is "PartOnly"
        var encryptedPartList = new List<EncryptedPart>
        {
            new EncryptedPart {
            Name = "work_type",
            Prefix = "T-"
            }
        };

        var signedPartList = new List<SignedPart> {
            new SignedPart {
                Name = "work_id",
                Prefix = "I-"
            }
        };

        var compoundBeaconList = new List<CompoundBeacon>
        {
            new CompoundBeacon  {
                Name = "work_unit",
                Split = ".",
                Encrypted = encryptedPartList,
                Signed = signedPartList
            }
        };

        // 2. Configure the Keystore
        //    These are the same constructions as in the Basic example, which describes these in more detail.
        var keyStore = new KeyStore(new KeyStoreConfig
        {
            KmsClient = new AmazonKeyManagementServiceClient(),
            DdbClient = new AmazonDynamoDBClient(),
            DdbTableName = branchKeyDdbTableName,
            LogicalKeyStoreName = branchKeyDdbTableName,
            KmsConfiguration = new KMSConfiguration { KmsKeyArn = branchKeyWrappingKmsKeyArn }
        });

        // 3. Create BeaconVersion.
        //    This is similar to the Basic example
        var beaconVersions = new List<BeaconVersion>
        {
            new BeaconVersion
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
            }
        };

        // 4. Create a Hierarchical Keyring
        //    This is the same configuration as in the Basic example.
        var matProv = new MaterialProviders(new MaterialProvidersConfig());
        var keyringInput = new CreateAwsKmsHierarchicalKeyringInput
        {
            BranchKeyId = branchKeyId,
            KeyStore = keyStore,
            TtlSeconds = 6000L
        };
        var kmsKeyring = matProv.CreateAwsKmsHierarchicalKeyring(keyringInput);

        // 5. Configure which attributes are encrypted and/or signed when writing new items.
        var attributeActionsOnEncrypt = new Dictionary<String, CryptoAction>
        {
            ["work_id"] = CryptoAction.SIGN_ONLY, // Our partition attribute must be SIGN_ONLY
            ["inspection_date"] = CryptoAction.SIGN_ONLY, // Our sort attribute must be SIGN_ONLY
            ["dessert"] = CryptoAction.ENCRYPT_AND_SIGN, // Beaconized attributes must be encrypted
            ["fruit"] = CryptoAction.ENCRYPT_AND_SIGN, // Beaconized attributes must be encrypted
            ["basket"] = CryptoAction.ENCRYPT_AND_SIGN, // Beaconized attributes must be encrypted
            ["veggies"] = CryptoAction.ENCRYPT_AND_SIGN, // Beaconized attributes must be encrypted
            ["work_type"] = CryptoAction.ENCRYPT_AND_SIGN // Beaconized attributes must be encrypted
        };

        // 6. Create the DynamoDb Encryption configuration for the table we will be writing to.
        //    The beaconVersions are added to the search configuration.
        var tableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
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
            }
        };

        // 7. Create config
        var encryptionConfig = new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs };

        // 8. Create item one, specifically with "dessert != fruit", and "fruit in basket".
        var item1 = new Dictionary<String, AttributeValue>
        {
            ["work_id"] = new AttributeValue("1"),
            ["inspection_date"] = new AttributeValue("2023-06-13"),
            ["dessert"] = new AttributeValue("cake"),
            ["fruit"] = new AttributeValue("banana"),
            ["basket"] = new AttributeValue { SS = new List<String> { "banana", "apple", "pear" } },
            ["veggies"] = new AttributeValue { SS = new List<String> { "beans", "carrots", "celery" } },
            ["work_type"] = new AttributeValue("small")
        };

        // 9. Create item two, specifically with "dessert == fruit", and "fruit not in basket".
        var item2 = new Dictionary<String, AttributeValue>
        {
            ["work_id"] = new AttributeValue("2"),
            ["inspection_date"] = new AttributeValue("2023-06-13"),
            ["dessert"] = new AttributeValue("orange"),
            ["fruit"] = new AttributeValue("orange"),
            ["basket"] = new AttributeValue { SS = new List<String> { "strawberry", "blueberry", "blackberry" } },
            ["veggies"] = new AttributeValue { SS = new List<String> { "beans", "carrots", "peas" } },
            ["work_type"] = new AttributeValue("large")
        };

        // 10. Create a new AWS SDK DynamoDb client using the DynamoDb Config above
        var ddb = new Client.DynamoDbClient(encryptionConfig);

        // 11. Add the two items
        var putRequest = new PutItemRequest
        {
            TableName = ddbTableName,
            Item = item1
        };

        var putResponse = await ddb.PutItemAsync(putRequest);
        // Validate object put successfully
        Debug.Assert(putResponse.HttpStatusCode == HttpStatusCode.OK);

        putRequest = new PutItemRequest
        {
            TableName = ddbTableName,
            Item = item2
        };

        putResponse = await ddb.PutItemAsync(putRequest);
        // Validate object put successfully
        Debug.Assert(putResponse.HttpStatusCode == HttpStatusCode.OK);

        // 12. Test the first type of Set operation :
        // Select records where the basket attribute holds a particular value
        var expressionAttributeValues = new Dictionary<String, AttributeValue>
        {
            [":value"] = new AttributeValue("banana")
        };

        var scanRequest = new ScanRequest
        {
            TableName = ddbTableName,
            FilterExpression = "contains(basket, :value)",
            ExpressionAttributeValues = expressionAttributeValues
        };

        var scanResponse = await ddb.ScanAsync(scanRequest);
        // Validate query was returned successfully
        Debug.Assert(scanResponse.HttpStatusCode == HttpStatusCode.OK);

        // Validate only 1 item was returned: item1
        Debug.Assert(scanResponse.Items.Count == 1);
        Debug.Assert(scanResponse.Items[0]["work_id"].S == item1["work_id"].S);

        // 14. Test the second type of Set operation :
        // Select records where the basket attribute holds the fruit attribute
        scanRequest = new ScanRequest
        {
            TableName = ddbTableName,
            FilterExpression = "contains(basket, fruit)"
        };

        scanResponse = await ddb.ScanAsync(scanRequest);
        // Validate query was returned successfully
        Debug.Assert(scanResponse.HttpStatusCode == HttpStatusCode.OK);

        // Validate only 1 item was returned: item1
        Debug.Assert(scanResponse.Items.Count == 1);
        Debug.Assert(scanResponse.Items[0]["work_id"].S == item1["work_id"].S);

        // 15. Test the third type of Set operation :
        // Select records where the fruit attribute exists in a particular set
        var basket3 = new List<String> { "boysenberry", "orange", "grape" };
        expressionAttributeValues[":value"] = new AttributeValue { SS = basket3 };

        scanRequest = new ScanRequest
        {
            TableName = ddbTableName,
            FilterExpression = "contains(:value, fruit)",
            ExpressionAttributeValues = expressionAttributeValues
        };


        scanResponse = await ddb.ScanAsync(scanRequest);

        // Validate query was returned successfully
        Debug.Assert(scanResponse.HttpStatusCode == HttpStatusCode.OK);

        // Validate only 1 item was returned: item2
        Debug.Assert(scanResponse.Items.Count == 1);
        Debug.Assert(scanResponse.Items[0]["work_id"].S == item2["work_id"].S);

        // Test a Shared search. Select records where the dessert attribute matches the fruit attribute
        scanRequest = new ScanRequest
        {
            TableName = ddbTableName,
            FilterExpression = "dessert = fruit"
        };

        scanResponse = await ddb.ScanAsync(scanRequest);

        // Validate query was returned successfully
        Debug.Assert(scanResponse.HttpStatusCode == HttpStatusCode.OK);

        // Validate only 1 item was returned: item2
        Debug.Assert(scanResponse.Items.Count == 1);
        Debug.Assert(scanResponse.Items[0]["work_id"].S == item2["work_id"].S);


        // 16. Test the AsSet attribute 'veggies' :
        // Select records where the veggies attribute holds a particular value
        expressionAttributeValues[":value"] = new AttributeValue { S = "peas" };

        scanRequest = new ScanRequest
        {
            TableName = ddbTableName,
            FilterExpression = "contains(veggies, :value)",
            ExpressionAttributeValues = expressionAttributeValues
        };

        scanResponse = await ddb.ScanAsync(scanRequest);
        // Validate query was returned successfully
        Debug.Assert(scanResponse.HttpStatusCode == HttpStatusCode.OK);

        // Validate only 1 item was returned: item1
        Debug.Assert(scanResponse.Items.Count == 1);
        Debug.Assert(scanResponse.Items[0]["work_id"].S == item2["work_id"].S);

        // 17. Test the compound beacon 'work_unit' :
        expressionAttributeValues[":value"] = new AttributeValue { S = "I-1.T-small" };

        scanRequest = new ScanRequest
        {
            TableName = ddbTableName,
            FilterExpression = "work_unit = :value",
            ExpressionAttributeValues = expressionAttributeValues
        };

        scanResponse = await ddb.ScanAsync(scanRequest);
        // Validate query was returned successfully
        Debug.Assert(scanResponse.HttpStatusCode == HttpStatusCode.OK);

        // Validate only 1 item was returned: item1
        Debug.Assert(scanResponse.Items.Count == 1);
        Debug.Assert(scanResponse.Items[0]["work_id"].S == item1["work_id"].S);

    }
}
