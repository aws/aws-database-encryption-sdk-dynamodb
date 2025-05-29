// Package Seq
// Dafny module Seq compiled into Go

package Seq

import (
	os "os"

	m__Math "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Math_"
	m_Relations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Relations"
	m_Seq_MergeSort "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Seq_MergeSort"
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
	return "Seq.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) First(xs _dafny.Sequence) interface{} {
	return (xs).Select(0).(interface{})
}
func (_static *CompanionStruct_Default___) DropFirst(xs _dafny.Sequence) _dafny.Sequence {
	return (xs).Drop(1)
}
func (_static *CompanionStruct_Default___) Last(xs _dafny.Sequence) interface{} {
	return (xs).Select(((_dafny.IntOfUint32((xs).Cardinality())).Minus(_dafny.One)).Uint32()).(interface{})
}
func (_static *CompanionStruct_Default___) DropLast(xs _dafny.Sequence) _dafny.Sequence {
	return (xs).Take(((_dafny.IntOfUint32((xs).Cardinality())).Minus(_dafny.One)).Uint32())
}
func (_static *CompanionStruct_Default___) ToArray(xs _dafny.Sequence) _dafny.Array {
	var a _dafny.Array = _dafny.NewArrayWithValue(nil, _dafny.IntOf(0))
	_ = a
	var _len0_0 _dafny.Int = _dafny.IntOfUint32((xs).Cardinality())
	_ = _len0_0
	var _nw0 _dafny.Array
	_ = _nw0
	if _len0_0.Cmp(_dafny.Zero) == 0 {
		_nw0 = _dafny.NewArray(_len0_0)
	} else {
		var _init0 func(_dafny.Int) interface{} = (func(_0_xs _dafny.Sequence) func(_dafny.Int) interface{} {
			return func(_1_i _dafny.Int) interface{} {
				return (_0_xs).Select((_1_i).Uint32()).(interface{})
			}
		})(xs)
		_ = _init0
		var _element0_0 = _init0(_dafny.Zero)
		_ = _element0_0
		_nw0 = _dafny.NewArrayFromExample(_element0_0, nil, _len0_0)
		(_nw0).ArraySet1(_element0_0, 0)
		var _nativeLen0_0 = (_len0_0).Int()
		_ = _nativeLen0_0
		for _i0_0 := 1; _i0_0 < _nativeLen0_0; _i0_0++ {
			(_nw0).ArraySet1(_init0(_dafny.IntOf(_i0_0)), _i0_0)
		}
	}
	a = _nw0
	return a
}
func (_static *CompanionStruct_Default___) ToSet(xs _dafny.Sequence) _dafny.Set {
	return func() _dafny.Set {
		var _coll0 = _dafny.NewBuilder()
		_ = _coll0
		for _iter0 := _dafny.Iterate((xs).Elements()); ; {
			_compr_0, _ok0 := _iter0()
			if !_ok0 {
				break
			}
			var _0_x interface{}
			_0_x = interface{}(_compr_0).(interface{})
			if _dafny.Companion_Sequence_.Contains(xs, _0_x) {
				_coll0.Add(_0_x)
			}
		}
		return _coll0.ToSet()
	}()
}
func (_static *CompanionStruct_Default___) IndexOf(xs _dafny.Sequence, v interface{}) _dafny.Int {
	var _0___accumulator _dafny.Int = _dafny.Zero
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if _dafny.AreEqual((xs).Select(0).(interface{}), v) {
		return (_dafny.Zero).Plus(_0___accumulator)
	} else {
		_0___accumulator = (_0___accumulator).Plus(_dafny.One)
		var _in0 _dafny.Sequence = (xs).Drop(1)
		_ = _in0
		var _in1 interface{} = v
		_ = _in1
		xs = _in0
		v = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) IndexOfOption(xs _dafny.Sequence, v interface{}) m_Wrappers.Option {
	if (_dafny.IntOfUint32((xs).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else if _dafny.AreEqual((xs).Select(0).(interface{}), v) {
		return m_Wrappers.Companion_Option_.Create_Some_(_dafny.Zero)
	} else {
		var _0_o_k m_Wrappers.Option = Companion_Default___.IndexOfOption((xs).Drop(1), v)
		_ = _0_o_k
		if (_0_o_k).Is_Some() {
			return m_Wrappers.Companion_Option_.Create_Some_(((_0_o_k).Dtor_value().(_dafny.Int)).Plus(_dafny.One))
		} else {
			return m_Wrappers.Companion_Option_.Create_None_()
		}
	}
}
func (_static *CompanionStruct_Default___) LastIndexOf(xs _dafny.Sequence, v interface{}) _dafny.Int {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if _dafny.AreEqual((xs).Select(((_dafny.IntOfUint32((xs).Cardinality())).Minus(_dafny.One)).Uint32()).(interface{}), v) {
		return (_dafny.IntOfUint32((xs).Cardinality())).Minus(_dafny.One)
	} else {
		var _in0 _dafny.Sequence = (xs).Take(((_dafny.IntOfUint32((xs).Cardinality())).Minus(_dafny.One)).Uint32())
		_ = _in0
		var _in1 interface{} = v
		_ = _in1
		xs = _in0
		v = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) LastIndexOfOption(xs _dafny.Sequence, v interface{}) m_Wrappers.Option {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((xs).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else if _dafny.AreEqual((xs).Select(((_dafny.IntOfUint32((xs).Cardinality())).Minus(_dafny.One)).Uint32()).(interface{}), v) {
		return m_Wrappers.Companion_Option_.Create_Some_((_dafny.IntOfUint32((xs).Cardinality())).Minus(_dafny.One))
	} else {
		var _in0 _dafny.Sequence = (xs).Take(((_dafny.IntOfUint32((xs).Cardinality())).Minus(_dafny.One)).Uint32())
		_ = _in0
		var _in1 interface{} = v
		_ = _in1
		xs = _in0
		v = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) Remove(xs _dafny.Sequence, pos _dafny.Int) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate((xs).Take((pos).Uint32()), (xs).Drop(((pos).Plus(_dafny.One)).Uint32()))
}
func (_static *CompanionStruct_Default___) RemoveValue(xs _dafny.Sequence, v interface{}) _dafny.Sequence {
	if !_dafny.Companion_Sequence_.Contains(xs, v) {
		return xs
	} else {
		var _0_i _dafny.Int = Companion_Default___.IndexOf(xs, v)
		_ = _0_i
		return _dafny.Companion_Sequence_.Concatenate((xs).Take((_0_i).Uint32()), (xs).Drop(((_0_i).Plus(_dafny.One)).Uint32()))
	}
}
func (_static *CompanionStruct_Default___) Insert(xs _dafny.Sequence, a interface{}, pos _dafny.Int) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate((xs).Take((pos).Uint32()), _dafny.SeqOf(a)), (xs).Drop((pos).Uint32()))
}
func (_static *CompanionStruct_Default___) Reverse(xs _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if _dafny.Companion_Sequence_.Equal(xs, _dafny.SeqOf()) {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf())
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf((xs).Select(((_dafny.IntOfUint32((xs).Cardinality())).Minus(_dafny.One)).Uint32()).(interface{})))
		var _in0 _dafny.Sequence = (xs).Subsequence(0, ((_dafny.IntOfUint32((xs).Cardinality())).Minus(_dafny.One)).Uint32())
		_ = _in0
		xs = _in0
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) Repeat(v interface{}, length _dafny.Int) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (length).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf())
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf(v))
		var _in0 interface{} = v
		_ = _in0
		var _in1 _dafny.Int = (length).Minus(_dafny.One)
		_ = _in1
		v = _in0
		length = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) Unzip(xs _dafny.Sequence) _dafny.Tuple {
	if (_dafny.IntOfUint32((xs).Cardinality())).Sign() == 0 {
		return _dafny.TupleOf(_dafny.SeqOf(), _dafny.SeqOf())
	} else {
		var _let_tmp_rhs0 _dafny.Tuple = Companion_Default___.Unzip(Companion_Default___.DropLast(xs))
		_ = _let_tmp_rhs0
		var _0_a _dafny.Sequence = (*(_let_tmp_rhs0).IndexInt(0)).(_dafny.Sequence)
		_ = _0_a
		var _1_b _dafny.Sequence = (*(_let_tmp_rhs0).IndexInt(1)).(_dafny.Sequence)
		_ = _1_b
		return _dafny.TupleOf(_dafny.Companion_Sequence_.Concatenate(_0_a, _dafny.SeqOf((*(Companion_Default___.Last(xs).(_dafny.Tuple)).IndexInt(0)))), _dafny.Companion_Sequence_.Concatenate(_1_b, _dafny.SeqOf((*(Companion_Default___.Last(xs).(_dafny.Tuple)).IndexInt(1)))))
	}
}
func (_static *CompanionStruct_Default___) Zip(xs _dafny.Sequence, ys _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((xs).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf(), _0___accumulator)
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf(_dafny.TupleOf(Companion_Default___.Last(xs), Companion_Default___.Last(ys))), _0___accumulator)
		var _in0 _dafny.Sequence = Companion_Default___.DropLast(xs)
		_ = _in0
		var _in1 _dafny.Sequence = Companion_Default___.DropLast(ys)
		_ = _in1
		xs = _in0
		ys = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) Max(xs _dafny.Sequence) _dafny.Int {
	if (_dafny.IntOfUint32((xs).Cardinality())).Cmp(_dafny.One) == 0 {
		return (xs).Select(0).(_dafny.Int)
	} else {
		return m__Math.Companion_Default___.Max((xs).Select(0).(_dafny.Int), Companion_Default___.Max((xs).Drop(1)))
	}
}
func (_static *CompanionStruct_Default___) Min(xs _dafny.Sequence) _dafny.Int {
	if (_dafny.IntOfUint32((xs).Cardinality())).Cmp(_dafny.One) == 0 {
		return (xs).Select(0).(_dafny.Int)
	} else {
		return m__Math.Companion_Default___.Min((xs).Select(0).(_dafny.Int), Companion_Default___.Min((xs).Drop(1)))
	}
}
func (_static *CompanionStruct_Default___) Flatten(xs _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((xs).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf())
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, (xs).Select(0).(_dafny.Sequence))
		var _in0 _dafny.Sequence = (xs).Drop(1)
		_ = _in0
		xs = _in0
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) FlattenReverse(xs _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((xs).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf(), _0___accumulator)
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(Companion_Default___.Last(xs).(_dafny.Sequence), _0___accumulator)
		var _in0 _dafny.Sequence = Companion_Default___.DropLast(xs)
		_ = _in0
		xs = _in0
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) Map(f func(interface{}) interface{}, xs _dafny.Sequence) _dafny.Sequence {
	return _dafny.SeqCreate((_dafny.IntOfUint32((xs).Cardinality())).Uint32(), func(coer1 func(_dafny.Int) interface{}) func(_dafny.Int) interface{} {
		return func(arg2 _dafny.Int) interface{} {
			return coer1(arg2)
		}
	}((func(_0_f func(interface{}) interface{}, _1_xs _dafny.Sequence) func(_dafny.Int) interface{} {
		return func(_2_i _dafny.Int) interface{} {
			return (_0_f)((_1_xs).Select((_2_i).Uint32()).(interface{}))
		}
	})(f, xs)))
}
func (_static *CompanionStruct_Default___) MapWithResult(f func(interface{}) m_Wrappers.Result, xs _dafny.Sequence) m_Wrappers.Result {
	if (_dafny.IntOfUint32((xs).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf())
	} else {
		var _0_valueOrError0 m_Wrappers.Result = (f)((xs).Select(0).(interface{}))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_head interface{} = (_0_valueOrError0).Extract()
			_ = _1_head
			var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.MapWithResult(f, (xs).Drop(1))
			_ = _2_valueOrError1
			if (_2_valueOrError1).IsFailure() {
				return (_2_valueOrError1).PropagateFailure()
			} else {
				var _3_tail _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
				_ = _3_tail
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf(_1_head), _3_tail))
			}
		}
	}
}
func (_static *CompanionStruct_Default___) Filter(f func(interface{}) bool, xs _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((xs).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf())
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, (func() _dafny.Sequence {
			if (f)((xs).Select(0).(interface{})) {
				return _dafny.SeqOf((xs).Select(0).(interface{}))
			}
			return _dafny.SeqOf()
		})())
		var _in0 func(interface{}) bool = f
		_ = _in0
		var _in1 _dafny.Sequence = (xs).Drop(1)
		_ = _in1
		f = _in0
		xs = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) FoldLeft(f func(interface{}, interface{}) interface{}, init interface{}, xs _dafny.Sequence) interface{} {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((xs).Cardinality())).Sign() == 0 {
		return init
	} else {
		var _in0 func(interface{}, interface{}) interface{} = f
		_ = _in0
		var _in1 interface{} = (f)(init, (xs).Select(0).(interface{}))
		_ = _in1
		var _in2 _dafny.Sequence = (xs).Drop(1)
		_ = _in2
		f = _in0
		init = _in1
		xs = _in2
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) FoldRight(f func(interface{}, interface{}) interface{}, xs _dafny.Sequence, init interface{}) interface{} {
	if (_dafny.IntOfUint32((xs).Cardinality())).Sign() == 0 {
		return init
	} else {
		return (f)((xs).Select(0).(interface{}), Companion_Default___.FoldRight(f, (xs).Drop(1), init))
	}
}
func (_static *CompanionStruct_Default___) FlatMap(f func(interface{}) _dafny.Sequence, xs _dafny.Sequence) _dafny.Sequence {
	var result _dafny.Sequence = _dafny.EmptySeq
	_ = result
	result = _dafny.SeqOf()
	var _lo0 _dafny.Int = _dafny.Zero
	_ = _lo0
	for _0_i := _dafny.IntOfUint32((xs).Cardinality()); _lo0.Cmp(_0_i) < 0; {
		_0_i = _0_i.Minus(_dafny.One)
		var _1_next _dafny.Sequence
		_ = _1_next
		_1_next = (f)((xs).Select((_0_i).Uint32()).(interface{}))
		result = _dafny.Companion_Sequence_.Concatenate(_1_next, result)
	}
	return result
}

// End of class Default__
