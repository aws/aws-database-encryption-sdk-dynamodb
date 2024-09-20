// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct GetBranchKeyIdFromDdbKeyOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub branch_key_id: ::std::option::Option<::std::string::String>,
}
impl GetBranchKeyIdFromDdbKeyOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn branch_key_id(&self) -> &::std::option::Option<::std::string::String> {
        &self.branch_key_id
    }
}
impl GetBranchKeyIdFromDdbKeyOutput {
    /// Creates a new builder-style object to manufacture [`GetBranchKeyIdFromDdbKeyOutput`](crate::operation::get_branch_key_id_from_ddb_key::builders::GetBranchKeyIdFromDdbKeyOutput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::builders::GetBranchKeyIdFromDdbKeyOutputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::builders::GetBranchKeyIdFromDdbKeyOutputBuilder::default()
    }
}

/// A builder for [`GetBranchKeyIdFromDdbKeyOutput`](crate::operation::operation::GetBranchKeyIdFromDdbKeyOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetBranchKeyIdFromDdbKeyOutputBuilder {
    pub(crate) branch_key_id: ::std::option::Option<::std::string::String>,
}
impl GetBranchKeyIdFromDdbKeyOutputBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn branch_key_id(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.branch_key_id = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_branch_key_id(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.branch_key_id = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_branch_key_id(&self) -> &::std::option::Option<::std::string::String> {
        &self.branch_key_id
    }
    /// Consumes the builder and constructs a [`GetBranchKeyIdFromDdbKeyOutput`](crate::operation::operation::GetBranchKeyIdFromDdbKeyOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyOutput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyOutput {
            branch_key_id: self.branch_key_id,
        })
    }
}
