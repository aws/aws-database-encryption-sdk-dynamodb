// Package Streams
// Dafny module Streams compiled into Go

package Streams

import (
	os "os"

	m_BoundedInts "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/BoundedInts"
	m_DivInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivInternals"
	m_DivInternalsNonlinear "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivInternalsNonlinear"
	m_DivMod "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivMod"
	m_FileIO "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/FileIO"
	m_Functions "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Functions"
	m_GeneralInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/GeneralInternals"
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
	m_StandardLibrary "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary"
	m_StandardLibraryInterop "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibraryInterop"
	m_StandardLibrary_MemoryMath "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_MemoryMath"
	m_StandardLibrary_Sequence "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_Sequence"
	m_StandardLibrary_String "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_String"
	m_StandardLibrary_UInt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_UInt"
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

type Dummy__ struct{}

// Definition of class SeqReader
type SeqReader struct {
	Pos   uint64
	_data _dafny.Sequence
}

func New_SeqReader_() *SeqReader {
	_this := SeqReader{}

	_this.Pos = uint64(0)
	_this._data = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_SeqReader_ struct {
}

var Companion_SeqReader_ = CompanionStruct_SeqReader_{}

func (_this *SeqReader) Equals(other *SeqReader) bool {
	return _this == other
}

func (_this *SeqReader) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*SeqReader)
	return ok && _this.Equals(other)
}

func (*SeqReader) String() string {
	return "Streams.SeqReader"
}

func Type_SeqReader_(Type_T_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_SeqReader_{Type_T_}
}

type type_SeqReader_ struct {
	Type_T_ _dafny.TypeDescriptor
}

func (_this type_SeqReader_) Default() interface{} {
	return (*SeqReader)(nil)
}

func (_this type_SeqReader_) String() string {
	return "Streams.SeqReader"
}
func (_this *SeqReader) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &SeqReader{}

func (_this *SeqReader) Ctor__(s _dafny.Sequence) {
	{
		(_this)._data = s
		(_this).Pos = uint64(0)
	}
}
func (_this *SeqReader) ReadElements(n uint64) _dafny.Sequence {
	{
		var elems _dafny.Sequence = _dafny.EmptySeq
		_ = elems
		elems = (((_this).Data()).Drop(uint32(_this.Pos))).Take(uint32(n))
		(_this).Pos = m_StandardLibrary_MemoryMath.Companion_Default___.Add(_this.Pos, n)
		elems = elems
		return elems
		return elems
	}
}
func (_this *SeqReader) ReadExact(n uint64) m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = res
		if (n) > ((uint64(((_this).Data()).Cardinality())) - (func() uint64 { return (_this.Pos) })()) {
			res = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("IO Error: Not enough elements left on stream."))
			return res
		} else {
			var _0_elements _dafny.Sequence
			_ = _0_elements
			var _out0 _dafny.Sequence
			_ = _out0
			_out0 = (_this).ReadElements(n)
			_0_elements = _out0
			res = m_Wrappers.Companion_Result_.Create_Success_(_0_elements)
			return res
		}
		return res
	}
}
func (_this *SeqReader) Data() _dafny.Sequence {
	{
		return _this._data
	}
}

// End of class SeqReader

// Definition of class ByteReader
type ByteReader struct {
	_reader *SeqReader
}

func New_ByteReader_() *ByteReader {
	_this := ByteReader{}

	_this._reader = (*SeqReader)(nil)
	return &_this
}

type CompanionStruct_ByteReader_ struct {
}

var Companion_ByteReader_ = CompanionStruct_ByteReader_{}

func (_this *ByteReader) Equals(other *ByteReader) bool {
	return _this == other
}

func (_this *ByteReader) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*ByteReader)
	return ok && _this.Equals(other)
}

func (*ByteReader) String() string {
	return "Streams.ByteReader"
}

func Type_ByteReader_() _dafny.TypeDescriptor {
	return type_ByteReader_{}
}

type type_ByteReader_ struct {
}

func (_this type_ByteReader_) Default() interface{} {
	return (*ByteReader)(nil)
}

func (_this type_ByteReader_) String() string {
	return "Streams.ByteReader"
}
func (_this *ByteReader) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &ByteReader{}

