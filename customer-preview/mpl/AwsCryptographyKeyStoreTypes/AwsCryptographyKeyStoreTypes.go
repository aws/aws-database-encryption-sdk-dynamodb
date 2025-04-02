// Package AwsCryptographyKeyStoreTypes
// Dafny module AwsCryptographyKeyStoreTypes compiled into Go

package AwsCryptographyKeyStoreTypes

import (
	os "os"

	m_ComAmazonawsDynamodbTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/ComAmazonawsDynamodbTypes"
	m_ComAmazonawsKmsTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/ComAmazonawsKmsTypes"
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
	return "AwsCryptographyKeyStoreTypes.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

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
			return "AwsCryptographyKeyStoreTypes.DafnyCallEvent.DafnyCallEvent" + "(" + _dafny.String(data.Input) + ", " + _dafny.String(data.Output) + ")"
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
	return "AwsCryptographyKeyStoreTypes.DafnyCallEvent"
}
func (_this DafnyCallEvent) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DafnyCallEvent{}

// End of datatype DafnyCallEvent

// Definition of datatype BeaconKeyMaterials
type BeaconKeyMaterials struct {
	Data_BeaconKeyMaterials_
}

func (_this BeaconKeyMaterials) Get_() Data_BeaconKeyMaterials_ {
	return _this.Data_BeaconKeyMaterials_
}

type Data_BeaconKeyMaterials_ interface {
	isBeaconKeyMaterials()
}

type CompanionStruct_BeaconKeyMaterials_ struct {
}

var Companion_BeaconKeyMaterials_ = CompanionStruct_BeaconKeyMaterials_{}

type BeaconKeyMaterials_BeaconKeyMaterials struct {
	BeaconKeyIdentifier _dafny.Sequence
	EncryptionContext   _dafny.Map
	BeaconKey           m_Wrappers.Option
	HmacKeys            m_Wrappers.Option
}

func (BeaconKeyMaterials_BeaconKeyMaterials) isBeaconKeyMaterials() {}

func (CompanionStruct_BeaconKeyMaterials_) Create_BeaconKeyMaterials_(BeaconKeyIdentifier _dafny.Sequence, EncryptionContext _dafny.Map, BeaconKey m_Wrappers.Option, HmacKeys m_Wrappers.Option) BeaconKeyMaterials {
	return BeaconKeyMaterials{BeaconKeyMaterials_BeaconKeyMaterials{BeaconKeyIdentifier, EncryptionContext, BeaconKey, HmacKeys}}
}

func (_this BeaconKeyMaterials) Is_BeaconKeyMaterials() bool {
	_, ok := _this.Get_().(BeaconKeyMaterials_BeaconKeyMaterials)
	return ok
}

func (CompanionStruct_BeaconKeyMaterials_) Default() BeaconKeyMaterials {
	return Companion_BeaconKeyMaterials_.Create_BeaconKeyMaterials_(_dafny.EmptySeq.SetString(), _dafny.EmptyMap, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this BeaconKeyMaterials) Dtor_beaconKeyIdentifier() _dafny.Sequence {
	return _this.Get_().(BeaconKeyMaterials_BeaconKeyMaterials).BeaconKeyIdentifier
}

func (_this BeaconKeyMaterials) Dtor_encryptionContext() _dafny.Map {
	return _this.Get_().(BeaconKeyMaterials_BeaconKeyMaterials).EncryptionContext
}

func (_this BeaconKeyMaterials) Dtor_beaconKey() m_Wrappers.Option {
	return _this.Get_().(BeaconKeyMaterials_BeaconKeyMaterials).BeaconKey
}

func (_this BeaconKeyMaterials) Dtor_hmacKeys() m_Wrappers.Option {
	return _this.Get_().(BeaconKeyMaterials_BeaconKeyMaterials).HmacKeys
}

func (_this BeaconKeyMaterials) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BeaconKeyMaterials_BeaconKeyMaterials:
		{
			return "AwsCryptographyKeyStoreTypes.BeaconKeyMaterials.BeaconKeyMaterials" + "(" + _dafny.String(data.BeaconKeyIdentifier) + ", " + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.BeaconKey) + ", " + _dafny.String(data.HmacKeys) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BeaconKeyMaterials) Equals(other BeaconKeyMaterials) bool {
	switch data1 := _this.Get_().(type) {
	case BeaconKeyMaterials_BeaconKeyMaterials:
		{
			data2, ok := other.Get_().(BeaconKeyMaterials_BeaconKeyMaterials)
			return ok && data1.BeaconKeyIdentifier.Equals(data2.BeaconKeyIdentifier) && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.BeaconKey.Equals(data2.BeaconKey) && data1.HmacKeys.Equals(data2.HmacKeys)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BeaconKeyMaterials) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BeaconKeyMaterials)
	return ok && _this.Equals(typed)
}

func Type_BeaconKeyMaterials_() _dafny.TypeDescriptor {
	return type_BeaconKeyMaterials_{}
}

type type_BeaconKeyMaterials_ struct {
}

func (_this type_BeaconKeyMaterials_) Default() interface{} {
	return Companion_BeaconKeyMaterials_.Default()
}

func (_this type_BeaconKeyMaterials_) String() string {
	return "AwsCryptographyKeyStoreTypes.BeaconKeyMaterials"
}
func (_this BeaconKeyMaterials) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BeaconKeyMaterials{}

// End of datatype BeaconKeyMaterials

// Definition of datatype BranchKeyMaterials
type BranchKeyMaterials struct {
	Data_BranchKeyMaterials_
}

func (_this BranchKeyMaterials) Get_() Data_BranchKeyMaterials_ {
	return _this.Data_BranchKeyMaterials_
}

type Data_BranchKeyMaterials_ interface {
	isBranchKeyMaterials()
}

type CompanionStruct_BranchKeyMaterials_ struct {
}

var Companion_BranchKeyMaterials_ = CompanionStruct_BranchKeyMaterials_{}

type BranchKeyMaterials_BranchKeyMaterials struct {
	BranchKeyIdentifier _dafny.Sequence
	BranchKeyVersion    _dafny.Sequence
	EncryptionContext   _dafny.Map
	BranchKey           _dafny.Sequence
}

func (BranchKeyMaterials_BranchKeyMaterials) isBranchKeyMaterials() {}

func (CompanionStruct_BranchKeyMaterials_) Create_BranchKeyMaterials_(BranchKeyIdentifier _dafny.Sequence, BranchKeyVersion _dafny.Sequence, EncryptionContext _dafny.Map, BranchKey _dafny.Sequence) BranchKeyMaterials {
	return BranchKeyMaterials{BranchKeyMaterials_BranchKeyMaterials{BranchKeyIdentifier, BranchKeyVersion, EncryptionContext, BranchKey}}
}

func (_this BranchKeyMaterials) Is_BranchKeyMaterials() bool {
	_, ok := _this.Get_().(BranchKeyMaterials_BranchKeyMaterials)
	return ok
}

func (CompanionStruct_BranchKeyMaterials_) Default() BranchKeyMaterials {
	return Companion_BranchKeyMaterials_.Create_BranchKeyMaterials_(_dafny.EmptySeq.SetString(), m_UTF8.Companion_ValidUTF8Bytes_.Witness(), _dafny.EmptyMap, _dafny.EmptySeq)
}

func (_this BranchKeyMaterials) Dtor_branchKeyIdentifier() _dafny.Sequence {
	return _this.Get_().(BranchKeyMaterials_BranchKeyMaterials).BranchKeyIdentifier
}

func (_this BranchKeyMaterials) Dtor_branchKeyVersion() _dafny.Sequence {
	return _this.Get_().(BranchKeyMaterials_BranchKeyMaterials).BranchKeyVersion
}

func (_this BranchKeyMaterials) Dtor_encryptionContext() _dafny.Map {
	return _this.Get_().(BranchKeyMaterials_BranchKeyMaterials).EncryptionContext
}

func (_this BranchKeyMaterials) Dtor_branchKey() _dafny.Sequence {
	return _this.Get_().(BranchKeyMaterials_BranchKeyMaterials).BranchKey
}

