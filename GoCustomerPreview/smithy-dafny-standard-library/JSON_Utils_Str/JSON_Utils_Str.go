// Package JSON_Utils_Str
// Dafny module JSON_Utils_Str compiled into Go

package JSON_Utils_Str

import (
	os "os"

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
	m_JSON_Utils_Cursors "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Cursors"
	m_JSON_Utils_Lexers_Core "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Lexers_Core"
	m_JSON_Utils_Lexers_Strings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Lexers_Strings"
	m_JSON_Utils_Parsers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Parsers"
	m_JSON_Utils_Str_CharStrConversion "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Str_CharStrConversion"
	m_JSON_Utils_Str_CharStrEscaping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Str_CharStrEscaping"
	m_JSON_Utils_Views_Core "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Views_Core"
	m_JSON_Utils_Views_Writers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Views_Writers"
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
var _ m_JSON_Utils_Views_Core.Dummy__
var _ m_JSON_Utils_Views_Writers.Dummy__
var _ m_JSON_Utils_Lexers_Core.Dummy__
var _ m_JSON_Utils_Lexers_Strings.Dummy__
var _ m_JSON_Utils_Cursors.Dummy__
var _ m_JSON_Utils_Parsers.Dummy__
var _ m_JSON_Utils_Str_CharStrConversion.Dummy__
var _ m_JSON_Utils_Str_CharStrEscaping.Dummy__

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
	return "JSON_Utils_Str.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) OfNat(n _dafny.Int, base _dafny.Int) _dafny.Sequence {
	return m_JSON_Utils_Str_CharStrConversion.Companion_Default___.OfNat__any(n, (Companion_Default___.HEX__DIGITS()).Take((base).Uint32()))
}
func (_static *CompanionStruct_Default___) OfInt(n _dafny.Int, base _dafny.Int) _dafny.Sequence {
	return m_JSON_Utils_Str_CharStrConversion.Companion_Default___.OfInt__any(n, (Companion_Default___.HEX__DIGITS()).Take((base).Uint32()), _dafny.Char('-'))
}
func (_static *CompanionStruct_Default___) ToNat(str _dafny.Sequence, base _dafny.Int) _dafny.Int {
	return m_JSON_Utils_Str_CharStrConversion.Companion_Default___.ToNat__any(str, base, Companion_Default___.HEX__TABLE())
}
func (_static *CompanionStruct_Default___) ToInt(str _dafny.Sequence, base _dafny.Int) _dafny.Int {
	return m_JSON_Utils_Str_CharStrConversion.Companion_Default___.ToInt__any(str, _dafny.Char('-'), base, Companion_Default___.HEX__TABLE())
}
func (_static *CompanionStruct_Default___) EscapeQuotes(str _dafny.Sequence) _dafny.Sequence {
	return m_JSON_Utils_Str_CharStrEscaping.Companion_Default___.Escape(str, _dafny.SetOf(_dafny.Char('"'), _dafny.Char('\'')), _dafny.Char('\\'))
}
func (_static *CompanionStruct_Default___) UnescapeQuotes(str _dafny.Sequence) m_Wrappers.Result {
	return m_JSON_Utils_Str_CharStrEscaping.Companion_Default___.Unescape(str, _dafny.Char('\\'))
}
func (_static *CompanionStruct_Default___) Test() {
	if !(_dafny.Companion_Sequence_.Equal(Companion_Default___.OfInt(_dafny.Zero, _dafny.IntOfInt64(10)), _dafny.SeqOfString("0"))) {
		panic("/Users/rishavkj/Documents/Storage/Team-Repos/aws-database-encryption-sdk-dynamodb/submodules/MaterialProviders/libraries/src/JSON/Utils/Str.dfy(229,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(Companion_Default___.OfInt(_dafny.IntOfInt64(3), _dafny.IntOfInt64(10)), _dafny.SeqOfString("3"))) {
		panic("/Users/rishavkj/Documents/Storage/Team-Repos/aws-database-encryption-sdk-dynamodb/submodules/MaterialProviders/libraries/src/JSON/Utils/Str.dfy(230,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(Companion_Default___.OfInt(_dafny.IntOfInt64(302), _dafny.IntOfInt64(10)), _dafny.SeqOfString("302"))) {
		panic("/Users/rishavkj/Documents/Storage/Team-Repos/aws-database-encryption-sdk-dynamodb/submodules/MaterialProviders/libraries/src/JSON/Utils/Str.dfy(231,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(Companion_Default___.OfInt(_dafny.IntOfInt64(-3), _dafny.IntOfInt64(10)), _dafny.SeqOfString("-3"))) {
		panic("/Users/rishavkj/Documents/Storage/Team-Repos/aws-database-encryption-sdk-dynamodb/submodules/MaterialProviders/libraries/src/JSON/Utils/Str.dfy(232,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(Companion_Default___.OfInt(_dafny.IntOfInt64(-302), _dafny.IntOfInt64(10)), _dafny.SeqOfString("-302"))) {
		panic("/Users/rishavkj/Documents/Storage/Team-Repos/aws-database-encryption-sdk-dynamodb/submodules/MaterialProviders/libraries/src/JSON/Utils/Str.dfy(233,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) OfBool(b bool) _dafny.Sequence {
	if b {
		return _dafny.SeqOfString("true")
	} else {
		return _dafny.SeqOfString("false")
	}
}
func (_static *CompanionStruct_Default___) OfChar(c _dafny.Char) _dafny.Sequence {
	return _dafny.SeqOfChars(c)
}
func (_static *CompanionStruct_Default___) Join(sep _dafny.Sequence, strs _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOfChars()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((strs).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOfString(""))
	} else if (_dafny.IntOfUint32((strs).Cardinality())).Cmp(_dafny.One) == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, (strs).Select(0).(_dafny.Sequence))
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.Companion_Sequence_.Concatenate((strs).Select(0).(_dafny.Sequence), sep))
		var _in0 _dafny.Sequence = sep
		_ = _in0
		var _in1 _dafny.Sequence = (strs).Drop(1)
		_ = _in1
		sep = _in0
		strs = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) Concat(strs _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOfChars()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((strs).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOfString(""))
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, (strs).Select(0).(_dafny.Sequence))
		var _in0 _dafny.Sequence = (strs).Drop(1)
		_ = _in0
		strs = _in0
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) HEX__DIGITS() _dafny.Sequence {
	return _dafny.SeqOfString("0123456789ABCDEF")
}
func (_static *CompanionStruct_Default___) HEX__TABLE() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.Char('0'), _dafny.Zero).UpdateUnsafe(_dafny.Char('1'), _dafny.One).UpdateUnsafe(_dafny.Char('2'), _dafny.IntOfInt64(2)).UpdateUnsafe(_dafny.Char('3'), _dafny.IntOfInt64(3)).UpdateUnsafe(_dafny.Char('4'), _dafny.IntOfInt64(4)).UpdateUnsafe(_dafny.Char('5'), _dafny.IntOfInt64(5)).UpdateUnsafe(_dafny.Char('6'), _dafny.IntOfInt64(6)).UpdateUnsafe(_dafny.Char('7'), _dafny.IntOfInt64(7)).UpdateUnsafe(_dafny.Char('8'), _dafny.IntOfInt64(8)).UpdateUnsafe(_dafny.Char('9'), _dafny.IntOfInt64(9)).UpdateUnsafe(_dafny.Char('a'), _dafny.IntOfInt64(10)).UpdateUnsafe(_dafny.Char('b'), _dafny.IntOfInt64(11)).UpdateUnsafe(_dafny.Char('c'), _dafny.IntOfInt64(12)).UpdateUnsafe(_dafny.Char('d'), _dafny.IntOfInt64(13)).UpdateUnsafe(_dafny.Char('e'), _dafny.IntOfInt64(14)).UpdateUnsafe(_dafny.Char('f'), _dafny.IntOfInt64(15)).UpdateUnsafe(_dafny.Char('A'), _dafny.IntOfInt64(10)).UpdateUnsafe(_dafny.Char('B'), _dafny.IntOfInt64(11)).UpdateUnsafe(_dafny.Char('C'), _dafny.IntOfInt64(12)).UpdateUnsafe(_dafny.Char('D'), _dafny.IntOfInt64(13)).UpdateUnsafe(_dafny.Char('E'), _dafny.IntOfInt64(14)).UpdateUnsafe(_dafny.Char('F'), _dafny.IntOfInt64(15))
}

// End of class Default__
