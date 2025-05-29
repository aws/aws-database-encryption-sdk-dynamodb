// Package JSON_Errors
// Dafny module JSON_Errors compiled into Go

package JSON_Errors

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
	m_JSON_Utils_Seq "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Seq"
	m_JSON_Utils_Str "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Str"
	m_JSON_Utils_Str_CharStrConversion "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Str_CharStrConversion"
	m_JSON_Utils_Str_CharStrEscaping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Str_CharStrEscaping"
	m_JSON_Utils_Vectors "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Vectors"
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
var _ m_JSON_Utils_Str.Dummy__
var _ m_JSON_Utils_Seq.Dummy__
var _ m_JSON_Utils_Vectors.Dummy__

type Dummy__ struct{}

// Definition of datatype DeserializationError
type DeserializationError struct {
	Data_DeserializationError_
}

func (_this DeserializationError) Get_() Data_DeserializationError_ {
	return _this.Data_DeserializationError_
}

type Data_DeserializationError_ interface {
	isDeserializationError()
}

type CompanionStruct_DeserializationError_ struct {
}

var Companion_DeserializationError_ = CompanionStruct_DeserializationError_{}

type DeserializationError_UnterminatedSequence struct {
}

func (DeserializationError_UnterminatedSequence) isDeserializationError() {}

func (CompanionStruct_DeserializationError_) Create_UnterminatedSequence_() DeserializationError {
	return DeserializationError{DeserializationError_UnterminatedSequence{}}
}

func (_this DeserializationError) Is_UnterminatedSequence() bool {
	_, ok := _this.Get_().(DeserializationError_UnterminatedSequence)
	return ok
}

type DeserializationError_UnsupportedEscape struct {
	Str _dafny.Sequence
}

func (DeserializationError_UnsupportedEscape) isDeserializationError() {}

func (CompanionStruct_DeserializationError_) Create_UnsupportedEscape_(Str _dafny.Sequence) DeserializationError {
	return DeserializationError{DeserializationError_UnsupportedEscape{Str}}
}

func (_this DeserializationError) Is_UnsupportedEscape() bool {
	_, ok := _this.Get_().(DeserializationError_UnsupportedEscape)
	return ok
}

type DeserializationError_EscapeAtEOS struct {
}

func (DeserializationError_EscapeAtEOS) isDeserializationError() {}

func (CompanionStruct_DeserializationError_) Create_EscapeAtEOS_() DeserializationError {
	return DeserializationError{DeserializationError_EscapeAtEOS{}}
}

func (_this DeserializationError) Is_EscapeAtEOS() bool {
	_, ok := _this.Get_().(DeserializationError_EscapeAtEOS)
	return ok
}

type DeserializationError_EmptyNumber struct {
}

func (DeserializationError_EmptyNumber) isDeserializationError() {}

func (CompanionStruct_DeserializationError_) Create_EmptyNumber_() DeserializationError {
	return DeserializationError{DeserializationError_EmptyNumber{}}
}

func (_this DeserializationError) Is_EmptyNumber() bool {
	_, ok := _this.Get_().(DeserializationError_EmptyNumber)
	return ok
}

type DeserializationError_ExpectingEOF struct {
}

func (DeserializationError_ExpectingEOF) isDeserializationError() {}

func (CompanionStruct_DeserializationError_) Create_ExpectingEOF_() DeserializationError {
	return DeserializationError{DeserializationError_ExpectingEOF{}}
}

func (_this DeserializationError) Is_ExpectingEOF() bool {
	_, ok := _this.Get_().(DeserializationError_ExpectingEOF)
	return ok
}

type DeserializationError_IntOverflow struct {
}

func (DeserializationError_IntOverflow) isDeserializationError() {}

func (CompanionStruct_DeserializationError_) Create_IntOverflow_() DeserializationError {
	return DeserializationError{DeserializationError_IntOverflow{}}
}

func (_this DeserializationError) Is_IntOverflow() bool {
	_, ok := _this.Get_().(DeserializationError_IntOverflow)
	return ok
}

