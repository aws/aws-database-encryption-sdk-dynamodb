// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct ScanOutputTransformOutput {
    #[allow(missing_docs)]
pub transformed_output: ::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanOutput>,
}
impl ScanOutputTransformOutput {
    #[allow(missing_docs)]
pub fn transformed_output(&self) -> &::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanOutput> {
    &self.transformed_output
}
}
impl ScanOutputTransformOutput {
    /// Creates a new builder-style object to manufacture [`ScanOutputTransformOutput`](crate::types::ScanOutputTransformOutput).
    pub fn builder() -> crate::types::builders::ScanOutputTransformOutputBuilder {
        crate::types::builders::ScanOutputTransformOutputBuilder::default()
    }
}

/// A builder for [`ScanOutputTransformOutput`](crate::types::ScanOutputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct ScanOutputTransformOutputBuilder {
    pub(crate) transformed_output: ::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanOutput>,
}
impl ScanOutputTransformOutputBuilder {
    #[allow(missing_docs)]
pub fn transformed_output(mut self, input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::scan::ScanOutput>) -> Self {
    self.transformed_output = ::std::option::Option::Some(input.into());
    self
}
#[allow(missing_docs)]
pub fn set_transformed_output(mut self, input: ::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanOutput>) -> Self {
    self.transformed_output = input;
    self
}
#[allow(missing_docs)]
pub fn get_transformed_output(&self) -> &::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanOutput> {
    &self.transformed_output
}
    /// Consumes the builder and constructs a [`ScanOutputTransformOutput`](crate::types::ScanOutputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::ScanOutputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::ScanOutputTransformOutput {
            transformed_output: self.transformed_output,
        })
    }
}
