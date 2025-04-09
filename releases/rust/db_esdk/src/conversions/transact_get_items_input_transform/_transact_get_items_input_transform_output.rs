// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::transact_get_items_input_transform::TransactGetItemsInputTransformOutput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactGetItemsInputTransformOutput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactGetItemsInputTransformOutput::TransactGetItemsInputTransformOutput {
        transformedInput: crate::deps::com_amazonaws_dynamodb::conversions::transact_get_items::_transact_get_items_request::to_dafny(&value.transformed_input.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactGetItemsInputTransformOutput,
    >,
) -> crate::operation::transact_get_items_input_transform::TransactGetItemsInputTransformOutput {
    crate::operation::transact_get_items_input_transform::TransactGetItemsInputTransformOutput::builder()
        .set_transformed_input(Some( crate::deps::com_amazonaws_dynamodb::conversions::transact_get_items::_transact_get_items_request::from_dafny(dafny_value.transformedInput().clone())
 ))
        .build()
        .unwrap()
}
