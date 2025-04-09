// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct DeleteItemInputTransformOutput {
    #[allow(missing_docs)]
    pub transformed_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>,
}
impl DeleteItemInputTransformOutput {
    #[allow(missing_docs)]
    pub fn transformed_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput> {
        &self.transformed_input
    }
}
impl DeleteItemInputTransformOutput {
    /// Creates a new builder-style object to manufacture [`DeleteItemInputTransformOutput`](crate::types::DeleteItemInputTransformOutput).
    pub fn builder() -> crate::types::builders::DeleteItemInputTransformOutputBuilder {
        crate::types::builders::DeleteItemInputTransformOutputBuilder::default()
    }
}

/// A builder for [`DeleteItemInputTransformOutput`](crate::types::DeleteItemInputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct DeleteItemInputTransformOutputBuilder {
    pub(crate) transformed_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>,
}
impl DeleteItemInputTransformOutputBuilder {
    #[allow(missing_docs)]
    pub fn transformed_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>,
    ) -> Self {
        self.transformed_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_transformed_input(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>,
    ) -> Self {
        self.transformed_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_transformed_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput> {
        &self.transformed_input
    }
    /// Consumes the builder and constructs a [`DeleteItemInputTransformOutput`](crate::types::DeleteItemInputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::DeleteItemInputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::DeleteItemInputTransformOutput {
            transformed_input: self.transformed_input,
        })
    }
}
