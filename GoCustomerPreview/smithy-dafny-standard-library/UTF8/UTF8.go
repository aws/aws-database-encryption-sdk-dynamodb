// Package UTF8
// Dafny module UTF8 compiled into Go

package UTF8

import (
	os "os"

	m_BoundedInts "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/BoundedInts"
	m_DivInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivInternals"
	m_DivInternalsNonlinear "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivInternalsNonlinear"
	m_DivMod "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivMod"
	m_FileIO "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/FileIO"
	m_Functions "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Functions"
	m_GeneralInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/GeneralInternals"
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
	m_StandardLibrary "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary"
	m_StandardLibraryInterop "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibraryInterop"
	m_StandardLibrary_MemoryMath "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_MemoryMath"
	m_StandardLibrary_Sequence "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_Sequence"
	m_StandardLibrary_String "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_String"
	m_StandardLibrary_UInt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_UInt"
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
	return "UTF8.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) CreateEncodeSuccess(bytes _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(bytes)
}
func (_static *CompanionStruct_Default___) CreateEncodeFailure(error_ _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}
func (_static *CompanionStruct_Default___) CreateDecodeSuccess(s _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(s)
}
func (_static *CompanionStruct_Default___) CreateDecodeFailure(error_ _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}
func (_static *CompanionStruct_Default___) IsASCIIString(s _dafny.Sequence) bool {
	return _dafny.Quantifier(_dafny.IntegerRange(_dafny.Zero, _dafny.IntOfUint32((s).Cardinality())), true, func(_forall_var_0 _dafny.Int) bool {
		var _0_i _dafny.Int
		_0_i = interface{}(_forall_var_0).(_dafny.Int)
		return !(((_0_i).Sign() != -1) && ((_0_i).Cmp(_dafny.IntOfUint32((s).Cardinality())) < 0)) || ((_dafny.IntOfInt32(rune((s).Select((_0_i).Uint32()).(_dafny.Char)))).Cmp(_dafny.IntOfInt64(128)) < 0)
	})
}
func (_static *CompanionStruct_Default___) Uses1Byte(s _dafny.Sequence) bool {
	return ((uint8(0)) <= ((s).Select(0).(uint8))) && (((s).Select(0).(uint8)) <= (uint8(127)))
}
func (_static *CompanionStruct_Default___) Uses2Bytes(s _dafny.Sequence) bool {
	return (((uint8(194)) <= ((s).Select(0).(uint8))) && (((s).Select(0).(uint8)) <= (uint8(223)))) && (((uint8(128)) <= ((s).Select(1).(uint8))) && (((s).Select(1).(uint8)) <= (uint8(191))))
}
func (_static *CompanionStruct_Default___) Uses3Bytes(s _dafny.Sequence) bool {
	return (((((((s).Select(0).(uint8)) == (uint8(224))) && (((uint8(160)) <= ((s).Select(1).(uint8))) && (((s).Select(1).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((s).Select(2).(uint8))) && (((s).Select(2).(uint8)) <= (uint8(191))))) || (((((uint8(225)) <= ((s).Select(0).(uint8))) && (((s).Select(0).(uint8)) <= (uint8(236)))) && (((uint8(128)) <= ((s).Select(1).(uint8))) && (((s).Select(1).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((s).Select(2).(uint8))) && (((s).Select(2).(uint8)) <= (uint8(191)))))) || (((((s).Select(0).(uint8)) == (uint8(237))) && (((uint8(128)) <= ((s).Select(1).(uint8))) && (((s).Select(1).(uint8)) <= (uint8(159))))) && (((uint8(128)) <= ((s).Select(2).(uint8))) && (((s).Select(2).(uint8)) <= (uint8(191)))))) || (((((uint8(238)) <= ((s).Select(0).(uint8))) && (((s).Select(0).(uint8)) <= (uint8(239)))) && (((uint8(128)) <= ((s).Select(1).(uint8))) && (((s).Select(1).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((s).Select(2).(uint8))) && (((s).Select(2).(uint8)) <= (uint8(191)))))
}
func (_static *CompanionStruct_Default___) Uses4Bytes(s _dafny.Sequence) bool {
	return (((((((s).Select(0).(uint8)) == (uint8(240))) && (((uint8(144)) <= ((s).Select(1).(uint8))) && (((s).Select(1).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((s).Select(2).(uint8))) && (((s).Select(2).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((s).Select(3).(uint8))) && (((s).Select(3).(uint8)) <= (uint8(191))))) || ((((((uint8(241)) <= ((s).Select(0).(uint8))) && (((s).Select(0).(uint8)) <= (uint8(243)))) && (((uint8(128)) <= ((s).Select(1).(uint8))) && (((s).Select(1).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((s).Select(2).(uint8))) && (((s).Select(2).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((s).Select(3).(uint8))) && (((s).Select(3).(uint8)) <= (uint8(191)))))) || ((((((s).Select(0).(uint8)) == (uint8(244))) && (((uint8(128)) <= ((s).Select(1).(uint8))) && (((s).Select(1).(uint8)) <= (uint8(143))))) && (((uint8(128)) <= ((s).Select(2).(uint8))) && (((s).Select(2).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((s).Select(3).(uint8))) && (((s).Select(3).(uint8)) <= (uint8(191)))))
}
func (_static *CompanionStruct_Default___) ValidUTF8Range(a _dafny.Sequence, lo _dafny.Int, hi _dafny.Int) bool {
	var _hresult bool = false
	_ = _hresult
	if m_StandardLibrary_UInt.Companion_Default___.HasUint64Len(a) {
		_hresult = Companion_Default___.BoundedValidUTF8Range(a, (lo).Uint64(), (hi).Uint64())
		return _hresult
	}
	if (lo).Cmp(hi) == 0 {
		_hresult = true
		return _hresult
	}
	var _0_i _dafny.Int
	_ = _0_i
	_0_i = lo
	for (_0_i).Cmp(hi) < 0 {
		if ((_0_i).Cmp(hi) < 0) && (((uint8(0)) <= ((a).Select((_0_i).Uint32()).(uint8))) && (((a).Select((_0_i).Uint32()).(uint8)) <= (uint8(127)))) {
			_0_i = (_0_i).Plus(_dafny.One)
		} else if ((((_0_i).Plus(_dafny.One)).Cmp(hi) < 0) && (((uint8(194)) <= ((a).Select((_0_i).Uint32()).(uint8))) && (((a).Select((_0_i).Uint32()).(uint8)) <= (uint8(223))))) && (((uint8(128)) <= ((a).Select(((_0_i).Plus(_dafny.One)).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.One)).Uint32()).(uint8)) <= (uint8(191)))) {
			_0_i = (_0_i).Plus(_dafny.IntOfInt64(2))
		} else if (((_0_i).Plus(_dafny.IntOfInt64(2))).Cmp(hi) < 0) && ((((((((a).Select((_0_i).Uint32()).(uint8)) == (uint8(224))) && (((uint8(160)) <= ((a).Select(((_0_i).Plus(_dafny.One)).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.One)).Uint32()).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((a).Select(((_0_i).Plus(_dafny.IntOfInt64(2))).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.IntOfInt64(2))).Uint32()).(uint8)) <= (uint8(191))))) || (((((uint8(225)) <= ((a).Select((_0_i).Uint32()).(uint8))) && (((a).Select((_0_i).Uint32()).(uint8)) <= (uint8(236)))) && (((uint8(128)) <= ((a).Select(((_0_i).Plus(_dafny.One)).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.One)).Uint32()).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((a).Select(((_0_i).Plus(_dafny.IntOfInt64(2))).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.IntOfInt64(2))).Uint32()).(uint8)) <= (uint8(191)))))) || (((((a).Select((_0_i).Uint32()).(uint8)) == (uint8(237))) && (((uint8(128)) <= ((a).Select(((_0_i).Plus(_dafny.One)).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.One)).Uint32()).(uint8)) <= (uint8(159))))) && (((uint8(128)) <= ((a).Select(((_0_i).Plus(_dafny.IntOfInt64(2))).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.IntOfInt64(2))).Uint32()).(uint8)) <= (uint8(191)))))) || (((((uint8(238)) <= ((a).Select((_0_i).Uint32()).(uint8))) && (((a).Select((_0_i).Uint32()).(uint8)) <= (uint8(239)))) && (((uint8(128)) <= ((a).Select(((_0_i).Plus(_dafny.One)).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.One)).Uint32()).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((a).Select(((_0_i).Plus(_dafny.IntOfInt64(2))).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.IntOfInt64(2))).Uint32()).(uint8)) <= (uint8(191)))))) {
			_0_i = (_0_i).Plus(_dafny.IntOfInt64(3))
		} else if (((_0_i).Plus(_dafny.IntOfInt64(3))).Cmp(hi) < 0) && ((((((((a).Select((_0_i).Uint32()).(uint8)) == (uint8(240))) && (((uint8(144)) <= ((a).Select(((_0_i).Plus(_dafny.One)).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.One)).Uint32()).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((a).Select(((_0_i).Plus(_dafny.IntOfInt64(2))).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.IntOfInt64(2))).Uint32()).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((a).Select(((_0_i).Plus(_dafny.IntOfInt64(3))).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.IntOfInt64(3))).Uint32()).(uint8)) <= (uint8(191))))) || ((((((uint8(241)) <= ((a).Select((_0_i).Uint32()).(uint8))) && (((a).Select((_0_i).Uint32()).(uint8)) <= (uint8(243)))) && (((uint8(128)) <= ((a).Select(((_0_i).Plus(_dafny.One)).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.One)).Uint32()).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((a).Select(((_0_i).Plus(_dafny.IntOfInt64(2))).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.IntOfInt64(2))).Uint32()).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((a).Select(((_0_i).Plus(_dafny.IntOfInt64(3))).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.IntOfInt64(3))).Uint32()).(uint8)) <= (uint8(191)))))) || ((((((a).Select((_0_i).Uint32()).(uint8)) == (uint8(244))) && (((uint8(128)) <= ((a).Select(((_0_i).Plus(_dafny.One)).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.One)).Uint32()).(uint8)) <= (uint8(143))))) && (((uint8(128)) <= ((a).Select(((_0_i).Plus(_dafny.IntOfInt64(2))).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.IntOfInt64(2))).Uint32()).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((a).Select(((_0_i).Plus(_dafny.IntOfInt64(3))).Uint32()).(uint8))) && (((a).Select(((_0_i).Plus(_dafny.IntOfInt64(3))).Uint32()).(uint8)) <= (uint8(191)))))) {
			_0_i = (_0_i).Plus(_dafny.IntOfInt64(4))
		} else {
			_hresult = false
			return _hresult
		}
	}
	_hresult = true
	return _hresult
	return _hresult
}
func (_static *CompanionStruct_Default___) BoundedValidUTF8Range(a _dafny.Sequence, lo uint64, hi uint64) bool {
	var _hresult bool = false
	_ = _hresult
	if (lo) == (hi) {
		_hresult = true
		return _hresult
	}
	var _0_i uint64
	_ = _0_i
	_0_i = lo
	for (_0_i) < (hi) {
		if ((_0_i) < (hi)) && (((uint8(0)) <= ((a).Select(uint32(_0_i)).(uint8))) && (((a).Select(uint32(_0_i)).(uint8)) <= (uint8(127)))) {
			_0_i = (_0_i) + (uint64(1))
		} else if (((_0_i) < ((hi) - (func() uint64 { return (uint64(1)) })())) && (((uint8(194)) <= ((a).Select(uint32(_0_i)).(uint8))) && (((a).Select(uint32(_0_i)).(uint8)) <= (uint8(223))))) && (((uint8(128)) <= ((a).Select(uint32((_0_i) + (uint64(1)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(1)))).(uint8)) <= (uint8(191)))) {
			_0_i = (_0_i) + (uint64(2))
		} else if (((uint64(2)) <= (hi)) && ((_0_i) < ((hi) - (func() uint64 { return (uint64(2)) })()))) && ((((((((a).Select(uint32(_0_i)).(uint8)) == (uint8(224))) && (((uint8(160)) <= ((a).Select(uint32((_0_i) + (uint64(1)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(1)))).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((a).Select(uint32((_0_i) + (uint64(2)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(2)))).(uint8)) <= (uint8(191))))) || (((((uint8(225)) <= ((a).Select(uint32(_0_i)).(uint8))) && (((a).Select(uint32(_0_i)).(uint8)) <= (uint8(236)))) && (((uint8(128)) <= ((a).Select(uint32((_0_i) + (uint64(1)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(1)))).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((a).Select(uint32((_0_i) + (uint64(2)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(2)))).(uint8)) <= (uint8(191)))))) || (((((a).Select(uint32(_0_i)).(uint8)) == (uint8(237))) && (((uint8(128)) <= ((a).Select(uint32((_0_i) + (uint64(1)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(1)))).(uint8)) <= (uint8(159))))) && (((uint8(128)) <= ((a).Select(uint32((_0_i) + (uint64(2)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(2)))).(uint8)) <= (uint8(191)))))) || (((((uint8(238)) <= ((a).Select(uint32(_0_i)).(uint8))) && (((a).Select(uint32(_0_i)).(uint8)) <= (uint8(239)))) && (((uint8(128)) <= ((a).Select(uint32((_0_i) + (uint64(1)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(1)))).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((a).Select(uint32((_0_i) + (uint64(2)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(2)))).(uint8)) <= (uint8(191)))))) {
			_0_i = (_0_i) + (uint64(3))
		} else if (((uint64(3)) <= (hi)) && ((_0_i) < ((hi) - (func() uint64 { return (uint64(3)) })()))) && ((((((((a).Select(uint32(_0_i)).(uint8)) == (uint8(240))) && (((uint8(144)) <= ((a).Select(uint32((_0_i) + (uint64(1)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(1)))).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((a).Select(uint32((_0_i) + (uint64(2)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(2)))).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((a).Select(uint32((_0_i) + (uint64(3)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(3)))).(uint8)) <= (uint8(191))))) || ((((((uint8(241)) <= ((a).Select(uint32(_0_i)).(uint8))) && (((a).Select(uint32(_0_i)).(uint8)) <= (uint8(243)))) && (((uint8(128)) <= ((a).Select(uint32((_0_i) + (uint64(1)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(1)))).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((a).Select(uint32((_0_i) + (uint64(2)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(2)))).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((a).Select(uint32((_0_i) + (uint64(3)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(3)))).(uint8)) <= (uint8(191)))))) || ((((((a).Select(uint32(_0_i)).(uint8)) == (uint8(244))) && (((uint8(128)) <= ((a).Select(uint32((_0_i) + (uint64(1)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(1)))).(uint8)) <= (uint8(143))))) && (((uint8(128)) <= ((a).Select(uint32((_0_i) + (uint64(2)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(2)))).(uint8)) <= (uint8(191))))) && (((uint8(128)) <= ((a).Select(uint32((_0_i) + (uint64(3)))).(uint8))) && (((a).Select(uint32((_0_i) + (uint64(3)))).(uint8)) <= (uint8(191)))))) {
			_0_i = (_0_i) + (uint64(4))
		} else {
			_hresult = false
			return _hresult
		}
	}
	_hresult = true
	return _hresult
	return _hresult
}
func (_static *CompanionStruct_Default___) ValidUTF8Seq(s _dafny.Sequence) bool {
	return Companion_Default___.ValidUTF8Range(s, _dafny.Zero, _dafny.IntOfUint32((s).Cardinality()))
}

// End of class Default__

// Definition of class ValidUTF8Bytes
type ValidUTF8Bytes struct {
}

func New_ValidUTF8Bytes_() *ValidUTF8Bytes {
	_this := ValidUTF8Bytes{}

	return &_this
}

type CompanionStruct_ValidUTF8Bytes_ struct {
}

var Companion_ValidUTF8Bytes_ = CompanionStruct_ValidUTF8Bytes_{}

func (*ValidUTF8Bytes) String() string {
	return "UTF8.ValidUTF8Bytes"
}
func (_this *CompanionStruct_ValidUTF8Bytes_) Witness() _dafny.Sequence {
	return _dafny.SeqOf()
}

// End of class ValidUTF8Bytes

func Type_ValidUTF8Bytes_() _dafny.TypeDescriptor {
	return type_ValidUTF8Bytes_{}
}

type type_ValidUTF8Bytes_ struct {
}

func (_this type_ValidUTF8Bytes_) Default() interface{} {
	return Companion_ValidUTF8Bytes_.Witness()
}

func (_this type_ValidUTF8Bytes_) String() string {
	return "UTF8.ValidUTF8Bytes"
}
func (_this *CompanionStruct_ValidUTF8Bytes_) Is_(__source _dafny.Sequence) bool {
	var _0_i _dafny.Sequence = (__source)
	_ = _0_i
	return Companion_Default___.ValidUTF8Seq(_0_i)
}
