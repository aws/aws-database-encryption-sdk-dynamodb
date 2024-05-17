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

        // Demonstrate that GetItem succeeded
        Debug.Assert(getResponse.HttpStatusCode == HttpStatusCode.OK);

        // 3. Extract the item from the dynamoDB table and prepare input for the GetEncryptedDataKeyDescription method.
        // Here, we are sending dynamodb item but you can also input the header itself by extracting the header from 
        // "aws_dbe_head" attribute in the dynamoDB item. The part of the code where we send input as the header is commented.
        var returnedItem = getResponse.Item;
        GetEncryptedDataKeyDescriptionUnion InputUnion = new GetEncryptedDataKeyDescriptionUnion();
        InputUnion.Item = returnedItem;

        // The code below shows how we can send header as the input to the DynamoDB. This code is written to demo the 
        // alternative approach. So, it is commented.

        // string header_attribute = "aws_dbe_head";
        // InputUnion.Header = returnedItem[header_attribute].B;

        GetEncryptedDataKeyDescriptionInput Input = new GetEncryptedDataKeyDescriptionInput();
        Input.Input = InputUnion;
        GetEncryptedDataKeyDescriptionOutput output = ddbEnc.GetEncryptedDataKeyDescription(Input);

        // 4. Get encrypted DataKey Descriptions from GetEncryptedDataKeyDescription method output and assert if its true.
        var encryptedDataKeyDescriptions = output.EncryptedDataKeyDescriptionOutput;
        Debug.Assert(encryptedDataKeyDescriptions[0].KeyProviderId == "aws-kms");
        Debug.Assert(encryptedDataKeyDescriptions[0].KeyProviderInfo == kmsKeyId);
    }
}

