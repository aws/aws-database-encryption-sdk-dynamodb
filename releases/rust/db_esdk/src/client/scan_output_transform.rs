// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`ScanOutputTransform`](crate::operation::scan_output_transform::builders::ScanOutputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`original_input(impl Into<Option<aws_sdk_dynamodb::operation::scan::ScanInput>>)`](crate::operation::scan_output_transform::builders::ScanOutputTransformFluentBuilder::original_input) / [`set_original_input(Option<aws_sdk_dynamodb::operation::scan::ScanInput>)`](crate::operation::scan_output_transform::builders::ScanOutputTransformFluentBuilder::set_original_input): (undocumented)<br>
    ///   - [`sdk_output(impl Into<Option<aws_sdk_dynamodb::operation::scan::ScanOutput>>)`](crate::operation::scan_output_transform::builders::ScanOutputTransformFluentBuilder::sdk_output) / [`set_sdk_output(Option<aws_sdk_dynamodb::operation::scan::ScanOutput>)`](crate::operation::scan_output_transform::builders::ScanOutputTransformFluentBuilder::set_sdk_output): (undocumented)<br>
    /// - On success, responds with [`ScanOutputTransformOutput`](crate::operation::scan_output_transform::ScanOutputTransformOutput) with field(s):
    ///   - [`transformed_output(Option<aws_sdk_dynamodb::operation::scan::ScanOutput>)`](crate::operation::scan_output_transform::ScanOutputTransformOutput::transformed_output): (undocumented)
    /// - On failure, responds with [`SdkError<ScanOutputTransformError>`](crate::operation::scan_output_transform::ScanOutputTransformError)
    pub fn scan_output_transform(
        &self,
    ) -> crate::operation::scan_output_transform::builders::ScanOutputTransformFluentBuilder {
        crate::operation::scan_output_transform::builders::ScanOutputTransformFluentBuilder::new(
            self.clone(),
        )
    }
}
