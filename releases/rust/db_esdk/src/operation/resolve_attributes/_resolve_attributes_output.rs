// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct ResolveAttributesOutput {
    /// Full plaintext of all calculable compound beacons.
    pub compound_beacons: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
    /// Full plaintext of all calculable virtual fields.
    pub virtual_fields: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
}
impl ResolveAttributesOutput {
    /// Full plaintext of all calculable compound beacons.
    pub fn compound_beacons(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    > {
        &self.compound_beacons
    }
    /// Full plaintext of all calculable virtual fields.
    pub fn virtual_fields(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    > {
        &self.virtual_fields
    }
}
impl ResolveAttributesOutput {
    /// Creates a new builder-style object to manufacture [`ResolveAttributesOutput`](crate::operation::resolve_attributes::builders::ResolveAttributesOutput).
    pub fn builder(
    ) -> crate::operation::resolve_attributes::builders::ResolveAttributesOutputBuilder {
        crate::operation::resolve_attributes::builders::ResolveAttributesOutputBuilder::default()
    }
}

/// A builder for [`ResolveAttributesOutput`](crate::operation::operation::ResolveAttributesOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct ResolveAttributesOutputBuilder {
    pub(crate) compound_beacons: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
    pub(crate) virtual_fields: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
}
impl ResolveAttributesOutputBuilder {
    /// Full plaintext of all calculable compound beacons.
    pub fn compound_beacons(
        mut self,
        input: impl ::std::convert::Into<
            ::std::collections::HashMap<::std::string::String, ::std::string::String>,
        >,
    ) -> Self {
        self.compound_beacons = ::std::option::Option::Some(input.into());
        self
    }
    /// Full plaintext of all calculable compound beacons.
    pub fn set_compound_beacons(
        mut self,
        input: ::std::option::Option<
            ::std::collections::HashMap<::std::string::String, ::std::string::String>,
        >,
    ) -> Self {
        self.compound_beacons = input;
        self
    }
    /// Full plaintext of all calculable compound beacons.
    pub fn get_compound_beacons(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    > {
        &self.compound_beacons
    }
    /// Full plaintext of all calculable virtual fields.
    pub fn virtual_fields(
        mut self,
        input: impl ::std::convert::Into<
            ::std::collections::HashMap<::std::string::String, ::std::string::String>,
        >,
    ) -> Self {
        self.virtual_fields = ::std::option::Option::Some(input.into());
        self
    }
    /// Full plaintext of all calculable virtual fields.
    pub fn set_virtual_fields(
        mut self,
        input: ::std::option::Option<
            ::std::collections::HashMap<::std::string::String, ::std::string::String>,
        >,
    ) -> Self {
        self.virtual_fields = input;
        self
    }
    /// Full plaintext of all calculable virtual fields.
    pub fn get_virtual_fields(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    > {
        &self.virtual_fields
    }
    /// Consumes the builder and constructs a [`ResolveAttributesOutput`](crate::operation::operation::ResolveAttributesOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::resolve_attributes::ResolveAttributesOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::resolve_attributes::ResolveAttributesOutput {
                compound_beacons: self.compound_beacons,
                virtual_fields: self.virtual_fields,
            },
        )
    }
}
