// Package Utf16EncodingForm
// Dafny module Utf16EncodingForm compiled into Go

package Utf16EncodingForm

import (
	os "os"

	m_BoundedInts "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/BoundedInts"
	m_Functions "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Functions"
	m__Math "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Math_"
	m_Relations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Relations"
	m_Seq "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Seq"
	m_Seq_MergeSort "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Seq_MergeSort"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
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
	return "Utf16EncodingForm.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) IsMinimalWellFormedCodeUnitSubsequence(s _dafny.Sequence) bool {
	if (_dafny.IntOfUint32((s).Cardinality())).Cmp(_dafny.One) == 0 {
		return Companion_Default___.IsWellFormedSingleCodeUnitSequence(s)
	} else if (_dafny.IntOfUint32((s).Cardinality())).Cmp(_dafny.IntOfInt64(2)) == 0 {
		var _0_b bool = Companion_Default___.IsWellFormedDoubleCodeUnitSequence(s)
		_ = _0_b
		return _0_b
	} else {
		return false
	}
}
func (_static *CompanionStruct_Default___) IsWellFormedSingleCodeUnitSequence(s _dafny.Sequence) bool {
	var _0_firstWord uint16 = (s).Select(0).(uint16)
	_ = _0_firstWord
	return (((uint16(0)) <= (_0_firstWord)) && ((_0_firstWord) <= (uint16(55295)))) || (((uint16(57344)) <= (_0_firstWord)) && ((_0_firstWord) <= (uint16(65535))))
}
func (_static *CompanionStruct_Default___) IsWellFormedDoubleCodeUnitSequence(s _dafny.Sequence) bool {
	var _0_firstWord uint16 = (s).Select(0).(uint16)
	_ = _0_firstWord
	var _1_secondWord uint16 = (s).Select(1).(uint16)
	_ = _1_secondWord
	return (((uint16(55296)) <= (_0_firstWord)) && ((_0_firstWord) <= (uint16(56319)))) && (((uint16(56320)) <= (_1_secondWord)) && ((_1_secondWord) <= (uint16(57343))))
}
func (_static *CompanionStruct_Default___) SplitPrefixMinimalWellFormedCodeUnitSubsequence(s _dafny.Sequence) m_Wrappers.Option {
	if ((_dafny.IntOfUint32((s).Cardinality())).Cmp(_dafny.One) >= 0) && (Companion_Default___.IsWellFormedSingleCodeUnitSequence((s).Take(1))) {
		return m_Wrappers.Companion_Option_.Create_Some_((s).Take(1))
	} else if ((_dafny.IntOfUint32((s).Cardinality())).Cmp(_dafny.IntOfInt64(2)) >= 0) && (Companion_Default___.IsWellFormedDoubleCodeUnitSequence((s).Take(2))) {
		return m_Wrappers.Companion_Option_.Create_Some_((s).Take(2))
	} else {
		return m_Wrappers.Companion_Option_.Create_None_()
	}
}
func (_static *CompanionStruct_Default___) EncodeScalarValue(v uint32) _dafny.Sequence {
	if (((uint32(0)) <= (v)) && ((v) <= (uint32(55295)))) || (((uint32(57344)) <= (v)) && ((v) <= (uint32(65535)))) {
		return Companion_Default___.EncodeScalarValueSingleWord(v)
	} else {
		return Companion_Default___.EncodeScalarValueDoubleWord(v)
	}
}
func (_static *CompanionStruct_Default___) EncodeScalarValueSingleWord(v uint32) _dafny.Sequence {
	var _0_firstWord uint16 = uint16(v)
	_ = _0_firstWord
	return _dafny.SeqOf(_0_firstWord)
}
func (_static *CompanionStruct_Default___) EncodeScalarValueDoubleWord(v uint32) _dafny.Sequence {
	var _0_x2 uint16 = uint16((v) & (uint32(1023)))
	_ = _0_x2
	var _1_x1 uint8 = uint8(((v) & (uint32(64512))) >> (uint8(10)))
	_ = _1_x1
	var _2_u uint8 = uint8(((v) & (uint32(2031616))) >> (uint8(16)))
	_ = _2_u
	var _3_w uint8 = uint8((((_2_u) - (func() uint8 { return (uint8(1)) })()) & 0x1F))
	_ = _3_w
	var _4_firstWord uint16 = ((uint16(55296)) | ((uint16(_3_w)) << (uint8(6)))) | (uint16(_1_x1))
	_ = _4_firstWord
	var _5_secondWord uint16 = (uint16(56320)) | (uint16(_0_x2))
	_ = _5_secondWord
	return _dafny.SeqOf(_4_firstWord, _5_secondWord)
}
func (_static *CompanionStruct_Default___) DecodeMinimalWellFormedCodeUnitSubsequence(m _dafny.Sequence) uint32 {
	if (_dafny.IntOfUint32((m).Cardinality())).Cmp(_dafny.One) == 0 {
		return Companion_Default___.DecodeMinimalWellFormedCodeUnitSubsequenceSingleWord(m)
	} else {
		return Companion_Default___.DecodeMinimalWellFormedCodeUnitSubsequenceDoubleWord(m)
	}
}
func (_static *CompanionStruct_Default___) DecodeMinimalWellFormedCodeUnitSubsequenceSingleWord(m _dafny.Sequence) uint32 {
	var _0_firstWord uint16 = (m).Select(0).(uint16)
	_ = _0_firstWord
	var _1_x uint16 = _0_firstWord
	_ = _1_x
	return uint32(_1_x)
}
func (_static *CompanionStruct_Default___) DecodeMinimalWellFormedCodeUnitSubsequenceDoubleWord(m _dafny.Sequence) uint32 {
	var _0_firstWord uint16 = (m).Select(0).(uint16)
	_ = _0_firstWord
	var _1_secondWord uint16 = (m).Select(1).(uint16)
	_ = _1_secondWord
	var _2_x2 uint32 = uint32((_1_secondWord) & (uint16(1023)))
	_ = _2_x2
	var _3_x1 uint32 = uint32((_0_firstWord) & (uint16(63)))
	_ = _3_x1
	var _4_w uint32 = uint32(((_0_firstWord) & (uint16(960))) >> (uint8(6)))
	_ = _4_w
	var _5_u uint32 = (((_4_w) + (uint32(1))) & 0xFFFFFF)
	_ = _5_u
	var _6_v uint32 = ((((_5_u) << (uint8(16))) & 0xFFFFFF) | (((_3_x1) << (uint8(10))) & 0xFFFFFF)) | (_2_x2)
	_ = _6_v
	return _6_v
}
func (_static *CompanionStruct_Default___) PartitionCodeUnitSequenceChecked(s _dafny.Sequence) m_Wrappers.Option {
	var maybeParts m_Wrappers.Option = m_Wrappers.Companion_Option_.Default()
	_ = maybeParts
	if _dafny.Companion_Sequence_.Equal(s, _dafny.SeqOf()) {
		maybeParts = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf())
		return maybeParts
	}
	var _0_result _dafny.Sequence
	_ = _0_result
	_0_result = _dafny.SeqOf()
	var _1_rest _dafny.Sequence
	_ = _1_rest
	_1_rest = s
	for (_dafny.IntOfUint32((_1_rest).Cardinality())).Sign() == 1 {
		var _2_valueOrError0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Default()
		_ = _2_valueOrError0
		_2_valueOrError0 = Companion_Default___.SplitPrefixMinimalWellFormedCodeUnitSubsequence(_1_rest)
		if (_2_valueOrError0).IsFailure() {
			maybeParts = (_2_valueOrError0).PropagateFailure()
			return maybeParts
		}
		var _3_prefix _dafny.Sequence
		_ = _3_prefix
		_3_prefix = (_2_valueOrError0).Extract().(_dafny.Sequence)
		_0_result = _dafny.Companion_Sequence_.Concatenate(_0_result, _dafny.SeqOf(_3_prefix))
		_1_rest = (_1_rest).Drop((_dafny.IntOfUint32((_3_prefix).Cardinality())).Uint32())
	}
	maybeParts = m_Wrappers.Companion_Option_.Create_Some_(_0_result)
	return maybeParts
	return maybeParts
}
func (_static *CompanionStruct_Default___) PartitionCodeUnitSequence(s _dafny.Sequence) _dafny.Sequence {
	return (Companion_Default___.PartitionCodeUnitSequenceChecked(s)).Extract().(_dafny.Sequence)
}
func (_static *CompanionStruct_Default___) IsWellFormedCodeUnitSequence(s _dafny.Sequence) bool {
	return (Companion_Default___.PartitionCodeUnitSequenceChecked(s)).Is_Some()
}
func (_static *CompanionStruct_Default___) EncodeScalarSequence(vs _dafny.Sequence) _dafny.Sequence {
	var s _dafny.Sequence = Companion_WellFormedCodeUnitSeq_.Witness()
	_ = s
	s = _dafny.SeqOf()
	var _lo0 _dafny.Int = _dafny.Zero
	_ = _lo0
	for _0_i := _dafny.IntOfUint32((vs).Cardinality()); _lo0.Cmp(_0_i) < 0; {
		_0_i = _0_i.Minus(_dafny.One)
		var _1_next _dafny.Sequence
		_ = _1_next
		_1_next = Companion_Default___.EncodeScalarValue((vs).Select((_0_i).Uint32()).(uint32))
		s = _dafny.Companion_Sequence_.Concatenate(_1_next, s)
	}
	return s
}
func (_static *CompanionStruct_Default___) DecodeCodeUnitSequence(s _dafny.Sequence) _dafny.Sequence {
	var _0_parts _dafny.Sequence = Companion_Default___.PartitionCodeUnitSequence(s)
	_ = _0_parts
	var _1_vs _dafny.Sequence = m_Seq.Companion_Default___.Map(func(coer4 func(_dafny.Sequence) uint32) func(interface{}) interface{} {
		return func(arg5 interface{}) interface{} {
			return coer4(arg5.(_dafny.Sequence))
		}
	}(Companion_Default___.DecodeMinimalWellFormedCodeUnitSubsequence), _0_parts)
	_ = _1_vs
	return _1_vs
}
func (_static *CompanionStruct_Default___) DecodeCodeUnitSequenceChecked(s _dafny.Sequence) m_Wrappers.Option {
	var maybeVs m_Wrappers.Option = m_Wrappers.Companion_Option_.Default()
	_ = maybeVs
	var _0_maybeParts m_Wrappers.Option
	_ = _0_maybeParts
	_0_maybeParts = Companion_Default___.PartitionCodeUnitSequenceChecked(s)
	if (_0_maybeParts).Is_None() {
		maybeVs = m_Wrappers.Companion_Option_.Create_None_()
		return maybeVs
	}
	var _1_parts _dafny.Sequence
	_ = _1_parts
	_1_parts = (_0_maybeParts).Dtor_value().(_dafny.Sequence)
	var _2_vs _dafny.Sequence
	_ = _2_vs
	_2_vs = m_Seq.Companion_Default___.Map(func(coer5 func(_dafny.Sequence) uint32) func(interface{}) interface{} {
		return func(arg6 interface{}) interface{} {
			return coer5(arg6.(_dafny.Sequence))
		}
	}(Companion_Default___.DecodeMinimalWellFormedCodeUnitSubsequence), _1_parts)
	maybeVs = m_Wrappers.Companion_Option_.Create_Some_(_2_vs)
	return maybeVs
	return maybeVs
}

