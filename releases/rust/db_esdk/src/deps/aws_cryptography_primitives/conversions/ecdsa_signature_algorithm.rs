// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]

pub fn to_dafny(
    value: crate::deps::aws_cryptography_primitives::types::EcdsaSignatureAlgorithm,
) -> ::dafny_runtime::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::ECDSASignatureAlgorithm>{
    ::dafny_runtime::Rc::new(match value {
        crate::deps::aws_cryptography_primitives::types::EcdsaSignatureAlgorithm::EcdsaP384 => crate::r#software::amazon::cryptography::primitives::internaldafny::types::ECDSASignatureAlgorithm::ECDSA_P384 {},
crate::deps::aws_cryptography_primitives::types::EcdsaSignatureAlgorithm::EcdsaP256 => crate::r#software::amazon::cryptography::primitives::internaldafny::types::ECDSASignatureAlgorithm::ECDSA_P256 {},
        _ => panic!("Unknown enum variant: {}", value),
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::primitives::internaldafny::types::ECDSASignatureAlgorithm,
) -> crate::deps::aws_cryptography_primitives::types::EcdsaSignatureAlgorithm {
    match dafny_value {
        crate::r#software::amazon::cryptography::primitives::internaldafny::types::ECDSASignatureAlgorithm::ECDSA_P384 {} => crate::deps::aws_cryptography_primitives::types::EcdsaSignatureAlgorithm::EcdsaP384,
crate::r#software::amazon::cryptography::primitives::internaldafny::types::ECDSASignatureAlgorithm::ECDSA_P256 {} => crate::deps::aws_cryptography_primitives::types::EcdsaSignatureAlgorithm::EcdsaP256,
    }
}
