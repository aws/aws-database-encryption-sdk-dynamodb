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
        var ddbEnc = new DynamoDbEncryption(new DynamoDbEncryptionConfig());
        string header_column = "aws_dbe_head";

        // 1. Define keys that will be used to retrieve item from the DynamoDB table.
        var keyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("BasicPutGetExample"),
            ["sort_key"] = new AttributeValue { N = "0" },
        };
        
        // 2. Create a Amazon DynamoDB Client and retrieve item from DynamoDB table
        var ddb = new AmazonDynamoDBClient();
        GetItemRequest getRequest = new GetItemRequest
        {
            Key = keyToGet,
            TableName = ddbTableName,
        };
        GetItemResponse getResponse = await ddb.GetItemAsync(getRequest);

        // Demonstrate that PutItem succeeded
        Debug.Assert(getResponse.HttpStatusCode == HttpStatusCode.OK);

        // 3. Extract the item from the dynamoDB table and prepare input for the GetEncryptedDataKeyDescription method.
        // Here, we are sending header as the input by getting it from "aws_dbe_head" attribute but you can send a complete DDB item as well.
        var returnedItem = getResponse.Item;
        GetEncryptedDataKeyDescriptionUnion InputUnion = new GetEncryptedDataKeyDescriptionUnion();
        InputUnion.Header = returnedItem[header_column].B;
        GetEncryptedDataKeyDescriptionInput Input = new GetEncryptedDataKeyDescriptionInput();
        Input.Input = InputUnion;
        GetEncryptedDataKeyDescriptionOutput output = ddbEnc.GetEncryptedDataKeyDescription(Input);

        // 4. Get encrypted DataKey Descriptions from GetEncryptedDataKeyDescription method output and assert if its true.
        var encryptedDataKeyDescriptions = output.EncryptedDataKeyDescriptionOutput;
        Debug.Assert(encryptedDataKeyDescriptions[0].KeyProviderId == "aws-kms");
        Debug.Assert(encryptedDataKeyDescriptions[0].KeyProviderInfo == kmsKeyId);        
    }
}

