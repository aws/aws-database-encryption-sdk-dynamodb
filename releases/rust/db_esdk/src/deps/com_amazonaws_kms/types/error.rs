// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[derive(::std::clone::Clone, ::std::fmt::Debug, ::std::cmp::PartialEq)]
pub enum Error {
    InvalidKeyUsageException {
        error: aws_sdk_kms::types::error::InvalidKeyUsageException,
    },

    XksProxyUriUnreachableException {
        error: aws_sdk_kms::types::error::XksProxyUriUnreachableException,
    },

    XksKeyNotFoundException {
        error: aws_sdk_kms::types::error::XksKeyNotFoundException,
    },

    CustomKeyStoreHasCmKsException {
        error: aws_sdk_kms::types::error::CustomKeyStoreHasCmKsException,
    },

    KeyUnavailableException {
        error: aws_sdk_kms::types::error::KeyUnavailableException,
    },

    XksKeyInvalidConfigurationException {
        error: aws_sdk_kms::types::error::XksKeyInvalidConfigurationException,
    },

    KmsInvalidMacException {
        error: aws_sdk_kms::types::error::KmsInvalidMacException,
    },

    InvalidGrantTokenException {
        error: aws_sdk_kms::types::error::InvalidGrantTokenException,
    },

    AlreadyExistsException {
        error: aws_sdk_kms::types::error::AlreadyExistsException,
    },

    DependencyTimeoutException {
        error: aws_sdk_kms::types::error::DependencyTimeoutException,
    },

    XksProxyUriEndpointInUseException {
        error: aws_sdk_kms::types::error::XksProxyUriEndpointInUseException,
    },

    CustomKeyStoreInvalidStateException {
        error: aws_sdk_kms::types::error::CustomKeyStoreInvalidStateException,
    },

    InvalidArnException {
        error: aws_sdk_kms::types::error::InvalidArnException,
    },

    XksProxyIncorrectAuthenticationCredentialException {
        error: aws_sdk_kms::types::error::XksProxyIncorrectAuthenticationCredentialException,
    },

    XksProxyInvalidConfigurationException {
        error: aws_sdk_kms::types::error::XksProxyInvalidConfigurationException,
    },

    DisabledException {
        error: aws_sdk_kms::types::error::DisabledException,
    },

    CloudHsmClusterNotFoundException {
        error: aws_sdk_kms::types::error::CloudHsmClusterNotFoundException,
    },

    XksProxyVpcEndpointServiceInvalidConfigurationException {
        error: aws_sdk_kms::types::error::XksProxyVpcEndpointServiceInvalidConfigurationException,
    },

    LimitExceededException {
        error: aws_sdk_kms::types::error::LimitExceededException,
    },

    XksProxyUriInUseException {
        error: aws_sdk_kms::types::error::XksProxyUriInUseException,
    },

    CustomKeyStoreNameInUseException {
        error: aws_sdk_kms::types::error::CustomKeyStoreNameInUseException,
    },

    InvalidImportTokenException {
        error: aws_sdk_kms::types::error::InvalidImportTokenException,
    },

    XksProxyInvalidResponseException {
        error: aws_sdk_kms::types::error::XksProxyInvalidResponseException,
    },

    IncorrectKeyException {
        error: aws_sdk_kms::types::error::IncorrectKeyException,
    },

    NotFoundException {
        error: aws_sdk_kms::types::error::NotFoundException,
    },

    CloudHsmClusterInvalidConfigurationException {
        error: aws_sdk_kms::types::error::CloudHsmClusterInvalidConfigurationException,
    },

    InvalidGrantIdException {
        error: aws_sdk_kms::types::error::InvalidGrantIdException,
    },

    KmsInvalidSignatureException {
        error: aws_sdk_kms::types::error::KmsInvalidSignatureException,
    },

    KmsInvalidStateException {
        error: aws_sdk_kms::types::error::KmsInvalidStateException,
    },

    ExpiredImportTokenException {
        error: aws_sdk_kms::types::error::ExpiredImportTokenException,
    },

    XksProxyVpcEndpointServiceNotFoundException {
        error: aws_sdk_kms::types::error::XksProxyVpcEndpointServiceNotFoundException,
    },

    MalformedPolicyDocumentException {
        error: aws_sdk_kms::types::error::MalformedPolicyDocumentException,
    },

    ConflictException {
        error: aws_sdk_kms::types::error::ConflictException,
    },

    KmsInternalException {
        error: aws_sdk_kms::types::error::KmsInternalException,
    },

    InvalidMarkerException {
        error: aws_sdk_kms::types::error::InvalidMarkerException,
    },

    UnsupportedOperationException {
        error: aws_sdk_kms::types::error::UnsupportedOperationException,
    },

    InvalidAliasNameException {
        error: aws_sdk_kms::types::error::InvalidAliasNameException,
    },

    XksProxyVpcEndpointServiceInUseException {
        error: aws_sdk_kms::types::error::XksProxyVpcEndpointServiceInUseException,
    },

    DryRunOperationException {
        error: aws_sdk_kms::types::error::DryRunOperationException,
    },

    CustomKeyStoreNotFoundException {
        error: aws_sdk_kms::types::error::CustomKeyStoreNotFoundException,
    },

    IncorrectKeyMaterialException {
        error: aws_sdk_kms::types::error::IncorrectKeyMaterialException,
    },

    IncorrectTrustAnchorException {
        error: aws_sdk_kms::types::error::IncorrectTrustAnchorException,
    },

    InvalidCiphertextException {
        error: aws_sdk_kms::types::error::InvalidCiphertextException,
    },

    TagException {
        error: aws_sdk_kms::types::error::TagException,
    },

    CloudHsmClusterNotActiveException {
        error: aws_sdk_kms::types::error::CloudHsmClusterNotActiveException,
    },

    CloudHsmClusterInUseException {
        error: aws_sdk_kms::types::error::CloudHsmClusterInUseException,
    },

    CloudHsmClusterNotRelatedException {
        error: aws_sdk_kms::types::error::CloudHsmClusterNotRelatedException,
    },

    XksKeyAlreadyInUseException {
        error: aws_sdk_kms::types::error::XksKeyAlreadyInUseException,
    },
    Opaque {
        obj: ::dafny_runtime::Object<dyn ::std::any::Any>,
        alt_text: String,
    },
}

impl ::std::cmp::Eq for Error {}

impl ::std::fmt::Display for Error {
    fn fmt(&self, f: &mut ::std::fmt::Formatter) -> ::std::fmt::Result {
        write!(f, "{:?}", self)
    }
}

impl ::std::error::Error for Error {}
