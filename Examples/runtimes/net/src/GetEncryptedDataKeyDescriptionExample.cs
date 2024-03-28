using System;
using System.Diagnostics;
using System.Net;
using System.Threading.Tasks;
using System.Collections.Generic;
using Amazon.DynamoDBv2.Model;
using Amazon.DynamoDBv2;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;

public class GetEncryptedDataKeyDescriptionExample
{
    public static async Task GetEncryptedDataKeyDescription()
    {
        var kmsKeyId = TestUtils.TEST_KMS_KEY_ID;
        var ddbTableName = TestUtils.TEST_DDB_TABLE_NAME;

        var region = Amazon.RegionEndpoint.GetBySystemName("us-east-1");

        var ddbEnc = new DynamoDbEncryption(new DynamoDbEncryptionConfig());

        string header_column = "aws_dbe_head";

        var keyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("BasicPutGetExample"),
            ["sort_key"] = new AttributeValue { N = "0" },
        };
        
        // 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
        Dictionary<String, DynamoDbTableEncryptionConfig> tableConfigs =
            new Dictionary<String, DynamoDbTableEncryptionConfig>();
        DynamoDbTableEncryptionConfig config = new DynamoDbTableEncryptionConfig
        {
            LogicalTableName = ddbTableName,
            PartitionKeyName = "partition_key",
            SortKeyName = "sort_key",
        };
        tableConfigs.Add(ddbTableName, config);
        
        // 5. Create a new AWS SDK DynamoDb client using the TableEncryptionConfigs
        var ddb = new AmazonDynamoDBClient();

        GetItemRequest getRequest = new GetItemRequest
        {
            Key = keyToGet,
            TableName = ddbTableName,
        };

        GetItemResponse getResponse = await ddb.GetItemAsync(getRequest);

        Debug.Assert(getResponse.HttpStatusCode == HttpStatusCode.OK);
        var returnedItem = getResponse.Item;
        
        GetEncryptedDataKeyDescriptionUnion InputUnion = new GetEncryptedDataKeyDescriptionUnion();

        InputUnion.Header = returnedItem[header_column].B;

        GetEncryptedDataKeyDescriptionInput Input = new GetEncryptedDataKeyDescriptionInput();

        Input.Input = InputUnion;

        GetEncryptedDataKeyDescriptionOutput output = ddbEnc.GetEncryptedDataKeyDescription(Input);

        var encryptedDataKeyDescriptions = output.EncryptedDataKeyDescriptionOutput;

        Debug.Assert(encryptedDataKeyDescriptions[0].KeyProviderId == "aws-kms");
        Debug.Assert(encryptedDataKeyDescriptions[0].KeyProviderId == kmsKeyId);        
    }
}

