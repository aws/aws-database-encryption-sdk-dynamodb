// Package WrappedHKDF
// Dafny module WrappedHKDF compiled into Go

package WrappedHKDF

import (
	os "os"

	m_AwsCryptographyPrimitivesTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesTypes"
	m_Digest "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/Digest"
	m_HKDF "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/HKDF"
	m_HMAC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/HMAC"
	m_Random "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/Random"
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
	return "WrappedHKDF.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) Extract(input m_AwsCryptographyPrimitivesTypes.HkdfExtractInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(((((input).Dtor_salt()).Is_None()) || ((_dafny.IntOfUint32((((input).Dtor_salt()).Dtor_value().(_dafny.Sequence)).Cardinality())).Sign() != 0)) && ((_dafny.IntOfUint32(((input).Dtor_ikm()).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.INT32__MAX__LIMIT()) < 0), m_AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(_dafny.SeqOfString("HKDF Extract needs a salt and reasonable ikm.")))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _let_tmp_rhs0 m_AwsCryptographyPrimitivesTypes.HkdfExtractInput = input
	_ = _let_tmp_rhs0
	var _1_digestAlgorithm m_AwsCryptographyPrimitivesTypes.DigestAlgorithm = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.HkdfExtractInput_HkdfExtractInput).DigestAlgorithm
	_ = _1_digestAlgorithm
	var _2_salt m_Wrappers.Option = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.HkdfExtractInput_HkdfExtractInput).Salt
	_ = _2_salt
	var _3_ikm _dafny.Sequence = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.HkdfExtractInput_HkdfExtractInput).Ikm
	_ = _3_ikm
	var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _4_valueOrError1
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_HMAC.Companion_HMac_.Build(_1_digestAlgorithm)
	_4_valueOrError1 = _out0
	if (_4_valueOrError1).IsFailure() {
		output = (_4_valueOrError1).PropagateFailure()
		return output
	}
	var _5_hmac *m_HMAC.HMac
	_ = _5_hmac
	_5_hmac = (_4_valueOrError1).Extract().(*m_HMAC.HMac)
	var _6_prk _dafny.Sequence
	_ = _6_prk
	var _out1 _dafny.Sequence
	_ = _out1
	_out1 = m_HKDF.Companion_Default___.Extract(_5_hmac, (_2_salt).UnwrapOr(m_StandardLibrary.Companion_Default___.Fill(uint8(0), m_Digest.Companion_Default___.Length(_1_digestAlgorithm))).(_dafny.Sequence), _3_ikm)
	_6_prk = _out1
	output = m_Wrappers.Companion_Result_.Create_Success_(_6_prk)
	return output
	return output
}
func (_static *CompanionStruct_Default___) Expand(input m_AwsCryptographyPrimitivesTypes.HkdfExpandInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(((((_dafny.One).Cmp(_dafny.IntOfInt32((input).Dtor_expectedLength())) <= 0) && ((_dafny.IntOfInt32((input).Dtor_expectedLength())).Cmp((_dafny.IntOfInt64(255)).Times(m_Digest.Companion_Default___.Length((input).Dtor_digestAlgorithm()))) <= 0)) && ((_dafny.IntOfUint32(((input).Dtor_info()).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.INT32__MAX__LIMIT()) < 0)) && ((m_Digest.Companion_Default___.Length((input).Dtor_digestAlgorithm())).Cmp(_dafny.IntOfUint32(((input).Dtor_prk()).Cardinality())) == 0), m_AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(_dafny.SeqOfString("HKDF Expand needs valid input.")))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _let_tmp_rhs0 m_AwsCryptographyPrimitivesTypes.HkdfExpandInput = input
	_ = _let_tmp_rhs0
	var _1_digestAlgorithm m_AwsCryptographyPrimitivesTypes.DigestAlgorithm = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.HkdfExpandInput_HkdfExpandInput).DigestAlgorithm
	_ = _1_digestAlgorithm
	var _2_prk _dafny.Sequence = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.HkdfExpandInput_HkdfExpandInput).Prk
	_ = _2_prk
	var _3_info _dafny.Sequence = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.HkdfExpandInput_HkdfExpandInput).Info
	_ = _3_info
	var _4_expectedLength int32 = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.HkdfExpandInput_HkdfExpandInput).ExpectedLength
	_ = _4_expectedLength
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _5_valueOrError1
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_HMAC.Companion_HMac_.Build(_1_digestAlgorithm)
	_5_valueOrError1 = _out0
	if (_5_valueOrError1).IsFailure() {
		output = (_5_valueOrError1).PropagateFailure()
		return output
	}
	var _6_hmac *m_HMAC.HMac
	_ = _6_hmac
	_6_hmac = (_5_valueOrError1).Extract().(*m_HMAC.HMac)
	var _7_omk _dafny.Sequence
	_ = _7_omk
	var _out1 _dafny.Sequence
	_ = _out1
	_out1 = m_HKDF.Companion_Default___.Expand(_6_hmac, _2_prk, _3_info, _dafny.IntOfInt32(_4_expectedLength), _1_digestAlgorithm)
	_7_omk = _out1
	output = m_Wrappers.Companion_Result_.Create_Success_(_7_omk)
	return output
	return output
}
func (_static *CompanionStruct_Default___) Hkdf(input m_AwsCryptographyPrimitivesTypes.HkdfInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((((((_dafny.One).Cmp(_dafny.IntOfInt32((input).Dtor_expectedLength())) <= 0) && ((_dafny.IntOfInt32((input).Dtor_expectedLength())).Cmp((_dafny.IntOfInt64(255)).Times(m_Digest.Companion_Default___.Length((input).Dtor_digestAlgorithm()))) <= 0)) && ((((input).Dtor_salt()).Is_None()) || ((_dafny.IntOfUint32((((input).Dtor_salt()).Dtor_value().(_dafny.Sequence)).Cardinality())).Sign() != 0))) && ((_dafny.IntOfUint32(((input).Dtor_info()).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.INT32__MAX__LIMIT()) < 0)) && ((_dafny.IntOfUint32(((input).Dtor_ikm()).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.INT32__MAX__LIMIT()) < 0), m_AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(_dafny.SeqOfString("Wrapped Hkdf input is invalid.")))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _let_tmp_rhs0 m_AwsCryptographyPrimitivesTypes.HkdfInput = input
	_ = _let_tmp_rhs0
	var _1_digest m_AwsCryptographyPrimitivesTypes.DigestAlgorithm = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.HkdfInput_HkdfInput).DigestAlgorithm
	_ = _1_digest
	var _2_salt m_Wrappers.Option = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.HkdfInput_HkdfInput).Salt
	_ = _2_salt
	var _3_ikm _dafny.Sequence = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.HkdfInput_HkdfInput).Ikm
	_ = _3_ikm
	var _4_info _dafny.Sequence = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.HkdfInput_HkdfInput).Info
	_ = _4_info
	var _5_expectedLength int32 = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.HkdfInput_HkdfInput).ExpectedLength
	_ = _5_expectedLength
	var _6_okm _dafny.Sequence
	_ = _6_okm
	var _out0 _dafny.Sequence
	_ = _out0
	_out0 = m_HKDF.Companion_Default___.Hkdf(_1_digest, _2_salt, _3_ikm, _4_info, _dafny.IntOfInt32(_5_expectedLength))
	_6_okm = _out0
	output = m_Wrappers.Companion_Result_.Create_Success_(_6_okm)
	return output
	return output
}

// End of class Default__
