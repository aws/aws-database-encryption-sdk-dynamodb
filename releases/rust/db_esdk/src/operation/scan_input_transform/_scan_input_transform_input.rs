// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct ScanInputTransformInput {
    #[allow(missing_docs)]
    pub sdk_input: ::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanInput>,
}
impl ScanInputTransformInput {
    #[allow(missing_docs)]
    pub fn sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanInput> {
        &self.sdk_input
    }
}
impl ScanInputTransformInput {
    /// Creates a new builder-style object to manufacture [`ScanInputTransformInput`](crate::operation::scan_input_transform::builders::ScanInputTransformInput).
    pub fn builder(
    ) -> crate::operation::scan_input_transform::builders::ScanInputTransformInputBuilder {
        crate::operation::scan_input_transform::builders::ScanInputTransformInputBuilder::default()
    }
}

/// A builder for [`ScanInputTransformInput`](crate::operation::operation::ScanInputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct ScanInputTransformInputBuilder {
    pub(crate) sdk_input: ::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanInput>,
}
impl ScanInputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn sdk_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::scan::ScanInput>,
    ) -> Self {
        self.sdk_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_input(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanInput>,
    ) -> Self {
        self.sdk_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanInput> {
        &self.sdk_input
    }
    /// Consumes the builder and constructs a [`ScanInputTransformInput`](crate::operation::operation::ScanInputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::scan_input_transform::ScanInputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::scan_input_transform::ScanInputTransformInput {
                sdk_input: self.sdk_input,
            },
        )
    }
}
