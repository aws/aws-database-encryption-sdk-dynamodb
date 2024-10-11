// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[derive(::std::clone::Clone, ::std::fmt::Debug, ::std::cmp::PartialEq)]
pub enum Error {
    XksProxyInvalidResponseException {
        error: aws_sdk_kms::types::error::XksProxyInvalidResponseException,
    },

    CloudHsmClusterNotActiveException {
        error: aws_sdk_kms::types::error::CloudHsmClusterNotActiveException,
    },

    NotFoundException {
        error: aws_sdk_kms::types::error::NotFoundException,
    },

    InvalidMarkerException {
        error: aws_sdk_kms::types::error::InvalidMarkerException,
    },

    XksProxyVpcEndpointServiceInvalidConfigurationException {
        error: aws_sdk_kms::types::error::XksProxyVpcEndpointServiceInvalidConfigurationException,
    },

    UnsupportedOperationException {
        error: aws_sdk_kms::types::error::UnsupportedOperationException,
    },

    XksProxyVpcEndpointServiceInUseException {
        error: aws_sdk_kms::types::error::XksProxyVpcEndpointServiceInUseException,
    },

    KmsInvalidSignatureException {
        error: aws_sdk_kms::types::error::KmsInvalidSignatureException,
    },

    XksProxyVpcEndpointServiceNotFoundException {
        error: aws_sdk_kms::types::error::XksProxyVpcEndpointServiceNotFoundException,
    },

    MalformedPolicyDocumentException {
        error: aws_sdk_kms::types::error::MalformedPolicyDocumentException,
    },

    InvalidCiphertextException {
        error: aws_sdk_kms::types::error::InvalidCiphertextException,
    },

    CustomKeyStoreNotFoundException {
        error: aws_sdk_kms::types::error::CustomKeyStoreNotFoundException,
    },

    CloudHsmClusterInUseException {
        error: aws_sdk_kms::types::error::CloudHsmClusterInUseException,
    },

    KmsInternalException {
        error: aws_sdk_kms::types::error::KmsInternalException,
    },

    InvalidGrantTokenException {
        error: aws_sdk_kms::types::error::InvalidGrantTokenException,
    },

    IncorrectTrustAnchorException {
        error: aws_sdk_kms::types::error::IncorrectTrustAnchorException,
    },

    KeyUnavailableException {
        error: aws_sdk_kms::types::error::KeyUnavailableException,
    },

    InvalidAliasNameException {
        error: aws_sdk_kms::types::error::InvalidAliasNameException,
    },

    KmsInvalidMacException {
        error: aws_sdk_kms::types::error::KmsInvalidMacException,
    },

    CloudHsmClusterNotRelatedException {
        error: aws_sdk_kms::types::error::CloudHsmClusterNotRelatedException,
    },

    XksKeyAlreadyInUseException {
        error: aws_sdk_kms::types::error::XksKeyAlreadyInUseException,
    },

    InvalidKeyUsageException {
        error: aws_sdk_kms::types::error::InvalidKeyUsageException,
    },

    InvalidGrantIdException {
        error: aws_sdk_kms::types::error::InvalidGrantIdException,
    },

    XksKeyNotFoundException {
        error: aws_sdk_kms::types::error::XksKeyNotFoundException,
    },

    InvalidImportTokenException {
        error: aws_sdk_kms::types::error::InvalidImportTokenException,
    },

    AlreadyExistsException {
        error: aws_sdk_kms::types::error::AlreadyExistsException,
    },

    XksProxyUriInUseException {
        error: aws_sdk_kms::types::error::XksProxyUriInUseException,
    },

    XksProxyUriUnreachableException {
        error: aws_sdk_kms::types::error::XksProxyUriUnreachableException,
    },

    CustomKeyStoreHasCmKsException {
        error: aws_sdk_kms::types::error::CustomKeyStoreHasCmKsException,
    },

    TagException {
        error: aws_sdk_kms::types::error::TagException,
    },

    XksKeyInvalidConfigurationException {
        error: aws_sdk_kms::types::error::XksKeyInvalidConfigurationException,
    },

    CustomKeyStoreInvalidStateException {
        error: aws_sdk_kms::types::error::CustomKeyStoreInvalidStateException,
    },

    LimitExceededException {
        error: aws_sdk_kms::types::error::LimitExceededException,
    },

    DisabledException {
        error: aws_sdk_kms::types::error::DisabledException,
    },

    IncorrectKeyMaterialException {
        error: aws_sdk_kms::types::error::IncorrectKeyMaterialException,
    },

    IncorrectKeyException {
        error: aws_sdk_kms::types::error::IncorrectKeyException,
    },

    CustomKeyStoreNameInUseException {
        error: aws_sdk_kms::types::error::CustomKeyStoreNameInUseException,
    },

    DependencyTimeoutException {
        error: aws_sdk_kms::types::error::DependencyTimeoutException,
    },

    InvalidArnException {
        error: aws_sdk_kms::types::error::InvalidArnException,
    },

    XksProxyIncorrectAuthenticationCredentialException {
        error: aws_sdk_kms::types::error::XksProxyIncorrectAuthenticationCredentialException,
    },

    KmsInvalidStateException {
        error: aws_sdk_kms::types::error::KmsInvalidStateException,
    },

    DryRunOperationException {
        error: aws_sdk_kms::types::error::DryRunOperationException,
    },

    ExpiredImportTokenException {
        error: aws_sdk_kms::types::error::ExpiredImportTokenException,
    },

    CloudHsmClusterInvalidConfigurationException {
        error: aws_sdk_kms::types::error::CloudHsmClusterInvalidConfigurationException,
    },

    XksProxyUriEndpointInUseException {
        error: aws_sdk_kms::types::error::XksProxyUriEndpointInUseException,
    },

    ConflictException {
        error: aws_sdk_kms::types::error::ConflictException,
    },

    CloudHsmClusterNotFoundException {
        error: aws_sdk_kms::types::error::CloudHsmClusterNotFoundException,
    },

    XksProxyInvalidConfigurationException {
        error: aws_sdk_kms::types::error::XksProxyInvalidConfigurationException,
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
