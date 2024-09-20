// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

#![deny(warnings, unconditional_panic)]
#![deny(nonstandard_style)]
#![deny(clippy::all)]

pub mod basic_get_put_example;
pub mod test_utils;
pub mod itemencryptor;
pub mod searchableencryption;
pub mod create_keystore_key;

#[tokio::main]
pub async fn main() {
    basic_get_put_example::put_item_get_item().await;
    itemencryptor::item_encrypt_decrypt::encrypt_decrypt().await;

    let key_id = create_keystore_key::keystore_create_key().await;
    // let key_id2 = create_keystore_key::keystore_create_key().await;
    // Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
    // our test fails due to eventual consistency issues.
    std::thread::sleep(std::time::Duration::from_secs(5));

    searchableencryption::basic_searchable_encryption::put_and_query_with_beacon(&key_id).await;
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


            await HierarchicalKeyringExample.HierarchicalKeyringGetItemPutItem(keyId, keyId2);
            await CompoundBeaconSearchableEncryptionExample.PutItemQueryItemWithCompoundBeacon(keyId);
            await VirtualBeaconSearchableEncryptionExample.PutItemQueryItemWithVirtualBeacon(keyId);
            await BeaconStylesSearchableEncryptionExample.PutItemQueryItemWithBeaconStyles(keyId);
            await ComplexSearchableEncryptionExample.RunExample(keyId);
            Console.Write("All examples completed successfully.\n");
*/
}
