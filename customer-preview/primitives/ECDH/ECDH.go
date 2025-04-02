// Package ECDH
// Dafny module ECDH compiled into Go

package ECDH

import (
	os "os"

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
	return "ECDH.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) GenerateEccKeyPair(input m_AwsCryptographyPrimitivesTypes.GenerateECCKeyPairInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_GenerateECCKeyPairOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_EccKeyPair_.Default())
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_ECDH.KeyGeneration.GenerateKeyPair((input).Dtor_eccCurve())
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_keyPair EccKeyPair
	_ = _1_keyPair
	_1_keyPair = (_0_valueOrError0).Extract().(EccKeyPair)
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyPrimitivesTypes.Companion_GenerateECCKeyPairOutput_.Create_GenerateECCKeyPairOutput_((input).Dtor_eccCurve(), m_AwsCryptographyPrimitivesTypes.Companion_ECCPrivateKey_.Create_ECCPrivateKey_((_1_keyPair).Dtor_privateKey()), m_AwsCryptographyPrimitivesTypes.Companion_ECCPublicKey_.Create_ECCPublicKey_((_1_keyPair).Dtor_publicKey())))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetPublicKeyFromPrivate(input m_AwsCryptographyPrimitivesTypes.GetPublicKeyFromPrivateKeyInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_GetPublicKeyFromPrivateKeyOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_ECDH.ECCUtils.GetPublicKey((input).Dtor_eccCurve(), (input).Dtor_privateKey())
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_publicKey _dafny.Sequence
	_ = _1_publicKey
	_1_publicKey = (_0_valueOrError0).Extract().(_dafny.Sequence)
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyPrimitivesTypes.Companion_GetPublicKeyFromPrivateKeyOutput_.Create_GetPublicKeyFromPrivateKeyOutput_((input).Dtor_eccCurve(), (input).Dtor_privateKey(), _1_publicKey))
	return output
	return output
}
func (_static *CompanionStruct_Default___) Go__ValidatePublicKey(input m_AwsCryptographyPrimitivesTypes.ValidatePublicKeyInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_ValidatePublicKeyOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_ECDH.ECCUtils.ValidatePublicKey((input).Dtor_eccCurve(), (input).Dtor_publicKey())
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_result bool
	_ = _1_result
	_1_result = (_0_valueOrError0).Extract().(bool)
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyPrimitivesTypes.Companion_ValidatePublicKeyOutput_.Create_ValidatePublicKeyOutput_(_1_result))
	return output
	return output
}
func (_static *CompanionStruct_Default___) DeriveSharedSecret(input m_AwsCryptographyPrimitivesTypes.DeriveSharedSecretInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_DeriveSharedSecretOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_ECDH.DeriveSharedSecret.CalculateSharedSecret((input).Dtor_eccCurve(), (input).Dtor_privateKey(), (input).Dtor_publicKey())
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_derivedSharedSecret _dafny.Sequence
	_ = _1_derivedSharedSecret
	_1_derivedSharedSecret = (_0_valueOrError0).Extract().(_dafny.Sequence)
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyPrimitivesTypes.Companion_DeriveSharedSecretOutput_.Create_DeriveSharedSecretOutput_(_1_derivedSharedSecret))
	return output
	return output
}
func (_static *CompanionStruct_Default___) Go__CompressPublicKey(input m_AwsCryptographyPrimitivesTypes.CompressPublicKeyInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_CompressPublicKeyOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_ECDH.ECCUtils.CompressPublicKey(((input).Dtor_publicKey()).Dtor_der(), (input).Dtor_eccCurve())
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_compressedPublicKey _dafny.Sequence
	_ = _1_compressedPublicKey
	_1_compressedPublicKey = (_0_valueOrError0).Extract().(_dafny.Sequence)
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyPrimitivesTypes.Companion_CompressPublicKeyOutput_.Create_CompressPublicKeyOutput_(_1_compressedPublicKey))
	return output
	return output
}
func (_static *CompanionStruct_Default___) Go__DecompressPublicKey(input m_AwsCryptographyPrimitivesTypes.DecompressPublicKeyInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_DecompressPublicKeyOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_ECDH.ECCUtils.DecompressPublicKey((input).Dtor_compressedPublicKey(), (input).Dtor_eccCurve())
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_decompressedPublicKey _dafny.Sequence
	_ = _1_decompressedPublicKey
	_1_decompressedPublicKey = (_0_valueOrError0).Extract().(_dafny.Sequence)
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyPrimitivesTypes.Companion_DecompressPublicKeyOutput_.Create_DecompressPublicKeyOutput_(m_AwsCryptographyPrimitivesTypes.Companion_ECCPublicKey_.Create_ECCPublicKey_(_1_decompressedPublicKey)))
	return output
	return output
}
func (_static *CompanionStruct_Default___) Go__ParsePublicKey(input m_AwsCryptographyPrimitivesTypes.ParsePublicKeyInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_ParsePublicKeyOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_ECDH.ECCUtils.ParsePublicKey((input).Dtor_publicKey())
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_derPublicKey _dafny.Sequence
	_ = _1_derPublicKey
	_1_derPublicKey = (_0_valueOrError0).Extract().(_dafny.Sequence)
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyPrimitivesTypes.Companion_ParsePublicKeyOutput_.Create_ParsePublicKeyOutput_(m_AwsCryptographyPrimitivesTypes.Companion_ECCPublicKey_.Create_ECCPublicKey_(_1_derPublicKey)))
	return output
	return output
}
func (_static *CompanionStruct_Default___) CreateExternEccKeyGenSuccess(output EccKeyPair) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(output)
}
func (_static *CompanionStruct_Default___) CreateExternEccKeyGenFailure(error_ m_AwsCryptographyPrimitivesTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}
func (_static *CompanionStruct_Default___) CreateExternGetPublicKeyFromPrivateSuccess(output _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(output)
}
func (_static *CompanionStruct_Default___) CreateExternGetPublicKeyFromPrivateError(error_ m_AwsCryptographyPrimitivesTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}
func (_static *CompanionStruct_Default___) CreateExternValidatePublicKeySuccess(output bool) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(output)
}
func (_static *CompanionStruct_Default___) CreateExternValidatePublicKeyError(error_ m_AwsCryptographyPrimitivesTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}
func (_static *CompanionStruct_Default___) CreateExternDerivesharedSecretSuccess(output _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(output)
}
func (_static *CompanionStruct_Default___) CreateExternDerivesharedSecretError(error_ m_AwsCryptographyPrimitivesTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}
func (_static *CompanionStruct_Default___) CreateExternCompressPublicKeyError(error_ m_AwsCryptographyPrimitivesTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}
func (_static *CompanionStruct_Default___) CreateExternCompressPublicKeySuccess(output _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(output)
}
func (_static *CompanionStruct_Default___) CreateExternDecompressPublicKeyError(error_ m_AwsCryptographyPrimitivesTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}
func (_static *CompanionStruct_Default___) CreateExternDecompressPublicKeySuccess(output _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(output)
}
func (_static *CompanionStruct_Default___) CreateExternParsePublicKeyError(error_ m_AwsCryptographyPrimitivesTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}
func (_static *CompanionStruct_Default___) CreateExternParsePublicKeySuccess(output _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(output)
}
func (_static *CompanionStruct_Default___) CreateGetInfinityPublicKeyError(error_ m_AwsCryptographyPrimitivesTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}
func (_static *CompanionStruct_Default___) CreateGetInfinityPublicKeySuccess(output _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(output)
}
func (_static *CompanionStruct_Default___) CreateGetOutOfBoundsPublicKeyError(error_ m_AwsCryptographyPrimitivesTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}
func (_static *CompanionStruct_Default___) CreateGetOutOfBoundsPublicKeySuccess(output _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(output)
}