type DeserializationError_ReachedEOF struct {
}

func (DeserializationError_ReachedEOF) isDeserializationError() {}

func (CompanionStruct_DeserializationError_) Create_ReachedEOF_() DeserializationError {
	return DeserializationError{DeserializationError_ReachedEOF{}}
}

func (_this DeserializationError) Is_ReachedEOF() bool {
	_, ok := _this.Get_().(DeserializationError_ReachedEOF)
	return ok
}

type DeserializationError_ExpectingByte struct {
	Expected uint8
	B        int16
}

func (DeserializationError_ExpectingByte) isDeserializationError() {}

func (CompanionStruct_DeserializationError_) Create_ExpectingByte_(Expected uint8, B int16) DeserializationError {
	return DeserializationError{DeserializationError_ExpectingByte{Expected, B}}
}

func (_this DeserializationError) Is_ExpectingByte() bool {
	_, ok := _this.Get_().(DeserializationError_ExpectingByte)
	return ok
}

type DeserializationError_ExpectingAnyByte struct {
	Expected__sq _dafny.Sequence
	B            int16
}

func (DeserializationError_ExpectingAnyByte) isDeserializationError() {}

func (CompanionStruct_DeserializationError_) Create_ExpectingAnyByte_(Expected__sq _dafny.Sequence, B int16) DeserializationError {
	return DeserializationError{DeserializationError_ExpectingAnyByte{Expected__sq, B}}
}

func (_this DeserializationError) Is_ExpectingAnyByte() bool {
	_, ok := _this.Get_().(DeserializationError_ExpectingAnyByte)
	return ok
}

type DeserializationError_InvalidUnicode struct {
}

func (DeserializationError_InvalidUnicode) isDeserializationError() {}

func (CompanionStruct_DeserializationError_) Create_InvalidUnicode_() DeserializationError {
	return DeserializationError{DeserializationError_InvalidUnicode{}}
}

func (_this DeserializationError) Is_InvalidUnicode() bool {
	_, ok := _this.Get_().(DeserializationError_InvalidUnicode)
	return ok
}

func (CompanionStruct_DeserializationError_) Default() DeserializationError {
	return Companion_DeserializationError_.Create_UnterminatedSequence_()
}

func (_this DeserializationError) Dtor_str() _dafny.Sequence {
	return _this.Get_().(DeserializationError_UnsupportedEscape).Str
}

func (_this DeserializationError) Dtor_expected() uint8 {
	return _this.Get_().(DeserializationError_ExpectingByte).Expected
}

func (_this DeserializationError) Dtor_b() int16 {
	switch data := _this.Get_().(type) {
	case DeserializationError_ExpectingByte:
		return data.B
	default:
		return data.(DeserializationError_ExpectingAnyByte).B
	}
}

func (_this DeserializationError) Dtor_expected__sq() _dafny.Sequence {
	return _this.Get_().(DeserializationError_ExpectingAnyByte).Expected__sq
}

