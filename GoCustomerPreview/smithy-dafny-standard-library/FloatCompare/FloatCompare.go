// Package FloatCompare
// Dafny module FloatCompare compiled into Go

package FloatCompare

import (
	os "os"

	m_BoundedInts "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/BoundedInts"
	m_DivInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivInternals"
	m_DivInternalsNonlinear "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivInternalsNonlinear"
	m_DivMod "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivMod"
	m_FileIO "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/FileIO"
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
	return "FloatCompare.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) StrToIntInner(s _dafny.Sequence, acc _dafny.Int) _dafny.Int {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((s).Cardinality())).Sign() == 0 {
		return acc
	} else if ((_dafny.Char('0')) <= ((s).Select(0).(_dafny.Char))) && (((s).Select(0).(_dafny.Char)) <= (_dafny.Char('9'))) {
		var _in0 _dafny.Sequence = (s).Drop(1)
		_ = _in0
		var _in1 _dafny.Int = (((acc).Times(_dafny.IntOfInt64(10))).Plus(_dafny.IntOfInt32(rune((s).Select(0).(_dafny.Char))))).Minus(_dafny.IntOfInt32(rune(_dafny.Char('0'))))
		_ = _in1
		s = _in0
		acc = _in1
		goto TAIL_CALL_START
	} else {
		var _in2 _dafny.Sequence = (s).Drop(1)
		_ = _in2
		var _in3 _dafny.Int = acc
		_ = _in3
		s = _in2
		acc = _in3
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) SkipLeadingSpace(val _dafny.Sequence) _dafny.Sequence {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if ((_dafny.IntOfUint32((val).Cardinality())).Sign() == 1) && (((val).Select(0).(_dafny.Char)) <= (_dafny.Char(' '))) {
		var _in0 _dafny.Sequence = (val).Drop(1)
		_ = _in0
		val = _in0
		goto TAIL_CALL_START
	} else {
		return val
	}
}
func (_static *CompanionStruct_Default___) StrToInt(s _dafny.Sequence, acc _dafny.Int) _dafny.Int {
	var _0_tmp _dafny.Sequence = Companion_Default___.SkipLeadingSpace(s)
	_ = _0_tmp
	if (_dafny.IntOfUint32((_0_tmp).Cardinality())).Sign() == 0 {
		return _dafny.Zero
	} else if ((_0_tmp).Select(0).(_dafny.Char)) == (_dafny.Char('-')) {
		return (_dafny.Zero).Minus(Companion_Default___.StrToIntInner(s, _dafny.Zero))
	} else {
		return Companion_Default___.StrToIntInner(s, _dafny.Zero)
	}
}
func (_static *CompanionStruct_Default___) SplitE(x _dafny.Sequence) m_Wrappers.Option {
	var _0_parts m_Wrappers.Option = m_StandardLibrary.Companion_Default___.SplitOnce_q(x, _dafny.Char('e'))
	_ = _0_parts
	if (_0_parts).Is_Some() {
		return _0_parts
	} else {
		return m_StandardLibrary.Companion_Default___.SplitOnce_q(x, _dafny.Char('E'))
	}
}
func (_static *CompanionStruct_Default___) SplitExp(x _dafny.Sequence) _dafny.Tuple {
	var _0_parts m_Wrappers.Option = Companion_Default___.SplitE(x)
	_ = _0_parts
	if (_0_parts).Is_Some() {
		return _dafny.TupleOf((*((_0_parts).Dtor_value().(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence), Companion_Default___.StrToInt((*((_0_parts).Dtor_value().(_dafny.Tuple)).IndexInt(1)).(_dafny.Sequence), _dafny.Zero))
	} else {
		return _dafny.TupleOf(x, _dafny.Zero)
	}
}
func (_static *CompanionStruct_Default___) SkipLeadingZeros(val _dafny.Sequence) _dafny.Sequence {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if ((_dafny.IntOfUint32((val).Cardinality())).Sign() == 1) && (((val).Select(0).(_dafny.Char)) == (_dafny.Char('0'))) {
		var _in0 _dafny.Sequence = (val).Drop(1)
		_ = _in0
		val = _in0
		goto TAIL_CALL_START
	} else {
		return val
	}
}
func (_static *CompanionStruct_Default___) SkipTrailingZeros(val _dafny.Sequence) _dafny.Sequence {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if ((_dafny.IntOfUint32((val).Cardinality())).Sign() == 1) && (((val).Select(((_dafny.IntOfUint32((val).Cardinality())).Minus(_dafny.One)).Uint32()).(_dafny.Char)) == (_dafny.Char('0'))) {
		var _in0 _dafny.Sequence = (val).Take(((_dafny.IntOfUint32((val).Cardinality())).Minus(_dafny.One)).Uint32())
		_ = _in0
		val = _in0
		goto TAIL_CALL_START
	} else {
		return val
	}
}
func (_static *CompanionStruct_Default___) SplitDot(x _dafny.Sequence) _dafny.Tuple {
	var _0_parts m_Wrappers.Option = m_StandardLibrary.Companion_Default___.SplitOnce_q(x, _dafny.Char('.'))
	_ = _0_parts
	if (_0_parts).Is_Some() {
		return _dafny.TupleOf(Companion_Default___.SkipLeadingZeros((*((_0_parts).Dtor_value().(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)), Companion_Default___.SkipTrailingZeros((*((_0_parts).Dtor_value().(_dafny.Tuple)).IndexInt(1)).(_dafny.Sequence)))
	} else {
		return _dafny.TupleOf(Companion_Default___.SkipLeadingZeros(x), _dafny.SeqOfString(""))
	}
}
func (_static *CompanionStruct_Default___) StrCmp(x _dafny.Sequence, y _dafny.Sequence) int8 {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if ((_dafny.IntOfUint32((x).Cardinality())).Sign() == 0) && ((_dafny.IntOfUint32((y).Cardinality())).Sign() == 0) {
		return int8(0)
	} else if (_dafny.IntOfUint32((x).Cardinality())).Sign() == 0 {
		return int8(-1)
	} else if (_dafny.IntOfUint32((y).Cardinality())).Sign() == 0 {
		return int8(1)
	} else if ((x).Select(0).(_dafny.Char)) < ((y).Select(0).(_dafny.Char)) {
		return int8(-1)
	} else if ((x).Select(0).(_dafny.Char)) > ((y).Select(0).(_dafny.Char)) {
		return int8(1)
	} else {
		var _in0 _dafny.Sequence = (x).Drop(1)
		_ = _in0
		var _in1 _dafny.Sequence = (y).Drop(1)
		_ = _in1
		x = _in0
		y = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) AppendZeros(x _dafny.Sequence, newLength _dafny.Int) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(x, _dafny.SeqCreate(((newLength).Minus(_dafny.IntOfUint32((x).Cardinality()))).Uint32(), func(coer25 func(_dafny.Int) _dafny.Char) func(_dafny.Int) interface{} {
		return func(arg28 _dafny.Int) interface{} {
			return coer25(arg28)
		}
	}(func(_0_i _dafny.Int) _dafny.Char {
		return _dafny.Char('0')
	})).SetString())
}
func (_static *CompanionStruct_Default___) CompareFloatInner(x _dafny.Sequence, y _dafny.Sequence) int8 {
	var _0_xParts _dafny.Tuple = Companion_Default___.SplitExp(x)
	_ = _0_xParts
	var _1_yParts _dafny.Tuple = Companion_Default___.SplitExp(y)
	_ = _1_yParts
	var _2_xNum _dafny.Tuple = Companion_Default___.SplitDot((*(_0_xParts).IndexInt(0)).(_dafny.Sequence))
	_ = _2_xNum
	var _3_yNum _dafny.Tuple = Companion_Default___.SplitDot((*(_1_yParts).IndexInt(0)).(_dafny.Sequence))
	_ = _3_yNum
	var _4_xDigits _dafny.Sequence = Companion_Default___.SkipLeadingZeros(_dafny.Companion_Sequence_.Concatenate((*(_2_xNum).IndexInt(0)).(_dafny.Sequence), (*(_2_xNum).IndexInt(1)).(_dafny.Sequence)))
	_ = _4_xDigits
	var _5_yDigits _dafny.Sequence = Companion_Default___.SkipLeadingZeros(_dafny.Companion_Sequence_.Concatenate((*(_3_yNum).IndexInt(0)).(_dafny.Sequence), (*(_3_yNum).IndexInt(1)).(_dafny.Sequence)))
	_ = _5_yDigits
	var _6_xExp _dafny.Int = ((*(_0_xParts).IndexInt(1)).(_dafny.Int)).Minus(_dafny.IntOfUint32(((*(_2_xNum).IndexInt(1)).(_dafny.Sequence)).Cardinality()))
	_ = _6_xExp
	var _7_yExp _dafny.Int = ((*(_1_yParts).IndexInt(1)).(_dafny.Int)).Minus(_dafny.IntOfUint32(((*(_3_yNum).IndexInt(1)).(_dafny.Sequence)).Cardinality()))
	_ = _7_yExp
	var _8_logX _dafny.Int = (_6_xExp).Plus(_dafny.IntOfUint32((_4_xDigits).Cardinality()))
	_ = _8_logX
	var _9_logY _dafny.Int = (_7_yExp).Plus(_dafny.IntOfUint32((_5_yDigits).Cardinality()))
	_ = _9_logY
	if (_8_logX).Cmp(_9_logY) > 0 {
		return int8(1)
	} else if (_9_logY).Cmp(_8_logX) > 0 {
		return int8(-1)
	} else if (_dafny.IntOfUint32((_4_xDigits).Cardinality())).Cmp(_dafny.IntOfUint32((_5_yDigits).Cardinality())) < 0 {
		return Companion_Default___.StrCmp(Companion_Default___.AppendZeros(_4_xDigits, _dafny.IntOfUint32((_5_yDigits).Cardinality())), _5_yDigits)
	} else if (_dafny.IntOfUint32((_5_yDigits).Cardinality())).Cmp(_dafny.IntOfUint32((_4_xDigits).Cardinality())) < 0 {
		return Companion_Default___.StrCmp(_4_xDigits, Companion_Default___.AppendZeros(_5_yDigits, _dafny.IntOfUint32((_4_xDigits).Cardinality())))
	} else {
		return Companion_Default___.StrCmp(_4_xDigits, _5_yDigits)
	}
}
func (_static *CompanionStruct_Default___) IsNegative(x _dafny.Sequence) bool {
	return ((_dafny.IntOfUint32((x).Cardinality())).Sign() == 1) && (((x).Select(0).(_dafny.Char)) == (_dafny.Char('-')))
}
func (_static *CompanionStruct_Default___) SkipLeadingPlus(x _dafny.Sequence) _dafny.Sequence {
	if ((_dafny.IntOfUint32((x).Cardinality())).Sign() == 1) && (((x).Select(0).(_dafny.Char)) == (_dafny.Char('+'))) {
		return (x).Drop(1)
	} else {
		return x
	}
}
func (_static *CompanionStruct_Default___) IsZero(x _dafny.Sequence) bool {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((x).Cardinality())).Sign() == 0 {
		return true
	} else if (((x).Select(0).(_dafny.Char)) == (_dafny.Char('0'))) || (((x).Select(0).(_dafny.Char)) == (_dafny.Char('.'))) {
		var _in0 _dafny.Sequence = (x).Drop(1)
		_ = _in0
		x = _in0
		goto TAIL_CALL_START
	} else if ((_dafny.Char('1')) <= ((x).Select(0).(_dafny.Char))) && (((x).Select(0).(_dafny.Char)) <= (_dafny.Char('9'))) {
		return false
	} else {
		return true
	}
}
func (_static *CompanionStruct_Default___) RecognizeZero(x _dafny.Sequence) _dafny.Sequence {
	if Companion_Default___.IsNegative(x) {
		if Companion_Default___.IsZero((x).Drop(1)) {
			return _dafny.SeqOfString("0")
		} else {
			return x
		}
	} else if Companion_Default___.IsZero(x) {
		return _dafny.SeqOfString("0")
	} else {
		return x
	}
}
func (_static *CompanionStruct_Default___) CleanNumber(x _dafny.Sequence) _dafny.Sequence {
	return Companion_Default___.RecognizeZero(Companion_Default___.SkipLeadingPlus(Companion_Default___.SkipLeadingSpace(x)))
}
func (_static *CompanionStruct_Default___) CompareFloat(x _dafny.Sequence, y _dafny.Sequence) int8 {
	var _0_x _dafny.Sequence = Companion_Default___.CleanNumber(x)
	_ = _0_x
	var _1_y _dafny.Sequence = Companion_Default___.CleanNumber(y)
	_ = _1_y
	if (Companion_Default___.IsNegative(_0_x)) && (Companion_Default___.IsNegative(_1_y)) {
		return Companion_Default___.CompareFloatInner((_1_y).Drop(1), (_0_x).Drop(1))
	} else if Companion_Default___.IsNegative(_0_x) {
		return int8(-1)
	} else if Companion_Default___.IsNegative(_1_y) {
		return int8(1)
	} else {
		return Companion_Default___.CompareFloatInner(_0_x, _1_y)
	}
}
func (_static *CompanionStruct_Default___) Less() int8 {
	return int8(-1)
}
func (_static *CompanionStruct_Default___) Equal() int8 {
	return int8(0)
}
func (_static *CompanionStruct_Default___) Greater() int8 {
	return int8(1)
}

// End of class Default__

// Definition of class CompareType
type CompareType struct {
}

func New_CompareType_() *CompareType {
	_this := CompareType{}

	return &_this
}

type CompanionStruct_CompareType_ struct {
}

var Companion_CompareType_ = CompanionStruct_CompareType_{}

func (*CompareType) String() string {
	return "FloatCompare.CompareType"
}
func (_this *CompareType) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &CompareType{}

func (_this *CompanionStruct_CompareType_) IntegerRange(lo _dafny.Int, hi _dafny.Int) _dafny.Iterator {
	iter := _dafny.IntegerRange(lo, hi)
	return func() (interface{}, bool) {
		next, ok := iter()
		if !ok {
			return int8(0), false
		}
		return next.(_dafny.Int).Int8(), true
	}
}

// End of class CompareType

func Type_CompareType_() _dafny.TypeDescriptor {
	return type_CompareType_{}
}

type type_CompareType_ struct {
}

func (_this type_CompareType_) Default() interface{} {
	return int8(0)
}

func (_this type_CompareType_) String() string {
	return "FloatCompare.CompareType"
}
func (_this *CompanionStruct_CompareType_) Is_(__source int8) bool {
	var _0_x _dafny.Int = _dafny.IntOfInt8(__source)
	_ = _0_x
	return ((_dafny.IntOfInt64(-1)).Cmp(_0_x) <= 0) && ((_0_x).Cmp(_dafny.One) <= 0)
}
