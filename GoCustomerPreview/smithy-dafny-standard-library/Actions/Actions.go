// Package Actions
// Dafny module Actions compiled into Go

package Actions

import (
	os "os"

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
	return "Actions.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) DeterministicMap(action DeterministicAction, s _dafny.Sequence) _dafny.Sequence {
	var res _dafny.Sequence = _dafny.EmptySeq
	_ = res
	var _0_rs _dafny.Sequence
	_ = _0_rs
	_0_rs = _dafny.SeqOf()
	var _hi0 uint64 = uint64((s).Cardinality())
	_ = _hi0
	for _1_i := uint64(0); _1_i < _hi0; _1_i++ {
		var _2_r interface{}
		_ = _2_r
		var _out0 interface{}
		_ = _out0
		_out0 = (action).Invoke((s).Select(uint32(_1_i)).(interface{}))
		_2_r = _out0
		_0_rs = _dafny.Companion_Sequence_.Concatenate(_0_rs, _dafny.SeqOf(_2_r))
	}
	res = _0_rs
	return res
	return res
}
func (_static *CompanionStruct_Default___) DeterministicMapWithResult(action DeterministicActionWithResult, s _dafny.Sequence) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = res
	var _0_rs _dafny.Sequence
	_ = _0_rs
	_0_rs = _dafny.SeqOf()
	var _hi0 uint64 = uint64((s).Cardinality())
	_ = _hi0
	for _1_i := uint64(0); _1_i < _hi0; _1_i++ {
		var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _2_valueOrError0
		var _out0 interface{}
		_ = _out0
		_out0 = (action).Invoke((s).Select(uint32(_1_i)).(interface{}))
		_2_valueOrError0 = _out0.(m_Wrappers.Result)
		if (_2_valueOrError0).IsFailure() {
			res = (_2_valueOrError0).PropagateFailure()
			return res
		}
		var _3_r interface{}
		_ = _3_r
		_3_r = (_2_valueOrError0).Extract()
		_0_rs = _dafny.Companion_Sequence_.Concatenate(_0_rs, _dafny.SeqOf(_3_r))
	}
	res = m_Wrappers.Companion_Result_.Create_Success_(_0_rs)
	return res
	return res
}
func (_static *CompanionStruct_Default___) DeterministicFlatMap(action DeterministicAction, s _dafny.Sequence) _dafny.Sequence {
	var res _dafny.Sequence = _dafny.EmptySeq
	_ = res
	var _0_rs _dafny.Sequence
	_ = _0_rs
	_0_rs = _dafny.SeqOf()
	var _hi0 uint64 = uint64((s).Cardinality())
	_ = _hi0
	for _1_i := uint64(0); _1_i < _hi0; _1_i++ {
		var _2_r _dafny.Sequence
		_ = _2_r
		var _out0 interface{}
		_ = _out0
		_out0 = (action).Invoke((s).Select(uint32(_1_i)).(interface{}))
		_2_r = _out0.(_dafny.Sequence)
		_0_rs = _dafny.Companion_Sequence_.Concatenate(_0_rs, _2_r)
	}
	res = _0_rs
	return res
	return res
}
func (_static *CompanionStruct_Default___) DeterministicFlatMapWithResult(action DeterministicActionWithResult, s _dafny.Sequence) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = res
	var _0_rs _dafny.Sequence
	_ = _0_rs
	_0_rs = _dafny.SeqOf()
	var _hi0 uint64 = uint64((s).Cardinality())
	_ = _hi0
	for _1_i := uint64(0); _1_i < _hi0; _1_i++ {
		var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _2_valueOrError0
		var _out0 interface{}
		_ = _out0
		_out0 = (action).Invoke((s).Select(uint32(_1_i)).(interface{}))
		_2_valueOrError0 = _out0.(m_Wrappers.Result)
		if (_2_valueOrError0).IsFailure() {
			res = (_2_valueOrError0).PropagateFailure()
			return res
		}
		var _3_r _dafny.Sequence
		_ = _3_r
		_3_r = (_2_valueOrError0).Extract().(_dafny.Sequence)
		_0_rs = _dafny.Companion_Sequence_.Concatenate(_0_rs, _3_r)
	}
	var _rhs0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Create_Success_(_0_rs)
	_ = _rhs0
	res = _rhs0
	return res
	return res
}
func (_static *CompanionStruct_Default___) Filter(action DeterministicAction, s _dafny.Sequence) _dafny.Sequence {
	var res _dafny.Sequence = _dafny.EmptySeq
	_ = res
	var _0_rs _dafny.Sequence
	_ = _0_rs
	_0_rs = _dafny.SeqOf()
	var _hi0 uint64 = uint64((s).Cardinality())
	_ = _hi0
	for _1_i := uint64(0); _1_i < _hi0; _1_i++ {
		var _2_r bool
		_ = _2_r
		var _out0 interface{}
		_ = _out0
		_out0 = (action).Invoke((s).Select(uint32(_1_i)).(interface{}))
		_2_r = _out0.(bool)
		if _2_r {
			_0_rs = _dafny.Companion_Sequence_.Concatenate(_0_rs, _dafny.SeqOf((s).Select(uint32(_1_i)).(interface{})))
		}
	}
	res = _0_rs
	return res
	return res
}
func (_static *CompanionStruct_Default___) FilterWithResult(action DeterministicActionWithResult, s _dafny.Sequence) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = res
	var _0_rs _dafny.Sequence
	_ = _0_rs
	_0_rs = _dafny.SeqOf()
	var _hi0 uint64 = uint64((s).Cardinality())
	_ = _hi0
	for _1_i := uint64(0); _1_i < _hi0; _1_i++ {
		var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _2_valueOrError0
		var _out0 interface{}
		_ = _out0
		_out0 = (action).Invoke((s).Select(uint32(_1_i)).(interface{}))
		_2_valueOrError0 = _out0.(m_Wrappers.Result)
		if (_2_valueOrError0).IsFailure() {
			res = (_2_valueOrError0).PropagateFailure()
			return res
		}
		var _3_r bool
		_ = _3_r
		_3_r = (_2_valueOrError0).Extract().(bool)
		if _3_r {
			_0_rs = _dafny.Companion_Sequence_.Concatenate(_0_rs, _dafny.SeqOf((s).Select(uint32(_1_i)).(interface{})))
		}
	}
	res = m_Wrappers.Companion_Result_.Create_Success_(_0_rs)
	return res
	return res
}
func (_static *CompanionStruct_Default___) ReduceToSuccess(action ActionWithResult, s _dafny.Sequence) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Result{}
	_ = res
	var _0_attemptedResults _dafny.Sequence
	_ = _0_attemptedResults
	_0_attemptedResults = _dafny.SeqOf()
	var _hi0 uint64 = uint64((s).Cardinality())
	_ = _hi0
	for _1_i := uint64(0); _1_i < _hi0; _1_i++ {
		var _2_attempt m_Wrappers.Result
		_ = _2_attempt
		var _out0 interface{}
		_ = _out0
		_out0 = (action).Invoke((s).Select(uint32(_1_i)).(interface{}))
		_2_attempt = _out0.(m_Wrappers.Result)
		_0_attemptedResults = _dafny.Companion_Sequence_.Concatenate(_0_attemptedResults, _dafny.SeqOf(_2_attempt))
		if (_2_attempt).Is_Success() {
			var _rhs0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Create_Success_((_2_attempt).Dtor_value())
			_ = _rhs0
			res = _rhs0
			return res
		}
	}
	res = m_Wrappers.Companion_Result_.Create_Failure_(m_Seq.Companion_Default___.Map(func(coer26 func(m_Wrappers.Result) interface{}) func(interface{}) interface{} {
		return func(arg29 interface{}) interface{} {
			return coer26(arg29.(m_Wrappers.Result))
		}
	}(func(coer27 func(m_Wrappers.Result) interface{}) func(m_Wrappers.Result) interface{} {
		return func(arg30 m_Wrappers.Result) interface{} {
			return coer27(arg30)
		}
	}(Companion_Default___.PluckErrors)), _0_attemptedResults))
	return res
}
func (_static *CompanionStruct_Default___) PluckErrors(r m_Wrappers.Result) interface{} {
	return (r).Dtor_error()
}

