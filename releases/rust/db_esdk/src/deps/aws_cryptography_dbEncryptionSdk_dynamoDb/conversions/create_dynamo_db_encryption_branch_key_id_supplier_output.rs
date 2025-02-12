// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
>{
    ::dafny_runtime::Rc::new(to_dafny_plain(value.clone()))
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput{
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput {
        branchKeyIdSupplier: crate::deps::aws_cryptography_materialProviders::conversions::branch_key_id_supplier::to_dafny(&value.branch_key_id_supplier.clone().unwrap())
,
    }
}

#[allow(dead_code)]
pub fn option_to_dafny(
  value: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput>,
) -> ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
  crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
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
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput{
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput{
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput {..} =>
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput::builder()
                .set_branch_key_id_supplier(Some( crate::deps::aws_cryptography_materialProviders::conversions::branch_key_id_supplier::from_dafny(dafny_value.branchKeyIdSupplier().clone())
 ))
                .build()
                .unwrap()
    }
}

#[allow(dead_code)]
pub fn option_from_dafny(
    dafny_value: ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
    >>>,
) -> ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput>{
    match &*dafny_value {
        crate::_Wrappers_Compile::Option::Some { value } => {
            ::std::option::Option::Some(plain_from_dafny(value))
        }
        _ => ::std::option::Option::None,
    }
}
