// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::ResolveAuthActionsOutput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsOutput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsOutput::ResolveAuthActionsOutput {
        cryptoActions: ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&value.crypto_actions.clone().unwrap(),
    |e| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::crypto_item::to_dafny(&e.clone())
,
)
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsOutput,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::ResolveAuthActionsOutput{
    crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::ResolveAuthActionsOutput::builder()
        .set_crypto_actions(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(dafny_value.cryptoActions(),
    |e: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::CryptoItem>| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::crypto_item::from_dafny(e.clone())
,
)
 ))
        .build()
        .unwrap()
}
