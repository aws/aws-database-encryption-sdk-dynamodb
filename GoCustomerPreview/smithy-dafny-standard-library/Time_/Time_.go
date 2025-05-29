// Package _Time
// Dafny module _Time compiled into Go

package _Time

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
	m_OsLang "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/OsLang"
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
	m_UTF8 "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UTF8"
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
	return "_Time.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) FormatMilli(diff uint64) _dafny.Sequence {
	var _0_whole _dafny.Sequence = m_StandardLibrary_String.Companion_Default___.Base10Int2String(_dafny.IntOfUint64((diff) / (uint64(1000))))
	_ = _0_whole
	var _1_frac _dafny.Sequence = m_StandardLibrary_String.Companion_Default___.Base10Int2String(_dafny.IntOfUint64((diff) % (uint64(1000))))
	_ = _1_frac
	if (_dafny.IntOfUint32((_1_frac).Cardinality())).Cmp(_dafny.One) == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_0_whole, _dafny.SeqOfString(".00")), _1_frac)
	} else if (_dafny.IntOfUint32((_1_frac).Cardinality())).Cmp(_dafny.IntOfInt64(2)) == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_0_whole, _dafny.SeqOfString(".0")), _1_frac)
	} else {
		return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_0_whole, _dafny.SeqOfString(".")), _1_frac)
	}
}
func (_static *CompanionStruct_Default___) FormatMilliDiff(start int64, end int64) _dafny.Sequence {
	if (start) <= (end) {
		return Companion_Default___.FormatMilli(uint64((end) - (start)))
	} else {
		return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("-"), Companion_Default___.FormatMilli(uint64((start)-(end))))
	}
}
func (_static *CompanionStruct_Default___) GetAbsoluteTime() AbsoluteTime {
	var output AbsoluteTime = Companion_AbsoluteTime_.Default()
	_ = output
	var _0_ClockTime int64
	_ = _0_ClockTime
	var _out0 int64
	_ = _out0
	_out0 = m__Time.CurrentRelativeTimeMilli()
	_0_ClockTime = _out0
	var _1_CpuTime int64
	_ = _1_CpuTime
	var _out1 int64
	_ = _out1
	_out1 = m__Time.GetProcessCpuTimeMillis()
	_1_CpuTime = _out1
	output = Companion_AbsoluteTime_.Create_AbsoluteTime_(uint64(_0_ClockTime), uint64(_1_CpuTime))
	return output
	return output
}
func (_static *CompanionStruct_Default___) PrintTimeSince(start AbsoluteTime) {
	var _0_t RelativeTime
	_ = _0_t
	var _out0 RelativeTime
	_ = _out0
	_out0 = Companion_Default___.TimeSince(start)
	_0_t = _out0
	Companion_Default___.PrintTime(_0_t)
}
func (_static *CompanionStruct_Default___) PrintTimeSinceShort(start AbsoluteTime) {
	var _0_t RelativeTime
	_ = _0_t
	var _out0 RelativeTime
	_ = _out0
	_out0 = Companion_Default___.TimeSince(start)
	_0_t = _out0
	Companion_Default___.PrintTimeShort(_0_t)
}
func (_static *CompanionStruct_Default___) PrintTimeSinceShortChained(start AbsoluteTime) AbsoluteTime {
	var x AbsoluteTime = Companion_AbsoluteTime_.Default()
	_ = x
	var _0_end AbsoluteTime
	_ = _0_end
	var _out0 AbsoluteTime
	_ = _out0
	_out0 = Companion_Default___.GetAbsoluteTime()
	_0_end = _out0
	Companion_Default___.PrintTimeShort(Companion_Default___.TimeDiff(start, _0_end))
	x = _0_end
	return x
	return x
}
func (_static *CompanionStruct_Default___) TimeDiff(start AbsoluteTime, end AbsoluteTime) RelativeTime {
	if (((start).Dtor_ClockTime()) <= ((end).Dtor_ClockTime())) && (((start).Dtor_CpuTime()) <= ((end).Dtor_CpuTime())) {
		return Companion_RelativeTime_.Create_RelativeTime_(((end).Dtor_ClockTime())-(func() uint64 { return ((start).Dtor_ClockTime()) })(), ((end).Dtor_CpuTime())-(func() uint64 { return ((start).Dtor_CpuTime()) })())
	} else {
		return Companion_RelativeTime_.Create_RelativeTime_(uint64(0), uint64(0))
	}
}
func (_static *CompanionStruct_Default___) TimeSince(start AbsoluteTime) RelativeTime {
	var output RelativeTime = Companion_RelativeTime_.Default()
	_ = output
	var _0_end AbsoluteTime
	_ = _0_end
	var _out0 AbsoluteTime
	_ = _out0
	_out0 = Companion_Default___.GetAbsoluteTime()
	_0_end = _out0
	output = Companion_Default___.TimeDiff(start, _0_end)
	return output
}
func (_static *CompanionStruct_Default___) PrintTime(time RelativeTime) {
	_dafny.Print((_dafny.SeqOfString("Clock Time : ")).SetString())
	_dafny.Print((Companion_Default___.FormatMilli((time).Dtor_ClockTime())).SetString())
	_dafny.Print((_dafny.SeqOfString(" CPU Time : ")).SetString())
	_dafny.Print((Companion_Default___.FormatMilli((time).Dtor_CpuTime())).SetString())
	_dafny.Print((_dafny.SeqOfString("\n")).SetString())
}
func (_static *CompanionStruct_Default___) PrintTimeSinceLong(start AbsoluteTime, tag _dafny.Sequence, file m_Wrappers.Option) {
	var _0_t RelativeTime
	_ = _0_t
	var _out0 RelativeTime
	_ = _out0
	_out0 = Companion_Default___.TimeSince(start)
	_0_t = _out0
	Companion_Default___.PrintTimeLong(_0_t, tag, file)
}
func (_static *CompanionStruct_Default___) PrintTimeLong(time RelativeTime, tag _dafny.Sequence, file m_Wrappers.Option) {
	var _0_val _dafny.Sequence
	_ = _0_val
	_0_val = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(tag, _dafny.SeqOfString(" ")), m_OsLang.GetOsShort()), _dafny.SeqOfString(" ")), m_OsLang.GetLanguageShort()), _dafny.SeqOfString(" ")), Companion_Default___.FormatMilli((time).Dtor_ClockTime())), _dafny.SeqOfString(" ")), Companion_Default___.FormatMilli((time).Dtor_CpuTime())), _dafny.SeqOfString("\n"))
	_dafny.Print((_0_val).SetString())
	if (file).Is_Some() {
		var _1_utf8__val m_Wrappers.Result
		_ = _1_utf8__val
		_1_utf8__val = m_UTF8.Encode(_0_val)
		if (_1_utf8__val).Is_Success() {
			var _2___v0 m_Wrappers.Result
			_ = _2___v0
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = m_FileIO.Companion_Default___.AppendBytesToFile((file).Dtor_value().(_dafny.Sequence), (_1_utf8__val).Dtor_value().(_dafny.Sequence))
			_2___v0 = _out0
		}
	}
}
func (_static *CompanionStruct_Default___) PrintTimeShort(time RelativeTime) {
	_dafny.Print((_dafny.SeqOfString("CPU:")).SetString())
	_dafny.Print((Companion_Default___.FormatMilli((time).Dtor_CpuTime())).SetString())
	_dafny.Print((_dafny.SeqOfString(" ")).SetString())
}
func (_static *CompanionStruct_Default___) CreateGetCurrentTimeStampSuccess(value _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(value)
}
func (_static *CompanionStruct_Default___) CreateGetCurrentTimeStampFailure(error_ _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}

