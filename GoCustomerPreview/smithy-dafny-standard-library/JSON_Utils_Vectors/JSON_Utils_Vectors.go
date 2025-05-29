// Package JSON_Utils_Vectors
// Dafny module JSON_Utils_Vectors compiled into Go

package JSON_Utils_Vectors

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
	m_JSON_Utils_Cursors "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Cursors"
	m_JSON_Utils_Lexers_Core "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Lexers_Core"
	m_JSON_Utils_Lexers_Strings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Lexers_Strings"
	m_JSON_Utils_Parsers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Parsers"
	m_JSON_Utils_Seq "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Seq"
	m_JSON_Utils_Str "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Str"
	m_JSON_Utils_Str_CharStrConversion "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Str_CharStrConversion"
	m_JSON_Utils_Str_CharStrEscaping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Str_CharStrEscaping"
	m_JSON_Utils_Views_Core "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Views_Core"
	m_JSON_Utils_Views_Writers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Views_Writers"
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
	return "JSON_Utils_Vectors.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) OOM__FAILURE() m_Wrappers.Outcome {
	return m_Wrappers.Companion_Outcome_.Create_Fail_(Companion_VectorError_.Create_OutOfMemory_())
}

// End of class Default__

// Definition of datatype VectorError
type VectorError struct {
	Data_VectorError_
}

func (_this VectorError) Get_() Data_VectorError_ {
	return _this.Data_VectorError_
}

type Data_VectorError_ interface {
	isVectorError()
}

type CompanionStruct_VectorError_ struct {
}

var Companion_VectorError_ = CompanionStruct_VectorError_{}

type VectorError_OutOfMemory struct {
}

func (VectorError_OutOfMemory) isVectorError() {}

func (CompanionStruct_VectorError_) Create_OutOfMemory_() VectorError {
	return VectorError{VectorError_OutOfMemory{}}
}

func (_this VectorError) Is_OutOfMemory() bool {
	_, ok := _this.Get_().(VectorError_OutOfMemory)
	return ok
}

func (CompanionStruct_VectorError_) Default() VectorError {
	return Companion_VectorError_.Create_OutOfMemory_()
}

func (_ CompanionStruct_VectorError_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_VectorError_.Create_OutOfMemory_(), true
		default:
			return VectorError{}, false
		}
	}
}

func (_this VectorError) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case VectorError_OutOfMemory:
		{
			return "Vectors.VectorError.OutOfMemory"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this VectorError) Equals(other VectorError) bool {
	switch _this.Get_().(type) {
	case VectorError_OutOfMemory:
		{
			_, ok := other.Get_().(VectorError_OutOfMemory)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this VectorError) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(VectorError)
	return ok && _this.Equals(typed)
}

func Type_VectorError_() _dafny.TypeDescriptor {
	return type_VectorError_{}
}

type type_VectorError_ struct {
}

func (_this type_VectorError_) Default() interface{} {
	return Companion_VectorError_.Default()
}

func (_this type_VectorError_) String() string {
	return "JSON_Utils_Vectors.VectorError"
}
func (_this VectorError) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = VectorError{}

// End of datatype VectorError

// Definition of class Vector
type Vector struct {
	Size     uint32
	Capacity uint32
	Data     _dafny.Array
	_a       interface{}
}

func New_Vector_() *Vector {
	_this := Vector{}

	_this.Size = uint32(0)
	_this.Capacity = uint32(0)
	_this.Data = _dafny.NewArrayWithValue(nil, _dafny.IntOf(0))
	_this._a = (interface{})(nil)
	return &_this
}

type CompanionStruct_Vector_ struct {
}

var Companion_Vector_ = CompanionStruct_Vector_{}

func (_this *Vector) Equals(other *Vector) bool {
	return _this == other
}

func (_this *Vector) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*Vector)
	return ok && _this.Equals(other)
}

func (*Vector) String() string {
	return "JSON_Utils_Vectors.Vector"
}

func Type_Vector_(Type_A_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_Vector_{Type_A_}
}

type type_Vector_ struct {
	Type_A_ _dafny.TypeDescriptor
}

func (_this type_Vector_) Default() interface{} {
	return (*Vector)(nil)
}

func (_this type_Vector_) String() string {
	return "JSON_Utils_Vectors.Vector"
}
func (_this *Vector) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Vector{}

