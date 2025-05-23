// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconStyle,
>{
    ::dafny_runtime::Rc::new(match value {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::PartOnly(x) =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconStyle::partOnly {
        partOnly: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::part_only::to_dafny(&x.clone())
,
    },
crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::Shared(x) =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconStyle::shared {
        shared: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::shared::to_dafny(&x.clone())
,
    },
crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::AsSet(x) =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconStyle::asSet {
        asSet: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::as_set::to_dafny(&x.clone())
,
    },
crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::SharedSet(x) =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconStyle::sharedSet {
        sharedSet: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::shared_set::to_dafny(&x.clone())
,
    },
        _ => panic!("Unknown union variant: {:?}", value),
    })
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconStyle,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle {
    match &::dafny_runtime::Rc::unwrap_or_clone(dafny_value) {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconStyle::partOnly {
    partOnly: x @ _,
} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::PartOnly(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::part_only::from_dafny(x.clone())
),
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconStyle::shared {
    shared: x @ _,
} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::Shared(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::shared::from_dafny(x.clone())
),
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconStyle::asSet {
    asSet: x @ _,
} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::AsSet(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::as_set::from_dafny(x.clone())
),
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconStyle::sharedSet {
    sharedSet: x @ _,
} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::SharedSet(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::shared_set::from_dafny(x.clone())
),
    }
}
