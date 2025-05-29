// Package FileIO
// Dafny module FileIO compiled into Go

package FileIO

import (
	os "os"

	m_BoundedInts "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/BoundedInts"
	m_Functions "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Functions"
	m__Math "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Math_"
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
	return "FileIO.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) ReadBytesFromFile(path _dafny.Sequence) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = res
	var _0_isError bool
	_ = _0_isError
	var _1_bytesRead _dafny.Sequence
	_ = _1_bytesRead
	var _2_errorMsg _dafny.Sequence
	_ = _2_errorMsg
	var _out0 bool
	_ = _out0
	var _out1 _dafny.Sequence
	_ = _out1
	var _out2 _dafny.Sequence
	_ = _out2
	_out0, _out1, _out2 = m_DafnyLibraries.FileIO.INTERNAL_ReadBytesFromFile(path)
	_0_isError = _out0
	_1_bytesRead = _out1
	_2_errorMsg = _out2
	if _0_isError {
		res = m_Wrappers.Companion_Result_.Create_Failure_(_2_errorMsg)
	} else {
		res = m_Wrappers.Companion_Result_.Create_Success_(_1_bytesRead)
	}
	return res
	return res
}
func (_static *CompanionStruct_Default___) WriteBytesToFile(path _dafny.Sequence, bytes _dafny.Sequence) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
	_ = res
	var _0_isError bool
	_ = _0_isError
	var _1_errorMsg _dafny.Sequence
	_ = _1_errorMsg
	var _out0 bool
	_ = _out0
	var _out1 _dafny.Sequence
	_ = _out1
	_out0, _out1 = m_DafnyLibraries.FileIO.INTERNAL_WriteBytesToFile(path, bytes)
	_0_isError = _out0
	_1_errorMsg = _out1
	if _0_isError {
		res = m_Wrappers.Companion_Result_.Create_Failure_(_1_errorMsg)
	} else {
		res = m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
	}
	return res
	return res
}
func (_static *CompanionStruct_Default___) AppendBytesToFile(path _dafny.Sequence, bytes _dafny.Sequence) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
	_ = res
	var _0_isError bool
	_ = _0_isError
	var _1_errorMsg _dafny.Sequence
	_ = _1_errorMsg
	var _out0 bool
	_ = _out0
	var _out1 _dafny.Sequence
	_ = _out1
	_out0, _out1 = m_DafnyLibraries.FileIO.INTERNAL_AppendBytesToFile(path, bytes)
	_0_isError = _out0
	_1_errorMsg = _out1
	if _0_isError {
		res = m_Wrappers.Companion_Result_.Create_Failure_(_1_errorMsg)
	} else {
		res = m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
	}
	return res
	return res
}

// End of class Default__
