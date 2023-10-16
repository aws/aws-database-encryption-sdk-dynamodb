using System;
using System.Threading;
using System.Threading.Tasks;

namespace Examples
{
    class Program
    {
        // Main method
        static async Task Main(string[] args)
        {
            ItemEncryptDecryptExample.PutItemGetItem();

            await BasicPutGetExample.PutItemGetItem();
           // await ClientSupplierExample.ClientSupplierPutItemGetItem();

            var keyId = CreateKeyStoreKeyExample.KeyStoreCreateKey();
            var keyId2 = CreateKeyStoreKeyExample.KeyStoreCreateKey();
            // Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
            // our test fails due to eventual consistency issues.
            Thread.Sleep(5000);

            await HierarchicalKeyringExample.HierarchicalKeyringGetItemPutItem(keyId, keyId2);
            await MultiMrkKeyringExample.MultiMrkKeyringGetItemPutItem();
            await RawAesKeyringExample.RawAesKeyringGetItemPutItem();
            await MrkDiscoveryMultiKeyringExample.MultiMrkDiscoveryKeyringGetItemPutItem();
            
            await BasicSearchableEncryptionExample.PutItemQueryItemWithBeacon(keyId);
            await CompoundBeaconSearchableEncryptionExample.PutItemQueryItemWithCompoundBeacon(keyId);
            await VirtualBeaconSearchableEncryptionExample.PutItemQueryItemWithVirtualBeacon(keyId);
            await BeaconStylesSearchableEncryptionExample.PutItemQueryItemWithBeaconStyles(keyId);
            Console.Write("All examples completed successfully.\n");
        }
    }
}