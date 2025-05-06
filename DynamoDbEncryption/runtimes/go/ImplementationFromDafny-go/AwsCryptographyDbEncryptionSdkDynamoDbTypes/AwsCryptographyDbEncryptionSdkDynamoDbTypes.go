// Package AwsCryptographyDbEncryptionSdkDynamoDbTypes
// Dafny module AwsCryptographyDbEncryptionSdkDynamoDbTypes compiled into Go

package AwsCryptographyDbEncryptionSdkDynamoDbTypes

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
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) IsValid__BeaconBitLength(x int32) bool {
	return ((int32(1)) <= (x)) && ((x) <= (int32(63)))
}
func (_static *CompanionStruct_Default___) IsValid__BeaconVersionList(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.One) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__Char(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.One) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__CompoundBeaconList(x _dafny.Sequence) bool {
	return (_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0
}
func (_static *CompanionStruct_Default___) IsValid__ConstructorList(x _dafny.Sequence) bool {
	return (_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0
}
func (_static *CompanionStruct_Default___) IsValid__ConstructorPartList(x _dafny.Sequence) bool {
	return (_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0
}
func (_static *CompanionStruct_Default___) IsValid__EncryptedPartsList(x _dafny.Sequence) bool {
	return (_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0
}
func (_static *CompanionStruct_Default___) IsValid__Prefix(x _dafny.Sequence) bool {
	return (_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0
}
func (_static *CompanionStruct_Default___) IsValid__SignedPartsList(x _dafny.Sequence) bool {
	return (_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0
}
func (_static *CompanionStruct_Default___) IsValid__StandardBeaconList(x _dafny.Sequence) bool {
	return (_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0
}
func (_static *CompanionStruct_Default___) IsValid__TerminalLocation(x _dafny.Sequence) bool {
	return (_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0
}
func (_static *CompanionStruct_Default___) IsValid__VersionNumber(x int32) bool {
	return (int32(1)) <= (x)
}
func (_static *CompanionStruct_Default___) IsValid__VirtualFieldList(x _dafny.Sequence) bool {
	return (_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0
}
func (_static *CompanionStruct_Default___) IsValid__VirtualPartList(x _dafny.Sequence) bool {
	return (_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0
}
func (_static *CompanionStruct_Default___) IsValid__VirtualTransformList(x _dafny.Sequence) bool {
	return (_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0
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
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.DafnyCallEvent.DafnyCallEvent" + "(" + _dafny.String(data.Input) + ", " + _dafny.String(data.Output) + ")"
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
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.DafnyCallEvent"
}
func (_this DafnyCallEvent) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DafnyCallEvent{}

// End of datatype DafnyCallEvent

// Definition of datatype AsSet
type AsSet struct {
	Data_AsSet_
}

func (_this AsSet) Get_() Data_AsSet_ {
	return _this.Data_AsSet_
}

type Data_AsSet_ interface {
	isAsSet()
}

type CompanionStruct_AsSet_ struct {
}

var Companion_AsSet_ = CompanionStruct_AsSet_{}

type AsSet_AsSet struct {
}

func (AsSet_AsSet) isAsSet() {}

func (CompanionStruct_AsSet_) Create_AsSet_() AsSet {
	return AsSet{AsSet_AsSet{}}
}

func (_this AsSet) Is_AsSet() bool {
	_, ok := _this.Get_().(AsSet_AsSet)
	return ok
}

func (CompanionStruct_AsSet_) Default() AsSet {
	return Companion_AsSet_.Create_AsSet_()
}

func (_ CompanionStruct_AsSet_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_AsSet_.Create_AsSet_(), true
		default:
			return AsSet{}, false
		}
	}
}

func (_this AsSet) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case AsSet_AsSet:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.AsSet.AsSet"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AsSet) Equals(other AsSet) bool {
	switch _this.Get_().(type) {
	case AsSet_AsSet:
		{
			_, ok := other.Get_().(AsSet_AsSet)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AsSet) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AsSet)
	return ok && _this.Equals(typed)
}

func Type_AsSet_() _dafny.TypeDescriptor {
	return type_AsSet_{}
}

type type_AsSet_ struct {
}

func (_this type_AsSet_) Default() interface{} {
	return Companion_AsSet_.Default()
}

func (_this type_AsSet_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.AsSet"
}
func (_this AsSet) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AsSet{}

// End of datatype AsSet

// Definition of class BeaconBitLength
type BeaconBitLength struct {
}

func New_BeaconBitLength_() *BeaconBitLength {
	_this := BeaconBitLength{}

	return &_this
}

type CompanionStruct_BeaconBitLength_ struct {
}

var Companion_BeaconBitLength_ = CompanionStruct_BeaconBitLength_{}

func (*BeaconBitLength) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconBitLength"
}

// End of class BeaconBitLength

func Type_BeaconBitLength_() _dafny.TypeDescriptor {
	return type_BeaconBitLength_{}
}

type type_BeaconBitLength_ struct {
}

func (_this type_BeaconBitLength_) Default() interface{} {
	return int32(0)
}

func (_this type_BeaconBitLength_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconBitLength"
}
func (_this *CompanionStruct_BeaconBitLength_) Is_(__source int32) bool {
	var _0_x int32 = (__source)
	_ = _0_x
	if true {
		return Companion_Default___.IsValid__BeaconBitLength(_0_x)
	}
	return false
}

// Definition of datatype BeaconKeySource
type BeaconKeySource struct {
	Data_BeaconKeySource_
}

func (_this BeaconKeySource) Get_() Data_BeaconKeySource_ {
	return _this.Data_BeaconKeySource_
}

type Data_BeaconKeySource_ interface {
	isBeaconKeySource()
}

type CompanionStruct_BeaconKeySource_ struct {
}

var Companion_BeaconKeySource_ = CompanionStruct_BeaconKeySource_{}

type BeaconKeySource_single struct {
	Single SingleKeyStore
}

func (BeaconKeySource_single) isBeaconKeySource() {}

func (CompanionStruct_BeaconKeySource_) Create_single_(Single SingleKeyStore) BeaconKeySource {
	return BeaconKeySource{BeaconKeySource_single{Single}}
}

func (_this BeaconKeySource) Is_single() bool {
	_, ok := _this.Get_().(BeaconKeySource_single)
	return ok
}

type BeaconKeySource_multi struct {
	Multi MultiKeyStore
}

func (BeaconKeySource_multi) isBeaconKeySource() {}

func (CompanionStruct_BeaconKeySource_) Create_multi_(Multi MultiKeyStore) BeaconKeySource {
	return BeaconKeySource{BeaconKeySource_multi{Multi}}
}

func (_this BeaconKeySource) Is_multi() bool {
	_, ok := _this.Get_().(BeaconKeySource_multi)
	return ok
}

func (CompanionStruct_BeaconKeySource_) Default() BeaconKeySource {
	return Companion_BeaconKeySource_.Create_single_(Companion_SingleKeyStore_.Default())
}

func (_this BeaconKeySource) Dtor_single() SingleKeyStore {
	return _this.Get_().(BeaconKeySource_single).Single
}

func (_this BeaconKeySource) Dtor_multi() MultiKeyStore {
	return _this.Get_().(BeaconKeySource_multi).Multi
}

func (_this BeaconKeySource) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BeaconKeySource_single:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconKeySource.single" + "(" + _dafny.String(data.Single) + ")"
		}
	case BeaconKeySource_multi:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconKeySource.multi" + "(" + _dafny.String(data.Multi) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BeaconKeySource) Equals(other BeaconKeySource) bool {
	switch data1 := _this.Get_().(type) {
	case BeaconKeySource_single:
		{
			data2, ok := other.Get_().(BeaconKeySource_single)
			return ok && data1.Single.Equals(data2.Single)
		}
	case BeaconKeySource_multi:
		{
			data2, ok := other.Get_().(BeaconKeySource_multi)
			return ok && data1.Multi.Equals(data2.Multi)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BeaconKeySource) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BeaconKeySource)
	return ok && _this.Equals(typed)
}

func Type_BeaconKeySource_() _dafny.TypeDescriptor {
	return type_BeaconKeySource_{}
}

type type_BeaconKeySource_ struct {
}

func (_this type_BeaconKeySource_) Default() interface{} {
	return Companion_BeaconKeySource_.Default()
}

func (_this type_BeaconKeySource_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconKeySource"
}
func (_this BeaconKeySource) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BeaconKeySource{}

// End of datatype BeaconKeySource

// Definition of datatype BeaconStyle
type BeaconStyle struct {
	Data_BeaconStyle_
}

func (_this BeaconStyle) Get_() Data_BeaconStyle_ {
	return _this.Data_BeaconStyle_
}

type Data_BeaconStyle_ interface {
	isBeaconStyle()
}

type CompanionStruct_BeaconStyle_ struct {
}

var Companion_BeaconStyle_ = CompanionStruct_BeaconStyle_{}

type BeaconStyle_partOnly struct {
	PartOnly PartOnly
}

func (BeaconStyle_partOnly) isBeaconStyle() {}

func (CompanionStruct_BeaconStyle_) Create_partOnly_(PartOnly PartOnly) BeaconStyle {
	return BeaconStyle{BeaconStyle_partOnly{PartOnly}}
}

func (_this BeaconStyle) Is_partOnly() bool {
	_, ok := _this.Get_().(BeaconStyle_partOnly)
	return ok
}

type BeaconStyle_shared struct {
	Shared Shared
}

func (BeaconStyle_shared) isBeaconStyle() {}

func (CompanionStruct_BeaconStyle_) Create_shared_(Shared Shared) BeaconStyle {
	return BeaconStyle{BeaconStyle_shared{Shared}}
}

func (_this BeaconStyle) Is_shared() bool {
	_, ok := _this.Get_().(BeaconStyle_shared)
	return ok
}

type BeaconStyle_asSet struct {
	AsSet AsSet
}

func (BeaconStyle_asSet) isBeaconStyle() {}

func (CompanionStruct_BeaconStyle_) Create_asSet_(AsSet AsSet) BeaconStyle {
	return BeaconStyle{BeaconStyle_asSet{AsSet}}
}

func (_this BeaconStyle) Is_asSet() bool {
	_, ok := _this.Get_().(BeaconStyle_asSet)
	return ok
}

type BeaconStyle_sharedSet struct {
	SharedSet SharedSet
}

func (BeaconStyle_sharedSet) isBeaconStyle() {}

func (CompanionStruct_BeaconStyle_) Create_sharedSet_(SharedSet SharedSet) BeaconStyle {
	return BeaconStyle{BeaconStyle_sharedSet{SharedSet}}
}

func (_this BeaconStyle) Is_sharedSet() bool {
	_, ok := _this.Get_().(BeaconStyle_sharedSet)
	return ok
}

func (CompanionStruct_BeaconStyle_) Default() BeaconStyle {
	return Companion_BeaconStyle_.Create_partOnly_(Companion_PartOnly_.Default())
}

func (_this BeaconStyle) Dtor_partOnly() PartOnly {
	return _this.Get_().(BeaconStyle_partOnly).PartOnly
}

func (_this BeaconStyle) Dtor_shared() Shared {
	return _this.Get_().(BeaconStyle_shared).Shared
}

func (_this BeaconStyle) Dtor_asSet() AsSet {
	return _this.Get_().(BeaconStyle_asSet).AsSet
}

func (_this BeaconStyle) Dtor_sharedSet() SharedSet {
	return _this.Get_().(BeaconStyle_sharedSet).SharedSet
}

func (_this BeaconStyle) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BeaconStyle_partOnly:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconStyle.partOnly" + "(" + _dafny.String(data.PartOnly) + ")"
		}
	case BeaconStyle_shared:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconStyle.shared" + "(" + _dafny.String(data.Shared) + ")"
		}
	case BeaconStyle_asSet:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconStyle.asSet" + "(" + _dafny.String(data.AsSet) + ")"
		}
	case BeaconStyle_sharedSet:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconStyle.sharedSet" + "(" + _dafny.String(data.SharedSet) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BeaconStyle) Equals(other BeaconStyle) bool {
	switch data1 := _this.Get_().(type) {
	case BeaconStyle_partOnly:
		{
			data2, ok := other.Get_().(BeaconStyle_partOnly)
			return ok && data1.PartOnly.Equals(data2.PartOnly)
		}
	case BeaconStyle_shared:
		{
			data2, ok := other.Get_().(BeaconStyle_shared)
			return ok && data1.Shared.Equals(data2.Shared)
		}
	case BeaconStyle_asSet:
		{
			data2, ok := other.Get_().(BeaconStyle_asSet)
			return ok && data1.AsSet.Equals(data2.AsSet)
		}
	case BeaconStyle_sharedSet:
		{
			data2, ok := other.Get_().(BeaconStyle_sharedSet)
			return ok && data1.SharedSet.Equals(data2.SharedSet)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BeaconStyle) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BeaconStyle)
	return ok && _this.Equals(typed)
}

func Type_BeaconStyle_() _dafny.TypeDescriptor {
	return type_BeaconStyle_{}
}

type type_BeaconStyle_ struct {
}

func (_this type_BeaconStyle_) Default() interface{} {
	return Companion_BeaconStyle_.Default()
}

func (_this type_BeaconStyle_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconStyle"
}
func (_this BeaconStyle) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BeaconStyle{}

// End of datatype BeaconStyle

// Definition of datatype BeaconVersion
type BeaconVersion struct {
	Data_BeaconVersion_
}

func (_this BeaconVersion) Get_() Data_BeaconVersion_ {
	return _this.Data_BeaconVersion_
}

type Data_BeaconVersion_ interface {
	isBeaconVersion()
}

type CompanionStruct_BeaconVersion_ struct {
}

var Companion_BeaconVersion_ = CompanionStruct_BeaconVersion_{}

type BeaconVersion_BeaconVersion struct {
	Version         int32
	KeyStore        m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	KeySource       BeaconKeySource
	StandardBeacons _dafny.Sequence
	CompoundBeacons m_Wrappers.Option
	VirtualFields   m_Wrappers.Option
	EncryptedParts  m_Wrappers.Option
	SignedParts     m_Wrappers.Option
}

func (BeaconVersion_BeaconVersion) isBeaconVersion() {}

func (CompanionStruct_BeaconVersion_) Create_BeaconVersion_(Version int32, KeyStore m_AwsCryptographyKeyStoreTypes.IKeyStoreClient, KeySource BeaconKeySource, StandardBeacons _dafny.Sequence, CompoundBeacons m_Wrappers.Option, VirtualFields m_Wrappers.Option, EncryptedParts m_Wrappers.Option, SignedParts m_Wrappers.Option) BeaconVersion {
	return BeaconVersion{BeaconVersion_BeaconVersion{Version, KeyStore, KeySource, StandardBeacons, CompoundBeacons, VirtualFields, EncryptedParts, SignedParts}}
}

func (_this BeaconVersion) Is_BeaconVersion() bool {
	_, ok := _this.Get_().(BeaconVersion_BeaconVersion)
	return ok
}

func (CompanionStruct_BeaconVersion_) Default() BeaconVersion {
	return Companion_BeaconVersion_.Create_BeaconVersion_(int32(0), (m_AwsCryptographyKeyStoreTypes.IKeyStoreClient)(nil), Companion_BeaconKeySource_.Default(), _dafny.EmptySeq, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this BeaconVersion) Dtor_version() int32 {
	return _this.Get_().(BeaconVersion_BeaconVersion).Version
}

func (_this BeaconVersion) Dtor_keyStore() m_AwsCryptographyKeyStoreTypes.IKeyStoreClient {
	return _this.Get_().(BeaconVersion_BeaconVersion).KeyStore
}

func (_this BeaconVersion) Dtor_keySource() BeaconKeySource {
	return _this.Get_().(BeaconVersion_BeaconVersion).KeySource
}

func (_this BeaconVersion) Dtor_standardBeacons() _dafny.Sequence {
	return _this.Get_().(BeaconVersion_BeaconVersion).StandardBeacons
}

func (_this BeaconVersion) Dtor_compoundBeacons() m_Wrappers.Option {
	return _this.Get_().(BeaconVersion_BeaconVersion).CompoundBeacons
}

func (_this BeaconVersion) Dtor_virtualFields() m_Wrappers.Option {
	return _this.Get_().(BeaconVersion_BeaconVersion).VirtualFields
}

func (_this BeaconVersion) Dtor_encryptedParts() m_Wrappers.Option {
	return _this.Get_().(BeaconVersion_BeaconVersion).EncryptedParts
}

func (_this BeaconVersion) Dtor_signedParts() m_Wrappers.Option {
	return _this.Get_().(BeaconVersion_BeaconVersion).SignedParts
}

func (_this BeaconVersion) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BeaconVersion_BeaconVersion:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion.BeaconVersion" + "(" + _dafny.String(data.Version) + ", " + _dafny.String(data.KeyStore) + ", " + _dafny.String(data.KeySource) + ", " + _dafny.String(data.StandardBeacons) + ", " + _dafny.String(data.CompoundBeacons) + ", " + _dafny.String(data.VirtualFields) + ", " + _dafny.String(data.EncryptedParts) + ", " + _dafny.String(data.SignedParts) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BeaconVersion) Equals(other BeaconVersion) bool {
	switch data1 := _this.Get_().(type) {
	case BeaconVersion_BeaconVersion:
		{
			data2, ok := other.Get_().(BeaconVersion_BeaconVersion)
			return ok && data1.Version == data2.Version && _dafny.AreEqual(data1.KeyStore, data2.KeyStore) && data1.KeySource.Equals(data2.KeySource) && data1.StandardBeacons.Equals(data2.StandardBeacons) && data1.CompoundBeacons.Equals(data2.CompoundBeacons) && data1.VirtualFields.Equals(data2.VirtualFields) && data1.EncryptedParts.Equals(data2.EncryptedParts) && data1.SignedParts.Equals(data2.SignedParts)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BeaconVersion) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BeaconVersion)
	return ok && _this.Equals(typed)
}

func Type_BeaconVersion_() _dafny.TypeDescriptor {
	return type_BeaconVersion_{}
}

type type_BeaconVersion_ struct {
}

func (_this type_BeaconVersion_) Default() interface{} {
	return Companion_BeaconVersion_.Default()
}

func (_this type_BeaconVersion_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion"
}
func (_this BeaconVersion) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BeaconVersion{}

// End of datatype BeaconVersion

// Definition of class BeaconVersionList
type BeaconVersionList struct {
}

func New_BeaconVersionList_() *BeaconVersionList {
	_this := BeaconVersionList{}

	return &_this
}

type CompanionStruct_BeaconVersionList_ struct {
}

var Companion_BeaconVersionList_ = CompanionStruct_BeaconVersionList_{}

func (*BeaconVersionList) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersionList"
}

// End of class BeaconVersionList

func Type_BeaconVersionList_() _dafny.TypeDescriptor {
	return type_BeaconVersionList_{}
}

type type_BeaconVersionList_ struct {
}

func (_this type_BeaconVersionList_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_BeaconVersionList_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersionList"
}
func (_this *CompanionStruct_BeaconVersionList_) Is_(__source _dafny.Sequence) bool {
	var _1_x _dafny.Sequence = (__source)
	_ = _1_x
	return Companion_Default___.IsValid__BeaconVersionList(_1_x)
}

// Definition of class Char
type Char struct {
}

func New_Char_() *Char {
	_this := Char{}

	return &_this
}

type CompanionStruct_Char_ struct {
}

var Companion_Char_ = CompanionStruct_Char_{}

func (*Char) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Char"
}

// End of class Char

func Type_Char_() _dafny.TypeDescriptor {
	return type_Char_{}
}

type type_Char_ struct {
}

func (_this type_Char_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_Char_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Char"
}
func (_this *CompanionStruct_Char_) Is_(__source _dafny.Sequence) bool {
	var _2_x _dafny.Sequence = (__source)
	_ = _2_x
	return Companion_Default___.IsValid__Char(_2_x)
}

// Definition of datatype CompoundBeacon
type CompoundBeacon struct {
	Data_CompoundBeacon_
}

func (_this CompoundBeacon) Get_() Data_CompoundBeacon_ {
	return _this.Data_CompoundBeacon_
}

type Data_CompoundBeacon_ interface {
	isCompoundBeacon()
}

type CompanionStruct_CompoundBeacon_ struct {
}

var Companion_CompoundBeacon_ = CompanionStruct_CompoundBeacon_{}

type CompoundBeacon_CompoundBeacon struct {
	Name         _dafny.Sequence
	Split        _dafny.Sequence
	Encrypted    m_Wrappers.Option
	Signed       m_Wrappers.Option
	Constructors m_Wrappers.Option
}

func (CompoundBeacon_CompoundBeacon) isCompoundBeacon() {}

func (CompanionStruct_CompoundBeacon_) Create_CompoundBeacon_(Name _dafny.Sequence, Split _dafny.Sequence, Encrypted m_Wrappers.Option, Signed m_Wrappers.Option, Constructors m_Wrappers.Option) CompoundBeacon {
	return CompoundBeacon{CompoundBeacon_CompoundBeacon{Name, Split, Encrypted, Signed, Constructors}}
}

func (_this CompoundBeacon) Is_CompoundBeacon() bool {
	_, ok := _this.Get_().(CompoundBeacon_CompoundBeacon)
	return ok
}

func (CompanionStruct_CompoundBeacon_) Default() CompoundBeacon {
	return Companion_CompoundBeacon_.Create_CompoundBeacon_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this CompoundBeacon) Dtor_name() _dafny.Sequence {
	return _this.Get_().(CompoundBeacon_CompoundBeacon).Name
}

func (_this CompoundBeacon) Dtor_split() _dafny.Sequence {
	return _this.Get_().(CompoundBeacon_CompoundBeacon).Split
}

func (_this CompoundBeacon) Dtor_encrypted() m_Wrappers.Option {
	return _this.Get_().(CompoundBeacon_CompoundBeacon).Encrypted
}

func (_this CompoundBeacon) Dtor_signed() m_Wrappers.Option {
	return _this.Get_().(CompoundBeacon_CompoundBeacon).Signed
}

func (_this CompoundBeacon) Dtor_constructors() m_Wrappers.Option {
	return _this.Get_().(CompoundBeacon_CompoundBeacon).Constructors
}

func (_this CompoundBeacon) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CompoundBeacon_CompoundBeacon:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon.CompoundBeacon" + "(" + _dafny.String(data.Name) + ", " + _dafny.String(data.Split) + ", " + _dafny.String(data.Encrypted) + ", " + _dafny.String(data.Signed) + ", " + _dafny.String(data.Constructors) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CompoundBeacon) Equals(other CompoundBeacon) bool {
	switch data1 := _this.Get_().(type) {
	case CompoundBeacon_CompoundBeacon:
		{
			data2, ok := other.Get_().(CompoundBeacon_CompoundBeacon)
			return ok && data1.Name.Equals(data2.Name) && data1.Split.Equals(data2.Split) && data1.Encrypted.Equals(data2.Encrypted) && data1.Signed.Equals(data2.Signed) && data1.Constructors.Equals(data2.Constructors)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CompoundBeacon) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CompoundBeacon)
	return ok && _this.Equals(typed)
}

func Type_CompoundBeacon_() _dafny.TypeDescriptor {
	return type_CompoundBeacon_{}
}

type type_CompoundBeacon_ struct {
}

func (_this type_CompoundBeacon_) Default() interface{} {
	return Companion_CompoundBeacon_.Default()
}

func (_this type_CompoundBeacon_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon"
}
func (_this CompoundBeacon) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CompoundBeacon{}

// End of datatype CompoundBeacon

// Definition of class CompoundBeaconList
type CompoundBeaconList struct {
}

func New_CompoundBeaconList_() *CompoundBeaconList {
	_this := CompoundBeaconList{}

	return &_this
}

type CompanionStruct_CompoundBeaconList_ struct {
}

var Companion_CompoundBeaconList_ = CompanionStruct_CompoundBeaconList_{}

func (*CompoundBeaconList) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeaconList"
}

// End of class CompoundBeaconList

func Type_CompoundBeaconList_() _dafny.TypeDescriptor {
	return type_CompoundBeaconList_{}
}

type type_CompoundBeaconList_ struct {
}

func (_this type_CompoundBeaconList_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_CompoundBeaconList_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeaconList"
}
func (_this *CompanionStruct_CompoundBeaconList_) Is_(__source _dafny.Sequence) bool {
	var _3_x _dafny.Sequence = (__source)
	_ = _3_x
	return Companion_Default___.IsValid__CompoundBeaconList(_3_x)
}

// Definition of datatype Constructor
type Constructor struct {
	Data_Constructor_
}

func (_this Constructor) Get_() Data_Constructor_ {
	return _this.Data_Constructor_
}

type Data_Constructor_ interface {
	isConstructor()
}

type CompanionStruct_Constructor_ struct {
}

var Companion_Constructor_ = CompanionStruct_Constructor_{}

type Constructor_Constructor struct {
	Parts _dafny.Sequence
}

func (Constructor_Constructor) isConstructor() {}

func (CompanionStruct_Constructor_) Create_Constructor_(Parts _dafny.Sequence) Constructor {
	return Constructor{Constructor_Constructor{Parts}}
}

func (_this Constructor) Is_Constructor() bool {
	_, ok := _this.Get_().(Constructor_Constructor)
	return ok
}

func (CompanionStruct_Constructor_) Default() Constructor {
	return Companion_Constructor_.Create_Constructor_(_dafny.EmptySeq)
}

func (_this Constructor) Dtor_parts() _dafny.Sequence {
	return _this.Get_().(Constructor_Constructor).Parts
}

func (_this Constructor) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Constructor_Constructor:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Constructor.Constructor" + "(" + _dafny.String(data.Parts) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Constructor) Equals(other Constructor) bool {
	switch data1 := _this.Get_().(type) {
	case Constructor_Constructor:
		{
			data2, ok := other.Get_().(Constructor_Constructor)
			return ok && data1.Parts.Equals(data2.Parts)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Constructor) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Constructor)
	return ok && _this.Equals(typed)
}

func Type_Constructor_() _dafny.TypeDescriptor {
	return type_Constructor_{}
}

type type_Constructor_ struct {
}

func (_this type_Constructor_) Default() interface{} {
	return Companion_Constructor_.Default()
}

func (_this type_Constructor_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Constructor"
}
func (_this Constructor) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Constructor{}

// End of datatype Constructor

// Definition of class ConstructorList
type ConstructorList struct {
}

func New_ConstructorList_() *ConstructorList {
	_this := ConstructorList{}

	return &_this
}

type CompanionStruct_ConstructorList_ struct {
}

var Companion_ConstructorList_ = CompanionStruct_ConstructorList_{}

func (*ConstructorList) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.ConstructorList"
}