// End of class Default__

// Definition of datatype EccKeyPair
type EccKeyPair struct {
	Data_EccKeyPair_
}

func (_this EccKeyPair) Get_() Data_EccKeyPair_ {
	return _this.Data_EccKeyPair_
}

type Data_EccKeyPair_ interface {
	isEccKeyPair()
}

type CompanionStruct_EccKeyPair_ struct {
}

var Companion_EccKeyPair_ = CompanionStruct_EccKeyPair_{}

type EccKeyPair_EccKeyPair struct {
	PrivateKey _dafny.Sequence
	PublicKey  _dafny.Sequence
}

func (EccKeyPair_EccKeyPair) isEccKeyPair() {}

func (CompanionStruct_EccKeyPair_) Create_EccKeyPair_(PrivateKey _dafny.Sequence, PublicKey _dafny.Sequence) EccKeyPair {
	return EccKeyPair{EccKeyPair_EccKeyPair{PrivateKey, PublicKey}}
}

func (_this EccKeyPair) Is_EccKeyPair() bool {
	_, ok := _this.Get_().(EccKeyPair_EccKeyPair)
	return ok
}

func (CompanionStruct_EccKeyPair_) Default() EccKeyPair {
	return Companion_EccKeyPair_.Create_EccKeyPair_(_dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this EccKeyPair) Dtor_privateKey() _dafny.Sequence {
	return _this.Get_().(EccKeyPair_EccKeyPair).PrivateKey
}

func (_this EccKeyPair) Dtor_publicKey() _dafny.Sequence {
	return _this.Get_().(EccKeyPair_EccKeyPair).PublicKey
}

func (_this EccKeyPair) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EccKeyPair_EccKeyPair:
		{
			return "ECDH.EccKeyPair.EccKeyPair" + "(" + _dafny.String(data.PrivateKey) + ", " + _dafny.String(data.PublicKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EccKeyPair) Equals(other EccKeyPair) bool {
	switch data1 := _this.Get_().(type) {
	case EccKeyPair_EccKeyPair:
		{
			data2, ok := other.Get_().(EccKeyPair_EccKeyPair)
			return ok && data1.PrivateKey.Equals(data2.PrivateKey) && data1.PublicKey.Equals(data2.PublicKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EccKeyPair) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EccKeyPair)
	return ok && _this.Equals(typed)
}

func Type_EccKeyPair_() _dafny.TypeDescriptor {
	return type_EccKeyPair_{}
}

type type_EccKeyPair_ struct {
}

func (_this type_EccKeyPair_) Default() interface{} {
	return Companion_EccKeyPair_.Default()
}

func (_this type_EccKeyPair_) String() string {
	return "ECDH.EccKeyPair"
}
func (_this EccKeyPair) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EccKeyPair{}

// End of datatype EccKeyPair
