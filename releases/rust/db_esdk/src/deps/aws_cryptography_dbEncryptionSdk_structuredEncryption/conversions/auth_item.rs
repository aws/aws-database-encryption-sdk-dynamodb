// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::AuthItem,
>{
    ::dafny_runtime::Rc::new(to_dafny_plain(value.clone()))
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::AuthItem{
    crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::AuthItem::AuthItem {
        key: ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&value.key.clone().unwrap(),
    |e| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::path_segment::to_dafny(&e.clone())
,
)
,
 data: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::structured_data_terminal::to_dafny(&value.data.clone().unwrap())
,
 action: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::authenticate_action::to_dafny(value.action.clone().unwrap()),
    }
}

#[allow(dead_code)]
pub fn option_to_dafny(
  value: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem>,
) -> ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
  crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::AuthItem,
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
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::AuthItem,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem {
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::AuthItem,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem {
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::AuthItem::AuthItem {..} =>
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem::builder()
                .set_key(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(dafny_value.key(),
    |e: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::PathSegment>| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::path_segment::from_dafny(e.clone())
,
)
 ))
 .set_data(Some( crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::structured_data_terminal::from_dafny(dafny_value.data().clone())
 ))
 .set_action(Some( crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::authenticate_action::from_dafny(dafny_value.action()) ))
                .build()
                .unwrap()
    }
}

#[allow(dead_code)]
pub fn option_from_dafny(
    dafny_value: ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::AuthItem,
    >>>,
) -> ::std::option::Option<
    crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem,
> {
    match &*dafny_value {
        crate::_Wrappers_Compile::Option::Some { value } => {
            ::std::option::Option::Some(plain_from_dafny(value))
        }
        _ => ::std::option::Option::None,
    }
}
