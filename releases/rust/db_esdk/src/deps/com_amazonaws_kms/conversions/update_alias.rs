// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny_error(
    value: &::aws_smithy_runtime_api::client::result::SdkError<
        aws_sdk_kms::operation::update_alias::UpdateAliasError,
        ::aws_smithy_runtime_api::client::orchestrator::HttpResponse,
    >,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::services::kms::internaldafny::types::Error,
> {
    match value {
      aws_sdk_kms::error::SdkError::ServiceError(service_error) => match service_error.err() {
                aws_sdk_kms::operation::update_alias::UpdateAliasError::DependencyTimeoutException(e) =>
            crate::deps::com_amazonaws_kms::conversions::error::dependency_timeout_exception::to_dafny(e.clone()),
         aws_sdk_kms::operation::update_alias::UpdateAliasError::KmsInternalException(e) =>
            crate::deps::com_amazonaws_kms::conversions::error::kms_internal_exception::to_dafny(e.clone()),
         aws_sdk_kms::operation::update_alias::UpdateAliasError::KmsInvalidStateException(e) =>
            crate::deps::com_amazonaws_kms::conversions::error::kms_invalid_state_exception::to_dafny(e.clone()),
         aws_sdk_kms::operation::update_alias::UpdateAliasError::LimitExceededException(e) =>
            crate::deps::com_amazonaws_kms::conversions::error::limit_exceeded_exception::to_dafny(e.clone()),
         aws_sdk_kms::operation::update_alias::UpdateAliasError::NotFoundException(e) =>
            crate::deps::com_amazonaws_kms::conversions::error::not_found_exception::to_dafny(e.clone()),
        e => {
          let msg = format!("{:?}", e);
          crate::deps::com_amazonaws_kms::conversions::error::to_opaque_error(msg)
        }
      },
      _ => {
        let msg = format!("{:?}", value);
        crate::deps::com_amazonaws_kms::conversions::error::to_opaque_error(msg)
      }
   }
}

pub mod _update_alias_request;
