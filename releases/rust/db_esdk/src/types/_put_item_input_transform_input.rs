// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct PutItemInputTransformInput {
    #[allow(missing_docs)]
    pub sdk_input: ::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemInput>,
}
impl PutItemInputTransformInput {
    #[allow(missing_docs)]
    pub fn sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemInput> {
        &self.sdk_input
    }
}
impl PutItemInputTransformInput {
    /// Creates a new builder-style object to manufacture [`PutItemInputTransformInput`](crate::types::PutItemInputTransformInput).
    pub fn builder() -> crate::types::builders::PutItemInputTransformInputBuilder {
        crate::types::builders::PutItemInputTransformInputBuilder::default()
    }
}

/// A builder for [`PutItemInputTransformInput`](crate::types::PutItemInputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct PutItemInputTransformInputBuilder {
    pub(crate) sdk_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemInput>,
}
impl PutItemInputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn sdk_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::put_item::PutItemInput>,
    ) -> Self {
        self.sdk_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_input(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemInput>,
    ) -> Self {
        self.sdk_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemInput> {
        &self.sdk_input
    }
    /// Consumes the builder and constructs a [`PutItemInputTransformInput`](crate::types::PutItemInputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::PutItemInputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::PutItemInputTransformInput {
            sdk_input: self.sdk_input,
        })
    }
}
