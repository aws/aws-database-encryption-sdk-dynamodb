// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct ScanOutputTransformInput {
    #[allow(missing_docs)]
    pub original_input: ::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanInput>,
    #[allow(missing_docs)]
    pub sdk_output: ::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanOutput>,
}
impl ScanOutputTransformInput {
    #[allow(missing_docs)]
    pub fn original_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanInput> {
        &self.original_input
    }
    #[allow(missing_docs)]
    pub fn sdk_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanOutput> {
        &self.sdk_output
    }
}
impl ScanOutputTransformInput {
    /// Creates a new builder-style object to manufacture [`ScanOutputTransformInput`](crate::operation::scan_output_transform::builders::ScanOutputTransformInput).
    pub fn builder(
    ) -> crate::operation::scan_output_transform::builders::ScanOutputTransformInputBuilder {
        crate::operation::scan_output_transform::builders::ScanOutputTransformInputBuilder::default(
        )
    }
}

/// A builder for [`ScanOutputTransformInput`](crate::operation::operation::ScanOutputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct ScanOutputTransformInputBuilder {
    pub(crate) original_input: ::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanInput>,
    pub(crate) sdk_output: ::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanOutput>,
}
impl ScanOutputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn original_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::scan::ScanInput>,
    ) -> Self {
        self.original_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_original_input(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanInput>,
    ) -> Self {
        self.original_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_original_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanInput> {
        &self.original_input
    }
    #[allow(missing_docs)]
    pub fn sdk_output(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::scan::ScanOutput>,
    ) -> Self {
        self.sdk_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_output(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanOutput>,
    ) -> Self {
        self.sdk_output = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanOutput> {
        &self.sdk_output
    }
    /// Consumes the builder and constructs a [`ScanOutputTransformInput`](crate::operation::operation::ScanOutputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::scan_output_transform::ScanOutputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::scan_output_transform::ScanOutputTransformInput {
                original_input: self.original_input,
                sdk_output: self.sdk_output,
            },
        )
    }
}
