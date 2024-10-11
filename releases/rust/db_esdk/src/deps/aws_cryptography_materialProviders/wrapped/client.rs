// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
use std::sync::LazyLock;

pub struct Client {
    wrapped: crate::deps::aws_cryptography_materialProviders::client::Client
}

/// A runtime for executing operations on the asynchronous client in a blocking manner.
/// Necessary because Dafny only generates synchronous code.
static dafny_tokio_runtime: LazyLock<tokio::runtime::Runtime> = LazyLock::new(|| {
    tokio::runtime::Builder::new_multi_thread()
          .enable_all()
          .build()
          .unwrap()
});

impl dafny_runtime::UpcastObject<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IAwsCryptographicMaterialProvidersClient> for Client {
  ::dafny_runtime::UpcastObjectFn!(dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IAwsCryptographicMaterialProvidersClient);
}

impl dafny_runtime::UpcastObject<dyn std::any::Any> for Client {
    ::dafny_runtime::UpcastObjectFn!(dyn ::std::any::Any);
}

impl Client {
  pub fn from_conf(config: &::std::rc::Rc<
    crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::MaterialProvidersConfig,
  >) ->
::std::rc::Rc<crate::r#_Wrappers_Compile::Result<
  ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IAwsCryptographicMaterialProvidersClient>,
  ::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>
>> {
    let result = crate::deps::aws_cryptography_materialProviders::client::Client::from_conf(
      crate::deps::aws_cryptography_materialProviders::conversions::material_providers_config::_material_providers_config::from_dafny(
          config.clone(),
      ),
    );
    match result {
      Ok(client) =>  {
        let wrap = crate::deps::aws_cryptography_materialProviders::wrapped::client::Client {
          wrapped: client
        };
        std::rc::Rc::new(
          crate::_Wrappers_Compile::Result::Success {
            value: ::dafny_runtime::upcast_object()(::dafny_runtime::object::new(wrap))
          }
        )
      },
      Err(error) => crate::deps::aws_cryptography_materialProviders::conversions::error::to_opaque_error_result(error)
    }
  }
}

