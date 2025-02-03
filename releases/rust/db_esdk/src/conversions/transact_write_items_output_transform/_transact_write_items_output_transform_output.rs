// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransformOutput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsOutputTransformOutput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsOutputTransformOutput::TransactWriteItemsOutputTransformOutput {
        transformedOutput: crate::deps::com_amazonaws_dynamodb::conversions::transact_write_items::_transact_write_items_response::to_dafny(&value.transformed_output.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsOutputTransformOutput,
    >,
) -> crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransformOutput
{
    crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransformOutput::builder()
        .set_transformed_output(Some( crate::deps::com_amazonaws_dynamodb::conversions::transact_write_items::_transact_write_items_response::from_dafny(dafny_value.transformedOutput().clone())
 ))
        .build()
        .unwrap()
}
