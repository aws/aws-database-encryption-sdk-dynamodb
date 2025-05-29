// Package HexStrings
// Dafny module HexStrings compiled into Go

package HexStrings

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
	return "HexStrings.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) HexChar(x uint8) _dafny.Char {
	if (x) < (uint8(10)) {
		return (_dafny.Char('0')) + (_dafny.Char((x)))
	} else {
		return (_dafny.Char('a')) + (_dafny.Char(((x) - (func() uint8 { return (uint8(10)) })())))
	}
}
func (_static *CompanionStruct_Default___) IsLooseHexChar(ch _dafny.Char) bool {
	return ((((_dafny.Char('0')) <= (ch)) && ((ch) <= (_dafny.Char('9')))) || (((_dafny.Char('a')) <= (ch)) && ((ch) <= (_dafny.Char('f'))))) || (((_dafny.Char('A')) <= (ch)) && ((ch) <= (_dafny.Char('F'))))
}
func (_static *CompanionStruct_Default___) IsHexChar(ch _dafny.Char) bool {
	return (((_dafny.Char('0')) <= (ch)) && ((ch) <= (_dafny.Char('9')))) || (((_dafny.Char('a')) <= (ch)) && ((ch) <= (_dafny.Char('f'))))
}
func (_static *CompanionStruct_Default___) IsHexString(s _dafny.Sequence) bool {
	return _dafny.Quantifier((s).UniqueElements(), true, func(_forall_var_0 _dafny.Char) bool {
		var _0_ch _dafny.Char
		_0_ch = interface{}(_forall_var_0).(_dafny.Char)
		return !(_dafny.Companion_Sequence_.Contains(s, _0_ch)) || (Companion_Default___.IsHexChar(_0_ch))
	})
}
func (_static *CompanionStruct_Default___) IsLooseHexString(s _dafny.Sequence) bool {
	return _dafny.Quantifier((s).UniqueElements(), true, func(_forall_var_0 _dafny.Char) bool {
		var _0_ch _dafny.Char
		_0_ch = interface{}(_forall_var_0).(_dafny.Char)
		return !(_dafny.Companion_Sequence_.Contains(s, _0_ch)) || (Companion_Default___.IsLooseHexChar(_0_ch))
	})
}
func (_static *CompanionStruct_Default___) HexVal(ch _dafny.Char) uint8 {
	if ((_dafny.Char('0')) <= (ch)) && ((ch) <= (_dafny.Char('9'))) {
		return (uint8(ch)) - (func() uint8 { return (uint8(_dafny.Char('0'))) })()
	} else if ((_dafny.Char('a')) <= (ch)) && ((ch) <= (_dafny.Char('f'))) {
		return ((uint8(ch)) - (func() uint8 { return (uint8(_dafny.Char('a'))) })()) + (uint8(10))
	} else {
		return ((uint8(ch)) - (func() uint8 { return (uint8(_dafny.Char('A'))) })()) + (uint8(10))
	}
}
func (_static *CompanionStruct_Default___) HexStr(x uint8) _dafny.Sequence {
	if (x) < (uint8(16)) {
		var _0_res _dafny.Sequence = _dafny.SeqOfChars(_dafny.Char('0'), Companion_Default___.HexChar(x))
		_ = _0_res
		return _0_res
	} else {
		var _1_res _dafny.Sequence = _dafny.SeqOfChars(Companion_Default___.HexChar((x)/(uint8(16))), Companion_Default___.HexChar((x)%(uint8(16))))
		_ = _1_res
		return _1_res
	}
}
func (_static *CompanionStruct_Default___) HexValue(x _dafny.Sequence) uint8 {
	return ((Companion_Default___.HexVal((x).Select(0).(_dafny.Char))) * (uint8(16))) + (Companion_Default___.HexVal((x).Select(1).(_dafny.Char)))
}
func (_static *CompanionStruct_Default___) ToHexString(val _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOfChars()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((val).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOfChars())
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, Companion_Default___.HexStr((val).Select(0).(uint8)))
		var _in0 _dafny.Sequence = (val).Drop(1)
		_ = _in0
		val = _in0
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) FromHexString(data _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((data).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf())
	} else if ((_dafny.IntOfUint32((data).Cardinality())).Modulo(_dafny.IntOfInt64(2))).Cmp(_dafny.One) == 0 {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf(Companion_Default___.HexVal((data).Select(0).(_dafny.Char))))
		var _in0 _dafny.Sequence = (data).Drop(1)
		_ = _in0
		data = _in0
		goto TAIL_CALL_START
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf(Companion_Default___.HexValue((data).Take(2))))
		var _in1 _dafny.Sequence = (data).Drop(2)
		_ = _in1
		data = _in1
		goto TAIL_CALL_START
	}
}

// End of class Default__

// Definition of class HexString
type HexString struct {
}

func New_HexString_() *HexString {
	_this := HexString{}

	return &_this
}

type CompanionStruct_HexString_ struct {
}

var Companion_HexString_ = CompanionStruct_HexString_{}

func (*HexString) String() string {
	return "HexStrings.HexString"
}

// End of class HexString

func Type_HexString_() _dafny.TypeDescriptor {
	return type_HexString_{}
}

type type_HexString_ struct {
}

func (_this type_HexString_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_HexString_) String() string {
	return "HexStrings.HexString"
}
func (_this *CompanionStruct_HexString_) Is_(__source _dafny.Sequence) bool {
	var _0_x _dafny.Sequence = (__source)
	_ = _0_x
	return Companion_Default___.IsHexString(_0_x)
}

// Definition of class LooseHexString
type LooseHexString struct {
}

func New_LooseHexString_() *LooseHexString {
	_this := LooseHexString{}

	return &_this
}

type CompanionStruct_LooseHexString_ struct {
}

var Companion_LooseHexString_ = CompanionStruct_LooseHexString_{}

func (*LooseHexString) String() string {
	return "HexStrings.LooseHexString"
}

// End of class LooseHexString

func Type_LooseHexString_() _dafny.TypeDescriptor {
	return type_LooseHexString_{}
}

type type_LooseHexString_ struct {
}

func (_this type_LooseHexString_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_LooseHexString_) String() string {
	return "HexStrings.LooseHexString"
}
func (_this *CompanionStruct_LooseHexString_) Is_(__source _dafny.Sequence) bool {
	var _1_x _dafny.Sequence = (__source)
	_ = _1_x
	return Companion_Default___.IsLooseHexString(_1_x)
}
