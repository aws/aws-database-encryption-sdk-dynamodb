// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyInput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetBranchKeyIdFromDdbKeyInput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetBranchKeyIdFromDdbKeyInput::GetBranchKeyIdFromDdbKeyInput {
        ddbKey: ::dafny_runtime::dafny_runtime_conversions::hashmap_to_dafny_map(&value.ddb_key.clone().unwrap(),
    |k| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::string_to_dafny_string(&k),
    |v| crate::deps::com_amazonaws_dynamodb::conversions::attribute_value::to_dafny(&v.clone())
,
)
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetBranchKeyIdFromDdbKeyInput,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyInput{
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyInput::builder()
        .set_ddb_key(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_map_to_hashmap(&dafny_value.ddbKey(),
    |k: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<::dafny_runtime::dafny_runtime_conversions::DafnyCharUTF16>| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(k),
    |v: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::AttributeValue>| crate::deps::com_amazonaws_dynamodb::conversions::attribute_value::from_dafny(v.clone())
,
)
 ))
        .build()
        .unwrap()
}
