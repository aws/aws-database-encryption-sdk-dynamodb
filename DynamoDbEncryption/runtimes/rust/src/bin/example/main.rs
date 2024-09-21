// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

#![deny(warnings, unconditional_panic)]
#![deny(nonstandard_style)]
#![deny(clippy::all)]

pub mod basic_get_put_example;
pub mod create_keystore_key;
pub mod get_encrypted_data_key_description;
pub mod itemencryptor;
pub mod keyring;
pub mod multi_get_put_example;
pub mod searchableencryption;
pub mod test_utils;

#[tokio::main]
pub async fn main() {
    basic_get_put_example::put_item_get_item().await;
    itemencryptor::item_encrypt_decrypt::encrypt_decrypt().await;
    get_encrypted_data_key_description::get_encrypted_data_key_description().await;
    multi_get_put_example::multi_put_get().await;
    keyring::raw_rsa_keyring::put_item_get_item().await;
    keyring::kms_rsa_keyring::put_item_get_item().await;

    let key_id = create_keystore_key::keystore_create_key().await;
    let key_id2 = create_keystore_key::keystore_create_key().await;
    // Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
    // our test fails due to eventual consistency issues.
    println!("Key Store Keys created. Waiting 5 seconds for consistency.\n");
    std::thread::sleep(std::time::Duration::from_secs(5));

    searchableencryption::basic_searchable_encryption::put_and_query_with_beacon(&key_id).await;
    keyring::hierarchical_keyring::put_item_get_item(&key_id, &key_id2).await;
    // // FIXME : ScanError will have to wait until we have a reasonable error message strategy

    /*
    await ClientSupplierExample.ClientSupplierPutItemGetItem();
    await MultiMrkKeyringExample.MultiMrkKeyringGetItemPutItem();
    await RawAesKeyringExample.RawAesKeyringGetItemPutItem();
    await MrkDiscoveryMultiKeyringExample.MultiMrkDiscoveryKeyringGetItemPutItem();
    await MultiKeyringExample.MultiKeyringGetItemPutItem();
    await RawRsaKeyringExample.RawRsaKeyringGetItemPutItem();

    await CompoundBeaconSearchableEncryptionExample.PutItemQueryItemWithCompoundBeacon(keyId);
    await VirtualBeaconSearchableEncryptionExample.PutItemQueryItemWithVirtualBeacon(keyId);
    await BeaconStylesSearchableEncryptionExample.PutItemQueryItemWithBeaconStyles(keyId);
    await ComplexSearchableEncryptionExample.RunExample(keyId);
    */
    println!("All examples completed successfully.\n");
}
