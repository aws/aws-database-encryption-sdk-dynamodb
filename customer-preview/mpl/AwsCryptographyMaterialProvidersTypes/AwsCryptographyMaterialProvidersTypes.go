// Package AwsCryptographyMaterialProvidersTypes
// Dafny module AwsCryptographyMaterialProvidersTypes compiled into Go

package AwsCryptographyMaterialProvidersTypes

import (
	os "os"

	m_ComAmazonawsDynamodbTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/ComAmazonawsDynamodbTypes"
	m_ComAmazonawsKmsTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/ComAmazonawsKmsTypes"
	m_AwsCryptographyKeyStoreTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyKeyStoreTypes"
	m_AtomicPrimitives "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AtomicPrimitives"
	m_AwsCryptographyPrimitivesOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesOperations"
	m_AwsCryptographyPrimitivesTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesTypes"
	m_Digest "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/Digest"
	m_HKDF "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/HKDF"
	m_KdfCtr "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/KdfCtr"
	m_Random "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/Random"
	m_WrappedHKDF "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/WrappedHKDF"
	m_WrappedHMAC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/WrappedHMAC"
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
	m_StandardLibrary_Sequence "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_Sequence"
	m_StandardLibrary_String "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_String"
	m_StandardLibrary_UInt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_UInt"
	m_Streams "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Streams"
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
var _ m_BoundedInts.Dummy__
var _ m_StandardLibrary_UInt.Dummy__
var _ m_StandardLibrary_Sequence.Dummy__
var _ m_StandardLibrary_String.Dummy__
var _ m_StandardLibrary.Dummy__
var _ m_AwsCryptographyPrimitivesTypes.Dummy__
var _ m_Random.Dummy__
var _ m_Digest.Dummy__
var _ m_WrappedHMAC.Dummy__
var _ m_HKDF.Dummy__
var _ m_WrappedHKDF.Dummy__
var _ m_KdfCtr.Dummy__
var _ m_AwsCryptographyPrimitivesOperations.Dummy__
var _ m_AtomicPrimitives.Dummy__
var _ m_ComAmazonawsDynamodbTypes.Dummy__
var _ m_ComAmazonawsKmsTypes.Dummy__
var _ m_Relations.Dummy__
var _ m_Seq_MergeSort.Dummy__
var _ m__Math.Dummy__
var _ m_Seq.Dummy__
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
var _ m_Streams.Dummy__
var _ m_Sorting.Dummy__
var _ m_HexStrings.Dummy__
var _ m_GetOpt.Dummy__
var _ m_FloatCompare.Dummy__
var _ m_Base64.Dummy__
var _ m_Base64Lemmas.Dummy__
var _ m_Actions.Dummy__
var _ m_AwsCryptographyKeyStoreTypes.Dummy__

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
	return "AwsCryptographyMaterialProvidersTypes.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) IsValid__CountingNumber(x int32) bool {
	return (int32(1)) <= (x)
}
func (_static *CompanionStruct_Default___) IsValid__PositiveInteger(x int32) bool {
	return (int32(0)) <= (x)
}
func (_static *CompanionStruct_Default___) IsValid__PositiveLong(x int64) bool {
	return (int64(0)) <= (x)
}
func (_static *CompanionStruct_Default___) IsDummySubsetType(x _dafny.Int) bool {
	return (x).Sign() == 1
}

// End of class Default__

// Definition of datatype DafnyCallEvent
type DafnyCallEvent struct {
	Data_DafnyCallEvent_
}

func (_this DafnyCallEvent) Get_() Data_DafnyCallEvent_ {
	return _this.Data_DafnyCallEvent_
}

type Data_DafnyCallEvent_ interface {
	isDafnyCallEvent()
}

type CompanionStruct_DafnyCallEvent_ struct {
}

var Companion_DafnyCallEvent_ = CompanionStruct_DafnyCallEvent_{}

type DafnyCallEvent_DafnyCallEvent struct {
	Input  interface{}
	Output interface{}
}

func (DafnyCallEvent_DafnyCallEvent) isDafnyCallEvent() {}

func (CompanionStruct_DafnyCallEvent_) Create_DafnyCallEvent_(Input interface{}, Output interface{}) DafnyCallEvent {
	return DafnyCallEvent{DafnyCallEvent_DafnyCallEvent{Input, Output}}
}

func (_this DafnyCallEvent) Is_DafnyCallEvent() bool {
	_, ok := _this.Get_().(DafnyCallEvent_DafnyCallEvent)
	return ok
}

func (CompanionStruct_DafnyCallEvent_) Default(_default_I interface{}, _default_O interface{}) DafnyCallEvent {
	return Companion_DafnyCallEvent_.Create_DafnyCallEvent_(_default_I, _default_O)
}

func (_this DafnyCallEvent) Dtor_input() interface{} {
	return _this.Get_().(DafnyCallEvent_DafnyCallEvent).Input
}

func (_this DafnyCallEvent) Dtor_output() interface{} {
	return _this.Get_().(DafnyCallEvent_DafnyCallEvent).Output
}

func (_this DafnyCallEvent) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DafnyCallEvent_DafnyCallEvent:
		{
			return "AwsCryptographyMaterialProvidersTypes.DafnyCallEvent.DafnyCallEvent" + "(" + _dafny.String(data.Input) + ", " + _dafny.String(data.Output) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DafnyCallEvent) Equals(other DafnyCallEvent) bool {
	switch data1 := _this.Get_().(type) {
	case DafnyCallEvent_DafnyCallEvent:
		{
			data2, ok := other.Get_().(DafnyCallEvent_DafnyCallEvent)
			return ok && _dafny.AreEqual(data1.Input, data2.Input) && _dafny.AreEqual(data1.Output, data2.Output)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DafnyCallEvent) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DafnyCallEvent)
	return ok && _this.Equals(typed)
}

func Type_DafnyCallEvent_(Type_I_ _dafny.TypeDescriptor, Type_O_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_DafnyCallEvent_{Type_I_, Type_O_}
}

type type_DafnyCallEvent_ struct {
	Type_I_ _dafny.TypeDescriptor
	Type_O_ _dafny.TypeDescriptor
}

func (_this type_DafnyCallEvent_) Default() interface{} {
	Type_I_ := _this.Type_I_
	_ = Type_I_
	Type_O_ := _this.Type_O_
	_ = Type_O_
	return Companion_DafnyCallEvent_.Default(Type_I_.Default(), Type_O_.Default())
}

func (_this type_DafnyCallEvent_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.DafnyCallEvent"
}
func (_this DafnyCallEvent) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DafnyCallEvent{}

// End of datatype DafnyCallEvent

// Definition of datatype AesWrappingAlg
type AesWrappingAlg struct {
	Data_AesWrappingAlg_
}

func (_this AesWrappingAlg) Get_() Data_AesWrappingAlg_ {
	return _this.Data_AesWrappingAlg_
}

type Data_AesWrappingAlg_ interface {
	isAesWrappingAlg()
}

type CompanionStruct_AesWrappingAlg_ struct {
}

var Companion_AesWrappingAlg_ = CompanionStruct_AesWrappingAlg_{}

type AesWrappingAlg_ALG__AES128__GCM__IV12__TAG16 struct {
}

func (AesWrappingAlg_ALG__AES128__GCM__IV12__TAG16) isAesWrappingAlg() {}

func (CompanionStruct_AesWrappingAlg_) Create_ALG__AES128__GCM__IV12__TAG16_() AesWrappingAlg {
	return AesWrappingAlg{AesWrappingAlg_ALG__AES128__GCM__IV12__TAG16{}}
}

func (_this AesWrappingAlg) Is_ALG__AES128__GCM__IV12__TAG16() bool {
	_, ok := _this.Get_().(AesWrappingAlg_ALG__AES128__GCM__IV12__TAG16)
	return ok
}

type AesWrappingAlg_ALG__AES192__GCM__IV12__TAG16 struct {
}

func (AesWrappingAlg_ALG__AES192__GCM__IV12__TAG16) isAesWrappingAlg() {}

func (CompanionStruct_AesWrappingAlg_) Create_ALG__AES192__GCM__IV12__TAG16_() AesWrappingAlg {
	return AesWrappingAlg{AesWrappingAlg_ALG__AES192__GCM__IV12__TAG16{}}
}

func (_this AesWrappingAlg) Is_ALG__AES192__GCM__IV12__TAG16() bool {
	_, ok := _this.Get_().(AesWrappingAlg_ALG__AES192__GCM__IV12__TAG16)
	return ok
}

type AesWrappingAlg_ALG__AES256__GCM__IV12__TAG16 struct {
}

func (AesWrappingAlg_ALG__AES256__GCM__IV12__TAG16) isAesWrappingAlg() {}

func (CompanionStruct_AesWrappingAlg_) Create_ALG__AES256__GCM__IV12__TAG16_() AesWrappingAlg {
	return AesWrappingAlg{AesWrappingAlg_ALG__AES256__GCM__IV12__TAG16{}}
}

func (_this AesWrappingAlg) Is_ALG__AES256__GCM__IV12__TAG16() bool {
	_, ok := _this.Get_().(AesWrappingAlg_ALG__AES256__GCM__IV12__TAG16)
	return ok
}

func (CompanionStruct_AesWrappingAlg_) Default() AesWrappingAlg {
	return Companion_AesWrappingAlg_.Create_ALG__AES128__GCM__IV12__TAG16_()
}

func (_ CompanionStruct_AesWrappingAlg_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_AesWrappingAlg_.Create_ALG__AES128__GCM__IV12__TAG16_(), true
		case 1:
			return Companion_AesWrappingAlg_.Create_ALG__AES192__GCM__IV12__TAG16_(), true
		case 2:
			return Companion_AesWrappingAlg_.Create_ALG__AES256__GCM__IV12__TAG16_(), true
		default:
			return AesWrappingAlg{}, false
		}
	}
}

func (_this AesWrappingAlg) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case AesWrappingAlg_ALG__AES128__GCM__IV12__TAG16:
		{
			return "AwsCryptographyMaterialProvidersTypes.AesWrappingAlg.ALG_AES128_GCM_IV12_TAG16"
		}
	case AesWrappingAlg_ALG__AES192__GCM__IV12__TAG16:
		{
			return "AwsCryptographyMaterialProvidersTypes.AesWrappingAlg.ALG_AES192_GCM_IV12_TAG16"
		}
	case AesWrappingAlg_ALG__AES256__GCM__IV12__TAG16:
		{
			return "AwsCryptographyMaterialProvidersTypes.AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AesWrappingAlg) Equals(other AesWrappingAlg) bool {
	switch _this.Get_().(type) {
	case AesWrappingAlg_ALG__AES128__GCM__IV12__TAG16:
		{
			_, ok := other.Get_().(AesWrappingAlg_ALG__AES128__GCM__IV12__TAG16)
			return ok
		}
	case AesWrappingAlg_ALG__AES192__GCM__IV12__TAG16:
		{
			_, ok := other.Get_().(AesWrappingAlg_ALG__AES192__GCM__IV12__TAG16)
			return ok
		}
	case AesWrappingAlg_ALG__AES256__GCM__IV12__TAG16:
		{
			_, ok := other.Get_().(AesWrappingAlg_ALG__AES256__GCM__IV12__TAG16)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AesWrappingAlg) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AesWrappingAlg)
	return ok && _this.Equals(typed)
}

func Type_AesWrappingAlg_() _dafny.TypeDescriptor {
	return type_AesWrappingAlg_{}
}

type type_AesWrappingAlg_ struct {
}

func (_this type_AesWrappingAlg_) Default() interface{} {
	return Companion_AesWrappingAlg_.Default()
}

func (_this type_AesWrappingAlg_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.AesWrappingAlg"
}
func (_this AesWrappingAlg) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AesWrappingAlg{}

// End of datatype AesWrappingAlg

// Definition of datatype AlgorithmSuiteId
type AlgorithmSuiteId struct {
	Data_AlgorithmSuiteId_
}

func (_this AlgorithmSuiteId) Get_() Data_AlgorithmSuiteId_ {
	return _this.Data_AlgorithmSuiteId_
}

type Data_AlgorithmSuiteId_ interface {
	isAlgorithmSuiteId()
}

type CompanionStruct_AlgorithmSuiteId_ struct {
}

var Companion_AlgorithmSuiteId_ = CompanionStruct_AlgorithmSuiteId_{}

type AlgorithmSuiteId_ESDK struct {
	ESDK ESDKAlgorithmSuiteId
}

func (AlgorithmSuiteId_ESDK) isAlgorithmSuiteId() {}

func (CompanionStruct_AlgorithmSuiteId_) Create_ESDK_(ESDK ESDKAlgorithmSuiteId) AlgorithmSuiteId {
	return AlgorithmSuiteId{AlgorithmSuiteId_ESDK{ESDK}}
}

func (_this AlgorithmSuiteId) Is_ESDK() bool {
	_, ok := _this.Get_().(AlgorithmSuiteId_ESDK)
	return ok
}

type AlgorithmSuiteId_DBE struct {
	DBE DBEAlgorithmSuiteId
}

func (AlgorithmSuiteId_DBE) isAlgorithmSuiteId() {}

func (CompanionStruct_AlgorithmSuiteId_) Create_DBE_(DBE DBEAlgorithmSuiteId) AlgorithmSuiteId {
	return AlgorithmSuiteId{AlgorithmSuiteId_DBE{DBE}}
}

func (_this AlgorithmSuiteId) Is_DBE() bool {
	_, ok := _this.Get_().(AlgorithmSuiteId_DBE)
	return ok
}

func (CompanionStruct_AlgorithmSuiteId_) Default() AlgorithmSuiteId {
	return Companion_AlgorithmSuiteId_.Create_ESDK_(Companion_ESDKAlgorithmSuiteId_.Default())
}

func (_this AlgorithmSuiteId) Dtor_ESDK() ESDKAlgorithmSuiteId {
	return _this.Get_().(AlgorithmSuiteId_ESDK).ESDK
}

func (_this AlgorithmSuiteId) Dtor_DBE() DBEAlgorithmSuiteId {
	return _this.Get_().(AlgorithmSuiteId_DBE).DBE
}

func (_this AlgorithmSuiteId) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AlgorithmSuiteId_ESDK:
		{
			return "AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteId.ESDK" + "(" + _dafny.String(data.ESDK) + ")"
		}
	case AlgorithmSuiteId_DBE:
		{
			return "AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteId.DBE" + "(" + _dafny.String(data.DBE) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AlgorithmSuiteId) Equals(other AlgorithmSuiteId) bool {
	switch data1 := _this.Get_().(type) {
	case AlgorithmSuiteId_ESDK:
		{
			data2, ok := other.Get_().(AlgorithmSuiteId_ESDK)
			return ok && data1.ESDK.Equals(data2.ESDK)
		}
	case AlgorithmSuiteId_DBE:
		{
			data2, ok := other.Get_().(AlgorithmSuiteId_DBE)
			return ok && data1.DBE.Equals(data2.DBE)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AlgorithmSuiteId) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AlgorithmSuiteId)
	return ok && _this.Equals(typed)
}

func Type_AlgorithmSuiteId_() _dafny.TypeDescriptor {
	return type_AlgorithmSuiteId_{}
}

type type_AlgorithmSuiteId_ struct {
}

func (_this type_AlgorithmSuiteId_) Default() interface{} {
	return Companion_AlgorithmSuiteId_.Default()
}

func (_this type_AlgorithmSuiteId_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteId"
}
func (_this AlgorithmSuiteId) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AlgorithmSuiteId{}

// End of datatype AlgorithmSuiteId

// Definition of datatype AlgorithmSuiteInfo
type AlgorithmSuiteInfo struct {
	Data_AlgorithmSuiteInfo_
}

func (_this AlgorithmSuiteInfo) Get_() Data_AlgorithmSuiteInfo_ {
	return _this.Data_AlgorithmSuiteInfo_
}

type Data_AlgorithmSuiteInfo_ interface {
	isAlgorithmSuiteInfo()
}

type CompanionStruct_AlgorithmSuiteInfo_ struct {
}

var Companion_AlgorithmSuiteInfo_ = CompanionStruct_AlgorithmSuiteInfo_{}

type AlgorithmSuiteInfo_AlgorithmSuiteInfo struct {
	Id                 AlgorithmSuiteId
	BinaryId           _dafny.Sequence
	MessageVersion     int32
	Encrypt            Encrypt
	Kdf                DerivationAlgorithm
	Commitment         DerivationAlgorithm
	Signature          SignatureAlgorithm
	SymmetricSignature SymmetricSignatureAlgorithm
	EdkWrapping        EdkWrappingAlgorithm
}

func (AlgorithmSuiteInfo_AlgorithmSuiteInfo) isAlgorithmSuiteInfo() {}

func (CompanionStruct_AlgorithmSuiteInfo_) Create_AlgorithmSuiteInfo_(Id AlgorithmSuiteId, BinaryId _dafny.Sequence, MessageVersion int32, Encrypt Encrypt, Kdf DerivationAlgorithm, Commitment DerivationAlgorithm, Signature SignatureAlgorithm, SymmetricSignature SymmetricSignatureAlgorithm, EdkWrapping EdkWrappingAlgorithm) AlgorithmSuiteInfo {
	return AlgorithmSuiteInfo{AlgorithmSuiteInfo_AlgorithmSuiteInfo{Id, BinaryId, MessageVersion, Encrypt, Kdf, Commitment, Signature, SymmetricSignature, EdkWrapping}}
}

func (_this AlgorithmSuiteInfo) Is_AlgorithmSuiteInfo() bool {
	_, ok := _this.Get_().(AlgorithmSuiteInfo_AlgorithmSuiteInfo)
	return ok
}

func (CompanionStruct_AlgorithmSuiteInfo_) Default() AlgorithmSuiteInfo {
	return Companion_AlgorithmSuiteInfo_.Create_AlgorithmSuiteInfo_(Companion_AlgorithmSuiteId_.Default(), _dafny.EmptySeq, int32(0), Companion_Encrypt_.Default(), Companion_DerivationAlgorithm_.Default(), Companion_DerivationAlgorithm_.Default(), Companion_SignatureAlgorithm_.Default(), Companion_SymmetricSignatureAlgorithm_.Default(), Companion_EdkWrappingAlgorithm_.Default())
}

func (_this AlgorithmSuiteInfo) Dtor_id() AlgorithmSuiteId {
	return _this.Get_().(AlgorithmSuiteInfo_AlgorithmSuiteInfo).Id
}

func (_this AlgorithmSuiteInfo) Dtor_binaryId() _dafny.Sequence {
	return _this.Get_().(AlgorithmSuiteInfo_AlgorithmSuiteInfo).BinaryId
}

func (_this AlgorithmSuiteInfo) Dtor_messageVersion() int32 {
	return _this.Get_().(AlgorithmSuiteInfo_AlgorithmSuiteInfo).MessageVersion
}

func (_this AlgorithmSuiteInfo) Dtor_encrypt() Encrypt {
	return _this.Get_().(AlgorithmSuiteInfo_AlgorithmSuiteInfo).Encrypt
}

func (_this AlgorithmSuiteInfo) Dtor_kdf() DerivationAlgorithm {
	return _this.Get_().(AlgorithmSuiteInfo_AlgorithmSuiteInfo).Kdf
}

func (_this AlgorithmSuiteInfo) Dtor_commitment() DerivationAlgorithm {
	return _this.Get_().(AlgorithmSuiteInfo_AlgorithmSuiteInfo).Commitment
}

func (_this AlgorithmSuiteInfo) Dtor_signature() SignatureAlgorithm {
	return _this.Get_().(AlgorithmSuiteInfo_AlgorithmSuiteInfo).Signature
}

func (_this AlgorithmSuiteInfo) Dtor_symmetricSignature() SymmetricSignatureAlgorithm {
	return _this.Get_().(AlgorithmSuiteInfo_AlgorithmSuiteInfo).SymmetricSignature
}

func (_this AlgorithmSuiteInfo) Dtor_edkWrapping() EdkWrappingAlgorithm {
	return _this.Get_().(AlgorithmSuiteInfo_AlgorithmSuiteInfo).EdkWrapping
}

func (_this AlgorithmSuiteInfo) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AlgorithmSuiteInfo_AlgorithmSuiteInfo:
		{
			return "AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo.AlgorithmSuiteInfo" + "(" + _dafny.String(data.Id) + ", " + _dafny.String(data.BinaryId) + ", " + _dafny.String(data.MessageVersion) + ", " + _dafny.String(data.Encrypt) + ", " + _dafny.String(data.Kdf) + ", " + _dafny.String(data.Commitment) + ", " + _dafny.String(data.Signature) + ", " + _dafny.String(data.SymmetricSignature) + ", " + _dafny.String(data.EdkWrapping) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AlgorithmSuiteInfo) Equals(other AlgorithmSuiteInfo) bool {
	switch data1 := _this.Get_().(type) {
	case AlgorithmSuiteInfo_AlgorithmSuiteInfo:
		{
			data2, ok := other.Get_().(AlgorithmSuiteInfo_AlgorithmSuiteInfo)
			return ok && data1.Id.Equals(data2.Id) && data1.BinaryId.Equals(data2.BinaryId) && data1.MessageVersion == data2.MessageVersion && data1.Encrypt.Equals(data2.Encrypt) && data1.Kdf.Equals(data2.Kdf) && data1.Commitment.Equals(data2.Commitment) && data1.Signature.Equals(data2.Signature) && data1.SymmetricSignature.Equals(data2.SymmetricSignature) && data1.EdkWrapping.Equals(data2.EdkWrapping)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AlgorithmSuiteInfo) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AlgorithmSuiteInfo)
	return ok && _this.Equals(typed)
}

func Type_AlgorithmSuiteInfo_() _dafny.TypeDescriptor {
	return type_AlgorithmSuiteInfo_{}
}

type type_AlgorithmSuiteInfo_ struct {
}

func (_this type_AlgorithmSuiteInfo_) Default() interface{} {
	return Companion_AlgorithmSuiteInfo_.Default()
}

func (_this type_AlgorithmSuiteInfo_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo"
}
func (_this AlgorithmSuiteInfo) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AlgorithmSuiteInfo{}

// End of datatype AlgorithmSuiteInfo

// Definition of class IAwsCryptographicMaterialProvidersClientCallHistory
type IAwsCryptographicMaterialProvidersClientCallHistory struct {
	dummy byte
}

func New_IAwsCryptographicMaterialProvidersClientCallHistory_() *IAwsCryptographicMaterialProvidersClientCallHistory {
	_this := IAwsCryptographicMaterialProvidersClientCallHistory{}

	return &_this
}

type CompanionStruct_IAwsCryptographicMaterialProvidersClientCallHistory_ struct {
}

var Companion_IAwsCryptographicMaterialProvidersClientCallHistory_ = CompanionStruct_IAwsCryptographicMaterialProvidersClientCallHistory_{}

func (_this *IAwsCryptographicMaterialProvidersClientCallHistory) Equals(other *IAwsCryptographicMaterialProvidersClientCallHistory) bool {
	return _this == other
}

func (_this *IAwsCryptographicMaterialProvidersClientCallHistory) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*IAwsCryptographicMaterialProvidersClientCallHistory)
	return ok && _this.Equals(other)
}

func (*IAwsCryptographicMaterialProvidersClientCallHistory) String() string {
	return "AwsCryptographyMaterialProvidersTypes.IAwsCryptographicMaterialProvidersClientCallHistory"
}

func Type_IAwsCryptographicMaterialProvidersClientCallHistory_() _dafny.TypeDescriptor {
	return type_IAwsCryptographicMaterialProvidersClientCallHistory_{}
}

type type_IAwsCryptographicMaterialProvidersClientCallHistory_ struct {
}

func (_this type_IAwsCryptographicMaterialProvidersClientCallHistory_) Default() interface{} {
	return (*IAwsCryptographicMaterialProvidersClientCallHistory)(nil)
}

func (_this type_IAwsCryptographicMaterialProvidersClientCallHistory_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.IAwsCryptographicMaterialProvidersClientCallHistory"
}
func (_this *IAwsCryptographicMaterialProvidersClientCallHistory) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &IAwsCryptographicMaterialProvidersClientCallHistory{}

// End of class IAwsCryptographicMaterialProvidersClientCallHistory

// Definition of trait IAwsCryptographicMaterialProvidersClient
type IAwsCryptographicMaterialProvidersClient interface {
	String() string
	CreateAwsKmsKeyring(input CreateAwsKmsKeyringInput) m_Wrappers.Result
	CreateAwsKmsDiscoveryKeyring(input CreateAwsKmsDiscoveryKeyringInput) m_Wrappers.Result
	CreateAwsKmsMultiKeyring(input CreateAwsKmsMultiKeyringInput) m_Wrappers.Result
	CreateAwsKmsDiscoveryMultiKeyring(input CreateAwsKmsDiscoveryMultiKeyringInput) m_Wrappers.Result
	CreateAwsKmsMrkKeyring(input CreateAwsKmsMrkKeyringInput) m_Wrappers.Result
	CreateAwsKmsMrkMultiKeyring(input CreateAwsKmsMrkMultiKeyringInput) m_Wrappers.Result
	CreateAwsKmsMrkDiscoveryKeyring(input CreateAwsKmsMrkDiscoveryKeyringInput) m_Wrappers.Result
	CreateAwsKmsMrkDiscoveryMultiKeyring(input CreateAwsKmsMrkDiscoveryMultiKeyringInput) m_Wrappers.Result
	CreateAwsKmsHierarchicalKeyring(input CreateAwsKmsHierarchicalKeyringInput) m_Wrappers.Result
	CreateAwsKmsRsaKeyring(input CreateAwsKmsRsaKeyringInput) m_Wrappers.Result
	CreateAwsKmsEcdhKeyring(input CreateAwsKmsEcdhKeyringInput) m_Wrappers.Result
	CreateMultiKeyring(input CreateMultiKeyringInput) m_Wrappers.Result
	CreateRawAesKeyring(input CreateRawAesKeyringInput) m_Wrappers.Result
	CreateRawRsaKeyring(input CreateRawRsaKeyringInput) m_Wrappers.Result
	CreateRawEcdhKeyring(input CreateRawEcdhKeyringInput) m_Wrappers.Result
	CreateDefaultCryptographicMaterialsManager(input CreateDefaultCryptographicMaterialsManagerInput) m_Wrappers.Result
	CreateRequiredEncryptionContextCMM(input CreateRequiredEncryptionContextCMMInput) m_Wrappers.Result
	CreateCryptographicMaterialsCache(input CreateCryptographicMaterialsCacheInput) m_Wrappers.Result
	CreateDefaultClientSupplier(input CreateDefaultClientSupplierInput) m_Wrappers.Result
	InitializeEncryptionMaterials(input InitializeEncryptionMaterialsInput) m_Wrappers.Result
	InitializeDecryptionMaterials(input InitializeDecryptionMaterialsInput) m_Wrappers.Result
	ValidEncryptionMaterialsTransition(input ValidEncryptionMaterialsTransitionInput) m_Wrappers.Result
	ValidDecryptionMaterialsTransition(input ValidDecryptionMaterialsTransitionInput) m_Wrappers.Result
	EncryptionMaterialsHasPlaintextDataKey(input EncryptionMaterials) m_Wrappers.Result
	DecryptionMaterialsWithPlaintextDataKey(input DecryptionMaterials) m_Wrappers.Result
	GetAlgorithmSuiteInfo(input _dafny.Sequence) m_Wrappers.Result
	ValidAlgorithmSuiteInfo(input AlgorithmSuiteInfo) m_Wrappers.Result
	ValidateCommitmentPolicyOnEncrypt(input ValidateCommitmentPolicyOnEncryptInput) m_Wrappers.Result
	ValidateCommitmentPolicyOnDecrypt(input ValidateCommitmentPolicyOnDecryptInput) m_Wrappers.Result
}
type CompanionStruct_IAwsCryptographicMaterialProvidersClient_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_IAwsCryptographicMaterialProvidersClient_ = CompanionStruct_IAwsCryptographicMaterialProvidersClient_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_IAwsCryptographicMaterialProvidersClient_) CastTo_(x interface{}) IAwsCryptographicMaterialProvidersClient {
	var t IAwsCryptographicMaterialProvidersClient
	t, _ = x.(IAwsCryptographicMaterialProvidersClient)
	return t
}

// End of trait IAwsCryptographicMaterialProvidersClient

// Definition of class IBranchKeyIdSupplierCallHistory
type IBranchKeyIdSupplierCallHistory struct {
	dummy byte
}

func New_IBranchKeyIdSupplierCallHistory_() *IBranchKeyIdSupplierCallHistory {
	_this := IBranchKeyIdSupplierCallHistory{}

	return &_this
}

type CompanionStruct_IBranchKeyIdSupplierCallHistory_ struct {
}

var Companion_IBranchKeyIdSupplierCallHistory_ = CompanionStruct_IBranchKeyIdSupplierCallHistory_{}

func (_this *IBranchKeyIdSupplierCallHistory) Equals(other *IBranchKeyIdSupplierCallHistory) bool {
	return _this == other
}

func (_this *IBranchKeyIdSupplierCallHistory) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*IBranchKeyIdSupplierCallHistory)
	return ok && _this.Equals(other)
}

func (*IBranchKeyIdSupplierCallHistory) String() string {
	return "AwsCryptographyMaterialProvidersTypes.IBranchKeyIdSupplierCallHistory"
}

func Type_IBranchKeyIdSupplierCallHistory_() _dafny.TypeDescriptor {
	return type_IBranchKeyIdSupplierCallHistory_{}
}

type type_IBranchKeyIdSupplierCallHistory_ struct {
}

func (_this type_IBranchKeyIdSupplierCallHistory_) Default() interface{} {
	return (*IBranchKeyIdSupplierCallHistory)(nil)
}

func (_this type_IBranchKeyIdSupplierCallHistory_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.IBranchKeyIdSupplierCallHistory"
}
func (_this *IBranchKeyIdSupplierCallHistory) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &IBranchKeyIdSupplierCallHistory{}

// End of class IBranchKeyIdSupplierCallHistory

// Definition of trait IBranchKeyIdSupplier
type IBranchKeyIdSupplier interface {
	String() string
	GetBranchKeyId(input GetBranchKeyIdInput) m_Wrappers.Result
	GetBranchKeyId_k(input GetBranchKeyIdInput) m_Wrappers.Result
}

func (_static *CompanionStruct_IBranchKeyIdSupplier_) GetBranchKeyId(_this IBranchKeyIdSupplier, input GetBranchKeyIdInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_GetBranchKeyIdOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (_this).GetBranchKeyId_k(input)
		output = _out0
		return output
	}
}

type CompanionStruct_IBranchKeyIdSupplier_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_IBranchKeyIdSupplier_ = CompanionStruct_IBranchKeyIdSupplier_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_IBranchKeyIdSupplier_) CastTo_(x interface{}) IBranchKeyIdSupplier {
	var t IBranchKeyIdSupplier
	t, _ = x.(IBranchKeyIdSupplier)
	return t
}

// End of trait IBranchKeyIdSupplier

// Definition of datatype CacheType
type CacheType struct {
	Data_CacheType_
}

func (_this CacheType) Get_() Data_CacheType_ {
	return _this.Data_CacheType_
}

type Data_CacheType_ interface {
	isCacheType()
}

type CompanionStruct_CacheType_ struct {
}

var Companion_CacheType_ = CompanionStruct_CacheType_{}

type CacheType_Default struct {
	Default DefaultCache
}

func (CacheType_Default) isCacheType() {}

func (CompanionStruct_CacheType_) Create_Default_(Default DefaultCache) CacheType {
	return CacheType{CacheType_Default{Default}}
}

func (_this CacheType) Is_Default() bool {
	_, ok := _this.Get_().(CacheType_Default)
	return ok
}

type CacheType_No struct {
	No NoCache
}

func (CacheType_No) isCacheType() {}

func (CompanionStruct_CacheType_) Create_No_(No NoCache) CacheType {
	return CacheType{CacheType_No{No}}
}

func (_this CacheType) Is_No() bool {
	_, ok := _this.Get_().(CacheType_No)
	return ok
}

type CacheType_SingleThreaded struct {
	SingleThreaded SingleThreadedCache
}

func (CacheType_SingleThreaded) isCacheType() {}

func (CompanionStruct_CacheType_) Create_SingleThreaded_(SingleThreaded SingleThreadedCache) CacheType {
	return CacheType{CacheType_SingleThreaded{SingleThreaded}}
}

func (_this CacheType) Is_SingleThreaded() bool {
	_, ok := _this.Get_().(CacheType_SingleThreaded)
	return ok
}

type CacheType_MultiThreaded struct {
	MultiThreaded MultiThreadedCache
}

func (CacheType_MultiThreaded) isCacheType() {}

func (CompanionStruct_CacheType_) Create_MultiThreaded_(MultiThreaded MultiThreadedCache) CacheType {
	return CacheType{CacheType_MultiThreaded{MultiThreaded}}
}

func (_this CacheType) Is_MultiThreaded() bool {
	_, ok := _this.Get_().(CacheType_MultiThreaded)
	return ok
}

type CacheType_StormTracking struct {
	StormTracking StormTrackingCache
}

func (CacheType_StormTracking) isCacheType() {}

func (CompanionStruct_CacheType_) Create_StormTracking_(StormTracking StormTrackingCache) CacheType {
	return CacheType{CacheType_StormTracking{StormTracking}}
}

func (_this CacheType) Is_StormTracking() bool {
	_, ok := _this.Get_().(CacheType_StormTracking)
	return ok
}

type CacheType_Shared struct {
	Shared ICryptographicMaterialsCache
}

func (CacheType_Shared) isCacheType() {}

func (CompanionStruct_CacheType_) Create_Shared_(Shared ICryptographicMaterialsCache) CacheType {
	return CacheType{CacheType_Shared{Shared}}
}

func (_this CacheType) Is_Shared() bool {
	_, ok := _this.Get_().(CacheType_Shared)
	return ok
}

func (CompanionStruct_CacheType_) Default() CacheType {
	return Companion_CacheType_.Create_Default_(Companion_DefaultCache_.Default())
}

func (_this CacheType) Dtor_Default() DefaultCache {
	return _this.Get_().(CacheType_Default).Default
}

func (_this CacheType) Dtor_No() NoCache {
	return _this.Get_().(CacheType_No).No
}

func (_this CacheType) Dtor_SingleThreaded() SingleThreadedCache {
	return _this.Get_().(CacheType_SingleThreaded).SingleThreaded
}

func (_this CacheType) Dtor_MultiThreaded() MultiThreadedCache {
	return _this.Get_().(CacheType_MultiThreaded).MultiThreaded
}

func (_this CacheType) Dtor_StormTracking() StormTrackingCache {
	return _this.Get_().(CacheType_StormTracking).StormTracking
}

func (_this CacheType) Dtor_Shared() ICryptographicMaterialsCache {
	return _this.Get_().(CacheType_Shared).Shared
}

func (_this CacheType) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CacheType_Default:
		{
			return "AwsCryptographyMaterialProvidersTypes.CacheType.Default" + "(" + _dafny.String(data.Default) + ")"
		}
	case CacheType_No:
		{
			return "AwsCryptographyMaterialProvidersTypes.CacheType.No" + "(" + _dafny.String(data.No) + ")"
		}
	case CacheType_SingleThreaded:
		{
			return "AwsCryptographyMaterialProvidersTypes.CacheType.SingleThreaded" + "(" + _dafny.String(data.SingleThreaded) + ")"
		}
	case CacheType_MultiThreaded:
		{
			return "AwsCryptographyMaterialProvidersTypes.CacheType.MultiThreaded" + "(" + _dafny.String(data.MultiThreaded) + ")"
		}
	case CacheType_StormTracking:
		{
			return "AwsCryptographyMaterialProvidersTypes.CacheType.StormTracking" + "(" + _dafny.String(data.StormTracking) + ")"
		}
	case CacheType_Shared:
		{
			return "AwsCryptographyMaterialProvidersTypes.CacheType.Shared" + "(" + _dafny.String(data.Shared) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CacheType) Equals(other CacheType) bool {
	switch data1 := _this.Get_().(type) {
	case CacheType_Default:
		{
			data2, ok := other.Get_().(CacheType_Default)
			return ok && data1.Default.Equals(data2.Default)
		}
	case CacheType_No:
		{
			data2, ok := other.Get_().(CacheType_No)
			return ok && data1.No.Equals(data2.No)
		}
	case CacheType_SingleThreaded:
		{
			data2, ok := other.Get_().(CacheType_SingleThreaded)
			return ok && data1.SingleThreaded.Equals(data2.SingleThreaded)
		}
	case CacheType_MultiThreaded:
		{
			data2, ok := other.Get_().(CacheType_MultiThreaded)
			return ok && data1.MultiThreaded.Equals(data2.MultiThreaded)
		}
	case CacheType_StormTracking:
		{
			data2, ok := other.Get_().(CacheType_StormTracking)
			return ok && data1.StormTracking.Equals(data2.StormTracking)
		}
	case CacheType_Shared:
		{
			data2, ok := other.Get_().(CacheType_Shared)
			return ok && _dafny.AreEqual(data1.Shared, data2.Shared)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CacheType) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CacheType)
	return ok && _this.Equals(typed)
}

func Type_CacheType_() _dafny.TypeDescriptor {
	return type_CacheType_{}
}

type type_CacheType_ struct {
}

func (_this type_CacheType_) Default() interface{} {
	return Companion_CacheType_.Default()
}

func (_this type_CacheType_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CacheType"
}
func (_this CacheType) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CacheType{}

// End of datatype CacheType

// Definition of class IClientSupplierCallHistory
type IClientSupplierCallHistory struct {
	dummy byte
}

func New_IClientSupplierCallHistory_() *IClientSupplierCallHistory {
	_this := IClientSupplierCallHistory{}

	return &_this
}

type CompanionStruct_IClientSupplierCallHistory_ struct {
}

var Companion_IClientSupplierCallHistory_ = CompanionStruct_IClientSupplierCallHistory_{}

func (_this *IClientSupplierCallHistory) Equals(other *IClientSupplierCallHistory) bool {
	return _this == other
}

func (_this *IClientSupplierCallHistory) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*IClientSupplierCallHistory)
	return ok && _this.Equals(other)
}

func (*IClientSupplierCallHistory) String() string {
	return "AwsCryptographyMaterialProvidersTypes.IClientSupplierCallHistory"
}

func Type_IClientSupplierCallHistory_() _dafny.TypeDescriptor {
	return type_IClientSupplierCallHistory_{}
}

type type_IClientSupplierCallHistory_ struct {
}

func (_this type_IClientSupplierCallHistory_) Default() interface{} {
	return (*IClientSupplierCallHistory)(nil)
}

func (_this type_IClientSupplierCallHistory_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.IClientSupplierCallHistory"
}
func (_this *IClientSupplierCallHistory) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &IClientSupplierCallHistory{}

// End of class IClientSupplierCallHistory

// Definition of trait IClientSupplier
type IClientSupplier interface {
	String() string
	GetClient(input GetClientInput) m_Wrappers.Result
	GetClient_k(input GetClientInput) m_Wrappers.Result
}

func (_static *CompanionStruct_IClientSupplier_) GetClient(_this IClientSupplier, input GetClientInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (_this).GetClient_k(input)
		output = _out0
		return output
	}
}

type CompanionStruct_IClientSupplier_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_IClientSupplier_ = CompanionStruct_IClientSupplier_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_IClientSupplier_) CastTo_(x interface{}) IClientSupplier {
	var t IClientSupplier
	t, _ = x.(IClientSupplier)
	return t
}

// End of trait IClientSupplier

// Definition of datatype CommitmentPolicy
type CommitmentPolicy struct {
	Data_CommitmentPolicy_
}

func (_this CommitmentPolicy) Get_() Data_CommitmentPolicy_ {
	return _this.Data_CommitmentPolicy_
}

type Data_CommitmentPolicy_ interface {
	isCommitmentPolicy()
}

type CompanionStruct_CommitmentPolicy_ struct {
}

var Companion_CommitmentPolicy_ = CompanionStruct_CommitmentPolicy_{}

type CommitmentPolicy_ESDK struct {
	ESDK ESDKCommitmentPolicy
}

func (CommitmentPolicy_ESDK) isCommitmentPolicy() {}

func (CompanionStruct_CommitmentPolicy_) Create_ESDK_(ESDK ESDKCommitmentPolicy) CommitmentPolicy {
	return CommitmentPolicy{CommitmentPolicy_ESDK{ESDK}}
}

func (_this CommitmentPolicy) Is_ESDK() bool {
	_, ok := _this.Get_().(CommitmentPolicy_ESDK)
	return ok
}

type CommitmentPolicy_DBE struct {
	DBE DBECommitmentPolicy
}

func (CommitmentPolicy_DBE) isCommitmentPolicy() {}

func (CompanionStruct_CommitmentPolicy_) Create_DBE_(DBE DBECommitmentPolicy) CommitmentPolicy {
	return CommitmentPolicy{CommitmentPolicy_DBE{DBE}}
}

func (_this CommitmentPolicy) Is_DBE() bool {
	_, ok := _this.Get_().(CommitmentPolicy_DBE)
	return ok
}

func (CompanionStruct_CommitmentPolicy_) Default() CommitmentPolicy {
	return Companion_CommitmentPolicy_.Create_ESDK_(Companion_ESDKCommitmentPolicy_.Default())
}

func (_this CommitmentPolicy) Dtor_ESDK() ESDKCommitmentPolicy {
	return _this.Get_().(CommitmentPolicy_ESDK).ESDK
}

func (_this CommitmentPolicy) Dtor_DBE() DBECommitmentPolicy {
	return _this.Get_().(CommitmentPolicy_DBE).DBE
}

func (_this CommitmentPolicy) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CommitmentPolicy_ESDK:
		{
			return "AwsCryptographyMaterialProvidersTypes.CommitmentPolicy.ESDK" + "(" + _dafny.String(data.ESDK) + ")"
		}
	case CommitmentPolicy_DBE:
		{
			return "AwsCryptographyMaterialProvidersTypes.CommitmentPolicy.DBE" + "(" + _dafny.String(data.DBE) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CommitmentPolicy) Equals(other CommitmentPolicy) bool {
	switch data1 := _this.Get_().(type) {
	case CommitmentPolicy_ESDK:
		{
			data2, ok := other.Get_().(CommitmentPolicy_ESDK)
			return ok && data1.ESDK.Equals(data2.ESDK)
		}
	case CommitmentPolicy_DBE:
		{
			data2, ok := other.Get_().(CommitmentPolicy_DBE)
			return ok && data1.DBE.Equals(data2.DBE)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CommitmentPolicy) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CommitmentPolicy)
	return ok && _this.Equals(typed)
}

func Type_CommitmentPolicy_() _dafny.TypeDescriptor {
	return type_CommitmentPolicy_{}
}

type type_CommitmentPolicy_ struct {
}

func (_this type_CommitmentPolicy_) Default() interface{} {
	return Companion_CommitmentPolicy_.Default()
}

func (_this type_CommitmentPolicy_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CommitmentPolicy"
}
func (_this CommitmentPolicy) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CommitmentPolicy{}

// End of datatype CommitmentPolicy

// Definition of class CountingNumber
type CountingNumber struct {
}

func New_CountingNumber_() *CountingNumber {
	_this := CountingNumber{}

	return &_this
}

type CompanionStruct_CountingNumber_ struct {
}

var Companion_CountingNumber_ = CompanionStruct_CountingNumber_{}

func (*CountingNumber) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CountingNumber"
}

// End of class CountingNumber

func Type_CountingNumber_() _dafny.TypeDescriptor {
	return type_CountingNumber_{}
}

type type_CountingNumber_ struct {
}

func (_this type_CountingNumber_) Default() interface{} {
	return int32(0)
}

func (_this type_CountingNumber_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CountingNumber"
}
func (_this *CompanionStruct_CountingNumber_) Is_(__source int32) bool {
	var _0_x int32 = (__source)
	_ = _0_x
	if true {
		return Companion_Default___.IsValid__CountingNumber(_0_x)
	}
	return false
}

// Definition of datatype CreateAwsKmsDiscoveryKeyringInput
type CreateAwsKmsDiscoveryKeyringInput struct {
	Data_CreateAwsKmsDiscoveryKeyringInput_
}

func (_this CreateAwsKmsDiscoveryKeyringInput) Get_() Data_CreateAwsKmsDiscoveryKeyringInput_ {
	return _this.Data_CreateAwsKmsDiscoveryKeyringInput_
}

type Data_CreateAwsKmsDiscoveryKeyringInput_ interface {
	isCreateAwsKmsDiscoveryKeyringInput()
}

type CompanionStruct_CreateAwsKmsDiscoveryKeyringInput_ struct {
}

var Companion_CreateAwsKmsDiscoveryKeyringInput_ = CompanionStruct_CreateAwsKmsDiscoveryKeyringInput_{}

type CreateAwsKmsDiscoveryKeyringInput_CreateAwsKmsDiscoveryKeyringInput struct {
	KmsClient       m_ComAmazonawsKmsTypes.IKMSClient
	DiscoveryFilter m_Wrappers.Option
	GrantTokens     m_Wrappers.Option
}

func (CreateAwsKmsDiscoveryKeyringInput_CreateAwsKmsDiscoveryKeyringInput) isCreateAwsKmsDiscoveryKeyringInput() {
}

func (CompanionStruct_CreateAwsKmsDiscoveryKeyringInput_) Create_CreateAwsKmsDiscoveryKeyringInput_(KmsClient m_ComAmazonawsKmsTypes.IKMSClient, DiscoveryFilter m_Wrappers.Option, GrantTokens m_Wrappers.Option) CreateAwsKmsDiscoveryKeyringInput {
	return CreateAwsKmsDiscoveryKeyringInput{CreateAwsKmsDiscoveryKeyringInput_CreateAwsKmsDiscoveryKeyringInput{KmsClient, DiscoveryFilter, GrantTokens}}
}

func (_this CreateAwsKmsDiscoveryKeyringInput) Is_CreateAwsKmsDiscoveryKeyringInput() bool {
	_, ok := _this.Get_().(CreateAwsKmsDiscoveryKeyringInput_CreateAwsKmsDiscoveryKeyringInput)
	return ok
}

func (CompanionStruct_CreateAwsKmsDiscoveryKeyringInput_) Default() CreateAwsKmsDiscoveryKeyringInput {
	return Companion_CreateAwsKmsDiscoveryKeyringInput_.Create_CreateAwsKmsDiscoveryKeyringInput_((m_ComAmazonawsKmsTypes.IKMSClient)(nil), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this CreateAwsKmsDiscoveryKeyringInput) Dtor_kmsClient() m_ComAmazonawsKmsTypes.IKMSClient {
	return _this.Get_().(CreateAwsKmsDiscoveryKeyringInput_CreateAwsKmsDiscoveryKeyringInput).KmsClient
}

func (_this CreateAwsKmsDiscoveryKeyringInput) Dtor_discoveryFilter() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsDiscoveryKeyringInput_CreateAwsKmsDiscoveryKeyringInput).DiscoveryFilter
}

func (_this CreateAwsKmsDiscoveryKeyringInput) Dtor_grantTokens() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsDiscoveryKeyringInput_CreateAwsKmsDiscoveryKeyringInput).GrantTokens
}

func (_this CreateAwsKmsDiscoveryKeyringInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateAwsKmsDiscoveryKeyringInput_CreateAwsKmsDiscoveryKeyringInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsDiscoveryKeyringInput.CreateAwsKmsDiscoveryKeyringInput" + "(" + _dafny.String(data.KmsClient) + ", " + _dafny.String(data.DiscoveryFilter) + ", " + _dafny.String(data.GrantTokens) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateAwsKmsDiscoveryKeyringInput) Equals(other CreateAwsKmsDiscoveryKeyringInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateAwsKmsDiscoveryKeyringInput_CreateAwsKmsDiscoveryKeyringInput:
		{
			data2, ok := other.Get_().(CreateAwsKmsDiscoveryKeyringInput_CreateAwsKmsDiscoveryKeyringInput)
			return ok && _dafny.AreEqual(data1.KmsClient, data2.KmsClient) && data1.DiscoveryFilter.Equals(data2.DiscoveryFilter) && data1.GrantTokens.Equals(data2.GrantTokens)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateAwsKmsDiscoveryKeyringInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateAwsKmsDiscoveryKeyringInput)
	return ok && _this.Equals(typed)
}

func Type_CreateAwsKmsDiscoveryKeyringInput_() _dafny.TypeDescriptor {
	return type_CreateAwsKmsDiscoveryKeyringInput_{}
}

type type_CreateAwsKmsDiscoveryKeyringInput_ struct {
}

func (_this type_CreateAwsKmsDiscoveryKeyringInput_) Default() interface{} {
	return Companion_CreateAwsKmsDiscoveryKeyringInput_.Default()
}

func (_this type_CreateAwsKmsDiscoveryKeyringInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsDiscoveryKeyringInput"
}
func (_this CreateAwsKmsDiscoveryKeyringInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateAwsKmsDiscoveryKeyringInput{}

// End of datatype CreateAwsKmsDiscoveryKeyringInput

// Definition of datatype CreateAwsKmsDiscoveryMultiKeyringInput
type CreateAwsKmsDiscoveryMultiKeyringInput struct {
	Data_CreateAwsKmsDiscoveryMultiKeyringInput_
}

func (_this CreateAwsKmsDiscoveryMultiKeyringInput) Get_() Data_CreateAwsKmsDiscoveryMultiKeyringInput_ {
	return _this.Data_CreateAwsKmsDiscoveryMultiKeyringInput_
}

type Data_CreateAwsKmsDiscoveryMultiKeyringInput_ interface {
	isCreateAwsKmsDiscoveryMultiKeyringInput()
}

type CompanionStruct_CreateAwsKmsDiscoveryMultiKeyringInput_ struct {
}

var Companion_CreateAwsKmsDiscoveryMultiKeyringInput_ = CompanionStruct_CreateAwsKmsDiscoveryMultiKeyringInput_{}

type CreateAwsKmsDiscoveryMultiKeyringInput_CreateAwsKmsDiscoveryMultiKeyringInput struct {
	Regions         _dafny.Sequence
	DiscoveryFilter m_Wrappers.Option
	ClientSupplier  m_Wrappers.Option
	GrantTokens     m_Wrappers.Option
}

func (CreateAwsKmsDiscoveryMultiKeyringInput_CreateAwsKmsDiscoveryMultiKeyringInput) isCreateAwsKmsDiscoveryMultiKeyringInput() {
}

func (CompanionStruct_CreateAwsKmsDiscoveryMultiKeyringInput_) Create_CreateAwsKmsDiscoveryMultiKeyringInput_(Regions _dafny.Sequence, DiscoveryFilter m_Wrappers.Option, ClientSupplier m_Wrappers.Option, GrantTokens m_Wrappers.Option) CreateAwsKmsDiscoveryMultiKeyringInput {
	return CreateAwsKmsDiscoveryMultiKeyringInput{CreateAwsKmsDiscoveryMultiKeyringInput_CreateAwsKmsDiscoveryMultiKeyringInput{Regions, DiscoveryFilter, ClientSupplier, GrantTokens}}
}

func (_this CreateAwsKmsDiscoveryMultiKeyringInput) Is_CreateAwsKmsDiscoveryMultiKeyringInput() bool {
	_, ok := _this.Get_().(CreateAwsKmsDiscoveryMultiKeyringInput_CreateAwsKmsDiscoveryMultiKeyringInput)
	return ok
}

func (CompanionStruct_CreateAwsKmsDiscoveryMultiKeyringInput_) Default() CreateAwsKmsDiscoveryMultiKeyringInput {
	return Companion_CreateAwsKmsDiscoveryMultiKeyringInput_.Create_CreateAwsKmsDiscoveryMultiKeyringInput_(_dafny.EmptySeq, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this CreateAwsKmsDiscoveryMultiKeyringInput) Dtor_regions() _dafny.Sequence {
	return _this.Get_().(CreateAwsKmsDiscoveryMultiKeyringInput_CreateAwsKmsDiscoveryMultiKeyringInput).Regions
}

func (_this CreateAwsKmsDiscoveryMultiKeyringInput) Dtor_discoveryFilter() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsDiscoveryMultiKeyringInput_CreateAwsKmsDiscoveryMultiKeyringInput).DiscoveryFilter
}

func (_this CreateAwsKmsDiscoveryMultiKeyringInput) Dtor_clientSupplier() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsDiscoveryMultiKeyringInput_CreateAwsKmsDiscoveryMultiKeyringInput).ClientSupplier
}

func (_this CreateAwsKmsDiscoveryMultiKeyringInput) Dtor_grantTokens() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsDiscoveryMultiKeyringInput_CreateAwsKmsDiscoveryMultiKeyringInput).GrantTokens
}

func (_this CreateAwsKmsDiscoveryMultiKeyringInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateAwsKmsDiscoveryMultiKeyringInput_CreateAwsKmsDiscoveryMultiKeyringInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsDiscoveryMultiKeyringInput.CreateAwsKmsDiscoveryMultiKeyringInput" + "(" + _dafny.String(data.Regions) + ", " + _dafny.String(data.DiscoveryFilter) + ", " + _dafny.String(data.ClientSupplier) + ", " + _dafny.String(data.GrantTokens) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateAwsKmsDiscoveryMultiKeyringInput) Equals(other CreateAwsKmsDiscoveryMultiKeyringInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateAwsKmsDiscoveryMultiKeyringInput_CreateAwsKmsDiscoveryMultiKeyringInput:
		{
			data2, ok := other.Get_().(CreateAwsKmsDiscoveryMultiKeyringInput_CreateAwsKmsDiscoveryMultiKeyringInput)
			return ok && data1.Regions.Equals(data2.Regions) && data1.DiscoveryFilter.Equals(data2.DiscoveryFilter) && data1.ClientSupplier.Equals(data2.ClientSupplier) && data1.GrantTokens.Equals(data2.GrantTokens)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateAwsKmsDiscoveryMultiKeyringInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateAwsKmsDiscoveryMultiKeyringInput)
	return ok && _this.Equals(typed)
}

func Type_CreateAwsKmsDiscoveryMultiKeyringInput_() _dafny.TypeDescriptor {
	return type_CreateAwsKmsDiscoveryMultiKeyringInput_{}
}

type type_CreateAwsKmsDiscoveryMultiKeyringInput_ struct {
}

func (_this type_CreateAwsKmsDiscoveryMultiKeyringInput_) Default() interface{} {
	return Companion_CreateAwsKmsDiscoveryMultiKeyringInput_.Default()
}

func (_this type_CreateAwsKmsDiscoveryMultiKeyringInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsDiscoveryMultiKeyringInput"
}
func (_this CreateAwsKmsDiscoveryMultiKeyringInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateAwsKmsDiscoveryMultiKeyringInput{}

// End of datatype CreateAwsKmsDiscoveryMultiKeyringInput

// Definition of datatype CreateAwsKmsEcdhKeyringInput
type CreateAwsKmsEcdhKeyringInput struct {
	Data_CreateAwsKmsEcdhKeyringInput_
}

func (_this CreateAwsKmsEcdhKeyringInput) Get_() Data_CreateAwsKmsEcdhKeyringInput_ {
	return _this.Data_CreateAwsKmsEcdhKeyringInput_
}

type Data_CreateAwsKmsEcdhKeyringInput_ interface {
	isCreateAwsKmsEcdhKeyringInput()
}

type CompanionStruct_CreateAwsKmsEcdhKeyringInput_ struct {
}

var Companion_CreateAwsKmsEcdhKeyringInput_ = CompanionStruct_CreateAwsKmsEcdhKeyringInput_{}

type CreateAwsKmsEcdhKeyringInput_CreateAwsKmsEcdhKeyringInput struct {
	KeyAgreementScheme KmsEcdhStaticConfigurations
	CurveSpec          m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec
	KmsClient          m_ComAmazonawsKmsTypes.IKMSClient
	GrantTokens        m_Wrappers.Option
}

func (CreateAwsKmsEcdhKeyringInput_CreateAwsKmsEcdhKeyringInput) isCreateAwsKmsEcdhKeyringInput() {}

func (CompanionStruct_CreateAwsKmsEcdhKeyringInput_) Create_CreateAwsKmsEcdhKeyringInput_(KeyAgreementScheme KmsEcdhStaticConfigurations, CurveSpec m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec, KmsClient m_ComAmazonawsKmsTypes.IKMSClient, GrantTokens m_Wrappers.Option) CreateAwsKmsEcdhKeyringInput {
	return CreateAwsKmsEcdhKeyringInput{CreateAwsKmsEcdhKeyringInput_CreateAwsKmsEcdhKeyringInput{KeyAgreementScheme, CurveSpec, KmsClient, GrantTokens}}
}

func (_this CreateAwsKmsEcdhKeyringInput) Is_CreateAwsKmsEcdhKeyringInput() bool {
	_, ok := _this.Get_().(CreateAwsKmsEcdhKeyringInput_CreateAwsKmsEcdhKeyringInput)
	return ok
}

func (CompanionStruct_CreateAwsKmsEcdhKeyringInput_) Default() CreateAwsKmsEcdhKeyringInput {
	return Companion_CreateAwsKmsEcdhKeyringInput_.Create_CreateAwsKmsEcdhKeyringInput_(Companion_KmsEcdhStaticConfigurations_.Default(), m_AwsCryptographyPrimitivesTypes.Companion_ECDHCurveSpec_.Default(), (m_ComAmazonawsKmsTypes.IKMSClient)(nil), m_Wrappers.Companion_Option_.Default())
}

func (_this CreateAwsKmsEcdhKeyringInput) Dtor_KeyAgreementScheme() KmsEcdhStaticConfigurations {
	return _this.Get_().(CreateAwsKmsEcdhKeyringInput_CreateAwsKmsEcdhKeyringInput).KeyAgreementScheme
}

func (_this CreateAwsKmsEcdhKeyringInput) Dtor_curveSpec() m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec {
	return _this.Get_().(CreateAwsKmsEcdhKeyringInput_CreateAwsKmsEcdhKeyringInput).CurveSpec
}

func (_this CreateAwsKmsEcdhKeyringInput) Dtor_kmsClient() m_ComAmazonawsKmsTypes.IKMSClient {
	return _this.Get_().(CreateAwsKmsEcdhKeyringInput_CreateAwsKmsEcdhKeyringInput).KmsClient
}

func (_this CreateAwsKmsEcdhKeyringInput) Dtor_grantTokens() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsEcdhKeyringInput_CreateAwsKmsEcdhKeyringInput).GrantTokens
}

func (_this CreateAwsKmsEcdhKeyringInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateAwsKmsEcdhKeyringInput_CreateAwsKmsEcdhKeyringInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsEcdhKeyringInput.CreateAwsKmsEcdhKeyringInput" + "(" + _dafny.String(data.KeyAgreementScheme) + ", " + _dafny.String(data.CurveSpec) + ", " + _dafny.String(data.KmsClient) + ", " + _dafny.String(data.GrantTokens) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateAwsKmsEcdhKeyringInput) Equals(other CreateAwsKmsEcdhKeyringInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateAwsKmsEcdhKeyringInput_CreateAwsKmsEcdhKeyringInput:
		{
			data2, ok := other.Get_().(CreateAwsKmsEcdhKeyringInput_CreateAwsKmsEcdhKeyringInput)
			return ok && data1.KeyAgreementScheme.Equals(data2.KeyAgreementScheme) && data1.CurveSpec.Equals(data2.CurveSpec) && _dafny.AreEqual(data1.KmsClient, data2.KmsClient) && data1.GrantTokens.Equals(data2.GrantTokens)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateAwsKmsEcdhKeyringInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateAwsKmsEcdhKeyringInput)
	return ok && _this.Equals(typed)
}

func Type_CreateAwsKmsEcdhKeyringInput_() _dafny.TypeDescriptor {
	return type_CreateAwsKmsEcdhKeyringInput_{}
}

type type_CreateAwsKmsEcdhKeyringInput_ struct {
}

func (_this type_CreateAwsKmsEcdhKeyringInput_) Default() interface{} {
	return Companion_CreateAwsKmsEcdhKeyringInput_.Default()
}

func (_this type_CreateAwsKmsEcdhKeyringInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsEcdhKeyringInput"
}
func (_this CreateAwsKmsEcdhKeyringInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateAwsKmsEcdhKeyringInput{}

// End of datatype CreateAwsKmsEcdhKeyringInput

// Definition of datatype CreateAwsKmsHierarchicalKeyringInput
type CreateAwsKmsHierarchicalKeyringInput struct {
	Data_CreateAwsKmsHierarchicalKeyringInput_
}

func (_this CreateAwsKmsHierarchicalKeyringInput) Get_() Data_CreateAwsKmsHierarchicalKeyringInput_ {
	return _this.Data_CreateAwsKmsHierarchicalKeyringInput_
}

type Data_CreateAwsKmsHierarchicalKeyringInput_ interface {
	isCreateAwsKmsHierarchicalKeyringInput()
}

type CompanionStruct_CreateAwsKmsHierarchicalKeyringInput_ struct {
}

var Companion_CreateAwsKmsHierarchicalKeyringInput_ = CompanionStruct_CreateAwsKmsHierarchicalKeyringInput_{}

type CreateAwsKmsHierarchicalKeyringInput_CreateAwsKmsHierarchicalKeyringInput struct {
	BranchKeyId         m_Wrappers.Option
	BranchKeyIdSupplier m_Wrappers.Option
	KeyStore            m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	TtlSeconds          int64
	Cache               m_Wrappers.Option
	PartitionId         m_Wrappers.Option
}

func (CreateAwsKmsHierarchicalKeyringInput_CreateAwsKmsHierarchicalKeyringInput) isCreateAwsKmsHierarchicalKeyringInput() {
}

func (CompanionStruct_CreateAwsKmsHierarchicalKeyringInput_) Create_CreateAwsKmsHierarchicalKeyringInput_(BranchKeyId m_Wrappers.Option, BranchKeyIdSupplier m_Wrappers.Option, KeyStore m_AwsCryptographyKeyStoreTypes.IKeyStoreClient, TtlSeconds int64, Cache m_Wrappers.Option, PartitionId m_Wrappers.Option) CreateAwsKmsHierarchicalKeyringInput {
	return CreateAwsKmsHierarchicalKeyringInput{CreateAwsKmsHierarchicalKeyringInput_CreateAwsKmsHierarchicalKeyringInput{BranchKeyId, BranchKeyIdSupplier, KeyStore, TtlSeconds, Cache, PartitionId}}
}

func (_this CreateAwsKmsHierarchicalKeyringInput) Is_CreateAwsKmsHierarchicalKeyringInput() bool {
	_, ok := _this.Get_().(CreateAwsKmsHierarchicalKeyringInput_CreateAwsKmsHierarchicalKeyringInput)
	return ok
}

func (CompanionStruct_CreateAwsKmsHierarchicalKeyringInput_) Default() CreateAwsKmsHierarchicalKeyringInput {
	return Companion_CreateAwsKmsHierarchicalKeyringInput_.Create_CreateAwsKmsHierarchicalKeyringInput_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), (m_AwsCryptographyKeyStoreTypes.IKeyStoreClient)(nil), int64(0), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this CreateAwsKmsHierarchicalKeyringInput) Dtor_branchKeyId() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsHierarchicalKeyringInput_CreateAwsKmsHierarchicalKeyringInput).BranchKeyId
}

func (_this CreateAwsKmsHierarchicalKeyringInput) Dtor_branchKeyIdSupplier() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsHierarchicalKeyringInput_CreateAwsKmsHierarchicalKeyringInput).BranchKeyIdSupplier
}

func (_this CreateAwsKmsHierarchicalKeyringInput) Dtor_keyStore() m_AwsCryptographyKeyStoreTypes.IKeyStoreClient {
	return _this.Get_().(CreateAwsKmsHierarchicalKeyringInput_CreateAwsKmsHierarchicalKeyringInput).KeyStore
}

func (_this CreateAwsKmsHierarchicalKeyringInput) Dtor_ttlSeconds() int64 {
	return _this.Get_().(CreateAwsKmsHierarchicalKeyringInput_CreateAwsKmsHierarchicalKeyringInput).TtlSeconds
}

func (_this CreateAwsKmsHierarchicalKeyringInput) Dtor_cache() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsHierarchicalKeyringInput_CreateAwsKmsHierarchicalKeyringInput).Cache
}

func (_this CreateAwsKmsHierarchicalKeyringInput) Dtor_partitionId() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsHierarchicalKeyringInput_CreateAwsKmsHierarchicalKeyringInput).PartitionId
}

func (_this CreateAwsKmsHierarchicalKeyringInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateAwsKmsHierarchicalKeyringInput_CreateAwsKmsHierarchicalKeyringInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsHierarchicalKeyringInput.CreateAwsKmsHierarchicalKeyringInput" + "(" + _dafny.String(data.BranchKeyId) + ", " + _dafny.String(data.BranchKeyIdSupplier) + ", " + _dafny.String(data.KeyStore) + ", " + _dafny.String(data.TtlSeconds) + ", " + _dafny.String(data.Cache) + ", " + _dafny.String(data.PartitionId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateAwsKmsHierarchicalKeyringInput) Equals(other CreateAwsKmsHierarchicalKeyringInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateAwsKmsHierarchicalKeyringInput_CreateAwsKmsHierarchicalKeyringInput:
		{
			data2, ok := other.Get_().(CreateAwsKmsHierarchicalKeyringInput_CreateAwsKmsHierarchicalKeyringInput)
			return ok && data1.BranchKeyId.Equals(data2.BranchKeyId) && data1.BranchKeyIdSupplier.Equals(data2.BranchKeyIdSupplier) && _dafny.AreEqual(data1.KeyStore, data2.KeyStore) && data1.TtlSeconds == data2.TtlSeconds && data1.Cache.Equals(data2.Cache) && data1.PartitionId.Equals(data2.PartitionId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateAwsKmsHierarchicalKeyringInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateAwsKmsHierarchicalKeyringInput)
	return ok && _this.Equals(typed)
}

func Type_CreateAwsKmsHierarchicalKeyringInput_() _dafny.TypeDescriptor {
	return type_CreateAwsKmsHierarchicalKeyringInput_{}
}

type type_CreateAwsKmsHierarchicalKeyringInput_ struct {
}

func (_this type_CreateAwsKmsHierarchicalKeyringInput_) Default() interface{} {
	return Companion_CreateAwsKmsHierarchicalKeyringInput_.Default()
}

func (_this type_CreateAwsKmsHierarchicalKeyringInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsHierarchicalKeyringInput"
}
func (_this CreateAwsKmsHierarchicalKeyringInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateAwsKmsHierarchicalKeyringInput{}

// End of datatype CreateAwsKmsHierarchicalKeyringInput

// Definition of datatype CreateAwsKmsKeyringInput
type CreateAwsKmsKeyringInput struct {
	Data_CreateAwsKmsKeyringInput_
}

func (_this CreateAwsKmsKeyringInput) Get_() Data_CreateAwsKmsKeyringInput_ {
	return _this.Data_CreateAwsKmsKeyringInput_
}

type Data_CreateAwsKmsKeyringInput_ interface {
	isCreateAwsKmsKeyringInput()
}

type CompanionStruct_CreateAwsKmsKeyringInput_ struct {
}

var Companion_CreateAwsKmsKeyringInput_ = CompanionStruct_CreateAwsKmsKeyringInput_{}

type CreateAwsKmsKeyringInput_CreateAwsKmsKeyringInput struct {
	KmsKeyId    _dafny.Sequence
	KmsClient   m_ComAmazonawsKmsTypes.IKMSClient
	GrantTokens m_Wrappers.Option
}

func (CreateAwsKmsKeyringInput_CreateAwsKmsKeyringInput) isCreateAwsKmsKeyringInput() {}

func (CompanionStruct_CreateAwsKmsKeyringInput_) Create_CreateAwsKmsKeyringInput_(KmsKeyId _dafny.Sequence, KmsClient m_ComAmazonawsKmsTypes.IKMSClient, GrantTokens m_Wrappers.Option) CreateAwsKmsKeyringInput {
	return CreateAwsKmsKeyringInput{CreateAwsKmsKeyringInput_CreateAwsKmsKeyringInput{KmsKeyId, KmsClient, GrantTokens}}
}

func (_this CreateAwsKmsKeyringInput) Is_CreateAwsKmsKeyringInput() bool {
	_, ok := _this.Get_().(CreateAwsKmsKeyringInput_CreateAwsKmsKeyringInput)
	return ok
}

func (CompanionStruct_CreateAwsKmsKeyringInput_) Default() CreateAwsKmsKeyringInput {
	return Companion_CreateAwsKmsKeyringInput_.Create_CreateAwsKmsKeyringInput_(_dafny.EmptySeq.SetString(), (m_ComAmazonawsKmsTypes.IKMSClient)(nil), m_Wrappers.Companion_Option_.Default())
}

func (_this CreateAwsKmsKeyringInput) Dtor_kmsKeyId() _dafny.Sequence {
	return _this.Get_().(CreateAwsKmsKeyringInput_CreateAwsKmsKeyringInput).KmsKeyId
}

func (_this CreateAwsKmsKeyringInput) Dtor_kmsClient() m_ComAmazonawsKmsTypes.IKMSClient {
	return _this.Get_().(CreateAwsKmsKeyringInput_CreateAwsKmsKeyringInput).KmsClient
}

func (_this CreateAwsKmsKeyringInput) Dtor_grantTokens() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsKeyringInput_CreateAwsKmsKeyringInput).GrantTokens
}

func (_this CreateAwsKmsKeyringInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateAwsKmsKeyringInput_CreateAwsKmsKeyringInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsKeyringInput.CreateAwsKmsKeyringInput" + "(" + _dafny.String(data.KmsKeyId) + ", " + _dafny.String(data.KmsClient) + ", " + _dafny.String(data.GrantTokens) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateAwsKmsKeyringInput) Equals(other CreateAwsKmsKeyringInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateAwsKmsKeyringInput_CreateAwsKmsKeyringInput:
		{
			data2, ok := other.Get_().(CreateAwsKmsKeyringInput_CreateAwsKmsKeyringInput)
			return ok && data1.KmsKeyId.Equals(data2.KmsKeyId) && _dafny.AreEqual(data1.KmsClient, data2.KmsClient) && data1.GrantTokens.Equals(data2.GrantTokens)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateAwsKmsKeyringInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateAwsKmsKeyringInput)
	return ok && _this.Equals(typed)
}

func Type_CreateAwsKmsKeyringInput_() _dafny.TypeDescriptor {
	return type_CreateAwsKmsKeyringInput_{}
}

type type_CreateAwsKmsKeyringInput_ struct {
}

func (_this type_CreateAwsKmsKeyringInput_) Default() interface{} {
	return Companion_CreateAwsKmsKeyringInput_.Default()
}

func (_this type_CreateAwsKmsKeyringInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsKeyringInput"
}
func (_this CreateAwsKmsKeyringInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateAwsKmsKeyringInput{}

// End of datatype CreateAwsKmsKeyringInput

// Definition of datatype CreateAwsKmsMrkDiscoveryKeyringInput
type CreateAwsKmsMrkDiscoveryKeyringInput struct {
	Data_CreateAwsKmsMrkDiscoveryKeyringInput_
}

func (_this CreateAwsKmsMrkDiscoveryKeyringInput) Get_() Data_CreateAwsKmsMrkDiscoveryKeyringInput_ {
	return _this.Data_CreateAwsKmsMrkDiscoveryKeyringInput_
}

type Data_CreateAwsKmsMrkDiscoveryKeyringInput_ interface {
	isCreateAwsKmsMrkDiscoveryKeyringInput()
}

type CompanionStruct_CreateAwsKmsMrkDiscoveryKeyringInput_ struct {
}

var Companion_CreateAwsKmsMrkDiscoveryKeyringInput_ = CompanionStruct_CreateAwsKmsMrkDiscoveryKeyringInput_{}

type CreateAwsKmsMrkDiscoveryKeyringInput_CreateAwsKmsMrkDiscoveryKeyringInput struct {
	KmsClient       m_ComAmazonawsKmsTypes.IKMSClient
	DiscoveryFilter m_Wrappers.Option
	GrantTokens     m_Wrappers.Option
	Region          _dafny.Sequence
}

func (CreateAwsKmsMrkDiscoveryKeyringInput_CreateAwsKmsMrkDiscoveryKeyringInput) isCreateAwsKmsMrkDiscoveryKeyringInput() {
}

func (CompanionStruct_CreateAwsKmsMrkDiscoveryKeyringInput_) Create_CreateAwsKmsMrkDiscoveryKeyringInput_(KmsClient m_ComAmazonawsKmsTypes.IKMSClient, DiscoveryFilter m_Wrappers.Option, GrantTokens m_Wrappers.Option, Region _dafny.Sequence) CreateAwsKmsMrkDiscoveryKeyringInput {
	return CreateAwsKmsMrkDiscoveryKeyringInput{CreateAwsKmsMrkDiscoveryKeyringInput_CreateAwsKmsMrkDiscoveryKeyringInput{KmsClient, DiscoveryFilter, GrantTokens, Region}}
}

func (_this CreateAwsKmsMrkDiscoveryKeyringInput) Is_CreateAwsKmsMrkDiscoveryKeyringInput() bool {
	_, ok := _this.Get_().(CreateAwsKmsMrkDiscoveryKeyringInput_CreateAwsKmsMrkDiscoveryKeyringInput)
	return ok
}

func (CompanionStruct_CreateAwsKmsMrkDiscoveryKeyringInput_) Default() CreateAwsKmsMrkDiscoveryKeyringInput {
	return Companion_CreateAwsKmsMrkDiscoveryKeyringInput_.Create_CreateAwsKmsMrkDiscoveryKeyringInput_((m_ComAmazonawsKmsTypes.IKMSClient)(nil), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), _dafny.EmptySeq.SetString())
}

func (_this CreateAwsKmsMrkDiscoveryKeyringInput) Dtor_kmsClient() m_ComAmazonawsKmsTypes.IKMSClient {
	return _this.Get_().(CreateAwsKmsMrkDiscoveryKeyringInput_CreateAwsKmsMrkDiscoveryKeyringInput).KmsClient
}

func (_this CreateAwsKmsMrkDiscoveryKeyringInput) Dtor_discoveryFilter() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsMrkDiscoveryKeyringInput_CreateAwsKmsMrkDiscoveryKeyringInput).DiscoveryFilter
}

func (_this CreateAwsKmsMrkDiscoveryKeyringInput) Dtor_grantTokens() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsMrkDiscoveryKeyringInput_CreateAwsKmsMrkDiscoveryKeyringInput).GrantTokens
}

func (_this CreateAwsKmsMrkDiscoveryKeyringInput) Dtor_region() _dafny.Sequence {
	return _this.Get_().(CreateAwsKmsMrkDiscoveryKeyringInput_CreateAwsKmsMrkDiscoveryKeyringInput).Region
}

func (_this CreateAwsKmsMrkDiscoveryKeyringInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateAwsKmsMrkDiscoveryKeyringInput_CreateAwsKmsMrkDiscoveryKeyringInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkDiscoveryKeyringInput.CreateAwsKmsMrkDiscoveryKeyringInput" + "(" + _dafny.String(data.KmsClient) + ", " + _dafny.String(data.DiscoveryFilter) + ", " + _dafny.String(data.GrantTokens) + ", " + _dafny.String(data.Region) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateAwsKmsMrkDiscoveryKeyringInput) Equals(other CreateAwsKmsMrkDiscoveryKeyringInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateAwsKmsMrkDiscoveryKeyringInput_CreateAwsKmsMrkDiscoveryKeyringInput:
		{
			data2, ok := other.Get_().(CreateAwsKmsMrkDiscoveryKeyringInput_CreateAwsKmsMrkDiscoveryKeyringInput)
			return ok && _dafny.AreEqual(data1.KmsClient, data2.KmsClient) && data1.DiscoveryFilter.Equals(data2.DiscoveryFilter) && data1.GrantTokens.Equals(data2.GrantTokens) && data1.Region.Equals(data2.Region)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateAwsKmsMrkDiscoveryKeyringInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateAwsKmsMrkDiscoveryKeyringInput)
	return ok && _this.Equals(typed)
}

func Type_CreateAwsKmsMrkDiscoveryKeyringInput_() _dafny.TypeDescriptor {
	return type_CreateAwsKmsMrkDiscoveryKeyringInput_{}
}

type type_CreateAwsKmsMrkDiscoveryKeyringInput_ struct {
}

func (_this type_CreateAwsKmsMrkDiscoveryKeyringInput_) Default() interface{} {
	return Companion_CreateAwsKmsMrkDiscoveryKeyringInput_.Default()
}

func (_this type_CreateAwsKmsMrkDiscoveryKeyringInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkDiscoveryKeyringInput"
}
func (_this CreateAwsKmsMrkDiscoveryKeyringInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateAwsKmsMrkDiscoveryKeyringInput{}

// End of datatype CreateAwsKmsMrkDiscoveryKeyringInput

// Definition of datatype CreateAwsKmsMrkDiscoveryMultiKeyringInput
type CreateAwsKmsMrkDiscoveryMultiKeyringInput struct {
	Data_CreateAwsKmsMrkDiscoveryMultiKeyringInput_
}

func (_this CreateAwsKmsMrkDiscoveryMultiKeyringInput) Get_() Data_CreateAwsKmsMrkDiscoveryMultiKeyringInput_ {
	return _this.Data_CreateAwsKmsMrkDiscoveryMultiKeyringInput_
}

type Data_CreateAwsKmsMrkDiscoveryMultiKeyringInput_ interface {
	isCreateAwsKmsMrkDiscoveryMultiKeyringInput()
}

type CompanionStruct_CreateAwsKmsMrkDiscoveryMultiKeyringInput_ struct {
}

var Companion_CreateAwsKmsMrkDiscoveryMultiKeyringInput_ = CompanionStruct_CreateAwsKmsMrkDiscoveryMultiKeyringInput_{}

type CreateAwsKmsMrkDiscoveryMultiKeyringInput_CreateAwsKmsMrkDiscoveryMultiKeyringInput struct {
	Regions         _dafny.Sequence
	DiscoveryFilter m_Wrappers.Option
	ClientSupplier  m_Wrappers.Option
	GrantTokens     m_Wrappers.Option
}

func (CreateAwsKmsMrkDiscoveryMultiKeyringInput_CreateAwsKmsMrkDiscoveryMultiKeyringInput) isCreateAwsKmsMrkDiscoveryMultiKeyringInput() {
}

func (CompanionStruct_CreateAwsKmsMrkDiscoveryMultiKeyringInput_) Create_CreateAwsKmsMrkDiscoveryMultiKeyringInput_(Regions _dafny.Sequence, DiscoveryFilter m_Wrappers.Option, ClientSupplier m_Wrappers.Option, GrantTokens m_Wrappers.Option) CreateAwsKmsMrkDiscoveryMultiKeyringInput {
	return CreateAwsKmsMrkDiscoveryMultiKeyringInput{CreateAwsKmsMrkDiscoveryMultiKeyringInput_CreateAwsKmsMrkDiscoveryMultiKeyringInput{Regions, DiscoveryFilter, ClientSupplier, GrantTokens}}
}

func (_this CreateAwsKmsMrkDiscoveryMultiKeyringInput) Is_CreateAwsKmsMrkDiscoveryMultiKeyringInput() bool {
	_, ok := _this.Get_().(CreateAwsKmsMrkDiscoveryMultiKeyringInput_CreateAwsKmsMrkDiscoveryMultiKeyringInput)
	return ok
}

func (CompanionStruct_CreateAwsKmsMrkDiscoveryMultiKeyringInput_) Default() CreateAwsKmsMrkDiscoveryMultiKeyringInput {
	return Companion_CreateAwsKmsMrkDiscoveryMultiKeyringInput_.Create_CreateAwsKmsMrkDiscoveryMultiKeyringInput_(_dafny.EmptySeq, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this CreateAwsKmsMrkDiscoveryMultiKeyringInput) Dtor_regions() _dafny.Sequence {
	return _this.Get_().(CreateAwsKmsMrkDiscoveryMultiKeyringInput_CreateAwsKmsMrkDiscoveryMultiKeyringInput).Regions
}

func (_this CreateAwsKmsMrkDiscoveryMultiKeyringInput) Dtor_discoveryFilter() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsMrkDiscoveryMultiKeyringInput_CreateAwsKmsMrkDiscoveryMultiKeyringInput).DiscoveryFilter
}

func (_this CreateAwsKmsMrkDiscoveryMultiKeyringInput) Dtor_clientSupplier() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsMrkDiscoveryMultiKeyringInput_CreateAwsKmsMrkDiscoveryMultiKeyringInput).ClientSupplier
}

func (_this CreateAwsKmsMrkDiscoveryMultiKeyringInput) Dtor_grantTokens() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsMrkDiscoveryMultiKeyringInput_CreateAwsKmsMrkDiscoveryMultiKeyringInput).GrantTokens
}

func (_this CreateAwsKmsMrkDiscoveryMultiKeyringInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateAwsKmsMrkDiscoveryMultiKeyringInput_CreateAwsKmsMrkDiscoveryMultiKeyringInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkDiscoveryMultiKeyringInput.CreateAwsKmsMrkDiscoveryMultiKeyringInput" + "(" + _dafny.String(data.Regions) + ", " + _dafny.String(data.DiscoveryFilter) + ", " + _dafny.String(data.ClientSupplier) + ", " + _dafny.String(data.GrantTokens) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateAwsKmsMrkDiscoveryMultiKeyringInput) Equals(other CreateAwsKmsMrkDiscoveryMultiKeyringInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateAwsKmsMrkDiscoveryMultiKeyringInput_CreateAwsKmsMrkDiscoveryMultiKeyringInput:
		{
			data2, ok := other.Get_().(CreateAwsKmsMrkDiscoveryMultiKeyringInput_CreateAwsKmsMrkDiscoveryMultiKeyringInput)
			return ok && data1.Regions.Equals(data2.Regions) && data1.DiscoveryFilter.Equals(data2.DiscoveryFilter) && data1.ClientSupplier.Equals(data2.ClientSupplier) && data1.GrantTokens.Equals(data2.GrantTokens)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateAwsKmsMrkDiscoveryMultiKeyringInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateAwsKmsMrkDiscoveryMultiKeyringInput)
	return ok && _this.Equals(typed)
}

func Type_CreateAwsKmsMrkDiscoveryMultiKeyringInput_() _dafny.TypeDescriptor {
	return type_CreateAwsKmsMrkDiscoveryMultiKeyringInput_{}
}

type type_CreateAwsKmsMrkDiscoveryMultiKeyringInput_ struct {
}

func (_this type_CreateAwsKmsMrkDiscoveryMultiKeyringInput_) Default() interface{} {
	return Companion_CreateAwsKmsMrkDiscoveryMultiKeyringInput_.Default()
}

func (_this type_CreateAwsKmsMrkDiscoveryMultiKeyringInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkDiscoveryMultiKeyringInput"
}
func (_this CreateAwsKmsMrkDiscoveryMultiKeyringInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateAwsKmsMrkDiscoveryMultiKeyringInput{}

// End of datatype CreateAwsKmsMrkDiscoveryMultiKeyringInput

// Definition of datatype CreateAwsKmsMrkKeyringInput
type CreateAwsKmsMrkKeyringInput struct {
	Data_CreateAwsKmsMrkKeyringInput_
}

func (_this CreateAwsKmsMrkKeyringInput) Get_() Data_CreateAwsKmsMrkKeyringInput_ {
	return _this.Data_CreateAwsKmsMrkKeyringInput_
}

type Data_CreateAwsKmsMrkKeyringInput_ interface {
	isCreateAwsKmsMrkKeyringInput()
}

type CompanionStruct_CreateAwsKmsMrkKeyringInput_ struct {
}

var Companion_CreateAwsKmsMrkKeyringInput_ = CompanionStruct_CreateAwsKmsMrkKeyringInput_{}

type CreateAwsKmsMrkKeyringInput_CreateAwsKmsMrkKeyringInput struct {
	KmsKeyId    _dafny.Sequence
	KmsClient   m_ComAmazonawsKmsTypes.IKMSClient
	GrantTokens m_Wrappers.Option
}

func (CreateAwsKmsMrkKeyringInput_CreateAwsKmsMrkKeyringInput) isCreateAwsKmsMrkKeyringInput() {}

func (CompanionStruct_CreateAwsKmsMrkKeyringInput_) Create_CreateAwsKmsMrkKeyringInput_(KmsKeyId _dafny.Sequence, KmsClient m_ComAmazonawsKmsTypes.IKMSClient, GrantTokens m_Wrappers.Option) CreateAwsKmsMrkKeyringInput {
	return CreateAwsKmsMrkKeyringInput{CreateAwsKmsMrkKeyringInput_CreateAwsKmsMrkKeyringInput{KmsKeyId, KmsClient, GrantTokens}}
}

func (_this CreateAwsKmsMrkKeyringInput) Is_CreateAwsKmsMrkKeyringInput() bool {
	_, ok := _this.Get_().(CreateAwsKmsMrkKeyringInput_CreateAwsKmsMrkKeyringInput)
	return ok
}

func (CompanionStruct_CreateAwsKmsMrkKeyringInput_) Default() CreateAwsKmsMrkKeyringInput {
	return Companion_CreateAwsKmsMrkKeyringInput_.Create_CreateAwsKmsMrkKeyringInput_(_dafny.EmptySeq.SetString(), (m_ComAmazonawsKmsTypes.IKMSClient)(nil), m_Wrappers.Companion_Option_.Default())
}

func (_this CreateAwsKmsMrkKeyringInput) Dtor_kmsKeyId() _dafny.Sequence {
	return _this.Get_().(CreateAwsKmsMrkKeyringInput_CreateAwsKmsMrkKeyringInput).KmsKeyId
}

func (_this CreateAwsKmsMrkKeyringInput) Dtor_kmsClient() m_ComAmazonawsKmsTypes.IKMSClient {
	return _this.Get_().(CreateAwsKmsMrkKeyringInput_CreateAwsKmsMrkKeyringInput).KmsClient
}

func (_this CreateAwsKmsMrkKeyringInput) Dtor_grantTokens() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsMrkKeyringInput_CreateAwsKmsMrkKeyringInput).GrantTokens
}

func (_this CreateAwsKmsMrkKeyringInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateAwsKmsMrkKeyringInput_CreateAwsKmsMrkKeyringInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkKeyringInput.CreateAwsKmsMrkKeyringInput" + "(" + _dafny.String(data.KmsKeyId) + ", " + _dafny.String(data.KmsClient) + ", " + _dafny.String(data.GrantTokens) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateAwsKmsMrkKeyringInput) Equals(other CreateAwsKmsMrkKeyringInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateAwsKmsMrkKeyringInput_CreateAwsKmsMrkKeyringInput:
		{
			data2, ok := other.Get_().(CreateAwsKmsMrkKeyringInput_CreateAwsKmsMrkKeyringInput)
			return ok && data1.KmsKeyId.Equals(data2.KmsKeyId) && _dafny.AreEqual(data1.KmsClient, data2.KmsClient) && data1.GrantTokens.Equals(data2.GrantTokens)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateAwsKmsMrkKeyringInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateAwsKmsMrkKeyringInput)
	return ok && _this.Equals(typed)
}

func Type_CreateAwsKmsMrkKeyringInput_() _dafny.TypeDescriptor {
	return type_CreateAwsKmsMrkKeyringInput_{}
}

type type_CreateAwsKmsMrkKeyringInput_ struct {
}

func (_this type_CreateAwsKmsMrkKeyringInput_) Default() interface{} {
	return Companion_CreateAwsKmsMrkKeyringInput_.Default()
}

func (_this type_CreateAwsKmsMrkKeyringInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkKeyringInput"
}
func (_this CreateAwsKmsMrkKeyringInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateAwsKmsMrkKeyringInput{}

// End of datatype CreateAwsKmsMrkKeyringInput

// Definition of datatype CreateAwsKmsMrkMultiKeyringInput
type CreateAwsKmsMrkMultiKeyringInput struct {
	Data_CreateAwsKmsMrkMultiKeyringInput_
}

func (_this CreateAwsKmsMrkMultiKeyringInput) Get_() Data_CreateAwsKmsMrkMultiKeyringInput_ {
	return _this.Data_CreateAwsKmsMrkMultiKeyringInput_
}

type Data_CreateAwsKmsMrkMultiKeyringInput_ interface {
	isCreateAwsKmsMrkMultiKeyringInput()
}

type CompanionStruct_CreateAwsKmsMrkMultiKeyringInput_ struct {
}

var Companion_CreateAwsKmsMrkMultiKeyringInput_ = CompanionStruct_CreateAwsKmsMrkMultiKeyringInput_{}

type CreateAwsKmsMrkMultiKeyringInput_CreateAwsKmsMrkMultiKeyringInput struct {
	Generator      m_Wrappers.Option
	KmsKeyIds      m_Wrappers.Option
	ClientSupplier m_Wrappers.Option
	GrantTokens    m_Wrappers.Option
}

func (CreateAwsKmsMrkMultiKeyringInput_CreateAwsKmsMrkMultiKeyringInput) isCreateAwsKmsMrkMultiKeyringInput() {
}

func (CompanionStruct_CreateAwsKmsMrkMultiKeyringInput_) Create_CreateAwsKmsMrkMultiKeyringInput_(Generator m_Wrappers.Option, KmsKeyIds m_Wrappers.Option, ClientSupplier m_Wrappers.Option, GrantTokens m_Wrappers.Option) CreateAwsKmsMrkMultiKeyringInput {
	return CreateAwsKmsMrkMultiKeyringInput{CreateAwsKmsMrkMultiKeyringInput_CreateAwsKmsMrkMultiKeyringInput{Generator, KmsKeyIds, ClientSupplier, GrantTokens}}
}

func (_this CreateAwsKmsMrkMultiKeyringInput) Is_CreateAwsKmsMrkMultiKeyringInput() bool {
	_, ok := _this.Get_().(CreateAwsKmsMrkMultiKeyringInput_CreateAwsKmsMrkMultiKeyringInput)
	return ok
}

func (CompanionStruct_CreateAwsKmsMrkMultiKeyringInput_) Default() CreateAwsKmsMrkMultiKeyringInput {
	return Companion_CreateAwsKmsMrkMultiKeyringInput_.Create_CreateAwsKmsMrkMultiKeyringInput_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this CreateAwsKmsMrkMultiKeyringInput) Dtor_generator() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsMrkMultiKeyringInput_CreateAwsKmsMrkMultiKeyringInput).Generator
}

func (_this CreateAwsKmsMrkMultiKeyringInput) Dtor_kmsKeyIds() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsMrkMultiKeyringInput_CreateAwsKmsMrkMultiKeyringInput).KmsKeyIds
}

func (_this CreateAwsKmsMrkMultiKeyringInput) Dtor_clientSupplier() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsMrkMultiKeyringInput_CreateAwsKmsMrkMultiKeyringInput).ClientSupplier
}

func (_this CreateAwsKmsMrkMultiKeyringInput) Dtor_grantTokens() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsMrkMultiKeyringInput_CreateAwsKmsMrkMultiKeyringInput).GrantTokens
}

func (_this CreateAwsKmsMrkMultiKeyringInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateAwsKmsMrkMultiKeyringInput_CreateAwsKmsMrkMultiKeyringInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkMultiKeyringInput.CreateAwsKmsMrkMultiKeyringInput" + "(" + _dafny.String(data.Generator) + ", " + _dafny.String(data.KmsKeyIds) + ", " + _dafny.String(data.ClientSupplier) + ", " + _dafny.String(data.GrantTokens) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateAwsKmsMrkMultiKeyringInput) Equals(other CreateAwsKmsMrkMultiKeyringInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateAwsKmsMrkMultiKeyringInput_CreateAwsKmsMrkMultiKeyringInput:
		{
			data2, ok := other.Get_().(CreateAwsKmsMrkMultiKeyringInput_CreateAwsKmsMrkMultiKeyringInput)
			return ok && data1.Generator.Equals(data2.Generator) && data1.KmsKeyIds.Equals(data2.KmsKeyIds) && data1.ClientSupplier.Equals(data2.ClientSupplier) && data1.GrantTokens.Equals(data2.GrantTokens)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateAwsKmsMrkMultiKeyringInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateAwsKmsMrkMultiKeyringInput)
	return ok && _this.Equals(typed)
}

func Type_CreateAwsKmsMrkMultiKeyringInput_() _dafny.TypeDescriptor {
	return type_CreateAwsKmsMrkMultiKeyringInput_{}
}

type type_CreateAwsKmsMrkMultiKeyringInput_ struct {
}

func (_this type_CreateAwsKmsMrkMultiKeyringInput_) Default() interface{} {
	return Companion_CreateAwsKmsMrkMultiKeyringInput_.Default()
}

func (_this type_CreateAwsKmsMrkMultiKeyringInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkMultiKeyringInput"
}
func (_this CreateAwsKmsMrkMultiKeyringInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateAwsKmsMrkMultiKeyringInput{}

// End of datatype CreateAwsKmsMrkMultiKeyringInput

// Definition of datatype CreateAwsKmsMultiKeyringInput
type CreateAwsKmsMultiKeyringInput struct {
	Data_CreateAwsKmsMultiKeyringInput_
}

func (_this CreateAwsKmsMultiKeyringInput) Get_() Data_CreateAwsKmsMultiKeyringInput_ {
	return _this.Data_CreateAwsKmsMultiKeyringInput_
}

type Data_CreateAwsKmsMultiKeyringInput_ interface {
	isCreateAwsKmsMultiKeyringInput()
}

type CompanionStruct_CreateAwsKmsMultiKeyringInput_ struct {
}

var Companion_CreateAwsKmsMultiKeyringInput_ = CompanionStruct_CreateAwsKmsMultiKeyringInput_{}

type CreateAwsKmsMultiKeyringInput_CreateAwsKmsMultiKeyringInput struct {
	Generator      m_Wrappers.Option
	KmsKeyIds      m_Wrappers.Option
	ClientSupplier m_Wrappers.Option
	GrantTokens    m_Wrappers.Option
}

func (CreateAwsKmsMultiKeyringInput_CreateAwsKmsMultiKeyringInput) isCreateAwsKmsMultiKeyringInput() {
}

func (CompanionStruct_CreateAwsKmsMultiKeyringInput_) Create_CreateAwsKmsMultiKeyringInput_(Generator m_Wrappers.Option, KmsKeyIds m_Wrappers.Option, ClientSupplier m_Wrappers.Option, GrantTokens m_Wrappers.Option) CreateAwsKmsMultiKeyringInput {
	return CreateAwsKmsMultiKeyringInput{CreateAwsKmsMultiKeyringInput_CreateAwsKmsMultiKeyringInput{Generator, KmsKeyIds, ClientSupplier, GrantTokens}}
}

func (_this CreateAwsKmsMultiKeyringInput) Is_CreateAwsKmsMultiKeyringInput() bool {
	_, ok := _this.Get_().(CreateAwsKmsMultiKeyringInput_CreateAwsKmsMultiKeyringInput)
	return ok
}

func (CompanionStruct_CreateAwsKmsMultiKeyringInput_) Default() CreateAwsKmsMultiKeyringInput {
	return Companion_CreateAwsKmsMultiKeyringInput_.Create_CreateAwsKmsMultiKeyringInput_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this CreateAwsKmsMultiKeyringInput) Dtor_generator() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsMultiKeyringInput_CreateAwsKmsMultiKeyringInput).Generator
}

func (_this CreateAwsKmsMultiKeyringInput) Dtor_kmsKeyIds() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsMultiKeyringInput_CreateAwsKmsMultiKeyringInput).KmsKeyIds
}

func (_this CreateAwsKmsMultiKeyringInput) Dtor_clientSupplier() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsMultiKeyringInput_CreateAwsKmsMultiKeyringInput).ClientSupplier
}

func (_this CreateAwsKmsMultiKeyringInput) Dtor_grantTokens() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsMultiKeyringInput_CreateAwsKmsMultiKeyringInput).GrantTokens
}

func (_this CreateAwsKmsMultiKeyringInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateAwsKmsMultiKeyringInput_CreateAwsKmsMultiKeyringInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMultiKeyringInput.CreateAwsKmsMultiKeyringInput" + "(" + _dafny.String(data.Generator) + ", " + _dafny.String(data.KmsKeyIds) + ", " + _dafny.String(data.ClientSupplier) + ", " + _dafny.String(data.GrantTokens) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateAwsKmsMultiKeyringInput) Equals(other CreateAwsKmsMultiKeyringInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateAwsKmsMultiKeyringInput_CreateAwsKmsMultiKeyringInput:
		{
			data2, ok := other.Get_().(CreateAwsKmsMultiKeyringInput_CreateAwsKmsMultiKeyringInput)
			return ok && data1.Generator.Equals(data2.Generator) && data1.KmsKeyIds.Equals(data2.KmsKeyIds) && data1.ClientSupplier.Equals(data2.ClientSupplier) && data1.GrantTokens.Equals(data2.GrantTokens)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateAwsKmsMultiKeyringInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateAwsKmsMultiKeyringInput)
	return ok && _this.Equals(typed)
}

func Type_CreateAwsKmsMultiKeyringInput_() _dafny.TypeDescriptor {
	return type_CreateAwsKmsMultiKeyringInput_{}
}

type type_CreateAwsKmsMultiKeyringInput_ struct {
}

func (_this type_CreateAwsKmsMultiKeyringInput_) Default() interface{} {
	return Companion_CreateAwsKmsMultiKeyringInput_.Default()
}

func (_this type_CreateAwsKmsMultiKeyringInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMultiKeyringInput"
}
func (_this CreateAwsKmsMultiKeyringInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateAwsKmsMultiKeyringInput{}

// End of datatype CreateAwsKmsMultiKeyringInput

// Definition of datatype CreateAwsKmsRsaKeyringInput
type CreateAwsKmsRsaKeyringInput struct {
	Data_CreateAwsKmsRsaKeyringInput_
}

func (_this CreateAwsKmsRsaKeyringInput) Get_() Data_CreateAwsKmsRsaKeyringInput_ {
	return _this.Data_CreateAwsKmsRsaKeyringInput_
}

type Data_CreateAwsKmsRsaKeyringInput_ interface {
	isCreateAwsKmsRsaKeyringInput()
}

type CompanionStruct_CreateAwsKmsRsaKeyringInput_ struct {
}

var Companion_CreateAwsKmsRsaKeyringInput_ = CompanionStruct_CreateAwsKmsRsaKeyringInput_{}

type CreateAwsKmsRsaKeyringInput_CreateAwsKmsRsaKeyringInput struct {
	PublicKey           m_Wrappers.Option
	KmsKeyId            _dafny.Sequence
	EncryptionAlgorithm m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec
	KmsClient           m_Wrappers.Option
	GrantTokens         m_Wrappers.Option
}

func (CreateAwsKmsRsaKeyringInput_CreateAwsKmsRsaKeyringInput) isCreateAwsKmsRsaKeyringInput() {}

func (CompanionStruct_CreateAwsKmsRsaKeyringInput_) Create_CreateAwsKmsRsaKeyringInput_(PublicKey m_Wrappers.Option, KmsKeyId _dafny.Sequence, EncryptionAlgorithm m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec, KmsClient m_Wrappers.Option, GrantTokens m_Wrappers.Option) CreateAwsKmsRsaKeyringInput {
	return CreateAwsKmsRsaKeyringInput{CreateAwsKmsRsaKeyringInput_CreateAwsKmsRsaKeyringInput{PublicKey, KmsKeyId, EncryptionAlgorithm, KmsClient, GrantTokens}}
}

func (_this CreateAwsKmsRsaKeyringInput) Is_CreateAwsKmsRsaKeyringInput() bool {
	_, ok := _this.Get_().(CreateAwsKmsRsaKeyringInput_CreateAwsKmsRsaKeyringInput)
	return ok
}

func (CompanionStruct_CreateAwsKmsRsaKeyringInput_) Default() CreateAwsKmsRsaKeyringInput {
	return Companion_CreateAwsKmsRsaKeyringInput_.Create_CreateAwsKmsRsaKeyringInput_(m_Wrappers.Companion_Option_.Default(), _dafny.EmptySeq.SetString(), m_ComAmazonawsKmsTypes.Companion_EncryptionAlgorithmSpec_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this CreateAwsKmsRsaKeyringInput) Dtor_publicKey() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsRsaKeyringInput_CreateAwsKmsRsaKeyringInput).PublicKey
}

func (_this CreateAwsKmsRsaKeyringInput) Dtor_kmsKeyId() _dafny.Sequence {
	return _this.Get_().(CreateAwsKmsRsaKeyringInput_CreateAwsKmsRsaKeyringInput).KmsKeyId
}

func (_this CreateAwsKmsRsaKeyringInput) Dtor_encryptionAlgorithm() m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec {
	return _this.Get_().(CreateAwsKmsRsaKeyringInput_CreateAwsKmsRsaKeyringInput).EncryptionAlgorithm
}

func (_this CreateAwsKmsRsaKeyringInput) Dtor_kmsClient() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsRsaKeyringInput_CreateAwsKmsRsaKeyringInput).KmsClient
}

func (_this CreateAwsKmsRsaKeyringInput) Dtor_grantTokens() m_Wrappers.Option {
	return _this.Get_().(CreateAwsKmsRsaKeyringInput_CreateAwsKmsRsaKeyringInput).GrantTokens
}

func (_this CreateAwsKmsRsaKeyringInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateAwsKmsRsaKeyringInput_CreateAwsKmsRsaKeyringInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsRsaKeyringInput.CreateAwsKmsRsaKeyringInput" + "(" + _dafny.String(data.PublicKey) + ", " + _dafny.String(data.KmsKeyId) + ", " + _dafny.String(data.EncryptionAlgorithm) + ", " + _dafny.String(data.KmsClient) + ", " + _dafny.String(data.GrantTokens) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateAwsKmsRsaKeyringInput) Equals(other CreateAwsKmsRsaKeyringInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateAwsKmsRsaKeyringInput_CreateAwsKmsRsaKeyringInput:
		{
			data2, ok := other.Get_().(CreateAwsKmsRsaKeyringInput_CreateAwsKmsRsaKeyringInput)
			return ok && data1.PublicKey.Equals(data2.PublicKey) && data1.KmsKeyId.Equals(data2.KmsKeyId) && data1.EncryptionAlgorithm.Equals(data2.EncryptionAlgorithm) && data1.KmsClient.Equals(data2.KmsClient) && data1.GrantTokens.Equals(data2.GrantTokens)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateAwsKmsRsaKeyringInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateAwsKmsRsaKeyringInput)
	return ok && _this.Equals(typed)
}

func Type_CreateAwsKmsRsaKeyringInput_() _dafny.TypeDescriptor {
	return type_CreateAwsKmsRsaKeyringInput_{}
}

type type_CreateAwsKmsRsaKeyringInput_ struct {
}

func (_this type_CreateAwsKmsRsaKeyringInput_) Default() interface{} {
	return Companion_CreateAwsKmsRsaKeyringInput_.Default()
}

func (_this type_CreateAwsKmsRsaKeyringInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateAwsKmsRsaKeyringInput"
}
func (_this CreateAwsKmsRsaKeyringInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateAwsKmsRsaKeyringInput{}

// End of datatype CreateAwsKmsRsaKeyringInput

// Definition of datatype CreateCryptographicMaterialsCacheInput
type CreateCryptographicMaterialsCacheInput struct {
	Data_CreateCryptographicMaterialsCacheInput_
}

func (_this CreateCryptographicMaterialsCacheInput) Get_() Data_CreateCryptographicMaterialsCacheInput_ {
	return _this.Data_CreateCryptographicMaterialsCacheInput_
}

type Data_CreateCryptographicMaterialsCacheInput_ interface {
	isCreateCryptographicMaterialsCacheInput()
}

type CompanionStruct_CreateCryptographicMaterialsCacheInput_ struct {
}

var Companion_CreateCryptographicMaterialsCacheInput_ = CompanionStruct_CreateCryptographicMaterialsCacheInput_{}

type CreateCryptographicMaterialsCacheInput_CreateCryptographicMaterialsCacheInput struct {
	Cache CacheType
}

func (CreateCryptographicMaterialsCacheInput_CreateCryptographicMaterialsCacheInput) isCreateCryptographicMaterialsCacheInput() {
}

func (CompanionStruct_CreateCryptographicMaterialsCacheInput_) Create_CreateCryptographicMaterialsCacheInput_(Cache CacheType) CreateCryptographicMaterialsCacheInput {
	return CreateCryptographicMaterialsCacheInput{CreateCryptographicMaterialsCacheInput_CreateCryptographicMaterialsCacheInput{Cache}}
}

func (_this CreateCryptographicMaterialsCacheInput) Is_CreateCryptographicMaterialsCacheInput() bool {
	_, ok := _this.Get_().(CreateCryptographicMaterialsCacheInput_CreateCryptographicMaterialsCacheInput)
	return ok
}

func (CompanionStruct_CreateCryptographicMaterialsCacheInput_) Default() CreateCryptographicMaterialsCacheInput {
	return Companion_CreateCryptographicMaterialsCacheInput_.Create_CreateCryptographicMaterialsCacheInput_(Companion_CacheType_.Default())
}

func (_this CreateCryptographicMaterialsCacheInput) Dtor_cache() CacheType {
	return _this.Get_().(CreateCryptographicMaterialsCacheInput_CreateCryptographicMaterialsCacheInput).Cache
}

func (_this CreateCryptographicMaterialsCacheInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateCryptographicMaterialsCacheInput_CreateCryptographicMaterialsCacheInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateCryptographicMaterialsCacheInput.CreateCryptographicMaterialsCacheInput" + "(" + _dafny.String(data.Cache) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateCryptographicMaterialsCacheInput) Equals(other CreateCryptographicMaterialsCacheInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateCryptographicMaterialsCacheInput_CreateCryptographicMaterialsCacheInput:
		{
			data2, ok := other.Get_().(CreateCryptographicMaterialsCacheInput_CreateCryptographicMaterialsCacheInput)
			return ok && data1.Cache.Equals(data2.Cache)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateCryptographicMaterialsCacheInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateCryptographicMaterialsCacheInput)
	return ok && _this.Equals(typed)
}

func Type_CreateCryptographicMaterialsCacheInput_() _dafny.TypeDescriptor {
	return type_CreateCryptographicMaterialsCacheInput_{}
}

type type_CreateCryptographicMaterialsCacheInput_ struct {
}

func (_this type_CreateCryptographicMaterialsCacheInput_) Default() interface{} {
	return Companion_CreateCryptographicMaterialsCacheInput_.Default()
}

func (_this type_CreateCryptographicMaterialsCacheInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateCryptographicMaterialsCacheInput"
}
func (_this CreateCryptographicMaterialsCacheInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateCryptographicMaterialsCacheInput{}

// End of datatype CreateCryptographicMaterialsCacheInput

// Definition of datatype CreateDefaultClientSupplierInput
type CreateDefaultClientSupplierInput struct {
	Data_CreateDefaultClientSupplierInput_
}

func (_this CreateDefaultClientSupplierInput) Get_() Data_CreateDefaultClientSupplierInput_ {
	return _this.Data_CreateDefaultClientSupplierInput_
}

type Data_CreateDefaultClientSupplierInput_ interface {
	isCreateDefaultClientSupplierInput()
}

type CompanionStruct_CreateDefaultClientSupplierInput_ struct {
}

var Companion_CreateDefaultClientSupplierInput_ = CompanionStruct_CreateDefaultClientSupplierInput_{}

type CreateDefaultClientSupplierInput_CreateDefaultClientSupplierInput struct {
}

func (CreateDefaultClientSupplierInput_CreateDefaultClientSupplierInput) isCreateDefaultClientSupplierInput() {
}

func (CompanionStruct_CreateDefaultClientSupplierInput_) Create_CreateDefaultClientSupplierInput_() CreateDefaultClientSupplierInput {
	return CreateDefaultClientSupplierInput{CreateDefaultClientSupplierInput_CreateDefaultClientSupplierInput{}}
}

func (_this CreateDefaultClientSupplierInput) Is_CreateDefaultClientSupplierInput() bool {
	_, ok := _this.Get_().(CreateDefaultClientSupplierInput_CreateDefaultClientSupplierInput)
	return ok
}

func (CompanionStruct_CreateDefaultClientSupplierInput_) Default() CreateDefaultClientSupplierInput {
	return Companion_CreateDefaultClientSupplierInput_.Create_CreateDefaultClientSupplierInput_()
}

func (_ CompanionStruct_CreateDefaultClientSupplierInput_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_CreateDefaultClientSupplierInput_.Create_CreateDefaultClientSupplierInput_(), true
		default:
			return CreateDefaultClientSupplierInput{}, false
		}
	}
}

func (_this CreateDefaultClientSupplierInput) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case CreateDefaultClientSupplierInput_CreateDefaultClientSupplierInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateDefaultClientSupplierInput.CreateDefaultClientSupplierInput"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateDefaultClientSupplierInput) Equals(other CreateDefaultClientSupplierInput) bool {
	switch _this.Get_().(type) {
	case CreateDefaultClientSupplierInput_CreateDefaultClientSupplierInput:
		{
			_, ok := other.Get_().(CreateDefaultClientSupplierInput_CreateDefaultClientSupplierInput)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateDefaultClientSupplierInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateDefaultClientSupplierInput)
	return ok && _this.Equals(typed)
}

func Type_CreateDefaultClientSupplierInput_() _dafny.TypeDescriptor {
	return type_CreateDefaultClientSupplierInput_{}
}

type type_CreateDefaultClientSupplierInput_ struct {
}

func (_this type_CreateDefaultClientSupplierInput_) Default() interface{} {
	return Companion_CreateDefaultClientSupplierInput_.Default()
}

func (_this type_CreateDefaultClientSupplierInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateDefaultClientSupplierInput"
}
func (_this CreateDefaultClientSupplierInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateDefaultClientSupplierInput{}

// End of datatype CreateDefaultClientSupplierInput

// Definition of datatype CreateDefaultCryptographicMaterialsManagerInput
type CreateDefaultCryptographicMaterialsManagerInput struct {
	Data_CreateDefaultCryptographicMaterialsManagerInput_
}

func (_this CreateDefaultCryptographicMaterialsManagerInput) Get_() Data_CreateDefaultCryptographicMaterialsManagerInput_ {
	return _this.Data_CreateDefaultCryptographicMaterialsManagerInput_
}

type Data_CreateDefaultCryptographicMaterialsManagerInput_ interface {
	isCreateDefaultCryptographicMaterialsManagerInput()
}

type CompanionStruct_CreateDefaultCryptographicMaterialsManagerInput_ struct {
}

var Companion_CreateDefaultCryptographicMaterialsManagerInput_ = CompanionStruct_CreateDefaultCryptographicMaterialsManagerInput_{}

type CreateDefaultCryptographicMaterialsManagerInput_CreateDefaultCryptographicMaterialsManagerInput struct {
	Keyring IKeyring
}

func (CreateDefaultCryptographicMaterialsManagerInput_CreateDefaultCryptographicMaterialsManagerInput) isCreateDefaultCryptographicMaterialsManagerInput() {
}

func (CompanionStruct_CreateDefaultCryptographicMaterialsManagerInput_) Create_CreateDefaultCryptographicMaterialsManagerInput_(Keyring IKeyring) CreateDefaultCryptographicMaterialsManagerInput {
	return CreateDefaultCryptographicMaterialsManagerInput{CreateDefaultCryptographicMaterialsManagerInput_CreateDefaultCryptographicMaterialsManagerInput{Keyring}}
}

func (_this CreateDefaultCryptographicMaterialsManagerInput) Is_CreateDefaultCryptographicMaterialsManagerInput() bool {
	_, ok := _this.Get_().(CreateDefaultCryptographicMaterialsManagerInput_CreateDefaultCryptographicMaterialsManagerInput)
	return ok
}

func (CompanionStruct_CreateDefaultCryptographicMaterialsManagerInput_) Default() CreateDefaultCryptographicMaterialsManagerInput {
	return Companion_CreateDefaultCryptographicMaterialsManagerInput_.Create_CreateDefaultCryptographicMaterialsManagerInput_((IKeyring)(nil))
}

func (_this CreateDefaultCryptographicMaterialsManagerInput) Dtor_keyring() IKeyring {
	return _this.Get_().(CreateDefaultCryptographicMaterialsManagerInput_CreateDefaultCryptographicMaterialsManagerInput).Keyring
}

func (_this CreateDefaultCryptographicMaterialsManagerInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateDefaultCryptographicMaterialsManagerInput_CreateDefaultCryptographicMaterialsManagerInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateDefaultCryptographicMaterialsManagerInput.CreateDefaultCryptographicMaterialsManagerInput" + "(" + _dafny.String(data.Keyring) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateDefaultCryptographicMaterialsManagerInput) Equals(other CreateDefaultCryptographicMaterialsManagerInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateDefaultCryptographicMaterialsManagerInput_CreateDefaultCryptographicMaterialsManagerInput:
		{
			data2, ok := other.Get_().(CreateDefaultCryptographicMaterialsManagerInput_CreateDefaultCryptographicMaterialsManagerInput)
			return ok && _dafny.AreEqual(data1.Keyring, data2.Keyring)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateDefaultCryptographicMaterialsManagerInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateDefaultCryptographicMaterialsManagerInput)
	return ok && _this.Equals(typed)
}

func Type_CreateDefaultCryptographicMaterialsManagerInput_() _dafny.TypeDescriptor {
	return type_CreateDefaultCryptographicMaterialsManagerInput_{}
}

type type_CreateDefaultCryptographicMaterialsManagerInput_ struct {
}

func (_this type_CreateDefaultCryptographicMaterialsManagerInput_) Default() interface{} {
	return Companion_CreateDefaultCryptographicMaterialsManagerInput_.Default()
}

func (_this type_CreateDefaultCryptographicMaterialsManagerInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateDefaultCryptographicMaterialsManagerInput"
}
func (_this CreateDefaultCryptographicMaterialsManagerInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateDefaultCryptographicMaterialsManagerInput{}

// End of datatype CreateDefaultCryptographicMaterialsManagerInput

// Definition of datatype CreateMultiKeyringInput
type CreateMultiKeyringInput struct {
	Data_CreateMultiKeyringInput_
}

func (_this CreateMultiKeyringInput) Get_() Data_CreateMultiKeyringInput_ {
	return _this.Data_CreateMultiKeyringInput_
}

type Data_CreateMultiKeyringInput_ interface {
	isCreateMultiKeyringInput()
}

type CompanionStruct_CreateMultiKeyringInput_ struct {
}

var Companion_CreateMultiKeyringInput_ = CompanionStruct_CreateMultiKeyringInput_{}

type CreateMultiKeyringInput_CreateMultiKeyringInput struct {
	Generator     m_Wrappers.Option
	ChildKeyrings _dafny.Sequence
}

func (CreateMultiKeyringInput_CreateMultiKeyringInput) isCreateMultiKeyringInput() {}

func (CompanionStruct_CreateMultiKeyringInput_) Create_CreateMultiKeyringInput_(Generator m_Wrappers.Option, ChildKeyrings _dafny.Sequence) CreateMultiKeyringInput {
	return CreateMultiKeyringInput{CreateMultiKeyringInput_CreateMultiKeyringInput{Generator, ChildKeyrings}}
}

func (_this CreateMultiKeyringInput) Is_CreateMultiKeyringInput() bool {
	_, ok := _this.Get_().(CreateMultiKeyringInput_CreateMultiKeyringInput)
	return ok
}

func (CompanionStruct_CreateMultiKeyringInput_) Default() CreateMultiKeyringInput {
	return Companion_CreateMultiKeyringInput_.Create_CreateMultiKeyringInput_(m_Wrappers.Companion_Option_.Default(), _dafny.EmptySeq)
}

func (_this CreateMultiKeyringInput) Dtor_generator() m_Wrappers.Option {
	return _this.Get_().(CreateMultiKeyringInput_CreateMultiKeyringInput).Generator
}

func (_this CreateMultiKeyringInput) Dtor_childKeyrings() _dafny.Sequence {
	return _this.Get_().(CreateMultiKeyringInput_CreateMultiKeyringInput).ChildKeyrings
}

func (_this CreateMultiKeyringInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateMultiKeyringInput_CreateMultiKeyringInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateMultiKeyringInput.CreateMultiKeyringInput" + "(" + _dafny.String(data.Generator) + ", " + _dafny.String(data.ChildKeyrings) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateMultiKeyringInput) Equals(other CreateMultiKeyringInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateMultiKeyringInput_CreateMultiKeyringInput:
		{
			data2, ok := other.Get_().(CreateMultiKeyringInput_CreateMultiKeyringInput)
			return ok && data1.Generator.Equals(data2.Generator) && data1.ChildKeyrings.Equals(data2.ChildKeyrings)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateMultiKeyringInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateMultiKeyringInput)
	return ok && _this.Equals(typed)
}

func Type_CreateMultiKeyringInput_() _dafny.TypeDescriptor {
	return type_CreateMultiKeyringInput_{}
}

type type_CreateMultiKeyringInput_ struct {
}

func (_this type_CreateMultiKeyringInput_) Default() interface{} {
	return Companion_CreateMultiKeyringInput_.Default()
}

func (_this type_CreateMultiKeyringInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateMultiKeyringInput"
}
func (_this CreateMultiKeyringInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateMultiKeyringInput{}

// End of datatype CreateMultiKeyringInput

// Definition of datatype CreateRawAesKeyringInput
type CreateRawAesKeyringInput struct {
	Data_CreateRawAesKeyringInput_
}

func (_this CreateRawAesKeyringInput) Get_() Data_CreateRawAesKeyringInput_ {
	return _this.Data_CreateRawAesKeyringInput_
}

type Data_CreateRawAesKeyringInput_ interface {
	isCreateRawAesKeyringInput()
}

type CompanionStruct_CreateRawAesKeyringInput_ struct {
}

var Companion_CreateRawAesKeyringInput_ = CompanionStruct_CreateRawAesKeyringInput_{}

type CreateRawAesKeyringInput_CreateRawAesKeyringInput struct {
	KeyNamespace _dafny.Sequence
	KeyName      _dafny.Sequence
	WrappingKey  _dafny.Sequence
	WrappingAlg  AesWrappingAlg
}

func (CreateRawAesKeyringInput_CreateRawAesKeyringInput) isCreateRawAesKeyringInput() {}

func (CompanionStruct_CreateRawAesKeyringInput_) Create_CreateRawAesKeyringInput_(KeyNamespace _dafny.Sequence, KeyName _dafny.Sequence, WrappingKey _dafny.Sequence, WrappingAlg AesWrappingAlg) CreateRawAesKeyringInput {
	return CreateRawAesKeyringInput{CreateRawAesKeyringInput_CreateRawAesKeyringInput{KeyNamespace, KeyName, WrappingKey, WrappingAlg}}
}

func (_this CreateRawAesKeyringInput) Is_CreateRawAesKeyringInput() bool {
	_, ok := _this.Get_().(CreateRawAesKeyringInput_CreateRawAesKeyringInput)
	return ok
}

func (CompanionStruct_CreateRawAesKeyringInput_) Default() CreateRawAesKeyringInput {
	return Companion_CreateRawAesKeyringInput_.Create_CreateRawAesKeyringInput_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), _dafny.EmptySeq, Companion_AesWrappingAlg_.Default())
}

func (_this CreateRawAesKeyringInput) Dtor_keyNamespace() _dafny.Sequence {
	return _this.Get_().(CreateRawAesKeyringInput_CreateRawAesKeyringInput).KeyNamespace
}

func (_this CreateRawAesKeyringInput) Dtor_keyName() _dafny.Sequence {
	return _this.Get_().(CreateRawAesKeyringInput_CreateRawAesKeyringInput).KeyName
}

func (_this CreateRawAesKeyringInput) Dtor_wrappingKey() _dafny.Sequence {
	return _this.Get_().(CreateRawAesKeyringInput_CreateRawAesKeyringInput).WrappingKey
}

func (_this CreateRawAesKeyringInput) Dtor_wrappingAlg() AesWrappingAlg {
	return _this.Get_().(CreateRawAesKeyringInput_CreateRawAesKeyringInput).WrappingAlg
}

func (_this CreateRawAesKeyringInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateRawAesKeyringInput_CreateRawAesKeyringInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateRawAesKeyringInput.CreateRawAesKeyringInput" + "(" + _dafny.String(data.KeyNamespace) + ", " + _dafny.String(data.KeyName) + ", " + _dafny.String(data.WrappingKey) + ", " + _dafny.String(data.WrappingAlg) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateRawAesKeyringInput) Equals(other CreateRawAesKeyringInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateRawAesKeyringInput_CreateRawAesKeyringInput:
		{
			data2, ok := other.Get_().(CreateRawAesKeyringInput_CreateRawAesKeyringInput)
			return ok && data1.KeyNamespace.Equals(data2.KeyNamespace) && data1.KeyName.Equals(data2.KeyName) && data1.WrappingKey.Equals(data2.WrappingKey) && data1.WrappingAlg.Equals(data2.WrappingAlg)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateRawAesKeyringInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateRawAesKeyringInput)
	return ok && _this.Equals(typed)
}

func Type_CreateRawAesKeyringInput_() _dafny.TypeDescriptor {
	return type_CreateRawAesKeyringInput_{}
}

type type_CreateRawAesKeyringInput_ struct {
}

func (_this type_CreateRawAesKeyringInput_) Default() interface{} {
	return Companion_CreateRawAesKeyringInput_.Default()
}

func (_this type_CreateRawAesKeyringInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateRawAesKeyringInput"
}
func (_this CreateRawAesKeyringInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateRawAesKeyringInput{}

// End of datatype CreateRawAesKeyringInput

// Definition of datatype CreateRawEcdhKeyringInput
type CreateRawEcdhKeyringInput struct {
	Data_CreateRawEcdhKeyringInput_
}

func (_this CreateRawEcdhKeyringInput) Get_() Data_CreateRawEcdhKeyringInput_ {
	return _this.Data_CreateRawEcdhKeyringInput_
}

type Data_CreateRawEcdhKeyringInput_ interface {
	isCreateRawEcdhKeyringInput()
}

type CompanionStruct_CreateRawEcdhKeyringInput_ struct {
}

var Companion_CreateRawEcdhKeyringInput_ = CompanionStruct_CreateRawEcdhKeyringInput_{}

type CreateRawEcdhKeyringInput_CreateRawEcdhKeyringInput struct {
	KeyAgreementScheme RawEcdhStaticConfigurations
	CurveSpec          m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec
}

func (CreateRawEcdhKeyringInput_CreateRawEcdhKeyringInput) isCreateRawEcdhKeyringInput() {}

func (CompanionStruct_CreateRawEcdhKeyringInput_) Create_CreateRawEcdhKeyringInput_(KeyAgreementScheme RawEcdhStaticConfigurations, CurveSpec m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec) CreateRawEcdhKeyringInput {
	return CreateRawEcdhKeyringInput{CreateRawEcdhKeyringInput_CreateRawEcdhKeyringInput{KeyAgreementScheme, CurveSpec}}
}

func (_this CreateRawEcdhKeyringInput) Is_CreateRawEcdhKeyringInput() bool {
	_, ok := _this.Get_().(CreateRawEcdhKeyringInput_CreateRawEcdhKeyringInput)
	return ok
}

func (CompanionStruct_CreateRawEcdhKeyringInput_) Default() CreateRawEcdhKeyringInput {
	return Companion_CreateRawEcdhKeyringInput_.Create_CreateRawEcdhKeyringInput_(Companion_RawEcdhStaticConfigurations_.Default(), m_AwsCryptographyPrimitivesTypes.Companion_ECDHCurveSpec_.Default())
}

func (_this CreateRawEcdhKeyringInput) Dtor_KeyAgreementScheme() RawEcdhStaticConfigurations {
	return _this.Get_().(CreateRawEcdhKeyringInput_CreateRawEcdhKeyringInput).KeyAgreementScheme
}

func (_this CreateRawEcdhKeyringInput) Dtor_curveSpec() m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec {
	return _this.Get_().(CreateRawEcdhKeyringInput_CreateRawEcdhKeyringInput).CurveSpec
}

func (_this CreateRawEcdhKeyringInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateRawEcdhKeyringInput_CreateRawEcdhKeyringInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateRawEcdhKeyringInput.CreateRawEcdhKeyringInput" + "(" + _dafny.String(data.KeyAgreementScheme) + ", " + _dafny.String(data.CurveSpec) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateRawEcdhKeyringInput) Equals(other CreateRawEcdhKeyringInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateRawEcdhKeyringInput_CreateRawEcdhKeyringInput:
		{
			data2, ok := other.Get_().(CreateRawEcdhKeyringInput_CreateRawEcdhKeyringInput)
			return ok && data1.KeyAgreementScheme.Equals(data2.KeyAgreementScheme) && data1.CurveSpec.Equals(data2.CurveSpec)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateRawEcdhKeyringInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateRawEcdhKeyringInput)
	return ok && _this.Equals(typed)
}

func Type_CreateRawEcdhKeyringInput_() _dafny.TypeDescriptor {
	return type_CreateRawEcdhKeyringInput_{}
}

type type_CreateRawEcdhKeyringInput_ struct {
}

func (_this type_CreateRawEcdhKeyringInput_) Default() interface{} {
	return Companion_CreateRawEcdhKeyringInput_.Default()
}

func (_this type_CreateRawEcdhKeyringInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateRawEcdhKeyringInput"
}
func (_this CreateRawEcdhKeyringInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateRawEcdhKeyringInput{}

// End of datatype CreateRawEcdhKeyringInput

// Definition of datatype CreateRawRsaKeyringInput
type CreateRawRsaKeyringInput struct {
	Data_CreateRawRsaKeyringInput_
}

func (_this CreateRawRsaKeyringInput) Get_() Data_CreateRawRsaKeyringInput_ {
	return _this.Data_CreateRawRsaKeyringInput_
}

type Data_CreateRawRsaKeyringInput_ interface {
	isCreateRawRsaKeyringInput()
}

type CompanionStruct_CreateRawRsaKeyringInput_ struct {
}

var Companion_CreateRawRsaKeyringInput_ = CompanionStruct_CreateRawRsaKeyringInput_{}

type CreateRawRsaKeyringInput_CreateRawRsaKeyringInput struct {
	KeyNamespace  _dafny.Sequence
	KeyName       _dafny.Sequence
	PaddingScheme PaddingScheme
	PublicKey     m_Wrappers.Option
	PrivateKey    m_Wrappers.Option
}

func (CreateRawRsaKeyringInput_CreateRawRsaKeyringInput) isCreateRawRsaKeyringInput() {}

func (CompanionStruct_CreateRawRsaKeyringInput_) Create_CreateRawRsaKeyringInput_(KeyNamespace _dafny.Sequence, KeyName _dafny.Sequence, PaddingScheme PaddingScheme, PublicKey m_Wrappers.Option, PrivateKey m_Wrappers.Option) CreateRawRsaKeyringInput {
	return CreateRawRsaKeyringInput{CreateRawRsaKeyringInput_CreateRawRsaKeyringInput{KeyNamespace, KeyName, PaddingScheme, PublicKey, PrivateKey}}
}

func (_this CreateRawRsaKeyringInput) Is_CreateRawRsaKeyringInput() bool {
	_, ok := _this.Get_().(CreateRawRsaKeyringInput_CreateRawRsaKeyringInput)
	return ok
}

func (CompanionStruct_CreateRawRsaKeyringInput_) Default() CreateRawRsaKeyringInput {
	return Companion_CreateRawRsaKeyringInput_.Create_CreateRawRsaKeyringInput_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), Companion_PaddingScheme_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this CreateRawRsaKeyringInput) Dtor_keyNamespace() _dafny.Sequence {
	return _this.Get_().(CreateRawRsaKeyringInput_CreateRawRsaKeyringInput).KeyNamespace
}

func (_this CreateRawRsaKeyringInput) Dtor_keyName() _dafny.Sequence {
	return _this.Get_().(CreateRawRsaKeyringInput_CreateRawRsaKeyringInput).KeyName
}

func (_this CreateRawRsaKeyringInput) Dtor_paddingScheme() PaddingScheme {
	return _this.Get_().(CreateRawRsaKeyringInput_CreateRawRsaKeyringInput).PaddingScheme
}

func (_this CreateRawRsaKeyringInput) Dtor_publicKey() m_Wrappers.Option {
	return _this.Get_().(CreateRawRsaKeyringInput_CreateRawRsaKeyringInput).PublicKey
}

func (_this CreateRawRsaKeyringInput) Dtor_privateKey() m_Wrappers.Option {
	return _this.Get_().(CreateRawRsaKeyringInput_CreateRawRsaKeyringInput).PrivateKey
}

func (_this CreateRawRsaKeyringInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateRawRsaKeyringInput_CreateRawRsaKeyringInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateRawRsaKeyringInput.CreateRawRsaKeyringInput" + "(" + _dafny.String(data.KeyNamespace) + ", " + _dafny.String(data.KeyName) + ", " + _dafny.String(data.PaddingScheme) + ", " + _dafny.String(data.PublicKey) + ", " + _dafny.String(data.PrivateKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateRawRsaKeyringInput) Equals(other CreateRawRsaKeyringInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateRawRsaKeyringInput_CreateRawRsaKeyringInput:
		{
			data2, ok := other.Get_().(CreateRawRsaKeyringInput_CreateRawRsaKeyringInput)
			return ok && data1.KeyNamespace.Equals(data2.KeyNamespace) && data1.KeyName.Equals(data2.KeyName) && data1.PaddingScheme.Equals(data2.PaddingScheme) && data1.PublicKey.Equals(data2.PublicKey) && data1.PrivateKey.Equals(data2.PrivateKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateRawRsaKeyringInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateRawRsaKeyringInput)
	return ok && _this.Equals(typed)
}

func Type_CreateRawRsaKeyringInput_() _dafny.TypeDescriptor {
	return type_CreateRawRsaKeyringInput_{}
}

type type_CreateRawRsaKeyringInput_ struct {
}

func (_this type_CreateRawRsaKeyringInput_) Default() interface{} {
	return Companion_CreateRawRsaKeyringInput_.Default()
}

func (_this type_CreateRawRsaKeyringInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateRawRsaKeyringInput"
}
func (_this CreateRawRsaKeyringInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateRawRsaKeyringInput{}

// End of datatype CreateRawRsaKeyringInput

// Definition of datatype CreateRequiredEncryptionContextCMMInput
type CreateRequiredEncryptionContextCMMInput struct {
	Data_CreateRequiredEncryptionContextCMMInput_
}

func (_this CreateRequiredEncryptionContextCMMInput) Get_() Data_CreateRequiredEncryptionContextCMMInput_ {
	return _this.Data_CreateRequiredEncryptionContextCMMInput_
}

type Data_CreateRequiredEncryptionContextCMMInput_ interface {
	isCreateRequiredEncryptionContextCMMInput()
}

type CompanionStruct_CreateRequiredEncryptionContextCMMInput_ struct {
}

var Companion_CreateRequiredEncryptionContextCMMInput_ = CompanionStruct_CreateRequiredEncryptionContextCMMInput_{}

type CreateRequiredEncryptionContextCMMInput_CreateRequiredEncryptionContextCMMInput struct {
	UnderlyingCMM                 m_Wrappers.Option
	Keyring                       m_Wrappers.Option
	RequiredEncryptionContextKeys _dafny.Sequence
}

func (CreateRequiredEncryptionContextCMMInput_CreateRequiredEncryptionContextCMMInput) isCreateRequiredEncryptionContextCMMInput() {
}

func (CompanionStruct_CreateRequiredEncryptionContextCMMInput_) Create_CreateRequiredEncryptionContextCMMInput_(UnderlyingCMM m_Wrappers.Option, Keyring m_Wrappers.Option, RequiredEncryptionContextKeys _dafny.Sequence) CreateRequiredEncryptionContextCMMInput {
	return CreateRequiredEncryptionContextCMMInput{CreateRequiredEncryptionContextCMMInput_CreateRequiredEncryptionContextCMMInput{UnderlyingCMM, Keyring, RequiredEncryptionContextKeys}}
}

func (_this CreateRequiredEncryptionContextCMMInput) Is_CreateRequiredEncryptionContextCMMInput() bool {
	_, ok := _this.Get_().(CreateRequiredEncryptionContextCMMInput_CreateRequiredEncryptionContextCMMInput)
	return ok
}

func (CompanionStruct_CreateRequiredEncryptionContextCMMInput_) Default() CreateRequiredEncryptionContextCMMInput {
	return Companion_CreateRequiredEncryptionContextCMMInput_.Create_CreateRequiredEncryptionContextCMMInput_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), _dafny.EmptySeq)
}

func (_this CreateRequiredEncryptionContextCMMInput) Dtor_underlyingCMM() m_Wrappers.Option {
	return _this.Get_().(CreateRequiredEncryptionContextCMMInput_CreateRequiredEncryptionContextCMMInput).UnderlyingCMM
}

func (_this CreateRequiredEncryptionContextCMMInput) Dtor_keyring() m_Wrappers.Option {
	return _this.Get_().(CreateRequiredEncryptionContextCMMInput_CreateRequiredEncryptionContextCMMInput).Keyring
}

func (_this CreateRequiredEncryptionContextCMMInput) Dtor_requiredEncryptionContextKeys() _dafny.Sequence {
	return _this.Get_().(CreateRequiredEncryptionContextCMMInput_CreateRequiredEncryptionContextCMMInput).RequiredEncryptionContextKeys
}

func (_this CreateRequiredEncryptionContextCMMInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateRequiredEncryptionContextCMMInput_CreateRequiredEncryptionContextCMMInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.CreateRequiredEncryptionContextCMMInput.CreateRequiredEncryptionContextCMMInput" + "(" + _dafny.String(data.UnderlyingCMM) + ", " + _dafny.String(data.Keyring) + ", " + _dafny.String(data.RequiredEncryptionContextKeys) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateRequiredEncryptionContextCMMInput) Equals(other CreateRequiredEncryptionContextCMMInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateRequiredEncryptionContextCMMInput_CreateRequiredEncryptionContextCMMInput:
		{
			data2, ok := other.Get_().(CreateRequiredEncryptionContextCMMInput_CreateRequiredEncryptionContextCMMInput)
			return ok && data1.UnderlyingCMM.Equals(data2.UnderlyingCMM) && data1.Keyring.Equals(data2.Keyring) && data1.RequiredEncryptionContextKeys.Equals(data2.RequiredEncryptionContextKeys)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateRequiredEncryptionContextCMMInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateRequiredEncryptionContextCMMInput)
	return ok && _this.Equals(typed)
}

func Type_CreateRequiredEncryptionContextCMMInput_() _dafny.TypeDescriptor {
	return type_CreateRequiredEncryptionContextCMMInput_{}
}

type type_CreateRequiredEncryptionContextCMMInput_ struct {
}

func (_this type_CreateRequiredEncryptionContextCMMInput_) Default() interface{} {
	return Companion_CreateRequiredEncryptionContextCMMInput_.Default()
}

func (_this type_CreateRequiredEncryptionContextCMMInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.CreateRequiredEncryptionContextCMMInput"
}
func (_this CreateRequiredEncryptionContextCMMInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateRequiredEncryptionContextCMMInput{}

// End of datatype CreateRequiredEncryptionContextCMMInput

// Definition of class ICryptographicMaterialsCacheCallHistory
type ICryptographicMaterialsCacheCallHistory struct {
	dummy byte
}

func New_ICryptographicMaterialsCacheCallHistory_() *ICryptographicMaterialsCacheCallHistory {
	_this := ICryptographicMaterialsCacheCallHistory{}

	return &_this
}

type CompanionStruct_ICryptographicMaterialsCacheCallHistory_ struct {
}

var Companion_ICryptographicMaterialsCacheCallHistory_ = CompanionStruct_ICryptographicMaterialsCacheCallHistory_{}

func (_this *ICryptographicMaterialsCacheCallHistory) Equals(other *ICryptographicMaterialsCacheCallHistory) bool {
	return _this == other
}

func (_this *ICryptographicMaterialsCacheCallHistory) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*ICryptographicMaterialsCacheCallHistory)
	return ok && _this.Equals(other)
}

func (*ICryptographicMaterialsCacheCallHistory) String() string {
	return "AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCacheCallHistory"
}

func Type_ICryptographicMaterialsCacheCallHistory_() _dafny.TypeDescriptor {
	return type_ICryptographicMaterialsCacheCallHistory_{}
}

type type_ICryptographicMaterialsCacheCallHistory_ struct {
}

func (_this type_ICryptographicMaterialsCacheCallHistory_) Default() interface{} {
	return (*ICryptographicMaterialsCacheCallHistory)(nil)
}

func (_this type_ICryptographicMaterialsCacheCallHistory_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCacheCallHistory"
}
func (_this *ICryptographicMaterialsCacheCallHistory) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &ICryptographicMaterialsCacheCallHistory{}

// End of class ICryptographicMaterialsCacheCallHistory

// Definition of trait ICryptographicMaterialsCache
type ICryptographicMaterialsCache interface {
	String() string
	PutCacheEntry(input PutCacheEntryInput) m_Wrappers.Result
	PutCacheEntry_k(input PutCacheEntryInput) m_Wrappers.Result
	UpdateUsageMetadata(input UpdateUsageMetadataInput) m_Wrappers.Result
	UpdateUsageMetadata_k(input UpdateUsageMetadataInput) m_Wrappers.Result
	GetCacheEntry(input GetCacheEntryInput) m_Wrappers.Result
	GetCacheEntry_k(input GetCacheEntryInput) m_Wrappers.Result
	DeleteCacheEntry(input DeleteCacheEntryInput) m_Wrappers.Result
	DeleteCacheEntry_k(input DeleteCacheEntryInput) m_Wrappers.Result
}

func (_static *CompanionStruct_ICryptographicMaterialsCache_) PutCacheEntry(_this ICryptographicMaterialsCache, input PutCacheEntryInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (_this).PutCacheEntry_k(input)
		output = _out0
		return output
	}
}
func (_static *CompanionStruct_ICryptographicMaterialsCache_) UpdateUsageMetadata(_this ICryptographicMaterialsCache, input UpdateUsageMetadataInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (_this).UpdateUsageMetadata_k(input)
		output = _out0
		return output
	}
}
func (_static *CompanionStruct_ICryptographicMaterialsCache_) GetCacheEntry(_this ICryptographicMaterialsCache, input GetCacheEntryInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (_this).GetCacheEntry_k(input)
		output = _out0
		return output
	}
}
func (_static *CompanionStruct_ICryptographicMaterialsCache_) DeleteCacheEntry(_this ICryptographicMaterialsCache, input DeleteCacheEntryInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (_this).DeleteCacheEntry_k(input)
		output = _out0
		return output
	}
}

type CompanionStruct_ICryptographicMaterialsCache_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_ICryptographicMaterialsCache_ = CompanionStruct_ICryptographicMaterialsCache_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_ICryptographicMaterialsCache_) CastTo_(x interface{}) ICryptographicMaterialsCache {
	var t ICryptographicMaterialsCache
	t, _ = x.(ICryptographicMaterialsCache)
	return t
}

// End of trait ICryptographicMaterialsCache

// Definition of class ICryptographicMaterialsManagerCallHistory
type ICryptographicMaterialsManagerCallHistory struct {
	dummy byte
}

func New_ICryptographicMaterialsManagerCallHistory_() *ICryptographicMaterialsManagerCallHistory {
	_this := ICryptographicMaterialsManagerCallHistory{}

	return &_this
}

type CompanionStruct_ICryptographicMaterialsManagerCallHistory_ struct {
}

var Companion_ICryptographicMaterialsManagerCallHistory_ = CompanionStruct_ICryptographicMaterialsManagerCallHistory_{}

func (_this *ICryptographicMaterialsManagerCallHistory) Equals(other *ICryptographicMaterialsManagerCallHistory) bool {
	return _this == other
}

func (_this *ICryptographicMaterialsManagerCallHistory) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*ICryptographicMaterialsManagerCallHistory)
	return ok && _this.Equals(other)
}

func (*ICryptographicMaterialsManagerCallHistory) String() string {
	return "AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManagerCallHistory"
}

func Type_ICryptographicMaterialsManagerCallHistory_() _dafny.TypeDescriptor {
	return type_ICryptographicMaterialsManagerCallHistory_{}
}

type type_ICryptographicMaterialsManagerCallHistory_ struct {
}

func (_this type_ICryptographicMaterialsManagerCallHistory_) Default() interface{} {
	return (*ICryptographicMaterialsManagerCallHistory)(nil)
}

func (_this type_ICryptographicMaterialsManagerCallHistory_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManagerCallHistory"
}
func (_this *ICryptographicMaterialsManagerCallHistory) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &ICryptographicMaterialsManagerCallHistory{}

// End of class ICryptographicMaterialsManagerCallHistory

// Definition of trait ICryptographicMaterialsManager
type ICryptographicMaterialsManager interface {
	String() string
	GetEncryptionMaterials(input GetEncryptionMaterialsInput) m_Wrappers.Result
	GetEncryptionMaterials_k(input GetEncryptionMaterialsInput) m_Wrappers.Result
	DecryptMaterials(input DecryptMaterialsInput) m_Wrappers.Result
	DecryptMaterials_k(input DecryptMaterialsInput) m_Wrappers.Result
}

func (_static *CompanionStruct_ICryptographicMaterialsManager_) GetEncryptionMaterials(_this ICryptographicMaterialsManager, input GetEncryptionMaterialsInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (_this).GetEncryptionMaterials_k(input)
		output = _out0
		return output
	}
}
func (_static *CompanionStruct_ICryptographicMaterialsManager_) DecryptMaterials(_this ICryptographicMaterialsManager, input DecryptMaterialsInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (_this).DecryptMaterials_k(input)
		output = _out0
		return output
	}
}

type CompanionStruct_ICryptographicMaterialsManager_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_ICryptographicMaterialsManager_ = CompanionStruct_ICryptographicMaterialsManager_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_ICryptographicMaterialsManager_) CastTo_(x interface{}) ICryptographicMaterialsManager {
	var t ICryptographicMaterialsManager
	t, _ = x.(ICryptographicMaterialsManager)
	return t
}

// End of trait ICryptographicMaterialsManager

// Definition of datatype DBEAlgorithmSuiteId
type DBEAlgorithmSuiteId struct {
	Data_DBEAlgorithmSuiteId_
}

func (_this DBEAlgorithmSuiteId) Get_() Data_DBEAlgorithmSuiteId_ {
	return _this.Data_DBEAlgorithmSuiteId_
}

type Data_DBEAlgorithmSuiteId_ interface {
	isDBEAlgorithmSuiteId()
}

type CompanionStruct_DBEAlgorithmSuiteId_ struct {
}

var Companion_DBEAlgorithmSuiteId_ = CompanionStruct_DBEAlgorithmSuiteId_{}

type DBEAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384 struct {
}

func (DBEAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384) isDBEAlgorithmSuiteId() {
}

func (CompanionStruct_DBEAlgorithmSuiteId_) Create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384_() DBEAlgorithmSuiteId {
	return DBEAlgorithmSuiteId{DBEAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384{}}
}

func (_this DBEAlgorithmSuiteId) Is_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384() bool {
	_, ok := _this.Get_().(DBEAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384)
	return ok
}

type DBEAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384 struct {
}

func (DBEAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384) isDBEAlgorithmSuiteId() {
}

func (CompanionStruct_DBEAlgorithmSuiteId_) Create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384_() DBEAlgorithmSuiteId {
	return DBEAlgorithmSuiteId{DBEAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384{}}
}

func (_this DBEAlgorithmSuiteId) Is_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384() bool {
	_, ok := _this.Get_().(DBEAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384)
	return ok
}

func (CompanionStruct_DBEAlgorithmSuiteId_) Default() DBEAlgorithmSuiteId {
	return Companion_DBEAlgorithmSuiteId_.Create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384_()
}

func (_ CompanionStruct_DBEAlgorithmSuiteId_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_DBEAlgorithmSuiteId_.Create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384_(), true
		case 1:
			return Companion_DBEAlgorithmSuiteId_.Create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384_(), true
		default:
			return DBEAlgorithmSuiteId{}, false
		}
	}
}

func (_this DBEAlgorithmSuiteId) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case DBEAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384:
		{
			return "AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384"
		}
	case DBEAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384:
		{
			return "AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DBEAlgorithmSuiteId) Equals(other DBEAlgorithmSuiteId) bool {
	switch _this.Get_().(type) {
	case DBEAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384:
		{
			_, ok := other.Get_().(DBEAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384)
			return ok
		}
	case DBEAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384:
		{
			_, ok := other.Get_().(DBEAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DBEAlgorithmSuiteId) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DBEAlgorithmSuiteId)
	return ok && _this.Equals(typed)
}

func Type_DBEAlgorithmSuiteId_() _dafny.TypeDescriptor {
	return type_DBEAlgorithmSuiteId_{}
}

type type_DBEAlgorithmSuiteId_ struct {
}

func (_this type_DBEAlgorithmSuiteId_) Default() interface{} {
	return Companion_DBEAlgorithmSuiteId_.Default()
}

func (_this type_DBEAlgorithmSuiteId_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId"
}
func (_this DBEAlgorithmSuiteId) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DBEAlgorithmSuiteId{}

// End of datatype DBEAlgorithmSuiteId

// Definition of datatype DBECommitmentPolicy
type DBECommitmentPolicy struct {
	Data_DBECommitmentPolicy_
}

func (_this DBECommitmentPolicy) Get_() Data_DBECommitmentPolicy_ {
	return _this.Data_DBECommitmentPolicy_
}

type Data_DBECommitmentPolicy_ interface {
	isDBECommitmentPolicy()
}

type CompanionStruct_DBECommitmentPolicy_ struct {
}

var Companion_DBECommitmentPolicy_ = CompanionStruct_DBECommitmentPolicy_{}

type DBECommitmentPolicy_REQUIRE__ENCRYPT__REQUIRE__DECRYPT struct {
}

func (DBECommitmentPolicy_REQUIRE__ENCRYPT__REQUIRE__DECRYPT) isDBECommitmentPolicy() {}

func (CompanionStruct_DBECommitmentPolicy_) Create_REQUIRE__ENCRYPT__REQUIRE__DECRYPT_() DBECommitmentPolicy {
	return DBECommitmentPolicy{DBECommitmentPolicy_REQUIRE__ENCRYPT__REQUIRE__DECRYPT{}}
}

func (_this DBECommitmentPolicy) Is_REQUIRE__ENCRYPT__REQUIRE__DECRYPT() bool {
	_, ok := _this.Get_().(DBECommitmentPolicy_REQUIRE__ENCRYPT__REQUIRE__DECRYPT)
	return ok
}

func (CompanionStruct_DBECommitmentPolicy_) Default() DBECommitmentPolicy {
	return Companion_DBECommitmentPolicy_.Create_REQUIRE__ENCRYPT__REQUIRE__DECRYPT_()
}

func (_ CompanionStruct_DBECommitmentPolicy_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_DBECommitmentPolicy_.Create_REQUIRE__ENCRYPT__REQUIRE__DECRYPT_(), true
		default:
			return DBECommitmentPolicy{}, false
		}
	}
}

func (_this DBECommitmentPolicy) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case DBECommitmentPolicy_REQUIRE__ENCRYPT__REQUIRE__DECRYPT:
		{
			return "AwsCryptographyMaterialProvidersTypes.DBECommitmentPolicy.REQUIRE_ENCRYPT_REQUIRE_DECRYPT"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DBECommitmentPolicy) Equals(other DBECommitmentPolicy) bool {
	switch _this.Get_().(type) {
	case DBECommitmentPolicy_REQUIRE__ENCRYPT__REQUIRE__DECRYPT:
		{
			_, ok := other.Get_().(DBECommitmentPolicy_REQUIRE__ENCRYPT__REQUIRE__DECRYPT)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DBECommitmentPolicy) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DBECommitmentPolicy)
	return ok && _this.Equals(typed)
}

func Type_DBECommitmentPolicy_() _dafny.TypeDescriptor {
	return type_DBECommitmentPolicy_{}
}

type type_DBECommitmentPolicy_ struct {
}

func (_this type_DBECommitmentPolicy_) Default() interface{} {
	return Companion_DBECommitmentPolicy_.Default()
}

func (_this type_DBECommitmentPolicy_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.DBECommitmentPolicy"
}
func (_this DBECommitmentPolicy) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DBECommitmentPolicy{}

// End of datatype DBECommitmentPolicy

// Definition of datatype DecryptionMaterials
type DecryptionMaterials struct {
	Data_DecryptionMaterials_
}

func (_this DecryptionMaterials) Get_() Data_DecryptionMaterials_ {
	return _this.Data_DecryptionMaterials_
}

type Data_DecryptionMaterials_ interface {
	isDecryptionMaterials()
}

type CompanionStruct_DecryptionMaterials_ struct {
}

var Companion_DecryptionMaterials_ = CompanionStruct_DecryptionMaterials_{}

type DecryptionMaterials_DecryptionMaterials struct {
	AlgorithmSuite                AlgorithmSuiteInfo
	EncryptionContext             _dafny.Map
	RequiredEncryptionContextKeys _dafny.Sequence
	PlaintextDataKey              m_Wrappers.Option
	VerificationKey               m_Wrappers.Option
	SymmetricSigningKey           m_Wrappers.Option
}

func (DecryptionMaterials_DecryptionMaterials) isDecryptionMaterials() {}

func (CompanionStruct_DecryptionMaterials_) Create_DecryptionMaterials_(AlgorithmSuite AlgorithmSuiteInfo, EncryptionContext _dafny.Map, RequiredEncryptionContextKeys _dafny.Sequence, PlaintextDataKey m_Wrappers.Option, VerificationKey m_Wrappers.Option, SymmetricSigningKey m_Wrappers.Option) DecryptionMaterials {
	return DecryptionMaterials{DecryptionMaterials_DecryptionMaterials{AlgorithmSuite, EncryptionContext, RequiredEncryptionContextKeys, PlaintextDataKey, VerificationKey, SymmetricSigningKey}}
}

func (_this DecryptionMaterials) Is_DecryptionMaterials() bool {
	_, ok := _this.Get_().(DecryptionMaterials_DecryptionMaterials)
	return ok
}

func (CompanionStruct_DecryptionMaterials_) Default() DecryptionMaterials {
	return Companion_DecryptionMaterials_.Create_DecryptionMaterials_(Companion_AlgorithmSuiteInfo_.Default(), _dafny.EmptyMap, _dafny.EmptySeq, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this DecryptionMaterials) Dtor_algorithmSuite() AlgorithmSuiteInfo {
	return _this.Get_().(DecryptionMaterials_DecryptionMaterials).AlgorithmSuite
}

func (_this DecryptionMaterials) Dtor_encryptionContext() _dafny.Map {
	return _this.Get_().(DecryptionMaterials_DecryptionMaterials).EncryptionContext
}

func (_this DecryptionMaterials) Dtor_requiredEncryptionContextKeys() _dafny.Sequence {
	return _this.Get_().(DecryptionMaterials_DecryptionMaterials).RequiredEncryptionContextKeys
}

func (_this DecryptionMaterials) Dtor_plaintextDataKey() m_Wrappers.Option {
	return _this.Get_().(DecryptionMaterials_DecryptionMaterials).PlaintextDataKey
}

func (_this DecryptionMaterials) Dtor_verificationKey() m_Wrappers.Option {
	return _this.Get_().(DecryptionMaterials_DecryptionMaterials).VerificationKey
}

func (_this DecryptionMaterials) Dtor_symmetricSigningKey() m_Wrappers.Option {
	return _this.Get_().(DecryptionMaterials_DecryptionMaterials).SymmetricSigningKey
}

func (_this DecryptionMaterials) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DecryptionMaterials_DecryptionMaterials:
		{
			return "AwsCryptographyMaterialProvidersTypes.DecryptionMaterials.DecryptionMaterials" + "(" + _dafny.String(data.AlgorithmSuite) + ", " + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.RequiredEncryptionContextKeys) + ", " + _dafny.String(data.PlaintextDataKey) + ", " + _dafny.String(data.VerificationKey) + ", " + _dafny.String(data.SymmetricSigningKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DecryptionMaterials) Equals(other DecryptionMaterials) bool {
	switch data1 := _this.Get_().(type) {
	case DecryptionMaterials_DecryptionMaterials:
		{
			data2, ok := other.Get_().(DecryptionMaterials_DecryptionMaterials)
			return ok && data1.AlgorithmSuite.Equals(data2.AlgorithmSuite) && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.RequiredEncryptionContextKeys.Equals(data2.RequiredEncryptionContextKeys) && data1.PlaintextDataKey.Equals(data2.PlaintextDataKey) && data1.VerificationKey.Equals(data2.VerificationKey) && data1.SymmetricSigningKey.Equals(data2.SymmetricSigningKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DecryptionMaterials) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DecryptionMaterials)
	return ok && _this.Equals(typed)
}

func Type_DecryptionMaterials_() _dafny.TypeDescriptor {
	return type_DecryptionMaterials_{}
}

type type_DecryptionMaterials_ struct {
}

func (_this type_DecryptionMaterials_) Default() interface{} {
	return Companion_DecryptionMaterials_.Default()
}

func (_this type_DecryptionMaterials_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.DecryptionMaterials"
}
func (_this DecryptionMaterials) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DecryptionMaterials{}

// End of datatype DecryptionMaterials

// Definition of datatype DecryptMaterialsInput
type DecryptMaterialsInput struct {
	Data_DecryptMaterialsInput_
}

func (_this DecryptMaterialsInput) Get_() Data_DecryptMaterialsInput_ {
	return _this.Data_DecryptMaterialsInput_
}

type Data_DecryptMaterialsInput_ interface {
	isDecryptMaterialsInput()
}

type CompanionStruct_DecryptMaterialsInput_ struct {
}

var Companion_DecryptMaterialsInput_ = CompanionStruct_DecryptMaterialsInput_{}

type DecryptMaterialsInput_DecryptMaterialsInput struct {
	AlgorithmSuiteId            AlgorithmSuiteId
	CommitmentPolicy            CommitmentPolicy
	EncryptedDataKeys           _dafny.Sequence
	EncryptionContext           _dafny.Map
	ReproducedEncryptionContext m_Wrappers.Option
}

func (DecryptMaterialsInput_DecryptMaterialsInput) isDecryptMaterialsInput() {}

func (CompanionStruct_DecryptMaterialsInput_) Create_DecryptMaterialsInput_(AlgorithmSuiteId AlgorithmSuiteId, CommitmentPolicy CommitmentPolicy, EncryptedDataKeys _dafny.Sequence, EncryptionContext _dafny.Map, ReproducedEncryptionContext m_Wrappers.Option) DecryptMaterialsInput {
	return DecryptMaterialsInput{DecryptMaterialsInput_DecryptMaterialsInput{AlgorithmSuiteId, CommitmentPolicy, EncryptedDataKeys, EncryptionContext, ReproducedEncryptionContext}}
}

func (_this DecryptMaterialsInput) Is_DecryptMaterialsInput() bool {
	_, ok := _this.Get_().(DecryptMaterialsInput_DecryptMaterialsInput)
	return ok
}

func (CompanionStruct_DecryptMaterialsInput_) Default() DecryptMaterialsInput {
	return Companion_DecryptMaterialsInput_.Create_DecryptMaterialsInput_(Companion_AlgorithmSuiteId_.Default(), Companion_CommitmentPolicy_.Default(), _dafny.EmptySeq, _dafny.EmptyMap, m_Wrappers.Companion_Option_.Default())
}

func (_this DecryptMaterialsInput) Dtor_algorithmSuiteId() AlgorithmSuiteId {
	return _this.Get_().(DecryptMaterialsInput_DecryptMaterialsInput).AlgorithmSuiteId
}

func (_this DecryptMaterialsInput) Dtor_commitmentPolicy() CommitmentPolicy {
	return _this.Get_().(DecryptMaterialsInput_DecryptMaterialsInput).CommitmentPolicy
}

func (_this DecryptMaterialsInput) Dtor_encryptedDataKeys() _dafny.Sequence {
	return _this.Get_().(DecryptMaterialsInput_DecryptMaterialsInput).EncryptedDataKeys
}

func (_this DecryptMaterialsInput) Dtor_encryptionContext() _dafny.Map {
	return _this.Get_().(DecryptMaterialsInput_DecryptMaterialsInput).EncryptionContext
}

func (_this DecryptMaterialsInput) Dtor_reproducedEncryptionContext() m_Wrappers.Option {
	return _this.Get_().(DecryptMaterialsInput_DecryptMaterialsInput).ReproducedEncryptionContext
}

func (_this DecryptMaterialsInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DecryptMaterialsInput_DecryptMaterialsInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.DecryptMaterialsInput.DecryptMaterialsInput" + "(" + _dafny.String(data.AlgorithmSuiteId) + ", " + _dafny.String(data.CommitmentPolicy) + ", " + _dafny.String(data.EncryptedDataKeys) + ", " + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.ReproducedEncryptionContext) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DecryptMaterialsInput) Equals(other DecryptMaterialsInput) bool {
	switch data1 := _this.Get_().(type) {
	case DecryptMaterialsInput_DecryptMaterialsInput:
		{
			data2, ok := other.Get_().(DecryptMaterialsInput_DecryptMaterialsInput)
			return ok && data1.AlgorithmSuiteId.Equals(data2.AlgorithmSuiteId) && data1.CommitmentPolicy.Equals(data2.CommitmentPolicy) && data1.EncryptedDataKeys.Equals(data2.EncryptedDataKeys) && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.ReproducedEncryptionContext.Equals(data2.ReproducedEncryptionContext)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DecryptMaterialsInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DecryptMaterialsInput)
	return ok && _this.Equals(typed)
}

func Type_DecryptMaterialsInput_() _dafny.TypeDescriptor {
	return type_DecryptMaterialsInput_{}
}

type type_DecryptMaterialsInput_ struct {
}

func (_this type_DecryptMaterialsInput_) Default() interface{} {
	return Companion_DecryptMaterialsInput_.Default()
}

func (_this type_DecryptMaterialsInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.DecryptMaterialsInput"
}
func (_this DecryptMaterialsInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DecryptMaterialsInput{}

// End of datatype DecryptMaterialsInput

// Definition of datatype DecryptMaterialsOutput
type DecryptMaterialsOutput struct {
	Data_DecryptMaterialsOutput_
}

func (_this DecryptMaterialsOutput) Get_() Data_DecryptMaterialsOutput_ {
	return _this.Data_DecryptMaterialsOutput_
}

type Data_DecryptMaterialsOutput_ interface {
	isDecryptMaterialsOutput()
}

type CompanionStruct_DecryptMaterialsOutput_ struct {
}

var Companion_DecryptMaterialsOutput_ = CompanionStruct_DecryptMaterialsOutput_{}

type DecryptMaterialsOutput_DecryptMaterialsOutput struct {
	DecryptionMaterials DecryptionMaterials
}

func (DecryptMaterialsOutput_DecryptMaterialsOutput) isDecryptMaterialsOutput() {}

func (CompanionStruct_DecryptMaterialsOutput_) Create_DecryptMaterialsOutput_(DecryptionMaterials DecryptionMaterials) DecryptMaterialsOutput {
	return DecryptMaterialsOutput{DecryptMaterialsOutput_DecryptMaterialsOutput{DecryptionMaterials}}
}

func (_this DecryptMaterialsOutput) Is_DecryptMaterialsOutput() bool {
	_, ok := _this.Get_().(DecryptMaterialsOutput_DecryptMaterialsOutput)
	return ok
}

func (CompanionStruct_DecryptMaterialsOutput_) Default() DecryptMaterialsOutput {
	return Companion_DecryptMaterialsOutput_.Create_DecryptMaterialsOutput_(Companion_DecryptionMaterials_.Default())
}

func (_this DecryptMaterialsOutput) Dtor_decryptionMaterials() DecryptionMaterials {
	return _this.Get_().(DecryptMaterialsOutput_DecryptMaterialsOutput).DecryptionMaterials
}

func (_this DecryptMaterialsOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DecryptMaterialsOutput_DecryptMaterialsOutput:
		{
			return "AwsCryptographyMaterialProvidersTypes.DecryptMaterialsOutput.DecryptMaterialsOutput" + "(" + _dafny.String(data.DecryptionMaterials) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DecryptMaterialsOutput) Equals(other DecryptMaterialsOutput) bool {
	switch data1 := _this.Get_().(type) {
	case DecryptMaterialsOutput_DecryptMaterialsOutput:
		{
			data2, ok := other.Get_().(DecryptMaterialsOutput_DecryptMaterialsOutput)
			return ok && data1.DecryptionMaterials.Equals(data2.DecryptionMaterials)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DecryptMaterialsOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DecryptMaterialsOutput)
	return ok && _this.Equals(typed)
}

func Type_DecryptMaterialsOutput_() _dafny.TypeDescriptor {
	return type_DecryptMaterialsOutput_{}
}

type type_DecryptMaterialsOutput_ struct {
}

func (_this type_DecryptMaterialsOutput_) Default() interface{} {
	return Companion_DecryptMaterialsOutput_.Default()
}

func (_this type_DecryptMaterialsOutput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.DecryptMaterialsOutput"
}
func (_this DecryptMaterialsOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DecryptMaterialsOutput{}

// End of datatype DecryptMaterialsOutput

// Definition of datatype DefaultCache
type DefaultCache struct {
	Data_DefaultCache_
}

func (_this DefaultCache) Get_() Data_DefaultCache_ {
	return _this.Data_DefaultCache_
}

type Data_DefaultCache_ interface {
	isDefaultCache()
}

type CompanionStruct_DefaultCache_ struct {
}

var Companion_DefaultCache_ = CompanionStruct_DefaultCache_{}

type DefaultCache_DefaultCache struct {
	EntryCapacity int32
}

func (DefaultCache_DefaultCache) isDefaultCache() {}

func (CompanionStruct_DefaultCache_) Create_DefaultCache_(EntryCapacity int32) DefaultCache {
	return DefaultCache{DefaultCache_DefaultCache{EntryCapacity}}
}

func (_this DefaultCache) Is_DefaultCache() bool {
	_, ok := _this.Get_().(DefaultCache_DefaultCache)
	return ok
}

func (CompanionStruct_DefaultCache_) Default() DefaultCache {
	return Companion_DefaultCache_.Create_DefaultCache_(int32(0))
}

func (_this DefaultCache) Dtor_entryCapacity() int32 {
	return _this.Get_().(DefaultCache_DefaultCache).EntryCapacity
}

func (_this DefaultCache) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DefaultCache_DefaultCache:
		{
			return "AwsCryptographyMaterialProvidersTypes.DefaultCache.DefaultCache" + "(" + _dafny.String(data.EntryCapacity) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DefaultCache) Equals(other DefaultCache) bool {
	switch data1 := _this.Get_().(type) {
	case DefaultCache_DefaultCache:
		{
			data2, ok := other.Get_().(DefaultCache_DefaultCache)
			return ok && data1.EntryCapacity == data2.EntryCapacity
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DefaultCache) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DefaultCache)
	return ok && _this.Equals(typed)
}

func Type_DefaultCache_() _dafny.TypeDescriptor {
	return type_DefaultCache_{}
}

type type_DefaultCache_ struct {
}

func (_this type_DefaultCache_) Default() interface{} {
	return Companion_DefaultCache_.Default()
}

func (_this type_DefaultCache_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.DefaultCache"
}
func (_this DefaultCache) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DefaultCache{}

// End of datatype DefaultCache

// Definition of datatype DeleteCacheEntryInput
type DeleteCacheEntryInput struct {
	Data_DeleteCacheEntryInput_
}

func (_this DeleteCacheEntryInput) Get_() Data_DeleteCacheEntryInput_ {
	return _this.Data_DeleteCacheEntryInput_
}

type Data_DeleteCacheEntryInput_ interface {
	isDeleteCacheEntryInput()
}

type CompanionStruct_DeleteCacheEntryInput_ struct {
}

var Companion_DeleteCacheEntryInput_ = CompanionStruct_DeleteCacheEntryInput_{}

type DeleteCacheEntryInput_DeleteCacheEntryInput struct {
	Identifier _dafny.Sequence
}

func (DeleteCacheEntryInput_DeleteCacheEntryInput) isDeleteCacheEntryInput() {}

func (CompanionStruct_DeleteCacheEntryInput_) Create_DeleteCacheEntryInput_(Identifier _dafny.Sequence) DeleteCacheEntryInput {
	return DeleteCacheEntryInput{DeleteCacheEntryInput_DeleteCacheEntryInput{Identifier}}
}

func (_this DeleteCacheEntryInput) Is_DeleteCacheEntryInput() bool {
	_, ok := _this.Get_().(DeleteCacheEntryInput_DeleteCacheEntryInput)
	return ok
}

func (CompanionStruct_DeleteCacheEntryInput_) Default() DeleteCacheEntryInput {
	return Companion_DeleteCacheEntryInput_.Create_DeleteCacheEntryInput_(_dafny.EmptySeq)
}

func (_this DeleteCacheEntryInput) Dtor_identifier() _dafny.Sequence {
	return _this.Get_().(DeleteCacheEntryInput_DeleteCacheEntryInput).Identifier
}

func (_this DeleteCacheEntryInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DeleteCacheEntryInput_DeleteCacheEntryInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.DeleteCacheEntryInput.DeleteCacheEntryInput" + "(" + _dafny.String(data.Identifier) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DeleteCacheEntryInput) Equals(other DeleteCacheEntryInput) bool {
	switch data1 := _this.Get_().(type) {
	case DeleteCacheEntryInput_DeleteCacheEntryInput:
		{
			data2, ok := other.Get_().(DeleteCacheEntryInput_DeleteCacheEntryInput)
			return ok && data1.Identifier.Equals(data2.Identifier)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DeleteCacheEntryInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DeleteCacheEntryInput)
	return ok && _this.Equals(typed)
}

func Type_DeleteCacheEntryInput_() _dafny.TypeDescriptor {
	return type_DeleteCacheEntryInput_{}
}

type type_DeleteCacheEntryInput_ struct {
}

func (_this type_DeleteCacheEntryInput_) Default() interface{} {
	return Companion_DeleteCacheEntryInput_.Default()
}

func (_this type_DeleteCacheEntryInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.DeleteCacheEntryInput"
}
func (_this DeleteCacheEntryInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DeleteCacheEntryInput{}

// End of datatype DeleteCacheEntryInput

// Definition of datatype DerivationAlgorithm
type DerivationAlgorithm struct {
	Data_DerivationAlgorithm_
}

func (_this DerivationAlgorithm) Get_() Data_DerivationAlgorithm_ {
	return _this.Data_DerivationAlgorithm_
}

type Data_DerivationAlgorithm_ interface {
	isDerivationAlgorithm()
}

type CompanionStruct_DerivationAlgorithm_ struct {
}

var Companion_DerivationAlgorithm_ = CompanionStruct_DerivationAlgorithm_{}

type DerivationAlgorithm_HKDF struct {
	HKDF HKDF
}

func (DerivationAlgorithm_HKDF) isDerivationAlgorithm() {}

func (CompanionStruct_DerivationAlgorithm_) Create_HKDF_(HKDF HKDF) DerivationAlgorithm {
	return DerivationAlgorithm{DerivationAlgorithm_HKDF{HKDF}}
}

func (_this DerivationAlgorithm) Is_HKDF() bool {
	_, ok := _this.Get_().(DerivationAlgorithm_HKDF)
	return ok
}

type DerivationAlgorithm_IDENTITY struct {
	IDENTITY IDENTITY
}

func (DerivationAlgorithm_IDENTITY) isDerivationAlgorithm() {}

func (CompanionStruct_DerivationAlgorithm_) Create_IDENTITY_(IDENTITY IDENTITY) DerivationAlgorithm {
	return DerivationAlgorithm{DerivationAlgorithm_IDENTITY{IDENTITY}}
}

func (_this DerivationAlgorithm) Is_IDENTITY() bool {
	_, ok := _this.Get_().(DerivationAlgorithm_IDENTITY)
	return ok
}

type DerivationAlgorithm_None struct {
	None None
}

func (DerivationAlgorithm_None) isDerivationAlgorithm() {}

func (CompanionStruct_DerivationAlgorithm_) Create_None_(None None) DerivationAlgorithm {
	return DerivationAlgorithm{DerivationAlgorithm_None{None}}
}

func (_this DerivationAlgorithm) Is_None() bool {
	_, ok := _this.Get_().(DerivationAlgorithm_None)
	return ok
}

func (CompanionStruct_DerivationAlgorithm_) Default() DerivationAlgorithm {
	return Companion_DerivationAlgorithm_.Create_HKDF_(Companion_HKDF_.Default())
}

func (_this DerivationAlgorithm) Dtor_HKDF() HKDF {
	return _this.Get_().(DerivationAlgorithm_HKDF).HKDF
}

func (_this DerivationAlgorithm) Dtor_IDENTITY() IDENTITY {
	return _this.Get_().(DerivationAlgorithm_IDENTITY).IDENTITY
}

func (_this DerivationAlgorithm) Dtor_None() None {
	return _this.Get_().(DerivationAlgorithm_None).None
}

func (_this DerivationAlgorithm) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DerivationAlgorithm_HKDF:
		{
			return "AwsCryptographyMaterialProvidersTypes.DerivationAlgorithm.HKDF" + "(" + _dafny.String(data.HKDF) + ")"
		}
	case DerivationAlgorithm_IDENTITY:
		{
			return "AwsCryptographyMaterialProvidersTypes.DerivationAlgorithm.IDENTITY" + "(" + _dafny.String(data.IDENTITY) + ")"
		}
	case DerivationAlgorithm_None:
		{
			return "AwsCryptographyMaterialProvidersTypes.DerivationAlgorithm.None" + "(" + _dafny.String(data.None) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DerivationAlgorithm) Equals(other DerivationAlgorithm) bool {
	switch data1 := _this.Get_().(type) {
	case DerivationAlgorithm_HKDF:
		{
			data2, ok := other.Get_().(DerivationAlgorithm_HKDF)
			return ok && data1.HKDF.Equals(data2.HKDF)
		}
	case DerivationAlgorithm_IDENTITY:
		{
			data2, ok := other.Get_().(DerivationAlgorithm_IDENTITY)
			return ok && data1.IDENTITY.Equals(data2.IDENTITY)
		}
	case DerivationAlgorithm_None:
		{
			data2, ok := other.Get_().(DerivationAlgorithm_None)
			return ok && data1.None.Equals(data2.None)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DerivationAlgorithm) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DerivationAlgorithm)
	return ok && _this.Equals(typed)
}

func Type_DerivationAlgorithm_() _dafny.TypeDescriptor {
	return type_DerivationAlgorithm_{}
}

type type_DerivationAlgorithm_ struct {
}

func (_this type_DerivationAlgorithm_) Default() interface{} {
	return Companion_DerivationAlgorithm_.Default()
}

func (_this type_DerivationAlgorithm_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.DerivationAlgorithm"
}
func (_this DerivationAlgorithm) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DerivationAlgorithm{}

// End of datatype DerivationAlgorithm

// Definition of datatype DIRECT__KEY__WRAPPING
type DIRECT__KEY__WRAPPING struct {
	Data_DIRECT__KEY__WRAPPING_
}

func (_this DIRECT__KEY__WRAPPING) Get_() Data_DIRECT__KEY__WRAPPING_ {
	return _this.Data_DIRECT__KEY__WRAPPING_
}

type Data_DIRECT__KEY__WRAPPING_ interface {
	isDIRECT__KEY__WRAPPING()
}

type CompanionStruct_DIRECT__KEY__WRAPPING_ struct {
}

var Companion_DIRECT__KEY__WRAPPING_ = CompanionStruct_DIRECT__KEY__WRAPPING_{}

type DIRECT__KEY__WRAPPING_DIRECT__KEY__WRAPPING struct {
}

func (DIRECT__KEY__WRAPPING_DIRECT__KEY__WRAPPING) isDIRECT__KEY__WRAPPING() {}

func (CompanionStruct_DIRECT__KEY__WRAPPING_) Create_DIRECT__KEY__WRAPPING_() DIRECT__KEY__WRAPPING {
	return DIRECT__KEY__WRAPPING{DIRECT__KEY__WRAPPING_DIRECT__KEY__WRAPPING{}}
}

func (_this DIRECT__KEY__WRAPPING) Is_DIRECT__KEY__WRAPPING() bool {
	_, ok := _this.Get_().(DIRECT__KEY__WRAPPING_DIRECT__KEY__WRAPPING)
	return ok
}

func (CompanionStruct_DIRECT__KEY__WRAPPING_) Default() DIRECT__KEY__WRAPPING {
	return Companion_DIRECT__KEY__WRAPPING_.Create_DIRECT__KEY__WRAPPING_()
}

func (_ CompanionStruct_DIRECT__KEY__WRAPPING_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_DIRECT__KEY__WRAPPING_.Create_DIRECT__KEY__WRAPPING_(), true
		default:
			return DIRECT__KEY__WRAPPING{}, false
		}
	}
}

func (_this DIRECT__KEY__WRAPPING) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case DIRECT__KEY__WRAPPING_DIRECT__KEY__WRAPPING:
		{
			return "AwsCryptographyMaterialProvidersTypes.DIRECT_KEY_WRAPPING.DIRECT_KEY_WRAPPING"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DIRECT__KEY__WRAPPING) Equals(other DIRECT__KEY__WRAPPING) bool {
	switch _this.Get_().(type) {
	case DIRECT__KEY__WRAPPING_DIRECT__KEY__WRAPPING:
		{
			_, ok := other.Get_().(DIRECT__KEY__WRAPPING_DIRECT__KEY__WRAPPING)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DIRECT__KEY__WRAPPING) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DIRECT__KEY__WRAPPING)
	return ok && _this.Equals(typed)
}

func Type_DIRECT__KEY__WRAPPING_() _dafny.TypeDescriptor {
	return type_DIRECT__KEY__WRAPPING_{}
}

type type_DIRECT__KEY__WRAPPING_ struct {
}

func (_this type_DIRECT__KEY__WRAPPING_) Default() interface{} {
	return Companion_DIRECT__KEY__WRAPPING_.Default()
}

func (_this type_DIRECT__KEY__WRAPPING_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.DIRECT__KEY__WRAPPING"
}
func (_this DIRECT__KEY__WRAPPING) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DIRECT__KEY__WRAPPING{}

// End of datatype DIRECT__KEY__WRAPPING

// Definition of datatype DiscoveryFilter
type DiscoveryFilter struct {
	Data_DiscoveryFilter_
}

func (_this DiscoveryFilter) Get_() Data_DiscoveryFilter_ {
	return _this.Data_DiscoveryFilter_
}

type Data_DiscoveryFilter_ interface {
	isDiscoveryFilter()
}

type CompanionStruct_DiscoveryFilter_ struct {
}

var Companion_DiscoveryFilter_ = CompanionStruct_DiscoveryFilter_{}

type DiscoveryFilter_DiscoveryFilter struct {
	AccountIds _dafny.Sequence
	Partition  _dafny.Sequence
}

func (DiscoveryFilter_DiscoveryFilter) isDiscoveryFilter() {}

func (CompanionStruct_DiscoveryFilter_) Create_DiscoveryFilter_(AccountIds _dafny.Sequence, Partition _dafny.Sequence) DiscoveryFilter {
	return DiscoveryFilter{DiscoveryFilter_DiscoveryFilter{AccountIds, Partition}}
}

func (_this DiscoveryFilter) Is_DiscoveryFilter() bool {
	_, ok := _this.Get_().(DiscoveryFilter_DiscoveryFilter)
	return ok
}

func (CompanionStruct_DiscoveryFilter_) Default() DiscoveryFilter {
	return Companion_DiscoveryFilter_.Create_DiscoveryFilter_(_dafny.EmptySeq, _dafny.EmptySeq.SetString())
}

func (_this DiscoveryFilter) Dtor_accountIds() _dafny.Sequence {
	return _this.Get_().(DiscoveryFilter_DiscoveryFilter).AccountIds
}

func (_this DiscoveryFilter) Dtor_partition() _dafny.Sequence {
	return _this.Get_().(DiscoveryFilter_DiscoveryFilter).Partition
}

func (_this DiscoveryFilter) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DiscoveryFilter_DiscoveryFilter:
		{
			return "AwsCryptographyMaterialProvidersTypes.DiscoveryFilter.DiscoveryFilter" + "(" + _dafny.String(data.AccountIds) + ", " + _dafny.String(data.Partition) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DiscoveryFilter) Equals(other DiscoveryFilter) bool {
	switch data1 := _this.Get_().(type) {
	case DiscoveryFilter_DiscoveryFilter:
		{
			data2, ok := other.Get_().(DiscoveryFilter_DiscoveryFilter)
			return ok && data1.AccountIds.Equals(data2.AccountIds) && data1.Partition.Equals(data2.Partition)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DiscoveryFilter) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DiscoveryFilter)
	return ok && _this.Equals(typed)
}

func Type_DiscoveryFilter_() _dafny.TypeDescriptor {
	return type_DiscoveryFilter_{}
}

type type_DiscoveryFilter_ struct {
}

func (_this type_DiscoveryFilter_) Default() interface{} {
	return Companion_DiscoveryFilter_.Default()
}

func (_this type_DiscoveryFilter_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.DiscoveryFilter"
}
func (_this DiscoveryFilter) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DiscoveryFilter{}

// End of datatype DiscoveryFilter

// Definition of datatype ECDSA
type ECDSA struct {
	Data_ECDSA_
}

func (_this ECDSA) Get_() Data_ECDSA_ {
	return _this.Data_ECDSA_
}

type Data_ECDSA_ interface {
	isECDSA()
}

type CompanionStruct_ECDSA_ struct {
}

var Companion_ECDSA_ = CompanionStruct_ECDSA_{}

type ECDSA_ECDSA struct {
	Curve m_AwsCryptographyPrimitivesTypes.ECDSASignatureAlgorithm
}

func (ECDSA_ECDSA) isECDSA() {}

func (CompanionStruct_ECDSA_) Create_ECDSA_(Curve m_AwsCryptographyPrimitivesTypes.ECDSASignatureAlgorithm) ECDSA {
	return ECDSA{ECDSA_ECDSA{Curve}}
}

func (_this ECDSA) Is_ECDSA() bool {
	_, ok := _this.Get_().(ECDSA_ECDSA)
	return ok
}

func (CompanionStruct_ECDSA_) Default() ECDSA {
	return Companion_ECDSA_.Create_ECDSA_(m_AwsCryptographyPrimitivesTypes.Companion_ECDSASignatureAlgorithm_.Default())
}

func (_this ECDSA) Dtor_curve() m_AwsCryptographyPrimitivesTypes.ECDSASignatureAlgorithm {
	return _this.Get_().(ECDSA_ECDSA).Curve
}

func (_this ECDSA) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ECDSA_ECDSA:
		{
			return "AwsCryptographyMaterialProvidersTypes.ECDSA.ECDSA" + "(" + _dafny.String(data.Curve) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ECDSA) Equals(other ECDSA) bool {
	switch data1 := _this.Get_().(type) {
	case ECDSA_ECDSA:
		{
			data2, ok := other.Get_().(ECDSA_ECDSA)
			return ok && data1.Curve.Equals(data2.Curve)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ECDSA) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ECDSA)
	return ok && _this.Equals(typed)
}

func Type_ECDSA_() _dafny.TypeDescriptor {
	return type_ECDSA_{}
}

type type_ECDSA_ struct {
}

func (_this type_ECDSA_) Default() interface{} {
	return Companion_ECDSA_.Default()
}

func (_this type_ECDSA_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.ECDSA"
}
func (_this ECDSA) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ECDSA{}

// End of datatype ECDSA

// Definition of datatype EdkWrappingAlgorithm
type EdkWrappingAlgorithm struct {
	Data_EdkWrappingAlgorithm_
}

func (_this EdkWrappingAlgorithm) Get_() Data_EdkWrappingAlgorithm_ {
	return _this.Data_EdkWrappingAlgorithm_
}

type Data_EdkWrappingAlgorithm_ interface {
	isEdkWrappingAlgorithm()
}

type CompanionStruct_EdkWrappingAlgorithm_ struct {
}

var Companion_EdkWrappingAlgorithm_ = CompanionStruct_EdkWrappingAlgorithm_{}

type EdkWrappingAlgorithm_DIRECT__KEY__WRAPPING struct {
	DIRECT__KEY__WRAPPING DIRECT__KEY__WRAPPING
}

func (EdkWrappingAlgorithm_DIRECT__KEY__WRAPPING) isEdkWrappingAlgorithm() {}

func (CompanionStruct_EdkWrappingAlgorithm_) Create_DIRECT__KEY__WRAPPING_(DIRECT__KEY__WRAPPING DIRECT__KEY__WRAPPING) EdkWrappingAlgorithm {
	return EdkWrappingAlgorithm{EdkWrappingAlgorithm_DIRECT__KEY__WRAPPING{DIRECT__KEY__WRAPPING}}
}

func (_this EdkWrappingAlgorithm) Is_DIRECT__KEY__WRAPPING() bool {
	_, ok := _this.Get_().(EdkWrappingAlgorithm_DIRECT__KEY__WRAPPING)
	return ok
}

type EdkWrappingAlgorithm_IntermediateKeyWrapping struct {
	IntermediateKeyWrapping IntermediateKeyWrapping
}

func (EdkWrappingAlgorithm_IntermediateKeyWrapping) isEdkWrappingAlgorithm() {}

func (CompanionStruct_EdkWrappingAlgorithm_) Create_IntermediateKeyWrapping_(IntermediateKeyWrapping IntermediateKeyWrapping) EdkWrappingAlgorithm {
	return EdkWrappingAlgorithm{EdkWrappingAlgorithm_IntermediateKeyWrapping{IntermediateKeyWrapping}}
}

func (_this EdkWrappingAlgorithm) Is_IntermediateKeyWrapping() bool {
	_, ok := _this.Get_().(EdkWrappingAlgorithm_IntermediateKeyWrapping)
	return ok
}

func (CompanionStruct_EdkWrappingAlgorithm_) Default() EdkWrappingAlgorithm {
	return Companion_EdkWrappingAlgorithm_.Create_DIRECT__KEY__WRAPPING_(Companion_DIRECT__KEY__WRAPPING_.Default())
}

func (_this EdkWrappingAlgorithm) Dtor_DIRECT__KEY__WRAPPING() DIRECT__KEY__WRAPPING {
	return _this.Get_().(EdkWrappingAlgorithm_DIRECT__KEY__WRAPPING).DIRECT__KEY__WRAPPING
}

func (_this EdkWrappingAlgorithm) Dtor_IntermediateKeyWrapping() IntermediateKeyWrapping {
	return _this.Get_().(EdkWrappingAlgorithm_IntermediateKeyWrapping).IntermediateKeyWrapping
}

func (_this EdkWrappingAlgorithm) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EdkWrappingAlgorithm_DIRECT__KEY__WRAPPING:
		{
			return "AwsCryptographyMaterialProvidersTypes.EdkWrappingAlgorithm.DIRECT_KEY_WRAPPING" + "(" + _dafny.String(data.DIRECT__KEY__WRAPPING) + ")"
		}
	case EdkWrappingAlgorithm_IntermediateKeyWrapping:
		{
			return "AwsCryptographyMaterialProvidersTypes.EdkWrappingAlgorithm.IntermediateKeyWrapping" + "(" + _dafny.String(data.IntermediateKeyWrapping) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EdkWrappingAlgorithm) Equals(other EdkWrappingAlgorithm) bool {
	switch data1 := _this.Get_().(type) {
	case EdkWrappingAlgorithm_DIRECT__KEY__WRAPPING:
		{
			data2, ok := other.Get_().(EdkWrappingAlgorithm_DIRECT__KEY__WRAPPING)
			return ok && data1.DIRECT__KEY__WRAPPING.Equals(data2.DIRECT__KEY__WRAPPING)
		}
	case EdkWrappingAlgorithm_IntermediateKeyWrapping:
		{
			data2, ok := other.Get_().(EdkWrappingAlgorithm_IntermediateKeyWrapping)
			return ok && data1.IntermediateKeyWrapping.Equals(data2.IntermediateKeyWrapping)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EdkWrappingAlgorithm) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EdkWrappingAlgorithm)
	return ok && _this.Equals(typed)
}

func Type_EdkWrappingAlgorithm_() _dafny.TypeDescriptor {
	return type_EdkWrappingAlgorithm_{}
}

type type_EdkWrappingAlgorithm_ struct {
}

func (_this type_EdkWrappingAlgorithm_) Default() interface{} {
	return Companion_EdkWrappingAlgorithm_.Default()
}

func (_this type_EdkWrappingAlgorithm_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.EdkWrappingAlgorithm"
}
func (_this EdkWrappingAlgorithm) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EdkWrappingAlgorithm{}

// End of datatype EdkWrappingAlgorithm

// Definition of datatype Encrypt
type Encrypt struct {
	Data_Encrypt_
}

func (_this Encrypt) Get_() Data_Encrypt_ {
	return _this.Data_Encrypt_
}

type Data_Encrypt_ interface {
	isEncrypt()
}

type CompanionStruct_Encrypt_ struct {
}

var Companion_Encrypt_ = CompanionStruct_Encrypt_{}

type Encrypt_AES__GCM struct {
	AES__GCM m_AwsCryptographyPrimitivesTypes.AES__GCM
}

func (Encrypt_AES__GCM) isEncrypt() {}

func (CompanionStruct_Encrypt_) Create_AES__GCM_(AES__GCM m_AwsCryptographyPrimitivesTypes.AES__GCM) Encrypt {
	return Encrypt{Encrypt_AES__GCM{AES__GCM}}
}

func (_this Encrypt) Is_AES__GCM() bool {
	_, ok := _this.Get_().(Encrypt_AES__GCM)
	return ok
}

func (CompanionStruct_Encrypt_) Default() Encrypt {
	return Companion_Encrypt_.Create_AES__GCM_(m_AwsCryptographyPrimitivesTypes.Companion_AES__GCM_.Default())
}

func (_this Encrypt) Dtor_AES__GCM() m_AwsCryptographyPrimitivesTypes.AES__GCM {
	return _this.Get_().(Encrypt_AES__GCM).AES__GCM
}

func (_this Encrypt) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Encrypt_AES__GCM:
		{
			return "AwsCryptographyMaterialProvidersTypes.Encrypt.AES_GCM" + "(" + _dafny.String(data.AES__GCM) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Encrypt) Equals(other Encrypt) bool {
	switch data1 := _this.Get_().(type) {
	case Encrypt_AES__GCM:
		{
			data2, ok := other.Get_().(Encrypt_AES__GCM)
			return ok && data1.AES__GCM.Equals(data2.AES__GCM)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Encrypt) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Encrypt)
	return ok && _this.Equals(typed)
}

func Type_Encrypt_() _dafny.TypeDescriptor {
	return type_Encrypt_{}
}

type type_Encrypt_ struct {
}

func (_this type_Encrypt_) Default() interface{} {
	return Companion_Encrypt_.Default()
}

func (_this type_Encrypt_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.Encrypt"
}
func (_this Encrypt) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Encrypt{}

// End of datatype Encrypt

// Definition of datatype EncryptedDataKey
type EncryptedDataKey struct {
	Data_EncryptedDataKey_
}

func (_this EncryptedDataKey) Get_() Data_EncryptedDataKey_ {
	return _this.Data_EncryptedDataKey_
}

type Data_EncryptedDataKey_ interface {
	isEncryptedDataKey()
}

type CompanionStruct_EncryptedDataKey_ struct {
}

var Companion_EncryptedDataKey_ = CompanionStruct_EncryptedDataKey_{}

type EncryptedDataKey_EncryptedDataKey struct {
	KeyProviderId   _dafny.Sequence
	KeyProviderInfo _dafny.Sequence
	Ciphertext      _dafny.Sequence
}

func (EncryptedDataKey_EncryptedDataKey) isEncryptedDataKey() {}

func (CompanionStruct_EncryptedDataKey_) Create_EncryptedDataKey_(KeyProviderId _dafny.Sequence, KeyProviderInfo _dafny.Sequence, Ciphertext _dafny.Sequence) EncryptedDataKey {
	return EncryptedDataKey{EncryptedDataKey_EncryptedDataKey{KeyProviderId, KeyProviderInfo, Ciphertext}}
}

func (_this EncryptedDataKey) Is_EncryptedDataKey() bool {
	_, ok := _this.Get_().(EncryptedDataKey_EncryptedDataKey)
	return ok
}

func (CompanionStruct_EncryptedDataKey_) Default() EncryptedDataKey {
	return Companion_EncryptedDataKey_.Create_EncryptedDataKey_(m_UTF8.Companion_ValidUTF8Bytes_.Witness(), _dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this EncryptedDataKey) Dtor_keyProviderId() _dafny.Sequence {
	return _this.Get_().(EncryptedDataKey_EncryptedDataKey).KeyProviderId
}

func (_this EncryptedDataKey) Dtor_keyProviderInfo() _dafny.Sequence {
	return _this.Get_().(EncryptedDataKey_EncryptedDataKey).KeyProviderInfo
}

func (_this EncryptedDataKey) Dtor_ciphertext() _dafny.Sequence {
	return _this.Get_().(EncryptedDataKey_EncryptedDataKey).Ciphertext
}

func (_this EncryptedDataKey) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EncryptedDataKey_EncryptedDataKey:
		{
			return "AwsCryptographyMaterialProvidersTypes.EncryptedDataKey.EncryptedDataKey" + "(" + _dafny.String(data.KeyProviderId) + ", " + _dafny.String(data.KeyProviderInfo) + ", " + _dafny.String(data.Ciphertext) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EncryptedDataKey) Equals(other EncryptedDataKey) bool {
	switch data1 := _this.Get_().(type) {
	case EncryptedDataKey_EncryptedDataKey:
		{
			data2, ok := other.Get_().(EncryptedDataKey_EncryptedDataKey)
			return ok && data1.KeyProviderId.Equals(data2.KeyProviderId) && data1.KeyProviderInfo.Equals(data2.KeyProviderInfo) && data1.Ciphertext.Equals(data2.Ciphertext)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EncryptedDataKey) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EncryptedDataKey)
	return ok && _this.Equals(typed)
}

func Type_EncryptedDataKey_() _dafny.TypeDescriptor {
	return type_EncryptedDataKey_{}
}

type type_EncryptedDataKey_ struct {
}

func (_this type_EncryptedDataKey_) Default() interface{} {
	return Companion_EncryptedDataKey_.Default()
}

func (_this type_EncryptedDataKey_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.EncryptedDataKey"
}
func (_this EncryptedDataKey) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EncryptedDataKey{}

// End of datatype EncryptedDataKey

// Definition of datatype EncryptionMaterials
type EncryptionMaterials struct {
	Data_EncryptionMaterials_
}

func (_this EncryptionMaterials) Get_() Data_EncryptionMaterials_ {
	return _this.Data_EncryptionMaterials_
}

type Data_EncryptionMaterials_ interface {
	isEncryptionMaterials()
}

type CompanionStruct_EncryptionMaterials_ struct {
}

var Companion_EncryptionMaterials_ = CompanionStruct_EncryptionMaterials_{}

type EncryptionMaterials_EncryptionMaterials struct {
	AlgorithmSuite                AlgorithmSuiteInfo
	EncryptionContext             _dafny.Map
	EncryptedDataKeys             _dafny.Sequence
	RequiredEncryptionContextKeys _dafny.Sequence
	PlaintextDataKey              m_Wrappers.Option
	SigningKey                    m_Wrappers.Option
	SymmetricSigningKeys          m_Wrappers.Option
}

func (EncryptionMaterials_EncryptionMaterials) isEncryptionMaterials() {}

func (CompanionStruct_EncryptionMaterials_) Create_EncryptionMaterials_(AlgorithmSuite AlgorithmSuiteInfo, EncryptionContext _dafny.Map, EncryptedDataKeys _dafny.Sequence, RequiredEncryptionContextKeys _dafny.Sequence, PlaintextDataKey m_Wrappers.Option, SigningKey m_Wrappers.Option, SymmetricSigningKeys m_Wrappers.Option) EncryptionMaterials {
	return EncryptionMaterials{EncryptionMaterials_EncryptionMaterials{AlgorithmSuite, EncryptionContext, EncryptedDataKeys, RequiredEncryptionContextKeys, PlaintextDataKey, SigningKey, SymmetricSigningKeys}}
}

func (_this EncryptionMaterials) Is_EncryptionMaterials() bool {
	_, ok := _this.Get_().(EncryptionMaterials_EncryptionMaterials)
	return ok
}

func (CompanionStruct_EncryptionMaterials_) Default() EncryptionMaterials {
	return Companion_EncryptionMaterials_.Create_EncryptionMaterials_(Companion_AlgorithmSuiteInfo_.Default(), _dafny.EmptyMap, _dafny.EmptySeq, _dafny.EmptySeq, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this EncryptionMaterials) Dtor_algorithmSuite() AlgorithmSuiteInfo {
	return _this.Get_().(EncryptionMaterials_EncryptionMaterials).AlgorithmSuite
}

func (_this EncryptionMaterials) Dtor_encryptionContext() _dafny.Map {
	return _this.Get_().(EncryptionMaterials_EncryptionMaterials).EncryptionContext
}

func (_this EncryptionMaterials) Dtor_encryptedDataKeys() _dafny.Sequence {
	return _this.Get_().(EncryptionMaterials_EncryptionMaterials).EncryptedDataKeys
}

func (_this EncryptionMaterials) Dtor_requiredEncryptionContextKeys() _dafny.Sequence {
	return _this.Get_().(EncryptionMaterials_EncryptionMaterials).RequiredEncryptionContextKeys
}

func (_this EncryptionMaterials) Dtor_plaintextDataKey() m_Wrappers.Option {
	return _this.Get_().(EncryptionMaterials_EncryptionMaterials).PlaintextDataKey
}

func (_this EncryptionMaterials) Dtor_signingKey() m_Wrappers.Option {
	return _this.Get_().(EncryptionMaterials_EncryptionMaterials).SigningKey
}

func (_this EncryptionMaterials) Dtor_symmetricSigningKeys() m_Wrappers.Option {
	return _this.Get_().(EncryptionMaterials_EncryptionMaterials).SymmetricSigningKeys
}

func (_this EncryptionMaterials) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EncryptionMaterials_EncryptionMaterials:
		{
			return "AwsCryptographyMaterialProvidersTypes.EncryptionMaterials.EncryptionMaterials" + "(" + _dafny.String(data.AlgorithmSuite) + ", " + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.EncryptedDataKeys) + ", " + _dafny.String(data.RequiredEncryptionContextKeys) + ", " + _dafny.String(data.PlaintextDataKey) + ", " + _dafny.String(data.SigningKey) + ", " + _dafny.String(data.SymmetricSigningKeys) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EncryptionMaterials) Equals(other EncryptionMaterials) bool {
	switch data1 := _this.Get_().(type) {
	case EncryptionMaterials_EncryptionMaterials:
		{
			data2, ok := other.Get_().(EncryptionMaterials_EncryptionMaterials)
			return ok && data1.AlgorithmSuite.Equals(data2.AlgorithmSuite) && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.EncryptedDataKeys.Equals(data2.EncryptedDataKeys) && data1.RequiredEncryptionContextKeys.Equals(data2.RequiredEncryptionContextKeys) && data1.PlaintextDataKey.Equals(data2.PlaintextDataKey) && data1.SigningKey.Equals(data2.SigningKey) && data1.SymmetricSigningKeys.Equals(data2.SymmetricSigningKeys)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EncryptionMaterials) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EncryptionMaterials)
	return ok && _this.Equals(typed)
}

func Type_EncryptionMaterials_() _dafny.TypeDescriptor {
	return type_EncryptionMaterials_{}
}

type type_EncryptionMaterials_ struct {
}

func (_this type_EncryptionMaterials_) Default() interface{} {
	return Companion_EncryptionMaterials_.Default()
}

func (_this type_EncryptionMaterials_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.EncryptionMaterials"
}
func (_this EncryptionMaterials) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EncryptionMaterials{}

// End of datatype EncryptionMaterials

// Definition of datatype EphemeralPrivateKeyToStaticPublicKeyInput
type EphemeralPrivateKeyToStaticPublicKeyInput struct {
	Data_EphemeralPrivateKeyToStaticPublicKeyInput_
}

func (_this EphemeralPrivateKeyToStaticPublicKeyInput) Get_() Data_EphemeralPrivateKeyToStaticPublicKeyInput_ {
	return _this.Data_EphemeralPrivateKeyToStaticPublicKeyInput_
}

type Data_EphemeralPrivateKeyToStaticPublicKeyInput_ interface {
	isEphemeralPrivateKeyToStaticPublicKeyInput()
}

type CompanionStruct_EphemeralPrivateKeyToStaticPublicKeyInput_ struct {
}

var Companion_EphemeralPrivateKeyToStaticPublicKeyInput_ = CompanionStruct_EphemeralPrivateKeyToStaticPublicKeyInput_{}

type EphemeralPrivateKeyToStaticPublicKeyInput_EphemeralPrivateKeyToStaticPublicKeyInput struct {
	RecipientPublicKey _dafny.Sequence
}

func (EphemeralPrivateKeyToStaticPublicKeyInput_EphemeralPrivateKeyToStaticPublicKeyInput) isEphemeralPrivateKeyToStaticPublicKeyInput() {
}

func (CompanionStruct_EphemeralPrivateKeyToStaticPublicKeyInput_) Create_EphemeralPrivateKeyToStaticPublicKeyInput_(RecipientPublicKey _dafny.Sequence) EphemeralPrivateKeyToStaticPublicKeyInput {
	return EphemeralPrivateKeyToStaticPublicKeyInput{EphemeralPrivateKeyToStaticPublicKeyInput_EphemeralPrivateKeyToStaticPublicKeyInput{RecipientPublicKey}}
}

func (_this EphemeralPrivateKeyToStaticPublicKeyInput) Is_EphemeralPrivateKeyToStaticPublicKeyInput() bool {
	_, ok := _this.Get_().(EphemeralPrivateKeyToStaticPublicKeyInput_EphemeralPrivateKeyToStaticPublicKeyInput)
	return ok
}

func (CompanionStruct_EphemeralPrivateKeyToStaticPublicKeyInput_) Default() EphemeralPrivateKeyToStaticPublicKeyInput {
	return Companion_EphemeralPrivateKeyToStaticPublicKeyInput_.Create_EphemeralPrivateKeyToStaticPublicKeyInput_(_dafny.EmptySeq)
}

func (_this EphemeralPrivateKeyToStaticPublicKeyInput) Dtor_recipientPublicKey() _dafny.Sequence {
	return _this.Get_().(EphemeralPrivateKeyToStaticPublicKeyInput_EphemeralPrivateKeyToStaticPublicKeyInput).RecipientPublicKey
}

func (_this EphemeralPrivateKeyToStaticPublicKeyInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EphemeralPrivateKeyToStaticPublicKeyInput_EphemeralPrivateKeyToStaticPublicKeyInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.EphemeralPrivateKeyToStaticPublicKeyInput.EphemeralPrivateKeyToStaticPublicKeyInput" + "(" + _dafny.String(data.RecipientPublicKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EphemeralPrivateKeyToStaticPublicKeyInput) Equals(other EphemeralPrivateKeyToStaticPublicKeyInput) bool {
	switch data1 := _this.Get_().(type) {
	case EphemeralPrivateKeyToStaticPublicKeyInput_EphemeralPrivateKeyToStaticPublicKeyInput:
		{
			data2, ok := other.Get_().(EphemeralPrivateKeyToStaticPublicKeyInput_EphemeralPrivateKeyToStaticPublicKeyInput)
			return ok && data1.RecipientPublicKey.Equals(data2.RecipientPublicKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EphemeralPrivateKeyToStaticPublicKeyInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EphemeralPrivateKeyToStaticPublicKeyInput)
	return ok && _this.Equals(typed)
}

func Type_EphemeralPrivateKeyToStaticPublicKeyInput_() _dafny.TypeDescriptor {
	return type_EphemeralPrivateKeyToStaticPublicKeyInput_{}
}

type type_EphemeralPrivateKeyToStaticPublicKeyInput_ struct {
}

func (_this type_EphemeralPrivateKeyToStaticPublicKeyInput_) Default() interface{} {
	return Companion_EphemeralPrivateKeyToStaticPublicKeyInput_.Default()
}

func (_this type_EphemeralPrivateKeyToStaticPublicKeyInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.EphemeralPrivateKeyToStaticPublicKeyInput"
}
func (_this EphemeralPrivateKeyToStaticPublicKeyInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EphemeralPrivateKeyToStaticPublicKeyInput{}

// End of datatype EphemeralPrivateKeyToStaticPublicKeyInput

// Definition of datatype ESDKAlgorithmSuiteId
type ESDKAlgorithmSuiteId struct {
	Data_ESDKAlgorithmSuiteId_
}

func (_this ESDKAlgorithmSuiteId) Get_() Data_ESDKAlgorithmSuiteId_ {
	return _this.Data_ESDKAlgorithmSuiteId_
}

type Data_ESDKAlgorithmSuiteId_ interface {
	isESDKAlgorithmSuiteId()
}

type CompanionStruct_ESDKAlgorithmSuiteId_ struct {
}

var Companion_ESDKAlgorithmSuiteId_ = CompanionStruct_ESDKAlgorithmSuiteId_{}

type ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__NO__KDF struct {
}

func (ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__NO__KDF) isESDKAlgorithmSuiteId() {}

func (CompanionStruct_ESDKAlgorithmSuiteId_) Create_ALG__AES__128__GCM__IV12__TAG16__NO__KDF_() ESDKAlgorithmSuiteId {
	return ESDKAlgorithmSuiteId{ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__NO__KDF{}}
}

func (_this ESDKAlgorithmSuiteId) Is_ALG__AES__128__GCM__IV12__TAG16__NO__KDF() bool {
	_, ok := _this.Get_().(ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__NO__KDF)
	return ok
}

type ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__NO__KDF struct {
}

func (ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__NO__KDF) isESDKAlgorithmSuiteId() {}

func (CompanionStruct_ESDKAlgorithmSuiteId_) Create_ALG__AES__192__GCM__IV12__TAG16__NO__KDF_() ESDKAlgorithmSuiteId {
	return ESDKAlgorithmSuiteId{ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__NO__KDF{}}
}

func (_this ESDKAlgorithmSuiteId) Is_ALG__AES__192__GCM__IV12__TAG16__NO__KDF() bool {
	_, ok := _this.Get_().(ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__NO__KDF)
	return ok
}

type ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__NO__KDF struct {
}

func (ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__NO__KDF) isESDKAlgorithmSuiteId() {}

func (CompanionStruct_ESDKAlgorithmSuiteId_) Create_ALG__AES__256__GCM__IV12__TAG16__NO__KDF_() ESDKAlgorithmSuiteId {
	return ESDKAlgorithmSuiteId{ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__NO__KDF{}}
}

func (_this ESDKAlgorithmSuiteId) Is_ALG__AES__256__GCM__IV12__TAG16__NO__KDF() bool {
	_, ok := _this.Get_().(ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__NO__KDF)
	return ok
}

type ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256 struct {
}

func (ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256) isESDKAlgorithmSuiteId() {}

func (CompanionStruct_ESDKAlgorithmSuiteId_) Create_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256_() ESDKAlgorithmSuiteId {
	return ESDKAlgorithmSuiteId{ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256{}}
}

func (_this ESDKAlgorithmSuiteId) Is_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256() bool {
	_, ok := _this.Get_().(ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256)
	return ok
}

type ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA256 struct {
}

func (ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA256) isESDKAlgorithmSuiteId() {}

func (CompanionStruct_ESDKAlgorithmSuiteId_) Create_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA256_() ESDKAlgorithmSuiteId {
	return ESDKAlgorithmSuiteId{ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA256{}}
}

func (_this ESDKAlgorithmSuiteId) Is_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA256() bool {
	_, ok := _this.Get_().(ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA256)
	return ok
}

type ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA256 struct {
}

func (ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA256) isESDKAlgorithmSuiteId() {}

func (CompanionStruct_ESDKAlgorithmSuiteId_) Create_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA256_() ESDKAlgorithmSuiteId {
	return ESDKAlgorithmSuiteId{ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA256{}}
}

func (_this ESDKAlgorithmSuiteId) Is_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA256() bool {
	_, ok := _this.Get_().(ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA256)
	return ok
}

type ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256__ECDSA__P256 struct {
}

func (ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256__ECDSA__P256) isESDKAlgorithmSuiteId() {
}

func (CompanionStruct_ESDKAlgorithmSuiteId_) Create_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256__ECDSA__P256_() ESDKAlgorithmSuiteId {
	return ESDKAlgorithmSuiteId{ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256__ECDSA__P256{}}
}

func (_this ESDKAlgorithmSuiteId) Is_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256__ECDSA__P256() bool {
	_, ok := _this.Get_().(ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256__ECDSA__P256)
	return ok
}

type ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384 struct {
}

func (ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384) isESDKAlgorithmSuiteId() {
}

func (CompanionStruct_ESDKAlgorithmSuiteId_) Create_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384_() ESDKAlgorithmSuiteId {
	return ESDKAlgorithmSuiteId{ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384{}}
}

func (_this ESDKAlgorithmSuiteId) Is_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384() bool {
	_, ok := _this.Get_().(ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384)
	return ok
}

type ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384 struct {
}

func (ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384) isESDKAlgorithmSuiteId() {
}

func (CompanionStruct_ESDKAlgorithmSuiteId_) Create_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384_() ESDKAlgorithmSuiteId {
	return ESDKAlgorithmSuiteId{ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384{}}
}

func (_this ESDKAlgorithmSuiteId) Is_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384() bool {
	_, ok := _this.Get_().(ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384)
	return ok
}

type ESDKAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY struct {
}

func (ESDKAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY) isESDKAlgorithmSuiteId() {}

func (CompanionStruct_ESDKAlgorithmSuiteId_) Create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY_() ESDKAlgorithmSuiteId {
	return ESDKAlgorithmSuiteId{ESDKAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY{}}
}

func (_this ESDKAlgorithmSuiteId) Is_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY() bool {
	_, ok := _this.Get_().(ESDKAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY)
	return ok
}

type ESDKAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384 struct {
}

func (ESDKAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384) isESDKAlgorithmSuiteId() {
}

func (CompanionStruct_ESDKAlgorithmSuiteId_) Create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384_() ESDKAlgorithmSuiteId {
	return ESDKAlgorithmSuiteId{ESDKAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384{}}
}

func (_this ESDKAlgorithmSuiteId) Is_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384() bool {
	_, ok := _this.Get_().(ESDKAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384)
	return ok
}

func (CompanionStruct_ESDKAlgorithmSuiteId_) Default() ESDKAlgorithmSuiteId {
	return Companion_ESDKAlgorithmSuiteId_.Create_ALG__AES__128__GCM__IV12__TAG16__NO__KDF_()
}

func (_ CompanionStruct_ESDKAlgorithmSuiteId_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_ESDKAlgorithmSuiteId_.Create_ALG__AES__128__GCM__IV12__TAG16__NO__KDF_(), true
		case 1:
			return Companion_ESDKAlgorithmSuiteId_.Create_ALG__AES__192__GCM__IV12__TAG16__NO__KDF_(), true
		case 2:
			return Companion_ESDKAlgorithmSuiteId_.Create_ALG__AES__256__GCM__IV12__TAG16__NO__KDF_(), true
		case 3:
			return Companion_ESDKAlgorithmSuiteId_.Create_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256_(), true
		case 4:
			return Companion_ESDKAlgorithmSuiteId_.Create_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA256_(), true
		case 5:
			return Companion_ESDKAlgorithmSuiteId_.Create_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA256_(), true
		case 6:
			return Companion_ESDKAlgorithmSuiteId_.Create_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256__ECDSA__P256_(), true
		case 7:
			return Companion_ESDKAlgorithmSuiteId_.Create_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384_(), true
		case 8:
			return Companion_ESDKAlgorithmSuiteId_.Create_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384_(), true
		case 9:
			return Companion_ESDKAlgorithmSuiteId_.Create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY_(), true
		case 10:
			return Companion_ESDKAlgorithmSuiteId_.Create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384_(), true
		default:
			return ESDKAlgorithmSuiteId{}, false
		}
	}
}

func (_this ESDKAlgorithmSuiteId) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__NO__KDF:
		{
			return "AwsCryptographyMaterialProvidersTypes.ESDKAlgorithmSuiteId.ALG_AES_128_GCM_IV12_TAG16_NO_KDF"
		}
	case ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__NO__KDF:
		{
			return "AwsCryptographyMaterialProvidersTypes.ESDKAlgorithmSuiteId.ALG_AES_192_GCM_IV12_TAG16_NO_KDF"
		}
	case ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__NO__KDF:
		{
			return "AwsCryptographyMaterialProvidersTypes.ESDKAlgorithmSuiteId.ALG_AES_256_GCM_IV12_TAG16_NO_KDF"
		}
	case ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256:
		{
			return "AwsCryptographyMaterialProvidersTypes.ESDKAlgorithmSuiteId.ALG_AES_128_GCM_IV12_TAG16_HKDF_SHA256"
		}
	case ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA256:
		{
			return "AwsCryptographyMaterialProvidersTypes.ESDKAlgorithmSuiteId.ALG_AES_192_GCM_IV12_TAG16_HKDF_SHA256"
		}
	case ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA256:
		{
			return "AwsCryptographyMaterialProvidersTypes.ESDKAlgorithmSuiteId.ALG_AES_256_GCM_IV12_TAG16_HKDF_SHA256"
		}
	case ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256__ECDSA__P256:
		{
			return "AwsCryptographyMaterialProvidersTypes.ESDKAlgorithmSuiteId.ALG_AES_128_GCM_IV12_TAG16_HKDF_SHA256_ECDSA_P256"
		}
	case ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384:
		{
			return "AwsCryptographyMaterialProvidersTypes.ESDKAlgorithmSuiteId.ALG_AES_192_GCM_IV12_TAG16_HKDF_SHA384_ECDSA_P384"
		}
	case ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384:
		{
			return "AwsCryptographyMaterialProvidersTypes.ESDKAlgorithmSuiteId.ALG_AES_256_GCM_IV12_TAG16_HKDF_SHA384_ECDSA_P384"
		}
	case ESDKAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY:
		{
			return "AwsCryptographyMaterialProvidersTypes.ESDKAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY"
		}
	case ESDKAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384:
		{
			return "AwsCryptographyMaterialProvidersTypes.ESDKAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ESDKAlgorithmSuiteId) Equals(other ESDKAlgorithmSuiteId) bool {
	switch _this.Get_().(type) {
	case ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__NO__KDF:
		{
			_, ok := other.Get_().(ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__NO__KDF)
			return ok
		}
	case ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__NO__KDF:
		{
			_, ok := other.Get_().(ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__NO__KDF)
			return ok
		}
	case ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__NO__KDF:
		{
			_, ok := other.Get_().(ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__NO__KDF)
			return ok
		}
	case ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256:
		{
			_, ok := other.Get_().(ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256)
			return ok
		}
	case ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA256:
		{
			_, ok := other.Get_().(ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA256)
			return ok
		}
	case ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA256:
		{
			_, ok := other.Get_().(ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA256)
			return ok
		}
	case ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256__ECDSA__P256:
		{
			_, ok := other.Get_().(ESDKAlgorithmSuiteId_ALG__AES__128__GCM__IV12__TAG16__HKDF__SHA256__ECDSA__P256)
			return ok
		}
	case ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384:
		{
			_, ok := other.Get_().(ESDKAlgorithmSuiteId_ALG__AES__192__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384)
			return ok
		}
	case ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384:
		{
			_, ok := other.Get_().(ESDKAlgorithmSuiteId_ALG__AES__256__GCM__IV12__TAG16__HKDF__SHA384__ECDSA__P384)
			return ok
		}
	case ESDKAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY:
		{
			_, ok := other.Get_().(ESDKAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY)
			return ok
		}
	case ESDKAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384:
		{
			_, ok := other.Get_().(ESDKAlgorithmSuiteId_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ESDKAlgorithmSuiteId) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ESDKAlgorithmSuiteId)
	return ok && _this.Equals(typed)
}

func Type_ESDKAlgorithmSuiteId_() _dafny.TypeDescriptor {
	return type_ESDKAlgorithmSuiteId_{}
}

type type_ESDKAlgorithmSuiteId_ struct {
}

func (_this type_ESDKAlgorithmSuiteId_) Default() interface{} {
	return Companion_ESDKAlgorithmSuiteId_.Default()
}

func (_this type_ESDKAlgorithmSuiteId_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.ESDKAlgorithmSuiteId"
}
func (_this ESDKAlgorithmSuiteId) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ESDKAlgorithmSuiteId{}

// End of datatype ESDKAlgorithmSuiteId

// Definition of datatype ESDKCommitmentPolicy
type ESDKCommitmentPolicy struct {
	Data_ESDKCommitmentPolicy_
}

func (_this ESDKCommitmentPolicy) Get_() Data_ESDKCommitmentPolicy_ {
	return _this.Data_ESDKCommitmentPolicy_
}

type Data_ESDKCommitmentPolicy_ interface {
	isESDKCommitmentPolicy()
}

type CompanionStruct_ESDKCommitmentPolicy_ struct {
}

var Companion_ESDKCommitmentPolicy_ = CompanionStruct_ESDKCommitmentPolicy_{}

type ESDKCommitmentPolicy_FORBID__ENCRYPT__ALLOW__DECRYPT struct {
}

func (ESDKCommitmentPolicy_FORBID__ENCRYPT__ALLOW__DECRYPT) isESDKCommitmentPolicy() {}

func (CompanionStruct_ESDKCommitmentPolicy_) Create_FORBID__ENCRYPT__ALLOW__DECRYPT_() ESDKCommitmentPolicy {
	return ESDKCommitmentPolicy{ESDKCommitmentPolicy_FORBID__ENCRYPT__ALLOW__DECRYPT{}}
}

func (_this ESDKCommitmentPolicy) Is_FORBID__ENCRYPT__ALLOW__DECRYPT() bool {
	_, ok := _this.Get_().(ESDKCommitmentPolicy_FORBID__ENCRYPT__ALLOW__DECRYPT)
	return ok
}

type ESDKCommitmentPolicy_REQUIRE__ENCRYPT__ALLOW__DECRYPT struct {
}

func (ESDKCommitmentPolicy_REQUIRE__ENCRYPT__ALLOW__DECRYPT) isESDKCommitmentPolicy() {}

func (CompanionStruct_ESDKCommitmentPolicy_) Create_REQUIRE__ENCRYPT__ALLOW__DECRYPT_() ESDKCommitmentPolicy {
	return ESDKCommitmentPolicy{ESDKCommitmentPolicy_REQUIRE__ENCRYPT__ALLOW__DECRYPT{}}
}

func (_this ESDKCommitmentPolicy) Is_REQUIRE__ENCRYPT__ALLOW__DECRYPT() bool {
	_, ok := _this.Get_().(ESDKCommitmentPolicy_REQUIRE__ENCRYPT__ALLOW__DECRYPT)
	return ok
}

type ESDKCommitmentPolicy_REQUIRE__ENCRYPT__REQUIRE__DECRYPT struct {
}

func (ESDKCommitmentPolicy_REQUIRE__ENCRYPT__REQUIRE__DECRYPT) isESDKCommitmentPolicy() {}

func (CompanionStruct_ESDKCommitmentPolicy_) Create_REQUIRE__ENCRYPT__REQUIRE__DECRYPT_() ESDKCommitmentPolicy {
	return ESDKCommitmentPolicy{ESDKCommitmentPolicy_REQUIRE__ENCRYPT__REQUIRE__DECRYPT{}}
}

func (_this ESDKCommitmentPolicy) Is_REQUIRE__ENCRYPT__REQUIRE__DECRYPT() bool {
	_, ok := _this.Get_().(ESDKCommitmentPolicy_REQUIRE__ENCRYPT__REQUIRE__DECRYPT)
	return ok
}

func (CompanionStruct_ESDKCommitmentPolicy_) Default() ESDKCommitmentPolicy {
	return Companion_ESDKCommitmentPolicy_.Create_FORBID__ENCRYPT__ALLOW__DECRYPT_()
}

func (_ CompanionStruct_ESDKCommitmentPolicy_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_ESDKCommitmentPolicy_.Create_FORBID__ENCRYPT__ALLOW__DECRYPT_(), true
		case 1:
			return Companion_ESDKCommitmentPolicy_.Create_REQUIRE__ENCRYPT__ALLOW__DECRYPT_(), true
		case 2:
			return Companion_ESDKCommitmentPolicy_.Create_REQUIRE__ENCRYPT__REQUIRE__DECRYPT_(), true
		default:
			return ESDKCommitmentPolicy{}, false
		}
	}
}

func (_this ESDKCommitmentPolicy) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case ESDKCommitmentPolicy_FORBID__ENCRYPT__ALLOW__DECRYPT:
		{
			return "AwsCryptographyMaterialProvidersTypes.ESDKCommitmentPolicy.FORBID_ENCRYPT_ALLOW_DECRYPT"
		}
	case ESDKCommitmentPolicy_REQUIRE__ENCRYPT__ALLOW__DECRYPT:
		{
			return "AwsCryptographyMaterialProvidersTypes.ESDKCommitmentPolicy.REQUIRE_ENCRYPT_ALLOW_DECRYPT"
		}
	case ESDKCommitmentPolicy_REQUIRE__ENCRYPT__REQUIRE__DECRYPT:
		{
			return "AwsCryptographyMaterialProvidersTypes.ESDKCommitmentPolicy.REQUIRE_ENCRYPT_REQUIRE_DECRYPT"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ESDKCommitmentPolicy) Equals(other ESDKCommitmentPolicy) bool {
	switch _this.Get_().(type) {
	case ESDKCommitmentPolicy_FORBID__ENCRYPT__ALLOW__DECRYPT:
		{
			_, ok := other.Get_().(ESDKCommitmentPolicy_FORBID__ENCRYPT__ALLOW__DECRYPT)
			return ok
		}
	case ESDKCommitmentPolicy_REQUIRE__ENCRYPT__ALLOW__DECRYPT:
		{
			_, ok := other.Get_().(ESDKCommitmentPolicy_REQUIRE__ENCRYPT__ALLOW__DECRYPT)
			return ok
		}
	case ESDKCommitmentPolicy_REQUIRE__ENCRYPT__REQUIRE__DECRYPT:
		{
			_, ok := other.Get_().(ESDKCommitmentPolicy_REQUIRE__ENCRYPT__REQUIRE__DECRYPT)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ESDKCommitmentPolicy) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ESDKCommitmentPolicy)
	return ok && _this.Equals(typed)
}

func Type_ESDKCommitmentPolicy_() _dafny.TypeDescriptor {
	return type_ESDKCommitmentPolicy_{}
}

type type_ESDKCommitmentPolicy_ struct {
}

func (_this type_ESDKCommitmentPolicy_) Default() interface{} {
	return Companion_ESDKCommitmentPolicy_.Default()
}

func (_this type_ESDKCommitmentPolicy_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.ESDKCommitmentPolicy"
}
func (_this ESDKCommitmentPolicy) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ESDKCommitmentPolicy{}

// End of datatype ESDKCommitmentPolicy

// Definition of datatype GetBranchKeyIdInput
type GetBranchKeyIdInput struct {
	Data_GetBranchKeyIdInput_
}

func (_this GetBranchKeyIdInput) Get_() Data_GetBranchKeyIdInput_ {
	return _this.Data_GetBranchKeyIdInput_
}

type Data_GetBranchKeyIdInput_ interface {
	isGetBranchKeyIdInput()
}

type CompanionStruct_GetBranchKeyIdInput_ struct {
}

var Companion_GetBranchKeyIdInput_ = CompanionStruct_GetBranchKeyIdInput_{}

type GetBranchKeyIdInput_GetBranchKeyIdInput struct {
	EncryptionContext _dafny.Map
}

func (GetBranchKeyIdInput_GetBranchKeyIdInput) isGetBranchKeyIdInput() {}

func (CompanionStruct_GetBranchKeyIdInput_) Create_GetBranchKeyIdInput_(EncryptionContext _dafny.Map) GetBranchKeyIdInput {
	return GetBranchKeyIdInput{GetBranchKeyIdInput_GetBranchKeyIdInput{EncryptionContext}}
}

func (_this GetBranchKeyIdInput) Is_GetBranchKeyIdInput() bool {
	_, ok := _this.Get_().(GetBranchKeyIdInput_GetBranchKeyIdInput)
	return ok
}

func (CompanionStruct_GetBranchKeyIdInput_) Default() GetBranchKeyIdInput {
	return Companion_GetBranchKeyIdInput_.Create_GetBranchKeyIdInput_(_dafny.EmptyMap)
}

func (_this GetBranchKeyIdInput) Dtor_encryptionContext() _dafny.Map {
	return _this.Get_().(GetBranchKeyIdInput_GetBranchKeyIdInput).EncryptionContext
}

func (_this GetBranchKeyIdInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetBranchKeyIdInput_GetBranchKeyIdInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.GetBranchKeyIdInput.GetBranchKeyIdInput" + "(" + _dafny.String(data.EncryptionContext) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetBranchKeyIdInput) Equals(other GetBranchKeyIdInput) bool {
	switch data1 := _this.Get_().(type) {
	case GetBranchKeyIdInput_GetBranchKeyIdInput:
		{
			data2, ok := other.Get_().(GetBranchKeyIdInput_GetBranchKeyIdInput)
			return ok && data1.EncryptionContext.Equals(data2.EncryptionContext)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetBranchKeyIdInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetBranchKeyIdInput)
	return ok && _this.Equals(typed)
}

func Type_GetBranchKeyIdInput_() _dafny.TypeDescriptor {
	return type_GetBranchKeyIdInput_{}
}

type type_GetBranchKeyIdInput_ struct {
}

func (_this type_GetBranchKeyIdInput_) Default() interface{} {
	return Companion_GetBranchKeyIdInput_.Default()
}

func (_this type_GetBranchKeyIdInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.GetBranchKeyIdInput"
}
func (_this GetBranchKeyIdInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetBranchKeyIdInput{}

// End of datatype GetBranchKeyIdInput

// Definition of datatype GetBranchKeyIdOutput
type GetBranchKeyIdOutput struct {
	Data_GetBranchKeyIdOutput_
}

func (_this GetBranchKeyIdOutput) Get_() Data_GetBranchKeyIdOutput_ {
	return _this.Data_GetBranchKeyIdOutput_
}

type Data_GetBranchKeyIdOutput_ interface {
	isGetBranchKeyIdOutput()
}

type CompanionStruct_GetBranchKeyIdOutput_ struct {
}

var Companion_GetBranchKeyIdOutput_ = CompanionStruct_GetBranchKeyIdOutput_{}

type GetBranchKeyIdOutput_GetBranchKeyIdOutput struct {
	BranchKeyId _dafny.Sequence
}

func (GetBranchKeyIdOutput_GetBranchKeyIdOutput) isGetBranchKeyIdOutput() {}

func (CompanionStruct_GetBranchKeyIdOutput_) Create_GetBranchKeyIdOutput_(BranchKeyId _dafny.Sequence) GetBranchKeyIdOutput {
	return GetBranchKeyIdOutput{GetBranchKeyIdOutput_GetBranchKeyIdOutput{BranchKeyId}}
}

func (_this GetBranchKeyIdOutput) Is_GetBranchKeyIdOutput() bool {
	_, ok := _this.Get_().(GetBranchKeyIdOutput_GetBranchKeyIdOutput)
	return ok
}

func (CompanionStruct_GetBranchKeyIdOutput_) Default() GetBranchKeyIdOutput {
	return Companion_GetBranchKeyIdOutput_.Create_GetBranchKeyIdOutput_(_dafny.EmptySeq.SetString())
}

func (_this GetBranchKeyIdOutput) Dtor_branchKeyId() _dafny.Sequence {
	return _this.Get_().(GetBranchKeyIdOutput_GetBranchKeyIdOutput).BranchKeyId
}

func (_this GetBranchKeyIdOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetBranchKeyIdOutput_GetBranchKeyIdOutput:
		{
			return "AwsCryptographyMaterialProvidersTypes.GetBranchKeyIdOutput.GetBranchKeyIdOutput" + "(" + _dafny.String(data.BranchKeyId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetBranchKeyIdOutput) Equals(other GetBranchKeyIdOutput) bool {
	switch data1 := _this.Get_().(type) {
	case GetBranchKeyIdOutput_GetBranchKeyIdOutput:
		{
			data2, ok := other.Get_().(GetBranchKeyIdOutput_GetBranchKeyIdOutput)
			return ok && data1.BranchKeyId.Equals(data2.BranchKeyId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetBranchKeyIdOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetBranchKeyIdOutput)
	return ok && _this.Equals(typed)
}

func Type_GetBranchKeyIdOutput_() _dafny.TypeDescriptor {
	return type_GetBranchKeyIdOutput_{}
}

type type_GetBranchKeyIdOutput_ struct {
}

func (_this type_GetBranchKeyIdOutput_) Default() interface{} {
	return Companion_GetBranchKeyIdOutput_.Default()
}

func (_this type_GetBranchKeyIdOutput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.GetBranchKeyIdOutput"
}
func (_this GetBranchKeyIdOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetBranchKeyIdOutput{}

// End of datatype GetBranchKeyIdOutput

// Definition of datatype GetCacheEntryInput
type GetCacheEntryInput struct {
	Data_GetCacheEntryInput_
}

func (_this GetCacheEntryInput) Get_() Data_GetCacheEntryInput_ {
	return _this.Data_GetCacheEntryInput_
}

type Data_GetCacheEntryInput_ interface {
	isGetCacheEntryInput()
}

type CompanionStruct_GetCacheEntryInput_ struct {
}

var Companion_GetCacheEntryInput_ = CompanionStruct_GetCacheEntryInput_{}

type GetCacheEntryInput_GetCacheEntryInput struct {
	Identifier _dafny.Sequence
	BytesUsed  m_Wrappers.Option
}

func (GetCacheEntryInput_GetCacheEntryInput) isGetCacheEntryInput() {}

func (CompanionStruct_GetCacheEntryInput_) Create_GetCacheEntryInput_(Identifier _dafny.Sequence, BytesUsed m_Wrappers.Option) GetCacheEntryInput {
	return GetCacheEntryInput{GetCacheEntryInput_GetCacheEntryInput{Identifier, BytesUsed}}
}

func (_this GetCacheEntryInput) Is_GetCacheEntryInput() bool {
	_, ok := _this.Get_().(GetCacheEntryInput_GetCacheEntryInput)
	return ok
}

func (CompanionStruct_GetCacheEntryInput_) Default() GetCacheEntryInput {
	return Companion_GetCacheEntryInput_.Create_GetCacheEntryInput_(_dafny.EmptySeq, m_Wrappers.Companion_Option_.Default())
}

func (_this GetCacheEntryInput) Dtor_identifier() _dafny.Sequence {
	return _this.Get_().(GetCacheEntryInput_GetCacheEntryInput).Identifier
}

func (_this GetCacheEntryInput) Dtor_bytesUsed() m_Wrappers.Option {
	return _this.Get_().(GetCacheEntryInput_GetCacheEntryInput).BytesUsed
}

func (_this GetCacheEntryInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetCacheEntryInput_GetCacheEntryInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.GetCacheEntryInput.GetCacheEntryInput" + "(" + _dafny.String(data.Identifier) + ", " + _dafny.String(data.BytesUsed) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetCacheEntryInput) Equals(other GetCacheEntryInput) bool {
	switch data1 := _this.Get_().(type) {
	case GetCacheEntryInput_GetCacheEntryInput:
		{
			data2, ok := other.Get_().(GetCacheEntryInput_GetCacheEntryInput)
			return ok && data1.Identifier.Equals(data2.Identifier) && data1.BytesUsed.Equals(data2.BytesUsed)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetCacheEntryInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetCacheEntryInput)
	return ok && _this.Equals(typed)
}

func Type_GetCacheEntryInput_() _dafny.TypeDescriptor {
	return type_GetCacheEntryInput_{}
}

type type_GetCacheEntryInput_ struct {
}

func (_this type_GetCacheEntryInput_) Default() interface{} {
	return Companion_GetCacheEntryInput_.Default()
}

func (_this type_GetCacheEntryInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.GetCacheEntryInput"
}
func (_this GetCacheEntryInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetCacheEntryInput{}

// End of datatype GetCacheEntryInput

// Definition of datatype GetCacheEntryOutput
type GetCacheEntryOutput struct {
	Data_GetCacheEntryOutput_
}

func (_this GetCacheEntryOutput) Get_() Data_GetCacheEntryOutput_ {
	return _this.Data_GetCacheEntryOutput_
}

type Data_GetCacheEntryOutput_ interface {
	isGetCacheEntryOutput()
}

type CompanionStruct_GetCacheEntryOutput_ struct {
}

var Companion_GetCacheEntryOutput_ = CompanionStruct_GetCacheEntryOutput_{}

type GetCacheEntryOutput_GetCacheEntryOutput struct {
	Materials    Materials
	CreationTime int64
	ExpiryTime   int64
	MessagesUsed int32
	BytesUsed    int32
}

func (GetCacheEntryOutput_GetCacheEntryOutput) isGetCacheEntryOutput() {}

func (CompanionStruct_GetCacheEntryOutput_) Create_GetCacheEntryOutput_(Materials Materials, CreationTime int64, ExpiryTime int64, MessagesUsed int32, BytesUsed int32) GetCacheEntryOutput {
	return GetCacheEntryOutput{GetCacheEntryOutput_GetCacheEntryOutput{Materials, CreationTime, ExpiryTime, MessagesUsed, BytesUsed}}
}

func (_this GetCacheEntryOutput) Is_GetCacheEntryOutput() bool {
	_, ok := _this.Get_().(GetCacheEntryOutput_GetCacheEntryOutput)
	return ok
}

func (CompanionStruct_GetCacheEntryOutput_) Default() GetCacheEntryOutput {
	return Companion_GetCacheEntryOutput_.Create_GetCacheEntryOutput_(Companion_Materials_.Default(), int64(0), int64(0), int32(0), int32(0))
}

func (_this GetCacheEntryOutput) Dtor_materials() Materials {
	return _this.Get_().(GetCacheEntryOutput_GetCacheEntryOutput).Materials
}

func (_this GetCacheEntryOutput) Dtor_creationTime() int64 {
	return _this.Get_().(GetCacheEntryOutput_GetCacheEntryOutput).CreationTime
}

func (_this GetCacheEntryOutput) Dtor_expiryTime() int64 {
	return _this.Get_().(GetCacheEntryOutput_GetCacheEntryOutput).ExpiryTime
}

func (_this GetCacheEntryOutput) Dtor_messagesUsed() int32 {
	return _this.Get_().(GetCacheEntryOutput_GetCacheEntryOutput).MessagesUsed
}

func (_this GetCacheEntryOutput) Dtor_bytesUsed() int32 {
	return _this.Get_().(GetCacheEntryOutput_GetCacheEntryOutput).BytesUsed
}

func (_this GetCacheEntryOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetCacheEntryOutput_GetCacheEntryOutput:
		{
			return "AwsCryptographyMaterialProvidersTypes.GetCacheEntryOutput.GetCacheEntryOutput" + "(" + _dafny.String(data.Materials) + ", " + _dafny.String(data.CreationTime) + ", " + _dafny.String(data.ExpiryTime) + ", " + _dafny.String(data.MessagesUsed) + ", " + _dafny.String(data.BytesUsed) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetCacheEntryOutput) Equals(other GetCacheEntryOutput) bool {
	switch data1 := _this.Get_().(type) {
	case GetCacheEntryOutput_GetCacheEntryOutput:
		{
			data2, ok := other.Get_().(GetCacheEntryOutput_GetCacheEntryOutput)
			return ok && data1.Materials.Equals(data2.Materials) && data1.CreationTime == data2.CreationTime && data1.ExpiryTime == data2.ExpiryTime && data1.MessagesUsed == data2.MessagesUsed && data1.BytesUsed == data2.BytesUsed
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetCacheEntryOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetCacheEntryOutput)
	return ok && _this.Equals(typed)
}

func Type_GetCacheEntryOutput_() _dafny.TypeDescriptor {
	return type_GetCacheEntryOutput_{}
}

type type_GetCacheEntryOutput_ struct {
}

func (_this type_GetCacheEntryOutput_) Default() interface{} {
	return Companion_GetCacheEntryOutput_.Default()
}

func (_this type_GetCacheEntryOutput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.GetCacheEntryOutput"
}
func (_this GetCacheEntryOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetCacheEntryOutput{}

// End of datatype GetCacheEntryOutput

// Definition of datatype GetClientInput
type GetClientInput struct {
	Data_GetClientInput_
}

func (_this GetClientInput) Get_() Data_GetClientInput_ {
	return _this.Data_GetClientInput_
}

type Data_GetClientInput_ interface {
	isGetClientInput()
}

type CompanionStruct_GetClientInput_ struct {
}

var Companion_GetClientInput_ = CompanionStruct_GetClientInput_{}

type GetClientInput_GetClientInput struct {
	Region _dafny.Sequence
}

func (GetClientInput_GetClientInput) isGetClientInput() {}

func (CompanionStruct_GetClientInput_) Create_GetClientInput_(Region _dafny.Sequence) GetClientInput {
	return GetClientInput{GetClientInput_GetClientInput{Region}}
}

func (_this GetClientInput) Is_GetClientInput() bool {
	_, ok := _this.Get_().(GetClientInput_GetClientInput)
	return ok
}

func (CompanionStruct_GetClientInput_) Default() GetClientInput {
	return Companion_GetClientInput_.Create_GetClientInput_(_dafny.EmptySeq.SetString())
}

func (_this GetClientInput) Dtor_region() _dafny.Sequence {
	return _this.Get_().(GetClientInput_GetClientInput).Region
}

func (_this GetClientInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetClientInput_GetClientInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.GetClientInput.GetClientInput" + "(" + _dafny.String(data.Region) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetClientInput) Equals(other GetClientInput) bool {
	switch data1 := _this.Get_().(type) {
	case GetClientInput_GetClientInput:
		{
			data2, ok := other.Get_().(GetClientInput_GetClientInput)
			return ok && data1.Region.Equals(data2.Region)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetClientInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetClientInput)
	return ok && _this.Equals(typed)
}

func Type_GetClientInput_() _dafny.TypeDescriptor {
	return type_GetClientInput_{}
}

type type_GetClientInput_ struct {
}

func (_this type_GetClientInput_) Default() interface{} {
	return Companion_GetClientInput_.Default()
}

func (_this type_GetClientInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.GetClientInput"
}
func (_this GetClientInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetClientInput{}

// End of datatype GetClientInput

// Definition of datatype GetEncryptionMaterialsInput
type GetEncryptionMaterialsInput struct {
	Data_GetEncryptionMaterialsInput_
}

func (_this GetEncryptionMaterialsInput) Get_() Data_GetEncryptionMaterialsInput_ {
	return _this.Data_GetEncryptionMaterialsInput_
}

type Data_GetEncryptionMaterialsInput_ interface {
	isGetEncryptionMaterialsInput()
}

type CompanionStruct_GetEncryptionMaterialsInput_ struct {
}

var Companion_GetEncryptionMaterialsInput_ = CompanionStruct_GetEncryptionMaterialsInput_{}

type GetEncryptionMaterialsInput_GetEncryptionMaterialsInput struct {
	EncryptionContext             _dafny.Map
	CommitmentPolicy              CommitmentPolicy
	AlgorithmSuiteId              m_Wrappers.Option
	MaxPlaintextLength            m_Wrappers.Option
	RequiredEncryptionContextKeys m_Wrappers.Option
}

func (GetEncryptionMaterialsInput_GetEncryptionMaterialsInput) isGetEncryptionMaterialsInput() {}

func (CompanionStruct_GetEncryptionMaterialsInput_) Create_GetEncryptionMaterialsInput_(EncryptionContext _dafny.Map, CommitmentPolicy CommitmentPolicy, AlgorithmSuiteId m_Wrappers.Option, MaxPlaintextLength m_Wrappers.Option, RequiredEncryptionContextKeys m_Wrappers.Option) GetEncryptionMaterialsInput {
	return GetEncryptionMaterialsInput{GetEncryptionMaterialsInput_GetEncryptionMaterialsInput{EncryptionContext, CommitmentPolicy, AlgorithmSuiteId, MaxPlaintextLength, RequiredEncryptionContextKeys}}
}

func (_this GetEncryptionMaterialsInput) Is_GetEncryptionMaterialsInput() bool {
	_, ok := _this.Get_().(GetEncryptionMaterialsInput_GetEncryptionMaterialsInput)
	return ok
}

func (CompanionStruct_GetEncryptionMaterialsInput_) Default() GetEncryptionMaterialsInput {
	return Companion_GetEncryptionMaterialsInput_.Create_GetEncryptionMaterialsInput_(_dafny.EmptyMap, Companion_CommitmentPolicy_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GetEncryptionMaterialsInput) Dtor_encryptionContext() _dafny.Map {
	return _this.Get_().(GetEncryptionMaterialsInput_GetEncryptionMaterialsInput).EncryptionContext
}

func (_this GetEncryptionMaterialsInput) Dtor_commitmentPolicy() CommitmentPolicy {
	return _this.Get_().(GetEncryptionMaterialsInput_GetEncryptionMaterialsInput).CommitmentPolicy
}

func (_this GetEncryptionMaterialsInput) Dtor_algorithmSuiteId() m_Wrappers.Option {
	return _this.Get_().(GetEncryptionMaterialsInput_GetEncryptionMaterialsInput).AlgorithmSuiteId
}

func (_this GetEncryptionMaterialsInput) Dtor_maxPlaintextLength() m_Wrappers.Option {
	return _this.Get_().(GetEncryptionMaterialsInput_GetEncryptionMaterialsInput).MaxPlaintextLength
}

func (_this GetEncryptionMaterialsInput) Dtor_requiredEncryptionContextKeys() m_Wrappers.Option {
	return _this.Get_().(GetEncryptionMaterialsInput_GetEncryptionMaterialsInput).RequiredEncryptionContextKeys
}

func (_this GetEncryptionMaterialsInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetEncryptionMaterialsInput_GetEncryptionMaterialsInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsInput.GetEncryptionMaterialsInput" + "(" + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.CommitmentPolicy) + ", " + _dafny.String(data.AlgorithmSuiteId) + ", " + _dafny.String(data.MaxPlaintextLength) + ", " + _dafny.String(data.RequiredEncryptionContextKeys) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetEncryptionMaterialsInput) Equals(other GetEncryptionMaterialsInput) bool {
	switch data1 := _this.Get_().(type) {
	case GetEncryptionMaterialsInput_GetEncryptionMaterialsInput:
		{
			data2, ok := other.Get_().(GetEncryptionMaterialsInput_GetEncryptionMaterialsInput)
			return ok && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.CommitmentPolicy.Equals(data2.CommitmentPolicy) && data1.AlgorithmSuiteId.Equals(data2.AlgorithmSuiteId) && data1.MaxPlaintextLength.Equals(data2.MaxPlaintextLength) && data1.RequiredEncryptionContextKeys.Equals(data2.RequiredEncryptionContextKeys)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetEncryptionMaterialsInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetEncryptionMaterialsInput)
	return ok && _this.Equals(typed)
}

func Type_GetEncryptionMaterialsInput_() _dafny.TypeDescriptor {
	return type_GetEncryptionMaterialsInput_{}
}

type type_GetEncryptionMaterialsInput_ struct {
}

func (_this type_GetEncryptionMaterialsInput_) Default() interface{} {
	return Companion_GetEncryptionMaterialsInput_.Default()
}

func (_this type_GetEncryptionMaterialsInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsInput"
}
func (_this GetEncryptionMaterialsInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetEncryptionMaterialsInput{}

// End of datatype GetEncryptionMaterialsInput

// Definition of datatype GetEncryptionMaterialsOutput
type GetEncryptionMaterialsOutput struct {
	Data_GetEncryptionMaterialsOutput_
}

func (_this GetEncryptionMaterialsOutput) Get_() Data_GetEncryptionMaterialsOutput_ {
	return _this.Data_GetEncryptionMaterialsOutput_
}

type Data_GetEncryptionMaterialsOutput_ interface {
	isGetEncryptionMaterialsOutput()
}

type CompanionStruct_GetEncryptionMaterialsOutput_ struct {
}

var Companion_GetEncryptionMaterialsOutput_ = CompanionStruct_GetEncryptionMaterialsOutput_{}

type GetEncryptionMaterialsOutput_GetEncryptionMaterialsOutput struct {
	EncryptionMaterials EncryptionMaterials
}

func (GetEncryptionMaterialsOutput_GetEncryptionMaterialsOutput) isGetEncryptionMaterialsOutput() {}

func (CompanionStruct_GetEncryptionMaterialsOutput_) Create_GetEncryptionMaterialsOutput_(EncryptionMaterials EncryptionMaterials) GetEncryptionMaterialsOutput {
	return GetEncryptionMaterialsOutput{GetEncryptionMaterialsOutput_GetEncryptionMaterialsOutput{EncryptionMaterials}}
}

func (_this GetEncryptionMaterialsOutput) Is_GetEncryptionMaterialsOutput() bool {
	_, ok := _this.Get_().(GetEncryptionMaterialsOutput_GetEncryptionMaterialsOutput)
	return ok
}

func (CompanionStruct_GetEncryptionMaterialsOutput_) Default() GetEncryptionMaterialsOutput {
	return Companion_GetEncryptionMaterialsOutput_.Create_GetEncryptionMaterialsOutput_(Companion_EncryptionMaterials_.Default())
}

func (_this GetEncryptionMaterialsOutput) Dtor_encryptionMaterials() EncryptionMaterials {
	return _this.Get_().(GetEncryptionMaterialsOutput_GetEncryptionMaterialsOutput).EncryptionMaterials
}

func (_this GetEncryptionMaterialsOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetEncryptionMaterialsOutput_GetEncryptionMaterialsOutput:
		{
			return "AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsOutput.GetEncryptionMaterialsOutput" + "(" + _dafny.String(data.EncryptionMaterials) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetEncryptionMaterialsOutput) Equals(other GetEncryptionMaterialsOutput) bool {
	switch data1 := _this.Get_().(type) {
	case GetEncryptionMaterialsOutput_GetEncryptionMaterialsOutput:
		{
			data2, ok := other.Get_().(GetEncryptionMaterialsOutput_GetEncryptionMaterialsOutput)
			return ok && data1.EncryptionMaterials.Equals(data2.EncryptionMaterials)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetEncryptionMaterialsOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetEncryptionMaterialsOutput)
	return ok && _this.Equals(typed)
}

func Type_GetEncryptionMaterialsOutput_() _dafny.TypeDescriptor {
	return type_GetEncryptionMaterialsOutput_{}
}

type type_GetEncryptionMaterialsOutput_ struct {
}

func (_this type_GetEncryptionMaterialsOutput_) Default() interface{} {
	return Companion_GetEncryptionMaterialsOutput_.Default()
}

func (_this type_GetEncryptionMaterialsOutput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsOutput"
}
func (_this GetEncryptionMaterialsOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetEncryptionMaterialsOutput{}

// End of datatype GetEncryptionMaterialsOutput

// Definition of datatype HKDF
type HKDF struct {
	Data_HKDF_
}

func (_this HKDF) Get_() Data_HKDF_ {
	return _this.Data_HKDF_
}

type Data_HKDF_ interface {
	isHKDF()
}

type CompanionStruct_HKDF_ struct {
}

var Companion_HKDF_ = CompanionStruct_HKDF_{}

type HKDF_HKDF struct {
	Hmac            m_AwsCryptographyPrimitivesTypes.DigestAlgorithm
	SaltLength      int32
	InputKeyLength  int32
	OutputKeyLength int32
}

func (HKDF_HKDF) isHKDF() {}

func (CompanionStruct_HKDF_) Create_HKDF_(Hmac m_AwsCryptographyPrimitivesTypes.DigestAlgorithm, SaltLength int32, InputKeyLength int32, OutputKeyLength int32) HKDF {
	return HKDF{HKDF_HKDF{Hmac, SaltLength, InputKeyLength, OutputKeyLength}}
}

func (_this HKDF) Is_HKDF() bool {
	_, ok := _this.Get_().(HKDF_HKDF)
	return ok
}

func (CompanionStruct_HKDF_) Default() HKDF {
	return Companion_HKDF_.Create_HKDF_(m_AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Default(), int32(0), int32(0), int32(0))
}

func (_this HKDF) Dtor_hmac() m_AwsCryptographyPrimitivesTypes.DigestAlgorithm {
	return _this.Get_().(HKDF_HKDF).Hmac
}

func (_this HKDF) Dtor_saltLength() int32 {
	return _this.Get_().(HKDF_HKDF).SaltLength
}

func (_this HKDF) Dtor_inputKeyLength() int32 {
	return _this.Get_().(HKDF_HKDF).InputKeyLength
}

func (_this HKDF) Dtor_outputKeyLength() int32 {
	return _this.Get_().(HKDF_HKDF).OutputKeyLength
}

func (_this HKDF) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case HKDF_HKDF:
		{
			return "AwsCryptographyMaterialProvidersTypes.HKDF.HKDF" + "(" + _dafny.String(data.Hmac) + ", " + _dafny.String(data.SaltLength) + ", " + _dafny.String(data.InputKeyLength) + ", " + _dafny.String(data.OutputKeyLength) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this HKDF) Equals(other HKDF) bool {
	switch data1 := _this.Get_().(type) {
	case HKDF_HKDF:
		{
			data2, ok := other.Get_().(HKDF_HKDF)
			return ok && data1.Hmac.Equals(data2.Hmac) && data1.SaltLength == data2.SaltLength && data1.InputKeyLength == data2.InputKeyLength && data1.OutputKeyLength == data2.OutputKeyLength
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this HKDF) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(HKDF)
	return ok && _this.Equals(typed)
}

func Type_HKDF_() _dafny.TypeDescriptor {
	return type_HKDF_{}
}

type type_HKDF_ struct {
}

func (_this type_HKDF_) Default() interface{} {
	return Companion_HKDF_.Default()
}

func (_this type_HKDF_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.HKDF"
}
func (_this HKDF) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = HKDF{}

// End of datatype HKDF

// Definition of datatype IDENTITY
type IDENTITY struct {
	Data_IDENTITY_
}

func (_this IDENTITY) Get_() Data_IDENTITY_ {
	return _this.Data_IDENTITY_
}

type Data_IDENTITY_ interface {
	isIDENTITY()
}

type CompanionStruct_IDENTITY_ struct {
}

var Companion_IDENTITY_ = CompanionStruct_IDENTITY_{}

type IDENTITY_IDENTITY struct {
}

func (IDENTITY_IDENTITY) isIDENTITY() {}

func (CompanionStruct_IDENTITY_) Create_IDENTITY_() IDENTITY {
	return IDENTITY{IDENTITY_IDENTITY{}}
}

func (_this IDENTITY) Is_IDENTITY() bool {
	_, ok := _this.Get_().(IDENTITY_IDENTITY)
	return ok
}

func (CompanionStruct_IDENTITY_) Default() IDENTITY {
	return Companion_IDENTITY_.Create_IDENTITY_()
}

func (_ CompanionStruct_IDENTITY_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_IDENTITY_.Create_IDENTITY_(), true
		default:
			return IDENTITY{}, false
		}
	}
}

func (_this IDENTITY) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case IDENTITY_IDENTITY:
		{
			return "AwsCryptographyMaterialProvidersTypes.IDENTITY.IDENTITY"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this IDENTITY) Equals(other IDENTITY) bool {
	switch _this.Get_().(type) {
	case IDENTITY_IDENTITY:
		{
			_, ok := other.Get_().(IDENTITY_IDENTITY)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this IDENTITY) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(IDENTITY)
	return ok && _this.Equals(typed)
}

func Type_IDENTITY_() _dafny.TypeDescriptor {
	return type_IDENTITY_{}
}

type type_IDENTITY_ struct {
}

func (_this type_IDENTITY_) Default() interface{} {
	return Companion_IDENTITY_.Default()
}

func (_this type_IDENTITY_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.IDENTITY"
}
func (_this IDENTITY) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = IDENTITY{}

// End of datatype IDENTITY

// Definition of datatype InitializeDecryptionMaterialsInput
type InitializeDecryptionMaterialsInput struct {
	Data_InitializeDecryptionMaterialsInput_
}

func (_this InitializeDecryptionMaterialsInput) Get_() Data_InitializeDecryptionMaterialsInput_ {
	return _this.Data_InitializeDecryptionMaterialsInput_
}

type Data_InitializeDecryptionMaterialsInput_ interface {
	isInitializeDecryptionMaterialsInput()
}

type CompanionStruct_InitializeDecryptionMaterialsInput_ struct {
}

var Companion_InitializeDecryptionMaterialsInput_ = CompanionStruct_InitializeDecryptionMaterialsInput_{}

type InitializeDecryptionMaterialsInput_InitializeDecryptionMaterialsInput struct {
	AlgorithmSuiteId              AlgorithmSuiteId
	EncryptionContext             _dafny.Map
	RequiredEncryptionContextKeys _dafny.Sequence
}

func (InitializeDecryptionMaterialsInput_InitializeDecryptionMaterialsInput) isInitializeDecryptionMaterialsInput() {
}

func (CompanionStruct_InitializeDecryptionMaterialsInput_) Create_InitializeDecryptionMaterialsInput_(AlgorithmSuiteId AlgorithmSuiteId, EncryptionContext _dafny.Map, RequiredEncryptionContextKeys _dafny.Sequence) InitializeDecryptionMaterialsInput {
	return InitializeDecryptionMaterialsInput{InitializeDecryptionMaterialsInput_InitializeDecryptionMaterialsInput{AlgorithmSuiteId, EncryptionContext, RequiredEncryptionContextKeys}}
}

func (_this InitializeDecryptionMaterialsInput) Is_InitializeDecryptionMaterialsInput() bool {
	_, ok := _this.Get_().(InitializeDecryptionMaterialsInput_InitializeDecryptionMaterialsInput)
	return ok
}

func (CompanionStruct_InitializeDecryptionMaterialsInput_) Default() InitializeDecryptionMaterialsInput {
	return Companion_InitializeDecryptionMaterialsInput_.Create_InitializeDecryptionMaterialsInput_(Companion_AlgorithmSuiteId_.Default(), _dafny.EmptyMap, _dafny.EmptySeq)
}

func (_this InitializeDecryptionMaterialsInput) Dtor_algorithmSuiteId() AlgorithmSuiteId {
	return _this.Get_().(InitializeDecryptionMaterialsInput_InitializeDecryptionMaterialsInput).AlgorithmSuiteId
}

func (_this InitializeDecryptionMaterialsInput) Dtor_encryptionContext() _dafny.Map {
	return _this.Get_().(InitializeDecryptionMaterialsInput_InitializeDecryptionMaterialsInput).EncryptionContext
}

func (_this InitializeDecryptionMaterialsInput) Dtor_requiredEncryptionContextKeys() _dafny.Sequence {
	return _this.Get_().(InitializeDecryptionMaterialsInput_InitializeDecryptionMaterialsInput).RequiredEncryptionContextKeys
}

func (_this InitializeDecryptionMaterialsInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case InitializeDecryptionMaterialsInput_InitializeDecryptionMaterialsInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.InitializeDecryptionMaterialsInput.InitializeDecryptionMaterialsInput" + "(" + _dafny.String(data.AlgorithmSuiteId) + ", " + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.RequiredEncryptionContextKeys) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this InitializeDecryptionMaterialsInput) Equals(other InitializeDecryptionMaterialsInput) bool {
	switch data1 := _this.Get_().(type) {
	case InitializeDecryptionMaterialsInput_InitializeDecryptionMaterialsInput:
		{
			data2, ok := other.Get_().(InitializeDecryptionMaterialsInput_InitializeDecryptionMaterialsInput)
			return ok && data1.AlgorithmSuiteId.Equals(data2.AlgorithmSuiteId) && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.RequiredEncryptionContextKeys.Equals(data2.RequiredEncryptionContextKeys)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this InitializeDecryptionMaterialsInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(InitializeDecryptionMaterialsInput)
	return ok && _this.Equals(typed)
}

func Type_InitializeDecryptionMaterialsInput_() _dafny.TypeDescriptor {
	return type_InitializeDecryptionMaterialsInput_{}
}

type type_InitializeDecryptionMaterialsInput_ struct {
}

func (_this type_InitializeDecryptionMaterialsInput_) Default() interface{} {
	return Companion_InitializeDecryptionMaterialsInput_.Default()
}

func (_this type_InitializeDecryptionMaterialsInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.InitializeDecryptionMaterialsInput"
}
func (_this InitializeDecryptionMaterialsInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = InitializeDecryptionMaterialsInput{}

// End of datatype InitializeDecryptionMaterialsInput

// Definition of datatype InitializeEncryptionMaterialsInput
type InitializeEncryptionMaterialsInput struct {
	Data_InitializeEncryptionMaterialsInput_
}

func (_this InitializeEncryptionMaterialsInput) Get_() Data_InitializeEncryptionMaterialsInput_ {
	return _this.Data_InitializeEncryptionMaterialsInput_
}

type Data_InitializeEncryptionMaterialsInput_ interface {
	isInitializeEncryptionMaterialsInput()
}

type CompanionStruct_InitializeEncryptionMaterialsInput_ struct {
}

var Companion_InitializeEncryptionMaterialsInput_ = CompanionStruct_InitializeEncryptionMaterialsInput_{}

type InitializeEncryptionMaterialsInput_InitializeEncryptionMaterialsInput struct {
	AlgorithmSuiteId              AlgorithmSuiteId
	EncryptionContext             _dafny.Map
	RequiredEncryptionContextKeys _dafny.Sequence
	SigningKey                    m_Wrappers.Option
	VerificationKey               m_Wrappers.Option
}

func (InitializeEncryptionMaterialsInput_InitializeEncryptionMaterialsInput) isInitializeEncryptionMaterialsInput() {
}

func (CompanionStruct_InitializeEncryptionMaterialsInput_) Create_InitializeEncryptionMaterialsInput_(AlgorithmSuiteId AlgorithmSuiteId, EncryptionContext _dafny.Map, RequiredEncryptionContextKeys _dafny.Sequence, SigningKey m_Wrappers.Option, VerificationKey m_Wrappers.Option) InitializeEncryptionMaterialsInput {
	return InitializeEncryptionMaterialsInput{InitializeEncryptionMaterialsInput_InitializeEncryptionMaterialsInput{AlgorithmSuiteId, EncryptionContext, RequiredEncryptionContextKeys, SigningKey, VerificationKey}}
}

func (_this InitializeEncryptionMaterialsInput) Is_InitializeEncryptionMaterialsInput() bool {
	_, ok := _this.Get_().(InitializeEncryptionMaterialsInput_InitializeEncryptionMaterialsInput)
	return ok
}

func (CompanionStruct_InitializeEncryptionMaterialsInput_) Default() InitializeEncryptionMaterialsInput {
	return Companion_InitializeEncryptionMaterialsInput_.Create_InitializeEncryptionMaterialsInput_(Companion_AlgorithmSuiteId_.Default(), _dafny.EmptyMap, _dafny.EmptySeq, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this InitializeEncryptionMaterialsInput) Dtor_algorithmSuiteId() AlgorithmSuiteId {
	return _this.Get_().(InitializeEncryptionMaterialsInput_InitializeEncryptionMaterialsInput).AlgorithmSuiteId
}

func (_this InitializeEncryptionMaterialsInput) Dtor_encryptionContext() _dafny.Map {
	return _this.Get_().(InitializeEncryptionMaterialsInput_InitializeEncryptionMaterialsInput).EncryptionContext
}

func (_this InitializeEncryptionMaterialsInput) Dtor_requiredEncryptionContextKeys() _dafny.Sequence {
	return _this.Get_().(InitializeEncryptionMaterialsInput_InitializeEncryptionMaterialsInput).RequiredEncryptionContextKeys
}

func (_this InitializeEncryptionMaterialsInput) Dtor_signingKey() m_Wrappers.Option {
	return _this.Get_().(InitializeEncryptionMaterialsInput_InitializeEncryptionMaterialsInput).SigningKey
}

func (_this InitializeEncryptionMaterialsInput) Dtor_verificationKey() m_Wrappers.Option {
	return _this.Get_().(InitializeEncryptionMaterialsInput_InitializeEncryptionMaterialsInput).VerificationKey
}

func (_this InitializeEncryptionMaterialsInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case InitializeEncryptionMaterialsInput_InitializeEncryptionMaterialsInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.InitializeEncryptionMaterialsInput.InitializeEncryptionMaterialsInput" + "(" + _dafny.String(data.AlgorithmSuiteId) + ", " + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.RequiredEncryptionContextKeys) + ", " + _dafny.String(data.SigningKey) + ", " + _dafny.String(data.VerificationKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this InitializeEncryptionMaterialsInput) Equals(other InitializeEncryptionMaterialsInput) bool {
	switch data1 := _this.Get_().(type) {
	case InitializeEncryptionMaterialsInput_InitializeEncryptionMaterialsInput:
		{
			data2, ok := other.Get_().(InitializeEncryptionMaterialsInput_InitializeEncryptionMaterialsInput)
			return ok && data1.AlgorithmSuiteId.Equals(data2.AlgorithmSuiteId) && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.RequiredEncryptionContextKeys.Equals(data2.RequiredEncryptionContextKeys) && data1.SigningKey.Equals(data2.SigningKey) && data1.VerificationKey.Equals(data2.VerificationKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this InitializeEncryptionMaterialsInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(InitializeEncryptionMaterialsInput)
	return ok && _this.Equals(typed)
}

func Type_InitializeEncryptionMaterialsInput_() _dafny.TypeDescriptor {
	return type_InitializeEncryptionMaterialsInput_{}
}

type type_InitializeEncryptionMaterialsInput_ struct {
}

func (_this type_InitializeEncryptionMaterialsInput_) Default() interface{} {
	return Companion_InitializeEncryptionMaterialsInput_.Default()
}

func (_this type_InitializeEncryptionMaterialsInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.InitializeEncryptionMaterialsInput"
}
func (_this InitializeEncryptionMaterialsInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = InitializeEncryptionMaterialsInput{}

// End of datatype InitializeEncryptionMaterialsInput

// Definition of datatype IntermediateKeyWrapping
type IntermediateKeyWrapping struct {
	Data_IntermediateKeyWrapping_
}

func (_this IntermediateKeyWrapping) Get_() Data_IntermediateKeyWrapping_ {
	return _this.Data_IntermediateKeyWrapping_
}

type Data_IntermediateKeyWrapping_ interface {
	isIntermediateKeyWrapping()
}

type CompanionStruct_IntermediateKeyWrapping_ struct {
}

var Companion_IntermediateKeyWrapping_ = CompanionStruct_IntermediateKeyWrapping_{}

type IntermediateKeyWrapping_IntermediateKeyWrapping struct {
	KeyEncryptionKeyKdf DerivationAlgorithm
	MacKeyKdf           DerivationAlgorithm
	PdkEncryptAlgorithm Encrypt
}

func (IntermediateKeyWrapping_IntermediateKeyWrapping) isIntermediateKeyWrapping() {}

func (CompanionStruct_IntermediateKeyWrapping_) Create_IntermediateKeyWrapping_(KeyEncryptionKeyKdf DerivationAlgorithm, MacKeyKdf DerivationAlgorithm, PdkEncryptAlgorithm Encrypt) IntermediateKeyWrapping {
	return IntermediateKeyWrapping{IntermediateKeyWrapping_IntermediateKeyWrapping{KeyEncryptionKeyKdf, MacKeyKdf, PdkEncryptAlgorithm}}
}

func (_this IntermediateKeyWrapping) Is_IntermediateKeyWrapping() bool {
	_, ok := _this.Get_().(IntermediateKeyWrapping_IntermediateKeyWrapping)
	return ok
}

func (CompanionStruct_IntermediateKeyWrapping_) Default() IntermediateKeyWrapping {
	return Companion_IntermediateKeyWrapping_.Create_IntermediateKeyWrapping_(Companion_DerivationAlgorithm_.Default(), Companion_DerivationAlgorithm_.Default(), Companion_Encrypt_.Default())
}

func (_this IntermediateKeyWrapping) Dtor_keyEncryptionKeyKdf() DerivationAlgorithm {
	return _this.Get_().(IntermediateKeyWrapping_IntermediateKeyWrapping).KeyEncryptionKeyKdf
}

func (_this IntermediateKeyWrapping) Dtor_macKeyKdf() DerivationAlgorithm {
	return _this.Get_().(IntermediateKeyWrapping_IntermediateKeyWrapping).MacKeyKdf
}

func (_this IntermediateKeyWrapping) Dtor_pdkEncryptAlgorithm() Encrypt {
	return _this.Get_().(IntermediateKeyWrapping_IntermediateKeyWrapping).PdkEncryptAlgorithm
}

func (_this IntermediateKeyWrapping) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case IntermediateKeyWrapping_IntermediateKeyWrapping:
		{
			return "AwsCryptographyMaterialProvidersTypes.IntermediateKeyWrapping.IntermediateKeyWrapping" + "(" + _dafny.String(data.KeyEncryptionKeyKdf) + ", " + _dafny.String(data.MacKeyKdf) + ", " + _dafny.String(data.PdkEncryptAlgorithm) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this IntermediateKeyWrapping) Equals(other IntermediateKeyWrapping) bool {
	switch data1 := _this.Get_().(type) {
	case IntermediateKeyWrapping_IntermediateKeyWrapping:
		{
			data2, ok := other.Get_().(IntermediateKeyWrapping_IntermediateKeyWrapping)
			return ok && data1.KeyEncryptionKeyKdf.Equals(data2.KeyEncryptionKeyKdf) && data1.MacKeyKdf.Equals(data2.MacKeyKdf) && data1.PdkEncryptAlgorithm.Equals(data2.PdkEncryptAlgorithm)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this IntermediateKeyWrapping) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(IntermediateKeyWrapping)
	return ok && _this.Equals(typed)
}

func Type_IntermediateKeyWrapping_() _dafny.TypeDescriptor {
	return type_IntermediateKeyWrapping_{}
}

type type_IntermediateKeyWrapping_ struct {
}

func (_this type_IntermediateKeyWrapping_) Default() interface{} {
	return Companion_IntermediateKeyWrapping_.Default()
}

func (_this type_IntermediateKeyWrapping_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.IntermediateKeyWrapping"
}
func (_this IntermediateKeyWrapping) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = IntermediateKeyWrapping{}

// End of datatype IntermediateKeyWrapping

// Definition of datatype KeyAgreementScheme
type KeyAgreementScheme struct {
	Data_KeyAgreementScheme_
}

func (_this KeyAgreementScheme) Get_() Data_KeyAgreementScheme_ {
	return _this.Data_KeyAgreementScheme_
}

type Data_KeyAgreementScheme_ interface {
	isKeyAgreementScheme()
}

type CompanionStruct_KeyAgreementScheme_ struct {
}

var Companion_KeyAgreementScheme_ = CompanionStruct_KeyAgreementScheme_{}

type KeyAgreementScheme_StaticConfiguration struct {
	StaticConfiguration StaticConfigurations
}

func (KeyAgreementScheme_StaticConfiguration) isKeyAgreementScheme() {}

func (CompanionStruct_KeyAgreementScheme_) Create_StaticConfiguration_(StaticConfiguration StaticConfigurations) KeyAgreementScheme {
	return KeyAgreementScheme{KeyAgreementScheme_StaticConfiguration{StaticConfiguration}}
}

func (_this KeyAgreementScheme) Is_StaticConfiguration() bool {
	_, ok := _this.Get_().(KeyAgreementScheme_StaticConfiguration)
	return ok
}

func (CompanionStruct_KeyAgreementScheme_) Default() KeyAgreementScheme {
	return Companion_KeyAgreementScheme_.Create_StaticConfiguration_(Companion_StaticConfigurations_.Default())
}

func (_this KeyAgreementScheme) Dtor_StaticConfiguration() StaticConfigurations {
	return _this.Get_().(KeyAgreementScheme_StaticConfiguration).StaticConfiguration
}

func (_this KeyAgreementScheme) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case KeyAgreementScheme_StaticConfiguration:
		{
			return "AwsCryptographyMaterialProvidersTypes.KeyAgreementScheme.StaticConfiguration" + "(" + _dafny.String(data.StaticConfiguration) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KeyAgreementScheme) Equals(other KeyAgreementScheme) bool {
	switch data1 := _this.Get_().(type) {
	case KeyAgreementScheme_StaticConfiguration:
		{
			data2, ok := other.Get_().(KeyAgreementScheme_StaticConfiguration)
			return ok && data1.StaticConfiguration.Equals(data2.StaticConfiguration)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KeyAgreementScheme) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KeyAgreementScheme)
	return ok && _this.Equals(typed)
}

func Type_KeyAgreementScheme_() _dafny.TypeDescriptor {
	return type_KeyAgreementScheme_{}
}

type type_KeyAgreementScheme_ struct {
}

func (_this type_KeyAgreementScheme_) Default() interface{} {
	return Companion_KeyAgreementScheme_.Default()
}

func (_this type_KeyAgreementScheme_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.KeyAgreementScheme"
}
func (_this KeyAgreementScheme) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KeyAgreementScheme{}

// End of datatype KeyAgreementScheme

// Definition of class IKeyringCallHistory
type IKeyringCallHistory struct {
	dummy byte
}

func New_IKeyringCallHistory_() *IKeyringCallHistory {
	_this := IKeyringCallHistory{}

	return &_this
}

type CompanionStruct_IKeyringCallHistory_ struct {
}

var Companion_IKeyringCallHistory_ = CompanionStruct_IKeyringCallHistory_{}

func (_this *IKeyringCallHistory) Equals(other *IKeyringCallHistory) bool {
	return _this == other
}

func (_this *IKeyringCallHistory) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*IKeyringCallHistory)
	return ok && _this.Equals(other)
}

func (*IKeyringCallHistory) String() string {
	return "AwsCryptographyMaterialProvidersTypes.IKeyringCallHistory"
}

func Type_IKeyringCallHistory_() _dafny.TypeDescriptor {
	return type_IKeyringCallHistory_{}
}

type type_IKeyringCallHistory_ struct {
}

func (_this type_IKeyringCallHistory_) Default() interface{} {
	return (*IKeyringCallHistory)(nil)
}

func (_this type_IKeyringCallHistory_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.IKeyringCallHistory"
}
func (_this *IKeyringCallHistory) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &IKeyringCallHistory{}

// End of class IKeyringCallHistory

// Definition of trait IKeyring
type IKeyring interface {
	String() string
	OnEncrypt(input OnEncryptInput) m_Wrappers.Result
	OnEncrypt_k(input OnEncryptInput) m_Wrappers.Result
	OnDecrypt(input OnDecryptInput) m_Wrappers.Result
	OnDecrypt_k(input OnDecryptInput) m_Wrappers.Result
}

func (_static *CompanionStruct_IKeyring_) OnEncrypt(_this IKeyring, input OnEncryptInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (_this).OnEncrypt_k(input)
		output = _out0
		return output
	}
}
func (_static *CompanionStruct_IKeyring_) OnDecrypt(_this IKeyring, input OnDecryptInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (_this).OnDecrypt_k(input)
		output = _out0
		return output
	}
}

type CompanionStruct_IKeyring_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_IKeyring_ = CompanionStruct_IKeyring_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_IKeyring_) CastTo_(x interface{}) IKeyring {
	var t IKeyring
	t, _ = x.(IKeyring)
	return t
}

// End of trait IKeyring

// Definition of datatype KmsEcdhStaticConfigurations
type KmsEcdhStaticConfigurations struct {
	Data_KmsEcdhStaticConfigurations_
}

func (_this KmsEcdhStaticConfigurations) Get_() Data_KmsEcdhStaticConfigurations_ {
	return _this.Data_KmsEcdhStaticConfigurations_
}

type Data_KmsEcdhStaticConfigurations_ interface {
	isKmsEcdhStaticConfigurations()
}

type CompanionStruct_KmsEcdhStaticConfigurations_ struct {
}

var Companion_KmsEcdhStaticConfigurations_ = CompanionStruct_KmsEcdhStaticConfigurations_{}

type KmsEcdhStaticConfigurations_KmsPublicKeyDiscovery struct {
	KmsPublicKeyDiscovery KmsPublicKeyDiscoveryInput
}

func (KmsEcdhStaticConfigurations_KmsPublicKeyDiscovery) isKmsEcdhStaticConfigurations() {}

func (CompanionStruct_KmsEcdhStaticConfigurations_) Create_KmsPublicKeyDiscovery_(KmsPublicKeyDiscovery KmsPublicKeyDiscoveryInput) KmsEcdhStaticConfigurations {
	return KmsEcdhStaticConfigurations{KmsEcdhStaticConfigurations_KmsPublicKeyDiscovery{KmsPublicKeyDiscovery}}
}

func (_this KmsEcdhStaticConfigurations) Is_KmsPublicKeyDiscovery() bool {
	_, ok := _this.Get_().(KmsEcdhStaticConfigurations_KmsPublicKeyDiscovery)
	return ok
}

type KmsEcdhStaticConfigurations_KmsPrivateKeyToStaticPublicKey struct {
	KmsPrivateKeyToStaticPublicKey KmsPrivateKeyToStaticPublicKeyInput
}

func (KmsEcdhStaticConfigurations_KmsPrivateKeyToStaticPublicKey) isKmsEcdhStaticConfigurations() {}

func (CompanionStruct_KmsEcdhStaticConfigurations_) Create_KmsPrivateKeyToStaticPublicKey_(KmsPrivateKeyToStaticPublicKey KmsPrivateKeyToStaticPublicKeyInput) KmsEcdhStaticConfigurations {
	return KmsEcdhStaticConfigurations{KmsEcdhStaticConfigurations_KmsPrivateKeyToStaticPublicKey{KmsPrivateKeyToStaticPublicKey}}
}

func (_this KmsEcdhStaticConfigurations) Is_KmsPrivateKeyToStaticPublicKey() bool {
	_, ok := _this.Get_().(KmsEcdhStaticConfigurations_KmsPrivateKeyToStaticPublicKey)
	return ok
}

func (CompanionStruct_KmsEcdhStaticConfigurations_) Default() KmsEcdhStaticConfigurations {
	return Companion_KmsEcdhStaticConfigurations_.Create_KmsPublicKeyDiscovery_(Companion_KmsPublicKeyDiscoveryInput_.Default())
}

func (_this KmsEcdhStaticConfigurations) Dtor_KmsPublicKeyDiscovery() KmsPublicKeyDiscoveryInput {
	return _this.Get_().(KmsEcdhStaticConfigurations_KmsPublicKeyDiscovery).KmsPublicKeyDiscovery
}

func (_this KmsEcdhStaticConfigurations) Dtor_KmsPrivateKeyToStaticPublicKey() KmsPrivateKeyToStaticPublicKeyInput {
	return _this.Get_().(KmsEcdhStaticConfigurations_KmsPrivateKeyToStaticPublicKey).KmsPrivateKeyToStaticPublicKey
}

func (_this KmsEcdhStaticConfigurations) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case KmsEcdhStaticConfigurations_KmsPublicKeyDiscovery:
		{
			return "AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations.KmsPublicKeyDiscovery" + "(" + _dafny.String(data.KmsPublicKeyDiscovery) + ")"
		}
	case KmsEcdhStaticConfigurations_KmsPrivateKeyToStaticPublicKey:
		{
			return "AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations.KmsPrivateKeyToStaticPublicKey" + "(" + _dafny.String(data.KmsPrivateKeyToStaticPublicKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KmsEcdhStaticConfigurations) Equals(other KmsEcdhStaticConfigurations) bool {
	switch data1 := _this.Get_().(type) {
	case KmsEcdhStaticConfigurations_KmsPublicKeyDiscovery:
		{
			data2, ok := other.Get_().(KmsEcdhStaticConfigurations_KmsPublicKeyDiscovery)
			return ok && data1.KmsPublicKeyDiscovery.Equals(data2.KmsPublicKeyDiscovery)
		}
	case KmsEcdhStaticConfigurations_KmsPrivateKeyToStaticPublicKey:
		{
			data2, ok := other.Get_().(KmsEcdhStaticConfigurations_KmsPrivateKeyToStaticPublicKey)
			return ok && data1.KmsPrivateKeyToStaticPublicKey.Equals(data2.KmsPrivateKeyToStaticPublicKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KmsEcdhStaticConfigurations) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KmsEcdhStaticConfigurations)
	return ok && _this.Equals(typed)
}

func Type_KmsEcdhStaticConfigurations_() _dafny.TypeDescriptor {
	return type_KmsEcdhStaticConfigurations_{}
}

type type_KmsEcdhStaticConfigurations_ struct {
}

func (_this type_KmsEcdhStaticConfigurations_) Default() interface{} {
	return Companion_KmsEcdhStaticConfigurations_.Default()
}

func (_this type_KmsEcdhStaticConfigurations_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations"
}
func (_this KmsEcdhStaticConfigurations) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KmsEcdhStaticConfigurations{}

// End of datatype KmsEcdhStaticConfigurations

// Definition of datatype KmsPrivateKeyToStaticPublicKeyInput
type KmsPrivateKeyToStaticPublicKeyInput struct {
	Data_KmsPrivateKeyToStaticPublicKeyInput_
}

func (_this KmsPrivateKeyToStaticPublicKeyInput) Get_() Data_KmsPrivateKeyToStaticPublicKeyInput_ {
	return _this.Data_KmsPrivateKeyToStaticPublicKeyInput_
}

type Data_KmsPrivateKeyToStaticPublicKeyInput_ interface {
	isKmsPrivateKeyToStaticPublicKeyInput()
}

type CompanionStruct_KmsPrivateKeyToStaticPublicKeyInput_ struct {
}

var Companion_KmsPrivateKeyToStaticPublicKeyInput_ = CompanionStruct_KmsPrivateKeyToStaticPublicKeyInput_{}

type KmsPrivateKeyToStaticPublicKeyInput_KmsPrivateKeyToStaticPublicKeyInput struct {
	SenderKmsIdentifier _dafny.Sequence
	SenderPublicKey     m_Wrappers.Option
	RecipientPublicKey  _dafny.Sequence
}

func (KmsPrivateKeyToStaticPublicKeyInput_KmsPrivateKeyToStaticPublicKeyInput) isKmsPrivateKeyToStaticPublicKeyInput() {
}

func (CompanionStruct_KmsPrivateKeyToStaticPublicKeyInput_) Create_KmsPrivateKeyToStaticPublicKeyInput_(SenderKmsIdentifier _dafny.Sequence, SenderPublicKey m_Wrappers.Option, RecipientPublicKey _dafny.Sequence) KmsPrivateKeyToStaticPublicKeyInput {
	return KmsPrivateKeyToStaticPublicKeyInput{KmsPrivateKeyToStaticPublicKeyInput_KmsPrivateKeyToStaticPublicKeyInput{SenderKmsIdentifier, SenderPublicKey, RecipientPublicKey}}
}

func (_this KmsPrivateKeyToStaticPublicKeyInput) Is_KmsPrivateKeyToStaticPublicKeyInput() bool {
	_, ok := _this.Get_().(KmsPrivateKeyToStaticPublicKeyInput_KmsPrivateKeyToStaticPublicKeyInput)
	return ok
}

func (CompanionStruct_KmsPrivateKeyToStaticPublicKeyInput_) Default() KmsPrivateKeyToStaticPublicKeyInput {
	return Companion_KmsPrivateKeyToStaticPublicKeyInput_.Create_KmsPrivateKeyToStaticPublicKeyInput_(_dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), _dafny.EmptySeq)
}

func (_this KmsPrivateKeyToStaticPublicKeyInput) Dtor_senderKmsIdentifier() _dafny.Sequence {
	return _this.Get_().(KmsPrivateKeyToStaticPublicKeyInput_KmsPrivateKeyToStaticPublicKeyInput).SenderKmsIdentifier
}

func (_this KmsPrivateKeyToStaticPublicKeyInput) Dtor_senderPublicKey() m_Wrappers.Option {
	return _this.Get_().(KmsPrivateKeyToStaticPublicKeyInput_KmsPrivateKeyToStaticPublicKeyInput).SenderPublicKey
}

func (_this KmsPrivateKeyToStaticPublicKeyInput) Dtor_recipientPublicKey() _dafny.Sequence {
	return _this.Get_().(KmsPrivateKeyToStaticPublicKeyInput_KmsPrivateKeyToStaticPublicKeyInput).RecipientPublicKey
}

func (_this KmsPrivateKeyToStaticPublicKeyInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case KmsPrivateKeyToStaticPublicKeyInput_KmsPrivateKeyToStaticPublicKeyInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.KmsPrivateKeyToStaticPublicKeyInput.KmsPrivateKeyToStaticPublicKeyInput" + "(" + _dafny.String(data.SenderKmsIdentifier) + ", " + _dafny.String(data.SenderPublicKey) + ", " + _dafny.String(data.RecipientPublicKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KmsPrivateKeyToStaticPublicKeyInput) Equals(other KmsPrivateKeyToStaticPublicKeyInput) bool {
	switch data1 := _this.Get_().(type) {
	case KmsPrivateKeyToStaticPublicKeyInput_KmsPrivateKeyToStaticPublicKeyInput:
		{
			data2, ok := other.Get_().(KmsPrivateKeyToStaticPublicKeyInput_KmsPrivateKeyToStaticPublicKeyInput)
			return ok && data1.SenderKmsIdentifier.Equals(data2.SenderKmsIdentifier) && data1.SenderPublicKey.Equals(data2.SenderPublicKey) && data1.RecipientPublicKey.Equals(data2.RecipientPublicKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KmsPrivateKeyToStaticPublicKeyInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KmsPrivateKeyToStaticPublicKeyInput)
	return ok && _this.Equals(typed)
}

func Type_KmsPrivateKeyToStaticPublicKeyInput_() _dafny.TypeDescriptor {
	return type_KmsPrivateKeyToStaticPublicKeyInput_{}
}

type type_KmsPrivateKeyToStaticPublicKeyInput_ struct {
}

func (_this type_KmsPrivateKeyToStaticPublicKeyInput_) Default() interface{} {
	return Companion_KmsPrivateKeyToStaticPublicKeyInput_.Default()
}

func (_this type_KmsPrivateKeyToStaticPublicKeyInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.KmsPrivateKeyToStaticPublicKeyInput"
}
func (_this KmsPrivateKeyToStaticPublicKeyInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KmsPrivateKeyToStaticPublicKeyInput{}

// End of datatype KmsPrivateKeyToStaticPublicKeyInput

// Definition of datatype KmsPublicKeyDiscoveryInput
type KmsPublicKeyDiscoveryInput struct {
	Data_KmsPublicKeyDiscoveryInput_
}

func (_this KmsPublicKeyDiscoveryInput) Get_() Data_KmsPublicKeyDiscoveryInput_ {
	return _this.Data_KmsPublicKeyDiscoveryInput_
}

type Data_KmsPublicKeyDiscoveryInput_ interface {
	isKmsPublicKeyDiscoveryInput()
}

type CompanionStruct_KmsPublicKeyDiscoveryInput_ struct {
}

var Companion_KmsPublicKeyDiscoveryInput_ = CompanionStruct_KmsPublicKeyDiscoveryInput_{}

type KmsPublicKeyDiscoveryInput_KmsPublicKeyDiscoveryInput struct {
	RecipientKmsIdentifier _dafny.Sequence
}

func (KmsPublicKeyDiscoveryInput_KmsPublicKeyDiscoveryInput) isKmsPublicKeyDiscoveryInput() {}

func (CompanionStruct_KmsPublicKeyDiscoveryInput_) Create_KmsPublicKeyDiscoveryInput_(RecipientKmsIdentifier _dafny.Sequence) KmsPublicKeyDiscoveryInput {
	return KmsPublicKeyDiscoveryInput{KmsPublicKeyDiscoveryInput_KmsPublicKeyDiscoveryInput{RecipientKmsIdentifier}}
}

func (_this KmsPublicKeyDiscoveryInput) Is_KmsPublicKeyDiscoveryInput() bool {
	_, ok := _this.Get_().(KmsPublicKeyDiscoveryInput_KmsPublicKeyDiscoveryInput)
	return ok
}

func (CompanionStruct_KmsPublicKeyDiscoveryInput_) Default() KmsPublicKeyDiscoveryInput {
	return Companion_KmsPublicKeyDiscoveryInput_.Create_KmsPublicKeyDiscoveryInput_(_dafny.EmptySeq.SetString())
}

func (_this KmsPublicKeyDiscoveryInput) Dtor_recipientKmsIdentifier() _dafny.Sequence {
	return _this.Get_().(KmsPublicKeyDiscoveryInput_KmsPublicKeyDiscoveryInput).RecipientKmsIdentifier
}

func (_this KmsPublicKeyDiscoveryInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case KmsPublicKeyDiscoveryInput_KmsPublicKeyDiscoveryInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.KmsPublicKeyDiscoveryInput.KmsPublicKeyDiscoveryInput" + "(" + _dafny.String(data.RecipientKmsIdentifier) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KmsPublicKeyDiscoveryInput) Equals(other KmsPublicKeyDiscoveryInput) bool {
	switch data1 := _this.Get_().(type) {
	case KmsPublicKeyDiscoveryInput_KmsPublicKeyDiscoveryInput:
		{
			data2, ok := other.Get_().(KmsPublicKeyDiscoveryInput_KmsPublicKeyDiscoveryInput)
			return ok && data1.RecipientKmsIdentifier.Equals(data2.RecipientKmsIdentifier)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KmsPublicKeyDiscoveryInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KmsPublicKeyDiscoveryInput)
	return ok && _this.Equals(typed)
}

func Type_KmsPublicKeyDiscoveryInput_() _dafny.TypeDescriptor {
	return type_KmsPublicKeyDiscoveryInput_{}
}

type type_KmsPublicKeyDiscoveryInput_ struct {
}

func (_this type_KmsPublicKeyDiscoveryInput_) Default() interface{} {
	return Companion_KmsPublicKeyDiscoveryInput_.Default()
}

func (_this type_KmsPublicKeyDiscoveryInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.KmsPublicKeyDiscoveryInput"
}
func (_this KmsPublicKeyDiscoveryInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KmsPublicKeyDiscoveryInput{}

// End of datatype KmsPublicKeyDiscoveryInput

// Definition of datatype MaterialProvidersConfig
type MaterialProvidersConfig struct {
	Data_MaterialProvidersConfig_
}

func (_this MaterialProvidersConfig) Get_() Data_MaterialProvidersConfig_ {
	return _this.Data_MaterialProvidersConfig_
}

type Data_MaterialProvidersConfig_ interface {
	isMaterialProvidersConfig()
}

type CompanionStruct_MaterialProvidersConfig_ struct {
}

var Companion_MaterialProvidersConfig_ = CompanionStruct_MaterialProvidersConfig_{}

type MaterialProvidersConfig_MaterialProvidersConfig struct {
}

func (MaterialProvidersConfig_MaterialProvidersConfig) isMaterialProvidersConfig() {}

func (CompanionStruct_MaterialProvidersConfig_) Create_MaterialProvidersConfig_() MaterialProvidersConfig {
	return MaterialProvidersConfig{MaterialProvidersConfig_MaterialProvidersConfig{}}
}

func (_this MaterialProvidersConfig) Is_MaterialProvidersConfig() bool {
	_, ok := _this.Get_().(MaterialProvidersConfig_MaterialProvidersConfig)
	return ok
}

func (CompanionStruct_MaterialProvidersConfig_) Default() MaterialProvidersConfig {
	return Companion_MaterialProvidersConfig_.Create_MaterialProvidersConfig_()
}

func (_ CompanionStruct_MaterialProvidersConfig_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_MaterialProvidersConfig_.Create_MaterialProvidersConfig_(), true
		default:
			return MaterialProvidersConfig{}, false
		}
	}
}

func (_this MaterialProvidersConfig) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case MaterialProvidersConfig_MaterialProvidersConfig:
		{
			return "AwsCryptographyMaterialProvidersTypes.MaterialProvidersConfig.MaterialProvidersConfig"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this MaterialProvidersConfig) Equals(other MaterialProvidersConfig) bool {
	switch _this.Get_().(type) {
	case MaterialProvidersConfig_MaterialProvidersConfig:
		{
			_, ok := other.Get_().(MaterialProvidersConfig_MaterialProvidersConfig)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this MaterialProvidersConfig) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(MaterialProvidersConfig)
	return ok && _this.Equals(typed)
}

func Type_MaterialProvidersConfig_() _dafny.TypeDescriptor {
	return type_MaterialProvidersConfig_{}
}

type type_MaterialProvidersConfig_ struct {
}

func (_this type_MaterialProvidersConfig_) Default() interface{} {
	return Companion_MaterialProvidersConfig_.Default()
}

func (_this type_MaterialProvidersConfig_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.MaterialProvidersConfig"
}
func (_this MaterialProvidersConfig) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = MaterialProvidersConfig{}

// End of datatype MaterialProvidersConfig

// Definition of datatype Materials
type Materials struct {
	Data_Materials_
}

func (_this Materials) Get_() Data_Materials_ {
	return _this.Data_Materials_
}

type Data_Materials_ interface {
	isMaterials()
}

type CompanionStruct_Materials_ struct {
}

var Companion_Materials_ = CompanionStruct_Materials_{}

type Materials_Encryption struct {
	Encryption EncryptionMaterials
}

func (Materials_Encryption) isMaterials() {}

func (CompanionStruct_Materials_) Create_Encryption_(Encryption EncryptionMaterials) Materials {
	return Materials{Materials_Encryption{Encryption}}
}

func (_this Materials) Is_Encryption() bool {
	_, ok := _this.Get_().(Materials_Encryption)
	return ok
}

type Materials_Decryption struct {
	Decryption DecryptionMaterials
}

func (Materials_Decryption) isMaterials() {}

func (CompanionStruct_Materials_) Create_Decryption_(Decryption DecryptionMaterials) Materials {
	return Materials{Materials_Decryption{Decryption}}
}

func (_this Materials) Is_Decryption() bool {
	_, ok := _this.Get_().(Materials_Decryption)
	return ok
}

type Materials_BranchKey struct {
	BranchKey m_AwsCryptographyKeyStoreTypes.BranchKeyMaterials
}

func (Materials_BranchKey) isMaterials() {}

func (CompanionStruct_Materials_) Create_BranchKey_(BranchKey m_AwsCryptographyKeyStoreTypes.BranchKeyMaterials) Materials {
	return Materials{Materials_BranchKey{BranchKey}}
}

func (_this Materials) Is_BranchKey() bool {
	_, ok := _this.Get_().(Materials_BranchKey)
	return ok
}

type Materials_BeaconKey struct {
	BeaconKey m_AwsCryptographyKeyStoreTypes.BeaconKeyMaterials
}

func (Materials_BeaconKey) isMaterials() {}

func (CompanionStruct_Materials_) Create_BeaconKey_(BeaconKey m_AwsCryptographyKeyStoreTypes.BeaconKeyMaterials) Materials {
	return Materials{Materials_BeaconKey{BeaconKey}}
}

func (_this Materials) Is_BeaconKey() bool {
	_, ok := _this.Get_().(Materials_BeaconKey)
	return ok
}

func (CompanionStruct_Materials_) Default() Materials {
	return Companion_Materials_.Create_Encryption_(Companion_EncryptionMaterials_.Default())
}

func (_this Materials) Dtor_Encryption() EncryptionMaterials {
	return _this.Get_().(Materials_Encryption).Encryption
}

func (_this Materials) Dtor_Decryption() DecryptionMaterials {
	return _this.Get_().(Materials_Decryption).Decryption
}

func (_this Materials) Dtor_BranchKey() m_AwsCryptographyKeyStoreTypes.BranchKeyMaterials {
	return _this.Get_().(Materials_BranchKey).BranchKey
}

func (_this Materials) Dtor_BeaconKey() m_AwsCryptographyKeyStoreTypes.BeaconKeyMaterials {
	return _this.Get_().(Materials_BeaconKey).BeaconKey
}

func (_this Materials) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Materials_Encryption:
		{
			return "AwsCryptographyMaterialProvidersTypes.Materials.Encryption" + "(" + _dafny.String(data.Encryption) + ")"
		}
	case Materials_Decryption:
		{
			return "AwsCryptographyMaterialProvidersTypes.Materials.Decryption" + "(" + _dafny.String(data.Decryption) + ")"
		}
	case Materials_BranchKey:
		{
			return "AwsCryptographyMaterialProvidersTypes.Materials.BranchKey" + "(" + _dafny.String(data.BranchKey) + ")"
		}
	case Materials_BeaconKey:
		{
			return "AwsCryptographyMaterialProvidersTypes.Materials.BeaconKey" + "(" + _dafny.String(data.BeaconKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Materials) Equals(other Materials) bool {
	switch data1 := _this.Get_().(type) {
	case Materials_Encryption:
		{
			data2, ok := other.Get_().(Materials_Encryption)
			return ok && data1.Encryption.Equals(data2.Encryption)
		}
	case Materials_Decryption:
		{
			data2, ok := other.Get_().(Materials_Decryption)
			return ok && data1.Decryption.Equals(data2.Decryption)
		}
	case Materials_BranchKey:
		{
			data2, ok := other.Get_().(Materials_BranchKey)
			return ok && data1.BranchKey.Equals(data2.BranchKey)
		}
	case Materials_BeaconKey:
		{
			data2, ok := other.Get_().(Materials_BeaconKey)
			return ok && data1.BeaconKey.Equals(data2.BeaconKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Materials) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Materials)
	return ok && _this.Equals(typed)
}

func Type_Materials_() _dafny.TypeDescriptor {
	return type_Materials_{}
}

type type_Materials_ struct {
}

func (_this type_Materials_) Default() interface{} {
	return Companion_Materials_.Default()
}

func (_this type_Materials_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.Materials"
}
func (_this Materials) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Materials{}

// End of datatype Materials

// Definition of datatype MultiThreadedCache
type MultiThreadedCache struct {
	Data_MultiThreadedCache_
}

func (_this MultiThreadedCache) Get_() Data_MultiThreadedCache_ {
	return _this.Data_MultiThreadedCache_
}

type Data_MultiThreadedCache_ interface {
	isMultiThreadedCache()
}

type CompanionStruct_MultiThreadedCache_ struct {
}

var Companion_MultiThreadedCache_ = CompanionStruct_MultiThreadedCache_{}

type MultiThreadedCache_MultiThreadedCache struct {
	EntryCapacity        int32
	EntryPruningTailSize m_Wrappers.Option
}

func (MultiThreadedCache_MultiThreadedCache) isMultiThreadedCache() {}

func (CompanionStruct_MultiThreadedCache_) Create_MultiThreadedCache_(EntryCapacity int32, EntryPruningTailSize m_Wrappers.Option) MultiThreadedCache {
	return MultiThreadedCache{MultiThreadedCache_MultiThreadedCache{EntryCapacity, EntryPruningTailSize}}
}

func (_this MultiThreadedCache) Is_MultiThreadedCache() bool {
	_, ok := _this.Get_().(MultiThreadedCache_MultiThreadedCache)
	return ok
}

func (CompanionStruct_MultiThreadedCache_) Default() MultiThreadedCache {
	return Companion_MultiThreadedCache_.Create_MultiThreadedCache_(int32(0), m_Wrappers.Companion_Option_.Default())
}

func (_this MultiThreadedCache) Dtor_entryCapacity() int32 {
	return _this.Get_().(MultiThreadedCache_MultiThreadedCache).EntryCapacity
}

func (_this MultiThreadedCache) Dtor_entryPruningTailSize() m_Wrappers.Option {
	return _this.Get_().(MultiThreadedCache_MultiThreadedCache).EntryPruningTailSize
}

func (_this MultiThreadedCache) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case MultiThreadedCache_MultiThreadedCache:
		{
			return "AwsCryptographyMaterialProvidersTypes.MultiThreadedCache.MultiThreadedCache" + "(" + _dafny.String(data.EntryCapacity) + ", " + _dafny.String(data.EntryPruningTailSize) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this MultiThreadedCache) Equals(other MultiThreadedCache) bool {
	switch data1 := _this.Get_().(type) {
	case MultiThreadedCache_MultiThreadedCache:
		{
			data2, ok := other.Get_().(MultiThreadedCache_MultiThreadedCache)
			return ok && data1.EntryCapacity == data2.EntryCapacity && data1.EntryPruningTailSize.Equals(data2.EntryPruningTailSize)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this MultiThreadedCache) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(MultiThreadedCache)
	return ok && _this.Equals(typed)
}

func Type_MultiThreadedCache_() _dafny.TypeDescriptor {
	return type_MultiThreadedCache_{}
}

type type_MultiThreadedCache_ struct {
}

func (_this type_MultiThreadedCache_) Default() interface{} {
	return Companion_MultiThreadedCache_.Default()
}

func (_this type_MultiThreadedCache_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.MultiThreadedCache"
}
func (_this MultiThreadedCache) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = MultiThreadedCache{}

// End of datatype MultiThreadedCache

// Definition of datatype NoCache
type NoCache struct {
	Data_NoCache_
}

func (_this NoCache) Get_() Data_NoCache_ {
	return _this.Data_NoCache_
}

type Data_NoCache_ interface {
	isNoCache()
}

type CompanionStruct_NoCache_ struct {
}

var Companion_NoCache_ = CompanionStruct_NoCache_{}

type NoCache_NoCache struct {
}

func (NoCache_NoCache) isNoCache() {}

func (CompanionStruct_NoCache_) Create_NoCache_() NoCache {
	return NoCache{NoCache_NoCache{}}
}

func (_this NoCache) Is_NoCache() bool {
	_, ok := _this.Get_().(NoCache_NoCache)
	return ok
}

func (CompanionStruct_NoCache_) Default() NoCache {
	return Companion_NoCache_.Create_NoCache_()
}

func (_ CompanionStruct_NoCache_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_NoCache_.Create_NoCache_(), true
		default:
			return NoCache{}, false
		}
	}
}

func (_this NoCache) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case NoCache_NoCache:
		{
			return "AwsCryptographyMaterialProvidersTypes.NoCache.NoCache"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this NoCache) Equals(other NoCache) bool {
	switch _this.Get_().(type) {
	case NoCache_NoCache:
		{
			_, ok := other.Get_().(NoCache_NoCache)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this NoCache) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(NoCache)
	return ok && _this.Equals(typed)
}

func Type_NoCache_() _dafny.TypeDescriptor {
	return type_NoCache_{}
}

type type_NoCache_ struct {
}

func (_this type_NoCache_) Default() interface{} {
	return Companion_NoCache_.Default()
}

func (_this type_NoCache_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.NoCache"
}
func (_this NoCache) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = NoCache{}

// End of datatype NoCache

// Definition of datatype None
type None struct {
	Data_None_
}

func (_this None) Get_() Data_None_ {
	return _this.Data_None_
}

type Data_None_ interface {
	isNone()
}

type CompanionStruct_None_ struct {
}

var Companion_None_ = CompanionStruct_None_{}

type None_None struct {
}

func (None_None) isNone() {}

func (CompanionStruct_None_) Create_None_() None {
	return None{None_None{}}
}

func (_this None) Is_None() bool {
	_, ok := _this.Get_().(None_None)
	return ok
}

func (CompanionStruct_None_) Default() None {
	return Companion_None_.Create_None_()
}

func (_ CompanionStruct_None_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_None_.Create_None_(), true
		default:
			return None{}, false
		}
	}
}

func (_this None) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case None_None:
		{
			return "AwsCryptographyMaterialProvidersTypes.None.None"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this None) Equals(other None) bool {
	switch _this.Get_().(type) {
	case None_None:
		{
			_, ok := other.Get_().(None_None)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this None) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(None)
	return ok && _this.Equals(typed)
}

func Type_None_() _dafny.TypeDescriptor {
	return type_None_{}
}

type type_None_ struct {
}

func (_this type_None_) Default() interface{} {
	return Companion_None_.Default()
}

func (_this type_None_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.None"
}
func (_this None) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = None{}

// End of datatype None

// Definition of datatype OnDecryptInput
type OnDecryptInput struct {
	Data_OnDecryptInput_
}

func (_this OnDecryptInput) Get_() Data_OnDecryptInput_ {
	return _this.Data_OnDecryptInput_
}

type Data_OnDecryptInput_ interface {
	isOnDecryptInput()
}

type CompanionStruct_OnDecryptInput_ struct {
}

var Companion_OnDecryptInput_ = CompanionStruct_OnDecryptInput_{}

type OnDecryptInput_OnDecryptInput struct {
	Materials         DecryptionMaterials
	EncryptedDataKeys _dafny.Sequence
}

func (OnDecryptInput_OnDecryptInput) isOnDecryptInput() {}

func (CompanionStruct_OnDecryptInput_) Create_OnDecryptInput_(Materials DecryptionMaterials, EncryptedDataKeys _dafny.Sequence) OnDecryptInput {
	return OnDecryptInput{OnDecryptInput_OnDecryptInput{Materials, EncryptedDataKeys}}
}

func (_this OnDecryptInput) Is_OnDecryptInput() bool {
	_, ok := _this.Get_().(OnDecryptInput_OnDecryptInput)
	return ok
}

func (CompanionStruct_OnDecryptInput_) Default() OnDecryptInput {
	return Companion_OnDecryptInput_.Create_OnDecryptInput_(Companion_DecryptionMaterials_.Default(), _dafny.EmptySeq)
}

func (_this OnDecryptInput) Dtor_materials() DecryptionMaterials {
	return _this.Get_().(OnDecryptInput_OnDecryptInput).Materials
}

func (_this OnDecryptInput) Dtor_encryptedDataKeys() _dafny.Sequence {
	return _this.Get_().(OnDecryptInput_OnDecryptInput).EncryptedDataKeys
}

func (_this OnDecryptInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case OnDecryptInput_OnDecryptInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.OnDecryptInput.OnDecryptInput" + "(" + _dafny.String(data.Materials) + ", " + _dafny.String(data.EncryptedDataKeys) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this OnDecryptInput) Equals(other OnDecryptInput) bool {
	switch data1 := _this.Get_().(type) {
	case OnDecryptInput_OnDecryptInput:
		{
			data2, ok := other.Get_().(OnDecryptInput_OnDecryptInput)
			return ok && data1.Materials.Equals(data2.Materials) && data1.EncryptedDataKeys.Equals(data2.EncryptedDataKeys)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this OnDecryptInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(OnDecryptInput)
	return ok && _this.Equals(typed)
}

func Type_OnDecryptInput_() _dafny.TypeDescriptor {
	return type_OnDecryptInput_{}
}

type type_OnDecryptInput_ struct {
}

func (_this type_OnDecryptInput_) Default() interface{} {
	return Companion_OnDecryptInput_.Default()
}

func (_this type_OnDecryptInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.OnDecryptInput"
}
func (_this OnDecryptInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = OnDecryptInput{}

// End of datatype OnDecryptInput

// Definition of datatype OnDecryptOutput
type OnDecryptOutput struct {
	Data_OnDecryptOutput_
}

func (_this OnDecryptOutput) Get_() Data_OnDecryptOutput_ {
	return _this.Data_OnDecryptOutput_
}

type Data_OnDecryptOutput_ interface {
	isOnDecryptOutput()
}

type CompanionStruct_OnDecryptOutput_ struct {
}

var Companion_OnDecryptOutput_ = CompanionStruct_OnDecryptOutput_{}

type OnDecryptOutput_OnDecryptOutput struct {
	Materials DecryptionMaterials
}

func (OnDecryptOutput_OnDecryptOutput) isOnDecryptOutput() {}

func (CompanionStruct_OnDecryptOutput_) Create_OnDecryptOutput_(Materials DecryptionMaterials) OnDecryptOutput {
	return OnDecryptOutput{OnDecryptOutput_OnDecryptOutput{Materials}}
}

func (_this OnDecryptOutput) Is_OnDecryptOutput() bool {
	_, ok := _this.Get_().(OnDecryptOutput_OnDecryptOutput)
	return ok
}

func (CompanionStruct_OnDecryptOutput_) Default() OnDecryptOutput {
	return Companion_OnDecryptOutput_.Create_OnDecryptOutput_(Companion_DecryptionMaterials_.Default())
}

func (_this OnDecryptOutput) Dtor_materials() DecryptionMaterials {
	return _this.Get_().(OnDecryptOutput_OnDecryptOutput).Materials
}

func (_this OnDecryptOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case OnDecryptOutput_OnDecryptOutput:
		{
			return "AwsCryptographyMaterialProvidersTypes.OnDecryptOutput.OnDecryptOutput" + "(" + _dafny.String(data.Materials) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this OnDecryptOutput) Equals(other OnDecryptOutput) bool {
	switch data1 := _this.Get_().(type) {
	case OnDecryptOutput_OnDecryptOutput:
		{
			data2, ok := other.Get_().(OnDecryptOutput_OnDecryptOutput)
			return ok && data1.Materials.Equals(data2.Materials)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this OnDecryptOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(OnDecryptOutput)
	return ok && _this.Equals(typed)
}

func Type_OnDecryptOutput_() _dafny.TypeDescriptor {
	return type_OnDecryptOutput_{}
}

type type_OnDecryptOutput_ struct {
}

func (_this type_OnDecryptOutput_) Default() interface{} {
	return Companion_OnDecryptOutput_.Default()
}

func (_this type_OnDecryptOutput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.OnDecryptOutput"
}
func (_this OnDecryptOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = OnDecryptOutput{}

// End of datatype OnDecryptOutput

// Definition of datatype OnEncryptInput
type OnEncryptInput struct {
	Data_OnEncryptInput_
}

func (_this OnEncryptInput) Get_() Data_OnEncryptInput_ {
	return _this.Data_OnEncryptInput_
}

type Data_OnEncryptInput_ interface {
	isOnEncryptInput()
}

type CompanionStruct_OnEncryptInput_ struct {
}

var Companion_OnEncryptInput_ = CompanionStruct_OnEncryptInput_{}

type OnEncryptInput_OnEncryptInput struct {
	Materials EncryptionMaterials
}

func (OnEncryptInput_OnEncryptInput) isOnEncryptInput() {}

func (CompanionStruct_OnEncryptInput_) Create_OnEncryptInput_(Materials EncryptionMaterials) OnEncryptInput {
	return OnEncryptInput{OnEncryptInput_OnEncryptInput{Materials}}
}

func (_this OnEncryptInput) Is_OnEncryptInput() bool {
	_, ok := _this.Get_().(OnEncryptInput_OnEncryptInput)
	return ok
}

func (CompanionStruct_OnEncryptInput_) Default() OnEncryptInput {
	return Companion_OnEncryptInput_.Create_OnEncryptInput_(Companion_EncryptionMaterials_.Default())
}

func (_this OnEncryptInput) Dtor_materials() EncryptionMaterials {
	return _this.Get_().(OnEncryptInput_OnEncryptInput).Materials
}

func (_this OnEncryptInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case OnEncryptInput_OnEncryptInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.OnEncryptInput.OnEncryptInput" + "(" + _dafny.String(data.Materials) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this OnEncryptInput) Equals(other OnEncryptInput) bool {
	switch data1 := _this.Get_().(type) {
	case OnEncryptInput_OnEncryptInput:
		{
			data2, ok := other.Get_().(OnEncryptInput_OnEncryptInput)
			return ok && data1.Materials.Equals(data2.Materials)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this OnEncryptInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(OnEncryptInput)
	return ok && _this.Equals(typed)
}

func Type_OnEncryptInput_() _dafny.TypeDescriptor {
	return type_OnEncryptInput_{}
}

type type_OnEncryptInput_ struct {
}

func (_this type_OnEncryptInput_) Default() interface{} {
	return Companion_OnEncryptInput_.Default()
}

func (_this type_OnEncryptInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.OnEncryptInput"
}
func (_this OnEncryptInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = OnEncryptInput{}

// End of datatype OnEncryptInput

// Definition of datatype OnEncryptOutput
type OnEncryptOutput struct {
	Data_OnEncryptOutput_
}

func (_this OnEncryptOutput) Get_() Data_OnEncryptOutput_ {
	return _this.Data_OnEncryptOutput_
}

type Data_OnEncryptOutput_ interface {
	isOnEncryptOutput()
}

type CompanionStruct_OnEncryptOutput_ struct {
}

var Companion_OnEncryptOutput_ = CompanionStruct_OnEncryptOutput_{}

type OnEncryptOutput_OnEncryptOutput struct {
	Materials EncryptionMaterials
}

func (OnEncryptOutput_OnEncryptOutput) isOnEncryptOutput() {}

func (CompanionStruct_OnEncryptOutput_) Create_OnEncryptOutput_(Materials EncryptionMaterials) OnEncryptOutput {
	return OnEncryptOutput{OnEncryptOutput_OnEncryptOutput{Materials}}
}

func (_this OnEncryptOutput) Is_OnEncryptOutput() bool {
	_, ok := _this.Get_().(OnEncryptOutput_OnEncryptOutput)
	return ok
}

func (CompanionStruct_OnEncryptOutput_) Default() OnEncryptOutput {
	return Companion_OnEncryptOutput_.Create_OnEncryptOutput_(Companion_EncryptionMaterials_.Default())
}

func (_this OnEncryptOutput) Dtor_materials() EncryptionMaterials {
	return _this.Get_().(OnEncryptOutput_OnEncryptOutput).Materials
}

func (_this OnEncryptOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case OnEncryptOutput_OnEncryptOutput:
		{
			return "AwsCryptographyMaterialProvidersTypes.OnEncryptOutput.OnEncryptOutput" + "(" + _dafny.String(data.Materials) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this OnEncryptOutput) Equals(other OnEncryptOutput) bool {
	switch data1 := _this.Get_().(type) {
	case OnEncryptOutput_OnEncryptOutput:
		{
			data2, ok := other.Get_().(OnEncryptOutput_OnEncryptOutput)
			return ok && data1.Materials.Equals(data2.Materials)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this OnEncryptOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(OnEncryptOutput)
	return ok && _this.Equals(typed)
}

func Type_OnEncryptOutput_() _dafny.TypeDescriptor {
	return type_OnEncryptOutput_{}
}

type type_OnEncryptOutput_ struct {
}

func (_this type_OnEncryptOutput_) Default() interface{} {
	return Companion_OnEncryptOutput_.Default()
}

func (_this type_OnEncryptOutput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.OnEncryptOutput"
}
func (_this OnEncryptOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = OnEncryptOutput{}

// End of datatype OnEncryptOutput

// Definition of datatype PaddingScheme
type PaddingScheme struct {
	Data_PaddingScheme_
}

func (_this PaddingScheme) Get_() Data_PaddingScheme_ {
	return _this.Data_PaddingScheme_
}

type Data_PaddingScheme_ interface {
	isPaddingScheme()
}

type CompanionStruct_PaddingScheme_ struct {
}

var Companion_PaddingScheme_ = CompanionStruct_PaddingScheme_{}

type PaddingScheme_PKCS1 struct {
}

func (PaddingScheme_PKCS1) isPaddingScheme() {}

func (CompanionStruct_PaddingScheme_) Create_PKCS1_() PaddingScheme {
	return PaddingScheme{PaddingScheme_PKCS1{}}
}

func (_this PaddingScheme) Is_PKCS1() bool {
	_, ok := _this.Get_().(PaddingScheme_PKCS1)
	return ok
}

type PaddingScheme_OAEP__SHA1__MGF1 struct {
}

func (PaddingScheme_OAEP__SHA1__MGF1) isPaddingScheme() {}

func (CompanionStruct_PaddingScheme_) Create_OAEP__SHA1__MGF1_() PaddingScheme {
	return PaddingScheme{PaddingScheme_OAEP__SHA1__MGF1{}}
}

func (_this PaddingScheme) Is_OAEP__SHA1__MGF1() bool {
	_, ok := _this.Get_().(PaddingScheme_OAEP__SHA1__MGF1)
	return ok
}

type PaddingScheme_OAEP__SHA256__MGF1 struct {
}

func (PaddingScheme_OAEP__SHA256__MGF1) isPaddingScheme() {}

func (CompanionStruct_PaddingScheme_) Create_OAEP__SHA256__MGF1_() PaddingScheme {
	return PaddingScheme{PaddingScheme_OAEP__SHA256__MGF1{}}
}

func (_this PaddingScheme) Is_OAEP__SHA256__MGF1() bool {
	_, ok := _this.Get_().(PaddingScheme_OAEP__SHA256__MGF1)
	return ok
}

type PaddingScheme_OAEP__SHA384__MGF1 struct {
}

func (PaddingScheme_OAEP__SHA384__MGF1) isPaddingScheme() {}

func (CompanionStruct_PaddingScheme_) Create_OAEP__SHA384__MGF1_() PaddingScheme {
	return PaddingScheme{PaddingScheme_OAEP__SHA384__MGF1{}}
}

func (_this PaddingScheme) Is_OAEP__SHA384__MGF1() bool {
	_, ok := _this.Get_().(PaddingScheme_OAEP__SHA384__MGF1)
	return ok
}

type PaddingScheme_OAEP__SHA512__MGF1 struct {
}

func (PaddingScheme_OAEP__SHA512__MGF1) isPaddingScheme() {}

func (CompanionStruct_PaddingScheme_) Create_OAEP__SHA512__MGF1_() PaddingScheme {
	return PaddingScheme{PaddingScheme_OAEP__SHA512__MGF1{}}
}

func (_this PaddingScheme) Is_OAEP__SHA512__MGF1() bool {
	_, ok := _this.Get_().(PaddingScheme_OAEP__SHA512__MGF1)
	return ok
}

func (CompanionStruct_PaddingScheme_) Default() PaddingScheme {
	return Companion_PaddingScheme_.Create_PKCS1_()
}

func (_ CompanionStruct_PaddingScheme_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_PaddingScheme_.Create_PKCS1_(), true
		case 1:
			return Companion_PaddingScheme_.Create_OAEP__SHA1__MGF1_(), true
		case 2:
			return Companion_PaddingScheme_.Create_OAEP__SHA256__MGF1_(), true
		case 3:
			return Companion_PaddingScheme_.Create_OAEP__SHA384__MGF1_(), true
		case 4:
			return Companion_PaddingScheme_.Create_OAEP__SHA512__MGF1_(), true
		default:
			return PaddingScheme{}, false
		}
	}
}

func (_this PaddingScheme) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case PaddingScheme_PKCS1:
		{
			return "AwsCryptographyMaterialProvidersTypes.PaddingScheme.PKCS1"
		}
	case PaddingScheme_OAEP__SHA1__MGF1:
		{
			return "AwsCryptographyMaterialProvidersTypes.PaddingScheme.OAEP_SHA1_MGF1"
		}
	case PaddingScheme_OAEP__SHA256__MGF1:
		{
			return "AwsCryptographyMaterialProvidersTypes.PaddingScheme.OAEP_SHA256_MGF1"
		}
	case PaddingScheme_OAEP__SHA384__MGF1:
		{
			return "AwsCryptographyMaterialProvidersTypes.PaddingScheme.OAEP_SHA384_MGF1"
		}
	case PaddingScheme_OAEP__SHA512__MGF1:
		{
			return "AwsCryptographyMaterialProvidersTypes.PaddingScheme.OAEP_SHA512_MGF1"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this PaddingScheme) Equals(other PaddingScheme) bool {
	switch _this.Get_().(type) {
	case PaddingScheme_PKCS1:
		{
			_, ok := other.Get_().(PaddingScheme_PKCS1)
			return ok
		}
	case PaddingScheme_OAEP__SHA1__MGF1:
		{
			_, ok := other.Get_().(PaddingScheme_OAEP__SHA1__MGF1)
			return ok
		}
	case PaddingScheme_OAEP__SHA256__MGF1:
		{
			_, ok := other.Get_().(PaddingScheme_OAEP__SHA256__MGF1)
			return ok
		}
	case PaddingScheme_OAEP__SHA384__MGF1:
		{
			_, ok := other.Get_().(PaddingScheme_OAEP__SHA384__MGF1)
			return ok
		}
	case PaddingScheme_OAEP__SHA512__MGF1:
		{
			_, ok := other.Get_().(PaddingScheme_OAEP__SHA512__MGF1)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this PaddingScheme) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(PaddingScheme)
	return ok && _this.Equals(typed)
}

func Type_PaddingScheme_() _dafny.TypeDescriptor {
	return type_PaddingScheme_{}
}

type type_PaddingScheme_ struct {
}

func (_this type_PaddingScheme_) Default() interface{} {
	return Companion_PaddingScheme_.Default()
}

func (_this type_PaddingScheme_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.PaddingScheme"
}
func (_this PaddingScheme) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = PaddingScheme{}

// End of datatype PaddingScheme

// Definition of class PositiveInteger
type PositiveInteger struct {
}

func New_PositiveInteger_() *PositiveInteger {
	_this := PositiveInteger{}

	return &_this
}

type CompanionStruct_PositiveInteger_ struct {
}

var Companion_PositiveInteger_ = CompanionStruct_PositiveInteger_{}

func (*PositiveInteger) String() string {
	return "AwsCryptographyMaterialProvidersTypes.PositiveInteger"
}

// End of class PositiveInteger

func Type_PositiveInteger_() _dafny.TypeDescriptor {
	return type_PositiveInteger_{}
}

type type_PositiveInteger_ struct {
}

func (_this type_PositiveInteger_) Default() interface{} {
	return int32(0)
}

func (_this type_PositiveInteger_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.PositiveInteger"
}
func (_this *CompanionStruct_PositiveInteger_) Is_(__source int32) bool {
	var _0_x int32 = (__source)
	_ = _0_x
	if true {
		return Companion_Default___.IsValid__PositiveInteger(_0_x)
	}
	return false
}

// Definition of class PositiveLong
type PositiveLong struct {
}

func New_PositiveLong_() *PositiveLong {
	_this := PositiveLong{}

	return &_this
}

type CompanionStruct_PositiveLong_ struct {
}

var Companion_PositiveLong_ = CompanionStruct_PositiveLong_{}

func (*PositiveLong) String() string {
	return "AwsCryptographyMaterialProvidersTypes.PositiveLong"
}

// End of class PositiveLong

func Type_PositiveLong_() _dafny.TypeDescriptor {
	return type_PositiveLong_{}
}

type type_PositiveLong_ struct {
}

func (_this type_PositiveLong_) Default() interface{} {
	return int64(0)
}

func (_this type_PositiveLong_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.PositiveLong"
}
func (_this *CompanionStruct_PositiveLong_) Is_(__source int64) bool {
	var _1_x int64 = (__source)
	_ = _1_x
	if true {
		return Companion_Default___.IsValid__PositiveLong(_1_x)
	}
	return false
}

// Definition of datatype PublicKeyDiscoveryInput
type PublicKeyDiscoveryInput struct {
	Data_PublicKeyDiscoveryInput_
}

func (_this PublicKeyDiscoveryInput) Get_() Data_PublicKeyDiscoveryInput_ {
	return _this.Data_PublicKeyDiscoveryInput_
}

type Data_PublicKeyDiscoveryInput_ interface {
	isPublicKeyDiscoveryInput()
}

type CompanionStruct_PublicKeyDiscoveryInput_ struct {
}

var Companion_PublicKeyDiscoveryInput_ = CompanionStruct_PublicKeyDiscoveryInput_{}

type PublicKeyDiscoveryInput_PublicKeyDiscoveryInput struct {
	RecipientStaticPrivateKey _dafny.Sequence
}

func (PublicKeyDiscoveryInput_PublicKeyDiscoveryInput) isPublicKeyDiscoveryInput() {}

func (CompanionStruct_PublicKeyDiscoveryInput_) Create_PublicKeyDiscoveryInput_(RecipientStaticPrivateKey _dafny.Sequence) PublicKeyDiscoveryInput {
	return PublicKeyDiscoveryInput{PublicKeyDiscoveryInput_PublicKeyDiscoveryInput{RecipientStaticPrivateKey}}
}

func (_this PublicKeyDiscoveryInput) Is_PublicKeyDiscoveryInput() bool {
	_, ok := _this.Get_().(PublicKeyDiscoveryInput_PublicKeyDiscoveryInput)
	return ok
}

func (CompanionStruct_PublicKeyDiscoveryInput_) Default() PublicKeyDiscoveryInput {
	return Companion_PublicKeyDiscoveryInput_.Create_PublicKeyDiscoveryInput_(_dafny.EmptySeq)
}

func (_this PublicKeyDiscoveryInput) Dtor_recipientStaticPrivateKey() _dafny.Sequence {
	return _this.Get_().(PublicKeyDiscoveryInput_PublicKeyDiscoveryInput).RecipientStaticPrivateKey
}

func (_this PublicKeyDiscoveryInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case PublicKeyDiscoveryInput_PublicKeyDiscoveryInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.PublicKeyDiscoveryInput.PublicKeyDiscoveryInput" + "(" + _dafny.String(data.RecipientStaticPrivateKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this PublicKeyDiscoveryInput) Equals(other PublicKeyDiscoveryInput) bool {
	switch data1 := _this.Get_().(type) {
	case PublicKeyDiscoveryInput_PublicKeyDiscoveryInput:
		{
			data2, ok := other.Get_().(PublicKeyDiscoveryInput_PublicKeyDiscoveryInput)
			return ok && data1.RecipientStaticPrivateKey.Equals(data2.RecipientStaticPrivateKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this PublicKeyDiscoveryInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(PublicKeyDiscoveryInput)
	return ok && _this.Equals(typed)
}

func Type_PublicKeyDiscoveryInput_() _dafny.TypeDescriptor {
	return type_PublicKeyDiscoveryInput_{}
}

type type_PublicKeyDiscoveryInput_ struct {
}

func (_this type_PublicKeyDiscoveryInput_) Default() interface{} {
	return Companion_PublicKeyDiscoveryInput_.Default()
}

func (_this type_PublicKeyDiscoveryInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.PublicKeyDiscoveryInput"
}
func (_this PublicKeyDiscoveryInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = PublicKeyDiscoveryInput{}

// End of datatype PublicKeyDiscoveryInput

// Definition of datatype PutCacheEntryInput
type PutCacheEntryInput struct {
	Data_PutCacheEntryInput_
}

func (_this PutCacheEntryInput) Get_() Data_PutCacheEntryInput_ {
	return _this.Data_PutCacheEntryInput_
}

type Data_PutCacheEntryInput_ interface {
	isPutCacheEntryInput()
}

type CompanionStruct_PutCacheEntryInput_ struct {
}

var Companion_PutCacheEntryInput_ = CompanionStruct_PutCacheEntryInput_{}

type PutCacheEntryInput_PutCacheEntryInput struct {
	Identifier   _dafny.Sequence
	Materials    Materials
	CreationTime int64
	ExpiryTime   int64
	MessagesUsed m_Wrappers.Option
	BytesUsed    m_Wrappers.Option
}

func (PutCacheEntryInput_PutCacheEntryInput) isPutCacheEntryInput() {}

func (CompanionStruct_PutCacheEntryInput_) Create_PutCacheEntryInput_(Identifier _dafny.Sequence, Materials Materials, CreationTime int64, ExpiryTime int64, MessagesUsed m_Wrappers.Option, BytesUsed m_Wrappers.Option) PutCacheEntryInput {
	return PutCacheEntryInput{PutCacheEntryInput_PutCacheEntryInput{Identifier, Materials, CreationTime, ExpiryTime, MessagesUsed, BytesUsed}}
}

func (_this PutCacheEntryInput) Is_PutCacheEntryInput() bool {
	_, ok := _this.Get_().(PutCacheEntryInput_PutCacheEntryInput)
	return ok
}

func (CompanionStruct_PutCacheEntryInput_) Default() PutCacheEntryInput {
	return Companion_PutCacheEntryInput_.Create_PutCacheEntryInput_(_dafny.EmptySeq, Companion_Materials_.Default(), int64(0), int64(0), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this PutCacheEntryInput) Dtor_identifier() _dafny.Sequence {
	return _this.Get_().(PutCacheEntryInput_PutCacheEntryInput).Identifier
}

func (_this PutCacheEntryInput) Dtor_materials() Materials {
	return _this.Get_().(PutCacheEntryInput_PutCacheEntryInput).Materials
}

func (_this PutCacheEntryInput) Dtor_creationTime() int64 {
	return _this.Get_().(PutCacheEntryInput_PutCacheEntryInput).CreationTime
}

func (_this PutCacheEntryInput) Dtor_expiryTime() int64 {
	return _this.Get_().(PutCacheEntryInput_PutCacheEntryInput).ExpiryTime
}

func (_this PutCacheEntryInput) Dtor_messagesUsed() m_Wrappers.Option {
	return _this.Get_().(PutCacheEntryInput_PutCacheEntryInput).MessagesUsed
}

func (_this PutCacheEntryInput) Dtor_bytesUsed() m_Wrappers.Option {
	return _this.Get_().(PutCacheEntryInput_PutCacheEntryInput).BytesUsed
}

func (_this PutCacheEntryInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case PutCacheEntryInput_PutCacheEntryInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.PutCacheEntryInput.PutCacheEntryInput" + "(" + _dafny.String(data.Identifier) + ", " + _dafny.String(data.Materials) + ", " + _dafny.String(data.CreationTime) + ", " + _dafny.String(data.ExpiryTime) + ", " + _dafny.String(data.MessagesUsed) + ", " + _dafny.String(data.BytesUsed) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this PutCacheEntryInput) Equals(other PutCacheEntryInput) bool {
	switch data1 := _this.Get_().(type) {
	case PutCacheEntryInput_PutCacheEntryInput:
		{
			data2, ok := other.Get_().(PutCacheEntryInput_PutCacheEntryInput)
			return ok && data1.Identifier.Equals(data2.Identifier) && data1.Materials.Equals(data2.Materials) && data1.CreationTime == data2.CreationTime && data1.ExpiryTime == data2.ExpiryTime && data1.MessagesUsed.Equals(data2.MessagesUsed) && data1.BytesUsed.Equals(data2.BytesUsed)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this PutCacheEntryInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(PutCacheEntryInput)
	return ok && _this.Equals(typed)
}

func Type_PutCacheEntryInput_() _dafny.TypeDescriptor {
	return type_PutCacheEntryInput_{}
}

type type_PutCacheEntryInput_ struct {
}

func (_this type_PutCacheEntryInput_) Default() interface{} {
	return Companion_PutCacheEntryInput_.Default()
}

func (_this type_PutCacheEntryInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.PutCacheEntryInput"
}
func (_this PutCacheEntryInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = PutCacheEntryInput{}

// End of datatype PutCacheEntryInput

// Definition of datatype RawEcdhStaticConfigurations
type RawEcdhStaticConfigurations struct {
	Data_RawEcdhStaticConfigurations_
}

func (_this RawEcdhStaticConfigurations) Get_() Data_RawEcdhStaticConfigurations_ {
	return _this.Data_RawEcdhStaticConfigurations_
}

type Data_RawEcdhStaticConfigurations_ interface {
	isRawEcdhStaticConfigurations()
}

type CompanionStruct_RawEcdhStaticConfigurations_ struct {
}

var Companion_RawEcdhStaticConfigurations_ = CompanionStruct_RawEcdhStaticConfigurations_{}

type RawEcdhStaticConfigurations_PublicKeyDiscovery struct {
	PublicKeyDiscovery PublicKeyDiscoveryInput
}

func (RawEcdhStaticConfigurations_PublicKeyDiscovery) isRawEcdhStaticConfigurations() {}

func (CompanionStruct_RawEcdhStaticConfigurations_) Create_PublicKeyDiscovery_(PublicKeyDiscovery PublicKeyDiscoveryInput) RawEcdhStaticConfigurations {
	return RawEcdhStaticConfigurations{RawEcdhStaticConfigurations_PublicKeyDiscovery{PublicKeyDiscovery}}
}

func (_this RawEcdhStaticConfigurations) Is_PublicKeyDiscovery() bool {
	_, ok := _this.Get_().(RawEcdhStaticConfigurations_PublicKeyDiscovery)
	return ok
}

type RawEcdhStaticConfigurations_RawPrivateKeyToStaticPublicKey struct {
	RawPrivateKeyToStaticPublicKey RawPrivateKeyToStaticPublicKeyInput
}

func (RawEcdhStaticConfigurations_RawPrivateKeyToStaticPublicKey) isRawEcdhStaticConfigurations() {}

func (CompanionStruct_RawEcdhStaticConfigurations_) Create_RawPrivateKeyToStaticPublicKey_(RawPrivateKeyToStaticPublicKey RawPrivateKeyToStaticPublicKeyInput) RawEcdhStaticConfigurations {
	return RawEcdhStaticConfigurations{RawEcdhStaticConfigurations_RawPrivateKeyToStaticPublicKey{RawPrivateKeyToStaticPublicKey}}
}

func (_this RawEcdhStaticConfigurations) Is_RawPrivateKeyToStaticPublicKey() bool {
	_, ok := _this.Get_().(RawEcdhStaticConfigurations_RawPrivateKeyToStaticPublicKey)
	return ok
}

type RawEcdhStaticConfigurations_EphemeralPrivateKeyToStaticPublicKey struct {
	EphemeralPrivateKeyToStaticPublicKey EphemeralPrivateKeyToStaticPublicKeyInput
}

func (RawEcdhStaticConfigurations_EphemeralPrivateKeyToStaticPublicKey) isRawEcdhStaticConfigurations() {
}

func (CompanionStruct_RawEcdhStaticConfigurations_) Create_EphemeralPrivateKeyToStaticPublicKey_(EphemeralPrivateKeyToStaticPublicKey EphemeralPrivateKeyToStaticPublicKeyInput) RawEcdhStaticConfigurations {
	return RawEcdhStaticConfigurations{RawEcdhStaticConfigurations_EphemeralPrivateKeyToStaticPublicKey{EphemeralPrivateKeyToStaticPublicKey}}
}

func (_this RawEcdhStaticConfigurations) Is_EphemeralPrivateKeyToStaticPublicKey() bool {
	_, ok := _this.Get_().(RawEcdhStaticConfigurations_EphemeralPrivateKeyToStaticPublicKey)
	return ok
}

func (CompanionStruct_RawEcdhStaticConfigurations_) Default() RawEcdhStaticConfigurations {
	return Companion_RawEcdhStaticConfigurations_.Create_PublicKeyDiscovery_(Companion_PublicKeyDiscoveryInput_.Default())
}

func (_this RawEcdhStaticConfigurations) Dtor_PublicKeyDiscovery() PublicKeyDiscoveryInput {
	return _this.Get_().(RawEcdhStaticConfigurations_PublicKeyDiscovery).PublicKeyDiscovery
}

func (_this RawEcdhStaticConfigurations) Dtor_RawPrivateKeyToStaticPublicKey() RawPrivateKeyToStaticPublicKeyInput {
	return _this.Get_().(RawEcdhStaticConfigurations_RawPrivateKeyToStaticPublicKey).RawPrivateKeyToStaticPublicKey
}

func (_this RawEcdhStaticConfigurations) Dtor_EphemeralPrivateKeyToStaticPublicKey() EphemeralPrivateKeyToStaticPublicKeyInput {
	return _this.Get_().(RawEcdhStaticConfigurations_EphemeralPrivateKeyToStaticPublicKey).EphemeralPrivateKeyToStaticPublicKey
}

func (_this RawEcdhStaticConfigurations) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case RawEcdhStaticConfigurations_PublicKeyDiscovery:
		{
			return "AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations.PublicKeyDiscovery" + "(" + _dafny.String(data.PublicKeyDiscovery) + ")"
		}
	case RawEcdhStaticConfigurations_RawPrivateKeyToStaticPublicKey:
		{
			return "AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations.RawPrivateKeyToStaticPublicKey" + "(" + _dafny.String(data.RawPrivateKeyToStaticPublicKey) + ")"
		}
	case RawEcdhStaticConfigurations_EphemeralPrivateKeyToStaticPublicKey:
		{
			return "AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations.EphemeralPrivateKeyToStaticPublicKey" + "(" + _dafny.String(data.EphemeralPrivateKeyToStaticPublicKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RawEcdhStaticConfigurations) Equals(other RawEcdhStaticConfigurations) bool {
	switch data1 := _this.Get_().(type) {
	case RawEcdhStaticConfigurations_PublicKeyDiscovery:
		{
			data2, ok := other.Get_().(RawEcdhStaticConfigurations_PublicKeyDiscovery)
			return ok && data1.PublicKeyDiscovery.Equals(data2.PublicKeyDiscovery)
		}
	case RawEcdhStaticConfigurations_RawPrivateKeyToStaticPublicKey:
		{
			data2, ok := other.Get_().(RawEcdhStaticConfigurations_RawPrivateKeyToStaticPublicKey)
			return ok && data1.RawPrivateKeyToStaticPublicKey.Equals(data2.RawPrivateKeyToStaticPublicKey)
		}
	case RawEcdhStaticConfigurations_EphemeralPrivateKeyToStaticPublicKey:
		{
			data2, ok := other.Get_().(RawEcdhStaticConfigurations_EphemeralPrivateKeyToStaticPublicKey)
			return ok && data1.EphemeralPrivateKeyToStaticPublicKey.Equals(data2.EphemeralPrivateKeyToStaticPublicKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RawEcdhStaticConfigurations) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RawEcdhStaticConfigurations)
	return ok && _this.Equals(typed)
}

func Type_RawEcdhStaticConfigurations_() _dafny.TypeDescriptor {
	return type_RawEcdhStaticConfigurations_{}
}

type type_RawEcdhStaticConfigurations_ struct {
}

func (_this type_RawEcdhStaticConfigurations_) Default() interface{} {
	return Companion_RawEcdhStaticConfigurations_.Default()
}

func (_this type_RawEcdhStaticConfigurations_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations"
}
func (_this RawEcdhStaticConfigurations) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RawEcdhStaticConfigurations{}

// End of datatype RawEcdhStaticConfigurations

// Definition of datatype RawPrivateKeyToStaticPublicKeyInput
type RawPrivateKeyToStaticPublicKeyInput struct {
	Data_RawPrivateKeyToStaticPublicKeyInput_
}

func (_this RawPrivateKeyToStaticPublicKeyInput) Get_() Data_RawPrivateKeyToStaticPublicKeyInput_ {
	return _this.Data_RawPrivateKeyToStaticPublicKeyInput_
}

type Data_RawPrivateKeyToStaticPublicKeyInput_ interface {
	isRawPrivateKeyToStaticPublicKeyInput()
}

type CompanionStruct_RawPrivateKeyToStaticPublicKeyInput_ struct {
}

var Companion_RawPrivateKeyToStaticPublicKeyInput_ = CompanionStruct_RawPrivateKeyToStaticPublicKeyInput_{}

type RawPrivateKeyToStaticPublicKeyInput_RawPrivateKeyToStaticPublicKeyInput struct {
	SenderStaticPrivateKey _dafny.Sequence
	RecipientPublicKey     _dafny.Sequence
}

func (RawPrivateKeyToStaticPublicKeyInput_RawPrivateKeyToStaticPublicKeyInput) isRawPrivateKeyToStaticPublicKeyInput() {
}

func (CompanionStruct_RawPrivateKeyToStaticPublicKeyInput_) Create_RawPrivateKeyToStaticPublicKeyInput_(SenderStaticPrivateKey _dafny.Sequence, RecipientPublicKey _dafny.Sequence) RawPrivateKeyToStaticPublicKeyInput {
	return RawPrivateKeyToStaticPublicKeyInput{RawPrivateKeyToStaticPublicKeyInput_RawPrivateKeyToStaticPublicKeyInput{SenderStaticPrivateKey, RecipientPublicKey}}
}

func (_this RawPrivateKeyToStaticPublicKeyInput) Is_RawPrivateKeyToStaticPublicKeyInput() bool {
	_, ok := _this.Get_().(RawPrivateKeyToStaticPublicKeyInput_RawPrivateKeyToStaticPublicKeyInput)
	return ok
}

func (CompanionStruct_RawPrivateKeyToStaticPublicKeyInput_) Default() RawPrivateKeyToStaticPublicKeyInput {
	return Companion_RawPrivateKeyToStaticPublicKeyInput_.Create_RawPrivateKeyToStaticPublicKeyInput_(_dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this RawPrivateKeyToStaticPublicKeyInput) Dtor_senderStaticPrivateKey() _dafny.Sequence {
	return _this.Get_().(RawPrivateKeyToStaticPublicKeyInput_RawPrivateKeyToStaticPublicKeyInput).SenderStaticPrivateKey
}

func (_this RawPrivateKeyToStaticPublicKeyInput) Dtor_recipientPublicKey() _dafny.Sequence {
	return _this.Get_().(RawPrivateKeyToStaticPublicKeyInput_RawPrivateKeyToStaticPublicKeyInput).RecipientPublicKey
}

func (_this RawPrivateKeyToStaticPublicKeyInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case RawPrivateKeyToStaticPublicKeyInput_RawPrivateKeyToStaticPublicKeyInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.RawPrivateKeyToStaticPublicKeyInput.RawPrivateKeyToStaticPublicKeyInput" + "(" + _dafny.String(data.SenderStaticPrivateKey) + ", " + _dafny.String(data.RecipientPublicKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RawPrivateKeyToStaticPublicKeyInput) Equals(other RawPrivateKeyToStaticPublicKeyInput) bool {
	switch data1 := _this.Get_().(type) {
	case RawPrivateKeyToStaticPublicKeyInput_RawPrivateKeyToStaticPublicKeyInput:
		{
			data2, ok := other.Get_().(RawPrivateKeyToStaticPublicKeyInput_RawPrivateKeyToStaticPublicKeyInput)
			return ok && data1.SenderStaticPrivateKey.Equals(data2.SenderStaticPrivateKey) && data1.RecipientPublicKey.Equals(data2.RecipientPublicKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RawPrivateKeyToStaticPublicKeyInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RawPrivateKeyToStaticPublicKeyInput)
	return ok && _this.Equals(typed)
}

func Type_RawPrivateKeyToStaticPublicKeyInput_() _dafny.TypeDescriptor {
	return type_RawPrivateKeyToStaticPublicKeyInput_{}
}

type type_RawPrivateKeyToStaticPublicKeyInput_ struct {
}

func (_this type_RawPrivateKeyToStaticPublicKeyInput_) Default() interface{} {
	return Companion_RawPrivateKeyToStaticPublicKeyInput_.Default()
}

func (_this type_RawPrivateKeyToStaticPublicKeyInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.RawPrivateKeyToStaticPublicKeyInput"
}
func (_this RawPrivateKeyToStaticPublicKeyInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RawPrivateKeyToStaticPublicKeyInput{}

// End of datatype RawPrivateKeyToStaticPublicKeyInput

// Definition of datatype SignatureAlgorithm
type SignatureAlgorithm struct {
	Data_SignatureAlgorithm_
}

func (_this SignatureAlgorithm) Get_() Data_SignatureAlgorithm_ {
	return _this.Data_SignatureAlgorithm_
}

type Data_SignatureAlgorithm_ interface {
	isSignatureAlgorithm()
}

type CompanionStruct_SignatureAlgorithm_ struct {
}

var Companion_SignatureAlgorithm_ = CompanionStruct_SignatureAlgorithm_{}

type SignatureAlgorithm_ECDSA struct {
	ECDSA ECDSA
}

func (SignatureAlgorithm_ECDSA) isSignatureAlgorithm() {}

func (CompanionStruct_SignatureAlgorithm_) Create_ECDSA_(ECDSA ECDSA) SignatureAlgorithm {
	return SignatureAlgorithm{SignatureAlgorithm_ECDSA{ECDSA}}
}

func (_this SignatureAlgorithm) Is_ECDSA() bool {
	_, ok := _this.Get_().(SignatureAlgorithm_ECDSA)
	return ok
}

type SignatureAlgorithm_None struct {
	None None
}

func (SignatureAlgorithm_None) isSignatureAlgorithm() {}

func (CompanionStruct_SignatureAlgorithm_) Create_None_(None None) SignatureAlgorithm {
	return SignatureAlgorithm{SignatureAlgorithm_None{None}}
}

func (_this SignatureAlgorithm) Is_None() bool {
	_, ok := _this.Get_().(SignatureAlgorithm_None)
	return ok
}

func (CompanionStruct_SignatureAlgorithm_) Default() SignatureAlgorithm {
	return Companion_SignatureAlgorithm_.Create_ECDSA_(Companion_ECDSA_.Default())
}

func (_this SignatureAlgorithm) Dtor_ECDSA() ECDSA {
	return _this.Get_().(SignatureAlgorithm_ECDSA).ECDSA
}

func (_this SignatureAlgorithm) Dtor_None() None {
	return _this.Get_().(SignatureAlgorithm_None).None
}

func (_this SignatureAlgorithm) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case SignatureAlgorithm_ECDSA:
		{
			return "AwsCryptographyMaterialProvidersTypes.SignatureAlgorithm.ECDSA" + "(" + _dafny.String(data.ECDSA) + ")"
		}
	case SignatureAlgorithm_None:
		{
			return "AwsCryptographyMaterialProvidersTypes.SignatureAlgorithm.None" + "(" + _dafny.String(data.None) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this SignatureAlgorithm) Equals(other SignatureAlgorithm) bool {
	switch data1 := _this.Get_().(type) {
	case SignatureAlgorithm_ECDSA:
		{
			data2, ok := other.Get_().(SignatureAlgorithm_ECDSA)
			return ok && data1.ECDSA.Equals(data2.ECDSA)
		}
	case SignatureAlgorithm_None:
		{
			data2, ok := other.Get_().(SignatureAlgorithm_None)
			return ok && data1.None.Equals(data2.None)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this SignatureAlgorithm) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(SignatureAlgorithm)
	return ok && _this.Equals(typed)
}

func Type_SignatureAlgorithm_() _dafny.TypeDescriptor {
	return type_SignatureAlgorithm_{}
}

type type_SignatureAlgorithm_ struct {
}

func (_this type_SignatureAlgorithm_) Default() interface{} {
	return Companion_SignatureAlgorithm_.Default()
}

func (_this type_SignatureAlgorithm_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.SignatureAlgorithm"
}
func (_this SignatureAlgorithm) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = SignatureAlgorithm{}

// End of datatype SignatureAlgorithm

// Definition of datatype SingleThreadedCache
type SingleThreadedCache struct {
	Data_SingleThreadedCache_
}

func (_this SingleThreadedCache) Get_() Data_SingleThreadedCache_ {
	return _this.Data_SingleThreadedCache_
}

type Data_SingleThreadedCache_ interface {
	isSingleThreadedCache()
}

type CompanionStruct_SingleThreadedCache_ struct {
}

var Companion_SingleThreadedCache_ = CompanionStruct_SingleThreadedCache_{}

type SingleThreadedCache_SingleThreadedCache struct {
	EntryCapacity        int32
	EntryPruningTailSize m_Wrappers.Option
}

func (SingleThreadedCache_SingleThreadedCache) isSingleThreadedCache() {}

func (CompanionStruct_SingleThreadedCache_) Create_SingleThreadedCache_(EntryCapacity int32, EntryPruningTailSize m_Wrappers.Option) SingleThreadedCache {
	return SingleThreadedCache{SingleThreadedCache_SingleThreadedCache{EntryCapacity, EntryPruningTailSize}}
}

func (_this SingleThreadedCache) Is_SingleThreadedCache() bool {
	_, ok := _this.Get_().(SingleThreadedCache_SingleThreadedCache)
	return ok
}

func (CompanionStruct_SingleThreadedCache_) Default() SingleThreadedCache {
	return Companion_SingleThreadedCache_.Create_SingleThreadedCache_(int32(0), m_Wrappers.Companion_Option_.Default())
}

func (_this SingleThreadedCache) Dtor_entryCapacity() int32 {
	return _this.Get_().(SingleThreadedCache_SingleThreadedCache).EntryCapacity
}

func (_this SingleThreadedCache) Dtor_entryPruningTailSize() m_Wrappers.Option {
	return _this.Get_().(SingleThreadedCache_SingleThreadedCache).EntryPruningTailSize
}

func (_this SingleThreadedCache) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case SingleThreadedCache_SingleThreadedCache:
		{
			return "AwsCryptographyMaterialProvidersTypes.SingleThreadedCache.SingleThreadedCache" + "(" + _dafny.String(data.EntryCapacity) + ", " + _dafny.String(data.EntryPruningTailSize) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this SingleThreadedCache) Equals(other SingleThreadedCache) bool {
	switch data1 := _this.Get_().(type) {
	case SingleThreadedCache_SingleThreadedCache:
		{
			data2, ok := other.Get_().(SingleThreadedCache_SingleThreadedCache)
			return ok && data1.EntryCapacity == data2.EntryCapacity && data1.EntryPruningTailSize.Equals(data2.EntryPruningTailSize)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this SingleThreadedCache) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(SingleThreadedCache)
	return ok && _this.Equals(typed)
}

func Type_SingleThreadedCache_() _dafny.TypeDescriptor {
	return type_SingleThreadedCache_{}
}

type type_SingleThreadedCache_ struct {
}

func (_this type_SingleThreadedCache_) Default() interface{} {
	return Companion_SingleThreadedCache_.Default()
}

func (_this type_SingleThreadedCache_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.SingleThreadedCache"
}
func (_this SingleThreadedCache) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = SingleThreadedCache{}

// End of datatype SingleThreadedCache

// Definition of datatype StaticConfigurations
type StaticConfigurations struct {
	Data_StaticConfigurations_
}

func (_this StaticConfigurations) Get_() Data_StaticConfigurations_ {
	return _this.Data_StaticConfigurations_
}

type Data_StaticConfigurations_ interface {
	isStaticConfigurations()
}

type CompanionStruct_StaticConfigurations_ struct {
}

var Companion_StaticConfigurations_ = CompanionStruct_StaticConfigurations_{}

type StaticConfigurations_AWS__KMS__ECDH struct {
	AWS__KMS__ECDH KmsEcdhStaticConfigurations
}

func (StaticConfigurations_AWS__KMS__ECDH) isStaticConfigurations() {}

func (CompanionStruct_StaticConfigurations_) Create_AWS__KMS__ECDH_(AWS__KMS__ECDH KmsEcdhStaticConfigurations) StaticConfigurations {
	return StaticConfigurations{StaticConfigurations_AWS__KMS__ECDH{AWS__KMS__ECDH}}
}

func (_this StaticConfigurations) Is_AWS__KMS__ECDH() bool {
	_, ok := _this.Get_().(StaticConfigurations_AWS__KMS__ECDH)
	return ok
}

type StaticConfigurations_RAW__ECDH struct {
	RAW__ECDH RawEcdhStaticConfigurations
}

func (StaticConfigurations_RAW__ECDH) isStaticConfigurations() {}

func (CompanionStruct_StaticConfigurations_) Create_RAW__ECDH_(RAW__ECDH RawEcdhStaticConfigurations) StaticConfigurations {
	return StaticConfigurations{StaticConfigurations_RAW__ECDH{RAW__ECDH}}
}

func (_this StaticConfigurations) Is_RAW__ECDH() bool {
	_, ok := _this.Get_().(StaticConfigurations_RAW__ECDH)
	return ok
}

func (CompanionStruct_StaticConfigurations_) Default() StaticConfigurations {
	return Companion_StaticConfigurations_.Create_AWS__KMS__ECDH_(Companion_KmsEcdhStaticConfigurations_.Default())
}

func (_this StaticConfigurations) Dtor_AWS__KMS__ECDH() KmsEcdhStaticConfigurations {
	return _this.Get_().(StaticConfigurations_AWS__KMS__ECDH).AWS__KMS__ECDH
}

func (_this StaticConfigurations) Dtor_RAW__ECDH() RawEcdhStaticConfigurations {
	return _this.Get_().(StaticConfigurations_RAW__ECDH).RAW__ECDH
}

func (_this StaticConfigurations) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case StaticConfigurations_AWS__KMS__ECDH:
		{
			return "AwsCryptographyMaterialProvidersTypes.StaticConfigurations.AWS_KMS_ECDH" + "(" + _dafny.String(data.AWS__KMS__ECDH) + ")"
		}
	case StaticConfigurations_RAW__ECDH:
		{
			return "AwsCryptographyMaterialProvidersTypes.StaticConfigurations.RAW_ECDH" + "(" + _dafny.String(data.RAW__ECDH) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this StaticConfigurations) Equals(other StaticConfigurations) bool {
	switch data1 := _this.Get_().(type) {
	case StaticConfigurations_AWS__KMS__ECDH:
		{
			data2, ok := other.Get_().(StaticConfigurations_AWS__KMS__ECDH)
			return ok && data1.AWS__KMS__ECDH.Equals(data2.AWS__KMS__ECDH)
		}
	case StaticConfigurations_RAW__ECDH:
		{
			data2, ok := other.Get_().(StaticConfigurations_RAW__ECDH)
			return ok && data1.RAW__ECDH.Equals(data2.RAW__ECDH)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this StaticConfigurations) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(StaticConfigurations)
	return ok && _this.Equals(typed)
}

func Type_StaticConfigurations_() _dafny.TypeDescriptor {
	return type_StaticConfigurations_{}
}

type type_StaticConfigurations_ struct {
}

func (_this type_StaticConfigurations_) Default() interface{} {
	return Companion_StaticConfigurations_.Default()
}

func (_this type_StaticConfigurations_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.StaticConfigurations"
}
func (_this StaticConfigurations) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = StaticConfigurations{}

// End of datatype StaticConfigurations

// Definition of datatype StormTrackingCache
type StormTrackingCache struct {
	Data_StormTrackingCache_
}

func (_this StormTrackingCache) Get_() Data_StormTrackingCache_ {
	return _this.Data_StormTrackingCache_
}

type Data_StormTrackingCache_ interface {
	isStormTrackingCache()
}

type CompanionStruct_StormTrackingCache_ struct {
}

var Companion_StormTrackingCache_ = CompanionStruct_StormTrackingCache_{}

type StormTrackingCache_StormTrackingCache struct {
	EntryCapacity        int32
	EntryPruningTailSize m_Wrappers.Option
	GracePeriod          int32
	GraceInterval        int32
	FanOut               int32
	InFlightTTL          int32
	SleepMilli           int32
	TimeUnits            m_Wrappers.Option
}

func (StormTrackingCache_StormTrackingCache) isStormTrackingCache() {}

func (CompanionStruct_StormTrackingCache_) Create_StormTrackingCache_(EntryCapacity int32, EntryPruningTailSize m_Wrappers.Option, GracePeriod int32, GraceInterval int32, FanOut int32, InFlightTTL int32, SleepMilli int32, TimeUnits m_Wrappers.Option) StormTrackingCache {
	return StormTrackingCache{StormTrackingCache_StormTrackingCache{EntryCapacity, EntryPruningTailSize, GracePeriod, GraceInterval, FanOut, InFlightTTL, SleepMilli, TimeUnits}}
}

func (_this StormTrackingCache) Is_StormTrackingCache() bool {
	_, ok := _this.Get_().(StormTrackingCache_StormTrackingCache)
	return ok
}

func (CompanionStruct_StormTrackingCache_) Default() StormTrackingCache {
	return Companion_StormTrackingCache_.Create_StormTrackingCache_(int32(0), m_Wrappers.Companion_Option_.Default(), int32(0), int32(0), int32(0), int32(0), int32(0), m_Wrappers.Companion_Option_.Default())
}

func (_this StormTrackingCache) Dtor_entryCapacity() int32 {
	return _this.Get_().(StormTrackingCache_StormTrackingCache).EntryCapacity
}

func (_this StormTrackingCache) Dtor_entryPruningTailSize() m_Wrappers.Option {
	return _this.Get_().(StormTrackingCache_StormTrackingCache).EntryPruningTailSize
}

func (_this StormTrackingCache) Dtor_gracePeriod() int32 {
	return _this.Get_().(StormTrackingCache_StormTrackingCache).GracePeriod
}

func (_this StormTrackingCache) Dtor_graceInterval() int32 {
	return _this.Get_().(StormTrackingCache_StormTrackingCache).GraceInterval
}

func (_this StormTrackingCache) Dtor_fanOut() int32 {
	return _this.Get_().(StormTrackingCache_StormTrackingCache).FanOut
}

func (_this StormTrackingCache) Dtor_inFlightTTL() int32 {
	return _this.Get_().(StormTrackingCache_StormTrackingCache).InFlightTTL
}

func (_this StormTrackingCache) Dtor_sleepMilli() int32 {
	return _this.Get_().(StormTrackingCache_StormTrackingCache).SleepMilli
}

func (_this StormTrackingCache) Dtor_timeUnits() m_Wrappers.Option {
	return _this.Get_().(StormTrackingCache_StormTrackingCache).TimeUnits
}

func (_this StormTrackingCache) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case StormTrackingCache_StormTrackingCache:
		{
			return "AwsCryptographyMaterialProvidersTypes.StormTrackingCache.StormTrackingCache" + "(" + _dafny.String(data.EntryCapacity) + ", " + _dafny.String(data.EntryPruningTailSize) + ", " + _dafny.String(data.GracePeriod) + ", " + _dafny.String(data.GraceInterval) + ", " + _dafny.String(data.FanOut) + ", " + _dafny.String(data.InFlightTTL) + ", " + _dafny.String(data.SleepMilli) + ", " + _dafny.String(data.TimeUnits) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this StormTrackingCache) Equals(other StormTrackingCache) bool {
	switch data1 := _this.Get_().(type) {
	case StormTrackingCache_StormTrackingCache:
		{
			data2, ok := other.Get_().(StormTrackingCache_StormTrackingCache)
			return ok && data1.EntryCapacity == data2.EntryCapacity && data1.EntryPruningTailSize.Equals(data2.EntryPruningTailSize) && data1.GracePeriod == data2.GracePeriod && data1.GraceInterval == data2.GraceInterval && data1.FanOut == data2.FanOut && data1.InFlightTTL == data2.InFlightTTL && data1.SleepMilli == data2.SleepMilli && data1.TimeUnits.Equals(data2.TimeUnits)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this StormTrackingCache) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(StormTrackingCache)
	return ok && _this.Equals(typed)
}

func Type_StormTrackingCache_() _dafny.TypeDescriptor {
	return type_StormTrackingCache_{}
}

type type_StormTrackingCache_ struct {
}

func (_this type_StormTrackingCache_) Default() interface{} {
	return Companion_StormTrackingCache_.Default()
}

func (_this type_StormTrackingCache_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.StormTrackingCache"
}
func (_this StormTrackingCache) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = StormTrackingCache{}

// End of datatype StormTrackingCache

// Definition of datatype SymmetricSignatureAlgorithm
type SymmetricSignatureAlgorithm struct {
	Data_SymmetricSignatureAlgorithm_
}

func (_this SymmetricSignatureAlgorithm) Get_() Data_SymmetricSignatureAlgorithm_ {
	return _this.Data_SymmetricSignatureAlgorithm_
}

type Data_SymmetricSignatureAlgorithm_ interface {
	isSymmetricSignatureAlgorithm()
}

type CompanionStruct_SymmetricSignatureAlgorithm_ struct {
}

var Companion_SymmetricSignatureAlgorithm_ = CompanionStruct_SymmetricSignatureAlgorithm_{}

type SymmetricSignatureAlgorithm_HMAC struct {
	HMAC m_AwsCryptographyPrimitivesTypes.DigestAlgorithm
}

func (SymmetricSignatureAlgorithm_HMAC) isSymmetricSignatureAlgorithm() {}

func (CompanionStruct_SymmetricSignatureAlgorithm_) Create_HMAC_(HMAC m_AwsCryptographyPrimitivesTypes.DigestAlgorithm) SymmetricSignatureAlgorithm {
	return SymmetricSignatureAlgorithm{SymmetricSignatureAlgorithm_HMAC{HMAC}}
}

func (_this SymmetricSignatureAlgorithm) Is_HMAC() bool {
	_, ok := _this.Get_().(SymmetricSignatureAlgorithm_HMAC)
	return ok
}

type SymmetricSignatureAlgorithm_None struct {
	None None
}

func (SymmetricSignatureAlgorithm_None) isSymmetricSignatureAlgorithm() {}

func (CompanionStruct_SymmetricSignatureAlgorithm_) Create_None_(None None) SymmetricSignatureAlgorithm {
	return SymmetricSignatureAlgorithm{SymmetricSignatureAlgorithm_None{None}}
}

func (_this SymmetricSignatureAlgorithm) Is_None() bool {
	_, ok := _this.Get_().(SymmetricSignatureAlgorithm_None)
	return ok
}

func (CompanionStruct_SymmetricSignatureAlgorithm_) Default() SymmetricSignatureAlgorithm {
	return Companion_SymmetricSignatureAlgorithm_.Create_HMAC_(m_AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Default())
}

func (_this SymmetricSignatureAlgorithm) Dtor_HMAC() m_AwsCryptographyPrimitivesTypes.DigestAlgorithm {
	return _this.Get_().(SymmetricSignatureAlgorithm_HMAC).HMAC
}

func (_this SymmetricSignatureAlgorithm) Dtor_None() None {
	return _this.Get_().(SymmetricSignatureAlgorithm_None).None
}

func (_this SymmetricSignatureAlgorithm) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case SymmetricSignatureAlgorithm_HMAC:
		{
			return "AwsCryptographyMaterialProvidersTypes.SymmetricSignatureAlgorithm.HMAC" + "(" + _dafny.String(data.HMAC) + ")"
		}
	case SymmetricSignatureAlgorithm_None:
		{
			return "AwsCryptographyMaterialProvidersTypes.SymmetricSignatureAlgorithm.None" + "(" + _dafny.String(data.None) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this SymmetricSignatureAlgorithm) Equals(other SymmetricSignatureAlgorithm) bool {
	switch data1 := _this.Get_().(type) {
	case SymmetricSignatureAlgorithm_HMAC:
		{
			data2, ok := other.Get_().(SymmetricSignatureAlgorithm_HMAC)
			return ok && data1.HMAC.Equals(data2.HMAC)
		}
	case SymmetricSignatureAlgorithm_None:
		{
			data2, ok := other.Get_().(SymmetricSignatureAlgorithm_None)
			return ok && data1.None.Equals(data2.None)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this SymmetricSignatureAlgorithm) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(SymmetricSignatureAlgorithm)
	return ok && _this.Equals(typed)
}

func Type_SymmetricSignatureAlgorithm_() _dafny.TypeDescriptor {
	return type_SymmetricSignatureAlgorithm_{}
}

type type_SymmetricSignatureAlgorithm_ struct {
}

func (_this type_SymmetricSignatureAlgorithm_) Default() interface{} {
	return Companion_SymmetricSignatureAlgorithm_.Default()
}

func (_this type_SymmetricSignatureAlgorithm_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.SymmetricSignatureAlgorithm"
}
func (_this SymmetricSignatureAlgorithm) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = SymmetricSignatureAlgorithm{}

// End of datatype SymmetricSignatureAlgorithm

// Definition of datatype TimeUnits
type TimeUnits struct {
	Data_TimeUnits_
}

func (_this TimeUnits) Get_() Data_TimeUnits_ {
	return _this.Data_TimeUnits_
}

type Data_TimeUnits_ interface {
	isTimeUnits()
}

type CompanionStruct_TimeUnits_ struct {
}

var Companion_TimeUnits_ = CompanionStruct_TimeUnits_{}

type TimeUnits_Seconds struct {
}

func (TimeUnits_Seconds) isTimeUnits() {}

func (CompanionStruct_TimeUnits_) Create_Seconds_() TimeUnits {
	return TimeUnits{TimeUnits_Seconds{}}
}

func (_this TimeUnits) Is_Seconds() bool {
	_, ok := _this.Get_().(TimeUnits_Seconds)
	return ok
}

type TimeUnits_Milliseconds struct {
}

func (TimeUnits_Milliseconds) isTimeUnits() {}

func (CompanionStruct_TimeUnits_) Create_Milliseconds_() TimeUnits {
	return TimeUnits{TimeUnits_Milliseconds{}}
}

func (_this TimeUnits) Is_Milliseconds() bool {
	_, ok := _this.Get_().(TimeUnits_Milliseconds)
	return ok
}

func (CompanionStruct_TimeUnits_) Default() TimeUnits {
	return Companion_TimeUnits_.Create_Seconds_()
}

func (_ CompanionStruct_TimeUnits_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_TimeUnits_.Create_Seconds_(), true
		case 1:
			return Companion_TimeUnits_.Create_Milliseconds_(), true
		default:
			return TimeUnits{}, false
		}
	}
}

func (_this TimeUnits) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case TimeUnits_Seconds:
		{
			return "AwsCryptographyMaterialProvidersTypes.TimeUnits.Seconds"
		}
	case TimeUnits_Milliseconds:
		{
			return "AwsCryptographyMaterialProvidersTypes.TimeUnits.Milliseconds"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this TimeUnits) Equals(other TimeUnits) bool {
	switch _this.Get_().(type) {
	case TimeUnits_Seconds:
		{
			_, ok := other.Get_().(TimeUnits_Seconds)
			return ok
		}
	case TimeUnits_Milliseconds:
		{
			_, ok := other.Get_().(TimeUnits_Milliseconds)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this TimeUnits) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(TimeUnits)
	return ok && _this.Equals(typed)
}

func Type_TimeUnits_() _dafny.TypeDescriptor {
	return type_TimeUnits_{}
}

type type_TimeUnits_ struct {
}

func (_this type_TimeUnits_) Default() interface{} {
	return Companion_TimeUnits_.Default()
}

func (_this type_TimeUnits_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.TimeUnits"
}
func (_this TimeUnits) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = TimeUnits{}

// End of datatype TimeUnits

// Definition of datatype UpdateUsageMetadataInput
type UpdateUsageMetadataInput struct {
	Data_UpdateUsageMetadataInput_
}

func (_this UpdateUsageMetadataInput) Get_() Data_UpdateUsageMetadataInput_ {
	return _this.Data_UpdateUsageMetadataInput_
}

type Data_UpdateUsageMetadataInput_ interface {
	isUpdateUsageMetadataInput()
}

type CompanionStruct_UpdateUsageMetadataInput_ struct {
}

var Companion_UpdateUsageMetadataInput_ = CompanionStruct_UpdateUsageMetadataInput_{}

type UpdateUsageMetadataInput_UpdateUsageMetadataInput struct {
	Identifier _dafny.Sequence
	BytesUsed  int32
}

func (UpdateUsageMetadataInput_UpdateUsageMetadataInput) isUpdateUsageMetadataInput() {}

func (CompanionStruct_UpdateUsageMetadataInput_) Create_UpdateUsageMetadataInput_(Identifier _dafny.Sequence, BytesUsed int32) UpdateUsageMetadataInput {
	return UpdateUsageMetadataInput{UpdateUsageMetadataInput_UpdateUsageMetadataInput{Identifier, BytesUsed}}
}

func (_this UpdateUsageMetadataInput) Is_UpdateUsageMetadataInput() bool {
	_, ok := _this.Get_().(UpdateUsageMetadataInput_UpdateUsageMetadataInput)
	return ok
}

func (CompanionStruct_UpdateUsageMetadataInput_) Default() UpdateUsageMetadataInput {
	return Companion_UpdateUsageMetadataInput_.Create_UpdateUsageMetadataInput_(_dafny.EmptySeq, int32(0))
}

func (_this UpdateUsageMetadataInput) Dtor_identifier() _dafny.Sequence {
	return _this.Get_().(UpdateUsageMetadataInput_UpdateUsageMetadataInput).Identifier
}

func (_this UpdateUsageMetadataInput) Dtor_bytesUsed() int32 {
	return _this.Get_().(UpdateUsageMetadataInput_UpdateUsageMetadataInput).BytesUsed
}

func (_this UpdateUsageMetadataInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case UpdateUsageMetadataInput_UpdateUsageMetadataInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.UpdateUsageMetadataInput.UpdateUsageMetadataInput" + "(" + _dafny.String(data.Identifier) + ", " + _dafny.String(data.BytesUsed) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this UpdateUsageMetadataInput) Equals(other UpdateUsageMetadataInput) bool {
	switch data1 := _this.Get_().(type) {
	case UpdateUsageMetadataInput_UpdateUsageMetadataInput:
		{
			data2, ok := other.Get_().(UpdateUsageMetadataInput_UpdateUsageMetadataInput)
			return ok && data1.Identifier.Equals(data2.Identifier) && data1.BytesUsed == data2.BytesUsed
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this UpdateUsageMetadataInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(UpdateUsageMetadataInput)
	return ok && _this.Equals(typed)
}

func Type_UpdateUsageMetadataInput_() _dafny.TypeDescriptor {
	return type_UpdateUsageMetadataInput_{}
}

type type_UpdateUsageMetadataInput_ struct {
}

func (_this type_UpdateUsageMetadataInput_) Default() interface{} {
	return Companion_UpdateUsageMetadataInput_.Default()
}

func (_this type_UpdateUsageMetadataInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.UpdateUsageMetadataInput"
}
func (_this UpdateUsageMetadataInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = UpdateUsageMetadataInput{}

// End of datatype UpdateUsageMetadataInput

// Definition of datatype ValidateCommitmentPolicyOnDecryptInput
type ValidateCommitmentPolicyOnDecryptInput struct {
	Data_ValidateCommitmentPolicyOnDecryptInput_
}

func (_this ValidateCommitmentPolicyOnDecryptInput) Get_() Data_ValidateCommitmentPolicyOnDecryptInput_ {
	return _this.Data_ValidateCommitmentPolicyOnDecryptInput_
}

type Data_ValidateCommitmentPolicyOnDecryptInput_ interface {
	isValidateCommitmentPolicyOnDecryptInput()
}

type CompanionStruct_ValidateCommitmentPolicyOnDecryptInput_ struct {
}

var Companion_ValidateCommitmentPolicyOnDecryptInput_ = CompanionStruct_ValidateCommitmentPolicyOnDecryptInput_{}

type ValidateCommitmentPolicyOnDecryptInput_ValidateCommitmentPolicyOnDecryptInput struct {
	Algorithm        AlgorithmSuiteId
	CommitmentPolicy CommitmentPolicy
}

func (ValidateCommitmentPolicyOnDecryptInput_ValidateCommitmentPolicyOnDecryptInput) isValidateCommitmentPolicyOnDecryptInput() {
}

func (CompanionStruct_ValidateCommitmentPolicyOnDecryptInput_) Create_ValidateCommitmentPolicyOnDecryptInput_(Algorithm AlgorithmSuiteId, CommitmentPolicy CommitmentPolicy) ValidateCommitmentPolicyOnDecryptInput {
	return ValidateCommitmentPolicyOnDecryptInput{ValidateCommitmentPolicyOnDecryptInput_ValidateCommitmentPolicyOnDecryptInput{Algorithm, CommitmentPolicy}}
}

func (_this ValidateCommitmentPolicyOnDecryptInput) Is_ValidateCommitmentPolicyOnDecryptInput() bool {
	_, ok := _this.Get_().(ValidateCommitmentPolicyOnDecryptInput_ValidateCommitmentPolicyOnDecryptInput)
	return ok
}

func (CompanionStruct_ValidateCommitmentPolicyOnDecryptInput_) Default() ValidateCommitmentPolicyOnDecryptInput {
	return Companion_ValidateCommitmentPolicyOnDecryptInput_.Create_ValidateCommitmentPolicyOnDecryptInput_(Companion_AlgorithmSuiteId_.Default(), Companion_CommitmentPolicy_.Default())
}

func (_this ValidateCommitmentPolicyOnDecryptInput) Dtor_algorithm() AlgorithmSuiteId {
	return _this.Get_().(ValidateCommitmentPolicyOnDecryptInput_ValidateCommitmentPolicyOnDecryptInput).Algorithm
}

func (_this ValidateCommitmentPolicyOnDecryptInput) Dtor_commitmentPolicy() CommitmentPolicy {
	return _this.Get_().(ValidateCommitmentPolicyOnDecryptInput_ValidateCommitmentPolicyOnDecryptInput).CommitmentPolicy
}

func (_this ValidateCommitmentPolicyOnDecryptInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ValidateCommitmentPolicyOnDecryptInput_ValidateCommitmentPolicyOnDecryptInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.ValidateCommitmentPolicyOnDecryptInput.ValidateCommitmentPolicyOnDecryptInput" + "(" + _dafny.String(data.Algorithm) + ", " + _dafny.String(data.CommitmentPolicy) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ValidateCommitmentPolicyOnDecryptInput) Equals(other ValidateCommitmentPolicyOnDecryptInput) bool {
	switch data1 := _this.Get_().(type) {
	case ValidateCommitmentPolicyOnDecryptInput_ValidateCommitmentPolicyOnDecryptInput:
		{
			data2, ok := other.Get_().(ValidateCommitmentPolicyOnDecryptInput_ValidateCommitmentPolicyOnDecryptInput)
			return ok && data1.Algorithm.Equals(data2.Algorithm) && data1.CommitmentPolicy.Equals(data2.CommitmentPolicy)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ValidateCommitmentPolicyOnDecryptInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ValidateCommitmentPolicyOnDecryptInput)
	return ok && _this.Equals(typed)
}

func Type_ValidateCommitmentPolicyOnDecryptInput_() _dafny.TypeDescriptor {
	return type_ValidateCommitmentPolicyOnDecryptInput_{}
}

type type_ValidateCommitmentPolicyOnDecryptInput_ struct {
}

func (_this type_ValidateCommitmentPolicyOnDecryptInput_) Default() interface{} {
	return Companion_ValidateCommitmentPolicyOnDecryptInput_.Default()
}

func (_this type_ValidateCommitmentPolicyOnDecryptInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.ValidateCommitmentPolicyOnDecryptInput"
}
func (_this ValidateCommitmentPolicyOnDecryptInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ValidateCommitmentPolicyOnDecryptInput{}

// End of datatype ValidateCommitmentPolicyOnDecryptInput

// Definition of datatype ValidateCommitmentPolicyOnEncryptInput
type ValidateCommitmentPolicyOnEncryptInput struct {
	Data_ValidateCommitmentPolicyOnEncryptInput_
}

func (_this ValidateCommitmentPolicyOnEncryptInput) Get_() Data_ValidateCommitmentPolicyOnEncryptInput_ {
	return _this.Data_ValidateCommitmentPolicyOnEncryptInput_
}

type Data_ValidateCommitmentPolicyOnEncryptInput_ interface {
	isValidateCommitmentPolicyOnEncryptInput()
}

type CompanionStruct_ValidateCommitmentPolicyOnEncryptInput_ struct {
}

var Companion_ValidateCommitmentPolicyOnEncryptInput_ = CompanionStruct_ValidateCommitmentPolicyOnEncryptInput_{}

type ValidateCommitmentPolicyOnEncryptInput_ValidateCommitmentPolicyOnEncryptInput struct {
	Algorithm        AlgorithmSuiteId
	CommitmentPolicy CommitmentPolicy
}

func (ValidateCommitmentPolicyOnEncryptInput_ValidateCommitmentPolicyOnEncryptInput) isValidateCommitmentPolicyOnEncryptInput() {
}

func (CompanionStruct_ValidateCommitmentPolicyOnEncryptInput_) Create_ValidateCommitmentPolicyOnEncryptInput_(Algorithm AlgorithmSuiteId, CommitmentPolicy CommitmentPolicy) ValidateCommitmentPolicyOnEncryptInput {
	return ValidateCommitmentPolicyOnEncryptInput{ValidateCommitmentPolicyOnEncryptInput_ValidateCommitmentPolicyOnEncryptInput{Algorithm, CommitmentPolicy}}
}

func (_this ValidateCommitmentPolicyOnEncryptInput) Is_ValidateCommitmentPolicyOnEncryptInput() bool {
	_, ok := _this.Get_().(ValidateCommitmentPolicyOnEncryptInput_ValidateCommitmentPolicyOnEncryptInput)
	return ok
}

func (CompanionStruct_ValidateCommitmentPolicyOnEncryptInput_) Default() ValidateCommitmentPolicyOnEncryptInput {
	return Companion_ValidateCommitmentPolicyOnEncryptInput_.Create_ValidateCommitmentPolicyOnEncryptInput_(Companion_AlgorithmSuiteId_.Default(), Companion_CommitmentPolicy_.Default())
}

func (_this ValidateCommitmentPolicyOnEncryptInput) Dtor_algorithm() AlgorithmSuiteId {
	return _this.Get_().(ValidateCommitmentPolicyOnEncryptInput_ValidateCommitmentPolicyOnEncryptInput).Algorithm
}

func (_this ValidateCommitmentPolicyOnEncryptInput) Dtor_commitmentPolicy() CommitmentPolicy {
	return _this.Get_().(ValidateCommitmentPolicyOnEncryptInput_ValidateCommitmentPolicyOnEncryptInput).CommitmentPolicy
}

func (_this ValidateCommitmentPolicyOnEncryptInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ValidateCommitmentPolicyOnEncryptInput_ValidateCommitmentPolicyOnEncryptInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.ValidateCommitmentPolicyOnEncryptInput.ValidateCommitmentPolicyOnEncryptInput" + "(" + _dafny.String(data.Algorithm) + ", " + _dafny.String(data.CommitmentPolicy) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ValidateCommitmentPolicyOnEncryptInput) Equals(other ValidateCommitmentPolicyOnEncryptInput) bool {
	switch data1 := _this.Get_().(type) {
	case ValidateCommitmentPolicyOnEncryptInput_ValidateCommitmentPolicyOnEncryptInput:
		{
			data2, ok := other.Get_().(ValidateCommitmentPolicyOnEncryptInput_ValidateCommitmentPolicyOnEncryptInput)
			return ok && data1.Algorithm.Equals(data2.Algorithm) && data1.CommitmentPolicy.Equals(data2.CommitmentPolicy)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ValidateCommitmentPolicyOnEncryptInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ValidateCommitmentPolicyOnEncryptInput)
	return ok && _this.Equals(typed)
}

func Type_ValidateCommitmentPolicyOnEncryptInput_() _dafny.TypeDescriptor {
	return type_ValidateCommitmentPolicyOnEncryptInput_{}
}

type type_ValidateCommitmentPolicyOnEncryptInput_ struct {
}

func (_this type_ValidateCommitmentPolicyOnEncryptInput_) Default() interface{} {
	return Companion_ValidateCommitmentPolicyOnEncryptInput_.Default()
}

func (_this type_ValidateCommitmentPolicyOnEncryptInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.ValidateCommitmentPolicyOnEncryptInput"
}
func (_this ValidateCommitmentPolicyOnEncryptInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ValidateCommitmentPolicyOnEncryptInput{}

// End of datatype ValidateCommitmentPolicyOnEncryptInput

// Definition of datatype ValidDecryptionMaterialsTransitionInput
type ValidDecryptionMaterialsTransitionInput struct {
	Data_ValidDecryptionMaterialsTransitionInput_
}

func (_this ValidDecryptionMaterialsTransitionInput) Get_() Data_ValidDecryptionMaterialsTransitionInput_ {
	return _this.Data_ValidDecryptionMaterialsTransitionInput_
}

type Data_ValidDecryptionMaterialsTransitionInput_ interface {
	isValidDecryptionMaterialsTransitionInput()
}

type CompanionStruct_ValidDecryptionMaterialsTransitionInput_ struct {
}

var Companion_ValidDecryptionMaterialsTransitionInput_ = CompanionStruct_ValidDecryptionMaterialsTransitionInput_{}

type ValidDecryptionMaterialsTransitionInput_ValidDecryptionMaterialsTransitionInput struct {
	Start DecryptionMaterials
	Stop  DecryptionMaterials
}

func (ValidDecryptionMaterialsTransitionInput_ValidDecryptionMaterialsTransitionInput) isValidDecryptionMaterialsTransitionInput() {
}

func (CompanionStruct_ValidDecryptionMaterialsTransitionInput_) Create_ValidDecryptionMaterialsTransitionInput_(Start DecryptionMaterials, Stop DecryptionMaterials) ValidDecryptionMaterialsTransitionInput {
	return ValidDecryptionMaterialsTransitionInput{ValidDecryptionMaterialsTransitionInput_ValidDecryptionMaterialsTransitionInput{Start, Stop}}
}

func (_this ValidDecryptionMaterialsTransitionInput) Is_ValidDecryptionMaterialsTransitionInput() bool {
	_, ok := _this.Get_().(ValidDecryptionMaterialsTransitionInput_ValidDecryptionMaterialsTransitionInput)
	return ok
}

func (CompanionStruct_ValidDecryptionMaterialsTransitionInput_) Default() ValidDecryptionMaterialsTransitionInput {
	return Companion_ValidDecryptionMaterialsTransitionInput_.Create_ValidDecryptionMaterialsTransitionInput_(Companion_DecryptionMaterials_.Default(), Companion_DecryptionMaterials_.Default())
}

func (_this ValidDecryptionMaterialsTransitionInput) Dtor_start() DecryptionMaterials {
	return _this.Get_().(ValidDecryptionMaterialsTransitionInput_ValidDecryptionMaterialsTransitionInput).Start
}

func (_this ValidDecryptionMaterialsTransitionInput) Dtor_stop() DecryptionMaterials {
	return _this.Get_().(ValidDecryptionMaterialsTransitionInput_ValidDecryptionMaterialsTransitionInput).Stop
}

func (_this ValidDecryptionMaterialsTransitionInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ValidDecryptionMaterialsTransitionInput_ValidDecryptionMaterialsTransitionInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.ValidDecryptionMaterialsTransitionInput.ValidDecryptionMaterialsTransitionInput" + "(" + _dafny.String(data.Start) + ", " + _dafny.String(data.Stop) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ValidDecryptionMaterialsTransitionInput) Equals(other ValidDecryptionMaterialsTransitionInput) bool {
	switch data1 := _this.Get_().(type) {
	case ValidDecryptionMaterialsTransitionInput_ValidDecryptionMaterialsTransitionInput:
		{
			data2, ok := other.Get_().(ValidDecryptionMaterialsTransitionInput_ValidDecryptionMaterialsTransitionInput)
			return ok && data1.Start.Equals(data2.Start) && data1.Stop.Equals(data2.Stop)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ValidDecryptionMaterialsTransitionInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ValidDecryptionMaterialsTransitionInput)
	return ok && _this.Equals(typed)
}

func Type_ValidDecryptionMaterialsTransitionInput_() _dafny.TypeDescriptor {
	return type_ValidDecryptionMaterialsTransitionInput_{}
}

type type_ValidDecryptionMaterialsTransitionInput_ struct {
}

func (_this type_ValidDecryptionMaterialsTransitionInput_) Default() interface{} {
	return Companion_ValidDecryptionMaterialsTransitionInput_.Default()
}

func (_this type_ValidDecryptionMaterialsTransitionInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.ValidDecryptionMaterialsTransitionInput"
}
func (_this ValidDecryptionMaterialsTransitionInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ValidDecryptionMaterialsTransitionInput{}

// End of datatype ValidDecryptionMaterialsTransitionInput

// Definition of datatype ValidEncryptionMaterialsTransitionInput
type ValidEncryptionMaterialsTransitionInput struct {
	Data_ValidEncryptionMaterialsTransitionInput_
}

func (_this ValidEncryptionMaterialsTransitionInput) Get_() Data_ValidEncryptionMaterialsTransitionInput_ {
	return _this.Data_ValidEncryptionMaterialsTransitionInput_
}

type Data_ValidEncryptionMaterialsTransitionInput_ interface {
	isValidEncryptionMaterialsTransitionInput()
}

type CompanionStruct_ValidEncryptionMaterialsTransitionInput_ struct {
}

var Companion_ValidEncryptionMaterialsTransitionInput_ = CompanionStruct_ValidEncryptionMaterialsTransitionInput_{}

type ValidEncryptionMaterialsTransitionInput_ValidEncryptionMaterialsTransitionInput struct {
	Start EncryptionMaterials
	Stop  EncryptionMaterials
}

func (ValidEncryptionMaterialsTransitionInput_ValidEncryptionMaterialsTransitionInput) isValidEncryptionMaterialsTransitionInput() {
}

func (CompanionStruct_ValidEncryptionMaterialsTransitionInput_) Create_ValidEncryptionMaterialsTransitionInput_(Start EncryptionMaterials, Stop EncryptionMaterials) ValidEncryptionMaterialsTransitionInput {
	return ValidEncryptionMaterialsTransitionInput{ValidEncryptionMaterialsTransitionInput_ValidEncryptionMaterialsTransitionInput{Start, Stop}}
}

func (_this ValidEncryptionMaterialsTransitionInput) Is_ValidEncryptionMaterialsTransitionInput() bool {
	_, ok := _this.Get_().(ValidEncryptionMaterialsTransitionInput_ValidEncryptionMaterialsTransitionInput)
	return ok
}

func (CompanionStruct_ValidEncryptionMaterialsTransitionInput_) Default() ValidEncryptionMaterialsTransitionInput {
	return Companion_ValidEncryptionMaterialsTransitionInput_.Create_ValidEncryptionMaterialsTransitionInput_(Companion_EncryptionMaterials_.Default(), Companion_EncryptionMaterials_.Default())
}

func (_this ValidEncryptionMaterialsTransitionInput) Dtor_start() EncryptionMaterials {
	return _this.Get_().(ValidEncryptionMaterialsTransitionInput_ValidEncryptionMaterialsTransitionInput).Start
}

func (_this ValidEncryptionMaterialsTransitionInput) Dtor_stop() EncryptionMaterials {
	return _this.Get_().(ValidEncryptionMaterialsTransitionInput_ValidEncryptionMaterialsTransitionInput).Stop
}

func (_this ValidEncryptionMaterialsTransitionInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ValidEncryptionMaterialsTransitionInput_ValidEncryptionMaterialsTransitionInput:
		{
			return "AwsCryptographyMaterialProvidersTypes.ValidEncryptionMaterialsTransitionInput.ValidEncryptionMaterialsTransitionInput" + "(" + _dafny.String(data.Start) + ", " + _dafny.String(data.Stop) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ValidEncryptionMaterialsTransitionInput) Equals(other ValidEncryptionMaterialsTransitionInput) bool {
	switch data1 := _this.Get_().(type) {
	case ValidEncryptionMaterialsTransitionInput_ValidEncryptionMaterialsTransitionInput:
		{
			data2, ok := other.Get_().(ValidEncryptionMaterialsTransitionInput_ValidEncryptionMaterialsTransitionInput)
			return ok && data1.Start.Equals(data2.Start) && data1.Stop.Equals(data2.Stop)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ValidEncryptionMaterialsTransitionInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ValidEncryptionMaterialsTransitionInput)
	return ok && _this.Equals(typed)
}

func Type_ValidEncryptionMaterialsTransitionInput_() _dafny.TypeDescriptor {
	return type_ValidEncryptionMaterialsTransitionInput_{}
}

type type_ValidEncryptionMaterialsTransitionInput_ struct {
}

func (_this type_ValidEncryptionMaterialsTransitionInput_) Default() interface{} {
	return Companion_ValidEncryptionMaterialsTransitionInput_.Default()
}

func (_this type_ValidEncryptionMaterialsTransitionInput_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.ValidEncryptionMaterialsTransitionInput"
}
func (_this ValidEncryptionMaterialsTransitionInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ValidEncryptionMaterialsTransitionInput{}

// End of datatype ValidEncryptionMaterialsTransitionInput

// Definition of datatype Error
type Error struct {
	Data_Error_
}

func (_this Error) Get_() Data_Error_ {
	return _this.Data_Error_
}

type Data_Error_ interface {
	isError()
}

type CompanionStruct_Error_ struct {
}

var Companion_Error_ = CompanionStruct_Error_{}

type Error_AwsCryptographicMaterialProvidersException struct {
	Message _dafny.Sequence
}

func (Error_AwsCryptographicMaterialProvidersException) isError() {}

func (CompanionStruct_Error_) Create_AwsCryptographicMaterialProvidersException_(Message _dafny.Sequence) Error {
	return Error{Error_AwsCryptographicMaterialProvidersException{Message}}
}

func (_this Error) Is_AwsCryptographicMaterialProvidersException() bool {
	_, ok := _this.Get_().(Error_AwsCryptographicMaterialProvidersException)
	return ok
}

type Error_EntryAlreadyExists struct {
	Message _dafny.Sequence
}

func (Error_EntryAlreadyExists) isError() {}

func (CompanionStruct_Error_) Create_EntryAlreadyExists_(Message _dafny.Sequence) Error {
	return Error{Error_EntryAlreadyExists{Message}}
}

func (_this Error) Is_EntryAlreadyExists() bool {
	_, ok := _this.Get_().(Error_EntryAlreadyExists)
	return ok
}

type Error_EntryDoesNotExist struct {
	Message _dafny.Sequence
}

func (Error_EntryDoesNotExist) isError() {}

func (CompanionStruct_Error_) Create_EntryDoesNotExist_(Message _dafny.Sequence) Error {
	return Error{Error_EntryDoesNotExist{Message}}
}

func (_this Error) Is_EntryDoesNotExist() bool {
	_, ok := _this.Get_().(Error_EntryDoesNotExist)
	return ok
}

type Error_InFlightTTLExceeded struct {
	Message _dafny.Sequence
}

func (Error_InFlightTTLExceeded) isError() {}

func (CompanionStruct_Error_) Create_InFlightTTLExceeded_(Message _dafny.Sequence) Error {
	return Error{Error_InFlightTTLExceeded{Message}}
}

func (_this Error) Is_InFlightTTLExceeded() bool {
	_, ok := _this.Get_().(Error_InFlightTTLExceeded)
	return ok
}

type Error_InvalidAlgorithmSuiteInfo struct {
	Message _dafny.Sequence
}

func (Error_InvalidAlgorithmSuiteInfo) isError() {}

func (CompanionStruct_Error_) Create_InvalidAlgorithmSuiteInfo_(Message _dafny.Sequence) Error {
	return Error{Error_InvalidAlgorithmSuiteInfo{Message}}
}

func (_this Error) Is_InvalidAlgorithmSuiteInfo() bool {
	_, ok := _this.Get_().(Error_InvalidAlgorithmSuiteInfo)
	return ok
}

type Error_InvalidAlgorithmSuiteInfoOnDecrypt struct {
	Message _dafny.Sequence
}

func (Error_InvalidAlgorithmSuiteInfoOnDecrypt) isError() {}

func (CompanionStruct_Error_) Create_InvalidAlgorithmSuiteInfoOnDecrypt_(Message _dafny.Sequence) Error {
	return Error{Error_InvalidAlgorithmSuiteInfoOnDecrypt{Message}}
}

func (_this Error) Is_InvalidAlgorithmSuiteInfoOnDecrypt() bool {
	_, ok := _this.Get_().(Error_InvalidAlgorithmSuiteInfoOnDecrypt)
	return ok
}

type Error_InvalidAlgorithmSuiteInfoOnEncrypt struct {
	Message _dafny.Sequence
}

func (Error_InvalidAlgorithmSuiteInfoOnEncrypt) isError() {}

func (CompanionStruct_Error_) Create_InvalidAlgorithmSuiteInfoOnEncrypt_(Message _dafny.Sequence) Error {
	return Error{Error_InvalidAlgorithmSuiteInfoOnEncrypt{Message}}
}

func (_this Error) Is_InvalidAlgorithmSuiteInfoOnEncrypt() bool {
	_, ok := _this.Get_().(Error_InvalidAlgorithmSuiteInfoOnEncrypt)
	return ok
}

type Error_InvalidDecryptionMaterials struct {
	Message _dafny.Sequence
}

func (Error_InvalidDecryptionMaterials) isError() {}

func (CompanionStruct_Error_) Create_InvalidDecryptionMaterials_(Message _dafny.Sequence) Error {
	return Error{Error_InvalidDecryptionMaterials{Message}}
}

func (_this Error) Is_InvalidDecryptionMaterials() bool {
	_, ok := _this.Get_().(Error_InvalidDecryptionMaterials)
	return ok
}

type Error_InvalidDecryptionMaterialsTransition struct {
	Message _dafny.Sequence
}

func (Error_InvalidDecryptionMaterialsTransition) isError() {}

func (CompanionStruct_Error_) Create_InvalidDecryptionMaterialsTransition_(Message _dafny.Sequence) Error {
	return Error{Error_InvalidDecryptionMaterialsTransition{Message}}
}

func (_this Error) Is_InvalidDecryptionMaterialsTransition() bool {
	_, ok := _this.Get_().(Error_InvalidDecryptionMaterialsTransition)
	return ok
}

type Error_InvalidEncryptionMaterials struct {
	Message _dafny.Sequence
}

func (Error_InvalidEncryptionMaterials) isError() {}

func (CompanionStruct_Error_) Create_InvalidEncryptionMaterials_(Message _dafny.Sequence) Error {
	return Error{Error_InvalidEncryptionMaterials{Message}}
}

func (_this Error) Is_InvalidEncryptionMaterials() bool {
	_, ok := _this.Get_().(Error_InvalidEncryptionMaterials)
	return ok
}

type Error_InvalidEncryptionMaterialsTransition struct {
	Message _dafny.Sequence
}

func (Error_InvalidEncryptionMaterialsTransition) isError() {}

func (CompanionStruct_Error_) Create_InvalidEncryptionMaterialsTransition_(Message _dafny.Sequence) Error {
	return Error{Error_InvalidEncryptionMaterialsTransition{Message}}
}

func (_this Error) Is_InvalidEncryptionMaterialsTransition() bool {
	_, ok := _this.Get_().(Error_InvalidEncryptionMaterialsTransition)
	return ok
}

type Error_AwsCryptographyKeyStore struct {
	AwsCryptographyKeyStore m_AwsCryptographyKeyStoreTypes.Error
}

func (Error_AwsCryptographyKeyStore) isError() {}

func (CompanionStruct_Error_) Create_AwsCryptographyKeyStore_(AwsCryptographyKeyStore m_AwsCryptographyKeyStoreTypes.Error) Error {
	return Error{Error_AwsCryptographyKeyStore{AwsCryptographyKeyStore}}
}

func (_this Error) Is_AwsCryptographyKeyStore() bool {
	_, ok := _this.Get_().(Error_AwsCryptographyKeyStore)
	return ok
}

type Error_AwsCryptographyPrimitives struct {
	AwsCryptographyPrimitives m_AwsCryptographyPrimitivesTypes.Error
}

func (Error_AwsCryptographyPrimitives) isError() {}

func (CompanionStruct_Error_) Create_AwsCryptographyPrimitives_(AwsCryptographyPrimitives m_AwsCryptographyPrimitivesTypes.Error) Error {
	return Error{Error_AwsCryptographyPrimitives{AwsCryptographyPrimitives}}
}

func (_this Error) Is_AwsCryptographyPrimitives() bool {
	_, ok := _this.Get_().(Error_AwsCryptographyPrimitives)
	return ok
}

type Error_ComAmazonawsDynamodb struct {
	ComAmazonawsDynamodb m_ComAmazonawsDynamodbTypes.Error
}

func (Error_ComAmazonawsDynamodb) isError() {}

func (CompanionStruct_Error_) Create_ComAmazonawsDynamodb_(ComAmazonawsDynamodb m_ComAmazonawsDynamodbTypes.Error) Error {
	return Error{Error_ComAmazonawsDynamodb{ComAmazonawsDynamodb}}
}

func (_this Error) Is_ComAmazonawsDynamodb() bool {
	_, ok := _this.Get_().(Error_ComAmazonawsDynamodb)
	return ok
}

type Error_ComAmazonawsKms struct {
	ComAmazonawsKms m_ComAmazonawsKmsTypes.Error
}

func (Error_ComAmazonawsKms) isError() {}

func (CompanionStruct_Error_) Create_ComAmazonawsKms_(ComAmazonawsKms m_ComAmazonawsKmsTypes.Error) Error {
	return Error{Error_ComAmazonawsKms{ComAmazonawsKms}}
}

func (_this Error) Is_ComAmazonawsKms() bool {
	_, ok := _this.Get_().(Error_ComAmazonawsKms)
	return ok
}

type Error_CollectionOfErrors struct {
	List    _dafny.Sequence
	Message _dafny.Sequence
}

func (Error_CollectionOfErrors) isError() {}

func (CompanionStruct_Error_) Create_CollectionOfErrors_(List _dafny.Sequence, Message _dafny.Sequence) Error {
	return Error{Error_CollectionOfErrors{List, Message}}
}

func (_this Error) Is_CollectionOfErrors() bool {
	_, ok := _this.Get_().(Error_CollectionOfErrors)
	return ok
}

type Error_Opaque struct {
	Obj interface{}
}

func (Error_Opaque) isError() {}

func (CompanionStruct_Error_) Create_Opaque_(Obj interface{}) Error {
	return Error{Error_Opaque{Obj}}
}

func (_this Error) Is_Opaque() bool {
	_, ok := _this.Get_().(Error_Opaque)
	return ok
}

type Error_OpaqueWithText struct {
	Obj        interface{}
	ObjMessage _dafny.Sequence
}

func (Error_OpaqueWithText) isError() {}

func (CompanionStruct_Error_) Create_OpaqueWithText_(Obj interface{}, ObjMessage _dafny.Sequence) Error {
	return Error{Error_OpaqueWithText{Obj, ObjMessage}}
}

func (_this Error) Is_OpaqueWithText() bool {
	_, ok := _this.Get_().(Error_OpaqueWithText)
	return ok
}

func (CompanionStruct_Error_) Default() Error {
	return Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.EmptySeq.SetString())
}

func (_this Error) Dtor_message() _dafny.Sequence {
	switch data := _this.Get_().(type) {
	case Error_AwsCryptographicMaterialProvidersException:
		return data.Message
	case Error_EntryAlreadyExists:
		return data.Message
	case Error_EntryDoesNotExist:
		return data.Message
	case Error_InFlightTTLExceeded:
		return data.Message
	case Error_InvalidAlgorithmSuiteInfo:
		return data.Message
	case Error_InvalidAlgorithmSuiteInfoOnDecrypt:
		return data.Message
	case Error_InvalidAlgorithmSuiteInfoOnEncrypt:
		return data.Message
	case Error_InvalidDecryptionMaterials:
		return data.Message
	case Error_InvalidDecryptionMaterialsTransition:
		return data.Message
	case Error_InvalidEncryptionMaterials:
		return data.Message
	case Error_InvalidEncryptionMaterialsTransition:
		return data.Message
	default:
		return data.(Error_CollectionOfErrors).Message
	}
}

func (_this Error) Dtor_AwsCryptographyKeyStore() m_AwsCryptographyKeyStoreTypes.Error {
	return _this.Get_().(Error_AwsCryptographyKeyStore).AwsCryptographyKeyStore
}

func (_this Error) Dtor_AwsCryptographyPrimitives() m_AwsCryptographyPrimitivesTypes.Error {
	return _this.Get_().(Error_AwsCryptographyPrimitives).AwsCryptographyPrimitives
}

func (_this Error) Dtor_ComAmazonawsDynamodb() m_ComAmazonawsDynamodbTypes.Error {
	return _this.Get_().(Error_ComAmazonawsDynamodb).ComAmazonawsDynamodb
}

func (_this Error) Dtor_ComAmazonawsKms() m_ComAmazonawsKmsTypes.Error {
	return _this.Get_().(Error_ComAmazonawsKms).ComAmazonawsKms
}

func (_this Error) Dtor_list() _dafny.Sequence {
	return _this.Get_().(Error_CollectionOfErrors).List
}

func (_this Error) Dtor_obj() interface{} {
	switch data := _this.Get_().(type) {
	case Error_Opaque:
		return data.Obj
	default:
		return data.(Error_OpaqueWithText).Obj
	}
}

func (_this Error) Dtor_objMessage() _dafny.Sequence {
	return _this.Get_().(Error_OpaqueWithText).ObjMessage
}

func (_this Error) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Error_AwsCryptographicMaterialProvidersException:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.AwsCryptographicMaterialProvidersException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_EntryAlreadyExists:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.EntryAlreadyExists" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_EntryDoesNotExist:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.EntryDoesNotExist" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_InFlightTTLExceeded:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.InFlightTTLExceeded" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_InvalidAlgorithmSuiteInfo:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.InvalidAlgorithmSuiteInfo" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_InvalidAlgorithmSuiteInfoOnDecrypt:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.InvalidAlgorithmSuiteInfoOnDecrypt" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_InvalidAlgorithmSuiteInfoOnEncrypt:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.InvalidAlgorithmSuiteInfoOnEncrypt" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_InvalidDecryptionMaterials:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.InvalidDecryptionMaterials" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_InvalidDecryptionMaterialsTransition:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.InvalidDecryptionMaterialsTransition" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_InvalidEncryptionMaterials:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.InvalidEncryptionMaterials" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_InvalidEncryptionMaterialsTransition:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.InvalidEncryptionMaterialsTransition" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_AwsCryptographyKeyStore:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.AwsCryptographyKeyStore" + "(" + _dafny.String(data.AwsCryptographyKeyStore) + ")"
		}
	case Error_AwsCryptographyPrimitives:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.AwsCryptographyPrimitives" + "(" + _dafny.String(data.AwsCryptographyPrimitives) + ")"
		}
	case Error_ComAmazonawsDynamodb:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.ComAmazonawsDynamodb" + "(" + _dafny.String(data.ComAmazonawsDynamodb) + ")"
		}
	case Error_ComAmazonawsKms:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.ComAmazonawsKms" + "(" + _dafny.String(data.ComAmazonawsKms) + ")"
		}
	case Error_CollectionOfErrors:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.CollectionOfErrors" + "(" + _dafny.String(data.List) + ", " + _dafny.String(data.Message) + ")"
		}
	case Error_Opaque:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.Opaque" + "(" + _dafny.String(data.Obj) + ")"
		}
	case Error_OpaqueWithText:
		{
			return "AwsCryptographyMaterialProvidersTypes.Error.OpaqueWithText" + "(" + _dafny.String(data.Obj) + ", " + _dafny.String(data.ObjMessage) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Error) Equals(other Error) bool {
	switch data1 := _this.Get_().(type) {
	case Error_AwsCryptographicMaterialProvidersException:
		{
			data2, ok := other.Get_().(Error_AwsCryptographicMaterialProvidersException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_EntryAlreadyExists:
		{
			data2, ok := other.Get_().(Error_EntryAlreadyExists)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_EntryDoesNotExist:
		{
			data2, ok := other.Get_().(Error_EntryDoesNotExist)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_InFlightTTLExceeded:
		{
			data2, ok := other.Get_().(Error_InFlightTTLExceeded)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_InvalidAlgorithmSuiteInfo:
		{
			data2, ok := other.Get_().(Error_InvalidAlgorithmSuiteInfo)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_InvalidAlgorithmSuiteInfoOnDecrypt:
		{
			data2, ok := other.Get_().(Error_InvalidAlgorithmSuiteInfoOnDecrypt)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_InvalidAlgorithmSuiteInfoOnEncrypt:
		{
			data2, ok := other.Get_().(Error_InvalidAlgorithmSuiteInfoOnEncrypt)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_InvalidDecryptionMaterials:
		{
			data2, ok := other.Get_().(Error_InvalidDecryptionMaterials)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_InvalidDecryptionMaterialsTransition:
		{
			data2, ok := other.Get_().(Error_InvalidDecryptionMaterialsTransition)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_InvalidEncryptionMaterials:
		{
			data2, ok := other.Get_().(Error_InvalidEncryptionMaterials)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_InvalidEncryptionMaterialsTransition:
		{
			data2, ok := other.Get_().(Error_InvalidEncryptionMaterialsTransition)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_AwsCryptographyKeyStore:
		{
			data2, ok := other.Get_().(Error_AwsCryptographyKeyStore)
			return ok && data1.AwsCryptographyKeyStore.Equals(data2.AwsCryptographyKeyStore)
		}
	case Error_AwsCryptographyPrimitives:
		{
			data2, ok := other.Get_().(Error_AwsCryptographyPrimitives)
			return ok && data1.AwsCryptographyPrimitives.Equals(data2.AwsCryptographyPrimitives)
		}
	case Error_ComAmazonawsDynamodb:
		{
			data2, ok := other.Get_().(Error_ComAmazonawsDynamodb)
			return ok && data1.ComAmazonawsDynamodb.Equals(data2.ComAmazonawsDynamodb)
		}
	case Error_ComAmazonawsKms:
		{
			data2, ok := other.Get_().(Error_ComAmazonawsKms)
			return ok && data1.ComAmazonawsKms.Equals(data2.ComAmazonawsKms)
		}
	case Error_CollectionOfErrors:
		{
			data2, ok := other.Get_().(Error_CollectionOfErrors)
			return ok && data1.List.Equals(data2.List) && data1.Message.Equals(data2.Message)
		}
	case Error_Opaque:
		{
			data2, ok := other.Get_().(Error_Opaque)
			return ok && _dafny.AreEqual(data1.Obj, data2.Obj)
		}
	case Error_OpaqueWithText:
		{
			data2, ok := other.Get_().(Error_OpaqueWithText)
			return ok && _dafny.AreEqual(data1.Obj, data2.Obj) && data1.ObjMessage.Equals(data2.ObjMessage)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Error) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Error)
	return ok && _this.Equals(typed)
}

func Type_Error_() _dafny.TypeDescriptor {
	return type_Error_{}
}

type type_Error_ struct {
}

func (_this type_Error_) Default() interface{} {
	return Companion_Error_.Default()
}

func (_this type_Error_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.Error"
}
func (_this Error) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Error{}

// End of datatype Error

// Definition of class OpaqueError
type OpaqueError struct {
}

func New_OpaqueError_() *OpaqueError {
	_this := OpaqueError{}

	return &_this
}

type CompanionStruct_OpaqueError_ struct {
}

var Companion_OpaqueError_ = CompanionStruct_OpaqueError_{}

func (*OpaqueError) String() string {
	return "AwsCryptographyMaterialProvidersTypes.OpaqueError"
}

// End of class OpaqueError

func Type_OpaqueError_() _dafny.TypeDescriptor {
	return type_OpaqueError_{}
}

type type_OpaqueError_ struct {
}

func (_this type_OpaqueError_) Default() interface{} {
	return Companion_Error_.Default()
}

func (_this type_OpaqueError_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.OpaqueError"
}
func (_this *CompanionStruct_OpaqueError_) Is_(__source Error) bool {
	var _2_e Error = (__source)
	_ = _2_e
	return ((_2_e).Is_Opaque()) || ((_2_e).Is_OpaqueWithText())
}

// Definition of class DummySubsetType
type DummySubsetType struct {
}

func New_DummySubsetType_() *DummySubsetType {
	_this := DummySubsetType{}

	return &_this
}

type CompanionStruct_DummySubsetType_ struct {
}

var Companion_DummySubsetType_ = CompanionStruct_DummySubsetType_{}

func (*DummySubsetType) String() string {
	return "AwsCryptographyMaterialProvidersTypes.DummySubsetType"
}
func (_this *CompanionStruct_DummySubsetType_) Witness() _dafny.Int {
	return _dafny.One
}

// End of class DummySubsetType

func Type_DummySubsetType_() _dafny.TypeDescriptor {
	return type_DummySubsetType_{}
}

type type_DummySubsetType_ struct {
}

func (_this type_DummySubsetType_) Default() interface{} {
	return Companion_DummySubsetType_.Witness()
}

func (_this type_DummySubsetType_) String() string {
	return "AwsCryptographyMaterialProvidersTypes.DummySubsetType"
}
func (_this *CompanionStruct_DummySubsetType_) Is_(__source _dafny.Int) bool {
	var _3_x _dafny.Int = (__source)
	_ = _3_x
	return Companion_Default___.IsDummySubsetType(_3_x)
}
