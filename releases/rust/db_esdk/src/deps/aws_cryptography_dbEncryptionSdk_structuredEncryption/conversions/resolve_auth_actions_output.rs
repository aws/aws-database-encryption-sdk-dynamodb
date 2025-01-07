// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ResolveAuthActionsOutput,
) -> ::std::rc::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsOutput,
> {
    ::std::rc::Rc::new(to_dafny_plain(value.clone()))
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ResolveAuthActionsOutput,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsOutput {
    crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsOutput::ResolveAuthActionsOutput {
        cryptoActions: ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&value.crypto_actions.clone().unwrap(),
    |e| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::crypto_item::to_dafny(&e.clone())
,
)
,
    }
}

#[allow(dead_code)]
pub fn option_to_dafny(
  value: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ResolveAuthActionsOutput>,
) -> ::std::rc::Rc<crate::_Wrappers_Compile::Option<::std::rc::Rc<
  crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsOutput,
>>>{
    ::std::rc::Rc::new(match value {
        ::std::option::Option::None => crate::_Wrappers_Compile::Option::None {},
        ::std::option::Option::Some(x) => crate::_Wrappers_Compile::Option::Some {
            value: ::std::rc::Rc::new(to_dafny_plain(x)),
        },
    })
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::std::rc::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsOutput,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ResolveAuthActionsOutput {
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsOutput,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ResolveAuthActionsOutput {
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsOutput::ResolveAuthActionsOutput {..} =>
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ResolveAuthActionsOutput::builder()
                .set_crypto_actions(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(dafny_value.cryptoActions(),
    |e: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::CryptoItem>| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::crypto_item::from_dafny(e.clone())
,
)
 ))
                .build()
                .unwrap()
    }
}

#[allow(dead_code)]
pub fn option_from_dafny(
    dafny_value: ::std::rc::Rc<crate::_Wrappers_Compile::Option<::std::rc::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsOutput,
    >>>,
) -> ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ResolveAuthActionsOutput> {
    match &*dafny_value {
        crate::_Wrappers_Compile::Option::Some { value } => {
            ::std::option::Option::Some(plain_from_dafny(value))
        }
        _ => ::std::option::Option::None,
    }
}
