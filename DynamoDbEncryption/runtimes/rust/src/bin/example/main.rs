
pub mod basic_get_put_example;
pub mod test_utils;
pub mod itemencryptor;
pub mod searchableencryption;

#[tokio::main]
pub async fn main() {
    basic_get_put_example::put_item_get_item().await;
    itemencryptor::item_encrypt_decrypt::encrypt_decrypt().await;
    /*

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

            var keyId = CreateKeyStoreKeyExample.KeyStoreCreateKey();
            var keyId2 = CreateKeyStoreKeyExample.KeyStoreCreateKey();
            // Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
            // our test fails due to eventual consistency issues.
            Thread.Sleep(5000);

            await HierarchicalKeyringExample.HierarchicalKeyringGetItemPutItem(keyId, keyId2);

            await BasicSearchableEncryptionExample.PutItemQueryItemWithBeacon(keyId);
            await CompoundBeaconSearchableEncryptionExample.PutItemQueryItemWithCompoundBeacon(keyId);
            await VirtualBeaconSearchableEncryptionExample.PutItemQueryItemWithVirtualBeacon(keyId);
            await BeaconStylesSearchableEncryptionExample.PutItemQueryItemWithBeaconStyles(keyId);
            await ComplexSearchableEncryptionExample.RunExample(keyId);
            Console.Write("All examples completed successfully.\n");
*/
}
