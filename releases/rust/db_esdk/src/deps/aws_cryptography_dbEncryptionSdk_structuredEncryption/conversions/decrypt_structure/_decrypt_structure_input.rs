// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_structure::DecryptStructureInput,
) -> ::std::rc::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::DecryptStructureInput,
>{
    ::std::rc::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::DecryptStructureInput::DecryptStructureInput {
        tableName: crate::standard_library_conversions::ostring_to_dafny(&value.table_name) .Extract(),
 encryptedStructure: ::dafny_runtime::dafny_runtime_conversions::hashmap_to_dafny_map(&value.encrypted_structure.clone().unwrap(),
    |k| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::string_to_dafny_string(&k),
    |v| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::structured_data_terminal::to_dafny(&v.clone())
,
)
,
 authenticateSchema: ::dafny_runtime::dafny_runtime_conversions::hashmap_to_dafny_map(&value.authenticate_schema.clone().unwrap(),
    |k| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::string_to_dafny_string(&k),
    |v| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::authenticate_action::to_dafny(v.clone()),
)
,
 cmm: crate::deps::aws_cryptography_materialProviders::conversions::cryptographic_materials_manager::to_dafny(&value.cmm.clone().unwrap())
,
 encryptionContext:
::std::rc::Rc::new(match &value.encryption_context {
    Some(x) => crate::r#_Wrappers_Compile::Option::Some { value :
        ::dafny_runtime::dafny_runtime_conversions::hashmap_to_dafny_map(x,
            |k| dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&k.as_bytes().to_vec(), |b| *b),
            |v| dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&v.as_bytes().to_vec(), |b| *b),
        )
    },
    None => crate::r#_Wrappers_Compile::Option::None {}
})
,
    })
}
 #[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::std::rc::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::DecryptStructureInput,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_structure::DecryptStructureInput {
    crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_structure::DecryptStructureInput::builder()
        .set_table_name(Some( dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(dafny_value.tableName()) ))
 .set_encrypted_structure(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_map_to_hashmap(&dafny_value.encryptedStructure(),
    |k: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<::dafny_runtime::dafny_runtime_conversions::DafnyCharUTF16>| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(k),
    |v: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::StructuredDataTerminal>| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::structured_data_terminal::from_dafny(v.clone())
,
)
 ))
 .set_authenticate_schema(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_map_to_hashmap(&dafny_value.authenticateSchema(),
    |k: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<::dafny_runtime::dafny_runtime_conversions::DafnyCharUTF16>| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(k),
    |v: &::std::rc::Rc<crate::software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::AuthenticateAction>| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::authenticate_action::from_dafny(v),
)
 ))
 .set_cmm(Some( crate::deps::aws_cryptography_materialProviders::conversions::cryptographic_materials_manager::from_dafny(dafny_value.cmm().clone())
 ))
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
