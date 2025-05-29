// Package Seq_MergeSort
// Dafny module Seq_MergeSort compiled into Go

package Seq_MergeSort

import (
	os "os"

	m_Relations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Relations"
	m_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	m__System "github.com/dafny-lang/DafnyRuntimeGo/v4/System_"
	_dafny "github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
)

var _ = os.Args
var _ _dafny.Dummy__
var _ m__System.Dummy__
var _ m_Wrappers.Dummy__
var _ m_Relations.Dummy__

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
	return "Seq_MergeSort.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) MergeSortBy(a _dafny.Sequence, lessThanOrEq func(interface{}, interface{}) bool) _dafny.Sequence {
	if (_dafny.IntOfUint32((a).Cardinality())).Cmp(_dafny.One) <= 0 {
		return a
	} else {
		var _0_splitIndex _dafny.Int = (_dafny.IntOfUint32((a).Cardinality())).DivBy(_dafny.IntOfInt64(2))
		_ = _0_splitIndex
		var _1_left _dafny.Sequence = (a).Take((_0_splitIndex).Uint32())
		_ = _1_left
		var _2_right _dafny.Sequence = (a).Drop((_0_splitIndex).Uint32())
		_ = _2_right
		var _3_leftSorted _dafny.Sequence = Companion_Default___.MergeSortBy(_1_left, lessThanOrEq)
		_ = _3_leftSorted
		var _4_rightSorted _dafny.Sequence = Companion_Default___.MergeSortBy(_2_right, lessThanOrEq)
		_ = _4_rightSorted
		return Companion_Default___.MergeSortedWith(_3_leftSorted, _4_rightSorted, func(coer0 func(interface{}, interface{}) bool) func(interface{}, interface{}) bool {
			return func(arg0 interface{}, arg1 interface{}) bool {
				return coer0(arg0, arg1)
			}
		}(lessThanOrEq))
	}
}
func (_static *CompanionStruct_Default___) MergeSortedWith(left _dafny.Sequence, right _dafny.Sequence, lessThanOrEq func(interface{}, interface{}) bool) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((left).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, right)
	} else if (_dafny.IntOfUint32((right).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, left)
	} else if (lessThanOrEq)((left).Select(0).(interface{}), (right).Select(0).(interface{})) {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf((left).Select(0).(interface{})))
		var _in0 _dafny.Sequence = (left).Drop(1)
		_ = _in0
		var _in1 _dafny.Sequence = right
		_ = _in1
		var _in2 func(interface{}, interface{}) bool = lessThanOrEq
		_ = _in2
		left = _in0
		right = _in1
		lessThanOrEq = _in2
		goto TAIL_CALL_START
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf((right).Select(0).(interface{})))
		var _in3 _dafny.Sequence = left
		_ = _in3
		var _in4 _dafny.Sequence = (right).Drop(1)
		_ = _in4
		var _in5 func(interface{}, interface{}) bool = lessThanOrEq
		_ = _in5
		left = _in3
		right = _in4
		lessThanOrEq = _in5
		goto TAIL_CALL_START
	}
}

// End of class Default__