// End of class ConstructorList

func Type_ConstructorList_() _dafny.TypeDescriptor {
	return type_ConstructorList_{}
}

type type_ConstructorList_ struct {
}

func (_this type_ConstructorList_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_ConstructorList_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.ConstructorList"
}
func (_this *CompanionStruct_ConstructorList_) Is_(__source _dafny.Sequence) bool {
	var _4_x _dafny.Sequence = (__source)
	_ = _4_x
	return Companion_Default___.IsValid__ConstructorList(_4_x)
}

// Definition of datatype ConstructorPart
type ConstructorPart struct {
	Data_ConstructorPart_
}

func (_this ConstructorPart) Get_() Data_ConstructorPart_ {
	return _this.Data_ConstructorPart_
}

type Data_ConstructorPart_ interface {
	isConstructorPart()
}

type CompanionStruct_ConstructorPart_ struct {
}

var Companion_ConstructorPart_ = CompanionStruct_ConstructorPart_{}

type ConstructorPart_ConstructorPart struct {
	Name     _dafny.Sequence
	Required bool
}

func (ConstructorPart_ConstructorPart) isConstructorPart() {}

func (CompanionStruct_ConstructorPart_) Create_ConstructorPart_(Name _dafny.Sequence, Required bool) ConstructorPart {
	return ConstructorPart{ConstructorPart_ConstructorPart{Name, Required}}
}

func (_this ConstructorPart) Is_ConstructorPart() bool {
	_, ok := _this.Get_().(ConstructorPart_ConstructorPart)
	return ok
}

func (CompanionStruct_ConstructorPart_) Default() ConstructorPart {
	return Companion_ConstructorPart_.Create_ConstructorPart_(_dafny.EmptySeq.SetString(), false)
}

func (_this ConstructorPart) Dtor_name() _dafny.Sequence {
	return _this.Get_().(ConstructorPart_ConstructorPart).Name
}

func (_this ConstructorPart) Dtor_required() bool {
	return _this.Get_().(ConstructorPart_ConstructorPart).Required
}

func (_this ConstructorPart) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ConstructorPart_ConstructorPart:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.ConstructorPart.ConstructorPart" + "(" + _dafny.String(data.Name) + ", " + _dafny.String(data.Required) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ConstructorPart) Equals(other ConstructorPart) bool {
	switch data1 := _this.Get_().(type) {
	case ConstructorPart_ConstructorPart:
		{
			data2, ok := other.Get_().(ConstructorPart_ConstructorPart)
			return ok && data1.Name.Equals(data2.Name) && data1.Required == data2.Required
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ConstructorPart) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ConstructorPart)
	return ok && _this.Equals(typed)
}

func Type_ConstructorPart_() _dafny.TypeDescriptor {
	return type_ConstructorPart_{}
}

type type_ConstructorPart_ struct {
}

func (_this type_ConstructorPart_) Default() interface{} {
	return Companion_ConstructorPart_.Default()
}

func (_this type_ConstructorPart_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.ConstructorPart"
}
func (_this ConstructorPart) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ConstructorPart{}

// End of datatype ConstructorPart

// Definition of class ConstructorPartList
type ConstructorPartList struct {
}

func New_ConstructorPartList_() *ConstructorPartList {
	_this := ConstructorPartList{}

	return &_this
}

type CompanionStruct_ConstructorPartList_ struct {
}

var Companion_ConstructorPartList_ = CompanionStruct_ConstructorPartList_{}

func (*ConstructorPartList) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.ConstructorPartList"
}

// End of class ConstructorPartList

func Type_ConstructorPartList_() _dafny.TypeDescriptor {
	return type_ConstructorPartList_{}
}

type type_ConstructorPartList_ struct {
}

func (_this type_ConstructorPartList_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_ConstructorPartList_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.ConstructorPartList"
}
func (_this *CompanionStruct_ConstructorPartList_) Is_(__source _dafny.Sequence) bool {
	var _5_x _dafny.Sequence = (__source)
	_ = _5_x
	return Companion_Default___.IsValid__ConstructorPartList(_5_x)
}

// Definition of datatype CreateDynamoDbEncryptionBranchKeyIdSupplierInput
type CreateDynamoDbEncryptionBranchKeyIdSupplierInput struct {
	Data_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_
}

func (_this CreateDynamoDbEncryptionBranchKeyIdSupplierInput) Get_() Data_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_ {
	return _this.Data_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_
}

type Data_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_ interface {
	isCreateDynamoDbEncryptionBranchKeyIdSupplierInput()
}

type CompanionStruct_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_ struct {
}

var Companion_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_ = CompanionStruct_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_{}

type CreateDynamoDbEncryptionBranchKeyIdSupplierInput_CreateDynamoDbEncryptionBranchKeyIdSupplierInput struct {
	DdbKeyBranchKeyIdSupplier IDynamoDbKeyBranchKeyIdSupplier
}

func (CreateDynamoDbEncryptionBranchKeyIdSupplierInput_CreateDynamoDbEncryptionBranchKeyIdSupplierInput) isCreateDynamoDbEncryptionBranchKeyIdSupplierInput() {
}

func (CompanionStruct_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_) Create_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_(DdbKeyBranchKeyIdSupplier IDynamoDbKeyBranchKeyIdSupplier) CreateDynamoDbEncryptionBranchKeyIdSupplierInput {
	return CreateDynamoDbEncryptionBranchKeyIdSupplierInput{CreateDynamoDbEncryptionBranchKeyIdSupplierInput_CreateDynamoDbEncryptionBranchKeyIdSupplierInput{DdbKeyBranchKeyIdSupplier}}
}

func (_this CreateDynamoDbEncryptionBranchKeyIdSupplierInput) Is_CreateDynamoDbEncryptionBranchKeyIdSupplierInput() bool {
	_, ok := _this.Get_().(CreateDynamoDbEncryptionBranchKeyIdSupplierInput_CreateDynamoDbEncryptionBranchKeyIdSupplierInput)
	return ok
}

func (CompanionStruct_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_) Default() CreateDynamoDbEncryptionBranchKeyIdSupplierInput {
	return Companion_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_.Create_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_((IDynamoDbKeyBranchKeyIdSupplier)(nil))
}

func (_this CreateDynamoDbEncryptionBranchKeyIdSupplierInput) Dtor_ddbKeyBranchKeyIdSupplier() IDynamoDbKeyBranchKeyIdSupplier {
	return _this.Get_().(CreateDynamoDbEncryptionBranchKeyIdSupplierInput_CreateDynamoDbEncryptionBranchKeyIdSupplierInput).DdbKeyBranchKeyIdSupplier
}

func (_this CreateDynamoDbEncryptionBranchKeyIdSupplierInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateDynamoDbEncryptionBranchKeyIdSupplierInput_CreateDynamoDbEncryptionBranchKeyIdSupplierInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.CreateDynamoDbEncryptionBranchKeyIdSupplierInput.CreateDynamoDbEncryptionBranchKeyIdSupplierInput" + "(" + _dafny.String(data.DdbKeyBranchKeyIdSupplier) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateDynamoDbEncryptionBranchKeyIdSupplierInput) Equals(other CreateDynamoDbEncryptionBranchKeyIdSupplierInput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateDynamoDbEncryptionBranchKeyIdSupplierInput_CreateDynamoDbEncryptionBranchKeyIdSupplierInput:
		{
			data2, ok := other.Get_().(CreateDynamoDbEncryptionBranchKeyIdSupplierInput_CreateDynamoDbEncryptionBranchKeyIdSupplierInput)
			return ok && _dafny.AreEqual(data1.DdbKeyBranchKeyIdSupplier, data2.DdbKeyBranchKeyIdSupplier)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateDynamoDbEncryptionBranchKeyIdSupplierInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateDynamoDbEncryptionBranchKeyIdSupplierInput)
	return ok && _this.Equals(typed)
}

func Type_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_() _dafny.TypeDescriptor {
	return type_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_{}
}

type type_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_ struct {
}

func (_this type_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_) Default() interface{} {
	return Companion_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_.Default()
}

func (_this type_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.CreateDynamoDbEncryptionBranchKeyIdSupplierInput"
}
func (_this CreateDynamoDbEncryptionBranchKeyIdSupplierInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateDynamoDbEncryptionBranchKeyIdSupplierInput{}

// End of datatype CreateDynamoDbEncryptionBranchKeyIdSupplierInput

// Definition of datatype CreateDynamoDbEncryptionBranchKeyIdSupplierOutput
type CreateDynamoDbEncryptionBranchKeyIdSupplierOutput struct {
	Data_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_
}

func (_this CreateDynamoDbEncryptionBranchKeyIdSupplierOutput) Get_() Data_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_ {
	return _this.Data_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_
}

type Data_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_ interface {
	isCreateDynamoDbEncryptionBranchKeyIdSupplierOutput()
}

type CompanionStruct_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_ struct {
}

var Companion_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_ = CompanionStruct_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_{}

type CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput struct {
	BranchKeyIdSupplier m_AwsCryptographyMaterialProvidersTypes.IBranchKeyIdSupplier
}

func (CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput) isCreateDynamoDbEncryptionBranchKeyIdSupplierOutput() {
}

func (CompanionStruct_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_) Create_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_(BranchKeyIdSupplier m_AwsCryptographyMaterialProvidersTypes.IBranchKeyIdSupplier) CreateDynamoDbEncryptionBranchKeyIdSupplierOutput {
	return CreateDynamoDbEncryptionBranchKeyIdSupplierOutput{CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput{BranchKeyIdSupplier}}
}

func (_this CreateDynamoDbEncryptionBranchKeyIdSupplierOutput) Is_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput() bool {
	_, ok := _this.Get_().(CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput)
	return ok
}

func (CompanionStruct_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_) Default() CreateDynamoDbEncryptionBranchKeyIdSupplierOutput {
	return Companion_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_.Create_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_((m_AwsCryptographyMaterialProvidersTypes.IBranchKeyIdSupplier)(nil))
}

func (_this CreateDynamoDbEncryptionBranchKeyIdSupplierOutput) Dtor_branchKeyIdSupplier() m_AwsCryptographyMaterialProvidersTypes.IBranchKeyIdSupplier {
	return _this.Get_().(CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput).BranchKeyIdSupplier
}

func (_this CreateDynamoDbEncryptionBranchKeyIdSupplierOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput" + "(" + _dafny.String(data.BranchKeyIdSupplier) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateDynamoDbEncryptionBranchKeyIdSupplierOutput) Equals(other CreateDynamoDbEncryptionBranchKeyIdSupplierOutput) bool {
	switch data1 := _this.Get_().(type) {
	case CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput:
		{
			data2, ok := other.Get_().(CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput)
			return ok && _dafny.AreEqual(data1.BranchKeyIdSupplier, data2.BranchKeyIdSupplier)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateDynamoDbEncryptionBranchKeyIdSupplierOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateDynamoDbEncryptionBranchKeyIdSupplierOutput)
	return ok && _this.Equals(typed)
}

func Type_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_() _dafny.TypeDescriptor {
	return type_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_{}
}

type type_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_ struct {
}

func (_this type_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_) Default() interface{} {
	return Companion_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_.Default()
}

func (_this type_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput"
}
func (_this CreateDynamoDbEncryptionBranchKeyIdSupplierOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateDynamoDbEncryptionBranchKeyIdSupplierOutput{}

// End of datatype CreateDynamoDbEncryptionBranchKeyIdSupplierOutput

// Definition of class IDynamoDbEncryptionClientCallHistory
type IDynamoDbEncryptionClientCallHistory struct {
	dummy byte
}

func New_IDynamoDbEncryptionClientCallHistory_() *IDynamoDbEncryptionClientCallHistory {
	_this := IDynamoDbEncryptionClientCallHistory{}

	return &_this
}

type CompanionStruct_IDynamoDbEncryptionClientCallHistory_ struct {
}

var Companion_IDynamoDbEncryptionClientCallHistory_ = CompanionStruct_IDynamoDbEncryptionClientCallHistory_{}

func (_this *IDynamoDbEncryptionClientCallHistory) Equals(other *IDynamoDbEncryptionClientCallHistory) bool {
	return _this == other
}

func (_this *IDynamoDbEncryptionClientCallHistory) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*IDynamoDbEncryptionClientCallHistory)
	return ok && _this.Equals(other)
}

func (*IDynamoDbEncryptionClientCallHistory) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.IDynamoDbEncryptionClientCallHistory"
}

func Type_IDynamoDbEncryptionClientCallHistory_() _dafny.TypeDescriptor {
	return type_IDynamoDbEncryptionClientCallHistory_{}
}

type type_IDynamoDbEncryptionClientCallHistory_ struct {
}

func (_this type_IDynamoDbEncryptionClientCallHistory_) Default() interface{} {
	return (*IDynamoDbEncryptionClientCallHistory)(nil)
}

func (_this type_IDynamoDbEncryptionClientCallHistory_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.IDynamoDbEncryptionClientCallHistory"
}
func (_this *IDynamoDbEncryptionClientCallHistory) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &IDynamoDbEncryptionClientCallHistory{}

// End of class IDynamoDbEncryptionClientCallHistory

// Definition of trait IDynamoDbEncryptionClient
type IDynamoDbEncryptionClient interface {
	String() string
	CreateDynamoDbEncryptionBranchKeyIdSupplier(input CreateDynamoDbEncryptionBranchKeyIdSupplierInput) m_Wrappers.Result
	GetEncryptedDataKeyDescription(input GetEncryptedDataKeyDescriptionInput) m_Wrappers.Result
}
type CompanionStruct_IDynamoDbEncryptionClient_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_IDynamoDbEncryptionClient_ = CompanionStruct_IDynamoDbEncryptionClient_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_IDynamoDbEncryptionClient_) CastTo_(x interface{}) IDynamoDbEncryptionClient {
	var t IDynamoDbEncryptionClient
	t, _ = x.(IDynamoDbEncryptionClient)
	return t
}

// End of trait IDynamoDbEncryptionClient

// Definition of datatype DynamoDbEncryptionConfig
type DynamoDbEncryptionConfig struct {
	Data_DynamoDbEncryptionConfig_
}

func (_this DynamoDbEncryptionConfig) Get_() Data_DynamoDbEncryptionConfig_ {
	return _this.Data_DynamoDbEncryptionConfig_
}

type Data_DynamoDbEncryptionConfig_ interface {
	isDynamoDbEncryptionConfig()
}

type CompanionStruct_DynamoDbEncryptionConfig_ struct {
}

var Companion_DynamoDbEncryptionConfig_ = CompanionStruct_DynamoDbEncryptionConfig_{}

type DynamoDbEncryptionConfig_DynamoDbEncryptionConfig struct {
}

func (DynamoDbEncryptionConfig_DynamoDbEncryptionConfig) isDynamoDbEncryptionConfig() {}

func (CompanionStruct_DynamoDbEncryptionConfig_) Create_DynamoDbEncryptionConfig_() DynamoDbEncryptionConfig {
	return DynamoDbEncryptionConfig{DynamoDbEncryptionConfig_DynamoDbEncryptionConfig{}}
}

func (_this DynamoDbEncryptionConfig) Is_DynamoDbEncryptionConfig() bool {
	_, ok := _this.Get_().(DynamoDbEncryptionConfig_DynamoDbEncryptionConfig)
	return ok
}

func (CompanionStruct_DynamoDbEncryptionConfig_) Default() DynamoDbEncryptionConfig {
	return Companion_DynamoDbEncryptionConfig_.Create_DynamoDbEncryptionConfig_()
}

func (_ CompanionStruct_DynamoDbEncryptionConfig_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_DynamoDbEncryptionConfig_.Create_DynamoDbEncryptionConfig_(), true
		default:
			return DynamoDbEncryptionConfig{}, false
		}
	}
}