func (_this *ByteReader) Ctor__(s _dafny.Sequence) {
	{
		var _0_mr *SeqReader
		_ = _0_mr
		var _nw0 *SeqReader = New_SeqReader_()
		_ = _nw0
		_nw0.Ctor__(s)
		_0_mr = _nw0
		(_this)._reader = _0_mr
	}
}
func (_this *ByteReader) ReadByte() m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(uint8(0))
		_ = res
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).Reader()).ReadExact(uint64(1))
		_0_valueOrError0 = _out0
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_bytes _dafny.Sequence
		_ = _1_bytes
		_1_bytes = (_0_valueOrError0).Extract().(_dafny.Sequence)
		res = m_Wrappers.Companion_Result_.Create_Success_((_1_bytes).Select(0).(uint8))
		return res
		return res
	}
}
func (_this *ByteReader) ReadBytes(n uint64) m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = res
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).Reader()).ReadExact(n)
		_0_valueOrError0 = _out0
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_bytes _dafny.Sequence
		_ = _1_bytes
		_1_bytes = (_0_valueOrError0).Extract().(_dafny.Sequence)
		res = m_Wrappers.Companion_Result_.Create_Success_(_1_bytes)
		return res
		return res
	}
}
func (_this *ByteReader) ReadUInt16() m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(uint16(0))
		_ = res
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).Reader()).ReadExact(uint64(2))
		_0_valueOrError0 = _out0
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_bytes _dafny.Sequence
		_ = _1_bytes
		_1_bytes = (_0_valueOrError0).Extract().(_dafny.Sequence)
		var _2_n uint16
		_ = _2_n
		_2_n = m_StandardLibrary_UInt.Companion_Default___.SeqToUInt16(_1_bytes)
		res = m_Wrappers.Companion_Result_.Create_Success_(_2_n)
		return res
		return res
	}
}
func (_this *ByteReader) ReadUInt32() m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(uint32(0))
		_ = res
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).Reader()).ReadExact(uint64(4))
		_0_valueOrError0 = _out0
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_bytes _dafny.Sequence
		_ = _1_bytes
		_1_bytes = (_0_valueOrError0).Extract().(_dafny.Sequence)
		var _2_n uint32
		_ = _2_n
		_2_n = m_StandardLibrary_UInt.Companion_Default___.SeqToUInt32(_1_bytes)
		res = m_Wrappers.Companion_Result_.Create_Success_(_2_n)
		return res
		return res
	}
}
func (_this *ByteReader) ReadUInt64() m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(uint64(0))
		_ = res
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).Reader()).ReadExact(uint64(8))
		_0_valueOrError0 = _out0
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_bytes _dafny.Sequence
		_ = _1_bytes
		_1_bytes = (_0_valueOrError0).Extract().(_dafny.Sequence)
		var _2_n uint64
		_ = _2_n
		_2_n = m_StandardLibrary_UInt.Companion_Default___.SeqToUInt64(_1_bytes)
		res = m_Wrappers.Companion_Result_.Create_Success_(_2_n)
		return res
		return res
	}
}
func (_this *ByteReader) IsDoneReading() bool {
	{
		var b bool = false
		_ = b
		b = (uint64((((_this).Reader()).Data()).Cardinality())) == ((_this).Reader().Pos)
		return b
		return b
	}
}
func (_this *ByteReader) GetSizeRead() uint64 {
	{
		var n uint64 = uint64(0)
		_ = n
		n = (_this).Reader().Pos
		return n
		return n
	}
}
func (_this *ByteReader) Reader() *SeqReader {
	{
		return _this._reader
	}
}

// End of class ByteReader

// Definition of class SeqWriter
type SeqWriter struct {
	Data _dafny.Sequence
}

func New_SeqWriter_() *SeqWriter {
	_this := SeqWriter{}

	_this.Data = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_SeqWriter_ struct {
}

var Companion_SeqWriter_ = CompanionStruct_SeqWriter_{}

func (_this *SeqWriter) Equals(other *SeqWriter) bool {
	return _this == other
}

func (_this *SeqWriter) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*SeqWriter)
	return ok && _this.Equals(other)
}

