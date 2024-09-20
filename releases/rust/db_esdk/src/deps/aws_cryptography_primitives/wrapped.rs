// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub mod client;

impl crate::r#software::amazon::cryptography::primitives::internaldafny::wrapped::_default {
  pub fn WrappedAtomicPrimitives(config: &::std::rc::Rc<
      crate::r#software::amazon::cryptography::primitives::internaldafny::types::CryptoConfig,
  >) -> ::std::rc::Rc<crate::r#_Wrappers_Compile::Result<
          ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::primitives::internaldafny::types::IAwsCryptographicPrimitivesClient>,
          ::std::rc::Rc<crate::r#software::amazon::cryptography::primitives::internaldafny::types::Error>
  >>{
      crate::deps::aws_cryptography_primitives::wrapped::client::Client::from_conf(config)
  }
}
