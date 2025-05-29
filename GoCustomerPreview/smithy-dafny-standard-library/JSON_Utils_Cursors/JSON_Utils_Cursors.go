// Package JSON_Utils_Cursors
// Dafny module JSON_Utils_Cursors compiled into Go

package JSON_Utils_Cursors

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
	m_JSON_Utils_Lexers_Core "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Lexers_Core"
	m_JSON_Utils_Lexers_Strings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Lexers_Strings"
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

type Dummy__ struct{}

// Definition of datatype Split
type Split struct {
	Data_Split_
}

func (_this Split) Get_() Data_Split_ {
	return _this.Data_Split_
}

type Data_Split_ interface {
	isSplit()
}

type CompanionStruct_Split_ struct {
}

var Companion_Split_ = CompanionStruct_Split_{}

type Split_SP struct {
	T  interface{}
	Cs Cursor__
}

func (Split_SP) isSplit() {}

func (CompanionStruct_Split_) Create_SP_(T interface{}, Cs Cursor__) Split {
	return Split{Split_SP{T, Cs}}
}

func (_this Split) Is_SP() bool {
	_, ok := _this.Get_().(Split_SP)
	return ok
}

func (CompanionStruct_Split_) Default(_default_T interface{}) Split {
	return Companion_Split_.Create_SP_(_default_T, Companion_FreshCursor_.Witness())
}

func (_this Split) Dtor_t() interface{} {
	return _this.Get_().(Split_SP).T
}

func (_this Split) Dtor_cs() Cursor__ {
	return _this.Get_().(Split_SP).Cs
}

func (_this Split) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Split_SP:
		{
			return "Cursors.Split.SP" + "(" + _dafny.String(data.T) + ", " + _dafny.String(data.Cs) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Split) Equals(other Split) bool {
	switch data1 := _this.Get_().(type) {
	case Split_SP:
		{
			data2, ok := other.Get_().(Split_SP)
			return ok && _dafny.AreEqual(data1.T, data2.T) && data1.Cs.Equals(data2.Cs)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Split) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Split)
	return ok && _this.Equals(typed)
}

func Type_Split_(Type_T_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_Split_{Type_T_}
}

type type_Split_ struct {
	Type_T_ _dafny.TypeDescriptor
}

func (_this type_Split_) Default() interface{} {
	Type_T_ := _this.Type_T_
	_ = Type_T_
	return Companion_Split_.Default(Type_T_.Default())
}

func (_this type_Split_) String() string {
	return "JSON_Utils_Cursors.Split"
}
func (_this Split) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Split{}

// End of datatype Split

// Definition of class Cursor
type Cursor struct {
}

func New_Cursor_() *Cursor {
	_this := Cursor{}

	return &_this
}

type CompanionStruct_Cursor_ struct {
}

var Companion_Cursor_ = CompanionStruct_Cursor_{}

func (*Cursor) String() string {
	return "JSON_Utils_Cursors.Cursor"
}
func (_this *CompanionStruct_Cursor_) Witness() Cursor__ {
	return Companion_Cursor___.Create_Cursor_(_dafny.SeqOf(), uint32(0), uint32(0), uint32(0))
}

// End of class Cursor

func Type_Cursor_() _dafny.TypeDescriptor {
	return type_Cursor_{}
}

type type_Cursor_ struct {
}

func (_this type_Cursor_) Default() interface{} {
	return Companion_Cursor_.Witness()
}

func (_this type_Cursor_) String() string {
	return "JSON_Utils_Cursors.Cursor"
}

// Definition of class FreshCursor
type FreshCursor struct {
}

func New_FreshCursor_() *FreshCursor {
	_this := FreshCursor{}

	return &_this
}

type CompanionStruct_FreshCursor_ struct {
}

var Companion_FreshCursor_ = CompanionStruct_FreshCursor_{}

func (*FreshCursor) String() string {
	return "JSON_Utils_Cursors.FreshCursor"
}
func (_this *CompanionStruct_FreshCursor_) Witness() Cursor__ {
	return Companion_Cursor___.Create_Cursor_(_dafny.SeqOf(), uint32(0), uint32(0), uint32(0))
}

// End of class FreshCursor