func (*SeqWriter) String() string {
	return "Streams.SeqWriter"
}

func Type_SeqWriter_(Type_T_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_SeqWriter_{Type_T_}
}

type type_SeqWriter_ struct {
	Type_T_ _dafny.TypeDescriptor
}

func (_this type_SeqWriter_) Default() interface{} {
	return (*SeqWriter)(nil)
}

func (_this type_SeqWriter_) String() string {
	return "Streams.SeqWriter"
}
func (_this *SeqWriter) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &SeqWriter{}

func (_this *SeqWriter) Ctor__() {
	{
		(_this).Data = _dafny.SeqOf()
	}
}
func (_this *SeqWriter) WriteElements(elems _dafny.Sequence) uint64 {
	{
		var n uint64 = uint64(0)
		_ = n
		(_this).Data = _dafny.Companion_Sequence_.Concatenate(_this.Data, elems)
		n = uint64((elems).Cardinality())
		return n
		return n
	}
}

// End of class SeqWriter

// Definition of class ByteWriter
type ByteWriter struct {
	_writer *SeqWriter
}

func New_ByteWriter_() *ByteWriter {
	_this := ByteWriter{}

	_this._writer = (*SeqWriter)(nil)
	return &_this
}

type CompanionStruct_ByteWriter_ struct {
}

var Companion_ByteWriter_ = CompanionStruct_ByteWriter_{}

func (_this *ByteWriter) Equals(other *ByteWriter) bool {
	return _this == other
}

func (_this *ByteWriter) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*ByteWriter)
	return ok && _this.Equals(other)
}

func (*ByteWriter) String() string {
	return "Streams.ByteWriter"
}

func Type_ByteWriter_() _dafny.TypeDescriptor {
	return type_ByteWriter_{}
}

type type_ByteWriter_ struct {
}

func (_this type_ByteWriter_) Default() interface{} {
	return (*ByteWriter)(nil)
}

func (_this type_ByteWriter_) String() string {
	return "Streams.ByteWriter"
}
func (_this *ByteWriter) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &ByteWriter{}

func (_this *ByteWriter) Ctor__() {
	{
		var _0_mw *SeqWriter
		_ = _0_mw
		var _nw0 *SeqWriter = New_SeqWriter_()
		_ = _nw0
		_nw0.Ctor__()
		_0_mw = _nw0
		(_this)._writer = _0_mw
	}
}
func (_this *ByteWriter) WriteByte(n uint8) uint64 {
	{
		var r uint64 = uint64(0)
		_ = r
		var _out0 uint64
		_ = _out0
		_out0 = ((_this).Writer()).WriteElements(_dafny.SeqOf(n))
		r = _out0
		return r
	}
}
func (_this *ByteWriter) WriteBytes(s _dafny.Sequence) uint64 {
	{
		var r uint64 = uint64(0)
		_ = r
		var _out0 uint64
		_ = _out0
		_out0 = ((_this).Writer()).WriteElements(s)
		r = _out0
		return r
	}
}
func (_this *ByteWriter) WriteUInt16(n uint16) uint64 {
	{
		var r uint64 = uint64(0)
		_ = r
		var _out0 uint64
		_ = _out0
		_out0 = ((_this).Writer()).WriteElements(m_StandardLibrary_UInt.Companion_Default___.UInt16ToSeq(n))
		r = _out0
		return r
	}
}
func (_this *ByteWriter) WriteUInt32(n uint32) uint64 {
	{
		var r uint64 = uint64(0)
		_ = r
		var _out0 uint64
		_ = _out0
		_out0 = ((_this).Writer()).WriteElements(m_StandardLibrary_UInt.Companion_Default___.UInt32ToSeq(n))
		r = _out0
		return r
	}
}
func (_this *ByteWriter) GetDataWritten() _dafny.Sequence {
	{
		return (_this).Writer().Data
	}
}
func (_this *ByteWriter) GetSizeWritten() uint64 {
	{
		return uint64(((_this).Writer().Data).Cardinality())
	}
}
func (_this *ByteWriter) Writer() *SeqWriter {
	{
		return _this._writer
	}
}

// End of class ByteWriter
