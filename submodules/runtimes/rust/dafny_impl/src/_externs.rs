use crate::ImplementationFromDafny::*;

use self::_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::RSAPaddingMode;

impl ExternRandom::_default {
  #[allow(non_snake_case)]
  pub fn GenerateBytes(_i: i32) -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<u8>, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>> {
    todo!("ExternRandom.GenerateBytes not implemented");
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
    todo!("AESEncryptExtern not implemented");
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
    todo!("AESDecryptExtern not implemented");
  }
}

impl ExternDigest::_default {
  #[allow(non_snake_case)]
  pub fn Digest(
    _digestAlgorithm: &::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::DigestAlgorithm>,
    _message: &::dafny_runtime::Sequence<u8>
  ) -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<u8>, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>> {
    todo!("Digest not implemented");
  }
}

impl RSAEncryption_dRSA::_default {
  #[allow(non_snake_case)]
  pub fn GenerateKeyPairExtern(_lengthBits: i32) -> (::dafny_runtime::Sequence<u8>, ::dafny_runtime::Sequence<u8>) {
    todo!("RSAEncryption_dRSA::GenerateKeyPairExtern not implemented");
  }
  #[allow(non_snake_case)]
  pub fn GetRSAKeyModulusLengthExtern(_publicKey: &::dafny_runtime::Sequence<u8>) -> ::std::rc::Rc<Wrappers::Result<u32, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>> {
    todo!("RSAEncryption_dRSA::GetRSAKeyModulusLengthExtern not implemented");
  }
  #[allow(non_snake_case)]
  pub fn DecryptExtern(_self: &RSAPaddingMode, _privateKey: &::dafny_runtime::Sequence<u8>, _cipher_text: &::dafny_runtime::Sequence<u8>)
    -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<u8>, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>>
  {
    todo!("RSAEncryption_dRSA::DecryptExtern not implemented");
  }
  #[allow(non_snake_case)]
  pub fn EncryptExtern(_self: &RSAPaddingMode, _publicKey: &::dafny_runtime::Sequence<u8>, _message: &::dafny_runtime::Sequence<u8>)
   -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<u8>, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>>
  {
    todo!("RSAEncryption_dRSA::EncryptExtern not implemented");
  }
}

impl r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::RSAPublicKey {
  #[allow(non_snake_case)]
  pub fn GetRSAKeyModulusLengthExtern(&self) -> ::std::rc::Rc<Wrappers::Result<u32, r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>> {
    todo!("GetRSAKeyModulusLengthExtern not implemented");
  }
}

// Let's implement HMAC::_default::Digest
impl crate::ImplementationFromDafny::HMAC::_default {
  #[allow(non_snake_case)]
  pub fn Digest(_input: &::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::HMacInput>)
    -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<u8>, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>> {
      todo!("HMAC::_default::Digest not implemented");
  }
}

pub mod HMAC {
  use crate::ImplementationFromDafny::*;
  pub struct HMac {
  }
  impl HMac {
    pub fn Init(&mut self, _salt: &::dafny_runtime::Sequence<u8>) {
      todo!("HMAC::HMac::Init not implemented");
    }
    pub fn Build(_input: &::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::DigestAlgorithm>) 
    -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Object<Self>, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>> {
      todo!("HMAC::HMac::Build not implemented");
    }
    pub fn BlockUpdate(&mut self, _block: &::dafny_runtime::Sequence<u8>) {
      todo!("HMAC::HMac::BlockUpdate not implemented");
    }
    pub fn GetResult(&mut self) -> ::dafny_runtime::Sequence<u8> {
      todo!("HMAC::HMac::GetResult not implemented");
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
      todo!("MutableMap::content not implemented");
    }
    fn Put(&mut self, _k: &K, _v: &V) -> () {
      todo!("MutableMap::Put not implemented");
    }
    fn Keys(&self) -> ::dafny_runtime::Set<K> {
      todo!("MutableMap::Keys not implemented");
    }
    fn HasKey(&self, _k: &K) -> bool {
      todo!("MutableMap::HasKey not implemented");
    }
    fn Values(&self) -> ::dafny_runtime::Set<V> {
      todo!("MutableMap::Values not implemented");
    }
    fn Items(&self) -> ::dafny_runtime::Set<(K, V)> {
      todo!("MutableMap::Items not implemented");
    }
    fn Select(&self, _k: &K) -> V {
      todo!("MutableMap::Select not implemented");
    }
    fn Remove(&mut self, _k: &K) -> () {
      todo!("MutableMap::Remove not implemented");
    }
    fn Size(&self) -> ::dafny_runtime::DafnyInt {
      todo!("MutableMap::Size not implemented");
    }
  }
}