func Type_FreshCursor_() _dafny.TypeDescriptor {
	return type_FreshCursor_{}
}

type type_FreshCursor_ struct {
}

func (_this type_FreshCursor_) Default() interface{} {
	return Companion_FreshCursor_.Witness()
}

func (_this type_FreshCursor_) String() string {
	return "JSON_Utils_Cursors.FreshCursor"
}

// Definition of datatype CursorError
type CursorError struct {
	Data_CursorError_
}

func (_this CursorError) Get_() Data_CursorError_ {
	return _this.Data_CursorError_
}

type Data_CursorError_ interface {
	isCursorError()
}

type CompanionStruct_CursorError_ struct {
}

var Companion_CursorError_ = CompanionStruct_CursorError_{}

type CursorError_EOF struct {
}

func (CursorError_EOF) isCursorError() {}

func (CompanionStruct_CursorError_) Create_EOF_() CursorError {
	return CursorError{CursorError_EOF{}}
}

func (_this CursorError) Is_EOF() bool {
	_, ok := _this.Get_().(CursorError_EOF)
	return ok
}

type CursorError_ExpectingByte struct {
	Expected uint8
	B        int16
}

func (CursorError_ExpectingByte) isCursorError() {}

func (CompanionStruct_CursorError_) Create_ExpectingByte_(Expected uint8, B int16) CursorError {
	return CursorError{CursorError_ExpectingByte{Expected, B}}
}

func (_this CursorError) Is_ExpectingByte() bool {
	_, ok := _this.Get_().(CursorError_ExpectingByte)
	return ok
}

type CursorError_ExpectingAnyByte struct {
	Expected__sq _dafny.Sequence
	B            int16
}

func (CursorError_ExpectingAnyByte) isCursorError() {}

func (CompanionStruct_CursorError_) Create_ExpectingAnyByte_(Expected__sq _dafny.Sequence, B int16) CursorError {
	return CursorError{CursorError_ExpectingAnyByte{Expected__sq, B}}
}

func (_this CursorError) Is_ExpectingAnyByte() bool {
	_, ok := _this.Get_().(CursorError_ExpectingAnyByte)
	return ok
}

type CursorError_OtherError struct {
	Err interface{}
}

func (CursorError_OtherError) isCursorError() {}

func (CompanionStruct_CursorError_) Create_OtherError_(Err interface{}) CursorError {
	return CursorError{CursorError_OtherError{Err}}
}

func (_this CursorError) Is_OtherError() bool {
	_, ok := _this.Get_().(CursorError_OtherError)
	return ok
}

func (CompanionStruct_CursorError_) Default() CursorError {
	return Companion_CursorError_.Create_EOF_()
}

func (_this CursorError) Dtor_expected() uint8 {
	return _this.Get_().(CursorError_ExpectingByte).Expected
}

func (_this CursorError) Dtor_b() int16 {
	switch data := _this.Get_().(type) {
	case CursorError_ExpectingByte:
		return data.B
	default:
		return data.(CursorError_ExpectingAnyByte).B
	}
}

func (_this CursorError) Dtor_expected__sq() _dafny.Sequence {
	return _this.Get_().(CursorError_ExpectingAnyByte).Expected__sq
}

func (_this CursorError) Dtor_err() interface{} {
	return _this.Get_().(CursorError_OtherError).Err
}

func (_this CursorError) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CursorError_EOF:
		{
			return "Cursors.CursorError.EOF"
		}
	case CursorError_ExpectingByte:
		{
			return "Cursors.CursorError.ExpectingByte" + "(" + _dafny.String(data.Expected) + ", " + _dafny.String(data.B) + ")"
		}
	case CursorError_ExpectingAnyByte:
		{
			return "Cursors.CursorError.ExpectingAnyByte" + "(" + _dafny.String(data.Expected__sq) + ", " + _dafny.String(data.B) + ")"
		}
	case CursorError_OtherError:
		{
			return "Cursors.CursorError.OtherError" + "(" + _dafny.String(data.Err) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CursorError) Equals(other CursorError) bool {
	switch data1 := _this.Get_().(type) {
	case CursorError_EOF:
		{
			_, ok := other.Get_().(CursorError_EOF)
			return ok
		}
	case CursorError_ExpectingByte:
		{
			data2, ok := other.Get_().(CursorError_ExpectingByte)
			return ok && data1.Expected == data2.Expected && data1.B == data2.B
		}
	case CursorError_ExpectingAnyByte:
		{
			data2, ok := other.Get_().(CursorError_ExpectingAnyByte)
			return ok && data1.Expected__sq.Equals(data2.Expected__sq) && data1.B == data2.B
		}
	case CursorError_OtherError:
		{
			data2, ok := other.Get_().(CursorError_OtherError)
			return ok && _dafny.AreEqual(data1.Err, data2.Err)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CursorError) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CursorError)
	return ok && _this.Equals(typed)
}

