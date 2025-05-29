// Package MaterialWrapping
// Dafny module MaterialWrapping compiled into Go

package MaterialWrapping

import (
	os "os"

	m_ComAmazonawsDynamodbTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/ComAmazonawsDynamodbTypes"
	m_Com_Amazonaws_Dynamodb "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/Com_Amazonaws_Dynamodb"
	m_ComAmazonawsKmsTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/ComAmazonawsKmsTypes"
	m_Com_Amazonaws_Kms "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/Com_Amazonaws_Kms"
	m_AlgorithmSuites "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AlgorithmSuites"
	m_AwsArnParsing "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsArnParsing"
	m_AwsCryptographyKeyStoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyKeyStoreOperations"
	m_AwsCryptographyKeyStoreTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyKeyStoreTypes"
	m_AwsCryptographyMaterialProvidersTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyMaterialProvidersTypes"
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_CanonicalEncryptionContext "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CanonicalEncryptionContext"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
	m_GetKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/GetKeys"
	m_KMSKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KMSKeystoreOperations"
	m_KeyStore "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStore"
	m_KeyStoreErrorMessages "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStoreErrorMessages"
	m_Keyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Keyring"
	m_KmsArn "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KmsArn"
	m_Materials "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Materials"
	m_Structure "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Structure"
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
var _ m_BoundedInts.Dummy__
var _ m_StandardLibrary_UInt.Dummy__
var _ m_StandardLibrary_MemoryMath.Dummy__
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
var _ m_AwsCryptographyMaterialProvidersTypes.Dummy__
var _ m_AwsArnParsing.Dummy__
var _ m_AwsKmsMrkMatchForDecrypt.Dummy__
var _ m_AwsKmsUtils.Dummy__
var _ m_KeyStoreErrorMessages.Dummy__
var _ m_KmsArn.Dummy__
var _ m_Structure.Dummy__
var _ m_KMSKeystoreOperations.Dummy__
var _ m_DDBKeystoreOperations.Dummy__
var _ m_CreateKeys.Dummy__
var _ m_CreateKeyStoreTable.Dummy__
var _ m_GetKeys.Dummy__
var _ m_AwsCryptographyKeyStoreOperations.Dummy__
var _ m_Com_Amazonaws_Kms.Dummy__
var _ m_Com_Amazonaws_Dynamodb.Dummy__
var _ m_KeyStore.Dummy__
var _ m_AlgorithmSuites.Dummy__
var _ m_Materials.Dummy__
var _ m_Keyring.Dummy__
var _ m_CanonicalEncryptionContext.Dummy__

type Dummy__ struct{}

// Definition of datatype GenerateAndWrapInput
type GenerateAndWrapInput struct {
	Data_GenerateAndWrapInput_
}

func (_this GenerateAndWrapInput) Get_() Data_GenerateAndWrapInput_ {
	return _this.Data_GenerateAndWrapInput_
}

type Data_GenerateAndWrapInput_ interface {
	isGenerateAndWrapInput()
}

type CompanionStruct_GenerateAndWrapInput_ struct {
}

var Companion_GenerateAndWrapInput_ = CompanionStruct_GenerateAndWrapInput_{}

type GenerateAndWrapInput_GenerateAndWrapInput struct {
	AlgorithmSuite    m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
	EncryptionContext _dafny.Map
	SerializedEC      m_Wrappers.Result
}

func (GenerateAndWrapInput_GenerateAndWrapInput) isGenerateAndWrapInput() {}

func (CompanionStruct_GenerateAndWrapInput_) Create_GenerateAndWrapInput_(AlgorithmSuite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo, EncryptionContext _dafny.Map, SerializedEC m_Wrappers.Result) GenerateAndWrapInput {
	return GenerateAndWrapInput{GenerateAndWrapInput_GenerateAndWrapInput{AlgorithmSuite, EncryptionContext, SerializedEC}}
}

func (_this GenerateAndWrapInput) Is_GenerateAndWrapInput() bool {
	_, ok := _this.Get_().(GenerateAndWrapInput_GenerateAndWrapInput)
	return ok
}

func (CompanionStruct_GenerateAndWrapInput_) Default() GenerateAndWrapInput {
	return Companion_GenerateAndWrapInput_.Create_GenerateAndWrapInput_(m_AwsCryptographyMaterialProvidersTypes.Companion_AlgorithmSuiteInfo_.Default(), _dafny.EmptyMap, m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq))
}

