// Package AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
// Dafny module AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes compiled into Go

package AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes

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
	m_AwsCryptographyMaterialProvidersOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyMaterialProvidersOperations"
	m_AwsCryptographyMaterialProvidersTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyMaterialProvidersTypes"
	m_AwsKmsDiscoveryKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsDiscoveryKeyring"
	m_AwsKmsEcdhKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsEcdhKeyring"
	m_AwsKmsHierarchicalKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsHierarchicalKeyring"
	m_AwsKmsKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsKeyring"
	m_AwsKmsMrkAreUnique "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkAreUnique"
	m_AwsKmsMrkDiscoveryKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkDiscoveryKeyring"
	m_AwsKmsMrkKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkKeyring"
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsRsaKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsRsaKeyring"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_CMM "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CMM"
	m_CacheConstants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CacheConstants"
	m_CanonicalEncryptionContext "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CanonicalEncryptionContext"
	m_Commitment "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Commitment"
	m_Constants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Constants"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
	m_DefaultCMM "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DefaultCMM"
	m_DefaultClientSupplier "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DefaultClientSupplier"
	m_Defaults "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Defaults"
	m_DiscoveryMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DiscoveryMultiKeyring"
	m_EcdhEdkWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/EcdhEdkWrapping"
	m_EdkWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/EdkWrapping"
	m_ErrorMessages "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/ErrorMessages"
	m_GetKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/GetKeys"
	m_IntermediateKeyWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/IntermediateKeyWrapping"
	m_KMSKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KMSKeystoreOperations"
	m_KeyStore "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStore"
	m_KeyStoreErrorMessages "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStoreErrorMessages"
	m_Keyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Keyring"
	m_KmsArn "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KmsArn"
	m_LocalCMC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/LocalCMC"
	m_MaterialProviders "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MaterialProviders"
	m_MaterialWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MaterialWrapping"
	m_Materials "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Materials"
	m_MrkAwareDiscoveryMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MrkAwareDiscoveryMultiKeyring"
	m_MrkAwareStrictMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MrkAwareStrictMultiKeyring"
	m_MultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MultiKeyring"
	m_RawAESKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawAESKeyring"
	m_RawECDHKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawECDHKeyring"
	m_RawRSAKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawRSAKeyring"
	m_RequiredEncryptionContextCMM "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RequiredEncryptionContextCMM"
	m_StormTracker "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StormTracker"
	m_StormTrackingCMC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StormTrackingCMC"
	m_StrictMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StrictMultiKeyring"
	m_Structure "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Structure"
	m_SynchronizedLocalCMC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/SynchronizedLocalCMC"
	m_Utils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Utils"
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
	m_UnicodeStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UnicodeStrings"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
	m_Utf16EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf16EncodingForm"
	m_Utf8EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf8EncodingForm"
	m_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/Canonize"
	m__Maps "github.com/aws/aws-database-encryption-sdk-dynamodb/Maps_"
	m_OptimizedMergeSort "github.com/aws/aws-database-encryption-sdk-dynamodb/OptimizedMergeSort"
	m_Sets "github.com/aws/aws-database-encryption-sdk-dynamodb/Sets"
	m_SortCanon "github.com/aws/aws-database-encryption-sdk-dynamodb/SortCanon"
	m_StructuredEncryption "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryption"
	m_StructuredEncryptionCrypt "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionCrypt"
	m_StructuredEncryptionFooter "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionFooter"
	m_StructuredEncryptionHeader "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionHeader"
	m_StructuredEncryptionPaths "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionPaths"
	m_StructuredEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionUtil"
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
var _ m_AwsCryptographyKeyStoreTypes.Dummy__
var _ m_AwsCryptographyMaterialProvidersTypes.Dummy__
var _ m_Base64.Dummy__
var _ m_AlgorithmSuites.Dummy__
var _ m_Materials.Dummy__
var _ m_Keyring.Dummy__
var _ m_Relations.Dummy__
var _ m_Seq_MergeSort.Dummy__
var _ m__Math.Dummy__
var _ m_Seq.Dummy__
var _ m_Actions.Dummy__
var _ m_CanonicalEncryptionContext.Dummy__
var _ m_MaterialWrapping.Dummy__
var _ m_IntermediateKeyWrapping.Dummy__
var _ m_EdkWrapping.Dummy__
var _ m_ErrorMessages.Dummy__
var _ m_RawAESKeyring.Dummy__
var _ m_AwsArnParsing.Dummy__
var _ m_Constants.Dummy__
var _ m_EcdhEdkWrapping.Dummy__
var _ m_RawECDHKeyring.Dummy__
var _ m_RawRSAKeyring.Dummy__
var _ m_AwsKmsMrkMatchForDecrypt.Dummy__
var _ m_AwsKmsUtils.Dummy__
var _ m_AwsKmsKeyring.Dummy__
var _ m_AwsKmsDiscoveryKeyring.Dummy__
var _ m_AwsKmsEcdhKeyring.Dummy__
var _ m_FileIO.Dummy__
var _ m_LocalCMC.Dummy__
var _ m_SynchronizedLocalCMC.Dummy__
var _ m_StormTracker.Dummy__
var _ m_StormTrackingCMC.Dummy__
var _ m_CacheConstants.Dummy__
var _ m_AwsKmsHierarchicalKeyring.Dummy__
var _ m_AwsKmsMrkDiscoveryKeyring.Dummy__
var _ m_AwsKmsMrkKeyring.Dummy__
var _ m_AwsKmsRsaKeyring.Dummy__
var _ m_MultiKeyring.Dummy__
var _ m_AwsKmsMrkAreUnique.Dummy__
var _ m_StrictMultiKeyring.Dummy__
var _ m_Com_Amazonaws_Kms.Dummy__
var _ m_Com_Amazonaws_Dynamodb.Dummy__
var _ m_DiscoveryMultiKeyring.Dummy__
var _ m_MrkAwareDiscoveryMultiKeyring.Dummy__
var _ m_MrkAwareStrictMultiKeyring.Dummy__
var _ m_CMM.Dummy__
var _ m_Defaults.Dummy__
var _ m_Commitment.Dummy__
var _ m_DefaultCMM.Dummy__
var _ m_DefaultClientSupplier.Dummy__
var _ m_Utils.Dummy__
var _ m_RequiredEncryptionContextCMM.Dummy__
var _ m_AwsCryptographyMaterialProvidersOperations.Dummy__
var _ m_MaterialProviders.Dummy__
var _ m_KeyStoreErrorMessages.Dummy__
var _ m_KmsArn.Dummy__
var _ m_Structure.Dummy__
var _ m_KMSKeystoreOperations.Dummy__
var _ m_DDBKeystoreOperations.Dummy__
var _ m_CreateKeys.Dummy__
var _ m_CreateKeyStoreTable.Dummy__
var _ m_GetKeys.Dummy__
var _ m_AwsCryptographyKeyStoreOperations.Dummy__
var _ m_KeyStore.Dummy__
var _ m__Unicode.Dummy__
var _ m_Functions.Dummy__
var _ m_Utf8EncodingForm.Dummy__
var _ m_Utf16EncodingForm.Dummy__
var _ m_UnicodeStrings.Dummy__
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
var _ m_Base64Lemmas.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Dummy__
var _ m_StructuredEncryptionUtil.Dummy__
var _ m_Sets.Dummy__
var _ m_StructuredEncryptionPaths.Dummy__
var _ m_StructuredEncryptionHeader.Dummy__
var _ m_StructuredEncryptionFooter.Dummy__
var _ m_OptimizedMergeSort.Dummy__
var _ m_SortCanon.Dummy__
var _ m_Canonize.Dummy__
var _ m_StructuredEncryptionCrypt.Dummy__
var _ m__Maps.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations.Dummy__
var _ m_StructuredEncryption.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Dummy__

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
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Default__"
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
			return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DafnyCallEvent.DafnyCallEvent" + "(" + _dafny.String(data.Input) + ", " + _dafny.String(data.Output) + ")"
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
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DafnyCallEvent"
}
func (_this DafnyCallEvent) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DafnyCallEvent{}

