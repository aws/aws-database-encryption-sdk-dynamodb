// Package Utf8EncodingForm
// Dafny module Utf8EncodingForm compiled into Go

package Utf8EncodingForm

import (
	os "os"

	m_BoundedInts "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/BoundedInts"
	m_Functions "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Functions"
	m__Math "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Math_"
	m_Relations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Relations"
	m_Seq "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Seq"
	m_Seq_MergeSort "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Seq_MergeSort"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
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
	return "Utf8EncodingForm.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) IsMinimalWellFormedCodeUnitSubsequence(s _dafny.Sequence) bool {
	if (_dafny.IntOfUint32((s).Cardinality())).Cmp(_dafny.One) == 0 {
		var _0_b bool = Companion_Default___.IsWellFormedSingleCodeUnitSequence(s)
		_ = _0_b
		return _0_b
	} else if (_dafny.IntOfUint32((s).Cardinality())).Cmp(_dafny.IntOfInt64(2)) == 0 {
		var _1_b bool = Companion_Default___.IsWellFormedDoubleCodeUnitSequence(s)
		_ = _1_b
		return _1_b
	} else if (_dafny.IntOfUint32((s).Cardinality())).Cmp(_dafny.IntOfInt64(3)) == 0 {
		var _2_b bool = Companion_Default___.IsWellFormedTripleCodeUnitSequence(s)
		_ = _2_b
		return _2_b
	} else if (_dafny.IntOfUint32((s).Cardinality())).Cmp(_dafny.IntOfInt64(4)) == 0 {
		var _3_b bool = Companion_Default___.IsWellFormedQuadrupleCodeUnitSequence(s)
		_ = _3_b
		return _3_b
	} else {
		return false
	}
}
func (_static *CompanionStruct_Default___) IsWellFormedSingleCodeUnitSequence(s _dafny.Sequence) bool {
	var _0_firstByte uint8 = (s).Select(0).(uint8)
	_ = _0_firstByte
	return (true) && (((uint8(0)) <= (_0_firstByte)) && ((_0_firstByte) <= (uint8(127))))
}
func (_static *CompanionStruct_Default___) IsWellFormedDoubleCodeUnitSequence(s _dafny.Sequence) bool {
	var _0_firstByte uint8 = (s).Select(0).(uint8)
	_ = _0_firstByte
	var _1_secondByte uint8 = (s).Select(1).(uint8)
	_ = _1_secondByte
	return (((uint8(194)) <= (_0_firstByte)) && ((_0_firstByte) <= (uint8(223)))) && (((uint8(128)) <= (_1_secondByte)) && ((_1_secondByte) <= (uint8(191))))
}
func (_static *CompanionStruct_Default___) IsWellFormedTripleCodeUnitSequence(s _dafny.Sequence) bool {
	var _0_firstByte uint8 = (s).Select(0).(uint8)
	_ = _0_firstByte
	var _1_secondByte uint8 = (s).Select(1).(uint8)
	_ = _1_secondByte
	var _2_thirdByte uint8 = (s).Select(2).(uint8)
	_ = _2_thirdByte
	return ((((((_0_firstByte) == (uint8(224))) && (((uint8(160)) <= (_1_secondByte)) && ((_1_secondByte) <= (uint8(191))))) || ((((uint8(225)) <= (_0_firstByte)) && ((_0_firstByte) <= (uint8(236)))) && (((uint8(128)) <= (_1_secondByte)) && ((_1_secondByte) <= (uint8(191)))))) || (((_0_firstByte) == (uint8(237))) && (((uint8(128)) <= (_1_secondByte)) && ((_1_secondByte) <= (uint8(159)))))) || ((((uint8(238)) <= (_0_firstByte)) && ((_0_firstByte) <= (uint8(239)))) && (((uint8(128)) <= (_1_secondByte)) && ((_1_secondByte) <= (uint8(191)))))) && (((uint8(128)) <= (_2_thirdByte)) && ((_2_thirdByte) <= (uint8(191))))
}
func (_static *CompanionStruct_Default___) IsWellFormedQuadrupleCodeUnitSequence(s _dafny.Sequence) bool {
	var _0_firstByte uint8 = (s).Select(0).(uint8)
	_ = _0_firstByte
	var _1_secondByte uint8 = (s).Select(1).(uint8)
	_ = _1_secondByte
	var _2_thirdByte uint8 = (s).Select(2).(uint8)
	_ = _2_thirdByte
	var _3_fourthByte uint8 = (s).Select(3).(uint8)
	_ = _3_fourthByte
	return ((((((_0_firstByte) == (uint8(240))) && (((uint8(144)) <= (_1_secondByte)) && ((_1_secondByte) <= (uint8(191))))) || ((((uint8(241)) <= (_0_firstByte)) && ((_0_firstByte) <= (uint8(243)))) && (((uint8(128)) <= (_1_secondByte)) && ((_1_secondByte) <= (uint8(191)))))) || (((_0_firstByte) == (uint8(244))) && (((uint8(128)) <= (_1_secondByte)) && ((_1_secondByte) <= (uint8(143)))))) && (((uint8(128)) <= (_2_thirdByte)) && ((_2_thirdByte) <= (uint8(191))))) && (((uint8(128)) <= (_3_fourthByte)) && ((_3_fourthByte) <= (uint8(191))))
}
func (_static *CompanionStruct_Default___) SplitPrefixMinimalWellFormedCodeUnitSubsequence(s _dafny.Sequence) m_Wrappers.Option {
	if ((_dafny.IntOfUint32((s).Cardinality())).Cmp(_dafny.One) >= 0) && (Companion_Default___.IsWellFormedSingleCodeUnitSequence((s).Take(1))) {
		return m_Wrappers.Companion_Option_.Create_Some_((s).Take(1))
	} else if ((_dafny.IntOfUint32((s).Cardinality())).Cmp(_dafny.IntOfInt64(2)) >= 0) && (Companion_Default___.IsWellFormedDoubleCodeUnitSequence((s).Take(2))) {
		return m_Wrappers.Companion_Option_.Create_Some_((s).Take(2))
	} else if ((_dafny.IntOfUint32((s).Cardinality())).Cmp(_dafny.IntOfInt64(3)) >= 0) && (Companion_Default___.IsWellFormedTripleCodeUnitSequence((s).Take(3))) {
		return m_Wrappers.Companion_Option_.Create_Some_((s).Take(3))
	} else if ((_dafny.IntOfUint32((s).Cardinality())).Cmp(_dafny.IntOfInt64(4)) >= 0) && (Companion_Default___.IsWellFormedQuadrupleCodeUnitSequence((s).Take(4))) {
		return m_Wrappers.Companion_Option_.Create_Some_((s).Take(4))
	} else {
		return m_Wrappers.Companion_Option_.Create_None_()
	}
}
func (_static *CompanionStruct_Default___) EncodeScalarValue(v uint32) _dafny.Sequence {
	if (v) <= (uint32(127)) {
		return Companion_Default___.EncodeScalarValueSingleByte(v)
	} else if (v) <= (uint32(2047)) {
		return Companion_Default___.EncodeScalarValueDoubleByte(v)
	} else if (v) <= (uint32(65535)) {
		return Companion_Default___.EncodeScalarValueTripleByte(v)
	} else {
		return Companion_Default___.EncodeScalarValueQuadrupleByte(v)
	}
}
func (_static *CompanionStruct_Default___) EncodeScalarValueSingleByte(v uint32) _dafny.Sequence {
	var _0_x uint8 = uint8((v) & (uint32(127)))
	_ = _0_x
	var _1_firstByte uint8 = uint8(_0_x)
	_ = _1_firstByte
	return _dafny.SeqOf(_1_firstByte)
}
func (_static *CompanionStruct_Default___) EncodeScalarValueDoubleByte(v uint32) _dafny.Sequence {
	var _0_x uint8 = uint8((v) & (uint32(63)))
	_ = _0_x
	var _1_y uint8 = uint8(((v) & (uint32(1984))) >> (uint8(6)))
	_ = _1_y
	var _2_firstByte uint8 = (uint8(192)) | (uint8(_1_y))
	_ = _2_firstByte
	var _3_secondByte uint8 = (uint8(128)) | (uint8(_0_x))
	_ = _3_secondByte
	return _dafny.SeqOf(_2_firstByte, _3_secondByte)
}
func (_static *CompanionStruct_Default___) EncodeScalarValueTripleByte(v uint32) _dafny.Sequence {
	var _0_x uint8 = uint8((v) & (uint32(63)))
	_ = _0_x
	var _1_y uint8 = uint8(((v) & (uint32(4032))) >> (uint8(6)))
	_ = _1_y
	var _2_z uint8 = uint8(((v) & (uint32(61440))) >> (uint8(12)))
	_ = _2_z
	var _3_firstByte uint8 = (uint8(224)) | (uint8(_2_z))
	_ = _3_firstByte
	var _4_secondByte uint8 = (uint8(128)) | (uint8(_1_y))
	_ = _4_secondByte
	var _5_thirdByte uint8 = (uint8(128)) | (uint8(_0_x))
	_ = _5_thirdByte
	return _dafny.SeqOf(_3_firstByte, _4_secondByte, _5_thirdByte)
}
func (_static *CompanionStruct_Default___) EncodeScalarValueQuadrupleByte(v uint32) _dafny.Sequence {
	var _0_x uint8 = uint8((v) & (uint32(63)))
	_ = _0_x
	var _1_y uint8 = uint8(((v) & (uint32(4032))) >> (uint8(6)))
	_ = _1_y
	var _2_z uint8 = uint8(((v) & (uint32(61440))) >> (uint8(12)))
	_ = _2_z
	var _3_u2 uint8 = uint8(((v) & (uint32(196608))) >> (uint8(16)))
	_ = _3_u2
	var _4_u1 uint8 = uint8(((v) & (uint32(1835008))) >> (uint8(18)))
	_ = _4_u1
	var _5_firstByte uint8 = (uint8(240)) | (uint8(_4_u1))
	_ = _5_firstByte
	var _6_secondByte uint8 = ((uint8(128)) | ((uint8(_3_u2)) << (uint8(4)))) | (uint8(_2_z))
	_ = _6_secondByte
	var _7_thirdByte uint8 = (uint8(128)) | (uint8(_1_y))
	_ = _7_thirdByte
	var _8_fourthByte uint8 = (uint8(128)) | (uint8(_0_x))
	_ = _8_fourthByte
	return _dafny.SeqOf(_5_firstByte, _6_secondByte, _7_thirdByte, _8_fourthByte)
}
func (_static *CompanionStruct_Default___) DecodeMinimalWellFormedCodeUnitSubsequence(m _dafny.Sequence) uint32 {
	if (_dafny.IntOfUint32((m).Cardinality())).Cmp(_dafny.One) == 0 {
		return Companion_Default___.DecodeMinimalWellFormedCodeUnitSubsequenceSingleByte(m)
	} else if (_dafny.IntOfUint32((m).Cardinality())).Cmp(_dafny.IntOfInt64(2)) == 0 {
		return Companion_Default___.DecodeMinimalWellFormedCodeUnitSubsequenceDoubleByte(m)
	} else if (_dafny.IntOfUint32((m).Cardinality())).Cmp(_dafny.IntOfInt64(3)) == 0 {
		return Companion_Default___.DecodeMinimalWellFormedCodeUnitSubsequenceTripleByte(m)
	} else {
		return Companion_Default___.DecodeMinimalWellFormedCodeUnitSubsequenceQuadrupleByte(m)
	}
}
func (_static *CompanionStruct_Default___) DecodeMinimalWellFormedCodeUnitSubsequenceSingleByte(m _dafny.Sequence) uint32 {
	var _0_firstByte uint8 = (m).Select(0).(uint8)
	_ = _0_firstByte
	var _1_x uint8 = uint8(_0_firstByte)
	_ = _1_x
	return uint32(_1_x)
}
func (_static *CompanionStruct_Default___) DecodeMinimalWellFormedCodeUnitSubsequenceDoubleByte(m _dafny.Sequence) uint32 {
	var _0_firstByte uint8 = (m).Select(0).(uint8)
	_ = _0_firstByte
	var _1_secondByte uint8 = (m).Select(1).(uint8)
	_ = _1_secondByte
	var _2_y uint32 = uint32((_0_firstByte) & (uint8(31)))
	_ = _2_y
	var _3_x uint32 = uint32((_1_secondByte) & (uint8(63)))
	_ = _3_x
	return (((_2_y) << (uint8(6))) & 0xFFFFFF) | (_3_x)
}
func (_static *CompanionStruct_Default___) DecodeMinimalWellFormedCodeUnitSubsequenceTripleByte(m _dafny.Sequence) uint32 {
	var _0_firstByte uint8 = (m).Select(0).(uint8)
	_ = _0_firstByte
	var _1_secondByte uint8 = (m).Select(1).(uint8)
	_ = _1_secondByte
	var _2_thirdByte uint8 = (m).Select(2).(uint8)
	_ = _2_thirdByte
	var _3_z uint32 = uint32((_0_firstByte) & (uint8(15)))
	_ = _3_z
	var _4_y uint32 = uint32((_1_secondByte) & (uint8(63)))
	_ = _4_y
	var _5_x uint32 = uint32((_2_thirdByte) & (uint8(63)))
	_ = _5_x
	return ((((_3_z) << (uint8(12))) & 0xFFFFFF) | (((_4_y) << (uint8(6))) & 0xFFFFFF)) | (_5_x)
}
func (_static *CompanionStruct_Default___) DecodeMinimalWellFormedCodeUnitSubsequenceQuadrupleByte(m _dafny.Sequence) uint32 {
	var _0_firstByte uint8 = (m).Select(0).(uint8)
	_ = _0_firstByte
	var _1_secondByte uint8 = (m).Select(1).(uint8)
	_ = _1_secondByte
	var _2_thirdByte uint8 = (m).Select(2).(uint8)
	_ = _2_thirdByte
	var _3_fourthByte uint8 = (m).Select(3).(uint8)
	_ = _3_fourthByte
	var _4_u1 uint32 = uint32((_0_firstByte) & (uint8(7)))
	_ = _4_u1
	var _5_u2 uint32 = uint32(((_1_secondByte) & (uint8(48))) >> (uint8(4)))
	_ = _5_u2
	var _6_z uint32 = uint32((_1_secondByte) & (uint8(15)))
	_ = _6_z
	var _7_y uint32 = uint32((_2_thirdByte) & (uint8(63)))
	_ = _7_y
	var _8_x uint32 = uint32((_3_fourthByte) & (uint8(63)))
	_ = _8_x
	return ((((((_4_u1) << (uint8(18))) & 0xFFFFFF) | (((_5_u2) << (uint8(16))) & 0xFFFFFF)) | (((_6_z) << (uint8(12))) & 0xFFFFFF)) | (((_7_y) << (uint8(6))) & 0xFFFFFF)) | (_8_x)
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
	var _1_vs _dafny.Sequence = m_Seq.Companion_Default___.Map(func(coer2 func(_dafny.Sequence) uint32) func(interface{}) interface{} {
		return func(arg3 interface{}) interface{} {
			return coer2(arg3.(_dafny.Sequence))
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
	_2_vs = m_Seq.Companion_Default___.Map(func(coer3 func(_dafny.Sequence) uint32) func(interface{}) interface{} {
		return func(arg4 interface{}) interface{} {
			return coer3(arg4.(_dafny.Sequence))
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
	return "Utf8EncodingForm.WellFormedCodeUnitSeq"
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
	return "Utf8EncodingForm.WellFormedCodeUnitSeq"
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
	return "Utf8EncodingForm.MinimalWellFormedCodeUnitSeq"
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
	return "Utf8EncodingForm.MinimalWellFormedCodeUnitSeq"
}
func (_this *CompanionStruct_MinimalWellFormedCodeUnitSeq_) Is_(__source _dafny.Sequence) bool {
	var _4_s _dafny.Sequence = (__source)
	_ = _4_s
	return Companion_Default___.IsMinimalWellFormedCodeUnitSubsequence(_4_s)
}
