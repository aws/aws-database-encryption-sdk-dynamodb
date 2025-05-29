// Package _Unicode
// Dafny module _Unicode compiled into Go

package _Unicode

import (
	os "os"

	m_BoundedInts "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/BoundedInts"
	m__Math "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Math_"
	m_Relations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Relations"
	m_Seq "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Seq"
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
var _ m_Seq.Dummy__
var _ m_BoundedInts.Dummy__

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
	return "_Unicode.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) HIGH__SURROGATE__MIN() uint32 {
	return uint32(55296)
}
func (_static *CompanionStruct_Default___) HIGH__SURROGATE__MAX() uint32 {
	return uint32(56319)
}
func (_static *CompanionStruct_Default___) LOW__SURROGATE__MIN() uint32 {
	return uint32(56320)
}
func (_static *CompanionStruct_Default___) LOW__SURROGATE__MAX() uint32 {
	return uint32(57343)
}
func (_static *CompanionStruct_Default___) ASSIGNED__PLANES() _dafny.Set {
	return _dafny.SetOf(uint8(0), uint8(1), uint8(2), uint8(3), uint8(14), uint8(15), uint8(16))
}

// End of class Default__

// Definition of class CodePoint
type CodePoint struct {
}

func New_CodePoint_() *CodePoint {
	_this := CodePoint{}

	return &_this
}

type CompanionStruct_CodePoint_ struct {
}

var Companion_CodePoint_ = CompanionStruct_CodePoint_{}

func (*CodePoint) String() string {
	return "_Unicode.CodePoint"
}

// End of class CodePoint

func Type_CodePoint_() _dafny.TypeDescriptor {
	return type_CodePoint_{}
}

type type_CodePoint_ struct {
}

func (_this type_CodePoint_) Default() interface{} {
	return 0
}

func (_this type_CodePoint_) String() string {
	return "_Unicode.CodePoint"
}
func (_this *CompanionStruct_CodePoint_) Is_(__source uint32) bool {
	var _0_i uint32 = (__source)
	_ = _0_i
	return ((uint32(0)) <= (_0_i)) && ((_0_i) <= (uint32(1114111)))
}

// Definition of class HighSurrogateCodePoint
type HighSurrogateCodePoint struct {
}

func New_HighSurrogateCodePoint_() *HighSurrogateCodePoint {
	_this := HighSurrogateCodePoint{}

	return &_this
}

type CompanionStruct_HighSurrogateCodePoint_ struct {
}

var Companion_HighSurrogateCodePoint_ = CompanionStruct_HighSurrogateCodePoint_{}

func (*HighSurrogateCodePoint) String() string {
	return "_Unicode.HighSurrogateCodePoint"
}
func (_this *CompanionStruct_HighSurrogateCodePoint_) Witness() uint32 {
	return Companion_Default___.HIGH__SURROGATE__MIN()
}

// End of class HighSurrogateCodePoint

func Type_HighSurrogateCodePoint_() _dafny.TypeDescriptor {
	return type_HighSurrogateCodePoint_{}
}

type type_HighSurrogateCodePoint_ struct {
}

func (_this type_HighSurrogateCodePoint_) Default() interface{} {
	return Companion_HighSurrogateCodePoint_.Witness()
}

func (_this type_HighSurrogateCodePoint_) String() string {
	return "_Unicode.HighSurrogateCodePoint"
}
func (_this *CompanionStruct_HighSurrogateCodePoint_) Is_(__source uint32) bool {
	var _1_p uint32 = (__source)
	_ = _1_p
	if Companion_CodePoint_.Is_(_1_p) {
		return ((Companion_Default___.HIGH__SURROGATE__MIN()) <= (_1_p)) && ((_1_p) <= (Companion_Default___.HIGH__SURROGATE__MAX()))
	}
	return false
}

// Definition of class LowSurrogateCodePoint
type LowSurrogateCodePoint struct {
}

func New_LowSurrogateCodePoint_() *LowSurrogateCodePoint {
	_this := LowSurrogateCodePoint{}

	return &_this
}

type CompanionStruct_LowSurrogateCodePoint_ struct {
}

var Companion_LowSurrogateCodePoint_ = CompanionStruct_LowSurrogateCodePoint_{}

func (*LowSurrogateCodePoint) String() string {
	return "_Unicode.LowSurrogateCodePoint"
}
func (_this *CompanionStruct_LowSurrogateCodePoint_) Witness() uint32 {
	return Companion_Default___.LOW__SURROGATE__MIN()
}

// End of class LowSurrogateCodePoint

func Type_LowSurrogateCodePoint_() _dafny.TypeDescriptor {
	return type_LowSurrogateCodePoint_{}
}

type type_LowSurrogateCodePoint_ struct {
}

func (_this type_LowSurrogateCodePoint_) Default() interface{} {
	return Companion_LowSurrogateCodePoint_.Witness()
}

func (_this type_LowSurrogateCodePoint_) String() string {
	return "_Unicode.LowSurrogateCodePoint"
}
func (_this *CompanionStruct_LowSurrogateCodePoint_) Is_(__source uint32) bool {
	var _2_p uint32 = (__source)
	_ = _2_p
	if Companion_CodePoint_.Is_(_2_p) {
		return ((Companion_Default___.LOW__SURROGATE__MIN()) <= (_2_p)) && ((_2_p) <= (Companion_Default___.LOW__SURROGATE__MAX()))
	}
	return false
}

// Definition of class ScalarValue
type ScalarValue struct {
}

func New_ScalarValue_() *ScalarValue {
	_this := ScalarValue{}

	return &_this
}

type CompanionStruct_ScalarValue_ struct {
}

var Companion_ScalarValue_ = CompanionStruct_ScalarValue_{}

func (*ScalarValue) String() string {
	return "_Unicode.ScalarValue"
}

// End of class ScalarValue

func Type_ScalarValue_() _dafny.TypeDescriptor {
	return type_ScalarValue_{}
}

type type_ScalarValue_ struct {
}

func (_this type_ScalarValue_) Default() interface{} {
	return 0
}

func (_this type_ScalarValue_) String() string {
	return "_Unicode.ScalarValue"
}
func (_this *CompanionStruct_ScalarValue_) Is_(__source uint32) bool {
	var _3_p uint32 = (__source)
	_ = _3_p
	if Companion_CodePoint_.Is_(_3_p) {
		return (((_3_p) < (Companion_Default___.HIGH__SURROGATE__MIN())) || ((_3_p) > (Companion_Default___.HIGH__SURROGATE__MAX()))) && (((_3_p) < (Companion_Default___.LOW__SURROGATE__MIN())) || ((_3_p) > (Companion_Default___.LOW__SURROGATE__MAX())))
	}
	return false
}

// Definition of class AssignedCodePoint
type AssignedCodePoint struct {
}

func New_AssignedCodePoint_() *AssignedCodePoint {
	_this := AssignedCodePoint{}

	return &_this
}

type CompanionStruct_AssignedCodePoint_ struct {
}

var Companion_AssignedCodePoint_ = CompanionStruct_AssignedCodePoint_{}

func (*AssignedCodePoint) String() string {
	return "_Unicode.AssignedCodePoint"
}

// End of class AssignedCodePoint

func Type_AssignedCodePoint_() _dafny.TypeDescriptor {
	return type_AssignedCodePoint_{}
}

type type_AssignedCodePoint_ struct {
}

func (_this type_AssignedCodePoint_) Default() interface{} {
	return 0
}

func (_this type_AssignedCodePoint_) String() string {
	return "_Unicode.AssignedCodePoint"
}
