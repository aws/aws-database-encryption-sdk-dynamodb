// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny_error(
    value: &::aws_smithy_runtime_api::client::result::SdkError<
        aws_sdk_kms::operation::create_grant::CreateGrantError,
        ::aws_smithy_runtime_api::client::orchestrator::HttpResponse,
    >,
) -> ::std::rc::Rc<crate::r#software::amazon::cryptography::services::kms::internaldafny::types::Error> {
    match value {
      aws_sdk_kms::error::SdkError::ServiceError(service_error) => match service_error.err() {
                aws_sdk_kms::operation::create_grant::CreateGrantError::DependencyTimeoutException(e) =>
            crate::deps::com_amazonaws_kms::conversions::error::dependency_timeout_exception::to_dafny(e.clone()),
         aws_sdk_kms::operation::create_grant::CreateGrantError::DisabledException(e) =>
            crate::deps::com_amazonaws_kms::conversions::error::disabled_exception::to_dafny(e.clone()),
         aws_sdk_kms::operation::create_grant::CreateGrantError::DryRunOperationException(e) =>
            crate::deps::com_amazonaws_kms::conversions::error::dry_run_operation_exception::to_dafny(e.clone()),
         aws_sdk_kms::operation::create_grant::CreateGrantError::InvalidArnException(e) =>
            crate::deps::com_amazonaws_kms::conversions::error::invalid_arn_exception::to_dafny(e.clone()),
         aws_sdk_kms::operation::create_grant::CreateGrantError::InvalidGrantTokenException(e) =>
            crate::deps::com_amazonaws_kms::conversions::error::invalid_grant_token_exception::to_dafny(e.clone()),
         aws_sdk_kms::operation::create_grant::CreateGrantError::KmsInternalException(e) =>
            crate::deps::com_amazonaws_kms::conversions::error::kms_internal_exception::to_dafny(e.clone()),
         aws_sdk_kms::operation::create_grant::CreateGrantError::KmsInvalidStateException(e) =>
            crate::deps::com_amazonaws_kms::conversions::error::kms_invalid_state_exception::to_dafny(e.clone()),
         aws_sdk_kms::operation::create_grant::CreateGrantError::LimitExceededException(e) =>
            crate::deps::com_amazonaws_kms::conversions::error::limit_exceeded_exception::to_dafny(e.clone()),
         aws_sdk_kms::operation::create_grant::CreateGrantError::NotFoundException(e) =>
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

 pub mod _create_grant_request;

 pub mod _create_grant_response;