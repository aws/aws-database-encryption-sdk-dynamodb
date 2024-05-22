use crate::ImplementationFromDafny::*;

use self::_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::RSAPaddingMode;

impl ExternRandom::_default {
  #[allow(non_snake_case)]
  pub fn GenerateBytes(_i: i32) -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<u8>, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>> {
    panic!("ExternRandom.GenerateBytes not implemented");
  }
}

impl r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::AES_GCM {
  #[allow(non_snake_case)]
  pub fn AESEncryptExtern(
    &self,
    _iv: &::dafny_runtime::Sequence<u8>,
    _key: &::dafny_runtime::Sequence<u8>,
    _msg: &::dafny_runtime::Sequence<u8>,
    _aad: &::dafny_runtime::Sequence<u8>
  ) -> ::std::rc::Rc<Wrappers::Result<::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::AESEncryptOutput>, r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::OpaqueError>> {
    panic!("AESEncryptExtern not implemented");
  }
  #[allow(non_snake_case)]
  pub fn AESDecryptExtern(
    &self,
    _key: &::dafny_runtime::Sequence<u8>,
    _cipherTxt: &::dafny_runtime::Sequence<u8>,
    _authTag: &::dafny_runtime::Sequence<u8>,
    _iv: &::dafny_runtime::Sequence<u8>,
    _aad: &::dafny_runtime::Sequence<u8>
  ) -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<u8>, r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::OpaqueError>> {
    panic!("AESDecryptExtern not implemented");
  }
}

impl ExternDigest::_default {
  #[allow(non_snake_case)]
  pub fn Digest(
    _digestAlgorithm: &::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::DigestAlgorithm>,
    _message: &::dafny_runtime::Sequence<u8>
  ) -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<u8>, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>> {
    panic!("Digest not implemented");
  }
}

impl RSAEncryption_dRSA::_default {
  #[allow(non_snake_case)]
  pub fn GenerateKeyPairExtern(_lengthBits: &::dafny_runtime::DafnyInt) -> (::dafny_runtime::Sequence<u8>, ::dafny_runtime::Sequence<u8>) {
    panic!("RSAEncryption_dRSA::GenerateKeyPairExtern not implemented");
  }
  #[allow(non_snake_case)]
  pub fn GetRSAKeyModulusLengthExtern(_publicKey: &::dafny_runtime::Sequence<u8>) -> ::std::rc::Rc<Wrappers::Result<u32, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>> {
    panic!("RSAEncryption_dRSA::GetRSAKeyModulusLengthExtern not implemented");
  }
  #[allow(non_snake_case)]
  pub fn DecryptExtern(_self: &RSAPaddingMode, _privateKey: &::dafny_runtime::Sequence<u8>, _cipher_text: &::dafny_runtime::Sequence<u8>)
    -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<u8>, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>>
  {
    panic!("RSAEncryption_dRSA::DecryptExtern not implemented");
  }
  #[allow(non_snake_case)]
  pub fn EncryptExtern(_self: &RSAPaddingMode, _publicKey: &::dafny_runtime::Sequence<u8>, _message: &::dafny_runtime::Sequence<u8>)
   -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<u8>, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>>
  {
    panic!("RSAEncryption_dRSA::EncryptExtern not implemented");
  }
}

impl r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::RSAPublicKey {
  #[allow(non_snake_case)]
  pub fn GetRSAKeyModulusLengthExtern(&self) -> ::std::rc::Rc<Wrappers::Result<u32, r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>> {
    panic!("GetRSAKeyModulusLengthExtern not implemented");
  }
}

// Let's implement HMAC::_default::Digest
impl crate::ImplementationFromDafny::HMAC::_default {
  #[allow(non_snake_case)]
  pub fn Digest(_input: &::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::HMacInput>)
    -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<u8>, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>> {
      panic!("HMAC::_default::Digest not implemented");
  }
}

pub mod HMAC {
  use crate::ImplementationFromDafny::*;
  pub struct HMac {
  }
  impl HMac {
    pub fn Init(&mut self, _salt: &::dafny_runtime::Sequence<u8>) {
      panic!("HMAC::HMac::Init not implemented");
    }
    pub fn Build(_input: &::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::DigestAlgorithm>) 
    -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Object<Self>, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>> {
      panic!("HMAC::HMac::Build not implemented");
    }
    pub fn BlockUpdate(&mut self, _block: &::dafny_runtime::Sequence<u8>) {
      panic!("HMAC::HMac::BlockUpdate not implemented");
    }
    pub fn GetResult(&mut self) -> ::dafny_runtime::Sequence<u8> {
      panic!("HMAC::HMac::GetResult not implemented");
    }
  }
}

pub mod DafnyLibraries {
  use crate::ImplementationFromDafny::*;
  pub struct MutableMap<K: ::dafny_runtime::DafnyTypeEq, V: ::dafny_runtime::DafnyTypeEq> {
    _phantom_type_param_0: ::std::marker::PhantomData<K>,
    _phantom_type_param_1: ::std::marker::PhantomData<V>
  }


