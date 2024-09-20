// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
use aws_smithy_types::error::operation::BuildError;

#[derive(::std::clone::Clone, ::std::fmt::Debug, ::std::cmp::PartialEq)]
pub struct Client {
    pub(crate) dafny_client: ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::IStructuredEncryptionClient>
}

impl Client {
    /// Creates a new client from the service [`Config`](crate::Config).
    #[track_caller]
    pub fn from_conf(
        conf: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::structured_encryption_config::StructuredEncryptionConfig,
    ) -> Result<Self, BuildError> {
        let inner =
            crate::software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::_default::StructuredEncryption(
                &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::structured_encryption_config::_structured_encryption_config::to_dafny(conf),
            );
        if matches!(
            inner.as_ref(),
            crate::_Wrappers_Compile::Result::Failure { .. }
        ) {
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

mod encrypt_structure;

mod decrypt_structure;

mod encrypt_path_structure;

mod decrypt_path_structure;

mod resolve_auth_actions;