impl r#_Dafny_dFileIO::_default {
  pub fn r#_INTERNAL_ReadBytesFromFile(_file: &::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>)
    -> (bool, ::dafny_runtime::Sequence<u8>, ::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>)
  {
    todo!("r#_Dafny_dFileIO::r#_INTERNAL_ReadBytesFromFile not implemented");
  }
  pub fn r#_INTERNAL_WriteBytesToFile(_path: &::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>, _bytes: &::dafny_runtime::Sequence<u8>)
    -> (bool, ::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>)
  {
    todo!("r#_Dafny_dFileIO::(path: &::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>, bytes: &::dafny_runtime::Sequence<u8>) not implemented");
  }
}

pub mod Signature_dECDSA {
  use crate::ImplementationFromDafny::*;
  pub fn ExternKeyGen(_self: &::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::ECDSASignatureAlgorithm>)
     -> ::std::rc::Rc<Wrappers::Result<::std::rc::Rc<Signature::SignatureKeyPair>, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>>
  {
    todo!("Signature::ExternKeyGen not implemented");
  }
  pub fn Sign(_self: &::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::ECDSASignatureAlgorithm>,
              _key: &::dafny_runtime::Sequence<u8>,
              _msg: &::dafny_runtime::Sequence<u8>
  ) -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<u8>, ::std::rc::Rc<r#_software_damazon_dcryptography_dprimitives_dinternaldafny_dtypes::Error>>> {
    todo!("Signature::Sign not implemented");
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
    todo!("Signature::Verify not implemented");
  }
}

impl Time::_default {
  pub fn CurrentRelativeTime() -> u64 {
    todo!("Time::CurrentRelativeTime not implemented");
  }
  pub fn GetCurrentTimeStamp() -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>, ::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>>> {
    todo!("Time::GetCurrentTimeStamp not implemented");
  }
}

impl SortedSets::_default {
  pub fn SetToSequence<T: ::dafny_runtime::DafnyTypeEq>(_elems: &::dafny_runtime::Set<T>) -> ::dafny_runtime::Sequence<T> {
    todo!("SortedSets::SetToSequence not implemented");
  }
}

impl UUID::_default {
  pub fn ToByteArray(_bytes: &::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>)
    -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<u8>, ::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>>>
  {
    todo!("UUID::ToByteArray not implemented");
  }

  pub fn FromByteArray(_bytes: &::dafny_runtime::Sequence<u8>)
    -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>, ::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>>>
  {
    todo!("UUID::FromByteArray not implemented");
  }

  pub fn GenerateUUID() -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>, ::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>>> {
    todo!("UUID::GenerateUUID not implemented");
  }
}

pub mod r#_software_damazon_dcryptography_dinternaldafny_dStormTrackingCMC {
  use crate::ImplementationFromDafny::*;

  pub struct StormTrackingCMC {}
  impl StormTrackingCMC {
    pub fn _allocate_rcmut() -> ::dafny_runtime::Object<Self> {
      ::dafny_runtime::allocate_rcmut::<Self>()
    }
    pub fn _ctor(_this: &::dafny_runtime::Object<Self>, _cmc: &::dafny_runtime::Object<StormTracker::StormTracker>) -> () {
      todo!("r#_software_damazon_dcryptography_dinternaldafny_dStormTrackingCMC::_ctor not implemented");
    }
  }

  impl _software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::ICryptographicMaterialsCache for StormTrackingCMC {
    fn r#_PutCacheEntry_k(&mut self, _input: &std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::PutCacheEntryInput>) -> std::rc::Rc<crate::ImplementationFromDafny::Wrappers::Result<(), std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::Error>>> {
      todo!("r#_software_damazon_dcryptography_dinternaldafny_dStormTrackingCMC::_ctor not implemented");
    }
  
    fn r#_UpdateUsageMetadata_k(&mut self, _input: &std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::UpdateUsageMetadataInput>) -> std::rc::Rc<crate::ImplementationFromDafny::Wrappers::Result<(), std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::Error>>> {
        todo!()
    }
  
    fn r#_GetCacheEntry_k(&mut self, _input: &std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::GetCacheEntryInput>) -> std::rc::Rc<crate::ImplementationFromDafny::Wrappers::Result<std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::GetCacheEntryOutput>, std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::Error>>> {
        todo!()
    }
  
    fn r#_DeleteCacheEntry_k(&mut self, _input: &std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::DeleteCacheEntryInput>) -> std::rc::Rc<crate::ImplementationFromDafny::Wrappers::Result<(), std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::Error>>> {
        todo!()
    }
  }
}

