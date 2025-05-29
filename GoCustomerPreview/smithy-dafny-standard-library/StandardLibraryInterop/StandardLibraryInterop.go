// Package StandardLibraryInterop
// Dafny module StandardLibraryInterop compiled into Go

package StandardLibraryInterop

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

type Dummy__ struct{}

// Definition of class WrappersInterop
type WrappersInterop struct {
	dummy byte
}

func New_WrappersInterop_() *WrappersInterop {
	_this := WrappersInterop{}

	return &_this
}

type CompanionStruct_WrappersInterop_ struct {
}

var Companion_WrappersInterop_ = CompanionStruct_WrappersInterop_{}

func (_this *WrappersInterop) Equals(other *WrappersInterop) bool {
	return _this == other
}

func (_this *WrappersInterop) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*WrappersInterop)
	return ok && _this.Equals(other)
}

func (*WrappersInterop) String() string {
	return "StandardLibraryInterop.WrappersInterop"
}

func Type_WrappersInterop_() _dafny.TypeDescriptor {
	return type_WrappersInterop_{}
}

type type_WrappersInterop_ struct {
}

func (_this type_WrappersInterop_) Default() interface{} {
	return (*WrappersInterop)(nil)
}

func (_this type_WrappersInterop_) String() string {
	return "StandardLibraryInterop.WrappersInterop"
}
func (_this *WrappersInterop) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &WrappersInterop{}

func (_static *CompanionStruct_WrappersInterop_) CreateStringSome(s _dafny.Sequence) m_Wrappers.Option {
	return m_Wrappers.Companion_Option_.Create_Some_(s)
}
func (_static *CompanionStruct_WrappersInterop_) CreateStringNone() m_Wrappers.Option {
	return m_Wrappers.Companion_Option_.Create_None_()
}
func (_static *CompanionStruct_WrappersInterop_) CreateBooleanSome(b bool) m_Wrappers.Option {
	return m_Wrappers.Companion_Option_.Create_Some_(b)
}
func (_static *CompanionStruct_WrappersInterop_) CreateBooleanNone() m_Wrappers.Option {
	return m_Wrappers.Companion_Option_.Create_None_()
}

// End of class WrappersInterop
