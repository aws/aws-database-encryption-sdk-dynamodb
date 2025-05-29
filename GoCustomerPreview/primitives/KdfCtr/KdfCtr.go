// Package KdfCtr
// Dafny module KdfCtr compiled into Go

package KdfCtr

import (
	os "os"

	m_AwsCryptographyPrimitivesTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesTypes"
	m_Digest "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/Digest"
	m_HKDF "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/HKDF"
	m_HMAC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/HMAC"
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
	return "KdfCtr.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) KdfCounterMode(input m_AwsCryptographyPrimitivesTypes.KdfCtrInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(((((((((input).Dtor_digestAlgorithm()).Equals(m_AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Create_SHA__256_())) || (((input).Dtor_digestAlgorithm()).Equals(m_AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Create_SHA__384_()))) && ((((uint64(((input).Dtor_ikm()).Cardinality())) == (uint64(32))) || ((uint64(((input).Dtor_ikm()).Cardinality())) == (uint64(48)))) || ((uint64(((input).Dtor_ikm()).Cardinality())) == (uint64(66))))) && (((input).Dtor_nonce()).Is_Some())) && (((uint64((((input).Dtor_nonce()).Dtor_value().(_dafny.Sequence)).Cardinality())) == (uint64(16))) || ((uint64((((input).Dtor_nonce()).Dtor_value().(_dafny.Sequence)).Cardinality())) == (uint64(32))))) && ((((input).Dtor_expectedLength()) == (int32(32))) || (((input).Dtor_expectedLength()) == (int32(64))))) && (((uint64(0)) < (uint64(((input).Dtor_expectedLength())*(int32(8))))) && ((uint64(((input).Dtor_expectedLength())*(int32(8)))) < ((m_StandardLibrary_UInt.Companion_Default___.INT32__MAX__LIMIT()).Uint64()))), m_AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(_dafny.SeqOfString("Kdf in Counter Mode input is invalid.")))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_ikm _dafny.Sequence
	_ = _1_ikm
	_1_ikm = (input).Dtor_ikm()
	var _2_label__ _dafny.Sequence
	_ = _2_label__
	_2_label__ = ((input).Dtor_purpose()).UnwrapOr(_dafny.SeqOf()).(_dafny.Sequence)
	var _3_info _dafny.Sequence
	_ = _3_info
	_3_info = ((input).Dtor_nonce()).UnwrapOr(_dafny.SeqOf()).(_dafny.Sequence)
	var _4_okm _dafny.Sequence
	_ = _4_okm
	_4_okm = _dafny.SeqOf()
	var _5_internalLength uint32
	_ = _5_internalLength
	_5_internalLength = uint32(((uint64(4)) + (uint64((Companion_Default___.SEPARATION__INDICATOR()).Cardinality()))) + (uint64(4)))
	var _6_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _6_valueOrError1
	_6_valueOrError1 = m_Wrappers.Companion_Default___.Need((true) && ((m_StandardLibrary_MemoryMath.Companion_Default___.Add3(uint64(_5_internalLength), uint64((_2_label__).Cardinality()), uint64((_3_info).Cardinality()))) < ((m_StandardLibrary_UInt.Companion_Default___.INT32__MAX__LIMIT()).Uint64())), m_AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(_dafny.SeqOfString("Input Length exceeds INT32_MAX_LIMIT")))
	if (_6_valueOrError1).IsFailure() {
		output = (_6_valueOrError1).PropagateFailure()
		return output
	}
	var _7_lengthBits _dafny.Sequence
	_ = _7_lengthBits
	_7_lengthBits = m_StandardLibrary_UInt.Companion_Default___.UInt32ToSeq(uint32(((input).Dtor_expectedLength()) * (int32(8))))
	var _8_explicitInfo _dafny.Sequence
	_ = _8_explicitInfo
	_8_explicitInfo = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_2_label__, Companion_Default___.SEPARATION__INDICATOR()), _3_info), _7_lengthBits)
	var _9_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _9_valueOrError2
	_9_valueOrError2 = m_Wrappers.Companion_Default___.Need(((uint64(4))+(uint64((_8_explicitInfo).Cardinality()))) < ((m_StandardLibrary_UInt.Companion_Default___.INT32__MAX__LIMIT()).Uint64()), m_AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(_dafny.SeqOfString("PRF input length exceeds INT32_MAX_LIMIT.")))
	if (_9_valueOrError2).IsFailure() {
		output = (_9_valueOrError2).PropagateFailure()
		return output
	}
	var _10_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _10_valueOrError3
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = Companion_Default___.RawDerive(_1_ikm, _8_explicitInfo, (input).Dtor_expectedLength(), int32(0), (input).Dtor_digestAlgorithm())
	_10_valueOrError3 = _out0
	if (_10_valueOrError3).IsFailure() {
		output = (_10_valueOrError3).PropagateFailure()
		return output
	}
	_4_okm = (_10_valueOrError3).Extract().(_dafny.Sequence)
	output = m_Wrappers.Companion_Result_.Create_Success_(_4_okm)
	return output
	return output
}
func (_static *CompanionStruct_Default___) RawDerive(ikm _dafny.Sequence, explicitInfo _dafny.Sequence, length int32, offset int32, digestAlgorithm m_AwsCryptographyPrimitivesTypes.DigestAlgorithm) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_HMAC.Companion_HMac_.Build(digestAlgorithm)
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_hmac *m_HMAC.HMac
	_ = _1_hmac
	_1_hmac = (_0_valueOrError0).Extract().(*m_HMAC.HMac)
	(_1_hmac).Init(ikm)
	var _2_macLengthBytes int32
	_ = _2_macLengthBytes
	_2_macLengthBytes = int32(m_Digest.Companion_Default___.Length(digestAlgorithm))
	var _3_iterations int32
	_ = _3_iterations
	_3_iterations = _dafny.DivInt32(((length)+(_2_macLengthBytes))-(int32(1)), _2_macLengthBytes)
	var _4_buffer _dafny.Sequence
	_ = _4_buffer
	_4_buffer = _dafny.SeqOf()
	var _5_i _dafny.Sequence
	_ = _5_i
	_5_i = m_StandardLibrary_UInt.Companion_Default___.UInt32ToSeq(Companion_Default___.COUNTER__START__VALUE())
	var _hi0 uint64 = m_StandardLibrary_MemoryMath.Companion_Default___.Add(uint64(_3_iterations), uint64(1))
	_ = _hi0
	for _6_iteration := uint64(1); _6_iteration < _hi0; _6_iteration++ {
		(_1_hmac).BlockUpdate(_5_i)
		(_1_hmac).BlockUpdate(explicitInfo)
		var _7_tmp _dafny.Sequence
		_ = _7_tmp
		var _out1 _dafny.Sequence
		_ = _out1
		_out1 = (_1_hmac).GetResult()
		_7_tmp = _out1
		_4_buffer = _dafny.Companion_Sequence_.Concatenate(_4_buffer, _7_tmp)
		var _8_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _8_valueOrError1
		_8_valueOrError1 = Companion_Default___.Increment(_5_i)
		if (_8_valueOrError1).IsFailure() {
			output = (_8_valueOrError1).PropagateFailure()
			return output
		}
		_5_i = (_8_valueOrError1).Extract().(_dafny.Sequence)
	}
	var _9_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _9_valueOrError2
	_9_valueOrError2 = m_Wrappers.Companion_Default___.Need((uint64((_4_buffer).Cardinality())) >= (uint64(length)), m_AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(_dafny.SeqOfString("Failed to derive key of requested length")))
	if (_9_valueOrError2).IsFailure() {
		output = (_9_valueOrError2).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_((_4_buffer).Take(uint32(length)))
	return output
	return output
}
func (_static *CompanionStruct_Default___) Increment(x _dafny.Sequence) m_Wrappers.Result {
	if ((x).Select(uint32(uint32(3))).(uint8)) < (uint8(255)) {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf((x).Select(uint32(uint32(0))).(uint8), (x).Select(uint32(uint32(1))).(uint8), (x).Select(uint32(uint32(2))).(uint8), ((x).Select(uint32(uint32(3))).(uint8))+(uint8(1))))
	} else if ((x).Select(uint32(uint32(2))).(uint8)) < (uint8(255)) {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf((x).Select(uint32(uint32(0))).(uint8), (x).Select(uint32(uint32(1))).(uint8), ((x).Select(uint32(uint32(2))).(uint8))+(uint8(1)), uint8(0)))
	} else if ((x).Select(uint32(uint32(1))).(uint8)) < (uint8(255)) {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf((x).Select(uint32(uint32(0))).(uint8), ((x).Select(uint32(uint32(1))).(uint8))+(uint8(1)), uint8(0), uint8(0)))
	} else if ((x).Select(uint32(uint32(0))).(uint8)) < (uint8(255)) {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf(((x).Select(uint32(uint32(0))).(uint8))+(uint8(1)), uint8(0), uint8(0), uint8(0)))
	} else {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(_dafny.SeqOfString("Unable to derive key material; may have exceeded limit.")))
	}
}
func (_static *CompanionStruct_Default___) SEPARATION__INDICATOR() _dafny.Sequence {
	return _dafny.SeqOf(uint8(0))
}
func (_static *CompanionStruct_Default___) COUNTER__START__VALUE() uint32 {
	return uint32(1)
}

// End of class Default__
