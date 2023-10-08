
using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.Model;
using System.Threading.Tasks;
using System;
using AWS.Cryptography.DbEncryptionSDK;

namespace Examples
{
  class Program
  {
    // Main method
    static async Task Main(string[] args)
    {
      // AmazonDynamoDBConfig clientConfig = new AmazonDynamoDBConfig();
      // clientConfig.ServiceURL = "http://localhost:8000";
      // AmazonDynamoDBClient dynamoDbClient = new Client.DynamoDbClient(clientConfig, null); 
      await BasicPutGetExample.PutItemGetItem();
    }
  }
}
