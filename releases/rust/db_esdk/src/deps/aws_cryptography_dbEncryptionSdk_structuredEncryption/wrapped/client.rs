// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
use std::sync::LazyLock;

pub struct Client {
    wrapped: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::client::Client
}

/// A runtime for executing operations on the asynchronous client in a blocking manner.
/// Necessary because Dafny only generates synchronous code.
static dafny_tokio_runtime: LazyLock<tokio::runtime::Runtime> = LazyLock::new(|| {
    tokio::runtime::Builder::new_multi_thread()
          .enable_all()
          .build()
          .unwrap()
});

impl dafny_runtime::UpcastObject<dyn crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::IStructuredEncryptionClient> for Client {
  ::dafny_runtime::UpcastObjectFn!(dyn crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::IStructuredEncryptionClient);
}

impl dafny_runtime::UpcastObject<dyn std::any::Any> for Client {
    ::dafny_runtime::UpcastObjectFn!(dyn ::std::any::Any);
}

impl Client {
  pub fn from_conf(config: &::std::rc::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::StructuredEncryptionConfig,
  >) ->
::std::rc::Rc<crate::r#_Wrappers_Compile::Result<
  ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::IStructuredEncryptionClient>,
  ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::Error>
>> {
    let result = crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::client::Client::from_conf(
      crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::structured_encryption_config::_structured_encryption_config::from_dafny(
          config.clone(),
      ),
    );
    match result {
      Ok(client) =>  {
        let wrap = crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::wrapped::client::Client {
          wrapped: client
        };
        std::rc::Rc::new(
          crate::_Wrappers_Compile::Result::Success {
            value: ::dafny_runtime::upcast_object()(::dafny_runtime::object::new(wrap))
          }
        )
      },
      Err(error) => crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::error::to_opaque_error_result(error)
    }
  }
}

impl crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::IStructuredEncryptionClient for Client {
    fn ResolveAuthActions(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::ResolveAuthActionsOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::resolve_auth_actions::_resolve_auth_actions_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::ResolveAuthActions::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::resolve_auth_actions::_resolve_auth_actions_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn DecryptStructure(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::DecryptStructureInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::DecryptStructureOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::decrypt_structure::_decrypt_structure_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_structure::DecryptStructure::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::decrypt_structure::_decrypt_structure_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn DecryptPathStructure(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::DecryptPathStructureInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::DecryptPathStructureOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::decrypt_path_structure::_decrypt_path_structure_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::DecryptPathStructure::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::decrypt_path_structure::_decrypt_path_structure_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn EncryptStructure(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::EncryptStructureInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::EncryptStructureOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::encrypt_structure::_encrypt_structure_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::encrypt_structure::EncryptStructure::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::encrypt_structure::_encrypt_structure_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn EncryptPathStructure(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::EncryptPathStructureInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::EncryptPathStructureOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::encrypt_path_structure::_encrypt_path_structure_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::encrypt_path_structure::EncryptPathStructure::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::encrypt_path_structure::_encrypt_path_structure_output::to_dafny(inner_result),
                },
            ),
        }
    }
}
