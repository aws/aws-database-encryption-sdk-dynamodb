// Package JSON_Deserializer
// Dafny module JSON_Deserializer compiled into Go

package JSON_Deserializer

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
	return "JSON_Deserializer.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) Bool(js m_JSON_Utils_Views_Core.View__) bool {
	return ((js).At(uint32(0))) == (uint8(_dafny.Char('t')))
}
func (_static *CompanionStruct_Default___) UnsupportedEscape16(code _dafny.Sequence) m_JSON_Errors.DeserializationError {
	return m_JSON_Errors.Companion_DeserializationError_.Create_UnsupportedEscape_((m_UnicodeStrings.Companion_Default___.FromUTF16Checked(code)).UnwrapOr(_dafny.SeqOfString("Couldn't decode UTF-16")).(_dafny.Sequence))
}
func (_static *CompanionStruct_Default___) ToNat16(str _dafny.Sequence) uint16 {
	var _0_hd _dafny.Int = m_JSON_Deserializer_Uint16StrConversion.Companion_Default___.ToNat__any(str, _dafny.IntOfInt64(16), Companion_Default___.HEX__TABLE__16())
	_ = _0_hd
	return (_0_hd).Uint16()
}
func (_static *CompanionStruct_Default___) Unescape(str _dafny.Sequence, start _dafny.Int, prefix _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (start).Cmp(_dafny.IntOfUint32((str).Cardinality())) >= 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(prefix)
	} else if ((str).Select((start).Uint32()).(uint16)) == (uint16(_dafny.Char('\\'))) {
		if (_dafny.IntOfUint32((str).Cardinality())).Cmp((start).Plus(_dafny.One)) == 0 {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_JSON_Errors.Companion_DeserializationError_.Create_EscapeAtEOS_())
		} else {
			var _0_c uint16 = (str).Select(((start).Plus(_dafny.One)).Uint32()).(uint16)
			_ = _0_c
			if (_0_c) == (uint16(_dafny.Char('u'))) {
				if (_dafny.IntOfUint32((str).Cardinality())).Cmp((start).Plus(_dafny.IntOfInt64(6))) < 0 {
					return m_Wrappers.Companion_Result_.Create_Failure_(m_JSON_Errors.Companion_DeserializationError_.Create_EscapeAtEOS_())
				} else {
					var _1_code _dafny.Sequence = (str).Subsequence(((start).Plus(_dafny.IntOfInt64(2))).Uint32(), ((start).Plus(_dafny.IntOfInt64(6))).Uint32())
					_ = _1_code
					if _dafny.Quantifier((_1_code).UniqueElements(), false, func(_exists_var_0 uint16) bool {
						var _2_c uint16
						_2_c = interface{}(_exists_var_0).(uint16)
						if true {
							return (_dafny.Companion_Sequence_.Contains(_1_code, _2_c)) && (!(Companion_Default___.HEX__TABLE__16()).Contains(_2_c))
						} else {
							return false
						}
					}) {
						return m_Wrappers.Companion_Result_.Create_Failure_(Companion_Default___.UnsupportedEscape16(_1_code))
					} else {
						var _3_hd uint16 = Companion_Default___.ToNat16(_1_code)
						_ = _3_hd
						var _in0 _dafny.Sequence = str
						_ = _in0
						var _in1 _dafny.Int = (start).Plus(_dafny.IntOfInt64(6))
						_ = _in1
						var _in2 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(prefix, _dafny.SeqOf(_3_hd))
						_ = _in2
						str = _in0
						start = _in1
						prefix = _in2
						goto TAIL_CALL_START
					}
				}
			} else {
				var _4_unescaped uint16 = func() uint16 {
					var _source0 uint16 = _0_c
					_ = _source0
					{
						if (_source0) == (uint16(34)) {
							return uint16(34)
						}
					}
					{
						if (_source0) == (uint16(92)) {
							return uint16(92)
						}
					}
					{
						if (_source0) == (uint16(98)) {
							return uint16(8)
						}
					}
					{
						if (_source0) == (uint16(102)) {
							return uint16(12)
						}
					}
					{
						if (_source0) == (uint16(110)) {
							return uint16(10)
						}
					}
					{
						if (_source0) == (uint16(114)) {
							return uint16(13)
						}
					}
					{
						if (_source0) == (uint16(116)) {
							return uint16(9)
						}
					}
					{
						return uint16(0)
					}
				}()
				_ = _4_unescaped
				if (_dafny.IntOfUint16(_4_unescaped)).Sign() == 0 {
					return m_Wrappers.Companion_Result_.Create_Failure_(Companion_Default___.UnsupportedEscape16((str).Subsequence((start).Uint32(), ((start).Plus(_dafny.IntOfInt64(2))).Uint32())))
				} else {
					var _in3 _dafny.Sequence = str
					_ = _in3
					var _in4 _dafny.Int = (start).Plus(_dafny.IntOfInt64(2))
					_ = _in4
					var _in5 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(prefix, _dafny.SeqOf(_4_unescaped))
					_ = _in5
					str = _in3
					start = _in4
					prefix = _in5
					goto TAIL_CALL_START
				}
			}
		}
	} else {
		var _in6 _dafny.Sequence = str
		_ = _in6
		var _in7 _dafny.Int = (start).Plus(_dafny.One)
		_ = _in7
		var _in8 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(prefix, _dafny.SeqOf((str).Select((start).Uint32()).(uint16)))
		_ = _in8
		str = _in6
		start = _in7
		prefix = _in8
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) String(js m_JSON_Grammar.Jstring) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = (m_UnicodeStrings.Companion_Default___.FromUTF8Checked(((js).Dtor_contents()).Bytes())).ToResult_k(m_JSON_Errors.Companion_DeserializationError_.Create_InvalidUnicode_())
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_asUtf32 _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_asUtf32
		var _2_valueOrError1 m_Wrappers.Result = (m_UnicodeStrings.Companion_Default___.ToUTF16Checked(_1_asUtf32)).ToResult_k(m_JSON_Errors.Companion_DeserializationError_.Create_InvalidUnicode_())
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_asUint16 _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
			_ = _3_asUint16
			var _4_valueOrError2 m_Wrappers.Result = Companion_Default___.Unescape(_3_asUint16, _dafny.Zero, _dafny.SeqOf())
			_ = _4_valueOrError2
			if (_4_valueOrError2).IsFailure() {
				return (_4_valueOrError2).PropagateFailure()
			} else {
				var _5_unescaped _dafny.Sequence = (_4_valueOrError2).Extract().(_dafny.Sequence)
				_ = _5_unescaped
				return (m_UnicodeStrings.Companion_Default___.FromUTF16Checked(_5_unescaped)).ToResult_k(m_JSON_Errors.Companion_DeserializationError_.Create_InvalidUnicode_())
			}
		}
	}
}
func (_static *CompanionStruct_Default___) ToInt(sign m_JSON_Utils_Views_Core.View__, n m_JSON_Utils_Views_Core.View__) m_Wrappers.Result {
	var _0_n _dafny.Int = m_JSON_Deserializer_ByteStrConversion.Companion_Default___.ToNat__any((n).Bytes(), _dafny.IntOfInt64(10), Companion_Default___.DIGITS())
	_ = _0_n
	return m_Wrappers.Companion_Result_.Create_Success_((func() _dafny.Int {
		if (sign).Char_q(_dafny.Char('-')) {
			return (_dafny.Zero).Minus(_0_n)
		}
		return _0_n
	})())
}
func (_static *CompanionStruct_Default___) Number(js m_JSON_Grammar.Jnumber) m_Wrappers.Result {
	var _let_tmp_rhs0 m_JSON_Grammar.Jnumber = js
	_ = _let_tmp_rhs0
	var _0_minus m_JSON_Utils_Views_Core.View__ = _let_tmp_rhs0.Get_().(m_JSON_Grammar.Jnumber_JNumber).Minus
	_ = _0_minus
	var _1_num m_JSON_Utils_Views_Core.View__ = _let_tmp_rhs0.Get_().(m_JSON_Grammar.Jnumber_JNumber).Num
	_ = _1_num
	var _2_frac m_JSON_Grammar.Maybe = _let_tmp_rhs0.Get_().(m_JSON_Grammar.Jnumber_JNumber).Frac
	_ = _2_frac
	var _3_exp m_JSON_Grammar.Maybe = _let_tmp_rhs0.Get_().(m_JSON_Grammar.Jnumber_JNumber).Exp
	_ = _3_exp
	var _4_valueOrError0 m_Wrappers.Result = Companion_Default___.ToInt(_0_minus, _1_num)
	_ = _4_valueOrError0
	if (_4_valueOrError0).IsFailure() {
		return (_4_valueOrError0).PropagateFailure()
	} else {
		var _5_n _dafny.Int = (_4_valueOrError0).Extract().(_dafny.Int)
		_ = _5_n
		var _6_valueOrError1 m_Wrappers.Result = func() m_Wrappers.Result {
			var _source0 m_JSON_Grammar.Maybe = _3_exp
			_ = _source0
			{
				if _source0.Is_Empty() {
					return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Zero)
				}
			}
			{
				var t0 m_JSON_Grammar.Jexp = _source0.Get_().(m_JSON_Grammar.Maybe_NonEmpty).T.(m_JSON_Grammar.Jexp)
				_ = t0
				var _7_sign m_JSON_Utils_Views_Core.View__ = t0.Get_().(m_JSON_Grammar.Jexp_JExp).Sign
				_ = _7_sign
				var _8_num m_JSON_Utils_Views_Core.View__ = t0.Get_().(m_JSON_Grammar.Jexp_JExp).Num
				_ = _8_num
				return Companion_Default___.ToInt(_7_sign, _8_num)
			}
		}()
		_ = _6_valueOrError1
		if (_6_valueOrError1).IsFailure() {
			return (_6_valueOrError1).PropagateFailure()
		} else {
			var _9_e10 _dafny.Int = (_6_valueOrError1).Extract().(_dafny.Int)
			_ = _9_e10
			var _source1 m_JSON_Grammar.Maybe = _2_frac
			_ = _source1
			{
				if _source1.Is_Empty() {
					return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Values.Companion_Decimal_.Create_Decimal_(_5_n, _9_e10))
				}
			}
			{
				var t1 m_JSON_Grammar.Jfrac = _source1.Get_().(m_JSON_Grammar.Maybe_NonEmpty).T.(m_JSON_Grammar.Jfrac)
				_ = t1
				var _10_num m_JSON_Utils_Views_Core.View__ = t1.Get_().(m_JSON_Grammar.Jfrac_JFrac).Num
				_ = _10_num
				var _11_pow10 _dafny.Int = _dafny.IntOfUint32((_10_num).Length())
				_ = _11_pow10
				var _12_valueOrError2 m_Wrappers.Result = Companion_Default___.ToInt(_0_minus, _10_num)
				_ = _12_valueOrError2
				if (_12_valueOrError2).IsFailure() {
					return (_12_valueOrError2).PropagateFailure()
				} else {
					var _13_frac _dafny.Int = (_12_valueOrError2).Extract().(_dafny.Int)
					_ = _13_frac
					return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Values.Companion_Decimal_.Create_Decimal_(((_5_n).Times(m_Power.Companion_Default___.Pow(_dafny.IntOfInt64(10), _11_pow10))).Plus(_13_frac), (_9_e10).Minus(_11_pow10)))
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) KeyValue(js m_JSON_Grammar.JKeyValue) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.String((js).Dtor_k())
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_k _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_k
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.Value((js).Dtor_v())
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_v m_JSON_Values.JSON = (_2_valueOrError1).Extract().(m_JSON_Values.JSON)
			_ = _3_v
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf(_1_k, _3_v))
		}
	}
}
func (_static *CompanionStruct_Default___) Object(js m_JSON_Grammar.Bracketed) m_Wrappers.Result {
	return m_Seq.Companion_Default___.MapWithResult(func(coer38 func(m_JSON_Grammar.Suffixed) m_Wrappers.Result) func(interface{}) m_Wrappers.Result {
		return func(arg41 interface{}) m_Wrappers.Result {
			return coer38(arg41.(m_JSON_Grammar.Suffixed))
		}
	}((func(_0_js m_JSON_Grammar.Bracketed) func(m_JSON_Grammar.Suffixed) m_Wrappers.Result {
		return func(_1_d m_JSON_Grammar.Suffixed) m_Wrappers.Result {
			return Companion_Default___.KeyValue((_1_d).Dtor_t().(m_JSON_Grammar.JKeyValue))
		}
	})(js)), (js).Dtor_data())
}
func (_static *CompanionStruct_Default___) Array(js m_JSON_Grammar.Bracketed) m_Wrappers.Result {
	return m_Seq.Companion_Default___.MapWithResult(func(coer39 func(m_JSON_Grammar.Suffixed) m_Wrappers.Result) func(interface{}) m_Wrappers.Result {
		return func(arg42 interface{}) m_Wrappers.Result {
			return coer39(arg42.(m_JSON_Grammar.Suffixed))
		}
	}((func(_0_js m_JSON_Grammar.Bracketed) func(m_JSON_Grammar.Suffixed) m_Wrappers.Result {
		return func(_1_d m_JSON_Grammar.Suffixed) m_Wrappers.Result {
			return Companion_Default___.Value((_1_d).Dtor_t().(m_JSON_Grammar.Value))
		}
	})(js)), (js).Dtor_data())
}
func (_static *CompanionStruct_Default___) Value(js m_JSON_Grammar.Value) m_Wrappers.Result {
	var _source0 m_JSON_Grammar.Value = js
	_ = _source0
	{
		if _source0.Is_Null() {
			return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Values.Companion_JSON_.Create_Null_())
		}
	}
	{
		if _source0.Is_Bool() {
			var _0_b m_JSON_Utils_Views_Core.View__ = _source0.Get_().(m_JSON_Grammar.Value_Bool).B
			_ = _0_b
			return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Values.Companion_JSON_.Create_Bool_(Companion_Default___.Bool(_0_b)))
		}
	}
	{
		if _source0.Is_String() {
			var _1_str m_JSON_Grammar.Jstring = _source0.Get_().(m_JSON_Grammar.Value_String).Str
			_ = _1_str
			var _2_valueOrError0 m_Wrappers.Result = Companion_Default___.String(_1_str)
			_ = _2_valueOrError0
			if (_2_valueOrError0).IsFailure() {
				return (_2_valueOrError0).PropagateFailure()
			} else {
				var _3_s _dafny.Sequence = (_2_valueOrError0).Extract().(_dafny.Sequence)
				_ = _3_s
				return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Values.Companion_JSON_.Create_String_(_3_s))
			}
		}
	}
	{
		if _source0.Is_Number() {
			var _4_dec m_JSON_Grammar.Jnumber = _source0.Get_().(m_JSON_Grammar.Value_Number).Num
			_ = _4_dec
			var _5_valueOrError1 m_Wrappers.Result = Companion_Default___.Number(_4_dec)
			_ = _5_valueOrError1
			if (_5_valueOrError1).IsFailure() {
				return (_5_valueOrError1).PropagateFailure()
			} else {
				var _6_n m_JSON_Values.Decimal = (_5_valueOrError1).Extract().(m_JSON_Values.Decimal)
				_ = _6_n
				return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Values.Companion_JSON_.Create_Number_(_6_n))
			}
		}
	}
	{
		if _source0.Is_Object() {
			var _7_obj m_JSON_Grammar.Bracketed = _source0.Get_().(m_JSON_Grammar.Value_Object).Obj
			_ = _7_obj
			var _8_valueOrError2 m_Wrappers.Result = Companion_Default___.Object(_7_obj)
			_ = _8_valueOrError2
			if (_8_valueOrError2).IsFailure() {
				return (_8_valueOrError2).PropagateFailure()
			} else {
				var _9_o _dafny.Sequence = (_8_valueOrError2).Extract().(_dafny.Sequence)
				_ = _9_o
				return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Values.Companion_JSON_.Create_Object_(_9_o))
			}
		}
	}
	{
		var _10_arr m_JSON_Grammar.Bracketed = _source0.Get_().(m_JSON_Grammar.Value_Array).Arr
		_ = _10_arr
		var _11_valueOrError3 m_Wrappers.Result = Companion_Default___.Array(_10_arr)
		_ = _11_valueOrError3
		if (_11_valueOrError3).IsFailure() {
			return (_11_valueOrError3).PropagateFailure()
		} else {
			var _12_a _dafny.Sequence = (_11_valueOrError3).Extract().(_dafny.Sequence)
			_ = _12_a
			return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Values.Companion_JSON_.Create_Array_(_12_a))
		}
	}
}
func (_static *CompanionStruct_Default___) JSON(js m_JSON_Grammar.Structural) m_Wrappers.Result {
	return Companion_Default___.Value((js).Dtor_t().(m_JSON_Grammar.Value))
}
func (_static *CompanionStruct_Default___) HEX__TABLE__16() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(uint16(_dafny.Char('0')), _dafny.Zero).UpdateUnsafe(uint16(_dafny.Char('1')), _dafny.One).UpdateUnsafe(uint16(_dafny.Char('2')), _dafny.IntOfInt64(2)).UpdateUnsafe(uint16(_dafny.Char('3')), _dafny.IntOfInt64(3)).UpdateUnsafe(uint16(_dafny.Char('4')), _dafny.IntOfInt64(4)).UpdateUnsafe(uint16(_dafny.Char('5')), _dafny.IntOfInt64(5)).UpdateUnsafe(uint16(_dafny.Char('6')), _dafny.IntOfInt64(6)).UpdateUnsafe(uint16(_dafny.Char('7')), _dafny.IntOfInt64(7)).UpdateUnsafe(uint16(_dafny.Char('8')), _dafny.IntOfInt64(8)).UpdateUnsafe(uint16(_dafny.Char('9')), _dafny.IntOfInt64(9)).UpdateUnsafe(uint16(_dafny.Char('a')), _dafny.IntOfInt64(10)).UpdateUnsafe(uint16(_dafny.Char('b')), _dafny.IntOfInt64(11)).UpdateUnsafe(uint16(_dafny.Char('c')), _dafny.IntOfInt64(12)).UpdateUnsafe(uint16(_dafny.Char('d')), _dafny.IntOfInt64(13)).UpdateUnsafe(uint16(_dafny.Char('e')), _dafny.IntOfInt64(14)).UpdateUnsafe(uint16(_dafny.Char('f')), _dafny.IntOfInt64(15)).UpdateUnsafe(uint16(_dafny.Char('A')), _dafny.IntOfInt64(10)).UpdateUnsafe(uint16(_dafny.Char('B')), _dafny.IntOfInt64(11)).UpdateUnsafe(uint16(_dafny.Char('C')), _dafny.IntOfInt64(12)).UpdateUnsafe(uint16(_dafny.Char('D')), _dafny.IntOfInt64(13)).UpdateUnsafe(uint16(_dafny.Char('E')), _dafny.IntOfInt64(14)).UpdateUnsafe(uint16(_dafny.Char('F')), _dafny.IntOfInt64(15))
}
func (_static *CompanionStruct_Default___) DIGITS() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(uint8(_dafny.Char('0')), _dafny.Zero).UpdateUnsafe(uint8(_dafny.Char('1')), _dafny.One).UpdateUnsafe(uint8(_dafny.Char('2')), _dafny.IntOfInt64(2)).UpdateUnsafe(uint8(_dafny.Char('3')), _dafny.IntOfInt64(3)).UpdateUnsafe(uint8(_dafny.Char('4')), _dafny.IntOfInt64(4)).UpdateUnsafe(uint8(_dafny.Char('5')), _dafny.IntOfInt64(5)).UpdateUnsafe(uint8(_dafny.Char('6')), _dafny.IntOfInt64(6)).UpdateUnsafe(uint8(_dafny.Char('7')), _dafny.IntOfInt64(7)).UpdateUnsafe(uint8(_dafny.Char('8')), _dafny.IntOfInt64(8)).UpdateUnsafe(uint8(_dafny.Char('9')), _dafny.IntOfInt64(9))
}
func (_static *CompanionStruct_Default___) MINUS() uint8 {
	return uint8(_dafny.Char('-'))
}

// End of class Default__
