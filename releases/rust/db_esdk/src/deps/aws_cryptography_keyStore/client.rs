// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
use aws_smithy_types::error::operation::BuildError;

#[derive(::std::clone::Clone, ::std::fmt::Debug, ::std::cmp::PartialEq)]
pub struct Client {
    pub(crate) dafny_client: ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::keystore::internaldafny::types::IKeyStoreClient>
}

impl Client {
    /// Creates a new client from the service [`Config`](crate::Config).
    #[track_caller]
    pub fn from_conf(
        conf: crate::deps::aws_cryptography_keyStore::types::key_store_config::KeyStoreConfig,
    ) -> Result<Self, BuildError> {
        let inner =
            crate::software::amazon::cryptography::keystore::internaldafny::_default::KeyStore(
                &crate::deps::aws_cryptography_keyStore::conversions::key_store_config::_key_store_config::to_dafny(conf),
            );
        if matches!(
            inner.as_ref(),
            crate::_Wrappers_Compile::Result::Failure { .. }
        ) {
            // TODO: convert error - the potential types are not modeled!
            return Err(BuildError::other(
                ::aws_smithy_types::error::metadata::ErrorMetadata::builder()
                    .message("Invalid client config")
                    .build(),
            ));
        }
        Ok(Self {
            dafny_client: ::dafny_runtime::upcast_object()(inner.Extract()),
        })
    }
}

mod get_key_store_info;

mod create_key_store;

mod create_key;

mod version_key;

mod get_active_branch_key;

mod get_branch_key_version;

mod get_beacon_key;
