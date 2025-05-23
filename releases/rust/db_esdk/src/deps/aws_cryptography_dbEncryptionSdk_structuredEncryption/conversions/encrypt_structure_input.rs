// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureInput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::EncryptStructureInput,
>{
    ::dafny_runtime::Rc::new(to_dafny_plain(value.clone()))
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureInput,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::EncryptStructureInput{
    crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::EncryptStructureInput::EncryptStructureInput {
        tableName: crate::standard_library_conversions::ostring_to_dafny(&value.table_name) .Extract(),
 plaintextStructure: ::dafny_runtime::dafny_runtime_conversions::hashmap_to_dafny_map(&value.plaintext_structure.clone().unwrap(),
    |k| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::string_to_dafny_string(&k),
    |v| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::structured_data_terminal::to_dafny(&v.clone())
,
)
,
 cryptoSchema: ::dafny_runtime::dafny_runtime_conversions::hashmap_to_dafny_map(&value.crypto_schema.clone().unwrap(),
    |k| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::string_to_dafny_string(&k),
    |v| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::crypto_action::to_dafny(v.clone()),
)
,
 cmm: crate::deps::aws_cryptography_materialProviders::conversions::cryptographic_materials_manager::to_dafny(&value.cmm.clone().unwrap())
,
 algorithmSuiteId: ::dafny_runtime::Rc::new(match &value.algorithm_suite_id {
    Some(x) => crate::_Wrappers_Compile::Option::Some { value: crate::deps::aws_cryptography_materialProviders::conversions::dbe_algorithm_suite_id::to_dafny(x.clone()) },
    None => crate::_Wrappers_Compile::Option::None { }
})
,
 encryptionContext:
::dafny_runtime::Rc::new(match &value.encryption_context {
    Some(x) => crate::r#_Wrappers_Compile::Option::Some { value :
        ::dafny_runtime::dafny_runtime_conversions::hashmap_to_dafny_map(x,
            |k| dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&k.as_bytes().to_vec(), |b| *b),
            |v| dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&v.as_bytes().to_vec(), |b| *b),
        )
    },
    None => crate::r#_Wrappers_Compile::Option::None {}
})
,
    }
}

#[allow(dead_code)]
pub fn option_to_dafny(
  value: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureInput>,
) -> ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
  crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::EncryptStructureInput,
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
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::EncryptStructureInput,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureInput
{
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::EncryptStructureInput,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureInput
{
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::EncryptStructureInput::EncryptStructureInput {..} =>
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureInput::builder()
                .set_table_name(Some( dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(dafny_value.tableName()) ))
 .set_plaintext_structure(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_map_to_hashmap(&dafny_value.plaintextStructure(),
    |k: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<::dafny_runtime::dafny_runtime_conversions::DafnyCharUTF16>| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(k),
    |v: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::StructuredDataTerminal>| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::structured_data_terminal::from_dafny(v.clone())
,
)
 ))
 .set_crypto_schema(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_map_to_hashmap(&dafny_value.cryptoSchema(),
    |k: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<::dafny_runtime::dafny_runtime_conversions::DafnyCharUTF16>| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(k),
    |v: &::dafny_runtime::Rc<crate::software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::CryptoAction>| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::crypto_action::from_dafny(v),
)
 ))
 .set_cmm(Some( crate::deps::aws_cryptography_materialProviders::conversions::cryptographic_materials_manager::from_dafny(dafny_value.cmm().clone())
 ))
 .set_algorithm_suite_id(match &**dafny_value.algorithmSuiteId() {
    crate::r#_Wrappers_Compile::Option::Some { value } => Some(
        crate::deps::aws_cryptography_materialProviders::conversions::dbe_algorithm_suite_id::from_dafny(value)
    ),
    _ => None,
}
)
 .set_encryption_context(match (*dafny_value.encryptionContext()).as_ref() {
    crate::r#_Wrappers_Compile::Option::Some { value } =>
        Some(
            ::dafny_runtime::dafny_runtime_conversions::dafny_map_to_hashmap(value,
                |k: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>| ::std::string::String::from_utf8(dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(&::std::borrow::Borrow::borrow(k), |b| *b)).unwrap(),
                |v: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>| ::std::string::String::from_utf8(dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(&::std::borrow::Borrow::borrow(v), |b| *b)).unwrap(),
            )
        ),
    _ => None
}
)
                .build()
                .unwrap()
    }
}

#[allow(dead_code)]
pub fn option_from_dafny(
    dafny_value: ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::EncryptStructureInput,
    >>>,
) -> ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureInput>{
    match &*dafny_value {
        crate::_Wrappers_Compile::Option::Some { value } => {
            ::std::option::Option::Some(plain_from_dafny(value))
        }
        _ => ::std::option::Option::None,
    }
}
