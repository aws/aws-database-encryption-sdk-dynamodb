
using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.Model;
using System.Threading.Tasks;
using System;
using System.Threading;
using AWS.Cryptography.DbEncryptionSDK;

namespace Examples
{
  class Program
  {
    // Main method
    static async Task Main(string[] args)
    {
      await BasicPutGetExample.PutItemGetItem();
      var keyId = CreateKeyStoreKeyExample.KeyStoreCreateKey();
      Thread.Sleep(5000);
      await BasicSearchableEncryptionExample.PutItemQueryItemWithBeacon(keyId);
      await CompoundBeaconSearchableEncryptionExample.PutItemQueryItemWithCompoundBeacon(keyId);
      await VirtualBeaconSearchableEncryptionExample.PutItemQueryItemWithVirtualBeacon(keyId);
      Console.Write("All examples completed successfully.\n");
    }
  }
}
