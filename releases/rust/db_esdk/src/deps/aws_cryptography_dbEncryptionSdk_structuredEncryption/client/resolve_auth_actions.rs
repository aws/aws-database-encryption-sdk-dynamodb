// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::client::Client {
    /// Constructs a fluent builder for the [`ResolveAuthActions`](crate::operation::resolve_auth_actions::builders::ResolveAuthActionsFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`auth_actions(impl Into<Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem>>>)`](crate::operation::resolve_auth_actions::builders::ResolveAuthActionsFluentBuilder::auth_actions) / [`set_auth_actions(Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem>>)`](crate::operation::resolve_auth_actions::builders::ResolveAuthActionsFluentBuilder::set_auth_actions): (undocumented)<br>
    ///   - [`header_bytes(impl Into<Option<::aws_smithy_types::Blob>>)`](crate::operation::resolve_auth_actions::builders::ResolveAuthActionsFluentBuilder::header_bytes) / [`set_header_bytes(Option<::aws_smithy_types::Blob>)`](crate::operation::resolve_auth_actions::builders::ResolveAuthActionsFluentBuilder::set_header_bytes): (undocumented)<br>
    ///   - [`table_name(impl Into<Option<::std::string::String>>)`](crate::operation::resolve_auth_actions::builders::ResolveAuthActionsFluentBuilder::table_name) / [`set_table_name(Option<::std::string::String>)`](crate::operation::resolve_auth_actions::builders::ResolveAuthActionsFluentBuilder::set_table_name): (undocumented)<br>
    /// - On success, responds with [`ResolveAuthActionsOutput`](crate::operation::resolve_auth_actions::ResolveAuthActionsOutput) with field(s):
    ///   - [`crypto_actions(Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem>>)`](crate::operation::resolve_auth_actions::ResolveAuthActionsOutput::crypto_actions): (undocumented)
    /// - On failure, responds with [`SdkError<ResolveAuthActionsError>`](crate::operation::resolve_auth_actions::ResolveAuthActionsError)
    pub fn resolve_auth_actions(&self) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::builders::ResolveAuthActionsFluentBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::builders::ResolveAuthActionsFluentBuilder::new(self.clone())
    }
}