// End of class Default__

// Definition of datatype ActionInvoke
type ActionInvoke struct {
	Data_ActionInvoke_
}

func (_this ActionInvoke) Get_() Data_ActionInvoke_ {
	return _this.Data_ActionInvoke_
}

type Data_ActionInvoke_ interface {
	isActionInvoke()
}

type CompanionStruct_ActionInvoke_ struct {
}

var Companion_ActionInvoke_ = CompanionStruct_ActionInvoke_{}

type ActionInvoke_ActionInvoke struct {
	Input  interface{}
	Output interface{}
}

func (ActionInvoke_ActionInvoke) isActionInvoke() {}

func (CompanionStruct_ActionInvoke_) Create_ActionInvoke_(Input interface{}, Output interface{}) ActionInvoke {
	return ActionInvoke{ActionInvoke_ActionInvoke{Input, Output}}
}

func (_this ActionInvoke) Is_ActionInvoke() bool {
	_, ok := _this.Get_().(ActionInvoke_ActionInvoke)
	return ok
}

func (CompanionStruct_ActionInvoke_) Default(_default_A interface{}, _default_R interface{}) ActionInvoke {
	return Companion_ActionInvoke_.Create_ActionInvoke_(_default_A, _default_R)
}

func (_this ActionInvoke) Dtor_input() interface{} {
	return _this.Get_().(ActionInvoke_ActionInvoke).Input
}