// End of datatype DafnyCallEvent

// Definition of datatype DecryptItemInput
type DecryptItemInput struct {
	Data_DecryptItemInput_
}

func (_this DecryptItemInput) Get_() Data_DecryptItemInput_ {
	return _this.Data_DecryptItemInput_
}

type Data_DecryptItemInput_ interface {
	isDecryptItemInput()
}

type CompanionStruct_DecryptItemInput_ struct {
}

var Companion_DecryptItemInput_ = CompanionStruct_DecryptItemInput_{}

type DecryptItemInput_DecryptItemInput struct {
	EncryptedItem _dafny.Map
}

func (DecryptItemInput_DecryptItemInput) isDecryptItemInput() {}

func (CompanionStruct_DecryptItemInput_) Create_DecryptItemInput_(EncryptedItem _dafny.Map) DecryptItemInput {
	return DecryptItemInput{DecryptItemInput_DecryptItemInput{EncryptedItem}}
}

func (_this DecryptItemInput) Is_DecryptItemInput() bool {
	_, ok := _this.Get_().(DecryptItemInput_DecryptItemInput)
	return ok
}

func (CompanionStruct_DecryptItemInput_) Default() DecryptItemInput {
	return Companion_DecryptItemInput_.Create_DecryptItemInput_(_dafny.EmptyMap)
}

func (_this DecryptItemInput) Dtor_encryptedItem() _dafny.Map {
	return _this.Get_().(DecryptItemInput_DecryptItemInput).EncryptedItem
}

