// Package JSON_Utils_Str_CharStrEscaping
// Dafny module JSON_Utils_Str_CharStrEscaping compiled into Go

package JSON_Utils_Str_CharStrEscaping

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
	return "JSON_Utils_Str_CharStrEscaping.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) Escape(str _dafny.Sequence, special _dafny.Set, escape _dafny.Char) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOfChars()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if _dafny.Companion_Sequence_.Equal(str, _dafny.SeqOfChars()) {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, str)
	} else if (special).Contains((str).Select(0).(_dafny.Char)) {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOfChars(escape, (str).Select(0).(_dafny.Char)))
		var _in0 _dafny.Sequence = (str).Drop(1)
		_ = _in0
		var _in1 _dafny.Set = special
		_ = _in1
		var _in2 _dafny.Char = escape
		_ = _in2
		str = _in0
		special = _in1
		escape = _in2
		goto TAIL_CALL_START
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOfChars((str).Select(0).(_dafny.Char)))
		var _in3 _dafny.Sequence = (str).Drop(1)
		_ = _in3
		var _in4 _dafny.Set = special
		_ = _in4
		var _in5 _dafny.Char = escape
		_ = _in5
		str = _in3
		special = _in4
		escape = _in5
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) Unescape(str _dafny.Sequence, escape _dafny.Char) m_Wrappers.Result {
	if _dafny.Companion_Sequence_.Equal(str, _dafny.SeqOfChars()) {
		return m_Wrappers.Companion_Result_.Create_Success_(str)
	} else if ((str).Select(0).(_dafny.Char)) == (escape) {
		if (_dafny.IntOfUint32((str).Cardinality())).Cmp(_dafny.One) > 0 {
			var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.Unescape((str).Drop(2), escape)
			_ = _0_valueOrError0
			if (_0_valueOrError0).IsFailure() {
				return (_0_valueOrError0).PropagateFailure()
			} else {
				var _1_tl _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
				_ = _1_tl
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfChars((str).Select(1).(_dafny.Char)), _1_tl))
			}
		} else {
			return m_Wrappers.Companion_Result_.Create_Failure_(Companion_UnescapeError_.Create_EscapeAtEOS_())
		}
	} else {
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.Unescape((str).Drop(1), escape)
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_tl _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
			_ = _3_tl
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfChars((str).Select(0).(_dafny.Char)), _3_tl))
		}
	}
}

// End of class Default__

// Definition of datatype UnescapeError
type UnescapeError struct {
	Data_UnescapeError_
}

func (_this UnescapeError) Get_() Data_UnescapeError_ {
	return _this.Data_UnescapeError_
}

type Data_UnescapeError_ interface {
	isUnescapeError()
}

type CompanionStruct_UnescapeError_ struct {
}

var Companion_UnescapeError_ = CompanionStruct_UnescapeError_{}

type UnescapeError_EscapeAtEOS struct {
}

func (UnescapeError_EscapeAtEOS) isUnescapeError() {}

func (CompanionStruct_UnescapeError_) Create_EscapeAtEOS_() UnescapeError {
	return UnescapeError{UnescapeError_EscapeAtEOS{}}
}

func (_this UnescapeError) Is_EscapeAtEOS() bool {
	_, ok := _this.Get_().(UnescapeError_EscapeAtEOS)
	return ok
}

func (CompanionStruct_UnescapeError_) Default() UnescapeError {
	return Companion_UnescapeError_.Create_EscapeAtEOS_()
}

func (_ CompanionStruct_UnescapeError_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_UnescapeError_.Create_EscapeAtEOS_(), true
		default:
			return UnescapeError{}, false
		}
	}
}

func (_this UnescapeError) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case UnescapeError_EscapeAtEOS:
		{
			return "CharStrEscaping.UnescapeError.EscapeAtEOS"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this UnescapeError) Equals(other UnescapeError) bool {
	switch _this.Get_().(type) {
	case UnescapeError_EscapeAtEOS:
		{
			_, ok := other.Get_().(UnescapeError_EscapeAtEOS)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this UnescapeError) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(UnescapeError)
	return ok && _this.Equals(typed)
}

func Type_UnescapeError_() _dafny.TypeDescriptor {
	return type_UnescapeError_{}
}

type type_UnescapeError_ struct {
}

func (_this type_UnescapeError_) Default() interface{} {
	return Companion_UnescapeError_.Default()
}

func (_this type_UnescapeError_) String() string {
	return "JSON_Utils_Str_CharStrEscaping.UnescapeError"
}
func (_this UnescapeError) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = UnescapeError{}

// End of datatype UnescapeError