func (_this DynamoDbEncryptionConfig) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case DynamoDbEncryptionConfig_DynamoDbEncryptionConfig:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbEncryptionConfig.DynamoDbEncryptionConfig"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DynamoDbEncryptionConfig) Equals(other DynamoDbEncryptionConfig) bool {
	switch _this.Get_().(type) {
	case DynamoDbEncryptionConfig_DynamoDbEncryptionConfig:
		{
			_, ok := other.Get_().(DynamoDbEncryptionConfig_DynamoDbEncryptionConfig)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DynamoDbEncryptionConfig) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DynamoDbEncryptionConfig)
	return ok && _this.Equals(typed)
}

func Type_DynamoDbEncryptionConfig_() _dafny.TypeDescriptor {
	return type_DynamoDbEncryptionConfig_{}
}

type type_DynamoDbEncryptionConfig_ struct {
}

func (_this type_DynamoDbEncryptionConfig_) Default() interface{} {
	return Companion_DynamoDbEncryptionConfig_.Default()
}

func (_this type_DynamoDbEncryptionConfig_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbEncryptionConfig"
}
func (_this DynamoDbEncryptionConfig) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DynamoDbEncryptionConfig{}

// End of datatype DynamoDbEncryptionConfig

// Definition of class IDynamoDbKeyBranchKeyIdSupplierCallHistory
type IDynamoDbKeyBranchKeyIdSupplierCallHistory struct {
	dummy byte
}

func New_IDynamoDbKeyBranchKeyIdSupplierCallHistory_() *IDynamoDbKeyBranchKeyIdSupplierCallHistory {
	_this := IDynamoDbKeyBranchKeyIdSupplierCallHistory{}

	return &_this
}

type CompanionStruct_IDynamoDbKeyBranchKeyIdSupplierCallHistory_ struct {
}

var Companion_IDynamoDbKeyBranchKeyIdSupplierCallHistory_ = CompanionStruct_IDynamoDbKeyBranchKeyIdSupplierCallHistory_{}

func (_this *IDynamoDbKeyBranchKeyIdSupplierCallHistory) Equals(other *IDynamoDbKeyBranchKeyIdSupplierCallHistory) bool {
	return _this == other
}

func (_this *IDynamoDbKeyBranchKeyIdSupplierCallHistory) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*IDynamoDbKeyBranchKeyIdSupplierCallHistory)
	return ok && _this.Equals(other)
}

func (*IDynamoDbKeyBranchKeyIdSupplierCallHistory) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.IDynamoDbKeyBranchKeyIdSupplierCallHistory"
}

func Type_IDynamoDbKeyBranchKeyIdSupplierCallHistory_() _dafny.TypeDescriptor {
	return type_IDynamoDbKeyBranchKeyIdSupplierCallHistory_{}
}

type type_IDynamoDbKeyBranchKeyIdSupplierCallHistory_ struct {
}

func (_this type_IDynamoDbKeyBranchKeyIdSupplierCallHistory_) Default() interface{} {
	return (*IDynamoDbKeyBranchKeyIdSupplierCallHistory)(nil)
}

func (_this type_IDynamoDbKeyBranchKeyIdSupplierCallHistory_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.IDynamoDbKeyBranchKeyIdSupplierCallHistory"
}
func (_this *IDynamoDbKeyBranchKeyIdSupplierCallHistory) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &IDynamoDbKeyBranchKeyIdSupplierCallHistory{}

// End of class IDynamoDbKeyBranchKeyIdSupplierCallHistory

// Definition of trait IDynamoDbKeyBranchKeyIdSupplier
type IDynamoDbKeyBranchKeyIdSupplier interface {
	String() string
	GetBranchKeyIdFromDdbKey(input GetBranchKeyIdFromDdbKeyInput) m_Wrappers.Result
	GetBranchKeyIdFromDdbKey_k(input GetBranchKeyIdFromDdbKeyInput) m_Wrappers.Result
}

func (_static *CompanionStruct_IDynamoDbKeyBranchKeyIdSupplier_) GetBranchKeyIdFromDdbKey(_this IDynamoDbKeyBranchKeyIdSupplier, input GetBranchKeyIdFromDdbKeyInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_GetBranchKeyIdFromDdbKeyOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (_this).GetBranchKeyIdFromDdbKey_k(input)
		output = _out0
		return output
	}
}

type CompanionStruct_IDynamoDbKeyBranchKeyIdSupplier_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_IDynamoDbKeyBranchKeyIdSupplier_ = CompanionStruct_IDynamoDbKeyBranchKeyIdSupplier_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_IDynamoDbKeyBranchKeyIdSupplier_) CastTo_(x interface{}) IDynamoDbKeyBranchKeyIdSupplier {
	var t IDynamoDbKeyBranchKeyIdSupplier
	t, _ = x.(IDynamoDbKeyBranchKeyIdSupplier)
	return t
}

// End of trait IDynamoDbKeyBranchKeyIdSupplier

// Definition of datatype DynamoDbTableEncryptionConfig
type DynamoDbTableEncryptionConfig struct {
	Data_DynamoDbTableEncryptionConfig_
}

func (_this DynamoDbTableEncryptionConfig) Get_() Data_DynamoDbTableEncryptionConfig_ {
	return _this.Data_DynamoDbTableEncryptionConfig_
}

type Data_DynamoDbTableEncryptionConfig_ interface {
	isDynamoDbTableEncryptionConfig()
}

type CompanionStruct_DynamoDbTableEncryptionConfig_ struct {
}

var Companion_DynamoDbTableEncryptionConfig_ = CompanionStruct_DynamoDbTableEncryptionConfig_{}

type DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig struct {
	LogicalTableName               _dafny.Sequence
	PartitionKeyName               _dafny.Sequence
	SortKeyName                    m_Wrappers.Option
	Search                         m_Wrappers.Option
	AttributeActionsOnEncrypt      _dafny.Map
	AllowedUnsignedAttributes      m_Wrappers.Option
	AllowedUnsignedAttributePrefix m_Wrappers.Option
	AlgorithmSuiteId               m_Wrappers.Option
	Keyring                        m_Wrappers.Option
	Cmm                            m_Wrappers.Option
	LegacyOverride                 m_Wrappers.Option
	PlaintextOverride              m_Wrappers.Option
}

func (DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig) isDynamoDbTableEncryptionConfig() {
}

func (CompanionStruct_DynamoDbTableEncryptionConfig_) Create_DynamoDbTableEncryptionConfig_(LogicalTableName _dafny.Sequence, PartitionKeyName _dafny.Sequence, SortKeyName m_Wrappers.Option, Search m_Wrappers.Option, AttributeActionsOnEncrypt _dafny.Map, AllowedUnsignedAttributes m_Wrappers.Option, AllowedUnsignedAttributePrefix m_Wrappers.Option, AlgorithmSuiteId m_Wrappers.Option, Keyring m_Wrappers.Option, Cmm m_Wrappers.Option, LegacyOverride m_Wrappers.Option, PlaintextOverride m_Wrappers.Option) DynamoDbTableEncryptionConfig {
	return DynamoDbTableEncryptionConfig{DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig{LogicalTableName, PartitionKeyName, SortKeyName, Search, AttributeActionsOnEncrypt, AllowedUnsignedAttributes, AllowedUnsignedAttributePrefix, AlgorithmSuiteId, Keyring, Cmm, LegacyOverride, PlaintextOverride}}
}

func (_this DynamoDbTableEncryptionConfig) Is_DynamoDbTableEncryptionConfig() bool {
	_, ok := _this.Get_().(DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig)
	return ok
}

func (CompanionStruct_DynamoDbTableEncryptionConfig_) Default() DynamoDbTableEncryptionConfig {
	return Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), _dafny.EmptyMap, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this DynamoDbTableEncryptionConfig) Dtor_logicalTableName() _dafny.Sequence {
	return _this.Get_().(DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig).LogicalTableName
}

func (_this DynamoDbTableEncryptionConfig) Dtor_partitionKeyName() _dafny.Sequence {
	return _this.Get_().(DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig).PartitionKeyName
}

func (_this DynamoDbTableEncryptionConfig) Dtor_sortKeyName() m_Wrappers.Option {
	return _this.Get_().(DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig).SortKeyName
}

func (_this DynamoDbTableEncryptionConfig) Dtor_search() m_Wrappers.Option {
	return _this.Get_().(DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig).Search
}

func (_this DynamoDbTableEncryptionConfig) Dtor_attributeActionsOnEncrypt() _dafny.Map {
	return _this.Get_().(DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig).AttributeActionsOnEncrypt
}

func (_this DynamoDbTableEncryptionConfig) Dtor_allowedUnsignedAttributes() m_Wrappers.Option {
	return _this.Get_().(DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig).AllowedUnsignedAttributes
}

func (_this DynamoDbTableEncryptionConfig) Dtor_allowedUnsignedAttributePrefix() m_Wrappers.Option {
	return _this.Get_().(DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig).AllowedUnsignedAttributePrefix
}

func (_this DynamoDbTableEncryptionConfig) Dtor_algorithmSuiteId() m_Wrappers.Option {
	return _this.Get_().(DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig).AlgorithmSuiteId
}

func (_this DynamoDbTableEncryptionConfig) Dtor_keyring() m_Wrappers.Option {
	return _this.Get_().(DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig).Keyring
}

func (_this DynamoDbTableEncryptionConfig) Dtor_cmm() m_Wrappers.Option {
	return _this.Get_().(DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig).Cmm
}

func (_this DynamoDbTableEncryptionConfig) Dtor_legacyOverride() m_Wrappers.Option {
	return _this.Get_().(DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig).LegacyOverride
}

func (_this DynamoDbTableEncryptionConfig) Dtor_plaintextOverride() m_Wrappers.Option {
	return _this.Get_().(DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig).PlaintextOverride
}

func (_this DynamoDbTableEncryptionConfig) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig.DynamoDbTableEncryptionConfig" + "(" + _dafny.String(data.LogicalTableName) + ", " + _dafny.String(data.PartitionKeyName) + ", " + _dafny.String(data.SortKeyName) + ", " + _dafny.String(data.Search) + ", " + _dafny.String(data.AttributeActionsOnEncrypt) + ", " + _dafny.String(data.AllowedUnsignedAttributes) + ", " + _dafny.String(data.AllowedUnsignedAttributePrefix) + ", " + _dafny.String(data.AlgorithmSuiteId) + ", " + _dafny.String(data.Keyring) + ", " + _dafny.String(data.Cmm) + ", " + _dafny.String(data.LegacyOverride) + ", " + _dafny.String(data.PlaintextOverride) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DynamoDbTableEncryptionConfig) Equals(other DynamoDbTableEncryptionConfig) bool {
	switch data1 := _this.Get_().(type) {
	case DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig:
		{
			data2, ok := other.Get_().(DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig)
			return ok && data1.LogicalTableName.Equals(data2.LogicalTableName) && data1.PartitionKeyName.Equals(data2.PartitionKeyName) && data1.SortKeyName.Equals(data2.SortKeyName) && data1.Search.Equals(data2.Search) && data1.AttributeActionsOnEncrypt.Equals(data2.AttributeActionsOnEncrypt) && data1.AllowedUnsignedAttributes.Equals(data2.AllowedUnsignedAttributes) && data1.AllowedUnsignedAttributePrefix.Equals(data2.AllowedUnsignedAttributePrefix) && data1.AlgorithmSuiteId.Equals(data2.AlgorithmSuiteId) && data1.Keyring.Equals(data2.Keyring) && data1.Cmm.Equals(data2.Cmm) && data1.LegacyOverride.Equals(data2.LegacyOverride) && data1.PlaintextOverride.Equals(data2.PlaintextOverride)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DynamoDbTableEncryptionConfig) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DynamoDbTableEncryptionConfig)
	return ok && _this.Equals(typed)
}

func Type_DynamoDbTableEncryptionConfig_() _dafny.TypeDescriptor {
	return type_DynamoDbTableEncryptionConfig_{}
}

type type_DynamoDbTableEncryptionConfig_ struct {
}

func (_this type_DynamoDbTableEncryptionConfig_) Default() interface{} {
	return Companion_DynamoDbTableEncryptionConfig_.Default()
}

func (_this type_DynamoDbTableEncryptionConfig_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig"
}
func (_this DynamoDbTableEncryptionConfig) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DynamoDbTableEncryptionConfig{}

// End of datatype DynamoDbTableEncryptionConfig

// Definition of datatype DynamoDbTablesEncryptionConfig
type DynamoDbTablesEncryptionConfig struct {
	Data_DynamoDbTablesEncryptionConfig_
}

func (_this DynamoDbTablesEncryptionConfig) Get_() Data_DynamoDbTablesEncryptionConfig_ {
	return _this.Data_DynamoDbTablesEncryptionConfig_
}

type Data_DynamoDbTablesEncryptionConfig_ interface {
	isDynamoDbTablesEncryptionConfig()
}

type CompanionStruct_DynamoDbTablesEncryptionConfig_ struct {
}

var Companion_DynamoDbTablesEncryptionConfig_ = CompanionStruct_DynamoDbTablesEncryptionConfig_{}

type DynamoDbTablesEncryptionConfig_DynamoDbTablesEncryptionConfig struct {
	TableEncryptionConfigs _dafny.Map
}

func (DynamoDbTablesEncryptionConfig_DynamoDbTablesEncryptionConfig) isDynamoDbTablesEncryptionConfig() {
}

func (CompanionStruct_DynamoDbTablesEncryptionConfig_) Create_DynamoDbTablesEncryptionConfig_(TableEncryptionConfigs _dafny.Map) DynamoDbTablesEncryptionConfig {
	return DynamoDbTablesEncryptionConfig{DynamoDbTablesEncryptionConfig_DynamoDbTablesEncryptionConfig{TableEncryptionConfigs}}
}

func (_this DynamoDbTablesEncryptionConfig) Is_DynamoDbTablesEncryptionConfig() bool {
	_, ok := _this.Get_().(DynamoDbTablesEncryptionConfig_DynamoDbTablesEncryptionConfig)
	return ok
}

func (CompanionStruct_DynamoDbTablesEncryptionConfig_) Default() DynamoDbTablesEncryptionConfig {
	return Companion_DynamoDbTablesEncryptionConfig_.Create_DynamoDbTablesEncryptionConfig_(_dafny.EmptyMap)
}

func (_this DynamoDbTablesEncryptionConfig) Dtor_tableEncryptionConfigs() _dafny.Map {
	return _this.Get_().(DynamoDbTablesEncryptionConfig_DynamoDbTablesEncryptionConfig).TableEncryptionConfigs
}

func (_this DynamoDbTablesEncryptionConfig) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DynamoDbTablesEncryptionConfig_DynamoDbTablesEncryptionConfig:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTablesEncryptionConfig.DynamoDbTablesEncryptionConfig" + "(" + _dafny.String(data.TableEncryptionConfigs) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DynamoDbTablesEncryptionConfig) Equals(other DynamoDbTablesEncryptionConfig) bool {
	switch data1 := _this.Get_().(type) {
	case DynamoDbTablesEncryptionConfig_DynamoDbTablesEncryptionConfig:
		{
			data2, ok := other.Get_().(DynamoDbTablesEncryptionConfig_DynamoDbTablesEncryptionConfig)
			return ok && data1.TableEncryptionConfigs.Equals(data2.TableEncryptionConfigs)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DynamoDbTablesEncryptionConfig) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DynamoDbTablesEncryptionConfig)
	return ok && _this.Equals(typed)
}

func Type_DynamoDbTablesEncryptionConfig_() _dafny.TypeDescriptor {
	return type_DynamoDbTablesEncryptionConfig_{}
}

type type_DynamoDbTablesEncryptionConfig_ struct {
}

func (_this type_DynamoDbTablesEncryptionConfig_) Default() interface{} {
	return Companion_DynamoDbTablesEncryptionConfig_.Default()
}

func (_this type_DynamoDbTablesEncryptionConfig_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTablesEncryptionConfig"
}
func (_this DynamoDbTablesEncryptionConfig) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DynamoDbTablesEncryptionConfig{}

// End of datatype DynamoDbTablesEncryptionConfig

// Definition of datatype EncryptedDataKeyDescription
type EncryptedDataKeyDescription struct {
	Data_EncryptedDataKeyDescription_
}

func (_this EncryptedDataKeyDescription) Get_() Data_EncryptedDataKeyDescription_ {
	return _this.Data_EncryptedDataKeyDescription_
}

type Data_EncryptedDataKeyDescription_ interface {
	isEncryptedDataKeyDescription()
}

type CompanionStruct_EncryptedDataKeyDescription_ struct {
}

var Companion_EncryptedDataKeyDescription_ = CompanionStruct_EncryptedDataKeyDescription_{}

type EncryptedDataKeyDescription_EncryptedDataKeyDescription struct {
	KeyProviderId    _dafny.Sequence
	KeyProviderInfo  m_Wrappers.Option
	BranchKeyId      m_Wrappers.Option
	BranchKeyVersion m_Wrappers.Option
}

func (EncryptedDataKeyDescription_EncryptedDataKeyDescription) isEncryptedDataKeyDescription() {}

func (CompanionStruct_EncryptedDataKeyDescription_) Create_EncryptedDataKeyDescription_(KeyProviderId _dafny.Sequence, KeyProviderInfo m_Wrappers.Option, BranchKeyId m_Wrappers.Option, BranchKeyVersion m_Wrappers.Option) EncryptedDataKeyDescription {
	return EncryptedDataKeyDescription{EncryptedDataKeyDescription_EncryptedDataKeyDescription{KeyProviderId, KeyProviderInfo, BranchKeyId, BranchKeyVersion}}
}