func (_this DeserializationError) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DeserializationError_UnterminatedSequence:
		{
			return "Errors.DeserializationError.UnterminatedSequence"
		}
	case DeserializationError_UnsupportedEscape:
		{
			return "Errors.DeserializationError.UnsupportedEscape" + "(" + _dafny.String(data.Str) + ")"
		}
	case DeserializationError_EscapeAtEOS:
		{
			return "Errors.DeserializationError.EscapeAtEOS"
		}
	case DeserializationError_EmptyNumber:
		{
			return "Errors.DeserializationError.EmptyNumber"
		}
	case DeserializationError_ExpectingEOF:
		{
			return "Errors.DeserializationError.ExpectingEOF"
		}
	case DeserializationError_IntOverflow:
		{
			return "Errors.DeserializationError.IntOverflow"
		}
	case DeserializationError_ReachedEOF:
		{
			return "Errors.DeserializationError.ReachedEOF"
		}
	case DeserializationError_ExpectingByte:
		{
			return "Errors.DeserializationError.ExpectingByte" + "(" + _dafny.String(data.Expected) + ", " + _dafny.String(data.B) + ")"
		}
	case DeserializationError_ExpectingAnyByte:
		{
			return "Errors.DeserializationError.ExpectingAnyByte" + "(" + _dafny.String(data.Expected__sq) + ", " + _dafny.String(data.B) + ")"
		}
	case DeserializationError_InvalidUnicode:
		{
			return "Errors.DeserializationError.InvalidUnicode"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DeserializationError) Equals(other DeserializationError) bool {
	switch data1 := _this.Get_().(type) {
	case DeserializationError_UnterminatedSequence:
		{
			_, ok := other.Get_().(DeserializationError_UnterminatedSequence)
			return ok
		}
	case DeserializationError_UnsupportedEscape:
		{
			data2, ok := other.Get_().(DeserializationError_UnsupportedEscape)
			return ok && data1.Str.Equals(data2.Str)
		}
	case DeserializationError_EscapeAtEOS:
		{
			_, ok := other.Get_().(DeserializationError_EscapeAtEOS)
			return ok
		}
	case DeserializationError_EmptyNumber:
		{
			_, ok := other.Get_().(DeserializationError_EmptyNumber)
			return ok
		}
	case DeserializationError_ExpectingEOF:
		{
			_, ok := other.Get_().(DeserializationError_ExpectingEOF)
			return ok
		}
	case DeserializationError_IntOverflow:
		{
			_, ok := other.Get_().(DeserializationError_IntOverflow)
			return ok
		}
	case DeserializationError_ReachedEOF:
		{
			_, ok := other.Get_().(DeserializationError_ReachedEOF)
			return ok
		}
	case DeserializationError_ExpectingByte:
		{
			data2, ok := other.Get_().(DeserializationError_ExpectingByte)
			return ok && data1.Expected == data2.Expected && data1.B == data2.B
		}
	case DeserializationError_ExpectingAnyByte:
		{
			data2, ok := other.Get_().(DeserializationError_ExpectingAnyByte)
			return ok && data1.Expected__sq.Equals(data2.Expected__sq) && data1.B == data2.B
		}
	case DeserializationError_InvalidUnicode:
		{
			_, ok := other.Get_().(DeserializationError_InvalidUnicode)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DeserializationError) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DeserializationError)
	return ok && _this.Equals(typed)
}

func Type_DeserializationError_() _dafny.TypeDescriptor {
	return type_DeserializationError_{}
}

type type_DeserializationError_ struct {
}

func (_this type_DeserializationError_) Default() interface{} {
	return Companion_DeserializationError_.Default()
}

func (_this type_DeserializationError_) String() string {
	return "JSON_Errors.DeserializationError"
}
func (_this DeserializationError) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DeserializationError{}