impl crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IAwsCryptographicMaterialProvidersClient for Client {
    fn CreateAwsKmsHierarchicalKeyring(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateAwsKmsHierarchicalKeyringInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IKeyring>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_aws_kms_hierarchical_keyring::_create_aws_kms_hierarchical_keyring_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_aws_kms_hierarchical_keyring::CreateAwsKmsHierarchicalKeyring::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::keyring::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn CreateAwsKmsKeyring(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateAwsKmsKeyringInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IKeyring>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_aws_kms_keyring::_create_aws_kms_keyring_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_aws_kms_keyring::CreateAwsKmsKeyring::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::keyring::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn ValidAlgorithmSuiteInfo(
        &self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::AlgorithmSuiteInfo>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            (),
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::valid_algorithm_suite_info::_valid_algorithm_suite_info_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::valid_algorithm_suite_info::ValidAlgorithmSuiteInfo::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: (),
                },
            ),
        }
    }

    fn CreateRawAesKeyring(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateRawAesKeyringInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IKeyring>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_raw_aes_keyring::_create_raw_aes_keyring_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_raw_aes_keyring::CreateRawAesKeyring::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::keyring::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn CreateRawRsaKeyring(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateRawRsaKeyringInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IKeyring>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_raw_rsa_keyring::_create_raw_rsa_keyring_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_raw_rsa_keyring::CreateRawRsaKeyring::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::keyring::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn CreateAwsKmsMrkKeyring(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateAwsKmsMrkKeyringInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IKeyring>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_aws_kms_mrk_keyring::_create_aws_kms_mrk_keyring_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_aws_kms_mrk_keyring::CreateAwsKmsMrkKeyring::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::keyring::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn CreateAwsKmsMrkMultiKeyring(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateAwsKmsMrkMultiKeyringInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IKeyring>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_aws_kms_mrk_multi_keyring::_create_aws_kms_mrk_multi_keyring_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_aws_kms_mrk_multi_keyring::CreateAwsKmsMrkMultiKeyring::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::keyring::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn ValidEncryptionMaterialsTransition(
        &self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::ValidEncryptionMaterialsTransitionInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            (),
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::valid_encryption_materials_transition::_valid_encryption_materials_transition_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::valid_encryption_materials_transition::ValidEncryptionMaterialsTransition::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: (),
                },
            ),
        }
    }

    fn CreateDefaultCryptographicMaterialsManager(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateDefaultCryptographicMaterialsManagerInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::ICryptographicMaterialsManager>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_default_cryptographic_materials_manager::_create_default_cryptographic_materials_manager_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_default_cryptographic_materials_manager::CreateDefaultCryptographicMaterialsManager::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::cryptographic_materials_manager::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn CreateCryptographicMaterialsCache(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateCryptographicMaterialsCacheInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::ICryptographicMaterialsCache>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_cryptographic_materials_cache::_create_cryptographic_materials_cache_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_cryptographic_materials_cache::CreateCryptographicMaterialsCache::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::cryptographic_materials_cache::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn CreateAwsKmsDiscoveryMultiKeyring(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateAwsKmsDiscoveryMultiKeyringInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IKeyring>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_aws_kms_discovery_multi_keyring::_create_aws_kms_discovery_multi_keyring_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_aws_kms_discovery_multi_keyring::CreateAwsKmsDiscoveryMultiKeyring::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::keyring::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn ValidDecryptionMaterialsTransition(
        &self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::ValidDecryptionMaterialsTransitionInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            (),
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::valid_decryption_materials_transition::_valid_decryption_materials_transition_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::valid_decryption_materials_transition::ValidDecryptionMaterialsTransition::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: (),
                },
            ),
        }
    }

    fn InitializeEncryptionMaterials(
        &self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::InitializeEncryptionMaterialsInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::EncryptionMaterials>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::initialize_encryption_materials::_initialize_encryption_materials_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::initialize_encryption_materials::InitializeEncryptionMaterials::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::initialize_encryption_materials::_initialize_encryption_materials_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn CreateAwsKmsMultiKeyring(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateAwsKmsMultiKeyringInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IKeyring>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_aws_kms_multi_keyring::_create_aws_kms_multi_keyring_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_aws_kms_multi_keyring::CreateAwsKmsMultiKeyring::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::keyring::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn CreateMultiKeyring(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateMultiKeyringInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IKeyring>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_multi_keyring::_create_multi_keyring_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_multi_keyring::CreateMultiKeyring::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::keyring::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn CreateAwsKmsMrkDiscoveryKeyring(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateAwsKmsMrkDiscoveryKeyringInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IKeyring>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_aws_kms_mrk_discovery_keyring::_create_aws_kms_mrk_discovery_keyring_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_aws_kms_mrk_discovery_keyring::CreateAwsKmsMrkDiscoveryKeyring::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::keyring::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn ValidateCommitmentPolicyOnDecrypt(
        &self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::ValidateCommitmentPolicyOnDecryptInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            (),
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::validate_commitment_policy_on_decrypt::_validate_commitment_policy_on_decrypt_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::validate_commitment_policy_on_decrypt::ValidateCommitmentPolicyOnDecrypt::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: (),
                },
            ),
        }
    }

    fn CreateRawEcdhKeyring(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateRawEcdhKeyringInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IKeyring>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_raw_ecdh_keyring::_create_raw_ecdh_keyring_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_raw_ecdh_keyring::CreateRawEcdhKeyring::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::keyring::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn CreateAwsKmsDiscoveryKeyring(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateAwsKmsDiscoveryKeyringInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IKeyring>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_aws_kms_discovery_keyring::_create_aws_kms_discovery_keyring_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_aws_kms_discovery_keyring::CreateAwsKmsDiscoveryKeyring::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::keyring::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn CreateAwsKmsRsaKeyring(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateAwsKmsRsaKeyringInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IKeyring>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_aws_kms_rsa_keyring::_create_aws_kms_rsa_keyring_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_aws_kms_rsa_keyring::CreateAwsKmsRsaKeyring::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::keyring::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn ValidateCommitmentPolicyOnEncrypt(
        &self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::ValidateCommitmentPolicyOnEncryptInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            (),
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::validate_commitment_policy_on_encrypt::_validate_commitment_policy_on_encrypt_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::validate_commitment_policy_on_encrypt::ValidateCommitmentPolicyOnEncrypt::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: (),
                },
            ),
        }
    }

    fn CreateDefaultClientSupplier(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateDefaultClientSupplierInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IClientSupplier>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_default_client_supplier::_create_default_client_supplier_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_default_client_supplier::CreateDefaultClientSupplier::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::client_supplier::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn InitializeDecryptionMaterials(
        &self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::InitializeDecryptionMaterialsInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::DecryptionMaterials>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::initialize_decryption_materials::_initialize_decryption_materials_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::initialize_decryption_materials::InitializeDecryptionMaterials::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::initialize_decryption_materials::_initialize_decryption_materials_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn EncryptionMaterialsHasPlaintextDataKey(
        &self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::EncryptionMaterials>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            (),
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::encryption_materials_has_plaintext_data_key::_encryption_materials_has_plaintext_data_key_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::encryption_materials_has_plaintext_data_key::EncryptionMaterialsHasPlaintextDataKey::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: (),
                },
            ),
        }
    }

    fn CreateRequiredEncryptionContextCMM(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateRequiredEncryptionContextCMMInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::ICryptographicMaterialsManager>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_required_encryption_context_cmm::_create_required_encryption_context_cmm_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_required_encryption_context_cmm::CreateRequiredEncryptionContextCmm::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::cryptographic_materials_manager::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn CreateAwsKmsEcdhKeyring(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateAwsKmsEcdhKeyringInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IKeyring>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_aws_kms_ecdh_keyring::_create_aws_kms_ecdh_keyring_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_aws_kms_ecdh_keyring::CreateAwsKmsEcdhKeyring::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::keyring::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }

    fn DecryptionMaterialsWithPlaintextDataKey(
        &self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::DecryptionMaterials>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            (),
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::decryption_materials_with_plaintext_data_key::_decryption_materials_with_plaintext_data_key_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::decryption_materials_with_plaintext_data_key::DecryptionMaterialsWithPlaintextDataKey::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: (),
                },
            ),
        }
    }

    fn GetAlgorithmSuiteInfo(
        &self,
        input: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::AlgorithmSuiteInfo>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::operation::get_algorithm_suite_info::_get_algorithm_suite_info_input::GetAlgorithmSuiteInfoInput {
  binary_id: Some(crate::standard_library_conversions::blob_from_dafny(input.clone()))
};
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::get_algorithm_suite_info::GetAlgorithmSuiteInfo::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::get_algorithm_suite_info::_get_algorithm_suite_info_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn CreateAwsKmsMrkDiscoveryMultiKeyring(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::CreateAwsKmsMrkDiscoveryMultiKeyringInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::IKeyring>,
            std::rc::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_materialProviders::conversions::create_aws_kms_mrk_discovery_multi_keyring::_create_aws_kms_mrk_discovery_multi_keyring_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_materialProviders::operation::create_aws_kms_mrk_discovery_multi_keyring::CreateAwsKmsMrkDiscoveryMultiKeyring::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_materialProviders::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_materialProviders::conversions::keyring::to_dafny(&inner_result.clone())
,
                },
            ),
        }
    }
}