  impl<K: ::dafny_runtime::DafnyTypeEq, V: ::dafny_runtime::DafnyTypeEq> MutableMap<K, V> {
  }

  impl<K: ::dafny_runtime::DafnyTypeEq, V: ::dafny_runtime::DafnyTypeEq> DafnyLibraries::MutableMapTrait<K, V>
    for MutableMap<K, V> {
    fn content(&self) -> ::dafny_runtime::Map<K, V> {
      panic!("MutableMap::content not implemented");
    }
    fn Put(&mut self, _k: &K, _v: &V) -> () {
      panic!("MutableMap::Put not implemented");
    }
    fn Keys(&self) -> ::dafny_runtime::Set<K> {
      panic!("MutableMap::Keys not implemented");
    }
    fn HasKey(&self, _k: &K) -> bool {
      panic!("MutableMap::HasKey not implemented");
    }
    fn Values(&self) -> ::dafny_runtime::Set<V> {
      panic!("MutableMap::Values not implemented");
    }
    fn Items(&self) -> ::dafny_runtime::Set<(K, V)> {
      panic!("MutableMap::Items not implemented");
    }
    fn Select(&self, _k: &K) -> V {
      panic!("MutableMap::Select not implemented");
    }
    fn Remove(&mut self, _k: &K) -> () {
      panic!("MutableMap::Remove not implemented");
    }
    fn Size(&self) -> ::dafny_runtime::DafnyInt {
      panic!("MutableMap::Size not implemented");
    }
  }
}

impl r#_Dafny_dFileIO::_default {
  pub fn r#_INTERNAL_ReadBytesFromFile(_file: &::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>)
    -> (bool, ::dafny_runtime::Sequence<u8>, ::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>)
  {
    panic!("r#_Dafny_dFileIO::r#_INTERNAL_ReadBytesFromFile not implemented");
  }
  pub fn r#_INTERNAL_WriteBytesToFile(_path: &::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>, _bytes: &::dafny_runtime::Sequence<u8>)
    -> (bool, ::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>)
  {
    panic!("r#_Dafny_dFileIO::(path: &::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>, bytes: &::dafny_runtime::Sequence<u8>) not implemented");
  }
}

pub mod Signature_dECDSA {
  use crate::ImplementationFromDafny::*;
  pub fn ExternKeyGen(_self: &::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::ECDSASignatureAlgorithm>)
     -> ::std::rc::Rc<Wrappers::Result<::std::rc::Rc<Signature::SignatureKeyPair>, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>>
  {
    panic!("Signature::ExternKeyGen not implemented");
  }
  pub fn Sign(_self: &::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::ECDSASignatureAlgorithm>,
              _key: &::dafny_runtime::Sequence<u8>,
              _msg: &::dafny_runtime::Sequence<u8>
  ) -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<u8>, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>> {
    panic!("Signature::Sign not implemented");
  }
  /*
    pub fn ECDSAVerify(config: &::std::rc::Rc<AwsCryptographyPrimitivesOperations::Config>, input: &::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::ECDSAVerifyInput>) -> ::std::rc::Rc<Wrappers::Result<bool, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>> {
      let mut output = ::dafny_runtime::MaybePlacebo::<::std::rc::Rc<Wrappers::Result<bool, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>>>::new();
      output = ::dafny_runtime::MaybePlacebo::from(crate::_externs::Signature_dECDSA::Verify(input.signatureAlgorithm(); input.verificationKey(), input.message(), input.signature()));
      return output.read(); */
  pub fn Verify(_self: &::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::ECDSASignatureAlgorithm>,
                _key: &::dafny_runtime::Sequence<u8>,
                _msg: &::dafny_runtime::Sequence<u8>,
                _sig: &::dafny_runtime::Sequence<u8>
  ) -> ::std::rc::Rc<Wrappers::Result<bool, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>> {
    panic!("Signature::Verify not implemented");
  }
}

impl Time::_default {
  pub fn CurrentRelativeTime() -> u64 {
    panic!("Time::CurrentRelativeTime not implemented");
  }
}

impl SortedSets::_default {
  pub fn SetToSequence<T: ::dafny_runtime::DafnyTypeEq>(_elems: &::dafny_runtime::Set<T>) -> ::dafny_runtime::Sequence<T> {
    panic!("SortedSets::SetToSequence not implemented");
  }
}

impl UUID::_default {
  pub fn ToByteArray(_bytes: ::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>)
    -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<u8>, ::std::rc::Rc<r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::Error>>>
  {
    panic!("UUID::ToByteArray not implemented");
  }

  pub fn FromByteArray(_bytes: ::dafny_runtime::Sequence<u8>)
    -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>, ::std::rc::Rc<r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::Error>>>
  {
    panic!("UUID::FromByteArray not implemented");
  }

  pub fn GenerateUUID() -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>, ::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>>> {
    panic!("UUID::GenerateUUID not implemented");
  }
}

pub mod r#_software_damazon_dcryptography_dinternaldafny_dStormTrackingCMC {
  pub struct StormTrackingCMC {}
  impl StormTrackingCMC {

  }
}