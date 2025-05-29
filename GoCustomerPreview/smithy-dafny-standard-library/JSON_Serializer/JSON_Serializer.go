// Package JSON_Serializer
// Dafny module JSON_Serializer compiled into Go

package JSON_Serializer

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
	m_JSON_Grammar "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Grammar"
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
	return "JSON_Serializer.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) Bool(b bool) m_JSON_Utils_Views_Core.View__ {
	return m_JSON_Utils_Views_Core.Companion_View___.OfBytes((func() _dafny.Sequence {
		if b {
			return m_JSON_Grammar.Companion_Default___.TRUE()
		}
		return m_JSON_Grammar.Companion_Default___.FALSE()
	})())
}
func (_static *CompanionStruct_Default___) CheckLength(s _dafny.Sequence, err m_JSON_Errors.SerializationError) m_Wrappers.Outcome {
	return m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((s).Cardinality())).Cmp(m_BoundedInts.Companion_Default___.TWO__TO__THE__32()) < 0, err)
}
func (_static *CompanionStruct_Default___) String(str _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = m_JSON_Spec.Companion_Default___.EscapeToUTF8(str, _dafny.Zero)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_bs _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_bs
		var _2_valueOrError1 m_Wrappers.Outcome = Companion_Default___.CheckLength(_1_bs, m_JSON_Errors.Companion_SerializationError_.Create_StringTooLong_(str))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Grammar.Companion_Jstring_.Create_JString_(m_JSON_Grammar.Companion_Default___.DOUBLEQUOTE(), m_JSON_Utils_Views_Core.Companion_View___.OfBytes(_1_bs), m_JSON_Grammar.Companion_Default___.DOUBLEQUOTE()))
		}
	}
}
func (_static *CompanionStruct_Default___) Sign(n _dafny.Int) m_JSON_Utils_Views_Core.View__ {
	return m_JSON_Utils_Views_Core.Companion_View___.OfBytes((func() _dafny.Sequence {
		if (n).Sign() == -1 {
			return _dafny.SeqOf(uint8(_dafny.Char('-')))
		}
		return _dafny.SeqOf()
	})())
}
func (_static *CompanionStruct_Default___) Int_k(n _dafny.Int) _dafny.Sequence {
	return m_JSON_Serializer_ByteStrConversion.Companion_Default___.OfInt__any(n, Companion_Default___.DIGITS(), Companion_Default___.MINUS())
}
func (_static *CompanionStruct_Default___) Int(n _dafny.Int) m_Wrappers.Result {
	var _0_bs _dafny.Sequence = Companion_Default___.Int_k(n)
	_ = _0_bs
	var _1_valueOrError0 m_Wrappers.Outcome = Companion_Default___.CheckLength(_0_bs, m_JSON_Errors.Companion_SerializationError_.Create_IntTooLarge_(n))
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Utils_Views_Core.Companion_View___.OfBytes(_0_bs))
	}
}
func (_static *CompanionStruct_Default___) Number(dec m_JSON_Values.Decimal) m_Wrappers.Result {
	var _pat_let_tv0 = dec
	_ = _pat_let_tv0
	var _pat_let_tv1 = dec
	_ = _pat_let_tv1
	var _0_minus m_JSON_Utils_Views_Core.View__ = Companion_Default___.Sign((dec).Dtor_n())
	_ = _0_minus
	var _1_valueOrError0 m_Wrappers.Result = Companion_Default___.Int(m__Math.Companion_Default___.Abs((dec).Dtor_n()))
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2_num m_JSON_Utils_Views_Core.View__ = (_1_valueOrError0).Extract().(m_JSON_Utils_Views_Core.View__)
		_ = _2_num
		var _3_frac m_JSON_Grammar.Maybe = m_JSON_Grammar.Companion_Maybe_.Create_Empty_()
		_ = _3_frac
		var _4_valueOrError1 m_Wrappers.Result = (func() m_Wrappers.Result {
			if ((dec).Dtor_e10()).Sign() == 0 {
				return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Grammar.Companion_Maybe_.Create_Empty_())
			}
			return func(_pat_let5_0 m_JSON_Utils_Views_Core.View__) m_Wrappers.Result {
				return func(_5_e m_JSON_Utils_Views_Core.View__) m_Wrappers.Result {
					return func(_pat_let6_0 m_JSON_Utils_Views_Core.View__) m_Wrappers.Result {
						return func(_6_sign m_JSON_Utils_Views_Core.View__) m_Wrappers.Result {
							return func(_pat_let7_0 m_Wrappers.Result) m_Wrappers.Result {
								return func(_7_valueOrError2 m_Wrappers.Result) m_Wrappers.Result {
									return (func() m_Wrappers.Result {
										if (_7_valueOrError2).IsFailure() {
											return (_7_valueOrError2).PropagateFailure()
										}
										return func(_pat_let8_0 m_JSON_Utils_Views_Core.View__) m_Wrappers.Result {
											return func(_8_num m_JSON_Utils_Views_Core.View__) m_Wrappers.Result {
												return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Grammar.Companion_Maybe_.Create_NonEmpty_(m_JSON_Grammar.Companion_Jexp_.Create_JExp_(_5_e, _6_sign, _8_num)))
											}(_pat_let8_0)
										}((_7_valueOrError2).Extract().(m_JSON_Utils_Views_Core.View__))
									})()
								}(_pat_let7_0)
							}(Companion_Default___.Int(m__Math.Companion_Default___.Abs((_pat_let_tv1).Dtor_e10())))
						}(_pat_let6_0)
					}(Companion_Default___.Sign((_pat_let_tv0).Dtor_e10()))
				}(_pat_let5_0)
			}(m_JSON_Utils_Views_Core.Companion_View___.OfBytes(_dafny.SeqOf(uint8(_dafny.Char('e')))))
		})()
		_ = _4_valueOrError1
		if (_4_valueOrError1).IsFailure() {
			return (_4_valueOrError1).PropagateFailure()
		} else {
			var _9_exp m_JSON_Grammar.Maybe = (_4_valueOrError1).Extract().(m_JSON_Grammar.Maybe)
			_ = _9_exp
			return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Grammar.Companion_Jnumber_.Create_JNumber_(_0_minus, _2_num, m_JSON_Grammar.Companion_Maybe_.Create_Empty_(), _9_exp))
		}
	}
}
func (_static *CompanionStruct_Default___) MkStructural(v interface{}) m_JSON_Grammar.Structural {
	return m_JSON_Grammar.Companion_Structural_.Create_Structural_(m_JSON_Grammar.Companion_Default___.EMPTY(), v, m_JSON_Grammar.Companion_Default___.EMPTY())
}
func (_static *CompanionStruct_Default___) KeyValue(kv _dafny.Tuple) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.String((*(kv).IndexInt(0)).(_dafny.Sequence))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_k m_JSON_Grammar.Jstring = (_0_valueOrError0).Extract().(m_JSON_Grammar.Jstring)
		_ = _1_k
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.Value((*(kv).IndexInt(1)).(m_JSON_Values.JSON))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_v m_JSON_Grammar.Value = (_2_valueOrError1).Extract().(m_JSON_Grammar.Value)
			_ = _3_v
			return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Grammar.Companion_JKeyValue_.Create_KeyValue_(_1_k, Companion_Default___.COLON(), _3_v))
		}
	}
}
func (_static *CompanionStruct_Default___) MkSuffixedSequence(ds _dafny.Sequence, suffix m_JSON_Grammar.Structural, start _dafny.Int) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (start).Cmp(_dafny.IntOfUint32((ds).Cardinality())) >= 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf())
	} else if (start).Cmp((_dafny.IntOfUint32((ds).Cardinality())).Minus(_dafny.One)) == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf(m_JSON_Grammar.Companion_Suffixed_.Create_Suffixed_((ds).Select((start).Uint32()).(interface{}), m_JSON_Grammar.Companion_Maybe_.Create_Empty_())))
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf(m_JSON_Grammar.Companion_Suffixed_.Create_Suffixed_((ds).Select((start).Uint32()).(interface{}), m_JSON_Grammar.Companion_Maybe_.Create_NonEmpty_(suffix))))
		var _in0 _dafny.Sequence = ds
		_ = _in0
		var _in1 m_JSON_Grammar.Structural = suffix
		_ = _in1
		var _in2 _dafny.Int = (start).Plus(_dafny.One)
		_ = _in2
		ds = _in0
		suffix = _in1
		start = _in2
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) Object(obj _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = m_Seq.Companion_Default___.MapWithResult(func(coer36 func(_dafny.Tuple) m_Wrappers.Result) func(interface{}) m_Wrappers.Result {
		return func(arg39 interface{}) m_Wrappers.Result {
			return coer36(arg39.(_dafny.Tuple))
		}
	}((func(_1_obj _dafny.Sequence) func(_dafny.Tuple) m_Wrappers.Result {
		return func(_2_v _dafny.Tuple) m_Wrappers.Result {
			return Companion_Default___.KeyValue(_2_v)
		}
	})(obj)), obj)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _3_items _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _3_items
		return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Grammar.Companion_Bracketed_.Create_Bracketed_(Companion_Default___.MkStructural(m_JSON_Grammar.Companion_Default___.LBRACE()), Companion_Default___.MkSuffixedSequence(_3_items, Companion_Default___.COMMA(), _dafny.Zero), Companion_Default___.MkStructural(m_JSON_Grammar.Companion_Default___.RBRACE())))
	}
}
func (_static *CompanionStruct_Default___) Array(arr _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = m_Seq.Companion_Default___.MapWithResult(func(coer37 func(m_JSON_Values.JSON) m_Wrappers.Result) func(interface{}) m_Wrappers.Result {
		return func(arg40 interface{}) m_Wrappers.Result {
			return coer37(arg40.(m_JSON_Values.JSON))
		}
	}((func(_1_arr _dafny.Sequence) func(m_JSON_Values.JSON) m_Wrappers.Result {
		return func(_2_v m_JSON_Values.JSON) m_Wrappers.Result {
			return Companion_Default___.Value(_2_v)
		}
	})(arr)), arr)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _3_items _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _3_items
		return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Grammar.Companion_Bracketed_.Create_Bracketed_(Companion_Default___.MkStructural(m_JSON_Grammar.Companion_Default___.LBRACKET()), Companion_Default___.MkSuffixedSequence(_3_items, Companion_Default___.COMMA(), _dafny.Zero), Companion_Default___.MkStructural(m_JSON_Grammar.Companion_Default___.RBRACKET())))
	}
}
func (_static *CompanionStruct_Default___) Value(js m_JSON_Values.JSON) m_Wrappers.Result {
	var _source0 m_JSON_Values.JSON = js
	_ = _source0
	{
		if _source0.Is_Null() {
			return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Grammar.Companion_Value_.Create_Null_(m_JSON_Utils_Views_Core.Companion_View___.OfBytes(m_JSON_Grammar.Companion_Default___.NULL())))
		}
	}
	{
		if _source0.Is_Bool() {
			var _0_b bool = _source0.Get_().(m_JSON_Values.JSON_Bool).B
			_ = _0_b
			return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Grammar.Companion_Value_.Create_Bool_(Companion_Default___.Bool(_0_b)))
		}
	}
	{
		if _source0.Is_String() {
			var _1_str _dafny.Sequence = _source0.Get_().(m_JSON_Values.JSON_String).Str
			_ = _1_str
			var _2_valueOrError0 m_Wrappers.Result = Companion_Default___.String(_1_str)
			_ = _2_valueOrError0
			if (_2_valueOrError0).IsFailure() {
				return (_2_valueOrError0).PropagateFailure()
			} else {
				var _3_s m_JSON_Grammar.Jstring = (_2_valueOrError0).Extract().(m_JSON_Grammar.Jstring)
				_ = _3_s
				return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Grammar.Companion_Value_.Create_String_(_3_s))
			}
		}
	}
	{
		if _source0.Is_Number() {
			var _4_dec m_JSON_Values.Decimal = _source0.Get_().(m_JSON_Values.JSON_Number).Num
			_ = _4_dec
			var _5_valueOrError1 m_Wrappers.Result = Companion_Default___.Number(_4_dec)
			_ = _5_valueOrError1
			if (_5_valueOrError1).IsFailure() {
				return (_5_valueOrError1).PropagateFailure()
			} else {
				var _6_n m_JSON_Grammar.Jnumber = (_5_valueOrError1).Extract().(m_JSON_Grammar.Jnumber)
				_ = _6_n
				return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Grammar.Companion_Value_.Create_Number_(_6_n))
			}
		}
	}
	{
		if _source0.Is_Object() {
			var _7_obj _dafny.Sequence = _source0.Get_().(m_JSON_Values.JSON_Object).Obj
			_ = _7_obj
			var _8_valueOrError2 m_Wrappers.Result = Companion_Default___.Object(_7_obj)
			_ = _8_valueOrError2
			if (_8_valueOrError2).IsFailure() {
				return (_8_valueOrError2).PropagateFailure()
			} else {
				var _9_o m_JSON_Grammar.Bracketed = (_8_valueOrError2).Extract().(m_JSON_Grammar.Bracketed)
				_ = _9_o
				return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Grammar.Companion_Value_.Create_Object_(_9_o))
			}
		}
	}
	{
		var _10_arr _dafny.Sequence = _source0.Get_().(m_JSON_Values.JSON_Array).Arr
		_ = _10_arr
		var _11_valueOrError3 m_Wrappers.Result = Companion_Default___.Array(_10_arr)
		_ = _11_valueOrError3
		if (_11_valueOrError3).IsFailure() {
			return (_11_valueOrError3).PropagateFailure()
		} else {
			var _12_a m_JSON_Grammar.Bracketed = (_11_valueOrError3).Extract().(m_JSON_Grammar.Bracketed)
			_ = _12_a
			return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Grammar.Companion_Value_.Create_Array_(_12_a))
		}
	}
}
func (_static *CompanionStruct_Default___) JSON(js m_JSON_Values.JSON) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.Value(js)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_val m_JSON_Grammar.Value = (_0_valueOrError0).Extract().(m_JSON_Grammar.Value)
		_ = _1_val
		return m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.MkStructural(_1_val))
	}
}
func (_static *CompanionStruct_Default___) DIGITS() _dafny.Sequence {
	return _dafny.SeqOf(uint8(_dafny.Char('0')), uint8(_dafny.Char('1')), uint8(_dafny.Char('2')), uint8(_dafny.Char('3')), uint8(_dafny.Char('4')), uint8(_dafny.Char('5')), uint8(_dafny.Char('6')), uint8(_dafny.Char('7')), uint8(_dafny.Char('8')), uint8(_dafny.Char('9')))
}
func (_static *CompanionStruct_Default___) MINUS() uint8 {
	return uint8(_dafny.Char('-'))
}
func (_static *CompanionStruct_Default___) COLON() m_JSON_Grammar.Structural {
	return Companion_Default___.MkStructural(m_JSON_Grammar.Companion_Default___.COLON())
}
func (_static *CompanionStruct_Default___) COMMA() m_JSON_Grammar.Structural {
	return Companion_Default___.MkStructural(m_JSON_Grammar.Companion_Default___.COMMA())
}