func (_this DeserializationError) ToString() _dafny.Sequence {
	{
		var _source0 DeserializationError = _this
		_ = _source0
		{
			if _source0.Is_UnterminatedSequence() {
				return _dafny.SeqOfString("Unterminated sequence")
			}
		}
		{
			if _source0.Is_UnsupportedEscape() {
				var _0_str _dafny.Sequence = _source0.Get_().(DeserializationError_UnsupportedEscape).Str
				_ = _0_str
				return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unsupported escape sequence: "), _0_str)
			}
		}
		{
			if _source0.Is_EscapeAtEOS() {
				return _dafny.SeqOfString("Escape character at end of string")
			}
		}
		{
			if _source0.Is_EmptyNumber() {
				return _dafny.SeqOfString("Number must contain at least one digit")
			}
		}
		{
			if _source0.Is_ExpectingEOF() {
				return _dafny.SeqOfString("Expecting EOF")
			}
		}
		{
			if _source0.Is_IntOverflow() {
				return _dafny.SeqOfString("Input length does not fit in a 32-bit counter")
			}
		}
		{
			if _source0.Is_ReachedEOF() {
				return _dafny.SeqOfString("Reached EOF")
			}
		}
		{
			if _source0.Is_ExpectingByte() {
				var _1_b0 uint8 = _source0.Get_().(DeserializationError_ExpectingByte).Expected
				_ = _1_b0
				var _2_b int16 = _source0.Get_().(DeserializationError_ExpectingByte).B
				_ = _2_b
				var _3_c _dafny.Sequence = (func() _dafny.Sequence {
					if (_2_b) > (int16(0)) {
						return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("'"), _dafny.SeqOfChars(_dafny.Char((_2_b)))), _dafny.SeqOfString("'"))
					}
					return _dafny.SeqOfString("EOF")
				})()
				_ = _3_c
				return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Expecting '"), _dafny.SeqOfChars(_dafny.Char((_1_b0)))), _dafny.SeqOfString("', read ")), _3_c)
			}
		}
		{
			if _source0.Is_ExpectingAnyByte() {
				var _4_bs0 _dafny.Sequence = _source0.Get_().(DeserializationError_ExpectingAnyByte).Expected__sq
				_ = _4_bs0
				var _5_b int16 = _source0.Get_().(DeserializationError_ExpectingAnyByte).B
				_ = _5_b
				var _6_c _dafny.Sequence = (func() _dafny.Sequence {
					if (_5_b) > (int16(0)) {
						return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("'"), _dafny.SeqOfChars(_dafny.Char((_5_b)))), _dafny.SeqOfString("'"))
					}
					return _dafny.SeqOfString("EOF")
				})()
				_ = _6_c
				var _7_c0s _dafny.Sequence = _dafny.SeqCreate((_dafny.IntOfUint32((_4_bs0).Cardinality())).Uint32(), func(coer32 func(_dafny.Int) _dafny.Char) func(_dafny.Int) interface{} {
					return func(arg35 _dafny.Int) interface{} {
						return coer32(arg35)
					}
				}((func(_8_bs0 _dafny.Sequence) func(_dafny.Int) _dafny.Char {
					return func(_9_idx _dafny.Int) _dafny.Char {
						return _dafny.Char(((_8_bs0).Select((_9_idx).Uint32()).(uint8)))
					}
				})(_4_bs0))).SetString()
				_ = _7_c0s
				return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Expecting one of '"), _7_c0s), _dafny.SeqOfString("', read ")), _6_c)
			}
		}
		{
			return _dafny.SeqOfString("Invalid Unicode sequence")
		}
	}
}

// End of datatype DeserializationError

// Definition of datatype SerializationError
type SerializationError struct {
	Data_SerializationError_
}

func (_this SerializationError) Get_() Data_SerializationError_ {
	return _this.Data_SerializationError_
}

type Data_SerializationError_ interface {
	isSerializationError()
}

type CompanionStruct_SerializationError_ struct {
}

var Companion_SerializationError_ = CompanionStruct_SerializationError_{}

type SerializationError_OutOfMemory struct {
}

func (SerializationError_OutOfMemory) isSerializationError() {}

func (CompanionStruct_SerializationError_) Create_OutOfMemory_() SerializationError {
	return SerializationError{SerializationError_OutOfMemory{}}
}

func (_this SerializationError) Is_OutOfMemory() bool {
	_, ok := _this.Get_().(SerializationError_OutOfMemory)
	return ok
}

type SerializationError_IntTooLarge struct {
	I _dafny.Int
}

func (SerializationError_IntTooLarge) isSerializationError() {}

func (CompanionStruct_SerializationError_) Create_IntTooLarge_(I _dafny.Int) SerializationError {
	return SerializationError{SerializationError_IntTooLarge{I}}
}

func (_this SerializationError) Is_IntTooLarge() bool {
	_, ok := _this.Get_().(SerializationError_IntTooLarge)
	return ok
}

type SerializationError_StringTooLong struct {
	S _dafny.Sequence
}

func (SerializationError_StringTooLong) isSerializationError() {}

