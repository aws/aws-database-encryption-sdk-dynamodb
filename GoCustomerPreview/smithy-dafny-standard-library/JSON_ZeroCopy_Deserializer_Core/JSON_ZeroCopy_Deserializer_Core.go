// Package JSON_ZeroCopy_Deserializer_Core
// Dafny module JSON_ZeroCopy_Deserializer_Core compiled into Go

package JSON_ZeroCopy_Deserializer_Core

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
	return "JSON_ZeroCopy_Deserializer_Core.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) Get(cs m_JSON_Utils_Cursors.Cursor__, err m_JSON_Errors.DeserializationError) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = (cs).Get(err)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_cs m_JSON_Utils_Cursors.Cursor__ = (_0_valueOrError0).Extract().(m_JSON_Utils_Cursors.Cursor__)
		_ = _1_cs
		return m_Wrappers.Companion_Result_.Create_Success_((_1_cs).Split())
	}
}
func (_static *CompanionStruct_Default___) WS(cs m_JSON_Utils_Cursors.Cursor__) m_JSON_Utils_Cursors.Split {
	var sp m_JSON_Utils_Cursors.Split = m_JSON_Utils_Cursors.Companion_Split_.Default(m_JSON_Grammar.Companion_Jblanks_.Witness())
	_ = sp
	var _0_point_k uint32
	_ = _0_point_k
	_0_point_k = (cs).Dtor_point()
	var _1_end uint32
	_ = _1_end
	_1_end = (cs).Dtor_end()
	for ((_0_point_k) < (_1_end)) && (m_JSON_Grammar.Companion_Default___.Blank_q(((cs).Dtor_s()).Select(uint32(_0_point_k)).(uint8))) {
		_0_point_k = (_0_point_k) + (uint32(1))
	}
	sp = (m_JSON_Utils_Cursors.Companion_Cursor___.Create_Cursor_((cs).Dtor_s(), (cs).Dtor_beg(), _0_point_k, (cs).Dtor_end())).Split()
	return sp
	return sp
}
func (_static *CompanionStruct_Default___) Structural(cs m_JSON_Utils_Cursors.Cursor__, parser m_JSON_Utils_Parsers.Parser__) m_Wrappers.Result {
	var _let_tmp_rhs0 m_JSON_Utils_Cursors.Split = Companion_Default___.WS(cs)
	_ = _let_tmp_rhs0
	var _0_before m_JSON_Utils_Views_Core.View__ = _let_tmp_rhs0.Get_().(m_JSON_Utils_Cursors.Split_SP).T.(m_JSON_Utils_Views_Core.View__)
	_ = _0_before
	var _1_cs m_JSON_Utils_Cursors.Cursor__ = _let_tmp_rhs0.Get_().(m_JSON_Utils_Cursors.Split_SP).Cs
	_ = _1_cs
	var _2_valueOrError0 m_Wrappers.Result = (func(coer48 func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result) func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result {
		return func(arg51 m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result {
			return coer48(arg51)
		}
	}((parser).Dtor_fn()))(_1_cs)
	_ = _2_valueOrError0
	if (_2_valueOrError0).IsFailure() {
		return (_2_valueOrError0).PropagateFailure()
	} else {
		var _let_tmp_rhs1 m_JSON_Utils_Cursors.Split = (_2_valueOrError0).Extract().(m_JSON_Utils_Cursors.Split)
		_ = _let_tmp_rhs1
		var _3_val interface{} = _let_tmp_rhs1.Get_().(m_JSON_Utils_Cursors.Split_SP).T
		_ = _3_val
		var _4_cs m_JSON_Utils_Cursors.Cursor__ = _let_tmp_rhs1.Get_().(m_JSON_Utils_Cursors.Split_SP).Cs
		_ = _4_cs
		var _let_tmp_rhs2 m_JSON_Utils_Cursors.Split = Companion_Default___.WS(_4_cs)
		_ = _let_tmp_rhs2
		var _5_after m_JSON_Utils_Views_Core.View__ = _let_tmp_rhs2.Get_().(m_JSON_Utils_Cursors.Split_SP).T.(m_JSON_Utils_Views_Core.View__)
		_ = _5_after
		var _6_cs m_JSON_Utils_Cursors.Cursor__ = _let_tmp_rhs2.Get_().(m_JSON_Utils_Cursors.Split_SP).Cs
		_ = _6_cs
		return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Utils_Cursors.Companion_Split_.Create_SP_(m_JSON_Grammar.Companion_Structural_.Create_Structural_(_0_before, _3_val, _5_after), _6_cs))
	}
}
func (_static *CompanionStruct_Default___) TryStructural(cs m_JSON_Utils_Cursors.Cursor__) m_JSON_Utils_Cursors.Split {
	var _let_tmp_rhs0 m_JSON_Utils_Cursors.Split = Companion_Default___.WS(cs)
	_ = _let_tmp_rhs0
	var _0_before m_JSON_Utils_Views_Core.View__ = _let_tmp_rhs0.Get_().(m_JSON_Utils_Cursors.Split_SP).T.(m_JSON_Utils_Views_Core.View__)
	_ = _0_before
	var _1_cs m_JSON_Utils_Cursors.Cursor__ = _let_tmp_rhs0.Get_().(m_JSON_Utils_Cursors.Split_SP).Cs
	_ = _1_cs
	var _let_tmp_rhs1 m_JSON_Utils_Cursors.Split = ((_1_cs).SkipByte()).Split()
	_ = _let_tmp_rhs1
	var _2_val m_JSON_Utils_Views_Core.View__ = _let_tmp_rhs1.Get_().(m_JSON_Utils_Cursors.Split_SP).T.(m_JSON_Utils_Views_Core.View__)
	_ = _2_val
	var _3_cs m_JSON_Utils_Cursors.Cursor__ = _let_tmp_rhs1.Get_().(m_JSON_Utils_Cursors.Split_SP).Cs
	_ = _3_cs
	var _let_tmp_rhs2 m_JSON_Utils_Cursors.Split = Companion_Default___.WS(_3_cs)
	_ = _let_tmp_rhs2
	var _4_after m_JSON_Utils_Views_Core.View__ = _let_tmp_rhs2.Get_().(m_JSON_Utils_Cursors.Split_SP).T.(m_JSON_Utils_Views_Core.View__)
	_ = _4_after
	var _5_cs m_JSON_Utils_Cursors.Cursor__ = _let_tmp_rhs2.Get_().(m_JSON_Utils_Cursors.Split_SP).Cs
	_ = _5_cs
	return m_JSON_Utils_Cursors.Companion_Split_.Create_SP_(m_JSON_Grammar.Companion_Structural_.Create_Structural_(_0_before, _2_val, _4_after), _5_cs)
}
func (_static *CompanionStruct_Default___) SpecView() func(m_JSON_Utils_Views_Core.View__) _dafny.Sequence {
	return func(_0_v m_JSON_Utils_Views_Core.View__) _dafny.Sequence {
		return m_JSON_ConcreteSyntax_Spec.Companion_Default___.View(_0_v)
	}
}

