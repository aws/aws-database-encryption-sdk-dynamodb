// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct ResolveAttributesOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub compound_beacons: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
    #[allow(missing_docs)] // documentation missing in model
    pub virtual_fields: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
}
impl ResolveAttributesOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn compound_beacons(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    > {
        &self.compound_beacons
    }
    #[allow(missing_docs)] // documentation missing in model
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
    #[allow(missing_docs)] // documentation missing in model
    pub fn compound_beacons(
        mut self,
        input: impl ::std::convert::Into<
            ::std::collections::HashMap<::std::string::String, ::std::string::String>,
        >,
    ) -> Self {
        self.compound_beacons = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_compound_beacons(
        mut self,
        input: ::std::option::Option<
            ::std::collections::HashMap<::std::string::String, ::std::string::String>,
        >,
    ) -> Self {
        self.compound_beacons = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_compound_beacons(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    > {
        &self.compound_beacons
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn virtual_fields(
        mut self,
        input: impl ::std::convert::Into<
            ::std::collections::HashMap<::std::string::String, ::std::string::String>,
        >,
    ) -> Self {
        self.virtual_fields = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_virtual_fields(
        mut self,
        input: ::std::option::Option<
            ::std::collections::HashMap<::std::string::String, ::std::string::String>,
        >,
    ) -> Self {
        self.virtual_fields = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
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
