// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct GetBranchKeyIdFromDdbKeyInput {
    #[allow(missing_docs)] // documentation missing in model
    pub ddb_key: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
}
impl GetBranchKeyIdFromDdbKeyInput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn ddb_key(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.ddb_key
    }
}
impl GetBranchKeyIdFromDdbKeyInput {
    /// Creates a new builder-style object to manufacture [`GetBranchKeyIdFromDdbKeyInput`](crate::operation::get_branch_key_id_from_ddb_key::builders::GetBranchKeyIdFromDdbKeyInput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::builders::GetBranchKeyIdFromDdbKeyInputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::builders::GetBranchKeyIdFromDdbKeyInputBuilder::default()
    }
}

/// A builder for [`GetBranchKeyIdFromDdbKeyInput`](crate::operation::operation::GetBranchKeyIdFromDdbKeyInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetBranchKeyIdFromDdbKeyInputBuilder {
    pub(crate) ddb_key: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
}
impl GetBranchKeyIdFromDdbKeyInputBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn ddb_key(
        mut self,
        input: impl ::std::convert::Into<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    ) -> Self {
        self.ddb_key = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_ddb_key(
        mut self,
        input: ::std::option::Option<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    ) -> Self {
        self.ddb_key = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_ddb_key(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.ddb_key
    }
    /// Consumes the builder and constructs a [`GetBranchKeyIdFromDdbKeyInput`](crate::operation::operation::GetBranchKeyIdFromDdbKeyInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyInput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyInput {
            ddb_key: self.ddb_key,
        })
    }
}