// End of class Default__

// Definition of datatype AbsoluteTime
type AbsoluteTime struct {
	Data_AbsoluteTime_
}

func (_this AbsoluteTime) Get_() Data_AbsoluteTime_ {
	return _this.Data_AbsoluteTime_
}

type Data_AbsoluteTime_ interface {
	isAbsoluteTime()
}

type CompanionStruct_AbsoluteTime_ struct {
}

var Companion_AbsoluteTime_ = CompanionStruct_AbsoluteTime_{}

type AbsoluteTime_AbsoluteTime struct {
	ClockTime uint64
	CpuTime   uint64
}

func (AbsoluteTime_AbsoluteTime) isAbsoluteTime() {}

func (CompanionStruct_AbsoluteTime_) Create_AbsoluteTime_(ClockTime uint64, CpuTime uint64) AbsoluteTime {
	return AbsoluteTime{AbsoluteTime_AbsoluteTime{ClockTime, CpuTime}}
}

func (_this AbsoluteTime) Is_AbsoluteTime() bool {
	_, ok := _this.Get_().(AbsoluteTime_AbsoluteTime)
	return ok
}

func (CompanionStruct_AbsoluteTime_) Default() AbsoluteTime {
	return Companion_AbsoluteTime_.Create_AbsoluteTime_(uint64(0), uint64(0))
}

