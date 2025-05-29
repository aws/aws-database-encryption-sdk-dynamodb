// Package AwsCryptographyPrimitivesOperations
// Dafny module AwsCryptographyPrimitivesOperations compiled into Go

package AwsCryptographyPrimitivesOperations

import (
	os "os"

	m_AESEncryption "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AESEncryption"
	m_AwsCryptographyPrimitivesTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesTypes"
	m_Digest "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/Digest"
	m_ECDH "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/ECDH"
	m_HKDF "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/HKDF"
	m_KdfCtr "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/KdfCtr"
	m_RSAEncryption "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/RSAEncryption"
	m_Random "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/Random"
	m_Signature "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/Signature"
	m_WrappedHKDF "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/WrappedHKDF"
	m_WrappedHMAC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/WrappedHMAC"
	m_Actions "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Actions"
	m_Base64 "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Base64"
	m_Base64Lemmas "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Base64Lemmas"
	m_BoundedInts "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/BoundedInts"
	m_DivInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivInternals"
	m_DivInternalsNonlinear "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivInternalsNonlinear"
	m_DivMod "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivMod"
	m_FileIO "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/FileIO"
	m_FloatCompare "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/FloatCompare"
	m_Functions "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Functions"
	m_GeneralInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/GeneralInternals"
	m_GetOpt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/GetOpt"
	m_HexStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/HexStrings"
	m_Logarithm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Logarithm"
	m__Math "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Math_"
	m_ModInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/ModInternals"
	m_ModInternalsNonlinear "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/ModInternalsNonlinear"
	m_Mul "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Mul"
	m_MulInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/MulInternals"
	m_MulInternalsNonlinear "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/MulInternalsNonlinear"
	m_Power "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Power"
	m_Relations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Relations"
	m_Seq "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Seq"
	m_Seq_MergeSort "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Seq_MergeSort"
	m_Sorting "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Sorting"
	m_StandardLibrary "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary"
	m_StandardLibraryInterop "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibraryInterop"
	m_StandardLibrary_MemoryMath "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_MemoryMath"
	m_StandardLibrary_Sequence "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_Sequence"
	m_StandardLibrary_String "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_String"
	m_StandardLibrary_UInt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_UInt"
	m_Streams "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Streams"
	m_UnicodeStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UnicodeStrings"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
	m_Utf16EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf16EncodingForm"
	m_Utf8EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf8EncodingForm"
	m_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	m__System "github.com/dafny-lang/DafnyRuntimeGo/v4/System_"
	_dafny "github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
)

var _ = os.Args
var _ _dafny.Dummy__
var _ m__System.Dummy__
var _ m_Wrappers.Dummy__
var _ m_Relations.Dummy__
var _ m_Seq_MergeSort.Dummy__
var _ m__Math.Dummy__
var _ m_Seq.Dummy__
var _ m_BoundedInts.Dummy__
var _ m__Unicode.Dummy__
var _ m_Functions.Dummy__
var _ m_Utf8EncodingForm.Dummy__
var _ m_Utf16EncodingForm.Dummy__
var _ m_UnicodeStrings.Dummy__
var _ m_FileIO.Dummy__
var _ m_GeneralInternals.Dummy__
var _ m_MulInternalsNonlinear.Dummy__
var _ m_MulInternals.Dummy__
var _ m_Mul.Dummy__
var _ m_ModInternalsNonlinear.Dummy__
var _ m_DivInternalsNonlinear.Dummy__
var _ m_ModInternals.Dummy__
var _ m_DivInternals.Dummy__
var _ m_DivMod.Dummy__
var _ m_Power.Dummy__
var _ m_Logarithm.Dummy__
var _ m_StandardLibraryInterop.Dummy__
var _ m_StandardLibrary_UInt.Dummy__
var _ m_StandardLibrary_MemoryMath.Dummy__
var _ m_StandardLibrary_Sequence.Dummy__
var _ m_StandardLibrary_String.Dummy__
var _ m_StandardLibrary.Dummy__
var _ m_Streams.Dummy__
var _ m_Sorting.Dummy__
var _ m_HexStrings.Dummy__
var _ m_GetOpt.Dummy__
var _ m_FloatCompare.Dummy__
var _ m_Base64.Dummy__
var _ m_Base64Lemmas.Dummy__
var _ m_Actions.Dummy__
var _ m_AwsCryptographyPrimitivesTypes.Dummy__
var _ m_Random.Dummy__
var _ m_Digest.Dummy__
var _ m_WrappedHMAC.Dummy__
var _ m_HKDF.Dummy__
var _ m_WrappedHKDF.Dummy__
var _ m_KdfCtr.Dummy__