func (_this EncryptedDataKeyDescription) Is_EncryptedDataKeyDescription() bool {
	_, ok := _this.Get_().(EncryptedDataKeyDescription_EncryptedDataKeyDescription)
	return ok
}

func (CompanionStruct_EncryptedDataKeyDescription_) Default() EncryptedDataKeyDescription {
	return Companion_EncryptedDataKeyDescription_.Create_EncryptedDataKeyDescription_(_dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this EncryptedDataKeyDescription) Dtor_keyProviderId() _dafny.Sequence {
	return _this.Get_().(EncryptedDataKeyDescription_EncryptedDataKeyDescription).KeyProviderId
}

func (_this EncryptedDataKeyDescription) Dtor_keyProviderInfo() m_Wrappers.Option {
	return _this.Get_().(EncryptedDataKeyDescription_EncryptedDataKeyDescription).KeyProviderInfo
}

func (_this EncryptedDataKeyDescription) Dtor_branchKeyId() m_Wrappers.Option {
	return _this.Get_().(EncryptedDataKeyDescription_EncryptedDataKeyDescription).BranchKeyId
}

func (_this EncryptedDataKeyDescription) Dtor_branchKeyVersion() m_Wrappers.Option {
	return _this.Get_().(EncryptedDataKeyDescription_EncryptedDataKeyDescription).BranchKeyVersion
}

func (_this EncryptedDataKeyDescription) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EncryptedDataKeyDescription_EncryptedDataKeyDescription:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription.EncryptedDataKeyDescription" + "(" + _dafny.String(data.KeyProviderId) + ", " + _dafny.String(data.KeyProviderInfo) + ", " + _dafny.String(data.BranchKeyId) + ", " + _dafny.String(data.BranchKeyVersion) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EncryptedDataKeyDescription) Equals(other EncryptedDataKeyDescription) bool {
	switch data1 := _this.Get_().(type) {
	case EncryptedDataKeyDescription_EncryptedDataKeyDescription:
		{
			data2, ok := other.Get_().(EncryptedDataKeyDescription_EncryptedDataKeyDescription)
			return ok && data1.KeyProviderId.Equals(data2.KeyProviderId) && data1.KeyProviderInfo.Equals(data2.KeyProviderInfo) && data1.BranchKeyId.Equals(data2.BranchKeyId) && data1.BranchKeyVersion.Equals(data2.BranchKeyVersion)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EncryptedDataKeyDescription) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EncryptedDataKeyDescription)
	return ok && _this.Equals(typed)
}

func Type_EncryptedDataKeyDescription_() _dafny.TypeDescriptor {
	return type_EncryptedDataKeyDescription_{}
}

type type_EncryptedDataKeyDescription_ struct {
}

func (_this type_EncryptedDataKeyDescription_) Default() interface{} {
	return Companion_EncryptedDataKeyDescription_.Default()
}

func (_this type_EncryptedDataKeyDescription_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription"
}
func (_this EncryptedDataKeyDescription) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EncryptedDataKeyDescription{}

// End of datatype EncryptedDataKeyDescription

// Definition of datatype EncryptedPart
type EncryptedPart struct {
	Data_EncryptedPart_
}

func (_this EncryptedPart) Get_() Data_EncryptedPart_ {
	return _this.Data_EncryptedPart_
}

type Data_EncryptedPart_ interface {
	isEncryptedPart()
}

type CompanionStruct_EncryptedPart_ struct {
}

var Companion_EncryptedPart_ = CompanionStruct_EncryptedPart_{}

type EncryptedPart_EncryptedPart struct {
	Name   _dafny.Sequence
	Prefix _dafny.Sequence
}

func (EncryptedPart_EncryptedPart) isEncryptedPart() {}

func (CompanionStruct_EncryptedPart_) Create_EncryptedPart_(Name _dafny.Sequence, Prefix _dafny.Sequence) EncryptedPart {
	return EncryptedPart{EncryptedPart_EncryptedPart{Name, Prefix}}
}

func (_this EncryptedPart) Is_EncryptedPart() bool {
	_, ok := _this.Get_().(EncryptedPart_EncryptedPart)
	return ok
}

func (CompanionStruct_EncryptedPart_) Default() EncryptedPart {
	return Companion_EncryptedPart_.Create_EncryptedPart_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString())
}

func (_this EncryptedPart) Dtor_name() _dafny.Sequence {
	return _this.Get_().(EncryptedPart_EncryptedPart).Name
}

func (_this EncryptedPart) Dtor_prefix() _dafny.Sequence {
	return _this.Get_().(EncryptedPart_EncryptedPart).Prefix
}

func (_this EncryptedPart) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EncryptedPart_EncryptedPart:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart.EncryptedPart" + "(" + _dafny.String(data.Name) + ", " + _dafny.String(data.Prefix) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EncryptedPart) Equals(other EncryptedPart) bool {
	switch data1 := _this.Get_().(type) {
	case EncryptedPart_EncryptedPart:
		{
			data2, ok := other.Get_().(EncryptedPart_EncryptedPart)
			return ok && data1.Name.Equals(data2.Name) && data1.Prefix.Equals(data2.Prefix)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EncryptedPart) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EncryptedPart)
	return ok && _this.Equals(typed)
}

func Type_EncryptedPart_() _dafny.TypeDescriptor {
	return type_EncryptedPart_{}
}

type type_EncryptedPart_ struct {
}

func (_this type_EncryptedPart_) Default() interface{} {
	return Companion_EncryptedPart_.Default()
}

func (_this type_EncryptedPart_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart"
}
func (_this EncryptedPart) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EncryptedPart{}

// End of datatype EncryptedPart

// Definition of class EncryptedPartsList
type EncryptedPartsList struct {
}

func New_EncryptedPartsList_() *EncryptedPartsList {
	_this := EncryptedPartsList{}

	return &_this
}

type CompanionStruct_EncryptedPartsList_ struct {
}

var Companion_EncryptedPartsList_ = CompanionStruct_EncryptedPartsList_{}

func (*EncryptedPartsList) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPartsList"
}

// End of class EncryptedPartsList

func Type_EncryptedPartsList_() _dafny.TypeDescriptor {
	return type_EncryptedPartsList_{}
}

type type_EncryptedPartsList_ struct {
}

func (_this type_EncryptedPartsList_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_EncryptedPartsList_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPartsList"
}
func (_this *CompanionStruct_EncryptedPartsList_) Is_(__source _dafny.Sequence) bool {
	var _0_x _dafny.Sequence = (__source)
	_ = _0_x
	return Companion_Default___.IsValid__EncryptedPartsList(_0_x)
}

// Definition of datatype GetBranchKeyIdFromDdbKeyInput
type GetBranchKeyIdFromDdbKeyInput struct {
	Data_GetBranchKeyIdFromDdbKeyInput_
}

func (_this GetBranchKeyIdFromDdbKeyInput) Get_() Data_GetBranchKeyIdFromDdbKeyInput_ {
	return _this.Data_GetBranchKeyIdFromDdbKeyInput_
}

type Data_GetBranchKeyIdFromDdbKeyInput_ interface {
	isGetBranchKeyIdFromDdbKeyInput()
}

type CompanionStruct_GetBranchKeyIdFromDdbKeyInput_ struct {
}

var Companion_GetBranchKeyIdFromDdbKeyInput_ = CompanionStruct_GetBranchKeyIdFromDdbKeyInput_{}

type GetBranchKeyIdFromDdbKeyInput_GetBranchKeyIdFromDdbKeyInput struct {
	DdbKey _dafny.Map
}

func (GetBranchKeyIdFromDdbKeyInput_GetBranchKeyIdFromDdbKeyInput) isGetBranchKeyIdFromDdbKeyInput() {
}

func (CompanionStruct_GetBranchKeyIdFromDdbKeyInput_) Create_GetBranchKeyIdFromDdbKeyInput_(DdbKey _dafny.Map) GetBranchKeyIdFromDdbKeyInput {
	return GetBranchKeyIdFromDdbKeyInput{GetBranchKeyIdFromDdbKeyInput_GetBranchKeyIdFromDdbKeyInput{DdbKey}}
}

func (_this GetBranchKeyIdFromDdbKeyInput) Is_GetBranchKeyIdFromDdbKeyInput() bool {
	_, ok := _this.Get_().(GetBranchKeyIdFromDdbKeyInput_GetBranchKeyIdFromDdbKeyInput)
	return ok
}

func (CompanionStruct_GetBranchKeyIdFromDdbKeyInput_) Default() GetBranchKeyIdFromDdbKeyInput {
	return Companion_GetBranchKeyIdFromDdbKeyInput_.Create_GetBranchKeyIdFromDdbKeyInput_(_dafny.EmptyMap)
}

func (_this GetBranchKeyIdFromDdbKeyInput) Dtor_ddbKey() _dafny.Map {
	return _this.Get_().(GetBranchKeyIdFromDdbKeyInput_GetBranchKeyIdFromDdbKeyInput).DdbKey
}