func Type_CursorError_() _dafny.TypeDescriptor {
	return type_CursorError_{}
}

type type_CursorError_ struct {
}

func (_this type_CursorError_) Default() interface{} {
	return Companion_CursorError_.Default()
}

func (_this type_CursorError_) String() string {
	return "JSON_Utils_Cursors.CursorError"
}
func (_this CursorError) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CursorError{}

func (_this CursorError) ToString(pr func(interface{}) _dafny.Sequence) _dafny.Sequence {
	{
		var _source0 CursorError = _this
		_ = _source0
		{
			if _source0.Is_EOF() {
				return _dafny.SeqOfString("Reached EOF")
			}
		}
		{
			if _source0.Is_ExpectingByte() {
				var _0_b0 uint8 = _source0.Get_().(CursorError_ExpectingByte).Expected
				_ = _0_b0
				var _1_b int16 = _source0.Get_().(CursorError_ExpectingByte).B
				_ = _1_b
				var _2_c _dafny.Sequence = (func() _dafny.Sequence {
					if (_1_b) > (int16(0)) {
						return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("'"), _dafny.SeqOfChars(_dafny.Char((_1_b)))), _dafny.SeqOfString("'"))
					}
					return _dafny.SeqOfString("EOF")
				})()
				_ = _2_c
				return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Expecting '"), _dafny.SeqOfChars(_dafny.Char((_0_b0)))), _dafny.SeqOfString("', read ")), _2_c)
			}
		}
		{
			if _source0.Is_ExpectingAnyByte() {
				var _3_bs0 _dafny.Sequence = _source0.Get_().(CursorError_ExpectingAnyByte).Expected__sq
				_ = _3_bs0
				var _4_b int16 = _source0.Get_().(CursorError_ExpectingAnyByte).B
				_ = _4_b
				var _5_c _dafny.Sequence = (func() _dafny.Sequence {
					if (_4_b) > (int16(0)) {
						return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("'"), _dafny.SeqOfChars(_dafny.Char((_4_b)))), _dafny.SeqOfString("'"))
					}
					return _dafny.SeqOfString("EOF")
				})()
				_ = _5_c
				var _6_c0s _dafny.Sequence = _dafny.SeqCreate((_dafny.IntOfUint32((_3_bs0).Cardinality())).Uint32(), func(coer29 func(_dafny.Int) _dafny.Char) func(_dafny.Int) interface{} {
					return func(arg32 _dafny.Int) interface{} {
						return coer29(arg32)
					}
				}((func(_7_bs0 _dafny.Sequence) func(_dafny.Int) _dafny.Char {
					return func(_8_idx _dafny.Int) _dafny.Char {
						return _dafny.Char(((_7_bs0).Select((_8_idx).Uint32()).(uint8)))
					}
				})(_3_bs0))).SetString()
				_ = _6_c0s
				return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Expecting one of '"), _6_c0s), _dafny.SeqOfString("', read ")), _5_c)
			}
		}
		{
			var _9_err interface{} = _source0.Get_().(CursorError_OtherError).Err
			_ = _9_err
			return (pr)(_9_err)
		}
	}
}

// End of datatype CursorError

// Definition of datatype Cursor__
type Cursor__ struct {
	Data_Cursor___
}

func (_this Cursor__) Get_() Data_Cursor___ {
	return _this.Data_Cursor___
}

type Data_Cursor___ interface {
	isCursor__()
}

type CompanionStruct_Cursor___ struct {
}

var Companion_Cursor___ = CompanionStruct_Cursor___{}

