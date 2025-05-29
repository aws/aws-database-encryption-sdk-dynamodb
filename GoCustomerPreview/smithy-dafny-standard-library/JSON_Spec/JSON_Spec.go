// Package JSON_Spec
// Dafny module JSON_Spec compiled into Go

package JSON_Spec

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
	m_JSON_Errors "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Errors"
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
	m_JSON_Values "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Values"
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
var _ m_JSON_Errors.Dummy__
var _ m_JSON_Values.Dummy__

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
	return "JSON_Spec.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) EscapeUnicode(c uint16) _dafny.Sequence {
	var _0_sStr _dafny.Sequence = m_JSON_Utils_Str.Companion_Default___.OfNat(_dafny.IntOfUint16(c), _dafny.IntOfInt64(16))
	_ = _0_sStr
	var _1_s _dafny.Sequence = m_UnicodeStrings.Companion_Default___.ASCIIToUTF16(_0_sStr)
	_ = _1_s
	return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqCreate(((_dafny.IntOfInt64(4)).Minus(_dafny.IntOfUint32((_1_s).Cardinality()))).Uint32(), func(coer33 func(_dafny.Int) uint16) func(_dafny.Int) interface{} {
		return func(arg36 _dafny.Int) interface{} {
			return coer33(arg36)
		}
	}(func(_2___v0 _dafny.Int) uint16 {
		return uint16(_dafny.Char('0'))
	})), _1_s)
}
func (_static *CompanionStruct_Default___) Escape(str _dafny.Sequence, start _dafny.Int) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (start).Cmp(_dafny.IntOfUint32((str).Cardinality())) >= 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf())
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, func() _dafny.Sequence {
			var _source0 uint16 = (str).Select((start).Uint32()).(uint16)
			_ = _source0
			{
				if (_source0) == (uint16(34)) {
					return m_UnicodeStrings.Companion_Default___.ASCIIToUTF16(_dafny.SeqOfString("\\\""))
				}
			}
			{
				if (_source0) == (uint16(92)) {
					return m_UnicodeStrings.Companion_Default___.ASCIIToUTF16(_dafny.SeqOfString("\\\\"))
				}
			}
			{
				if (_source0) == (uint16(8)) {
					return m_UnicodeStrings.Companion_Default___.ASCIIToUTF16(_dafny.SeqOfString("\\b"))
				}
			}
			{
				if (_source0) == (uint16(12)) {
					return m_UnicodeStrings.Companion_Default___.ASCIIToUTF16(_dafny.SeqOfString("\\f"))
				}
			}
			{
				if (_source0) == (uint16(10)) {
					return m_UnicodeStrings.Companion_Default___.ASCIIToUTF16(_dafny.SeqOfString("\\n"))
				}
			}
			{
				if (_source0) == (uint16(13)) {
					return m_UnicodeStrings.Companion_Default___.ASCIIToUTF16(_dafny.SeqOfString("\\r"))
				}
			}
			{
				if (_source0) == (uint16(9)) {
					return m_UnicodeStrings.Companion_Default___.ASCIIToUTF16(_dafny.SeqOfString("\\t"))
				}
			}
			{
				var _1_c uint16 = _source0
				_ = _1_c
				if (_1_c) < (uint16(31)) {
					return _dafny.Companion_Sequence_.Concatenate(m_UnicodeStrings.Companion_Default___.ASCIIToUTF16(_dafny.SeqOfString("\\u")), Companion_Default___.EscapeUnicode(_1_c))
				} else {
					return _dafny.SeqOf((str).Select((start).Uint32()).(uint16))
				}
			}
		}())
		var _in0 _dafny.Sequence = str
		_ = _in0
		var _in1 _dafny.Int = (start).Plus(_dafny.One)
		_ = _in1
		str = _in0
		start = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) EscapeToUTF8(str _dafny.Sequence, start _dafny.Int) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = (m_UnicodeStrings.Companion_Default___.ToUTF16Checked(str)).ToResult_k(m_JSON_Errors.Companion_SerializationError_.Create_InvalidUnicode_())
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_utf16 _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_utf16
		var _2_escaped _dafny.Sequence = Companion_Default___.Escape(_1_utf16, _dafny.Zero)
		_ = _2_escaped
		var _3_valueOrError1 m_Wrappers.Result = (m_UnicodeStrings.Companion_Default___.FromUTF16Checked(_2_escaped)).ToResult_k(m_JSON_Errors.Companion_SerializationError_.Create_InvalidUnicode_())
		_ = _3_valueOrError1
		if (_3_valueOrError1).IsFailure() {
			return (_3_valueOrError1).PropagateFailure()
		} else {
			var _4_utf32 _dafny.Sequence = (_3_valueOrError1).Extract().(_dafny.Sequence)
			_ = _4_utf32
			return (m_UnicodeStrings.Companion_Default___.ToUTF8Checked(_4_utf32)).ToResult_k(m_JSON_Errors.Companion_SerializationError_.Create_InvalidUnicode_())
		}
	}
}
func (_static *CompanionStruct_Default___) String(str _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.EscapeToUTF8(str, _dafny.Zero)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_inBytes _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_inBytes
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(m_UnicodeStrings.Companion_Default___.ASCIIToUTF8(_dafny.SeqOfString("\"")), _1_inBytes), m_UnicodeStrings.Companion_Default___.ASCIIToUTF8(_dafny.SeqOfString("\""))))
	}
}
func (_static *CompanionStruct_Default___) IntToBytes(n _dafny.Int) _dafny.Sequence {
	var _0_s _dafny.Sequence = m_JSON_Utils_Str.Companion_Default___.OfInt(n, _dafny.IntOfInt64(10))
	_ = _0_s
	return m_UnicodeStrings.Companion_Default___.ASCIIToUTF8(_0_s)
}
func (_static *CompanionStruct_Default___) Number(dec m_JSON_Values.Decimal) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(Companion_Default___.IntToBytes((dec).Dtor_n()), (func() _dafny.Sequence {
		if ((dec).Dtor_e10()).Sign() == 0 {
			return _dafny.SeqOf()
		}
		return _dafny.Companion_Sequence_.Concatenate(m_UnicodeStrings.Companion_Default___.ASCIIToUTF8(_dafny.SeqOfString("e")), Companion_Default___.IntToBytes((dec).Dtor_e10()))
	})()))
}
func (_static *CompanionStruct_Default___) KeyValue(kv _dafny.Tuple) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.String((*(kv).IndexInt(0)).(_dafny.Sequence))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_key _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_key
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.JSON((*(kv).IndexInt(1)).(m_JSON_Values.JSON))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_value _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
			_ = _3_value
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_1_key, m_UnicodeStrings.Companion_Default___.ASCIIToUTF8(_dafny.SeqOfString(":"))), _3_value))
		}
	}
}
func (_static *CompanionStruct_Default___) Join(sep _dafny.Sequence, items _dafny.Sequence) m_Wrappers.Result {
	if (_dafny.IntOfUint32((items).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf())
	} else {
		var _0_valueOrError0 m_Wrappers.Result = (items).Select(0).(m_Wrappers.Result)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_first _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _1_first
			if (_dafny.IntOfUint32((items).Cardinality())).Cmp(_dafny.One) == 0 {
				return m_Wrappers.Companion_Result_.Create_Success_(_1_first)
			} else {
				var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.Join(sep, (items).Drop(1))
				_ = _2_valueOrError1
				if (_2_valueOrError1).IsFailure() {
					return (_2_valueOrError1).PropagateFailure()
				} else {
					var _3_rest _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
					_ = _3_rest
					return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_1_first, sep), _3_rest))
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) Object(obj _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.Join(m_UnicodeStrings.Companion_Default___.ASCIIToUTF8(_dafny.SeqOfString(",")), _dafny.SeqCreate((_dafny.IntOfUint32((obj).Cardinality())).Uint32(), func(coer34 func(_dafny.Int) m_Wrappers.Result) func(_dafny.Int) interface{} {
		return func(arg37 _dafny.Int) interface{} {
			return coer34(arg37)
		}
	}((func(_1_obj _dafny.Sequence) func(_dafny.Int) m_Wrappers.Result {
		return func(_2_i _dafny.Int) m_Wrappers.Result {
			return Companion_Default___.KeyValue((_1_obj).Select((_2_i).Uint32()).(_dafny.Tuple))
		}
	})(obj))))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _3_middle _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _3_middle
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(m_UnicodeStrings.Companion_Default___.ASCIIToUTF8(_dafny.SeqOfString("{")), _3_middle), m_UnicodeStrings.Companion_Default___.ASCIIToUTF8(_dafny.SeqOfString("}"))))
	}
}
func (_static *CompanionStruct_Default___) Array(arr _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.Join(m_UnicodeStrings.Companion_Default___.ASCIIToUTF8(_dafny.SeqOfString(",")), _dafny.SeqCreate((_dafny.IntOfUint32((arr).Cardinality())).Uint32(), func(coer35 func(_dafny.Int) m_Wrappers.Result) func(_dafny.Int) interface{} {
		return func(arg38 _dafny.Int) interface{} {
			return coer35(arg38)
		}
	}((func(_1_arr _dafny.Sequence) func(_dafny.Int) m_Wrappers.Result {
		return func(_2_i _dafny.Int) m_Wrappers.Result {
			return Companion_Default___.JSON((_1_arr).Select((_2_i).Uint32()).(m_JSON_Values.JSON))
		}
	})(arr))))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _3_middle _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _3_middle
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(m_UnicodeStrings.Companion_Default___.ASCIIToUTF8(_dafny.SeqOfString("[")), _3_middle), m_UnicodeStrings.Companion_Default___.ASCIIToUTF8(_dafny.SeqOfString("]"))))
	}
}
func (_static *CompanionStruct_Default___) JSON(js m_JSON_Values.JSON) m_Wrappers.Result {
	var _source0 m_JSON_Values.JSON = js
	_ = _source0
	{
		if _source0.Is_Null() {
			return m_Wrappers.Companion_Result_.Create_Success_(m_UnicodeStrings.Companion_Default___.ASCIIToUTF8(_dafny.SeqOfString("null")))
		}
	}
	{
		if _source0.Is_Bool() {
			var _0_b bool = _source0.Get_().(m_JSON_Values.JSON_Bool).B
			_ = _0_b
			return m_Wrappers.Companion_Result_.Create_Success_((func() _dafny.Sequence {
				if _0_b {
					return m_UnicodeStrings.Companion_Default___.ASCIIToUTF8(_dafny.SeqOfString("true"))
				}
				return m_UnicodeStrings.Companion_Default___.ASCIIToUTF8(_dafny.SeqOfString("false"))
			})())
		}
	}
	{
		if _source0.Is_String() {
			var _1_str _dafny.Sequence = _source0.Get_().(m_JSON_Values.JSON_String).Str
			_ = _1_str
			return Companion_Default___.String(_1_str)
		}
	}
	{
		if _source0.Is_Number() {
			var _2_dec m_JSON_Values.Decimal = _source0.Get_().(m_JSON_Values.JSON_Number).Num
			_ = _2_dec
			return Companion_Default___.Number(_2_dec)
		}
	}
	{
		if _source0.Is_Object() {
			var _3_obj _dafny.Sequence = _source0.Get_().(m_JSON_Values.JSON_Object).Obj
			_ = _3_obj
			return Companion_Default___.Object(_3_obj)
		}
	}
	{
		var _4_arr _dafny.Sequence = _source0.Get_().(m_JSON_Values.JSON_Array).Arr
		_ = _4_arr
		return Companion_Default___.Array(_4_arr)
	}
}

// End of class Default__
