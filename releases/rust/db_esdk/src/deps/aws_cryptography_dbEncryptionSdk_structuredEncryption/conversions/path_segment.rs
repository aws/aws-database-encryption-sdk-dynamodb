// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::PathSegment,
>{
    ::dafny_runtime::Rc::new(match value {
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment::Member(x) =>
    crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::PathSegment::member {
        member: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::structure_segment::to_dafny(&x.clone())
,
    },
        _ => panic!("Unknown union variant: {:?}", value),
    })
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::PathSegment,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment {
    match &::dafny_runtime::Rc::unwrap_or_clone(dafny_value) {
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::PathSegment::member {
    member: x @ _,
} => crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment::Member(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::structure_segment::from_dafny(x.clone())
),
    }
}