type Cursor___Cursor struct {
	S     _dafny.Sequence
	Beg   uint32
	Point uint32
	End   uint32
}

func (Cursor___Cursor) isCursor__() {}

func (CompanionStruct_Cursor___) Create_Cursor_(S _dafny.Sequence, Beg uint32, Point uint32, End uint32) Cursor__ {
	return Cursor__{Cursor___Cursor{S, Beg, Point, End}}
}

func (_this Cursor__) Is_Cursor() bool {
	_, ok := _this.Get_().(Cursor___Cursor)
	return ok
}

func (CompanionStruct_Cursor___) Default() Cursor__ {
	return Companion_Cursor___.Create_Cursor_(_dafny.EmptySeq, uint32(0), uint32(0), uint32(0))
}

func (_this Cursor__) Dtor_s() _dafny.Sequence {
	return _this.Get_().(Cursor___Cursor).S
}

func (_this Cursor__) Dtor_beg() uint32 {
	return _this.Get_().(Cursor___Cursor).Beg
}

func (_this Cursor__) Dtor_point() uint32 {
	return _this.Get_().(Cursor___Cursor).Point
}

func (_this Cursor__) Dtor_end() uint32 {
	return _this.Get_().(Cursor___Cursor).End
}

func (_this Cursor__) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Cursor___Cursor:
		{
			return "Cursors.Cursor_.Cursor" + "(" + _dafny.String(data.S) + ", " + _dafny.String(data.Beg) + ", " + _dafny.String(data.Point) + ", " + _dafny.String(data.End) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Cursor__) Equals(other Cursor__) bool {
	switch data1 := _this.Get_().(type) {
	case Cursor___Cursor:
		{
			data2, ok := other.Get_().(Cursor___Cursor)
			return ok && data1.S.Equals(data2.S) && data1.Beg == data2.Beg && data1.Point == data2.Point && data1.End == data2.End
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Cursor__) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Cursor__)
	return ok && _this.Equals(typed)
}

func Type_Cursor___() _dafny.TypeDescriptor {
	return type_Cursor___{}
}

type type_Cursor___ struct {
}

func (_this type_Cursor___) Default() interface{} {
	return Companion_Cursor___.Default()
}

