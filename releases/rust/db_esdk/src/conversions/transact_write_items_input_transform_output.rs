// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::types::TransactWriteItemsInputTransformOutput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsInputTransformOutput,
>{
    ::dafny_runtime::Rc::new(to_dafny_plain(value.clone()))
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::types::TransactWriteItemsInputTransformOutput,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsInputTransformOutput{
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsInputTransformOutput::TransactWriteItemsInputTransformOutput {
        transformedInput: crate::deps::com_amazonaws_dynamodb::conversions::transact_write_items::_transact_write_items_request::to_dafny(&value.transformed_input.clone().unwrap())
,
    }
}

#[allow(dead_code)]
pub fn option_to_dafny(
  value: ::std::option::Option<crate::types::TransactWriteItemsInputTransformOutput>,
) -> ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
  crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsInputTransformOutput,
>>>{
    ::dafny_runtime::Rc::new(match value {
        ::std::option::Option::None => crate::_Wrappers_Compile::Option::None {},
        ::std::option::Option::Some(x) => crate::_Wrappers_Compile::Option::Some {
            value: ::dafny_runtime::Rc::new(to_dafny_plain(x)),
        },
    })
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsInputTransformOutput,
    >,
) -> crate::types::TransactWriteItemsInputTransformOutput {
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsInputTransformOutput,
) -> crate::types::TransactWriteItemsInputTransformOutput {
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsInputTransformOutput::TransactWriteItemsInputTransformOutput {..} =>
            crate::types::TransactWriteItemsInputTransformOutput::builder()
                .set_transformed_input(Some( crate::deps::com_amazonaws_dynamodb::conversions::transact_write_items::_transact_write_items_request::from_dafny(dafny_value.transformedInput().clone())
 ))
                .build()
                .unwrap()
    }
}

#[allow(dead_code)]
pub fn option_from_dafny(
    dafny_value: ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsInputTransformOutput,
    >>>,
) -> ::std::option::Option<crate::types::TransactWriteItemsInputTransformOutput> {
    match &*dafny_value {
        crate::_Wrappers_Compile::Option::Some { value } => {
            ::std::option::Option::Some(plain_from_dafny(value))
        }
        _ => ::std::option::Option::None,
    }
}
