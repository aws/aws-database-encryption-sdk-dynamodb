// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
use aws_smithy_types::error::operation::BuildError;

#[derive(::std::clone::Clone, ::std::fmt::Debug, ::std::cmp::PartialEq)]
#[allow(missing_docs)]
pub struct Client {
    pub(crate) dafny_client: ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::IStructuredEncryptionClient>
}

impl Client {
    /// Creates a new client from the service [`Config`](crate::Config).
    #[track_caller]
    pub fn from_conf(
        input: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::structured_encryption_config::StructuredEncryptionConfig,
    ) -> Result<
        Self,
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error,
    > {
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::validation::validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredEncryptionConfig(&input)
            .map_err(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error::wrap_validation_err)?;
        let inner =
            crate::software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::_default::StructuredEncryption(
                &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::structured_encryption_config::_structured_encryption_config::to_dafny(input),
            );
        if matches!(
            inner.as_ref(),
            crate::_Wrappers_Compile::Result::Failure { .. }
        ) {
            return Err(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::error::from_dafny(inner.as_ref().error().clone()));
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
