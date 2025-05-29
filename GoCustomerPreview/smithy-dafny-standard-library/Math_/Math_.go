// Package _Math
// Dafny module _Math compiled into Go

package _Math

import (
	os "os"

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
	return "_Math.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) Min(a _dafny.Int, b _dafny.Int) _dafny.Int {
	if (a).Cmp(b) < 0 {
		return a
	} else {
		return b
	}
}
func (_static *CompanionStruct_Default___) Max(a _dafny.Int, b _dafny.Int) _dafny.Int {
	if (a).Cmp(b) < 0 {
		return b
	} else {
		return a
	}
}
func (_static *CompanionStruct_Default___) Abs(a _dafny.Int) _dafny.Int {
	if (a).Sign() != -1 {
		return a
	} else {
		return (_dafny.Zero).Minus(a)
	}
}

// End of class Default__