func (_this DecryptItemInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DecryptItemInput_DecryptItemInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemInput.DecryptItemInput" + "(" + _dafny.String(data.EncryptedItem) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DecryptItemInput) Equals(other DecryptItemInput) bool {
	switch data1 := _this.Get_().(type) {
	case DecryptItemInput_DecryptItemInput:
		{
			data2, ok := other.Get_().(DecryptItemInput_DecryptItemInput)
			return ok && data1.EncryptedItem.Equals(data2.EncryptedItem)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DecryptItemInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DecryptItemInput)
	return ok && _this.Equals(typed)
}

func Type_DecryptItemInput_() _dafny.TypeDescriptor {
	return type_DecryptItemInput_{}
}

type type_DecryptItemInput_ struct {
}

func (_this type_DecryptItemInput_) Default() interface{} {
	return Companion_DecryptItemInput_.Default()
}

func (_this type_DecryptItemInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemInput"
}
func (_this DecryptItemInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DecryptItemInput{}

// End of datatype DecryptItemInput

// Definition of datatype DecryptItemOutput
type DecryptItemOutput struct {
	Data_DecryptItemOutput_
}

func (_this DecryptItemOutput) Get_() Data_DecryptItemOutput_ {
	return _this.Data_DecryptItemOutput_
}

type Data_DecryptItemOutput_ interface {
	isDecryptItemOutput()
}

type CompanionStruct_DecryptItemOutput_ struct {
}

var Companion_DecryptItemOutput_ = CompanionStruct_DecryptItemOutput_{}

type DecryptItemOutput_DecryptItemOutput struct {
	PlaintextItem _dafny.Map
	ParsedHeader  m_Wrappers.Option
}

func (DecryptItemOutput_DecryptItemOutput) isDecryptItemOutput() {}

func (CompanionStruct_DecryptItemOutput_) Create_DecryptItemOutput_(PlaintextItem _dafny.Map, ParsedHeader m_Wrappers.Option) DecryptItemOutput {
	return DecryptItemOutput{DecryptItemOutput_DecryptItemOutput{PlaintextItem, ParsedHeader}}
}

func (_this DecryptItemOutput) Is_DecryptItemOutput() bool {
	_, ok := _this.Get_().(DecryptItemOutput_DecryptItemOutput)
	return ok
}

func (CompanionStruct_DecryptItemOutput_) Default() DecryptItemOutput {
	return Companion_DecryptItemOutput_.Create_DecryptItemOutput_(_dafny.EmptyMap, m_Wrappers.Companion_Option_.Default())
}

func (_this DecryptItemOutput) Dtor_plaintextItem() _dafny.Map {
	return _this.Get_().(DecryptItemOutput_DecryptItemOutput).PlaintextItem
}

func (_this DecryptItemOutput) Dtor_parsedHeader() m_Wrappers.Option {
	return _this.Get_().(DecryptItemOutput_DecryptItemOutput).ParsedHeader
}

func (_this DecryptItemOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DecryptItemOutput_DecryptItemOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput.DecryptItemOutput" + "(" + _dafny.String(data.PlaintextItem) + ", " + _dafny.String(data.ParsedHeader) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DecryptItemOutput) Equals(other DecryptItemOutput) bool {
	switch data1 := _this.Get_().(type) {
	case DecryptItemOutput_DecryptItemOutput:
		{
			data2, ok := other.Get_().(DecryptItemOutput_DecryptItemOutput)
			return ok && data1.PlaintextItem.Equals(data2.PlaintextItem) && data1.ParsedHeader.Equals(data2.ParsedHeader)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DecryptItemOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DecryptItemOutput)
	return ok && _this.Equals(typed)
}

func Type_DecryptItemOutput_() _dafny.TypeDescriptor {
	return type_DecryptItemOutput_{}
}

type type_DecryptItemOutput_ struct {
}

func (_this type_DecryptItemOutput_) Default() interface{} {
	return Companion_DecryptItemOutput_.Default()
}

func (_this type_DecryptItemOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput"
}
func (_this DecryptItemOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DecryptItemOutput{}

// End of datatype DecryptItemOutput

// Definition of class IDynamoDbItemEncryptorClientCallHistory
type IDynamoDbItemEncryptorClientCallHistory struct {
	dummy byte
}

func New_IDynamoDbItemEncryptorClientCallHistory_() *IDynamoDbItemEncryptorClientCallHistory {
	_this := IDynamoDbItemEncryptorClientCallHistory{}

	return &_this
}

type CompanionStruct_IDynamoDbItemEncryptorClientCallHistory_ struct {
}

var Companion_IDynamoDbItemEncryptorClientCallHistory_ = CompanionStruct_IDynamoDbItemEncryptorClientCallHistory_{}

func (_this *IDynamoDbItemEncryptorClientCallHistory) Equals(other *IDynamoDbItemEncryptorClientCallHistory) bool {
	return _this == other
}

func (_this *IDynamoDbItemEncryptorClientCallHistory) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*IDynamoDbItemEncryptorClientCallHistory)
	return ok && _this.Equals(other)
}

func (*IDynamoDbItemEncryptorClientCallHistory) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.IDynamoDbItemEncryptorClientCallHistory"
}

func Type_IDynamoDbItemEncryptorClientCallHistory_() _dafny.TypeDescriptor {
	return type_IDynamoDbItemEncryptorClientCallHistory_{}
}

type type_IDynamoDbItemEncryptorClientCallHistory_ struct {
}

func (_this type_IDynamoDbItemEncryptorClientCallHistory_) Default() interface{} {
	return (*IDynamoDbItemEncryptorClientCallHistory)(nil)
}

func (_this type_IDynamoDbItemEncryptorClientCallHistory_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.IDynamoDbItemEncryptorClientCallHistory"
}
func (_this *IDynamoDbItemEncryptorClientCallHistory) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &IDynamoDbItemEncryptorClientCallHistory{}

// End of class IDynamoDbItemEncryptorClientCallHistory

// Definition of trait IDynamoDbItemEncryptorClient
type IDynamoDbItemEncryptorClient interface {
	String() string
	EncryptItem(input EncryptItemInput) m_Wrappers.Result
	DecryptItem(input DecryptItemInput) m_Wrappers.Result
}
type CompanionStruct_IDynamoDbItemEncryptorClient_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_IDynamoDbItemEncryptorClient_ = CompanionStruct_IDynamoDbItemEncryptorClient_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_IDynamoDbItemEncryptorClient_) CastTo_(x interface{}) IDynamoDbItemEncryptorClient {
	var t IDynamoDbItemEncryptorClient
	t, _ = x.(IDynamoDbItemEncryptorClient)
	return t
}

// End of trait IDynamoDbItemEncryptorClient

// Definition of datatype DynamoDbItemEncryptorConfig
type DynamoDbItemEncryptorConfig struct {
	Data_DynamoDbItemEncryptorConfig_
}

func (_this DynamoDbItemEncryptorConfig) Get_() Data_DynamoDbItemEncryptorConfig_ {
	return _this.Data_DynamoDbItemEncryptorConfig_
}

type Data_DynamoDbItemEncryptorConfig_ interface {
	isDynamoDbItemEncryptorConfig()
}

type CompanionStruct_DynamoDbItemEncryptorConfig_ struct {
}

var Companion_DynamoDbItemEncryptorConfig_ = CompanionStruct_DynamoDbItemEncryptorConfig_{}

type DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig struct {
	LogicalTableName               _dafny.Sequence
	PartitionKeyName               _dafny.Sequence
	SortKeyName                    m_Wrappers.Option
	AttributeActionsOnEncrypt      _dafny.Map
	AllowedUnsignedAttributes      m_Wrappers.Option
	AllowedUnsignedAttributePrefix m_Wrappers.Option
	AlgorithmSuiteId               m_Wrappers.Option
	Keyring                        m_Wrappers.Option
	Cmm                            m_Wrappers.Option
	LegacyOverride                 m_Wrappers.Option
	PlaintextOverride              m_Wrappers.Option
}

func (DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig) isDynamoDbItemEncryptorConfig() {}

func (CompanionStruct_DynamoDbItemEncryptorConfig_) Create_DynamoDbItemEncryptorConfig_(LogicalTableName _dafny.Sequence, PartitionKeyName _dafny.Sequence, SortKeyName m_Wrappers.Option, AttributeActionsOnEncrypt _dafny.Map, AllowedUnsignedAttributes m_Wrappers.Option, AllowedUnsignedAttributePrefix m_Wrappers.Option, AlgorithmSuiteId m_Wrappers.Option, Keyring m_Wrappers.Option, Cmm m_Wrappers.Option, LegacyOverride m_Wrappers.Option, PlaintextOverride m_Wrappers.Option) DynamoDbItemEncryptorConfig {
	return DynamoDbItemEncryptorConfig{DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig{LogicalTableName, PartitionKeyName, SortKeyName, AttributeActionsOnEncrypt, AllowedUnsignedAttributes, AllowedUnsignedAttributePrefix, AlgorithmSuiteId, Keyring, Cmm, LegacyOverride, PlaintextOverride}}
}

func (_this DynamoDbItemEncryptorConfig) Is_DynamoDbItemEncryptorConfig() bool {
	_, ok := _this.Get_().(DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig)
	return ok
}

func (CompanionStruct_DynamoDbItemEncryptorConfig_) Default() DynamoDbItemEncryptorConfig {
	return Companion_DynamoDbItemEncryptorConfig_.Create_DynamoDbItemEncryptorConfig_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), _dafny.EmptyMap, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this DynamoDbItemEncryptorConfig) Dtor_logicalTableName() _dafny.Sequence {
	return _this.Get_().(DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig).LogicalTableName
}

func (_this DynamoDbItemEncryptorConfig) Dtor_partitionKeyName() _dafny.Sequence {
	return _this.Get_().(DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig).PartitionKeyName
}

func (_this DynamoDbItemEncryptorConfig) Dtor_sortKeyName() m_Wrappers.Option {
	return _this.Get_().(DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig).SortKeyName
}

func (_this DynamoDbItemEncryptorConfig) Dtor_attributeActionsOnEncrypt() _dafny.Map {
	return _this.Get_().(DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig).AttributeActionsOnEncrypt
}

func (_this DynamoDbItemEncryptorConfig) Dtor_allowedUnsignedAttributes() m_Wrappers.Option {
	return _this.Get_().(DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig).AllowedUnsignedAttributes
}

func (_this DynamoDbItemEncryptorConfig) Dtor_allowedUnsignedAttributePrefix() m_Wrappers.Option {
	return _this.Get_().(DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig).AllowedUnsignedAttributePrefix
}

func (_this DynamoDbItemEncryptorConfig) Dtor_algorithmSuiteId() m_Wrappers.Option {
	return _this.Get_().(DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig).AlgorithmSuiteId
}

func (_this DynamoDbItemEncryptorConfig) Dtor_keyring() m_Wrappers.Option {
	return _this.Get_().(DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig).Keyring
}

func (_this DynamoDbItemEncryptorConfig) Dtor_cmm() m_Wrappers.Option {
	return _this.Get_().(DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig).Cmm
}

func (_this DynamoDbItemEncryptorConfig) Dtor_legacyOverride() m_Wrappers.Option {
	return _this.Get_().(DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig).LegacyOverride
}

func (_this DynamoDbItemEncryptorConfig) Dtor_plaintextOverride() m_Wrappers.Option {
	return _this.Get_().(DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig).PlaintextOverride
}

func (_this DynamoDbItemEncryptorConfig) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig.DynamoDbItemEncryptorConfig" + "(" + _dafny.String(data.LogicalTableName) + ", " + _dafny.String(data.PartitionKeyName) + ", " + _dafny.String(data.SortKeyName) + ", " + _dafny.String(data.AttributeActionsOnEncrypt) + ", " + _dafny.String(data.AllowedUnsignedAttributes) + ", " + _dafny.String(data.AllowedUnsignedAttributePrefix) + ", " + _dafny.String(data.AlgorithmSuiteId) + ", " + _dafny.String(data.Keyring) + ", " + _dafny.String(data.Cmm) + ", " + _dafny.String(data.LegacyOverride) + ", " + _dafny.String(data.PlaintextOverride) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DynamoDbItemEncryptorConfig) Equals(other DynamoDbItemEncryptorConfig) bool {
	switch data1 := _this.Get_().(type) {
	case DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig:
		{
			data2, ok := other.Get_().(DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig)
			return ok && data1.LogicalTableName.Equals(data2.LogicalTableName) && data1.PartitionKeyName.Equals(data2.PartitionKeyName) && data1.SortKeyName.Equals(data2.SortKeyName) && data1.AttributeActionsOnEncrypt.Equals(data2.AttributeActionsOnEncrypt) && data1.AllowedUnsignedAttributes.Equals(data2.AllowedUnsignedAttributes) && data1.AllowedUnsignedAttributePrefix.Equals(data2.AllowedUnsignedAttributePrefix) && data1.AlgorithmSuiteId.Equals(data2.AlgorithmSuiteId) && data1.Keyring.Equals(data2.Keyring) && data1.Cmm.Equals(data2.Cmm) && data1.LegacyOverride.Equals(data2.LegacyOverride) && data1.PlaintextOverride.Equals(data2.PlaintextOverride)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DynamoDbItemEncryptorConfig) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DynamoDbItemEncryptorConfig)
	return ok && _this.Equals(typed)
}

func Type_DynamoDbItemEncryptorConfig_() _dafny.TypeDescriptor {
	return type_DynamoDbItemEncryptorConfig_{}
}

type type_DynamoDbItemEncryptorConfig_ struct {
}

func (_this type_DynamoDbItemEncryptorConfig_) Default() interface{} {
	return Companion_DynamoDbItemEncryptorConfig_.Default()
}

func (_this type_DynamoDbItemEncryptorConfig_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig"
}
func (_this DynamoDbItemEncryptorConfig) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DynamoDbItemEncryptorConfig{}

// End of datatype DynamoDbItemEncryptorConfig

// Definition of datatype EncryptItemInput
type EncryptItemInput struct {
	Data_EncryptItemInput_
}

func (_this EncryptItemInput) Get_() Data_EncryptItemInput_ {
	return _this.Data_EncryptItemInput_
}

type Data_EncryptItemInput_ interface {
	isEncryptItemInput()
}

type CompanionStruct_EncryptItemInput_ struct {
}

var Companion_EncryptItemInput_ = CompanionStruct_EncryptItemInput_{}

type EncryptItemInput_EncryptItemInput struct {
	PlaintextItem _dafny.Map
}

func (EncryptItemInput_EncryptItemInput) isEncryptItemInput() {}

func (CompanionStruct_EncryptItemInput_) Create_EncryptItemInput_(PlaintextItem _dafny.Map) EncryptItemInput {
	return EncryptItemInput{EncryptItemInput_EncryptItemInput{PlaintextItem}}
}

func (_this EncryptItemInput) Is_EncryptItemInput() bool {
	_, ok := _this.Get_().(EncryptItemInput_EncryptItemInput)
	return ok
}

func (CompanionStruct_EncryptItemInput_) Default() EncryptItemInput {
	return Companion_EncryptItemInput_.Create_EncryptItemInput_(_dafny.EmptyMap)
}

func (_this EncryptItemInput) Dtor_plaintextItem() _dafny.Map {
	return _this.Get_().(EncryptItemInput_EncryptItemInput).PlaintextItem
}

func (_this EncryptItemInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EncryptItemInput_EncryptItemInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemInput.EncryptItemInput" + "(" + _dafny.String(data.PlaintextItem) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EncryptItemInput) Equals(other EncryptItemInput) bool {
	switch data1 := _this.Get_().(type) {
	case EncryptItemInput_EncryptItemInput:
		{
			data2, ok := other.Get_().(EncryptItemInput_EncryptItemInput)
			return ok && data1.PlaintextItem.Equals(data2.PlaintextItem)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EncryptItemInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EncryptItemInput)
	return ok && _this.Equals(typed)
}

func Type_EncryptItemInput_() _dafny.TypeDescriptor {
	return type_EncryptItemInput_{}
}

type type_EncryptItemInput_ struct {
}

func (_this type_EncryptItemInput_) Default() interface{} {
	return Companion_EncryptItemInput_.Default()
}

func (_this type_EncryptItemInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemInput"
}
func (_this EncryptItemInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EncryptItemInput{}

// End of datatype EncryptItemInput

// Definition of datatype EncryptItemOutput
type EncryptItemOutput struct {
	Data_EncryptItemOutput_
}

func (_this EncryptItemOutput) Get_() Data_EncryptItemOutput_ {
	return _this.Data_EncryptItemOutput_
}

type Data_EncryptItemOutput_ interface {
	isEncryptItemOutput()
}

type CompanionStruct_EncryptItemOutput_ struct {
}

var Companion_EncryptItemOutput_ = CompanionStruct_EncryptItemOutput_{}

type EncryptItemOutput_EncryptItemOutput struct {
	EncryptedItem _dafny.Map
	ParsedHeader  m_Wrappers.Option
}

func (EncryptItemOutput_EncryptItemOutput) isEncryptItemOutput() {}

func (CompanionStruct_EncryptItemOutput_) Create_EncryptItemOutput_(EncryptedItem _dafny.Map, ParsedHeader m_Wrappers.Option) EncryptItemOutput {
	return EncryptItemOutput{EncryptItemOutput_EncryptItemOutput{EncryptedItem, ParsedHeader}}
}

func (_this EncryptItemOutput) Is_EncryptItemOutput() bool {
	_, ok := _this.Get_().(EncryptItemOutput_EncryptItemOutput)
	return ok
}

func (CompanionStruct_EncryptItemOutput_) Default() EncryptItemOutput {
	return Companion_EncryptItemOutput_.Create_EncryptItemOutput_(_dafny.EmptyMap, m_Wrappers.Companion_Option_.Default())
}

func (_this EncryptItemOutput) Dtor_encryptedItem() _dafny.Map {
	return _this.Get_().(EncryptItemOutput_EncryptItemOutput).EncryptedItem
}

func (_this EncryptItemOutput) Dtor_parsedHeader() m_Wrappers.Option {
	return _this.Get_().(EncryptItemOutput_EncryptItemOutput).ParsedHeader
}

func (_this EncryptItemOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EncryptItemOutput_EncryptItemOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput.EncryptItemOutput" + "(" + _dafny.String(data.EncryptedItem) + ", " + _dafny.String(data.ParsedHeader) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EncryptItemOutput) Equals(other EncryptItemOutput) bool {
	switch data1 := _this.Get_().(type) {
	case EncryptItemOutput_EncryptItemOutput:
		{
			data2, ok := other.Get_().(EncryptItemOutput_EncryptItemOutput)
			return ok && data1.EncryptedItem.Equals(data2.EncryptedItem) && data1.ParsedHeader.Equals(data2.ParsedHeader)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EncryptItemOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EncryptItemOutput)
	return ok && _this.Equals(typed)
}

func Type_EncryptItemOutput_() _dafny.TypeDescriptor {
	return type_EncryptItemOutput_{}
}

type type_EncryptItemOutput_ struct {
}

func (_this type_EncryptItemOutput_) Default() interface{} {
	return Companion_EncryptItemOutput_.Default()
}

func (_this type_EncryptItemOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput"
}
func (_this EncryptItemOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EncryptItemOutput{}

// End of datatype EncryptItemOutput

// Definition of datatype ParsedHeader
type ParsedHeader struct {
	Data_ParsedHeader_
}

func (_this ParsedHeader) Get_() Data_ParsedHeader_ {
	return _this.Data_ParsedHeader_
}

type Data_ParsedHeader_ interface {
	isParsedHeader()
}

type CompanionStruct_ParsedHeader_ struct {
}

var Companion_ParsedHeader_ = CompanionStruct_ParsedHeader_{}

type ParsedHeader_ParsedHeader struct {
	AttributeActionsOnEncrypt _dafny.Map
	AlgorithmSuiteId          m_AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId
	EncryptedDataKeys         _dafny.Sequence
	StoredEncryptionContext   _dafny.Map
	EncryptionContext         _dafny.Map
	SelectorContext           _dafny.Map
}

func (ParsedHeader_ParsedHeader) isParsedHeader() {}

func (CompanionStruct_ParsedHeader_) Create_ParsedHeader_(AttributeActionsOnEncrypt _dafny.Map, AlgorithmSuiteId m_AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId, EncryptedDataKeys _dafny.Sequence, StoredEncryptionContext _dafny.Map, EncryptionContext _dafny.Map, SelectorContext _dafny.Map) ParsedHeader {
	return ParsedHeader{ParsedHeader_ParsedHeader{AttributeActionsOnEncrypt, AlgorithmSuiteId, EncryptedDataKeys, StoredEncryptionContext, EncryptionContext, SelectorContext}}
}

func (_this ParsedHeader) Is_ParsedHeader() bool {
	_, ok := _this.Get_().(ParsedHeader_ParsedHeader)
	return ok
}

func (CompanionStruct_ParsedHeader_) Default() ParsedHeader {
	return Companion_ParsedHeader_.Create_ParsedHeader_(_dafny.EmptyMap, m_AwsCryptographyMaterialProvidersTypes.Companion_DBEAlgorithmSuiteId_.Default(), _dafny.EmptySeq, _dafny.EmptyMap, _dafny.EmptyMap, _dafny.EmptyMap)
}

func (_this ParsedHeader) Dtor_attributeActionsOnEncrypt() _dafny.Map {
	return _this.Get_().(ParsedHeader_ParsedHeader).AttributeActionsOnEncrypt
}

func (_this ParsedHeader) Dtor_algorithmSuiteId() m_AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId {
	return _this.Get_().(ParsedHeader_ParsedHeader).AlgorithmSuiteId
}

func (_this ParsedHeader) Dtor_encryptedDataKeys() _dafny.Sequence {
	return _this.Get_().(ParsedHeader_ParsedHeader).EncryptedDataKeys
}

func (_this ParsedHeader) Dtor_storedEncryptionContext() _dafny.Map {
	return _this.Get_().(ParsedHeader_ParsedHeader).StoredEncryptionContext
}

func (_this ParsedHeader) Dtor_encryptionContext() _dafny.Map {
	return _this.Get_().(ParsedHeader_ParsedHeader).EncryptionContext
}

func (_this ParsedHeader) Dtor_selectorContext() _dafny.Map {
	return _this.Get_().(ParsedHeader_ParsedHeader).SelectorContext
}

func (_this ParsedHeader) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ParsedHeader_ParsedHeader:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader.ParsedHeader" + "(" + _dafny.String(data.AttributeActionsOnEncrypt) + ", " + _dafny.String(data.AlgorithmSuiteId) + ", " + _dafny.String(data.EncryptedDataKeys) + ", " + _dafny.String(data.StoredEncryptionContext) + ", " + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.SelectorContext) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ParsedHeader) Equals(other ParsedHeader) bool {
	switch data1 := _this.Get_().(type) {
	case ParsedHeader_ParsedHeader:
		{
			data2, ok := other.Get_().(ParsedHeader_ParsedHeader)
			return ok && data1.AttributeActionsOnEncrypt.Equals(data2.AttributeActionsOnEncrypt) && data1.AlgorithmSuiteId.Equals(data2.AlgorithmSuiteId) && data1.EncryptedDataKeys.Equals(data2.EncryptedDataKeys) && data1.StoredEncryptionContext.Equals(data2.StoredEncryptionContext) && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.SelectorContext.Equals(data2.SelectorContext)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ParsedHeader) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ParsedHeader)
	return ok && _this.Equals(typed)
}

func Type_ParsedHeader_() _dafny.TypeDescriptor {
	return type_ParsedHeader_{}
}

type type_ParsedHeader_ struct {
}

func (_this type_ParsedHeader_) Default() interface{} {
	return Companion_ParsedHeader_.Default()
}

func (_this type_ParsedHeader_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader"
}
func (_this ParsedHeader) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ParsedHeader{}

// End of datatype ParsedHeader

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

type Error_DynamoDbItemEncryptorException struct {
	Message _dafny.Sequence
}

func (Error_DynamoDbItemEncryptorException) isError() {}

func (CompanionStruct_Error_) Create_DynamoDbItemEncryptorException_(Message _dafny.Sequence) Error {
	return Error{Error_DynamoDbItemEncryptorException{Message}}
}

func (_this Error) Is_DynamoDbItemEncryptorException() bool {
	_, ok := _this.Get_().(Error_DynamoDbItemEncryptorException)
	return ok
}

type Error_AwsCryptographyDbEncryptionSdkDynamoDb struct {
	AwsCryptographyDbEncryptionSdkDynamoDb m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error
}

func (Error_AwsCryptographyDbEncryptionSdkDynamoDb) isError() {}

func (CompanionStruct_Error_) Create_AwsCryptographyDbEncryptionSdkDynamoDb_(AwsCryptographyDbEncryptionSdkDynamoDb m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) Error {
	return Error{Error_AwsCryptographyDbEncryptionSdkDynamoDb{AwsCryptographyDbEncryptionSdkDynamoDb}}
}

func (_this Error) Is_AwsCryptographyDbEncryptionSdkDynamoDb() bool {
	_, ok := _this.Get_().(Error_AwsCryptographyDbEncryptionSdkDynamoDb)
	return ok
}

type Error_AwsCryptographyDbEncryptionSdkStructuredEncryption struct {
	AwsCryptographyDbEncryptionSdkStructuredEncryption m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error
}

func (Error_AwsCryptographyDbEncryptionSdkStructuredEncryption) isError() {}

func (CompanionStruct_Error_) Create_AwsCryptographyDbEncryptionSdkStructuredEncryption_(AwsCryptographyDbEncryptionSdkStructuredEncryption m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) Error {
	return Error{Error_AwsCryptographyDbEncryptionSdkStructuredEncryption{AwsCryptographyDbEncryptionSdkStructuredEncryption}}
}

func (_this Error) Is_AwsCryptographyDbEncryptionSdkStructuredEncryption() bool {
	_, ok := _this.Get_().(Error_AwsCryptographyDbEncryptionSdkStructuredEncryption)
	return ok
}

type Error_AwsCryptographyMaterialProviders struct {
	AwsCryptographyMaterialProviders m_AwsCryptographyMaterialProvidersTypes.Error
}

func (Error_AwsCryptographyMaterialProviders) isError() {}

func (CompanionStruct_Error_) Create_AwsCryptographyMaterialProviders_(AwsCryptographyMaterialProviders m_AwsCryptographyMaterialProvidersTypes.Error) Error {
	return Error{Error_AwsCryptographyMaterialProviders{AwsCryptographyMaterialProviders}}
}

func (_this Error) Is_AwsCryptographyMaterialProviders() bool {
	_, ok := _this.Get_().(Error_AwsCryptographyMaterialProviders)
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
	return Companion_Error_.Create_DynamoDbItemEncryptorException_(_dafny.EmptySeq.SetString())
}

func (_this Error) Dtor_message() _dafny.Sequence {
	switch data := _this.Get_().(type) {
	case Error_DynamoDbItemEncryptorException:
		return data.Message
	default:
		return data.(Error_CollectionOfErrors).Message
	}
}

func (_this Error) Dtor_AwsCryptographyDbEncryptionSdkDynamoDb() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
	return _this.Get_().(Error_AwsCryptographyDbEncryptionSdkDynamoDb).AwsCryptographyDbEncryptionSdkDynamoDb
}

func (_this Error) Dtor_AwsCryptographyDbEncryptionSdkStructuredEncryption() m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
	return _this.Get_().(Error_AwsCryptographyDbEncryptionSdkStructuredEncryption).AwsCryptographyDbEncryptionSdkStructuredEncryption
}

func (_this Error) Dtor_AwsCryptographyMaterialProviders() m_AwsCryptographyMaterialProvidersTypes.Error {
	return _this.Get_().(Error_AwsCryptographyMaterialProviders).AwsCryptographyMaterialProviders
}

func (_this Error) Dtor_AwsCryptographyPrimitives() m_AwsCryptographyPrimitivesTypes.Error {
	return _this.Get_().(Error_AwsCryptographyPrimitives).AwsCryptographyPrimitives
}

func (_this Error) Dtor_ComAmazonawsDynamodb() m_ComAmazonawsDynamodbTypes.Error {
	return _this.Get_().(Error_ComAmazonawsDynamodb).ComAmazonawsDynamodb
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
	case Error_DynamoDbItemEncryptorException:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error.DynamoDbItemEncryptorException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_AwsCryptographyDbEncryptionSdkDynamoDb:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error.AwsCryptographyDbEncryptionSdkDynamoDb" + "(" + _dafny.String(data.AwsCryptographyDbEncryptionSdkDynamoDb) + ")"
		}
	case Error_AwsCryptographyDbEncryptionSdkStructuredEncryption:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error.AwsCryptographyDbEncryptionSdkStructuredEncryption" + "(" + _dafny.String(data.AwsCryptographyDbEncryptionSdkStructuredEncryption) + ")"
		}
	case Error_AwsCryptographyMaterialProviders:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error.AwsCryptographyMaterialProviders" + "(" + _dafny.String(data.AwsCryptographyMaterialProviders) + ")"
		}
	case Error_AwsCryptographyPrimitives:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error.AwsCryptographyPrimitives" + "(" + _dafny.String(data.AwsCryptographyPrimitives) + ")"
		}
	case Error_ComAmazonawsDynamodb:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error.ComAmazonawsDynamodb" + "(" + _dafny.String(data.ComAmazonawsDynamodb) + ")"
		}
	case Error_CollectionOfErrors:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error.CollectionOfErrors" + "(" + _dafny.String(data.List) + ", " + _dafny.String(data.Message) + ")"
		}
	case Error_Opaque:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error.Opaque" + "(" + _dafny.String(data.Obj) + ")"
		}
	case Error_OpaqueWithText:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error.OpaqueWithText" + "(" + _dafny.String(data.Obj) + ", " + _dafny.String(data.ObjMessage) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Error) Equals(other Error) bool {
	switch data1 := _this.Get_().(type) {
	case Error_DynamoDbItemEncryptorException:
		{
			data2, ok := other.Get_().(Error_DynamoDbItemEncryptorException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_AwsCryptographyDbEncryptionSdkDynamoDb:
		{
			data2, ok := other.Get_().(Error_AwsCryptographyDbEncryptionSdkDynamoDb)
			return ok && data1.AwsCryptographyDbEncryptionSdkDynamoDb.Equals(data2.AwsCryptographyDbEncryptionSdkDynamoDb)
		}
	case Error_AwsCryptographyDbEncryptionSdkStructuredEncryption:
		{
			data2, ok := other.Get_().(Error_AwsCryptographyDbEncryptionSdkStructuredEncryption)
			return ok && data1.AwsCryptographyDbEncryptionSdkStructuredEncryption.Equals(data2.AwsCryptographyDbEncryptionSdkStructuredEncryption)
		}
	case Error_AwsCryptographyMaterialProviders:
		{
			data2, ok := other.Get_().(Error_AwsCryptographyMaterialProviders)
			return ok && data1.AwsCryptographyMaterialProviders.Equals(data2.AwsCryptographyMaterialProviders)
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
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error"
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
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.OpaqueError"
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
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.OpaqueError"
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
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DummySubsetType"
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
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DummySubsetType"
}
func (_this *CompanionStruct_DummySubsetType_) Is_(__source _dafny.Int) bool {
	var _1_x _dafny.Int = (__source)
	_ = _1_x
	return Companion_Default___.IsDummySubsetType(_1_x)
}
