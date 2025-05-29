// Package JSON_ZeroCopy_Deserializer_Arrays
// Dafny module JSON_ZeroCopy_Deserializer_Arrays compiled into Go

package JSON_ZeroCopy_Deserializer_Arrays

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
	m_JSON_ConcreteSyntax_Spec "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ConcreteSyntax_Spec"
	m_JSON_ConcreteSyntax_SpecProperties "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ConcreteSyntax_SpecProperties"
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
	m_JSON_ZeroCopy_Deserializer_ArrayParams "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Deserializer_ArrayParams"
	m_JSON_ZeroCopy_Deserializer_Core "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Deserializer_Core"
	m_JSON_ZeroCopy_Deserializer_Numbers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Deserializer_Numbers"
	m_JSON_ZeroCopy_Deserializer_ObjectParams "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Deserializer_ObjectParams"
	m_JSON_ZeroCopy_Deserializer_Objects "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Deserializer_Objects"
	m_JSON_ZeroCopy_Deserializer_Strings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Deserializer_Strings"
	m_JSON_ZeroCopy_Serializer "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Serializer"
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
var _ m_JSON_ConcreteSyntax_Spec.Dummy__
var _ m_JSON_ConcreteSyntax_SpecProperties.Dummy__
var _ m_JSON_ZeroCopy_Serializer.Dummy__
var _ m_JSON_ZeroCopy_Deserializer_Core.Dummy__
var _ m_JSON_ZeroCopy_Deserializer_Strings.Dummy__
var _ m_JSON_ZeroCopy_Deserializer_Numbers.Dummy__
var _ m_JSON_ZeroCopy_Deserializer_ObjectParams.Dummy__
var _ m_JSON_ZeroCopy_Deserializer_Objects.Dummy__
var _ m_JSON_ZeroCopy_Deserializer_ArrayParams.Dummy__

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
	return "JSON_ZeroCopy_Deserializer_Arrays.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) Array(cs m_JSON_Utils_Cursors.Cursor__, json m_JSON_Utils_Parsers.SubParser__) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.Bracketed(cs, json)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_sp m_JSON_Utils_Cursors.Split = (_0_valueOrError0).Extract().(m_JSON_Utils_Cursors.Split)
		_ = _1_sp
		return m_Wrappers.Companion_Result_.Create_Success_(_1_sp)
	}
}
func (_static *CompanionStruct_Default___) Open(cs m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = (cs).AssertByte(m_JSON_ZeroCopy_Deserializer_ArrayParams.Companion_Default___.OPEN())
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_cs m_JSON_Utils_Cursors.Cursor__ = (_0_valueOrError0).Extract().(m_JSON_Utils_Cursors.Cursor__)
		_ = _1_cs
		return m_Wrappers.Companion_Result_.Create_Success_((_1_cs).Split())
	}
}
func (_static *CompanionStruct_Default___) Close(cs m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = (cs).AssertByte(m_JSON_ZeroCopy_Deserializer_ArrayParams.Companion_Default___.CLOSE())
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_cs m_JSON_Utils_Cursors.Cursor__ = (_0_valueOrError0).Extract().(m_JSON_Utils_Cursors.Cursor__)
		_ = _1_cs
		return m_Wrappers.Companion_Result_.Create_Success_((_1_cs).Split())
	}
}
func (_static *CompanionStruct_Default___) BracketedFromParts(open m_JSON_Utils_Cursors.Split, elems m_JSON_Utils_Cursors.Split, close_ m_JSON_Utils_Cursors.Split) m_JSON_Utils_Cursors.Split {
	var _0_sp m_JSON_Utils_Cursors.Split = m_JSON_Utils_Cursors.Companion_Split_.Create_SP_(m_JSON_Grammar.Companion_Bracketed_.Create_Bracketed_((open).Dtor_t().(m_JSON_Grammar.Structural), (elems).Dtor_t().(_dafny.Sequence), (close_).Dtor_t().(m_JSON_Grammar.Structural)), (close_).Dtor_cs())
	_ = _0_sp
	return _0_sp
}
func (_static *CompanionStruct_Default___) AppendWithSuffix(elems m_JSON_Utils_Cursors.Split, elem m_JSON_Utils_Cursors.Split, sep m_JSON_Utils_Cursors.Split) m_JSON_Utils_Cursors.Split {
	var _0_suffixed m_JSON_Grammar.Suffixed = m_JSON_Grammar.Companion_Suffixed_.Create_Suffixed_((elem).Dtor_t().(m_JSON_Grammar.Value), m_JSON_Grammar.Companion_Maybe_.Create_NonEmpty_((sep).Dtor_t().(m_JSON_Grammar.Structural)))
	_ = _0_suffixed
	var _1_elems_k m_JSON_Utils_Cursors.Split = m_JSON_Utils_Cursors.Companion_Split_.Create_SP_(_dafny.Companion_Sequence_.Concatenate((elems).Dtor_t().(_dafny.Sequence), _dafny.SeqOf(_0_suffixed)), (sep).Dtor_cs())
	_ = _1_elems_k
	return _1_elems_k
}
func (_static *CompanionStruct_Default___) AppendLast(elems m_JSON_Utils_Cursors.Split, elem m_JSON_Utils_Cursors.Split, sep m_JSON_Utils_Cursors.Split) m_JSON_Utils_Cursors.Split {
	var _0_suffixed m_JSON_Grammar.Suffixed = m_JSON_Grammar.Companion_Suffixed_.Create_Suffixed_((elem).Dtor_t().(m_JSON_Grammar.Value), m_JSON_Grammar.Companion_Maybe_.Create_Empty_())
	_ = _0_suffixed
	var _1_elems_k m_JSON_Utils_Cursors.Split = m_JSON_Utils_Cursors.Companion_Split_.Create_SP_(_dafny.Companion_Sequence_.Concatenate((elems).Dtor_t().(_dafny.Sequence), _dafny.SeqOf(_0_suffixed)), (elem).Dtor_cs())
	_ = _1_elems_k
	return _1_elems_k
}
func (_static *CompanionStruct_Default___) Elements(json m_JSON_Utils_Parsers.SubParser__, open m_JSON_Utils_Cursors.Split, elems m_JSON_Utils_Cursors.Split) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	var _0_valueOrError0 m_Wrappers.Result = m_JSON_ZeroCopy_Deserializer_ArrayParams.Companion_Default___.Element((elems).Dtor_cs(), json)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_elem m_JSON_Utils_Cursors.Split = (_0_valueOrError0).Extract().(m_JSON_Utils_Cursors.Split)
		_ = _1_elem
		if ((_1_elem).Dtor_cs()).EOF_q() {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_JSON_Utils_Cursors.Companion_CursorError_.Create_EOF_())
		} else {
			var _2_sep m_JSON_Utils_Cursors.Split = m_JSON_ZeroCopy_Deserializer_Core.Companion_Default___.TryStructural((_1_elem).Dtor_cs())
			_ = _2_sep
			var _3_s0 int16 = (((_2_sep).Dtor_t().(m_JSON_Grammar.Structural)).Dtor_t().(m_JSON_Utils_Views_Core.View__)).Peek()
			_ = _3_s0
			if ((_3_s0) == (int16(Companion_Default___.SEPARATOR()))) && (((((_2_sep).Dtor_t().(m_JSON_Grammar.Structural)).Dtor_t().(m_JSON_Utils_Views_Core.View__)).Length()) == (uint32(1))) {
				var _4_sep m_JSON_Utils_Cursors.Split = _2_sep
				_ = _4_sep
				var _5_elems m_JSON_Utils_Cursors.Split = Companion_Default___.AppendWithSuffix(elems, _1_elem, _4_sep)
				_ = _5_elems
				var _in0 m_JSON_Utils_Parsers.SubParser__ = json
				_ = _in0
				var _in1 m_JSON_Utils_Cursors.Split = open
				_ = _in1
				var _in2 m_JSON_Utils_Cursors.Split = _5_elems
				_ = _in2
				json = _in0
				open = _in1
				elems = _in2
				goto TAIL_CALL_START
			} else if ((_3_s0) == (int16(m_JSON_ZeroCopy_Deserializer_ArrayParams.Companion_Default___.CLOSE()))) && (((((_2_sep).Dtor_t().(m_JSON_Grammar.Structural)).Dtor_t().(m_JSON_Utils_Views_Core.View__)).Length()) == (uint32(1))) {
				var _6_sep m_JSON_Utils_Cursors.Split = _2_sep
				_ = _6_sep
				var _7_elems_k m_JSON_Utils_Cursors.Split = Companion_Default___.AppendLast(elems, _1_elem, _6_sep)
				_ = _7_elems_k
				var _8_bracketed m_JSON_Utils_Cursors.Split = Companion_Default___.BracketedFromParts(open, _7_elems_k, _6_sep)
				_ = _8_bracketed
				return m_Wrappers.Companion_Result_.Create_Success_(_8_bracketed)
			} else {
				var _9_separator uint8 = Companion_Default___.SEPARATOR()
				_ = _9_separator
				var _10_pr m_Wrappers.Result = m_Wrappers.Companion_Result_.Create_Failure_(m_JSON_Utils_Cursors.Companion_CursorError_.Create_ExpectingAnyByte_(_dafny.SeqOf(m_JSON_ZeroCopy_Deserializer_ArrayParams.Companion_Default___.CLOSE(), _9_separator), _3_s0))
				_ = _10_pr
				return _10_pr
			}
		}
	}
}
func (_static *CompanionStruct_Default___) Bracketed(cs m_JSON_Utils_Cursors.Cursor__, json m_JSON_Utils_Parsers.SubParser__) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = m_JSON_ZeroCopy_Deserializer_Core.Companion_Default___.Structural(cs, m_JSON_Utils_Parsers.Companion_Parser___.Create_Parser_(func(coer54 func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result) func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result {
		return func(arg57 m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result {
			return coer54(arg57)
		}
	}(Companion_Default___.Open)))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_open m_JSON_Utils_Cursors.Split = (_0_valueOrError0).Extract().(m_JSON_Utils_Cursors.Split)
		_ = _1_open
		var _2_elems m_JSON_Utils_Cursors.Split = m_JSON_Utils_Cursors.Companion_Split_.Create_SP_(_dafny.SeqOf(), (_1_open).Dtor_cs())
		_ = _2_elems
		if (((_1_open).Dtor_cs()).Peek()) == (int16(m_JSON_ZeroCopy_Deserializer_ArrayParams.Companion_Default___.CLOSE())) {
			var _3_p m_JSON_Utils_Parsers.Parser__ = m_JSON_Utils_Parsers.Companion_Parser___.Create_Parser_(func(coer55 func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result) func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result {
				return func(arg58 m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result {
					return coer55(arg58)
				}
			}(Companion_Default___.Close))
			_ = _3_p
			var _4_valueOrError1 m_Wrappers.Result = m_JSON_ZeroCopy_Deserializer_Core.Companion_Default___.Structural((_1_open).Dtor_cs(), _3_p)
			_ = _4_valueOrError1
			if (_4_valueOrError1).IsFailure() {
				return (_4_valueOrError1).PropagateFailure()
			} else {
				var _5_close m_JSON_Utils_Cursors.Split = (_4_valueOrError1).Extract().(m_JSON_Utils_Cursors.Split)
				_ = _5_close
				return m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.BracketedFromParts(_1_open, _2_elems, _5_close))
			}
		} else {
			return Companion_Default___.Elements(json, _1_open, _2_elems)
		}
	}
}
func (_static *CompanionStruct_Default___) SpecViewOpen() func(m_JSON_Utils_Views_Core.View__) _dafny.Sequence {
	return m_JSON_ZeroCopy_Deserializer_Core.Companion_Default___.SpecView()
}
func (_static *CompanionStruct_Default___) SpecViewClose() func(m_JSON_Utils_Views_Core.View__) _dafny.Sequence {
	return m_JSON_ZeroCopy_Deserializer_Core.Companion_Default___.SpecView()
}
func (_static *CompanionStruct_Default___) SEPARATOR() uint8 {
	return uint8(_dafny.Char(','))
}

