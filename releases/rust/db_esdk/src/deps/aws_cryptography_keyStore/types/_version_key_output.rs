// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct VersionKeyOutput {}
impl VersionKeyOutput {}
impl VersionKeyOutput {
    /// Creates a new builder-style object to manufacture [`VersionKeyOutput`](crate::deps::aws_cryptography_keyStore::types::VersionKeyOutput).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_keyStore::types::builders::VersionKeyOutputBuilder {
        crate::deps::aws_cryptography_keyStore::types::builders::VersionKeyOutputBuilder::default()
    }
}

/// A builder for [`VersionKeyOutput`](crate::deps::aws_cryptography_keyStore::types::VersionKeyOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct VersionKeyOutputBuilder {}
impl VersionKeyOutputBuilder {
    /// Consumes the builder and constructs a [`VersionKeyOutput`](crate::deps::aws_cryptography_keyStore::types::VersionKeyOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_keyStore::types::VersionKeyOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_keyStore::types::VersionKeyOutput {},
        )
    }
}