// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`ScanInputTransform`](crate::operation::scan_input_transform::builders::ScanInputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`sdk_input(impl Into<Option<aws_sdk_dynamodb::operation::scan::ScanInput>>)`](crate::operation::scan_input_transform::builders::ScanInputTransformFluentBuilder::sdk_input) / [`set_sdk_input(Option<aws_sdk_dynamodb::operation::scan::ScanInput>)`](crate::operation::scan_input_transform::builders::ScanInputTransformFluentBuilder::set_sdk_input): (undocumented)<br>
    /// - On success, responds with [`ScanInputTransformOutput`](crate::operation::scan_input_transform::ScanInputTransformOutput) with field(s):
    ///   - [`transformed_input(Option<aws_sdk_dynamodb::operation::scan::ScanInput>)`](crate::operation::scan_input_transform::ScanInputTransformOutput::transformed_input): (undocumented)
    /// - On failure, responds with [`SdkError<ScanInputTransformError>`](crate::operation::scan_input_transform::ScanInputTransformError)
    pub fn scan_input_transform(
        &self,
    ) -> crate::operation::scan_input_transform::builders::ScanInputTransformFluentBuilder {
        crate::operation::scan_input_transform::builders::ScanInputTransformFluentBuilder::new(
            self.clone(),
        )
    }
}
