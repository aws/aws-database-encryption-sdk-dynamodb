// Package Signature
// Dafny module Signature compiled into Go

package Signature

import (
	os "os"

	m_AwsCryptographyPrimitivesTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesTypes"
	m_Digest "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/Digest"
	m_HKDF "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/HKDF"
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
	return "Signature.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) SignatureLength(signatureAlgorithm m_AwsCryptographyPrimitivesTypes.ECDSASignatureAlgorithm) uint16 {
	var _source0 m_AwsCryptographyPrimitivesTypes.ECDSASignatureAlgorithm = signatureAlgorithm
	_ = _source0
	{
		if _source0.Is_ECDSA__P256() {
			return uint16(71)
		}
	}
	{
		return uint16(103)
	}
}
func (_static *CompanionStruct_Default___) FieldSize(signatureAlgorithm m_AwsCryptographyPrimitivesTypes.ECDSASignatureAlgorithm) _dafny.Int {
	var _source0 m_AwsCryptographyPrimitivesTypes.ECDSASignatureAlgorithm = signatureAlgorithm
	_ = _source0
	{
		if _source0.Is_ECDSA__P256() {
			return _dafny.IntOfInt64(33)
		}
	}
	{
		return _dafny.IntOfInt64(49)
	}
}
func (_static *CompanionStruct_Default___) KeyGen(input m_AwsCryptographyPrimitivesTypes.GenerateECDSASignatureKeyInput) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_GenerateECDSASignatureKeyOutput_.Default())
	_ = res
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_SignatureKeyPair_.Default())
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_Signature.ECDSA.ExternKeyGen((input).Dtor_signatureAlgorithm())
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		res = (_0_valueOrError0).PropagateFailure()
		return res
	}
	var _1_sigKeyPair SignatureKeyPair
	_ = _1_sigKeyPair
	_1_sigKeyPair = (_0_valueOrError0).Extract().(SignatureKeyPair)
	var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _2_valueOrError1
	_2_valueOrError1 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32(((_1_sigKeyPair).Dtor_verificationKey()).Cardinality())).Cmp(Companion_Default___.FieldSize((input).Dtor_signatureAlgorithm())) == 0, m_AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(_dafny.SeqOfString("Incorrect verification-key length from ExternKeyGen.")))
	if (_2_valueOrError1).IsFailure() {
		res = (_2_valueOrError1).PropagateFailure()
		return res
	}
	res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyPrimitivesTypes.Companion_GenerateECDSASignatureKeyOutput_.Create_GenerateECDSASignatureKeyOutput_((input).Dtor_signatureAlgorithm(), (_1_sigKeyPair).Dtor_verificationKey(), (_1_sigKeyPair).Dtor_signingKey()))
	return res
	return res
}
func (_static *CompanionStruct_Default___) CreateExternKeyGenSuccess(output SignatureKeyPair) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(output)
}
func (_static *CompanionStruct_Default___) CreateExternKeyGenFailure(error_ m_AwsCryptographyPrimitivesTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}
func (_static *CompanionStruct_Default___) CreateSignSuccess(bytes _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(bytes)
}
func (_static *CompanionStruct_Default___) CreateSignFailure(error_ m_AwsCryptographyPrimitivesTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}
func (_static *CompanionStruct_Default___) CreateVerifySuccess(b bool) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(b)
}
func (_static *CompanionStruct_Default___) CreateVerifyFailure(error_ m_AwsCryptographyPrimitivesTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}

// End of class Default__

// Definition of datatype SignatureKeyPair
type SignatureKeyPair struct {
	Data_SignatureKeyPair_
}

func (_this SignatureKeyPair) Get_() Data_SignatureKeyPair_ {
	return _this.Data_SignatureKeyPair_
}

type Data_SignatureKeyPair_ interface {
	isSignatureKeyPair()
}

type CompanionStruct_SignatureKeyPair_ struct {
}

var Companion_SignatureKeyPair_ = CompanionStruct_SignatureKeyPair_{}

type SignatureKeyPair_SignatureKeyPair struct {
	VerificationKey _dafny.Sequence
	SigningKey      _dafny.Sequence
}

func (SignatureKeyPair_SignatureKeyPair) isSignatureKeyPair() {}

func (CompanionStruct_SignatureKeyPair_) Create_SignatureKeyPair_(VerificationKey _dafny.Sequence, SigningKey _dafny.Sequence) SignatureKeyPair {
	return SignatureKeyPair{SignatureKeyPair_SignatureKeyPair{VerificationKey, SigningKey}}
}

func (_this SignatureKeyPair) Is_SignatureKeyPair() bool {
	_, ok := _this.Get_().(SignatureKeyPair_SignatureKeyPair)
	return ok
}

func (CompanionStruct_SignatureKeyPair_) Default() SignatureKeyPair {
	return Companion_SignatureKeyPair_.Create_SignatureKeyPair_(_dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this SignatureKeyPair) Dtor_verificationKey() _dafny.Sequence {
	return _this.Get_().(SignatureKeyPair_SignatureKeyPair).VerificationKey
}

func (_this SignatureKeyPair) Dtor_signingKey() _dafny.Sequence {
	return _this.Get_().(SignatureKeyPair_SignatureKeyPair).SigningKey
}

func (_this SignatureKeyPair) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case SignatureKeyPair_SignatureKeyPair:
		{
			return "Signature.SignatureKeyPair.SignatureKeyPair" + "(" + _dafny.String(data.VerificationKey) + ", " + _dafny.String(data.SigningKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this SignatureKeyPair) Equals(other SignatureKeyPair) bool {
	switch data1 := _this.Get_().(type) {
	case SignatureKeyPair_SignatureKeyPair:
		{
			data2, ok := other.Get_().(SignatureKeyPair_SignatureKeyPair)
			return ok && data1.VerificationKey.Equals(data2.VerificationKey) && data1.SigningKey.Equals(data2.SigningKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this SignatureKeyPair) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(SignatureKeyPair)
	return ok && _this.Equals(typed)
}

func Type_SignatureKeyPair_() _dafny.TypeDescriptor {
	return type_SignatureKeyPair_{}
}

type type_SignatureKeyPair_ struct {
}

func (_this type_SignatureKeyPair_) Default() interface{} {
	return Companion_SignatureKeyPair_.Default()
}

func (_this type_SignatureKeyPair_) String() string {
	return "Signature.SignatureKeyPair"
}
func (_this SignatureKeyPair) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = SignatureKeyPair{}

// End of datatype SignatureKeyPair
