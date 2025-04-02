// Package HKDF
// Dafny module HKDF compiled into Go

package HKDF

import (
	os "os"

	m_AwsCryptographyPrimitivesTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesTypes"
	m_Digest "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/Digest"
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
	return "HKDF.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) Extract(hmac *m_HMAC.HMac, salt _dafny.Sequence, ikm _dafny.Sequence) _dafny.Sequence {
	var prk _dafny.Sequence = _dafny.EmptySeq
	_ = prk
	(hmac).Init(salt)
	(hmac).BlockUpdate(ikm)
	var _out0 _dafny.Sequence
	_ = _out0
	_out0 = (hmac).GetResult()
	prk = _out0
	prk = prk
	return prk
	return prk
}
func (_static *CompanionStruct_Default___) Expand(hmac *m_HMAC.HMac, prk _dafny.Sequence, info _dafny.Sequence, expectedLength _dafny.Int, digest m_AwsCryptographyPrimitivesTypes.DigestAlgorithm) _dafny.Sequence {
	var okm _dafny.Sequence = _dafny.EmptySeq
	_ = okm
	var _0_hashLength _dafny.Int
	_ = _0_hashLength
	_0_hashLength = m_Digest.Companion_Default___.Length(digest)
	var _1_n _dafny.Int
	_ = _1_n
	_1_n = (((_0_hashLength).Plus(expectedLength)).Minus(_dafny.One)).DivBy(_0_hashLength)
	(hmac).Init(prk)
	var _2_t__prev _dafny.Sequence
	_ = _2_t__prev
	_2_t__prev = _dafny.SeqOf()
	var _3_t__n _dafny.Sequence
	_ = _3_t__n
	_3_t__n = _2_t__prev
	var _4_i _dafny.Int
	_ = _4_i
	_4_i = _dafny.One
	for (_4_i).Cmp(_1_n) <= 0 {
		(hmac).BlockUpdate(_2_t__prev)
		(hmac).BlockUpdate(info)
		(hmac).BlockUpdate(_dafny.SeqOf((_4_i).Uint8()))
		var _out0 _dafny.Sequence
		_ = _out0
		_out0 = (hmac).GetResult()
		_2_t__prev = _out0
		_3_t__n = _dafny.Companion_Sequence_.Concatenate(_3_t__n, _2_t__prev)
		_4_i = (_4_i).Plus(_dafny.One)
	}
	okm = _3_t__n
	if (expectedLength).Cmp(_dafny.IntOfUint32((okm).Cardinality())) < 0 {
		okm = (okm).Take((expectedLength).Uint32())
	}
	return okm
}
func (_static *CompanionStruct_Default___) Hkdf(digest m_AwsCryptographyPrimitivesTypes.DigestAlgorithm, salt m_Wrappers.Option, ikm _dafny.Sequence, info _dafny.Sequence, L _dafny.Int) _dafny.Sequence {
	var okm _dafny.Sequence = _dafny.EmptySeq
	_ = okm
	if (L).Sign() == 0 {
		okm = _dafny.SeqOf()
		return okm
	}
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_HMAC.Companion_HMac_.Build(digest)
	_0_valueOrError0 = _out0
	if !(!((_0_valueOrError0).IsFailure())) {
		panic("src/HKDF/HKDF.dfy(222,16): " + (_0_valueOrError0).String())
	}
	var _1_hmac *m_HMAC.HMac
	_ = _1_hmac
	_1_hmac = (_0_valueOrError0).Extract().(*m_HMAC.HMac)
	var _2_hashLength _dafny.Int
	_ = _2_hashLength
	_2_hashLength = m_Digest.Companion_Default___.Length(digest)
	var _3_nonEmptySalt _dafny.Sequence = _dafny.EmptySeq
	_ = _3_nonEmptySalt
	var _source0 m_Wrappers.Option = salt
	_ = _source0
	{
		{
			if _source0.Is_None() {
				_3_nonEmptySalt = m_StandardLibrary.Companion_Default___.Fill(uint8(0), _2_hashLength)
				goto Lmatch0
			}
		}
		{
			var _4_s _dafny.Sequence = _source0.Get_().(m_Wrappers.Option_Some).Value.(_dafny.Sequence)
			_ = _4_s
			_3_nonEmptySalt = _4_s
		}
		goto Lmatch0
	}
Lmatch0:
	var _5_prk _dafny.Sequence
	_ = _5_prk
	var _out1 _dafny.Sequence
	_ = _out1
	_out1 = Companion_Default___.Extract(_1_hmac, _3_nonEmptySalt, ikm)
	_5_prk = _out1
	var _out2 _dafny.Sequence
	_ = _out2
	_out2 = Companion_Default___.Expand(_1_hmac, _5_prk, info, L, digest)
	okm = _out2
	return okm
}

// End of class Default__
