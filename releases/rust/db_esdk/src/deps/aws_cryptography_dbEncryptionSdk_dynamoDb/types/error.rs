// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[derive(::std::clone::Clone, ::std::fmt::Debug, ::std::cmp::PartialEq)]
pub enum Error {
    DynamoDbEncryptionException {
        message: ::std::string::String,
    },

    AwsCryptographicPrimitivesError {
        error: crate::deps::aws_cryptography_primitives::types::error::Error,
    },

    DynamoDB_20120810Error {
        error: crate::deps::com_amazonaws_dynamodb::types::error::Error,
    },

    AwsCryptographicMaterialProvidersError {
        error: crate::deps::aws_cryptography_materialProviders::types::error::Error,
    },

    StructuredEncryptionError {
        error:
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error,
    },

    KeyStoreError {
        error: crate::deps::aws_cryptography_keyStore::types::error::Error,
    },
    CollectionOfErrors {
        list: ::std::vec::Vec<Error>,
        message: ::std::string::String,
    },
    Opaque {
        obj: ::dafny_runtime::Object<dyn ::std::any::Any>,
    },
}

impl ::std::cmp::Eq for Error {}

impl ::std::fmt::Display for Error {
    fn fmt(&self, f: &mut ::std::fmt::Formatter) -> ::std::fmt::Result {
        write!(f, "{:?}", self)
    }
}

impl ::std::error::Error for Error {}
