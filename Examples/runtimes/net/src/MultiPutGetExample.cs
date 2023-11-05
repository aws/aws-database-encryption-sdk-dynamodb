using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Net;
using System.Threading.Tasks;
using Amazon.DynamoDBv2.Model;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
using AWS.Cryptography.MaterialProviders;
using AttributeValue = Amazon.DynamoDBv2.Model.AttributeValue;
using DeleteRequest = Amazon.DynamoDBv2.Model.DeleteRequest;
using PutRequest = Amazon.DynamoDBv2.Model.PutRequest;
using WriteRequest = Amazon.DynamoDBv2.Model.WriteRequest;

/*
  This example sets up DynamoDb Encryption for the AWS SDK client
  and uses the low level PutItem and GetItem DDB APIs to demonstrate
  putting a client-side encrypted item into DynamoDb
  and then retrieving and decrypting that item from DynamoDb.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (N)
 */
public class MultiPutGetExample
{
    public static async Task MultiPutGet()
    {
        var kmsKeyId = TestUtils.TEST_KMS_KEY_ID;
        var ddbTableName = TestUtils.TEST_DDB_TABLE_NAME;
        // 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
        //    For this example, we will create a AWS KMS Keyring with the AWS KMS Key we want to use.
        //    We will use the `CreateMrkMultiKeyring` method to create this keyring,
        //    as it will correctly handle both single region and Multi-Region KMS Keys.
        var matProv = new MaterialProviders(new MaterialProvidersConfig());
        var keyringInput = new CreateAwsKmsMrkMultiKeyringInput { Generator = kmsKeyId };
        var kmsKeyring = matProv.CreateAwsKmsMrkMultiKeyring(keyringInput);

        // 2. Configure which attributes are encrypted and/or signed when writing new items.
        //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        //    we must explicitly configure how they should be treated during item encryption:
        //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
        //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
        //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
        var attributeActionsOnEncrypt = new Dictionary<string, CryptoAction>
        {
            ["partition_key"] = CryptoAction.SIGN_ONLY, // Our partition attribute must be SIGN_ONLY
            ["sort_key"] = CryptoAction.SIGN_ONLY, // Our sort attribute must be SIGN_ONLY
            ["attribute1"] = CryptoAction.ENCRYPT_AND_SIGN,
            ["attribute2"] = CryptoAction.SIGN_ONLY,
            [":attribute3"] = CryptoAction.DO_NOTHING
        };

        // 3. Configure which attributes we expect to be included in the signature
        //    when reading items. There are two options for configuring this:
        //
        //    - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
        //      When defining your DynamoDb schema and deciding on attribute names,
        //      choose a distinguishing prefix (such as ":") for all attributes that
        //      you do not want to include in the signature.
        //      This has two main benefits:
        //      - It is easier to reason about the security and authenticity of data within your item
        //        when all unauthenticated data is easily distinguishable by their attribute name.
        //      - If you need to add new unauthenticated attributes in the future,
        //        you can easily make the corresponding update to your `attributeActionsOnEncrypt`
        //        and immediately start writing to that new attribute, without
        //        any other configuration update needed.
        //      Once you configure this field, it is not safe to update it.
        //
        //    - Configure `allowedUnsignedAttributes`: You may also explicitly list
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
        const String unsignAttrPrefix = ":";

        // 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
        Dictionary<String, DynamoDbTableEncryptionConfig> tableConfigs =
            new Dictionary<String, DynamoDbTableEncryptionConfig>();
        DynamoDbTableEncryptionConfig config = new DynamoDbTableEncryptionConfig
        {
            LogicalTableName = ddbTableName,
            PartitionKeyName = "partition_key",
            SortKeyName = "sort_key",
            AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
            Keyring = kmsKeyring,
            AllowedUnsignedAttributePrefix = unsignAttrPrefix,
            // Specifying an algorithm suite is not required,
            // but is done here to demonstrate how to do so.
            // We suggest using the
            // `ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384` suite,
            // which includes AES-GCM with key derivation, signing, and key commitment.
            // This is also the default algorithm suite if one is not specified in this config.
            // For more information on supported algorithm suites, see:
            //   https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/supported-algorithms.html
            AlgorithmSuiteId = DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384
        };
        tableConfigs.Add(ddbTableName, config);

        // 5. Create a new AWS SDK DynamoDb client using the TableEncryptionConfigs
        var ddb = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

        // 6. Put an item into our table using the above client.
        //    Before the item gets sent to DynamoDb, it will be encrypted
        //    client-side, according to our configuration.
        var batchWriteItem = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("BatchWriteItemExample"),
            ["sort_key"] = new AttributeValue { N = "0" },
            ["attribute1"] = new AttributeValue("encrypt and sign me!"),
            ["attribute2"] = new AttributeValue("sign me!"),
            [":attribute3"] = new AttributeValue("ignore me!")
        };
        var transactWriteItem = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("TransactWriteItemExample"),
            ["sort_key"] = new AttributeValue { N = "0" },
            ["attribute1"] = new AttributeValue("encrypt and sign me!"),
            ["attribute2"] = new AttributeValue("sign me!"),
            [":attribute3"] = new AttributeValue("ignore me!")
        };