func (_this GenerateAndWrapInput) Dtor_algorithmSuite() m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo {
	return _this.Get_().(GenerateAndWrapInput_GenerateAndWrapInput).AlgorithmSuite
}

func (_this GenerateAndWrapInput) Dtor_encryptionContext() _dafny.Map {
	return _this.Get_().(GenerateAndWrapInput_GenerateAndWrapInput).EncryptionContext
}

func (_this GenerateAndWrapInput) Dtor_serializedEC() m_Wrappers.Result {
	return _this.Get_().(GenerateAndWrapInput_GenerateAndWrapInput).SerializedEC
}

func (_this GenerateAndWrapInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateAndWrapInput_GenerateAndWrapInput:
		{
			return "MaterialWrapping.GenerateAndWrapInput.GenerateAndWrapInput" + "(" + _dafny.String(data.AlgorithmSuite) + ", " + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.SerializedEC) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateAndWrapInput) Equals(other GenerateAndWrapInput) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateAndWrapInput_GenerateAndWrapInput:
		{
			data2, ok := other.Get_().(GenerateAndWrapInput_GenerateAndWrapInput)
			return ok && data1.AlgorithmSuite.Equals(data2.AlgorithmSuite) && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.SerializedEC.Equals(data2.SerializedEC)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateAndWrapInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateAndWrapInput)
	return ok && _this.Equals(typed)
}

func Type_GenerateAndWrapInput_() _dafny.TypeDescriptor {
	return type_GenerateAndWrapInput_{}
}

type type_GenerateAndWrapInput_ struct {
}

func (_this type_GenerateAndWrapInput_) Default() interface{} {
	return Companion_GenerateAndWrapInput_.Default()
}

