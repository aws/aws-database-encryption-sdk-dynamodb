// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &aws_sdk_dynamodb::operation::describe_export::DescribeExportOutput
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::DescribeExportOutput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::DescribeExportOutput::DescribeExportOutput {
        ExportDescription: ::dafny_runtime::Rc::new(match &value.export_description {
    Some(x) => crate::_Wrappers_Compile::Option::Some { value: crate::deps::com_amazonaws_dynamodb::conversions::export_description::to_dafny(x) },
    None => crate::_Wrappers_Compile::Option::None { }
})
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::DescribeExportOutput,
    >,
) -> aws_sdk_dynamodb::operation::describe_export::DescribeExportOutput {
    aws_sdk_dynamodb::operation::describe_export::DescribeExportOutput::builder()
        .set_export_description(match (*dafny_value.ExportDescription()).as_ref() {
            crate::r#_Wrappers_Compile::Option::Some { value } => Some(
                crate::deps::com_amazonaws_dynamodb::conversions::export_description::from_dafny(
                    value.clone(),
                ),
            ),
            _ => None,
        })
        .build()
}
