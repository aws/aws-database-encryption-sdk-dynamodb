// Package JSON_Utils_Views_Writers
// Dafny module JSON_Utils_Views_Writers compiled into Go

package JSON_Utils_Views_Writers

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
	m_JSON_Utils_Views_Core "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Views_Core"
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

type Dummy__ struct{}

// Definition of datatype Chain
type Chain struct {
	Data_Chain_
}

func (_this Chain) Get_() Data_Chain_ {
	return _this.Data_Chain_
}

type Data_Chain_ interface {
	isChain()
}

type CompanionStruct_Chain_ struct {
}

var Companion_Chain_ = CompanionStruct_Chain_{}

type Chain_Empty struct {
}

func (Chain_Empty) isChain() {}

func (CompanionStruct_Chain_) Create_Empty_() Chain {
	return Chain{Chain_Empty{}}
}

func (_this Chain) Is_Empty() bool {
	_, ok := _this.Get_().(Chain_Empty)
	return ok
}

type Chain_Chain struct {
	Previous Chain
	V        m_JSON_Utils_Views_Core.View__
}

func (Chain_Chain) isChain() {}

func (CompanionStruct_Chain_) Create_Chain_(Previous Chain, V m_JSON_Utils_Views_Core.View__) Chain {
	return Chain{Chain_Chain{Previous, V}}
}

func (_this Chain) Is_Chain() bool {
	_, ok := _this.Get_().(Chain_Chain)
	return ok
}

func (CompanionStruct_Chain_) Default() Chain {
	return Companion_Chain_.Create_Empty_()
}

func (_this Chain) Dtor_previous() Chain {
	return _this.Get_().(Chain_Chain).Previous
}

func (_this Chain) Dtor_v() m_JSON_Utils_Views_Core.View__ {
	return _this.Get_().(Chain_Chain).V
}

func (_this Chain) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Chain_Empty:
		{
			return "Writers.Chain.Empty"
		}
	case Chain_Chain:
		{
			return "Writers.Chain.Chain" + "(" + _dafny.String(data.Previous) + ", " + _dafny.String(data.V) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Chain) Equals(other Chain) bool {
	switch data1 := _this.Get_().(type) {
	case Chain_Empty:
		{
			_, ok := other.Get_().(Chain_Empty)
			return ok
		}
	case Chain_Chain:
		{
			data2, ok := other.Get_().(Chain_Chain)
			return ok && data1.Previous.Equals(data2.Previous) && data1.V.Equals(data2.V)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Chain) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Chain)
	return ok && _this.Equals(typed)
}

func Type_Chain_() _dafny.TypeDescriptor {
	return type_Chain_{}
}

type type_Chain_ struct {
}

func (_this type_Chain_) Default() interface{} {
	return Companion_Chain_.Default()
}

func (_this type_Chain_) String() string {
	return "JSON_Utils_Views_Writers.Chain"
}
func (_this Chain) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Chain{}

func (_this Chain) Length() _dafny.Int {
	{
		var _0___accumulator _dafny.Int = _dafny.Zero
		_ = _0___accumulator
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (_this).Is_Empty() {
			return (_dafny.Zero).Plus(_0___accumulator)
		} else {
			_0___accumulator = (_dafny.IntOfUint32(((_this).Dtor_v()).Length())).Plus(_0___accumulator)
			var _in0 Chain = (_this).Dtor_previous()
			_ = _in0
			_this = _in0

			goto TAIL_CALL_START
		}
	}
}
func (_this Chain) Count() _dafny.Int {
	{
		var _0___accumulator _dafny.Int = _dafny.Zero
		_ = _0___accumulator
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (_this).Is_Empty() {
			return (_dafny.Zero).Plus(_0___accumulator)
		} else {
			_0___accumulator = (_dafny.One).Plus(_0___accumulator)
			var _in0 Chain = (_this).Dtor_previous()
			_ = _in0
			_this = _in0

			goto TAIL_CALL_START
		}
	}
}
func (_this Chain) Bytes() _dafny.Sequence {
	{
		var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
		_ = _0___accumulator
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (_this).Is_Empty() {
			return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf(), _0___accumulator)
		} else {
			_0___accumulator = _dafny.Companion_Sequence_.Concatenate(((_this).Dtor_v()).Bytes(), _0___accumulator)
			var _in0 Chain = (_this).Dtor_previous()
			_ = _in0
			_this = _in0

			goto TAIL_CALL_START
		}
	}
}
func (_this Chain) Append(v_k m_JSON_Utils_Views_Core.View__) Chain {
	{
		if ((_this).Is_Chain()) && (m_JSON_Utils_Views_Core.Companion_Default___.Adjacent((_this).Dtor_v(), v_k)) {
			return Companion_Chain_.Create_Chain_((_this).Dtor_previous(), m_JSON_Utils_Views_Core.Companion_Default___.Merge((_this).Dtor_v(), v_k))
		} else {
			return Companion_Chain_.Create_Chain_(_this, v_k)
		}
	}
}
func (_this Chain) CopyTo(dest _dafny.Array, end uint32) {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (_this).Is_Chain() {
			var _0_end uint32
			_ = _0_end
			_0_end = (end) - (func() uint32 { return (((_this).Dtor_v()).Length()) })()
			((_this).Dtor_v()).CopyTo(dest, _0_end)
			var _in0 Chain = (_this).Dtor_previous()
			_ = _in0
			var _in1 _dafny.Array = dest
			_ = _in1
			var _in2 uint32 = _0_end
			_ = _in2
			_this = _in0

			dest = _in1
			end = _in2
			goto TAIL_CALL_START
		}
	}
}

