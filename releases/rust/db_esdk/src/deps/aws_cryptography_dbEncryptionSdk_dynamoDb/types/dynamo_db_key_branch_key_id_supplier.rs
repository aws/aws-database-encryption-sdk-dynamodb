// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

#[allow(missing_docs)]
pub trait DynamoDbKeyBranchKeyIdSupplier: Send + Sync {
    fn get_branch_key_id_from_ddb_key(
    &self,
    input: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyInput,
  ) -> Result<
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyOutput,
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error,
  >;
}

#[derive(::std::clone::Clone)]
/// A reference to a DynamoDbKeyBranchKeyIdSupplier
pub struct DynamoDbKeyBranchKeyIdSupplierRef {
    pub inner: ::dafny_runtime::Rc<::dafny_runtime::RefCell<dyn DynamoDbKeyBranchKeyIdSupplier>>,
}

impl<T: DynamoDbKeyBranchKeyIdSupplier + 'static> From<T> for DynamoDbKeyBranchKeyIdSupplierRef {
    fn from(value: T) -> Self {
        Self {
            inner: dafny_runtime::Rc::new(::dafny_runtime::RefCell::new(value)),
        }
    }
}

impl ::std::cmp::PartialEq for DynamoDbKeyBranchKeyIdSupplierRef {
    fn eq(&self, other: &DynamoDbKeyBranchKeyIdSupplierRef) -> bool {
        ::dafny_runtime::Rc::ptr_eq(&self.inner, &other.inner)
    }
}

impl ::std::fmt::Debug for DynamoDbKeyBranchKeyIdSupplierRef {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(f, "<DynamoDbKeyBranchKeyIdSupplierRef>")
    }
}

mod get_branch_key_id_from_ddb_key;
