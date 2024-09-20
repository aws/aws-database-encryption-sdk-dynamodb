// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &aws_sdk_dynamodb::types::KinesisStreamingDestinationInput,
) -> ::std::rc::Rc<crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::KinesisStreamingDestinationInput>{
  ::std::rc::Rc::new(
    crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::KinesisStreamingDestinationInput::KinesisStreamingDestinationInput {
        TableName: dafny_runtime::dafny_runtime_conversions::unicode_chars_false::string_to_dafny_string(&value.table_name),
 StreamArn: dafny_runtime::dafny_runtime_conversions::unicode_chars_false::string_to_dafny_string(&value.stream_arn),
    }
  )
} #[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::std::rc::Rc<
        crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::KinesisStreamingDestinationInput,
    >,
) -> aws_sdk_dynamodb::types::KinesisStreamingDestinationInput {
    aws_sdk_dynamodb::types::KinesisStreamingDestinationInput::builder()
          .set_table_name(Some( dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(dafny_value.TableName()) ))
 .set_stream_arn(Some( dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(dafny_value.StreamArn()) ))
          .build()
          .unwrap()
}