func (_this *Vector) Ctor__(a0 interface{}, initial__capacity uint32) {
	{
		(_this)._a = a0
		(_this).Size = uint32(0)
		(_this).Capacity = initial__capacity
		var _len0_0 _dafny.Int = _dafny.IntOfAny(initial__capacity)
		_ = _len0_0
		var _nw0 _dafny.Array
		_ = _nw0
		if _len0_0.Cmp(_dafny.Zero) == 0 {
			_nw0 = _dafny.NewArray(_len0_0)
		} else {
			var _init0 func(_dafny.Int) interface{} = (func(_0_a0 interface{}) func(_dafny.Int) interface{} {
				return func(_1___v0 _dafny.Int) interface{} {
					return _0_a0
				}
			})(a0)
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
		(_this).Data = _nw0
	}
}
func (_this *Vector) At(idx uint32) interface{} {
	{
		return (_this.Data).ArrayGet1(int(idx))
	}
}
func (_this *Vector) Top() interface{} {
	{
		return (_this.Data).ArrayGet1(int((_this.Size) - (func() uint32 { return (uint32(1)) })()))
	}
}
func (_this *Vector) Put(idx uint32, a interface{}) {
	{
		var _arr0 _dafny.Array = _this.Data
		_ = _arr0
		(_arr0).ArraySet1(a, int((idx)))
	}
}
func (_this *Vector) CopyFrom(new__data _dafny.Array, count uint32) {
	{
		var _hi0 uint32 = count
		_ = _hi0
		for _0_idx := uint32(0); _0_idx < _hi0; _0_idx++ {
			var _arr0 _dafny.Array = _this.Data
			_ = _arr0
			(_arr0).ArraySet1((new__data).ArrayGet1(int(_0_idx)), int((_0_idx)))
		}
	}
}
func (_this *Vector) Realloc(new__capacity uint32) {
	{
		var _0_old__data _dafny.Array
		_ = _0_old__data
		var _1_old__capacity uint32
		_ = _1_old__capacity
		var _rhs0 _dafny.Array = _this.Data
		_ = _rhs0
		var _rhs1 uint32 = _this.Capacity
		_ = _rhs1
		_0_old__data = _rhs0
		_1_old__capacity = _rhs1
		var _len0_0 _dafny.Int = _dafny.IntOfAny(new__capacity)
		_ = _len0_0
		var _nw0 _dafny.Array
		_ = _nw0
		if _len0_0.Cmp(_dafny.Zero) == 0 {
			_nw0 = _dafny.NewArray(_len0_0)
		} else {
			var _init0 func(_dafny.Int) interface{} = func(_2___v1 _dafny.Int) interface{} {
				return (_this).A()
			}
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
		var _rhs2 _dafny.Array = _nw0
		_ = _rhs2
		var _rhs3 uint32 = new__capacity
		_ = _rhs3
		var _lhs0 *Vector = _this
		_ = _lhs0
		var _lhs1 *Vector = _this
		_ = _lhs1
		_lhs0.Data = _rhs2
		_lhs1.Capacity = _rhs3
		(_this).CopyFrom(_0_old__data, _1_old__capacity)
	}
}
func (_this *Vector) DefaultNewCapacity(capacity uint32) uint32 {
	{
		if (capacity) < ((_this).MAX__CAPACITY__BEFORE__DOUBLING()) {
			return (uint32(2)) * (capacity)
		} else {
			return (_this).MAX__CAPACITY()
		}
	}
}
func (_this *Vector) ReallocDefault() m_Wrappers.Outcome {
	{
		var o m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = o
		if (_this.Capacity) == ((_this).MAX__CAPACITY()) {
			o = m_Wrappers.Companion_Outcome_.Create_Fail_(Companion_VectorError_.Create_OutOfMemory_())
			return o
		}
		(_this).Realloc((_this).DefaultNewCapacity(_this.Capacity))
		o = m_Wrappers.Companion_Outcome_.Create_Pass_()
		return o
		return o
	}
}
func (_this *Vector) Ensure(reserved uint32) m_Wrappers.Outcome {
	{
		var o m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = o
		if (reserved) > (((_this).MAX__CAPACITY()) - (func() uint32 { return (_this.Size) })()) {
			o = m_Wrappers.Companion_Outcome_.Create_Fail_(Companion_VectorError_.Create_OutOfMemory_())
			return o
		}
		if (reserved) <= ((_this.Capacity) - (func() uint32 { return (_this.Size) })()) {
			o = m_Wrappers.Companion_Outcome_.Create_Pass_()
			return o
		}
		var _0_new__capacity uint32
		_ = _0_new__capacity
		_0_new__capacity = _this.Capacity
		for (reserved) > ((_0_new__capacity) - (func() uint32 { return (_this.Size) })()) {
			_0_new__capacity = (_this).DefaultNewCapacity(_0_new__capacity)
		}
		(_this).Realloc(_0_new__capacity)
		o = m_Wrappers.Companion_Outcome_.Create_Pass_()
		return o
		return o
	}
}
func (_this *Vector) PopFast() {
	{
		(_this).Size = (_this.Size) - (func() uint32 { return (uint32(1)) })()
	}
}
func (_this *Vector) PushFast(a interface{}) {
	{
		var _arr0 _dafny.Array = _this.Data
		_ = _arr0
		var _index0 uint32 = _this.Size
		_ = _index0
		(_arr0).ArraySet1(a, int(_index0))
		(_this).Size = (_this.Size) + (uint32(1))
	}
}
func (_this *Vector) Push(a interface{}) m_Wrappers.Outcome {
	{
		var o m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = o
		if (_this.Size) == (_this.Capacity) {
			var _0_d m_Wrappers.Outcome
			_ = _0_d
			var _out0 m_Wrappers.Outcome
			_ = _out0
			_out0 = (_this).ReallocDefault()
			_0_d = _out0
			if (_0_d).Is_Fail() {
				o = _0_d
				return o
			}
		}
		(_this).PushFast(a)
		o = m_Wrappers.Companion_Outcome_.Create_Pass_()
		return o
		return o
	}
}
func (_this *Vector) A() interface{} {
	{
		return _this._a
	}
}
func (_this *Vector) MAX__CAPACITY__BEFORE__DOUBLING() uint32 {
	{
		return (m_BoundedInts.Companion_Default___.UINT32__MAX()) / (uint32(2))
	}
}
func (_this *Vector) MAX__CAPACITY() uint32 {
	{
		return m_BoundedInts.Companion_Default___.UINT32__MAX()
	}
}

// End of class Vector
