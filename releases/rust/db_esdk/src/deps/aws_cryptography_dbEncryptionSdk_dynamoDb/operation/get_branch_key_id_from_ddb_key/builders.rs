// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::_get_branch_key_id_from_ddb_key_output::GetBranchKeyIdFromDdbKeyOutputBuilder;

pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::_get_branch_key_id_from_ddb_key_input::GetBranchKeyIdFromDdbKeyInputBuilder;

impl GetBranchKeyIdFromDdbKeyInputBuilder {
    /// Sends a request with this input using the given client.
    pub async fn send_with(
        self,
        dynamo_db_key_branch_key_id_supplier: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error,
    >{
        let mut fluent_builder =
            dynamo_db_key_branch_key_id_supplier.get_branch_key_id_from_ddb_key();
        fluent_builder.inner = self;
        fluent_builder.send().await
    }
}
/// Fluent builder constructing a request to `GetBranchKeyIdFromDdbKey`.
///
/// Get the Branch Key that should be used for wrapping and unwrapping data keys based on the primary key of the item being read or written, along with the values of any attributes configured as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.
#[derive(::std::clone::Clone, ::std::fmt::Debug)]
pub struct GetBranchKeyIdFromDdbKeyFluentBuilder {
    dynamo_db_key_branch_key_id_supplier: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef,
    pub(crate) inner: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::builders::GetBranchKeyIdFromDdbKeyInputBuilder,
}
impl GetBranchKeyIdFromDdbKeyFluentBuilder {
    /// Creates a new `GetBranchKeyIdFromDdbKey`.
    pub(crate) fn new(
        dynamo_db_key_branch_key_id_supplier: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef,
    ) -> Self {
        Self {
            dynamo_db_key_branch_key_id_supplier,
            inner: ::std::default::Default::default(),
        }
    }
    /// Access the GetBranchKeyIdFromDdbKey as a reference.
    pub fn as_input(&self) -> &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::builders::GetBranchKeyIdFromDdbKeyInputBuilder{
        &self.inner
    }
    /// Sends the request and returns the response.
    pub async fn send(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error,
    >{
        let input = self
            .inner
            .build()
            // Using Opaque since we don't have a validation-specific error yet.
            // Operations' models don't declare their own validation error,
            // and smithy-rs seems to not generate a ValidationError case unless there is.
            // Vanilla smithy-rs uses SdkError::construction_failure, but we aren't using SdkError.
            .map_err(|mut e| {
	     let msg = format!("{:?}", e);
             crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error::OpaqueWithText {
                obj: ::dafny_runtime::Object::from_ref(&mut e as &mut ::dafny_runtime::DynAny),
		objMessage: msg
             }})?;
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKey::send(&self.dynamo_db_key_branch_key_id_supplier, input).await
    }

    /// The partition and sort (if it exists) attributes on the item being read or written, along with the values of any attributes configured as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.
    pub fn ddb_key(
        mut self,
        input: impl ::std::convert::Into<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    ) -> Self {
        self.inner = self.inner.ddb_key(input.into());
        self
    }
    /// The partition and sort (if it exists) attributes on the item being read or written, along with the values of any attributes configured as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.
    pub fn set_ddb_key(
        mut self,
        input: ::std::option::Option<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    ) -> Self {
        self.inner = self.inner.set_ddb_key(input);
        self
    }
    /// The partition and sort (if it exists) attributes on the item being read or written, along with the values of any attributes configured as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.
    pub fn get_ddb_key(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        self.inner.get_ddb_key()
    }
}
