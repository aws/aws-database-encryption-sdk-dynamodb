// Package JSON_ConcreteSyntax_Spec
// Dafny module JSON_ConcreteSyntax_Spec compiled into Go

package JSON_ConcreteSyntax_Spec

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
	m_JSON_Deserializer "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Deserializer"
	m_JSON_Deserializer_ByteStrConversion "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Deserializer_ByteStrConversion"
	m_JSON_Deserializer_Uint16StrConversion "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Deserializer_Uint16StrConversion"
	m_JSON_Errors "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Errors"
	m_JSON_Grammar "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Grammar"
	m_JSON_Serializer "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Serializer"
	m_JSON_Serializer_ByteStrConversion "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Serializer_ByteStrConversion"
	m_JSON_Spec "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Spec"
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
var _ m_JSON_Spec.Dummy__
var _ m_JSON_Grammar.Dummy__
var _ m_JSON_Serializer_ByteStrConversion.Dummy__
var _ m_JSON_Serializer.Dummy__
var _ m_JSON_Deserializer_Uint16StrConversion.Dummy__
var _ m_JSON_Deserializer_ByteStrConversion.Dummy__
var _ m_JSON_Deserializer.Dummy__

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
	return "JSON_ConcreteSyntax_Spec.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) View(v m_JSON_Utils_Views_Core.View__) _dafny.Sequence {
	return (v).Bytes()
}
func (_static *CompanionStruct_Default___) Structural(self m_JSON_Grammar.Structural, fT func(interface{}) _dafny.Sequence) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(Companion_Default___.View((self).Dtor_before()), (fT)((self).Dtor_t())), Companion_Default___.View((self).Dtor_after()))
}
func (_static *CompanionStruct_Default___) StructuralView(self m_JSON_Grammar.Structural) _dafny.Sequence {
	return Companion_Default___.Structural(self, func(coer40 func(m_JSON_Utils_Views_Core.View__) _dafny.Sequence) func(interface{}) _dafny.Sequence {
		return func(arg43 interface{}) _dafny.Sequence {
			return coer40(arg43.(m_JSON_Utils_Views_Core.View__))
		}
	}(Companion_Default___.View))
}
func (_static *CompanionStruct_Default___) Maybe(self m_JSON_Grammar.Maybe, fT func(interface{}) _dafny.Sequence) _dafny.Sequence {
	if (self).Is_Empty() {
		return _dafny.SeqOf()
	} else {
		return (fT)((self).Dtor_t())
	}
}
func (_static *CompanionStruct_Default___) ConcatBytes(ts _dafny.Sequence, fT func(interface{}) _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((ts).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf())
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, (fT)((ts).Select(0).(interface{})))
		var _in0 _dafny.Sequence = (ts).Drop(1)
		_ = _in0
		var _in1 func(interface{}) _dafny.Sequence = fT
		_ = _in1
		ts = _in0
		fT = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) Bracketed(self m_JSON_Grammar.Bracketed, fDatum func(m_JSON_Grammar.Suffixed) _dafny.Sequence) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(Companion_Default___.StructuralView((self).Dtor_l()), Companion_Default___.ConcatBytes((self).Dtor_data(), func(coer41 func(m_JSON_Grammar.Suffixed) _dafny.Sequence) func(interface{}) _dafny.Sequence {
		return func(arg44 interface{}) _dafny.Sequence {
			return coer41(arg44.(m_JSON_Grammar.Suffixed))
		}
	}(fDatum))), Companion_Default___.StructuralView((self).Dtor_r()))
}
func (_static *CompanionStruct_Default___) KeyValue(self m_JSON_Grammar.JKeyValue) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(Companion_Default___.String((self).Dtor_k()), Companion_Default___.StructuralView((self).Dtor_colon())), Companion_Default___.Value((self).Dtor_v()))
}
func (_static *CompanionStruct_Default___) Frac(self m_JSON_Grammar.Jfrac) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(Companion_Default___.View((self).Dtor_period()), Companion_Default___.View((self).Dtor_num()))
}
func (_static *CompanionStruct_Default___) Exp(self m_JSON_Grammar.Jexp) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(Companion_Default___.View((self).Dtor_e()), Companion_Default___.View((self).Dtor_sign())), Companion_Default___.View((self).Dtor_num()))
}
func (_static *CompanionStruct_Default___) Number(self m_JSON_Grammar.Jnumber) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(Companion_Default___.View((self).Dtor_minus()), Companion_Default___.View((self).Dtor_num())), Companion_Default___.Maybe((self).Dtor_frac(), func(coer42 func(m_JSON_Grammar.Jfrac) _dafny.Sequence) func(interface{}) _dafny.Sequence {
		return func(arg45 interface{}) _dafny.Sequence {
			return coer42(arg45.(m_JSON_Grammar.Jfrac))
		}
	}(Companion_Default___.Frac))), Companion_Default___.Maybe((self).Dtor_exp(), func(coer43 func(m_JSON_Grammar.Jexp) _dafny.Sequence) func(interface{}) _dafny.Sequence {
		return func(arg46 interface{}) _dafny.Sequence {
			return coer43(arg46.(m_JSON_Grammar.Jexp))
		}
	}(Companion_Default___.Exp)))
}
func (_static *CompanionStruct_Default___) String(self m_JSON_Grammar.Jstring) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(Companion_Default___.View((self).Dtor_lq()), Companion_Default___.View((self).Dtor_contents())), Companion_Default___.View((self).Dtor_rq()))
}
func (_static *CompanionStruct_Default___) CommaSuffix(c m_JSON_Grammar.Maybe) _dafny.Sequence {
	return Companion_Default___.Maybe(c, func(coer44 func(m_JSON_Grammar.Structural) _dafny.Sequence) func(interface{}) _dafny.Sequence {
		return func(arg47 interface{}) _dafny.Sequence {
			return coer44(arg47.(m_JSON_Grammar.Structural))
		}
	}(Companion_Default___.StructuralView))
}
func (_static *CompanionStruct_Default___) Member(self m_JSON_Grammar.Suffixed) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(Companion_Default___.KeyValue((self).Dtor_t().(m_JSON_Grammar.JKeyValue)), Companion_Default___.CommaSuffix((self).Dtor_suffix()))
}
func (_static *CompanionStruct_Default___) Item(self m_JSON_Grammar.Suffixed) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(Companion_Default___.Value((self).Dtor_t().(m_JSON_Grammar.Value)), Companion_Default___.CommaSuffix((self).Dtor_suffix()))
}
func (_static *CompanionStruct_Default___) Object(obj m_JSON_Grammar.Bracketed) _dafny.Sequence {
	return Companion_Default___.Bracketed(obj, func(coer45 func(m_JSON_Grammar.Suffixed) _dafny.Sequence) func(m_JSON_Grammar.Suffixed) _dafny.Sequence {
		return func(arg48 m_JSON_Grammar.Suffixed) _dafny.Sequence {
			return coer45(arg48)
		}
	}((func(_0_obj m_JSON_Grammar.Bracketed) func(m_JSON_Grammar.Suffixed) _dafny.Sequence {
		return func(_1_d m_JSON_Grammar.Suffixed) _dafny.Sequence {
			return Companion_Default___.Member(_1_d)
		}
	})(obj)))
}
func (_static *CompanionStruct_Default___) Array(arr m_JSON_Grammar.Bracketed) _dafny.Sequence {
	return Companion_Default___.Bracketed(arr, func(coer46 func(m_JSON_Grammar.Suffixed) _dafny.Sequence) func(m_JSON_Grammar.Suffixed) _dafny.Sequence {
		return func(arg49 m_JSON_Grammar.Suffixed) _dafny.Sequence {
			return coer46(arg49)
		}
	}((func(_0_arr m_JSON_Grammar.Bracketed) func(m_JSON_Grammar.Suffixed) _dafny.Sequence {
		return func(_1_d m_JSON_Grammar.Suffixed) _dafny.Sequence {
			return Companion_Default___.Item(_1_d)
		}
	})(arr)))
}
func (_static *CompanionStruct_Default___) Value(self m_JSON_Grammar.Value) _dafny.Sequence {
	var _source0 m_JSON_Grammar.Value = self
	_ = _source0
	{
		if _source0.Is_Null() {
			var _0_n m_JSON_Utils_Views_Core.View__ = _source0.Get_().(m_JSON_Grammar.Value_Null).N
			_ = _0_n
			return Companion_Default___.View(_0_n)
		}
	}
	{
		if _source0.Is_Bool() {
			var _1_b m_JSON_Utils_Views_Core.View__ = _source0.Get_().(m_JSON_Grammar.Value_Bool).B
			_ = _1_b
			return Companion_Default___.View(_1_b)
		}
	}
	{
		if _source0.Is_String() {
			var _2_str m_JSON_Grammar.Jstring = _source0.Get_().(m_JSON_Grammar.Value_String).Str
			_ = _2_str
			return Companion_Default___.String(_2_str)
		}
	}
	{
		if _source0.Is_Number() {
			var _3_num m_JSON_Grammar.Jnumber = _source0.Get_().(m_JSON_Grammar.Value_Number).Num
			_ = _3_num
			return Companion_Default___.Number(_3_num)
		}
	}
	{
		if _source0.Is_Object() {
			var _4_obj m_JSON_Grammar.Bracketed = _source0.Get_().(m_JSON_Grammar.Value_Object).Obj
			_ = _4_obj
			return Companion_Default___.Object(_4_obj)
		}
	}
	{
		var _5_arr m_JSON_Grammar.Bracketed = _source0.Get_().(m_JSON_Grammar.Value_Array).Arr
		_ = _5_arr
		return Companion_Default___.Array(_5_arr)
	}
}
func (_static *CompanionStruct_Default___) JSON(js m_JSON_Grammar.Structural) _dafny.Sequence {
	return Companion_Default___.Structural(js, func(coer47 func(m_JSON_Grammar.Value) _dafny.Sequence) func(interface{}) _dafny.Sequence {
		return func(arg50 interface{}) _dafny.Sequence {
			return coer47(arg50.(m_JSON_Grammar.Value))
		}
	}(Companion_Default___.Value))
}

// End of class Default__