type Dummy__ struct{}

// Definition of class Default__
type Default__ struct {
	dummy byte
}

func New_Default___() *Default__ {
	_this := Default__{}

	return &_this
}

type CompanionStruct_Default___ struct {
}

var Companion_Default___ = CompanionStruct_Default___{}

func (_this *Default__) Equals(other *Default__) bool {
	return _this == other
}

func (_this *Default__) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*Default__)
	return ok && _this.Equals(other)
}

func (*Default__) String() string {
	return "AwsCryptographyPrimitivesOperations.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) GenerateRandomBytes(config Config, input m_AwsCryptographyPrimitivesTypes.GenerateRandomBytesInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_Random.Companion_Default___.GenerateBytes((input).Dtor_length())
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) Digest(config Config, input m_AwsCryptographyPrimitivesTypes.DigestInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_Digest.Companion_Default___.Digest(input)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) HMac(config Config, input m_AwsCryptographyPrimitivesTypes.HMacInput) m_Wrappers.Result {
	return m_WrappedHMAC.Companion_Default___.Digest(input)
}
func (_static *CompanionStruct_Default___) HkdfExtract(config Config, input m_AwsCryptographyPrimitivesTypes.HkdfExtractInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_WrappedHKDF.Companion_Default___.Extract(input)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) HkdfExpand(config Config, input m_AwsCryptographyPrimitivesTypes.HkdfExpandInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_WrappedHKDF.Companion_Default___.Expand(input)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) Hkdf(config Config, input m_AwsCryptographyPrimitivesTypes.HkdfInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_WrappedHKDF.Companion_Default___.Hkdf(input)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) KdfCounterMode(config Config, input m_AwsCryptographyPrimitivesTypes.KdfCtrInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_KdfCtr.Companion_Default___.KdfCounterMode(input)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) AesKdfCounterMode(config Config, input m_AwsCryptographyPrimitivesTypes.AesKdfCtrInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	output = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(_dafny.SeqOfString("Implement")))
	return output
}
func (_static *CompanionStruct_Default___) AESEncrypt(config Config, input m_AwsCryptographyPrimitivesTypes.AESEncryptInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_AESEncryptOutput_.Default())
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_AESEncryption.Companion_Default___.AESEncrypt(input)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) AESDecrypt(config Config, input m_AwsCryptographyPrimitivesTypes.AESDecryptInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_AESEncryption.Companion_Default___.AESDecrypt(input)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) GenerateRSAKeyPair(config Config, input m_AwsCryptographyPrimitivesTypes.GenerateRSAKeyPairInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_publicKey m_AwsCryptographyPrimitivesTypes.RSAPublicKey
	_ = _0_publicKey
	var _1_privateKey m_AwsCryptographyPrimitivesTypes.RSAPrivateKey
	_ = _1_privateKey
	var _out0 m_AwsCryptographyPrimitivesTypes.RSAPublicKey
	_ = _out0
	var _out1 m_AwsCryptographyPrimitivesTypes.RSAPrivateKey
	_ = _out1
	_out0, _out1 = m_RSAEncryption.Companion_Default___.GenerateKeyPair((input).Dtor_lengthBits())
	_0_publicKey = _out0
	_1_privateKey = _out1
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyPrimitivesTypes.Companion_GenerateRSAKeyPairOutput_.Create_GenerateRSAKeyPairOutput_(_0_publicKey, _1_privateKey))
	return output
}
func (_static *CompanionStruct_Default___) GetRSAKeyModulusLength(config Config, input m_AwsCryptographyPrimitivesTypes.GetRSAKeyModulusLengthInput) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = m_RSAEncryption.Companion_Default___.GetRSAKeyModulusLength((input).Dtor_publicKey())
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_length int32 = (_0_valueOrError0).Extract().(int32)
		_ = _1_length
		return m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyPrimitivesTypes.Companion_GetRSAKeyModulusLengthOutput_.Create_GetRSAKeyModulusLengthOutput_(_1_length))
	}
}
func (_static *CompanionStruct_Default___) RSADecrypt(config Config, input m_AwsCryptographyPrimitivesTypes.RSADecryptInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_RSAEncryption.Companion_Default___.Decrypt(input)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) RSAEncrypt(config Config, input m_AwsCryptographyPrimitivesTypes.RSAEncryptInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_RSAEncryption.Companion_Default___.Encrypt(input)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) GenerateECDSASignatureKey(config Config, input m_AwsCryptographyPrimitivesTypes.GenerateECDSASignatureKeyInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_GenerateECDSASignatureKeyOutput_.Default())
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_Signature.Companion_Default___.KeyGen(input)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) ECDSASign(config Config, input m_AwsCryptographyPrimitivesTypes.ECDSASignInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_Signature.ECDSA.Sign((input).Dtor_signatureAlgorithm(), (input).Dtor_signingKey(), (input).Dtor_message())
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) ECDSAVerify(config Config, input m_AwsCryptographyPrimitivesTypes.ECDSAVerifyInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
	_ = output
	output = m_Signature.ECDSA_Verify((input).Dtor_signatureAlgorithm(), (input).Dtor_verificationKey(), (input).Dtor_message(), (input).Dtor_signature())
	return output
}
func (_static *CompanionStruct_Default___) GenerateECCKeyPair(config Config, input m_AwsCryptographyPrimitivesTypes.GenerateECCKeyPairInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_GenerateECCKeyPairOutput_.Default())
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_ECDH.Companion_Default___.GenerateEccKeyPair(input)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) GetPublicKeyFromPrivateKey(config Config, input m_AwsCryptographyPrimitivesTypes.GetPublicKeyFromPrivateKeyInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_GetPublicKeyFromPrivateKeyOutput_.Default())
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_ECDH.Companion_Default___.GetPublicKeyFromPrivate(input)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) ValidatePublicKey(config Config, input m_AwsCryptographyPrimitivesTypes.ValidatePublicKeyInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_ValidatePublicKeyOutput_.Default())
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_ECDH.Companion_Default___.Go__ValidatePublicKey(input)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) DeriveSharedSecret(config Config, input m_AwsCryptographyPrimitivesTypes.DeriveSharedSecretInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_DeriveSharedSecretOutput_.Default())
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_ECDH.Companion_Default___.DeriveSharedSecret(input)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) CompressPublicKey(config Config, input m_AwsCryptographyPrimitivesTypes.CompressPublicKeyInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_CompressPublicKeyOutput_.Default())
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_ECDH.Companion_Default___.Go__CompressPublicKey(input)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) DecompressPublicKey(config Config, input m_AwsCryptographyPrimitivesTypes.DecompressPublicKeyInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_DecompressPublicKeyOutput_.Default())
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_ECDH.Companion_Default___.Go__DecompressPublicKey(input)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) ParsePublicKey(config Config, input m_AwsCryptographyPrimitivesTypes.ParsePublicKeyInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_ParsePublicKeyOutput_.Default())
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_ECDH.Companion_Default___.Go__ParsePublicKey(input)
	output = _out0
	return output
}

