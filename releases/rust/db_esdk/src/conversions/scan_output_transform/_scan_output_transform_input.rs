// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::scan_output_transform::ScanOutputTransformInput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ScanOutputTransformInput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ScanOutputTransformInput::ScanOutputTransformInput {
        sdkOutput: crate::deps::com_amazonaws_dynamodb::conversions::scan::_scan_response::to_dafny(&value.sdk_output.clone().unwrap())
,
 originalInput: crate::deps::com_amazonaws_dynamodb::conversions::scan::_scan_request::to_dafny(&value.original_input.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ScanOutputTransformInput,
    >,
) -> crate::operation::scan_output_transform::ScanOutputTransformInput {
    crate::operation::scan_output_transform::ScanOutputTransformInput::builder()
        .set_sdk_output(Some(
            crate::deps::com_amazonaws_dynamodb::conversions::scan::_scan_response::from_dafny(
                dafny_value.sdkOutput().clone(),
            ),
        ))
        .set_original_input(Some(
            crate::deps::com_amazonaws_dynamodb::conversions::scan::_scan_request::from_dafny(
                dafny_value.originalInput().clone(),
            ),
        ))
        .build()
        .unwrap()
}