func (_this BranchKeyMaterials) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BranchKeyMaterials_BranchKeyMaterials:
		{
			return "AwsCryptographyKeyStoreTypes.BranchKeyMaterials.BranchKeyMaterials" + "(" + _dafny.String(data.BranchKeyIdentifier) + ", " + _dafny.String(data.BranchKeyVersion) + ", " + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.BranchKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BranchKeyMaterials) Equals(other BranchKeyMaterials) bool {
	switch data1 := _this.Get_().(type) {
	case BranchKeyMaterials_BranchKeyMaterials:
		{
			data2, ok := other.Get_().(BranchKeyMaterials_BranchKeyMaterials)
			return ok && data1.BranchKeyIdentifier.Equals(data2.BranchKeyIdentifier) && data1.BranchKeyVersion.Equals(data2.BranchKeyVersion) && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.BranchKey.Equals(data2.BranchKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BranchKeyMaterials) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BranchKeyMaterials)
	return ok && _this.Equals(typed)
}

func Type_BranchKeyMaterials_() _dafny.TypeDescriptor {
	return type_BranchKeyMaterials_{}
}

type type_BranchKeyMaterials_ struct {
}

func (_this type_BranchKeyMaterials_) Default() interface{} {
	return Companion_BranchKeyMaterials_.Default()
}

func (_this type_BranchKeyMaterials_) String() string {
	return "AwsCryptographyKeyStoreTypes.BranchKeyMaterials"
}
func (_this BranchKeyMaterials) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BranchKeyMaterials{}

// End of datatype BranchKeyMaterials

// Definition of datatype CreateKeyInput
type CreateKeyInput struct {
	Data_CreateKeyInput_
}

func (_this CreateKeyInput) Get_() Data_CreateKeyInput_ {
	return _this.Data_CreateKeyInput_
}

type Data_CreateKeyInput_ interface {
	isCreateKeyInput()
}

type CompanionStruct_CreateKeyInput_ struct {
}

var Companion_CreateKeyInput_ = CompanionStruct_CreateKeyInput_{}

type CreateKeyInput_CreateKeyInput struct {
	BranchKeyIdentifier m_Wrappers.Option
	EncryptionContext   m_Wrappers.Option
}

func (CreateKeyInput_CreateKeyInput) isCreateKeyInput() {}

func (CompanionStruct_CreateKeyInput_) Create_CreateKeyInput_(BranchKeyIdentifier m_Wrappers.Option, EncryptionContext m_Wrappers.Option) CreateKeyInput {
	return CreateKeyInput{CreateKeyInput_CreateKeyInput{BranchKeyIdentifier, EncryptionContext}}
}

func (_this CreateKeyInput) Is_CreateKeyInput() bool {
	_, ok := _this.Get_().(CreateKeyInput_CreateKeyInput)
	return ok
}

func (CompanionStruct_CreateKeyInput_) Default() CreateKeyInput {
	return Companion_CreateKeyInput_.Create_CreateKeyInput_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this CreateKeyInput) Dtor_branchKeyIdentifier() m_Wrappers.Option {
	return _this.Get_().(CreateKeyInput_CreateKeyInput).BranchKeyIdentifier
}

func (_this CreateKeyInput) Dtor_encryptionContext() m_Wrappers.Option {
	return _this.Get_().(CreateKeyInput_CreateKeyInput).EncryptionContext
}

func (_this CreateKeyInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateKeyInput_CreateKeyInput:
		{
			return "AwsCryptographyKeyStoreTypes.CreateKeyInput.CreateKeyInput" + "(" + _dafny.String(data.BranchKeyIdentifier) + ", " + _dafny.String(data.EncryptionContext) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateKeyInput) Equals(other CreateKeyInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateKeyInput_CreateKeyInput:
		{
			data2, ok := other.Get_().(CreateKeyInput_CreateKeyInput)
			return ok && data1.BranchKeyIdentifier.Equals(data2.BranchKeyIdentifier) && data1.EncryptionContext.Equals(data2.EncryptionContext)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateKeyInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateKeyInput)
	return ok && _this.Equals(typed)
}

func Type_CreateKeyInput_() _dafny.TypeDescriptor {
	return type_CreateKeyInput_{}
}

type type_CreateKeyInput_ struct {
}

func (_this type_CreateKeyInput_) Default() interface{} {
	return Companion_CreateKeyInput_.Default()
}

func (_this type_CreateKeyInput_) String() string {
	return "AwsCryptographyKeyStoreTypes.CreateKeyInput"
}
func (_this CreateKeyInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateKeyInput{}

// End of datatype CreateKeyInput

// Definition of datatype CreateKeyOutput
type CreateKeyOutput struct {
	Data_CreateKeyOutput_
}

func (_this CreateKeyOutput) Get_() Data_CreateKeyOutput_ {
	return _this.Data_CreateKeyOutput_
}

type Data_CreateKeyOutput_ interface {
	isCreateKeyOutput()
}

type CompanionStruct_CreateKeyOutput_ struct {
}

var Companion_CreateKeyOutput_ = CompanionStruct_CreateKeyOutput_{}

type CreateKeyOutput_CreateKeyOutput struct {
	BranchKeyIdentifier _dafny.Sequence
}

func (CreateKeyOutput_CreateKeyOutput) isCreateKeyOutput() {}

func (CompanionStruct_CreateKeyOutput_) Create_CreateKeyOutput_(BranchKeyIdentifier _dafny.Sequence) CreateKeyOutput {
	return CreateKeyOutput{CreateKeyOutput_CreateKeyOutput{BranchKeyIdentifier}}
}

func (_this CreateKeyOutput) Is_CreateKeyOutput() bool {
	_, ok := _this.Get_().(CreateKeyOutput_CreateKeyOutput)
	return ok
}

func (CompanionStruct_CreateKeyOutput_) Default() CreateKeyOutput {
	return Companion_CreateKeyOutput_.Create_CreateKeyOutput_(_dafny.EmptySeq.SetString())
}

func (_this CreateKeyOutput) Dtor_branchKeyIdentifier() _dafny.Sequence {
	return _this.Get_().(CreateKeyOutput_CreateKeyOutput).BranchKeyIdentifier
}

func (_this CreateKeyOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateKeyOutput_CreateKeyOutput:
		{
			return "AwsCryptographyKeyStoreTypes.CreateKeyOutput.CreateKeyOutput" + "(" + _dafny.String(data.BranchKeyIdentifier) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateKeyOutput) Equals(other CreateKeyOutput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateKeyOutput_CreateKeyOutput:
		{
			data2, ok := other.Get_().(CreateKeyOutput_CreateKeyOutput)
			return ok && data1.BranchKeyIdentifier.Equals(data2.BranchKeyIdentifier)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateKeyOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateKeyOutput)
	return ok && _this.Equals(typed)
}

func Type_CreateKeyOutput_() _dafny.TypeDescriptor {
	return type_CreateKeyOutput_{}
}

type type_CreateKeyOutput_ struct {
}

func (_this type_CreateKeyOutput_) Default() interface{} {
	return Companion_CreateKeyOutput_.Default()
}

func (_this type_CreateKeyOutput_) String() string {
	return "AwsCryptographyKeyStoreTypes.CreateKeyOutput"
}
func (_this CreateKeyOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateKeyOutput{}

// End of datatype CreateKeyOutput

// Definition of datatype CreateKeyStoreInput
type CreateKeyStoreInput struct {
	Data_CreateKeyStoreInput_
}

func (_this CreateKeyStoreInput) Get_() Data_CreateKeyStoreInput_ {
	return _this.Data_CreateKeyStoreInput_
}

type Data_CreateKeyStoreInput_ interface {
	isCreateKeyStoreInput()
}

type CompanionStruct_CreateKeyStoreInput_ struct {
}

var Companion_CreateKeyStoreInput_ = CompanionStruct_CreateKeyStoreInput_{}

type CreateKeyStoreInput_CreateKeyStoreInput struct {
}

func (CreateKeyStoreInput_CreateKeyStoreInput) isCreateKeyStoreInput() {}

func (CompanionStruct_CreateKeyStoreInput_) Create_CreateKeyStoreInput_() CreateKeyStoreInput {
	return CreateKeyStoreInput{CreateKeyStoreInput_CreateKeyStoreInput{}}
}

func (_this CreateKeyStoreInput) Is_CreateKeyStoreInput() bool {
	_, ok := _this.Get_().(CreateKeyStoreInput_CreateKeyStoreInput)
	return ok
}

func (CompanionStruct_CreateKeyStoreInput_) Default() CreateKeyStoreInput {
	return Companion_CreateKeyStoreInput_.Create_CreateKeyStoreInput_()
}

func (_ CompanionStruct_CreateKeyStoreInput_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_CreateKeyStoreInput_.Create_CreateKeyStoreInput_(), true
		default:
			return CreateKeyStoreInput{}, false
		}
	}
}

func (_this CreateKeyStoreInput) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case CreateKeyStoreInput_CreateKeyStoreInput:
		{
			return "AwsCryptographyKeyStoreTypes.CreateKeyStoreInput.CreateKeyStoreInput"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateKeyStoreInput) Equals(other CreateKeyStoreInput) bool {
	switch _this.Get_().(type) {
	case CreateKeyStoreInput_CreateKeyStoreInput:
		{
			_, ok := other.Get_().(CreateKeyStoreInput_CreateKeyStoreInput)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateKeyStoreInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateKeyStoreInput)
	return ok && _this.Equals(typed)
}

func Type_CreateKeyStoreInput_() _dafny.TypeDescriptor {
	return type_CreateKeyStoreInput_{}
}

type type_CreateKeyStoreInput_ struct {
}

func (_this type_CreateKeyStoreInput_) Default() interface{} {
	return Companion_CreateKeyStoreInput_.Default()
}

func (_this type_CreateKeyStoreInput_) String() string {
	return "AwsCryptographyKeyStoreTypes.CreateKeyStoreInput"
}
func (_this CreateKeyStoreInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateKeyStoreInput{}

// End of datatype CreateKeyStoreInput

// Definition of datatype CreateKeyStoreOutput
type CreateKeyStoreOutput struct {
	Data_CreateKeyStoreOutput_
}

func (_this CreateKeyStoreOutput) Get_() Data_CreateKeyStoreOutput_ {
	return _this.Data_CreateKeyStoreOutput_
}

type Data_CreateKeyStoreOutput_ interface {
	isCreateKeyStoreOutput()
}

type CompanionStruct_CreateKeyStoreOutput_ struct {
}

var Companion_CreateKeyStoreOutput_ = CompanionStruct_CreateKeyStoreOutput_{}

type CreateKeyStoreOutput_CreateKeyStoreOutput struct {
	TableArn _dafny.Sequence
}

func (CreateKeyStoreOutput_CreateKeyStoreOutput) isCreateKeyStoreOutput() {}

func (CompanionStruct_CreateKeyStoreOutput_) Create_CreateKeyStoreOutput_(TableArn _dafny.Sequence) CreateKeyStoreOutput {
	return CreateKeyStoreOutput{CreateKeyStoreOutput_CreateKeyStoreOutput{TableArn}}
}

func (_this CreateKeyStoreOutput) Is_CreateKeyStoreOutput() bool {
	_, ok := _this.Get_().(CreateKeyStoreOutput_CreateKeyStoreOutput)
	return ok
}

func (CompanionStruct_CreateKeyStoreOutput_) Default() CreateKeyStoreOutput {
	return Companion_CreateKeyStoreOutput_.Create_CreateKeyStoreOutput_(_dafny.EmptySeq.SetString())
}

func (_this CreateKeyStoreOutput) Dtor_tableArn() _dafny.Sequence {
	return _this.Get_().(CreateKeyStoreOutput_CreateKeyStoreOutput).TableArn
}

func (_this CreateKeyStoreOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateKeyStoreOutput_CreateKeyStoreOutput:
		{
			return "AwsCryptographyKeyStoreTypes.CreateKeyStoreOutput.CreateKeyStoreOutput" + "(" + _dafny.String(data.TableArn) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateKeyStoreOutput) Equals(other CreateKeyStoreOutput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateKeyStoreOutput_CreateKeyStoreOutput:
		{
			data2, ok := other.Get_().(CreateKeyStoreOutput_CreateKeyStoreOutput)
			return ok && data1.TableArn.Equals(data2.TableArn)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateKeyStoreOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateKeyStoreOutput)
	return ok && _this.Equals(typed)
}

func Type_CreateKeyStoreOutput_() _dafny.TypeDescriptor {
	return type_CreateKeyStoreOutput_{}
}

type type_CreateKeyStoreOutput_ struct {
}

func (_this type_CreateKeyStoreOutput_) Default() interface{} {
	return Companion_CreateKeyStoreOutput_.Default()
}

func (_this type_CreateKeyStoreOutput_) String() string {
	return "AwsCryptographyKeyStoreTypes.CreateKeyStoreOutput"
}
func (_this CreateKeyStoreOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateKeyStoreOutput{}

// End of datatype CreateKeyStoreOutput

// Definition of datatype Discovery
type Discovery struct {
	Data_Discovery_
}

func (_this Discovery) Get_() Data_Discovery_ {
	return _this.Data_Discovery_
}

type Data_Discovery_ interface {
	isDiscovery()
}

type CompanionStruct_Discovery_ struct {
}

var Companion_Discovery_ = CompanionStruct_Discovery_{}

type Discovery_Discovery struct {
}

func (Discovery_Discovery) isDiscovery() {}

func (CompanionStruct_Discovery_) Create_Discovery_() Discovery {
	return Discovery{Discovery_Discovery{}}
}

func (_this Discovery) Is_Discovery() bool {
	_, ok := _this.Get_().(Discovery_Discovery)
	return ok
}

func (CompanionStruct_Discovery_) Default() Discovery {
	return Companion_Discovery_.Create_Discovery_()
}

func (_ CompanionStruct_Discovery_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_Discovery_.Create_Discovery_(), true
		default:
			return Discovery{}, false
		}
	}
}

func (_this Discovery) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case Discovery_Discovery:
		{
			return "AwsCryptographyKeyStoreTypes.Discovery.Discovery"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Discovery) Equals(other Discovery) bool {
	switch _this.Get_().(type) {
	case Discovery_Discovery:
		{
			_, ok := other.Get_().(Discovery_Discovery)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Discovery) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Discovery)
	return ok && _this.Equals(typed)
}

func Type_Discovery_() _dafny.TypeDescriptor {
	return type_Discovery_{}
}

type type_Discovery_ struct {
}

func (_this type_Discovery_) Default() interface{} {
	return Companion_Discovery_.Default()
}

func (_this type_Discovery_) String() string {
	return "AwsCryptographyKeyStoreTypes.Discovery"
}
func (_this Discovery) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Discovery{}

// End of datatype Discovery

// Definition of datatype GetActiveBranchKeyInput
type GetActiveBranchKeyInput struct {
	Data_GetActiveBranchKeyInput_
}

func (_this GetActiveBranchKeyInput) Get_() Data_GetActiveBranchKeyInput_ {
	return _this.Data_GetActiveBranchKeyInput_
}

type Data_GetActiveBranchKeyInput_ interface {
	isGetActiveBranchKeyInput()
}

type CompanionStruct_GetActiveBranchKeyInput_ struct {
}

var Companion_GetActiveBranchKeyInput_ = CompanionStruct_GetActiveBranchKeyInput_{}

type GetActiveBranchKeyInput_GetActiveBranchKeyInput struct {
	BranchKeyIdentifier _dafny.Sequence
}

func (GetActiveBranchKeyInput_GetActiveBranchKeyInput) isGetActiveBranchKeyInput() {}

func (CompanionStruct_GetActiveBranchKeyInput_) Create_GetActiveBranchKeyInput_(BranchKeyIdentifier _dafny.Sequence) GetActiveBranchKeyInput {
	return GetActiveBranchKeyInput{GetActiveBranchKeyInput_GetActiveBranchKeyInput{BranchKeyIdentifier}}
}

func (_this GetActiveBranchKeyInput) Is_GetActiveBranchKeyInput() bool {
	_, ok := _this.Get_().(GetActiveBranchKeyInput_GetActiveBranchKeyInput)
	return ok
}

func (CompanionStruct_GetActiveBranchKeyInput_) Default() GetActiveBranchKeyInput {
	return Companion_GetActiveBranchKeyInput_.Create_GetActiveBranchKeyInput_(_dafny.EmptySeq.SetString())
}

func (_this GetActiveBranchKeyInput) Dtor_branchKeyIdentifier() _dafny.Sequence {
	return _this.Get_().(GetActiveBranchKeyInput_GetActiveBranchKeyInput).BranchKeyIdentifier
}

func (_this GetActiveBranchKeyInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetActiveBranchKeyInput_GetActiveBranchKeyInput:
		{
			return "AwsCryptographyKeyStoreTypes.GetActiveBranchKeyInput.GetActiveBranchKeyInput" + "(" + _dafny.String(data.BranchKeyIdentifier) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetActiveBranchKeyInput) Equals(other GetActiveBranchKeyInput) bool {
	switch data1 := _this.Get_().(type) {
	case GetActiveBranchKeyInput_GetActiveBranchKeyInput:
		{
			data2, ok := other.Get_().(GetActiveBranchKeyInput_GetActiveBranchKeyInput)
			return ok && data1.BranchKeyIdentifier.Equals(data2.BranchKeyIdentifier)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetActiveBranchKeyInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetActiveBranchKeyInput)
	return ok && _this.Equals(typed)
}

func Type_GetActiveBranchKeyInput_() _dafny.TypeDescriptor {
	return type_GetActiveBranchKeyInput_{}
}

type type_GetActiveBranchKeyInput_ struct {
}

func (_this type_GetActiveBranchKeyInput_) Default() interface{} {
	return Companion_GetActiveBranchKeyInput_.Default()
}

func (_this type_GetActiveBranchKeyInput_) String() string {
	return "AwsCryptographyKeyStoreTypes.GetActiveBranchKeyInput"
}
func (_this GetActiveBranchKeyInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetActiveBranchKeyInput{}

// End of datatype GetActiveBranchKeyInput

// Definition of datatype GetActiveBranchKeyOutput
type GetActiveBranchKeyOutput struct {
	Data_GetActiveBranchKeyOutput_
}

func (_this GetActiveBranchKeyOutput) Get_() Data_GetActiveBranchKeyOutput_ {
	return _this.Data_GetActiveBranchKeyOutput_
}

type Data_GetActiveBranchKeyOutput_ interface {
	isGetActiveBranchKeyOutput()
}

type CompanionStruct_GetActiveBranchKeyOutput_ struct {
}

var Companion_GetActiveBranchKeyOutput_ = CompanionStruct_GetActiveBranchKeyOutput_{}

type GetActiveBranchKeyOutput_GetActiveBranchKeyOutput struct {
	BranchKeyMaterials BranchKeyMaterials
}

func (GetActiveBranchKeyOutput_GetActiveBranchKeyOutput) isGetActiveBranchKeyOutput() {}

func (CompanionStruct_GetActiveBranchKeyOutput_) Create_GetActiveBranchKeyOutput_(BranchKeyMaterials BranchKeyMaterials) GetActiveBranchKeyOutput {
	return GetActiveBranchKeyOutput{GetActiveBranchKeyOutput_GetActiveBranchKeyOutput{BranchKeyMaterials}}
}

func (_this GetActiveBranchKeyOutput) Is_GetActiveBranchKeyOutput() bool {
	_, ok := _this.Get_().(GetActiveBranchKeyOutput_GetActiveBranchKeyOutput)
	return ok
}

func (CompanionStruct_GetActiveBranchKeyOutput_) Default() GetActiveBranchKeyOutput {
	return Companion_GetActiveBranchKeyOutput_.Create_GetActiveBranchKeyOutput_(Companion_BranchKeyMaterials_.Default())
}

func (_this GetActiveBranchKeyOutput) Dtor_branchKeyMaterials() BranchKeyMaterials {
	return _this.Get_().(GetActiveBranchKeyOutput_GetActiveBranchKeyOutput).BranchKeyMaterials
}

func (_this GetActiveBranchKeyOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetActiveBranchKeyOutput_GetActiveBranchKeyOutput:
		{
			return "AwsCryptographyKeyStoreTypes.GetActiveBranchKeyOutput.GetActiveBranchKeyOutput" + "(" + _dafny.String(data.BranchKeyMaterials) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetActiveBranchKeyOutput) Equals(other GetActiveBranchKeyOutput) bool {
	switch data1 := _this.Get_().(type) {
	case GetActiveBranchKeyOutput_GetActiveBranchKeyOutput:
		{
			data2, ok := other.Get_().(GetActiveBranchKeyOutput_GetActiveBranchKeyOutput)
			return ok && data1.BranchKeyMaterials.Equals(data2.BranchKeyMaterials)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetActiveBranchKeyOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetActiveBranchKeyOutput)
	return ok && _this.Equals(typed)
}

func Type_GetActiveBranchKeyOutput_() _dafny.TypeDescriptor {
	return type_GetActiveBranchKeyOutput_{}
}

type type_GetActiveBranchKeyOutput_ struct {
}

func (_this type_GetActiveBranchKeyOutput_) Default() interface{} {
	return Companion_GetActiveBranchKeyOutput_.Default()
}

func (_this type_GetActiveBranchKeyOutput_) String() string {
	return "AwsCryptographyKeyStoreTypes.GetActiveBranchKeyOutput"
}
func (_this GetActiveBranchKeyOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetActiveBranchKeyOutput{}

// End of datatype GetActiveBranchKeyOutput

// Definition of datatype GetBeaconKeyInput
type GetBeaconKeyInput struct {
	Data_GetBeaconKeyInput_
}

func (_this GetBeaconKeyInput) Get_() Data_GetBeaconKeyInput_ {
	return _this.Data_GetBeaconKeyInput_
}

type Data_GetBeaconKeyInput_ interface {
	isGetBeaconKeyInput()
}

type CompanionStruct_GetBeaconKeyInput_ struct {
}

var Companion_GetBeaconKeyInput_ = CompanionStruct_GetBeaconKeyInput_{}

type GetBeaconKeyInput_GetBeaconKeyInput struct {
	BranchKeyIdentifier _dafny.Sequence
}

func (GetBeaconKeyInput_GetBeaconKeyInput) isGetBeaconKeyInput() {}

func (CompanionStruct_GetBeaconKeyInput_) Create_GetBeaconKeyInput_(BranchKeyIdentifier _dafny.Sequence) GetBeaconKeyInput {
	return GetBeaconKeyInput{GetBeaconKeyInput_GetBeaconKeyInput{BranchKeyIdentifier}}
}

func (_this GetBeaconKeyInput) Is_GetBeaconKeyInput() bool {
	_, ok := _this.Get_().(GetBeaconKeyInput_GetBeaconKeyInput)
	return ok
}

func (CompanionStruct_GetBeaconKeyInput_) Default() GetBeaconKeyInput {
	return Companion_GetBeaconKeyInput_.Create_GetBeaconKeyInput_(_dafny.EmptySeq.SetString())
}

func (_this GetBeaconKeyInput) Dtor_branchKeyIdentifier() _dafny.Sequence {
	return _this.Get_().(GetBeaconKeyInput_GetBeaconKeyInput).BranchKeyIdentifier
}

func (_this GetBeaconKeyInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetBeaconKeyInput_GetBeaconKeyInput:
		{
			return "AwsCryptographyKeyStoreTypes.GetBeaconKeyInput.GetBeaconKeyInput" + "(" + _dafny.String(data.BranchKeyIdentifier) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetBeaconKeyInput) Equals(other GetBeaconKeyInput) bool {
	switch data1 := _this.Get_().(type) {
	case GetBeaconKeyInput_GetBeaconKeyInput:
		{
			data2, ok := other.Get_().(GetBeaconKeyInput_GetBeaconKeyInput)
			return ok && data1.BranchKeyIdentifier.Equals(data2.BranchKeyIdentifier)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetBeaconKeyInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetBeaconKeyInput)
	return ok && _this.Equals(typed)
}

func Type_GetBeaconKeyInput_() _dafny.TypeDescriptor {
	return type_GetBeaconKeyInput_{}
}

type type_GetBeaconKeyInput_ struct {
}

func (_this type_GetBeaconKeyInput_) Default() interface{} {
	return Companion_GetBeaconKeyInput_.Default()
}

func (_this type_GetBeaconKeyInput_) String() string {
	return "AwsCryptographyKeyStoreTypes.GetBeaconKeyInput"
}
func (_this GetBeaconKeyInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetBeaconKeyInput{}

// End of datatype GetBeaconKeyInput

// Definition of datatype GetBeaconKeyOutput
type GetBeaconKeyOutput struct {
	Data_GetBeaconKeyOutput_
}

func (_this GetBeaconKeyOutput) Get_() Data_GetBeaconKeyOutput_ {
	return _this.Data_GetBeaconKeyOutput_
}

type Data_GetBeaconKeyOutput_ interface {
	isGetBeaconKeyOutput()
}

type CompanionStruct_GetBeaconKeyOutput_ struct {
}

var Companion_GetBeaconKeyOutput_ = CompanionStruct_GetBeaconKeyOutput_{}

type GetBeaconKeyOutput_GetBeaconKeyOutput struct {
	BeaconKeyMaterials BeaconKeyMaterials
}

func (GetBeaconKeyOutput_GetBeaconKeyOutput) isGetBeaconKeyOutput() {}

func (CompanionStruct_GetBeaconKeyOutput_) Create_GetBeaconKeyOutput_(BeaconKeyMaterials BeaconKeyMaterials) GetBeaconKeyOutput {
	return GetBeaconKeyOutput{GetBeaconKeyOutput_GetBeaconKeyOutput{BeaconKeyMaterials}}
}

func (_this GetBeaconKeyOutput) Is_GetBeaconKeyOutput() bool {
	_, ok := _this.Get_().(GetBeaconKeyOutput_GetBeaconKeyOutput)
	return ok
}

func (CompanionStruct_GetBeaconKeyOutput_) Default() GetBeaconKeyOutput {
	return Companion_GetBeaconKeyOutput_.Create_GetBeaconKeyOutput_(Companion_BeaconKeyMaterials_.Default())
}

func (_this GetBeaconKeyOutput) Dtor_beaconKeyMaterials() BeaconKeyMaterials {
	return _this.Get_().(GetBeaconKeyOutput_GetBeaconKeyOutput).BeaconKeyMaterials
}

func (_this GetBeaconKeyOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetBeaconKeyOutput_GetBeaconKeyOutput:
		{
			return "AwsCryptographyKeyStoreTypes.GetBeaconKeyOutput.GetBeaconKeyOutput" + "(" + _dafny.String(data.BeaconKeyMaterials) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetBeaconKeyOutput) Equals(other GetBeaconKeyOutput) bool {
	switch data1 := _this.Get_().(type) {
	case GetBeaconKeyOutput_GetBeaconKeyOutput:
		{
			data2, ok := other.Get_().(GetBeaconKeyOutput_GetBeaconKeyOutput)
			return ok && data1.BeaconKeyMaterials.Equals(data2.BeaconKeyMaterials)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetBeaconKeyOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetBeaconKeyOutput)
	return ok && _this.Equals(typed)
}

func Type_GetBeaconKeyOutput_() _dafny.TypeDescriptor {
	return type_GetBeaconKeyOutput_{}
}

type type_GetBeaconKeyOutput_ struct {
}

func (_this type_GetBeaconKeyOutput_) Default() interface{} {
	return Companion_GetBeaconKeyOutput_.Default()
}

func (_this type_GetBeaconKeyOutput_) String() string {
	return "AwsCryptographyKeyStoreTypes.GetBeaconKeyOutput"
}
func (_this GetBeaconKeyOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetBeaconKeyOutput{}

// End of datatype GetBeaconKeyOutput

// Definition of datatype GetBranchKeyVersionInput
type GetBranchKeyVersionInput struct {
	Data_GetBranchKeyVersionInput_
}

func (_this GetBranchKeyVersionInput) Get_() Data_GetBranchKeyVersionInput_ {
	return _this.Data_GetBranchKeyVersionInput_
}

type Data_GetBranchKeyVersionInput_ interface {
	isGetBranchKeyVersionInput()
}

type CompanionStruct_GetBranchKeyVersionInput_ struct {
}

var Companion_GetBranchKeyVersionInput_ = CompanionStruct_GetBranchKeyVersionInput_{}

type GetBranchKeyVersionInput_GetBranchKeyVersionInput struct {
	BranchKeyIdentifier _dafny.Sequence
	BranchKeyVersion    _dafny.Sequence
}

func (GetBranchKeyVersionInput_GetBranchKeyVersionInput) isGetBranchKeyVersionInput() {}

func (CompanionStruct_GetBranchKeyVersionInput_) Create_GetBranchKeyVersionInput_(BranchKeyIdentifier _dafny.Sequence, BranchKeyVersion _dafny.Sequence) GetBranchKeyVersionInput {
	return GetBranchKeyVersionInput{GetBranchKeyVersionInput_GetBranchKeyVersionInput{BranchKeyIdentifier, BranchKeyVersion}}
}

func (_this GetBranchKeyVersionInput) Is_GetBranchKeyVersionInput() bool {
	_, ok := _this.Get_().(GetBranchKeyVersionInput_GetBranchKeyVersionInput)
	return ok
}

func (CompanionStruct_GetBranchKeyVersionInput_) Default() GetBranchKeyVersionInput {
	return Companion_GetBranchKeyVersionInput_.Create_GetBranchKeyVersionInput_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString())
}

func (_this GetBranchKeyVersionInput) Dtor_branchKeyIdentifier() _dafny.Sequence {
	return _this.Get_().(GetBranchKeyVersionInput_GetBranchKeyVersionInput).BranchKeyIdentifier
}

func (_this GetBranchKeyVersionInput) Dtor_branchKeyVersion() _dafny.Sequence {
	return _this.Get_().(GetBranchKeyVersionInput_GetBranchKeyVersionInput).BranchKeyVersion
}

func (_this GetBranchKeyVersionInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetBranchKeyVersionInput_GetBranchKeyVersionInput:
		{
			return "AwsCryptographyKeyStoreTypes.GetBranchKeyVersionInput.GetBranchKeyVersionInput" + "(" + _dafny.String(data.BranchKeyIdentifier) + ", " + _dafny.String(data.BranchKeyVersion) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetBranchKeyVersionInput) Equals(other GetBranchKeyVersionInput) bool {
	switch data1 := _this.Get_().(type) {
	case GetBranchKeyVersionInput_GetBranchKeyVersionInput:
		{
			data2, ok := other.Get_().(GetBranchKeyVersionInput_GetBranchKeyVersionInput)
			return ok && data1.BranchKeyIdentifier.Equals(data2.BranchKeyIdentifier) && data1.BranchKeyVersion.Equals(data2.BranchKeyVersion)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetBranchKeyVersionInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetBranchKeyVersionInput)
	return ok && _this.Equals(typed)
}

func Type_GetBranchKeyVersionInput_() _dafny.TypeDescriptor {
	return type_GetBranchKeyVersionInput_{}
}

type type_GetBranchKeyVersionInput_ struct {
}

func (_this type_GetBranchKeyVersionInput_) Default() interface{} {
	return Companion_GetBranchKeyVersionInput_.Default()
}

func (_this type_GetBranchKeyVersionInput_) String() string {
	return "AwsCryptographyKeyStoreTypes.GetBranchKeyVersionInput"
}
func (_this GetBranchKeyVersionInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetBranchKeyVersionInput{}

// End of datatype GetBranchKeyVersionInput

// Definition of datatype GetBranchKeyVersionOutput
type GetBranchKeyVersionOutput struct {
	Data_GetBranchKeyVersionOutput_
}

func (_this GetBranchKeyVersionOutput) Get_() Data_GetBranchKeyVersionOutput_ {
	return _this.Data_GetBranchKeyVersionOutput_
}

type Data_GetBranchKeyVersionOutput_ interface {
	isGetBranchKeyVersionOutput()
}

type CompanionStruct_GetBranchKeyVersionOutput_ struct {
}

var Companion_GetBranchKeyVersionOutput_ = CompanionStruct_GetBranchKeyVersionOutput_{}

type GetBranchKeyVersionOutput_GetBranchKeyVersionOutput struct {
	BranchKeyMaterials BranchKeyMaterials
}

func (GetBranchKeyVersionOutput_GetBranchKeyVersionOutput) isGetBranchKeyVersionOutput() {}

func (CompanionStruct_GetBranchKeyVersionOutput_) Create_GetBranchKeyVersionOutput_(BranchKeyMaterials BranchKeyMaterials) GetBranchKeyVersionOutput {
	return GetBranchKeyVersionOutput{GetBranchKeyVersionOutput_GetBranchKeyVersionOutput{BranchKeyMaterials}}
}

func (_this GetBranchKeyVersionOutput) Is_GetBranchKeyVersionOutput() bool {
	_, ok := _this.Get_().(GetBranchKeyVersionOutput_GetBranchKeyVersionOutput)
	return ok
}

func (CompanionStruct_GetBranchKeyVersionOutput_) Default() GetBranchKeyVersionOutput {
	return Companion_GetBranchKeyVersionOutput_.Create_GetBranchKeyVersionOutput_(Companion_BranchKeyMaterials_.Default())
}

func (_this GetBranchKeyVersionOutput) Dtor_branchKeyMaterials() BranchKeyMaterials {
	return _this.Get_().(GetBranchKeyVersionOutput_GetBranchKeyVersionOutput).BranchKeyMaterials
}

func (_this GetBranchKeyVersionOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetBranchKeyVersionOutput_GetBranchKeyVersionOutput:
		{
			return "AwsCryptographyKeyStoreTypes.GetBranchKeyVersionOutput.GetBranchKeyVersionOutput" + "(" + _dafny.String(data.BranchKeyMaterials) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetBranchKeyVersionOutput) Equals(other GetBranchKeyVersionOutput) bool {
	switch data1 := _this.Get_().(type) {
	case GetBranchKeyVersionOutput_GetBranchKeyVersionOutput:
		{
			data2, ok := other.Get_().(GetBranchKeyVersionOutput_GetBranchKeyVersionOutput)
			return ok && data1.BranchKeyMaterials.Equals(data2.BranchKeyMaterials)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetBranchKeyVersionOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetBranchKeyVersionOutput)
	return ok && _this.Equals(typed)
}

func Type_GetBranchKeyVersionOutput_() _dafny.TypeDescriptor {
	return type_GetBranchKeyVersionOutput_{}
}

type type_GetBranchKeyVersionOutput_ struct {
}

func (_this type_GetBranchKeyVersionOutput_) Default() interface{} {
	return Companion_GetBranchKeyVersionOutput_.Default()
}

func (_this type_GetBranchKeyVersionOutput_) String() string {
	return "AwsCryptographyKeyStoreTypes.GetBranchKeyVersionOutput"
}
func (_this GetBranchKeyVersionOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetBranchKeyVersionOutput{}

// End of datatype GetBranchKeyVersionOutput

// Definition of datatype GetKeyStoreInfoOutput
type GetKeyStoreInfoOutput struct {
	Data_GetKeyStoreInfoOutput_
}

func (_this GetKeyStoreInfoOutput) Get_() Data_GetKeyStoreInfoOutput_ {
	return _this.Data_GetKeyStoreInfoOutput_
}

type Data_GetKeyStoreInfoOutput_ interface {
	isGetKeyStoreInfoOutput()
}

type CompanionStruct_GetKeyStoreInfoOutput_ struct {
}

var Companion_GetKeyStoreInfoOutput_ = CompanionStruct_GetKeyStoreInfoOutput_{}

type GetKeyStoreInfoOutput_GetKeyStoreInfoOutput struct {
	KeyStoreId          _dafny.Sequence
	KeyStoreName        _dafny.Sequence
	LogicalKeyStoreName _dafny.Sequence
	GrantTokens         _dafny.Sequence
	KmsConfiguration    KMSConfiguration
}

func (GetKeyStoreInfoOutput_GetKeyStoreInfoOutput) isGetKeyStoreInfoOutput() {}

func (CompanionStruct_GetKeyStoreInfoOutput_) Create_GetKeyStoreInfoOutput_(KeyStoreId _dafny.Sequence, KeyStoreName _dafny.Sequence, LogicalKeyStoreName _dafny.Sequence, GrantTokens _dafny.Sequence, KmsConfiguration KMSConfiguration) GetKeyStoreInfoOutput {
	return GetKeyStoreInfoOutput{GetKeyStoreInfoOutput_GetKeyStoreInfoOutput{KeyStoreId, KeyStoreName, LogicalKeyStoreName, GrantTokens, KmsConfiguration}}
}

func (_this GetKeyStoreInfoOutput) Is_GetKeyStoreInfoOutput() bool {
	_, ok := _this.Get_().(GetKeyStoreInfoOutput_GetKeyStoreInfoOutput)
	return ok
}

func (CompanionStruct_GetKeyStoreInfoOutput_) Default() GetKeyStoreInfoOutput {
	return Companion_GetKeyStoreInfoOutput_.Create_GetKeyStoreInfoOutput_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), _dafny.EmptySeq, Companion_KMSConfiguration_.Default())
}

func (_this GetKeyStoreInfoOutput) Dtor_keyStoreId() _dafny.Sequence {
	return _this.Get_().(GetKeyStoreInfoOutput_GetKeyStoreInfoOutput).KeyStoreId
}

func (_this GetKeyStoreInfoOutput) Dtor_keyStoreName() _dafny.Sequence {
	return _this.Get_().(GetKeyStoreInfoOutput_GetKeyStoreInfoOutput).KeyStoreName
}

func (_this GetKeyStoreInfoOutput) Dtor_logicalKeyStoreName() _dafny.Sequence {
	return _this.Get_().(GetKeyStoreInfoOutput_GetKeyStoreInfoOutput).LogicalKeyStoreName
}

func (_this GetKeyStoreInfoOutput) Dtor_grantTokens() _dafny.Sequence {
	return _this.Get_().(GetKeyStoreInfoOutput_GetKeyStoreInfoOutput).GrantTokens
}

func (_this GetKeyStoreInfoOutput) Dtor_kmsConfiguration() KMSConfiguration {
	return _this.Get_().(GetKeyStoreInfoOutput_GetKeyStoreInfoOutput).KmsConfiguration
}

func (_this GetKeyStoreInfoOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetKeyStoreInfoOutput_GetKeyStoreInfoOutput:
		{
			return "AwsCryptographyKeyStoreTypes.GetKeyStoreInfoOutput.GetKeyStoreInfoOutput" + "(" + _dafny.String(data.KeyStoreId) + ", " + _dafny.String(data.KeyStoreName) + ", " + _dafny.String(data.LogicalKeyStoreName) + ", " + _dafny.String(data.GrantTokens) + ", " + _dafny.String(data.KmsConfiguration) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetKeyStoreInfoOutput) Equals(other GetKeyStoreInfoOutput) bool {
	switch data1 := _this.Get_().(type) {
	case GetKeyStoreInfoOutput_GetKeyStoreInfoOutput:
		{
			data2, ok := other.Get_().(GetKeyStoreInfoOutput_GetKeyStoreInfoOutput)
			return ok && data1.KeyStoreId.Equals(data2.KeyStoreId) && data1.KeyStoreName.Equals(data2.KeyStoreName) && data1.LogicalKeyStoreName.Equals(data2.LogicalKeyStoreName) && data1.GrantTokens.Equals(data2.GrantTokens) && data1.KmsConfiguration.Equals(data2.KmsConfiguration)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetKeyStoreInfoOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetKeyStoreInfoOutput)
	return ok && _this.Equals(typed)
}

func Type_GetKeyStoreInfoOutput_() _dafny.TypeDescriptor {
	return type_GetKeyStoreInfoOutput_{}
}

type type_GetKeyStoreInfoOutput_ struct {
}

func (_this type_GetKeyStoreInfoOutput_) Default() interface{} {
	return Companion_GetKeyStoreInfoOutput_.Default()
}

func (_this type_GetKeyStoreInfoOutput_) String() string {
	return "AwsCryptographyKeyStoreTypes.GetKeyStoreInfoOutput"
}
func (_this GetKeyStoreInfoOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetKeyStoreInfoOutput{}

// End of datatype GetKeyStoreInfoOutput

// Definition of class IKeyStoreClientCallHistory
type IKeyStoreClientCallHistory struct {
	dummy byte
}

func New_IKeyStoreClientCallHistory_() *IKeyStoreClientCallHistory {
	_this := IKeyStoreClientCallHistory{}

	return &_this
}

type CompanionStruct_IKeyStoreClientCallHistory_ struct {
}

var Companion_IKeyStoreClientCallHistory_ = CompanionStruct_IKeyStoreClientCallHistory_{}

func (_this *IKeyStoreClientCallHistory) Equals(other *IKeyStoreClientCallHistory) bool {
	return _this == other
}

func (_this *IKeyStoreClientCallHistory) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*IKeyStoreClientCallHistory)
	return ok && _this.Equals(other)
}

func (*IKeyStoreClientCallHistory) String() string {
	return "AwsCryptographyKeyStoreTypes.IKeyStoreClientCallHistory"
}

func Type_IKeyStoreClientCallHistory_() _dafny.TypeDescriptor {
	return type_IKeyStoreClientCallHistory_{}
}

type type_IKeyStoreClientCallHistory_ struct {
}

func (_this type_IKeyStoreClientCallHistory_) Default() interface{} {
	return (*IKeyStoreClientCallHistory)(nil)
}

func (_this type_IKeyStoreClientCallHistory_) String() string {
	return "AwsCryptographyKeyStoreTypes.IKeyStoreClientCallHistory"
}
func (_this *IKeyStoreClientCallHistory) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &IKeyStoreClientCallHistory{}

// End of class IKeyStoreClientCallHistory

// Definition of trait IKeyStoreClient
type IKeyStoreClient interface {
	String() string
	GetKeyStoreInfo() m_Wrappers.Result
	CreateKeyStore(input CreateKeyStoreInput) m_Wrappers.Result
	CreateKey(input CreateKeyInput) m_Wrappers.Result
	VersionKey(input VersionKeyInput) m_Wrappers.Result
	GetActiveBranchKey(input GetActiveBranchKeyInput) m_Wrappers.Result
	GetBranchKeyVersion(input GetBranchKeyVersionInput) m_Wrappers.Result
	GetBeaconKey(input GetBeaconKeyInput) m_Wrappers.Result
}
type CompanionStruct_IKeyStoreClient_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_IKeyStoreClient_ = CompanionStruct_IKeyStoreClient_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_IKeyStoreClient_) CastTo_(x interface{}) IKeyStoreClient {
	var t IKeyStoreClient
	t, _ = x.(IKeyStoreClient)
	return t
}

// End of trait IKeyStoreClient

// Definition of datatype KeyStoreConfig
type KeyStoreConfig struct {
	Data_KeyStoreConfig_
}

func (_this KeyStoreConfig) Get_() Data_KeyStoreConfig_ {
	return _this.Data_KeyStoreConfig_
}

type Data_KeyStoreConfig_ interface {
	isKeyStoreConfig()
}

type CompanionStruct_KeyStoreConfig_ struct {
}

var Companion_KeyStoreConfig_ = CompanionStruct_KeyStoreConfig_{}

type KeyStoreConfig_KeyStoreConfig struct {
	DdbTableName        _dafny.Sequence
	KmsConfiguration    KMSConfiguration
	LogicalKeyStoreName _dafny.Sequence
	Id                  m_Wrappers.Option
	GrantTokens         m_Wrappers.Option
	DdbClient           m_Wrappers.Option
	KmsClient           m_Wrappers.Option
}

func (KeyStoreConfig_KeyStoreConfig) isKeyStoreConfig() {}

func (CompanionStruct_KeyStoreConfig_) Create_KeyStoreConfig_(DdbTableName _dafny.Sequence, KmsConfiguration KMSConfiguration, LogicalKeyStoreName _dafny.Sequence, Id m_Wrappers.Option, GrantTokens m_Wrappers.Option, DdbClient m_Wrappers.Option, KmsClient m_Wrappers.Option) KeyStoreConfig {
	return KeyStoreConfig{KeyStoreConfig_KeyStoreConfig{DdbTableName, KmsConfiguration, LogicalKeyStoreName, Id, GrantTokens, DdbClient, KmsClient}}
}

func (_this KeyStoreConfig) Is_KeyStoreConfig() bool {
	_, ok := _this.Get_().(KeyStoreConfig_KeyStoreConfig)
	return ok
}

func (CompanionStruct_KeyStoreConfig_) Default() KeyStoreConfig {
	return Companion_KeyStoreConfig_.Create_KeyStoreConfig_(_dafny.EmptySeq.SetString(), Companion_KMSConfiguration_.Default(), _dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this KeyStoreConfig) Dtor_ddbTableName() _dafny.Sequence {
	return _this.Get_().(KeyStoreConfig_KeyStoreConfig).DdbTableName
}

func (_this KeyStoreConfig) Dtor_kmsConfiguration() KMSConfiguration {
	return _this.Get_().(KeyStoreConfig_KeyStoreConfig).KmsConfiguration
}

func (_this KeyStoreConfig) Dtor_logicalKeyStoreName() _dafny.Sequence {
	return _this.Get_().(KeyStoreConfig_KeyStoreConfig).LogicalKeyStoreName
}

func (_this KeyStoreConfig) Dtor_id() m_Wrappers.Option {
	return _this.Get_().(KeyStoreConfig_KeyStoreConfig).Id
}

func (_this KeyStoreConfig) Dtor_grantTokens() m_Wrappers.Option {
	return _this.Get_().(KeyStoreConfig_KeyStoreConfig).GrantTokens
}

func (_this KeyStoreConfig) Dtor_ddbClient() m_Wrappers.Option {
	return _this.Get_().(KeyStoreConfig_KeyStoreConfig).DdbClient
}

func (_this KeyStoreConfig) Dtor_kmsClient() m_Wrappers.Option {
	return _this.Get_().(KeyStoreConfig_KeyStoreConfig).KmsClient
}

func (_this KeyStoreConfig) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case KeyStoreConfig_KeyStoreConfig:
		{
			return "AwsCryptographyKeyStoreTypes.KeyStoreConfig.KeyStoreConfig" + "(" + _dafny.String(data.DdbTableName) + ", " + _dafny.String(data.KmsConfiguration) + ", " + _dafny.String(data.LogicalKeyStoreName) + ", " + _dafny.String(data.Id) + ", " + _dafny.String(data.GrantTokens) + ", " + _dafny.String(data.DdbClient) + ", " + _dafny.String(data.KmsClient) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KeyStoreConfig) Equals(other KeyStoreConfig) bool {
	switch data1 := _this.Get_().(type) {
	case KeyStoreConfig_KeyStoreConfig:
		{
			data2, ok := other.Get_().(KeyStoreConfig_KeyStoreConfig)
			return ok && data1.DdbTableName.Equals(data2.DdbTableName) && data1.KmsConfiguration.Equals(data2.KmsConfiguration) && data1.LogicalKeyStoreName.Equals(data2.LogicalKeyStoreName) && data1.Id.Equals(data2.Id) && data1.GrantTokens.Equals(data2.GrantTokens) && data1.DdbClient.Equals(data2.DdbClient) && data1.KmsClient.Equals(data2.KmsClient)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KeyStoreConfig) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KeyStoreConfig)
	return ok && _this.Equals(typed)
}

func Type_KeyStoreConfig_() _dafny.TypeDescriptor {
	return type_KeyStoreConfig_{}
}

type type_KeyStoreConfig_ struct {
}

func (_this type_KeyStoreConfig_) Default() interface{} {
	return Companion_KeyStoreConfig_.Default()
}

func (_this type_KeyStoreConfig_) String() string {
	return "AwsCryptographyKeyStoreTypes.KeyStoreConfig"
}
func (_this KeyStoreConfig) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KeyStoreConfig{}

// End of datatype KeyStoreConfig

// Definition of datatype KMSConfiguration
type KMSConfiguration struct {
	Data_KMSConfiguration_
}

func (_this KMSConfiguration) Get_() Data_KMSConfiguration_ {
	return _this.Data_KMSConfiguration_
}

type Data_KMSConfiguration_ interface {
	isKMSConfiguration()
}

type CompanionStruct_KMSConfiguration_ struct {
}

var Companion_KMSConfiguration_ = CompanionStruct_KMSConfiguration_{}

type KMSConfiguration_kmsKeyArn struct {
	KmsKeyArn _dafny.Sequence
}

func (KMSConfiguration_kmsKeyArn) isKMSConfiguration() {}

func (CompanionStruct_KMSConfiguration_) Create_kmsKeyArn_(KmsKeyArn _dafny.Sequence) KMSConfiguration {
	return KMSConfiguration{KMSConfiguration_kmsKeyArn{KmsKeyArn}}
}

func (_this KMSConfiguration) Is_kmsKeyArn() bool {
	_, ok := _this.Get_().(KMSConfiguration_kmsKeyArn)
	return ok
}

type KMSConfiguration_kmsMRKeyArn struct {
	KmsMRKeyArn _dafny.Sequence
}

func (KMSConfiguration_kmsMRKeyArn) isKMSConfiguration() {}

func (CompanionStruct_KMSConfiguration_) Create_kmsMRKeyArn_(KmsMRKeyArn _dafny.Sequence) KMSConfiguration {
	return KMSConfiguration{KMSConfiguration_kmsMRKeyArn{KmsMRKeyArn}}
}

func (_this KMSConfiguration) Is_kmsMRKeyArn() bool {
	_, ok := _this.Get_().(KMSConfiguration_kmsMRKeyArn)
	return ok
}

type KMSConfiguration_discovery struct {
	Discovery Discovery
}

func (KMSConfiguration_discovery) isKMSConfiguration() {}

func (CompanionStruct_KMSConfiguration_) Create_discovery_(Discovery Discovery) KMSConfiguration {
	return KMSConfiguration{KMSConfiguration_discovery{Discovery}}
}

func (_this KMSConfiguration) Is_discovery() bool {
	_, ok := _this.Get_().(KMSConfiguration_discovery)
	return ok
}

type KMSConfiguration_mrDiscovery struct {
	MrDiscovery MRDiscovery
}

func (KMSConfiguration_mrDiscovery) isKMSConfiguration() {}

func (CompanionStruct_KMSConfiguration_) Create_mrDiscovery_(MrDiscovery MRDiscovery) KMSConfiguration {
	return KMSConfiguration{KMSConfiguration_mrDiscovery{MrDiscovery}}
}

func (_this KMSConfiguration) Is_mrDiscovery() bool {
	_, ok := _this.Get_().(KMSConfiguration_mrDiscovery)
	return ok
}

func (CompanionStruct_KMSConfiguration_) Default() KMSConfiguration {
	return Companion_KMSConfiguration_.Create_kmsKeyArn_(_dafny.EmptySeq.SetString())
}

func (_this KMSConfiguration) Dtor_kmsKeyArn() _dafny.Sequence {
	return _this.Get_().(KMSConfiguration_kmsKeyArn).KmsKeyArn
}

func (_this KMSConfiguration) Dtor_kmsMRKeyArn() _dafny.Sequence {
	return _this.Get_().(KMSConfiguration_kmsMRKeyArn).KmsMRKeyArn
}

func (_this KMSConfiguration) Dtor_discovery() Discovery {
	return _this.Get_().(KMSConfiguration_discovery).Discovery
}

func (_this KMSConfiguration) Dtor_mrDiscovery() MRDiscovery {
	return _this.Get_().(KMSConfiguration_mrDiscovery).MrDiscovery
}

func (_this KMSConfiguration) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case KMSConfiguration_kmsKeyArn:
		{
			return "AwsCryptographyKeyStoreTypes.KMSConfiguration.kmsKeyArn" + "(" + _dafny.String(data.KmsKeyArn) + ")"
		}
	case KMSConfiguration_kmsMRKeyArn:
		{
			return "AwsCryptographyKeyStoreTypes.KMSConfiguration.kmsMRKeyArn" + "(" + _dafny.String(data.KmsMRKeyArn) + ")"
		}
	case KMSConfiguration_discovery:
		{
			return "AwsCryptographyKeyStoreTypes.KMSConfiguration.discovery" + "(" + _dafny.String(data.Discovery) + ")"
		}
	case KMSConfiguration_mrDiscovery:
		{
			return "AwsCryptographyKeyStoreTypes.KMSConfiguration.mrDiscovery" + "(" + _dafny.String(data.MrDiscovery) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KMSConfiguration) Equals(other KMSConfiguration) bool {
	switch data1 := _this.Get_().(type) {
	case KMSConfiguration_kmsKeyArn:
		{
			data2, ok := other.Get_().(KMSConfiguration_kmsKeyArn)
			return ok && data1.KmsKeyArn.Equals(data2.KmsKeyArn)
		}
	case KMSConfiguration_kmsMRKeyArn:
		{
			data2, ok := other.Get_().(KMSConfiguration_kmsMRKeyArn)
			return ok && data1.KmsMRKeyArn.Equals(data2.KmsMRKeyArn)
		}
	case KMSConfiguration_discovery:
		{
			data2, ok := other.Get_().(KMSConfiguration_discovery)
			return ok && data1.Discovery.Equals(data2.Discovery)
		}
	case KMSConfiguration_mrDiscovery:
		{
			data2, ok := other.Get_().(KMSConfiguration_mrDiscovery)
			return ok && data1.MrDiscovery.Equals(data2.MrDiscovery)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KMSConfiguration) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KMSConfiguration)
	return ok && _this.Equals(typed)
}

func Type_KMSConfiguration_() _dafny.TypeDescriptor {
	return type_KMSConfiguration_{}
}

type type_KMSConfiguration_ struct {
}

func (_this type_KMSConfiguration_) Default() interface{} {
	return Companion_KMSConfiguration_.Default()
}

func (_this type_KMSConfiguration_) String() string {
	return "AwsCryptographyKeyStoreTypes.KMSConfiguration"
}
func (_this KMSConfiguration) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KMSConfiguration{}

// End of datatype KMSConfiguration

// Definition of datatype MRDiscovery
type MRDiscovery struct {
	Data_MRDiscovery_
}

func (_this MRDiscovery) Get_() Data_MRDiscovery_ {
	return _this.Data_MRDiscovery_
}

type Data_MRDiscovery_ interface {
	isMRDiscovery()
}

type CompanionStruct_MRDiscovery_ struct {
}

var Companion_MRDiscovery_ = CompanionStruct_MRDiscovery_{}

type MRDiscovery_MRDiscovery struct {
	Region _dafny.Sequence
}

func (MRDiscovery_MRDiscovery) isMRDiscovery() {}

func (CompanionStruct_MRDiscovery_) Create_MRDiscovery_(Region _dafny.Sequence) MRDiscovery {
	return MRDiscovery{MRDiscovery_MRDiscovery{Region}}
}

func (_this MRDiscovery) Is_MRDiscovery() bool {
	_, ok := _this.Get_().(MRDiscovery_MRDiscovery)
	return ok
}

func (CompanionStruct_MRDiscovery_) Default() MRDiscovery {
	return Companion_MRDiscovery_.Create_MRDiscovery_(_dafny.EmptySeq.SetString())
}

func (_this MRDiscovery) Dtor_region() _dafny.Sequence {
	return _this.Get_().(MRDiscovery_MRDiscovery).Region
}

func (_this MRDiscovery) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case MRDiscovery_MRDiscovery:
		{
			return "AwsCryptographyKeyStoreTypes.MRDiscovery.MRDiscovery" + "(" + _dafny.String(data.Region) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this MRDiscovery) Equals(other MRDiscovery) bool {
	switch data1 := _this.Get_().(type) {
	case MRDiscovery_MRDiscovery:
		{
			data2, ok := other.Get_().(MRDiscovery_MRDiscovery)
			return ok && data1.Region.Equals(data2.Region)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this MRDiscovery) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(MRDiscovery)
	return ok && _this.Equals(typed)
}

func Type_MRDiscovery_() _dafny.TypeDescriptor {
	return type_MRDiscovery_{}
}

type type_MRDiscovery_ struct {
}

func (_this type_MRDiscovery_) Default() interface{} {
	return Companion_MRDiscovery_.Default()
}

func (_this type_MRDiscovery_) String() string {
	return "AwsCryptographyKeyStoreTypes.MRDiscovery"
}
func (_this MRDiscovery) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = MRDiscovery{}

// End of datatype MRDiscovery

// Definition of datatype VersionKeyInput
type VersionKeyInput struct {
	Data_VersionKeyInput_
}

func (_this VersionKeyInput) Get_() Data_VersionKeyInput_ {
	return _this.Data_VersionKeyInput_
}

type Data_VersionKeyInput_ interface {
	isVersionKeyInput()
}

type CompanionStruct_VersionKeyInput_ struct {
}

var Companion_VersionKeyInput_ = CompanionStruct_VersionKeyInput_{}

type VersionKeyInput_VersionKeyInput struct {
	BranchKeyIdentifier _dafny.Sequence
}

func (VersionKeyInput_VersionKeyInput) isVersionKeyInput() {}

func (CompanionStruct_VersionKeyInput_) Create_VersionKeyInput_(BranchKeyIdentifier _dafny.Sequence) VersionKeyInput {
	return VersionKeyInput{VersionKeyInput_VersionKeyInput{BranchKeyIdentifier}}
}

func (_this VersionKeyInput) Is_VersionKeyInput() bool {
	_, ok := _this.Get_().(VersionKeyInput_VersionKeyInput)
	return ok
}

func (CompanionStruct_VersionKeyInput_) Default() VersionKeyInput {
	return Companion_VersionKeyInput_.Create_VersionKeyInput_(_dafny.EmptySeq.SetString())
}

func (_this VersionKeyInput) Dtor_branchKeyIdentifier() _dafny.Sequence {
	return _this.Get_().(VersionKeyInput_VersionKeyInput).BranchKeyIdentifier
}

func (_this VersionKeyInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case VersionKeyInput_VersionKeyInput:
		{
			return "AwsCryptographyKeyStoreTypes.VersionKeyInput.VersionKeyInput" + "(" + _dafny.String(data.BranchKeyIdentifier) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this VersionKeyInput) Equals(other VersionKeyInput) bool {
	switch data1 := _this.Get_().(type) {
	case VersionKeyInput_VersionKeyInput:
		{
			data2, ok := other.Get_().(VersionKeyInput_VersionKeyInput)
			return ok && data1.BranchKeyIdentifier.Equals(data2.BranchKeyIdentifier)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this VersionKeyInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(VersionKeyInput)
	return ok && _this.Equals(typed)
}

func Type_VersionKeyInput_() _dafny.TypeDescriptor {
	return type_VersionKeyInput_{}
}

type type_VersionKeyInput_ struct {
}

func (_this type_VersionKeyInput_) Default() interface{} {
	return Companion_VersionKeyInput_.Default()
}

func (_this type_VersionKeyInput_) String() string {
	return "AwsCryptographyKeyStoreTypes.VersionKeyInput"
}
func (_this VersionKeyInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = VersionKeyInput{}

// End of datatype VersionKeyInput

// Definition of datatype VersionKeyOutput
type VersionKeyOutput struct {
	Data_VersionKeyOutput_
}

func (_this VersionKeyOutput) Get_() Data_VersionKeyOutput_ {
	return _this.Data_VersionKeyOutput_
}

type Data_VersionKeyOutput_ interface {
	isVersionKeyOutput()
}

type CompanionStruct_VersionKeyOutput_ struct {
}

var Companion_VersionKeyOutput_ = CompanionStruct_VersionKeyOutput_{}

type VersionKeyOutput_VersionKeyOutput struct {
}

func (VersionKeyOutput_VersionKeyOutput) isVersionKeyOutput() {}

func (CompanionStruct_VersionKeyOutput_) Create_VersionKeyOutput_() VersionKeyOutput {
	return VersionKeyOutput{VersionKeyOutput_VersionKeyOutput{}}
}

func (_this VersionKeyOutput) Is_VersionKeyOutput() bool {
	_, ok := _this.Get_().(VersionKeyOutput_VersionKeyOutput)
	return ok
}

func (CompanionStruct_VersionKeyOutput_) Default() VersionKeyOutput {
	return Companion_VersionKeyOutput_.Create_VersionKeyOutput_()
}

func (_ CompanionStruct_VersionKeyOutput_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_VersionKeyOutput_.Create_VersionKeyOutput_(), true
		default:
			return VersionKeyOutput{}, false
		}
	}
}

func (_this VersionKeyOutput) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case VersionKeyOutput_VersionKeyOutput:
		{
			return "AwsCryptographyKeyStoreTypes.VersionKeyOutput.VersionKeyOutput"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this VersionKeyOutput) Equals(other VersionKeyOutput) bool {
	switch _this.Get_().(type) {
	case VersionKeyOutput_VersionKeyOutput:
		{
			_, ok := other.Get_().(VersionKeyOutput_VersionKeyOutput)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this VersionKeyOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(VersionKeyOutput)
	return ok && _this.Equals(typed)
}

func Type_VersionKeyOutput_() _dafny.TypeDescriptor {
	return type_VersionKeyOutput_{}
}

type type_VersionKeyOutput_ struct {
}

func (_this type_VersionKeyOutput_) Default() interface{} {
	return Companion_VersionKeyOutput_.Default()
}

func (_this type_VersionKeyOutput_) String() string {
	return "AwsCryptographyKeyStoreTypes.VersionKeyOutput"
}
func (_this VersionKeyOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = VersionKeyOutput{}

// End of datatype VersionKeyOutput

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

type Error_KeyStoreException struct {
	Message _dafny.Sequence
}

func (Error_KeyStoreException) isError() {}

func (CompanionStruct_Error_) Create_KeyStoreException_(Message _dafny.Sequence) Error {
	return Error{Error_KeyStoreException{Message}}
}

func (_this Error) Is_KeyStoreException() bool {
	_, ok := _this.Get_().(Error_KeyStoreException)
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
	return Companion_Error_.Create_KeyStoreException_(_dafny.EmptySeq.SetString())
}

func (_this Error) Dtor_message() _dafny.Sequence {
	switch data := _this.Get_().(type) {
	case Error_KeyStoreException:
		return data.Message
	default:
		return data.(Error_CollectionOfErrors).Message
	}
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
	case Error_KeyStoreException:
		{
			return "AwsCryptographyKeyStoreTypes.Error.KeyStoreException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_ComAmazonawsDynamodb:
		{
			return "AwsCryptographyKeyStoreTypes.Error.ComAmazonawsDynamodb" + "(" + _dafny.String(data.ComAmazonawsDynamodb) + ")"
		}
	case Error_ComAmazonawsKms:
		{
			return "AwsCryptographyKeyStoreTypes.Error.ComAmazonawsKms" + "(" + _dafny.String(data.ComAmazonawsKms) + ")"
		}
	case Error_CollectionOfErrors:
		{
			return "AwsCryptographyKeyStoreTypes.Error.CollectionOfErrors" + "(" + _dafny.String(data.List) + ", " + _dafny.String(data.Message) + ")"
		}
	case Error_Opaque:
		{
			return "AwsCryptographyKeyStoreTypes.Error.Opaque" + "(" + _dafny.String(data.Obj) + ")"
		}
	case Error_OpaqueWithText:
		{
			return "AwsCryptographyKeyStoreTypes.Error.OpaqueWithText" + "(" + _dafny.String(data.Obj) + ", " + _dafny.String(data.ObjMessage) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Error) Equals(other Error) bool {
	switch data1 := _this.Get_().(type) {
	case Error_KeyStoreException:
		{
			data2, ok := other.Get_().(Error_KeyStoreException)
			return ok && data1.Message.Equals(data2.Message)
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
	return "AwsCryptographyKeyStoreTypes.Error"
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
	return "AwsCryptographyKeyStoreTypes.OpaqueError"
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
	return "AwsCryptographyKeyStoreTypes.OpaqueError"
}
func (_this *CompanionStruct_OpaqueError_) Is_(__source Error) bool {
	var _0_e Error = (__source)
	_ = _0_e
	return ((_0_e).Is_Opaque()) || ((_0_e).Is_OpaqueWithText())
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
	return "AwsCryptographyKeyStoreTypes.DummySubsetType"
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
	return "AwsCryptographyKeyStoreTypes.DummySubsetType"
}
func (_this *CompanionStruct_DummySubsetType_) Is_(__source _dafny.Int) bool {
	var _1_x _dafny.Int = (__source)
	_ = _1_x
	return Companion_Default___.IsDummySubsetType(_1_x)
}