// End of class Default__

// Definition of datatype Config
type Config struct {
	Data_Config_
}

func (_this Config) Get_() Data_Config_ {
	return _this.Data_Config_
}

type Data_Config_ interface {
	isConfig()
}

type CompanionStruct_Config_ struct {
}

var Companion_Config_ = CompanionStruct_Config_{}

type Config_Config struct {
}

func (Config_Config) isConfig() {}

func (CompanionStruct_Config_) Create_Config_() Config {
	return Config{Config_Config{}}
}

func (_this Config) Is_Config() bool {
	_, ok := _this.Get_().(Config_Config)
	return ok
}

func (CompanionStruct_Config_) Default() Config {
	return Companion_Config_.Create_Config_()
}

func (_ CompanionStruct_Config_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_Config_.Create_Config_(), true
		default:
			return Config{}, false
		}
	}
}

func (_this Config) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case Config_Config:
		{
			return "AwsCryptographyPrimitivesOperations.Config.Config"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Config) Equals(other Config) bool {
	switch _this.Get_().(type) {
	case Config_Config:
		{
			_, ok := other.Get_().(Config_Config)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Config) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Config)
	return ok && _this.Equals(typed)
}

func Type_Config_() _dafny.TypeDescriptor {
	return type_Config_{}
}

type type_Config_ struct {
}

func (_this type_Config_) Default() interface{} {
	return Companion_Config_.Default()
}

func (_this type_Config_) String() string {
	return "AwsCryptographyPrimitivesOperations.Config"
}
func (_this Config) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Config{}

// End of datatype Config
