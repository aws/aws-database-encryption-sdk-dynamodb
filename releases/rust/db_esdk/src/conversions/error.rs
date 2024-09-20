// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
/// Wraps up an arbitrary Rust Error value as a Dafny Error
pub fn to_opaque_error<E: 'static>(value: E) ->
    ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>
{
    let error_obj: ::dafny_runtime::Object<dyn ::std::any::Any> = ::dafny_runtime::Object(Some(
        ::std::rc::Rc::new(::std::cell::UnsafeCell::new(value)),
    ));
    ::std::rc::Rc::new(
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error::Opaque {
            obj: error_obj,
        },
    )
}

/// Wraps up an arbitrary Rust Error value as a Dafny Result<T, Error>.Failure
pub fn to_opaque_error_result<T: ::dafny_runtime::DafnyType, E: 'static>(value: E) ->
    ::std::rc::Rc<
        crate::_Wrappers_Compile::Result<
            T,
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>
        >
    >
{
    ::std::rc::Rc::new(crate::_Wrappers_Compile::Result::Failure {
        error: to_opaque_error(value),
    })
}
pub fn to_dafny(
    value: crate::types::error::Error,
) -> ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>{
    ::std::rc::Rc::new(match value {
        crate::types::error::Error::DynamoDbEncryptionTransformsException { message } =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error::DynamoDbEncryptionTransformsException {
        message: ::dafny_runtime::dafny_runtime_conversions::unicode_chars_false::string_to_dafny_string(&message),
    },
crate::types::error::Error::DynamoDB_20120810Error { error } =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error::ComAmazonawsDynamodb {
        ComAmazonawsDynamodb: crate::deps::com_amazonaws_dynamodb::conversions::error::to_dafny(error),
    },
crate::types::error::Error::DynamoDbEncryptionError { error } =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error::AwsCryptographyDbEncryptionSdkDynamoDb {
        AwsCryptographyDbEncryptionSdkDynamoDb: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::error::to_dafny(error),
    },
crate::types::error::Error::DynamoDbItemEncryptorError { error } =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error::AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor {
        AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::error::to_dafny(error),
    },
crate::types::error::Error::StructuredEncryptionError { error } =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error::AwsCryptographyDbEncryptionSdkStructuredEncryption {
        AwsCryptographyDbEncryptionSdkStructuredEncryption: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::error::to_dafny(error),
    },
crate::types::error::Error::AwsCryptographicMaterialProvidersError { error } =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error::AwsCryptographyMaterialProviders {
        AwsCryptographyMaterialProviders: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
    },
        crate::types::error::Error::CollectionOfErrors { list, message } =>
            crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error::CollectionOfErrors {
                message: ::dafny_runtime::dafny_runtime_conversions::unicode_chars_false::string_to_dafny_string(&message),
                list: ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&list, |e| to_dafny(e.clone()))
            },
        crate::types::error::Error::Opaque { obj } =>
            crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error::Opaque {
                obj: ::dafny_runtime::Object(obj.0)
            },
    })
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::std::rc::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error,
    >,
) -> crate::types::error::Error {
    match ::std::borrow::Borrow::borrow(&dafny_value) {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error::DynamoDbEncryptionTransformsException { message } =>
    crate::types::error::Error::DynamoDbEncryptionTransformsException {
        message: ::dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(&message),
    },
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error::ComAmazonawsDynamodb { ComAmazonawsDynamodb } =>
    crate::types::error::Error::DynamoDB_20120810Error {
        error: crate::deps::com_amazonaws_dynamodb::conversions::error::from_dafny(ComAmazonawsDynamodb.clone()),
    },
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error::AwsCryptographyDbEncryptionSdkDynamoDb { AwsCryptographyDbEncryptionSdkDynamoDb } =>
    crate::types::error::Error::DynamoDbEncryptionError {
        error: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::error::from_dafny(AwsCryptographyDbEncryptionSdkDynamoDb.clone()),
    },
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error::AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor { AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor } =>
    crate::types::error::Error::DynamoDbItemEncryptorError {
        error: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::error::from_dafny(AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor.clone()),
    },
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error::AwsCryptographyDbEncryptionSdkStructuredEncryption { AwsCryptographyDbEncryptionSdkStructuredEncryption } =>
    crate::types::error::Error::StructuredEncryptionError {
        error: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::error::from_dafny(AwsCryptographyDbEncryptionSdkStructuredEncryption.clone()),
    },
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error::AwsCryptographyMaterialProviders { AwsCryptographyMaterialProviders } =>
    crate::types::error::Error::AwsCryptographicMaterialProvidersError {
        error: crate::deps::aws_cryptography_materialProviders::conversions::error::from_dafny(AwsCryptographyMaterialProviders.clone()),
    },
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error::CollectionOfErrors { list, message } =>
            crate::types::error::Error::CollectionOfErrors {
                message: ::dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(&message),
                list: ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(&list, |e| from_dafny(e.clone()))
            },
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error::Opaque { obj } =>
            crate::types::error::Error::Opaque {
                obj: obj.clone()
            },
    }
}
