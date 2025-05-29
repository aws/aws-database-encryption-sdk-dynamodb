// Package JSON_Utils_Parsers
// Dafny module JSON_Utils_Parsers compiled into Go

package JSON_Utils_Parsers

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
	return "JSON_Utils_Parsers.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) ParserWitness() Parser__ {
	return Companion_Parser___.Create_Parser_(func(coer30 func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result) func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result {
		return func(arg33 m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result {
			return coer30(arg33)
		}
	}(func(_0___v0 m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_JSON_Utils_Cursors.Companion_CursorError_.Create_EOF_())
	}))
}
func (_static *CompanionStruct_Default___) SubParserWitness() SubParser__ {
	return Companion_SubParser___.Create_SubParser_(func(coer31 func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result) func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result {
		return func(arg34 m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result {
			return coer31(arg34)
		}
	}(func(_0_cs m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_JSON_Utils_Cursors.Companion_CursorError_.Create_EOF_())
	}))
}

// End of class Default__

// Definition of class Parser
type Parser struct {
}

func New_Parser_() *Parser {
	_this := Parser{}

	return &_this
}

type CompanionStruct_Parser_ struct {
}

var Companion_Parser_ = CompanionStruct_Parser_{}

func (*Parser) String() string {
	return "JSON_Utils_Parsers.Parser"
}
func (_this *CompanionStruct_Parser_) Witness() Parser__ {
	return Companion_Default___.ParserWitness()
}

// End of class Parser

func Type_Parser_(Type_T_ _dafny.TypeDescriptor, Type_R_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_Parser_{Type_T_, Type_R_}
}

type type_Parser_ struct {
	Type_T_ _dafny.TypeDescriptor
	Type_R_ _dafny.TypeDescriptor
}

func (_this type_Parser_) Default() interface{} {
	Type_T_ := _this.Type_T_
	_ = Type_T_
	Type_R_ := _this.Type_R_
	_ = Type_R_
	return Companion_Parser_.Witness()
}

func (_this type_Parser_) String() string {
	return "JSON_Utils_Parsers.Parser"
}

// Definition of datatype Parser__
type Parser__ struct {
	Data_Parser___
}

func (_this Parser__) Get_() Data_Parser___ {
	return _this.Data_Parser___
}

type Data_Parser___ interface {
	isParser__()
}

type CompanionStruct_Parser___ struct {
}

var Companion_Parser___ = CompanionStruct_Parser___{}

type Parser___Parser struct {
	Fn func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result
}

func (Parser___Parser) isParser__() {}

func (CompanionStruct_Parser___) Create_Parser_(Fn func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result) Parser__ {
	return Parser__{Parser___Parser{Fn}}
}

func (_this Parser__) Is_Parser() bool {
	_, ok := _this.Get_().(Parser___Parser)
	return ok
}

func (CompanionStruct_Parser___) Default(_default_T interface{}) Parser__ {
	return Companion_Parser___.Create_Parser_(func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result {
		return m_Wrappers.Companion_Result_.Default(m_JSON_Utils_Cursors.Companion_Split_.Default(_default_T))
	})
}

func (_this Parser__) Dtor_fn() func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result {
	return _this.Get_().(Parser___Parser).Fn
}

func (_this Parser__) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Parser___Parser:
		{
			return "Parsers.Parser_.Parser" + "(" + _dafny.String(data.Fn) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Parser__) Equals(other Parser__) bool {
	switch data1 := _this.Get_().(type) {
	case Parser___Parser:
		{
			data2, ok := other.Get_().(Parser___Parser)
			return ok && _dafny.AreEqual(data1.Fn, data2.Fn)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Parser__) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Parser__)
	return ok && _this.Equals(typed)
}

func Type_Parser___(Type_T_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_Parser___{Type_T_}
}

type type_Parser___ struct {
	Type_T_ _dafny.TypeDescriptor
}

func (_this type_Parser___) Default() interface{} {
	Type_T_ := _this.Type_T_
	_ = Type_T_
	return Companion_Parser___.Default(Type_T_.Default())
}

func (_this type_Parser___) String() string {
	return "JSON_Utils_Parsers.Parser__"
}
func (_this Parser__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Parser__{}

// End of datatype Parser__

// Definition of datatype SubParser__
type SubParser__ struct {
	Data_SubParser___
}

func (_this SubParser__) Get_() Data_SubParser___ {
	return _this.Data_SubParser___
}

type Data_SubParser___ interface {
	isSubParser__()
}

type CompanionStruct_SubParser___ struct {
}

var Companion_SubParser___ = CompanionStruct_SubParser___{}

type SubParser___SubParser struct {
	Fn func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result
}

func (SubParser___SubParser) isSubParser__() {}

func (CompanionStruct_SubParser___) Create_SubParser_(Fn func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result) SubParser__ {
	return SubParser__{SubParser___SubParser{Fn}}
}

func (_this SubParser__) Is_SubParser() bool {
	_, ok := _this.Get_().(SubParser___SubParser)
	return ok
}

func (CompanionStruct_SubParser___) Default() SubParser__ {
	return Companion_SubParser___.Create_SubParser_((func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result)(nil))
}

func (_this SubParser__) Dtor_fn() func(m_JSON_Utils_Cursors.Cursor__) m_Wrappers.Result {
	return _this.Get_().(SubParser___SubParser).Fn
}

func (_this SubParser__) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case SubParser___SubParser:
		{
			return "Parsers.SubParser_.SubParser" + "(" + _dafny.String(data.Fn) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this SubParser__) Equals(other SubParser__) bool {
	switch data1 := _this.Get_().(type) {
	case SubParser___SubParser:
		{
			data2, ok := other.Get_().(SubParser___SubParser)
			return ok && _dafny.AreEqual(data1.Fn, data2.Fn)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this SubParser__) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(SubParser__)
	return ok && _this.Equals(typed)
}

func Type_SubParser___() _dafny.TypeDescriptor {
	return type_SubParser___{}
}

type type_SubParser___ struct {
}

func (_this type_SubParser___) Default() interface{} {
	return Companion_SubParser___.Default()
}

func (_this type_SubParser___) String() string {
	return "JSON_Utils_Parsers.SubParser__"
}
func (_this SubParser__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = SubParser__{}

// End of datatype SubParser__

// Definition of class SubParser
type SubParser struct {
}

func New_SubParser_() *SubParser {
	_this := SubParser{}

	return &_this
}

type CompanionStruct_SubParser_ struct {
}

var Companion_SubParser_ = CompanionStruct_SubParser_{}

func (*SubParser) String() string {
	return "JSON_Utils_Parsers.SubParser"
}
func (_this *CompanionStruct_SubParser_) Witness() SubParser__ {
	return Companion_Default___.SubParserWitness()
}

// End of class SubParser

func Type_SubParser_(Type_T_ _dafny.TypeDescriptor, Type_R_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_SubParser_{Type_T_, Type_R_}
}

type type_SubParser_ struct {
	Type_T_ _dafny.TypeDescriptor
	Type_R_ _dafny.TypeDescriptor
}

func (_this type_SubParser_) Default() interface{} {
	Type_T_ := _this.Type_T_
	_ = Type_T_
	Type_R_ := _this.Type_R_
	_ = Type_R_
	return Companion_SubParser_.Witness()
}

func (_this type_SubParser_) String() string {
	return "JSON_Utils_Parsers.SubParser"
}
