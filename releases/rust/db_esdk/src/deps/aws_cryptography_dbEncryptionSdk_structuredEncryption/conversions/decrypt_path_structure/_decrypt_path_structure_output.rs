// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::DecryptPathStructureOutput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::DecryptPathStructureOutput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::DecryptPathStructureOutput::DecryptPathStructureOutput {
        plaintextStructure: ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&value.plaintext_structure.clone().unwrap(),
    |e| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::crypto_item::to_dafny(&e.clone())
,
)
,
 parsedHeader: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::parsed_header::to_dafny(&value.parsed_header.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::DecryptPathStructureOutput,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::DecryptPathStructureOutput{
    crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::DecryptPathStructureOutput::builder()
        .set_plaintext_structure(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(dafny_value.plaintextStructure(),
    |e: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::CryptoItem>| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::crypto_item::from_dafny(e.clone())
,
)
 ))
 .set_parsed_header(Some( crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::parsed_header::from_dafny(dafny_value.parsedHeader().clone())
 ))
        .build()
        .unwrap()
}
