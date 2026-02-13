// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

#![deny(warnings, unconditional_panic)]
#![deny(nonstandard_style)]
#![deny(clippy::all)]

pub mod basic_get_put_example;
pub mod clientsupplier;
pub mod create_keystore_key;
pub mod get_encrypted_data_key_description;
pub mod itemencryptor;
pub mod keyring;
pub mod migration;
pub mod multi_get_put_example;
pub mod searchableencryption;
pub mod test_utils;

use std::convert::From;

// Why two types?
// return type from main must impl Debug
// but if impl Debug for BoxError
// then I can't impl<T : std::fmt::Debug> From<T> for BoxError
// because there's already a impl<T> From<T> for T;

pub struct BoxError(String);
pub struct BoxError2(String);

impl std::fmt::Debug for BoxError2 {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(f, "{}", self.0)
    }
}

impl From<BoxError> for BoxError2 {
    fn from(error: BoxError) -> Self {
        BoxError2(error.0)
    }
}

impl<T: std::fmt::Debug> From<T> for BoxError {
    fn from(error: T) -> Self {
        let my_str = format!("{:?}", error);
        BoxError(my_str)
    }
}

#[tokio::main]
pub async fn main() -> Result<(), BoxError2> {
    basic_get_put_example::put_item_get_item().await?;
    // itemencryptor::item_encrypt_decrypt::encrypt_decrypt().await?;
    // get_encrypted_data_key_description::get_encrypted_data_key_description().await?;
    // multi_get_put_example::multi_put_get().await?;
    // keyring::raw_rsa_keyring::put_item_get_item().await?;
    // keyring::kms_rsa_keyring::put_item_get_item().await?;
    // keyring::multi_mrk_keyring::put_item_get_item().await?;
    // keyring::raw_aes_keyring::put_item_get_item().await?;
    // keyring::multi_keyring::put_item_get_item().await?;
    // keyring::mrk_discovery_multi_keyring::put_item_get_item().await?;
    // clientsupplier::client_supplier_example::put_item_get_item().await?;

    // let key_id = create_keystore_key::keystore_create_key().await?;
    // let key_id2 = create_keystore_key::keystore_create_key().await?;
    // // Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
    // // our test fails due to eventual consistency issues.
    // println!("Key Store Keys created. Waiting 5 seconds for consistency.");
    // std::thread::sleep(std::time::Duration::from_secs(5));

    // keyring::hierarchical_keyring::put_item_get_item(&key_id, &key_id2).await?;

    // searchableencryption::basic_searchable_encryption::put_and_query_with_beacon(&key_id).await?;
    // searchableencryption::beacon_styles_searchable_encryption::put_and_query_with_beacon(&key_id)
    //     .await?;
    // searchableencryption::compound_beacon_searchable_encryption::put_and_query_with_beacon(&key_id)
    //     .await?;
    // searchableencryption::virtual_beacon_searchable_encryption::put_and_query_with_beacon(&key_id)
    //     .await?;
    // searchableencryption::complexexample::complex_searchable_encryption::run_example(&key_id)
    //     .await?;

    // // ScanError will have to wait until we have a reasonable error message strategy

    println!("All examples completed successfully.\n");
    Ok(())
}
