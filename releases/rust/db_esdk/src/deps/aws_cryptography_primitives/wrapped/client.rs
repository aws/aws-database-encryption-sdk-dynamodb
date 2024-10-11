// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
use std::sync::LazyLock;

pub struct Client {
    wrapped: crate::deps::aws_cryptography_primitives::client::Client
}

/// A runtime for executing operations on the asynchronous client in a blocking manner.
/// Necessary because Dafny only generates synchronous code.
static dafny_tokio_runtime: LazyLock<tokio::runtime::Runtime> = LazyLock::new(|| {
    tokio::runtime::Builder::new_multi_thread()
          .enable_all()
          .build()
          .unwrap()
});

impl dafny_runtime::UpcastObject<dyn crate::r#software::amazon::cryptography::primitives::internaldafny::types::IAwsCryptographicPrimitivesClient> for Client {
  ::dafny_runtime::UpcastObjectFn!(dyn crate::r#software::amazon::cryptography::primitives::internaldafny::types::IAwsCryptographicPrimitivesClient);
}

impl dafny_runtime::UpcastObject<dyn std::any::Any> for Client {
    ::dafny_runtime::UpcastObjectFn!(dyn ::std::any::Any);
}

impl Client {
  pub fn from_conf(config: &::std::rc::Rc<
    crate::r#software::amazon::cryptography::primitives::internaldafny::types::CryptoConfig,
  >) ->
::std::rc::Rc<crate::r#_Wrappers_Compile::Result<
  ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::primitives::internaldafny::types::IAwsCryptographicPrimitivesClient>,
  ::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>
>> {
    let result = crate::deps::aws_cryptography_primitives::client::Client::from_conf(
      crate::deps::aws_cryptography_primitives::conversions::crypto_config::_crypto_config::from_dafny(
          config.clone(),
      ),
    );
    match result {
      Ok(client) =>  {
        let wrap = crate::deps::aws_cryptography_primitives::wrapped::client::Client {
          wrapped: client
        };
        std::rc::Rc::new(
          crate::_Wrappers_Compile::Result::Success {
            value: ::dafny_runtime::upcast_object()(::dafny_runtime::object::new(wrap))
          }
        )
      },
      Err(error) => crate::deps::aws_cryptography_primitives::conversions::error::to_opaque_error_result(error)
    }
  }
}

