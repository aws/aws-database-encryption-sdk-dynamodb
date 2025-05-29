// Package AtomicPrimitives
// Dafny module AtomicPrimitives compiled into Go

package AtomicPrimitives

import (
	os "os"

	m_AwsCryptographyPrimitivesOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesOperations"
	m_AwsCryptographyPrimitivesTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesTypes"
	m_Digest "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/Digest"
	m_HKDF "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/HKDF"
	m_KdfCtr "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/KdfCtr"
	m_Random "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/Random"
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
var _ m_AwsCryptographyPrimitivesOperations.Dummy__

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
	return "AtomicPrimitives.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) DefaultCryptoConfig() m_AwsCryptographyPrimitivesTypes.CryptoConfig {
	return m_AwsCryptographyPrimitivesTypes.Companion_CryptoConfig_.Create_CryptoConfig_()
}
func (_static *CompanionStruct_Default___) AtomicPrimitives(config m_AwsCryptographyPrimitivesTypes.CryptoConfig) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Result{}
	_ = res
	var _0_client *AtomicPrimitivesClient
	_ = _0_client
	var _nw0 *AtomicPrimitivesClient = New_AtomicPrimitivesClient_()
	_ = _nw0
	_nw0.Ctor__(m_AwsCryptographyPrimitivesOperations.Companion_Config_.Create_Config_())
	_0_client = _nw0
	res = m_Wrappers.Companion_Result_.Create_Success_(_0_client)
	return res
	return res
}
func (_static *CompanionStruct_Default___) CreateSuccessOfClient(client m_AwsCryptographyPrimitivesTypes.IAwsCryptographicPrimitivesClient) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(client)
}
func (_static *CompanionStruct_Default___) CreateFailureOfError(error_ m_AwsCryptographyPrimitivesTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}

// End of class Default__

// Definition of class AtomicPrimitivesClient
type AtomicPrimitivesClient struct {
	_config m_AwsCryptographyPrimitivesOperations.Config
}

func New_AtomicPrimitivesClient_() *AtomicPrimitivesClient {
	_this := AtomicPrimitivesClient{}

	_this._config = m_AwsCryptographyPrimitivesOperations.Companion_Config_.Default()
	return &_this
}

type CompanionStruct_AtomicPrimitivesClient_ struct {
}

var Companion_AtomicPrimitivesClient_ = CompanionStruct_AtomicPrimitivesClient_{}

func (_this *AtomicPrimitivesClient) Equals(other *AtomicPrimitivesClient) bool {
	return _this == other
}

func (_this *AtomicPrimitivesClient) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*AtomicPrimitivesClient)
	return ok && _this.Equals(other)
}

func (*AtomicPrimitivesClient) String() string {
	return "AtomicPrimitives.AtomicPrimitivesClient"
}

func Type_AtomicPrimitivesClient_() _dafny.TypeDescriptor {
	return type_AtomicPrimitivesClient_{}
}

type type_AtomicPrimitivesClient_ struct {
}

func (_this type_AtomicPrimitivesClient_) Default() interface{} {
	return (*AtomicPrimitivesClient)(nil)
}

func (_this type_AtomicPrimitivesClient_) String() string {
	return "AtomicPrimitives.AtomicPrimitivesClient"
}
func (_this *AtomicPrimitivesClient) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_AwsCryptographyPrimitivesTypes.Companion_IAwsCryptographicPrimitivesClient_.TraitID_}
}

var _ m_AwsCryptographyPrimitivesTypes.IAwsCryptographicPrimitivesClient = &AtomicPrimitivesClient{}
var _ _dafny.TraitOffspring = &AtomicPrimitivesClient{}

