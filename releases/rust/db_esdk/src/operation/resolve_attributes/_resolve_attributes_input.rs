// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct ResolveAttributesInput {
    #[allow(missing_docs)] // documentation missing in model
    pub item: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
    #[allow(missing_docs)] // documentation missing in model
    pub table_name: ::std::option::Option<::std::string::String>,
    #[allow(missing_docs)] // documentation missing in model
    pub version: ::std::option::Option<::std::primitive::i32>,
}
impl ResolveAttributesInput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn item(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.item
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn table_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.table_name
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn version(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.version
    }
}
impl ResolveAttributesInput {
    /// Creates a new builder-style object to manufacture [`ResolveAttributesInput`](crate::operation::resolve_attributes::builders::ResolveAttributesInput).
    pub fn builder() -> crate::operation::resolve_attributes::builders::ResolveAttributesInputBuilder
    {
        crate::operation::resolve_attributes::builders::ResolveAttributesInputBuilder::default()
    }
}

/// A builder for [`ResolveAttributesInput`](crate::operation::operation::ResolveAttributesInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct ResolveAttributesInputBuilder {
    pub(crate) item: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
    pub(crate) table_name: ::std::option::Option<::std::string::String>,
    pub(crate) version: ::std::option::Option<::std::primitive::i32>,
}
impl ResolveAttributesInputBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn item(
        mut self,
        input: impl ::std::convert::Into<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    ) -> Self {
        self.item = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_item(
        mut self,
        input: ::std::option::Option<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    ) -> Self {
        self.item = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_item(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.item
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn table_name(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.table_name = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_table_name(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.table_name = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_table_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.table_name
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn version(mut self, input: impl ::std::convert::Into<::std::primitive::i32>) -> Self {
        self.version = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_version(mut self, input: ::std::option::Option<::std::primitive::i32>) -> Self {
        self.version = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_version(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.version
    }
    /// Consumes the builder and constructs a [`ResolveAttributesInput`](crate::operation::operation::ResolveAttributesInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::resolve_attributes::ResolveAttributesInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::resolve_attributes::ResolveAttributesInput {
                item: self.item,
                table_name: self.table_name,
                version: self.version,
            },
        )
    }
}
