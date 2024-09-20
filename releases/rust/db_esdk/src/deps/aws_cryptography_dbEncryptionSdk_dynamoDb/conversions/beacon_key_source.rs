// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource,
) -> ::std::rc::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconKeySource,
>{
    ::std::rc::Rc::new(match value {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource::Single(x) =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconKeySource::single {
        single: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::single_key_store::to_dafny(&x.clone())
,
    },
crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource::Multi(x) =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconKeySource::multi {
        multi: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::multi_key_store::to_dafny(&x.clone())
,
    },
        _ => panic!("Unknown union variant: {:?}", value),
    })
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::std::rc::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconKeySource,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource {
    match &::std::rc::Rc::unwrap_or_clone(dafny_value) {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconKeySource::single {
    single: x @ _,
} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource::Single(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::single_key_store::from_dafny(x.clone())
),
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconKeySource::multi {
    multi: x @ _,
} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource::Multi(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::multi_key_store::from_dafny(x.clone())
),
    }
}