func (CompanionStruct_SerializationError_) Create_StringTooLong_(S _dafny.Sequence) SerializationError {
	return SerializationError{SerializationError_StringTooLong{S}}
}

func (_this SerializationError) Is_StringTooLong() bool {
	_, ok := _this.Get_().(SerializationError_StringTooLong)
	return ok
}

type SerializationError_InvalidUnicode struct {
}

func (SerializationError_InvalidUnicode) isSerializationError() {}

func (CompanionStruct_SerializationError_) Create_InvalidUnicode_() SerializationError {
	return SerializationError{SerializationError_InvalidUnicode{}}
}

func (_this SerializationError) Is_InvalidUnicode() bool {
	_, ok := _this.Get_().(SerializationError_InvalidUnicode)
	return ok
}

func (CompanionStruct_SerializationError_) Default() SerializationError {
	return Companion_SerializationError_.Create_OutOfMemory_()
}

func (_this SerializationError) Dtor_i() _dafny.Int {
	return _this.Get_().(SerializationError_IntTooLarge).I
}

func (_this SerializationError) Dtor_s() _dafny.Sequence {
	return _this.Get_().(SerializationError_StringTooLong).S
}

func (_this SerializationError) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case SerializationError_OutOfMemory:
		{
			return "Errors.SerializationError.OutOfMemory"
		}
	case SerializationError_IntTooLarge:
		{
			return "Errors.SerializationError.IntTooLarge" + "(" + _dafny.String(data.I) + ")"
		}
	case SerializationError_StringTooLong:
		{
			return "Errors.SerializationError.StringTooLong" + "(" + _dafny.String(data.S) + ")"
		}
	case SerializationError_InvalidUnicode:
		{
			return "Errors.SerializationError.InvalidUnicode"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this SerializationError) Equals(other SerializationError) bool {
	switch data1 := _this.Get_().(type) {
	case SerializationError_OutOfMemory:
		{
			_, ok := other.Get_().(SerializationError_OutOfMemory)
			return ok
		}
	case SerializationError_IntTooLarge:
		{
			data2, ok := other.Get_().(SerializationError_IntTooLarge)
			return ok && data1.I.Cmp(data2.I) == 0
		}
	case SerializationError_StringTooLong:
		{
			data2, ok := other.Get_().(SerializationError_StringTooLong)
			return ok && data1.S.Equals(data2.S)
		}
	case SerializationError_InvalidUnicode:
		{
			_, ok := other.Get_().(SerializationError_InvalidUnicode)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this SerializationError) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(SerializationError)
	return ok && _this.Equals(typed)
}

func Type_SerializationError_() _dafny.TypeDescriptor {
	return type_SerializationError_{}
}

type type_SerializationError_ struct {
}

func (_this type_SerializationError_) Default() interface{} {
	return Companion_SerializationError_.Default()
}

func (_this type_SerializationError_) String() string {
	return "JSON_Errors.SerializationError"
}
func (_this SerializationError) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = SerializationError{}

func (_this SerializationError) ToString() _dafny.Sequence {
	{
		var _source0 SerializationError = _this
		_ = _source0
		{
			if _source0.Is_OutOfMemory() {
				return _dafny.SeqOfString("Out of memory")
			}
		}
		{
			if _source0.Is_IntTooLarge() {
				var _0_i _dafny.Int = _source0.Get_().(SerializationError_IntTooLarge).I
				_ = _0_i
				return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Integer too large: "), m_JSON_Utils_Str.Companion_Default___.OfInt(_0_i, _dafny.IntOfInt64(10)))
			}
		}
		{
			if _source0.Is_StringTooLong() {
				var _1_s _dafny.Sequence = _source0.Get_().(SerializationError_StringTooLong).S
				_ = _1_s
				return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("String too long: "), _1_s)
			}
		}
		{
			return _dafny.SeqOfString("Invalid Unicode sequence")
		}
	}
}

// End of datatype SerializationError