func (_this GetBranchKeyIdFromDdbKeyInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetBranchKeyIdFromDdbKeyInput_GetBranchKeyIdFromDdbKeyInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetBranchKeyIdFromDdbKeyInput.GetBranchKeyIdFromDdbKeyInput" + "(" + _dafny.String(data.DdbKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetBranchKeyIdFromDdbKeyInput) Equals(other GetBranchKeyIdFromDdbKeyInput) bool {
	switch data1 := _this.Get_().(type) {
	case GetBranchKeyIdFromDdbKeyInput_GetBranchKeyIdFromDdbKeyInput:
		{
			data2, ok := other.Get_().(GetBranchKeyIdFromDdbKeyInput_GetBranchKeyIdFromDdbKeyInput)
			return ok && data1.DdbKey.Equals(data2.DdbKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetBranchKeyIdFromDdbKeyInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetBranchKeyIdFromDdbKeyInput)
	return ok && _this.Equals(typed)
}

func Type_GetBranchKeyIdFromDdbKeyInput_() _dafny.TypeDescriptor {
	return type_GetBranchKeyIdFromDdbKeyInput_{}
}

type type_GetBranchKeyIdFromDdbKeyInput_ struct {
}

func (_this type_GetBranchKeyIdFromDdbKeyInput_) Default() interface{} {
	return Companion_GetBranchKeyIdFromDdbKeyInput_.Default()
}

func (_this type_GetBranchKeyIdFromDdbKeyInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetBranchKeyIdFromDdbKeyInput"
}
func (_this GetBranchKeyIdFromDdbKeyInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetBranchKeyIdFromDdbKeyInput{}

// End of datatype GetBranchKeyIdFromDdbKeyInput

// Definition of datatype GetBranchKeyIdFromDdbKeyOutput
type GetBranchKeyIdFromDdbKeyOutput struct {
	Data_GetBranchKeyIdFromDdbKeyOutput_
}

func (_this GetBranchKeyIdFromDdbKeyOutput) Get_() Data_GetBranchKeyIdFromDdbKeyOutput_ {
	return _this.Data_GetBranchKeyIdFromDdbKeyOutput_
}

type Data_GetBranchKeyIdFromDdbKeyOutput_ interface {
	isGetBranchKeyIdFromDdbKeyOutput()
}

type CompanionStruct_GetBranchKeyIdFromDdbKeyOutput_ struct {
}

var Companion_GetBranchKeyIdFromDdbKeyOutput_ = CompanionStruct_GetBranchKeyIdFromDdbKeyOutput_{}

type GetBranchKeyIdFromDdbKeyOutput_GetBranchKeyIdFromDdbKeyOutput struct {
	BranchKeyId _dafny.Sequence
}

func (GetBranchKeyIdFromDdbKeyOutput_GetBranchKeyIdFromDdbKeyOutput) isGetBranchKeyIdFromDdbKeyOutput() {
}

func (CompanionStruct_GetBranchKeyIdFromDdbKeyOutput_) Create_GetBranchKeyIdFromDdbKeyOutput_(BranchKeyId _dafny.Sequence) GetBranchKeyIdFromDdbKeyOutput {
	return GetBranchKeyIdFromDdbKeyOutput{GetBranchKeyIdFromDdbKeyOutput_GetBranchKeyIdFromDdbKeyOutput{BranchKeyId}}
}

func (_this GetBranchKeyIdFromDdbKeyOutput) Is_GetBranchKeyIdFromDdbKeyOutput() bool {
	_, ok := _this.Get_().(GetBranchKeyIdFromDdbKeyOutput_GetBranchKeyIdFromDdbKeyOutput)
	return ok
}

func (CompanionStruct_GetBranchKeyIdFromDdbKeyOutput_) Default() GetBranchKeyIdFromDdbKeyOutput {
	return Companion_GetBranchKeyIdFromDdbKeyOutput_.Create_GetBranchKeyIdFromDdbKeyOutput_(_dafny.EmptySeq.SetString())
}

func (_this GetBranchKeyIdFromDdbKeyOutput) Dtor_branchKeyId() _dafny.Sequence {
	return _this.Get_().(GetBranchKeyIdFromDdbKeyOutput_GetBranchKeyIdFromDdbKeyOutput).BranchKeyId
}

func (_this GetBranchKeyIdFromDdbKeyOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetBranchKeyIdFromDdbKeyOutput_GetBranchKeyIdFromDdbKeyOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetBranchKeyIdFromDdbKeyOutput.GetBranchKeyIdFromDdbKeyOutput" + "(" + _dafny.String(data.BranchKeyId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetBranchKeyIdFromDdbKeyOutput) Equals(other GetBranchKeyIdFromDdbKeyOutput) bool {
	switch data1 := _this.Get_().(type) {
	case GetBranchKeyIdFromDdbKeyOutput_GetBranchKeyIdFromDdbKeyOutput:
		{
			data2, ok := other.Get_().(GetBranchKeyIdFromDdbKeyOutput_GetBranchKeyIdFromDdbKeyOutput)
			return ok && data1.BranchKeyId.Equals(data2.BranchKeyId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetBranchKeyIdFromDdbKeyOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetBranchKeyIdFromDdbKeyOutput)
	return ok && _this.Equals(typed)
}

func Type_GetBranchKeyIdFromDdbKeyOutput_() _dafny.TypeDescriptor {
	return type_GetBranchKeyIdFromDdbKeyOutput_{}
}

type type_GetBranchKeyIdFromDdbKeyOutput_ struct {
}

func (_this type_GetBranchKeyIdFromDdbKeyOutput_) Default() interface{} {
	return Companion_GetBranchKeyIdFromDdbKeyOutput_.Default()
}

func (_this type_GetBranchKeyIdFromDdbKeyOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetBranchKeyIdFromDdbKeyOutput"
}
func (_this GetBranchKeyIdFromDdbKeyOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetBranchKeyIdFromDdbKeyOutput{}

// End of datatype GetBranchKeyIdFromDdbKeyOutput

// Definition of datatype GetEncryptedDataKeyDescriptionInput
type GetEncryptedDataKeyDescriptionInput struct {
	Data_GetEncryptedDataKeyDescriptionInput_
}

func (_this GetEncryptedDataKeyDescriptionInput) Get_() Data_GetEncryptedDataKeyDescriptionInput_ {
	return _this.Data_GetEncryptedDataKeyDescriptionInput_
}

type Data_GetEncryptedDataKeyDescriptionInput_ interface {
	isGetEncryptedDataKeyDescriptionInput()
}

type CompanionStruct_GetEncryptedDataKeyDescriptionInput_ struct {
}

var Companion_GetEncryptedDataKeyDescriptionInput_ = CompanionStruct_GetEncryptedDataKeyDescriptionInput_{}

type GetEncryptedDataKeyDescriptionInput_GetEncryptedDataKeyDescriptionInput struct {
	Input GetEncryptedDataKeyDescriptionUnion
}

func (GetEncryptedDataKeyDescriptionInput_GetEncryptedDataKeyDescriptionInput) isGetEncryptedDataKeyDescriptionInput() {
}

func (CompanionStruct_GetEncryptedDataKeyDescriptionInput_) Create_GetEncryptedDataKeyDescriptionInput_(Input GetEncryptedDataKeyDescriptionUnion) GetEncryptedDataKeyDescriptionInput {
	return GetEncryptedDataKeyDescriptionInput{GetEncryptedDataKeyDescriptionInput_GetEncryptedDataKeyDescriptionInput{Input}}
}

func (_this GetEncryptedDataKeyDescriptionInput) Is_GetEncryptedDataKeyDescriptionInput() bool {
	_, ok := _this.Get_().(GetEncryptedDataKeyDescriptionInput_GetEncryptedDataKeyDescriptionInput)
	return ok
}

func (CompanionStruct_GetEncryptedDataKeyDescriptionInput_) Default() GetEncryptedDataKeyDescriptionInput {
	return Companion_GetEncryptedDataKeyDescriptionInput_.Create_GetEncryptedDataKeyDescriptionInput_(Companion_GetEncryptedDataKeyDescriptionUnion_.Default())
}

func (_this GetEncryptedDataKeyDescriptionInput) Dtor_input() GetEncryptedDataKeyDescriptionUnion {
	return _this.Get_().(GetEncryptedDataKeyDescriptionInput_GetEncryptedDataKeyDescriptionInput).Input
}

func (_this GetEncryptedDataKeyDescriptionInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetEncryptedDataKeyDescriptionInput_GetEncryptedDataKeyDescriptionInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionInput.GetEncryptedDataKeyDescriptionInput" + "(" + _dafny.String(data.Input) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetEncryptedDataKeyDescriptionInput) Equals(other GetEncryptedDataKeyDescriptionInput) bool {
	switch data1 := _this.Get_().(type) {
	case GetEncryptedDataKeyDescriptionInput_GetEncryptedDataKeyDescriptionInput:
		{
			data2, ok := other.Get_().(GetEncryptedDataKeyDescriptionInput_GetEncryptedDataKeyDescriptionInput)
			return ok && data1.Input.Equals(data2.Input)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetEncryptedDataKeyDescriptionInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetEncryptedDataKeyDescriptionInput)
	return ok && _this.Equals(typed)
}

func Type_GetEncryptedDataKeyDescriptionInput_() _dafny.TypeDescriptor {
	return type_GetEncryptedDataKeyDescriptionInput_{}
}

type type_GetEncryptedDataKeyDescriptionInput_ struct {
}

func (_this type_GetEncryptedDataKeyDescriptionInput_) Default() interface{} {
	return Companion_GetEncryptedDataKeyDescriptionInput_.Default()
}

func (_this type_GetEncryptedDataKeyDescriptionInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionInput"
}
func (_this GetEncryptedDataKeyDescriptionInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetEncryptedDataKeyDescriptionInput{}

// End of datatype GetEncryptedDataKeyDescriptionInput

// Definition of datatype GetEncryptedDataKeyDescriptionOutput
type GetEncryptedDataKeyDescriptionOutput struct {
	Data_GetEncryptedDataKeyDescriptionOutput_
}

func (_this GetEncryptedDataKeyDescriptionOutput) Get_() Data_GetEncryptedDataKeyDescriptionOutput_ {
	return _this.Data_GetEncryptedDataKeyDescriptionOutput_
}

type Data_GetEncryptedDataKeyDescriptionOutput_ interface {
	isGetEncryptedDataKeyDescriptionOutput()
}

type CompanionStruct_GetEncryptedDataKeyDescriptionOutput_ struct {
}

var Companion_GetEncryptedDataKeyDescriptionOutput_ = CompanionStruct_GetEncryptedDataKeyDescriptionOutput_{}

type GetEncryptedDataKeyDescriptionOutput_GetEncryptedDataKeyDescriptionOutput struct {
	EncryptedDataKeyDescriptionOutput _dafny.Sequence
}

func (GetEncryptedDataKeyDescriptionOutput_GetEncryptedDataKeyDescriptionOutput) isGetEncryptedDataKeyDescriptionOutput() {
}

func (CompanionStruct_GetEncryptedDataKeyDescriptionOutput_) Create_GetEncryptedDataKeyDescriptionOutput_(EncryptedDataKeyDescriptionOutput _dafny.Sequence) GetEncryptedDataKeyDescriptionOutput {
	return GetEncryptedDataKeyDescriptionOutput{GetEncryptedDataKeyDescriptionOutput_GetEncryptedDataKeyDescriptionOutput{EncryptedDataKeyDescriptionOutput}}
}

func (_this GetEncryptedDataKeyDescriptionOutput) Is_GetEncryptedDataKeyDescriptionOutput() bool {
	_, ok := _this.Get_().(GetEncryptedDataKeyDescriptionOutput_GetEncryptedDataKeyDescriptionOutput)
	return ok
}

func (CompanionStruct_GetEncryptedDataKeyDescriptionOutput_) Default() GetEncryptedDataKeyDescriptionOutput {
	return Companion_GetEncryptedDataKeyDescriptionOutput_.Create_GetEncryptedDataKeyDescriptionOutput_(_dafny.EmptySeq)
}

func (_this GetEncryptedDataKeyDescriptionOutput) Dtor_EncryptedDataKeyDescriptionOutput() _dafny.Sequence {
	return _this.Get_().(GetEncryptedDataKeyDescriptionOutput_GetEncryptedDataKeyDescriptionOutput).EncryptedDataKeyDescriptionOutput
}

func (_this GetEncryptedDataKeyDescriptionOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetEncryptedDataKeyDescriptionOutput_GetEncryptedDataKeyDescriptionOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput.GetEncryptedDataKeyDescriptionOutput" + "(" + _dafny.String(data.EncryptedDataKeyDescriptionOutput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetEncryptedDataKeyDescriptionOutput) Equals(other GetEncryptedDataKeyDescriptionOutput) bool {
	switch data1 := _this.Get_().(type) {
	case GetEncryptedDataKeyDescriptionOutput_GetEncryptedDataKeyDescriptionOutput:
		{
			data2, ok := other.Get_().(GetEncryptedDataKeyDescriptionOutput_GetEncryptedDataKeyDescriptionOutput)
			return ok && data1.EncryptedDataKeyDescriptionOutput.Equals(data2.EncryptedDataKeyDescriptionOutput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetEncryptedDataKeyDescriptionOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetEncryptedDataKeyDescriptionOutput)
	return ok && _this.Equals(typed)
}

func Type_GetEncryptedDataKeyDescriptionOutput_() _dafny.TypeDescriptor {
	return type_GetEncryptedDataKeyDescriptionOutput_{}
}

type type_GetEncryptedDataKeyDescriptionOutput_ struct {
}

func (_this type_GetEncryptedDataKeyDescriptionOutput_) Default() interface{} {
	return Companion_GetEncryptedDataKeyDescriptionOutput_.Default()
}

func (_this type_GetEncryptedDataKeyDescriptionOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput"
}
func (_this GetEncryptedDataKeyDescriptionOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetEncryptedDataKeyDescriptionOutput{}

// End of datatype GetEncryptedDataKeyDescriptionOutput

// Definition of datatype GetEncryptedDataKeyDescriptionUnion
type GetEncryptedDataKeyDescriptionUnion struct {
	Data_GetEncryptedDataKeyDescriptionUnion_
}

func (_this GetEncryptedDataKeyDescriptionUnion) Get_() Data_GetEncryptedDataKeyDescriptionUnion_ {
	return _this.Data_GetEncryptedDataKeyDescriptionUnion_
}

type Data_GetEncryptedDataKeyDescriptionUnion_ interface {
	isGetEncryptedDataKeyDescriptionUnion()
}

type CompanionStruct_GetEncryptedDataKeyDescriptionUnion_ struct {
}

var Companion_GetEncryptedDataKeyDescriptionUnion_ = CompanionStruct_GetEncryptedDataKeyDescriptionUnion_{}

type GetEncryptedDataKeyDescriptionUnion_header struct {
	Header _dafny.Sequence
}

func (GetEncryptedDataKeyDescriptionUnion_header) isGetEncryptedDataKeyDescriptionUnion() {}

func (CompanionStruct_GetEncryptedDataKeyDescriptionUnion_) Create_header_(Header _dafny.Sequence) GetEncryptedDataKeyDescriptionUnion {
	return GetEncryptedDataKeyDescriptionUnion{GetEncryptedDataKeyDescriptionUnion_header{Header}}
}

func (_this GetEncryptedDataKeyDescriptionUnion) Is_header() bool {
	_, ok := _this.Get_().(GetEncryptedDataKeyDescriptionUnion_header)
	return ok
}

type GetEncryptedDataKeyDescriptionUnion_item struct {
	Item _dafny.Map
}

func (GetEncryptedDataKeyDescriptionUnion_item) isGetEncryptedDataKeyDescriptionUnion() {}

func (CompanionStruct_GetEncryptedDataKeyDescriptionUnion_) Create_item_(Item _dafny.Map) GetEncryptedDataKeyDescriptionUnion {
	return GetEncryptedDataKeyDescriptionUnion{GetEncryptedDataKeyDescriptionUnion_item{Item}}
}

func (_this GetEncryptedDataKeyDescriptionUnion) Is_item() bool {
	_, ok := _this.Get_().(GetEncryptedDataKeyDescriptionUnion_item)
	return ok
}

func (CompanionStruct_GetEncryptedDataKeyDescriptionUnion_) Default() GetEncryptedDataKeyDescriptionUnion {
	return Companion_GetEncryptedDataKeyDescriptionUnion_.Create_header_(_dafny.EmptySeq)
}

func (_this GetEncryptedDataKeyDescriptionUnion) Dtor_header() _dafny.Sequence {
	return _this.Get_().(GetEncryptedDataKeyDescriptionUnion_header).Header
}

func (_this GetEncryptedDataKeyDescriptionUnion) Dtor_item() _dafny.Map {
	return _this.Get_().(GetEncryptedDataKeyDescriptionUnion_item).Item
}

func (_this GetEncryptedDataKeyDescriptionUnion) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetEncryptedDataKeyDescriptionUnion_header:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionUnion.header" + "(" + _dafny.String(data.Header) + ")"
		}
	case GetEncryptedDataKeyDescriptionUnion_item:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionUnion.item" + "(" + _dafny.String(data.Item) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetEncryptedDataKeyDescriptionUnion) Equals(other GetEncryptedDataKeyDescriptionUnion) bool {
	switch data1 := _this.Get_().(type) {
	case GetEncryptedDataKeyDescriptionUnion_header:
		{
			data2, ok := other.Get_().(GetEncryptedDataKeyDescriptionUnion_header)
			return ok && data1.Header.Equals(data2.Header)
		}
	case GetEncryptedDataKeyDescriptionUnion_item:
		{
			data2, ok := other.Get_().(GetEncryptedDataKeyDescriptionUnion_item)
			return ok && data1.Item.Equals(data2.Item)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetEncryptedDataKeyDescriptionUnion) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetEncryptedDataKeyDescriptionUnion)
	return ok && _this.Equals(typed)
}

func Type_GetEncryptedDataKeyDescriptionUnion_() _dafny.TypeDescriptor {
	return type_GetEncryptedDataKeyDescriptionUnion_{}
}

type type_GetEncryptedDataKeyDescriptionUnion_ struct {
}

func (_this type_GetEncryptedDataKeyDescriptionUnion_) Default() interface{} {
	return Companion_GetEncryptedDataKeyDescriptionUnion_.Default()
}

func (_this type_GetEncryptedDataKeyDescriptionUnion_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionUnion"
}
func (_this GetEncryptedDataKeyDescriptionUnion) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetEncryptedDataKeyDescriptionUnion{}

// End of datatype GetEncryptedDataKeyDescriptionUnion

// Definition of datatype GetPrefix
type GetPrefix struct {
	Data_GetPrefix_
}

func (_this GetPrefix) Get_() Data_GetPrefix_ {
	return _this.Data_GetPrefix_
}

type Data_GetPrefix_ interface {
	isGetPrefix()
}

type CompanionStruct_GetPrefix_ struct {
}

var Companion_GetPrefix_ = CompanionStruct_GetPrefix_{}

type GetPrefix_GetPrefix struct {
	Length int32
}

func (GetPrefix_GetPrefix) isGetPrefix() {}

func (CompanionStruct_GetPrefix_) Create_GetPrefix_(Length int32) GetPrefix {
	return GetPrefix{GetPrefix_GetPrefix{Length}}
}

func (_this GetPrefix) Is_GetPrefix() bool {
	_, ok := _this.Get_().(GetPrefix_GetPrefix)
	return ok
}

func (CompanionStruct_GetPrefix_) Default() GetPrefix {
	return Companion_GetPrefix_.Create_GetPrefix_(int32(0))
}

func (_this GetPrefix) Dtor_length() int32 {
	return _this.Get_().(GetPrefix_GetPrefix).Length
}

func (_this GetPrefix) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetPrefix_GetPrefix:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetPrefix.GetPrefix" + "(" + _dafny.String(data.Length) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetPrefix) Equals(other GetPrefix) bool {
	switch data1 := _this.Get_().(type) {
	case GetPrefix_GetPrefix:
		{
			data2, ok := other.Get_().(GetPrefix_GetPrefix)
			return ok && data1.Length == data2.Length
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetPrefix) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetPrefix)
	return ok && _this.Equals(typed)
}

func Type_GetPrefix_() _dafny.TypeDescriptor {
	return type_GetPrefix_{}
}

type type_GetPrefix_ struct {
}

func (_this type_GetPrefix_) Default() interface{} {
	return Companion_GetPrefix_.Default()
}

func (_this type_GetPrefix_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetPrefix"
}
func (_this GetPrefix) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetPrefix{}

// End of datatype GetPrefix

// Definition of datatype GetSegment
type GetSegment struct {
	Data_GetSegment_
}

func (_this GetSegment) Get_() Data_GetSegment_ {
	return _this.Data_GetSegment_
}

type Data_GetSegment_ interface {
	isGetSegment()
}

type CompanionStruct_GetSegment_ struct {
}

var Companion_GetSegment_ = CompanionStruct_GetSegment_{}

type GetSegment_GetSegment struct {
	Split _dafny.Sequence
	Index int32
}

func (GetSegment_GetSegment) isGetSegment() {}

func (CompanionStruct_GetSegment_) Create_GetSegment_(Split _dafny.Sequence, Index int32) GetSegment {
	return GetSegment{GetSegment_GetSegment{Split, Index}}
}

func (_this GetSegment) Is_GetSegment() bool {
	_, ok := _this.Get_().(GetSegment_GetSegment)
	return ok
}

func (CompanionStruct_GetSegment_) Default() GetSegment {
	return Companion_GetSegment_.Create_GetSegment_(_dafny.EmptySeq.SetString(), int32(0))
}

func (_this GetSegment) Dtor_split() _dafny.Sequence {
	return _this.Get_().(GetSegment_GetSegment).Split
}

func (_this GetSegment) Dtor_index() int32 {
	return _this.Get_().(GetSegment_GetSegment).Index
}

func (_this GetSegment) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetSegment_GetSegment:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetSegment.GetSegment" + "(" + _dafny.String(data.Split) + ", " + _dafny.String(data.Index) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetSegment) Equals(other GetSegment) bool {
	switch data1 := _this.Get_().(type) {
	case GetSegment_GetSegment:
		{
			data2, ok := other.Get_().(GetSegment_GetSegment)
			return ok && data1.Split.Equals(data2.Split) && data1.Index == data2.Index
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetSegment) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetSegment)
	return ok && _this.Equals(typed)
}

func Type_GetSegment_() _dafny.TypeDescriptor {
	return type_GetSegment_{}
}

type type_GetSegment_ struct {
}

func (_this type_GetSegment_) Default() interface{} {
	return Companion_GetSegment_.Default()
}

func (_this type_GetSegment_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetSegment"
}
func (_this GetSegment) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetSegment{}

// End of datatype GetSegment

// Definition of datatype GetSegments
type GetSegments struct {
	Data_GetSegments_
}

func (_this GetSegments) Get_() Data_GetSegments_ {
	return _this.Data_GetSegments_
}

type Data_GetSegments_ interface {
	isGetSegments()
}

type CompanionStruct_GetSegments_ struct {
}

var Companion_GetSegments_ = CompanionStruct_GetSegments_{}

type GetSegments_GetSegments struct {
	Split _dafny.Sequence
	Low   int32
	High  int32
}

func (GetSegments_GetSegments) isGetSegments() {}

func (CompanionStruct_GetSegments_) Create_GetSegments_(Split _dafny.Sequence, Low int32, High int32) GetSegments {
	return GetSegments{GetSegments_GetSegments{Split, Low, High}}
}

func (_this GetSegments) Is_GetSegments() bool {
	_, ok := _this.Get_().(GetSegments_GetSegments)
	return ok
}

func (CompanionStruct_GetSegments_) Default() GetSegments {
	return Companion_GetSegments_.Create_GetSegments_(_dafny.EmptySeq.SetString(), int32(0), int32(0))
}

func (_this GetSegments) Dtor_split() _dafny.Sequence {
	return _this.Get_().(GetSegments_GetSegments).Split
}

func (_this GetSegments) Dtor_low() int32 {
	return _this.Get_().(GetSegments_GetSegments).Low
}

func (_this GetSegments) Dtor_high() int32 {
	return _this.Get_().(GetSegments_GetSegments).High
}

func (_this GetSegments) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetSegments_GetSegments:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetSegments.GetSegments" + "(" + _dafny.String(data.Split) + ", " + _dafny.String(data.Low) + ", " + _dafny.String(data.High) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetSegments) Equals(other GetSegments) bool {
	switch data1 := _this.Get_().(type) {
	case GetSegments_GetSegments:
		{
			data2, ok := other.Get_().(GetSegments_GetSegments)
			return ok && data1.Split.Equals(data2.Split) && data1.Low == data2.Low && data1.High == data2.High
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetSegments) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetSegments)
	return ok && _this.Equals(typed)
}

func Type_GetSegments_() _dafny.TypeDescriptor {
	return type_GetSegments_{}
}

type type_GetSegments_ struct {
}

func (_this type_GetSegments_) Default() interface{} {
	return Companion_GetSegments_.Default()
}

func (_this type_GetSegments_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetSegments"
}
func (_this GetSegments) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetSegments{}

// End of datatype GetSegments

// Definition of datatype GetSubstring
type GetSubstring struct {
	Data_GetSubstring_
}

func (_this GetSubstring) Get_() Data_GetSubstring_ {
	return _this.Data_GetSubstring_
}

type Data_GetSubstring_ interface {
	isGetSubstring()
}

type CompanionStruct_GetSubstring_ struct {
}

var Companion_GetSubstring_ = CompanionStruct_GetSubstring_{}

type GetSubstring_GetSubstring struct {
	Low  int32
	High int32
}

func (GetSubstring_GetSubstring) isGetSubstring() {}

func (CompanionStruct_GetSubstring_) Create_GetSubstring_(Low int32, High int32) GetSubstring {
	return GetSubstring{GetSubstring_GetSubstring{Low, High}}
}

func (_this GetSubstring) Is_GetSubstring() bool {
	_, ok := _this.Get_().(GetSubstring_GetSubstring)
	return ok
}

func (CompanionStruct_GetSubstring_) Default() GetSubstring {
	return Companion_GetSubstring_.Create_GetSubstring_(int32(0), int32(0))
}

func (_this GetSubstring) Dtor_low() int32 {
	return _this.Get_().(GetSubstring_GetSubstring).Low
}

func (_this GetSubstring) Dtor_high() int32 {
	return _this.Get_().(GetSubstring_GetSubstring).High
}

func (_this GetSubstring) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetSubstring_GetSubstring:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetSubstring.GetSubstring" + "(" + _dafny.String(data.Low) + ", " + _dafny.String(data.High) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetSubstring) Equals(other GetSubstring) bool {
	switch data1 := _this.Get_().(type) {
	case GetSubstring_GetSubstring:
		{
			data2, ok := other.Get_().(GetSubstring_GetSubstring)
			return ok && data1.Low == data2.Low && data1.High == data2.High
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetSubstring) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetSubstring)
	return ok && _this.Equals(typed)
}

func Type_GetSubstring_() _dafny.TypeDescriptor {
	return type_GetSubstring_{}
}

type type_GetSubstring_ struct {
}

func (_this type_GetSubstring_) Default() interface{} {
	return Companion_GetSubstring_.Default()
}

func (_this type_GetSubstring_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetSubstring"
}
func (_this GetSubstring) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetSubstring{}

// End of datatype GetSubstring

// Definition of datatype GetSuffix
type GetSuffix struct {
	Data_GetSuffix_
}

func (_this GetSuffix) Get_() Data_GetSuffix_ {
	return _this.Data_GetSuffix_
}

type Data_GetSuffix_ interface {
	isGetSuffix()
}

type CompanionStruct_GetSuffix_ struct {
}

var Companion_GetSuffix_ = CompanionStruct_GetSuffix_{}

type GetSuffix_GetSuffix struct {
	Length int32
}

func (GetSuffix_GetSuffix) isGetSuffix() {}

func (CompanionStruct_GetSuffix_) Create_GetSuffix_(Length int32) GetSuffix {
	return GetSuffix{GetSuffix_GetSuffix{Length}}
}

func (_this GetSuffix) Is_GetSuffix() bool {
	_, ok := _this.Get_().(GetSuffix_GetSuffix)
	return ok
}

func (CompanionStruct_GetSuffix_) Default() GetSuffix {
	return Companion_GetSuffix_.Create_GetSuffix_(int32(0))
}

func (_this GetSuffix) Dtor_length() int32 {
	return _this.Get_().(GetSuffix_GetSuffix).Length
}

func (_this GetSuffix) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetSuffix_GetSuffix:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetSuffix.GetSuffix" + "(" + _dafny.String(data.Length) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetSuffix) Equals(other GetSuffix) bool {
	switch data1 := _this.Get_().(type) {
	case GetSuffix_GetSuffix:
		{
			data2, ok := other.Get_().(GetSuffix_GetSuffix)
			return ok && data1.Length == data2.Length
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetSuffix) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetSuffix)
	return ok && _this.Equals(typed)
}

func Type_GetSuffix_() _dafny.TypeDescriptor {
	return type_GetSuffix_{}
}

type type_GetSuffix_ struct {
}

func (_this type_GetSuffix_) Default() interface{} {
	return Companion_GetSuffix_.Default()
}

func (_this type_GetSuffix_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetSuffix"
}
func (_this GetSuffix) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetSuffix{}

// End of datatype GetSuffix

// Definition of datatype Insert
type Insert struct {
	Data_Insert_
}

func (_this Insert) Get_() Data_Insert_ {
	return _this.Data_Insert_
}

type Data_Insert_ interface {
	isInsert()
}

type CompanionStruct_Insert_ struct {
}

var Companion_Insert_ = CompanionStruct_Insert_{}

type Insert_Insert struct {
	Literal _dafny.Sequence
}

func (Insert_Insert) isInsert() {}

func (CompanionStruct_Insert_) Create_Insert_(Literal _dafny.Sequence) Insert {
	return Insert{Insert_Insert{Literal}}
}

func (_this Insert) Is_Insert() bool {
	_, ok := _this.Get_().(Insert_Insert)
	return ok
}

func (CompanionStruct_Insert_) Default() Insert {
	return Companion_Insert_.Create_Insert_(_dafny.EmptySeq.SetString())
}

func (_this Insert) Dtor_literal() _dafny.Sequence {
	return _this.Get_().(Insert_Insert).Literal
}

func (_this Insert) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Insert_Insert:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Insert.Insert" + "(" + _dafny.String(data.Literal) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Insert) Equals(other Insert) bool {
	switch data1 := _this.Get_().(type) {
	case Insert_Insert:
		{
			data2, ok := other.Get_().(Insert_Insert)
			return ok && data1.Literal.Equals(data2.Literal)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Insert) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Insert)
	return ok && _this.Equals(typed)
}

func Type_Insert_() _dafny.TypeDescriptor {
	return type_Insert_{}
}

type type_Insert_ struct {
}

func (_this type_Insert_) Default() interface{} {
	return Companion_Insert_.Default()
}

func (_this type_Insert_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Insert"
}
func (_this Insert) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Insert{}

// End of datatype Insert

// Definition of class ILegacyDynamoDbEncryptorCallHistory
type ILegacyDynamoDbEncryptorCallHistory struct {
	dummy byte
}

func New_ILegacyDynamoDbEncryptorCallHistory_() *ILegacyDynamoDbEncryptorCallHistory {
	_this := ILegacyDynamoDbEncryptorCallHistory{}

	return &_this
}

type CompanionStruct_ILegacyDynamoDbEncryptorCallHistory_ struct {
}

var Companion_ILegacyDynamoDbEncryptorCallHistory_ = CompanionStruct_ILegacyDynamoDbEncryptorCallHistory_{}

func (_this *ILegacyDynamoDbEncryptorCallHistory) Equals(other *ILegacyDynamoDbEncryptorCallHistory) bool {
	return _this == other
}

func (_this *ILegacyDynamoDbEncryptorCallHistory) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*ILegacyDynamoDbEncryptorCallHistory)
	return ok && _this.Equals(other)
}

func (*ILegacyDynamoDbEncryptorCallHistory) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.ILegacyDynamoDbEncryptorCallHistory"
}

func Type_ILegacyDynamoDbEncryptorCallHistory_() _dafny.TypeDescriptor {
	return type_ILegacyDynamoDbEncryptorCallHistory_{}
}

type type_ILegacyDynamoDbEncryptorCallHistory_ struct {
}

func (_this type_ILegacyDynamoDbEncryptorCallHistory_) Default() interface{} {
	return (*ILegacyDynamoDbEncryptorCallHistory)(nil)
}

func (_this type_ILegacyDynamoDbEncryptorCallHistory_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.ILegacyDynamoDbEncryptorCallHistory"
}
func (_this *ILegacyDynamoDbEncryptorCallHistory) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &ILegacyDynamoDbEncryptorCallHistory{}

// End of class ILegacyDynamoDbEncryptorCallHistory

// Definition of trait ILegacyDynamoDbEncryptor
type ILegacyDynamoDbEncryptor interface {
	String() string
}
type CompanionStruct_ILegacyDynamoDbEncryptor_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_ILegacyDynamoDbEncryptor_ = CompanionStruct_ILegacyDynamoDbEncryptor_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_ILegacyDynamoDbEncryptor_) CastTo_(x interface{}) ILegacyDynamoDbEncryptor {
	var t ILegacyDynamoDbEncryptor
	t, _ = x.(ILegacyDynamoDbEncryptor)
	return t
}

// End of trait ILegacyDynamoDbEncryptor

// Definition of datatype LegacyOverride
type LegacyOverride struct {
	Data_LegacyOverride_
}

func (_this LegacyOverride) Get_() Data_LegacyOverride_ {
	return _this.Data_LegacyOverride_
}

type Data_LegacyOverride_ interface {
	isLegacyOverride()
}

type CompanionStruct_LegacyOverride_ struct {
}

var Companion_LegacyOverride_ = CompanionStruct_LegacyOverride_{}

type LegacyOverride_LegacyOverride struct {
	Policy                    LegacyPolicy
	Encryptor                 ILegacyDynamoDbEncryptor
	AttributeActionsOnEncrypt _dafny.Map
	DefaultAttributeFlag      m_Wrappers.Option
}

func (LegacyOverride_LegacyOverride) isLegacyOverride() {}

func (CompanionStruct_LegacyOverride_) Create_LegacyOverride_(Policy LegacyPolicy, Encryptor ILegacyDynamoDbEncryptor, AttributeActionsOnEncrypt _dafny.Map, DefaultAttributeFlag m_Wrappers.Option) LegacyOverride {
	return LegacyOverride{LegacyOverride_LegacyOverride{Policy, Encryptor, AttributeActionsOnEncrypt, DefaultAttributeFlag}}
}

func (_this LegacyOverride) Is_LegacyOverride() bool {
	_, ok := _this.Get_().(LegacyOverride_LegacyOverride)
	return ok
}

func (CompanionStruct_LegacyOverride_) Default() LegacyOverride {
	return Companion_LegacyOverride_.Create_LegacyOverride_(Companion_LegacyPolicy_.Default(), (ILegacyDynamoDbEncryptor)(nil), _dafny.EmptyMap, m_Wrappers.Companion_Option_.Default())
}

func (_this LegacyOverride) Dtor_policy() LegacyPolicy {
	return _this.Get_().(LegacyOverride_LegacyOverride).Policy
}

func (_this LegacyOverride) Dtor_encryptor() ILegacyDynamoDbEncryptor {
	return _this.Get_().(LegacyOverride_LegacyOverride).Encryptor
}

func (_this LegacyOverride) Dtor_attributeActionsOnEncrypt() _dafny.Map {
	return _this.Get_().(LegacyOverride_LegacyOverride).AttributeActionsOnEncrypt
}

func (_this LegacyOverride) Dtor_defaultAttributeFlag() m_Wrappers.Option {
	return _this.Get_().(LegacyOverride_LegacyOverride).DefaultAttributeFlag
}

func (_this LegacyOverride) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case LegacyOverride_LegacyOverride:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.LegacyOverride.LegacyOverride" + "(" + _dafny.String(data.Policy) + ", " + _dafny.String(data.Encryptor) + ", " + _dafny.String(data.AttributeActionsOnEncrypt) + ", " + _dafny.String(data.DefaultAttributeFlag) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this LegacyOverride) Equals(other LegacyOverride) bool {
	switch data1 := _this.Get_().(type) {
	case LegacyOverride_LegacyOverride:
		{
			data2, ok := other.Get_().(LegacyOverride_LegacyOverride)
			return ok && data1.Policy.Equals(data2.Policy) && _dafny.AreEqual(data1.Encryptor, data2.Encryptor) && data1.AttributeActionsOnEncrypt.Equals(data2.AttributeActionsOnEncrypt) && data1.DefaultAttributeFlag.Equals(data2.DefaultAttributeFlag)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this LegacyOverride) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(LegacyOverride)
	return ok && _this.Equals(typed)
}

func Type_LegacyOverride_() _dafny.TypeDescriptor {
	return type_LegacyOverride_{}
}

type type_LegacyOverride_ struct {
}

func (_this type_LegacyOverride_) Default() interface{} {
	return Companion_LegacyOverride_.Default()
}

func (_this type_LegacyOverride_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.LegacyOverride"
}
func (_this LegacyOverride) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = LegacyOverride{}

// End of datatype LegacyOverride

// Definition of datatype LegacyPolicy
type LegacyPolicy struct {
	Data_LegacyPolicy_
}

func (_this LegacyPolicy) Get_() Data_LegacyPolicy_ {
	return _this.Data_LegacyPolicy_
}

type Data_LegacyPolicy_ interface {
	isLegacyPolicy()
}

type CompanionStruct_LegacyPolicy_ struct {
}

var Companion_LegacyPolicy_ = CompanionStruct_LegacyPolicy_{}

type LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT struct {
}

func (LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT) isLegacyPolicy() {}

func (CompanionStruct_LegacyPolicy_) Create_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT_() LegacyPolicy {
	return LegacyPolicy{LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT{}}
}

func (_this LegacyPolicy) Is_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT() bool {
	_, ok := _this.Get_().(LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT)
	return ok
}

type LegacyPolicy_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT struct {
}

func (LegacyPolicy_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT) isLegacyPolicy() {}

func (CompanionStruct_LegacyPolicy_) Create_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT_() LegacyPolicy {
	return LegacyPolicy{LegacyPolicy_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT{}}
}

func (_this LegacyPolicy) Is_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT() bool {
	_, ok := _this.Get_().(LegacyPolicy_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT)
	return ok
}

type LegacyPolicy_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT struct {
}

func (LegacyPolicy_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT) isLegacyPolicy() {}

func (CompanionStruct_LegacyPolicy_) Create_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT_() LegacyPolicy {
	return LegacyPolicy{LegacyPolicy_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT{}}
}

func (_this LegacyPolicy) Is_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT() bool {
	_, ok := _this.Get_().(LegacyPolicy_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT)
	return ok
}

func (CompanionStruct_LegacyPolicy_) Default() LegacyPolicy {
	return Companion_LegacyPolicy_.Create_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT_()
}

func (_ CompanionStruct_LegacyPolicy_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_LegacyPolicy_.Create_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT_(), true
		case 1:
			return Companion_LegacyPolicy_.Create_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT_(), true
		case 2:
			return Companion_LegacyPolicy_.Create_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT_(), true
		default:
			return LegacyPolicy{}, false
		}
	}
}

func (_this LegacyPolicy) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT"
		}
	case LegacyPolicy_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.LegacyPolicy.FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT"
		}
	case LegacyPolicy_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.LegacyPolicy.FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this LegacyPolicy) Equals(other LegacyPolicy) bool {
	switch _this.Get_().(type) {
	case LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT:
		{
			_, ok := other.Get_().(LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT)
			return ok
		}
	case LegacyPolicy_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT:
		{
			_, ok := other.Get_().(LegacyPolicy_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT)
			return ok
		}
	case LegacyPolicy_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT:
		{
			_, ok := other.Get_().(LegacyPolicy_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this LegacyPolicy) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(LegacyPolicy)
	return ok && _this.Equals(typed)
}

func Type_LegacyPolicy_() _dafny.TypeDescriptor {
	return type_LegacyPolicy_{}
}

type type_LegacyPolicy_ struct {
}

func (_this type_LegacyPolicy_) Default() interface{} {
	return Companion_LegacyPolicy_.Default()
}

func (_this type_LegacyPolicy_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.LegacyPolicy"
}
func (_this LegacyPolicy) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = LegacyPolicy{}

// End of datatype LegacyPolicy

// Definition of datatype Lower
type Lower struct {
	Data_Lower_
}

func (_this Lower) Get_() Data_Lower_ {
	return _this.Data_Lower_
}

type Data_Lower_ interface {
	isLower()
}

type CompanionStruct_Lower_ struct {
}

var Companion_Lower_ = CompanionStruct_Lower_{}

type Lower_Lower struct {
}

func (Lower_Lower) isLower() {}

func (CompanionStruct_Lower_) Create_Lower_() Lower {
	return Lower{Lower_Lower{}}
}

func (_this Lower) Is_Lower() bool {
	_, ok := _this.Get_().(Lower_Lower)
	return ok
}

func (CompanionStruct_Lower_) Default() Lower {
	return Companion_Lower_.Create_Lower_()
}

func (_ CompanionStruct_Lower_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_Lower_.Create_Lower_(), true
		default:
			return Lower{}, false
		}
	}
}

func (_this Lower) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case Lower_Lower:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Lower.Lower"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Lower) Equals(other Lower) bool {
	switch _this.Get_().(type) {
	case Lower_Lower:
		{
			_, ok := other.Get_().(Lower_Lower)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Lower) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Lower)
	return ok && _this.Equals(typed)
}

func Type_Lower_() _dafny.TypeDescriptor {
	return type_Lower_{}
}

type type_Lower_ struct {
}

func (_this type_Lower_) Default() interface{} {
	return Companion_Lower_.Default()
}

func (_this type_Lower_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Lower"
}
func (_this Lower) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Lower{}

// End of datatype Lower

// Definition of datatype MultiKeyStore
type MultiKeyStore struct {
	Data_MultiKeyStore_
}

func (_this MultiKeyStore) Get_() Data_MultiKeyStore_ {
	return _this.Data_MultiKeyStore_
}

type Data_MultiKeyStore_ interface {
	isMultiKeyStore()
}

type CompanionStruct_MultiKeyStore_ struct {
}

var Companion_MultiKeyStore_ = CompanionStruct_MultiKeyStore_{}

type MultiKeyStore_MultiKeyStore struct {
	KeyFieldName _dafny.Sequence
	CacheTTL     int32
	Cache        m_Wrappers.Option
	PartitionId  m_Wrappers.Option
}

func (MultiKeyStore_MultiKeyStore) isMultiKeyStore() {}

func (CompanionStruct_MultiKeyStore_) Create_MultiKeyStore_(KeyFieldName _dafny.Sequence, CacheTTL int32, Cache m_Wrappers.Option, PartitionId m_Wrappers.Option) MultiKeyStore {
	return MultiKeyStore{MultiKeyStore_MultiKeyStore{KeyFieldName, CacheTTL, Cache, PartitionId}}
}

func (_this MultiKeyStore) Is_MultiKeyStore() bool {
	_, ok := _this.Get_().(MultiKeyStore_MultiKeyStore)
	return ok
}

func (CompanionStruct_MultiKeyStore_) Default() MultiKeyStore {
	return Companion_MultiKeyStore_.Create_MultiKeyStore_(_dafny.EmptySeq.SetString(), int32(0), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this MultiKeyStore) Dtor_keyFieldName() _dafny.Sequence {
	return _this.Get_().(MultiKeyStore_MultiKeyStore).KeyFieldName
}

func (_this MultiKeyStore) Dtor_cacheTTL() int32 {
	return _this.Get_().(MultiKeyStore_MultiKeyStore).CacheTTL
}

func (_this MultiKeyStore) Dtor_cache() m_Wrappers.Option {
	return _this.Get_().(MultiKeyStore_MultiKeyStore).Cache
}

func (_this MultiKeyStore) Dtor_partitionId() m_Wrappers.Option {
	return _this.Get_().(MultiKeyStore_MultiKeyStore).PartitionId
}

func (_this MultiKeyStore) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case MultiKeyStore_MultiKeyStore:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.MultiKeyStore.MultiKeyStore" + "(" + _dafny.String(data.KeyFieldName) + ", " + _dafny.String(data.CacheTTL) + ", " + _dafny.String(data.Cache) + ", " + _dafny.String(data.PartitionId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this MultiKeyStore) Equals(other MultiKeyStore) bool {
	switch data1 := _this.Get_().(type) {
	case MultiKeyStore_MultiKeyStore:
		{
			data2, ok := other.Get_().(MultiKeyStore_MultiKeyStore)
			return ok && data1.KeyFieldName.Equals(data2.KeyFieldName) && data1.CacheTTL == data2.CacheTTL && data1.Cache.Equals(data2.Cache) && data1.PartitionId.Equals(data2.PartitionId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this MultiKeyStore) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(MultiKeyStore)
	return ok && _this.Equals(typed)
}

func Type_MultiKeyStore_() _dafny.TypeDescriptor {
	return type_MultiKeyStore_{}
}

type type_MultiKeyStore_ struct {
}

func (_this type_MultiKeyStore_) Default() interface{} {
	return Companion_MultiKeyStore_.Default()
}

func (_this type_MultiKeyStore_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.MultiKeyStore"
}
func (_this MultiKeyStore) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = MultiKeyStore{}

// End of datatype MultiKeyStore

// Definition of datatype PartOnly
type PartOnly struct {
	Data_PartOnly_
}

func (_this PartOnly) Get_() Data_PartOnly_ {
	return _this.Data_PartOnly_
}

type Data_PartOnly_ interface {
	isPartOnly()
}

type CompanionStruct_PartOnly_ struct {
}

var Companion_PartOnly_ = CompanionStruct_PartOnly_{}

type PartOnly_PartOnly struct {
}

func (PartOnly_PartOnly) isPartOnly() {}

func (CompanionStruct_PartOnly_) Create_PartOnly_() PartOnly {
	return PartOnly{PartOnly_PartOnly{}}
}

func (_this PartOnly) Is_PartOnly() bool {
	_, ok := _this.Get_().(PartOnly_PartOnly)
	return ok
}

func (CompanionStruct_PartOnly_) Default() PartOnly {
	return Companion_PartOnly_.Create_PartOnly_()
}

func (_ CompanionStruct_PartOnly_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_PartOnly_.Create_PartOnly_(), true
		default:
			return PartOnly{}, false
		}
	}
}

func (_this PartOnly) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case PartOnly_PartOnly:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.PartOnly.PartOnly"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this PartOnly) Equals(other PartOnly) bool {
	switch _this.Get_().(type) {
	case PartOnly_PartOnly:
		{
			_, ok := other.Get_().(PartOnly_PartOnly)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this PartOnly) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(PartOnly)
	return ok && _this.Equals(typed)
}

func Type_PartOnly_() _dafny.TypeDescriptor {
	return type_PartOnly_{}
}

type type_PartOnly_ struct {
}

func (_this type_PartOnly_) Default() interface{} {
	return Companion_PartOnly_.Default()
}

func (_this type_PartOnly_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.PartOnly"
}
func (_this PartOnly) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = PartOnly{}

// End of datatype PartOnly

// Definition of datatype PlaintextOverride
type PlaintextOverride struct {
	Data_PlaintextOverride_
}

func (_this PlaintextOverride) Get_() Data_PlaintextOverride_ {
	return _this.Data_PlaintextOverride_
}

type Data_PlaintextOverride_ interface {
	isPlaintextOverride()
}

type CompanionStruct_PlaintextOverride_ struct {
}

var Companion_PlaintextOverride_ = CompanionStruct_PlaintextOverride_{}

type PlaintextOverride_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ struct {
}

func (PlaintextOverride_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ) isPlaintextOverride() {}

func (CompanionStruct_PlaintextOverride_) Create_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ_() PlaintextOverride {
	return PlaintextOverride{PlaintextOverride_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ{}}
}

func (_this PlaintextOverride) Is_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ() bool {
	_, ok := _this.Get_().(PlaintextOverride_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ)
	return ok
}

type PlaintextOverride_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ struct {
}

func (PlaintextOverride_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ) isPlaintextOverride() {}

func (CompanionStruct_PlaintextOverride_) Create_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ_() PlaintextOverride {
	return PlaintextOverride{PlaintextOverride_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ{}}
}

func (_this PlaintextOverride) Is_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ() bool {
	_, ok := _this.Get_().(PlaintextOverride_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ)
	return ok
}

type PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ struct {
}

func (PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ) isPlaintextOverride() {}

func (CompanionStruct_PlaintextOverride_) Create_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ_() PlaintextOverride {
	return PlaintextOverride{PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ{}}
}

func (_this PlaintextOverride) Is_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ() bool {
	_, ok := _this.Get_().(PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ)
	return ok
}

func (CompanionStruct_PlaintextOverride_) Default() PlaintextOverride {
	return Companion_PlaintextOverride_.Create_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ_()
}

func (_ CompanionStruct_PlaintextOverride_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_PlaintextOverride_.Create_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ_(), true
		case 1:
			return Companion_PlaintextOverride_.Create_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ_(), true
		case 2:
			return Companion_PlaintextOverride_.Create_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ_(), true
		default:
			return PlaintextOverride{}, false
		}
	}
}

func (_this PlaintextOverride) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case PlaintextOverride_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.PlaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ"
		}
	case PlaintextOverride_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.PlaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ"
		}
	case PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.PlaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this PlaintextOverride) Equals(other PlaintextOverride) bool {
	switch _this.Get_().(type) {
	case PlaintextOverride_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ:
		{
			_, ok := other.Get_().(PlaintextOverride_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ)
			return ok
		}
	case PlaintextOverride_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ:
		{
			_, ok := other.Get_().(PlaintextOverride_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ)
			return ok
		}
	case PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ:
		{
			_, ok := other.Get_().(PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this PlaintextOverride) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(PlaintextOverride)
	return ok && _this.Equals(typed)
}

func Type_PlaintextOverride_() _dafny.TypeDescriptor {
	return type_PlaintextOverride_{}
}

type type_PlaintextOverride_ struct {
}

func (_this type_PlaintextOverride_) Default() interface{} {
	return Companion_PlaintextOverride_.Default()
}

func (_this type_PlaintextOverride_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.PlaintextOverride"
}
func (_this PlaintextOverride) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = PlaintextOverride{}

// End of datatype PlaintextOverride

// Definition of class Prefix
type Prefix struct {
}

func New_Prefix_() *Prefix {
	_this := Prefix{}

	return &_this
}

type CompanionStruct_Prefix_ struct {
}

var Companion_Prefix_ = CompanionStruct_Prefix_{}

func (*Prefix) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Prefix"
}

// End of class Prefix

func Type_Prefix_() _dafny.TypeDescriptor {
	return type_Prefix_{}
}

type type_Prefix_ struct {
}

func (_this type_Prefix_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_Prefix_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Prefix"
}
func (_this *CompanionStruct_Prefix_) Is_(__source _dafny.Sequence) bool {
	var _0_x _dafny.Sequence = (__source)
	_ = _0_x
	return Companion_Default___.IsValid__Prefix(_0_x)
}

// Definition of datatype SearchConfig
type SearchConfig struct {
	Data_SearchConfig_
}

func (_this SearchConfig) Get_() Data_SearchConfig_ {
	return _this.Data_SearchConfig_
}

type Data_SearchConfig_ interface {
	isSearchConfig()
}

type CompanionStruct_SearchConfig_ struct {
}

var Companion_SearchConfig_ = CompanionStruct_SearchConfig_{}

type SearchConfig_SearchConfig struct {
	Versions     _dafny.Sequence
	WriteVersion int32
}

func (SearchConfig_SearchConfig) isSearchConfig() {}

func (CompanionStruct_SearchConfig_) Create_SearchConfig_(Versions _dafny.Sequence, WriteVersion int32) SearchConfig {
	return SearchConfig{SearchConfig_SearchConfig{Versions, WriteVersion}}
}

func (_this SearchConfig) Is_SearchConfig() bool {
	_, ok := _this.Get_().(SearchConfig_SearchConfig)
	return ok
}

func (CompanionStruct_SearchConfig_) Default() SearchConfig {
	return Companion_SearchConfig_.Create_SearchConfig_(_dafny.EmptySeq, int32(0))
}

func (_this SearchConfig) Dtor_versions() _dafny.Sequence {
	return _this.Get_().(SearchConfig_SearchConfig).Versions
}

func (_this SearchConfig) Dtor_writeVersion() int32 {
	return _this.Get_().(SearchConfig_SearchConfig).WriteVersion
}

func (_this SearchConfig) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case SearchConfig_SearchConfig:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.SearchConfig.SearchConfig" + "(" + _dafny.String(data.Versions) + ", " + _dafny.String(data.WriteVersion) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this SearchConfig) Equals(other SearchConfig) bool {
	switch data1 := _this.Get_().(type) {
	case SearchConfig_SearchConfig:
		{
			data2, ok := other.Get_().(SearchConfig_SearchConfig)
			return ok && data1.Versions.Equals(data2.Versions) && data1.WriteVersion == data2.WriteVersion
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this SearchConfig) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(SearchConfig)
	return ok && _this.Equals(typed)
}

func Type_SearchConfig_() _dafny.TypeDescriptor {
	return type_SearchConfig_{}
}

type type_SearchConfig_ struct {
}

func (_this type_SearchConfig_) Default() interface{} {
	return Companion_SearchConfig_.Default()
}

func (_this type_SearchConfig_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.SearchConfig"
}
func (_this SearchConfig) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = SearchConfig{}

// End of datatype SearchConfig

// Definition of datatype Shared
type Shared struct {
	Data_Shared_
}

func (_this Shared) Get_() Data_Shared_ {
	return _this.Data_Shared_
}

type Data_Shared_ interface {
	isShared()
}

type CompanionStruct_Shared_ struct {
}

var Companion_Shared_ = CompanionStruct_Shared_{}

type Shared_Shared struct {
	Other _dafny.Sequence
}

func (Shared_Shared) isShared() {}

func (CompanionStruct_Shared_) Create_Shared_(Other _dafny.Sequence) Shared {
	return Shared{Shared_Shared{Other}}
}

func (_this Shared) Is_Shared() bool {
	_, ok := _this.Get_().(Shared_Shared)
	return ok
}

func (CompanionStruct_Shared_) Default() Shared {
	return Companion_Shared_.Create_Shared_(_dafny.EmptySeq.SetString())
}

func (_this Shared) Dtor_other() _dafny.Sequence {
	return _this.Get_().(Shared_Shared).Other
}

func (_this Shared) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Shared_Shared:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Shared.Shared" + "(" + _dafny.String(data.Other) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Shared) Equals(other Shared) bool {
	switch data1 := _this.Get_().(type) {
	case Shared_Shared:
		{
			data2, ok := other.Get_().(Shared_Shared)
			return ok && data1.Other.Equals(data2.Other)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Shared) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Shared)
	return ok && _this.Equals(typed)
}

func Type_Shared_() _dafny.TypeDescriptor {
	return type_Shared_{}
}

type type_Shared_ struct {
}

func (_this type_Shared_) Default() interface{} {
	return Companion_Shared_.Default()
}

func (_this type_Shared_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Shared"
}
func (_this Shared) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Shared{}

// End of datatype Shared

// Definition of datatype SharedSet
type SharedSet struct {
	Data_SharedSet_
}

func (_this SharedSet) Get_() Data_SharedSet_ {
	return _this.Data_SharedSet_
}

type Data_SharedSet_ interface {
	isSharedSet()
}

type CompanionStruct_SharedSet_ struct {
}

var Companion_SharedSet_ = CompanionStruct_SharedSet_{}

type SharedSet_SharedSet struct {
	Other _dafny.Sequence
}

func (SharedSet_SharedSet) isSharedSet() {}

func (CompanionStruct_SharedSet_) Create_SharedSet_(Other _dafny.Sequence) SharedSet {
	return SharedSet{SharedSet_SharedSet{Other}}
}

func (_this SharedSet) Is_SharedSet() bool {
	_, ok := _this.Get_().(SharedSet_SharedSet)
	return ok
}

func (CompanionStruct_SharedSet_) Default() SharedSet {
	return Companion_SharedSet_.Create_SharedSet_(_dafny.EmptySeq.SetString())
}

func (_this SharedSet) Dtor_other() _dafny.Sequence {
	return _this.Get_().(SharedSet_SharedSet).Other
}

func (_this SharedSet) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case SharedSet_SharedSet:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.SharedSet.SharedSet" + "(" + _dafny.String(data.Other) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this SharedSet) Equals(other SharedSet) bool {
	switch data1 := _this.Get_().(type) {
	case SharedSet_SharedSet:
		{
			data2, ok := other.Get_().(SharedSet_SharedSet)
			return ok && data1.Other.Equals(data2.Other)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this SharedSet) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(SharedSet)
	return ok && _this.Equals(typed)
}

func Type_SharedSet_() _dafny.TypeDescriptor {
	return type_SharedSet_{}
}

type type_SharedSet_ struct {
}

func (_this type_SharedSet_) Default() interface{} {
	return Companion_SharedSet_.Default()
}

func (_this type_SharedSet_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.SharedSet"
}
func (_this SharedSet) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = SharedSet{}

// End of datatype SharedSet

// Definition of datatype SignedPart
type SignedPart struct {
	Data_SignedPart_
}

func (_this SignedPart) Get_() Data_SignedPart_ {
	return _this.Data_SignedPart_
}

type Data_SignedPart_ interface {
	isSignedPart()
}

type CompanionStruct_SignedPart_ struct {
}

var Companion_SignedPart_ = CompanionStruct_SignedPart_{}

type SignedPart_SignedPart struct {
	Name   _dafny.Sequence
	Prefix _dafny.Sequence
	Loc    m_Wrappers.Option
}

func (SignedPart_SignedPart) isSignedPart() {}

func (CompanionStruct_SignedPart_) Create_SignedPart_(Name _dafny.Sequence, Prefix _dafny.Sequence, Loc m_Wrappers.Option) SignedPart {
	return SignedPart{SignedPart_SignedPart{Name, Prefix, Loc}}
}

func (_this SignedPart) Is_SignedPart() bool {
	_, ok := _this.Get_().(SignedPart_SignedPart)
	return ok
}

func (CompanionStruct_SignedPart_) Default() SignedPart {
	return Companion_SignedPart_.Create_SignedPart_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default())
}

func (_this SignedPart) Dtor_name() _dafny.Sequence {
	return _this.Get_().(SignedPart_SignedPart).Name
}

func (_this SignedPart) Dtor_prefix() _dafny.Sequence {
	return _this.Get_().(SignedPart_SignedPart).Prefix
}

func (_this SignedPart) Dtor_loc() m_Wrappers.Option {
	return _this.Get_().(SignedPart_SignedPart).Loc
}

func (_this SignedPart) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case SignedPart_SignedPart:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart.SignedPart" + "(" + _dafny.String(data.Name) + ", " + _dafny.String(data.Prefix) + ", " + _dafny.String(data.Loc) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this SignedPart) Equals(other SignedPart) bool {
	switch data1 := _this.Get_().(type) {
	case SignedPart_SignedPart:
		{
			data2, ok := other.Get_().(SignedPart_SignedPart)
			return ok && data1.Name.Equals(data2.Name) && data1.Prefix.Equals(data2.Prefix) && data1.Loc.Equals(data2.Loc)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this SignedPart) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(SignedPart)
	return ok && _this.Equals(typed)
}

func Type_SignedPart_() _dafny.TypeDescriptor {
	return type_SignedPart_{}
}

type type_SignedPart_ struct {
}

func (_this type_SignedPart_) Default() interface{} {
	return Companion_SignedPart_.Default()
}

func (_this type_SignedPart_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart"
}
func (_this SignedPart) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = SignedPart{}

// End of datatype SignedPart

// Definition of class SignedPartsList
type SignedPartsList struct {
}

func New_SignedPartsList_() *SignedPartsList {
	_this := SignedPartsList{}

	return &_this
}

type CompanionStruct_SignedPartsList_ struct {
}

var Companion_SignedPartsList_ = CompanionStruct_SignedPartsList_{}

func (*SignedPartsList) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPartsList"
}

// End of class SignedPartsList

func Type_SignedPartsList_() _dafny.TypeDescriptor {
	return type_SignedPartsList_{}
}

type type_SignedPartsList_ struct {
}

func (_this type_SignedPartsList_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_SignedPartsList_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPartsList"
}
func (_this *CompanionStruct_SignedPartsList_) Is_(__source _dafny.Sequence) bool {
	var _1_x _dafny.Sequence = (__source)
	_ = _1_x
	return Companion_Default___.IsValid__SignedPartsList(_1_x)
}

// Definition of datatype SingleKeyStore
type SingleKeyStore struct {
	Data_SingleKeyStore_
}

func (_this SingleKeyStore) Get_() Data_SingleKeyStore_ {
	return _this.Data_SingleKeyStore_
}

type Data_SingleKeyStore_ interface {
	isSingleKeyStore()
}

type CompanionStruct_SingleKeyStore_ struct {
}

var Companion_SingleKeyStore_ = CompanionStruct_SingleKeyStore_{}

type SingleKeyStore_SingleKeyStore struct {
	KeyId       _dafny.Sequence
	CacheTTL    int32
	Cache       m_Wrappers.Option
	PartitionId m_Wrappers.Option
}

func (SingleKeyStore_SingleKeyStore) isSingleKeyStore() {}

func (CompanionStruct_SingleKeyStore_) Create_SingleKeyStore_(KeyId _dafny.Sequence, CacheTTL int32, Cache m_Wrappers.Option, PartitionId m_Wrappers.Option) SingleKeyStore {
	return SingleKeyStore{SingleKeyStore_SingleKeyStore{KeyId, CacheTTL, Cache, PartitionId}}
}

func (_this SingleKeyStore) Is_SingleKeyStore() bool {
	_, ok := _this.Get_().(SingleKeyStore_SingleKeyStore)
	return ok
}

func (CompanionStruct_SingleKeyStore_) Default() SingleKeyStore {
	return Companion_SingleKeyStore_.Create_SingleKeyStore_(_dafny.EmptySeq.SetString(), int32(0), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this SingleKeyStore) Dtor_keyId() _dafny.Sequence {
	return _this.Get_().(SingleKeyStore_SingleKeyStore).KeyId
}

func (_this SingleKeyStore) Dtor_cacheTTL() int32 {
	return _this.Get_().(SingleKeyStore_SingleKeyStore).CacheTTL
}

func (_this SingleKeyStore) Dtor_cache() m_Wrappers.Option {
	return _this.Get_().(SingleKeyStore_SingleKeyStore).Cache
}

func (_this SingleKeyStore) Dtor_partitionId() m_Wrappers.Option {
	return _this.Get_().(SingleKeyStore_SingleKeyStore).PartitionId
}

func (_this SingleKeyStore) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case SingleKeyStore_SingleKeyStore:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.SingleKeyStore.SingleKeyStore" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.CacheTTL) + ", " + _dafny.String(data.Cache) + ", " + _dafny.String(data.PartitionId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this SingleKeyStore) Equals(other SingleKeyStore) bool {
	switch data1 := _this.Get_().(type) {
	case SingleKeyStore_SingleKeyStore:
		{
			data2, ok := other.Get_().(SingleKeyStore_SingleKeyStore)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.CacheTTL == data2.CacheTTL && data1.Cache.Equals(data2.Cache) && data1.PartitionId.Equals(data2.PartitionId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this SingleKeyStore) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(SingleKeyStore)
	return ok && _this.Equals(typed)
}

func Type_SingleKeyStore_() _dafny.TypeDescriptor {
	return type_SingleKeyStore_{}
}

type type_SingleKeyStore_ struct {
}

func (_this type_SingleKeyStore_) Default() interface{} {
	return Companion_SingleKeyStore_.Default()
}

func (_this type_SingleKeyStore_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.SingleKeyStore"
}
func (_this SingleKeyStore) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = SingleKeyStore{}

// End of datatype SingleKeyStore

// Definition of datatype StandardBeacon
type StandardBeacon struct {
	Data_StandardBeacon_
}

func (_this StandardBeacon) Get_() Data_StandardBeacon_ {
	return _this.Data_StandardBeacon_
}

type Data_StandardBeacon_ interface {
	isStandardBeacon()
}

type CompanionStruct_StandardBeacon_ struct {
}

var Companion_StandardBeacon_ = CompanionStruct_StandardBeacon_{}

type StandardBeacon_StandardBeacon struct {
	Name   _dafny.Sequence
	Length int32
	Loc    m_Wrappers.Option
	Style  m_Wrappers.Option
}

func (StandardBeacon_StandardBeacon) isStandardBeacon() {}

func (CompanionStruct_StandardBeacon_) Create_StandardBeacon_(Name _dafny.Sequence, Length int32, Loc m_Wrappers.Option, Style m_Wrappers.Option) StandardBeacon {
	return StandardBeacon{StandardBeacon_StandardBeacon{Name, Length, Loc, Style}}
}

func (_this StandardBeacon) Is_StandardBeacon() bool {
	_, ok := _this.Get_().(StandardBeacon_StandardBeacon)
	return ok
}

func (CompanionStruct_StandardBeacon_) Default() StandardBeacon {
	return Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.EmptySeq.SetString(), int32(0), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this StandardBeacon) Dtor_name() _dafny.Sequence {
	return _this.Get_().(StandardBeacon_StandardBeacon).Name
}

func (_this StandardBeacon) Dtor_length() int32 {
	return _this.Get_().(StandardBeacon_StandardBeacon).Length
}

func (_this StandardBeacon) Dtor_loc() m_Wrappers.Option {
	return _this.Get_().(StandardBeacon_StandardBeacon).Loc
}

func (_this StandardBeacon) Dtor_style() m_Wrappers.Option {
	return _this.Get_().(StandardBeacon_StandardBeacon).Style
}

func (_this StandardBeacon) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case StandardBeacon_StandardBeacon:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon.StandardBeacon" + "(" + _dafny.String(data.Name) + ", " + _dafny.String(data.Length) + ", " + _dafny.String(data.Loc) + ", " + _dafny.String(data.Style) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this StandardBeacon) Equals(other StandardBeacon) bool {
	switch data1 := _this.Get_().(type) {
	case StandardBeacon_StandardBeacon:
		{
			data2, ok := other.Get_().(StandardBeacon_StandardBeacon)
			return ok && data1.Name.Equals(data2.Name) && data1.Length == data2.Length && data1.Loc.Equals(data2.Loc) && data1.Style.Equals(data2.Style)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this StandardBeacon) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(StandardBeacon)
	return ok && _this.Equals(typed)
}

func Type_StandardBeacon_() _dafny.TypeDescriptor {
	return type_StandardBeacon_{}
}

type type_StandardBeacon_ struct {
}

func (_this type_StandardBeacon_) Default() interface{} {
	return Companion_StandardBeacon_.Default()
}

func (_this type_StandardBeacon_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon"
}
func (_this StandardBeacon) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = StandardBeacon{}

// End of datatype StandardBeacon

// Definition of class StandardBeaconList
type StandardBeaconList struct {
}

func New_StandardBeaconList_() *StandardBeaconList {
	_this := StandardBeaconList{}

	return &_this
}

type CompanionStruct_StandardBeaconList_ struct {
}

var Companion_StandardBeaconList_ = CompanionStruct_StandardBeaconList_{}

func (*StandardBeaconList) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeaconList"
}

// End of class StandardBeaconList

func Type_StandardBeaconList_() _dafny.TypeDescriptor {
	return type_StandardBeaconList_{}
}

type type_StandardBeaconList_ struct {
}

func (_this type_StandardBeaconList_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_StandardBeaconList_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeaconList"
}
func (_this *CompanionStruct_StandardBeaconList_) Is_(__source _dafny.Sequence) bool {
	var _2_x _dafny.Sequence = (__source)
	_ = _2_x
	return Companion_Default___.IsValid__StandardBeaconList(_2_x)
}

// Definition of class TerminalLocation
type TerminalLocation struct {
}

func New_TerminalLocation_() *TerminalLocation {
	_this := TerminalLocation{}

	return &_this
}

type CompanionStruct_TerminalLocation_ struct {
}

var Companion_TerminalLocation_ = CompanionStruct_TerminalLocation_{}

func (*TerminalLocation) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.TerminalLocation"
}

// End of class TerminalLocation

func Type_TerminalLocation_() _dafny.TypeDescriptor {
	return type_TerminalLocation_{}
}

type type_TerminalLocation_ struct {
}

func (_this type_TerminalLocation_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_TerminalLocation_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.TerminalLocation"
}
func (_this *CompanionStruct_TerminalLocation_) Is_(__source _dafny.Sequence) bool {
	var _3_x _dafny.Sequence = (__source)
	_ = _3_x
	return Companion_Default___.IsValid__TerminalLocation(_3_x)
}

// Definition of datatype Upper
type Upper struct {
	Data_Upper_
}

func (_this Upper) Get_() Data_Upper_ {
	return _this.Data_Upper_
}

type Data_Upper_ interface {
	isUpper()
}

type CompanionStruct_Upper_ struct {
}

var Companion_Upper_ = CompanionStruct_Upper_{}

type Upper_Upper struct {
}

func (Upper_Upper) isUpper() {}

func (CompanionStruct_Upper_) Create_Upper_() Upper {
	return Upper{Upper_Upper{}}
}

func (_this Upper) Is_Upper() bool {
	_, ok := _this.Get_().(Upper_Upper)
	return ok
}

func (CompanionStruct_Upper_) Default() Upper {
	return Companion_Upper_.Create_Upper_()
}

func (_ CompanionStruct_Upper_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_Upper_.Create_Upper_(), true
		default:
			return Upper{}, false
		}
	}
}

func (_this Upper) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case Upper_Upper:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Upper.Upper"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Upper) Equals(other Upper) bool {
	switch _this.Get_().(type) {
	case Upper_Upper:
		{
			_, ok := other.Get_().(Upper_Upper)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Upper) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Upper)
	return ok && _this.Equals(typed)
}

func Type_Upper_() _dafny.TypeDescriptor {
	return type_Upper_{}
}

type type_Upper_ struct {
}

func (_this type_Upper_) Default() interface{} {
	return Companion_Upper_.Default()
}

func (_this type_Upper_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Upper"
}
func (_this Upper) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Upper{}

// End of datatype Upper

// Definition of class VersionNumber
type VersionNumber struct {
}

func New_VersionNumber_() *VersionNumber {
	_this := VersionNumber{}

	return &_this
}

type CompanionStruct_VersionNumber_ struct {
}

var Companion_VersionNumber_ = CompanionStruct_VersionNumber_{}

func (*VersionNumber) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VersionNumber"
}