func (_this *AtomicPrimitivesClient) Ctor__(config m_AwsCryptographyPrimitivesOperations.Config) {
	{
		(_this)._config = config
	}
}
func (_this *AtomicPrimitivesClient) GenerateRandomBytes(input m_AwsCryptographyPrimitivesTypes.GenerateRandomBytesInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.GenerateRandomBytes((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) Digest(input m_AwsCryptographyPrimitivesTypes.DigestInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.Digest((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) HMac(input m_AwsCryptographyPrimitivesTypes.HMacInput) m_Wrappers.Result {
	{
		return m_AwsCryptographyPrimitivesOperations.Companion_Default___.HMac((_this).Config(), input)
	}
}
func (_this *AtomicPrimitivesClient) HkdfExtract(input m_AwsCryptographyPrimitivesTypes.HkdfExtractInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.HkdfExtract((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) HkdfExpand(input m_AwsCryptographyPrimitivesTypes.HkdfExpandInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.HkdfExpand((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) Hkdf(input m_AwsCryptographyPrimitivesTypes.HkdfInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.Hkdf((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) KdfCounterMode(input m_AwsCryptographyPrimitivesTypes.KdfCtrInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.KdfCounterMode((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) AesKdfCounterMode(input m_AwsCryptographyPrimitivesTypes.AesKdfCtrInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.AesKdfCounterMode((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) AESEncrypt(input m_AwsCryptographyPrimitivesTypes.AESEncryptInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_AESEncryptOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.AESEncrypt((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) AESDecrypt(input m_AwsCryptographyPrimitivesTypes.AESDecryptInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.AESDecrypt((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) GenerateRSAKeyPair(input m_AwsCryptographyPrimitivesTypes.GenerateRSAKeyPairInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.GenerateRSAKeyPair((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) GetRSAKeyModulusLength(input m_AwsCryptographyPrimitivesTypes.GetRSAKeyModulusLengthInput) m_Wrappers.Result {
	{
		return m_AwsCryptographyPrimitivesOperations.Companion_Default___.GetRSAKeyModulusLength((_this).Config(), input)
	}
}
func (_this *AtomicPrimitivesClient) RSADecrypt(input m_AwsCryptographyPrimitivesTypes.RSADecryptInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.RSADecrypt((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) RSAEncrypt(input m_AwsCryptographyPrimitivesTypes.RSAEncryptInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.RSAEncrypt((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) GenerateECDSASignatureKey(input m_AwsCryptographyPrimitivesTypes.GenerateECDSASignatureKeyInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_GenerateECDSASignatureKeyOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.GenerateECDSASignatureKey((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) ECDSASign(input m_AwsCryptographyPrimitivesTypes.ECDSASignInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.ECDSASign((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) ECDSAVerify(input m_AwsCryptographyPrimitivesTypes.ECDSAVerifyInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.ECDSAVerify((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) GenerateECCKeyPair(input m_AwsCryptographyPrimitivesTypes.GenerateECCKeyPairInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_GenerateECCKeyPairOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.GenerateECCKeyPair((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) GetPublicKeyFromPrivateKey(input m_AwsCryptographyPrimitivesTypes.GetPublicKeyFromPrivateKeyInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_GetPublicKeyFromPrivateKeyOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.GetPublicKeyFromPrivateKey((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) ValidatePublicKey(input m_AwsCryptographyPrimitivesTypes.ValidatePublicKeyInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_ValidatePublicKeyOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.ValidatePublicKey((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) DeriveSharedSecret(input m_AwsCryptographyPrimitivesTypes.DeriveSharedSecretInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_DeriveSharedSecretOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.DeriveSharedSecret((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) CompressPublicKey(input m_AwsCryptographyPrimitivesTypes.CompressPublicKeyInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_CompressPublicKeyOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.CompressPublicKey((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) DecompressPublicKey(input m_AwsCryptographyPrimitivesTypes.DecompressPublicKeyInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_DecompressPublicKeyOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.DecompressPublicKey((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) ParsePublicKey(input m_AwsCryptographyPrimitivesTypes.ParsePublicKeyInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_ParsePublicKeyOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyPrimitivesOperations.Companion_Default___.ParsePublicKey((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *AtomicPrimitivesClient) Config() m_AwsCryptographyPrimitivesOperations.Config {
	{
		return _this._config
	}
}

// End of class AtomicPrimitivesClient