func (_this ActionInvoke) Dtor_output() interface{} {
	return _this.Get_().(ActionInvoke_ActionInvoke).Output
}

func (_this ActionInvoke) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ActionInvoke_ActionInvoke:
		{
			return "Actions.ActionInvoke.ActionInvoke" + "(" + _dafny.String(data.Input) + ", " + _dafny.String(data.Output) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ActionInvoke) Equals(other ActionInvoke) bool {
	switch data1 := _this.Get_().(type) {
	case ActionInvoke_ActionInvoke:
		{
			data2, ok := other.Get_().(ActionInvoke_ActionInvoke)
			return ok && _dafny.AreEqual(data1.Input, data2.Input) && _dafny.AreEqual(data1.Output, data2.Output)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ActionInvoke) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ActionInvoke)
	return ok && _this.Equals(typed)
}

func Type_ActionInvoke_(Type_A_ _dafny.TypeDescriptor, Type_R_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_ActionInvoke_{Type_A_, Type_R_}
}

type type_ActionInvoke_ struct {
	Type_A_ _dafny.TypeDescriptor
	Type_R_ _dafny.TypeDescriptor
}

func (_this type_ActionInvoke_) Default() interface{} {
	Type_A_ := _this.Type_A_
	_ = Type_A_
	Type_R_ := _this.Type_R_
	_ = Type_R_
	return Companion_ActionInvoke_.Default(Type_A_.Default(), Type_R_.Default())
}

func (_this type_ActionInvoke_) String() string {
	return "Actions.ActionInvoke"
}
func (_this ActionInvoke) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ActionInvoke{}

// End of datatype ActionInvoke

// Definition of trait Action
type Action interface {
	String() string
	Invoke(a interface{}) interface{}
}
type CompanionStruct_Action_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_Action_ = CompanionStruct_Action_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_Action_) CastTo_(x interface{}) Action {
	var t Action
	t, _ = x.(Action)
	return t
}

// End of trait Action

// Definition of trait ActionWithResult
type ActionWithResult interface {
	String() string
	Invoke(a interface{}) interface{}
}
type CompanionStruct_ActionWithResult_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_ActionWithResult_ = CompanionStruct_ActionWithResult_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_ActionWithResult_) CastTo_(x interface{}) ActionWithResult {
	var t ActionWithResult
	t, _ = x.(ActionWithResult)
	return t
}

// End of trait ActionWithResult

// Definition of trait DeterministicAction
type DeterministicAction interface {
	String() string
	Invoke(a interface{}) interface{}
}
type CompanionStruct_DeterministicAction_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_DeterministicAction_ = CompanionStruct_DeterministicAction_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_DeterministicAction_) CastTo_(x interface{}) DeterministicAction {
	var t DeterministicAction
	t, _ = x.(DeterministicAction)
	return t
}

// End of trait DeterministicAction

// Definition of trait DeterministicActionWithResult
type DeterministicActionWithResult interface {
	String() string
	Invoke(a interface{}) interface{}
}
type CompanionStruct_DeterministicActionWithResult_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_DeterministicActionWithResult_ = CompanionStruct_DeterministicActionWithResult_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_DeterministicActionWithResult_) CastTo_(x interface{}) DeterministicActionWithResult {
	var t DeterministicActionWithResult
	t, _ = x.(DeterministicActionWithResult)
	return t
}

// End of trait DeterministicActionWithResult