// End of class VersionNumber

func Type_VersionNumber_() _dafny.TypeDescriptor {
	return type_VersionNumber_{}
}

type type_VersionNumber_ struct {
}

func (_this type_VersionNumber_) Default() interface{} {
	return int32(0)
}

func (_this type_VersionNumber_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VersionNumber"
}
func (_this *CompanionStruct_VersionNumber_) Is_(__source int32) bool {
	var _4_x int32 = (__source)
	_ = _4_x
	if true {
		return Companion_Default___.IsValid__VersionNumber(_4_x)
	}
	return false
}

// Definition of datatype VirtualField
type VirtualField struct {
	Data_VirtualField_
}

func (_this VirtualField) Get_() Data_VirtualField_ {
	return _this.Data_VirtualField_
}

type Data_VirtualField_ interface {
	isVirtualField()
}

type CompanionStruct_VirtualField_ struct {
}

var Companion_VirtualField_ = CompanionStruct_VirtualField_{}

type VirtualField_VirtualField struct {
	Name  _dafny.Sequence
	Parts _dafny.Sequence
}

func (VirtualField_VirtualField) isVirtualField() {}

func (CompanionStruct_VirtualField_) Create_VirtualField_(Name _dafny.Sequence, Parts _dafny.Sequence) VirtualField {
	return VirtualField{VirtualField_VirtualField{Name, Parts}}
}