impl crate::r#software::amazon::cryptography::primitives::internaldafny::types::IAwsCryptographicPrimitivesClient for Client {
    fn GenerateRSAKeyPair(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::GenerateRSAKeyPairInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::GenerateRSAKeyPairOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::generate_rsa_key_pair::_generate_rsa_key_pair_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::generate_rsa_key_pair::GenerateRsaKeyPair::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_primitives::conversions::generate_rsa_key_pair::_generate_rsa_key_pair_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn ECDSASign(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::ECDSASignInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::ecdsa_sign::_ecdsa_sign_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::ecdsa_sign::EcdsaSign::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::standard_library_conversions::blob_to_dafny(&inner_result),
                },
            ),
        }
    }

    fn GenerateECDSASignatureKey(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::GenerateECDSASignatureKeyInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::GenerateECDSASignatureKeyOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::generate_ecdsa_signature_key::_generate_ecdsa_signature_key_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::generate_ecdsa_signature_key::GenerateEcdsaSignatureKey::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_primitives::conversions::generate_ecdsa_signature_key::_generate_ecdsa_signature_key_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn AesKdfCounterMode(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::AesKdfCtrInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::aes_kdf_counter_mode::_aes_kdf_counter_mode_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::aes_kdf_counter_mode::AesKdfCounterMode::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::standard_library_conversions::blob_to_dafny(&inner_result),
                },
            ),
        }
    }

    fn GenerateECCKeyPair(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::GenerateECCKeyPairInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::GenerateECCKeyPairOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::generate_ecc_key_pair::_generate_ecc_key_pair_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::generate_ecc_key_pair::GenerateEccKeyPair::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_primitives::conversions::generate_ecc_key_pair::_generate_ecc_key_pair_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn HMac(
        &self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::HMacInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::h_mac::_h_mac_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::h_mac::HMac::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::standard_library_conversions::blob_to_dafny(&inner_result),
                },
            ),
        }
    }

    fn Hkdf(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::HkdfInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::hkdf::_hkdf_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::hkdf::Hkdf::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::standard_library_conversions::blob_to_dafny(&inner_result),
                },
            ),
        }
    }

    fn AESDecrypt(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::AESDecryptInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::aes_decrypt::_aes_decrypt_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::aes_decrypt::AesDecrypt::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::standard_library_conversions::blob_to_dafny(&inner_result),
                },
            ),
        }
    }

    fn ECDSAVerify(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::ECDSAVerifyInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::primitive::bool,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::ecdsa_verify::_ecdsa_verify_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::ecdsa_verify::EcdsaVerify::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: inner_result.clone(),
                },
            ),
        }
    }

    fn ValidatePublicKey(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::ValidatePublicKeyInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::ValidatePublicKeyOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::validate_public_key::_validate_public_key_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::validate_public_key::ValidatePublicKey::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_primitives::conversions::validate_public_key::_validate_public_key_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn DeriveSharedSecret(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::DeriveSharedSecretInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::DeriveSharedSecretOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::derive_shared_secret::_derive_shared_secret_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::derive_shared_secret::DeriveSharedSecret::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_primitives::conversions::derive_shared_secret::_derive_shared_secret_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn CompressPublicKey(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::CompressPublicKeyInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::CompressPublicKeyOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::compress_public_key::_compress_public_key_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::compress_public_key::CompressPublicKey::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_primitives::conversions::compress_public_key::_compress_public_key_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn KdfCounterMode(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::KdfCtrInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::kdf_counter_mode::_kdf_counter_mode_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::kdf_counter_mode::KdfCounterMode::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::standard_library_conversions::blob_to_dafny(&inner_result),
                },
            ),
        }
    }

    fn Digest(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::DigestInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::digest::_digest_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::digest::Digest::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::standard_library_conversions::blob_to_dafny(&inner_result),
                },
            ),
        }
    }

    fn HkdfExpand(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::HkdfExpandInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::hkdf_expand::_hkdf_expand_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::hkdf_expand::HkdfExpand::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::standard_library_conversions::blob_to_dafny(&inner_result),
                },
            ),
        }
    }

    fn ParsePublicKey(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::ParsePublicKeyInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::ParsePublicKeyOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::parse_public_key::_parse_public_key_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::parse_public_key::ParsePublicKey::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_primitives::conversions::parse_public_key::_parse_public_key_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn RSAEncrypt(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::RSAEncryptInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::rsa_encrypt::_rsa_encrypt_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::rsa_encrypt::RsaEncrypt::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::standard_library_conversions::blob_to_dafny(&inner_result),
                },
            ),
        }
    }

    fn GenerateRandomBytes(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::GenerateRandomBytesInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::generate_random_bytes::_generate_random_bytes_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::generate_random_bytes::GenerateRandomBytes::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::standard_library_conversions::blob_to_dafny(&inner_result),
                },
            ),
        }
    }

    fn AESEncrypt(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::AESEncryptInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::AESEncryptOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::aes_encrypt::_aes_encrypt_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::aes_encrypt::AesEncrypt::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_primitives::conversions::aes_encrypt::_aes_encrypt_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn HkdfExtract(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::HkdfExtractInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::hkdf_extract::_hkdf_extract_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::hkdf_extract::HkdfExtract::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::standard_library_conversions::blob_to_dafny(&inner_result),
                },
            ),
        }
    }

    fn RSADecrypt(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::RSADecryptInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::rsa_decrypt::_rsa_decrypt_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::rsa_decrypt::RsaDecrypt::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::standard_library_conversions::blob_to_dafny(&inner_result),
                },
            ),
        }
    }

    fn DecompressPublicKey(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::DecompressPublicKeyInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::DecompressPublicKeyOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::decompress_public_key::_decompress_public_key_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::decompress_public_key::DecompressPublicKey::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_primitives::conversions::decompress_public_key::_decompress_public_key_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn GetPublicKeyFromPrivateKey(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::GetPublicKeyFromPrivateKeyInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::GetPublicKeyFromPrivateKeyOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::get_public_key_from_private_key::_get_public_key_from_private_key_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::get_public_key_from_private_key::GetPublicKeyFromPrivateKey::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_primitives::conversions::get_public_key_from_private_key::_get_public_key_from_private_key_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn GetRSAKeyModulusLength(
        &self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::GetRSAKeyModulusLengthInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::GetRSAKeyModulusLengthOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_primitives::conversions::get_rsa_key_modulus_length::_get_rsa_key_modulus_length_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_primitives::operation::get_rsa_key_modulus_length::GetRsaKeyModulusLength::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_primitives::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_primitives::conversions::get_rsa_key_modulus_length::_get_rsa_key_modulus_length_output::to_dafny(inner_result),
                },
            ),
        }
    }
}
