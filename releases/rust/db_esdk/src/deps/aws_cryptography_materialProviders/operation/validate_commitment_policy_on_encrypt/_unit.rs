// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct Unit {}
impl Unit {}
impl Unit {
    /// Creates a new builder-style object to manufacture [`Unit`](crate::operation::validate_commitment_policy_on_encrypt::builders::Unit).
    pub fn builder() -> crate::deps::aws_cryptography_materialProviders::operation::validate_commitment_policy_on_encrypt::builders::UnitBuilder{
        crate::deps::aws_cryptography_materialProviders::operation::validate_commitment_policy_on_encrypt::builders::UnitBuilder::default()
    }
}

/// A builder for [`Unit`](crate::operation::operation::Unit).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct UnitBuilder {}
impl UnitBuilder {
    /// Consumes the builder and constructs a [`Unit`](crate::operation::operation::Unit).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_materialProviders::operation::validate_commitment_policy_on_encrypt::Unit,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_materialProviders::operation::validate_commitment_policy_on_encrypt::Unit {

        })
    }
}
