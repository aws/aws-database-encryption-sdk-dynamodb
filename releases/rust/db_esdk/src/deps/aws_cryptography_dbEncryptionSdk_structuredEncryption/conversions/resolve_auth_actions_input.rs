// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ResolveAuthActionsInput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsInput,
>{
    ::dafny_runtime::Rc::new(to_dafny_plain(value.clone()))
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ResolveAuthActionsInput,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsInput{
    crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsInput::ResolveAuthActionsInput {
        tableName: crate::standard_library_conversions::ostring_to_dafny(&value.table_name) .Extract(),
 authActions: ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&value.auth_actions.clone().unwrap(),
    |e| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::auth_item::to_dafny(&e.clone())
,
)
,
 headerBytes: crate::standard_library_conversions::blob_to_dafny(&value.header_bytes.unwrap()),
    }
}

#[allow(dead_code)]
pub fn option_to_dafny(
  value: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ResolveAuthActionsInput>,
) -> ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
  crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsInput,
>>>{
    ::dafny_runtime::Rc::new(match value {
        ::std::option::Option::None => crate::_Wrappers_Compile::Option::None {},
        ::std::option::Option::Some(x) => crate::_Wrappers_Compile::Option::Some {
            value: ::dafny_runtime::Rc::new(to_dafny_plain(x)),
        },
    })
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsInput,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ResolveAuthActionsInput{
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsInput,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ResolveAuthActionsInput{
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsInput::ResolveAuthActionsInput {..} =>
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ResolveAuthActionsInput::builder()
                .set_table_name(Some( dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(dafny_value.tableName()) ))
 .set_auth_actions(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(dafny_value.authActions(),
    |e: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::AuthItem>| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::auth_item::from_dafny(e.clone())
,
)
 ))
 .set_header_bytes(Some(crate::standard_library_conversions::blob_from_dafny(dafny_value.headerBytes().clone())))
                .build()
                .unwrap()
    }
}

#[allow(dead_code)]
pub fn option_from_dafny(
    dafny_value: ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsInput,
    >>>,
) -> ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ResolveAuthActionsInput>{
    match &*dafny_value {
        crate::_Wrappers_Compile::Option::Some { value } => {
            ::std::option::Option::Some(plain_from_dafny(value))
        }
        _ => ::std::option::Option::None,
    }
}