pub mod r#_software_damazon_dcryptography_dinternaldafny_dSynchronizedLocalCMC {
  use crate::ImplementationFromDafny::*;
  pub struct SynchronizedLocalCMC {}

  impl SynchronizedLocalCMC {
    pub fn _allocate_rcmut() -> ::dafny_runtime::Object<Self> {
      ::dafny_runtime::allocate_rcmut::<Self>()
    }
    pub fn _ctor(_this: &::dafny_runtime::Object<Self>, _cmc: &::dafny_runtime::Object<LocalCMC::LocalCMC>) -> () {
      todo!("r#_software_damazon_dcryptography_dinternaldafny_dSynchronizedLocalCMC::_ctor not implemented");
    }
  }

  impl _software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::ICryptographicMaterialsCache for SynchronizedLocalCMC {
    fn r#_PutCacheEntry_k(&mut self, _input: &std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::PutCacheEntryInput>) -> std::rc::Rc<crate::ImplementationFromDafny::Wrappers::Result<(), std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::Error>>> {
      todo!("r#_software_damazon_dcryptography_dinternaldafny_dSynchronizedLocalCMC::_ctor not implemented");
    }
  
    fn r#_UpdateUsageMetadata_k(&mut self, _input: &std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::UpdateUsageMetadataInput>) -> std::rc::Rc<crate::ImplementationFromDafny::Wrappers::Result<(), std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::Error>>> {
      todo!("r#_software_damazon_dcryptography_dinternaldafny_dSynchronizedLocalCMC::_ctor not implemented");
    }
  
    fn r#_GetCacheEntry_k(&mut self, _input: &std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::GetCacheEntryInput>) -> std::rc::Rc<crate::ImplementationFromDafny::Wrappers::Result<std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::GetCacheEntryOutput>, std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::Error>>> {
      todo!("r#_software_damazon_dcryptography_dinternaldafny_dSynchronizedLocalCMC::_ctor not implemented");
    }
  
    fn r#_DeleteCacheEntry_k(&mut self, _input: &std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::DeleteCacheEntryInput>) -> std::rc::Rc<crate::ImplementationFromDafny::Wrappers::Result<(), std::rc::Rc<crate::ImplementationFromDafny::r#_software_damazon_dcryptography_dmaterialproviders_dinternaldafny_dtypes::Error>>> {
      todo!("r#_software_damazon_dcryptography_dinternaldafny_dSynchronizedLocalCMC::_ctor not implemented");
    }
  }
}

impl r#_software_damazon_dcryptography_dservices_dkms_dinternaldafny::_default {
  pub fn KMSClientForRegion(_region: &::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>) -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Object<dyn r#_software_damazon_dcryptography_dservices_dkms_dinternaldafny_dtypes::IKMSClient>, ::std::rc::Rc<r#_software_damazon_dcryptography_dservices_dkms_dinternaldafny_dtypes::Error>>> {
    todo!("r#_software_damazon_dcryptography_dservices_dkms_dinternaldafny::KMSClientForRegion not implemented");
  }
  pub fn RegionMatch(_kmsClient: &::dafny_runtime::Object<dyn r#_software_damazon_dcryptography_dservices_dkms_dinternaldafny_dtypes::IKMSClient>, _region:  &::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>) ->
    ::std::rc::Rc<Wrappers::Option<bool>>
  {
    todo!("r#_software_damazon_dcryptography_dservices_dkms_dinternaldafny::RegionMatch not implemented");
  }
}

impl r#_software_damazon_dcryptography_dservices_ddynamodb_dinternaldafny::_default {
  pub fn DDBClientForRegion(_region: &::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>)
    -> ::std::rc::Rc<Wrappers::Result<::dafny_runtime::Object<dyn r#_software_damazon_dcryptography_dservices_ddynamodb_dinternaldafny_dtypes::IDynamoDBClient>, ::std::rc::Rc<r#_software_damazon_dcryptography_dservices_ddynamodb_dinternaldafny_dtypes::Error>>>
  {
    todo!("r#_software_damazon_dcryptography_dservices_ddynamodb_dinternaldafny::DDBClientForRegion not implemented");
  }
}