// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`ResolveAttributes`](crate::operation::resolve_attributes::builders::ResolveAttributesFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`item(impl Into<Option<::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>>>)`](crate::operation::resolve_attributes::builders::ResolveAttributesFluentBuilder::item) / [`set_item(Option<::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>>)`](crate::operation::resolve_attributes::builders::ResolveAttributesFluentBuilder::set_item): (undocumented)<br>
    ///   - [`table_name(impl Into<Option<::std::string::String>>)`](crate::operation::resolve_attributes::builders::ResolveAttributesFluentBuilder::table_name) / [`set_table_name(Option<::std::string::String>)`](crate::operation::resolve_attributes::builders::ResolveAttributesFluentBuilder::set_table_name): (undocumented)<br>
    ///   - [`version(impl Into<Option<::std::primitive::i32>>)`](crate::operation::resolve_attributes::builders::ResolveAttributesFluentBuilder::version) / [`set_version(Option<::std::primitive::i32>)`](crate::operation::resolve_attributes::builders::ResolveAttributesFluentBuilder::set_version): (undocumented)<br>
    /// - On success, responds with [`ResolveAttributesOutput`](crate::operation::resolve_attributes::ResolveAttributesOutput) with field(s):
    ///   - [`compound_beacons(Option<::std::collections::HashMap<::std::string::String, ::std::string::String>>)`](crate::operation::resolve_attributes::ResolveAttributesOutput::compound_beacons): (undocumented)
    ///   - [`virtual_fields(Option<::std::collections::HashMap<::std::string::String, ::std::string::String>>)`](crate::operation::resolve_attributes::ResolveAttributesOutput::virtual_fields): (undocumented)
    /// - On failure, responds with [`SdkError<ResolveAttributesError>`](crate::operation::resolve_attributes::ResolveAttributesError)
    pub fn resolve_attributes(
        &self,
    ) -> crate::operation::resolve_attributes::builders::ResolveAttributesFluentBuilder {
        crate::operation::resolve_attributes::builders::ResolveAttributesFluentBuilder::new(
            self.clone(),
        )
    }
}