func (_this AbsoluteTime) Dtor_ClockTime() uint64 {
	return _this.Get_().(AbsoluteTime_AbsoluteTime).ClockTime
}

func (_this AbsoluteTime) Dtor_CpuTime() uint64 {
	return _this.Get_().(AbsoluteTime_AbsoluteTime).CpuTime
}

func (_this AbsoluteTime) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AbsoluteTime_AbsoluteTime:
		{
			return "Time.AbsoluteTime.AbsoluteTime" + "(" + _dafny.String(data.ClockTime) + ", " + _dafny.String(data.CpuTime) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AbsoluteTime) Equals(other AbsoluteTime) bool {
	switch data1 := _this.Get_().(type) {
	case AbsoluteTime_AbsoluteTime:
		{
			data2, ok := other.Get_().(AbsoluteTime_AbsoluteTime)
			return ok && data1.ClockTime == data2.ClockTime && data1.CpuTime == data2.CpuTime
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AbsoluteTime) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AbsoluteTime)
	return ok && _this.Equals(typed)
}

func Type_AbsoluteTime_() _dafny.TypeDescriptor {
	return type_AbsoluteTime_{}
}

type type_AbsoluteTime_ struct {
}

func (_this type_AbsoluteTime_) Default() interface{} {
	return Companion_AbsoluteTime_.Default()
}

func (_this type_AbsoluteTime_) String() string {
	return "_Time.AbsoluteTime"
}
func (_this AbsoluteTime) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AbsoluteTime{}

// End of datatype AbsoluteTime

// Definition of datatype RelativeTime
type RelativeTime struct {
	Data_RelativeTime_
}

func (_this RelativeTime) Get_() Data_RelativeTime_ {
	return _this.Data_RelativeTime_
}

type Data_RelativeTime_ interface {
	isRelativeTime()
}

type CompanionStruct_RelativeTime_ struct {
}

var Companion_RelativeTime_ = CompanionStruct_RelativeTime_{}

type RelativeTime_RelativeTime struct {
	ClockTime uint64
	CpuTime   uint64
}

func (RelativeTime_RelativeTime) isRelativeTime() {}

func (CompanionStruct_RelativeTime_) Create_RelativeTime_(ClockTime uint64, CpuTime uint64) RelativeTime {
	return RelativeTime{RelativeTime_RelativeTime{ClockTime, CpuTime}}
}

func (_this RelativeTime) Is_RelativeTime() bool {
	_, ok := _this.Get_().(RelativeTime_RelativeTime)
	return ok
}

func (CompanionStruct_RelativeTime_) Default() RelativeTime {
	return Companion_RelativeTime_.Create_RelativeTime_(uint64(0), uint64(0))
}

func (_this RelativeTime) Dtor_ClockTime() uint64 {
	return _this.Get_().(RelativeTime_RelativeTime).ClockTime
}

func (_this RelativeTime) Dtor_CpuTime() uint64 {
	return _this.Get_().(RelativeTime_RelativeTime).CpuTime
}

func (_this RelativeTime) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case RelativeTime_RelativeTime:
		{
			return "Time.RelativeTime.RelativeTime" + "(" + _dafny.String(data.ClockTime) + ", " + _dafny.String(data.CpuTime) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RelativeTime) Equals(other RelativeTime) bool {
	switch data1 := _this.Get_().(type) {
	case RelativeTime_RelativeTime:
		{
			data2, ok := other.Get_().(RelativeTime_RelativeTime)
			return ok && data1.ClockTime == data2.ClockTime && data1.CpuTime == data2.CpuTime
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RelativeTime) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RelativeTime)
	return ok && _this.Equals(typed)
}

func Type_RelativeTime_() _dafny.TypeDescriptor {
	return type_RelativeTime_{}
}

type type_RelativeTime_ struct {
}

func (_this type_RelativeTime_) Default() interface{} {
	return Companion_RelativeTime_.Default()
}

func (_this type_RelativeTime_) String() string {
	return "_Time.RelativeTime"
}
func (_this RelativeTime) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RelativeTime{}

// End of datatype RelativeTime
