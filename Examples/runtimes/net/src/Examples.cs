using System;
using System.Threading;
using System.Threading.Tasks;
using Examples.keyring;

namespace Examples
{
    class Program
    {
        // Main method
        static async Task Main()
        {
            ItemEncryptDecryptExample.PutItemGetItem();

            await BasicPutGetExample.PutItemGetItem();
            await ScanErrorExample.ScanError();
            await GetEncryptedDataKeyDescriptionExample.GetEncryptedDataKeyDescription();
            await MultiPutGetExample.MultiPutGet();
            await ClientSupplierExample.ClientSupplierPutItemGetItem();
            await MultiMrkKeyringExample.MultiMrkKeyringGetItemPutItem();
            await RawAesKeyringExample.RawAesKeyringGetItemPutItem();
            await MrkDiscoveryMultiKeyringExample.MultiMrkDiscoveryKeyringGetItemPutItem();
            await MultiKeyringExample.MultiKeyringGetItemPutItem();
            await RawRsaKeyringExample.RawRsaKeyringGetItemPutItem();
            await KmsRsaKeyringExample.KmsRsaKeyringGetItemPutItem();
            await RawEcdhKeyringExample.RawEcdhKeyringExamples();
            await KmsEcdhKeyringExample.KmsEcdhKeyringExamples();

            var keyId = CreateKeyStoreKeyExample.KeyStoreCreateKey();
            var keyId2 = CreateKeyStoreKeyExample.KeyStoreCreateKey();
            // Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
            // our test fails due to eventual consistency issues.
            Thread.Sleep(5000);

            await HierarchicalKeyringExample.HierarchicalKeyringGetItemPutItem(keyId, keyId2);
            await SharedCacheAcrossHierarchicalKeyringsExample.SharedCacheAcrossHierarchicalKeyringsGetItemPutItem(keyId);

            await BasicSearchableEncryptionExample.PutItemQueryItemWithBeacon(keyId);
            await CompoundBeaconSearchableEncryptionExample.PutItemQueryItemWithCompoundBeacon(keyId);
            await VirtualBeaconSearchableEncryptionExample.PutItemQueryItemWithVirtualBeacon(keyId);
            await BeaconStylesSearchableEncryptionExample.PutItemQueryItemWithBeaconStyles(keyId);
            await ComplexSearchableEncryptionExample.RunExample(keyId);
            Console.Write("All examples completed successfully.\n");
        }
    }
}