
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
      await BasicPutGetExample.PutItemGetItem();
      Console.Write("All examples completed successfully.\n");
    }
  }
}
