// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform,
>{
    ::dafny_runtime::Rc::new(match value {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Upper(x) =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform::upper {
        upper: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::upper::to_dafny(&x.clone())
,
    },
crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Lower(x) =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform::lower {
        lower: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::lower::to_dafny(&x.clone())
,
    },
crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Insert(x) =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform::insert {
        insert: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::insert::to_dafny(&x.clone())
,
    },
crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Prefix(x) =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform::prefix {
        prefix: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_prefix::to_dafny(&x.clone())
,
    },
crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Suffix(x) =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform::suffix {
        suffix: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_suffix::to_dafny(&x.clone())
,
    },
crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Substring(x) =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform::substring {
        substring: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_substring::to_dafny(&x.clone())
,
    },
crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Segment(x) =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform::segment {
        segment: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_segment::to_dafny(&x.clone())
,
    },
crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Segments(x) =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform::segments {
        segments: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_segments::to_dafny(&x.clone())
,
    },
        _ => panic!("Unknown union variant: {:?}", value),
    })
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform {
    match &::dafny_runtime::Rc::unwrap_or_clone(dafny_value) {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform::upper {
    upper: x @ _,
} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Upper(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::upper::from_dafny(x.clone())
),
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform::lower {
    lower: x @ _,
} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Lower(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::lower::from_dafny(x.clone())
),
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform::insert {
    insert: x @ _,
} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Insert(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::insert::from_dafny(x.clone())
),
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform::prefix {
    prefix: x @ _,
} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Prefix(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_prefix::from_dafny(x.clone())
),
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform::suffix {
    suffix: x @ _,
} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Suffix(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_suffix::from_dafny(x.clone())
),
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform::substring {
    substring: x @ _,
} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Substring(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_substring::from_dafny(x.clone())
),
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform::segment {
    segment: x @ _,
} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Segment(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_segment::from_dafny(x.clone())
),
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualTransform::segments {
    segments: x @ _,
} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Segments(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_segments::from_dafny(x.clone())
),
    }
}