// End of class Default__

// Definition of class WellFormedCodeUnitSeq
type WellFormedCodeUnitSeq struct {
}

func New_WellFormedCodeUnitSeq_() *WellFormedCodeUnitSeq {
	_this := WellFormedCodeUnitSeq{}

	return &_this
}

type CompanionStruct_WellFormedCodeUnitSeq_ struct {
}

var Companion_WellFormedCodeUnitSeq_ = CompanionStruct_WellFormedCodeUnitSeq_{}

func (*WellFormedCodeUnitSeq) String() string {
	return "Utf16EncodingForm.WellFormedCodeUnitSeq"
}
func (_this *CompanionStruct_WellFormedCodeUnitSeq_) Witness() _dafny.Sequence {
	return _dafny.SeqOf()
}

// End of class WellFormedCodeUnitSeq

func Type_WellFormedCodeUnitSeq_() _dafny.TypeDescriptor {
	return type_WellFormedCodeUnitSeq_{}
}

type type_WellFormedCodeUnitSeq_ struct {
}

func (_this type_WellFormedCodeUnitSeq_) Default() interface{} {
	return Companion_WellFormedCodeUnitSeq_.Witness()
}

func (_this type_WellFormedCodeUnitSeq_) String() string {
	return "Utf16EncodingForm.WellFormedCodeUnitSeq"
}
func (_this *CompanionStruct_WellFormedCodeUnitSeq_) Is_(__source _dafny.Sequence) bool {
	var _3_s _dafny.Sequence = (__source)
	_ = _3_s
	return Companion_Default___.IsWellFormedCodeUnitSequence(_3_s)
}