func (_this VirtualField) Is_VirtualField() bool {
	_, ok := _this.Get_().(VirtualField_VirtualField)
	return ok
}

func (CompanionStruct_VirtualField_) Default() VirtualField {
	return Companion_VirtualField_.Create_VirtualField_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq)
}

func (_this VirtualField) Dtor_name() _dafny.Sequence {
	return _this.Get_().(VirtualField_VirtualField).Name
}

func (_this VirtualField) Dtor_parts() _dafny.Sequence {
	return _this.Get_().(VirtualField_VirtualField).Parts
}

func (_this VirtualField) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case VirtualField_VirtualField:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualField.VirtualField" + "(" + _dafny.String(data.Name) + ", " + _dafny.String(data.Parts) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this VirtualField) Equals(other VirtualField) bool {
	switch data1 := _this.Get_().(type) {
	case VirtualField_VirtualField:
		{
			data2, ok := other.Get_().(VirtualField_VirtualField)
			return ok && data1.Name.Equals(data2.Name) && data1.Parts.Equals(data2.Parts)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this VirtualField) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(VirtualField)
	return ok && _this.Equals(typed)
}

func Type_VirtualField_() _dafny.TypeDescriptor {
	return type_VirtualField_{}
}

type type_VirtualField_ struct {
}

func (_this type_VirtualField_) Default() interface{} {
	return Companion_VirtualField_.Default()
}

func (_this type_VirtualField_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualField"
}
func (_this VirtualField) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = VirtualField{}

// End of datatype VirtualField

// Definition of class VirtualFieldList
type VirtualFieldList struct {
}

func New_VirtualFieldList_() *VirtualFieldList {
	_this := VirtualFieldList{}

	return &_this
}

type CompanionStruct_VirtualFieldList_ struct {
}

var Companion_VirtualFieldList_ = CompanionStruct_VirtualFieldList_{}

func (*VirtualFieldList) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualFieldList"
}