// End of class Default__

// Definition of class Jopen
type Jopen struct {
}

func New_Jopen_() *Jopen {
	_this := Jopen{}

	return &_this
}

type CompanionStruct_Jopen_ struct {
}

var Companion_Jopen_ = CompanionStruct_Jopen_{}

func (*Jopen) String() string {
	return "JSON_ZeroCopy_Deserializer_Arrays.Jopen"
}
func (_this *CompanionStruct_Jopen_) Witness() m_JSON_Utils_Views_Core.View__ {
	return m_JSON_Utils_Views_Core.Companion_View___.OfBytes(_dafny.SeqOf(m_JSON_ZeroCopy_Deserializer_ArrayParams.Companion_Default___.OPEN()))
}

// End of class Jopen

func Type_Jopen_() _dafny.TypeDescriptor {
	return type_Jopen_{}
}

type type_Jopen_ struct {
}

func (_this type_Jopen_) Default() interface{} {
	return Companion_Jopen_.Witness()
}

func (_this type_Jopen_) String() string {
	return "JSON_ZeroCopy_Deserializer_Arrays.Jopen"
}

// Definition of class Jclose
type Jclose struct {
}

func New_Jclose_() *Jclose {
	_this := Jclose{}

	return &_this
}

type CompanionStruct_Jclose_ struct {
}

var Companion_Jclose_ = CompanionStruct_Jclose_{}

func (*Jclose) String() string {
	return "JSON_ZeroCopy_Deserializer_Arrays.Jclose"
}
func (_this *CompanionStruct_Jclose_) Witness() m_JSON_Utils_Views_Core.View__ {
	return m_JSON_Utils_Views_Core.Companion_View___.OfBytes(_dafny.SeqOf(m_JSON_ZeroCopy_Deserializer_ArrayParams.Companion_Default___.CLOSE()))
}

// End of class Jclose

func Type_Jclose_() _dafny.TypeDescriptor {
	return type_Jclose_{}
}

type type_Jclose_ struct {
}

func (_this type_Jclose_) Default() interface{} {
	return Companion_Jclose_.Witness()
}

func (_this type_Jclose_) String() string {
	return "JSON_ZeroCopy_Deserializer_Arrays.Jclose"
}