// Definition of class MinimalWellFormedCodeUnitSeq
type MinimalWellFormedCodeUnitSeq struct {
}

func New_MinimalWellFormedCodeUnitSeq_() *MinimalWellFormedCodeUnitSeq {
	_this := MinimalWellFormedCodeUnitSeq{}

	return &_this
}

type CompanionStruct_MinimalWellFormedCodeUnitSeq_ struct {
}

var Companion_MinimalWellFormedCodeUnitSeq_ = CompanionStruct_MinimalWellFormedCodeUnitSeq_{}

func (*MinimalWellFormedCodeUnitSeq) String() string {
	return "Utf16EncodingForm.MinimalWellFormedCodeUnitSeq"
}

// End of class MinimalWellFormedCodeUnitSeq

func Type_MinimalWellFormedCodeUnitSeq_() _dafny.TypeDescriptor {
	return type_MinimalWellFormedCodeUnitSeq_{}
}

type type_MinimalWellFormedCodeUnitSeq_ struct {
}

func (_this type_MinimalWellFormedCodeUnitSeq_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_MinimalWellFormedCodeUnitSeq_) String() string {
	return "Utf16EncodingForm.MinimalWellFormedCodeUnitSeq"
}
func (_this *CompanionStruct_MinimalWellFormedCodeUnitSeq_) Is_(__source _dafny.Sequence) bool {
	var _4_s _dafny.Sequence = (__source)
	_ = _4_s
	return Companion_Default___.IsMinimalWellFormedCodeUnitSubsequence(_4_s)
}
