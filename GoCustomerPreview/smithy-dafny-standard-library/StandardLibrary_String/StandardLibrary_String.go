// Package StandardLibrary_String
// Dafny module StandardLibrary_String compiled into Go

package StandardLibrary_String

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
	m_StandardLibraryInterop "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibraryInterop"
	m_StandardLibrary_MemoryMath "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_MemoryMath"
	m_StandardLibrary_Sequence "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_Sequence"
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
	return "StandardLibrary_String.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) Int2Digits(n _dafny.Int, base _dafny.Int) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (n).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf(), _0___accumulator)
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf((n).Modulo(base)), _0___accumulator)
		var _in0 _dafny.Int = (n).DivBy(base)
		_ = _in0
		var _in1 _dafny.Int = base
		_ = _in1
		n = _in0
		base = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) Digits2String(digits _dafny.Sequence, chars _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOfChars()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if _dafny.Companion_Sequence_.Equal(digits, _dafny.SeqOf()) {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOfString(""))
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOfChars((chars).Select(((digits).Select(0).(_dafny.Int)).Uint32()).(_dafny.Char)))
		var _in0 _dafny.Sequence = (digits).Drop(1)
		_ = _in0
		var _in1 _dafny.Sequence = chars
		_ = _in1
		digits = _in0
		chars = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) Int2String(n _dafny.Int, chars _dafny.Sequence) _dafny.Sequence {
	var _0_base _dafny.Int = _dafny.IntOfUint32((chars).Cardinality())
	_ = _0_base
	if (n).Sign() == 0 {
		return _dafny.SeqOfString("0")
	} else if (n).Sign() == 1 {
		return Companion_Default___.Digits2String(Companion_Default___.Int2Digits(n, _0_base), chars)
	} else {
		return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("-"), Companion_Default___.Digits2String(Companion_Default___.Int2Digits((_dafny.Zero).Minus(n), _0_base), chars))
	}
}
func (_static *CompanionStruct_Default___) Base10Int2String(n _dafny.Int) _dafny.Sequence {
	return Companion_Default___.Int2String(n, Companion_Default___.Base10())
}
func (_static *CompanionStruct_Default___) HasSubString(haystack _dafny.Sequence, needle _dafny.Sequence) m_Wrappers.Option {
	var o m_Wrappers.Option = m_Wrappers.Companion_Option_.Default()
	_ = o
	if (_dafny.IntOfUint32((haystack).Cardinality())).Cmp(_dafny.IntOfUint32((needle).Cardinality())) < 0 {
		o = m_Wrappers.Companion_Option_.Create_None_()
		return o
	}
	if !((_dafny.IntOfUint32((haystack).Cardinality())).Cmp((m_StandardLibrary_UInt.Companion_Default___.UINT64__MAX__LIMIT()).Minus(_dafny.One)) <= 0) {
		panic("src/String.dfy(75,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _0_size uint64
	_ = _0_size
	_0_size = uint64((needle).Cardinality())
	var _1_limit uint64
	_ = _1_limit
	_1_limit = ((uint64((haystack).Cardinality())) - (func() uint64 { return (_0_size) })()) + (uint64(1))
	var _hi0 uint64 = _1_limit
	_ = _hi0
	for _2_index := uint64(0); _2_index < _hi0; _2_index++ {
		if m_StandardLibrary_Sequence.Companion_Default___.SequenceEqual(haystack, needle, _2_index, uint64(0), _0_size) {
			o = m_Wrappers.Companion_Option_.Create_Some_(_dafny.IntOfUint64(_2_index))
			return o
		}
	}
	o = m_Wrappers.Companion_Option_.Create_None_()
	return o
	return o
}
func (_static *CompanionStruct_Default___) Base10() _dafny.Sequence {
	return _dafny.SeqOfChars(_dafny.Char('0'), _dafny.Char('1'), _dafny.Char('2'), _dafny.Char('3'), _dafny.Char('4'), _dafny.Char('5'), _dafny.Char('6'), _dafny.Char('7'), _dafny.Char('8'), _dafny.Char('9'))
}

// End of class Default__