func (_this type_Cursor___) String() string {
	return "JSON_Utils_Cursors.Cursor__"
}
func (_this Cursor__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Cursor__{}

func (_static CompanionStruct_Cursor___) OfView(v m_JSON_Utils_Views_Core.View__) Cursor__ {
	return Companion_Cursor___.Create_Cursor_((v).Dtor_s(), (v).Dtor_beg(), (v).Dtor_beg(), (v).Dtor_end())
}
func (_static CompanionStruct_Cursor___) OfBytes(bs _dafny.Sequence) Cursor__ {
	return Companion_Cursor___.Create_Cursor_(bs, uint32(0), uint32(0), uint32((bs).Cardinality()))
}
func (_this Cursor__) Bytes() _dafny.Sequence {
	{
		return ((_this).Dtor_s()).Subsequence(uint32((_this).Dtor_beg()), uint32((_this).Dtor_end()))
	}
}
func (_this Cursor__) Prefix() m_JSON_Utils_Views_Core.View__ {
	{
		return m_JSON_Utils_Views_Core.Companion_View___.Create_View_((_this).Dtor_s(), (_this).Dtor_beg(), (_this).Dtor_point())
	}
}
func (_this Cursor__) Suffix() Cursor__ {
	{
		var _0_dt__update__tmp_h0 Cursor__ = _this
		_ = _0_dt__update__tmp_h0
		var _1_dt__update_hbeg_h0 uint32 = (_this).Dtor_point()
		_ = _1_dt__update_hbeg_h0
		return Companion_Cursor___.Create_Cursor_((_0_dt__update__tmp_h0).Dtor_s(), _1_dt__update_hbeg_h0, (_0_dt__update__tmp_h0).Dtor_point(), (_0_dt__update__tmp_h0).Dtor_end())
	}
}
func (_this Cursor__) Split() Split {
	{
		return Companion_Split_.Create_SP_((_this).Prefix(), (_this).Suffix())
	}
}
func (_this Cursor__) PrefixLength() uint32 {
	{
		return ((_this).Dtor_point()) - (func() uint32 { return ((_this).Dtor_beg()) })()
	}
}
func (_this Cursor__) SuffixLength() uint32 {
	{
		return ((_this).Dtor_end()) - (func() uint32 { return ((_this).Dtor_point()) })()
	}
}
func (_this Cursor__) Length() uint32 {
	{
		return ((_this).Dtor_end()) - (func() uint32 { return ((_this).Dtor_beg()) })()
	}
}
func (_this Cursor__) At(idx uint32) uint8 {
	{
		return ((_this).Dtor_s()).Select(uint32(((_this).Dtor_beg()) + (idx))).(uint8)
	}
}
func (_this Cursor__) SuffixAt(idx uint32) uint8 {
	{
		return ((_this).Dtor_s()).Select(uint32(((_this).Dtor_point()) + (idx))).(uint8)
	}
}
func (_this Cursor__) Peek() int16 {
	{
		if (_this).EOF_q() {
			return int16(-1)
		} else {
			return int16((_this).SuffixAt(uint32(0)))
		}
	}
}
func (_this Cursor__) LookingAt(c _dafny.Char) bool {
	{
		return ((_this).Peek()) == (int16(c))
	}
}
func (_this Cursor__) Skip(n uint32) Cursor__ {
	{
		var _0_dt__update__tmp_h0 Cursor__ = _this
		_ = _0_dt__update__tmp_h0
		var _1_dt__update_hpoint_h0 uint32 = ((_this).Dtor_point()) + (n)
		_ = _1_dt__update_hpoint_h0
		return Companion_Cursor___.Create_Cursor_((_0_dt__update__tmp_h0).Dtor_s(), (_0_dt__update__tmp_h0).Dtor_beg(), _1_dt__update_hpoint_h0, (_0_dt__update__tmp_h0).Dtor_end())
	}
}
func (_this Cursor__) Unskip(n uint32) Cursor__ {
	{
		var _0_dt__update__tmp_h0 Cursor__ = _this
		_ = _0_dt__update__tmp_h0
		var _1_dt__update_hpoint_h0 uint32 = ((_this).Dtor_point()) - (func() uint32 { return (n) })()
		_ = _1_dt__update_hpoint_h0
		return Companion_Cursor___.Create_Cursor_((_0_dt__update__tmp_h0).Dtor_s(), (_0_dt__update__tmp_h0).Dtor_beg(), _1_dt__update_hpoint_h0, (_0_dt__update__tmp_h0).Dtor_end())
	}
}
func (_this Cursor__) Get(err interface{}) m_Wrappers.Result {
	{
		if (_this).EOF_q() {
			return m_Wrappers.Companion_Result_.Create_Failure_(Companion_CursorError_.Create_OtherError_(err))
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_((_this).Skip(uint32(1)))
		}
	}
}
func (_this Cursor__) AssertByte(b uint8) m_Wrappers.Result {
	{
		var _0_nxt int16 = (_this).Peek()
		_ = _0_nxt
		if (_0_nxt) == (int16(b)) {
			return m_Wrappers.Companion_Result_.Create_Success_((_this).Skip(uint32(1)))
		} else {
			return m_Wrappers.Companion_Result_.Create_Failure_(Companion_CursorError_.Create_ExpectingByte_(b, _0_nxt))
		}
	}
}
func (_this Cursor__) AssertBytes(bs _dafny.Sequence, offset uint32) m_Wrappers.Result {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (offset) == (uint32((bs).Cardinality())) {
			return m_Wrappers.Companion_Result_.Create_Success_(_this)
		} else {
			var _0_valueOrError0 m_Wrappers.Result = (_this).AssertByte((bs).Select(uint32(offset)).(uint8))
			_ = _0_valueOrError0
			if (_0_valueOrError0).IsFailure() {
				return (_0_valueOrError0).PropagateFailure()
			} else {
				var _1_ps Cursor__ = (_0_valueOrError0).Extract().(Cursor__)
				_ = _1_ps
				var _in0 Cursor__ = _1_ps
				_ = _in0
				var _in1 _dafny.Sequence = bs
				_ = _in1
				var _in2 uint32 = (offset) + (uint32(1))
				_ = _in2
				_this = _in0

				bs = _in1
				offset = _in2
				goto TAIL_CALL_START
			}
		}
	}
}
func (_this Cursor__) AssertChar(c0 _dafny.Char) m_Wrappers.Result {
	{
		return (_this).AssertByte(uint8(c0))
	}
}
func (_this Cursor__) SkipByte() Cursor__ {
	{
		if (_this).EOF_q() {
			return _this
		} else {
			return (_this).Skip(uint32(1))
		}
	}
}
func (_this Cursor__) SkipIf(p func(uint8) bool) Cursor__ {
	{
		if ((_this).EOF_q()) || (!((p)((_this).SuffixAt(uint32(0))))) {
			return _this
		} else {
			return (_this).Skip(uint32(1))
		}
	}
}
func (_this Cursor__) SkipWhile(p func(uint8) bool) Cursor__ {
	{
		var ps Cursor__ = Companion_Cursor_.Witness()
		_ = ps
		var _0_point_k uint32
		_ = _0_point_k
		_0_point_k = (_this).Dtor_point()
		var _1_end uint32
		_ = _1_end
		_1_end = (_this).Dtor_end()
		for ((_0_point_k) < (_1_end)) && ((p)(((_this).Dtor_s()).Select(uint32(_0_point_k)).(uint8))) {
			_0_point_k = (_0_point_k) + (uint32(1))
		}
		ps = Companion_Cursor___.Create_Cursor_((_this).Dtor_s(), (_this).Dtor_beg(), _0_point_k, (_this).Dtor_end())
		return ps
		return ps
	}
}
func (_this Cursor__) SkipWhileLexer(step func(interface{}, int16) m_JSON_Utils_Lexers_Core.LexerResult, st interface{}) m_Wrappers.Result {
	{
		var pr m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_Cursor_.Witness())
		_ = pr
		var _0_point_k uint32
		_ = _0_point_k
		_0_point_k = (_this).Dtor_point()
		var _1_end uint32
		_ = _1_end
		_1_end = (_this).Dtor_end()
		var _2_st_k interface{}
		_ = _2_st_k
		_2_st_k = st
		for true {
			var _3_eof bool
			_ = _3_eof
			_3_eof = (_0_point_k) == (_1_end)
			var _4_minusone int16
			_ = _4_minusone
			_4_minusone = int16(-1)
			var _5_c int16
			_ = _5_c
			if _3_eof {
				_5_c = _4_minusone
			} else {
				_5_c = int16(((_this).Dtor_s()).Select(uint32(_0_point_k)).(uint8))
			}
			var _source0 m_JSON_Utils_Lexers_Core.LexerResult = (step)(_2_st_k, _5_c)
			_ = _source0
			{
				{
					if _source0.Is_Accept() {
						pr = m_Wrappers.Companion_Result_.Create_Success_(Companion_Cursor___.Create_Cursor_((_this).Dtor_s(), (_this).Dtor_beg(), _0_point_k, (_this).Dtor_end()))
						return pr
						goto Lmatch0
					}
				}
				{
					if _source0.Is_Reject() {
						var _6_err interface{} = _source0.Get_().(m_JSON_Utils_Lexers_Core.LexerResult_Reject).Err
						_ = _6_err
						pr = m_Wrappers.Companion_Result_.Create_Failure_(Companion_CursorError_.Create_OtherError_(_6_err))
						return pr
						goto Lmatch0
					}
				}
				{
					var _7_st_k_k interface{} = _source0.Get_().(m_JSON_Utils_Lexers_Core.LexerResult_Partial).St
					_ = _7_st_k_k
					if _3_eof {
						pr = m_Wrappers.Companion_Result_.Create_Failure_(Companion_CursorError_.Create_EOF_())
						return pr
					} else {
						_2_st_k = _7_st_k_k
						_0_point_k = (_0_point_k) + (uint32(1))
					}
				}
				goto Lmatch0
			}
		Lmatch0:
		}
		return pr
	}
}
func (_this Cursor__) BOF_q() bool {
	{
		return ((_this).Dtor_point()) == ((_this).Dtor_beg())
	}
}
func (_this Cursor__) EOF_q() bool {
	{
		return ((_this).Dtor_point()) == ((_this).Dtor_end())
	}
}

// End of datatype Cursor__
