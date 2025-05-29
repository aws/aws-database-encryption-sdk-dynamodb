// Package JSON_Utils_Lexers_Core
// Dafny module JSON_Utils_Lexers_Core compiled into Go

package JSON_Utils_Lexers_Core

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

type Dummy__ struct{}

// Definition of datatype LexerResult
type LexerResult struct {
	Data_LexerResult_
}

func (_this LexerResult) Get_() Data_LexerResult_ {
	return _this.Data_LexerResult_
}

type Data_LexerResult_ interface {
	isLexerResult()
}

type CompanionStruct_LexerResult_ struct {
}

var Companion_LexerResult_ = CompanionStruct_LexerResult_{}

type LexerResult_Accept struct {
}

func (LexerResult_Accept) isLexerResult() {}

func (CompanionStruct_LexerResult_) Create_Accept_() LexerResult {
	return LexerResult{LexerResult_Accept{}}
}

func (_this LexerResult) Is_Accept() bool {
	_, ok := _this.Get_().(LexerResult_Accept)
	return ok
}

type LexerResult_Reject struct {
	Err interface{}
}

func (LexerResult_Reject) isLexerResult() {}

func (CompanionStruct_LexerResult_) Create_Reject_(Err interface{}) LexerResult {
	return LexerResult{LexerResult_Reject{Err}}
}

func (_this LexerResult) Is_Reject() bool {
	_, ok := _this.Get_().(LexerResult_Reject)
	return ok
}

type LexerResult_Partial struct {
	St interface{}
}

func (LexerResult_Partial) isLexerResult() {}

func (CompanionStruct_LexerResult_) Create_Partial_(St interface{}) LexerResult {
	return LexerResult{LexerResult_Partial{St}}
}

func (_this LexerResult) Is_Partial() bool {
	_, ok := _this.Get_().(LexerResult_Partial)
	return ok
}

func (CompanionStruct_LexerResult_) Default() LexerResult {
	return Companion_LexerResult_.Create_Accept_()
}

func (_this LexerResult) Dtor_err() interface{} {
	return _this.Get_().(LexerResult_Reject).Err
}

func (_this LexerResult) Dtor_st() interface{} {
	return _this.Get_().(LexerResult_Partial).St
}

func (_this LexerResult) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case LexerResult_Accept:
		{
			return "Core.LexerResult.Accept"
		}
	case LexerResult_Reject:
		{
			return "Core.LexerResult.Reject" + "(" + _dafny.String(data.Err) + ")"
		}
	case LexerResult_Partial:
		{
			return "Core.LexerResult.Partial" + "(" + _dafny.String(data.St) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this LexerResult) Equals(other LexerResult) bool {
	switch data1 := _this.Get_().(type) {
	case LexerResult_Accept:
		{
			_, ok := other.Get_().(LexerResult_Accept)
			return ok
		}
	case LexerResult_Reject:
		{
			data2, ok := other.Get_().(LexerResult_Reject)
			return ok && _dafny.AreEqual(data1.Err, data2.Err)
		}
	case LexerResult_Partial:
		{
			data2, ok := other.Get_().(LexerResult_Partial)
			return ok && _dafny.AreEqual(data1.St, data2.St)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this LexerResult) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(LexerResult)
	return ok && _this.Equals(typed)
}

func Type_LexerResult_() _dafny.TypeDescriptor {
	return type_LexerResult_{}
}

type type_LexerResult_ struct {
}

func (_this type_LexerResult_) Default() interface{} {
	return Companion_LexerResult_.Default()
}

func (_this type_LexerResult_) String() string {
	return "JSON_Utils_Lexers_Core.LexerResult"
}
func (_this LexerResult) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = LexerResult{}

// End of datatype LexerResult