// End of class Default__

// Definition of class Jopt
type Jopt struct {
}

func New_Jopt_() *Jopt {
	_this := Jopt{}

	return &_this
}

type CompanionStruct_Jopt_ struct {
}

var Companion_Jopt_ = CompanionStruct_Jopt_{}

func (*Jopt) String() string {
	return "JSON_ZeroCopy_Deserializer_Core.Jopt"
}
func (_this *CompanionStruct_Jopt_) Witness() m_JSON_Utils_Views_Core.View__ {
	return m_JSON_Utils_Views_Core.Companion_View___.OfBytes(_dafny.SeqOf())
}

// End of class Jopt

func Type_Jopt_() _dafny.TypeDescriptor {
	return type_Jopt_{}
}

type type_Jopt_ struct {
}

func (_this type_Jopt_) Default() interface{} {
	return Companion_Jopt_.Witness()
}

func (_this type_Jopt_) String() string {
	return "JSON_ZeroCopy_Deserializer_Core.Jopt"
}

// Definition of class ValueParser
type ValueParser struct {
}

func New_ValueParser_() *ValueParser {
	_this := ValueParser{}

	return &_this
}

type CompanionStruct_ValueParser_ struct {
}

var Companion_ValueParser_ = CompanionStruct_ValueParser_{}

func (*ValueParser) String() string {
	return "JSON_ZeroCopy_Deserializer_Core.ValueParser"
}

// End of class ValueParser

func Type_ValueParser_() _dafny.TypeDescriptor {
	return type_ValueParser_{}
}

type type_ValueParser_ struct {
}

func (_this type_ValueParser_) Default() interface{} {
	return m_JSON_Utils_Parsers.Companion_SubParser_.Witness()
}

func (_this type_ValueParser_) String() string {
	return "JSON_ZeroCopy_Deserializer_Core.ValueParser"
}
