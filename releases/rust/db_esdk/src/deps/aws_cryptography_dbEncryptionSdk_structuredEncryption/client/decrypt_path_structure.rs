// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::client::Client {
    /// Constructs a fluent builder for the [`DecryptPathStructure`](crate::operation::decrypt_path_structure::builders::DecryptPathStructureFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`cmm(impl Into<Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>>)`](crate::operation::decrypt_path_structure::builders::DecryptPathStructureFluentBuilder::cmm) / [`set_cmm(Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>)`](crate::operation::decrypt_path_structure::builders::DecryptPathStructureFluentBuilder::set_cmm): (undocumented)<br>
    ///   - [`encrypted_structure(impl Into<Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem>>>)`](crate::operation::decrypt_path_structure::builders::DecryptPathStructureFluentBuilder::encrypted_structure) / [`set_encrypted_structure(Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem>>)`](crate::operation::decrypt_path_structure::builders::DecryptPathStructureFluentBuilder::set_encrypted_structure): (undocumented)<br>
    ///   - [`encryption_context(impl Into<Option<::std::collections::HashMap<::std::string::String, ::std::string::String>>>)`](crate::operation::decrypt_path_structure::builders::DecryptPathStructureFluentBuilder::encryption_context) / [`set_encryption_context(Option<::std::collections::HashMap<::std::string::String, ::std::string::String>>)`](crate::operation::decrypt_path_structure::builders::DecryptPathStructureFluentBuilder::set_encryption_context): (undocumented)<br>
    ///   - [`table_name(impl Into<Option<::std::string::String>>)`](crate::operation::decrypt_path_structure::builders::DecryptPathStructureFluentBuilder::table_name) / [`set_table_name(Option<::std::string::String>)`](crate::operation::decrypt_path_structure::builders::DecryptPathStructureFluentBuilder::set_table_name): (undocumented)<br>
    /// - On success, responds with [`DecryptPathStructureOutput`](crate::operation::decrypt_path_structure::DecryptPathStructureOutput) with field(s):
    ///   - [`parsed_header(Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader>)`](crate::operation::decrypt_path_structure::DecryptPathStructureOutput::parsed_header): (undocumented)
    ///   - [`plaintext_structure(Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem>>)`](crate::operation::decrypt_path_structure::DecryptPathStructureOutput::plaintext_structure): (undocumented)
    /// - On failure, responds with [`SdkError<DecryptPathStructureError>`](crate::operation::decrypt_path_structure::DecryptPathStructureError)
    pub fn decrypt_path_structure(&self) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::builders::DecryptPathStructureFluentBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::builders::DecryptPathStructureFluentBuilder::new(self.clone())
    }
}