/*
   - [Encrypt before TransactWriteItems](#encrypt-before-transactwriteitems)
   - [Decrypt after TransactGetItem](#decrypt-after-transactgetitem)

   - [Validate before UpdateItem](#validate-before-updateitem)
   - [Validate before DeleteItem](#validate-before-deleteitem)
   - [Validate before ExecuteStatement](#validate-before-executestatement)
   - [Validate before BatchExecuteStatement](#validate-before-batchexecutestatement)
   - [Validate before ExecuteTransaction](#validate-before-executetransaction)

 */
        var batchWriteRequest = new BatchWriteItemRequest
        {
            RequestItems = new Dictionary<string, List<WriteRequest>>
            {
                [ddbTableName] = new List<WriteRequest>
                {
                    new WriteRequest
                    {
                        PutRequest = new PutRequest { Item = batchWriteItem }
                    }
                }
            }
        };

        var batchWriteResponse = await ddb.BatchWriteItemAsync(batchWriteRequest);

        // Demonstrate that BatchWriteItem succeeded
        Debug.Assert(batchWriteResponse.HttpStatusCode == HttpStatusCode.OK);

        var transactWriteRequest = new TransactWriteItemsRequest
        {
            TransactItems = new List<TransactWriteItem>
            {
                new TransactWriteItem
                {
                    Put = new Put
                    {
                        TableName = ddbTableName,
                        Item = transactWriteItem
                    }
                }
            }
        };
        var transactWriteResponse = await ddb.TransactWriteItemsAsync(transactWriteRequest);

        // Demonstrate that TransactWriteItems succeeded
        Debug.Assert(transactWriteResponse.HttpStatusCode == HttpStatusCode.OK);

        // 7. Get the item back from our table using the same client.
        //    The client will decrypt the item client-side, and return
        //    back the original item.
        var keyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("BatchWriteItemExample"),
            ["sort_key"] = new AttributeValue { N = "0" }
        };

        var getRequest = new BatchGetItemRequest
        {
            RequestItems = new Dictionary<string, KeysAndAttributes>
            {
                [ddbTableName] = new KeysAndAttributes
                {
                    Keys = new List<Dictionary<string, AttributeValue>> { keyToGet }
                }
            }
        };

        var getResponse = await ddb.BatchGetItemAsync(getRequest);

        // Demonstrate that GetItem succeeded and returned the decrypted item
        Debug.Assert(getResponse.HttpStatusCode == HttpStatusCode.OK);
        var returnedItem = getResponse.Responses[ddbTableName][0];
        Debug.Assert(returnedItem["attribute1"].S == "encrypt and sign me!");

        var transactKeyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("TransactWriteItemExample"),
            ["sort_key"] = new AttributeValue { N = "0" }
        };

        var transactGetRequest = new TransactGetItemsRequest
        {
            TransactItems = new List<TransactGetItem>
            {
                new TransactGetItem
                {
                    Get = new Get
                    {
                        TableName = ddbTableName,
                        Key = transactKeyToGet
                    }
                }
            }
        };
        var transactGetResponse = await ddb.TransactGetItemsAsync(transactGetRequest);

        // Demonstrate that TransactGetItems succeeded and returned the decrypted item
        Debug.Assert(transactGetResponse.HttpStatusCode == HttpStatusCode.OK);
        var theItem = transactGetResponse.Responses[0].Item;
        Debug.Assert(theItem["attribute1"].S == "encrypt and sign me!");
    }
}