// End of datatype Chain

// Definition of class Writer
type Writer struct {
}

func New_Writer_() *Writer {
	_this := Writer{}

	return &_this
}

type CompanionStruct_Writer_ struct {
}

var Companion_Writer_ = CompanionStruct_Writer_{}

func (*Writer) String() string {
	return "JSON_Utils_Views_Writers.Writer"
}
func (_this *CompanionStruct_Writer_) Witness() Writer__ {
	return Companion_Writer___.Create_Writer_(uint32(0), Companion_Chain_.Create_Empty_())
}

// End of class Writer

func Type_Writer_() _dafny.TypeDescriptor {
	return type_Writer_{}
}

type type_Writer_ struct {
}

func (_this type_Writer_) Default() interface{} {
	return Companion_Writer_.Witness()
}

func (_this type_Writer_) String() string {
	return "JSON_Utils_Views_Writers.Writer"
}

// Definition of datatype Writer__
type Writer__ struct {
	Data_Writer___
}

func (_this Writer__) Get_() Data_Writer___ {
	return _this.Data_Writer___
}

type Data_Writer___ interface {
	isWriter__()
}

type CompanionStruct_Writer___ struct {
}

var Companion_Writer___ = CompanionStruct_Writer___{}

type Writer___Writer struct {
	Length uint32
	Chain  Chain
}

func (Writer___Writer) isWriter__() {}

func (CompanionStruct_Writer___) Create_Writer_(Length uint32, Chain Chain) Writer__ {
	return Writer__{Writer___Writer{Length, Chain}}
}

func (_this Writer__) Is_Writer() bool {
	_, ok := _this.Get_().(Writer___Writer)
	return ok
}

func (CompanionStruct_Writer___) Default() Writer__ {
	return Companion_Writer___.Create_Writer_(uint32(0), Companion_Chain_.Default())
}

func (_this Writer__) Dtor_length() uint32 {
	return _this.Get_().(Writer___Writer).Length
}

func (_this Writer__) Dtor_chain() Chain {
	return _this.Get_().(Writer___Writer).Chain
}

func (_this Writer__) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Writer___Writer:
		{
			return "Writers.Writer_.Writer" + "(" + _dafny.String(data.Length) + ", " + _dafny.String(data.Chain) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Writer__) Equals(other Writer__) bool {
	switch data1 := _this.Get_().(type) {
	case Writer___Writer:
		{
			data2, ok := other.Get_().(Writer___Writer)
			return ok && data1.Length == data2.Length && data1.Chain.Equals(data2.Chain)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Writer__) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Writer__)
	return ok && _this.Equals(typed)
}

func Type_Writer___() _dafny.TypeDescriptor {
	return type_Writer___{}
}

type type_Writer___ struct {
}

func (_this type_Writer___) Default() interface{} {
	return Companion_Writer___.Default()
}

func (_this type_Writer___) String() string {
	return "JSON_Utils_Views_Writers.Writer__"
}
func (_this Writer__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Writer__{}

func (_this Writer__) Bytes() _dafny.Sequence {
	{
		return ((_this).Dtor_chain()).Bytes()
	}
}
func (_static CompanionStruct_Writer___) SaturatedAddU32(a uint32, b uint32) uint32 {
	if (a) <= ((m_BoundedInts.Companion_Default___.UINT32__MAX()) - (func() uint32 { return (b) })()) {
		return (a) + (b)
	} else {
		return m_BoundedInts.Companion_Default___.UINT32__MAX()
	}
}
func (_this Writer__) Append(v_k m_JSON_Utils_Views_Core.View__) Writer__ {
	{
		return Companion_Writer___.Create_Writer_(Companion_Writer___.SaturatedAddU32((_this).Dtor_length(), (v_k).Length()), ((_this).Dtor_chain()).Append(v_k))
	}
}
func (_this Writer__) Then(fn func(Writer__) Writer__) Writer__ {
	{
		return (fn)(_this)
	}
}
func (_this Writer__) CopyTo(dest _dafny.Array) {
	{
		((_this).Dtor_chain()).CopyTo(dest, (_this).Dtor_length())
	}
}
func (_this Writer__) ToArray() _dafny.Array {
	{
		var bs _dafny.Array = _dafny.NewArrayWithValue(nil, _dafny.IntOf(0))
		_ = bs
		var _nw0 _dafny.Array = _dafny.NewArrayWithValue(uint8(0), _dafny.IntOfAny((_this).Dtor_length()))
		_ = _nw0
		bs = _nw0
		(_this).CopyTo(bs)
		return bs
	}
}
func (_static CompanionStruct_Writer___) Empty() Writer__ {
	return Companion_Writer___.Create_Writer_(uint32(0), Companion_Chain_.Create_Empty_())
}
func (_this Writer__) Unsaturated_q() bool {
	{
		return ((_this).Dtor_length()) != (m_BoundedInts.Companion_Default___.UINT32__MAX()) /* dircomp */
	}
}
func (_this Writer__) Empty_q() bool {
	{
		return ((_this).Dtor_chain()).Is_Empty()
	}
}

// End of datatype Writer__