func (_this type_GenerateAndWrapInput_) String() string {
	return "MaterialWrapping.GenerateAndWrapInput"
}
func (_this GenerateAndWrapInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateAndWrapInput{}

// End of datatype GenerateAndWrapInput

// Definition of datatype GenerateAndWrapOutput
type GenerateAndWrapOutput struct {
	Data_GenerateAndWrapOutput_
}

func (_this GenerateAndWrapOutput) Get_() Data_GenerateAndWrapOutput_ {
	return _this.Data_GenerateAndWrapOutput_
}

type Data_GenerateAndWrapOutput_ interface {
	isGenerateAndWrapOutput()
}

type CompanionStruct_GenerateAndWrapOutput_ struct {
}

var Companion_GenerateAndWrapOutput_ = CompanionStruct_GenerateAndWrapOutput_{}

type GenerateAndWrapOutput_GenerateAndWrapOutput struct {
	PlaintextMaterial _dafny.Sequence
	WrappedMaterial   _dafny.Sequence
	WrapInfo          interface{}
}

func (GenerateAndWrapOutput_GenerateAndWrapOutput) isGenerateAndWrapOutput() {}

func (CompanionStruct_GenerateAndWrapOutput_) Create_GenerateAndWrapOutput_(PlaintextMaterial _dafny.Sequence, WrappedMaterial _dafny.Sequence, WrapInfo interface{}) GenerateAndWrapOutput {
	return GenerateAndWrapOutput{GenerateAndWrapOutput_GenerateAndWrapOutput{PlaintextMaterial, WrappedMaterial, WrapInfo}}
}

func (_this GenerateAndWrapOutput) Is_GenerateAndWrapOutput() bool {
	_, ok := _this.Get_().(GenerateAndWrapOutput_GenerateAndWrapOutput)
	return ok
}

func (CompanionStruct_GenerateAndWrapOutput_) Default(_default_T interface{}) GenerateAndWrapOutput {
	return Companion_GenerateAndWrapOutput_.Create_GenerateAndWrapOutput_(_dafny.EmptySeq, _dafny.EmptySeq, _default_T)
}

func (_this GenerateAndWrapOutput) Dtor_plaintextMaterial() _dafny.Sequence {
	return _this.Get_().(GenerateAndWrapOutput_GenerateAndWrapOutput).PlaintextMaterial
}

func (_this GenerateAndWrapOutput) Dtor_wrappedMaterial() _dafny.Sequence {
	return _this.Get_().(GenerateAndWrapOutput_GenerateAndWrapOutput).WrappedMaterial
}

func (_this GenerateAndWrapOutput) Dtor_wrapInfo() interface{} {
	return _this.Get_().(GenerateAndWrapOutput_GenerateAndWrapOutput).WrapInfo
}

func (_this GenerateAndWrapOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateAndWrapOutput_GenerateAndWrapOutput:
		{
			return "MaterialWrapping.GenerateAndWrapOutput.GenerateAndWrapOutput" + "(" + _dafny.String(data.PlaintextMaterial) + ", " + _dafny.String(data.WrappedMaterial) + ", " + _dafny.String(data.WrapInfo) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateAndWrapOutput) Equals(other GenerateAndWrapOutput) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateAndWrapOutput_GenerateAndWrapOutput:
		{
			data2, ok := other.Get_().(GenerateAndWrapOutput_GenerateAndWrapOutput)
			return ok && data1.PlaintextMaterial.Equals(data2.PlaintextMaterial) && data1.WrappedMaterial.Equals(data2.WrappedMaterial) && _dafny.AreEqual(data1.WrapInfo, data2.WrapInfo)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateAndWrapOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateAndWrapOutput)
	return ok && _this.Equals(typed)
}

func Type_GenerateAndWrapOutput_(Type_T_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_GenerateAndWrapOutput_{Type_T_}
}

type type_GenerateAndWrapOutput_ struct {
	Type_T_ _dafny.TypeDescriptor
}

func (_this type_GenerateAndWrapOutput_) Default() interface{} {
	Type_T_ := _this.Type_T_
	_ = Type_T_
	return Companion_GenerateAndWrapOutput_.Default(Type_T_.Default())
}

func (_this type_GenerateAndWrapOutput_) String() string {
	return "MaterialWrapping.GenerateAndWrapOutput"
}
func (_this GenerateAndWrapOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateAndWrapOutput{}

// End of datatype GenerateAndWrapOutput

// Definition of datatype WrapInput
type WrapInput struct {
	Data_WrapInput_
}

func (_this WrapInput) Get_() Data_WrapInput_ {
	return _this.Data_WrapInput_
}

type Data_WrapInput_ interface {
	isWrapInput()
}

type CompanionStruct_WrapInput_ struct {
}

var Companion_WrapInput_ = CompanionStruct_WrapInput_{}

type WrapInput_WrapInput struct {
	PlaintextMaterial _dafny.Sequence
	AlgorithmSuite    m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
	EncryptionContext _dafny.Map
	SerializedEC      m_Wrappers.Result
}

func (WrapInput_WrapInput) isWrapInput() {}

func (CompanionStruct_WrapInput_) Create_WrapInput_(PlaintextMaterial _dafny.Sequence, AlgorithmSuite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo, EncryptionContext _dafny.Map, SerializedEC m_Wrappers.Result) WrapInput {
	return WrapInput{WrapInput_WrapInput{PlaintextMaterial, AlgorithmSuite, EncryptionContext, SerializedEC}}
}

func (_this WrapInput) Is_WrapInput() bool {
	_, ok := _this.Get_().(WrapInput_WrapInput)
	return ok
}

func (CompanionStruct_WrapInput_) Default() WrapInput {
	return Companion_WrapInput_.Create_WrapInput_(_dafny.EmptySeq, m_AwsCryptographyMaterialProvidersTypes.Companion_AlgorithmSuiteInfo_.Default(), _dafny.EmptyMap, m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq))
}

func (_this WrapInput) Dtor_plaintextMaterial() _dafny.Sequence {
	return _this.Get_().(WrapInput_WrapInput).PlaintextMaterial
}

func (_this WrapInput) Dtor_algorithmSuite() m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo {
	return _this.Get_().(WrapInput_WrapInput).AlgorithmSuite
}

func (_this WrapInput) Dtor_encryptionContext() _dafny.Map {
	return _this.Get_().(WrapInput_WrapInput).EncryptionContext
}

func (_this WrapInput) Dtor_serializedEC() m_Wrappers.Result {
	return _this.Get_().(WrapInput_WrapInput).SerializedEC
}

func (_this WrapInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case WrapInput_WrapInput:
		{
			return "MaterialWrapping.WrapInput.WrapInput" + "(" + _dafny.String(data.PlaintextMaterial) + ", " + _dafny.String(data.AlgorithmSuite) + ", " + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.SerializedEC) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this WrapInput) Equals(other WrapInput) bool {
	switch data1 := _this.Get_().(type) {
	case WrapInput_WrapInput:
		{
			data2, ok := other.Get_().(WrapInput_WrapInput)
			return ok && data1.PlaintextMaterial.Equals(data2.PlaintextMaterial) && data1.AlgorithmSuite.Equals(data2.AlgorithmSuite) && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.SerializedEC.Equals(data2.SerializedEC)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this WrapInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(WrapInput)
	return ok && _this.Equals(typed)
}

func Type_WrapInput_() _dafny.TypeDescriptor {
	return type_WrapInput_{}
}

type type_WrapInput_ struct {
}

func (_this type_WrapInput_) Default() interface{} {
	return Companion_WrapInput_.Default()
}

func (_this type_WrapInput_) String() string {
	return "MaterialWrapping.WrapInput"
}
func (_this WrapInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = WrapInput{}

// End of datatype WrapInput

// Definition of datatype WrapOutput
type WrapOutput struct {
	Data_WrapOutput_
}

func (_this WrapOutput) Get_() Data_WrapOutput_ {
	return _this.Data_WrapOutput_
}

type Data_WrapOutput_ interface {
	isWrapOutput()
}

type CompanionStruct_WrapOutput_ struct {
}

var Companion_WrapOutput_ = CompanionStruct_WrapOutput_{}

type WrapOutput_WrapOutput struct {
	WrappedMaterial _dafny.Sequence
	WrapInfo        interface{}
}

func (WrapOutput_WrapOutput) isWrapOutput() {}

func (CompanionStruct_WrapOutput_) Create_WrapOutput_(WrappedMaterial _dafny.Sequence, WrapInfo interface{}) WrapOutput {
	return WrapOutput{WrapOutput_WrapOutput{WrappedMaterial, WrapInfo}}
}

func (_this WrapOutput) Is_WrapOutput() bool {
	_, ok := _this.Get_().(WrapOutput_WrapOutput)
	return ok
}

func (CompanionStruct_WrapOutput_) Default(_default_T interface{}) WrapOutput {
	return Companion_WrapOutput_.Create_WrapOutput_(_dafny.EmptySeq, _default_T)
}

func (_this WrapOutput) Dtor_wrappedMaterial() _dafny.Sequence {
	return _this.Get_().(WrapOutput_WrapOutput).WrappedMaterial
}

func (_this WrapOutput) Dtor_wrapInfo() interface{} {
	return _this.Get_().(WrapOutput_WrapOutput).WrapInfo
}

func (_this WrapOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case WrapOutput_WrapOutput:
		{
			return "MaterialWrapping.WrapOutput.WrapOutput" + "(" + _dafny.String(data.WrappedMaterial) + ", " + _dafny.String(data.WrapInfo) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this WrapOutput) Equals(other WrapOutput) bool {
	switch data1 := _this.Get_().(type) {
	case WrapOutput_WrapOutput:
		{
			data2, ok := other.Get_().(WrapOutput_WrapOutput)
			return ok && data1.WrappedMaterial.Equals(data2.WrappedMaterial) && _dafny.AreEqual(data1.WrapInfo, data2.WrapInfo)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this WrapOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(WrapOutput)
	return ok && _this.Equals(typed)
}

func Type_WrapOutput_(Type_T_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_WrapOutput_{Type_T_}
}

type type_WrapOutput_ struct {
	Type_T_ _dafny.TypeDescriptor
}

func (_this type_WrapOutput_) Default() interface{} {
	Type_T_ := _this.Type_T_
	_ = Type_T_
	return Companion_WrapOutput_.Default(Type_T_.Default())
}

func (_this type_WrapOutput_) String() string {
	return "MaterialWrapping.WrapOutput"
}
func (_this WrapOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = WrapOutput{}

// End of datatype WrapOutput

// Definition of datatype UnwrapInput
type UnwrapInput struct {
	Data_UnwrapInput_
}

func (_this UnwrapInput) Get_() Data_UnwrapInput_ {
	return _this.Data_UnwrapInput_
}

type Data_UnwrapInput_ interface {
	isUnwrapInput()
}

type CompanionStruct_UnwrapInput_ struct {
}

var Companion_UnwrapInput_ = CompanionStruct_UnwrapInput_{}

type UnwrapInput_UnwrapInput struct {
	WrappedMaterial   _dafny.Sequence
	AlgorithmSuite    m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
	EncryptionContext _dafny.Map
	SerializedEC      m_Wrappers.Result
}

func (UnwrapInput_UnwrapInput) isUnwrapInput() {}

func (CompanionStruct_UnwrapInput_) Create_UnwrapInput_(WrappedMaterial _dafny.Sequence, AlgorithmSuite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo, EncryptionContext _dafny.Map, SerializedEC m_Wrappers.Result) UnwrapInput {
	return UnwrapInput{UnwrapInput_UnwrapInput{WrappedMaterial, AlgorithmSuite, EncryptionContext, SerializedEC}}
}

func (_this UnwrapInput) Is_UnwrapInput() bool {
	_, ok := _this.Get_().(UnwrapInput_UnwrapInput)
	return ok
}

func (CompanionStruct_UnwrapInput_) Default() UnwrapInput {
	return Companion_UnwrapInput_.Create_UnwrapInput_(_dafny.EmptySeq, m_AwsCryptographyMaterialProvidersTypes.Companion_AlgorithmSuiteInfo_.Default(), _dafny.EmptyMap, m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq))
}

func (_this UnwrapInput) Dtor_wrappedMaterial() _dafny.Sequence {
	return _this.Get_().(UnwrapInput_UnwrapInput).WrappedMaterial
}

func (_this UnwrapInput) Dtor_algorithmSuite() m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo {
	return _this.Get_().(UnwrapInput_UnwrapInput).AlgorithmSuite
}

func (_this UnwrapInput) Dtor_encryptionContext() _dafny.Map {
	return _this.Get_().(UnwrapInput_UnwrapInput).EncryptionContext
}

func (_this UnwrapInput) Dtor_serializedEC() m_Wrappers.Result {
	return _this.Get_().(UnwrapInput_UnwrapInput).SerializedEC
}

func (_this UnwrapInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case UnwrapInput_UnwrapInput:
		{
			return "MaterialWrapping.UnwrapInput.UnwrapInput" + "(" + _dafny.String(data.WrappedMaterial) + ", " + _dafny.String(data.AlgorithmSuite) + ", " + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.SerializedEC) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this UnwrapInput) Equals(other UnwrapInput) bool {
	switch data1 := _this.Get_().(type) {
	case UnwrapInput_UnwrapInput:
		{
			data2, ok := other.Get_().(UnwrapInput_UnwrapInput)
			return ok && data1.WrappedMaterial.Equals(data2.WrappedMaterial) && data1.AlgorithmSuite.Equals(data2.AlgorithmSuite) && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.SerializedEC.Equals(data2.SerializedEC)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this UnwrapInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(UnwrapInput)
	return ok && _this.Equals(typed)
}

func Type_UnwrapInput_() _dafny.TypeDescriptor {
	return type_UnwrapInput_{}
}

type type_UnwrapInput_ struct {
}

func (_this type_UnwrapInput_) Default() interface{} {
	return Companion_UnwrapInput_.Default()
}

func (_this type_UnwrapInput_) String() string {
	return "MaterialWrapping.UnwrapInput"
}
func (_this UnwrapInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = UnwrapInput{}

// End of datatype UnwrapInput

// Definition of datatype UnwrapOutput
type UnwrapOutput struct {
	Data_UnwrapOutput_
}

func (_this UnwrapOutput) Get_() Data_UnwrapOutput_ {
	return _this.Data_UnwrapOutput_
}

type Data_UnwrapOutput_ interface {
	isUnwrapOutput()
}

type CompanionStruct_UnwrapOutput_ struct {
}

var Companion_UnwrapOutput_ = CompanionStruct_UnwrapOutput_{}

type UnwrapOutput_UnwrapOutput struct {
	UnwrappedMaterial _dafny.Sequence
	UnwrapInfo        interface{}
}

func (UnwrapOutput_UnwrapOutput) isUnwrapOutput() {}

func (CompanionStruct_UnwrapOutput_) Create_UnwrapOutput_(UnwrappedMaterial _dafny.Sequence, UnwrapInfo interface{}) UnwrapOutput {
	return UnwrapOutput{UnwrapOutput_UnwrapOutput{UnwrappedMaterial, UnwrapInfo}}
}

func (_this UnwrapOutput) Is_UnwrapOutput() bool {
	_, ok := _this.Get_().(UnwrapOutput_UnwrapOutput)
	return ok
}

func (CompanionStruct_UnwrapOutput_) Default(_default_T interface{}) UnwrapOutput {
	return Companion_UnwrapOutput_.Create_UnwrapOutput_(_dafny.EmptySeq, _default_T)
}

func (_this UnwrapOutput) Dtor_unwrappedMaterial() _dafny.Sequence {
	return _this.Get_().(UnwrapOutput_UnwrapOutput).UnwrappedMaterial
}

func (_this UnwrapOutput) Dtor_unwrapInfo() interface{} {
	return _this.Get_().(UnwrapOutput_UnwrapOutput).UnwrapInfo
}

func (_this UnwrapOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case UnwrapOutput_UnwrapOutput:
		{
			return "MaterialWrapping.UnwrapOutput.UnwrapOutput" + "(" + _dafny.String(data.UnwrappedMaterial) + ", " + _dafny.String(data.UnwrapInfo) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this UnwrapOutput) Equals(other UnwrapOutput) bool {
	switch data1 := _this.Get_().(type) {
	case UnwrapOutput_UnwrapOutput:
		{
			data2, ok := other.Get_().(UnwrapOutput_UnwrapOutput)
			return ok && data1.UnwrappedMaterial.Equals(data2.UnwrappedMaterial) && _dafny.AreEqual(data1.UnwrapInfo, data2.UnwrapInfo)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this UnwrapOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(UnwrapOutput)
	return ok && _this.Equals(typed)
}

func Type_UnwrapOutput_(Type_T_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_UnwrapOutput_{Type_T_}
}

type type_UnwrapOutput_ struct {
	Type_T_ _dafny.TypeDescriptor
}

func (_this type_UnwrapOutput_) Default() interface{} {
	Type_T_ := _this.Type_T_
	_ = Type_T_
	return Companion_UnwrapOutput_.Default(Type_T_.Default())
}

func (_this type_UnwrapOutput_) String() string {
	return "MaterialWrapping.UnwrapOutput"
}
func (_this UnwrapOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = UnwrapOutput{}

// End of datatype UnwrapOutput

// Definition of trait GenerateAndWrapMaterial
type GenerateAndWrapMaterial interface {
	String() string
	Invoke(a interface{}) interface{}
}
type CompanionStruct_GenerateAndWrapMaterial_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_GenerateAndWrapMaterial_ = CompanionStruct_GenerateAndWrapMaterial_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_GenerateAndWrapMaterial_) CastTo_(x interface{}) GenerateAndWrapMaterial {
	var t GenerateAndWrapMaterial
	t, _ = x.(GenerateAndWrapMaterial)
	return t
}

// End of trait GenerateAndWrapMaterial

// Definition of trait WrapMaterial
type WrapMaterial interface {
	String() string
	Invoke(a interface{}) interface{}
}
type CompanionStruct_WrapMaterial_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_WrapMaterial_ = CompanionStruct_WrapMaterial_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_WrapMaterial_) CastTo_(x interface{}) WrapMaterial {
	var t WrapMaterial
	t, _ = x.(WrapMaterial)
	return t
}

// End of trait WrapMaterial

// Definition of trait UnwrapMaterial
type UnwrapMaterial interface {
	String() string
	Invoke(a interface{}) interface{}
}
type CompanionStruct_UnwrapMaterial_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_UnwrapMaterial_ = CompanionStruct_UnwrapMaterial_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_UnwrapMaterial_) CastTo_(x interface{}) UnwrapMaterial {
	var t UnwrapMaterial
	t, _ = x.(UnwrapMaterial)
	return t
}

// End of trait UnwrapMaterial
