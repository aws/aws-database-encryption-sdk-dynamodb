// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &aws_sdk_dynamodb::operation::list_tags_of_resource::ListTagsOfResourceOutput
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::ListTagsOfResourceOutput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::ListTagsOfResourceOutput::ListTagsOfResourceOutput {
        Tags: ::dafny_runtime::Rc::new(match &value.tags {
    Some(x) => crate::r#_Wrappers_Compile::Option::Some { value :
        ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(x,
            |e| crate::deps::com_amazonaws_dynamodb::conversions::tag::to_dafny(e)
,
        )
    },
    None => crate::r#_Wrappers_Compile::Option::None {}
})
,
 NextToken: crate::standard_library_conversions::ostring_to_dafny(&value.next_token),
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::ListTagsOfResourceOutput,
    >,
) -> aws_sdk_dynamodb::operation::list_tags_of_resource::ListTagsOfResourceOutput {
    aws_sdk_dynamodb::operation::list_tags_of_resource::ListTagsOfResourceOutput::builder()
          .set_tags(match (*dafny_value.Tags()).as_ref() {
    crate::r#_Wrappers_Compile::Option::Some { value } =>
        Some(
            ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(value,
                |e: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::Tag>| crate::deps::com_amazonaws_dynamodb::conversions::tag::from_dafny(e.clone())
,
            )
        ),
    _ => None
}
)
 .set_next_token(crate::standard_library_conversions::ostring_from_dafny(dafny_value.NextToken().clone()))
          .build()
}