// End of class VirtualFieldList

func Type_VirtualFieldList_() _dafny.TypeDescriptor {
	return type_VirtualFieldList_{}
}

type type_VirtualFieldList_ struct {
}

func (_this type_VirtualFieldList_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_VirtualFieldList_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualFieldList"
}
func (_this *CompanionStruct_VirtualFieldList_) Is_(__source _dafny.Sequence) bool {
	var _5_x _dafny.Sequence = (__source)
	_ = _5_x
	return Companion_Default___.IsValid__VirtualFieldList(_5_x)
}

// Definition of datatype VirtualPart
type VirtualPart struct {
	Data_VirtualPart_
}

func (_this VirtualPart) Get_() Data_VirtualPart_ {
	return _this.Data_VirtualPart_
}

type Data_VirtualPart_ interface {
	isVirtualPart()
}

type CompanionStruct_VirtualPart_ struct {
}

var Companion_VirtualPart_ = CompanionStruct_VirtualPart_{}

type VirtualPart_VirtualPart struct {
	Loc   _dafny.Sequence
	Trans m_Wrappers.Option
}

func (VirtualPart_VirtualPart) isVirtualPart() {}

func (CompanionStruct_VirtualPart_) Create_VirtualPart_(Loc _dafny.Sequence, Trans m_Wrappers.Option) VirtualPart {
	return VirtualPart{VirtualPart_VirtualPart{Loc, Trans}}
}

func (_this VirtualPart) Is_VirtualPart() bool {
	_, ok := _this.Get_().(VirtualPart_VirtualPart)
	return ok
}

func (CompanionStruct_VirtualPart_) Default() VirtualPart {
	return Companion_VirtualPart_.Create_VirtualPart_(_dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default())
}

func (_this VirtualPart) Dtor_loc() _dafny.Sequence {
	return _this.Get_().(VirtualPart_VirtualPart).Loc
}

func (_this VirtualPart) Dtor_trans() m_Wrappers.Option {
	return _this.Get_().(VirtualPart_VirtualPart).Trans
}

func (_this VirtualPart) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case VirtualPart_VirtualPart:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualPart.VirtualPart" + "(" + _dafny.String(data.Loc) + ", " + _dafny.String(data.Trans) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this VirtualPart) Equals(other VirtualPart) bool {
	switch data1 := _this.Get_().(type) {
	case VirtualPart_VirtualPart:
		{
			data2, ok := other.Get_().(VirtualPart_VirtualPart)
			return ok && data1.Loc.Equals(data2.Loc) && data1.Trans.Equals(data2.Trans)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this VirtualPart) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(VirtualPart)
	return ok && _this.Equals(typed)
}

func Type_VirtualPart_() _dafny.TypeDescriptor {
	return type_VirtualPart_{}
}

type type_VirtualPart_ struct {
}

func (_this type_VirtualPart_) Default() interface{} {
	return Companion_VirtualPart_.Default()
}

func (_this type_VirtualPart_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualPart"
}
func (_this VirtualPart) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = VirtualPart{}

// End of datatype VirtualPart

// Definition of class VirtualPartList
type VirtualPartList struct {
}

func New_VirtualPartList_() *VirtualPartList {
	_this := VirtualPartList{}

	return &_this
}

type CompanionStruct_VirtualPartList_ struct {
}

var Companion_VirtualPartList_ = CompanionStruct_VirtualPartList_{}

func (*VirtualPartList) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualPartList"
}

// End of class VirtualPartList

func Type_VirtualPartList_() _dafny.TypeDescriptor {
	return type_VirtualPartList_{}
}

type type_VirtualPartList_ struct {
}

func (_this type_VirtualPartList_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_VirtualPartList_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualPartList"
}
func (_this *CompanionStruct_VirtualPartList_) Is_(__source _dafny.Sequence) bool {
	var _6_x _dafny.Sequence = (__source)
	_ = _6_x
	return Companion_Default___.IsValid__VirtualPartList(_6_x)
}

// Definition of datatype VirtualTransform
type VirtualTransform struct {
	Data_VirtualTransform_
}

func (_this VirtualTransform) Get_() Data_VirtualTransform_ {
	return _this.Data_VirtualTransform_
}

type Data_VirtualTransform_ interface {
	isVirtualTransform()
}

type CompanionStruct_VirtualTransform_ struct {
}

var Companion_VirtualTransform_ = CompanionStruct_VirtualTransform_{}

type VirtualTransform_upper struct {
	Upper Upper
}

func (VirtualTransform_upper) isVirtualTransform() {}

func (CompanionStruct_VirtualTransform_) Create_upper_(Upper Upper) VirtualTransform {
	return VirtualTransform{VirtualTransform_upper{Upper}}
}

func (_this VirtualTransform) Is_upper() bool {
	_, ok := _this.Get_().(VirtualTransform_upper)
	return ok
}

type VirtualTransform_lower struct {
	Lower Lower
}

func (VirtualTransform_lower) isVirtualTransform() {}

func (CompanionStruct_VirtualTransform_) Create_lower_(Lower Lower) VirtualTransform {
	return VirtualTransform{VirtualTransform_lower{Lower}}
}

func (_this VirtualTransform) Is_lower() bool {
	_, ok := _this.Get_().(VirtualTransform_lower)
	return ok
}

type VirtualTransform_insert struct {
	Insert Insert
}

func (VirtualTransform_insert) isVirtualTransform() {}

func (CompanionStruct_VirtualTransform_) Create_insert_(Insert Insert) VirtualTransform {
	return VirtualTransform{VirtualTransform_insert{Insert}}
}

func (_this VirtualTransform) Is_insert() bool {
	_, ok := _this.Get_().(VirtualTransform_insert)
	return ok
}

type VirtualTransform_prefix struct {
	Prefix GetPrefix
}

func (VirtualTransform_prefix) isVirtualTransform() {}

func (CompanionStruct_VirtualTransform_) Create_prefix_(Prefix GetPrefix) VirtualTransform {
	return VirtualTransform{VirtualTransform_prefix{Prefix}}
}

func (_this VirtualTransform) Is_prefix() bool {
	_, ok := _this.Get_().(VirtualTransform_prefix)
	return ok
}

type VirtualTransform_suffix struct {
	Suffix GetSuffix
}

func (VirtualTransform_suffix) isVirtualTransform() {}

func (CompanionStruct_VirtualTransform_) Create_suffix_(Suffix GetSuffix) VirtualTransform {
	return VirtualTransform{VirtualTransform_suffix{Suffix}}
}

func (_this VirtualTransform) Is_suffix() bool {
	_, ok := _this.Get_().(VirtualTransform_suffix)
	return ok
}

type VirtualTransform_substring struct {
	Substring GetSubstring
}

func (VirtualTransform_substring) isVirtualTransform() {}

func (CompanionStruct_VirtualTransform_) Create_substring_(Substring GetSubstring) VirtualTransform {
	return VirtualTransform{VirtualTransform_substring{Substring}}
}

func (_this VirtualTransform) Is_substring() bool {
	_, ok := _this.Get_().(VirtualTransform_substring)
	return ok
}

type VirtualTransform_segment struct {
	Segment GetSegment
}

func (VirtualTransform_segment) isVirtualTransform() {}

func (CompanionStruct_VirtualTransform_) Create_segment_(Segment GetSegment) VirtualTransform {
	return VirtualTransform{VirtualTransform_segment{Segment}}
}

func (_this VirtualTransform) Is_segment() bool {
	_, ok := _this.Get_().(VirtualTransform_segment)
	return ok
}

type VirtualTransform_segments struct {
	Segments GetSegments
}

func (VirtualTransform_segments) isVirtualTransform() {}

func (CompanionStruct_VirtualTransform_) Create_segments_(Segments GetSegments) VirtualTransform {
	return VirtualTransform{VirtualTransform_segments{Segments}}
}

func (_this VirtualTransform) Is_segments() bool {
	_, ok := _this.Get_().(VirtualTransform_segments)
	return ok
}

func (CompanionStruct_VirtualTransform_) Default() VirtualTransform {
	return Companion_VirtualTransform_.Create_upper_(Companion_Upper_.Default())
}

func (_this VirtualTransform) Dtor_upper() Upper {
	return _this.Get_().(VirtualTransform_upper).Upper
}

func (_this VirtualTransform) Dtor_lower() Lower {
	return _this.Get_().(VirtualTransform_lower).Lower
}

func (_this VirtualTransform) Dtor_insert() Insert {
	return _this.Get_().(VirtualTransform_insert).Insert
}

func (_this VirtualTransform) Dtor_prefix() GetPrefix {
	return _this.Get_().(VirtualTransform_prefix).Prefix
}

func (_this VirtualTransform) Dtor_suffix() GetSuffix {
	return _this.Get_().(VirtualTransform_suffix).Suffix
}

func (_this VirtualTransform) Dtor_substring() GetSubstring {
	return _this.Get_().(VirtualTransform_substring).Substring
}

func (_this VirtualTransform) Dtor_segment() GetSegment {
	return _this.Get_().(VirtualTransform_segment).Segment
}

func (_this VirtualTransform) Dtor_segments() GetSegments {
	return _this.Get_().(VirtualTransform_segments).Segments
}

func (_this VirtualTransform) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case VirtualTransform_upper:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform.upper" + "(" + _dafny.String(data.Upper) + ")"
		}
	case VirtualTransform_lower:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform.lower" + "(" + _dafny.String(data.Lower) + ")"
		}
	case VirtualTransform_insert:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform.insert" + "(" + _dafny.String(data.Insert) + ")"
		}
	case VirtualTransform_prefix:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform.prefix" + "(" + _dafny.String(data.Prefix) + ")"
		}
	case VirtualTransform_suffix:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform.suffix" + "(" + _dafny.String(data.Suffix) + ")"
		}
	case VirtualTransform_substring:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform.substring" + "(" + _dafny.String(data.Substring) + ")"
		}
	case VirtualTransform_segment:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform.segment" + "(" + _dafny.String(data.Segment) + ")"
		}
	case VirtualTransform_segments:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform.segments" + "(" + _dafny.String(data.Segments) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this VirtualTransform) Equals(other VirtualTransform) bool {
	switch data1 := _this.Get_().(type) {
	case VirtualTransform_upper:
		{
			data2, ok := other.Get_().(VirtualTransform_upper)
			return ok && data1.Upper.Equals(data2.Upper)
		}
	case VirtualTransform_lower:
		{
			data2, ok := other.Get_().(VirtualTransform_lower)
			return ok && data1.Lower.Equals(data2.Lower)
		}
	case VirtualTransform_insert:
		{
			data2, ok := other.Get_().(VirtualTransform_insert)
			return ok && data1.Insert.Equals(data2.Insert)
		}
	case VirtualTransform_prefix:
		{
			data2, ok := other.Get_().(VirtualTransform_prefix)
			return ok && data1.Prefix.Equals(data2.Prefix)
		}
	case VirtualTransform_suffix:
		{
			data2, ok := other.Get_().(VirtualTransform_suffix)
			return ok && data1.Suffix.Equals(data2.Suffix)
		}
	case VirtualTransform_substring:
		{
			data2, ok := other.Get_().(VirtualTransform_substring)
			return ok && data1.Substring.Equals(data2.Substring)
		}
	case VirtualTransform_segment:
		{
			data2, ok := other.Get_().(VirtualTransform_segment)
			return ok && data1.Segment.Equals(data2.Segment)
		}
	case VirtualTransform_segments:
		{
			data2, ok := other.Get_().(VirtualTransform_segments)
			return ok && data1.Segments.Equals(data2.Segments)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this VirtualTransform) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(VirtualTransform)
	return ok && _this.Equals(typed)
}

func Type_VirtualTransform_() _dafny.TypeDescriptor {
	return type_VirtualTransform_{}
}

type type_VirtualTransform_ struct {
}

func (_this type_VirtualTransform_) Default() interface{} {
	return Companion_VirtualTransform_.Default()
}

func (_this type_VirtualTransform_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform"
}
func (_this VirtualTransform) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = VirtualTransform{}

// End of datatype VirtualTransform

// Definition of class VirtualTransformList
type VirtualTransformList struct {
}

func New_VirtualTransformList_() *VirtualTransformList {
	_this := VirtualTransformList{}

	return &_this
}

type CompanionStruct_VirtualTransformList_ struct {
}

var Companion_VirtualTransformList_ = CompanionStruct_VirtualTransformList_{}

func (*VirtualTransformList) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransformList"
}

// End of class VirtualTransformList

func Type_VirtualTransformList_() _dafny.TypeDescriptor {
	return type_VirtualTransformList_{}
}

type type_VirtualTransformList_ struct {
}

func (_this type_VirtualTransformList_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_VirtualTransformList_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransformList"
}
func (_this *CompanionStruct_VirtualTransformList_) Is_(__source _dafny.Sequence) bool {
	var _7_x _dafny.Sequence = (__source)
	_ = _7_x
	return Companion_Default___.IsValid__VirtualTransformList(_7_x)
}

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

type Error_DynamoDbEncryptionException struct {
	Message _dafny.Sequence
}

func (Error_DynamoDbEncryptionException) isError() {}

func (CompanionStruct_Error_) Create_DynamoDbEncryptionException_(Message _dafny.Sequence) Error {
	return Error{Error_DynamoDbEncryptionException{Message}}
}

func (_this Error) Is_DynamoDbEncryptionException() bool {
	_, ok := _this.Get_().(Error_DynamoDbEncryptionException)
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
	return Companion_Error_.Create_DynamoDbEncryptionException_(_dafny.EmptySeq.SetString())
}

func (_this Error) Dtor_message() _dafny.Sequence {
	switch data := _this.Get_().(type) {
	case Error_DynamoDbEncryptionException:
		return data.Message
	default:
		return data.(Error_CollectionOfErrors).Message
	}
}

func (_this Error) Dtor_AwsCryptographyDbEncryptionSdkStructuredEncryption() m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
	return _this.Get_().(Error_AwsCryptographyDbEncryptionSdkStructuredEncryption).AwsCryptographyDbEncryptionSdkStructuredEncryption
}

func (_this Error) Dtor_AwsCryptographyMaterialProviders() m_AwsCryptographyMaterialProvidersTypes.Error {
	return _this.Get_().(Error_AwsCryptographyMaterialProviders).AwsCryptographyMaterialProviders
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
	case Error_DynamoDbEncryptionException:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error.DynamoDbEncryptionException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_AwsCryptographyDbEncryptionSdkStructuredEncryption:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error.AwsCryptographyDbEncryptionSdkStructuredEncryption" + "(" + _dafny.String(data.AwsCryptographyDbEncryptionSdkStructuredEncryption) + ")"
		}
	case Error_AwsCryptographyMaterialProviders:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error.AwsCryptographyMaterialProviders" + "(" + _dafny.String(data.AwsCryptographyMaterialProviders) + ")"
		}
	case Error_AwsCryptographyKeyStore:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error.AwsCryptographyKeyStore" + "(" + _dafny.String(data.AwsCryptographyKeyStore) + ")"
		}
	case Error_AwsCryptographyPrimitives:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error.AwsCryptographyPrimitives" + "(" + _dafny.String(data.AwsCryptographyPrimitives) + ")"
		}
	case Error_ComAmazonawsDynamodb:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error.ComAmazonawsDynamodb" + "(" + _dafny.String(data.ComAmazonawsDynamodb) + ")"
		}
	case Error_CollectionOfErrors:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error.CollectionOfErrors" + "(" + _dafny.String(data.List) + ", " + _dafny.String(data.Message) + ")"
		}
	case Error_Opaque:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error.Opaque" + "(" + _dafny.String(data.Obj) + ")"
		}
	case Error_OpaqueWithText:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error.OpaqueWithText" + "(" + _dafny.String(data.Obj) + ", " + _dafny.String(data.ObjMessage) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Error) Equals(other Error) bool {
	switch data1 := _this.Get_().(type) {
	case Error_DynamoDbEncryptionException:
		{
			data2, ok := other.Get_().(Error_DynamoDbEncryptionException)
			return ok && data1.Message.Equals(data2.Message)
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
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error"
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
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.OpaqueError"
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
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.OpaqueError"
}
func (_this *CompanionStruct_OpaqueError_) Is_(__source Error) bool {
	var _8_e Error = (__source)
	_ = _8_e
	return ((_8_e).Is_Opaque()) || ((_8_e).Is_OpaqueWithText())
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
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.DummySubsetType"
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
	return "AwsCryptographyDbEncryptionSdkDynamoDbTypes.DummySubsetType"
}
func (_this *CompanionStruct_DummySubsetType_) Is_(__source _dafny.Int) bool {
	var _9_x _dafny.Int = (__source)
	_ = _9_x
	return Companion_Default___.IsDummySubsetType(_9_x)
}