// End of class Default__

// Definition of class Bytes32
type Bytes32 struct {
}

func New_Bytes32_() *Bytes32 {
	_this := Bytes32{}

	return &_this
}

type CompanionStruct_Bytes32_ struct {
}

var Companion_Bytes32_ = CompanionStruct_Bytes32_{}

func (*Bytes32) String() string {
	return "JSON_Serializer.Bytes32"
}

// End of class Bytes32

func Type_Bytes32_() _dafny.TypeDescriptor {
	return type_Bytes32_{}
}

type type_Bytes32_ struct {
}

func (_this type_Bytes32_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_Bytes32_) String() string {
	return "JSON_Serializer.Bytes32"
}
func (_this *CompanionStruct_Bytes32_) Is_(__source _dafny.Sequence) bool {
	var _0_bs _dafny.Sequence = (__source)
	_ = _0_bs
	return (_dafny.IntOfUint32((_0_bs).Cardinality())).Cmp(m_BoundedInts.Companion_Default___.TWO__TO__THE__32()) < 0
}

// Definition of class String32
type String32 struct {
}

func New_String32_() *String32 {
	_this := String32{}

	return &_this
}

type CompanionStruct_String32_ struct {
}

var Companion_String32_ = CompanionStruct_String32_{}

func (*String32) String() string {
	return "JSON_Serializer.String32"
}

// End of class String32

func Type_String32_() _dafny.TypeDescriptor {
	return type_String32_{}
}

type type_String32_ struct {
}

func (_this type_String32_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_String32_) String() string {
	return "JSON_Serializer.String32"
}
func (_this *CompanionStruct_String32_) Is_(__source _dafny.Sequence) bool {
	var _1_s _dafny.Sequence = (__source)
	_ = _1_s
	return (_dafny.IntOfUint32((_1_s).Cardinality())).Cmp(m_BoundedInts.Companion_Default___.TWO__TO__THE__32()) < 0
}
