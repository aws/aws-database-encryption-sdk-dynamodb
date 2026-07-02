// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

#[allow(missing_docs)]
pub trait PartitionSelector: Send + Sync {
    fn get_partition_number(
    &self,
    input: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::GetPartitionNumberInput,
  ) -> Result<
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::GetPartitionNumberOutput,
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error,
  >;
}

#[derive(::std::clone::Clone)]
/// A reference to a PartitionSelector
pub struct PartitionSelectorRef {
    pub inner: ::dafny_runtime::Rc<::dafny_runtime::RefCell<dyn PartitionSelector>>,
}

impl<T: PartitionSelector + 'static> From<T> for PartitionSelectorRef {
    fn from(value: T) -> Self {
        Self {
            inner: dafny_runtime::Rc::new(::dafny_runtime::RefCell::new(value)),
        }
    }
}

impl ::std::cmp::PartialEq for PartitionSelectorRef {
    fn eq(&self, other: &PartitionSelectorRef) -> bool {
        ::dafny_runtime::Rc::ptr_eq(&self.inner, &other.inner)
    }
}

impl ::std::fmt::Debug for PartitionSelectorRef {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(f, "<PartitionSelectorRef>")
    }
}

mod get_partition_number;
